package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hJU;
    String[] hJV;
    Class[] hJW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hJU = clsArr;
        this.hJV = strArr;
        this.hJW = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hJU == null) {
            this.hJU = xP(3);
        }
        return this.hJU;
    }

    public Class[] getExceptionTypes() {
        if (this.hJW == null) {
            this.hJW = xP(5);
        }
        return this.hJW;
    }
}
