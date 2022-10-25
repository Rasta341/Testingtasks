package org.example;
import java.util.Scanner;

 class Stack {
    String topResumeSalary;
    int maxResumeAmount;
     public Stack() { }
    
     public void setMaxResumeAmount(int maxResumeAmount) { //кол-во резюме в стопке
         this.maxResumeAmount = maxResumeAmount;
     }
     
     public void setTopResumeSalary(String topResumeSalary) { //значение зарплаты в верхнем резюме
         this.topResumeSalary = topResumeSalary;
     }
     public boolean isEmpty() { //проверяем не пустая ли стопка
         if(!topResumeSalary.contains("-")) {
             int[] stack = new int[maxResumeAmount];
             stack[0] = Integer.parseInt(topResumeSalary);
         return false;
         } else {
         return true;
         }
     }
    
     public int getTopResumeSalary() {
         return Integer.parseInt(topResumeSalary);
     }
 }

public class Main {
    public static void main(String[] args) {
        /*
        +1. Ввод данных в строке:
           1: размер1 размер2 макс зп
           2: зп1 зп2
           3: зп1 зп2
           4: до знака -
        2. как обойти "-"???????
        3. Посчитать сумму
        4. Вернуть кол-во резюме
         */
        int counterOfResume = 0; //Счетчик резюме
        int sumCurrent = 0; //сумма зарплат из взятых резюме
        Stack stackA = new Stack(); //стопка А
        Stack stackB = new Stack(); //стопка Б
    
        Scanner s = new Scanner(System.in);
        String firstInput = s.nextLine(); //Задаем величину стопок и максимальную сумму зарплат
        String[] firstInputArr = firstInput.split(" ");
        
        int sumMax = Integer.parseInt(firstInputArr[2]);
        stackA.setMaxResumeAmount(Integer.parseInt(firstInputArr[0]));
        stackB.setMaxResumeAmount(Integer.parseInt(firstInputArr[1]));
        
        while(sumCurrent < sumMax) { //пока сумма зарплат из взятых резюме не достигнет заданной суммы
            String secondInput;
            secondInput = s.nextLine(); //получаем одной строкой два верхних резюме с двумя величинами зарплат
            String[] secondInputArr = secondInput.split(" "); //делим строку на массив из двух элементов
            
            stackA.setTopResumeSalary(secondInputArr[0]); //присваиваем 0-й элемент первой стопке
            stackB.setTopResumeSalary(secondInputArr[1]); //присваиваем 1-й элемент второй стопке
            
            if (stackA.isEmpty() == false | stackB.isEmpty() == false) {         //если стопки не пустые, прибавляем к текущей сумме резюме
                sumCurrent += Math.min(stackA.getTopResumeSalary(),stackB.getTopResumeSalary());    // значение зарплаты из верхнего резюме
                counterOfResume++; //увеличиваем счетчик резюме на 1
            }
        }
        System.out.println(counterOfResume);
    }
}
