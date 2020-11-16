package org.aspectj.a.b;
/* loaded from: classes11.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] parameterTypes;
    String[] qbC;
    Class[] qbD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.qbC = strArr;
        this.qbD = clsArr2;
    }

    public Class[] eEu() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Sk(3);
        }
        return this.parameterTypes;
    }

    public Class[] eEv() {
        if (this.qbD == null) {
            this.qbD = Sk(5);
        }
        return this.qbD;
    }
}
