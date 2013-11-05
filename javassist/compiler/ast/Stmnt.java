package javassist.compiler.ast;

import javassist.compiler.j;
/* loaded from: classes.dex */
public class Stmnt extends ASTList implements j {
    protected int operatorId;

    public Stmnt(int i, ASTree aSTree, ASTList aSTList) {
        super(aSTree, aSTList);
        this.operatorId = i;
    }

    public Stmnt(int i, ASTree aSTree) {
        super(aSTree);
        this.operatorId = i;
    }

    public Stmnt(int i) {
        this(i, null);
    }

    public static Stmnt make(int i, ASTree aSTree, ASTree aSTree2) {
        return new Stmnt(i, aSTree, new ASTList(aSTree2));
    }

    public static Stmnt make(int i, ASTree aSTree, ASTree aSTree2, ASTree aSTree3) {
        return new Stmnt(i, aSTree, new ASTList(aSTree2, new ASTList(aSTree3)));
    }

    @Override // javassist.compiler.ast.ASTList, javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }

    public int getOperator() {
        return this.operatorId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javassist.compiler.ast.ASTree
    public String getTag() {
        return this.operatorId < 128 ? "stmnt:" + ((char) this.operatorId) : "stmnt:" + this.operatorId;
    }
}
