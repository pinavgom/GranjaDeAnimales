/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/**
 *
 * @author ohmp9
 */
public abstract class Animal {

    /**
     *
     */
    protected String codigo;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso;
/**
      * Constructor de la clase Animal.
     *
     * Realiza validaciones sobre los parámetros:
     * El código debe tener exactamente 5 caracteres que sean dígitos (0-9) o letras minúsculas (a-z)
     * El sexo debe ser 'M' (hembra) o 'H' (macho).
     * El peso debe ser un valor positivo mayor que cero.
     * La fecha de nacimiento debe estar en formato ISO-8601 (yyyy-MM-dd) válido.
     *    
     * Si algún parámetro no cumple estas condiciones, se lanza una excepción IllegalArgumentException 
     * 
 * @param codigo el código identificativo del animal, compuesto por 5 caracteres alfanuméricos en minúscula
 * @param fechaNacimiento la fecha de nacimiento del animal en formato "yyyy-MM-dd"
 * @param sexo el sexo del animal, 'M' para hembra o 'H' para macho
 * @param peso el peso del animal en kilogramos, debe ser mayor que 0
 * @throws IllegalArgumentException si el código no cumple el patrón, el sexo es incorrecto, el peso no es poto, el psitivo o la fecha no tiene un formato válido
 */
    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) {

        LocalDate fecha;

        if (!codigo.matches("[0-9a-z]{5}") || (sexo != 'M' && sexo != 'H') || (peso <= 0)) {
            throw new IllegalArgumentException();
        } else {

            try {
                fecha = LocalDate.parse(fechaNacimiento);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException();
            }
            this.codigo = codigo;
            this.fechaNacimiento = fecha;
            this.sexo = sexo;
            this.peso = peso;
        }
    }

    /**
     * Devuelve el código identificativo del animal.
     *
     * @return el código del animal, cadena de 5 caracteres alfanuméricos en minúscula
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece un nuevo código identificativo para el animal.
     * El código debe tener exactamente 5 caracteres que sean dígitos (0-9) o letras minúsculas (a-z).
     *
     * @param codigo el nuevo código del animal
     * @throws IllegalArgumentException si el código no cumple el patrón requerido
     */
    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }

    /**
     * Devuelve la fecha de nacimiento del animal.
     *
     * @return la fecha de nacimiento como objeto {@link LocalDate}
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece una nueva fecha de nacimiento para el animal.
     * La fecha debe estar en formato ISO-8601 (yyyy-MM-dd).
     *
     * @param fechaNacimiento la nueva fecha de nacimiento en formato "yyyy-MM-dd"
     * @throws IllegalArgumentException si la cadena no representa una fecha válida en formato ISO-8601
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException();
        }

        this.fechaNacimiento = fecha;
    }

    /**
     * Devuelve el sexo del animal.
     *
     * @return 'M' si el animal es hembra, 'H' si el animal es macho
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del animal.
     * El valor debe ser 'M' (hembra) o 'H' (macho).
     *
     * @param sexo el sexo del animal, 'M' para hembra o 'H' para macho
     * @throws IllegalArgumentException si el valor no es 'M' ni 'H'
     */
    public void setSexo(char sexo) {
        if ((sexo != 'M' && sexo != 'H')) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }

    /**
     * Devuelve el peso del animal en kilogramos.
     *
     * @return el peso del animal, valor positivo mayor que cero
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso del animal en kilogramos.
     * El valor debe ser mayor que cero.
     *
     * @param peso el nuevo peso del animal en kilogramos
     * @throws IllegalArgumentException si el peso es menor o igual a cero
     */
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }

    /**
     * Devuelve un código hash para este objeto Animal basado en todos sus atributos:
     * código, fecha de nacimiento, sexo y peso.
     *
     * @return el valor del código hash del objeto
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + this.sexo;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

    /**
     * Compara este Animal con otro objeto para determinar si son iguales.
     * Dos animales se consideran iguales si tienen el mismo código, fecha de nacimiento,
     * sexo y peso. También comprueba que ambos objetos sean exactamente de la misma clase.
     *
     * @param obj el objeto con el que se compara
     * @return {@code true} si los objetos son iguales; {@code false} en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en cadena de texto del objeto Animal,
     * mostrando todos sus atributos: código, fecha de nacimiento, sexo y peso.
     *
     * @return cadena de texto con el formato:
     *         {@code Animal{codigo=..., fechaNacimiento=..., sexo=..., peso=...}}
     */
    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }

    /**
     * Devuelve una cadena de texto que representa el sonido característico del animal.
     * Cada subclase concreta debe implementar este método con su propio sonido.
     *
     * @return el sonido que emite el animal
     */
    public abstract String hacerSonido();

    /**
     * Devuelve una cadena de texto que describe el comportamiento del animal cuando se alegra.
     * Cada subclase concreta debe implementar este método según su comportamiento propio.
     *
     * @return descripción del comportamiento del animal al alegrarse
     */
    public abstract String alegrarse();

    /**
    * Devuelve una cadena de texto que describe el comportamiento del animal cuando se enfada.
     * Cada subclase concreta debe implementar este método según su comportamiento propio.
     *
     * @return descripción del comportamiento del animal al enfadarse
     */
    public abstract String enfadarse();

    /**
     * Devuelve una cadena de texto que identifica el tipo de animal.
     * Cada subclase concreta debe implementar este método indicando qué tipo de animal es.
     *
     * @return descripción del tipo de animal
     */
    public abstract String queSoy();

}
