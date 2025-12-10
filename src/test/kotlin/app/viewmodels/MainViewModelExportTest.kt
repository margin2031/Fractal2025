package app.viewmodels


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MainViewModelExportTest {

    @Test
    fun `saveAsJpg does not throw exception`() {
        val vm = MainViewModel()

        assertDoesNotThrow {
            vm.saveAsJpg()
        }
    }
}