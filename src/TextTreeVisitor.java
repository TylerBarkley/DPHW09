import java.util.ArrayList;

public class TextTreeVisitor implements TreeVisitor {

    private StringBuilder stringBuilder;
    private int depth;
    private ArrayList<Integer> linesAndTabs;

    public TextTreeVisitor(){
        this.stringBuilder = new StringBuilder();
        this.depth = 0;
        this.linesAndTabs = new ArrayList<>();
    }


    /* ENJOY THIS CAT JEFF
                  ;,_            ,
                 _uP~"b          d"u,
                dP'   "b       ,d"  "o
               d"    , `b     d"'    "b
              l] [    " `l,  d"       lb
              Ol ?     "  "b`"=uoqo,_  "l
            ,dBb "b        "b,    `"~~TObup,_
          ,d" (db.`"         ""     "tbc,_ `~"Yuu,_
        .d" l`T'  '=                      ~     `""Yu,
      ,dO` gP,                           `u,   b,_  "b7
     d?' ,d" l,                           `"b,_ `~b  "1
   ,8i' dl   `l                 ,ggQOV",dbgq,._"  `l  lb
  .df' (O,    "             ,ggQY"~  , @@@@@d"bd~  `b "1
 .df'   `"           -=@QgpOY""     (b  @@@@P db    `Lp"b,
.d(                  _               "ko "=d_,Q`  ,_  "  "b,
Ql         .         `"qo,._          "tQo,_`""bo ;tb,    `"b,
qQ         |L           ~"QQQgggc,_.,dObc,opooO  `"~~";.   __,7,
qp         t\io,_           `~"TOOggQV""""        _,dg,_ =PIQHib.
`qp        `Q["tQQQo,_                          ,pl{QOP"'   7AFR`
  `         `tb  '""tQQQg,_             p" "b   `       .;-.`Vl'
             "Yb      `"tQOOo,__    _,edb    ` .__   /`/'|  |b;=;.__
                           `"tQQQOOOOP""`"\QV;qQObob"`-._`\_~~-._
                                """"    ._        /   | |oP"\_   ~\ ~\_~\
                                        `~"\ic,qggddOOP"|  |  ~\   `\~-._
                                          ,qP`"""|"   | `\ `;   `\   `\
                               _        _,p"     |    |   `\`;    |    |
       unknown                 "boo,._dP"       `\_  `\    `\|   `\   ;
                                 `"7tY~'            `\  `\    `|_   |
                                                      `~\  |
     */
    @Override
    public void visitTree(OperatorNode operatorNode) {
        if(depth != 0){
            stringBuilder.append("\n");
        }

        addLinesAndTabs();

        if(depth != 0){
            stringBuilder.append(" +---");
        }
        linesAndTabs.add(depth);
        stringBuilder.append("[" + operatorNode.getOperator().toString() + "]");
        for(int i = 0; i < operatorNode.getChildren().size(); i++){
            if(i == operatorNode.getChildren().size() - 1){
                linesAndTabs.remove(new Integer(depth));
            }
            depth++;
            operatorNode.getChildren().get(i).Accept(this);
            depth--;
        }
    }

    @Override
    public void visitTree(Leaf leaf) {
        if(depth != 0) {
            this.stringBuilder.append("\n");
        }
        addLinesAndTabs();
        this.stringBuilder.append(" +---[" + leaf.toString() + "]");
    }

    private void resetStringBuilder(){
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public String toString() {
        return this.stringBuilder.toString();
    }

    private void addLinesAndTabs(){
        for(int x = 0; x < depth - 1; x++){

            if(linesAndTabs.contains(x)){
                stringBuilder.append(" |");
            }

            stringBuilder.append("\t");
            /*
            for(int i = 1; i < depth; i++){
                stringBuilder.append(" ");
            }*/
        }
    }

}
