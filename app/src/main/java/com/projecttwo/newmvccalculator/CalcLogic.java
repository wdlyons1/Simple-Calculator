package com.projecttwo.newmvccalculator;


class CalcLogic {

    private Double val1;



    Double addition(Double val1, Double val2){
        this.val1 = val1 + val2;
        return this.val1;
    }

    Double subtraction(Double val1, Double val2){
        this.val1 = val1 - val2;
        return this.val1;
    }

    Double multiplication(Double val1, Double val2){
        this.val1 = val1 * val2;
        return this.val1;
    }

    Double division(Double val1, Double val2){
            this.val1 = val1 / val2;
            return this.val1;
    }

    Double switchAction(Double val1, Double val2, char Action) {
        switch (Action){
            case '+':
                this.val1 = addition(val1,val2);
                break;
            case '-':
                this.val1 = subtraction(val1,val2);
                break;
            case '*':
                this.val1 = multiplication(val1,val2);
                break;
            case '/':
                this.val1 = division(val1,val2);
                break;
        }
        return this.val1;
    }
}
