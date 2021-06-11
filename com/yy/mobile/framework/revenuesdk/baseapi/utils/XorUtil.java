package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import android.text.TextUtils;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes7.dex */
public class XorUtil {
    public static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = new String(xorEncode(str.getBytes()));
        RLog.debug("XorUtil", "encodeStr:" + str2);
        return str2;
    }

    public static byte[] xorEncode(byte[] bArr) {
        byte[] bytes = "yypayxorsdk123".getBytes();
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ bytes[i2 % bytes.length]);
        }
        return bArr2;
    }
}
