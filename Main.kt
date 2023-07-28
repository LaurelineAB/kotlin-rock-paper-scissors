import kotlin.random.Random

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    //println("Program arguments: ${args.joinToString()}")
    fun cpChooses(): String {
        val choices = listOf<String>("ciseaux", "papier", "pierre")
        val cpChoice = choices[Random.nextInt(0, 2)]
        return cpChoice
    }

    fun userChooses(): String {
        print("Choisissez entre pierre, papier et ciseaux : ")
        val userChoice: String = readLine()!!
        return userChoice
    }

    fun game() {
        val cpChoice = cpChooses()
        println(cpChoice)
        val userChoice = userChooses()
        println(
            when {
                cpChoice == "pierre" && userChoice == "ciseaux" || cpChoice == "papier" && userChoice == "pierre" || cpChoice == "ciseaux" && userChoice == "papier" -> "Vous avez perdu :( Vous : $userChoice, ordinateur : $cpChoice"
                cpChoice == "ciseaux" && userChoice == "pierre" || cpChoice == "pierre" && userChoice == "papier" || cpChoice == "papier" && userChoice == "ciseaux" -> "Vous avez gagné ! :) Vous : $userChoice, ordinateur : $cpChoice"
                cpChoice == userChoice -> "Egalité ! Vous : $userChoice, ordinateur : $cpChoice"
                else -> "Il semble y avoir une erreur, avez-vous correctement écrit votre choix ? (Votre choix : $userChoice)"
            }
        )
        println("Voulez-vous continuer ? (Y pour oui, N pour non)")
        val tryAgain = readLine()!!
        when (tryAgain) {
            "Y" -> game()
            "N" -> return
            else -> return
        }
    }

    game()
}