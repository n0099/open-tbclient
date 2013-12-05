package javassist;

import java.io.DataOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends j {
    protected boolean s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(String str, c cVar, boolean z, h hVar) {
        super(str, cVar);
        String str2;
        this.n = true;
        if (z || hVar == null) {
            str2 = null;
        } else {
            str2 = hVar.n();
        }
        this.q = new javassist.bytecode.i(z, str, str2);
        if (z && hVar != null) {
            this.q.a(new String[]{hVar.n()});
        }
        a(v.g(c()));
        this.s = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javassist.j, javassist.h
    public void a(StringBuffer stringBuffer) {
        if (this.s) {
            stringBuffer.append("hasConstructor ");
        }
        super.a(stringBuffer);
    }

    @Override // javassist.j, javassist.h
    public void a(CtConstructor ctConstructor) {
        this.s = true;
        super.a(ctConstructor);
    }

    @Override // javassist.j, javassist.h
    public void a(DataOutputStream dataOutputStream) {
        if (!this.s) {
            try {
                C();
                this.s = true;
            } catch (NotFoundException e) {
                throw new CannotCompileException(e);
            }
        }
        super.a(dataOutputStream);
    }

    public void C() {
        CtConstructor[] s;
        h f = f();
        int i = 0;
        for (CtConstructor ctConstructor : f.s()) {
            int b = ctConstructor.b();
            if (a(b, f)) {
                CtConstructor a2 = p.a(ctConstructor.i_(), ctConstructor.f(), this);
                a2.a(b & 7);
                a(a2);
                i++;
            }
        }
        if (i < 1) {
            throw new CannotCompileException("no inheritable constructor in " + f.n());
        }
    }

    private boolean a(int i, h hVar) {
        if (v.b(i)) {
            return false;
        }
        if (v.c(i)) {
            String p = p();
            String p2 = hVar.p();
            if (p == null) {
                return p2 == null;
            }
            return p.equals(p2);
        }
        return true;
    }
}
