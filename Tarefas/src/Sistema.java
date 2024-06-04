public class Sistema {
	
    public static void exibirMenu() {
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
                break;
            case 2:
                // Lógica para buscar tarefa
                break;
            case 3:
                // Lógica para editar tarefa
                break;
            case 4:
                // Lógica para excluir tarefa
                break;
            case 5:
                // Lógica para listar todas as tarefas
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
}
