package com.xiaomi.push;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f38113a = new a(new byte[0]);

    /* renamed from: a  reason: collision with other field name */
    public volatile int f98a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f99a;

    public a(byte[] bArr) {
        this.f99a = bArr;
    }

    public static a a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static a a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new a(bArr2);
    }

    public int a() {
        return this.f99a.length;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m125a() {
        byte[] bArr = this.f99a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            byte[] bArr = this.f99a;
            int length = bArr.length;
            byte[] bArr2 = ((a) obj).f99a;
            if (length != bArr2.length) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f98a;
        if (i2 == 0) {
            byte[] bArr = this.f99a;
            int length = bArr.length;
            for (byte b2 : bArr) {
                length = (length * 31) + b2;
            }
            i2 = length == 0 ? 1 : length;
            this.f98a = i2;
        }
        return i2;
    }
}
