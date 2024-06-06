import java.util.ArrayList;

public class ListaTarefas {

    private static ArrayList<Tarefa> listaTarefas = new ArrayList<>();

    public static ArrayList<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public static void cadatrarTarefa(Tarefa tarefa) {
        listaTarefas.add(tarefa);
    }

    public static Tarefa buscarTafera(String titulo) throws Exception {
        for (Tarefa tempTarefa : listaTarefas) {
            if (tempTarefa.getTitulo().contains(titulo)) {
                return tempTarefa;
            }
        }
        throw new Exception("\nTarefa não encontrada..");
    }

    public static void apagarTarefa(Tarefa tarefa) {
        listaTarefas.remove(tarefa);
    }

    public static void editarTarefa(String titulo, Tarefa tarefa) throws Exception {
        boolean tarefaEncontarada = false;
        // bucar tarefa antes
        for (int i = 0; i < listaTarefas.size(); i++) {
            Tarefa tempTarefa = listaTarefas.get(i);
            if (tempTarefa.getTitulo().equals(tempTarefa)) {
                // atualizar tarfea encontrada
                listaTarefas.set(i, tempTarefa);
                tarefaEncontarada = false;
                break;
            }
        }
        // execeçao se tarefa nao for encontrada
        if (!tarefaEncontarada) {
            throw new Exception("\nTarefa com titulo " + titulo + " não encontrada...");
        }
    }

}
