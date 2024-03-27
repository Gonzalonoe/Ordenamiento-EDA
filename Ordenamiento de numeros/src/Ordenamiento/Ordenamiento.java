//eJERCICIO EDA
package Ordenamiento;

import java.util.Arrays;
import java.util.Random;


public class Ordenamiento {
    //Atributos
    private int[] datos;
    
    
    //Creamos un metodo para cargar el arreglo con 10000 numeros aleatorios
    public void carga(){
        datos = new int[10000];
        Random random = new Random();
        for (int i = 0; i < datos.length; i++) {
            datos[i] = random.nextInt(10000);
        }
    }
    
    //Creamos un metodo para para mostrar el contenido del arreglo
    public void muestra() {
    int contador = 0;
    for (int dato : datos) {
        System.out.print(dato + "| ");
        contador++;
        if (contador % 10 == 0) {
            System.out.println(); // Salto de línea después de cada grupo de 10 números
        }
    }
}

    
    //Implementamos el algoritmo de ordenamiento BubbleSort
    public int[] bubbleSort() {
        int n = datos.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (datos[j] > datos[j + 1]) {
                    // Intercambiamos datos[j] y datos[j+1]
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                }
            }
        }
        return datos;
                
    }
    
    //Implementamos el algoritmo de ordenamiento Insertion Sort
    public int[] insertionSort() {
        int n = datos.length;
        for (int i = 1; i < n; ++i) {
            int key = datos[i];
            int j = i - 1;

            //Aqui vamos a mover los elementos de datos[0..i-1] que son mayores que key
            // a una posicion adelante de su posición actual
            while (j >= 0 && datos[j] > key) {
                datos[j + 1] = datos[j];
                j = j - 1;
            }
            datos[j + 1] = key;
        }
        return datos;
    }
    
    // Implementamos el algoritmo de ordenamiento Shell Sort
    public int[] shellSort() {
        int n = datos.length;
        // Iniciar con un intervalo grande, luego reducir el intervalo
        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
            // Hacer un insertion sort para cada intervalo
            for (int i = intervalo; i < n; i++) {
                int temp = datos[i];
                int j;
                for (j = i; j >= intervalo && datos[j - intervalo] > temp; j -= intervalo) {
                    datos[j] = datos[j - intervalo];
                }
                datos[j] = temp;
            }
        }
        return datos;
    }
    
    //Implementamos el algoritmo de ordenamiento Shell Sort Bucket Sort
    public int[] bucketSort() {
        int n = datos.length;
        int max = getMax(datos);
        int[] cubeta = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            cubeta[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            cubeta[datos[i]]++;
        }

        int pos = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < cubeta[i]; j++) {
                datos[pos++] = i;
            }
        }
        return datos;
    }
    private int getMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    
    //Implementamos el metodo de ordenamiento QuickSort
    public int[] quickSort() {
        quickSort(0, datos.length - 1);
        return datos;
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }
    
    private int partition(int low, int high) {
        int pivot = datos[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (datos[j] < pivot) {
                i++;

                int temp = datos[i];
                datos[i] = datos[j];
                datos[j] = temp;
            }
        }

        int temp = datos[i + 1];
        datos[i + 1] = datos[high];
        datos[high] = temp;

        return i + 1;
    }
    
    //Implementamos el metodo de busqueda binaria
    public int BusquedaBinaria (int[] arr, int objetivo){
    
        int bajo = 0;
        int alto = arr.length - 1;

        while (bajo <= alto) {
            int medio = bajo + (alto - bajo) / 2;

            if (arr[medio] == objetivo) {
                return medio;
            } else if (arr[medio] < objetivo) {
                bajo = medio + 1; // Buscar en la mitad derecha
            } else {
                alto = medio - 1; // Buscar en la mitad izquierda
            }
            
        }

        return -1;
    }
}

