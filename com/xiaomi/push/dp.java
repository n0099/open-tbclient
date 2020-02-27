package com.xiaomi.push;
/* loaded from: classes8.dex */
public class dp {
    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] a = av.a(str);
        try {
            a(a);
            return h.a(a, bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] a = av.a(str);
        try {
            a(a);
            return h.b(a, bArr);
        } catch (Exception e) {
            return null;
        }
    }
}
