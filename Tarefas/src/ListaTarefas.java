import java.util.ArrayList;

public class ListaTarefas {

    private static ArrayList<Tarefa> listaTarefas = new ArrayList<>();

    public static ArrayList<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public static void cadatrarTarefa(Tarefa tarefa) {
        listaTarefas.add(tarefa);
    }

    public static void verificarlistaVazia() throws Exception {
        if (listaTarefas.isEmpty()) {
            throw new Exception("\nNão há nenhuma, tarfea cadastrada...");
        }
    }

    public static Tarefa buscarTafera(String titulo) throws Exception {
        for (Tarefa tempTarefa : listaTarefas) {
            if (tempTarefa.getTitulo().contains(titulo)) {
                return tempTarefa;
            }
        }
        throw new Exception("\nTarefa não encontrada..");
    }

    public static void apagarTarefab(Tarefa tarefa) {
        listaTarefas.remove(tarefa);
    }

    public static Tarefa editarTarefas(ArrayList<Tarefa> listaTarefas) throws Exception {

        boolean tarefaEncontarada = false;
        // buscar tarefa
        String titulo = Console.lerString("Infome nome da tarefa pra editar");
        Tarefa tarefaParaEditar = buscarTafera(titulo);
        if (tarefaParaEditar != null) {
            // atualizando a tarefa
            tarefaParaEditar.setTitulo(Console.lerString("\nInfome novo nome"));
            tarefaParaEditar.setDescricao(Console.lerString("\nInforme a nova descrição"));
            tarefaParaEditar.setDataVencimento(Console.lerString("\nInfome nova data"));
            tarefaParaEditar.setStatus(Console.lerString("\nStatus da tarefa"));
            tarefaEncontarada = true;
        }
        if (!tarefaEncontarada) {
            throw new Exception("\nTarefa com titulo " + titulo + " não encontrada");
        }
        PersistenciaTarefas.salvarTarefaNoArquivo(listaTarefas);
        return tarefaParaEditar;
    }

}
