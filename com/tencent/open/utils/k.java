package com.tencent.open.utils;
/* loaded from: classes6.dex */
public final class k implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private long f4623a;

    public k(long j) {
        this.f4623a = j;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof k) && this.f4623a == ((k) obj).b();
    }

    public byte[] a() {
        return new byte[]{(byte) (this.f4623a & 255), (byte) ((this.f4623a & 65280) >> 8), (byte) ((this.f4623a & 16711680) >> 16), (byte) ((this.f4623a & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f4623a;
    }

    public int hashCode() {
        return (int) this.f4623a;
    }
}
