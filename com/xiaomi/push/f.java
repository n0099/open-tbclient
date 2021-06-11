package com.xiaomi.push;
/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f41246a = a(1, 3);

    /* renamed from: b  reason: collision with root package name */
    public static final int f41247b = a(1, 4);

    /* renamed from: c  reason: collision with root package name */
    public static final int f41248c = a(2, 0);

    /* renamed from: d  reason: collision with root package name */
    public static final int f41249d = a(3, 2);

    public static int a(int i2) {
        return i2 & 7;
    }

    public static int a(int i2, int i3) {
        return (i2 << 3) | i3;
    }

    public static int b(int i2) {
        return i2 >>> 3;
    }
}
