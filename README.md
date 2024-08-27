# Biblioteca - API

Esta é uma API desenvolvida para a gestão de uma biblioteca, permitindo a realização de operações CRUD (Create, Read, Update, Delete) para livros e usuários, além de gerenciar empréstimos de livros. O projeto utiliza Java 17 com o framework Spring Boot, Hibernate, Lombok, Maven e um banco de dados relacional MySQL.

**Nota:** Este projeto está atualmente em construção e pode estar sujeito a mudanças e atualizações.

## Tecnologias Utilizadas

- **Java 17**: Versão do Java utilizada para o desenvolvimento.
- **Spring Boot**: Framework para construção de aplicações Java.
- **Hibernate**: Framework ORM para mapeamento objeto-relacional.
- **Lombok**: Biblioteca para redução de código boilerplate.
- **Maven**: Gerenciador de dependências e construção.
- **MySQL**: Banco de dados relacional.

## Instalação

1. **Clone o repositório**

    ```bash
    git clone https://github.com/SEU_USUARIO/biblioteca-api.git
    ```

2. **Configure o banco de dados**

    Certifique-se de ter o MySQL instalado e em execução. Na pasta `script-sql` contém os scripts para criação do banco de dados. Crie um banco de dados com o nome desejado e atualize o arquivo `src/main/resources/application.properties` com as suas credenciais do banco de dados:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/NOME_DO_BANCO
    spring.datasource.username=SEU_USUARIO
    spring.datasource.password=SUA_SENHA
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Compile e execute o projeto**

    Use o Maven para compilar e executar o projeto:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
## Modelagem
![image](https://github.com/user-attachments/assets/e94954c6-8ecd-4d36-9dc1-715c057875c3)



