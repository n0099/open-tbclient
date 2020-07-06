package org.aspectj.a.b;
/* loaded from: classes7.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] nXq;
    Class[] nXr;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.nXq = strArr;
        this.nXr = clsArr2;
    }

    public Class[] dTn() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Ln(3);
        }
        return this.parameterTypes;
    }

    public Class[] dTo() {
        if (this.nXr == null) {
            this.nXr = Ln(5);
        }
        return this.nXr;
    }
}
