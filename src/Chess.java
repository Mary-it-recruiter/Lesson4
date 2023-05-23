
public class Chess {
    private static final int BOARD_SIZE = 8;

    public static void main(String[] args) {
        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

        // заполним доску пустыми клетками
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '0';
            }
        }

        placeQueens(board, 0); // начинаем с первой строки

        // выводим доску
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean placeQueens(char[][] board, int row) {
        if (row == BOARD_SIZE) { // если успешно расставили всех 8 ферзей, то возвращаем true
            return true;
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isSafe(board, row, col)) { // проверяем, не находится ли текущая позиция под ударом других ферзей
                board[row][col] = 'Q'; // ставим ферзя на позицию
                if (placeQueens(board, row + 1)) { // пытаемся разместить следующего ферзя на следующей строке
                    return true; // если удачно, то возвращаем true
                }
                board[row][col] = '0'; // если не удалось, то возвращаем false и продолжаем поиск в других ячейках
            }
        }

        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int i, j;

        // проверяем вертикальную линию вверх от текущей клетки
        for (i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // проверяем главную диагональ влево-вверх от текущей клетки
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // проверяем побочную диагональ вправо-вверх от текущей клетки
        for (i = row, j = col; i >= 0 && j < BOARD_SIZE; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true; // если все проверки пройдены успешно, то возвращаем true
    }
}