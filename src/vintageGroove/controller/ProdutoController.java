package vintageGroove.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vintageGroove.model.CD;
import vintageGroove.model.Disco;
import vintageGroove.model.Produto;

public class ProdutoController {

    private List<Produto> produtos;

    public ProdutoController() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void listarTodos() {
        for (Produto produto : produtos) {
            produto.visualizar();
        }
    }

    public Produto consultarPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public void consultarPorNome(String nome) {
        boolean encontrado = false;
        for (Produto produto : produtos) {
            if (produto.getNome().trim().equalsIgnoreCase(nome.trim())) {
                produto.visualizar();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Produto não encontrado.");
        }
    }

    public void atualizarProduto(Produto produtoAtualizar) {
        int index = produtos.indexOf(produtoAtualizar);
        if (index != -1) {
            Produto produtoNovo = solicitarDadosAtualizacao(produtoAtualizar);
            produtos.set(index, produtoNovo);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void deletarProduto(int id) {
        Produto produto = consultarPorId(id);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto deletado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public boolean verificarIdExistente(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private Produto solicitarDadosAtualizacao(Produto produtoAtualizar) {
        Scanner scan = new Scanner(System.in);
        Produto produtoNovo;

        if (produtoAtualizar instanceof Disco) {
            Disco discoAtualizar = (Disco) produtoAtualizar;
            System.out.println("Digite o novo gênero: ");
            String novoGenero = scan.next();
            produtoNovo = new Disco(discoAtualizar.getId(), discoAtualizar.getNome(), discoAtualizar.getArtista(),
                    discoAtualizar.getPreco(), novoGenero);
        } else if (produtoAtualizar instanceof CD) {
            CD cdAtualizar = (CD) produtoAtualizar;
            System.out.println("Digite o novo número de faixas: ");
            int novoNumFaixas = scan.nextInt();
            produtoNovo = new CD(cdAtualizar.getId(), cdAtualizar.getNome(), cdAtualizar.getArtista(),
                    cdAtualizar.getPreco(), novoNumFaixas);
        } else {
            // Se for um tipo desconhecido, criar um novo Produto com os mesmos dados
            produtoNovo = new Produto(produtoAtualizar.getId(), produtoAtualizar.getNome(),
                    produtoAtualizar.getArtista(), produtoAtualizar.getPreco());
        }

        return produtoNovo;
    }
}