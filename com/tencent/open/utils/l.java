package com.tencent.open.utils;
/* loaded from: classes7.dex */
public final class l implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public int f39339a;

    public l(byte[] bArr) {
        this(bArr, 0);
    }

    public byte[] a() {
        int i = this.f39339a;
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public int b() {
        return this.f39339a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof l) && this.f39339a == ((l) obj).b();
    }

    public int hashCode() {
        return this.f39339a;
    }

    public l(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & 65280;
        this.f39339a = i2;
        this.f39339a = i2 + (bArr[i] & 255);
    }

    public l(int i) {
        this.f39339a = i;
    }
}
