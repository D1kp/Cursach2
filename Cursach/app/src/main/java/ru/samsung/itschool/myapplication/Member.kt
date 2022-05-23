package ru.samsung.itschool.myapplication


class Member{
        var zadacha:ArrayList<String>? =null
        var komand:String = ""
    constructor(){}
    constructor(zadacha: ArrayList<String>?, komand: String) {
        this.zadacha = zadacha
        this.komand = komand
    }

    fun toMap():Map<String,Any?>{
        return mapOf(
            "komand" to komand,
            "zadacha" to zadacha
        )
    }

}