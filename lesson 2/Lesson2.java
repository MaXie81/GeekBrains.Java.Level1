public class Lesson2 {
    public static void main(String[] args) {
    // Проверка выполнения заданий
        setArr1();                              // п.1

        setArr2();                              // п.2

        setArr3();                              // п.3

        setArr4(5);                             // п.4
        setArr4Alt(5);                          // п.4 АЛЬТЕРНАТИВНЫЙ вариант решения

        getMinMax();                            // п.5

        chkArr(new int[] {1, 2, 3});            // п.6

        modArr(new int[] {1, 2, 3}, 1);      // п.7
        modArrAlt(new int[] {1, 2, 3}, 1);   // п.7 АЛЬТЕРНАТИВНЫЙ вариант решения
    }
    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    private static void setArr1(){
        int[] arrInt = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arrInt.length; i++) {
            if (arrInt[i] == 0) {
                arrInt[i]++;
            } else {
                arrInt[i]--;
            }
        }
    }
    // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    private static void setArr2() {
        int[] arrInt = new int[8];

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = i * 3;
        }
    }
    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    private static void setArr3() {
        int[] arrInt = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arrInt.length; i++) {
            if (arrInt[i] < 6) {
                arrInt[i] *= 2;
            }
        }
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
    private static void modArr(int[] arrInt, int n) {
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
    private static void modArrAlt(int[] arrInt, int n) {
        boolean rev = n < 0;

        if (rev) {n *= -1;}

        for(int i = 1; i <= n; i++) {
            arrInt = pushArr(arrInt, rev);
        }
    }
}
