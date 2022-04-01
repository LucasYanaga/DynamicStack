import java.lang.Math;

public class Stack {
    public int[] stack;
    public int index;
    public int max;

    public Stack(int lenght){
        this.index = -1;
        this.stack = new int[lenght];
    }

    public void push(int value){
        System.out.println("Pushing: " + value);

        if (this.isFull()) {
            increaseStack();
        }

        this.stack[++this.index] = value;
    }

    public void pop(){
        if(!this.isEmpty()){
            System.out.println("Poping: " + this.stack[this.index]);
            this.stack[this.index] = 0;
            this.index--;
        }
    }

    public int peek(){
        if(!this.isEmpty()){
            return this.stack[this.index];
        }else{
            return -1;
        }
    }

    public boolean isEmpty(){
        boolean isEmpty = false;

        if(this.index == -1){
            isEmpty = true;
        }
        return isEmpty;
    }

    public boolean isFull(){
        boolean isFull = false;

        if(this.index + 1 == this.stack.length){
            isFull = true;
        }
        return isFull;
    }

    public void increaseStack(){
        int[] newStack = new int[this.stack.length + 1];

        for(int i = 0; i < this.stack.length; i++) {
           newStack[i] = this.stack[i];
        }

        this.stack = newStack;
    }

    public void printStack(){
        this.max();
        int houses = (int)Math.floor(Math.log10(this.max) + 1);

        for (int i = this.stack.length -1; i >= 0; i--) {

            switch (houses) {
                case 1 -> System.out.printf("|%1s%-1d%-1s|\n", "", this.stack[i], "");
                case 2 -> System.out.printf("|%1s%-2d%-1s|\n", "", this.stack[i], "");
                case 3 -> System.out.printf("|%1s%-3d%-1s|\n", "", this.stack[i], "");
                case 4 -> System.out.printf("|%1s%-4d%-1s|\n", "", this.stack[i], "");
                case 5 -> System.out.printf("|%1s%-5d%-1s|\n", "", this.stack[i], "");
                case 6 -> System.out.printf("|%1s%-6d%-1s|\n", "", this.stack[i], "");
            }
        }

        for (int i = 0; i < 4 + houses; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void max(){
        this.max = 0;
        for (int j : this.stack) {
            if (j > this.max) {
                this.max = j;
            }
        }
    }

}
