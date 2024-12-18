package batalha;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BatalhaTest {

  @Nested
  @DisplayName("Determinar ordem de ataque")
  class CT05 {
    @Test
    void CT051() {
      
      Integer velocidade_p1 = 5;
      Integer velocidade_p2 = 5;
      Integer randomico = 0;
      
      Personagem p1 = new Personagem() {
        @Override
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      p1.setVelocidade(velocidade_p1);

      Personagem p2 = new Personagem() {
        @Override
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      p2.setVelocidade(velocidade_p2);

      Personagem personagem_esperado = p1;
      Personagem personagem_retornado = new Batalha(p1, p2, randomico).getPrimeiroAtacante();

      assertEquals(personagem_esperado, personagem_retornado);
    }

    @Test
    void CT052() {
      
      Integer velocidade_p1 = 5;
      Integer velocidade_p2 = 5;
      Integer randomico = 1;
      
      Personagem p1 = new Personagem() {
        @Override
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      p1.setVelocidade(velocidade_p1);

      Personagem p2 = new Personagem() {
        @Override
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      p2.setVelocidade(velocidade_p2);

      Personagem personagem_esperado = p2;
      Personagem personagem_retornado = new Batalha(p1, p2, randomico).getPrimeiroAtacante();

      assertEquals(personagem_esperado, personagem_retornado);
    }

    @Test
    void CT053() {
      
      Integer velocidade_p1 = 6;
      Integer velocidade_p2 = 4;
      
      Personagem p1 = new Personagem() {
        @Override
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      p1.setVelocidade(velocidade_p1);

      Personagem p2 = new Personagem() {
        @Override
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      p2.setVelocidade(velocidade_p2);

      Personagem personagem_esperado = p1;
      Personagem personagem_retornado = new Batalha(p1, p2).getPrimeiroAtacante();

      assertEquals(personagem_esperado, personagem_retornado);
    }
    
    @Test
    void CT054() {
      
      Integer velocidade_p1 = 3;
      Integer velocidade_p2 = 8;
      
      Personagem p1 = new Personagem() {
        @Override
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      p1.setVelocidade(velocidade_p1);

      Personagem p2 = new Personagem() {
        @Override
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      p2.setVelocidade(velocidade_p2);

      Personagem personagem_esperado = p2;
      Personagem personagem_retornado = new Batalha(p1, p2).getPrimeiroAtacante();

      assertEquals(personagem_esperado, personagem_retornado);
    }
  }
  @Nested
  @DisplayName("Verificação de Evasão")
  class CT06 {
    @Test
    void CT061() {
      Integer velocidadeAtacante = 5;
      Integer velocidadeDefensor = 4;

      Personagem atacante = new Personagem() {
        @Override
        void checarRegraDeClasse() {
          // Deixado em branco de propósito
        }
      };
      Personagem defensor = new Personagem() {
        @Override
        void checarRegraDeClasse() {
          // Deixado em branco de propósito
        }
      };

      atacante.setVelocidade(velocidadeAtacante);
      defensor.setVelocidade(velocidadeDefensor);

      int chanceEvasao = Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());

      Assertions.assertEquals(0, chanceEvasao);
    }

    @Test
    void CT062() {
      Integer velocidadeAtacante = 5;
      Integer velocidadeDefensor = 5;

      Personagem atacante = new Personagem() {
        @Override
        void checarRegraDeClasse() {
          // Deixado em branco de propósito
        }
      };
      Personagem defensor = new Personagem() {
        @Override
        void checarRegraDeClasse() {
          // Deixado em branco de propósito
        }
      };

      atacante.setVelocidade(velocidadeAtacante);
      defensor.setVelocidade(velocidadeDefensor);

      int chanceEvasao = Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());

      Assertions.assertEquals(0, chanceEvasao);
    }
    @Test
    void CT063() {
      Integer velocidadeAtacante = 6;
      Integer velocidadeDefensor = 7;

      Personagem atacante = new Personagem() {
        @Override
        void checarRegraDeClasse() {
          // Deixado em branco de propósito
        }
      };
      Personagem defensor = new Personagem() {
        @Override
        void checarRegraDeClasse() {
          // Deixado em branco de propósito
        }
      };

      atacante.setVelocidade(velocidadeAtacante);
      defensor.setVelocidade(velocidadeDefensor);

      int chanceEvasao = Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());

      Assertions.assertEquals(2, chanceEvasao);
    }

    @Test
    void CT064() {
      Integer velocidadeAtacante = 6;
      Integer velocidadeDefensor = 8;

      Personagem atacante = new Personagem() {
        @Override
        void checarRegraDeClasse() {
          // Deixado em branco de propósito
        }
      };
      Personagem defensor = new Personagem() {
        @Override
        void checarRegraDeClasse() {
          // Deixado em branco de propósito
        }
      };
 
 
      atacante.setVelocidade(velocidadeAtacante);
      defensor.setVelocidade(velocidadeDefensor);
 
 
      int chanceEvasao = Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());
 
 
      Assertions.assertEquals(4, chanceEvasao);
    }
    @Test
   void CT065() {
     Integer velocidadeAtacante = 5;
     Integer velocidadeDefensor = 8;


     Personagem atacante = new Personagem() {
       @Override
       void checarRegraDeClasse() {
         // Deixado em branco de propósito
       }
     };
     Personagem defensor = new Personagem() {
       @Override
       void checarRegraDeClasse() {
         // Deixado em branco de propósito
       }
     };


     atacante.setVelocidade(velocidadeAtacante);
     defensor.setVelocidade(velocidadeDefensor);


     int chanceEvasao = Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());


     Assertions.assertEquals(6, chanceEvasao);
   }


  }
  @Nested
  @DisplayName("Checagem de Dano Crítico")
  class CT07 {

  }

}
