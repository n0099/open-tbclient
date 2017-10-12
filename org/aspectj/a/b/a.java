package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hnH;
    String[] hnI;
    Class[] hnJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hnH = clsArr;
        this.hnI = strArr;
        this.hnJ = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hnH == null) {
            this.hnH = wR(3);
        }
        return this.hnH;
    }

    public Class[] getExceptionTypes() {
        if (this.hnJ == null) {
            this.hnJ = wR(5);
        }
        return this.hnJ;
    }
}
