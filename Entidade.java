public abstract class Entidade {
    protected String nome; // Protected deixa os filhos acessarem diretamente

    public Entidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}