package com.google.zxing.common;

import org.apache.commons.io.FilenameUtils;
/* loaded from: classes.dex */
public final class BitArray {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    public BitArray(int i) {
        this.size = i;
        this.bits = makeArray(i);
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) >> 3;
    }

    private void ensureCapacity(int i) {
        if (i > (this.bits.length << 5)) {
            int[] makeArray = makeArray(i);
            System.arraycopy(this.bits, 0, makeArray, 0, this.bits.length);
            this.bits = makeArray;
        }
    }

    public boolean get(int i) {
        return (this.bits[i >> 5] & (1 << (i & 31))) != 0;
    }

    public void set(int i) {
        int[] iArr = this.bits;
        int i2 = i >> 5;
        iArr[i2] = iArr[i2] | (1 << (i & 31));
    }

    public void flip(int i) {
        int[] iArr = this.bits;
        int i2 = i >> 5;
        iArr[i2] = iArr[i2] ^ (1 << (i & 31));
    }

    public int getNextSet(int i) {
        if (i >= this.size) {
            return this.size;
        }
        int i2 = i >> 5;
        int i3 = this.bits[i2] & (((1 << (i & 31)) - 1) ^ (-1));
        while (i3 == 0) {
            i2++;
            if (i2 == this.bits.length) {
                return this.size;
            }
            i3 = this.bits[i2];
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i3) + (i2 << 5);
        return numberOfTrailingZeros > this.size ? this.size : numberOfTrailingZeros;
    }

    public int getNextUnset(int i) {
        if (i >= this.size) {
            return this.size;
        }
        int i2 = i >> 5;
        int i3 = (this.bits[i2] ^ (-1)) & (((1 << (i & 31)) - 1) ^ (-1));
        while (i3 == 0) {
            i2++;
            if (i2 == this.bits.length) {
                return this.size;
            }
            i3 = this.bits[i2] ^ (-1);
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i3) + (i2 << 5);
        return numberOfTrailingZeros > this.size ? this.size : numberOfTrailingZeros;
    }

    public void setBulk(int i, int i2) {
        this.bits[i >> 5] = i2;
    }

    public void setRange(int i, int i2) {
        int i3;
        if (i2 < i) {
            throw new IllegalArgumentException();
        }
        if (i2 != i) {
            int i4 = i2 - 1;
            int i5 = i >> 5;
            int i6 = i4 >> 5;
            int i7 = i5;
            while (i7 <= i6) {
                int i8 = i7 > i5 ? 0 : i & 31;
                int i9 = i7 < i6 ? 31 : i4 & 31;
                if (i8 == 0 && i9 == 31) {
                    i3 = -1;
                } else {
                    int i10 = i8;
                    i3 = 0;
                    while (i10 <= i9) {
                        int i11 = (1 << i10) | i3;
                        i10++;
                        i3 = i11;
                    }
                }
                int[] iArr = this.bits;
                iArr[i7] = i3 | iArr[i7];
                i7++;
            }
        }
    }

    public void clear() {
        int length = this.bits.length;
        for (int i = 0; i < length; i++) {
            this.bits[i] = 0;
        }
    }

    public boolean isRange(int i, int i2, boolean z) {
        int i3;
        if (i2 < i) {
            throw new IllegalArgumentException();
        }
        if (i2 == i) {
            return true;
        }
        int i4 = i2 - 1;
        int i5 = i >> 5;
        int i6 = i4 >> 5;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = i7 > i5 ? 0 : i & 31;
            int i9 = i7 < i6 ? 31 : i4 & 31;
            if (i8 == 0 && i9 == 31) {
                i3 = -1;
            } else {
                int i10 = i8;
                i3 = 0;
                while (i10 <= i9) {
                    int i11 = (1 << i10) | i3;
                    i10++;
                    i3 = i11;
                }
            }
            int i12 = this.bits[i7] & i3;
            if (!z) {
                i3 = 0;
            }
            if (i12 != i3) {
                return false;
            }
            i7++;
        }
        return true;
    }

    public void appendBit(boolean z) {
        ensureCapacity(this.size + 1);
        if (z) {
            int[] iArr = this.bits;
            int i = this.size >> 5;
            iArr[i] = iArr[i] | (1 << (this.size & 31));
        }
        this.size++;
    }

    public void appendBits(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + i2);
        while (i2 > 0) {
            appendBit(((i >> (i2 + (-1))) & 1) == 1);
            i2--;
        }
    }

    public void appendBitArray(BitArray bitArray) {
        int i = bitArray.size;
        ensureCapacity(this.size + i);
        for (int i2 = 0; i2 < i; i2++) {
            appendBit(bitArray.get(i2));
        }
    }

    public void xor(BitArray bitArray) {
        if (this.bits.length != bitArray.bits.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < this.bits.length; i++) {
            int[] iArr = this.bits;
            iArr[i] = iArr[i] ^ bitArray.bits[i];
        }
    }

    public void toBytes(int i, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        int i5 = i;
        while (i4 < i3) {
            int i6 = i5;
            int i7 = 0;
            for (int i8 = 0; i8 < 8; i8++) {
                if (get(i6)) {
                    i7 |= 1 << (7 - i8);
                }
                i6++;
            }
            bArr[i2 + i4] = (byte) i7;
            i4++;
            i5 = i6;
        }
    }

    public int[] getBitArray() {
        return this.bits;
    }

    public void reverse() {
        int[] iArr = new int[this.bits.length];
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (get((i - i2) - 1)) {
                int i3 = i2 >> 5;
                iArr[i3] = iArr[i3] | (1 << (i2 & 31));
            }
        }
        this.bits = iArr;
    }

    private static int[] makeArray(int i) {
        return new int[(i + 31) >> 5];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.size);
        for (int i = 0; i < this.size; i++) {
            if ((i & 7) == 0) {
                sb.append(' ');
            }
            sb.append(get(i) ? 'X' : FilenameUtils.EXTENSION_SEPARATOR);
        }
        return sb.toString();
    }
}
