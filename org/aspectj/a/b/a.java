package org.aspectj.a.b;
/* loaded from: classes7.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] nBC;
    Class[] nBD;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.nBC = strArr;
        this.nBD = clsArr2;
    }

    public Class[] dOD() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Kg(3);
        }
        return this.parameterTypes;
    }

    public Class[] dOE() {
        if (this.nBD == null) {
            this.nBD = Kg(5);
        }
        return this.nBD;
    }
}
