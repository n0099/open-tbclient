package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    private static final int INTEGER_MATH_SHIFT = 8;
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }

    protected final BitMatrix getImage() {
        return this.image;
    }

    protected final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final FinderPatternInfo find(Map<DecodeHintType, ?> map) {
        int i;
        int i2;
        boolean z;
        boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i3 = (height * 3) / 228;
        int i4 = (i3 < 3 || z2) ? 3 : i3;
        boolean z3 = false;
        int[] iArr = new int[5];
        int i5 = i4 - 1;
        int i6 = i4;
        while (i5 < height && !z3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i7 = 0;
            int i8 = 0;
            while (i8 < width) {
                if (this.image.get(i8, i5)) {
                    if ((i7 & 1) == 1) {
                        i7++;
                    }
                    iArr[i7] = iArr[i7] + 1;
                } else if ((i7 & 1) == 0) {
                    if (i7 == 4) {
                        if (foundPatternCross(iArr)) {
                            if (handlePossibleCenter(iArr, i5, i8)) {
                                i6 = 2;
                                if (this.hasSkipped) {
                                    int i9 = i8;
                                    i2 = i5;
                                    z = haveMultiplyConfirmedCenters();
                                    i = i9;
                                } else {
                                    int findRowSkip = findRowSkip();
                                    if (findRowSkip > iArr[2]) {
                                        i2 = i5 + ((findRowSkip - iArr[2]) - 2);
                                        i = width - 1;
                                        z = z3;
                                    } else {
                                        i = i8;
                                        i2 = i5;
                                        z = z3;
                                    }
                                }
                                iArr[0] = 0;
                                iArr[1] = 0;
                                iArr[2] = 0;
                                iArr[3] = 0;
                                iArr[4] = 0;
                                int i10 = i;
                                i7 = 0;
                                z3 = z;
                                i5 = i2;
                                i8 = i10;
                            } else {
                                iArr[0] = iArr[2];
                                iArr[1] = iArr[3];
                                iArr[2] = iArr[4];
                                iArr[3] = 1;
                                iArr[4] = 0;
                                i7 = 3;
                            }
                        } else {
                            iArr[0] = iArr[2];
                            iArr[1] = iArr[3];
                            iArr[2] = iArr[4];
                            iArr[3] = 1;
                            iArr[4] = 0;
                            i7 = 3;
                        }
                    } else {
                        i7++;
                        iArr[i7] = iArr[i7] + 1;
                    }
                } else {
                    iArr[i7] = iArr[i7] + 1;
                }
                i8++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i5, width)) {
                i6 = iArr[0];
                if (this.hasSkipped) {
                    z3 = haveMultiplyConfirmedCenters();
                }
            }
            i5 += i6;
        }
        FinderPattern[] selectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    protected static boolean foundPatternCross(int[] iArr) {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 5; i4++) {
            int i5 = iArr[i4];
            if (i5 == 0) {
                return false;
            }
            i3 += i5;
        }
        return i3 >= 7 && Math.abs(i - (iArr[0] << 8)) < (i2 = (i = (i3 << 8) / 7) / 2) && Math.abs(i - (iArr[1] << 8)) < i2 && Math.abs((i * 3) - (iArr[2] << 8)) < i2 * 3 && Math.abs(i - (iArr[3] << 8)) < i2 && Math.abs(i - (iArr[4] << 8)) < i2;
    }

    private int[] getCrossCheckStateCount() {
        this.crossCheckStateCount[0] = 0;
        this.crossCheckStateCount[1] = 0;
        this.crossCheckStateCount[2] = 0;
        this.crossCheckStateCount[3] = 0;
        this.crossCheckStateCount[4] = 0;
        return this.crossCheckStateCount;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r4[1] > r14) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r1 < 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r2.get(r13, r1) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r4[0] <= r14) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        if (r4[0] > r14) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
        r1 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
        if (r1 >= r3) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r2.get(r13, r1) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        if (r1 == r3) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r1 >= r3) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (r2.get(r13, r1) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
        if (r4[3] < r14) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        if (r1 == r3) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
        if (r4[3] >= r14) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
        if (r1 >= r3) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0074, code lost:
        if (r2.get(r13, r1) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0078, code lost:
        if (r4[4] < r14) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007c, code lost:
        if (r4[4] >= r14) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0096, code lost:
        if ((java.lang.Math.abs(((((r4[0] + r4[1]) + r4[2]) + r4[3]) + r4[4]) - r15) * 5) >= (r15 * 2)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009c, code lost:
        if (foundPatternCross(r4) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a4, code lost:
        r4[0] = r4[0] + 1;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ad, code lost:
        r4[2] = r4[2] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b7, code lost:
        r4[3] = r4[3] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c0, code lost:
        r4[4] = r4[4] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
        return centerFromEnd(r4, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float crossCheckVertical(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i2, i5)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i2, i5) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        return Float.NaN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r4[1] > r14) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r1 < 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r2.get(r1, r13) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r4[0] <= r14) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        if (r4[0] > r14) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
        r1 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
        if (r1 >= r3) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r2.get(r1, r13) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        if (r1 == r3) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r1 >= r3) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (r2.get(r1, r13) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
        if (r4[3] < r14) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        if (r1 == r3) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
        if (r4[3] >= r14) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
        if (r1 >= r3) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0074, code lost:
        if (r2.get(r1, r13) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0078, code lost:
        if (r4[4] < r14) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007c, code lost:
        if (r4[4] >= r14) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0094, code lost:
        if ((java.lang.Math.abs(((((r4[0] + r4[1]) + r4[2]) + r4[3]) + r4[4]) - r15) * 5) >= r15) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009a, code lost:
        if (foundPatternCross(r4) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
        r4[0] = r4[0] + 1;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ab, code lost:
        r4[2] = r4[2] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b5, code lost:
        r4[3] = r4[3] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00be, code lost:
        r4[4] = r4[4] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
        return centerFromEnd(r4, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float crossCheckHorizontal(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i5, i2)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i5, i2) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        return Float.NaN;
    }

    protected final boolean handlePossibleCenter(int[] iArr, int i, int i2) {
        boolean z = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        float centerFromEnd = centerFromEnd(iArr, i2);
        float crossCheckVertical = crossCheckVertical(i, (int) centerFromEnd, iArr[2], i3);
        if (Float.isNaN(crossCheckVertical)) {
            return false;
        }
        float crossCheckHorizontal = crossCheckHorizontal((int) centerFromEnd, (int) crossCheckVertical, iArr[2], i3);
        if (Float.isNaN(crossCheckHorizontal)) {
            return false;
        }
        float f = i3 / 7.0f;
        int i4 = 0;
        while (true) {
            if (i4 >= this.possibleCenters.size()) {
                break;
            }
            FinderPattern finderPattern = this.possibleCenters.get(i4);
            if (!finderPattern.aboutEquals(f, crossCheckVertical, crossCheckHorizontal)) {
                i4++;
            } else {
                this.possibleCenters.set(i4, finderPattern.combineEstimate(crossCheckVertical, crossCheckHorizontal, f));
                z = true;
                break;
            }
        }
        if (!z) {
            FinderPattern finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, f);
            this.possibleCenters.add(finderPattern2);
            if (this.resultPointCallback != null) {
                this.resultPointCallback.foundPossibleResultPoint(finderPattern2);
            }
        }
        return true;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern != null) {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
                finderPattern = finderPattern2;
            }
        }
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        float f = 0.0f;
        int size = this.possibleCenters.size();
        float f2 = 0.0f;
        int i = 0;
        for (FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                i++;
                f2 = finderPattern.getEstimatedModuleSize() + f2;
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / size;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            f += Math.abs(finderPattern2.getEstimatedModuleSize() - f3);
        }
        return f <= 0.05f * f2;
    }

    private FinderPattern[] selectBestPatterns() {
        float f = 0.0f;
        int size = this.possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (size > 3) {
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (FinderPattern finderPattern : this.possibleCenters) {
                float estimatedModuleSize = finderPattern.getEstimatedModuleSize();
                f3 += estimatedModuleSize;
                f2 = (estimatedModuleSize * estimatedModuleSize) + f2;
            }
            float f4 = f3 / size;
            Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f4, null));
            float max = Math.max(0.2f * f4, (float) Math.sqrt((f2 / size) - (f4 * f4)));
            int i = 0;
            while (i < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                if (Math.abs(this.possibleCenters.get(i).getEstimatedModuleSize() - f4) > max) {
                    this.possibleCenters.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.possibleCenters.size() > 3) {
            for (FinderPattern finderPattern2 : this.possibleCenters) {
                f += finderPattern2.getEstimatedModuleSize();
            }
            Collections.sort(this.possibleCenters, new CenterComparator(f / this.possibleCenters.size(), null));
            this.possibleCenters.subList(3, this.possibleCenters.size()).clear();
        }
        return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private FurthestFromAverageComparator(float f) {
            this.average = f;
        }

        /* synthetic */ FurthestFromAverageComparator(float f, FurthestFromAverageComparator furthestFromAverageComparator) {
            this(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private CenterComparator(float f) {
            this.average = f;
        }

        /* synthetic */ CenterComparator(float f, CenterComparator centerComparator) {
            this(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            if (finderPattern2.getCount() == finderPattern.getCount()) {
                float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
                float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
                if (abs < abs2) {
                    return 1;
                }
                return abs == abs2 ? 0 : -1;
            }
            return finderPattern2.getCount() - finderPattern.getCount();
        }
    }
}
