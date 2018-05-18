package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hzX;
    String[] hzY;
    Class[] hzZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hzX = clsArr;
        this.hzY = strArr;
        this.hzZ = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hzX == null) {
            this.hzX = wn(3);
        }
        return this.hzX;
    }

    public Class[] getExceptionTypes() {
        if (this.hzZ == null) {
            this.hzZ = wn(5);
        }
        return this.hzZ;
    }
}
