package org.aspectj.a.b;
/* loaded from: classes7.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] nfr;
    Class[] nfs;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.nfr = strArr;
        this.nfs = clsArr2;
    }

    public Class[] dGu() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Jt(3);
        }
        return this.parameterTypes;
    }

    public Class[] dGv() {
        if (this.nfs == null) {
            this.nfs = Jt(5);
        }
        return this.nfs;
    }
}
