package vintageGroove.repository;

import vintageGroove.model.Produto;

public interface ProdutoRepository {

    // CRUD do Produto
    void consultarProdutoPorId(int id);
    void listarTodos();
    void cadastrar(Produto produto);
    void atualizar(Produto produto);
    void deletar(int id);
    
    // Métodos específicos para Produto
    void visualizarDetalhes(int id);
    void consultarPorNome(String nome);
    void consultarPorTipo(String tipo);
    void atualizarPorTipo(String tipo, Produto produto);
    void deletarPorTipo(String tipo, int id);
}
