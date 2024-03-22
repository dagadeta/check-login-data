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
        if (count(password, "digits") < 1) { pwddigit = false }
        if (count(password, "upper") < 1) { pwdupper = false }
        if (count(password, "lower") < 1) { pwdlower = false }
        if (count(password, "special") < 1) { pwdspecial = false }
    } else if (usertype == 2) {
        if (password.length < 15) { pwdlength = false }
        if (count(password, "digits") < 2) { pwddigit = false }
        if (count(password, "upper") < 2) { pwdupper = false }
        if (count(password, "lower") < 2) { pwdlower = false }
        if (count(password, "special") < 2) { pwdspecial = false }
    } else if (usertype == 3) {
        if (password.length < 25) { pwdlength = false }
        if (count(password, "digits") < 4) { pwddigit = false }
        if (count(password, "upper") < 4) { pwdupper = false }
        if (count(password, "lower") < 4) { pwdlower = false }
        if (count(password, "special") < 4) { pwdspecial = false }
    }

    println("")
    println("Password:")
    println("Length: $pwdlength")
    println("Digit: $pwddigit")
    println("Uppercase: $pwdupper")
    println("Lowercase: $pwdlower")
    println("Special: $pwdspecial")

    return pwdlength && pwddigit && pwdupper && pwdlower && pwdspecial
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

fun count(password: String, type: String): Int {
    var regex = "".toRegex()
    if (type == "digits") {
        regex = "\\d+".toRegex()
    } else if (type == "upper") {
        regex = "[A-Z]".toRegex()
    } else if (type == "lower") {
        regex = "[a-z]".toRegex()
    } else if (type == "special") {
        regex = "[^A-Za-z0-9\\s]".toRegex()
    }
    val matches = regex.findAll(password)
    var count = 0
    for (match in matches) {
        count++
    }
    return count
}