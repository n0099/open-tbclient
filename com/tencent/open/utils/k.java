package com.tencent.open.utils;
/* loaded from: classes24.dex */
public final class k implements Cloneable {
    private long a;

    public k(long j) {
        this.a = j;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof k) && this.a == ((k) obj).b();
    }

    public byte[] a() {
        return new byte[]{(byte) (this.a & 255), (byte) ((this.a & 65280) >> 8), (byte) ((this.a & 16711680) >> 16), (byte) ((this.a & 4278190080L) >> 24)};
    }

    public long b() {
        return this.a;
    }

    public int hashCode() {
        return (int) this.a;
    }
}
