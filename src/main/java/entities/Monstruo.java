package entities;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("monstruos")
public class Monstruo {
    @ExcelCellName("NOMBRE")
    private String nombre;
    @ExcelCellName("EDAD")
    private int edad;
    @ExcelCellName("PESO")
    private double peso;
    @ExcelCellName("GENERO")
    private String genero;
    @ExcelCellName("TIPO")
    private String tipo;
    @ExcelCellName("NIVEL")
    private double nivel;

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public double getPeso() {
        return peso;
    }

    public String getTipo() {
        return tipo;
    }

    public double getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        final var multiline = """
                {
                nombre: %s
                edad: %d
                peso: %.2f
                genero: %s
                tipo: %s
                nivel: %f
                }
                """;
        return String.format(multiline,
                nombre, edad, peso, genero, tipo, nivel);
    }
}
