package d.h.c.g;

import d.h.c.a.n;
/* loaded from: classes6.dex */
public final class b {
    public static byte a(long j) {
        n.h((j >> 8) == 0, "out of range: %s", j);
        return (byte) j;
    }

    public static int b(byte b2, byte b3) {
        return c(b2) - c(b3);
    }

    public static int c(byte b2) {
        return b2 & 255;
    }
}
