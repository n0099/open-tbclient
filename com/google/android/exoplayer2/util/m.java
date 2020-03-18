package com.google.android.exoplayer2.util;
/* loaded from: classes6.dex */
public final class m {
    private int bitOffset;
    private int byteOffset;
    private byte[] data;
    private int mnG;

    public m(byte[] bArr, int i, int i2) {
        H(bArr, i, i2);
    }

    public void H(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.byteOffset = i;
        this.mnG = i2;
        this.bitOffset = 0;
        dvM();
    }

    public void dzP() {
        int i = this.bitOffset + 1;
        this.bitOffset = i;
        if (i == 8) {
            this.bitOffset = 0;
            this.byteOffset = (Md(this.byteOffset + 1) ? 2 : 1) + this.byteOffset;
        }
        dvM();
    }

    public void Ka(int i) {
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
                if (Md(i2)) {
                    this.byteOffset++;
                    i2 += 2;
                }
            } else {
                dvM();
                return;
            }
        }
    }

    public boolean Mc(int i) {
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
        while (i8 <= i7 && i7 < this.mnG) {
            if (Md(i8)) {
                i7++;
                i8 += 2;
            }
            i8++;
        }
        return i7 < this.mnG || (i7 == this.mnG && i5 == 0);
    }

    public boolean dvL() {
        boolean z = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        dzP();
        return z;
    }

    public int readBits(int i) {
        this.bitOffset += i;
        int i2 = 0;
        while (this.bitOffset > 8) {
            this.bitOffset -= 8;
            i2 |= (this.data[this.byteOffset] & 255) << this.bitOffset;
            this.byteOffset = (Md(this.byteOffset + 1) ? 2 : 1) + this.byteOffset;
        }
        int i3 = (i2 | ((this.data[this.byteOffset] & 255) >> (8 - this.bitOffset))) & ((-1) >>> (32 - i));
        if (this.bitOffset == 8) {
            this.bitOffset = 0;
            this.byteOffset += Md(this.byteOffset + 1) ? 2 : 1;
        }
        dvM();
        return i3;
    }

    public boolean dAh() {
        int i = this.byteOffset;
        int i2 = this.bitOffset;
        int i3 = 0;
        while (this.byteOffset < this.mnG && !dvL()) {
            i3++;
        }
        boolean z = this.byteOffset == this.mnG;
        this.byteOffset = i;
        this.bitOffset = i2;
        return !z && Mc((i3 * 2) + 1);
    }

    public int dAi() {
        return dAk();
    }

    public int dAj() {
        int dAk = dAk();
        return (dAk % 2 == 0 ? -1 : 1) * ((dAk + 1) / 2);
    }

    private int dAk() {
        int i = 0;
        while (!dvL()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? readBits(i) : 0);
    }

    private boolean Md(int i) {
        return 2 <= i && i < this.mnG && this.data[i] == 3 && this.data[i + (-2)] == 0 && this.data[i + (-1)] == 0;
    }

    private void dvM() {
        a.checkState(this.byteOffset >= 0 && (this.byteOffset < this.mnG || (this.byteOffset == this.mnG && this.bitOffset == 0)));
    }
}
