package org.aspectj.a.b;
/* loaded from: classes7.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] nJM;
    Class[] nJN;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.nJM = strArr;
        this.nJN = clsArr2;
    }

    public Class[] dMX() {
        if (this.parameterTypes == null) {
            this.parameterTypes = NT(3);
        }
        return this.parameterTypes;
    }

    public Class[] dMY() {
        if (this.nJN == null) {
            this.nJN = NT(5);
        }
        return this.nJN;
    }
}
