fun main() {
    val gameVars =  arrayOf("Камень","Ножницы","Бумага")
    val gameChoice = getGameChoice(gameVars)
    val userChoice = getUserChoice(gameVars)
    printResult(userChoice,gameChoice)
}

fun getGameChoice(vars: Array<String>) = vars[(Math.random() * vars.size).toInt()]

fun getUserChoice(vars: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""
    while (!isValidChoice) {

        print("Пожалуйста, выберите:")
        for (item in vars) print(" $item")
        println(".")
        val userInput = readLine()
        if (userInput != null && userInput in vars) {
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) println("Вы должны ввести допустимое значение.")
    }
    return userChoice
}
fun printResult(userChoice: String, gameChoice: String){
    val result: String
    if (userChoice == gameChoice) result = "Ничья!"
    else if((userChoice == "Камень" && gameChoice == "Ножницы") ||
        (userChoice == "Ножницы" && gameChoice == "Бумага") ||
        (userChoice == "Бумага" && gameChoice == "Камень")) result = "Ты победил!"
    else result = "Ты проиграл!"
    println("Ты выбрал $userChoice, я выбрал $gameChoice. $result")
}