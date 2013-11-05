package javassist.compiler.ast;
/* loaded from: classes.dex */
public class Symbol extends ASTree {
    protected String identifier;

    public Symbol(String str) {
        this.identifier = str;
    }

    public String get() {
        return this.identifier;
    }

    @Override // javassist.compiler.ast.ASTree
    public String toString() {
        return this.identifier;
    }

    @Override // javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }
}
