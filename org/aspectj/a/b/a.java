package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hSR;
    String[] hSS;
    Class[] hST;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hSR = clsArr;
        this.hSS = strArr;
        this.hST = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hSR == null) {
            this.hSR = wQ(3);
        }
        return this.hSR;
    }

    public Class[] getExceptionTypes() {
        if (this.hST == null) {
            this.hST = wQ(5);
        }
        return this.hST;
    }
}
