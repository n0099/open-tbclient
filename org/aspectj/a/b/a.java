package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] ilU;
    String[] ilV;
    Class[] ilW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.ilU = clsArr;
        this.ilV = strArr;
        this.ilW = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.ilU == null) {
            this.ilU = zx(3);
        }
        return this.ilU;
    }

    public Class[] getExceptionTypes() {
        if (this.ilW == null) {
            this.ilW = zx(5);
        }
        return this.ilW;
    }
}
