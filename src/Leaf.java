public class Leaf extends Node {

    private int value;

    public Leaf(int value){
        this.value = value;
    }

    public String toString(){
        return Integer.toString(value);
    }

    @Override
    void Accept(TreeVisitor treeVisitor) {
        treeVisitor.visitTree(this);
    }

    public int getValue(){
        return this.value;
    }
}
