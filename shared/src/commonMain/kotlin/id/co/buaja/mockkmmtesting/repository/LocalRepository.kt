package id.co.buaja.mockkmmtesting.repository

import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    fun sum(a: Int, b: Int): Int
    suspend fun sumSuspend(a: Int, b: Int): Int
    fun sumFlow(a: Int, b: Int): Flow<Int>
}