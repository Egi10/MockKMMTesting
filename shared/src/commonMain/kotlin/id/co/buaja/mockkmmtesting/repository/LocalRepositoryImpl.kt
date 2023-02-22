package id.co.buaja.mockkmmtesting.repository

import id.co.buaja.mockkmmtesting.data.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalRepositoryImpl(
    private val localDataSource: LocalDataSource
): LocalRepository {
    override fun sum(a: Int, b: Int): Int {
        return localDataSource.sum(
            a, b
        )
    }

    override suspend fun sumSuspend(a: Int, b: Int): Int {
        return localDataSource.sumSuspend(
            a, b
        )
    }

    override fun sumFlow(a: Int, b: Int): Flow<Int> {
        return localDataSource.sumFlow(a, b)
    }

}