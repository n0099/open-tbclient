package org.aspectj.a.b;
/* loaded from: classes7.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] nLK;
    Class[] nLL;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.nLK = strArr;
        this.nLL = clsArr2;
    }

    public Class[] dNy() {
        if (this.parameterTypes == null) {
            this.parameterTypes = NZ(3);
        }
        return this.parameterTypes;
    }

    public Class[] dNz() {
        if (this.nLL == null) {
            this.nLL = NZ(5);
        }
        return this.nLL;
    }
}
