public class candidato {
    private String nome;
    private String partido;
    private int votos;

    public candidato(String nome, String partido) {
        this.nome = nome;
        this.partido = partido;
        this.votos = 0;
    }

    public void receberVoto() {
        this.votos++;
    }

    public String getNome() {
        return nome;
    }

    public String getPartido() {
        return partido;
    }

    public int getVotos() {
        return votos;
    }

    @Override
    public String toString() {
        return nome + " (" + partido + ") - Votos: " + votos;
    }
}
