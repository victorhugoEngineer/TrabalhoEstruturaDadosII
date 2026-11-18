# 🔐 Criptografia, Hash e Blockchain

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Projeto](https://img.shields.io/badge/Projeto-Acad%C3%AAmico-6A5ACD?style=for-the-badge&logo=github&logoColor=white)
## 📖 Sobre o projeto

Este projeto foi desenvolvido como parte do trabalho prático da disciplina de **Estrutura de Dados II**, do curso de Engenharia de Software.

O objetivo é estudar e demonstrar, por meio de uma aplicação desenvolvida em Java, conceitos fundamentais de segurança da informação, com foco em criptografia, funções Hash e Blockchain.

A aplicação tem como proposta permitir que o usuário realize operações de criptografia e descriptografia de mensagens, além de gerar e comparar códigos Hash utilizando o algoritmo SHA-256.

## 🎯 Objetivos

- Compreender os fundamentos da criptografia e sua importância na segurança da informação.
- Diferenciar criptografia simétrica e assimétrica.
- Entender o funcionamento das funções Hash.
- Demonstrar a geração de códigos Hash utilizando SHA-256.
- Verificar a integridade de informações por meio da comparação de Hashes.
- Conhecer os conceitos de Blockchain e suas aplicações.

## ⚙️ Funcionalidades

### 1. Criptografia e descriptografia

A funcionalidade de criptografia tem como objetivo transformar uma mensagem original em um conteúdo protegido por meio de um algoritmo criptográfico.

O processo deverá permitir:

- Inserir uma mensagem de texto.
- Definir ou informar uma chave de criptografia.
- Criptografar a mensagem.
- Exibir o texto original e o texto criptografado.
- Descriptografar a mensagem.
- Verificar se o texto original foi recuperado corretamente.

### 2. Geração de Hash (SHA-256)

A funcionalidade de Hash permite gerar um código a partir de uma mensagem utilizando o algoritmo SHA-256.

Principais operações:

- Inserir uma mensagem.
- Gerar seu código Hash.
- Exibir o resultado em hexadecimal.
- Inserir uma segunda mensagem.
- Gerar o Hash da segunda mensagem.
- Comparar os dois resultados.
- Identificar se os códigos são iguais ou diferentes.

**Exemplo ilustrativo:**

| Mensagem  | Resultado |
| --------- | --------- |
| Olá Mundo | Hash A    |
| Olá mundo | Hash B    |

Mesmo uma pequena alteração na mensagem pode produzir um resultado Hash completamente diferente.

## 📚 Fundamentação teórica

O trabalho também aborda os seguintes conceitos:

**Criptografia**

- Criptografia simétrica.
- Criptografia assimétrica.
- Chaves públicas e privadas.
- Algoritmos criptográficos e suas aplicações.

**Funções Hash e Tabelas Hash**

- Funcionamento das funções Hash.
- Diferenças entre Hash e criptografia.
- Algoritmos de Hash.
- Integridade de informações.
- Tabelas Hash e colisões.

**Blockchain**

- Conceito e funcionamento.
- Relação com o Bitcoin.
- Encadeamento de blocos por funções Hash.
- Assinaturas digitais.
- Aplicações além das criptomoedas.

## 🛠️ Tecnologias utilizadas

| Tecnologia    | Finalidade                                |
| ------------- | ----------------------------------------- |
| Java          | Linguagem de programação                  |
| Maven         | Gerenciamento e organização do projeto    |
| SHA-256       | Geração de códigos Hash                   |
| MessageDigest | Implementação de funções Hash em Java     |
| Git e GitHub  | Controle de versão e hospedagem do código |

## 📂 Estrutura do projeto

```text
TrabalhoEstruturaDadosII/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   └── main/
│       └── java/
│           └── ...
│
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## 🚀 Como executar o projeto

### Pré-requisitos

- Java JDK instalado.
- Git instalado.
- IDE de sua preferência (IntelliJ IDEA, Eclipse ou VS Code).

### 1. Clonar o repositório

```bash
git clone https://github.com/victorhugoEngineer/TrabalhoEstruturaDadosII.git
```

### 2. Acessar a pasta

```bash
cd TrabalhoEstruturaDadosII
```

### 3. Compilar o projeto

No Windows:

```bash
mvnw.cmd clean package
```

No Linux ou macOS:

```bash
./mvnw clean package
```

### 4. Executar

Abra o projeto na sua IDE e execute a classe principal (`main`).

> Observação: o comando de execução direta depende da classe principal configurada no projeto Maven.

## 🎓 Informações acadêmicas

- **Instituição:** UNIFAN – Centro Educacional Alfredo Nasser
- **Curso:** Engenharia de Software
- **Disciplina:** Estrutura de Dados II
- **Professor:** Ricardo Vilaverde
- **Tema:** Criptografia, Hash e Blockchain
- **Linguagem:** Java

## 👨‍💻 Desenvolvedores

Projeto acadêmico desenvolvido para a disciplina de Estrutura de Dados II.

*Victor Hugo Alves Vaz.*

## 📌 Resultado esperado

Uma aplicação funcional desenvolvida em Java, capaz de demonstrar os processos de criptografia e descriptografia de mensagens, geração de códigos Hash com SHA-256 e comparação de resultados.

O projeto busca proporcionar uma compreensão prática dos conceitos de segurança da informação e sua relação com tecnologias como Blockchain.

## 📄 Licença

Projeto desenvolvido para fins acadêmicos e educacionais.

---

\<p align="center">
&#x20; Desenvolvido com ☕ Java para a disciplina de Estrutura de Dados II.
\</p>
