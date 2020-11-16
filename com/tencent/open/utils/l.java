package com.tencent.open.utils;

import android.support.v4.view.MotionEventCompat;
/* loaded from: classes11.dex */
public final class l implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int f4624a;

    public l(byte[] bArr) {
        this(bArr, 0);
    }

    public l(byte[] bArr, int i) {
        this.f4624a = (bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.f4624a += bArr[i] & 255;
    }

    public l(int i) {
        this.f4624a = i;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof l) && this.f4624a == ((l) obj).b();
    }

    public byte[] a() {
        return new byte[]{(byte) (this.f4624a & 255), (byte) ((this.f4624a & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int b() {
        return this.f4624a;
    }

    public int hashCode() {
        return this.f4624a;
    }
}
