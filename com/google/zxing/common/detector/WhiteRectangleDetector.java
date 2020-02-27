package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes10.dex */
public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) throws NotFoundException {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        this.width = bitMatrix.getWidth();
        int i4 = i / 2;
        this.leftInit = i2 - i4;
        this.rightInit = i2 + i4;
        this.upInit = i3 - i4;
        this.downInit = i4 + i3;
        if (this.upInit < 0 || this.leftInit < 0 || this.downInit >= this.height || this.rightInit >= this.width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = false;
        int i5 = this.leftInit;
        int i6 = this.rightInit;
        int i7 = this.upInit;
        int i8 = this.downInit;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = true;
        while (true) {
            if (!z7) {
                i = i6;
                i2 = i5;
                i3 = i8;
                i4 = i7;
                break;
            }
            boolean z8 = true;
            boolean z9 = z5;
            boolean z10 = false;
            while (true) {
                if ((z8 || !z9) && i6 < this.width) {
                    z8 = containsBlackPoint(i7, i8, i6, false);
                    if (z8) {
                        i6++;
                        z9 = true;
                        z10 = true;
                    } else if (!z9) {
                        i6++;
                    }
                }
            }
            if (i6 >= this.width) {
                z = true;
                i = i6;
                i2 = i5;
                i3 = i8;
                i4 = i7;
                break;
            }
            boolean z11 = z4;
            boolean z12 = z10;
            boolean z13 = true;
            while (true) {
                if ((z13 || !z11) && i8 < this.height) {
                    z13 = containsBlackPoint(i5, i6, i8, true);
                    if (z13) {
                        i8++;
                        z11 = true;
                        z12 = true;
                    } else if (!z11) {
                        i8++;
                    }
                }
            }
            if (i8 >= this.height) {
                z = true;
                i = i6;
                i2 = i5;
                i3 = i8;
                i4 = i7;
                break;
            }
            boolean z14 = z3;
            boolean z15 = z12;
            boolean z16 = true;
            while (true) {
                if ((z16 || !z14) && i5 >= 0) {
                    z16 = containsBlackPoint(i7, i8, i5, false);
                    if (z16) {
                        i5--;
                        z14 = true;
                        z15 = true;
                    } else if (!z14) {
                        i5--;
                    }
                }
            }
            if (i5 < 0) {
                z = true;
                i = i6;
                i2 = i5;
                i3 = i8;
                i4 = i7;
                break;
            }
            boolean z17 = z15;
            boolean z18 = z2;
            boolean z19 = true;
            while (true) {
                if ((z19 || !z18) && i7 >= 0) {
                    z19 = containsBlackPoint(i5, i6, i7, true);
                    if (z19) {
                        i7--;
                        z18 = true;
                        z17 = true;
                    } else if (!z18) {
                        i7--;
                    }
                }
            }
            if (i7 < 0) {
                z = true;
                i = i6;
                i2 = i5;
                i3 = i8;
                i4 = i7;
                break;
            }
            if (z17) {
                z6 = true;
            }
            z2 = z18;
            z3 = z14;
            z5 = z9;
            boolean z20 = z11;
            z7 = z17;
            z4 = z20;
        }
        if (!z && z6) {
            int i9 = i - i2;
            int i10 = 1;
            ResultPoint resultPoint = null;
            while (resultPoint == null && i10 < i9) {
                i10++;
                resultPoint = getBlackPointOnSegment(i2, i3 - i10, i2 + i10, i3);
            }
            if (resultPoint == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i11 = 1;
            ResultPoint resultPoint2 = null;
            while (resultPoint2 == null && i11 < i9) {
                i11++;
                resultPoint2 = getBlackPointOnSegment(i2, i4 + i11, i2 + i11, i4);
            }
            if (resultPoint2 == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            ResultPoint resultPoint3 = null;
            for (int i12 = 1; resultPoint3 == null && i12 < i9; i12++) {
                resultPoint3 = getBlackPointOnSegment(i, i4 + i12, i - i12, i4);
            }
            if (resultPoint3 == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            ResultPoint resultPoint4 = null;
            for (int i13 = 1; resultPoint4 == null && i13 < i9; i13++) {
                resultPoint4 = getBlackPointOnSegment(i, i3 - i13, i - i13, i3);
            }
            if (resultPoint4 == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            return centerEdges(resultPoint4, resultPoint, resultPoint3, resultPoint2);
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
