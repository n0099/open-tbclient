package org.aspectj.a.b;
/* loaded from: classes7.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] nfo;
    Class[] nfp;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.nfo = strArr;
        this.nfp = clsArr2;
    }

    public Class[] dGy() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Jt(3);
        }
        return this.parameterTypes;
    }

    public Class[] dGz() {
        if (this.nfp == null) {
            this.nfp = Jt(5);
        }
        return this.nfp;
    }
}
