import java.util.Arrays;

public class QuickSort {
    public static void sort(int a[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, hight); // 对高子表进行递归排序
    }

    public static void myQuickSortTop(int[] a) {
        int left = 0;
        int right = a.length -1 ;

        int pivotIndex = myQuickSort(a, left, right);

    }

    public static int myQuickSort(int[] a, int left, int right) {
        int initLeft = left;
        int initRight = right;

        int pivot = a[left];
        if (left >= right){
            return -1;
        }

        while (left < right ){
            while (left < right){
                if(a[right] < pivot ){
                    a[left] = a[right];
                    break;
                }else{
                    right -- ;
                }
            }
            while (left < right){
                if (a[left] > pivot){
                    a[right] = a[left];
                    break;
                }else{
                    left ++ ;
                }
            }
        }
        a[left] = pivot;
        System.out.println(Arrays.toString(a));

        myQuickSort(a, initLeft, left - 1);
        myQuickSort(a, left + 1, initRight);

        return left;
    }



    public static void quickSort(int a[]) {
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {

        int a[] = { 49, 38, 65, 97, 76, 13,32,45, 27, 49 };
        System.out.println(Arrays.toString(a));
        myQuickSortTop(a);

        System.out.println(Arrays.toString(a));
    }
}