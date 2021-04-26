package com.google.zxing.common;
/* loaded from: classes6.dex */
public final class BitSource {
    public int bitOffset;
    public int byteOffset;
    public final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i2) {
        if (i2 > 0 && i2 <= 32 && i2 <= available()) {
            int i3 = this.bitOffset;
            int i4 = 0;
            if (i3 > 0) {
                int i5 = 8 - i3;
                int i6 = i2 < i5 ? i2 : i5;
                int i7 = i5 - i6;
                byte[] bArr = this.bytes;
                int i8 = this.byteOffset;
                int i9 = (((255 >> (8 - i6)) << i7) & bArr[i8]) >> i7;
                i2 -= i6;
                int i10 = this.bitOffset + i6;
                this.bitOffset = i10;
                if (i10 == 8) {
                    this.bitOffset = 0;
                    this.byteOffset = i8 + 1;
                }
                i4 = i9;
            }
            if (i2 > 0) {
                while (i2 >= 8) {
                    int i11 = i4 << 8;
                    byte[] bArr2 = this.bytes;
                    int i12 = this.byteOffset;
                    i4 = (bArr2[i12] & 255) | i11;
                    this.byteOffset = i12 + 1;
                    i2 -= 8;
                }
                if (i2 > 0) {
                    int i13 = 8 - i2;
                    int i14 = (i4 << i2) | ((((255 >> i13) << i13) & this.bytes[this.byteOffset]) >> i13);
                    this.bitOffset += i2;
                    return i14;
                }
                return i4;
            }
            return i4;
        }
        throw new IllegalArgumentException(String.valueOf(i2));
    }
}
