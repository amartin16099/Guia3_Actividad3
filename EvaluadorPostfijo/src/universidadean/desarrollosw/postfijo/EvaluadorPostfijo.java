/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Evaluador de Expresiones Postfijas
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.postfijo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.*;

/**
 * Esta clase representa una clase que evalúa expresiones en notación polaca o
 * postfija. Por ejemplo: 4 5 +
 */
public class EvaluadorPostfijo {

    /**
     * Permite saber si la expresión en la lista está balanceada
     * o no. Cada elemento de la lista es un elemento. DEBE OBlIGATORIAMENTE
     * USARSE EL ALGORITMO QUE ESTÁ EN EL ENUNCIADO.
     */
    static boolean estaBalanceada(List<String> expresion) {
        Stack<String> delimitadores = new Stack<>();

        // TODO: Escriba el algoritmo del enunciado aquí

        return delimitadores.isEmpty();
    }

    /**
     * Transforma la expresión, cambiando los símbolos de agrupación
     * de corchetes ([]) y llaves ({}) por paréntesis ()
     */
    static void reemplazarDelimitadores(List<String> expresion) {
        // TODO: Escriba el algoritmo aquí
    }

    /**
     * Realiza la conversión de la notación infija a postfija
     * @return la expresión convertida a postfija
     * OJO: Debe usarse el algoritmo que está en el enunciado OBLIGATORIAMENTE
     */
    static List<String> convertirAPostfijo(List<String> expresion) {
        Stack<String> pila = new Stack<>();
        List<String> salida = new ArrayList<>();

        // TODO: Escriba el algoritmo aquí

        return salida;
    }

    /**
     * Realiza la evaluación de la expresión postfijo utilizando una pila
     * @param expresion una lista de elementos con números u operadores
     * @return el resultado de la evaluación de la expresión.
     */
    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();
        
        for (String elemento : expresion) {
            if (esOperando(elemento)) {
                pila.push(Integer.parseInt(elemento));
            } else if (esOperador(elemento)) {
                if (pila.size() < 2) {
                    throw new IllegalArgumentException("Expresión postfija no válida: no hay suficientes operandos.");
                }
                int operand2 = pila.pop();
                int operand1 = pila.pop();
                int resultado;
                if (elemento.equals("+")) {
                    resultado = operand1 + operand2;
                } else if (elemento.equals("-")) {
                    resultado = operand1 - operand2;
                } else if (elemento.equals("*")) {
                    resultado = operand1 * operand2;
                } else if (elemento.equals("/")) {
                    if (operand2 == 0) {
                        throw new ArithmeticException("División por cero.");
                    }
                    resultado = operand1 / operand2;
                } else if (elemento.equals("%")) {
                    if (operand2 == 0) {
                        throw new ArithmeticException("Módulo por cero.");
                    }
                    resultado = operand1 % operand2;
                } else {
                    throw new IllegalArgumentException("Operador no válido: " + elemento);
                }
                pila.push(resultado);
            }
        }

        if (pila.size() != 1) {
            throw new IllegalArgumentException("Expresión postfija no válida: formato incorrecto.");
        }

        return pila.pop();
    }

}
