package com.google.zxing.common;
/* loaded from: classes.dex */
public final class BitMatrix {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i) {
        this(i, i);
    }

    public BitMatrix(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = i;
        this.height = i2;
        this.rowSize = (i + 31) >> 5;
        this.bits = new int[this.rowSize * i2];
    }

    public boolean get(int i, int i2) {
        return ((this.bits[(this.rowSize * i2) + (i >> 5)] >>> (i & 31)) & 1) != 0;
    }

    public void set(int i, int i2) {
        int i3 = (this.rowSize * i2) + (i >> 5);
        int[] iArr = this.bits;
        iArr[i3] = iArr[i3] | (1 << (i & 31));
    }

    public void flip(int i, int i2) {
        int i3 = (this.rowSize * i2) + (i >> 5);
        int[] iArr = this.bits;
        iArr[i3] = iArr[i3] ^ (1 << (i & 31));
    }

    public void clear() {
        int length = this.bits.length;
        for (int i = 0; i < length; i++) {
            this.bits[i] = 0;
        }
    }

    public void setRegion(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i + i3;
        int i6 = i2 + i4;
        if (i6 > this.height || i5 > this.width) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = i2 * this.rowSize;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.bits;
                int i9 = (i8 >> 5) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public BitArray getRow(int i, BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.width) {
            bitArray = new BitArray(this.width);
        }
        int i2 = i * this.rowSize;
        for (int i3 = 0; i3 < this.rowSize; i3++) {
            bitArray.setBulk(i3 << 5, this.bits[i2 + i3]);
        }
        return bitArray;
    }

    public void setRow(int i, BitArray bitArray) {
        System.arraycopy(bitArray.getBitArray(), 0, this.bits, this.rowSize * i, this.rowSize);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x005a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] getEnclosingRectangle() {
        int i;
        int i2 = this.width;
        int i3 = this.height;
        int i4 = i2;
        int i5 = -1;
        int i6 = -1;
        for (int i7 = 0; i7 < this.height; i7++) {
            int i8 = 0;
            while (i8 < this.rowSize) {
                int i9 = this.bits[(this.rowSize * i7) + i8];
                if (i9 != 0) {
                    if (i7 < i3) {
                        i3 = i7;
                    }
                    if (i7 > i6) {
                        i6 = i7;
                    }
                    if (i8 * 32 < i4) {
                        int i10 = 0;
                        while ((i9 << (31 - i10)) == 0) {
                            i10++;
                        }
                        if ((i8 * 32) + i10 < i4) {
                            i = (i8 * 32) + i10;
                            if ((i8 * 32) + 31 <= i5) {
                                int i11 = 31;
                                while ((i9 >>> i11) == 0) {
                                    i11--;
                                }
                                if ((i8 * 32) + i11 > i5) {
                                    i5 = (i8 * 32) + i11;
                                }
                            }
                        }
                    }
                    i = i4;
                    if ((i8 * 32) + 31 <= i5) {
                    }
                } else {
                    i = i4;
                }
                i8++;
                i6 = i6;
                i5 = i5;
                i3 = i3;
                i4 = i;
            }
        }
        int i12 = i5 - i4;
        int i13 = i6 - i3;
        if (i12 < 0 || i13 < 0) {
            return null;
        }
        return new int[]{i4, i3, i12, i13};
    }

    public int[] getTopLeftOnBit() {
        int i = 0;
        while (i < this.bits.length && this.bits[i] == 0) {
            i++;
        }
        if (i == this.bits.length) {
            return null;
        }
        int i2 = i / this.rowSize;
        int i3 = (i % this.rowSize) << 5;
        int i4 = this.bits[i];
        int i5 = 0;
        while ((i4 << (31 - i5)) == 0) {
            i5++;
        }
        return new int[]{i3 + i5, i2};
    }

    public int[] getBottomRightOnBit() {
        int length = this.bits.length - 1;
        while (length >= 0 && this.bits[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = length / this.rowSize;
        int i2 = (length % this.rowSize) << 5;
        int i3 = this.bits[length];
        int i4 = 31;
        while ((i3 >>> i4) == 0) {
            i4--;
        }
        return new int[]{i2 + i4, i};
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BitMatrix) {
            BitMatrix bitMatrix = (BitMatrix) obj;
            if (this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && this.bits.length == bitMatrix.bits.length) {
                for (int i = 0; i < this.bits.length; i++) {
                    if (this.bits[i] != bitMatrix.bits[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = this.rowSize + (((((this.width * 31) + this.width) * 31) + this.height) * 31);
        for (int i2 : this.bits) {
            i = (i * 31) + i2;
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; i++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                sb.append(get(i2, i) ? "X " : "  ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
