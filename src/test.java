public class test {
    public static void main(String[] args) {
        int[] a = {4, 0, 9, 2, 1};
        int[] b = {6, 3, 2, 9, 0};

        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                a[i] -= b[i];
            } else {
                b[i] -= a[i];
            }

            if (a[i] % 2 == 0) {
                a[i] += 1;
                b[i] += 1;
            }
        }
        for (int i: a) {
            System.out.print(i);
        }
        for (int i: b) {
            System.out.print(i);
        }
    }
}
