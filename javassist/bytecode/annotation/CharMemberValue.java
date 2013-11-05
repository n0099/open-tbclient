package javassist.bytecode.annotation;

import javassist.bytecode.y;
/* loaded from: classes.dex */
public class CharMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    int f2731a;

    public CharMemberValue(int i, y yVar) {
        super('C', yVar);
        this.f2731a = i;
    }

    public char a() {
        return (char) this.c.r(this.f2731a);
    }

    public String toString() {
        return Character.toString(a());
    }
}
