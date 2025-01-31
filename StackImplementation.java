import java.util.EmptyStackException;

interface StackADT {
    void push(int item);
    int pop();
    int peek();
    boolean isEmpty();
    boolean isFull();
}

class StackArray implements StackADT {
    private int[] stack;
    private int top;
    private int capacity;

    public StackArray(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    @Override
    public void push(int item) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full! Cannot push item.");
        }
        stack[++top] = item;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top--];
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == capacity - 1;
    }
}

public class StackImplementation {
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        
        try {
            stack.push(10);
            stack.push(20);
            stack.push(30);
            
            System.out.println("Top element: " + stack.peek());
            System.out.println("Popped element: " + stack.pop());
            System.out.println("Popped element: " + stack.pop());
            
            System.out.println("Stack is empty: " + stack.isEmpty());
            
            stack.pop(); // This will throw an exception if popped further
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

