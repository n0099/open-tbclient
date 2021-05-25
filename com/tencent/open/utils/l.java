package com.tencent.open.utils;
/* loaded from: classes7.dex */
public final class l implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public int f36499a;

    public l(byte[] bArr) {
        this(bArr, 0);
    }

    public byte[] a() {
        int i2 = this.f36499a;
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 & 65280) >> 8)};
    }

    public int b() {
        return this.f36499a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof l) && this.f36499a == ((l) obj).b();
    }

    public int hashCode() {
        return this.f36499a;
    }

    public l(byte[] bArr, int i2) {
        int i3 = (bArr[i2 + 1] << 8) & 65280;
        this.f36499a = i3;
        this.f36499a = i3 + (bArr[i2] & 255);
    }

    public l(int i2) {
        this.f36499a = i2;
    }
}
