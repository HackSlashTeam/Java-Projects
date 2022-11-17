package Matrix;

import Color.RGB;

import java.util.ArrayList;
import java.util.List;

public class MatricesWithPair {
    public List<Pair<Integer, List<List<Double>>>> matrices = new ArrayList<>();

    public void add(int Key, List<List<Double>> lists) {
        matrices.add(new Pair<>(Key, lists));
    }

    public void display(int index) {
        get(index).getValue().forEach(list -> {
            System.out.print(RGB.Shape("|") + RGB.Digit);
            list.forEach(number -> System.out.printf("    %-7s", number.toString()));
            System.out.println(RGB.Shape("|"));
        });
    }

    public Pair<Integer, List<List<Double>>> get(int index) {
        return matrices.get(index);
    }

    public List<Double> get(int index, int row) {
        return matrices.get(index).getValue().get(row);
    }

    public int size() {
        return matrices.size();
    }

    public static class Pair<T, V> {
        T key;
        V value;

        public Pair(T key, V value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
