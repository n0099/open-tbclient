package com.xiaomi.push;
/* loaded from: classes7.dex */
public abstract class jl {
    public int a() {
        return 0;
    }

    public abstract int a(byte[] bArr, int i2, int i3);

    public void a(int i2) {
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract void m518a(byte[] bArr, int i2, int i3);

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m519a() {
        return null;
    }

    public int b() {
        return -1;
    }

    public int b(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i3) {
            int a2 = a(bArr, i2 + i4, i3 - i4);
            if (a2 <= 0) {
                throw new jm("Cannot read. Remote side has closed. Tried to read " + i3 + " bytes, but only got " + i4 + " bytes.");
            }
            i4 += a2;
        }
        return i4;
    }
}
