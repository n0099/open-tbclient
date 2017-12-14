package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hMN;
    String[] hMO;
    Class[] hMP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hMN = clsArr;
        this.hMO = strArr;
        this.hMP = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hMN == null) {
            this.hMN = yc(3);
        }
        return this.hMN;
    }

    public Class[] getExceptionTypes() {
        if (this.hMP == null) {
            this.hMP = yc(5);
        }
        return this.hMP;
    }
}
