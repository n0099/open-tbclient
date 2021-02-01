package com.tencent.open.utils;
/* loaded from: classes15.dex */
public final class k implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private long f13450a;

    public k(long j) {
        this.f13450a = j;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof k) && this.f13450a == ((k) obj).b();
    }

    public byte[] a() {
        return new byte[]{(byte) (this.f13450a & 255), (byte) ((this.f13450a & 65280) >> 8), (byte) ((this.f13450a & 16711680) >> 16), (byte) ((this.f13450a & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f13450a;
    }

    public int hashCode() {
        return (int) this.f13450a;
    }
}
