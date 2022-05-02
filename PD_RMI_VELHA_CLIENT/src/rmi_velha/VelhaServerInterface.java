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
	 * -> Dizer se pode ou não pode marcar certo local do tabuleiro (talvez dê pra deixar essa lógica no client)
	 * -> Saber que devem ter no mínimo e no máximo 2 jogadores pra poder começar o jogo (e poder jogar)
	 * -> Identificar o ganhador e terminar.
	 */
}
