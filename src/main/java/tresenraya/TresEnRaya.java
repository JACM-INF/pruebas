/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tresenraya;

import java.util.Scanner;

/**
 *
 * @author Patry
 */
public class TresEnRaya {

    /**
     * @param args the command line arguments
     */
    static char[][] tablero = new char[3][3];
    static Scanner sc = new Scanner(System.in);
    static char jugadorActual = 'O';

    public static void main(String[] args) {
        // TODO code application logic here
        inicializarTablero();
        imprimirTablero();
        do {
            
            cambiarJugador();
            turno();
           
        } while (!hayGanador() && !hayEmpate());
        
        if (hayGanador()) {
            System.out.println("El jugador "
                    + jugadorActual + " ha ganado!!!\nGAME OVER");
        } else {
            System.out.println("�Empate!");
        }
    }

    static void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    static void imprimirTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void turno() {
        System.out.println("Jugador " + jugadorActual + ", es tu turno.");
        
        int fila= pedirCasilla("fila");
        int columna = pedirCasilla("columna");
        
        if (tablero[fila][columna] == '-') {
            tablero[fila][columna] = jugadorActual;
            imprimirTablero();
        } else {
            System.out.println("Esa casilla ya está ocupada. Inténtalo de nuevo.");
            turno();
        }
    }

    static int pedirCasilla(String tipo) {       
        int casilla =-1;
        do {
            System.out.printf("\nIngresa la %s (1-3): ",tipo);
            String dato = sc.nextLine();
            if (dato != null ){
                try {
                    casilla = Integer.parseInt(dato) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Dato incorrecto. Solo numeros (0-2)");
                }
            }
        } while (!(casilla >=0 && casilla <=2));
                
        return casilla;
    }

    static void cambiarJugador() {
        if (jugadorActual == 'X') {
            jugadorActual = 'O';
        } else {
            jugadorActual = 'X';
        }
    }

    static boolean hayGanador() {
        // Comprobamos filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual
                    && tablero[i][1] == jugadorActual
                    && tablero[i][2] == jugadorActual) {
                return true;
            }
        }
        // Comprobamos columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == jugadorActual
                    && tablero[1][j] == jugadorActual
                    && tablero[2][j] == jugadorActual) {
                return true;
            }
        }
        // Comprobamos diagonales
        if (tablero[0][0] == jugadorActual
                && tablero[1][1] == jugadorActual
                && tablero[2][2] == jugadorActual) {
            return true;
        }
        if (tablero[0][2] == jugadorActual
                && tablero[1][1] == jugadorActual
                && tablero[2][0] == jugadorActual) {
            return true;
        }
        return false;
    }

    static boolean hayEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

}
