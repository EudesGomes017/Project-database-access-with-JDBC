# Módulo Java: Integração com Banco de Dados Usando JDBC

Este módulo implementa a integração com um banco de dados relacional utilizando **JDBC** (Java Database Connectivity). Através deste módulo, é possível realizar operações básicas de **CRUD** (Criar, Ler, Atualizar, Deletar) em um banco de dados, permitindo o gerenciamento de dados de forma simples e eficaz.

## Funcionalidade

O objetivo desse módulo é demonstrar como usar **JDBC** para se conectar a um banco de dados e realizar operações como inserção de dados, leitura, atualização e exclusão de registros. O módulo foi projetado para interagir com um banco de dados SQL, como MySQL, PostgreSQL ou qualquer outro banco compatível com JDBC.

### Operações Realizadas

- **Conectar ao Banco de Dados**: Estabelece uma conexão com o banco de dados utilizando as credenciais fornecidas.
- **Criar (Insert)**: Insere novos registros no banco de dados.
- **Ler (Select)**: Recupera registros específicos do banco, com a possibilidade de aplicar filtros.
- **Atualizar (Update)**: Modifica registros existentes no banco com base em uma condição específica.
- **Excluir (Delete)**: Remove registros do banco de dados de acordo com um critério.

### Como Funciona

1. **Conexão com o Banco de Dados**: Utiliza o **Driver JDBC** correspondente ao banco (MySQL, PostgreSQL, etc.) para estabelecer uma conexão.
2. **Execução de Consultas SQL**: O módulo utiliza **PreparedStatement** para executar as consultas SQL de forma segura e eficiente.
3. **Manipulação de Resultados**: Para consultas de leitura, os dados retornados são processados utilizando **ResultSet**.
4. **Fechamento de Conexão**: Após a execução das operações, a conexão com o banco de dados é fechada corretamente para evitar vazamentos de recursos.

## Exemplo de Operações Realizadas

- **Conexão com o banco**: O módulo se conecta ao banco utilizando a URL de conexão, o nome de usuário e a senha.
- **Inserção de dados**: Insere registros de forma segura com **PreparedStatement**, evitando ataques de injeção SQL.
- **Consulta e exibição**: Utiliza **ResultSet** para percorrer os resultados de uma consulta **SELECT** e exibir os dados.
- **Atualização e exclusão**: Modifica ou exclui registros com base em condições específicas fornecidas pelo usuário.

### Fluxo de Execução

1. **Conectar** ao banco de dados usando o **Driver JDBC** adequado.
2. **Executar** as operações de **CRUD** (Insert, Select, Update, Delete) conforme necessário.
3. **Exibir os resultados** (para leitura de dados) ou confirmar a execução das operações.
4. **Fechar a conexão** ao banco de dados para liberar recursos.
