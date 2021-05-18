package com.tencent.open.utils;
/* loaded from: classes7.dex */
public final class k implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public long f36569a;

    public k(long j) {
        this.f36569a = j;
    }

    public byte[] a() {
        long j = this.f36569a;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f36569a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof k) && this.f36569a == ((k) obj).b();
    }

    public int hashCode() {
        return (int) this.f36569a;
    }
}
