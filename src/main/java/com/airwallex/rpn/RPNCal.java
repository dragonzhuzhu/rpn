/**
 * @author joe
 * @date 2018/11/2
 */
package com.airwallex.rpn;

import com.airwallex.rpn.optor.ClearOptor;
import com.airwallex.rpn.optor.FourOptor;
import com.airwallex.rpn.optor.SingleOptor;
import com.airwallex.rpn.optor.UndoOptor;

import java.util.Scanner;

public class RPNCal {

    public static void main(String[] args){
        System.out.println(Constants.msgInput);
        Scanner sc=new Scanner(System.in);

        while(true){
            String line = sc.nextLine();
            RPNCal cal=new RPNCal();
            try {
                cal.evalRPN(line);
                cal.printStack();
            }catch(OprException e){
                System.out.println(e.getMessage());
                cal.printStack();
            }
        }
    }

    public void clear(){
        StackMgt.clearStacks();
    }
    public void printStack(){
        StackMgt.printStack();
    }
    public void evalRPN(String input) throws OprException {

        //check if there are other optors which don't support
       /* if(!input.matches(Constants.regOptor)) {
            System.out.println(Constants.unExpOptor);
            return;
        }*/

        String[] inputs = input.split(Constants.regSplit);
        //indicate which char when it throws exceptions
        int i = 1;
        for (String str : inputs) {
            //maybe more than one space
            if (!str.equals("")) {
                if (FourOptor.isOptor(str)) {
                    //need two parameters here for +-*/
                    if (StackMgt.stackSize() < 2) {
                        String msg=Utils.format(Constants.exParam,str,i);
                        throw new OprException(msg);
                    } else {
                        StackMgt.fourOptor(str);
                    }
                } else if (SingleOptor.isOptor(str)) {
                    //need one parameter here for sqrt
                    if (StackMgt.stackSize() < 1) {
                        String msg=Utils.format(Constants.exParam,str,i);
                        throw new OprException(msg);
                    } else {
                        StackMgt.singleOptor(str);
                    }
                } else if (ClearOptor.isOptor(str)) { //for clear
                    StackMgt.copyStack();
                } else if (UndoOptor.isOptor(str)) {// for undo
                    StackMgt.undo();
                    //StackMgt.printStack();
                } else { //for numbers
                   try{
                      double opr= Double.valueOf(str);
                      StackMgt.pushStack(opr);
                   }catch(Exception e){
                       String msg=Utils.format(Constants.exFormat,str,i);;
                       throw new OprException(msg);
                    }

                }
            }
            //for operator sqrt/clear/undo+one space
            i += str.length() + 1;
        }
    }
}
