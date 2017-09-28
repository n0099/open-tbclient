package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hnI;
    String[] hnJ;
    Class[] hnK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hnI = clsArr;
        this.hnJ = strArr;
        this.hnK = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hnI == null) {
            this.hnI = wR(3);
        }
        return this.hnI;
    }

    public Class[] getExceptionTypes() {
        if (this.hnK == null) {
            this.hnK = wR(5);
        }
        return this.hnK;
    }
}
