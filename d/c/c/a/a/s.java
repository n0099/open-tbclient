package d.c.c.a.a;

import java.nio.charset.Charset;
import kotlin.UShort;
/* loaded from: classes4.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f65167a = Charset.forName("UTF-8");

    public static int a(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static short b(short s) {
        int i = s & UShort.MAX_VALUE;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    public static void c(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static void d(Throwable th) {
        f(th);
        throw null;
    }

    public static boolean e(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Throwable> void f(Throwable th) throws Throwable {
        throw th;
    }
}
