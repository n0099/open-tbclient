package com.google.zxing.oned.rss;

import android.support.v7.widget.ActivityChooserView;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;
/* loaded from: classes3.dex */
public abstract class AbstractRSSReader extends OneDReader {
    private static final float MAX_AVG_VARIANCE = 0.2f;
    private static final float MAX_FINDER_PATTERN_RATIO = 0.89285713f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.45f;
    private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667f;
    private final int[] decodeFinderCounters = new int[4];
    private final int[] dataCharacterCounters = new int[8];
    private final float[] oddRoundingErrors = new float[4];
    private final float[] evenRoundingErrors = new float[4];
    private final int[] oddCounts = new int[this.dataCharacterCounters.length / 2];
    private final int[] evenCounts = new int[this.dataCharacterCounters.length / 2];

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] getDecodeFinderCounters() {
        return this.decodeFinderCounters;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] getDataCharacterCounters() {
        return this.dataCharacterCounters;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float[] getOddRoundingErrors() {
        return this.oddRoundingErrors;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float[] getEvenRoundingErrors() {
        return this.evenRoundingErrors;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] getOddCounts() {
        return this.oddCounts;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] getEvenCounts() {
        return this.evenCounts;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int parseFinderValue(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i = 0; i < iArr2.length; i++) {
            if (patternMatchVariance(iArr, iArr2[i], MAX_INDIVIDUAL_VARIANCE) < 0.2f) {
                return i;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Deprecated
    protected static int count(int[] iArr) {
        return MathUtils.sum(iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void increment(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void decrement(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isFinderPattern(int[] iArr) {
        int i;
        float f = (iArr[0] + iArr[1]) / ((iArr[2] + i) + iArr[3]);
        if (f < MIN_FINDER_PATTERN_RATIO || f > MAX_FINDER_PATTERN_RATIO) {
            return false;
        }
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = Integer.MIN_VALUE;
        int length = iArr.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = iArr[i4];
            if (i5 > i3) {
                i3 = i5;
            }
            if (i5 >= i2) {
                i5 = i2;
            }
            i4++;
            i2 = i5;
        }
        return i3 < i2 * 10;
    }
}
