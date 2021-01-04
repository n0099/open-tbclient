package com.heytap.mcssdk.utils;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;
/* loaded from: classes5.dex */
public class CryptoUtil {
    private static final int DEFAULT_RADIX = 16;
    public static final String DES_KEY = "com.nearme.mcs";

    public static String desDecrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return DESUtil.decrypt(str, getDesKey());
        } catch (Exception e) {
            LogUtil.e("desDecrypt-" + e.getMessage());
            return "";
        }
    }

    public static String desEncrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return DESUtil.encrypt(str, getDesKey());
        } catch (Exception e) {
            LogUtil.e("desEncrypt-" + e.getMessage());
            return "";
        }
    }

    private static String getDesKey() {
        byte[] swapBytes = swapBytes(getUTF8Bytes(DES_KEY));
        return swapBytes != null ? new String(swapBytes, Charset.forName("UTF-8")) : "";
    }

    public static byte[] getUTF8Bytes(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
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
        for (int i = 0; i < str.length() / 2; i++) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
        }
        return bArr;
    }

    public static byte[] swapBytes(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i = 0; i < length; i += 2) {
            byte b2 = bArr[i];
            bArr[i] = bArr[i + 1];
            bArr[i + 1] = b2;
        }
        return bArr;
    }
}
