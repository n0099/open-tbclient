package com.google.android.exoplayer2.util;
/* loaded from: classes5.dex */
public final class m {
    private int bitOffset;
    private int byteOffset;
    private byte[] data;
    private int mlh;

    public m(byte[] bArr, int i, int i2) {
        D(bArr, i, i2);
    }

    public void D(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.byteOffset = i;
        this.mlh = i2;
        this.bitOffset = 0;
        dub();
    }

    public void dyf() {
        int i = this.bitOffset + 1;
        this.bitOffset = i;
        if (i == 8) {
            this.bitOffset = 0;
            this.byteOffset = (LS(this.byteOffset + 1) ? 2 : 1) + this.byteOffset;
        }
        dub();
    }

    public void JP(int i) {
        int i2 = this.byteOffset;
        int i3 = i / 8;
        this.byteOffset += i3;
        this.bitOffset = (i - (i3 * 8)) + this.bitOffset;
        if (this.bitOffset > 7) {
            this.byteOffset++;
            this.bitOffset -= 8;
        }
        while (true) {
            i2++;
            if (i2 <= this.byteOffset) {
                if (LS(i2)) {
                    this.byteOffset++;
                    i2 += 2;
                }
            } else {
                dub();
                return;
            }
        }
    }

    public boolean LR(int i) {
        int i2 = this.byteOffset;
        int i3 = i / 8;
        int i4 = this.byteOffset + i3;
        int i5 = (this.bitOffset + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        int i6 = i2 + 1;
        int i7 = i4;
        int i8 = i6;
        while (i8 <= i7 && i7 < this.mlh) {
            if (LS(i8)) {
                i7++;
                i8 += 2;
            }
            i8++;
        }
        return i7 < this.mlh || (i7 == this.mlh && i5 == 0);
    }

    public boolean dua() {
        boolean z = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        dyf();
        return z;
    }

    public int readBits(int i) {
        this.bitOffset += i;
        int i2 = 0;
        while (this.bitOffset > 8) {
            this.bitOffset -= 8;
            i2 |= (this.data[this.byteOffset] & 255) << this.bitOffset;
            this.byteOffset = (LS(this.byteOffset + 1) ? 2 : 1) + this.byteOffset;
        }
        int i3 = (i2 | ((this.data[this.byteOffset] & 255) >> (8 - this.bitOffset))) & ((-1) >>> (32 - i));
        if (this.bitOffset == 8) {
            this.bitOffset = 0;
            this.byteOffset += LS(this.byteOffset + 1) ? 2 : 1;
        }
        dub();
        return i3;
    }

    public boolean dyx() {
        int i = this.byteOffset;
        int i2 = this.bitOffset;
        int i3 = 0;
        while (this.byteOffset < this.mlh && !dua()) {
            i3++;
        }
        boolean z = this.byteOffset == this.mlh;
        this.byteOffset = i;
        this.bitOffset = i2;
        return !z && LR((i3 * 2) + 1);
    }

    public int dyy() {
        return dyA();
    }

    public int dyz() {
        int dyA = dyA();
        return (dyA % 2 == 0 ? -1 : 1) * ((dyA + 1) / 2);
    }

    private int dyA() {
        int i = 0;
        while (!dua()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? readBits(i) : 0);
    }

    private boolean LS(int i) {
        return 2 <= i && i < this.mlh && this.data[i] == 3 && this.data[i + (-2)] == 0 && this.data[i + (-1)] == 0;
    }

    private void dub() {
        a.checkState(this.byteOffset >= 0 && (this.byteOffset < this.mlh || (this.byteOffset == this.mlh && this.bitOffset == 0)));
    }
}
