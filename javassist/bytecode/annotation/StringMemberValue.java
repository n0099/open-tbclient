package javassist.bytecode.annotation;

import javassist.bytecode.y;
/* loaded from: classes.dex */
public class StringMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    int f2739a;

    public StringMemberValue(int i, y yVar) {
        super('s', yVar);
        this.f2739a = i;
    }

    public String a() {
        return this.c.w(this.f2739a);
    }

    public String toString() {
        return "\"" + a() + "\"";
    }
}
