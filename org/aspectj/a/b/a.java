package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hJD;
    String[] hJE;
    Class[] hJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hJD = clsArr;
        this.hJE = strArr;
        this.hJF = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hJD == null) {
            this.hJD = wf(3);
        }
        return this.hJD;
    }

    public Class[] getExceptionTypes() {
        if (this.hJF == null) {
            this.hJF = wf(5);
        }
        return this.hJF;
    }
}
