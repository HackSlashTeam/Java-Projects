package Matrix;

import Color.RGB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static Color.RGB.Error;
import static Color.RGB.Shape;
import static exception.Handle.round;

public class Matrices {
    public List<List<List<Double>>> matrices = new ArrayList<>();
    String filePath;

    public Matrices(String filePath) {
        this.filePath = filePath;
        if (new File(filePath).exists()) read();
    }

    public static void Gaws(List<List<Double>> l) {
        int nColumn = l.get(0).size() - 1;
        for (int i = l.size(); i > 0; i--) {
            for (int j = i - 1; j >= 0 && i != l.size(); j--) {
                double n = l.get(j).get(i);
                for (int k = nColumn; k >= j; k--)
                    l.get(j).set(k, round(l.get(j).get(k) - l.get(i).get(k) * n));
            }
            if (l.get(i - 1).get(i - 1) == 0) continue;
            for (int j = l.get(i - 1).size() - 1; j >= i - 1; j--) {
                l.get(i - 1).set(j, round(l.get(i - 1).get(j) / l.get(i - 1).get(i - 1)));
            }
        }
    }

    public static void Jordan(List<List<Double>> l) {
        for (int n = 0; n < l.size() - 1; n++) {
            for (int i = l.size() - 1; i > n; i--) {
                if (l.get(i).get(n) == 0) continue;
                if (l.get(i - 1).get(n) == 0) {
                    Collections.swap(l, i, i - 1);
                    continue;
                }
                double m = l.get(i).get(n);
                for (int j = n; j < l.get(i).size(); j++)
                    l.get(i).set(j, round(l.get(i).get(j) * l.get(i - 1).get(n) - m * l.get(i - 1).get(j)));
            }
        }
        Gaws(l);
    }

    public double det(List<List<Double>> m) {
        if (m.size() == 1 && m.get(0).size() == 1) return m.get(0).get(0);
        double det = 0;
        for (int i = 0; i < m.size(); i++) {
            List<List<Double>> v = new ArrayList<>();
            for (int j = 1; j < m.size(); j++) {
                List<Double> vv = new ArrayList<>();
                for (int k = 0; k < m.get(j).size(); k++)
                    if (k != i)
                        vv.add(m.get(j).get(k));
                v.add(vv);
            }
            det += (i % 2 == 0 ? 1 : -1) * m.get(0).get(i) * det(v);
        }
        return det;
    }

    public void read() {
        try {
            File file = new File(filePath);
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                List<List<Double>> Matrix2D = new ArrayList<>();
                for (String Line : scan.nextLine().trim().split("~")) {
                    List<Double> Matrix1D = new ArrayList<>();
                    for (String i : Line.split(",")) {
                        Matrix1D.add(Double.parseDouble(i));
                    }
                    Matrix2D.add(Matrix1D);
                }
                matrices.add(Matrix2D);
            }
        } catch (Exception e) {
            System.out.println("--> Error : " + e);
        }

    }

    public void write() {
        try {
            FileWriter file = new FileWriter(filePath, false);
            for (List<List<Double>> Matrix2D : matrices) {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < Matrix2D.size(); i++) {
                    for (int j = 0; j < Matrix2D.get(i).size(); j++) {
                        s.append(Matrix2D.get(i).get(j));
                        if (j + 1 != Matrix2D.get(i).size()) s.append(",");
                    }
                    if (i + 1 != Matrix2D.size()) s.append("~");
                }
                file.write(s + "\n");
                file.flush();
            }
        } catch (IOException e) {
            System.out.println("--> Error : " + e);
        }
    }

    public void add(List<List<Double>> lists) {
        matrices.add(lists);
        write();
    }

    public void Edit(int n, int row, int column, Double NewValue) {
        matrices.get(n).get(row).set(column, NewValue);
        write();
    }

    public void Delete(int n) {
        matrices.remove(n);
        write();
    }

    public MatricesWithPair FindByRow(int row) {
        MatricesWithPair matrix = new MatricesWithPair();
        for (int i = 0; i < matrices.size(); i++) {
            if (matrices.get(i).size() == row) matrix.add(i, matrices.get(i));
        }
        return matrix;
    }

    public MatricesWithPair FindByColumn(int column) {
        MatricesWithPair matrix = new MatricesWithPair();
        for (int i = 0; i < matrices.size(); i++) {
            if (matrices.get(i).get(0).size() == column) matrix.add(i, matrices.get(i));
        }
        return matrix;
    }

    public MatricesWithPair FindBySize(int row, int column) {
        MatricesWithPair matrix = new MatricesWithPair();
        for (int i = 0; i < matrices.size(); i++) {
            if (matrices.get(i).size() == row && matrices.get(i).get(0).size() == column)
                matrix.add(i, matrices.get(i));
        }
        return matrix;
    }

    public MatricesWithPair Square() {
        MatricesWithPair matrix = new MatricesWithPair();
        for (int i = 0; i < matrices.size(); i++) {
            if (matrices.get(i).size() == matrices.get(i).get(0).size())
                matrix.add(i, matrices.get(i));
        }
        return matrix;
    }

    public void display(int index) {
        display(get(index));
    }

    public void display(List<List<Double>> list) {
        list.forEach(l -> {
            System.out.print(RGB.Shape("|") + RGB.Digit);
            l.forEach(number -> System.out.printf("     %-8s", number.toString()));
            System.out.println(RGB.Shape("|"));
        });
    }

    public List<List<Double>> get(int index) {
        return matrices.get(index);
    }

    public List<Double> get(int index, int row) {
        return matrices.get(index).get(row);
    }

    public int size() {
        return matrices.size();
    }

    public void clear() {
        matrices.clear();
        write();
    }

    public void add(int indexMatrix1, int indexMatrix2) {
        List<List<Double>> list1 = get(indexMatrix1);
        List<List<Double>> list2 = get(indexMatrix2);
        List<List<Double>> list3 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            List<Double> list = new ArrayList<>();
            for (int j = 0; j < list1.get(i).size(); j++) {
                list.add(round(list1.get(i).get(j) + list2.get(i).get(j)));
            }
            list3.add(list);
        }
        matrices.add(list3);
        write();
    }

    public void add(int indexMatrix, double number) {
        List<List<Double>> list1 = get(indexMatrix);
        List<List<Double>> list2 = new ArrayList<>();
        for (List<Double> doubles : list1) {
            List<Double> list = new ArrayList<>();
            for (Double i : doubles) list.add(round(i + number));
            list2.add(list);
        }
        matrices.add(list2);
        write();
    }

    public boolean AddCheck(int index1, int index2) {
        if (get(index1).size() == get(index2).size() && get(index1).get(0).size() == get(index2).get(0).size())
            return false;
        System.out.println(Shape("--> ") + Error("Error : The Number of Rows And Columns in both Not Equal."));
        return true;
    }

    public void sub(int indexMatrix1, int indexMatrix2) {
        List<List<Double>> list1 = get(indexMatrix1);
        List<List<Double>> list2 = get(indexMatrix2);
        List<List<Double>> list3 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            List<Double> list = new ArrayList<>();
            for (int j = 0; j < list1.get(i).size(); j++) {
                list.add(round(list1.get(i).get(j) - list2.get(i).get(j)));
            }
            list3.add(list);
        }
        matrices.add(list3);
        write();
    }

    public void sub(int indexMatrix, double number) {
        List<List<Double>> list1 = get(indexMatrix);
        List<List<Double>> list2 = new ArrayList<>();
        for (List<Double> doubles : list1) {
            List<Double> list = new ArrayList<>();
            for (Double i : doubles) list.add(round(i - number));
            list2.add(list);
        }
        matrices.add(list2);
        write();
    }

    public void multi(int indexMatrix1, int indexMatrix2) {
        List<List<Double>> list1 = get(indexMatrix1);
        List<List<Double>> list2 = get(indexMatrix2);
        List<List<Double>> list3 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            List<Double> list = new ArrayList<>();
            for (int j = 0; j < list2.get(0).size(); j++) {
                double sum = 0;
                for (int k = 0; k < list2.size(); k++) {
                    sum += list1.get(i).get(k) * list2.get(k).get(j);
                }
                list.add(round(sum));
            }
            list3.add(list);
        }
        matrices.add(list3);
        write();
    }

    public void multi(int indexMatrix, double number) {
        List<List<Double>> list1 = get(indexMatrix);
        List<List<Double>> list2 = new ArrayList<>();
        for (List<Double> doubles : list1) {
            List<Double> list = new ArrayList<>();
            for (Double i : doubles) list.add(round(i * number));
            list2.add(list);
        }
        matrices.add(list2);
        write();
    }

    public boolean CheekMulti(int index1, int index2) {
        if (get(index1).size() == get(index2).get(0).size()) return false;
        System.out.print(Shape("--> ") + Error("Error : The Number of Rows In Second Matrix"));
        System.out.println(Error(" Not Equal Columns In First Matrix."));
        return true;
    }


    public int checkSolution(List<List<Double>> l) {
        int s = l.size() - 1;
        if (l.get(s).get(l.get(s).size() - 2) != 0) return 0; // one sol
        if (l.get(s).get(l.get(s).size() - 1).equals(l.get(s).get(l.get(s).size() - 2))) return 1; // inf sol
        return -1; // no sol
    }

    public List<List<Double>> transpose(int indexMatrix) {
        List<List<Double>> l = new ArrayList<>(get(indexMatrix));
        List<List<Double>> list = new ArrayList<>();
        for (int i = 0; i < l.get(0).size(); i++) {
            List<Double> list1 = new ArrayList<>();
            for (List<Double> doubles : l) list1.add(doubles.get(i));
            list.add(list1);
        }
        return list;
    }

    public void inverse(int indexMatrix) {
        List<List<Double>> list = new ArrayList<>();
        for (int i = 0; i < get(indexMatrix).size(); i++) {
            List<Double> list1 = new ArrayList<>(get(indexMatrix).get(i));
            for (int j = 0; j < get(indexMatrix).get(i).size(); j++)
                list1.add(i == j ? 1.0 : 0.0);
            list.add(list1);
        }
        Jordan(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).subList(list.get(i).size() / 2, list.get(i).size()));
        }
        matrices.add(list);
        write();
    }

    public boolean checkSquare(int indexMatrix) {
        if (matrices.get(indexMatrix).size() == matrices.get(indexMatrix).get(0).size()) return false;
        System.out.println(Shape("--> ") + Error("Error : Matrix Not Square(Number of Row and Columns Not Equal)."));
        return true;
    }
}
