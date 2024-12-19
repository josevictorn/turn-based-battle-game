package batalha;

import static java.lang.Math.min;

import java.security.SecureRandom;

public class Batalha {

	private final Personagem primeiroAtacante;

	private final Personagem segundoAtacante;
	
	private final SecureRandom geradorRandomico;

	Batalha(Personagem p1, Personagem p2, int randomico) {
		this.geradorRandomico = new SecureRandom();
		
		if (p1.getVelocidade() > p2.getVelocidade()) {
			this.primeiroAtacante = p1;
			this.segundoAtacante = p2;
		} else if (p1.getVelocidade() < p2.getVelocidade()) {
			this.primeiroAtacante = p2;
			this.segundoAtacante = p1;
		} else {
			if (randomico == 0) {
				this.primeiroAtacante = p1;
				this.segundoAtacante = p2;
			} else {
				this.primeiroAtacante = p2;
				this.segundoAtacante = p1;
			}
		}
	}

	public Batalha(Personagem p1, Personagem p2) {
		this(p1, p2, new SecureRandom().nextInt(2));
	}

	public void realizarPrimeiroAtaque() {
		realizarAtaque(primeiroAtacante, segundoAtacante);
	}
	
	public void realizarSegundoAtaque() {
		realizarAtaque(segundoAtacante, primeiroAtacante);
	}

	private void realizarAtaque(Personagem atacante, Personagem defensor) {
		int chanceEvasao = calcularChanceEvasao(atacante, defensor);
		int randomicoEvasao = geradorRandomico.nextInt(100);
		
		
		if(this.evadiu(chanceEvasao, randomicoEvasao)) {
			// Informar que evadiu
		}
		else {
			double modificadorAtaque = 0.8 + (geradorRandomico.nextDouble() * (0.4));
			boolean eGolpeCritico = verificarSeGolpeCritico();
			
			atacante.atacar(defensor, modificadorAtaque, eGolpeCritico);
		}
	}
	//Método para verificar se o golpe é critico, criado para facilitar a realização dos teste usando sobrecarga 
     public boolean verificarSeGolpeCritico(){
		return  geradorRandomico.nextInt(1, 101) <= 10;
	 }
	//Método obrecarregado para verificar se é golpe critico nos testes
	public boolean verificarSeGolpeCritico(Integer randomico){
			return  randomico <= 10;
	 }

	boolean evadiu(int chanceEvasao, int randomico) {
		return randomico <= chanceEvasao;
	}
	

	int calcularChanceEvasao(Personagem atacante, Personagem defensor) {
		return Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());
	}

	static int calcularChanceEvasao(int velocidadeAtacante, int velocidadeDefensor) {
		int chanceEvasao = min(50, (velocidadeDefensor - velocidadeAtacante) * 2);
		return chanceEvasao < 0 ? 0 : chanceEvasao;
	}

	public boolean temVencedor() {
		// TODO implementar a lógica
		return false;
	}

	public Personagem getPrimeiroAtacante() {
		return primeiroAtacante;
	}

	public Personagem getSegundoAtacante() {
		return segundoAtacante;
	}

}
