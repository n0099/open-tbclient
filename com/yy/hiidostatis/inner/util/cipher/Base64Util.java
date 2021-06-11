package com.yy.hiidostatis.inner.util.cipher;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
/* loaded from: classes7.dex */
public class Base64Util {
    public static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    public static int decode(char c2) {
        int i2;
        if (c2 < 'A' || c2 > 'Z') {
            if (c2 >= 'a' && c2 <= 'z') {
                i2 = c2 - 'a';
            } else if (c2 < '0' || c2 > '9') {
                if (c2 != '+') {
                    if (c2 != '/') {
                        if (c2 == '=') {
                            return 0;
                        }
                        throw new RuntimeException("unexpected code: " + c2);
                    }
                    return 63;
                }
                return 62;
            } else {
                i2 = (c2 - '0') + 26;
            }
            return i2 + 26;
        }
        return c2 - 'A';
    }

    public static String encode(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i2 = length - 3;
        int i3 = 0;
        loop0: while (true) {
            int i4 = 0;
            while (i3 <= i2) {
                int i5 = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8) | (bArr[i3 + 2] & 255);
                stringBuffer.append(legalChars[(i5 >> 18) & 63]);
                stringBuffer.append(legalChars[(i5 >> 12) & 63]);
                stringBuffer.append(legalChars[(i5 >> 6) & 63]);
                stringBuffer.append(legalChars[i5 & 63]);
                i3 += 3;
                int i6 = i4 + 1;
                if (i4 >= 14) {
                    break;
                }
                i4 = i6;
            }
        }
        int i7 = 0 + length;
        if (i3 == i7 - 2) {
            int i8 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16);
            stringBuffer.append(legalChars[(i8 >> 18) & 63]);
            stringBuffer.append(legalChars[(i8 >> 12) & 63]);
            stringBuffer.append(legalChars[(i8 >> 6) & 63]);
            stringBuffer.append("=");
        } else if (i3 == i7 - 1) {
            int i9 = (bArr[i3] & 255) << 16;
            stringBuffer.append(legalChars[(i9 >> 18) & 63]);
            stringBuffer.append(legalChars[(i9 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString();
    }

    public static byte[] decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            decode(str, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                PrintStream printStream = System.err;
                printStream.println("Error while decoding BASE64: " + e2.toString());
            }
            return byteArray;
        } catch (IOException unused) {
            throw new RuntimeException();
        }
    }

    public static void decode(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 < length && str.charAt(i2) <= ' ') {
                i2++;
            } else if (i2 == length) {
                return;
            } else {
                int i3 = i2 + 2;
                int i4 = i2 + 3;
                int decode = (decode(str.charAt(i2)) << 18) + (decode(str.charAt(i2 + 1)) << 12) + (decode(str.charAt(i3)) << 6) + decode(str.charAt(i4));
                outputStream.write((decode >> 16) & 255);
                if (str.charAt(i3) == '=') {
                    return;
                }
                outputStream.write((decode >> 8) & 255);
                if (str.charAt(i4) == '=') {
                    return;
                }
                outputStream.write(decode & 255);
                i2 += 4;
            }
        }
    }
}
