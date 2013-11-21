package javassist;

import javassist.bytecode.an;
import javassist.bytecode.z;
import javassist.compiler.ast.MethodDecl;
/* loaded from: classes.dex */
public final class CtConstructor extends CtBehavior {
    /* JADX INFO: Access modifiers changed from: protected */
    public CtConstructor(an anVar, h hVar) {
        super(hVar, anVar);
    }

    public CtConstructor(h[] hVarArr, h hVar) {
        this((an) null, hVar);
        this.f2724a = new an(hVar.h().c(), MethodDecl.initName, z.a(hVarArr));
        a(1);
    }

    public boolean g() {
        return this.f2724a.d();
    }

    public boolean h() {
        return this.f2724a.e();
    }

    @Override // javassist.l
    public String i() {
        return this.f2724a.e() ? "<clinit>" : this.c.o();
    }

    @Override // javassist.CtBehavior
    public void a(String str) {
        if (str == null) {
            if (h()) {
                str = ";";
            } else {
                str = "super();";
            }
        }
        super.a(str);
    }
}
