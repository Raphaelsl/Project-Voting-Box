import java.util.ArrayList;
import java.util.List;

// O Cargo também é uma Entidade (tem nome).
public class Cargo extends Entidade {
    private int votosBranco;
    private int votosNulos;

    // Aqui tem Generics: a lista só aceita objetos do tipo Candidato
    private List<Candidato> candidatos;

    public Cargo(String nomeCargo) {
        super(nomeCargo);
        this.votosBranco = 0;
        this.votosNulos = 0;
        this.candidatos = new ArrayList<>();
    }

    public void adicionarCandidato(Candidato novoCandidato) {
        candidatos.add(novoCandidato);
    }

    public void registrarVotoBranco() {
        votosBranco++;
    }

    public void registrarVotoNulo() {
        votosNulos++;
    }

    // Método pra procurar o candidato pelo número na lista do cargo
    public Candidato buscarCandidato(int numero) {
        for (Candidato c : candidatos) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    public int getVotosBranco() { return votosBranco; }
    public int getVotosNulos() { return votosNulos; }
    public List<Candidato> getCandidatos() { return candidatos; }
}
