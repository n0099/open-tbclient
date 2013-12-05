package javassist;

import javassist.bytecode.an;
import javassist.bytecode.z;
/* loaded from: classes.dex */
public final class CtMethod extends CtBehavior {
    protected String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CtMethod(an anVar, h hVar) {
        super(hVar, anVar);
        this.d = null;
    }

    public CtMethod(h hVar, String str, h[] hVarArr, h hVar2) {
        this(null, hVar2);
        this.f2905a = new an(hVar2.h().c(), str, z.a(hVar, hVarArr));
        a(1025);
    }

    public int hashCode() {
        return g().hashCode();
    }

    final String g() {
        if (this.d == null) {
            this.d = this.f2905a.a() + z.e(this.f2905a.g());
        }
        return this.d;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof CtMethod) && ((CtMethod) obj).g().equals(g());
    }

    @Override // javassist.l
    public String i() {
        return this.f2905a.a();
    }

    public h h() {
        return d();
    }
}
