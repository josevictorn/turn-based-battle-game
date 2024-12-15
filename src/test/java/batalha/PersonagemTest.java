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

      Integer resistencia = 0;
      Integer ataque = 0;
      Integer defesa = 0;
      Integer velocidade = 0;
      
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

      Integer resistencia = 1;
      Integer ataque = 0;
      Integer defesa = 0;
      Integer velocidade = 0;
      
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

      Integer resistencia = 5;
      Integer ataque = 5;
      Integer defesa = 5;
      Integer velocidade = 4;
      
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

      Integer resistencia = 5;
      Integer ataque = 5;
      Integer defesa = 5;
      Integer velocidade = 5;
      
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

      Integer resistencia = 5;
      Integer ataque = 6;
      Integer defesa = 5;
      Integer velocidade = 5;
      
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

      Integer resistencia = 10;
      Integer ataque = 10;
      Integer defesa = 10;
      Integer velocidade = 10;
      
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
        @Override
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
        @Override
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
        @Override
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
        @Override
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

  @Nested
  @DisplayName("Checar se um Guerreiro possui os atributos Resistência e Ataque como os mais altos ou empatados entre si.")
  class CT03 {
    @Test
    void CT031() {
      
      Integer resistencia = 5;
      Integer ataque = 5;
      Integer defesa = 5;
      Integer velocidade = 5;
      
      Guerreiro g = new Guerreiro(resistencia, ataque, defesa, velocidade);

      assertDoesNotThrow(()->g.checarRegraDeClasse());
    }

    @Test
    void CT032() {
      Integer resistencia = 10;
      Integer ataque = 4;
      Integer defesa = 3;
      Integer velocidade = 3;
      
      Guerreiro g = new Guerreiro(resistencia, ataque, defesa, velocidade);

      assertDoesNotThrow(()->g.checarRegraDeClasse());
    }
    
    @Test
    void CT033() {
      Integer resistencia = 6;
      Integer ataque = 8;
      Integer defesa = 3;
      Integer velocidade = 3;
      
      Guerreiro g = new Guerreiro(resistencia, ataque, defesa, velocidade);

      assertDoesNotThrow(()->g.checarRegraDeClasse());
    }
  
    @Test
    void CT034() {
      Integer resistencia = 4;
      Integer ataque = 6;
      Integer defesa = 3;
      Integer velocidade = 7;
      
      assertThrows(IllegalStateException.class, () -> {
        new Guerreiro(resistencia, ataque, defesa, velocidade);
      });
    }
    
    @Test
    void CT035() {      
      Integer resistencia = 5;
      Integer ataque = 4;
      Integer defesa = 8;
      Integer velocidade = 3;
      
      assertThrows(IllegalStateException.class, () -> {
        new Guerreiro(resistencia, ataque, defesa, velocidade);
      });
    }
  }

  @Nested
  @DisplayName("Checar se um Assassino possui os atributos Velocidade e Ataque como os mais altos ou empatados entre si.")
  class CT04 {
    @Test
    void CT041() {
      
      Integer resistencia = 5;
      Integer ataque = 5;
      Integer defesa = 5;
      Integer velocidade = 5;
      
      Personagem p = new Assassino(resistencia, ataque, defesa, velocidade);

      assertDoesNotThrow(()->p.checarRegraDeClasse());
    }

    @Test
    void CT042() {
      Integer resistencia = 3;
      Integer ataque = 4;
      Integer defesa = 3;
      Integer velocidade = 10;
      
      Personagem p = new Assassino(resistencia, ataque, defesa, velocidade);

      assertDoesNotThrow(()->p.checarRegraDeClasse());
    }
    
    @Test
    void CT043() {
      Integer resistencia = 3;
      Integer ataque = 8;
      Integer defesa = 3;
      Integer velocidade = 6;
      
      Personagem p = new Assassino(resistencia, ataque, defesa, velocidade);

      assertDoesNotThrow(()->p.checarRegraDeClasse());
    }
  
    @Test
    void CT044() {
      Integer resistencia = 7;
      Integer ataque = 6;
      Integer defesa = 3;
      Integer velocidade = 4;
      
      assertThrows(IllegalStateException.class, () -> {
        new Assassino(resistencia, ataque, defesa, velocidade);
      });
    }
    
    @Test
    void CT045() {      
      Integer resistencia = 3;
      Integer ataque = 4;
      Integer defesa = 8;
      Integer velocidade = 5;
      
      assertThrows(IllegalStateException.class, () -> {
        new Assassino(resistencia, ataque, defesa, velocidade);
      });
    }
  }

}
