package matrix_ops;

abstract class GenericMatrix<E extends Number> {

    //these to be implemented in extending class (see IntegerMatrix)
    protected abstract E add(E o1, E o2);
    protected abstract E multiply(E o1, E o2);
    protected abstract E zero();

    public E[][] addMatrix(E[][] matrix1, E[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length)
            throw new RuntimeException("The matrices are not the same size!");

        @SuppressWarnings("unchecked")
        E[][] result = (E[][]) new Number[matrix1.length][matrix1[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        }
        return result;
    }

    /*tricky business because Liang does not explain how multiplying matrices works, so
     * it's probably college math 101. here goes--
     *
     * 1) precondition: no. of columns in m1 must equal no. of rows in m2.
     *
     * 2) how to multiply compatible matrices: every element in row 0 of m1 has to be multiplied
     * by every element in col 0 in m2; the products must be added; the result is stored at [0][0] in m3
     *
     * examples for further multiplication:
     * 3) to get m3[0][1] use row0 in m1 against col1 in m2 (multiply elements, sum up, store in m3)
     * 4) to get m3[1][0] ust row1 in m1 against col0 in m2 (again, multiply elements, sum up, store in m3)
     *
     * 5) size of m3: m3 will have no of rows == no columns in m2, and no of columns == no of rows in m1*/

    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            throw new RuntimeException("The matrices do not have compatible size");
        }

        @SuppressWarnings("unchecked")
        E[][] result = (E[][]) new Number[matrix1.length][matrix2[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero();

                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = add(result[i][j], multiply(matrix1[i] [k], matrix2[k][j]));
                }
            }
        }
        return result;
    }
}
