package com.tencent.open.utils;
/* loaded from: classes10.dex */
public final class n implements Cloneable {
    public int a;

    public n(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof n) || this.a != ((n) obj).b()) {
            return false;
        }
        return true;
    }

    public n(byte[] bArr) {
        this(bArr, 0);
    }

    public n(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & 65280;
        this.a = i2;
        this.a = i2 + (bArr[i] & 255);
    }

    public byte[] a() {
        int i = this.a;
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public int b() {
        return this.a;
    }

    public int hashCode() {
        return this.a;
    }
}
