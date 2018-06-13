import java.util.*

fun main(args : Array<String>) {
    data class Player(var name: String, var _class:String, var dex:Int = 1, var str: Int = 1, var lvl:Int = 1, var maxHP:Int = 10,
                      var nextLvlXP: Int= 10, var XP:Int = 0, var HP:Int = 10, var backpack : Array<Array<Int>>, var MaxSizeBack : Int = 100, var SizeBack : Int = 0){
        private fun lvlUp(){
            lvl+=1
            str += if (lvl % 2 == 0) 1 else 0
            dex += if (lvl % 2 == 1) 1 else 0
            maxHP = (maxHP*1.1).toInt()
            nextLvlXP *= 2
            HP = maxHP
            println ("Lvl up! Your stats are ${toString()}")
        }
        fun increaseXP(newXP : Int){
            println("Got ${newXP} XP")
            XP += newXP
            if (XP > nextLvlXP) lvlUp()
        }
         fun deathPenalty (){
            maxHP = (maxHP * 0.05).toInt()
             XP = (XP/2).toInt()
        }
        fun pain(damage : Int){
            maxHP -= damage
            if (maxHP <= 0){
                maxHP = maxHP + damage
                deathPenalty()
            }
        }
    }
    open class Item (var name: String){}

    class Weapon(name: String, var pr : Int, var dg : Int) : Item (name){
        fun Bush (){
            
        }
    }
}

