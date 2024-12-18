# Trabalho Prático: Implementação e Teste de um (Pseudo) Jogo de Batalha por Turnos

## Documentação das Regras de Negócio
### RN01: Cada personagem começa com 20 pontos para distribuir entre os atributos.
- Partições:
  - [0, 20): a soma dos pontos é menor que 20 
  - [20]: a soma dos pontos alocados nos atributos é igual a 20.
  - (20, ∞): a soma dos ponto é maior que 20.
- Valores limites:
  - Partição [0, 20): {0, 1, 19, 20, 21}
  - Partição [20]: {19, 20, 21}
  - Partição (20, ∞): {19, 20, 21, 40}
- Tabelas de decisão:
  | Condições | Regra 1 | Regra 2 | Regra 3 |
  |-------------|-------------|-------------|-------------|
  | Soma total dos pontos = 20 | T | - | - |
  | Soma total dos pontos < 20 | - | T | - |
  | Soma total dos pontos > 20 | - | - | T|
  | Retorna exceção |  | X | X |
  | Não retorna exceção | X |  |  |

### RN02: Cada atributo deve ter no mínimo 3 pontos.
- Partições:
  - [0, 3): O atributo tem potuação menor que 3.
  - [3, 20]: O atributo possui no mínimo 3 pontos.
- Valores limites:
  - Partição [0, 3): {0, 2}
  - Partição [3, 20]: {2, 3, 4, 19, 20, 21}
- Tabela de decisão:
  | Condições | Regra 1 | Regra 2 | Regra 3 |  Regra 4 |  Regra 5 |
  |-------------|-------------|-------------|-------------|-------------|-------------|
  | Resistência | < 3 | >= 3 | >= 3 | >= 3 | >= 3 |
  | Ataque | - | < 3 | >= 3 | >= 3 | >= 3 |
  | Defesa | - | - | <3 | >=3 | >= 3 |
  | Velocidade | - | - | - | <3 | >= 3 |
  | Retorna exceção | X | X | X | X |  |
  | Não retorna exceção |  |  |  |  | X |

### RN03: O Guerreiro deve ter os atributos resistência e ataque com os valores mais altos ou empatados.
- Partições:
  - Resistência > Ataque
  - Resistência = Ataque
  - Resistência < Ataque
  - Defesa <= (Resistência && Ataque)
  - Velocidade <= (Resistência && Ataque)
- Valores limites:
  - Partição [0, 20]: desde que respeite a RN01 e RN02
- Tabela de decisão:
  | Condições | Regra 1 | Regra 2 | Regra 3 |
  |-------------|-------------|-------------|-------------|
  | Resistência > Ataque | - | - | - |
  | Resistência = Ataque | - | - | - |
  | Resistência < Ataque | - | - | - |
  | Defesa <= (Resistência && Ataque) | T | F | - |
  | Velocidade <= (Resistência && Ataque) | T | - | F |
  | Lança exceção |  | X | X |
  | Não lança exceçao | X |  |  |

### RN04: O Assassino deve ter os atributos ataque e velocidade com os valores mais altos ou empatados.
- Partições:
  - Velocidade > Ataque
  - Velocidade = Ataque
  - Velocidade < Ataque
  - Defesa <= (Velocidade && Ataque)
  - Resistência <= (Velocidade && Ataque)
- Valores limites:
  - Partição [0, 20]: desde que respeite a RN01 e RN02
- Tabela de decisão:
  | Condições | Regra 1 | Regra 2 | Regra 3 |
  |-------------|-------------|-------------|-------------|
  | Velocidade > Ataque | - | - | - |
  | Velocidade = Ataque | - | - | - |
  | Velocidade < Ataque | - | - | - |
  | Defesa <= (Velocidade && Ataque) | T | F | - |
  | Resistêcia <= (Velocidade && Ataque) | T | - | F |
  | Lança exceção |  | X | X |
  | Não lança exceçao | X |  |  |

### RN05: O personagem que ataca primeiro deve ser determinado pelo valor da velocidade.
- Partições:
  - Velocidade de p1 > Velocidade de p2: o personagem p1 deve ataca primeiro.
  - Velocidade de p2 > Velocidade de p1: o personagem p2 deve atacar primeiro.
  - Velocidade de p1 = Velocidade de p2: a ordem de ataque é decidida aleatoriamente.
- Valores limites:
  - Mínimo: 0.
  - Máximo: qualquer valor inteiro positivo.
- Tabela de decisão:
  | Condições | Regra 1 | Regra 2 | Regra 3 | Regra 4 |
  |-------------|-------------|-------------|-------------|-------------|
  | Velocidade de p1 > Velocidade de p2 | T | - | - | - |
  | Velocidade de p1 < Velocidade de p2 | - | T | - | - |
  | Velocidade de p1 = Velocidade de p2 | - | - | T | T |
  | Ordem aleatória decide p1 como primeiro | - | - | T | F |
  | Ordem aleatória decide p2 como primeiro | - | - | F | T |
  | p1 ataca primeiro | X |  | X |  |
  | p2 ataca primeiro |  | X |  | X |

### RN06: Cálculo da Chance de Evasão
- Partições: 
  - Velocidade do Defensor > Velocidade do Atacante
  - Velocidade do Defensor ≤ Velocidade do Atacante
- Valores limites: 
  - [0, 50] = {0, 1, 49, 50, 51}
- Tabela de decisão:
  
  | Condições | Regra 1 | Regra 2 |
  |-------------|-------------|-------------|
  | Número gerado ≤ Chance de Evasão | T | F |
  | Ataque é evitado | X |  |
  | Ataque não é evitado |  | X |

### RN07: Cálculo de Golpes Críticos

- Partições:
  - Número gerado <= 10
  - Número gerado > 10
- Valores limites: 
  - Número gerador: {1, 9, 10, 11, 99, 100}
- Tabela de decisão:
  | Condições | Regra 1 | Regra 2 |
  |-------------|-------------|-------------|
  | Número gerado <= 10 | T | F |
  | Golpe crítico | X |  |
  | Não é um golpe crítico |  | X |
  | Dano infringido é multiplicado por 1.5 | X |  |

### RN08: Dano Base

- Partições: 
  - Não se aplica;
- Valores limites: 
  - [0.8, 1.2]: {0.7, 0.8, 0.9, 1.1, 1.2, 1.3}
- Tabela de decisão:
  - Não se aplica;

### RN09: Dano Infringido

- Partições: 
  - Dano Base + Ataque do Atacante  <= Defesa do Defensor
  - Dano Base + Ataque do Atacante > Defesa do Defensor
- Valores limites: 
  - Valores do dano infringido: {-1, 0, 1, 2}
- Tabela de decisão:
  | Condições | Regra 1 | Regra 2 |
  |-------------|-------------|-------------|
  | Dano Base + Ataque do Atacante  <= Defesa do Defensor | T | F |
  | Dano infringido = Dano Base + Ataque do Atacante - Defesa do Defensor | - | X |
  | Dano infringido = 1 | X | - |
  
## Casos de teste
### CT01: Checar se o total de ponto alocados nos atributos é válido (RN01)
<a id="CT01"></a>
  | ID | Resistência | Ataque | Defesa | Velocidade | Total | Saída esperada | Pré-condição | Pós-condição |
  |-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|
  | CT011 | 0 | 0 | 0 | 0 | 0 | Lançar exceção | PRE1, PRE2, PRE3 | POS2
  | CT012 | 1 | 0 | 0 | 0 | 1 | Lançar exceção | PRE1, PRE2, PRE3 | POS2
  | CT013 | 5 | 5 | 5 | 4 | 19 | Lançar exceção | PRE1, PRE2, PRE3 | POS2
  | CT014 | 5 | 5 | 5 | 5 | 20 | Não lançar exceção | PRE1, PRE2, PRE3 | POS1
  | CT015 | 5 | 6 | 5 | 5 | 21 | Lançar exceção | PRE1, PRE2, PRE3 | POS2
  | CT016 | 10 | 10 | 10 | 10 | 40 | Lançar exceção | PRE1, PRE2, PRE3 | POS2

- Pré condições:
  - PRE1: o sistema solicita dados dos 4 atributos.
  - PRE2: O usuário inputa os dados dos 4 atributos.
  - PRE3: o sistema realiza a soma dos pontos dos atributos.
- Pós-condições:
  - POS1: o sistema cria o personagem.
  - POS2: o sistema não cria o personagem.
  
### CT02: Checar se o total de ponto de cada atributos é no mínimo 3 (RN02)
<a id="CT02"></a>

  | ID | Resistência | Ataque | Defesa | Velocidade | Total | Saída esperada | Pré-condição | Pós-condição |
  |-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|
  | CT021 | 0 | 0 | 0 | 0 | 0 | LE, LE, LE, LE | PRE1, PRE2 | POS2
  | CT022 | 19 | 1 | 0 | 0 | 20 | NE, LE, LE, LE | PRE1, PRE2 | POS2
  | CT023 | 20 | 3 | 0 | 7 | 30 | NE, NE, LE, NE | PRE1, PRE2 | POS2
  | CT024 | 4 | 3 | 11 | 2 | 20 | NE, NE, NE, LE | PRE1, PRE2 | POS2
  | CT025 | 5 | 5 | 5 | 5 | 20 | NE, NE, NE, NE | PRE1, PRE2 | POS1
  | CT026 | 21 | 6 | 5 | 4 | 36 | NE, NE, NE, NE | PRE1, PRE2 | POS2

- Saídas esperadas:
  - LE: Lança exceção
  - NE: Não lança exceção
- Pré condições:
  - PRE1: o sistema solicita dados dos 4 atributos.
  - PRE2: O usuário inputa os dados dos 4 atributos.
- Pós-condições:
  - POS1: o sistema cria o personagem.
  - POS2: o sistema não cria o personagem.
  
### CT03: Checar se um Guerreiro possui os atributos Resistência e Ataque como os mais altos ou empatados entre si (RN03)
<a id="CT03"></a>

  | ID | Resistência | Ataque | Defesa | Velocidade | Total | Saída esperada | Pré-condição | Pós-condição |
  |-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|
  | CT031 | 5 | 5 | 5 | 5 | 20 | NE | PRE1, PRE2 | POS2
  | CT032 | 10 | 4 | 3 | 3 | 20 | NE | PRE1, PRE2 | POS2
  | CT033 | 6 | 8 | 3 | 3 | 20 | NE | PRE1, PRE2 | POS2
  | CT034 | 4 | 6 | 3 | 7 | 20 | LE | PRE1, PRE2 | POS2
  | CT035 | 5 | 4 | 8 | 3 | 20 | LE | PRE1, PRE2 | POS2

- Saídas esperadas:
  - LE: Lança exceção
  - NE: Não lança exceção
- Pré condições:
  - PRE1: o sistema solicita dados dos 4 atributos.
  - PRE2: O usuário inputa os dados dos 4 atributos.
- Pós-condições:
  - POS1: o sistema cria o personagem.
  - POS2: o sistema não cria o personagem.

### CT04: Checar se um Assassino possui os atributos Velocidade e Ataque como os mais altos ou empatados entre si (RN03)
<a id="CT04"></a>

  | ID | Resistência | Ataque | Defesa | Velocidade | Total | Saída esperada | Pré-condição | Pós-condição |
  |-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|
  | CT041 | 5 | 5 | 5 | 5 | 20 | NE | PRE1, PRE2 | POS2
  | CT042 | 3 | 4 | 3 | 10 | 20 | NE | PRE1, PRE2 | POS2
  | CT043 | 3 | 8 | 3 | 6 | 20 | NE | PRE1, PRE2 | POS2
  | CT044 | 7 | 6 | 3 | 4 | 20 | LE | PRE1, PRE2 | POS2
  | CT045 | 3 | 4 | 8 | 5 | 20 | LE | PRE1, PRE2 | POS2

- Saídas esperadas:
  - LE: Lança exceção
  - NE: Não lança exceção
- Pré condições:
  - PRE1: o sistema solicita dados dos 4 atributos.
  - PRE2: O usuário inputa os dados dos 4 atributos.
- Pós-condições:
  - POS1: o sistema cria o personagem.
  - POS2: o sistema não cria o personagem.

### CT05: Determina quem ataca primeiro (RN05)
<a id="CT05"></a>

  | ID | Velocidade p1 | Velocidade p2 | Valor aleatório | Saída esperada | Pré-condição | Pós-condição |
  |-------------|-------------|-------------|-------------|-------------|-------------|-------------|
  | CT051 | 5 | 5 | 0 | P1 | PRE1, PRE2 |  |
  | CT052 | 5 | 5 | 1 | P2 | PRE1, PRE2 |  |
  | CT053 | 6 | 4 | - | P1 | PRE1, PRE2 |  |
  | CT053 | 3 | 8 | - | P2 | PRE1, PRE2 |  |

- Saídas esperadas:
  - P1: o personagem p1 deve atacar primeiro.
  - P2: o personagem p2 deve atacar primeiro.
- Pré condições:
  - PRE1: o sistema solicita valor do atributo velocidade para cada um dos personagens (respeitando RN01 e RN02).
  - PRE2: o usuário inputa os dados de velocidade de ambos os personagens.
- Pós-condições:

### CT06: Verificação de Evasão (RN06)
<a id="CT06"></a>

  | ID | Chance de evasão | Número Gerado aleatório | Saída Esperada | Pré-condição | Pós-condição |
  |-------------|-------------|-------------|-------------|-------------|-------------|
  | CT061 | 0 | 0 | AE | PRE1 | - |
  | CT062 | 1 | 0 | AE | PRE1 | - |
  | CT063 | 49 | 64 | ANE | PRE1 | - |
  | CT064 | 50 | 50 | AE | PRE1 | - |
  | CT065 | 51 | 100 | ANE | PRE1 | - |

- Saídas esperadas:
  - ANE: Ataque não evitado
  - AE: Ataque evitado
- Pré-condição:
  - PRE1: o sistema solicita valor do atributo velocidade para cada um dos personagens (respeitando RN01 e RN02).

### CT07: Checa se o ataque é um Golpe Crítico (RN07)
<a id="CT07"></a>
  | ID | Número aleatório gerado entre 1 e 100 | Saída Esperada | Pré-condição | Pós-condição |
  |-------------|-------------|-------------|-------------|-------------|
  | CT071 | 1 | T | PRE1, PRE2 | POS1 |
  | CT071 | 9 | T | PRE1, PRE2 | POS1 |
  | CT072 | 10 | T | PRE1, PRE2 |  |
  | CT073 | 11 | F | PRE1, PRE2 |  |
  | CT074 | 99 | F | PRE1, PRE2 |  |
  | CT075 | 100 | F | PRE1, PRE2 |  |

- Legenda:
  - PRE1: o sistema gerar um número aleatório entre 1 e 100.
  - PRE2: sistema ter o Dano Infringido calculado.
  - POS2: Dano Infringido *= 1.5

### CT08:  Checagem do Dano Base (RN08)
<a id="CT08"></a>

  | ID | Ataque | Modificador de ataque | Saída Esperada | Pré-condição | Pós-condição |
  |-------------|-------------|-------------|-------------|-------------|-------------|
  | CT081 | 5 | 0.7 | LE | PRE1, PRE2 |  |
  | CT082 | 4 | 0.8 | 3 | PRE1, PRE2 |  |
  | CT083 | 3 | 0.9 | 2 | PRE1, PRE2 |  |
  | CT084 | 3 | 1.1 | 3 | PRE1, PRE2 |  |
  | CT085 | 4 | 1.2 | 5 | PRE1, PRE2 |  |
  | CT086 | 5 | 1.3 | LE | PRE1, PRE2 |  |

- Saídas esperadas:
  - LE: lança exceção.
- Pré-condição:
  - PRE1: Valor arredondado para o inteiro mais próximo.
  - PRE2: o sistema tem armazenado o valor do atributo Ataque do personagem que está atacando.

### CT09:  Checagem do Dano Infringido (RN09)
<a id="CT09"></a>

  | ID | Dano Base | Ataque do Atacante | Defesa do Defensor | Cálculo do Dano Infringido | Saída Esperada | Pré-condição | Pós-condição |
  |-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------| 
  | CT091 | 3 | 3 | 7 | -1 | 1 | PRE1; PRE2; PRE3 |  |
  | CT092 | 4 | 4 | 8 | 0 | 1 | PRE1; PRE2; PRE3 |  |
  | CT093 | 5 | 4 | 8 | 1 | 1 | PRE1; PRE2; PRE3 |  |
  | CT094 | 6 | 4 | 8 | 2 | 2 | PRE1; PRE2; PRE3 |  |

- Legenda:
  - Saídas esperadas:
  - Pré-condição:
    - PRE1: O sistema calular o Dano Base.
    - PRE2: O sistema armazenar o Ataque do Atacante.
    - PRE3: O sistema armazenar a Defesa do Defensor

## Matriz de rastreabilidade
  | Partição / Critério | Casos de Teste Relacionados |
  |-------------|-------------|
  | Soma dos atributos < 20  | [CT011](#CT01), [CT013](#CT01) |
  | Soma dos atributos = 20 | [CT014](#CT01) |
  | Soma dos atributos > 20 | [CT015](#CT01), [CT016](#CT01) |
  | Soma dos atributos = 0 | [CT011](#CT01) |
  | Soma dos atributos = 1 | [CT012](#CT01) |
  | Soma dos atributos = 19 | [CT013](#CT01) |
  | Soma dos atributos = 21 | [CT015](#CT01) |
  | Soma dos atributos = 40 | [CT016](#CT01) |
  | Valor de atributo < 3 | [CT021](#CT02), [CT022](#CT02), [CT023](#CT02), [CT024](#CT02) |
  | Valor de atributo >= 3 | [CT022](#CT02), [CT023](#CT02), [CT024](#CT02), [CT025](#CT02), [CT026](#CT02) |
  | Valor de atributo = 0 | [CT021](#CT02), [CT022](#CT02), [CT023](#CT02) |
  | Valor de atributo = 2 | [CT024](#CT02) |
  | Valor de atributo = 3 | [CT023](#CT02), [CT024](#CT02) |
  | Valor de atributo = 4 | [CT024](#CT02) |
  | Valor de atributo = 19 | [CT022](#CT02) |
  | Valor de atributo = 20 | [CT023](#CT02) |
  | Valor de atributo = 21 | [CT026](#CT02) |
  | Valor Resistência < 3 | [CT021](#CT02) |
  | Resistência < 3 | [CT021](#CT02) |
  | Resistência >= 3, Ataque < 3 | [CT022](#CT02) |
  | Resistência >= 3, Ataque >= 3, Defesa < 3 | [CT023](#CT02) |
  | Resistência >= 3, Ataque >= 3, Defesa >= 3, Velocidade < 3 | [CT024](#CT02) |
  | Resistência >= 3, Ataque >= 3, Defesa >= 3, Velocidade >= 3 | [CT025](#CT02), [CT026](#CT02) |
  | Resistência > Ataque | [CT032](#CT03), [CT035](#CT03) |
  | Resistência = Ataque | [CT031](#CT03) |
  | Resistência < Ataque | [CT033](#CT03), [CT034](#CT03) |
  | Defesa <= (Resistência && Ataque) | [CT031](#CT03), [CT032](#CT03), [CT033](#CT03), [CT035](#CT03) |
  | Velocidade <= (Resistência && Ataque) | [CT031](#CT03), [CT032](#CT03), [CT033](#CT03) |
  | Velocidade > Ataque | [CT042](#CT04), [CT045](#CT04) |
  | Velocidade = Ataque | [CT041](#CT04) |
  | Velocidade < Ataque | [CT043](#CT04), [CT044](#CT04) |
  | Defesa <= (Velocidade && Ataque) | [CT041](#CT04), [CT042](#CT04) |
  | Resistência <= (Velocidade && Ataque) | [CT041](#CT04), [CT042](#CT04), [CT043](#CT04) |
  | Velocidade de p1 > Velocidade de p2 | [CT053](#CT05) |
  | Velocidade de p1 < Velocidade de p2 | [CT054](#CT05) |
  | Velocidade de p1 = Velocidade de p2 | [CT051](#CT05), [CT052](#CT05) |
  | Ordem aleatória decide p1 como primeiro | [CT051](#CT05) |
  | Ordem aleatória decide p2 como primeiro | [CT052](#CT05) |
  | Número gerado ≤ Chance de Evasão | [CT061](#CT06), [CT062](#CT06), [CT064](#CT06) |
  | Número gerado > Chance de Evasão | [CT063](#CT06), [CT065](#CT06) |
