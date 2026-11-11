# AtlasTrip — Gestão de Viagens (Portfólio)

Aplicação demonstrativa **independente e fictícia** para explorar destinos, consultar saídas e filtrar pacotes por mês. Projeto desenvolvido para portfólio, com **Next.js + TypeScript** no frontend e **Java + Spring Boot + API REST + JPA** no backend. Nenhuma reserva ou pagamento real é realizado.

## Telas e recursos
- Página inicial com catálogo de destinos e resumo do projeto
- Listagem de pacotes e datas de saída com filtros por destino e mês
- Página de detalhes com roteiro diário e valores demonstrativos
- API REST de consulta com filtros
- Persistência em H2 (modo padrão) ou MySQL (perfil opcional)
- Layout responsivo e dados de demonstração inicializados automaticamente

## Executar localmente

**Requisitos:** Java 21+, Maven 3.9+, Node.js 20+.

Terminal 1 — backend:
```bash
cd backend
mvn spring-boot:run
```
API: http://localhost:8080/api/viagens

Terminal 2 — frontend:
```bash
cd frontend
npm install
npm run dev
```
Site: http://localhost:3000

O frontend usa a API em `http://localhost:8080` por padrão. Se ela estiver indisponível, exibe **dados locais demonstrativos** e um aviso visível; o frontend pode, portanto, ser apresentado sozinho em um deploy estático/dinâmico.

### MySQL opcional
Crie um banco `atlastrip` e configure variáveis de ambiente (nunca commitá-las):
```
DB_URL=jdbc:mysql://localhost:3306/atlastrip?createDatabaseIfNotExist=true
DB_USER=seu_usuario
DB_PASSWORD=sua_senha
```
Então execute `mvn spring-boot:run -Dspring-boot.run.profiles=mysql` dentro de `backend`.

### Endpoints
- `GET /api/destinos`
- `GET /api/viagens` — filtros opcionais `destino` (slug) e `mes` (`AAAA-MM`)
- `GET /api/viagens/{id}`
- `GET /api/health`

Exemplo: `http://localhost:8080/api/viagens?destino=japao&mes=2027-04`

## Estrutura
```
frontend/     Next.js App Router, TypeScript e CSS
backend/      Java 21, Spring Boot, JPA, H2 e MySQL opcional
```

## Segurança e privacidade
- Projeto **novo e independente**, com marca fictícia AtlasTrip.
- Não usa contas reais, tokens, webhooks, credenciais de empresa, imagens de terceiros nem URLs privadas.
- Sem autenticação ou operações financeiras: esta API é apenas um catálogo público de demonstração.
- Arquivos `.env` e artefatos de compilação ignorados pelo Git.
- As imagens de destino são ilustrações abstratas feitas em CSS; nenhum material visual da empresa original foi reutilizado.

## Sugestões de mídia para LinkedIn
1. Página inicial com cartões de destinos.
2. Catálogo de saídas com filtro por mês.
3. Página de detalhes e roteiro dia a dia.
4. Captura de `GET /api/viagens` no navegador ou Insomnia.

**Descrição sugerida:** Aplicativo web demonstrativo para consulta e organização de viagens, com catálogo de destinos, saídas, filtros e roteiros detalhados. Frontend em Next.js/TypeScript e backend em Java/Spring Boot com API REST e persistência em banco relacional.

**Competências:** Java, Spring Boot, API REST, MySQL, JPA, SQL, Next.js, TypeScript, Git e GitHub.

> Valores, datas, destinos, itinerários e nomes são fictícios. Não há serviços turísticos comercializados.


## Fotografias dos destinos

A interface utiliza imagens ilustrativas públicas carregadas por URLs do Unsplash CDN em `frontend/src/app/globals.css`. Elas exigem conexão à internet; os arquivos de imagem **não** estão incluídos no repositório. Antes de uma publicação comercial, verifique a licença, a disponibilidade e os créditos de cada imagem, ou substitua por imagens próprias com autorização. Caso alguma URL não carregue, troque-a no bloco `--photo-*` do CSS.

## Publicação segura

Este é um projeto novo, independente, com dados fictícios. Não copie `.git`, arquivos de ambiente, imagens privadas ou código do sistema original para este repositório. Para publicar, crie um repositório Git novo na raiz deste projeto.
