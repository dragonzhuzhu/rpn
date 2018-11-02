/**
 * @author joe
 * @date 2018/11/2
 */
package com.airwallex.rpn.optor;

import com.airwallex.rpn.Constants;
import com.airwallex.rpn.OprException;

public class SingleOptor extends Optor {


    public SingleOptor(String optor, double opr1){
        this.setOptor(optor);;
        this.setOpr1(opr1);;
    }

    public void op() throws OprException {
        if(this.getOptor().equals(Constants.sqrt)) {
            if(this.getOpr1()<0d)  throw new OprException(Constants.exSqrt);
            this.setResult(Math.sqrt(this.getOpr1()));
        }
    }
    public static boolean isOptor(String str){
        return str.equals(Constants.sqrt);
    }
}
