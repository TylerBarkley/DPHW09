import java.util.Stack;

public class ValueVisitor implements TreeVisitor {

    double evaluation;
    Stack<Double> evaluationStack = new Stack<Double>();

    public ValueVisitor(){
        this.evaluation = 0;
    }

    /*Value this cat Jeff
       T."-._..---.._,-"/|
                  l|"-.  _.v._   (" |
                  [l /.'_ \; _~"-.`-t
                  Y " _(o} _{o)._ ^.|
                  j  T  ,-<v>-.  T  ]
                  \  l ( /-^-\ ) !  !
                   \. \.  "~"  ./  /c-..,__
                     ^r- .._ .- .-"  `- .  ~"--.
                      > \.                      \
                      ]   ^.                     \
                      3  .  ">            .       Y  -Row
         ,.__.--._   _j   \ ~   .         ;       |
        (    ~"-._~"^._\   ^.    ^._      I     . l
         "-._ ___ ~"-,_7    .Z-._   7"   Y      ;  \        _
            /"   "~-(r r  _/_--._~-/    /      /,.--^-._   / Y
            "-._    '"~~~>-._~]>--^---./____,.^~        ^.^  !
                ~--._    '   Y---.                        \./
                     ~~--._  l_   )                        \
                           ~-._~~~---._,____..---           \
                               ~----"~       \
     */

    @Override
    public void visitTree(OperatorNode operatorNode) {

        Stack<Double> operatorStack = new Stack<Double>();
        double sumValue = 0;

        for(int i = 0; i < operatorNode.getChildren().size(); i++){
            operatorNode.getChildren().get(i).Accept(this);
        }

        for(int j = 0; j < operatorNode.getChildren().size(); j++){
            operatorStack.push(evaluationStack.pop());
        }

        sumValue = operatorStack.pop();

        while(operatorStack.empty() != true){
            sumValue = operatorNode.evaluate(sumValue, operatorStack.pop());
        }
        evaluationStack.push(sumValue);
    }

    @Override
    public void visitTree(Leaf leaf) {
        double x  = leaf.getValue();
        evaluationStack.add(x);
    }

    public String toString(){
        return evaluationStack.peek().toString();
    }

}
