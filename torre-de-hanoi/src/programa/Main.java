package programa;

import java.util.Scanner;

import entidades.Torre;
import entidades.Controlador;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Controlador configurarJogo = new Controlador();
		int numPecas = 0;
		int modoJogo = 0;
		int escolhaManualAutomatico = 0;
		String modoJogoStr;
		
		System.out.println("-- Torre de Hanoi --\n");
		System.out.println("Escolha com quantos elementos deseja jogar:");
		System.out.println(".3");
		System.out.println(".5");
		System.out.println(".7");
		System.out.println(".8");
		
		numPecas = sc.nextInt();
		
		System.out.println("\nEscolha a forma de jogo:");
		System.out.println("1. Crescente");
		System.out.println("2 .Decrescente");
		
		modoJogo = sc.nextInt();
		
		if(modoJogo == 1) {
			modoJogoStr = "Crescente";
		} else {
			modoJogoStr = "Decrescente";
		}
		
		System.out.printf("\n\nSelecionado: %d pecas, %s\n", numPecas, modoJogoStr);
		
		Torre torre1 = new Torre(numPecas);
		Torre torre2 = new Torre(numPecas);
		Torre torre3 = new Torre(numPecas);
		
		configurarJogo.iniciar(torre1, modoJogo);
		configurarJogo.inserirTorre(torre2);
		configurarJogo.inserirTorre(torre3);
		
		System.out.println("1. Jogar manualmente");
		System.out.println("2. Resolucao automatica");
		
		escolhaManualAutomatico = sc.nextInt();
		
		if(escolhaManualAutomatico == 1) {
			
			Integer t1;
			Integer t2;
			
			configurarJogo.imprimirJogo(numPecas);
			
			boolean condicaoVitoria = true;
			
			while(condicaoVitoria) {
				
				System.out.print("Mover de: ");
				t1 = sc.nextInt();
				System.out.print("Para: ");
				t2 = sc.nextInt();
				
				condicaoVitoria = configurarJogo.mover(t1,t2);
				configurarJogo.imprimirJogo(numPecas);
				
			}
		}
		
		else {
			
			configurarJogo.resolverHanoi(numPecas, 1, 3, 2, numPecas);
			
		}
		
		System.out.println("\nParabens voce ganhou!");
				
		sc.close();
	}
}