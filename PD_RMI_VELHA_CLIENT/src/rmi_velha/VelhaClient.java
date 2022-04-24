package rmi_velha;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

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
				System.out.print(tab[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		Jogada(jogador);
		server.SetBoard(tab);
	}

	public void Jogada(int jogador) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Selecione uma linha 0 1 2");
		int linha = keyboard.nextInt();
		System.out.println("Selecione uma coluna 0 1 2");
		int coluna = keyboard.nextInt();
		tab[linha][coluna] = jogador;
	}

}
