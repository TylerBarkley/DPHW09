public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        OperatorNode div1 = new OperatorNode(new Division());
        div1.addChild(new Leaf(1));
        OperatorNode add1 = new OperatorNode(new Addition());
        div1.addChild(add1);
        add1.addChild(new Leaf(3));
        add1.addChild(new Leaf(2));
        OperatorNode mult1 = new OperatorNode(new Multiplication());
        mult1.addChild(new Leaf(9));
        mult1.addChild(new Leaf(11));
        add1.addChild(mult1);
        LispVisitor lV = new LispVisitor();
        lV.visitTree(div1);
        System.out.println();
        InfixVisitor infixVisitor = new InfixVisitor();
        infixVisitor.visitTree(div1);
        System.out.println();
        TextTreeVisitor textTreeVisitor = new TextTreeVisitor();
        textTreeVisitor.visitTree(div1);
        //sub1.toString();
    }
}
