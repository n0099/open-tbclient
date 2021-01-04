package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;
/* loaded from: classes6.dex */
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
                for (int i3 : iArr2) {
                    one = one.multiply(new ModulusPoly(this.field, new int[]{this.field.subtract(0, this.field.exp((iArr.length - 1) - i3)), 1}));
                }
            }
            ModulusPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new ModulusPoly(this.field, iArr3), i);
            ModulusPoly modulusPoly2 = runEuclideanAlgorithm[0];
            ModulusPoly modulusPoly3 = runEuclideanAlgorithm[1];
            int[] findErrorLocations = findErrorLocations(modulusPoly2);
            int[] findErrorMagnitudes = findErrorMagnitudes(modulusPoly3, modulusPoly2, findErrorLocations);
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
        ModulusPoly modulusPoly3;
        ModulusPoly modulusPoly4;
        if (modulusPoly.getDegree() < modulusPoly2.getDegree()) {
            modulusPoly3 = modulusPoly;
            modulusPoly4 = modulusPoly2;
        } else {
            modulusPoly3 = modulusPoly2;
            modulusPoly4 = modulusPoly;
        }
        ModulusPoly zero = this.field.getZero();
        ModulusPoly one = this.field.getOne();
        ModulusPoly modulusPoly5 = modulusPoly3;
        ModulusPoly modulusPoly6 = modulusPoly4;
        while (modulusPoly5.getDegree() >= i / 2) {
            if (modulusPoly5.isZero()) {
                throw ChecksumException.getChecksumInstance();
            }
            ModulusPoly zero2 = this.field.getZero();
            int inverse = this.field.inverse(modulusPoly5.getCoefficient(modulusPoly5.getDegree()));
            ModulusPoly modulusPoly7 = modulusPoly6;
            while (modulusPoly7.getDegree() >= modulusPoly5.getDegree() && !modulusPoly7.isZero()) {
                int degree = modulusPoly7.getDegree() - modulusPoly5.getDegree();
                int multiply = this.field.multiply(modulusPoly7.getCoefficient(modulusPoly7.getDegree()), inverse);
                zero2 = zero2.add(this.field.buildMonomial(degree, multiply));
                modulusPoly7 = modulusPoly7.subtract(modulusPoly5.multiplyByMonomial(degree, multiply));
            }
            zero = one;
            modulusPoly6 = modulusPoly5;
            modulusPoly5 = modulusPoly7;
            one = zero2.multiply(one).subtract(zero).negative();
        }
        int coefficient = one.getCoefficient(0);
        if (coefficient == 0) {
            throw ChecksumException.getChecksumInstance();
        }
        int inverse2 = this.field.inverse(coefficient);
        return new ModulusPoly[]{one.multiply(inverse2), modulusPoly5.multiply(inverse2)};
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
