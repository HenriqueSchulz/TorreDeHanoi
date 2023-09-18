package entidades;

import java.util.Random;

public class Controlador {
	
	private ListaTorres torres =  new ListaTorres();
	private Integer modoDeJogo;
	private int tentativas = 0;
	
	public Controlador(){}
	
	public void iniciar(Torre torre, int modoDeJogo) {
		
		Random random = new Random();
		int[] vetorNumerosAleatorios = new int[torre.getTamanho()];
		int numeroAleatorio;
		
		for(int i = 0; i < torre.getTamanho(); i++) {
			
			numeroAleatorio =  random.nextInt(100) + 1;
			vetorNumerosAleatorios[i] = numeroAleatorio;
			
		}
		
		vetorNumerosAleatorios = ordenar(vetorNumerosAleatorios, torre.getTamanho());
		
		if(modoDeJogo == 1) {
			
			for(int i = torre.getTamanho()-1; i >= 0; i--) {
				torre.inserir(vetorNumerosAleatorios[i]);	
			}	
			
		} else {
			for(int i = 0; i < torre.getTamanho(); i++) {
				torre.inserir(vetorNumerosAleatorios[i]);
			}
		}
		
		this.modoDeJogo = modoDeJogo;
		inserirTorre(torre);
	}
	
	public void inserirTorre(Torre torre) {

		torres.inserir(new NodeLista(torre));
		
	}
	
	public void imprimirJogo(int tamanho) {
		
		System.out.println();
		
		Torre torre1 = torres.getPrimeiro().getTorre();
		Torre torre2 = torres.getPrimeiro().getProximo().getTorre();
		Torre torre3 = torres.getUltimo().getTorre();
		
		NodeTorre elementoTorre1 = torre1.getTopo();
		NodeTorre elementoTorre2 = torre2.getTopo();
		NodeTorre elementoTorre3 = torre3.getTopo();
		
		for(int i = 0; i < tamanho; i++) {
			
			if(elementoTorre1 == null) {
				System.out.print(".  ");
			} else {
				System.out.print(elementoTorre1.getDado() + " ");
			}
			
			if(elementoTorre2 == null) {
				System.out.print(".  ");
			} else {
				System.out.print(elementoTorre2.getDado() + " ");
			}
			
			if(elementoTorre3 == null) {
				System.out.print(".");
			} else {
				System.out.print(elementoTorre3.getDado());
			}
			
			System.out.print("\n");
			
			if(elementoTorre1 != null) elementoTorre1 = elementoTorre1.getProximo();
			if(elementoTorre2 != null) elementoTorre2 = elementoTorre2.getProximo();
			if(elementoTorre3 != null) elementoTorre3 = elementoTorre3.getProximo();
			
		}
		
		System.out.println("T1 T2 T3");
		System.out.println("\n***************");
		System.out.println("Tentativas: " + tentativas);
		
	}
	
	public Integer getTopoTorre(int numTorre) {
		
		Integer peca;
		
		switch(numTorre) {
		case 1:
			peca = torres.getPrimeiro().getDadoTopo();
			break;
		case 2: 
			peca = torres.getPrimeiro().getProximo().getDadoTopo();
			break;
		case 3:
			peca = torres.getUltimo().getDadoTopo();
			break;
		default:
			System.out.println("Torre invalida");
			return 1000;
		}
		
		return peca;
		
	}
	
	public boolean mover(int numTorre1, int numTorre2) {
		
		tentativas ++;
		
		Integer peca1;
		Integer peca2;
		
		peca1 = getTopoTorre(numTorre1);
		peca2 = getTopoTorre(numTorre2);
		
		if(validarJogada(peca1, peca2)) {
			remover(numTorre1);
			adicionar(numTorre2, peca1);
		}
		
		System.out.println("***************");
		
		if(torres.getUltimo().getTorre().cheia()) {
			return false;
		}
		return true;
		
	}
	
	public void adicionar(int numTorre, int peca) {
		
		if(numTorre == 1) {
			torres.getPrimeiro().torre.inserir(peca);
		} else if (numTorre == 2) {
			torres.getPrimeiro().getProximo().torre.inserir(peca);
		} else {
			torres.getUltimo().torre.inserir(peca);
		}
		
	}
	
	public void remover(int numTorre) {
		
		if(numTorre == 1) {
			torres.getPrimeiro().torre.remover();
		} else if (numTorre == 2) {
			torres.getPrimeiro().getProximo().torre.remover();
		} else {
			torres.getUltimo().torre.remover();
		}
		
	}
	
	public boolean validarJogada(int peca1, int peca2) {
		if(peca1 == -1) {
			System.out.println("Movimento invalido!");
			return false;
		}
		
		if(modoDeJogo == 1) {
			
			if(peca1 > peca2 && peca2 != -1) {
				System.out.println("Movimento invalido!");
				return false;
				
			} else {
				return true;
			}
			
		} else {
			
			if(peca1 < peca2 && peca2 != -1) {
				System.out.println("Movimento invalido!");
				return false;
				
			} else {
				return true;
				
			}
			
		}
		
	}
	
	public void resolverHanoi(int tamanho, int origem, int destino, int auxiliar, int tamanhoFixo) {
		if(tamanho == 1) {
			mover(origem, destino);
			imprimirJogo(tamanhoFixo);
		} else {
			resolverHanoi(tamanho-1, origem, auxiliar, destino, tamanhoFixo);
			mover(origem, destino);
			imprimirJogo(tamanhoFixo);
			resolverHanoi(tamanho-1, auxiliar, destino, origem, tamanhoFixo);
		}
	}
	
	public int[] ordenar(int[] vetor, int tamanho) {
		
		int numAtual;
		int numMenor;
		int index = 0;
		
		for(int i = 0; i < tamanho; i++) {
			
			numAtual = vetor[i];
			numMenor = vetor[i];
			
			for(int p = i+1; p < tamanho; p++){
				if(vetor[p] < numMenor) {
					numMenor = vetor[p];
					index = p;
				}
			}
			
			if(numMenor != numAtual) {
				vetor[index] = vetor[i];
				vetor[i] = numMenor;
			}	
		}
		
		return vetor;
	}
	
}
