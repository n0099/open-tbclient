package com.xiaomi.push.mpcd;
/* loaded from: classes3.dex */
public class e {
    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] a = com.xiaomi.channel.commonutils.string.a.a(str);
        try {
            a(a);
            return com.xiaomi.channel.commonutils.android.c.a(a, bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] a = com.xiaomi.channel.commonutils.string.a.a(str);
        try {
            a(a);
            return com.xiaomi.channel.commonutils.android.c.b(a, bArr);
        } catch (Exception e) {
            return null;
        }
    }
}
