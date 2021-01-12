package com.xiaomi.push;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f13846a = new a(new byte[0]);

    /* renamed from: a  reason: collision with other field name */
    private volatile int f168a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f169a;

    private a(byte[] bArr) {
        this.f169a = bArr;
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
        return this.f169a.length;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m149a() {
        int length = this.f169a.length;
        byte[] bArr = new byte[length];
        System.arraycopy(this.f169a, 0, bArr, 0, length);
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            int length = this.f169a.length;
            if (length != aVar.f169a.length) {
                return false;
            }
            byte[] bArr = this.f169a;
            byte[] bArr2 = aVar.f169a;
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
        int i = this.f168a;
        if (i == 0) {
            byte[] bArr = this.f169a;
            int length = this.f169a.length;
            i = length;
            for (int i2 = 0; i2 < length; i2++) {
                i = (i * 31) + bArr[i2];
            }
            if (i == 0) {
                i = 1;
            }
            this.f168a = i;
        }
        return i;
    }
}
