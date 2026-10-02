const fs = require('fs');
const { execSync } = require('child_process');

// 1. Gera o JSON de todos os commits/releases
const contextRaw = execSync("npx --yes git-cliff --context", { encoding: 'utf-8' });
const context = JSON.parse(contextRaw);

// O context é uma array de releases, a primeira é a mais nova.
let md = `# Changelog\n\n`;
md += `Todos os marcos e mudanças notáveis neste projeto serão documentados neste arquivo.\n`;
md += `O formato baseia-se no [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/) e é gerado dinamicamente.\n\n`;

context.forEach((release, index) => {
    if (!release.version) return;
    const vName = release.version.replace('v', '');
    const date = new Date(release.timestamp * 1000).toISOString().split('T')[0];
    
    if (index === 0) {
        // Tag mais recente (Rica em detalhes)
        md += `## [${vName}](https://github.com/carloskvasir/api_rest_spring/releases/tag/${release.version}) - ${date}\n`;
        
        // Agrupa commits por "group"
        const groups = {};
        release.commits.forEach(commit => {
            if (!groups[commit.group]) groups[commit.group] = [];
            groups[commit.group].push(commit.message);
        });
        
        Object.keys(groups).forEach(g => {
            md += `### ${g}\n`;
            groups[g].forEach(msg => {
                md += `- ${msg}\n`;
            });
        });
        md += `\n`;
    } else {
        // Tags antigas (Apenas título e link)
        md += `## [${vName}](https://github.com/carloskvasir/api_rest_spring/releases/tag/${release.version}) - ${date}\n`;
        md += `> *(Consulte a tag acima para ver as notas completas)*\n\n`;
    }
});

fs.writeFileSync('CHANGELOG.md', md);
console.log("CHANGELOG.md gerado com sucesso pelo formato híbrido.");
