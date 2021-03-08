package com.tencent.open.utils;

import androidx.core.view.MotionEventCompat;
/* loaded from: classes14.dex */
public final class l implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int f7999a;

    public l(byte[] bArr) {
        this(bArr, 0);
    }

    public l(byte[] bArr, int i) {
        this.f7999a = (bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.f7999a += bArr[i] & 255;
    }

    public l(int i) {
        this.f7999a = i;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof l) && this.f7999a == ((l) obj).b();
    }

    public byte[] a() {
        return new byte[]{(byte) (this.f7999a & 255), (byte) ((this.f7999a & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int b() {
        return this.f7999a;
    }

    public int hashCode() {
        return this.f7999a;
    }
}
