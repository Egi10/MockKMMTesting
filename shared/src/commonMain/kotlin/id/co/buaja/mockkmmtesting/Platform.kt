package id.co.buaja.mockkmmtesting

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform