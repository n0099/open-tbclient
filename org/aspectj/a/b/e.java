package org.aspectj.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class returnType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.returnType = cls2;
    }

    public Class dOH() {
        if (this.returnType == null) {
            this.returnType = Kf(6);
        }
        return this.returnType;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.Kh(dOI()));
        if (hVar.nBW) {
            stringBuffer.append(hVar.N(dOH()));
        }
        if (hVar.nBW) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.k(dOJ(), dOK()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, dOD());
        hVar.c(stringBuffer, dOE());
        return stringBuffer.toString();
    }
}
