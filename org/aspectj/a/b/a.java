package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] inr;

    /* renamed from: int  reason: not valid java name */
    String[] f0int;
    Class[] inu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.inr = clsArr;
        this.f0int = strArr;
        this.inu = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.inr == null) {
            this.inr = zx(3);
        }
        return this.inr;
    }

    public Class[] getExceptionTypes() {
        if (this.inu == null) {
            this.inu = zx(5);
        }
        return this.inu;
    }
}
