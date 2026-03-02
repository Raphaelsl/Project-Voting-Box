public class Candidato extends Entidade implements Votavel {
    private int numero; // Encapsulamento: ninguém mexe no número de fora
    private int votos;

    public Candidato(int numero, String nome) {
        super(nome); // Chama o construtor da Entidade
        this.numero = numero;
        this.votos = 0;
    }

    public int getNumero() {
        return numero;
    }

    // Aqui eu "honro" o contrato da interface Votavel
    @Override
    public void registrarVoto() {
        this.votos++;
    }

    @Override
    public int getTotalVotos() {
        return votos;
    }
}
