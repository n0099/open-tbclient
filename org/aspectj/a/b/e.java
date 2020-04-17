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

    public Class dGC() {
        if (this.returnType == null) {
            this.returnType = Js(6);
        }
        return this.returnType;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.Ju(dGD()));
        if (hVar.nfI) {
            stringBuffer.append(hVar.N(dGC()));
        }
        if (hVar.nfI) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.k(dGE(), dGF()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, dGy());
        hVar.c(stringBuffer, dGz());
        return stringBuffer.toString();
    }
}
