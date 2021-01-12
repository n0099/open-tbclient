package com.tencent.open.utils;
/* loaded from: classes4.dex */
public final class k implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private long f13448a;

    public k(long j) {
        this.f13448a = j;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof k) && this.f13448a == ((k) obj).b();
    }

    public byte[] a() {
        return new byte[]{(byte) (this.f13448a & 255), (byte) ((this.f13448a & 65280) >> 8), (byte) ((this.f13448a & 16711680) >> 16), (byte) ((this.f13448a & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f13448a;
    }

    public int hashCode() {
        return (int) this.f13448a;
    }
}
