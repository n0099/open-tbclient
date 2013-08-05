package com.tencent.mm.sdk.channel;

import com.tencent.mm.algorithm.b;
/* loaded from: classes.dex */
public class MMessageUtil {
    private MMessageUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(553844737);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return b.a(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
