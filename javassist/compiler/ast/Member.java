package javassist.compiler.ast;

import javassist.CtField;
/* loaded from: classes.dex */
public class Member extends Symbol {
    private CtField field;

    public Member(String str) {
        super(str);
        this.field = null;
    }

    public void setField(CtField ctField) {
        this.field = ctField;
    }

    public CtField getField() {
        return this.field;
    }

    @Override // javassist.compiler.ast.Symbol, javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }
}
