package dao

import model.User
import java.util.concurrent.atomic.AtomicInteger

class UserDao {

    val users = mutableListOf(
            User(name = "Alice", email = "alice@alice.kt", id = 0),
            User(name = "Bob", email = "bob@bob.kt", id = 1),
            User(name = "Carol", email = "carol@carol.kt", id = 2),
            User(name = "Dave", email = "dave@dave.kt", id = 3)
    )

    var lastId: AtomicInteger = AtomicInteger(users.size - 1)

    fun save(name: String, email: String) {
        val id = lastId.incrementAndGet()
        users.add(id, User(name = name, email = email, id = id))
    }

    fun findById(id: Int): User? {
        return users[id]
    }

    fun findByEmail(email: String): User? {
        return users.find { it.email == email }
    }

    fun update(id: Int, user: User) {
        users.add(id, User(name = user.name, email = user.email, id = id))
    }

    fun delete(id: Int) {
        users.remove(findById(id))
    }

}