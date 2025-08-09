# Sistema de Cadastro de Pessoas

Sistema completo de cadastro de pessoas com backend Java Spring Boot e frontend Angular, seguindo princípios SOLID e arquitetura limpa.

## 🚀 Tecnologias Utilizadas

### Backend
- **Java 17**
- **Spring Boot 3.2.x**
- **Spring Security** (Autenticação Básica)
- **Spring Data JPA** (Persistência)
- **H2 Database** (Banco de dados em memória)
- **Swagger/OpenAPI 3.0** (Documentação da API)
- **Docker** (Containerização)

### Frontend
- **Angular 17**
- **TypeScript**
- **Bootstrap 5** (Estilização)
- **Reactive Forms** (Formulários)
- **RxJS** (Programação reativa)

## 📋 Pré-requisitos

### Backend
- Java 17 ou superior
- Maven 3.8 ou superior
- Docker (opcional)

### Frontend
- Node.js 18 ou superior
- npm ou yarn
- Angular CLI

## 🔧 Configuração e Execução

### Opção 1: Docker (Recomendado)

1. **Clone o repositório:**
```bash
git clone [URL_DO_REPOSITORIO]
cd person-registration-system
```

2. **Execute com Docker Compose:**
```bash
docker-compose up --build
```

3. **Acesse a aplicação:**
- Frontend: http://localhost:4200
- Backend API: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- H2 Console: http://localhost:8080/h2-console

### Opção 2: Execução Manual

#### Backend (Java Spring Boot)

1. **Navegue para o diretório do backend:**
```bash
cd person-registration-system
```

2. **Compile e execute:**
```bash
mvn clean install
mvn spring-boot:run
```

3. **Acesse o backend:**
- API: http://localhost:8080
- Swagger: http://localhost:8080/swagger-ui.html
- Credenciais H2:
  - JDBC URL: jdbc:h2:mem:testdb
  - Username: sa
  - Password: password

#### Frontend (Angular)

1. **Navegue para o diretório do frontend:**
```bash
cd person-registration-system/frontend
```

2. **Instale as dependências:**
```bash
npm install
```

3. **Execute o servidor de desenvolvimento:**
```bash
ng serve
```

4. **Acesse o frontend:**
- http://localhost:4200

## 🔐 Credenciais de Acesso

### Autenticação Básica
- **Usuário:** admin
- **Senha:** admin123

## 📊 Endpoints da API

### API v1 - Pessoas
- `GET /api/v1/persons` - Listar todas as pessoas
- `GET /api/v1/persons/{id}` - Buscar pessoa por ID
- `POST /api/v1/persons` - Criar nova pessoa
- `PUT /api/v1/persons/{id}` - Atualizar pessoa
- `DELETE /api/v1/persons/{id}` - Excluir pessoa

### API v2 - Pessoas com Endereço
- `GET /api/v2/persons` - Listar pessoas com endereço
- `GET /api/v2/persons/{id}` - Buscar pessoa com endereço
- `POST /api/v2/persons` - Criar pessoa com endereço
- `PUT /api/v2/persons/{id}` - Atualizar pessoa com endereço
- `DELETE /api/v2/persons/{id}` - Excluir pessoa com endereço

### Endpoints Adicionais
- `GET /source` - Link do código fonte (sem autenticação)
- `GET /swagger-ui.html` - Documentação da API

## 🎯 Funcionalidades

### Backend
- ✅ CRUD completo de pessoas
- ✅ Validação de CPF (formato e duplicidade)
- ✅ Validação de email
- ✅ Validação de data de nascimento
- ✅ Armazenamento de data de criação/atualização
- ✅ API versionada (v1 e v2)
- ✅ Endereço obrigatório na v2
- ✅ Documentação Swagger
- ✅ Autenticação básica
- ✅ Tratamento de exceções

### Frontend
- ✅ Formulário reativo de cadastro
- ✅ Validações em tempo real
- ✅ Listagem com paginação
- ✅ Edição e exclusão de registros
- ✅ Design responsivo
- ✅ Loading states
- ✅ Tratamento de erros
- ✅ Autenticação integrada

## 🏗️ Estrutura do Projeto

```
person-registration-system/
├── backend/
│   ├── src/main/java/com/personregistration/
│   │   ├── api/           # Controllers
│   │   ├── domain/        # Entidades e repositórios
│   │   ├── application/   # Serviços e DTOs
│   │   └── infrastructure/ # Configurações
├── frontend/
│   ├── src/app/
│   │   ├── components/    # Componentes Angular
│   │   ├── services/      # Serviços
│   │   ├── models/        # Interfaces TypeScript
│   │   └── core/          # Módulos core
├── docker-compose.yml
├── Dockerfile
└── README.md
```

## 🧪 Testes

### Backend
```bash
mvn test
```

### Frontend
```bash
cd frontend
ng test
ng e2e
```

## 🐳 Docker

### Construir imagem
```bash
# Backend
docker build -t person-registration-backend .

# Frontend
cd frontend
docker build -t person-registration-frontend .
```

### Executar com Docker
```bash
# Backend apenas
docker run -p 8080:8080 person-registration-backend

# Frontend apenas
docker run -p 4200:4200 person-registration-frontend
```

## 📦 Build para Produção

### Backend
```bash
mvn clean package
java -jar target/person-registration-0.0.1-SNAPSHOT.jar
```

### Frontend
```bash
cd frontend
ng build --configuration production
```

## 🔍 Solução de Problemas

### Backend não inicia
1. Verifique se a porta 8080 está disponível
2. Confirme Java 17 instalado: `java -version`
3. Verifique variáveis de ambiente JAVA_HOME

### Frontend não carrega
1. Verifique se a porta 4200 está disponível
2. Confirme Node.js 18+: `node --version`
3. Delete node_modules e reinstale: `rm -rf node_modules && npm install`

### Erros de CORS
- O backend já está configurado para aceitar requisições do frontend
- Verifique se as URLs estão corretas no environment.ts


