import Model.Field;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class TestField {
    @Test
    public void test1(){
        Field field = new Field();
        field.addValueToRow(0, 5);
        field.addValueToRow(0, 5);
        field.addValueToRow(2, 3);
        field.addValueToRow(2, 3);
        field.addValueToRow(2, 3);
        field.addValueToRow(1, 4);
        Assert.assertEquals(new int[][]{{5,5,0},{4,0,0},{3,3,3}}, field.getField());
        Assert.assertEquals(new int[]{20,4,27}, field.getRowScores());
        Assert.assertEquals(51, field.getFinalScore());
    }
    @Test
    public void test2(){
        Field field = new Field();
        field.addValueToRow(0, 5);
        field.addValueToRow(0, 4);
        field.addValueToRow(0, 3);
        Assert.assertEquals(new int[][]{{5,4,3},{0,0,0},{0,0,0}}, field.getField());
        Assert.assertEquals(new int[]{12,0,0}, field.getRowScores());
        field.removeValueFromRow(0, 5);
        Assert.assertEquals(new int[][]{{4,3,0},{0,0,0},{0,0,0}}, field.getField());
    }

    @Test
    public void test3(){
        Field field = new Field();
        field.addValueToRow(1, 6);
        field.addValueToRow(1,6);
        field.addValueToRow(1,4);
        field.removeValueFromRow(1,6);
        Assert.assertEquals(new int[][] {{0,0,0},{4,0,0},{0,0,0}}, field.getField());
    }
}
