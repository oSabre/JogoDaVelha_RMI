package rmi_velha;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VelhaClientInterface extends Remote {
	// Vai precisar de uma fun��o pra imprimir o tabuleiro
	public void PrintBoard(int[][] board, int jogador, VelhaServerInterface server) throws RemoteException;
	
	// TALVEZ (N�o tenho certeza): Fun��o pra imprimir se ganhou ou perdeu
	
}
