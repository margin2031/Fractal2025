package app.fractal.FractalSaving
import androidx.compose.ui.geometry.Offset
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable

class FractalSaving (
    var selectionStart: Offset, var selectionEnd: Offset, var fractalName: String,
    var color: String
) : Serializable {
    constructor() : this(Offset.Zero, Offset.Zero, String(), "")
    /**
     * Сохранение объекта в файл с расширением .fractal
     */
    fun saveFractalObject( file: File) {
        ObjectOutputStream(FileOutputStream(file)).use { out ->
            out.writeObject(this)
        }
    }

    /**
     * Загрузка объекта из файла .fractal
     */
    fun loadFractalObject(path:String,filename:String) {
        ObjectInputStream(FileInputStream("$path/$filename ")).use { input ->
            val l = input.readObject() as FractalSaving
            selectionStart = l.selectionStart
            selectionEnd = l.selectionEnd
            fractalName = l.fractalName
            color = l.color
        }
    }

}
