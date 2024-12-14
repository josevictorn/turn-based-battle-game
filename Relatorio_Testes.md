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
  | Condições | Condição 1 | Condição 2 | Condição 3 |
  |-------------|-------------|-------------|-------------|
  | Soma total dos pontos = 20 | T | - | - |
  | Soma total dos pontos < 20 | - | T | - |
  | Soma total dos pontos > 20 | - | - | T|
  | Retorna exceção |  | X | X |
  | Não retorna exceção | X |  |  |

### RN02: Cada atributo deve ter no mínimo 3 pontos
- Partições:
  - [0, 3): O atributo tem potuação menor que 3.
  - [3, 20]: O atributo possui no mínimo 3 pontos.
- Valores limites:
  - Partição [0, 3): {0, 2}
  - Partição [3, 20]: {2, }

## Casos de teste
### CT01: Checar se o total de ponto alocados nos atributos é válido (RN01)
  | ID | Resistência | Ataque | Defesa | Velocidade | Total | Saída esperada | Pré-condição | Pós-condição |
  |-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|
  | CT011 | 0 | 0 | 0 | 0 | 0 | Lançar exceção | PRE1 | POS2
  | CT012 | 1 | 0 | 0 | 0 | 1 | Lançar exceção | PRE1 | POS2
  | CT013 | 5 | 5 | 5 | 4 | 19 | Lançar exceção | PRE1 | POS2
  | CT014 | 5 | 5 | 5 | 5 | 20 | Não lançar exceção | PRE1 | POS1
  | CT015 | 5 | 6 | 5 | 5 | 21 | Lançar exceção | PRE1 | POS2
  | CT016 | 10 | 10 | 10 | 10 | 40 | Lançar exceção | PRE1 | POS2

- Pré condições:
  - PRE1: o sistema realiza a soma dos pontos dos atributos
- Pós-condições:
  - POS1: o sistema cria o personagem
  - POS2: o sistema não cria o personagem
  