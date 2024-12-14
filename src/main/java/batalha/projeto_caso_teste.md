# Trabalho Prático: Implementação e Teste de um (Pseudo) Jogo de Batalha por Turnos

## Documentação das Regras de Negócio
### RN01: Cada personagem começa com 20 pontos para distribuir entre os atributos.
- Partições:
  - [0, 20): a soma dos pontos é menor que 20 
  - [20]: a soma dos pontos alocados nos atributos é igual a 20.
  - (20, ∞): a soma dos ponto é maior que 20.
- Valores limites:
  - Partição [0, 20): {0, 19}
  - Partição [20]: {20}
  - Partição (20, ∞): {21, 40}
- Tabelas de decisão:
  | Condições | Condição 1 | Condição 2 | Condição 3 |
  |-------------|-------------|-------------|-------------|
  | Soma total dos pontos = 20 | T | - | - |
  | Soma total dos pontos < 20 | - | T | - |
  | Soma total dos pontos > 20 | - | - | T|
  | Retorna exceção |  | X | X |
  | Não retorna exceção | X |  |  |


## Casos de teste
### CT01: Checar se o total de ponto alocados nos atributos é válido (RN01)
  | ID | Resistência | Ataque | Defesa | Velocidade | Total | Saída esperada | Pré-condição | Pós-condição |
  |-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|
  | CT011 | 0 | 0 | 0 | 0 | 0 | Lançar exceção | PRE1 | POS2
  | CT012 | 5 | 5 | 5 | 4 | 19 | Lançar exceção | PRE1 | POS2
  | CT013 | 5 | 5 | 5 | 5 | 20 | Não lançar exceção | PRE1 | POS1
  | CT014 | 5 | 6 | 5 | 5 | 21 | Lançar exceção | PRE1 | POS2
  | CT015 | 10 | 10 | 10 | 10 | 40 | Lançar exceção | PRE1 | POS2

- Pré condições:
  - PRE1: o sistema realiza a soma dos pontos dos atributos
- Pós-condições:
  - POS1: o sistema cria o personagem
  - POS2: o sistema não cria o personagem
  