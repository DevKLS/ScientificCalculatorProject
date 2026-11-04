
package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScientificCalculatorTest {

    private ScientificCalculator calculator;

    // ==========================================
    // TEST FIXTURE - EXERCICIO 4
    // ==========================================

    @BeforeEach
    void setUp() {
        calculator = new ScientificCalculator();
    }

    // ==========================================
    // GRUPO 1 - OPERACOES ARITMETICAS
    // ==========================================

    // EXERCICIO 2 - Teste de soma
    @Test
    void testAddition() {

        double a = 10.0;
        double b = 5.0;

        double result = calculator.add(a, b);

        assertEquals(15.0, result, 0.0001);
    }

    // EXERCICIO 3 - Quatro fases do teste
    @Test
    void testSubtractPositiveNumbers() {

        // SETUP: preparacao dos dados
        double a = 10.0;
        double b = 4.0;

        // EXECUTION: execucao da subtracao
        double result = calculator.subtract(a, b);

        // ASSERTION: verificacao do resultado
        assertEquals(6.0, result, 0.0001);

        // TEARDOWN: nao aplicavel.
        // Nao existem recursos externos para liberar.
    }

    @Test
    void testMultiplyPositiveNumbers() {

        double result = calculator.multiply(4.0, 3.0);

        assertEquals(12.0, result, 0.0001);
    }

    @Test
    void testDividePositiveNumbers() {

        double result = calculator.divide(10.0, 2.0);

        assertEquals(5.0, result, 0.0001);
    }

    @Test
    void testPowerPositiveNumbers() {

        double result = calculator.power(2.0, 3.0);

        assertEquals(8.0, result, 0.0001);
    }

    // ==========================================
    // GRUPO 2 - RAIZ QUADRADA
    // ==========================================

    // EXERCICIO 5 - Happy Path
    @Test
    void testSquareRootPositive() {

        double result = calculator.squareRoot(25.0);

        assertEquals(5.0, result, 0.0001);
    }

    // EXERCICIO 6 - Corner Case
    @Test
    void testSquareRootNegative() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.squareRoot(-9.0)
        );

        assertEquals("Negative number", exception.getMessage());
    }

    @Test
    void testSquareRootZero() {

        double result = calculator.squareRoot(0.0);

        assertEquals(0.0, result, 0.0001);
    }

    // ==========================================
    // GRUPO 3 - TESTES DE EXCECAO
    // ==========================================

    // EXERCICIO 7 - Divisao por zero
    @Test
    void testDivideByZero() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10.0, 0.0)
        );

        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    void testLogOfZeroThrowsException() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.log(0.0)
        );

        assertEquals(
                "Log of non-positive number",
                exception.getMessage()
        );
    }

    @Test
    void testLogOfNegativeNumberThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.log(-1.0)
        );
    }

    // ==========================================
    // GRUPO 4 - LOGARITMO E TRIGONOMETRIA
    // ==========================================

    // EXERCICIO 8 - Logaritmos de valores positivos
    @Test
    void testLogOfPositiveNumbers() {

        assertAll(
                () -> assertEquals(
                        1.0,
                        calculator.log(Math.E),
                        0.0001
                ),

                () -> assertEquals(
                        0.0,
                        calculator.log(1.0),
                        0.0001
                ),

                () -> assertEquals(
                        Math.log(10.0),
                        calculator.log(10.0),
                        0.0001
                )
        );
    }

    // EXERCICIO 8 - Senos de diferentes angulos
    @Test
    void testSinOfCommonAngles() {

        assertAll(
                () -> assertEquals(
                        0.5,
                        calculator.sin(30.0),
                        0.0001
                ),

                () -> assertEquals(
                        1.0,
                        calculator.sin(90.0),
                        0.0001
                ),

                () -> assertEquals(
                        0.0,
                        calculator.sin(0.0),
                        0.0001
                )
        );
    }

    // Teste complementar - Cosseno
    @Test
    void testCosOfCommonAngles() {

        assertAll(
                () -> assertEquals(
                        0.5,
                        calculator.cos(60.0),
                        0.0001
                ),

                () -> assertEquals(
                        1.0,
                        calculator.cos(0.0),
                        0.0001
                )
        );
    }
}
