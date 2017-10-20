import java.util.ArrayList;

public class OperatorNode extends Node {

    private Operator operator;
    private ArrayList<Node> children;

    public OperatorNode(Operator operator){
        this.operator = operator;
        this.children = new ArrayList<Node>();
    }

    public void addChild(OperatorNode o){
        this.children.add(o);
    }

    public void addChild(Leaf l){
        this.children.add(l);
    }

    public String toString(){
        return operator.toString();
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    @Override
    void Accept(TreeVisitor treeVisitor) {
        treeVisitor.visitTree(this);
    }

    public Operator getOperator() {
        return this.operator;
    }

    public double evaluate(double x, double y){
        return this.operator.evaluate(x,y);
    }
}