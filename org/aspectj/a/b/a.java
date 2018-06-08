package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hOL;
    String[] hOM;
    Class[] hON;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hOL = clsArr;
        this.hOM = strArr;
        this.hON = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hOL == null) {
            this.hOL = wH(3);
        }
        return this.hOL;
    }

    public Class[] getExceptionTypes() {
        if (this.hON == null) {
            this.hON = wH(5);
        }
        return this.hON;
    }
}
