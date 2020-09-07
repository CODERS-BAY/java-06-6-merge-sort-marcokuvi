public class Main {

    public static void merge(int[] array, int start, int mid, int end) {

        int l = mid - start + 1;
        int r = end - mid;

        int[] leftArray = new int[l];
        int[] rightArray = new int[r];

        for (int i = 0; i < l; ++i)
            leftArray[i] = array[start + i];

        for (int j = 0; j < r; ++j)
            rightArray[j] = array[mid + 1 + j];


        int i = 0, j = 0;
        int k = start;
        while (i < l && j < r) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < r) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(array, start, mid);
            sort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    public static void main(String[] args) {

        int[] unsortedArray = {90, 23, 101, 45, 65, 24, 67, 89, 34, 77};

        sort(unsortedArray, 0, unsortedArray.length - 1);

        for (int i : unsortedArray) {
            System.out.print(i + " ");
        }
    }
}

