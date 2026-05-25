import java.io.PrintStream
import java.nio.charset.StandardCharsets
import kotlin.system.exitProcess
fun main(){
    System.setOut(PrintStream(System.`out`, true, StandardCharsets.UTF_8.name()))
    val listaCursos = listOf(
        Curso(1, "Kotlin Iniciante", "Programação", 40, 9.5, true),
        Curso(2, "Java Intermediário", "Programação", 60, 8.0, false),
        Curso(3, "UI/UX Design", "Design", 30, 10.0, true)
    )

    println("\n\nQual exercício você quer visualizar?" +
            "\n 1- Par ou ímpar" +
            "\n 2- Classificação de nota" +
            "\n 3- Validação de curso" +
            "\n 4- Buscar curso por ID" +
            "\n 5- Filtrar cursos ativos" +
            "\n 6- Ranking por nota" +
            "\n 7- Agrupar por categoria" +
            "\n 8- Calcular carga horária total" +
            "\n 9- Deduplicar categorias" +
            "\n 0- Sair")
    when(readLine()!!.toInt()){
        1 -> parouimpar()
        2 -> classnota()
        3 -> validarcurso()
        4 -> buscarcurso(listaCursos)
        5 -> filtrarcursosativos(listaCursos)
        6 -> rankingnota(listaCursos)
        7 -> agruparporcategoria(listaCursos)
        8 -> calcularcargatotal(listaCursos)
        9 -> deduplicar(listaCursos)
        else -> exitProcess(0)
    }
}
fun parouimpar(){
    println("Insira um numero")
    var n1 = readLine()!!.toInt()
    if (n1%2==0) {
        println("Esse número é Par")
    } else {
        println("Esse número é Impar")
    }
    println(n1%2)
    return main()
}
fun classnota(){
    println("Insira sua nota")
    var n1 = readLine()!!.toInt()
    when (n1) {
        in 90..100 -> println("Excelente")
        in 70..89 -> println("Aprovado")
        in 50..69 -> println("Recuperação")
        in 0..49 -> println("Reprovado")
        else -> println("Nota inválida")
    }
    return main()
}
fun validarcurso(){
    println("Insira o seu nome")
    var nome = readLine()!!
    println("Insira sua carga horária")
    var ch = readLine()!!.toInt()
    if (ch == 0 || ch > 400){
        println("Insira uma carga horaria de 1 a 400 horas")
        return main()
    } else {
        if (nome.length<1){
            println("Erro, o nome precisa conter algo")
            return main()
        }
    }
    println("Curso aprovado")
}
data class Curso(
    var id: Int,
    var nome: String,
    var categoria: String,
    var cargaHoraria: Int,
    var nota: Double,
    var ativo: Boolean
)
fun buscarcurso(cursos: List<Curso>){
    println("Digite o ID do curso que deseja buscar:")
    val idBuscado = readLine()?.toIntOrNull()
    val cursoEncontrado = cursos.find { it.id == idBuscado }

    if (cursoEncontrado != null) {
        println("Curso encontrado: ${cursoEncontrado.nome} | Categoria: ${cursoEncontrado.categoria}")
    } else {
        println("Curso com ID $idBuscado não encontrado.")
    }
    return main()
}
fun  filtrarcursosativos(cursos: List<Curso>){
    println("Os cursos ativos são:")
    var ativos = cursos.filter {it.ativo}
    for (cursoEncontrado in ativos){
        println("$cursoEncontrado")
    }
    return main()
}
fun rankingnota(cursos: List<Curso>){
    var lista = cursos.sortedByDescending { it.nota }
    for (curso in lista) {
        println("${curso.nota} | ${curso.nome}")
    }
    return main()
}
fun agruparporcategoria(cursos: List<Curso>){
    val categoriasUnicas = cursos.map { it.categoria }.distinct()


    for (cat in categoriasUnicas) {
        println("\nCategoria: $cat")
        for (curso in cursos) {
            if (curso.categoria == cat) {
                println(" - ${curso.nome}")
            }
        }
    }
}
fun calcularcargatotal(cursos: List<Curso>){
    var soma = cursos.sumOf { it.cargaHoraria }
    println("A carga horaria total é $soma")
    return main()
}
fun deduplicar(cursos: List<Curso>){
    var cat = cursos.map { it.categoria }
    var set = cat.toSet()
    var um = 1
    for (curso in set){
        println("Categoria $um: $curso")
        um++
    }
    return main()

}
