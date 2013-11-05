package javassist;

import javassist.bytecode.ad;
import javassist.bytecode.y;
import javassist.bytecode.z;
/* loaded from: classes.dex */
public class CtField extends l {

    /* renamed from: a  reason: collision with root package name */
    protected ad f2693a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CtField(ad adVar, h hVar) {
        super(hVar);
        this.f2693a = adVar;
    }

    @Override // javassist.l
    public String toString() {
        return c().n() + "." + i() + ":" + this.f2693a.d();
    }

    @Override // javassist.l
    protected void a(StringBuffer stringBuffer) {
        stringBuffer.append(' ');
        stringBuffer.append(i());
        stringBuffer.append(' ');
        stringBuffer.append(this.f2693a.d());
    }

    public ad a() {
        return this.f2693a;
    }

    @Override // javassist.l
    public h c() {
        return super.c();
    }

    @Override // javassist.l
    public String i() {
        return this.f2693a.b();
    }

    @Override // javassist.l
    public int b() {
        return javassist.bytecode.a.e(this.f2693a.c());
    }

    @Override // javassist.l
    public String e() {
        return this.f2693a.d();
    }

    public h d() {
        return z.c(this.f2693a.d(), this.c.a());
    }

    public Object f() {
        int e = this.f2693a.e();
        if (e == 0) {
            return null;
        }
        y a2 = this.f2693a.a();
        switch (a2.c(e)) {
            case 3:
                int r = a2.r(e);
                if ("Z".equals(this.f2693a.d())) {
                    return new Boolean(r != 0);
                }
                return new Integer(r);
            case 4:
                return new Float(a2.s(e));
            case 5:
                return new Long(a2.t(e));
            case 6:
                return new Double(a2.u(e));
            case 7:
            default:
                throw new RuntimeException("bad tag: " + a2.c(e) + " at " + e);
            case 8:
                return a2.v(e);
        }
    }
}
