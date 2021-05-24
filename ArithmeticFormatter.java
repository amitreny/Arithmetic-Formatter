public class ArithmeticFormatter {
    public static int flag = 0;
    public static char[] opp = new char[5];
    public static int[] a = new int[5];
    public static int[] b = new int[5];
    public static int[] result = new int[5];
    public static String[] stringarray;

    static void arithmeticArranger(String[] exps) {
        int j = 0;
        int k1 = 0;
        String regex = "[0-9]+";

        // Checking if expressions are more than 5
        if (exps.length > 5) {
            System.out.println("Error: Too many problems.\n");
            return;
        }

        // Checking if there are any other operators besides '+' or '-'
        for (int i = 0; i < exps.length; i++) {

            String recieve = exps[i];
            for (int l = 0; l < recieve.length(); l++) {
                if ((recieve.charAt(l) == '*') || (recieve.charAt(l) == '/')) {
                    System.out.println("Error: Operator must be '+' or '-'\n");
                    return;
                }
            }

            // Removing whitespaces in the strings
            exps[i] = exps[i].replaceAll("\\s", "");

            // Splitting the strings to get the 2 opperands
            stringarray = exps[i].split("[+-]+");

            // Checking to ensure that operands contain only digits
            for (int y = 0; y < stringarray.length; y++) {
                if (!stringarray[y].matches(regex)) {
                    System.out.println("Error: Numbers must only contain digits.\n");
                    return;
                }
            }

            // Storing the first operand and second operand of each expression in two
            // different arrays
            int v1 = Integer.parseInt(stringarray[0]);
            a[j++] = v1;
            int v2 = Integer.parseInt(stringarray[1]);
            b[k1++] = v2;

            // Loop to find operator in the string
            for (int j1 = 0; j1 < exps[i].length(); j1++) {
                if ((exps[i].charAt(j1) == '+') || (exps[i].charAt(j1) == '-')) {
                    opp[i] = exps[i].charAt(j1);
                }
            }

        }

        // Checking to see if operands are not more than 5 digits
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 9999 || b[i] > 9999) {
                System.out.println("Error: Numbers cannot be more than four digits.\n");
                return;
            }
        }

        // Printing the output
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%10s", a[i]);
        }
        System.out.println();
        for (int i = 0; i < opp.length; i++) {
            System.out.printf("%5s %4s", opp[i], b[i]);
        }
        System.out.println();
        String hifen = "------";
        for (int i = 0; i < opp.length; i++) {
            System.out.printf("%10s", hifen);
        }
        System.out.println("\n\n");

    }

    // Function to print with result
    static void arithmeticArranger(String[] exps, boolean solve) {
        int j = 0;
        int k1 = 0;
        String regex = "[0-9]+";

        // Checking if expressions are more than 5
        if (exps.length > 5) {
            System.out.println("Error: Too many problems.\n");
            return;
        }

        // Checking if there are any other operators besides '+' or '-'
        for (int i = 0; i < exps.length; i++) {

            String recieve = exps[i];
            for (int l = 0; l < recieve.length(); l++) {
                if ((recieve.charAt(l) == '*') || (recieve.charAt(l) == '/')) {
                    System.out.println("Error: Operator must be '+' or '-'\n");
                    return;
                }
            }

            // Removing whitespaces in the strings
            exps[i] = exps[i].replaceAll("\\s", "");

            // Splitting the strings to get the 2 opperands
            stringarray = exps[i].split("[+-]+");

            // Checking to ensure that operands contain only digits
            for (int y = 0; y < stringarray.length; y++) {
                if (!stringarray[y].matches(regex)) {
                    System.out.println("Error: Numbers must only contain digits.\n");
                    return;
                }
            }

            // Storing the first operand and second operand of each expression in two
            // different arrays
            int v1 = Integer.parseInt(stringarray[0]);
            a[j++] = v1;
            int v2 = Integer.parseInt(stringarray[1]);
            b[k1++] = v2;

            // Loop to find operator in the string
            for (int j1 = 0; j1 < exps[i].length(); j1++) {
                if ((exps[i].charAt(j1) == '+') || (exps[i].charAt(j1) == '-')) {
                    opp[i] = exps[i].charAt(j1);
                }
            }

        }

        // Checking to see if operands are not more than 5 digits
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 9999 || b[i] > 9999) {
                System.out.println("Error: Numbers cannot be more than four digits.\n");
                return;
            }
        }

        // Performing the operations
        for (int i = 0; i < opp.length; i++) {
            switch (opp[i]) {
                case '+':
                    result[i] = a[i] + b[i];
                    break;
                case '-':
                    result[i] = a[i] - b[i];
                    break;
            }
        }

        // printing the output
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%10s", a[i]);
        }
        System.out.println();
        for (int i = 0; i < opp.length; i++) {
            System.out.printf("%5s %4s", opp[i], b[i]);
        }
        System.out.println();
        String hifen = "------";
        for (int i = 0; i < opp.length; i++) {
            System.out.printf("%10s", hifen);
        }
        System.out.println();
        if (solve == false) {
            return;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%10s", result[i]);
        }
        System.out.println("\n\n");

    }

    public static void main(String[] args) {
        // Test case to show output without the results
        String[] stringsa = { "3244 + 6983", "3801 - 2", "9999 + 9999", "1234 + 49", "123 + 49" };
        arithmeticArranger(stringsa);

        // Test case to show output with results
        String[] stringsb = { "3244 + 6983", "3801 - 2", "9999 + 9999", "1234 + 49", "123 + 49" };
        arithmeticArranger(stringsb, true);

        // Test case to show "Error: Too many problems."
        String[] stringsc = { "3244 + 6983", "3801 - 2", "9999 + 9999", "1234 + 49", "123 + 49", "1+2" };
        arithmeticArranger(stringsc);

        // Test case to show "Error: Operator must be '+' or '-'."
        String[] stringsd = { "3244 * 6983", "3801 - 2", "9999 + 9999", "1234 + 49", "123 + 49" };
        arithmeticArranger(stringsd);

        // Test case to show "Error: Numbers must only contain digits."
        String[] stringse = { "A244 + 6983", "3801 - 2", "9999 + 9999", "1234 + 49", "123 + 49" };
        arithmeticArranger(stringse);

        // Test case to show "Error: Numbers cannot be more than four digits."
        String[] stringsf = { "32444 + 6983", "3801 - 2", "9999 + 9999", "1234 + 49", "123 + 49" };
        arithmeticArranger(stringsf);
    }
}
