package rmi_velha;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

@SuppressWarnings("serial")
public class VelhaClient extends UnicastRemoteObject implements VelhaClientInterface{
	volatile private int tab[][] = new int [3][3];
	
	protected VelhaClient() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void PrintBoard(int[][] board, int jogador, VelhaServerInterface server) throws RemoteException {
		tab = board;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(tab[i][j] == 0) {
					System.out.print(" ");
				}
				else if(tab[i][j] == 1) {
					System.out.print("X");
				}
				else if(tab[i][j] == 2) {
					System.out.print("O");
				}
				if(j < 2) {
					System.out.print("|");
				}
				else {
					System.out.println();
				}
			}
			if(i < 2) {
				System.out.println("-.-.-");
			}
			else {
				System.out.println();
			}
		}
		System.out.println();
		Jogada(jogador, server);
		server.SetBoard(tab);
	}

	public void Jogada(int jogador,  VelhaServerInterface server) throws RemoteException {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Selecione uma linha 0 1 2");
		int linha = keyboard.nextInt();
		System.out.println("Selecione uma coluna 0 1 2");
		int coluna = keyboard.nextInt();
		if(linha > 2 || linha < 0 || coluna > 2 || coluna < 0 || tab[linha][coluna] != 0) {
			System.out.println("Posição Incorreta!");
			Jogada(jogador, server);
		}
		else {
			tab[linha][coluna] = jogador;
		}
		Verifica(jogador, linha, coluna, server);
		//keyboard.close();
		
		
	}
	
	public void Verifica(int jogador, int linha, int coluna, VelhaServerInterface server) throws RemoteException {
		if (tab[0][coluna] == tab[1][coluna] && tab[1][coluna] == tab[2][coluna]){
			server.SetWinner(jogador);
		}
		if (tab[linha][0] == tab[linha][1] && tab[linha][1] == tab[linha][2]){
			server.SetWinner(jogador);
		}
		if((linha + coluna) == 2){
			if(tab[0][2] == tab[1][1] && tab[1][1] == tab[2][0]){
				server.SetWinner(jogador);
			}
		}
		if(linha == coluna){
			if(tab[0][0] == tab[1][1] && tab[1][1] == tab[2][2]){
				server.SetWinner(jogador);
			}
		}
	}
	
	@Override
	public void PrintWin(int jogador, int[][] board) throws RemoteException {
		System.out.println("O jogador nº" + jogador +" venceu!");
		tab = board;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(tab[i][j] == 0) {
					System.out.print(" ");
				}
				else if(tab[i][j] == 1) {
					System.out.print("X");
				}
				else if(tab[i][j] == 2) {
					System.out.print("O");
				}
				if(j < 2) {
					System.out.print("|");
				}
				else {
					System.out.println();
				}
			}
			if(i < 2) {
				System.out.println("-.-.-");
			}
			else {
				System.out.println();
			}
		}
		System.out.println();
	}
	@Override
	public void PrintVelha(int[][] board) throws RemoteException {
		System.out.println("O jogo terminou empatado!");
		tab = board;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(tab[i][j] == 0) {
					System.out.print(" ");
				}
				else if(tab[i][j] == 1) {
					System.out.print("X");
				}
				else if(tab[i][j] == 2) {
					System.out.print("O");
				}
				if(j < 2) {
					System.out.print("|");
				}
				else {
					System.out.println();
				}
			}
			if(i < 2) {
				System.out.println("-.-.-");
			}
			else {
				System.out.println();
			}
		}
		System.out.println();
	}
}
