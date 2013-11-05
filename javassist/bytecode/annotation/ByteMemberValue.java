package javassist.bytecode.annotation;

import javassist.bytecode.y;
/* loaded from: classes.dex */
public class ByteMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    int f2730a;

    public ByteMemberValue(int i, y yVar) {
        super('B', yVar);
        this.f2730a = i;
    }

    public byte a() {
        return (byte) this.c.r(this.f2730a);
    }

    public String toString() {
        return Byte.toString(a());
    }
}
