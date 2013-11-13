package javassist;

import javassist.bytecode.BadBytecode;
import javassist.bytecode.ExceptionsAttribute;
import javassist.bytecode.an;
import javassist.bytecode.z;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;
/* loaded from: classes.dex */
public abstract class CtBehavior extends l {

    /* renamed from: a  reason: collision with root package name */
    protected an f2740a;

    /* JADX INFO: Access modifiers changed from: protected */
    public CtBehavior(h hVar, an anVar) {
        super(hVar);
        this.f2740a = anVar;
    }

    @Override // javassist.l
    protected void a(StringBuffer stringBuffer) {
        stringBuffer.append(' ');
        stringBuffer.append(i());
        stringBuffer.append(' ');
        stringBuffer.append(this.f2740a.g());
    }

    public an a() {
        return this.f2740a;
    }

    @Override // javassist.l
    public int b() {
        return javassist.bytecode.a.e(this.f2740a.f());
    }

    public void a(int i) {
        this.c.l();
        this.f2740a.a(javassist.bytecode.a.d(i));
    }

    public h[] i_() {
        return z.a(this.f2740a.g(), this.c.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h d() {
        return z.b(this.f2740a.g(), this.c.a());
    }

    @Override // javassist.l
    public String e() {
        return this.f2740a.g();
    }

    public h[] f() {
        String[] a2;
        ExceptionsAttribute h = this.f2740a.h();
        if (h == null) {
            a2 = null;
        } else {
            a2 = h.a();
        }
        return this.c.a().a(a2);
    }

    public void a(h[] hVarArr) {
        this.c.l();
        if (hVarArr == null || hVarArr.length == 0) {
            this.f2740a.j();
            return;
        }
        String[] strArr = new String[hVarArr.length];
        for (int i = 0; i < hVarArr.length; i++) {
            strArr[i] = hVarArr[i].n();
        }
        ExceptionsAttribute h = this.f2740a.h();
        if (h == null) {
            h = new ExceptionsAttribute(this.f2740a.c());
            this.f2740a.a(h);
        }
        h.a(strArr);
    }

    public void a(String str) {
        a(str, null, null);
    }

    public void a(String str, String str2, String str3) {
        h hVar = this.c;
        hVar.l();
        try {
            Javac javac = new Javac(hVar);
            if (str3 != null) {
                javac.a(str2, str3);
            }
            this.f2740a.a(javac.a(this, str).e());
            this.f2740a.a(this.f2740a.f() & (-1025));
            this.f2740a.a(hVar.a(), hVar.h());
            this.c.v();
        } catch (BadBytecode e) {
            throw new CannotCompileException(e);
        } catch (CompileError e2) {
            throw new CannotCompileException(e2);
        }
    }
}
