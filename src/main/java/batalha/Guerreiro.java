package batalha;

public class Guerreiro extends Personagem {

	public Guerreiro(Integer resistencia, Integer ataque, Integer defesa, Integer velocidade) {
		super(resistencia, ataque, defesa, velocidade);
	}

	@Override
	final void checarRegraDeClasse() {
		if((this.getDefesa() > (this.getResistencia())) & (this.getDefesa() > this.getAtaque())) {
			throw new IllegalStateException("O atributo Defesa não pode ultrapassar os atributos Resistência e Ataque.");
		}
		
		if((this.getVelocidade() > this.getResistencia()) & (this.getVelocidade() > this.getAtaque())) {
			throw new IllegalStateException("O atributo Velocidade não pode ultrapassar os atributos Resistência e Ataque.");
		}
	}

}
