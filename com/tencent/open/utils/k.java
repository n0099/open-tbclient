package com.tencent.open.utils;
/* loaded from: classes7.dex */
public final class k implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public long f40177a;

    public k(long j) {
        this.f40177a = j;
    }

    public byte[] a() {
        long j = this.f40177a;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f40177a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof k) && this.f40177a == ((k) obj).b();
    }

    public int hashCode() {
        return (int) this.f40177a;
    }
}
