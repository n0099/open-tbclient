package com.xiaomi.push;
/* loaded from: classes9.dex */
public final class f {
    public static final int a = a(1, 3);
    public static final int b = a(1, 4);
    public static final int c = a(2, 0);
    public static final int d = a(3, 2);

    public static int a(int i) {
        return i & 7;
    }

    public static int a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static int b(int i) {
        return i >>> 3;
    }
}
