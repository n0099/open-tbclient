package com.google.android.exoplayer2.util;
/* loaded from: classes5.dex */
public final class m {
    private int bitOffset;
    private int byteOffset;
    private byte[] data;
    private int mlc;

    public m(byte[] bArr, int i, int i2) {
        D(bArr, i, i2);
    }

    public void D(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.byteOffset = i;
        this.mlc = i2;
        this.bitOffset = 0;
        dtZ();
    }

    public void dyd() {
        int i = this.bitOffset + 1;
        this.bitOffset = i;
        if (i == 8) {
            this.bitOffset = 0;
            this.byteOffset = (LS(this.byteOffset + 1) ? 2 : 1) + this.byteOffset;
        }
        dtZ();
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
                dtZ();
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
        while (i8 <= i7 && i7 < this.mlc) {
            if (LS(i8)) {
                i7++;
                i8 += 2;
            }
            i8++;
        }
        return i7 < this.mlc || (i7 == this.mlc && i5 == 0);
    }

    public boolean dtY() {
        boolean z = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        dyd();
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
        dtZ();
        return i3;
    }

    public boolean dyv() {
        int i = this.byteOffset;
        int i2 = this.bitOffset;
        int i3 = 0;
        while (this.byteOffset < this.mlc && !dtY()) {
            i3++;
        }
        boolean z = this.byteOffset == this.mlc;
        this.byteOffset = i;
        this.bitOffset = i2;
        return !z && LR((i3 * 2) + 1);
    }

    public int dyw() {
        return dyy();
    }

    public int dyx() {
        int dyy = dyy();
        return (dyy % 2 == 0 ? -1 : 1) * ((dyy + 1) / 2);
    }

    private int dyy() {
        int i = 0;
        while (!dtY()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? readBits(i) : 0);
    }

    private boolean LS(int i) {
        return 2 <= i && i < this.mlc && this.data[i] == 3 && this.data[i + (-2)] == 0 && this.data[i + (-1)] == 0;
    }

    private void dtZ() {
        a.checkState(this.byteOffset >= 0 && (this.byteOffset < this.mlc || (this.byteOffset == this.mlc && this.bitOffset == 0)));
    }
}
