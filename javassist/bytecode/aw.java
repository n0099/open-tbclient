package javassist.bytecode;

import javassist.bytecode.SignatureAttribute;
/* loaded from: classes.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    SignatureAttribute.ObjectType f2779a;
    char b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(SignatureAttribute.ObjectType objectType, char c) {
        this.f2779a = objectType;
        this.b = c;
    }

    public aw() {
        this(null, '*');
    }

    public String toString() {
        if (this.b == '*') {
            return "?";
        }
        String obj = this.f2779a.toString();
        if (this.b != ' ') {
            if (this.b == '+') {
                return "? extends " + obj;
            }
            return "? super " + obj;
        }
        return obj;
    }
}
