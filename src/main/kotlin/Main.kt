import kotlin.random.Random

class Field() {
    private val height = 9 //высота
    private val width = 9  //ширина
    private val point = '.'
    private val mine = 'X'
    private val pole = MutableList(this.height) { MutableList<Char>(this.width) { this.point } }
    private val mineCount: Int = readln().toInt()

    private fun initMine() {
        var count = 0
        while (count < this.mineCount) {
            val x: Int = Random.nextInt(0, this.width)
            val y: Int = Random.nextInt(0, this.height)
            if (this.pole[y][x] != this.mine) {
                this.mine.also { this.pole[y][x] = it }
                count++
            }
        }
    }

    fun printField() {
        this.initAmbit()
        for (y in 0 until this.height) {
            for (x in 0 until this.width) {
                print(this.pole[y][x])
            }
            println()
        }
    }

    private fun initAmbit() {
        this.initMine()
        for (y in 0 until this.height) for (x in 0 until this.width) {
            if (this.pole[y][x] == 'X') continue
            var count = 0
            for (i in y-1..y+1) for (j in x-1..x+1) {
                if (0 <= i && i < this.height && 0 <= j && j < this.width && (i != y || j != x)) {
                    if (this.pole[i][j] == '.') continue
                    if (this.pole[i][j] == 'X') count++
                }
                if (count == 0) continue
                this.pole[y][x] = Character.forDigit(count, 10)
            }
        }
    }
}

fun main(args: Array<String>) {

    println("How many mines do you want on the field?")
    val field = Field()
    field.printField()
}