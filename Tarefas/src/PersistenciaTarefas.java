import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersistenciaTarefas {

    private static final String ARQUIVO = "LISTA DE TAREFAS.txt";

    public static void salvarTarefaNoArquivo(ArrayList<Tarefa> listaTarefas) throws IOException {
        // salvar arquivo
        try (FileWriter fw = new FileWriter(ARQUIVO);
                BufferedWriter bw = new BufferedWriter(fw)) {
            for (Tarefa tempTarefa : listaTarefas) {
                fw.write(tempTarefa + "\n");
            }
        }
    }

    public static void lerArquivo(ArrayList<Tarefa> lisTarefas) throws IOException {
        // ler arquivo
        try (FileReader fr = new FileReader(ARQUIVO);
                BufferedReader br = new BufferedReader(fr)) {
            // percorre a lista
            String linha;
            while ((linha = br.readLine()) != null) {
                Tarefa tempTarefa = new Tarefa();
                tempTarefa.fromString(linha);
                lisTarefas.add(tempTarefa);
            }
        }
    }

    public static void criarArquivoSeNaoExistir() throws IOException {
        // criando arquivo
        try {
            File arquivo = new File(ARQUIVO);

            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } finally {
        }
    }

}
