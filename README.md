# READ ME

## AUTORES
- GUSTAVO SOUSA BERNARDES
- JOSE VICTOR DO NASCIMENTO FERREIRA 
- VLADIMIR VIEIRA DO NASCIMENTO 

## INTRODUÇÃO

  Este projeto é uma implementação de um sistema de batalha por turnos, onde personagens com atributos específicos (Ataque, Defesa, Velocidade e Resistência) se enfrentam. O objetivo principal é simular a luta entre dois personagens e determinar o vencedor com base nas mecânicas de batalha definidas, incluindo a chance de evasão, cálculo de dano e golpes críticos. Além disso, o projeto também apresenta como foco garantir que o código a ser desenvolvido também seja testado, por meio do JUnit 5, e em complemento o mesmo será submetido ao JaCoCo para realizar uma análise de cobertura dos testes.


## INSTRUÇÕES DE COMPILAÇÃO E EXECUÇÃO

### Clonar o Repositório

  Clone o repositório para a sua máquina local. Para isso, no terminal você deve digitar:

    git clone https://github.com/seuusuario/projeto-batalhas.git 

  Agora, vá para o diretório de interesse:

    cd projeto-batalhas

### INSTALAR O MAVEN

  O Maven, atualmente, é conhecido como uma ferramenta de automação de construção e gerenciamento de dependências. 

  Diante disso, primeiro vamos verificar se o Maven está instalado no seu sistema.
  Para isso, abra o terminal ou prompt de comando e digite:
  
    mvn -v
  
  Se o Maven não estiver instalado, você pode seguir as instruções de instalação presentes no site oficial do Maven: 
      
    https://maven.apache.org/install.html


### COMPILAR O PROJETO

  Para compilar o projeto e instalar as dependências necessárias, digite:
  
    mvn clean install

### COMO EXECUTAR OS TESTES AUTOMATIZADOS

  Este projeto utiliza JUnit 5 para realizar os testes automatizados. Para rodar os testes, execute o seguinte comando:

    mvn test
    
### RELATÓRIO DE COBERTURA

  Para utilizar o JaCoCo (Java Code Coverage Library) para poder gerar relatórios de cobertura de testes em seu projeto Java, siga os seguintes passos:


  Passo 1: Adicionar o plugin JaCoCo no arquivo pom.xml (para Maven)
  Para isso, abra o arquivo pom.xml do projeto que deseja analisar.
  Adicione o plugin JaCoCo abaixo na seção <build> do pom.xml para coletar as métricas de cobertura durante a execução dos testes.

    <build>
	    <plugins>
        	<!-- JaCoCo Plugin para cobertura de testes -->
    	    <plugin>
        	  <groupId>org.jacoco</groupId>
        	  <artifactId>jacoco-maven-plugin</artifactId>
        	  <version>0.8.8</version> 
        	  <executions>
            	  <execution>
                  	<goals>
                      	<!-- Gera o relatório de cobertura durante o ciclo de teste -->
                      	<goal>prepare-agent</goal>
                    	  <goal>report</goal>
                	  </goals>
                	  <phase>test</phase>
            	  </execution>
        	  </executions>
    	  </plugin>
	    </plugins>
    </build>




 Passo 2: Rodar os Testes e Gerar o Relatório de Cobertura

 No terminal, dentro do diretório raiz do seu projeto, execute o comando Maven para rodar os testes com o JaCoCo:

    mvn clean test

 ### Relatório de Cobertura
 
 O JaCoCo gera os relatórios de cobertura que podem ser encontrados por meio do seguinte caminho 
     
     target/site/jacoco/index.html. 
     
 Diante disso, o arquivo que você deseja apresenta o nome index.html. Ao clicar   nesse arquivo você poderá visualizar os dados do relatório de cobertura.
