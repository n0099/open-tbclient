package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] iyY;
    String[] iyZ;
    Class[] iza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.iyY = clsArr;
        this.iyZ = strArr;
        this.iza = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.iyY == null) {
            this.iyY = zi(3);
        }
        return this.iyY;
    }

    public Class[] getExceptionTypes() {
        if (this.iza == null) {
            this.iza = zi(5);
        }
        return this.iza;
    }
}
