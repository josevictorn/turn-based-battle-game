package batalha;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PersonagemTest {

  @Nested
  @DisplayName("Checar se o total de ponto alocados nos atributos é válido.")
  class CT01 {
    @Test
    void CT011() {
      Personagem p = new Personagem() {
          @Override
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      Integer ataque = 0;
      Integer defesa = 0;
      Integer velocidade = 0;
      Integer resistencia = 0;
      
      p.setAtaque(ataque);
      p.setDefesa(defesa);
      p.setResistencia(resistencia);
      p.setVelocidade(velocidade);
      
      assertThrows(IllegalStateException.class, ()->p.checarTotal());
    }

    @Test
    void CT012() {
      Personagem p = new Personagem() {
          @Override
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      Integer ataque = 1;
      Integer defesa = 0;
      Integer velocidade = 0;
      Integer resistencia = 0;
      
      p.setAtaque(ataque);
      p.setDefesa(defesa);
      p.setResistencia(resistencia);
      p.setVelocidade(velocidade);
      
      assertThrows(IllegalStateException.class, ()->p.checarTotal());
    }
    
    @Test
    void CT013() {
      Personagem p = new Personagem() {
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      Integer ataque = 5;
      Integer defesa = 5;
      Integer velocidade = 5;
      Integer resistencia = 4;
      
      p.setAtaque(ataque);
      p.setDefesa(defesa);
      p.setResistencia(resistencia);
      p.setVelocidade(velocidade);

      assertThrows(IllegalStateException.class, ()->p.checarTotal());		
    }
  
  
    @Test
    void CT014() {
      Personagem p = new Personagem() {
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      Integer ataque = 5;
      Integer defesa = 5;
      Integer velocidade = 5;
      Integer resistencia = 5;
      
      p.setAtaque(ataque);
      p.setDefesa(defesa);
      p.setResistencia(resistencia);
      p.setVelocidade(velocidade);

      assertDoesNotThrow(()->p.checarTotal());
    }
    
    @Test
    void CT015() {
      Personagem p = new Personagem() {
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      Integer ataque = 5;
      Integer defesa = 6;
      Integer velocidade = 5;
      Integer resistencia = 5;
      
      p.setAtaque(ataque);
      p.setDefesa(defesa);
      p.setResistencia(resistencia);
      p.setVelocidade(velocidade);
      
      assertThrows(IllegalStateException.class, ()->p.checarTotal());		
    }

    
    @Test
    void CT016() {
      Personagem p = new Personagem() {
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      Integer ataque = 10;
      Integer defesa = 10;
      Integer velocidade = 10;
      Integer resistencia = 10;
      
      p.setAtaque(ataque);
      p.setDefesa(defesa);
      p.setResistencia(resistencia);
      p.setVelocidade(velocidade);
      
      assertThrows(IllegalStateException.class, ()->p.checarTotal());		
    }
  }

  @Nested
  @DisplayName("Checar se o total de ponto de cada atributos é no mínimo 3.")
  class CT02 {
    @Test
    void CT021() {
      Personagem p = new Personagem() {
          @Override
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      Integer resistencia = 0;
      Integer ataque = 0;
      Integer defesa = 0;
      Integer velocidade = 0;
      
      p.setResistencia(resistencia);
      p.setAtaque(ataque);
      p.setDefesa(defesa);
      p.setVelocidade(velocidade);

      assertThrows(IllegalStateException.class, ()->p.checarValorMinimo(resistencia));
      assertThrows(IllegalStateException.class, ()->p.checarValorMinimo(ataque));
      assertThrows(IllegalStateException.class, ()->p.checarValorMinimo(defesa));
      assertThrows(IllegalStateException.class, ()->p.checarValorMinimo(velocidade));
    }

    @Test
    void CT022() {
      Personagem p = new Personagem() {
          @Override
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      Integer resistencia = 19;
      Integer ataque = 1;
      Integer defesa = 0;
      Integer velocidade = 0;
      
      p.setResistencia(resistencia);
      p.setAtaque(ataque);
      p.setDefesa(defesa);
      p.setVelocidade(velocidade);

      assertDoesNotThrow(()->p.checarValorMinimo(resistencia));
      assertThrows(IllegalStateException.class, ()->p.checarValorMinimo(ataque));
      assertThrows(IllegalStateException.class, ()->p.checarValorMinimo(defesa));
      assertThrows(IllegalStateException.class, ()->p.checarValorMinimo(velocidade));
    }
    
    @Test
    void CT023() {
      Personagem p = new Personagem() {
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      Integer resistencia = 20;
      Integer ataque = 3;
      Integer defesa = 0;
      Integer velocidade = 7;
      
      p.setResistencia(resistencia);
      p.setAtaque(ataque);
      p.setDefesa(defesa);
      p.setVelocidade(velocidade);

      assertDoesNotThrow(()->p.checarValorMinimo(resistencia));
      assertDoesNotThrow(()->p.checarValorMinimo(ataque));
      assertThrows(IllegalStateException.class, ()->p.checarValorMinimo(defesa));
      assertDoesNotThrow(()->p.checarValorMinimo(velocidade));
    }
  
  
    @Test
    void CT024() {
      Personagem p = new Personagem() {
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      Integer resistencia = 4;
      Integer ataque = 3;
      Integer defesa = 11;
      Integer velocidade = 2;
      
      p.setResistencia(resistencia);
      p.setAtaque(ataque);
      p.setDefesa(defesa);
      p.setVelocidade(velocidade);

      assertDoesNotThrow(()->p.checarValorMinimo(resistencia));
      assertDoesNotThrow(()->p.checarValorMinimo(ataque));
      assertDoesNotThrow(()->p.checarValorMinimo(defesa));
      assertThrows(IllegalStateException.class, ()->p.checarValorMinimo(velocidade));
    }
    
    @Test
    void CT025() {
      Personagem p = new Personagem() {
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      Integer resistencia = 5;
      Integer ataque = 5;
      Integer defesa = 5;
      Integer velocidade = 5;
      
      p.setResistencia(resistencia);
      p.setAtaque(ataque);
      p.setDefesa(defesa);
      p.setVelocidade(velocidade);

      assertDoesNotThrow(()->p.checarValorMinimo(resistencia));
      assertDoesNotThrow(()->p.checarValorMinimo(ataque));
      assertDoesNotThrow(()->p.checarValorMinimo(defesa));
      assertDoesNotThrow(()->p.checarValorMinimo(velocidade));
    }

    
    @Test
    void CT026() {
      Personagem p = new Personagem() {
        void checarRegraDeClasse () {
          // Deixado em branco de propósito
        }
      };

      Integer resistencia = 21;
      Integer ataque = 6;
      Integer defesa = 5;
      Integer velocidade = 4;
      
      p.setResistencia(resistencia);
      p.setAtaque(ataque);
      p.setDefesa(defesa);
      p.setVelocidade(velocidade);

      assertDoesNotThrow(()->p.checarValorMinimo(resistencia));
      assertDoesNotThrow(()->p.checarValorMinimo(ataque));
      assertDoesNotThrow(()->p.checarValorMinimo(defesa));
      assertDoesNotThrow(()->p.checarValorMinimo(velocidade));
    }
  }
}
