/*fila 3, silla 14
Puse que de limite 10 rondas pero solo porque no sabia si teniamos que poner un limite, pero "funciona" con mas.
Hice lo que pude ;]
Desgraciadamente no supe pasar la matriz ;[
Bueno no se para que te cuento si lo vas a ver ahora
Buenas noches, o dias, o madrugada yo que se*/
package lab8p1_carlosflores;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import static lab8p1_carlosflores.Lab8P1_CarlosFlores.array_coord;
import static lab8p1_carlosflores.Lab8P1_CarlosFlores.entero_rondas;
import static lab8p1_carlosflores.Lab8P1_CarlosFlores.imprimir;
import static lab8p1_carlosflores.Lab8P1_CarlosFlores.matriz1;
import static lab8p1_carlosflores.Lab8P1_CarlosFlores.r;
import static lab8p1_carlosflores.Lab8P1_CarlosFlores.read;

public class Game {
    
    static Random r = new Random();
    static Scanner read = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion = 0;
        System.out.println("---MENU---\n1-Game of Life\n2-Salir\nIngrese una opcion:");
        opcion = read.nextInt();
        while(opcion > 2 || opcion <1){
            System.out.print("Opcion no valida, intente otra vez:");
            opcion = read.nextInt();
        }
        while(opcion != 2){
            int [][] matriz;
            matriz = matriz1();
            ArrayList<String> array_coord = new ArrayList<>();
            Print(array_coord, matriz);
            System.out.println();
            int x = entero_rondas();
            System.out.println(x);
            jugar(x, matriz, array_coord);
            
            System.out.println();
            System.out.println("---MENU---\n1-Game of Life\n2-Salir\nIngrese una opcion:");
            opcion = read.nextInt();
            while(opcion > 2 || opcion <1){
                System.out.print("Opcion no valida, intente otra vez:");
                opcion = read.nextInt();
            }
        }
    }
    
    public static void imprimir(int [][] matriz){
        for(int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("\n");
        }
    }
    
    public static void jugar(int x, int [][] matriz, ArrayList<String> coordenadas){
        for (int i = 1; i <= x; i++) {
            System.out.println("Ronda " + i + ":\n");
            Print(coordenadas, matriz);
            nextGen(matriz);
        }
    }
    
    public static void nextGen(int [][] matriz){
        int vecin = 0;
        int vecin2 = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] == 1){
                    if(matriz[i-1][j-1] == 1){
                        vecin++;
                    }
                    if(matriz[j-1][i] == 1){
                        vecin++;
                    }
                    if(matriz[j-1][i+1] == 1){
                        vecin++;
                    }
                    if(matriz[j][i-1] == 1){
                        vecin++;
                    }
                    if(matriz[j][i+1] == 1){
                        vecin++;
                    }
                    if(matriz[j+1][i-1] == 1){
                        vecin++;
                    }
                    if(matriz[j+1][i] == 1){
                        vecin++;
                    }
                    if(matriz[j+1][i+1] == 1){
                        vecin++;
                    }
                }
                if(vecin != 2){
                    matriz[i][j] = 0;
                }
                if(matriz[i][j] == 0 && i != 0 && i != 9 && j != 0 && j != 9){
                    if(matriz[i-1][j-1] == 1){
                        vecin2++;
                    }
                    if(matriz[j-1][i] == 1){
                        vecin2++;
                    }
                    if(matriz[j-1][i+1] == 1){
                        vecin2++;
                    }
                    if(matriz[j][i-1] == 1){
                        vecin2++;
                    }
                    if(matriz[j][i+1] == 1){
                        vecin2++;
                    }
                    if(matriz[j+1][i-1] == 1){
                        vecin2++;
                    }
                    if(matriz[j+1][i] == 1){
                        vecin2++;
                    }
                    if(matriz[j+1][i+1] == 1){
                        vecin2++;
                    }
                }
                if(vecin2 == 2){
                    matriz[i][j] = 1;
                }
                vecin = 0;
                vecin2 = 0;
            }
        }
    }
    public static void array_coord(int [][] matriz){
        ArrayList<String> coordenadas = new ArrayList<>();
        for(int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if(matriz[i][j] != 0 ){
                    coordenadas.add(j + "," + i);
                }
            }
        }
        System.out.print("[");
        for (int i = 0; i < coordenadas.size(); i++){
            System.out.print(coordenadas.get(i)+ "|");
        }
        System.out.print("]\n\n");
    }
    public static int [][] Print(ArrayList<String> coordenadas, int [][] matriz){
        array_coord(matriz);
        int cont  = 0;
        int [][] temporal = matriz;
        for (int i = 0; i < temporal.length; i++) {
            for (int j = 0; j < temporal[i].length; j++) {
                for (int k = 0; k < coordenadas.lastIndexOf(k); k++) {
                    if(coordenadas.get(k).contentEquals(j + ":" + i)){
                        temporal[i][j] = 1;
                    }else{
                        temporal[i][j] = 0;
                    }
                }
                System.out.print("[" + temporal[i][j] + "]");
            }
            System.out.println("\n");
        }
        return temporal;
    }
    
    
    public static int [][] matriz1(){
        int[][] temporal = new int [10][10];
        for (int i = 0; i < temporal.length; i++) {
            for (int j = 0; j < temporal[i].length; j++) {
                if(i == 0 || i == 9 || j == 0 || j == 9){
                    temporal[i][j] = 0;
                }else{
                    temporal[i][j] = r.nextInt(2);
                }
            }
        }
        return temporal;
    }
    
    public static int entero_rondas(){
        int temporal = 0;
        int rondas = 0;
        System.out.print("Ingrese el numero de rondas: ");
        rondas = read.nextInt();
        while(rondas > 10 || rondas < 1){
            System.out.println("No pueden haber " + rondas + " rondas, intente otra vez:");
            rondas = read.nextInt();
        }
        temporal = rondas;
        return temporal;
    }
    
}
