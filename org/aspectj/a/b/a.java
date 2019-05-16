package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] kkW;
    String[] kkX;
    Class[] kkY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.kkW = clsArr;
        this.kkX = strArr;
        this.kkY = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.kkW == null) {
            this.kkW = Ed(3);
        }
        return this.kkW;
    }

    public Class[] getExceptionTypes() {
        if (this.kkY == null) {
            this.kkY = Ed(5);
        }
        return this.kkY;
    }
}
