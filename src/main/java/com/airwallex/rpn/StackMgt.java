package com.airwallex.rpn;
/**
 * @author joe
 * @date 2018/11/2
 */
import com.airwallex.rpn.optor.*;

import java.util.Stack;

public class StackMgt {

    private static Stack<Optor> stack = new Stack<Optor>();
    private static Stack<Optor> undoStack = new Stack<Optor>();

    public static int stackSize(){
        return stack.size();
    }

    public static void pushStack(Optor optor){
        stack.push(optor);
        undoStack.push(optor);
    }

    public static void pushStack(String str) throws OprException{
        Optor optor = new StackValue(str);
        stack.push(optor);
    }
    public static void pushStack(double val){
        Optor optor = new StackValue(val);
        stack.push(optor);
    }

    public static void fourOptor(String str) throws OprException{
        double result = stack.pop().getResult();
        Optor optor = new FourOptor(str, stack.pop().getResult(), result);
        optor.op();
        pushStack(optor);
    }

    public static void singleOptor(String str) throws OprException{
        Optor optor = new SingleOptor(str, stack.pop().getResult());
        optor.op();
        pushStack(optor);
    }

    public static void copyStack() {
        while (!stack.empty()) {
            undoStack.push(stack.pop());
        }
        stack.clear();
    }

    public static void printStack() {
        System.out.print(Constants.msgStack);
        for (int i = 0; i < stack.size(); i++) {
            Optor optor = stack.get(i);
            //check if the operator could be converted to be Long
            if(Utils.isLong(optor.getResult())){
                System.out.printf(Constants.msgLong, Double.valueOf(optor.getResult()).longValue());
            }else {
                System.out.printf(Constants.msgDouble, optor.getResult());
            }
        }
        System.out.print(Constants.msgLine);
    }

    public static void clearStacks() {
        undoStack.clear();
        stack.clear();
    }

    public static void revertStack(double optor){
        stack.push(new StackValue(optor));
    }


    public static void undo() {
        stack.pop();
        if (!undoStack.empty()) {
            Optor optor = undoStack.pop();
            if (optor instanceof FourOptor) {
                FourOptor optor1 = (FourOptor) optor;
                revertStack(optor1.getOpr1());
                revertStack(optor1.getOpr2());
            } else if (optor instanceof SingleOptor) {
                SingleOptor optor1 = (SingleOptor) optor;
                revertStack(optor1.getOpr1());
            } else if (optor instanceof ClearOptor) {
                //undo for clear operation

            } else {
                //stack.pop();
            }
        }
    }
}
