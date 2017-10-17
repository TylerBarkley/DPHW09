public interface TreeVisitor {
    public abstract void visitTree(OperatorNode operatorNode);
    public abstract void visitTree(Leaf leaf);
}
