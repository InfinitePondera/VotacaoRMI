package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface ServerInterface extends Remote {
    void receiveVote(String candidateName, int numVotes) throws RemoteException;
    Map<String, Integer> countVotes() throws RemoteException;

    void displayVoteCount(Map<String, Integer> voteCount) throws RemoteException;
}