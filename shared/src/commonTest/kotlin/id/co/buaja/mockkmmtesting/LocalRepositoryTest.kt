@file:OptIn(ExperimentalCoroutinesApi::class)

package id.co.buaja.mockkmmtesting

import app.cash.turbine.test
import id.co.buaja.mockkmmtesting.data.LocalDataSource
import id.co.buaja.mockkmmtesting.repository.LocalRepositoryImpl
import io.mockative.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalRepositoryTest {
    @Mock
    val localDataSource = mock(classOf<LocalDataSource>())

    private lateinit var localRepositoryImpl: LocalRepositoryImpl

    @BeforeTest
    fun beforeTest() {
        localRepositoryImpl = LocalRepositoryImpl(
            localDataSource = localDataSource
        )
    }

    @Test
    fun `when check sum`() {
        // Given
        given(localDataSource).invocation {
            sum(a = 5, b = 5)
        }.thenReturn(10)

        // Then
        val sum = localRepositoryImpl.sum(5, 5)
        assertEquals(10, sum)

        verify(localDataSource).invocation {
            sum(5, 5)
        }
    }

    @Test
    fun `when check sum suspend`() = runTest {
        // Given
        given(localDataSource).coroutine {
            sumSuspend(a = 5, b = 5)
        }.thenReturn(10)

        // Then
        val sum = localRepositoryImpl.sumSuspend(5, 5)
        assertEquals(10, sum)

        verify(localDataSource).coroutine {
            sumSuspend(5, 5)
        }
    }

    @Test
    fun `when check sum flow`() = runTest {
        // Given
        given(localDataSource).invocation {
            sumFlow(a = 5, b = 5)
        }.then {
            flowOf(10)
        }

        // Then
        localRepositoryImpl.sumFlow(5, 5).test {
            val success = awaitItem()
            assertEquals(10, success)
            awaitComplete()
        }

        verify(localDataSource).invocation {
            sumFlow(5, 5)
        }
    }
}