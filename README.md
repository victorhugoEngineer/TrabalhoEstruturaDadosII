# 🔐 Criptografia, Hash e Blockchain

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![AES](https://img.shields.io/badge/AES-256-2E8B57?style=for-the-badge&logo=letsencrypt&logoColor=white)
![SHA-256](https://img.shields.io/badge/SHA--256-Hash-6A5ACD?style=for-the-badge&logo=databricks&logoColor=white)

## 📖 Sobre o projeto

Este projeto foi desenvolvido como parte do trabalho prático da disciplina de **Estrutura de Dados II**, do curso de Engenharia de Software da UNIFAN – Centro Universitário Alfredo Nasser.

O objetivo é estudar e demonstrar, por meio de uma aplicação desenvolvida em **Java 21**, conceitos fundamentais de segurança da informação, com foco em criptografia, funções Hash e Blockchain.

A aplicação implementa mecanismos de criptografia e descriptografia de mensagens utilizando o algoritmo **AES-256**, além da geração de códigos Hash por meio do algoritmo **SHA-256**.

O projeto também apresenta o conceito de Efeito Avalanche, demonstrando como pequenas alterações em uma mensagem podem produzir resultados Hash completamente diferentes.

## 🎯 Objetivos

- Compreender os fundamentos da criptografia e sua importância na segurança da informação.
- Diferenciar criptografia simétrica e assimétrica.
- Implementar criptografia e descriptografia utilizando AES-256.
- Compreender o funcionamento das funções Hash.
- Gerar códigos Hash utilizando SHA-256.
- Verificar a integridade de informações por meio da comparação de Hashes.
- Demonstrar o Efeito Avalanche.
- Conhecer os conceitos de Blockchain e suas aplicações.

## ⚙️ Funcionalidades

### 🔒 1. Criptografia e descriptografia AES-256

A aplicação utiliza o algoritmo **AES-256 (Advanced Encryption Standard)**, um algoritmo de criptografia simétrica que utiliza a mesma chave para realizar a criptografia e a descriptografia dos dados.

Principais funcionalidades:

- Inserção de mensagens de texto.
- Derivação da chave de criptografia utilizando SHA-256.
- Geração de IV (Vetor de Inicialização) aleatório.
- Criptografia de mensagens utilizando AES-256.
- Codificação dos dados criptografados e do IV em Base64.
- Exibição da mensagem original e do conteúdo criptografado.
- Descriptografia utilizando a chave informada.
- Verificação da recuperação da mensagem original.
- Teste de descriptografia utilizando uma chave incorreta.

**Detalhes técnicos:**

| Recurso | Implementação |
|---|---|
| Algoritmo | AES-256 |
| Tipo | Criptografia simétrica |
| Derivação da chave | SHA-256 |
| IV | Gerado aleatoriamente |
| Codificação | Base64 |
| API Java | `javax.crypto.Cipher` |

### #️⃣ 2. Geração de Hash SHA-256

A funcionalidade de Hash utiliza o algoritmo **SHA-256 (Secure Hash Algorithm 256-bit)** para gerar códigos únicos de 256 bits a partir de mensagens de texto.

Principais funcionalidades:

- Inserção de mensagens.
- Geração de códigos Hash utilizando SHA-256.
- Exibição dos resultados em hexadecimal.
- Comparação entre dois códigos Hash.
- Identificação de mensagens iguais ou diferentes.
- Demonstração do Efeito Avalanche.

**Detalhes técnicos:**

| Recurso | Implementação |
|---|---|
| Algoritmo | SHA-256 |
| Tamanho do resultado | 256 bits |
| Formato de exibição | Hexadecimal |
| API Java | `java.security.MessageDigest` |

### 🌊 3. Efeito Avalanche

O Efeito Avalanche é uma propriedade importante dos algoritmos Hash.

Ele demonstra que uma pequena alteração na mensagem original pode provocar uma grande mudança no resultado gerado.

A aplicação permite comparar dois Hashes e calcular a quantidade de bits diferentes entre eles.

Essa funcionalidade ajuda a compreender como o SHA-256 contribui para a verificação da integridade das informações.

## 📚 Fundamentação teórica

O relatório teórico que acompanha este repositório aborda três áreas fundamentais da segurança da informação.

### 🔐 Criptografia

- Conceito e finalidade da criptografia.
- Diferenças entre criptografia simétrica e assimétrica.
- Funcionamento de chaves públicas e privadas.
- Algoritmos AES e RSA.
- Aplicações da criptografia na segurança da informação.

### #️⃣ Funções Hash e Tabelas Hash

- Conceito e funcionamento das funções Hash.
- Propriedades de resistência à colisão.
- Propriedade de unidirecionalidade.
- Verificação da integridade de informações.
- Funcionamento das tabelas Hash.
- Tratamento de colisões.

### ⛓️ Blockchain

- Conceito de Blockchain e sua estrutura descentralizada.
- Relação entre Blockchain e Bitcoin.
- Encadeamento de blocos utilizando funções Hash.
- Imutabilidade e segurança dos registros.
- Importância das assinaturas digitais.
- Aplicações corporativas além das criptomoedas.

## 🛠️ Tecnologias utilizadas

| Tecnologia | Finalidade |
|---|---|
| Java 21 (JDK 21) | Linguagem principal de desenvolvimento |
| Maven | Gerenciamento de dependências e build do projeto |
| `javax.crypto.Cipher` | Implementação da criptografia simétrica AES-256 |
| `java.security.MessageDigest` | Implementação das funções Hash SHA-256 |
| `java.util.Base64` | Codificação dos dados criptografados e do IV |
| Git | Controle de versão |
| GitHub | Hospedagem e compartilhamento do código-fonte |

## 📂 Estrutura do projeto

```text
TrabalhoEstruturaDadosII/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── CriptografiaAES.java
│       │   ├── HashSHA256.java
│       │   └── Main.java
│       │
│       └── resources/
│
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

### 📄 Descrição dos arquivos principais

| Arquivo | Responsabilidade |
|---|---|
| `Main.java` | Menu interativo no terminal e gerenciamento do fluxo da aplicação |
| `CriptografiaAES.java` | Derivação da chave, geração do IV e operações de criptografia e descriptografia AES-256 |
| `HashSHA256.java` | Geração de Hash SHA-256 e cálculo do Efeito Avalanche |
| `pom.xml` | Configurações e gerenciamento do projeto Maven |

## 🚀 Como executar o projeto

### 📋 Pré-requisitos

Antes de executar a aplicação, certifique-se de possuir:

- Java JDK 21 ou superior instalado.
- Git instalado.
- IntelliJ IDEA, Eclipse ou Visual Studio Code (opcional).
- Terminal ou Prompt de Comando.

### 1. Clonar o repositório

```bash
git clone https://github.com/victorhugoEngineer/TrabalhoEstruturaDadosII.git
```

### 2. Acessar o diretório do projeto

```bash
cd TrabalhoEstruturaDadosII
```

### 3. Compilar o projeto

Utilize o Maven Wrapper para compilar a aplicação.

**Windows:**

```bash
mvnw.cmd clean compile
```

**Linux / macOS:**

```bash
./mvnw clean compile
```

### 4. Executar a aplicação

Após a compilação, execute a classe principal.

**Via terminal:**

```bash
java -cp target/classes Main
```

**Via IDE:**

Abra o projeto na sua IDE de preferência e execute o método `main` da classe `Main.java`.

> Observação: o comando direto pelo terminal pressupõe que a classe Main não utiliza declaração de pacote e que as classes compiladas estão disponíveis em `target/classes`.

## 🧪 Testes e demonstrações

A aplicação permite realizar testes práticos para demonstrar o funcionamento dos algoritmos implementados.

**Testes de criptografia:**

- Criptografar uma mensagem utilizando uma chave.
- Descriptografar a mensagem com a chave correta.
- Verificar a recuperação do texto original.
- Tentar descriptografar utilizando uma chave incorreta.
- Observar a utilização do IV aleatório.

**Testes de Hash:**

- Gerar o Hash de uma mensagem.
- Alterar um caractere da mensagem.
- Gerar um novo Hash.
- Comparar os resultados.
- Calcular a quantidade de bits diferentes entre os códigos.

Esses testes demonstram, na prática, os conceitos de criptografia, integridade e Efeito Avalanche.

## 🎓 Informações acadêmicas

- **Instituição:** UNIFAN – Centro Universitário Alfredo Nasser
- **Curso:** Engenharia de Software
- **Disciplina:** Estrutura de Dados II
- **Professor:** Ricardo Vilaverde
- **Tema:** Criptografia, Hash e Blockchain
- **Linguagem:** Java 21

## 👨‍💻 Autor

**Victor Hugo Alves Vaz**

Estudante de Engenharia de Software.

- GitHub: [@victorhugoEngineer](https://github.com/victorhugoEngineer)
- Repositório: [TrabalhoEstruturaDadosII](https://github.com/victorhugoEngineer/TrabalhoEstruturaDadosII)

## 📌 Considerações finais

O desenvolvimento deste projeto proporcionou a aplicação prática dos conceitos de criptografia, funções Hash e segurança da informação utilizando a linguagem Java.

Por meio da implementação do AES-256 e do SHA-256, foi possível compreender os processos de proteção de mensagens, verificação de integridade e comparação de resultados Hash.

Além disso, o estudo teórico sobre Blockchain permitiu compreender a importância dessas tecnologias na construção de sistemas seguros e descentralizados.

## 📄 Licença

Projeto desenvolvido para fins acadêmicos e educacionais.

---

<p align="center">
  Desenvolvido com ☕ Java 21
</p>

<p align="center">
  <strong>Estrutura de Dados II | Engenharia de Software</strong>
</p>
