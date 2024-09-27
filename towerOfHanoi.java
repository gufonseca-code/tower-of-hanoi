import java.util.Scanner;
import java.util.Stack;

public class towerOfHanoi {
    public static void hanoi(int n) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Stack<Integer> c = new Stack<>();

        for (int i = n; i > 0; i--){
            a.push(i);
        }
        move(n, a, b, c);
    }

    public static void move(int num, Stack<Integer> from_stack, Stack<Integer> to_stack, Stack<Integer> aux_stack) {
        if (num == 1) {
            to_stack.push(from_stack.pop());
            print(from_stack, aux_stack, to_stack);

        } else {
            move(num - 1, from_stack, aux_stack, to_stack);
            to_stack.push(from_stack.pop());
            print(from_stack, aux_stack, to_stack);
            move(num - 1, aux_stack, to_stack, from_stack);
        }
    }

    public static void print(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
        System.out.println("\nA" + a);
        System.out.println("B" + b);
        System.out.println("C" + c + "\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira a quantidade de números para a torre: ");

        try {
            int quantity = scanner.nextInt();
            hanoi(quantity);
        } catch (Exception e) {
            System.out.println("Valor inválido");
        }
    }
}
