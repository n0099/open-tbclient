package com.heytap.mcssdk.utils;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;
/* loaded from: classes6.dex */
public class CryptoUtil {
    public static final int DEFAULT_RADIX = 16;
    public static final String DES_KEY = "com.nearme.mcs";

    public static String desDecrypt(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return DESUtil.decrypt(str, getDesKey());
            } catch (Exception e2) {
                LogUtil.e("desDecrypt-" + e2.getMessage());
            }
        }
        return "";
    }

    public static String desEncrypt(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return DESUtil.encrypt(str, getDesKey());
            } catch (Exception e2) {
                LogUtil.e("desEncrypt-" + e2.getMessage());
            }
        }
        return "";
    }

    public static String getDesKey() {
        byte[] swapBytes = swapBytes(getUTF8Bytes(DES_KEY));
        return swapBytes != null ? new String(swapBytes, Charset.forName("UTF-8")) : "";
    }

    public static byte[] getUTF8Bytes(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString.toUpperCase(Locale.getDefault()));
        }
        return sb.toString();
    }

    public static byte[] parseHexStr2Byte(String str) {
        if (str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i2 = 0; i2 < str.length() / 2; i2++) {
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            bArr[i2] = (byte) ((Integer.parseInt(str.substring(i3, i4), 16) * 16) + Integer.parseInt(str.substring(i4, i3 + 2), 16));
        }
        return bArr;
    }

    public static byte[] swapBytes(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i2 = 0; i2 < length; i2 += 2) {
            byte b2 = bArr[i2];
            int i3 = i2 + 1;
            bArr[i2] = bArr[i3];
            bArr[i3] = b2;
        }
        return bArr;
    }
}
