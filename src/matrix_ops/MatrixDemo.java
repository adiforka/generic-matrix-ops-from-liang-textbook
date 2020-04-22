package matrix_ops;

//snatched from Daniel Liang's Introduction to Java Programming and Data Structures textbook
//11th edition
public class MatrixDemo {
    public static void main(String[] args) {

        Integer[][] m1 = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {1, 1, 1}};
        Integer[][] m2 = new Integer[][]{{1, 1, 1}, {2, 2, 2}, {0, 0, 0}};

        IntegerMatrix matrix = new IntegerMatrix();

        System.out.println("m1 + m2 is ");
        ResultMatrixPrinter.printResultMatrix(m1, m2, matrix.addMatrix(m1, m2), '+');

        System.out.println();
        System.out.println();

        System.out.println("m1 * m2 is ");
        ResultMatrixPrinter.printResultMatrix(m1, m2, matrix.multiplyMatrix(m1, m2), '*');
    }
}
