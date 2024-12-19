package batalha;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.SecureRandom;

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

    @Test
    void CT071() {
      Integer velocidadeAtacante = 5;
      Integer velocidadeDefensor = 5;
      Integer randomico = 1;
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
        Batalha batalha = new Batalha(atacante, defensor);
        boolean teste = batalha.verificarSeGolpeCritico(randomico);
        assertTrue(teste);
  }

  @Test
  void CT072() {
    Integer velocidadeAtacante = 5;
    Integer velocidadeDefensor = 5;
    Integer randomico = 9;
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
      Batalha batalha = new Batalha(atacante, defensor);
      boolean teste = batalha.verificarSeGolpeCritico(randomico);
      assertTrue(teste);
}
  @Test
  void CT073() {
    Integer velocidadeAtacante = 5;
    Integer velocidadeDefensor = 5;
    Integer randomico = 10;
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
      Batalha batalha = new Batalha(atacante, defensor);
      boolean teste = batalha.verificarSeGolpeCritico(randomico);
      assertTrue(teste);
}
@Test
void CT074() {
  Integer velocidadeAtacante = 5;
  Integer velocidadeDefensor = 5;
  Integer randomico = 11;
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
    Batalha batalha = new Batalha(atacante, defensor);
    boolean teste = batalha.verificarSeGolpeCritico(randomico);
    assertFalse(teste);
}
void CT075() {
  Integer velocidadeAtacante = 5;
  Integer velocidadeDefensor = 5;
  Integer randomico = 99;
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
    Batalha batalha = new Batalha(atacante, defensor);
    boolean teste = batalha.verificarSeGolpeCritico(randomico);
    assertFalse(teste);
}
void CT076() {
  Integer velocidadeAtacante = 5;
  Integer velocidadeDefensor = 5;
  Integer randomico = 100;
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
    Batalha batalha = new Batalha(atacante, defensor);
    boolean teste = batalha.verificarSeGolpeCritico(randomico);
    assertFalse(teste);
}
  }

@Nested
  @DisplayName("Checagem do Dano Base")
  class CT08 {

    @Test
    void CT081() {
      Integer ataque = 5;
      double randomico = 0.7;
        Personagem atacante = new Personagem() {
            @Override
            void checarRegraDeClasse() {
                // Deixado em branco de propósito
            }
        };
        atacante.setAtaque(ataque);
        assertThrows(IllegalStateException.class, 
     () -> atacante.calcularDanoBase(randomico),"O valor do modificado de ataque é invalido!");
  
  }
  @Test
  void CT082() {
    Integer ataque = 4;
    double randomico = 0.8;
    Integer valorEsperado=3;
      Personagem atacante = new Personagem() {
          @Override
          void checarRegraDeClasse() {
              // Deixado em branco de propósito
          }
      };
      atacante.setAtaque(ataque);
      int danoBase = atacante.calcularDanoBase(randomico);
      assertEquals(valorEsperado, danoBase);
}
@Test
void CT083() {
  Integer ataque = 3;
  double randomico = 0.9;
  Integer valorEsperado=3;
    Personagem atacante = new Personagem() {
        @Override
        void checarRegraDeClasse() {
            // Deixado em branco de propósito
        }
    };
    atacante.setAtaque(ataque);
    int danoBase = atacante.calcularDanoBase(randomico);
    assertEquals(valorEsperado, danoBase);
}
@Test
void CT084() {
  Integer ataque = 3;
  double randomico = 1.1;
  Integer valorEsperado=3;
    Personagem atacante = new Personagem() {
        @Override
        void checarRegraDeClasse() {
            // Deixado em branco de propósito
        }
    };
    atacante.setAtaque(ataque);
    int danoBase = atacante.calcularDanoBase(randomico);
    assertEquals(valorEsperado, danoBase);
}
@Test
void CT085() {
  Integer ataque = 4;
  double randomico = 1.2;
  Integer valorEsperado=5;
    Personagem atacante = new Personagem() {
        @Override
        void checarRegraDeClasse() {
            // Deixado em branco de propósito
        }
    };
    atacante.setAtaque(ataque);
    int danoBase = atacante.calcularDanoBase(randomico);
    assertEquals(valorEsperado, danoBase);
  }
  @Test
  void CT086() {
    Integer ataque = 5;
    double randomico = 1.3;
      Personagem atacante = new Personagem() {
          @Override
          void checarRegraDeClasse() {
              // Deixado em branco de propósito
          }
      };
      atacante.setAtaque(ataque);
      assertThrows(IllegalStateException.class, 
   () -> atacante.calcularDanoBase(randomico),"O valor do modificado de ataque é invalido!");

}
}

  
}
