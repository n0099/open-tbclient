package javassist.bytecode.annotation;

import javassist.bytecode.y;
/* loaded from: classes.dex */
public class BooleanMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    int f2777a;

    public BooleanMemberValue(int i, y yVar) {
        super('Z', yVar);
        this.f2777a = i;
    }

    public boolean a() {
        return this.c.r(this.f2777a) != 0;
    }

    public String toString() {
        return a() ? "true" : "false";
    }
}
