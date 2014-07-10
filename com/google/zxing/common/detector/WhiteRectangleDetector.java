package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes.dex */
public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 30;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        this.width = bitMatrix.getWidth();
        this.leftInit = (this.width - 30) >> 1;
        this.rightInit = (this.width + 30) >> 1;
        this.upInit = (this.height - 30) >> 1;
        this.downInit = (this.height + 30) >> 1;
        if (this.upInit < 0 || this.leftInit < 0 || this.downInit >= this.height || this.rightInit >= this.width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        this.width = bitMatrix.getWidth();
        int i4 = i >> 1;
        this.leftInit = i2 - i4;
        this.rightInit = i2 + i4;
        this.upInit = i3 - i4;
        this.downInit = i4 + i3;
        if (this.upInit < 0 || this.leftInit < 0 || this.downInit >= this.height || this.rightInit >= this.width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public ResultPoint[] detect() {
        int i;
        int i2;
        int i3;
        int i4;
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        boolean z = false;
        int i5 = this.leftInit;
        int i6 = this.rightInit;
        int i7 = this.upInit;
        int i8 = this.downInit;
        boolean z2 = false;
        boolean z3 = true;
        while (true) {
            if (!z3) {
                i = i7;
                i2 = i6;
                i3 = i5;
                i4 = i8;
                break;
            }
            boolean z4 = true;
            boolean z5 = false;
            while (z4 && i6 < this.width) {
                z4 = containsBlackPoint(i7, i8, i6, false);
                if (z4) {
                    i6++;
                    z5 = true;
                }
            }
            if (i6 >= this.width) {
                z = true;
                i = i7;
                i2 = i6;
                i3 = i5;
                i4 = i8;
                break;
            }
            boolean z6 = true;
            while (z6 && i8 < this.height) {
                z6 = containsBlackPoint(i5, i6, i8, true);
                if (z6) {
                    i8++;
                    z5 = true;
                }
            }
            if (i8 >= this.height) {
                z = true;
                i = i7;
                i2 = i6;
                i3 = i5;
                i4 = i8;
                break;
            }
            boolean z7 = true;
            while (z7 && i5 >= 0) {
                z7 = containsBlackPoint(i7, i8, i5, false);
                if (z7) {
                    i5--;
                    z5 = true;
                }
            }
            if (i5 < 0) {
                z = true;
                i = i7;
                i2 = i6;
                i3 = i5;
                i4 = i8;
                break;
            }
            z3 = z5;
            boolean z8 = true;
            while (z8 && i7 >= 0) {
                z8 = containsBlackPoint(i5, i6, i7, true);
                if (z8) {
                    i7--;
                    z3 = true;
                }
            }
            if (i7 < 0) {
                z = true;
                i = i7;
                i2 = i6;
                i3 = i5;
                i4 = i8;
                break;
            } else if (z3) {
                z2 = true;
            }
        }
        if (!z && z2) {
            int i9 = i2 - i3;
            int i10 = 1;
            ResultPoint resultPoint3 = null;
            while (true) {
                if (i10 >= i9) {
                    resultPoint = resultPoint3;
                    break;
                }
                resultPoint3 = getBlackPointOnSegment(i3, i4 - i10, i3 + i10, i4);
                if (resultPoint3 != null) {
                    resultPoint = resultPoint3;
                    break;
                }
                i10++;
            }
            if (resultPoint == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i11 = 1;
            ResultPoint resultPoint4 = null;
            while (true) {
                if (i11 >= i9) {
                    resultPoint2 = resultPoint4;
                    break;
                }
                resultPoint4 = getBlackPointOnSegment(i3, i + i11, i3 + i11, i);
                if (resultPoint4 != null) {
                    resultPoint2 = resultPoint4;
                    break;
                }
                i11++;
            }
            if (resultPoint2 == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            ResultPoint resultPoint5 = null;
            for (int i12 = 1; i12 < i9; i12++) {
                resultPoint5 = getBlackPointOnSegment(i2, i + i12, i2 - i12, i);
                if (resultPoint5 != null) {
                    break;
                }
            }
            if (resultPoint5 == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            ResultPoint resultPoint6 = null;
            for (int i13 = 1; i13 < i9; i13++) {
                resultPoint6 = getBlackPointOnSegment(i2, i4 - i13, i2 - i13, i4);
                if (resultPoint6 != null) {
                    break;
                }
            }
            if (resultPoint6 == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            return centerEdges(resultPoint6, resultPoint, resultPoint5, resultPoint2);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private ResultPoint getBlackPointOnSegment(float f, float f2, float f3, float f4) {
        int round = MathUtils.round(MathUtils.distance(f, f2, f3, f4));
        float f5 = (f3 - f) / round;
        float f6 = (f4 - f2) / round;
        for (int i = 0; i < round; i++) {
            int round2 = MathUtils.round((i * f5) + f);
            int round3 = MathUtils.round((i * f6) + f2);
            if (this.image.get(round2, round3)) {
                return new ResultPoint(round2, round3);
            }
        }
        return null;
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        return x < ((float) this.width) / 2.0f ? new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)} : new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
    }

    private boolean containsBlackPoint(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.image.get(i, i3)) {
                    return true;
                }
                i++;
            }
        } else {
            while (i <= i2) {
                if (this.image.get(i3, i)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
