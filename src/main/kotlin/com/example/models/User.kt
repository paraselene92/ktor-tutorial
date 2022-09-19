package com.example.models//package com.example.models
//
//import kotlinx.serialization.Serializable
//
//object Users : Table() {
//    val id: Column<Int> = integer("id").autoIncrement()
//    val name: Column<String> = varchar("name", 255)
//}
//
//@Serializable
//data class User (val name:String, val age:Int)

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Characters: IntIdTable() {
    val name: Column<String> = varchar("name", 50)
    val age: Column<String> = varchar("age", 3)
}

class Character(id: EntityID<Int>) : IntEntity(id) {
    companion object: IntEntityClass<Character>(Characters)
    var name by Characters.name
    var age by Characters.age
}
