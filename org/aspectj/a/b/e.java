package org.aspectj.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class returnType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.returnType = cls2;
    }

    public Class eEy() {
        if (this.returnType == null) {
            this.returnType = Sj(6);
        }
        return this.returnType;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.Sl(eEz()));
        if (hVar.qbV) {
            stringBuffer.append(hVar.N(eEy()));
        }
        if (hVar.qbV) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.k(eEA(), eEB()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, eEu());
        hVar.c(stringBuffer, eEv());
        return stringBuffer.toString();
    }
}
