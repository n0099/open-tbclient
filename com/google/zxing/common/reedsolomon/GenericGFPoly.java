package com.google.zxing.common.reedsolomon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class GenericGFPoly {
    private final int[] coefficients;
    private final GenericGF field;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GenericGFPoly(GenericGF genericGF, int[] iArr) {
        int i = 1;
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.field = genericGF;
        int length = iArr.length;
        if (length > 1 && iArr[0] == 0) {
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.coefficients = genericGF.getZero().coefficients;
                return;
            }
            this.coefficients = new int[length - i];
            System.arraycopy(iArr, i, this.coefficients, 0, this.coefficients.length);
            return;
        }
        this.coefficients = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int[] getCoefficients() {
        return this.coefficients;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getDegree() {
        return this.coefficients.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isZero() {
        return this.coefficients[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getCoefficient(int i) {
        return this.coefficients[(this.coefficients.length - 1) - i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int evaluateAt(int i) {
        if (i == 0) {
            return getCoefficient(0);
        }
        int length = this.coefficients.length;
        if (i == 1) {
            int i2 = 0;
            for (int i3 : this.coefficients) {
                i2 = GenericGF.addOrSubtract(i2, i3);
            }
            return i2;
        }
        int i4 = this.coefficients[0];
        int i5 = 1;
        while (i5 < length) {
            int addOrSubtract = GenericGF.addOrSubtract(this.field.multiply(i, i4), this.coefficients[i5]);
            i5++;
            i4 = addOrSubtract;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GenericGFPoly addOrSubtract(GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (!isZero()) {
            if (genericGFPoly.isZero()) {
                return this;
            }
            int[] iArr = this.coefficients;
            int[] iArr2 = genericGFPoly.coefficients;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr3[i] = GenericGF.addOrSubtract(iArr2[i - length], iArr[i]);
            }
            return new GenericGFPoly(this.field, iArr3);
        }
        return genericGFPoly;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GenericGFPoly multiply(GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (isZero() || genericGFPoly.isZero()) {
            return this.field.getZero();
        }
        int[] iArr = this.coefficients;
        int length = iArr.length;
        int[] iArr2 = genericGFPoly.coefficients;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                iArr3[i + i3] = GenericGF.addOrSubtract(iArr3[i + i3], this.field.multiply(i2, iArr2[i3]));
            }
        }
        return new GenericGFPoly(this.field, iArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GenericGFPoly multiply(int i) {
        if (i == 0) {
            return this.field.getZero();
        }
        if (i != 1) {
            int length = this.coefficients.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = this.field.multiply(this.coefficients[i2], i);
            }
            return new GenericGFPoly(this.field, iArr);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GenericGFPoly multiplyByMonomial(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.field.getZero();
        }
        int length = this.coefficients.length;
        int[] iArr = new int[length + i];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.field.multiply(this.coefficients[i3], i2);
        }
        return new GenericGFPoly(this.field, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GenericGFPoly[] divide(GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (genericGFPoly.isZero()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        GenericGFPoly zero = this.field.getZero();
        int inverse = this.field.inverse(genericGFPoly.getCoefficient(genericGFPoly.getDegree()));
        GenericGFPoly genericGFPoly2 = zero;
        GenericGFPoly genericGFPoly3 = this;
        while (genericGFPoly3.getDegree() >= genericGFPoly.getDegree() && !genericGFPoly3.isZero()) {
            int degree = genericGFPoly3.getDegree() - genericGFPoly.getDegree();
            int multiply = this.field.multiply(genericGFPoly3.getCoefficient(genericGFPoly3.getDegree()), inverse);
            GenericGFPoly multiplyByMonomial = genericGFPoly.multiplyByMonomial(degree, multiply);
            genericGFPoly2 = genericGFPoly2.addOrSubtract(this.field.buildMonomial(degree, multiply));
            genericGFPoly3 = genericGFPoly3.addOrSubtract(multiplyByMonomial);
        }
        return new GenericGFPoly[]{genericGFPoly2, genericGFPoly3};
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(getDegree() * 8);
        for (int degree = getDegree(); degree >= 0; degree--) {
            int coefficient = getCoefficient(degree);
            if (coefficient != 0) {
                if (coefficient < 0) {
                    sb.append(" - ");
                    coefficient = -coefficient;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (degree == 0 || coefficient != 1) {
                    int log = this.field.log(coefficient);
                    if (log == 0) {
                        sb.append('1');
                    } else if (log == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(log);
                    }
                }
                if (degree != 0) {
                    if (degree == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(degree);
                    }
                }
            }
        }
        return sb.toString();
    }
}
