package com.google.zxing;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f2838a;
    private final int b;

    public abstract byte[] a();

    public abstract byte[] a(int i, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public c(int i, int i2) {
        this.f2838a = i;
        this.b = i2;
    }

    public final int b() {
        return this.f2838a;
    }

    public final int c() {
        return this.b;
    }

    public final String toString() {
        char c;
        StringBuilder sb = new StringBuilder(this.b * (this.f2838a + 1));
        byte[] bArr = new byte[this.f2838a];
        for (int i = 0; i < this.b; i++) {
            bArr = a(i, bArr);
            for (int i2 = 0; i2 < this.f2838a; i2++) {
                int i3 = bArr[i2] & 255;
                if (i3 < 64) {
                    c = '#';
                } else if (i3 < 128) {
                    c = '+';
                } else if (i3 < 192) {
                    c = '.';
                } else {
                    c = ' ';
                }
                sb.append(c);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
