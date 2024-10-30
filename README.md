# Projeto de Testes automatizados mobile

## Descrição

Este projeto utiliza o Appium e Java para realizar testes de em um aplicativo mobile.

## Configuração do Projeto

### Pré-requisitos

Certifique-se de que você tem instalado em sua máquina:

- Appium Server
- Emulador Android

### Clonando o Repositório

```
git clone https://github.com/carlos-gl/AppiumProject.git
```
Utilize sua IDE de preferência para executar o projeto (Sugetão: InteliJJ).

### Executando os Testes:
```
mvn clean test
```
#### O mesmo também é executado através do github actions, está configurado para rodar a esteira a cada commit.
#### O Projeto está configurado para executar integrado com o BrowserStack, serviço que fornece dispositivos para testes.

### Resultados dos Testes
O projeto executa dois testes.
- Login (Faz login no sistema e valida que está na página correspondente)
![cenário1](https://github.com/user-attachments/assets/dfc712f0-d179-41d3-8442-762ff9223cd1)
- Checkout (Faz o processo completo de selecionar produto e preencher dados da compra, validando que os dados preenchidos são os mesmos apresentados no final da compra)
![cenário2](https://github.com/user-attachments/assets/90cdedc1-8915-4164-b444-cbc620ce0b31)

