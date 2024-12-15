package batalha;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GuerreiroTest {
  @Nested
  @DisplayName("Checar se um guerreiro possui os atributos Resistência e Ataque como os mais altos ou empatados entre si.")
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
}
