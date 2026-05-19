package data

data class Teacher(
    val id: Int,
    val name: String,
    val email: String,
    val password: String
){
    companion object {
        val registeredTeachers = mutableListOf<Teacher>()
    }

}