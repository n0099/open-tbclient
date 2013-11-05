package javassist.compiler.ast;
/* loaded from: classes.dex */
public class StringL extends ASTree {
    protected String text;

    public StringL(String str) {
        this.text = str;
    }

    public String get() {
        return this.text;
    }

    @Override // javassist.compiler.ast.ASTree
    public String toString() {
        return "\"" + this.text + "\"";
    }

    @Override // javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }
}
