package id.co.buaja.mockkmmtesting.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class LocalDataSourceImpl : LocalDataSource {
    override fun sum(a: Int, b: Int): Int {
        return a + b
    }

    override suspend fun sumSuspend(a: Int, b: Int): Int {
        return a + b
    }

    override fun sumFlow(a: Int, b: Int): Flow<Int> {
        return flowOf(a + b)
    }

}