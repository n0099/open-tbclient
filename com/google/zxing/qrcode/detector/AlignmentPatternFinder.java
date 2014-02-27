package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
final class AlignmentPatternFinder {
    private final int height;
    private final BitMatrix image;
    private final float moduleSize;
    private final ResultPointCallback resultPointCallback;
    private final int startX;
    private final int startY;
    private final int width;
    private final List<AlignmentPattern> possibleCenters = new ArrayList(5);
    private final int[] crossCheckStateCount = new int[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlignmentPatternFinder(BitMatrix bitMatrix, int i, int i2, int i3, int i4, float f, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.startX = i;
        this.startY = i2;
        this.width = i3;
        this.height = i4;
        this.moduleSize = f;
        this.resultPointCallback = resultPointCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final AlignmentPattern find() {
        AlignmentPattern handlePossibleCenter;
        AlignmentPattern handlePossibleCenter2;
        int i = this.startX;
        int i2 = this.height;
        int i3 = i + this.width;
        int i4 = this.startY + (i2 >> 1);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i4 + ((i5 & 1) == 0 ? (i5 + 1) >> 1 : -((i5 + 1) >> 1));
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.image.get(i7, i6)) {
                i7++;
            }
            int i8 = 0;
            for (int i9 = i7; i9 < i3; i9++) {
                if (this.image.get(i9, i6)) {
                    if (i8 != 1) {
                        if (i8 == 2) {
                            if (foundPatternCross(iArr) && (handlePossibleCenter2 = handlePossibleCenter(iArr, i6, i9)) != null) {
                                return handlePossibleCenter2;
                            }
                            iArr[0] = iArr[2];
                            iArr[1] = 1;
                            iArr[2] = 0;
                            i8 = 1;
                        } else {
                            i8++;
                            iArr[i8] = iArr[i8] + 1;
                        }
                    }
                } else if (i8 == 1) {
                    i8++;
                }
                iArr[i8] = iArr[i8] + 1;
            }
            if (foundPatternCross(iArr) && (handlePossibleCenter = handlePossibleCenter(iArr, i6, i3)) != null) {
                return handlePossibleCenter;
            }
        }
        if (!this.possibleCenters.isEmpty()) {
            return this.possibleCenters.get(0);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    private boolean foundPatternCross(int[] iArr) {
        float f = this.moduleSize;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (r4[1] <= r12) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
        r4[0] = r4[0] + 1;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
        if (r1 < 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (r2.get(r11, r1) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r4[0] <= r12) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r4[0] > r12) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
        r1 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r1 >= r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (r2.get(r11, r1) == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (r4[1] <= r12) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
        if (r1 == r3) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        if (r4[1] > r12) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r1 >= r3) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (r2.get(r11, r1) != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
        if (r4[2] <= r12) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
        if (r4[2] > r12) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007d, code lost:
        if ((java.lang.Math.abs(((r4[0] + r4[1]) + r4[2]) - r13) * 5) >= (r13 * 2)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0083, code lost:
        if (foundPatternCross(r4) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008a, code lost:
        r4[1] = r4[1] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0093, code lost:
        r4[2] = r4[2] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
        return centerFromEnd(r4, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float crossCheckVertical(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] iArr = this.crossCheckStateCount;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5--;
        }
        return Float.NaN;
    }

    private AlignmentPattern handlePossibleCenter(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float centerFromEnd = centerFromEnd(iArr, i2);
        float crossCheckVertical = crossCheckVertical(i, (int) centerFromEnd, iArr[1] * 2, i3);
        if (!Float.isNaN(crossCheckVertical)) {
            float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
            for (AlignmentPattern alignmentPattern : this.possibleCenters) {
                if (alignmentPattern.aboutEquals(f, crossCheckVertical, centerFromEnd)) {
                    return alignmentPattern.combineEstimate(crossCheckVertical, centerFromEnd, f);
                }
            }
            AlignmentPattern alignmentPattern2 = new AlignmentPattern(centerFromEnd, crossCheckVertical, f);
            this.possibleCenters.add(alignmentPattern2);
            if (this.resultPointCallback != null) {
                this.resultPointCallback.foundPossibleResultPoint(alignmentPattern2);
            }
        }
        return null;
    }
}
