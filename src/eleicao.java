import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class eleicao {
    private List<candidato> candidatos;

    public eleicao() {
        this.candidatos = new ArrayList<>();
    }

    public void adicionarCandidato(candidato candidato) {
        if (!candidatoExiste(candidato.getNome())) {
            this.candidatos.add(candidato);
        } else {
            System.out.println("Candidato já existe: " + candidato.getNome());
        }
    }

    public boolean candidatoExiste(String nomeCandidato) {
        for (candidato candidato : candidatos) {
            if (candidato.getNome().equalsIgnoreCase(nomeCandidato)) {
                return true;
            }
        }
        return false;
    }

    public void votar(String nomeCandidato) {
        for (candidato candidato : candidatos) {
            if (candidato.getNome().equalsIgnoreCase(nomeCandidato)) {
                candidato.receberVoto();
                return;
            }
        }
        System.out.println("Candidato não encontrado: " + nomeCandidato);
    }

    public void salvarDados(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (candidato candidato : candidatos) {
                writer.write(candidato.toString());
                writer.newLine();
            }
            System.out.println("Dados salvos com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public void mostrarResultados() {
        System.out.println("Resultados da Eleição:");
        for (candidato candidato : candidatos) {
            System.out.println(candidato);
        }
    }

    public List<candidato> getCandidatos() {
        return candidatos;
    }
}
