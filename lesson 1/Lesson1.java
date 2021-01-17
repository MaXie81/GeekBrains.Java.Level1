public class Lesson1 {
    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
    public static void main(String[] args) {
    // 2. Создать переменные всех пройденных типов данных и инициализировать их значения.
        byte    varByte     = 1;
        short   varShort    = 1;
        int     varInt      = 1;
        long    varLong     = 1L;

        float   varFloat    = 0.0f;
        double  varDouble   = 0.0;

        char    varChar     = 'A';

        boolean varBoolean  = false;

        String  varString   = "Java";

    // Проверка выполнения заданий
        System.out.println();
    // п.3
        System.out.println("3. a =   2, b =   3, c =   7, d = 2.5:  " + calcFltExpr(2f, 3f, 7f, 2.5f));
        System.out.println("3. a =   3, b = 1.5, c =   4, d =   6:  " + calcFltExpr(3, 1.5f, 4, 6));
        System.out.println("3. a = 3.5, b =   1, c =   3, d =   6:  " + calcFltExpr(3.5f, 1f, 3, 6));
        System.out.println();
    // п.4
        System.out.println("4. num1 = 5, num2 =  2:                 " + verifSum(5, 2));
        System.out.println("4. num1 = 7, num2 =  3:                 " + verifSum(7, 3));
        System.out.println("4. num1 = 9, num2 = 12:                 " + verifSum(9, 12));
        System.out.println();
    // п.5
        System.out.println("5. num =  7:                            " + chkPosNum(7));
        System.out.println("5. num =  0:                            " + chkPosNum(0));
        System.out.println("5. num = -3:                            " + chkPosNum(-3));
        System.out.println();
    // п.6
        System.out.println("6. num = -1:                            " + chkNegNum(-1));
        System.out.println("6. num =  3:                            " + chkNegNum(3));
        System.out.println();
    // п.7
        System.out.println("7. name = Аня           :               " + getHello("Аня"));
        System.out.println("7. name = Максим        :               " + getHello("Максим"));
        System.out.println("7. name = Ольга Петровна:               " + getHello("Ольга Петровна"));
        System.out.println();
    // п.8*
        System.out.println("8. year =    0:                         " + chkLeapYear(0));
        System.out.println("8. year = 2020:                         " + chkLeapYear(2020));
        System.out.println("8. year = 2021:                         " + chkLeapYear(2021));
        System.out.println("8. year = 1900:                         " + chkLeapYear(1900));
        System.out.println("8. year = 2000:                         " + chkLeapYear(2000));
        System.out.println();
    }

    // 3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат
    // , где a, b, c, d – аргументы этого метода, имеющие тип float.
    private static float calcFltExpr(
            float a,
            float b,
            float c,
            float d
    ) {
        float v = a * (b + (c / d));
        return v;
    }
    // 4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно)
    // , если да – вернуть true, в противном случае – false.
    private static boolean verifSum(int num1, int num2) {
        int sum = num1 + num2;
        if(sum >= 10 && sum <= 20){
            return true;
        } else {
            return false;
        }
    }
    // 5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.
    private static String chkPosNum(int num) {
        if(num >= 0)
        //{
            return "число положительное";
        //}
        else
            //{
            return "число отрицательное";
        //}
    }
    // 6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    private static boolean chkNegNum(int num) {
        if(num < 0){
            return true;
        } else {
            return false;
        }
    }
    // 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    private static String getHello(String name) {
        final String cStrHelloS = "Привет, ";
        final String cStrHelloE = "!";

        return cStrHelloS + name + cStrHelloE;
    }
    // 8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    private static boolean chkDiv(int num, int numDiv) {
        return num % numDiv == 0;
    }
    private static String chkLeapYear(int year) {
        final int cDiv4     = 4;
        final int cDiv100   = 100;
        final int cDiv400   = 400;

        if (year == 0) {                        // если год "нулевой"
            return "год не високосный";
        } else if (chkDiv(year, cDiv400)) {     // если год "каждый 400-й"
            return "год високосный";
        } else if (chkDiv(year, cDiv100)) {     // если год "каждый 100-ый"
            return "год не високосный";
        } else if (chkDiv(year, cDiv4)) {       // если год "каждый 4-ый"
            return "год високосный";
        } else {                                // все остальные года
            return "год не високосный";
        }
    }
}
