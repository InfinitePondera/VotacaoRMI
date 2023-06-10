package Impl;
import Interface.ServerInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {
    private Map<String, Integer> voteCount;

    public ServerImpl() throws RemoteException {
        super();
        voteCount = new HashMap<>();
    }

    @Override
    public void receiveVote(String candidateName, int numVotes) throws RemoteException {
        voteCount.put(candidateName, voteCount.getOrDefault(candidateName, 0) + numVotes);
    }

    @Override
    public Map<String, Integer> countVotes() throws RemoteException {
        return voteCount;
    }

    @Override
    public void displayVoteCount(Map<String, Integer> voteCount) throws RemoteException {
        // Exibir a apuração de votos atualizada
        System.out.println("Apuração de votos:");
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            String candidateName = entry.getKey();
            int numVotes = entry.getValue();
            System.out.println(candidateName + ": " + numVotes + " votos");
        }
        System.out.println();
    }
}
