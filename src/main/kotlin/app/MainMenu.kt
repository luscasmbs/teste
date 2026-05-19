package app

import service.login
import service.register

fun mainmenu(){
    while (true){
        println("=================================\n " +
                "Sistema de Alunos e Trilhas\n" +
                "=================================\n\n" +
                "1 - Fazer Login\n" +
                "2 - Fazer Cadastro\n" +
                "0 - Sair\n")

        print("Escolha uma opção: ")
        val op = readLine()?.toIntOrNull()
        when(op){
            1 -> login()
            2 -> register()
            0 -> mainmenu()
            else -> println("Opção inválida. Tente novamente.")
        }
    }

}