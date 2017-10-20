public class Subtraction extends Operator {

    public String toString(){
        return "-";
    }

    @Override
    double evaluate(double x, double y) {
        return x - y;
    }
}
