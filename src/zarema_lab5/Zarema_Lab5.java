
package zarema_lab5;

import java.util.prefs.Preferences;


public class Zarema_Lab5 {

    public static void main(String[] args) {
        // Инициализация данных
        Preferences node = Preferences.userRoot().node("zarema_data");
        
        // Вывод данных о задании на экран
        System.out.println("Лабораторная работа 5");
        System.out.println("Если максимальный элемент находится в первом столбце, то увеличить все элементы третьей строки на 10");
        
        // Создание исходных данных (элементов массива) и вывод их на экран
        final int r = 4;
        final int c = 4;
        int m[][] = new int[r][c];
        int k;
        System.out.println("Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                k = (int) Math.round(Math.random() * 9);
                m[i][j] = k;
                System.out.print(k + " ");
            }
            System.out.println("");
        }
        // Реализация алгоритма варианта задания 
           int max = m[0][0], maxi = 0, maxj = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    k = m[i][j];
                    if (k > max) {
                        max = k;
                        maxi = i;
                        maxj = j;
                    }
                }
            }
            for (int i = 0; i < r; i+=4)
            if (maxj == i)
                for (int j = 0; j<c; j++)
                    m[2][j]=max*10;
            // Сохранение обработанных данных массива
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                node.putInt("M" + i + j, m[i][j]);
            }
        }
        // Считывание данных итогового массива
        System.out.println("New matrix:");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(node.getInt("M" + i + j, 0) + " ");
                }
                System.out.println("");
            }
    }
    }
