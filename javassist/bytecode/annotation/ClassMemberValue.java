package javassist.bytecode.annotation;

import javassist.bytecode.BadBytecode;
import javassist.bytecode.SignatureAttribute;
import javassist.bytecode.y;
/* loaded from: classes.dex */
public class ClassMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    int f2764a;

    public ClassMemberValue(int i, y yVar) {
        super('c', yVar);
        this.f2764a = i;
    }

    public String a() {
        try {
            return SignatureAttribute.a(this.c.w(this.f2764a)).toString();
        } catch (BadBytecode e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return a() + ".class";
    }
}
