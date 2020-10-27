package com.xiaomi.push;
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f4783a = new a(new byte[0]);

    /* renamed from: a  reason: collision with other field name */
    private volatile int f87a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f88a;

    private a(byte[] bArr) {
        this.f88a = bArr;
    }

    public static a a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static a a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new a(bArr2);
    }

    public int a() {
        return this.f88a.length;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m123a() {
        int length = this.f88a.length;
        byte[] bArr = new byte[length];
        System.arraycopy(this.f88a, 0, bArr, 0, length);
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            int length = this.f88a.length;
            if (length != aVar.f88a.length) {
                return false;
            }
            byte[] bArr = this.f88a;
            byte[] bArr2 = aVar.f88a;
            for (int i = 0; i < length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f87a;
        if (i == 0) {
            byte[] bArr = this.f88a;
            int length = this.f88a.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                i2++;
                i = bArr[i2] + (i * 31);
            }
            if (i == 0) {
                i = 1;
            }
            this.f87a = i;
        }
        return i;
    }
}
