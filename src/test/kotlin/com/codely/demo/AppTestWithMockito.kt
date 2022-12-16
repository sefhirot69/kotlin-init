package com.codely.demo

import kotlin.test.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito.verify
import org.mockito.kotlin.any
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class AppTestWithMockito {

    private lateinit var writer: Writer
    private lateinit var reader: Reader

    @BeforeEach
    fun setUp() {
        reader = mock<Reader>()
        writer = mock<Writer>()
    }

    @Test
    fun `should calculate the diff and return 11 month`() {

        val app = AppTest(reader, writer)
        whenever(reader.read()).thenReturn("2020-09-01")
        doNothing().`when`(writer).write(any())

        app.execute()

        verify(writer).write("The difference between the date you wrote an today is 11 months")
    }

    @Test
    fun `should calculate the difference and return 31 years`() {

        val app = AppTest(reader, writer)
        whenever(reader.read()).thenReturn("1990-08-31")
        doNothing().`when`(writer).write(any())

        app.execute()

        verify(writer).write("The difference between the date you wrote an today is 31 years")
    }

    @Test
    fun `should calculate the difference and return 2 days`() {

        val app = AppTest(reader, writer)
        whenever(reader.read()).thenReturn("2021-08-29")
        doNothing().`when`(writer).write(any())

        app.execute()

        verify(writer).write("The difference between the date you wrote an today is 2 days")
    }
}
