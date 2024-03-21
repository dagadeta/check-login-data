fun main() {
    print("Please type your password: ")
    val password = readln()
    print("Please type your username: ")
    val username = readln()

    println("Password is valid: " + isValidPassword(password))
    println("Password is " + checkPasswordStrength(password) + "% strong")

    println("Username is valid: " + isValidUsername(username))
}

fun isValidPassword(password: String): Boolean {
    var pwdlength = true
    var pwddigit = true
    var pwdupper = true
    var pwdlower = true
    var pwdspecial = true

    if (password.length < 8) { pwdlength = false }
    if (password.filter { it.isDigit() }.firstOrNull() == null) { pwddigit = false }
    if (password.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null) { pwdupper = false }
    if (password.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null) { pwdlower = false }
    if (password.filter { !it.isLetterOrDigit() }.firstOrNull() == null) { pwdspecial = false }

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

fun checkPasswordStrength(password: String): Int {
    return(100)
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