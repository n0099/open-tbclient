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

    public Class eAI() {
        if (this.returnType == null) {
            this.returnType = Rl(6);
        }
        return this.returnType;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.Rn(eAJ()));
        if (hVar.pQY) {
            stringBuffer.append(hVar.N(eAI()));
        }
        if (hVar.pQY) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.k(eAK(), eAL()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, eAE());
        hVar.c(stringBuffer, eAF());
        return stringBuffer.toString();
    }
}
