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

    public Class eqK() {
        if (this.returnType == null) {
            this.returnType = Pu(6);
        }
        return this.returnType;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.Pw(eqL()));
        if (hVar.oZD) {
            stringBuffer.append(hVar.N(eqK()));
        }
        if (hVar.oZD) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.k(eqM(), eqN()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, eqG());
        hVar.c(stringBuffer, eqH());
        return stringBuffer.toString();
    }
}
