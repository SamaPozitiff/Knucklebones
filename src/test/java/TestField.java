import knucklebonesGame.model.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestField {
    @Test
    public void test1(){
        Field result = new Field();
        List<List<Integer>> expect = new ArrayList<>(3);
        expect.add(new ArrayList<>());
        expect.add(new ArrayList<>());
        expect.add(new ArrayList<>());
        result.addValueToRow(0, 5);
        expect.get(0).add(5);
        result.addValueToRow(0, 5);
        expect.get(0).add(5);
        result.addValueToRow(2, 3);
        expect.get(2).add(3);
        result.addValueToRow(2, 3);
        expect.get(2).add(3);
        result.addValueToRow(2, 3);
        result.addValueToRow(2,3);
        expect.get(2).add(3);
        result.addValueToRow(1, 4);
        expect.get(1).add(4);
        Assertions.assertTrue(expect.containsAll(result.getField()));
       Assertions.assertArrayEquals(new int[]{20,4,27}, result.getRowScores());
       Assertions.assertEquals(51, result.getFinalScore());
    }
    @Test
    public void test2(){
        Field result = new Field();
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(new ArrayList<>());
        expect.add(new ArrayList<>());
        expect.add(new ArrayList<>());
        result.addValueToRow(0, 5);
        expect.get(0).add(5);
        result.addValueToRow(0, 4);
        expect.get(0).add(4);
        result.addValueToRow(0, 3);
        expect.get(0).add(3);
        Assertions.assertEquals(expect, result.getField());
        Assertions.assertArrayEquals(new int[]{12,0,0}, result.getRowScores());
        result.removeValueFromRow(0, 5);
        expect.get(0).remove(Integer.valueOf(5));
        Assertions.assertEquals(expect, result.getField());
    }

    @Test
    public void test3(){
        Field result = new Field();
        List <List<Integer>> expect = new ArrayList<>();
        expect.add(new ArrayList<>());
        expect.add(new ArrayList<>());
        expect.add(new ArrayList<>());
        result.addValueToRow(1, 6);
        expect.get(1).add(6);
        result.addValueToRow(1,6);
        expect.get(1).add(6);
        result.addValueToRow(1,4);
        expect.get(1).add(4);
        result.removeValueFromRow(1,6);
        expect.get(1).removeAll(Arrays.asList(6));
        Assertions.assertEquals(expect, result.getField());
    }
}
