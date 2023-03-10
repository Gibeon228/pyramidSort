public class Main {
    public static void main(String[] args) {


        int[] array = {5, 3, 2, 4, 10, 42, 34, 1, 4, 0, 241};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    static void sort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            pyramidSort(a, a.length, i);
        }

        for (int i = a.length - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            pyramidSort(a, i, 0);
        }
    }

    static void pyramidSort(int[] a, int size, int parentIndex) {
        int tempIndex = parentIndex;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;

        if (leftChild < size && a[leftChild] > a[tempIndex]) {
            tempIndex = leftChild;
        }
        if (rightChild < size && a[rightChild] > a[tempIndex]) {
            tempIndex = rightChild;
        }

        if (tempIndex != parentIndex) {
            int temp = a[tempIndex];
            a[tempIndex] = a[parentIndex];
            a[parentIndex] = temp;

            pyramidSort(a, size, tempIndex);
        }


        return;
    }
}