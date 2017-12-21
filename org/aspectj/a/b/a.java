package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hMS;
    String[] hMT;
    Class[] hMU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hMS = clsArr;
        this.hMT = strArr;
        this.hMU = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hMS == null) {
            this.hMS = yc(3);
        }
        return this.hMS;
    }

    public Class[] getExceptionTypes() {
        if (this.hMU == null) {
            this.hMU = yc(5);
        }
        return this.hMU;
    }
}
