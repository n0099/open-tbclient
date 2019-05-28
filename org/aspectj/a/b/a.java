package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] kkX;
    String[] kkY;
    Class[] kkZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.kkX = clsArr;
        this.kkY = strArr;
        this.kkZ = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.kkX == null) {
            this.kkX = Ed(3);
        }
        return this.kkX;
    }

    public Class[] getExceptionTypes() {
        if (this.kkZ == null) {
            this.kkZ = Ed(5);
        }
        return this.kkZ;
    }
}
