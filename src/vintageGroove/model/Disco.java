package vintageGroove.model;

public class Disco extends Produto {

    private String genero;

    public Disco(int id, String nome, String artista, float preco, String genero) {
        super(id, nome, artista, preco);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Gênero: " + this.genero);
    }
}
