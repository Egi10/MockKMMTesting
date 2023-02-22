package id.co.buaja.mockkmmtesting.data

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun sum(a: Int, b: Int): Int
    suspend fun sumSuspend(a: Int, b: Int): Int
    fun sumFlow(a: Int, b: Int): Flow<Int>
}