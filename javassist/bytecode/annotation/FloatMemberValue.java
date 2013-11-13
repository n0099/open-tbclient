package javassist.bytecode.annotation;

import javassist.bytecode.y;
/* loaded from: classes.dex */
public class FloatMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    int f2783a;

    public FloatMemberValue(int i, y yVar) {
        super('F', yVar);
        this.f2783a = i;
    }

    public float a() {
        return this.c.s(this.f2783a);
    }

    public String toString() {
        return Float.toString(a());
    }
}
