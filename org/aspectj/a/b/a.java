package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] ktF;
    String[] ktG;
    Class[] ktH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.ktF = clsArr;
        this.ktG = strArr;
        this.ktH = clsArr2;
    }

    public Class[] cOs() {
        if (this.ktF == null) {
            this.ktF = EO(3);
        }
        return this.ktF;
    }

    public Class[] cOt() {
        if (this.ktH == null) {
            this.ktH = EO(5);
        }
        return this.ktH;
    }
}
