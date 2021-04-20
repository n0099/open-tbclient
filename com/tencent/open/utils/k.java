package com.tencent.open.utils;
/* loaded from: classes6.dex */
public final class k implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public long f39627a;

    public k(long j) {
        this.f39627a = j;
    }

    public byte[] a() {
        long j = this.f39627a;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f39627a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof k) && this.f39627a == ((k) obj).b();
    }

    public int hashCode() {
        return (int) this.f39627a;
    }
}
