package view;

import java.util.Hashtable;
import java.util.Scanner;

import model.*;

public class App {
    public static void main(String[] args) throws Exception {
   
    Hashtable<String, Avaliacao> hashAval = new Hashtable<>();
    Scanner teclado = new Scanner(System.in);
    String entrada;
    int flag = 1;

    Status.leitor(hashAval);

        do{
            Status.Menu();
            entrada = teclado.nextLine();
            switch (entrada) {
                case "1":
                    Status.InserirAval(teclado, hashAval);
                    break;
                case "2":
                    Status.remover(teclado, hashAval);
                    break;
                case "0":
                    flag = 0;
                    break;
                default:
                    System.out.println("Entrada inválida");
                    break;
            }
        }while(flag!=0);
    }
}
