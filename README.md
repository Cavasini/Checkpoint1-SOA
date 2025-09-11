# 🚘 Autoescola API  

Projeto desenvolvido para o **Checkpoint 1** da disciplina:  
**Engenharia de Software (Noturno) - Paulista**  
**Curso:** 3ESPV-2025  
**Matéria:** Arquitetura Orientada a Serviços (SOA) e Web Services  

---

## 👥 Integrantes do Grupo
- Julia Amorim - RM99609
- Lana Leite - RM551143
- Lucas Speranzini - RM98297
- Matheus Cavasini - RM97722
  
---

## 📌 Exemplo de RequestBody para criar aluno

```json
{
  "nome": "João da Silva",
  "email": "joao.silva@email.com",
  "cpf": "12345678901",
  "dataNascimento": "2000-05-15",
  "telefone": "11987654321",
  "endereco": {
    "logradouro": "Rua das Flores",
    "numero": "123",
    "complemento": "Apto 45",
    "bairro": "Jardim Primavera",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "12345-678"
  }
}
```
## 🐳 Banco de Dados com Docker  

Na pasta **`docker`** existe um arquivo **`docker-compose.yml`** que sobe um container com MySQL configurado para rodar o projeto.  

Para iniciar o banco, execute:  

```bash
docker-compose up -d

```
## ⚙️ Configuração do `application.properties`  

Para conectar ao banco MySQL criado pelo Docker, ajuste o arquivo `src/main/resources/application.properties`:  

```properties
# Conexão com o MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/appdb?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=appuser
spring.datasource.password=apppass
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Flyway - execução automática dos scripts SQL
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
spring.flyway.baseline-on-migrate=true
