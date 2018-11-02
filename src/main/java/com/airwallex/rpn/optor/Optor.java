/**
 * @author joe
 * @date 2018/11/2
 */

package com.airwallex.rpn.optor;

import com.airwallex.rpn.OprException;


public abstract class Optor {

      private String optor="";

      private double opr1=0d;

      private  double result=0d;

      public String getOptor() {
            return optor;
      }

      public void setOptor(String optor) {
            this.optor = optor;
      }

      public double getOpr1() {
            return opr1;
      }

      public void setOpr1(double opr1) {
            this.opr1 = opr1;
      }

      public double getResult() {
            return result;
      }

      public void setResult(double result) {
            this.result = result;
      }

      public abstract void op() throws OprException;

}
