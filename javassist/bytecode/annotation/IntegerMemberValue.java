package javassist.bytecode.annotation;

import javassist.bytecode.y;
/* loaded from: classes.dex */
public class IntegerMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    int f2784a;

    public IntegerMemberValue(int i, y yVar) {
        super('I', yVar);
        this.f2784a = i;
    }

    public int a() {
        return this.c.r(this.f2784a);
    }

    public String toString() {
        return Integer.toString(a());
    }
}
