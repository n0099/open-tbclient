package com.tencent.open.utils;
/* loaded from: classes14.dex */
public final class k implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private long f7998a;

    public k(long j) {
        this.f7998a = j;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof k) && this.f7998a == ((k) obj).b();
    }

    public byte[] a() {
        return new byte[]{(byte) (this.f7998a & 255), (byte) ((this.f7998a & 65280) >> 8), (byte) ((this.f7998a & 16711680) >> 16), (byte) ((this.f7998a & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f7998a;
    }

    public int hashCode() {
        return (int) this.f7998a;
    }
}
