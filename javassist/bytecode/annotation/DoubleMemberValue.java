package javassist.bytecode.annotation;

import javassist.bytecode.y;
/* loaded from: classes.dex */
public class DoubleMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    int f2733a;

    public DoubleMemberValue(int i, y yVar) {
        super('D', yVar);
        this.f2733a = i;
    }

    public double a() {
        return this.c.u(this.f2733a);
    }

    public String toString() {
        return Double.toString(a());
    }
}
