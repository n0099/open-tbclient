package org.aspectj.a.b;

import com.baidu.android.imsdk.utils.HanziToPinyin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class returnType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.returnType = cls2;
    }

    public Class dLM() {
        if (this.returnType == null) {
            this.returnType = NP(6);
        }
        return this.returnType;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.NR(dLN()));
        if (hVar.nJp) {
            stringBuffer.append(hVar.O(dLM()));
        }
        if (hVar.nJp) {
            stringBuffer.append(HanziToPinyin.Token.SEPARATOR);
        }
        stringBuffer.append(hVar.k(dLO(), dLP()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, dLI());
        hVar.c(stringBuffer, dLJ());
        return stringBuffer.toString();
    }
}
