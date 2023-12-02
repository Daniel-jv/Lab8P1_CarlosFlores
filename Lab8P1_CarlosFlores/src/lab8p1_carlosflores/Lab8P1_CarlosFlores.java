/*fila 3, silla 14
Puse que de limite 10 rondas pero solo porque no sabia si teniamos que poner un limite, pero "funciona" con mas.
Hice lo que pude ;]
Desgraciadamente no supe pasar la matriz ;[
Bueno no se para que te cuento si lo vas a ver ahora
Buenas noches, o dias, o madrugada yo que se*/
package lab8p1_carlosflores;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Lab8P1_CarlosFlores {

    static Random r = new Random();
    static Scanner read = new Scanner(System.in);
    
    public static void main(String[] args) {
        int [][] matriz;
        matriz = matriz1();
        
        array_coord(matriz);
        System.out.println("\n");
        imprimir(matriz);
        
        System.out.println();
    }
    
    public static void imprimir(int [][] matriz){
        for(int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("\n");
        }
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
    
    public static void array_coord(int [][] matriz){
        
        System.out.println("Celulas vivas: ");
        ArrayList<String> coordenadas = new ArrayList<>();
        for(int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if(matriz[i][j] != 0 ){
                    coordenadas.add(j + ":" + i);
                }
            }
        }
        System.out.print("[");
        for (int i = 0; i < coordenadas.size(); i++){
            System.out.print(coordenadas.get(i)+ ",");
            if(i == coordenadas.size()/ 2){
                System.out.println();
            }
        }
        System.out.print("]");
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
        return temporal;
    }
    
}