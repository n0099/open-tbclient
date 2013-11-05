package javassist.compiler.ast;
/* loaded from: classes.dex */
public class ArrayInit extends ASTList {
    public ArrayInit(ASTree aSTree) {
        super(aSTree);
    }

    @Override // javassist.compiler.ast.ASTList, javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }

    @Override // javassist.compiler.ast.ASTree
    public String getTag() {
        return "array";
    }
}
