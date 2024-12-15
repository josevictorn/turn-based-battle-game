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

## Casos de teste
### CT01: Checar se o total de ponto alocados nos atributos é válido (RN01) e 
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

## Matriz de rastreabilidade
  | Partição / Critério | Casos de Teste Relacionados |
  |-------------|-------------|
  | Soma dos atributos < 20  | CT011, CT013 |
  | Soma dos atributos = 20 | CT014 |
  | Soma dos atributos > 20 | CT015, CT016 |
  | Soma dos atributos = 0 | CT011 |
  | Soma dos atributos = 1 | CT012 |
  | Soma dos atributos = 19 | CT013 |
  | Soma dos atributos = 21 | CT015 |
  | Soma dos atributos = 40 | CT016 |
  | Valor de atributo < 3 | CT021, CT022, CT023, CT024 |
  | Valor de atributo >= 3 | CT022, CT023, CT024, CT025, CT026 |
  | Valor de atributo = 0 | CT021, CT022, CT023 |
  | Valor de atributo = 2 | CT024 |
  | Valor de atributo = 3 | CT023, CT024 |
  | Valor de atributo = 4 | CT024 |
  | Valor de atributo = 19 | CT022 |
  | Valor de atributo = 20 | CT023 |
  | Valor de atributo = 21 | CT026 |
  | Valor Resistência < 3 | CT021 |
  | Resistência < 3 | CT021 |
  | Resistência >= 3, Ataque < 3 | CT022 |
  | Resistência >= 3, Ataque >= 3, Defesa < 3 | CT023 |
  | Resistência >= 3, Ataque >= 3, Defesa >= 3, Velocidade < 3 | CT024 |
  | Resistência >= 3, Ataque >= 3, Defesa >= 3, Velocidade >= 3 | CT025, CT026 |
  | Resistência > Ataque | CT032, CT035 |
  | Resistência = Ataque | CT031 |
  | Resistência < Ataque | CT033, CT034 |
  | Defesa <= (Resistência && Ataque) | CT031, CT032, CT033, CT035 |
  | Velocidade <= (Resistência && Ataque) | CT031, CT032, CT033 |
  | Velocidade > Ataque | CT042, CT045 |
  | Velocidade = Ataque | CT041 |
  | Velocidade < Ataque | CT043, CT044 |
  | Defesa <= (Velocidade && Ataque) | CT041, CT042 |
  | Resistência <= (Velocidade && Ataque) | CT041, CT042, CT043 |
  | Velocidade de p1 > Velocidade de p2 | CT053 |
  | Velocidade de p1 < Velocidade de p2 | CT054 |
  | Velocidade de p1 = Velocidade de p2 | CT051, CT052 |
  | Ordem aleatória decide p1 como primeiro | CT051 |
  | Ordem aleatória decide p2 como primeiro | CT052 |
