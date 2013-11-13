package javassist.bytecode.annotation;

import javassist.bytecode.y;
/* loaded from: classes.dex */
public class ArrayMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    d f2776a;
    d[] b;

    public ArrayMemberValue(y yVar) {
        super('[', yVar);
        this.f2776a = null;
        this.b = null;
    }

    public void a(d[] dVarArr) {
        this.b = dVarArr;
        if (dVarArr != null && dVarArr.length > 0) {
            this.f2776a = dVarArr[0];
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("{");
        if (this.b != null) {
            for (int i = 0; i < this.b.length; i++) {
                stringBuffer.append(this.b[i].toString());
                if (i + 1 < this.b.length) {
                    stringBuffer.append(", ");
                }
            }
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
