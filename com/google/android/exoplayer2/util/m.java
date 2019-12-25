package com.google.android.exoplayer2.util;
/* loaded from: classes4.dex */
public final class m {
    private int bitOffset;
    private int byteOffset;
    private byte[] data;
    private int mhl;

    public m(byte[] bArr, int i, int i2) {
        E(bArr, i, i2);
    }

    public void E(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.byteOffset = i;
        this.mhl = i2;
        this.bitOffset = 0;
        dsN();
    }

    public void dwT() {
        int i = this.bitOffset + 1;
        this.bitOffset = i;
        if (i == 8) {
            this.bitOffset = 0;
            this.byteOffset = (LJ(this.byteOffset + 1) ? 2 : 1) + this.byteOffset;
        }
        dsN();
    }

    public void JG(int i) {
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
                if (LJ(i2)) {
                    this.byteOffset++;
                    i2 += 2;
                }
            } else {
                dsN();
                return;
            }
        }
    }

    public boolean LI(int i) {
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
        while (i8 <= i7 && i7 < this.mhl) {
            if (LJ(i8)) {
                i7++;
                i8 += 2;
            }
            i8++;
        }
        return i7 < this.mhl || (i7 == this.mhl && i5 == 0);
    }

    public boolean dsM() {
        boolean z = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        dwT();
        return z;
    }

    public int readBits(int i) {
        this.bitOffset += i;
        int i2 = 0;
        while (this.bitOffset > 8) {
            this.bitOffset -= 8;
            i2 |= (this.data[this.byteOffset] & 255) << this.bitOffset;
            this.byteOffset = (LJ(this.byteOffset + 1) ? 2 : 1) + this.byteOffset;
        }
        int i3 = (i2 | ((this.data[this.byteOffset] & 255) >> (8 - this.bitOffset))) & ((-1) >>> (32 - i));
        if (this.bitOffset == 8) {
            this.bitOffset = 0;
            this.byteOffset += LJ(this.byteOffset + 1) ? 2 : 1;
        }
        dsN();
        return i3;
    }

    public boolean dxl() {
        int i = this.byteOffset;
        int i2 = this.bitOffset;
        int i3 = 0;
        while (this.byteOffset < this.mhl && !dsM()) {
            i3++;
        }
        boolean z = this.byteOffset == this.mhl;
        this.byteOffset = i;
        this.bitOffset = i2;
        return !z && LI((i3 * 2) + 1);
    }

    public int dxm() {
        return dxo();
    }

    public int dxn() {
        int dxo = dxo();
        return (dxo % 2 == 0 ? -1 : 1) * ((dxo + 1) / 2);
    }

    private int dxo() {
        int i = 0;
        while (!dsM()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? readBits(i) : 0);
    }

    private boolean LJ(int i) {
        return 2 <= i && i < this.mhl && this.data[i] == 3 && this.data[i + (-2)] == 0 && this.data[i + (-1)] == 0;
    }

    private void dsN() {
        a.checkState(this.byteOffset >= 0 && (this.byteOffset < this.mhl || (this.byteOffset == this.mhl && this.bitOffset == 0)));
    }
}
