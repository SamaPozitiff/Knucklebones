package Model;

import java.util.HashMap;
import java.util.Map;

public class Field {
    private int [][] field;
    private int [] rowScores;
    private int finalScore;
    private static final int FIELD_SIZE = 3;

    public Field(){
        field = new int[3][3];
        rowScores = new int[3];
    }

    public int[][] getField() {
        return field;
    }

    public int[] getRowScores() {
        return rowScores;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void addToField(int row, int value){
        for (int i = 0; i < FIELD_SIZE; i++){
            if(field[row][i] == 0){
                field[row][i] = value;
                break;
            }
        }
        countRowScore(row);
        countFinalScore();
    }

    public void countRowScore (int row){
        rowScores[row] = 0;
        Map<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < FIELD_SIZE; i++){
            if(values.containsKey(field[row][i])){
                values.put(field[row][i], values.get(field[row][i])+1);
            } else {
                values.put(field[row][i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry: values.entrySet()){
            if (entry.getValue() == 1){
                rowScores[row]+= entry.getKey();
            } else if(entry.getValue() == 2){
                rowScores[row]+= (entry.getKey() * 2)*2;
            }else if (entry.getValue() == 3){
                rowScores[row]+= ((entry.getKey() * 2)*2)*2 + entry.getKey();
            }
        }
    }

    public void countFinalScore(){
        finalScore = 0;
        for (int i = 0; i < rowScores.length; i++){
            finalScore+= rowScores[i];
        }
    }

}
