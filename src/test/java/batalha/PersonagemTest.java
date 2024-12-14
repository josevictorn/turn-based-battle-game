package batalha;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PersonagemTest {

  @Nested
  @DisplayName("Checar se o total de ponto alocados nos atributos é válido")
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
}
