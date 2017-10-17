public class TextTreeVisitor implements TreeVisitor {

    private StringBuilder stringBuilder;
    int times = -1;

    public TextTreeVisitor(){
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void visitTree(OperatorNode operatorNode) {
        this.stringBuilder.append("[" + operatorNode.toString() + "]\n");
        ++times;
        for(int i = 0; i < operatorNode.getChildren().size(); i++){
            System.out.print(this.stringBuilder.toString());
            resetStringBuilder();
            this.stringBuilder.append(" ");
            for(int j = 0; j < times; j++){
                this.stringBuilder.append("\t");
                this.stringBuilder.append(" ");
                for(int k = 0; k < times; k++)
                    this.stringBuilder.append(" ");
            }
            this.stringBuilder.append("+---");
            operatorNode.getChildren().get(i).Accept(this);
        }
        System.out.println(stringBuilder.toString());
        resetStringBuilder();
    }

    @Override
    public void visitTree(Leaf leaf) {
        this.stringBuilder.append("[" + leaf.toString() + "]\n");
    }

    private void resetStringBuilder(){
        this.stringBuilder = new StringBuilder();
    }

}
