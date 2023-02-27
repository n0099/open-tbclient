package com.tencent.open.utils;
/* loaded from: classes8.dex */
public final class m implements Cloneable {
    public long a;

    public m(long j) {
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof m) || this.a != ((m) obj).b()) {
            return false;
        }
        return true;
    }

    public byte[] a() {
        long j = this.a;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public long b() {
        return this.a;
    }

    public int hashCode() {
        return (int) this.a;
    }
}
