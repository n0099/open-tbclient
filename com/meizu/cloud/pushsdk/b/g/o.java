package com.meizu.cloud.pushsdk.b.g;

import java.nio.charset.Charset;
/* loaded from: classes10.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f75009a = Charset.forName("UTF-8");

    public static void a(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)));
        }
    }

    public static void a(Throwable th) {
        b(th);
    }

    public static boolean a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (bArr[i5 + i2] != bArr2[i5 + i3]) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Throwable> void b(Throwable th) throws Throwable {
        throw th;
    }
}
