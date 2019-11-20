package org.aspectj.a.b;

import com.baidu.android.imsdk.internal.DefaultConfig;
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

    public Class cNn() {
        if (this.returnType == null) {
            this.returnType = Dn(6);
        }
        return this.returnType;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.Dp(cNo()));
        if (hVar.kwk) {
            stringBuffer.append(hVar.E(cNn()));
        }
        if (hVar.kwk) {
            stringBuffer.append(HanziToPinyin.Token.SEPARATOR);
        }
        stringBuffer.append(hVar.h(cNp(), cNq()));
        stringBuffer.append(DefaultConfig.TOKEN_SEPARATOR);
        stringBuffer.append(getName());
        hVar.b(stringBuffer, cNj());
        hVar.c(stringBuffer, cNk());
        return stringBuffer.toString();
    }
}
