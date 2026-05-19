package service

import data.Teacher

class RegisterTeacher {
    fun RegisteredTeacher(id: Int, name: String, email: String, password: String) {
        require(name.isNotBlank()) { "O nome é obrigatório" }
        require(name.length > 2) { "O nome precisa ter pelo menos 3 caracteres" }
        require(email.isNotBlank()) { "O email é obrigatório" }
        require(Teacher.registeredTeachers.none { it.id == id }) {
            "Já existe um professor com o id $id"

        }

    }
}