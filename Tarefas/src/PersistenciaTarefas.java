import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersistenciaTarefas {

    private static final String ARQUIVO = "LISTA DE TAREFAS.txt";

    public static void salvarTarefaNoArquivo(ArrayList<Tarefa> listaTarefas) throws IOException {
        try (FileWriter fw = new FileWriter(ARQUIVO);
                BufferedWriter bw = new BufferedWriter(fw)) {
            for (Tarefa tempTarefa : listaTarefas) {
                fw.write(tempTarefa + "\n");
            }
        }
    }

}
