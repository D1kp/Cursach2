package ru.samsung.itschool.myapplication

class Viewer(name:String,score:Int) {
     var name:String = name
     var score:Int = score


    fun toMap():Map<String,Any?>{
        return mapOf(
            "name" to name,
            "score" to score
        )
    }
}