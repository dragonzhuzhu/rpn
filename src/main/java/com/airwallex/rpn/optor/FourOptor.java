/**
 * @author joe
 * @date 2018/11/2
 */
package com.airwallex.rpn.optor;

import com.airwallex.rpn.Constants;
import com.airwallex.rpn.OprException;

public class FourOptor extends Optor {

    private double opr2=0d;

    public double getOpr2() {
        return opr2;
    }

    public void setOpr2(double opr2) {
        this.opr2 = opr2;
    }

    public FourOptor(String optor, double opr1, double opr2){
        this.setOptor(optor);
        this.setOpr1(opr1);
        this.opr2=opr2;
    }
    public void op() throws OprException {
        if(this.getOptor().equals(Constants.add)) {
            this.setResult(this.getOpr1() + opr2);
        }else if(this.getOptor().equals(Constants.sub)) {
            this.setResult(this.getOpr1() - opr2);
        }else if(this.getOptor().equals(Constants.multiply)) {
            this.setResult(this.getOpr1() * opr2);
        }else if(this.getOptor().equals(Constants.divide)) {
            if(opr2==0d) throw new OprException(Constants.exDivide);
            this.setResult(this.getOpr1() / opr2);
        }else{
            throw new OprException(Constants.exFourOptor);
        }

    }

    public static boolean isOptor(String str){
        return str.equals(Constants.add) || str.equals(Constants.sub) ||str.equals(Constants.multiply) ||str.equals(Constants.divide);
    }
}
