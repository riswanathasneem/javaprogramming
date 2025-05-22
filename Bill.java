package riswanaa;
import java.util.*;

interface Billgen {
    int calculate();
}

class productB implements Billgen {
    String name;
    int prod_id, quantity, unit_price, total;

    productB() {}

    productB(String n, int p, int q, int u) {
        name = n;
        prod_id = p;
        quantity = q;
        unit_price = u;
    }

    public int calculate() {
        total = quantity * unit_price;
        return total;
    }
}

public class Bill {
    public static void main(String[] args) {
        productB[][] order;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of orders:");
        int n = sc.nextInt();
        order = new productB[n][];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter number of products in order " + (i + 1) + ":");
            int m = sc.nextInt();
            order[i] = new productB[m];

            for (int j = 0; j < m; j++) {
                System.out.println("Enter product " + (j + 1) + " name:");
                String a = sc.next();

                System.out.println("Enter product ID:");
                int b = sc.nextInt();

                System.out.println("Enter product quantity:");
                int c = sc.nextInt();

                System.out.println("Enter product unit price:");
                int d = sc.nextInt();

                productB pb = new productB(a, b, c, d);
                order[i][j] = pb;
                order[i][j].total = order[i][j].calculate();
            }
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            System.out.println("\nOrder No: " + (i + 1));
            Date date = java.util.Calendar.getInstance().getTime();
            System.out.println(date);
            System.out.println("-------------------------------------------------------------");

            // Correct header
            System.out.printf("%10s %20s %10s %15s %10s\n", "prod_id", "name", "quantity", "unit_price", "total");

            System.out.println("-------------------------------------------------------------");

            for (int j = 0; j < order[i].length; j++) {
                // Correct data formatting
                System.out.printf("%10d %20s %10d %15d %10d\n",
                        order[i][j].prod_id,
                        order[i][j].name,
                        order[i][j].quantity,
                        order[i][j].unit_price,
                        order[i][j].total);
            }

            System.out.println("-------------------------------------------------------------");
            for (int k = 0; k < order[i].length; k++) {
                sum += order[i][k].total;
            }
            System.out.println("Net Amount: " + sum);
            System.out.println("-------------------------------------------------------------");
        }

        sc.close();
    }
}
