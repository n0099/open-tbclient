package com.tencent.mm.sdk.a.a;
/* loaded from: classes6.dex */
public final class b {
    public static byte[] a(String str, int i2, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i2);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return com.tencent.mm.a.a.a(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
