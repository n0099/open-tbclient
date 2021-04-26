package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;
/* loaded from: classes6.dex */
public final class ErrorCorrection {
    public final ModulusGF field = ModulusGF.PDF417_GF;

    private int[] findErrorLocations(ModulusPoly modulusPoly) throws ChecksumException {
        int degree = modulusPoly.getDegree();
        int[] iArr = new int[degree];
        int i2 = 0;
        for (int i3 = 1; i3 < this.field.getSize() && i2 < degree; i3++) {
            if (modulusPoly.evaluateAt(i3) == 0) {
                iArr[i2] = this.field.inverse(i3);
                i2++;
            }
        }
        if (i2 == degree) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] findErrorMagnitudes(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int[] iArr) {
        int degree = modulusPoly2.getDegree();
        int[] iArr2 = new int[degree];
        for (int i2 = 1; i2 <= degree; i2++) {
            iArr2[degree - i2] = this.field.multiply(i2, modulusPoly2.getCoefficient(i2));
        }
        ModulusPoly modulusPoly3 = new ModulusPoly(this.field, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            int inverse = this.field.inverse(iArr[i3]);
            iArr3[i3] = this.field.multiply(this.field.subtract(0, modulusPoly.evaluateAt(inverse)), this.field.inverse(modulusPoly3.evaluateAt(inverse)));
        }
        return iArr3;
    }

    private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int i2) throws ChecksumException {
        if (modulusPoly.getDegree() < modulusPoly2.getDegree()) {
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly2;
        }
        ModulusPoly zero = this.field.getZero();
        ModulusPoly one = this.field.getOne();
        while (true) {
            ModulusPoly modulusPoly3 = modulusPoly2;
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly3;
            ModulusPoly modulusPoly4 = one;
            ModulusPoly modulusPoly5 = zero;
            zero = modulusPoly4;
            if (modulusPoly.getDegree() >= i2 / 2) {
                if (!modulusPoly.isZero()) {
                    ModulusPoly zero2 = this.field.getZero();
                    int inverse = this.field.inverse(modulusPoly.getCoefficient(modulusPoly.getDegree()));
                    while (modulusPoly2.getDegree() >= modulusPoly.getDegree() && !modulusPoly2.isZero()) {
                        int degree = modulusPoly2.getDegree() - modulusPoly.getDegree();
                        int multiply = this.field.multiply(modulusPoly2.getCoefficient(modulusPoly2.getDegree()), inverse);
                        zero2 = zero2.add(this.field.buildMonomial(degree, multiply));
                        modulusPoly2 = modulusPoly2.subtract(modulusPoly.multiplyByMonomial(degree, multiply));
                    }
                    one = zero2.multiply(zero).subtract(modulusPoly5).negative();
                } else {
                    throw ChecksumException.getChecksumInstance();
                }
            } else {
                int coefficient = zero.getCoefficient(0);
                if (coefficient != 0) {
                    int inverse2 = this.field.inverse(coefficient);
                    return new ModulusPoly[]{zero.multiply(inverse2), modulusPoly.multiply(inverse2)};
                }
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public int decode(int[] iArr, int i2, int[] iArr2) throws ChecksumException {
        ModulusPoly modulusPoly = new ModulusPoly(this.field, iArr);
        int[] iArr3 = new int[i2];
        boolean z = false;
        for (int i3 = i2; i3 > 0; i3--) {
            int evaluateAt = modulusPoly.evaluateAt(this.field.exp(i3));
            iArr3[i2 - i3] = evaluateAt;
            if (evaluateAt != 0) {
                z = true;
            }
        }
        if (z) {
            ModulusPoly one = this.field.getOne();
            if (iArr2 != null) {
                for (int i4 : iArr2) {
                    int exp = this.field.exp((iArr.length - 1) - i4);
                    ModulusGF modulusGF = this.field;
                    one = one.multiply(new ModulusPoly(modulusGF, new int[]{modulusGF.subtract(0, exp), 1}));
                }
            }
            ModulusPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i2, 1), new ModulusPoly(this.field, iArr3), i2);
            ModulusPoly modulusPoly2 = runEuclideanAlgorithm[0];
            ModulusPoly modulusPoly3 = runEuclideanAlgorithm[1];
            int[] findErrorLocations = findErrorLocations(modulusPoly2);
            int[] findErrorMagnitudes = findErrorMagnitudes(modulusPoly3, modulusPoly2, findErrorLocations);
            for (int i5 = 0; i5 < findErrorLocations.length; i5++) {
                int length = (iArr.length - 1) - this.field.log(findErrorLocations[i5]);
                if (length >= 0) {
                    iArr[length] = this.field.subtract(iArr[length], findErrorMagnitudes[i5]);
                } else {
                    throw ChecksumException.getChecksumInstance();
                }
            }
            return findErrorLocations.length;
        }
        return 0;
    }
}
