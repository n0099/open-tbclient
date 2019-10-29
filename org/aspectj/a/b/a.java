package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] kwG;
    String[] kwH;
    Class[] kwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.kwG = clsArr;
        this.kwH = strArr;
        this.kwI = clsArr2;
    }

    public Class[] cNl() {
        if (this.kwG == null) {
            this.kwG = Dp(3);
        }
        return this.kwG;
    }

    public Class[] cNm() {
        if (this.kwI == null) {
            this.kwI = Dp(5);
        }
        return this.kwI;
    }
}
