package rmi_velha;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VelhaServerInterface extends Remote{
	
	public void RegisterClient(VelhaClientInterface client) throws RemoteException;
	public void SetBoard(int [][] board) throws RemoteException;
	public void SetWinner(int jogador) throws RemoteException;
	/*
	 * Precisa de uma maneira de:
	 * -> Salvar as jogadas e passar para o outro jogador
	 * -> Dizer se pode ou n�o pode marcar certo local do tabuleiro (talvez d� pra deixar essa l�gica no client)
	 * -> Saber que devem ter no m�nimo e no m�ximo 2 jogadores pra poder come�ar o jogo (e poder jogar)
	 * -> Identificar o ganhador e terminar.
	 */
}
