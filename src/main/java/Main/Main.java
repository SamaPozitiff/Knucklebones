package Main;

import Model.Field;

public class Main {
    public static void main (String[] args) {
        Field field = new Field();
        field.addToField(0, 5);
        field.addToField(0, 5);
        field.addToField(2, 3);
        field.addToField(2, 3);
        field.addToField(2, 3);
        field.addToField(1, 4);
        int[][] array = field.getField();
        System.out.println(array.length);
        System.out.println(array[0].length);
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        int[][] scores = field.getScores();
        for (int i = 0; i < scores.length; i++){
            System.out.println(scores[i][0]);
        }
    }
}
