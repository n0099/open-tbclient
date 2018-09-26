package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hRE;
    String[] hRF;
    Class[] hRG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hRE = clsArr;
        this.hRF = strArr;
        this.hRG = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hRE == null) {
            this.hRE = wD(3);
        }
        return this.hRE;
    }

    public Class[] getExceptionTypes() {
        if (this.hRG == null) {
            this.hRG = wD(5);
        }
        return this.hRG;
    }
}
