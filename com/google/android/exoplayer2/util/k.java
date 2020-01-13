package com.google.android.exoplayer2.util;
/* loaded from: classes5.dex */
public final class k {
    private int bitOffset;
    private int byteOffset;
    public byte[] data;
    private int mlc;

    public k() {
    }

    public k(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public k(byte[] bArr, int i) {
        this.data = bArr;
        this.mlc = i;
    }

    public void aw(byte[] bArr) {
        G(bArr, bArr.length);
    }

    public void G(byte[] bArr, int i) {
        this.data = bArr;
        this.byteOffset = 0;
        this.bitOffset = 0;
        this.mlc = i;
    }

    public int dyb() {
        return ((this.mlc - this.byteOffset) * 8) - this.bitOffset;
    }

    public int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public int dyc() {
        a.checkState(this.bitOffset == 0);
        return this.byteOffset;
    }

    public void setPosition(int i) {
        this.byteOffset = i / 8;
        this.bitOffset = i - (this.byteOffset * 8);
        dtZ();
    }

    public void dyd() {
        int i = this.bitOffset + 1;
        this.bitOffset = i;
        if (i == 8) {
            this.bitOffset = 0;
            this.byteOffset++;
        }
        dtZ();
    }

    public void JP(int i) {
        int i2 = i / 8;
        this.byteOffset += i2;
        this.bitOffset = (i - (i2 * 8)) + this.bitOffset;
        if (this.bitOffset > 7) {
            this.byteOffset++;
            this.bitOffset -= 8;
        }
        dtZ();
    }

    public boolean dtY() {
        boolean z = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        dyd();
        return z;
    }

    public int readBits(int i) {
        if (i == 0) {
            return 0;
        }
        this.bitOffset += i;
        int i2 = 0;
        while (this.bitOffset > 8) {
            this.bitOffset -= 8;
            byte[] bArr = this.data;
            int i3 = this.byteOffset;
            this.byteOffset = i3 + 1;
            i2 |= (bArr[i3] & 255) << this.bitOffset;
        }
        int i4 = (i2 | ((this.data[this.byteOffset] & 255) >> (8 - this.bitOffset))) & ((-1) >>> (32 - i));
        if (this.bitOffset == 8) {
            this.bitOffset = 0;
            this.byteOffset++;
        }
        dtZ();
        return i4;
    }

    public void B(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.data;
            int i4 = this.byteOffset;
            this.byteOffset = i4 + 1;
            bArr[i] = (byte) (bArr2[i4] << this.bitOffset);
            bArr[i] = (byte) (bArr[i] | ((this.data[this.byteOffset] & 255) >> (8 - this.bitOffset)));
            i++;
        }
        int i5 = i2 & 7;
        if (i5 != 0) {
            bArr[i3] = (byte) (bArr[i3] & (255 >> i5));
            if (this.bitOffset + i5 > 8) {
                byte b = bArr[i3];
                byte[] bArr3 = this.data;
                int i6 = this.byteOffset;
                this.byteOffset = i6 + 1;
                bArr[i3] = (byte) (b | ((byte) ((bArr3[i6] & 255) << this.bitOffset)));
                this.bitOffset -= 8;
            }
            this.bitOffset += i5;
            bArr[i3] = (byte) (((byte) (((this.data[this.byteOffset] & 255) >> (8 - this.bitOffset)) << (8 - i5))) | bArr[i3]);
            if (this.bitOffset == 8) {
                this.bitOffset = 0;
                this.byteOffset++;
            }
            dtZ();
        }
    }

    public void dye() {
        if (this.bitOffset != 0) {
            this.bitOffset = 0;
            this.byteOffset++;
            dtZ();
        }
    }

    public void C(byte[] bArr, int i, int i2) {
        a.checkState(this.bitOffset == 0);
        System.arraycopy(this.data, this.byteOffset, bArr, i, i2);
        this.byteOffset += i2;
        dtZ();
    }

    public void skipBytes(int i) {
        a.checkState(this.bitOffset == 0);
        this.byteOffset += i;
        dtZ();
    }

    private void dtZ() {
        a.checkState(this.byteOffset >= 0 && (this.byteOffset < this.mlc || (this.byteOffset == this.mlc && this.bitOffset == 0)));
    }
}
