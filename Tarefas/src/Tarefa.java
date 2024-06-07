public class Tarefa {

    private String titulo;
    private String descricao;
    private String dataVencimento;
    private String status;

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao, String dataVencimento, String status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "titulo:" + titulo + "\ndescricao:" + descricao + "\ndataVencimento:" + dataVencimento
                + "\nstatus:" + status;
    }

    public void fromString(String linha) {
        String[] partes = linha.split(", ");
        titulo = partes[0].split(":")[1];
        descricao = partes[1].split(":")[1];
        dataVencimento = partes[2].split(":")[1];
        status = partes[3].split(":")[1];

    }

}
