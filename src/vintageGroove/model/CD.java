package vintageGroove.model;

public class CD extends Produto {

    private int numFaixas;

    public CD(int id, String nome, String artista, float preco, int numFaixas) {
        super(id, nome, artista, preco);
        this.numFaixas = numFaixas;
    }

    public int getNumFaixas() {
        return numFaixas;
    }

    public void setNumFaixas(int numFaixas) {
        this.numFaixas = numFaixas;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Número de Faixas: " + this.numFaixas);
    }
}
