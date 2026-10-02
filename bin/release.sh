#!/bin/bash
set -e

if [[ -n $(git status -s) ]]; then
  echo "❌ Erro: Seu repositório tem arquivos não commitados."
  exit 1
fi

NEXT_VERSION=$(npx --yes git-cliff --bumped-version | sed 's/v//g')
echo "🚀 Iniciando processo de Release: v$NEXT_VERSION"

echo "📦 1/4 Atualizando pom.xml..."
./mvnw versions:set -DnewVersion=$NEXT_VERSION -DgenerateBackupPoms=false -q

echo "📝 2/4 Gerando CHANGELOG.md via git-cliff..."
npx --yes git-cliff --bump -o CHANGELOG.md

echo "🏷️  3/4 Criando commit e TAG no Git..."
git add pom.xml CHANGELOG.md
git commit -m "chore: release da versao $NEXT_VERSION"
git tag -a "v$NEXT_VERSION" -m "Release v$NEXT_VERSION"

echo "☁️  4/4 Publicando no GitHub..."
git push origin main
git push origin v$NEXT_VERSION

# Extrai as notas exatas da release recém-gerada
npx --yes git-cliff --latest --strip header > .github_release_notes.md
echo -e "\n---\n📖 **Histórico Completo:** Acesse nosso [CHANGELOG.md](https://github.com/carloskvasir/api_rest_spring/blob/main/CHANGELOG.md)." >> .github_release_notes.md

gh release create v$NEXT_VERSION -t "Release v$NEXT_VERSION" -F .github_release_notes.md
rm .github_release_notes.md

echo "=========================================================="
echo "✅ Release v$NEXT_VERSION publicada com sucesso no GitHub!"
