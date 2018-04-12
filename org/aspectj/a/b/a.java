package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hyW;
    String[] hyX;
    Class[] hyY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hyW = clsArr;
        this.hyX = strArr;
        this.hyY = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hyW == null) {
            this.hyW = wp(3);
        }
        return this.hyW;
    }

    public Class[] getExceptionTypes() {
        if (this.hyY == null) {
            this.hyY = wp(5);
        }
        return this.hyY;
    }
}
