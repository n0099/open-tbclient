package com.yy.mediaframework.utils;

import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class ByteUtil {
    private static final String TAG = "ByteUtil";

    public static String byte2hex(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            YMFLog.info(null, "[Util    ]", "invalid buffer");
            return "";
        }
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str = str + " " + hexString;
        }
        return str;
    }

    public static String FloatBuffer2String(FloatBuffer floatBuffer) {
        if (floatBuffer == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("buffer to string");
        for (int i = 0; i < floatBuffer.capacity(); i++) {
            sb.append(floatBuffer.get(i) + "::");
        }
        floatBuffer.rewind();
        return sb.toString();
    }

    public static String convertFloatBuffer2String(FloatBuffer floatBuffer) {
        if (floatBuffer == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("Buffer::");
        for (int i = 0; i < floatBuffer.capacity(); i++) {
            sb.append(floatBuffer.get(i));
            sb.append("  ");
        }
        floatBuffer.rewind();
        return sb.toString();
    }
}
