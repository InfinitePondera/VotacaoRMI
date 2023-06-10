package Runnable;

import Impl.ClientImpl;
import Interface.ServerInterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.util.Scanner;

public class ElectionClient {
    public static void main(String[] args) {
        try {
            Integer voto = 0;
            ServerInterface server = (ServerInterface) Naming.lookup("rmi://localhost/ElectionServer");
            ClientImpl client = new ClientImpl(server);
            Scanner in = new Scanner(System.in);

            while (true) {
                System.out.println("Digite o seu voto: ");
                System.out.println("// Julio Iglesias - 1");
                System.out.println("// Freddy Mercury - 2");
                System.out.println("// José da Manga - 3");
                voto = in.nextInt();
                switch(voto) {
                    case 1:
                        client.sendVote("Julio Iglesias", 1);
                        break;
                    case 2:
                        client.sendVote("Freddy Mercury", 1);
                        break;
                    case 3:
                        client.sendVote("José da Manga", 1);
                        break;
                    default:
                        System.out.println("Erro inesperado, voto não computado");
                        break;
                }
            }

        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e);
            e.printStackTrace();
        }
    }
}
