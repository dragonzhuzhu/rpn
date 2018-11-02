/**
 * @author joe
 * @date 2018/11/2
 */
package com.airwallex.rpn.optor;

import com.airwallex.rpn.OprException;

public class StackValue extends Optor {

    public StackValue(double value){
        this.setResult(value);
    }

    public StackValue(String value) throws OprException{
        try {
            this.setResult(Double.valueOf(value).doubleValue());
        }catch(Exception e){
            throw new OprException();
        }
    }
    public void op() throws OprException {}
}
