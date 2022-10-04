import Model.Field;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class TestField {
    @Test
    public void test1(){
        Field field = new Field();
        field.addToField(0, 5);
        field.addToField(0, 5);
        field.addToField(2, 3);
        field.addToField(2, 3);
        field.addToField(2, 3);
        field.addToField(1, 4);
        Assert.assertEquals(new int[][]{{5,5,0},{4,0,0},{3,3,3}}, field.getField());
        Assert.assertEquals(new int[]{20,4,27}, field.getRowScores());
        Assert.assertEquals(51, field.getFinalScore());
    }
}
