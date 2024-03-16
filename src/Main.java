public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};


        class SumThread extends Thread {
            private final int[] numbers;
            private int sum = 0;

            public SumThread(int[] numbers) {
                this.numbers = numbers;
            }

            @Override
            public void run() {
                for (int number: numbers){
                    sum += number;
                }
            }

            public int getSum() {
                return sum;
            }
        }

        class MaxThread extends Thread {
            private final int[] numbers;
            private int max = -1000;

            public MaxThread(int[] numbers) {
                this.numbers = numbers;
            }

            @Override
            public void run() {
                for (int number: numbers){
                    if (number > max){
                        max = number;
                    }
                }
            }

            public int getMax() {
                return max;
            }
        }

        // Tạo và khởi chạy luồng 1
        SumThread thread1 = new SumThread(numbers);
        thread1.start();

        // Tạo và khởi chạy luồng 2
        MaxThread thread2 = new MaxThread(numbers);
        thread2.start();

        try {
            // Chờ cả hai luồng kết thúc
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Phần tử lớn nhất trong mảng là: " + thread2.getMax());
        System.out.println("Tổng của các phần tử trong mảng là: " + thread1.getSum());
    
    }
}
