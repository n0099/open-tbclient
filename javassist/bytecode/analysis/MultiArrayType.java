package javassist.bytecode.analysis;

import javassist.NotFoundException;
/* loaded from: classes.dex */
public class MultiArrayType extends h {
    private MultiType r;
    private int s;

    public MultiArrayType(MultiType multiType, int i) {
        super(null);
        this.r = multiType;
        this.s = i;
    }

    @Override // javassist.bytecode.analysis.h
    public javassist.h a() {
        javassist.h a2 = this.r.a();
        if (a2 == null) {
            return null;
        }
        javassist.c a3 = a2.a();
        if (a3 == null) {
            a3 = javassist.c.a();
        }
        try {
            return a3.c(a(a2.n(), this.s));
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // javassist.bytecode.analysis.h
    boolean b() {
        return this.r.b();
    }

    @Override // javassist.bytecode.analysis.h
    public int c() {
        return this.s;
    }

    @Override // javassist.bytecode.analysis.h
    public h d() {
        return this.s == 1 ? this.r : new MultiArrayType(this.r, this.s - 1);
    }

    @Override // javassist.bytecode.analysis.h
    public int e() {
        return 1;
    }

    @Override // javassist.bytecode.analysis.h
    public boolean f() {
        return true;
    }

    @Override // javassist.bytecode.analysis.h
    public boolean a(h hVar) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override // javassist.bytecode.analysis.h
    public boolean g() {
        return true;
    }

    public boolean b(h hVar) {
        if (a(hVar.a(), h.n.a()) || a(hVar.a(), h.p.a()) || a(hVar.a(), h.o.a())) {
            return true;
        }
        if (hVar.f()) {
            h d = d(hVar);
            int c = hVar.c();
            if (c > this.s) {
                return false;
            }
            if (c < this.s) {
                return a(d.a(), h.n.a()) || a(d.a(), h.p.a()) || a(d.a(), h.o.a());
            }
            return this.r.b(d);
        }
        return false;
    }

    @Override // javassist.bytecode.analysis.h
    public boolean equals(Object obj) {
        if (obj instanceof MultiArrayType) {
            MultiArrayType multiArrayType = (MultiArrayType) obj;
            return this.r.equals(multiArrayType.r) && this.s == multiArrayType.s;
        }
        return false;
    }

    @Override // javassist.bytecode.analysis.h
    public String toString() {
        return a(this.r.toString(), this.s);
    }
}
