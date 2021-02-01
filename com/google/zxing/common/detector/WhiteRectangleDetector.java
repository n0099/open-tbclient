package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes4.dex */
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
        boolean z = false;
        int i3 = this.leftInit;
        int i4 = this.rightInit;
        int i5 = this.upInit;
        int i6 = this.downInit;
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
                break;
            }
            boolean z8 = true;
            z7 = false;
            while (true) {
                if ((z8 || !z5) && i4 < this.width) {
                    z8 = containsBlackPoint(i5, i6, i4, false);
                    if (z8) {
                        i4++;
                        z5 = true;
                        z7 = true;
                    } else if (!z5) {
                        i4++;
                    }
                }
            }
            if (i4 >= this.width) {
                z = true;
                i = i6;
                i2 = i5;
                break;
            }
            boolean z9 = true;
            while (true) {
                if ((z9 || !z4) && i6 < this.height) {
                    z9 = containsBlackPoint(i3, i4, i6, true);
                    if (z9) {
                        i6++;
                        z4 = true;
                        z7 = true;
                    } else if (!z4) {
                        i6++;
                    }
                }
            }
            if (i6 >= this.height) {
                z = true;
                i = i6;
                i2 = i5;
                break;
            }
            boolean z10 = true;
            while (true) {
                if ((z10 || !z3) && i3 >= 0) {
                    z10 = containsBlackPoint(i5, i6, i3, false);
                    if (z10) {
                        i3--;
                        z3 = true;
                        z7 = true;
                    } else if (!z3) {
                        i3--;
                    }
                }
            }
            if (i3 < 0) {
                z = true;
                i = i6;
                i2 = i5;
                break;
            }
            boolean z11 = true;
            while (true) {
                if ((z11 || !z2) && i5 >= 0) {
                    z11 = containsBlackPoint(i3, i4, i5, true);
                    if (z11) {
                        i5--;
                        z2 = true;
                        z7 = true;
                    } else if (!z2) {
                        i5--;
                    }
                }
            }
            if (i5 < 0) {
                z = true;
                i = i6;
                i2 = i5;
                break;
            } else if (z7) {
                z6 = true;
            }
        }
        if (!z && z6) {
            int i7 = i4 - i3;
            int i8 = 1;
            ResultPoint resultPoint = null;
            while (resultPoint == null && i8 < i7) {
                i8++;
                resultPoint = getBlackPointOnSegment(i3, i - i8, i3 + i8, i);
            }
            if (resultPoint == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i9 = 1;
            ResultPoint resultPoint2 = null;
            while (resultPoint2 == null && i9 < i7) {
                i9++;
                resultPoint2 = getBlackPointOnSegment(i3, i2 + i9, i3 + i9, i2);
            }
            if (resultPoint2 == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            ResultPoint resultPoint3 = null;
            for (int i10 = 1; resultPoint3 == null && i10 < i7; i10++) {
                resultPoint3 = getBlackPointOnSegment(i4, i2 + i10, i4 - i10, i2);
            }
            if (resultPoint3 == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            ResultPoint resultPoint4 = null;
            for (int i11 = 1; resultPoint4 == null && i11 < i7; i11++) {
                resultPoint4 = getBlackPointOnSegment(i4, i - i11, i4 - i11, i);
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
