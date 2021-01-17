public class Lesson2Test {
    public static void main(String[] args) {
        // Проверка выполнения заданий
        System.out.println();
        // п.1
        System.out.println("1. инверсия массива:");
        setArr1();
        System.out.println();
        // п.2
        System.out.println("2. задать массив:");
        setArr2();
        System.out.println();
        // п.3
        System.out.println("3. задать массив:");
        setArr3();
        System.out.println();
        // п.4
        System.out.println("4. задать массив:");
        setArr4(5);
        System.out.println();
        setArr4(8);
        System.out.println();
        // п.5
        System.out.println("5. найти минимальное и максимальное значения элеметов массива:");
        getMinMax();
        System.out.println();
        // п.6
        System.out.println("6. проверить массив на равенство сумм справа и слева:");
        System.out.println("результат проверки: " + chkArr(new int[]{1, 2, 3}));
        System.out.println("результат проверки: " + chkArr(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println("результат проверки: " + chkArr(new int[]{1, 0, 2, 1, 5, 3}));
        System.out.println("результат проверки: " + chkArr(new int[]{1, 3, 5, 7}));
        System.out.println("результат проверки: " + chkArr(new int[]{4, 1, 2, 1}));
        System.out.println();
        // п.7
        System.out.println("7. сместить элементы массива на n позиций:");
        final int[] arrIntConst = {1, 2, 3};
        int[] arrInt;
        arrInt = modArr(arrIntConst.clone(),  0);
        prnArr("смещение:  " + 0 + ", результирующий массив", arrInt);
        arrInt = modArr(arrIntConst.clone(),  1);
        prnArr("смещение:  " + 1 + ", результирующий массив", arrInt);
        arrInt = modArr(arrIntConst.clone(),  2);
        prnArr("смещение:  " + 2 + ", результирующий массив", arrInt);
        arrInt = modArr(arrIntConst.clone(), -1);
        prnArr("смещение: " + -1 + ", результирующий массив", arrInt);
        arrInt = modArr(arrIntConst.clone(), -2);
        prnArr("смещение: " + -2 + ", результирующий массив", arrInt);
        arrInt = modArr(arrIntConst.clone(),  3);
        prnArr("смещение:  " + 3 + ", результирующий массив", arrInt);
        arrInt = modArr(arrIntConst.clone(),  4);
        prnArr("смещение:  " + 4 + ", результирующий массив", arrInt);
        System.out.println();
    }
    private static void prnArr(String lbl, int[] arr) {                             // метод для вывода на печать элементов массива
        String str;

        System.out.print(lbl + ": ");

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 10) {
                str = " " + arr[i];
            }
            else {
                str = String.valueOf(arr[i]);
            }
            System.out.print(" " + str);
        }
        System.out.println();
    }
    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    private static void setArr1(){
        int[] arrInt = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        prnArr("   до изменения", arrInt);

        for (int i = 0; i < arrInt.length; i++) {
            if (arrInt[i] == 0) {
                arrInt[i]++;
            } else {
                arrInt[i]--;
            }
        }
        prnArr("после изменения", arrInt);
    }
    // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    private static void setArr2() {
        int[] arrInt = new int[8];

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = i * 3;
        }
        prnArr("массив", arrInt);
    }
    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    private static void setArr3() {
        int[] arrInt = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        prnArr("   до изменения", arrInt);

        for (int i = 0; i < arrInt.length; i++) {
            if (arrInt[i] < 6) {
                arrInt[i] *= 2;
            }
        }
        prnArr("после изменения", arrInt);
    }
    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    // ВЛОЖЕННЫЙ ЦИКЛ
    private static void setArr4(int size){
        int[][] arrInt = new int[size][size];

        for (int i = 0; i < arrInt.length; i++){
            for (int j = 0; j < arrInt[i].length; j++) {
                if (i == j || (i + j) == (size -1)) {
                    arrInt[i][j] = 1;
                }
            }
            prnArr(String.valueOf(i + 1), arrInt[i]);
        }
    }
    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    // ОДИН ЦИКЛ
    private static void setArr4Alt(int size){
        int[][] arrInt = new int[size][size];

        for (int i = 0, j = arrInt.length -1; i < arrInt.length; i++, j--){
            arrInt[i][i] = 1;
            arrInt[i][j] = 1;

            prnArr(String.valueOf(i + 1), arrInt[i]);
        }
    }
    // 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    private static void getMinMax(){
        int valMin = -1;                                // минимальное значение элементов массива
        int valMax = -1;                                // максимальное значение элементов массива

        int[] arrInt = {5, 2, 7, 3, 4, 1, 9, 6, 8};

        for (int i = 0; i < arrInt.length; i++) {
            if (i == 1) {
                valMin = valMax = arrInt[i];
            } else {
                if (arrInt[i] < valMin) {
                    valMin = arrInt[i];
                }
                if (arrInt[i] > valMax) {
                    valMax = arrInt[i];
                }
            }
        }

        System.out.println(" минимальное: " + valMin);
        System.out.println("максимальное: " + valMax);
    }
    // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.
    private static boolean chkArr(int[] arrInt) {
        int sumArr      = 0;                            // сумма всех элементов массива
        int sumArrRght  = 0;                            // сумма элементов массива "справа"
        int sumArrLeft  = 0;                            // сумма элементов массива "слева"(можно без него!)

        prnArr("массив: ", arrInt);

        for (int i = 0; i < arrInt.length; i++) {       // расчет суммы всех элементов массива
            sumArr += arrInt[i];
        }
        for (int i = 0; i < arrInt.length; i++) {
            sumArrRght += arrInt[i];                    // сумма элементов массива "справа"
            sumArrLeft = sumArr - sumArrRght;           // сумма элементов массива "слева"

            if (sumArrRght == sumArrLeft) {
                return true;
            }
        }
        return false;
    }
    // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным)
    // , при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры:
    // [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.
    private static int[] modArr(int[] arrInt, int n) {
        int[] arrIntRslt = new int[arrInt.length];      // результирующий массив
        int idx;                                        // индекс для элементов входящего массива

        n %= arrInt.length;                             // если величина смещения больше, чем кол-во элементов входящего массива

        for (int i = 0; i < arrIntRslt.length; i++) {
            idx = i - n;

            // Проверки на выход за пределы диапазона индексов массива
            if(idx >= arrInt.length) {
                idx -= arrInt.length;
            }
            if(idx < 0) {
                idx += arrInt.length;
            }
            arrIntRslt[i] = arrInt[idx];
        }
        return arrIntRslt;
    }
    // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным)
    // , при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры:
    // [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.
    // БЕЗ ВСПОМОГАТЕЛЬНОГО МАССИВА
    private static int[] pushArr(int[] arr, boolean reverse){
        int buf = -1;

        if (reverse) {
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    buf = arr[i];
                }
                if (i == arr.length - 1) {
                    arr[i] = buf;
                } else {
                    arr[i] = arr[i + 1];
                }
            }
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (i == arr.length - 1) {
                    buf = arr[i];
                }
                if (i == 0) {
                    arr[i] = buf;
                } else {
                    arr[i] = arr[i - 1];
                }
            }
        }
        return arr;
    }
    private static int[] modArrAlt(int[] arrInt, int n) {
        boolean rev = n < 0;

        if (rev) {n *= -1;}

        for(int i = 1; i <= n; i++) {
            arrInt = pushArr(arrInt, rev);
        }
        return arrInt;
    }
}
