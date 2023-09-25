package com.example.konteudo

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object Users: Table(){
    val id: Column<String> = char("id", 36)
    val name: Column<String> = varchar("name", 50)
    val nickname: Column<String> = varchar("nickname", 10)
    val password: Column<String> = varchar("password", 100)
    override val primaryKey = PrimaryKey(id, name = "PK_Users_Id")

    fun toUser(row: ResultRow): User = User(
        id = row[Users.id],
        name = row[Users.name],
        nickname = row[Users.nickname],
        password = row[Users.password]
    )
}

@Serializable
data class User (
    var id: String? = null,
    val name: String,
    val nickname: String,
    val password: String
)