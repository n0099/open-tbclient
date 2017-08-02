package com.google.protobuf.micro;
/* loaded from: classes2.dex */
public final class a {
    public static final a gRe = new a(new byte[0]);
    private final byte[] b;
    private volatile int c = 0;

    private a(byte[] bArr) {
        this.b = bArr;
    }

    public static a J(byte[] bArr) {
        return k(bArr, 0, bArr.length);
    }

    public static a k(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new a(bArr2);
    }

    public int a() {
        return this.b.length;
    }

    public byte[] b() {
        int length = this.b.length;
        byte[] bArr = new byte[length];
        System.arraycopy(this.b, 0, bArr, 0, length);
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            int length = this.b.length;
            if (length != aVar.b.length) {
                return false;
            }
            byte[] bArr = this.b;
            byte[] bArr2 = aVar.b;
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
        int i = this.c;
        if (i == 0) {
            byte[] bArr = this.b;
            int length = this.b.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                i2++;
                i = bArr[i2] + (i * 31);
            }
            if (i == 0) {
                i = 1;
            }
            this.c = i;
        }
        return i;
    }
}
