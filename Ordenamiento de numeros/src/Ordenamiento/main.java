package Ordenamiento;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Ordenamiento arreglo = new Ordenamiento();
        int[] arregloordenado = new int [10000];
        Scanner scanner = new Scanner(System.in);
        char opcion;

        do {
            //Cargamos el arreglo
            arreglo.carga();
            //Mostramos el arreglo sin ordenar
            arreglo.muestra();

            System.out.println("\nElija el metodo de ordenamiento:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Shell Sort");
            System.out.println("4. Bucket Sort");
            System.out.println("5. Quick Sort\n");
            System.out.println("6. Buscar elemento de forma Binaria");
            System.out.println("7. Buscar elemento de forma Lineal");
            int metodo = scanner.nextInt();

            switch (metodo) {
                case 1:
                    long startTime = System.currentTimeMillis(); // Inicio del contador de tiempo
                    arregloordenado = arreglo.bubbleSort();
                    long endTime = System.currentTimeMillis(); // Fin del contador de tiempo
                    //Mostramos el arreglo ordenado
                    arreglo.muestra();
                    System.out.println("\nTiempo de ejecucion: " + (endTime - startTime) + " milisegundos");
                    break;
                case 2:
                    long startTime1 = System.currentTimeMillis(); // Inicio del contador de tiempo
                    arregloordenado = arreglo.insertionSort();
                    long endTime1 = System.currentTimeMillis(); // Fin del contador de tiempo
                    //Mostramos el arreglo ordenado
                    arreglo.muestra();
                    System.out.println("\nTiempo de ejecucion: " + (endTime1 - startTime1) + " milisegundos");
                    break;
                case 3:
                    long startTime2 = System.currentTimeMillis(); // Inicio del contador de tiempo
                    arregloordenado = arreglo.shellSort();
                    long endTime2 = System.currentTimeMillis(); // Fin del contador de tiempo
                    //Mostramos el arreglo ordenado
                    arreglo.muestra();
                    System.out.println("\nTiempo de ejecucion: " + (endTime2 - startTime2) + " milisegundos");
                    break;
                case 4:
                    long startTime3 = System.currentTimeMillis(); // Inicio del contador de tiempo
                    arregloordenado = arreglo.bucketSort();
                    long endTime3 = System.currentTimeMillis(); // Fin del contador de tiempo
                    //Mostramos el arreglo ordenado
                    arreglo.muestra();
                    System.out.println("\nTiempo de ejecucion: " + (endTime3 - startTime3) + " milisegundos");
                    break;
                case 5:
                    long startTime4 = System.currentTimeMillis(); // Inicio del contador de tiempo
                    arregloordenado = arreglo.quickSort();
                    long endTime4 = System.currentTimeMillis(); // Fin del contador de tiempo
                    //Mostramos el arreglo ordenado
                    arreglo.muestra();
                    System.out.println("\nTiempo de ejecucion: " + (endTime4 - startTime4) + " milisegundos");
                    break;
                case 6:
                    long startTime6 = System.currentTimeMillis(); // Inicio del contador de tiempo
                    System.out.println("Ingrese un numero para buscar");
                    int num = scanner.nextInt();
                    int x=arreglo.BusquedaBinaria(arregloordenado, num);
                    if (x!=-1)
                    {
                        System.out.println("El numero se encontro en la posicion " + x);
                    }else{
                         System.out.println("No se encontro el numero buscado"); 
                    }
                    long endTime6 = System.currentTimeMillis(); // Fin del contador de tiempo
                    System.out.println("\nTiempo de ejecucion: " + (endTime6 - startTime6) + " milisegundos");
                    break;
                case 7:
                    
                    
                    
                    
                    
                    
                default:
                    System.out.println("Opcion no valida");
            }

            System.out.println("Desea ordenar otro arreglo? (s/n)");
            opcion = scanner.next().charAt(0);
        } while (opcion == 's' || opcion == 'S');
    }
}
