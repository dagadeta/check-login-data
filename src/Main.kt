fun main() {
    print("Please type your password: ")
    val password = readln()
    print("Please type your username: ")
    val username = readln()
    print("Please type your type of user (1/2/3): ")
    val userType = readln()
    val userTypeInt = userType.toInt()

    println("Password is valid: " + isValidPassword(password, userTypeInt))
    println("Username is valid: " + isValidUsername(username))
}

data class PasswordProperties(val length: Boolean, val digits: Boolean, val upper: Boolean, val lower: Boolean, val special: Boolean)

fun isValidPassword(password: String, usertype: Int): Boolean {
    val passwordProperties = when (usertype) {
        1 -> checkPasswordProperties(password, 8, 1)
        2 -> checkPasswordProperties(password, 15, 2)
        3 -> checkPasswordProperties(password, 25, 4)
        else -> throw IllegalArgumentException("1/2/3 as user type expected")
    }

    println("")
    println("Password:")
    println("Length: ${passwordProperties.length}")
    println("Digit: ${passwordProperties.digits}")
    println("Uppercase: ${passwordProperties.upper}")
    println("Lowercase: ${passwordProperties.lower}")
    println("Special: ${passwordProperties.special}")

    return passwordProperties.length && passwordProperties.digits && passwordProperties.upper && passwordProperties.lower && passwordProperties.special
}

private fun checkPasswordProperties(password: String, minLength: Int, minOther: Int) = PasswordProperties(
    length = password.length >= minLength,
    digits = password.count("digits") >= minOther,
    upper = password.count("upper") >= minOther,
    lower = password.count("lower") >= minOther,
    special = password.count("special") >= minOther
)

fun isValidUsername(username: String): Boolean {
    var userNameLength = true

    if ((username.length < 3) or (username.length > 20)) { userNameLength = false }
    val userNameSpecial = username.firstOrNull { !(it.isLetterOrDigit() || it in listOf('.', '_', '@')) } == null

    println("")
    println("Username:")
    println("Between 3 and 20 characters: $userNameLength")
    println("No special characters except for \".\", \"_\" and \"@\": $userNameSpecial")

    return userNameLength && userNameSpecial
}

fun String.count(type: String) = when (type) {
    "digits" -> "\\d+"
    "upper" -> "[A-Z]"
    "lower" -> "[a-z]"
    "special" -> "[^A-Za-z0-9\\s]"
    else -> ""
}.toRegex().findAll(this).count()