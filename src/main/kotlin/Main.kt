import kotlin.random.Random

fun main(args: Array<String>) {
    val height = 9 //высота
    val width = 40  //ширина
    val point = '.'
    val mine = 'X'
    val pole = MutableList(height) { MutableList(width) { point } }
    val message = "How many mines do you want on the field?"
    /* ----------------------------------------------------------- */
    println(message)
    val mineCount: Int = readln().toInt()

    var count = 0
    while (count < mineCount) {
        val x: Int = Random.nextInt(0, width)
        val y: Int = Random.nextInt(0, height)
        if (pole[y][x] != mine) {
            mine.also { pole[y][x] = it }
            count++
        }
    }

    /* ----------------------------------------------------------- */
    for (i in 0 until height) {
        for (j in 0 until width) {
            print(pole[i][j])
        }
        println()
    }
}