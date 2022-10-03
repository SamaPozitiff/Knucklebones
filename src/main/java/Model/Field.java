package Model;

import java.util.HashMap;
import java.util.Map;

public class Field {
    private int [][] field;
    private int [][] scores;
    private static final int FIELD_SIZE = 3;

    public Field(){
        field = new int[3][3];
        scores = new int[3][1];
    }

    public int[][] getField() {
        return field;
    }

    public int[][] getScores() {
        return scores;
    }

    public void addToField(int row, int value){
        for (int i = 0; i < FIELD_SIZE; i++){
            if(field[row][i] == 0){
                field[row][i] = value;
                break;
            }
        }
        countRowScore(row);
    }

    public void countRowScore (int row){
        scores[row][0] = 0;
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
                scores[row][0]+= entry.getKey();
            } else if(entry.getValue() == 2){
                scores[row][0]+= (entry.getKey() * 2)*2;
            }else if (entry.getValue() == 3){
                scores[row][0]+= ((entry.getKey() * 2)*2)*2 + entry.getKey();
            }
        }



    }


}
