package javassist.bytecode.annotation;

import javassist.bytecode.y;
/* loaded from: classes.dex */
public class ShortMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    int f2770a;

    public ShortMemberValue(int i, y yVar) {
        super('S', yVar);
        this.f2770a = i;
    }

    public short a() {
        return (short) this.c.r(this.f2770a);
    }

    public String toString() {
        return Short.toString(a());
    }
}
