package vintageGroove;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String tipo;

        System.out.println("**********************************************************************");
        System.out.println("Bem-Vindo à Vintage Groove!");
        System.out.println("**********************************************************************");

        int op;
        do {
            System.out.println("\nSelecione uma opção: ");
            System.out.println("1 - Cadastrar Disco/CD");
            System.out.println("2 - Listar todos os Discos/CDs");
            System.out.println("3 - Consultar Disco ou CD por Nome");
            System.out.println("4 - Consultar Disco ou CD por Id");
            System.out.println("5 - Atualizar Disco ou CD");
            System.out.println("6 - Deletar Disco ou CD");
            System.out.println("0 - Sair");

            System.out.println("Selecione uma opção: ");
            op = scan.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Cadastrar Disco ou CD");
                    System.out.println("Digite o tipo (Disco ou CD): ");
                    tipo = scan.next();

                    if (tipo.equalsIgnoreCase("Disco")) {
                        System.out.println("Você escolheu cadastrar um Disco.");
                    } else if (tipo.equalsIgnoreCase("CD")) {
                        System.out.println("Você escolheu cadastrar um CD.");
                    } else {
                        System.out.println("Tipo inválido. Escolha entre Disco ou CD.");
                    }
                    break;

                case 2:
                    System.out.println("Listar Discos e CDs");
                    break;

                case 3:
                    System.out.println("Consultar Disco ou CD por Nome");
                    System.out.println("Digite o tipo (Disco ou CD): ");
                    tipo = scan.next();
                    break;

                case 4:
                    System.out.println("Consultar Disco ou CD por Id");
                    System.out.println("Digite o tipo (Disco ou CD): ");
                    tipo = scan.next();
                    break;

                case 5:
                    System.out.println("Atualizar Disco ou CD");
                    System.out.println("Digite o tipo (Disco ou CD): ");
                    tipo = scan.next();
                    break;

                case 6:
                    System.out.println("Deletar Disco ou CD");
                    System.out.println("Digite o tipo (Disco ou CD): ");
                    tipo = scan.next();                   
                    break;

                case 0:
                    System.out.println("Sair");
                    break;

                default:
                    System.out.println("Opção Inválida! Tente novamente.");
            }

        } while (op != 0);
    }
}

