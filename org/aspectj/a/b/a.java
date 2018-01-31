package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] inM;
    String[] inN;
    Class[] inO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.inM = clsArr;
        this.inN = strArr;
        this.inO = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.inM == null) {
            this.inM = zx(3);
        }
        return this.inM;
    }

    public Class[] getExceptionTypes() {
        if (this.inO == null) {
            this.inO = zx(5);
        }
        return this.inO;
    }
}
