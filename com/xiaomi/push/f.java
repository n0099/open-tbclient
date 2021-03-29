package com.xiaomi.push;
/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f40487a = a(1, 3);

    /* renamed from: b  reason: collision with root package name */
    public static final int f40488b = a(1, 4);

    /* renamed from: c  reason: collision with root package name */
    public static final int f40489c = a(2, 0);

    /* renamed from: d  reason: collision with root package name */
    public static final int f40490d = a(3, 2);

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
