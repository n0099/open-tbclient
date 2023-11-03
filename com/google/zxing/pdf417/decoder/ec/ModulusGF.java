package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.pdf417.PDF417Common;
/* loaded from: classes10.dex */
public final class ModulusGF {
    public static final ModulusGF PDF417_GF = new ModulusGF(PDF417Common.NUMBER_OF_CODEWORDS, 3);
    public final int[] expTable;
    public final int[] logTable;
    public final int modulus;
    public final ModulusPoly one;
    public final ModulusPoly zero;

    public ModulusPoly getOne() {
        return this.one;
    }

    public int getSize() {
        return this.modulus;
    }

    public ModulusPoly getZero() {
        return this.zero;
    }

    public ModulusGF(int i, int i2) {
        this.modulus = i;
        this.expTable = new int[i];
        this.logTable = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.expTable[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.logTable[this.expTable[i5]] = i5;
        }
        this.zero = new ModulusPoly(this, new int[]{0});
        this.one = new ModulusPoly(this, new int[]{1});
    }

    public int add(int i, int i2) {
        return (i + i2) % this.modulus;
    }

    public ModulusPoly buildMonomial(int i, int i2) {
        if (i >= 0) {
            if (i2 == 0) {
                return this.zero;
            }
            int[] iArr = new int[i + 1];
            iArr[0] = i2;
            return new ModulusPoly(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    public int multiply(int i, int i2) {
        if (i != 0 && i2 != 0) {
            int[] iArr = this.expTable;
            int[] iArr2 = this.logTable;
            return iArr[(iArr2[i] + iArr2[i2]) % (this.modulus - 1)];
        }
        return 0;
    }

    public int subtract(int i, int i2) {
        int i3 = this.modulus;
        return ((i + i3) - i2) % i3;
    }

    public int exp(int i) {
        return this.expTable[i];
    }

    public int inverse(int i) {
        if (i != 0) {
            return this.expTable[(this.modulus - this.logTable[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public int log(int i) {
        if (i != 0) {
            return this.logTable[i];
        }
        throw new IllegalArgumentException();
    }
}
