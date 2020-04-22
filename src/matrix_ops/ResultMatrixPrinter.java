package matrix_ops;

//utility class
public class ResultMatrixPrinter {

    private ResultMatrixPrinter() {

    }

    public static void printResultMatrix(Number[][] m1, Number[][] m2, Number[][] m3, char op) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++)
                System.out.printf("%3s ", m1[i][j]);

            if (i == m1.length / 2)
                System.out.printf("    %c   ", op);
            else
                System.out.print("        ");

            for (int j = 0; j < m2.length; j++)
                System.out.printf(" %3s", m2[i][j]);

            if (i == m1.length / 2)
                System.out.print("    =   ");
            else System.out.print("        ");

            for (int j = 0; j < m3.length; j++)
                System.out.printf("%3s", m3[i][j] + " ");

            System.out.println();
        }
    }
}
