package batalha;

public class Assassino extends Personagem {

	public Assassino(Integer ataque, Integer defesa, Integer velocidade, Integer resistencia) {
		super(ataque, defesa, velocidade, resistencia);
	}

	@Override
	final void checarRegraDeClasse() {
		if((this.getDefesa() > (this.getVelocidade())) & (this.getDefesa() > this.getAtaque())) {
			throw new IllegalStateException("O atributo Defesa não pode ultrapassar os atributos Resistência e Ataque.");
		}
		
		if((this.getResistencia() > this.getVelocidade()) & (this.getResistencia() > this.getAtaque())) {
			throw new IllegalStateException("O atributo Velocidade não pode ultrapassar os atributos Resistência e Ataque.");
		}
	}
}
