package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class AlignmentPatternFinder {
    public final int height;
    public final BitMatrix image;
    public final float moduleSize;
    public final ResultPointCallback resultPointCallback;
    public final int startX;
    public final int startY;
    public final int width;
    public final List<AlignmentPattern> possibleCenters = new ArrayList(5);
    public final int[] crossCheckStateCount = new int[3];

    public AlignmentPatternFinder(BitMatrix bitMatrix, int i2, int i3, int i4, int i5, float f2, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.startX = i2;
        this.startY = i3;
        this.width = i4;
        this.height = i5;
        this.moduleSize = f2;
        this.resultPointCallback = resultPointCallback;
    }

    public static float centerFromEnd(int[] iArr, int i2) {
        return (i2 - iArr[2]) - (iArr[1] / 2.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (r2[1] <= r12) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
        if (r10 >= r1) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
        if (r0.get(r11, r10) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
        if (r2[2] > r12) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0071, code lost:
        r2[2] = r2[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007b, code lost:
        if (r2[2] <= r12) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007d, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008f, code lost:
        if ((java.lang.Math.abs(((r2[0] + r2[1]) + r2[2]) - r13) * 5) < (r13 * 2)) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0096, code lost:
        if (foundPatternCross(r2) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009c, code lost:
        return centerFromEnd(r2, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float crossCheckVertical(int i2, int i3, int i4, int i5) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] iArr = this.crossCheckStateCount;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i6 = i2;
        while (i6 >= 0 && bitMatrix.get(i3, i6) && iArr[1] <= i4) {
            iArr[1] = iArr[1] + 1;
            i6--;
        }
        if (i6 >= 0 && iArr[1] <= i4) {
            while (i6 >= 0 && !bitMatrix.get(i3, i6) && iArr[0] <= i4) {
                iArr[0] = iArr[0] + 1;
                i6--;
            }
            if (iArr[0] > i4) {
                return Float.NaN;
            }
            int i7 = i2 + 1;
            while (i7 < height && bitMatrix.get(i3, i7) && iArr[1] <= i4) {
                iArr[1] = iArr[1] + 1;
                i7++;
            }
        }
        return Float.NaN;
    }

    private boolean foundPatternCross(int[] iArr) {
        float f2 = this.moduleSize;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - iArr[i2]) >= f3) {
                return false;
            }
        }
        return true;
    }

    private AlignmentPattern handlePossibleCenter(int[] iArr, int i2, int i3) {
        int i4 = iArr[0] + iArr[1] + iArr[2];
        float centerFromEnd = centerFromEnd(iArr, i3);
        float crossCheckVertical = crossCheckVertical(i2, (int) centerFromEnd, iArr[1] * 2, i4);
        if (Float.isNaN(crossCheckVertical)) {
            return null;
        }
        float f2 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (AlignmentPattern alignmentPattern : this.possibleCenters) {
            if (alignmentPattern.aboutEquals(f2, crossCheckVertical, centerFromEnd)) {
                return alignmentPattern.combineEstimate(crossCheckVertical, centerFromEnd, f2);
            }
        }
        AlignmentPattern alignmentPattern2 = new AlignmentPattern(centerFromEnd, crossCheckVertical, f2);
        this.possibleCenters.add(alignmentPattern2);
        ResultPointCallback resultPointCallback = this.resultPointCallback;
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(alignmentPattern2);
            return null;
        }
        return null;
    }

    public AlignmentPattern find() throws NotFoundException {
        AlignmentPattern handlePossibleCenter;
        AlignmentPattern handlePossibleCenter2;
        int i2 = this.startX;
        int i3 = this.height;
        int i4 = this.width + i2;
        int i5 = this.startY + (i3 / 2);
        int[] iArr = new int[3];
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i5;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i8 = i2;
            while (i8 < i4 && !this.image.get(i8, i7)) {
                i8++;
            }
            int i9 = 0;
            while (i8 < i4) {
                if (!this.image.get(i8, i7)) {
                    if (i9 == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i9 == 2) {
                    if (foundPatternCross(iArr) && (handlePossibleCenter2 = handlePossibleCenter(iArr, i7, i8)) != null) {
                        return handlePossibleCenter2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i9 = 1;
                } else {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                }
                i8++;
            }
            if (foundPatternCross(iArr) && (handlePossibleCenter = handlePossibleCenter(iArr, i7, i4)) != null) {
                return handlePossibleCenter;
            }
        }
        if (!this.possibleCenters.isEmpty()) {
            return this.possibleCenters.get(0);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
