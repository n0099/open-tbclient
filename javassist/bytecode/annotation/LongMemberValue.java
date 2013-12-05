package javassist.bytecode.annotation;

import javassist.bytecode.y;
/* loaded from: classes.dex */
public class LongMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    int f2950a;

    public LongMemberValue(int i, y yVar) {
        super('J', yVar);
        this.f2950a = i;
    }

    public long a() {
        return this.c.t(this.f2950a);
    }

    public String toString() {
        return Long.toString(a());
    }
}
