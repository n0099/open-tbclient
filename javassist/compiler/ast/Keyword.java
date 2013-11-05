package javassist.compiler.ast;
/* loaded from: classes.dex */
public class Keyword extends ASTree {
    protected int tokenId;

    public Keyword(int i) {
        this.tokenId = i;
    }

    public int get() {
        return this.tokenId;
    }

    @Override // javassist.compiler.ast.ASTree
    public String toString() {
        return "id:" + this.tokenId;
    }

    @Override // javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }
}
