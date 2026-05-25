import java.io.PrintStream
import java.nio.charset.StandardCharsets
import kotlin.system.exitProcess

data class Curso(
    var id: Int,
    var nome: String,
    var categoria: String,
    var cargaHoraria: Int,
    var nota: Double,
    var ativo: Boolean
)

fun main() {
    System.setOut(PrintStream(System.`out`, true, StandardCharsets.UTF_8.name()))
    
    val listaCursos = listOf(
        Curso(1, "Kotlin Iniciante", "Programação", 40, 9.5, true),
        Curso(2, "Java Intermediário", "Programação", 60, 8.0, false),
        Curso(3, "UI/UX Design", "Design", 30, 10.0, true)
    )

    println("\n\nOlá, bem vindo! o que você quer fazer?" +
            "\n 1- Buscar por nome" +
            "\n 2- Filtrar por categoria" +
            "\n 3- Gerar Ranking" +
            "\n 4- Gerar resumo por categoria" +
            "\n 5- Validar cadastro" +
            "\n 0- Sair")

    val opcao = readLine()?.toIntOrNull() ?: 0

    when(opcao) {
        1 -> buscarpornome(listaCursos)
        2 -> filtrarPorCategoria(listaCursos)
        3 -> rankingnota(listaCursos)
        4 -> resumoPorCategoria(listaCursos)
        5 -> validarcurso()
        0 -> exitProcess(0)
        else -> {
            println("Opção inválida!")
            main()
        }
    }
}

fun buscarpornome(cursoList: List<Curso>) {
    println("Qual o nome?")
    val entrada = readLine() ?: ""
    val resultados = cursoList.filter { it.nome.contains(entrada, ignoreCase = true) }
    
    if (resultados.isEmpty()) {
        println("Nenhum curso encontrado.")
    } else {
        resultados.forEach { println("- ${it.nome} [${it.categoria}]") }
    }
    main()
}

fun filtrarPorCategoria(cursos: List<Curso>) {
    println("Digite a categoria:")
    val entrada = readLine() ?: ""
    val filtrados = cursos.filter { it.categoria.equals(entrada, ignoreCase = true) }
    
    if (filtrados.isEmpty()) {
        println("Nenhum curso nesta categoria.")
    } else {
        filtrados.forEach { println("- ${it.nome}") }
    }
    main()
}

fun rankingnota(cursos: List<Curso>) {
    println("-- Ranking por Nota --")
    val lista = cursos.sortedByDescending { it.nota }
    for (curso in lista) {
        println("${curso.nota} | ${curso.nome}")
    }
    main()
}

fun resumoPorCategoria(cursos: List<Curso>) {
    val categorias = cursos.map { it.categoria }.distinct()
    for (cat in categorias) {
        val qtd = cursos.count { it.categoria == cat }
        println("Categoria: $cat | Total de cursos: $qtd")
    }
    main()
}

fun validarcurso() {
    println("Insira o nome do curso:")
    val nome = readLine() ?: ""
    println("Insira a carga horária:")
    val ch = readLine()?.toIntOrNull() ?: 0

    if (ch <= 0 || ch > 400) {
        println("Erro: Carga horária deve ser entre 1 e 400.")
    } else if (nome.isEmpty()) {
        println("Erro: O nome não pode ser vazio.")
    } else {
        println("Curso validado com sucesso!")
    }
    main()
}