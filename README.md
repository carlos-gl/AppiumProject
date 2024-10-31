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

### Executando os Testes com BrowserStack:
#### Caso você tenha uma conta no BrowserStack basta definir seu User Name e Access Key, como variavéis de ambiente e após clonar o projeto na sua máquina executar os comandos abaixo:
![image](https://github.com/user-attachments/assets/b448ac0e-7fd4-4ef5-8377-e5a3db7a8d34)

```
mvn install -DskipTests
```

```
mvn clean test
```

Caso não possua pode utilizar o User Name e Access Key abaixo:
* carloslins_PQ4NyW
* UsK18P3iYtR4xFnsMMBq

Lembrando que ele deve estar cadastrado como uma variável de ambiente:
![image](https://github.com/user-attachments/assets/a459b64e-89a8-4839-8e90-b4f25003b50d)

Após feito o cadastro a máquina deve ser reiniciada para o sistema reconhecer as variavéis, feito isso basta repetir os passos para execução do projeto descrito acima. (Lembrando que só será visível se estiver logado na plataforma do browserStack)

### Executando os Testes localmente:
Para executar os testes localmente, podemos alterar os capabilities configurados no arquivo **BaseTest.java**

Basta alterar a função setUp para o código abaixo: (o deviceName, deve ser o nome do seu emulador, o padrão é esse que está no código)
```
public void setUp() throws MalformedURLException {
    DesiredCapabilities caps = new DesiredCapabilities();

    caps.setCapability("platformName", "Android");
    caps.setCapability("deviceName", "Emulator-5554"); 
    caps.setCapability("automationName", "UiAutomator2");

    caps.setCapability("app", System.getProperty("user.dir") + "/src/test/java/com/resources/Android-app.apk");

    driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
    
    driver.manage().timeouts().implicitlyWait(30, java.util.concurrent.TimeUnit.SECONDS);
  }
```

Feito a alteração, devemos garantir que o Appium Server está em execução, configurar porta 4723, após isso clicar em startServer:
![image](https://github.com/user-attachments/assets/be1a4b22-4a9f-4968-a01c-3b239e76fad5)

Com ele em execução devemos ter configurado também um emulador em execução, sugiro utilizar o do Android Studio
![image](https://github.com/user-attachments/assets/a6da2ce1-f8cc-464c-a4f4-c398e10764e6)
![image](https://github.com/user-attachments/assets/b42a09b8-21f8-4fe0-9c51-79779d9addf3)

- Com o emulador rodando, executar os comandos:

```
mvn install -DskipTests
```

```
mvn clean test
```

Com isso os testes serão executados e poderá acompanhar a execução no seu emulador local.

Exemplo de execução local:
![app](https://github.com/user-attachments/assets/c511fcc0-c470-4e4d-bcbf-89b8ead57c20)


#### O mesmo também é executado através do github actions, está configurado para rodar a esteira a cada commit.

### Resultados dos Testes
O projeto executa dois testes.
* Login (Faz login no sistema e valida que está na página correspondente)
![cenário1](https://github.com/user-attachments/assets/dfc712f0-d179-41d3-8442-762ff9223cd1)
* Checkout (Faz o processo completo de selecionar produto e preencher dados da compra, validando que os dados preenchidos são os mesmos apresentados no final da compra)
  
![cenário2](https://github.com/user-attachments/assets/90cdedc1-8915-4164-b444-cbc620ce0b31)
