public class EquationSolver {
    public static void main(String[] args) {
        for (int q = 0; q <= 9; q++) {
            for (int w = 0; w <= 9; w++) {
                for (int e = 0; e <= 9; e++) {
                    if ((q != w) && (q != e) && (w != e)) { // проверяем, что все цифры различны
                        int leftSide = replaceQuestionMarks("2? + ?5", q, w);
                        int rightSide = replaceQuestionMarks("69", w, e);
                        if (leftSide + rightSide == e) {
                            System.out.println("Solution found: " + leftSide + " + " + rightSide + " = " + e);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("No solution found.");
    }

    // Заменяет знаки вопроса в строке на заданные цифры
    public static int replaceQuestionMarks(String equation, int digit1, int digit2) {
        equation = equation.replace("?", Integer.toString(digit1));
        equation = equation.replace("?", Integer.toString(digit2));
        return Integer.parseInt(equation);
    }
}
