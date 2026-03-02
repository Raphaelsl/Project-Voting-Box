import java.util.ArrayList;
import java.util.List;

public class Eleicao {
    private List<Cargo> cargos;

    public Eleicao() {
        this.cargos = new ArrayList<>();
    }

    public void addCargo(Cargo cargo) {
        cargos.add(cargo);
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void exibirRelatorioFinal() {
        System.out.println("\n--- RELATÓRIO FINAL DA URNA ---");
        for (Cargo cargo : cargos) {
            System.out.println("\nCargo: " + cargo.getNome());
            System.out.println("Votos em Branco: " + cargo.getVotosBranco());
            System.out.println("Votos Nulos: " + cargo.getVotosNulos());

            for (Candidato c : cargo.getCandidatos()) {
                System.out.println("Candidato: " + c.getNome() + " | Votos: " + c.getTotalVotos());
            }
        }
    }
}
