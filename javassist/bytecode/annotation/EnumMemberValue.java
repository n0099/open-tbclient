package javassist.bytecode.annotation;

import javassist.bytecode.y;
import javassist.bytecode.z;
/* loaded from: classes.dex */
public class EnumMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    int f2947a;
    int b;

    public EnumMemberValue(int i, int i2, y yVar) {
        super('e', yVar);
        this.f2947a = i;
        this.b = i2;
    }

    public String a() {
        return z.c(this.c.w(this.f2947a));
    }

    public String b() {
        return this.c.w(this.b);
    }

    public String toString() {
        return a() + "." + b();
    }
}
