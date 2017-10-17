public class LispVisitor implements TreeVisitor {

    private StringBuilder stringBuilder;

    public LispVisitor(){
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void visitTree(OperatorNode operatorNode) {
        this.stringBuilder.append("(");
        this.stringBuilder.append(operatorNode.toString());
        this.stringBuilder.append(" ");
        for(int i = 0; i < operatorNode.getChildren().size(); i++){
            System.out.print(this.stringBuilder.toString());
            resetStringBuilder();
            operatorNode.getChildren().get(i).Accept(this);
            if(i != operatorNode.getChildren().size() - 1){
                this.stringBuilder.append(" ");
            }
        }
        this.stringBuilder.append(")");
        System.out.print(this.stringBuilder.toString());
        resetStringBuilder();
    }

    @Override
    public void visitTree(Leaf leaf) {
        this.stringBuilder.append(leaf.toString());
    }

    private void resetStringBuilder(){
        this.stringBuilder = new StringBuilder();
    }
}
