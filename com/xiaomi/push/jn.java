package com.xiaomi.push;
/* loaded from: classes10.dex */
public abstract class jn {
    public int a() {
        return 0;
    }

    public abstract int a(byte[] bArr, int i, int i2);

    public void a(int i) {
    }

    /* renamed from: a */
    public abstract void mo719a(byte[] bArr, int i, int i2);

    /* renamed from: a */
    public byte[] mo720a() {
        return null;
    }

    public int b() {
        return -1;
    }

    public int b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int a = a(bArr, i + i3, i2 - i3);
            if (a <= 0) {
                throw new jo("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes.");
            }
            i3 += a;
        }
        return i3;
    }
}
