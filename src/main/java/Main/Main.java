package Main;

import Model.Field;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        Field field = new Field();
        field.addValueToRow(1, 6);
        field.addValueToRow(1,6);
        field.addValueToRow(1,4);
        field.removeValueFromRow(1,6);
        System.out.println(Arrays.toString(field.getField()[1]));
    }
}
