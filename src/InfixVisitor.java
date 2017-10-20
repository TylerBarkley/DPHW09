public class InfixVisitor implements TreeVisitor {

    private StringBuilder stringBuilder;

    public InfixVisitor(){
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void visitTree(OperatorNode operatorNode) {
        this.stringBuilder.append("(");
        for(int i = 0; i < operatorNode.getChildren().size(); i++){
            this.stringBuilder.toString();
            operatorNode.getChildren().get(i).Accept(this);
            if(i != operatorNode.getChildren().size() - 1){
                this.stringBuilder.append(" ");
                this.stringBuilder.append(operatorNode.toString());
                this.stringBuilder.append(" ");
            }
        }
        this.stringBuilder.append(")");
    }

    @Override
    public void visitTree(Leaf leaf) {
        this.stringBuilder.append(leaf.toString());
    }

    private void resetStringBuilder(){
        this.stringBuilder = new StringBuilder();
    }

    public String toString(){
        this.stringBuilder.deleteCharAt(0);
        this.stringBuilder.deleteCharAt(this.stringBuilder.length()-1);
        return this.stringBuilder.toString();
    }
}
