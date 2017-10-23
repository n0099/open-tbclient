package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hnr;
    String[] hns;
    Class[] hnt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hnr = clsArr;
        this.hns = strArr;
        this.hnt = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hnr == null) {
            this.hnr = wQ(3);
        }
        return this.hnr;
    }

    public Class[] getExceptionTypes() {
        if (this.hnt == null) {
            this.hnt = wQ(5);
        }
        return this.hnt;
    }
}
