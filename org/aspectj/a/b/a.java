package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] imt;
    String[] imu;
    Class[] imv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.imt = clsArr;
        this.imu = strArr;
        this.imv = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.imt == null) {
            this.imt = zx(3);
        }
        return this.imt;
    }

    public Class[] getExceptionTypes() {
        if (this.imv == null) {
            this.imv = zx(5);
        }
        return this.imv;
    }
}
