package org.aspectj.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class returnType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.returnType = cls2;
    }

    public Class eNk() {
        if (this.returnType == null) {
            this.returnType = TL(6);
        }
        return this.returnType;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.TN(eNl()));
        if (hVar.qpi) {
            stringBuffer.append(hVar.H(eNk()));
        }
        if (hVar.qpi) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.l(eNm(), eNn()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, eNg());
        hVar.c(stringBuffer, eNh());
        return stringBuffer.toString();
    }
}
