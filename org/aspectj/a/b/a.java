package org.aspectj.a.b;
/* loaded from: classes7.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] nXn;
    Class[] nXo;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.nXn = strArr;
        this.nXo = clsArr2;
    }

    public Class[] dTj() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Ln(3);
        }
        return this.parameterTypes;
    }

    public Class[] dTk() {
        if (this.nXo == null) {
            this.nXo = Ln(5);
        }
        return this.nXo;
    }
}
