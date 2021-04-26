package okio;

import java.nio.charset.Charset;
import kotlin.UShort;
/* loaded from: classes7.dex */
public final class Util {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static boolean arrayRangeEquals(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (bArr[i5 + i2] != bArr2[i5 + i3]) {
                return false;
            }
        }
        return true;
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static int reverseBytesInt(int i2) {
        return ((i2 & 255) << 24) | (((-16777216) & i2) >>> 24) | ((16711680 & i2) >>> 8) | ((65280 & i2) << 8);
    }

    public static long reverseBytesLong(long j) {
        return ((j & 255) << 56) | (((-72057594037927936L) & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((65280 & j) << 40);
    }

    public static short reverseBytesShort(short s) {
        int i2 = s & UShort.MAX_VALUE;
        return (short) (((i2 & 255) << 8) | ((65280 & i2) >>> 8));
    }

    public static void sneakyRethrow(Throwable th) {
        sneakyThrow2(th);
    }

    public static <T extends Throwable> void sneakyThrow2(Throwable th) throws Throwable {
        throw th;
    }
}
