package vintageGroove;

import java.util.InputMismatchException;
import java.util.Scanner;
import vintageGroove.controller.ProdutoController;
import vintageGroove.model.CD;
import vintageGroove.model.Disco;
import vintageGroove.model.Produto;

public class Menu {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ProdutoController controller = new ProdutoController();

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
            scan.nextLine(); // Consumir a quebra de linha pendente

            switch (op) {
                case 1:
                    cadastrarDiscoOuCD(scan, controller);
                    break;

                case 2:
                    System.out.println("Listar Discos e CDs");
                    controller.listarTodos();
                    break;

                case 3:
                    consultarPorNome(scan, controller);
                    break;

                case 4:
                    consultarPorId(scan, controller);
                    break;

                case 5:
                    System.out.println("Atualizar Disco ou CD");
                    System.out.println("Digite o ID: ");
                    int idAtualizar = scan.nextInt();
                    Produto produtoAtualizar = controller.consultarPorId(idAtualizar);
                    if (produtoAtualizar != null) {
                        controller.atualizarProduto(produtoAtualizar);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Deletar Disco ou CD");
                    System.out.println("Digite o ID: ");
                    int idDeletar = scan.nextInt();
                    controller.deletarProduto(idDeletar);
                    break;

                case 0:
                    System.out.println("Finalizando.... ");
                    System.out.println("Obrigada por utilizar o sistema!");
                    sobre();
                    break;

                default:
                    System.out.println("Opção Inválida! Tente novamente.");
            }

        } while (op != 0);
    }

    private static void cadastrarDiscoOuCD(Scanner scan, ProdutoController controller) {
        System.out.println("Cadastrar Disco ou CD");
        System.out.println("Digite o tipo (Disco ou CD): ");
        String tipo = scan.next();

        if (tipo.equalsIgnoreCase("Disco")) {
            cadastrarDisco(scan, controller);
        } else if (tipo.equalsIgnoreCase("CD")) {
            cadastrarCD(scan, controller);
        } else {
            System.out.println("Tipo inválido. Escolha entre Disco ou CD.");
        }
    }

    private static void cadastrarDisco(Scanner scan, ProdutoController controller) {
        int id = lerId(scan, controller);
        System.out.println("Digite o nome: ");
        String nome = scan.nextLine();
        System.out.println("Digite o artista: ");
        String artista = scan.nextLine();

        float preco = 0;
        boolean precoValido = false;
        while (!precoValido) {
            try {
                System.out.println("Digite o preço: ");
                preco = Float.parseFloat(scan.nextLine());
                precoValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um valor numérico para o preço.");
            }
        }

        System.out.println("Digite o gênero: ");
        String genero = scan.nextLine();

        Disco disco = new Disco(id, nome, artista, preco, genero);
        controller.cadastrarProduto(disco);
    }

    private static void cadastrarCD(Scanner scan, ProdutoController controller) {
        int id = lerId(scan, controller);
        System.out.println("Digite o nome: ");
        String nome = scan.nextLine();
        System.out.println("Digite o artista: ");
        String artista = scan.nextLine();

        float preco = 0;
        boolean precoValido = false;
        while (!precoValido) {
            try {
                System.out.println("Digite o preço: ");
                preco = Float.parseFloat(scan.nextLine());
                precoValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um valor numérico para o preço.");
            }
        }

        int numFaixas = 0;
        boolean numFaixasValido = false;
        while (!numFaixasValido) {
            try {
                System.out.println("Digite o número de faixas: ");
                numFaixas = Integer.parseInt(scan.nextLine());
                numFaixasValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um valor numérico para o número de faixas.");
            }
        }

        CD cd = new CD(id, nome, artista, preco, numFaixas);
        controller.cadastrarProduto(cd);
    }


    private static void consultarPorNome(Scanner scan, ProdutoController controller) {
        System.out.println("Consultar Disco ou CD por Nome");
        System.out.println("Digite o nome: ");
        String nomeConsulta = scan.nextLine();
        controller.consultarPorNome(nomeConsulta);
    }

    private static void consultarPorId(Scanner scan, ProdutoController controller) {
        System.out.println("Consultar Disco ou CD por Id");
        int idConsulta = lerIdConsulta(scan);
        Produto produtoConsulta = controller.consultarPorId(idConsulta);
        if (produtoConsulta != null) {
            produtoConsulta.visualizar();
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static int lerIdConsulta(Scanner scan) {
        int id = -1;

        while (true) {
            try {
                System.out.println("Digite o ID: ");
                id = scan.nextInt();
                scan.nextLine(); // Consumir a quebra de linha pendente
                break; // Saímos do loop, não precisamos verificar a existência
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
                scan.nextLine(); // Consumir entrada inválida
            }
        }

        return id;
    }

    private static int lerId(Scanner scan, ProdutoController controller) {
        int id = -1;
        boolean idValido = false;

        while (!idValido) {
            System.out.println("Digite o ID: ");
            try {
                id = scan.nextInt();
                scan.nextLine(); // Consumir a quebra de linha pendente

                boolean idExistente = controller.verificarIdExistente(id);

                if (!idExistente) {
                    idValido = true;
                } else {
                    System.out.println("ID já existe. Por favor, escolha um ID único.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
                scan.nextLine();
            }
        }

        return id;
    }
    
	public static void sobre() {
	System.out.println("\n*********************************************************");
	System.out.println("Projeto Desenvolvido por: ");
	System.out.println("Talia Moura - talia.dev@outlook.com");
	System.out.println("GitHub:     - github.com/TahMoura");
	System.out.println("*********************************************************");
	}
}
