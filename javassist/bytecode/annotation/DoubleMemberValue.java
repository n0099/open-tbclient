package javassist.bytecode.annotation;

import javassist.bytecode.y;
/* loaded from: classes.dex */
public class DoubleMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    int f2946a;

    public DoubleMemberValue(int i, y yVar) {
        super('D', yVar);
        this.f2946a = i;
    }

    public double a() {
        return this.c.u(this.f2946a);
    }

    public String toString() {
        return Double.toString(a());
    }
}
