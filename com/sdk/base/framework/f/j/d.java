package com.sdk.base.framework.f.j;

import com.baidu.android.imsdk.internal.Constants;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
/* loaded from: classes9.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static char[] f4278a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
        if (r5 == (-1)) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        r4.write(((r6 & 15) << 4) | ((r5 & 60) >>> 2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
        r0 = r1 + 1;
        r1 = r2[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        if (r1 == 61) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
        r1 = com.sdk.base.framework.f.j.d.b[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
        if (r0 >= r3) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
        if (r1 == (-1)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
        if (r1 == (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        r4.write(r1 | ((r5 & 3) << 6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007d, code lost:
        r1 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        int i;
        byte b2;
        int i2;
        byte b3;
        byte[] bytes = str.getBytes(Charset.defaultCharset());
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i3 = 0;
        loop0: while (i3 < length) {
            while (true) {
                i = i3 + 1;
                b2 = b[bytes[i3]];
                if (i >= length || b2 != -1) {
                    break;
                }
                i3 = i;
            }
            if (b2 == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                b3 = b[bytes[i]];
                if (i2 >= length || b3 != -1) {
                    break;
                }
                i = i2;
            }
            if (b3 == -1) {
                break;
            }
            byteArrayOutputStream.write((b2 << 2) | ((b3 & 48) >>> 4));
            while (true) {
                int i4 = i2 + 1;
                byte b4 = bytes[i2];
                if (b4 == 61) {
                    break loop0;
                }
                byte b5 = b[b4];
                if (i4 >= length || b5 != -1) {
                    break;
                }
                i2 = i4;
            }
        }
        return new String(byteArrayOutputStream.toByteArray(), Charset.defaultCharset());
    }
}
