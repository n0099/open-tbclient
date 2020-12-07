package org.aspectj.a.b;
/* loaded from: classes16.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] pLC;
    Class[] pLD;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.pLC = strArr;
        this.pLD = clsArr2;
    }

    public Class[] eEt() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Sd(3);
        }
        return this.parameterTypes;
    }

    public Class[] eEu() {
        if (this.pLD == null) {
            this.pLD = Sd(5);
        }
        return this.pLD;
    }
}
