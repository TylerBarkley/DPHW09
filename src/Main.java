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
        System.out.println("LISP VISITOR");
        System.out.println(lV.toString());
        System.out.println();
        InfixVisitor infixVisitor = new InfixVisitor();
        infixVisitor.visitTree(div1);
        System.out.println("INFIX VISITOR");
        System.out.println(infixVisitor.toString());
        System.out.println();
        ValueVisitor valueVisitor = new ValueVisitor();
        valueVisitor.visitTree(div1);
        System.out.println("EVALUATION VISITOR");
        System.out.println(valueVisitor.toString() + "\n");
        System.out.println("TEXTUAL TREE");
        div1.addChild(new Leaf(5));
        TextTreeVisitor textTreeVisitor = new TextTreeVisitor();
        textTreeVisitor.visitTree(div1);
        System.out.println(textTreeVisitor.toString() + "\n");
        OperatorNode add2 = new OperatorNode(new Addition());
        add2.addChild(new Leaf(11));
        OperatorNode mult2 = new OperatorNode(new Multiplication());
        add2.addChild(mult2);
        add2.addChild(new Leaf(-23));
        OperatorNode div2 = new OperatorNode(new Division());
        OperatorNode sub2 = new OperatorNode(new Subtraction());
        div2.addChild(new Leaf(1));
        div2.addChild(new Leaf(2));
        OperatorNode add5 = new OperatorNode(new Addition());
        add5.addChild(new Leaf(3));
        add5.addChild(new Leaf(-5));
        sub2.addChild(add5);
        sub2.addChild(new Leaf(45));
        mult2.addChild(div2);
        mult2.addChild(sub2);
        TextTreeVisitor textTreeVisitor2 = new TextTreeVisitor();
        textTreeVisitor2.visitTree(add2);
        System.out.println("TEXT TREE VISITOR 2");
        System.out.println(textTreeVisitor2.toString());

    }
}
