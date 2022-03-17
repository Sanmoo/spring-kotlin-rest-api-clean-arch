package com.mercadolivro.adapters.datastores.in_memory

import com.mercadolivro.core.entities.Entity
import com.mercadolivro.core.use_cases.ports.GenericRepository

open class GenericInMemoryRepository<T : Entity> : GenericRepository<T> {
    protected val store = HashMap<Int, T>()
    private var index = 1

    override fun create(e: T): Int {
        val newId = index++
        e.id = newId
        store[newId] = e
        return newId
    }

    override fun getAll(): List<T> {
        return store.values.toList()
    }

    override fun getById(id: Int): T? {
        return store[id]
    }

    override fun update(id: Int, e: T) {
        store[id] = e
    }

    override fun deleteById(id: Int) {
        store.remove(id)
    }
}
