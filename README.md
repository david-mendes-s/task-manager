# Task Manager

## Descrição

O **Gerenciador de Tarefas com Listas de Afazeres** é uma aplicação projetada para simplificar a organização e o acompanhamento de suas tarefas diárias, projetos e atividades. Com uma interface amigável e recursos poderosos, esta aplicação torna o gerenciamento de tarefas eficiente e eficaz.

## Funções da Aplicação

### Tarefas (Tasks)

- **Criação de Tasks**: Permite criar uma nova tarefa especificando o nome e a descrição.
- **Listagem de Tasks**: Exibe a lista de todas as tarefas criadas.
- **Exclusão de Tasks**: Permite excluir uma tarefa específica com base em seu ID.
- **Atualização de Tasks**: Permite atualizar o nome e a descrição de uma tarefa existente.

### Subtarefas (Subtasks)

- **Criação de Subtarefas**: Permite criar subtarefas relacionadas a uma tarefa principal.
- **Listagem de SubTarefas**: Exibe a lista de todas as subtarefas associadas a uma tarefa.
- **Exclusão de Subtarefas**: Permite excluir uma subtarefa específica com base em seu ID.
- **Atualização de Subtarefas**: Permite marcar uma subtarefa como concluída ou não.

## Tecnologias Usadas

- Java 17
- Spring Boot
- JPA (Java Persistence API)
- Maven (Gestão de Dependências)
- PostgreSQL (Banco de Dados Relacional)

## Endpoints e Requisições

### Tasks

- **Listar todas as Tasks**
  - Endpoint: `GET https://localhost:8080/tasks/tasks-all`

- **Criar uma nova Task**
  - Endpoint: `POST https://localhost:8080/tasks/create/tasks`
  - Corpo da Requisição:
    ```json
    {
      "name": "Estudar Java",
      "description": "Finalizar curso de Java da dio."
    }
    ```

- **Excluir uma Task por ID**
  - Endpoint: `DELETE https://localhost:8080/tasks/delete-task/{id}`

- **Atualizar uma Task**
  - Endpoint: `PUT https://localhost:8080/tasks/update-task`
  - Corpo da Requisição:
    ```json
    {
      "id": "16417e04-2335-49ea-b3e2-5c80f87175e6",
      "name": "Revisar Java"
    }
    ```

### Todo-List

- **Listar todas as Listas de Afazeres (Todo-Lists) de uma Task**
  - Endpoint: `GET https://localhost:8080/todo-list/todo-list-all`
  - Corpo da Requisição:
    ```json
    {
      "id": "16417e04-2335-49ea-b3e2-5c80f87175e6"
    }
    ```

- **Criar uma nova Lista de Afazeres (Todo-List) para uma Task**
  - Endpoint: `POST https://localhost:8080/todo-list/create/todo-list-task`
  - Corpo da Requisição:
    ```json
    {
      "description": "Aula 03.",
      "task_id": "16417e04-2335-49ea-b3e2-5c80f87175e6"
    }
    ```

- **Excluir uma Lista de Afazeres (Todo-List) por ID**
  - Endpoint: `DELETE https://localhost:8080/todo-list/delete-todo-list/{id}`

- **Atualizar o status de uma Lista de Afazeres (Todo-List)**
  - Endpoint: `PUT https://localhost:8080/todo-list/update-todo-list`
  - Corpo da Requisição:
    ```json
    {
      "id": "69a0cdc5-5250-4197-b243-9ae9a173a2c4",
      "completed": true
    }
    ```

Lembre-se de substituir `https:localhost:8080` pelo URL correto de sua aplicação. Esta aplicação permite que você gerencie suas tarefas, crie listas de afazeres e mantenha o controle sobre seu trabalho de forma eficaz. Divirta-se usando o Gerenciador de Tarefas com Listas de Afazeres!

