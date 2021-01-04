package org.aspectj.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class returnType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.returnType = cls2;
    }

    public Class eMG() {
        if (this.returnType == null) {
            this.returnType = Tv(6);
        }
        return this.returnType;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.Tx(eMH()));
        if (hVar.qnA) {
            stringBuffer.append(hVar.H(eMG()));
        }
        if (hVar.qnA) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.l(eMI(), eMJ()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, eMC());
        hVar.c(stringBuffer, eMD());
        return stringBuffer.toString();
    }
}
