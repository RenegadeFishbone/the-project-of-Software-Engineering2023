package src;
import java.util.Random;
import java.util.Scanner;
abstract class BinaryOperation {
    static final int UPPER = 100;
    static final int LOWER=0;
    private int left_operand=0,right_operand=0;
    private char operator='+';
    private int value=0;
    protected void generateBinaryOperation(char anOperator){
        int left,right,result;
        Random random=new Random();
        left=random.nextInt(UPPER+1);
        do{
            right=random.nextInt(UPPER+1);
            result=calculate(left,right);
        }while(!(checkingCalculation(result)));
        if(result<0){
            left_operand=right;
            right_operand=left;
            operator=anOperator;
            value=-result;
        }
        else{
            left_operand=left;
            right_operand=right;
            operator=anOperator;
            value=result;
        }
    }
    abstract boolean checkingCalculation(int anInteger);  //检查结果是否符合范围
    abstract int calculate(int left,int right);  //返回计算值---一开始无法确定，具体类具体实现
    public boolean equals(BinaryOperation anOperation){
        return left_operand == anOperation.getLeftoperand()&
                right_operand == anOperation.getRightOperand()&
                operator == anOperation.getOperator();
    }
    public char getOperator() {
        // TODO Auto-generated method stub
        return operator;
    }
    public int getRightOperand() {
        // TODO Auto-generated method stub
        return right_operand;
    }
    public int getLeftoperand() {
        // TODO Auto-generated method stub
        return left_operand;
    }
    public int getValue(){
        return value;
    }

}
class AdditionOperation extends BinaryOperation{
    AdditionOperation(){
        generateBinaryOperation('+');
    }

    @Override
    public boolean checkingCalculation(int anInteger) {
        // TODO Auto-generated method stub
        return anInteger<=UPPER;
    }

    @Override
    int calculate(int left, int right) {
        // TODO Auto-generated method stub
        return left+right;
    }
}
class SubstractOperation extends BinaryOperation{
    SubstractOperation(){
        generateBinaryOperation('-');
    }
    @Override
    boolean checkingCalculation(int anInteger) {
        // TODO Auto-generated method stub
        return anInteger<=UPPER;
    }

    @Override
    int calculate(int left, int right) {
        // TODO Auto-generated method stub
        return left-right;
    }

}