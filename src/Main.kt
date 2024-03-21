fun main() {
    print("Please type your password: ")
    val password = readln()
    print("Please type your username: ")
    val username = readln()
    print("Please type your type of user (1/2/3): ")
    val usertype = readln()
    val usertypeInt = usertype.toInt()

    println("Password is valid: " + isValidPassword(password, usertypeInt))

    println("Username is valid: " + isValidUsername(username))
}

fun isValidPassword(password: String, usertype: Int): Boolean {
    var pwdlength = true
    var pwddigit = true
    var pwdupper = true
    var pwdlower = true
    var pwdspecial = true

    if (usertype == 1) {
        if (password.length < 8) { pwdlength = false }
        if (countNumbers(password) < 1) {pwddigit = false}
        if (countUpperCaseLetters(password) < 1) { pwdupper = false }
        if (countLowerCaseLetters(password) < 1) { pwdlower = false }
        if (countSpecialCharacters(password) < 1) { pwdspecial = false }
    } else if (usertype == 2) {
        if (password.length < 15) { pwdlength = false }
        if (countNumbers(password) < 2) {pwddigit = false}
        if (countUpperCaseLetters(password) < 2) { pwdupper = false }
        if (countLowerCaseLetters(password) < 2) { pwdlower = false }
        if (countSpecialCharacters(password) < 2) { pwdspecial = false }
    } else if (usertype == 3) {
        if (password.length < 25) { pwdlength = false }
        if (countNumbers(password) < 4) {pwddigit = false}
        if (countUpperCaseLetters(password) < 4) { pwdupper = false }
        if (countLowerCaseLetters(password) < 4) { pwdlower = false }
        if (countSpecialCharacters(password) < 4) { pwdspecial = false }
    }

    println("")
    println("Password:")
    println("Length: $pwdlength")
    println("Digit: $pwddigit")
    println("Uppercase: $pwdupper")
    println("Lowercase: $pwdlower")
    println("Special: $pwdspecial")

    return if ((pwdlength) and (pwddigit) and (pwdupper) and (pwdlower) and (pwdspecial)) {
        (true)
    } else {
        (false)
    }
}

fun isValidUsername(username: String): Boolean {
    var usrnmlength = true
    var usrnmspecial = true

    if ((username.length < 3) or (username.length > 20)) { usrnmlength = false }
    if (username.filter { !(it.isLetterOrDigit() || it in listOf('.', '_', '@')) }.firstOrNull() != null) {usrnmspecial = false}

    println("")
    println("Username:")
    println("Between 3 and 20 characters: $usrnmlength")
    println("No special characters except for \".\", \"_\" and \"@\": $usrnmspecial")

    return usrnmlength && usrnmspecial
}

fun countNumbers(password: String): Int {
    val regex = "\\d+".toRegex()
    val matches = regex.findAll(password)
    var count = 0
    for (match in matches) {
        count++
    }
    return count
}

fun countUpperCaseLetters(password: String): Int {
    val regex = "[A-Z]".toRegex()
    val matches = regex.findAll(password)
    var count = 0
    for (match in matches) {
        count++
    }
    return count
}

fun countLowerCaseLetters(password: String): Int {
    val regex = "[a-z]".toRegex()
    val matches = regex.findAll(password)
    var count = 0
    for (match in matches) {
        count++
    }
    return count
}

fun countSpecialCharacters(password: String): Int {
    val regex = "[^A-Za-z0-9\\s]".toRegex()
    val matches = regex.findAll(password)
    var count = 0
    for (match in matches) {
        count++
    }
    return count
}