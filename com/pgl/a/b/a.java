package com.pgl.a.b;
/* loaded from: classes4.dex */
public class a {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] charArray = "0123456789abcdef".toCharArray();
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = charArray[i2 >>> 4];
            cArr[(i * 2) + 1] = charArray[i2 & 15];
        }
        return new String(cArr);
    }
}
