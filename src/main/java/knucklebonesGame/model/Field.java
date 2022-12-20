package knucklebonesGame.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Field {
    private static final int FIELD_SIZE = 3;
    private List<List<Integer>> field = new ArrayList<>(FIELD_SIZE);
    private int[] rowScores;
    private int finalScore;



    @Bean ("allyField")
    public Field getAllyField(){
        return new Field();

    }

    @Bean("enemyField")
        public Field getEnemyField(){
            return new Field();
    }

    public Field() {
        field.add(0, new ArrayList<>());
        field.add(1, new ArrayList<>());
        field.add(2, new ArrayList<>());
        rowScores = new int[FIELD_SIZE];
    }

    public List<List<Integer>> getField() {
        return field;
    }

    public int[] getRowScores() {
        return rowScores;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void addValueToRow(int row, int value) {
        if (field.get(row).size() >= FIELD_SIZE){
            return;
        }
        field.get(row).add(value);
        countRowScore(row);
        countFinalScore();
    }

   public void countRowScore(int row) {
           rowScores[row] = 0;
        Map<Integer, Integer> values = new HashMap<>();
        for(int i = 0; i < field.get(row).size(); i++){
            if (values.containsKey(field.get(row).get(i))){
                values.put(field.get(row).get(i), values.get(field.get(row).get(i)) + 1);
            } else {
                values.put(field.get(row).get(i), 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : values.entrySet()) {
            if (entry.getValue() == null){
                return;
            }
            if (entry.getValue() == 1) {
                rowScores[row] += entry.getKey();
            } else if (entry.getValue() == 2) {
                rowScores[row] += (entry.getKey() * 2) * 2;
            } else if (entry.getValue() == 3) {
                rowScores[row] += ((entry.getKey() * 2) * 2) * 2 + entry.getKey();
            }
        }
    }

    public void countFinalScore() {
        finalScore = 0;
        for (int rowScore : rowScores) {
            finalScore += rowScore;
        }
    }

    public void removeValueFromRow(int row, int value) {
        field.get(row).removeAll(Arrays.asList(value));
        countRowScore(row);
        countFinalScore();
    }

}
