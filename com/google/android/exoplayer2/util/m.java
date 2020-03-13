package com.google.android.exoplayer2.util;
/* loaded from: classes6.dex */
public final class m {
    private int bitOffset;
    private int byteOffset;
    private byte[] data;
    private int mma;

    public m(byte[] bArr, int i, int i2) {
        H(bArr, i, i2);
    }

    public void H(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.byteOffset = i;
        this.mma = i2;
        this.bitOffset = 0;
        dvp();
    }

    public void dzs() {
        int i = this.bitOffset + 1;
        this.bitOffset = i;
        if (i == 8) {
            this.bitOffset = 0;
            this.byteOffset = (LX(this.byteOffset + 1) ? 2 : 1) + this.byteOffset;
        }
        dvp();
    }

    public void JU(int i) {
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
                if (LX(i2)) {
                    this.byteOffset++;
                    i2 += 2;
                }
            } else {
                dvp();
                return;
            }
        }
    }

    public boolean LW(int i) {
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
        while (i8 <= i7 && i7 < this.mma) {
            if (LX(i8)) {
                i7++;
                i8 += 2;
            }
            i8++;
        }
        return i7 < this.mma || (i7 == this.mma && i5 == 0);
    }

    public boolean dvo() {
        boolean z = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        dzs();
        return z;
    }

    public int readBits(int i) {
        this.bitOffset += i;
        int i2 = 0;
        while (this.bitOffset > 8) {
            this.bitOffset -= 8;
            i2 |= (this.data[this.byteOffset] & 255) << this.bitOffset;
            this.byteOffset = (LX(this.byteOffset + 1) ? 2 : 1) + this.byteOffset;
        }
        int i3 = (i2 | ((this.data[this.byteOffset] & 255) >> (8 - this.bitOffset))) & ((-1) >>> (32 - i));
        if (this.bitOffset == 8) {
            this.bitOffset = 0;
            this.byteOffset += LX(this.byteOffset + 1) ? 2 : 1;
        }
        dvp();
        return i3;
    }

    public boolean dzK() {
        int i = this.byteOffset;
        int i2 = this.bitOffset;
        int i3 = 0;
        while (this.byteOffset < this.mma && !dvo()) {
            i3++;
        }
        boolean z = this.byteOffset == this.mma;
        this.byteOffset = i;
        this.bitOffset = i2;
        return !z && LW((i3 * 2) + 1);
    }

    public int dzL() {
        return dzN();
    }

    public int dzM() {
        int dzN = dzN();
        return (dzN % 2 == 0 ? -1 : 1) * ((dzN + 1) / 2);
    }

    private int dzN() {
        int i = 0;
        while (!dvo()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? readBits(i) : 0);
    }

    private boolean LX(int i) {
        return 2 <= i && i < this.mma && this.data[i] == 3 && this.data[i + (-2)] == 0 && this.data[i + (-1)] == 0;
    }

    private void dvp() {
        a.checkState(this.byteOffset >= 0 && (this.byteOffset < this.mma || (this.byteOffset == this.mma && this.bitOffset == 0)));
    }
}
