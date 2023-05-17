package com.google.android.exoplayer2.util;
/* loaded from: classes9.dex */
public final class ParsableBitArray {
    public int bitOffset;
    public int byteLimit;
    public int byteOffset;
    public byte[] data;

    public ParsableBitArray() {
    }

    private void assertValidOffset() {
        boolean z;
        int i;
        int i2 = this.byteOffset;
        if (i2 >= 0 && (i2 < (i = this.byteLimit) || (i2 == i && this.bitOffset == 0))) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
    }

    public int bitsLeft() {
        return ((this.byteLimit - this.byteOffset) * 8) - this.bitOffset;
    }

    public void byteAlign() {
        if (this.bitOffset == 0) {
            return;
        }
        this.bitOffset = 0;
        this.byteOffset++;
        assertValidOffset();
    }

    public int getBytePosition() {
        boolean z;
        if (this.bitOffset == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        return this.byteOffset;
    }

    public int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public boolean readBit() {
        boolean z;
        if ((this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0) {
            z = true;
        } else {
            z = false;
        }
        skipBit();
        return z;
    }

    public void skipBit() {
        int i = this.bitOffset + 1;
        this.bitOffset = i;
        if (i == 8) {
            this.bitOffset = 0;
            this.byteOffset++;
        }
        assertValidOffset();
    }

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public void reset(ParsableByteArray parsableByteArray) {
        reset(parsableByteArray.data, parsableByteArray.limit());
        setPosition(parsableByteArray.getPosition() * 8);
    }

    public void setPosition(int i) {
        int i2 = i / 8;
        this.byteOffset = i2;
        this.bitOffset = i - (i2 * 8);
        assertValidOffset();
    }

    public void skipBits(int i) {
        int i2 = i / 8;
        int i3 = this.byteOffset + i2;
        this.byteOffset = i3;
        int i4 = this.bitOffset + (i - (i2 * 8));
        this.bitOffset = i4;
        if (i4 > 7) {
            this.byteOffset = i3 + 1;
            this.bitOffset = i4 - 8;
        }
        assertValidOffset();
    }

    public void skipBytes(int i) {
        boolean z;
        if (this.bitOffset == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.byteOffset += i;
        assertValidOffset();
    }

    public ParsableBitArray(byte[] bArr, int i) {
        this.data = bArr;
        this.byteLimit = i;
    }

    public void reset(byte[] bArr, int i) {
        this.data = bArr;
        this.byteOffset = 0;
        this.bitOffset = 0;
        this.byteLimit = i;
    }

    public int readBits(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.bitOffset += i;
        int i3 = 0;
        while (true) {
            i2 = this.bitOffset;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.bitOffset = i4;
            byte[] bArr = this.data;
            int i5 = this.byteOffset;
            this.byteOffset = i5 + 1;
            i3 |= (bArr[i5] & 255) << i4;
        }
        byte[] bArr2 = this.data;
        int i6 = this.byteOffset;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i6 + 1;
        }
        assertValidOffset();
        return i7;
    }

    public void readBits(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.data;
            int i4 = this.byteOffset;
            int i5 = i4 + 1;
            this.byteOffset = i5;
            byte b = bArr2[i4];
            int i6 = this.bitOffset;
            bArr[i] = (byte) (b << i6);
            bArr[i] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | bArr[i]);
            i++;
        }
        int i7 = i2 & 7;
        if (i7 == 0) {
            return;
        }
        bArr[i3] = (byte) (bArr[i3] & (255 >> i7));
        int i8 = this.bitOffset;
        if (i8 + i7 > 8) {
            byte b2 = bArr[i3];
            byte[] bArr3 = this.data;
            int i9 = this.byteOffset;
            this.byteOffset = i9 + 1;
            bArr[i3] = (byte) (b2 | ((byte) ((bArr3[i9] & 255) << i8)));
            this.bitOffset = i8 - 8;
        }
        int i10 = this.bitOffset + i7;
        this.bitOffset = i10;
        byte[] bArr4 = this.data;
        int i11 = this.byteOffset;
        bArr[i3] = (byte) (((byte) (((255 & bArr4[i11]) >> (8 - i10)) << (8 - i7))) | bArr[i3]);
        if (i10 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i11 + 1;
        }
        assertValidOffset();
    }

    public void readBytes(byte[] bArr, int i, int i2) {
        boolean z;
        if (this.bitOffset == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        System.arraycopy(this.data, this.byteOffset, bArr, i, i2);
        this.byteOffset += i2;
        assertValidOffset();
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }
}
