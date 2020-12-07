package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;
/* loaded from: classes16.dex */
public final class ErrorCorrection {
    private final ModulusGF field = ModulusGF.PDF417_GF;

    public int decode(int[] iArr, int i, int[] iArr2) throws ChecksumException {
        ModulusPoly modulusPoly = new ModulusPoly(this.field, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int evaluateAt = modulusPoly.evaluateAt(this.field.exp(i2));
            iArr3[i - i2] = evaluateAt;
            if (evaluateAt != 0) {
                z = true;
            }
        }
        if (z) {
            ModulusPoly one = this.field.getOne();
            if (iArr2 != null) {
                ModulusPoly modulusPoly2 = one;
                for (int i3 : iArr2) {
                    modulusPoly2 = modulusPoly2.multiply(new ModulusPoly(this.field, new int[]{this.field.subtract(0, this.field.exp((iArr.length - 1) - i3)), 1}));
                }
            }
            ModulusPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new ModulusPoly(this.field, iArr3), i);
            ModulusPoly modulusPoly3 = runEuclideanAlgorithm[0];
            ModulusPoly modulusPoly4 = runEuclideanAlgorithm[1];
            int[] findErrorLocations = findErrorLocations(modulusPoly3);
            int[] findErrorMagnitudes = findErrorMagnitudes(modulusPoly4, modulusPoly3, findErrorLocations);
            for (int i4 = 0; i4 < findErrorLocations.length; i4++) {
                int length = (iArr.length - 1) - this.field.log(findErrorLocations[i4]);
                if (length < 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                iArr[length] = this.field.subtract(iArr[length], findErrorMagnitudes[i4]);
            }
            return findErrorLocations.length;
        }
        return 0;
    }

    private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int i) throws ChecksumException {
        if (modulusPoly.getDegree() >= modulusPoly2.getDegree()) {
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly2;
        }
        ModulusPoly zero = this.field.getZero();
        ModulusPoly one = this.field.getOne();
        while (modulusPoly.getDegree() >= i / 2) {
            if (modulusPoly.isZero()) {
                throw ChecksumException.getChecksumInstance();
            }
            ModulusPoly zero2 = this.field.getZero();
            int inverse = this.field.inverse(modulusPoly.getCoefficient(modulusPoly.getDegree()));
            ModulusPoly modulusPoly3 = zero2;
            ModulusPoly modulusPoly4 = modulusPoly2;
            while (modulusPoly4.getDegree() >= modulusPoly.getDegree() && !modulusPoly4.isZero()) {
                int degree = modulusPoly4.getDegree() - modulusPoly.getDegree();
                int multiply = this.field.multiply(modulusPoly4.getCoefficient(modulusPoly4.getDegree()), inverse);
                modulusPoly3 = modulusPoly3.add(this.field.buildMonomial(degree, multiply));
                modulusPoly4 = modulusPoly4.subtract(modulusPoly.multiplyByMonomial(degree, multiply));
            }
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly4;
            ModulusPoly modulusPoly5 = one;
            one = modulusPoly3.multiply(one).subtract(zero).negative();
            zero = modulusPoly5;
        }
        int coefficient = one.getCoefficient(0);
        if (coefficient == 0) {
            throw ChecksumException.getChecksumInstance();
        }
        int inverse2 = this.field.inverse(coefficient);
        return new ModulusPoly[]{one.multiply(inverse2), modulusPoly.multiply(inverse2)};
    }

    private int[] findErrorLocations(ModulusPoly modulusPoly) throws ChecksumException {
        int degree = modulusPoly.getDegree();
        int[] iArr = new int[degree];
        int i = 0;
        for (int i2 = 1; i2 < this.field.getSize() && i < degree; i2++) {
            if (modulusPoly.evaluateAt(i2) == 0) {
                iArr[i] = this.field.inverse(i2);
                i++;
            }
        }
        if (i != degree) {
            throw ChecksumException.getChecksumInstance();
        }
        return iArr;
    }

    private int[] findErrorMagnitudes(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int[] iArr) {
        int degree = modulusPoly2.getDegree();
        int[] iArr2 = new int[degree];
        for (int i = 1; i <= degree; i++) {
            iArr2[degree - i] = this.field.multiply(i, modulusPoly2.getCoefficient(i));
        }
        ModulusPoly modulusPoly3 = new ModulusPoly(this.field, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int inverse = this.field.inverse(iArr[i2]);
            iArr3[i2] = this.field.multiply(this.field.subtract(0, modulusPoly.evaluateAt(inverse)), this.field.inverse(modulusPoly3.evaluateAt(inverse)));
        }
        return iArr3;
    }
}
