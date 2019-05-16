package com.google.zxing.common;

import java.util.Arrays;
/* loaded from: classes5.dex */
public final class BitMatrix implements Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i) {
        this(i, i);
    }

    public BitMatrix(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = i;
        this.height = i2;
        this.rowSize = (i + 31) / 32;
        this.bits = new int[this.rowSize * i2];
    }

    private BitMatrix(int i, int i2, int i3, int[] iArr) {
        this.width = i;
        this.height = i2;
        this.rowSize = i3;
        this.bits = iArr;
    }

    public static BitMatrix parse(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '\n' || str.charAt(i) == '\r') {
                if (i5 > i4) {
                    if (i3 == -1) {
                        i3 = i5 - i4;
                    } else if (i5 - i4 != i3) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i2++;
                    i4 = i5;
                }
                i++;
            } else if (str.substring(i, str2.length() + i).equals(str2)) {
                i += str2.length();
                zArr[i5] = true;
                i5++;
            } else if (str.substring(i, str3.length() + i).equals(str3)) {
                i += str3.length();
                zArr[i5] = false;
                i5++;
            } else {
                throw new IllegalArgumentException("illegal character encountered: " + str.substring(i));
            }
        }
        if (i5 > i4) {
            if (i3 == -1) {
                i3 = i5 - i4;
            } else if (i5 - i4 != i3) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i2++;
        }
        BitMatrix bitMatrix = new BitMatrix(i3, i2);
        for (int i6 = 0; i6 < i5; i6++) {
            if (zArr[i6]) {
                bitMatrix.set(i6 % i3, i6 / i3);
            }
        }
        return bitMatrix;
    }

    public boolean get(int i, int i2) {
        return ((this.bits[(this.rowSize * i2) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public void set(int i, int i2) {
        int i3 = (this.rowSize * i2) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = iArr[i3] | (1 << (i & 31));
    }

    public void unset(int i, int i2) {
        int i3 = (this.rowSize * i2) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = iArr[i3] & ((1 << (i & 31)) ^ (-1));
    }

    public void flip(int i, int i2) {
        int i3 = (this.rowSize * i2) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = iArr[i3] ^ (1 << (i & 31));
    }

    public void xor(BitMatrix bitMatrix) {
        if (this.width != bitMatrix.getWidth() || this.height != bitMatrix.getHeight() || this.rowSize != bitMatrix.getRowSize()) {
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
        BitArray bitArray = new BitArray((this.width / 32) + 1);
        for (int i = 0; i < this.height; i++) {
            int i2 = i * this.rowSize;
            int[] bitArray2 = bitMatrix.getRow(i, bitArray).getBitArray();
            for (int i3 = 0; i3 < this.rowSize; i3++) {
                int[] iArr = this.bits;
                int i4 = i2 + i3;
                iArr[i4] = iArr[i4] ^ bitArray2[i3];
            }
        }
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
        if (i4 <= 0 || i3 <= 0) {
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
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public BitArray getRow(int i, BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.width) {
            bitArray = new BitArray(this.width);
        } else {
            bitArray.clear();
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

    public void rotate180() {
        int width = getWidth();
        int height = getHeight();
        BitArray bitArray = new BitArray(width);
        BitArray bitArray2 = new BitArray(width);
        for (int i = 0; i < (height + 1) / 2; i++) {
            bitArray = getRow(i, bitArray);
            bitArray2 = getRow((height - 1) - i, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(i, bitArray2);
            setRow((height - 1) - i, bitArray);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0055 A[SYNTHETIC] */
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
                    if ((i8 << 5) < i4) {
                        int i10 = 0;
                        while ((i9 << (31 - i10)) == 0) {
                            i10++;
                        }
                        if ((i8 << 5) + i10 < i4) {
                            i = (i8 << 5) + i10;
                            if ((i8 << 5) + 31 <= i5) {
                                int i11 = 31;
                                while ((i9 >>> i11) == 0) {
                                    i11--;
                                }
                                if ((i8 << 5) + i11 > i5) {
                                    i5 = (i8 << 5) + i11;
                                }
                            }
                        }
                    }
                    i = i4;
                    if ((i8 << 5) + 31 <= i5) {
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
        if (i5 < i4 || i6 < i3) {
            return null;
        }
        return new int[]{i4, i3, (i5 - i4) + 1, (i6 - i3) + 1};
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

    public int getRowSize() {
        return this.rowSize;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BitMatrix) {
            BitMatrix bitMatrix = (BitMatrix) obj;
            return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.width * 31) + this.width) * 31) + this.height) * 31) + this.rowSize) * 31) + Arrays.hashCode(this.bits);
    }

    public String toString() {
        return toString("X ", "  ");
    }

    public String toString(String str, String str2) {
        return buildToString(str, str2, "\n");
    }

    @Deprecated
    public String toString(String str, String str2, String str3) {
        return buildToString(str, str2, str3);
    }

    private String buildToString(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; i++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                sb.append(get(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BitMatrix m27clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }
}
