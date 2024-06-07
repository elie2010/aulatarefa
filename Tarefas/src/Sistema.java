import java.util.ArrayList;

public class Sistema {

    private static ArrayList<Tarefa> listaTarefas = ListaTarefas.getListaTarefas();
    private static Tarefa editarTarefas;

    public static void executar() {
        try {
            PersistenciaTarefas.criarArquivoSeNaoExistir();
            PersistenciaTarefas.lerArquivo(listaTarefas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        while (true) {
            exibirMenu();
            int opcao = Console.lerInt("Informe opção");
            try {
                verificarOpcao(opcao);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

    private static void exibirMenu() {
        System.out.println("1. Cadastrar Tarefa");
        System.out.println("2. Buscar Tarefa");
        System.out.println("3. Editar Tarefa");
        System.out.println("4. Excluir Tarefa");
        System.out.println("5. Listar Todas as Tarefas");
        System.out.println("0. Sair");
    }

    public static void verificarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                // Lógica para cadastrar tarefa
                cadatrarTarefa();
                break;
            case 2:
                // Lógica para buscar tarefa
                buscarTafera();
                break;
            case 3:
                // Lógica para editar tarefa
                editarTarefa(editarTarefas);
                break;
            case 4:
                // Lógica para excluir tarefa
                excluirTarefa();
                break;
            case 5:
                // Lógica para listar todas as tarefas
                lisTarefas();
                break;
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void cadatrarTarefa() {
        System.out.println("\nCadastrar tarefa:");
        String titulo = Console.lerString("Nome da tarefa");
        String descricao = Console.lerString("Insira a descrição da tarefa");
        int dataDeVencimento = Console.lerInt("Data de entrega");
        String status = Console.lerString("Staus da atividade");
        Tarefa tarefa = new Tarefa(titulo, descricao, descricao, status);
        try {
            ListaTarefas.cadatrarTarefa(tarefa);
            PersistenciaTarefas.salvarTarefaNoArquivo(listaTarefas);
            System.out.println("\nTarefa cadatrada com sucesso...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarTafera() {
        try {
            ListaTarefas.verificarlistaVazia();
            System.out.println("\nBuscar tarefa:");
            String titulo = Console.lerString("Informe o nome da tarefa");
            Tarefa tarefa = ListaTarefas.buscarTafera(titulo);
            System.out.println("\nTarefa localizada:");
            System.out.println(tarefa.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void editarTarefa(Tarefa tarefa) {
        try {
            ListaTarefas.verificarlistaVazia();
            tarefa = ListaTarefas.editarTarefas(listaTarefas);
            PersistenciaTarefas.salvarTarefaNoArquivo(listaTarefas);
            System.out.println("\nTarefa editar");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void excluirTarefa() {
        try {
            ListaTarefas.verificarlistaVazia();
            System.out.println("\nApagar tarefa:");
            String titulo = Console.lerString("Informe nome da tarefa");
            Tarefa tarefa = ListaTarefas.buscarTafera(titulo);
            System.out.println("\nTarefa localiza:");
            ListaTarefas.apagarTarefab(tarefa);
            System.out.println("\nTarefa excluída!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void lisTarefas() {
        try {
            ListaTarefas.verificarlistaVazia();
            System.out.println("\nTarefas cadstradas:");
            for (Tarefa tempTarefa : listaTarefas) {
                System.out.println(tempTarefa.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
