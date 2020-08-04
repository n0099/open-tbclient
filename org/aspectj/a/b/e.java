package org.aspectj.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class returnType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.returnType = cls2;
    }

    public Class dWO() {
        if (this.returnType == null) {
            this.returnType = LG(6);
        }
        return this.returnType;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.LI(dWP()));
        if (hVar.ogw) {
            stringBuffer.append(hVar.N(dWO()));
        }
        if (hVar.ogw) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.k(dWQ(), dWR()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, dWK());
        hVar.c(stringBuffer, dWL());
        return stringBuffer.toString();
    }
}
