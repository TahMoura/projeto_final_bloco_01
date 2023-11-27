package vintageGroove.model;

public class Produto {
  
    private int id;
    private String nome;
    private String artista;
    private float preco;

    public Produto(int id, String nome, String artista, float preco) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void visualizar() {
        System.out.println("\n\n************************************************************");
        System.out.println("Detalhes do Produto:");
        System.out.println("************************************************************");
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Artista: " + this.artista);
        System.out.println("Preço: " + this.preco);
    }
}
