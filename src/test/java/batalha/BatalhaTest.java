package batalha;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
