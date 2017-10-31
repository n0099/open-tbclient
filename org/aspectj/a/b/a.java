package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hxA;
    String[] hxB;
    Class[] hxC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hxA = clsArr;
        this.hxB = strArr;
        this.hxC = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hxA == null) {
            this.hxA = xn(3);
        }
        return this.hxA;
    }

    public Class[] getExceptionTypes() {
        if (this.hxC == null) {
            this.hxC = xn(5);
        }
        return this.hxC;
    }
}
