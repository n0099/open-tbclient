package org.aspectj.a.b;
/* loaded from: classes7.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] nAs;
    Class[] nAt;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.nAs = strArr;
        this.nAt = clsArr2;
    }

    public Class[] dOp() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Ke(3);
        }
        return this.parameterTypes;
    }

    public Class[] dOq() {
        if (this.nAt == null) {
            this.nAt = Ke(5);
        }
        return this.nAt;
    }
}
