#!/bin/bash
set -e

# Garante que não estamos com nada pendente
if [[ -n $(git status -s) ]]; then
  echo "❌ Erro: Seu repositório tem arquivos não commitados. Faça o commit de tudo antes da release."
  exit 1
fi

echo "🔍 Analisando histórico do Git para descobrir a próxima versão..."
# Pega a nova versão sugerida baseada nos Conventional Commits (ex: 1.0.1)
NEXT_VERSION=$(npx --yes git-cliff --bumped-version | sed 's/v//g')

echo "🚀 Iniciando processo de Release Local: v$NEXT_VERSION"

# 1. Atualiza a versão do projeto no Maven (pom.xml)
echo "📦 1/3 Atualizando pom.xml..."
./mvnw versions:set -DnewVersion=$NEXT_VERSION -DgenerateBackupPoms=false -q

# 2. Gera o CHANGELOG atualizado automaticamente
echo "📝 2/3 Gerando CHANGELOG.md via git-cliff..."
npx --yes git-cliff --bump -o CHANGELOG.md

# 3. Comita os arquivos de versão e cria a TAG
echo "🏷️  3/3 Criando commit de release e TAG no Git..."
git add pom.xml CHANGELOG.md
git commit -m "chore: release da versao $NEXT_VERSION"
git tag -a "v$NEXT_VERSION" -m "Release v$NEXT_VERSION"

echo "=========================================================="
echo "✅ Release v$NEXT_VERSION localmente concluída com sucesso!"
echo "👉 Para enviar tudo para o GitHub e acionar a publicação, execute:"
echo "   git push origin main && git push origin v$NEXT_VERSION"
