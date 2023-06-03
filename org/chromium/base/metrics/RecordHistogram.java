package org.chromium.base.metrics;

import androidx.annotation.VisibleForTesting;
import com.baidu.live.LiveFeedPageSdk;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;
@JNINamespace("base::android")
@MainDex
/* loaded from: classes2.dex */
public class RecordHistogram {

    /* loaded from: classes2.dex */
    public interface Natives {
        int getHistogramTotalCountForTesting(String str);

        int getHistogramValueCountForTesting(String str, int i);
    }

    public static int clampToInt(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    @VisibleForTesting
    public static int getHistogramTotalCountForTesting(String str) {
        return RecordHistogramJni.get().getHistogramTotalCountForTesting(str);
    }

    @VisibleForTesting
    public static int getHistogramValueCountForTesting(String str, int i) {
        return RecordHistogramJni.get().getHistogramValueCountForTesting(str, i);
    }

    public static void recordBooleanHistogram(String str, boolean z) {
        UmaRecorderHolder.get().recordBooleanHistogram(str, z);
    }

    public static void recordCount100000Histogram(String str, int i) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, i, 1, DefaultOggSeeker.MATCH_BYTE_RANGE, 50);
    }

    public static void recordCount1000Histogram(String str, int i) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, i, 1, 1000, 50);
    }

    public static void recordCount100Histogram(String str, int i) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, i, 1, 100, 50);
    }

    public static void recordCountHistogram(String str, int i) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, i, 1, 1000000, 50);
    }

    public static void recordLongTimesHistogram(String str, long j) {
        recordCustomTimesHistogramMilliseconds(str, j, 1L, 3600000L, 50);
    }

    public static void recordLongTimesHistogram100(String str, long j) {
        recordCustomTimesHistogramMilliseconds(str, j, 1L, 3600000L, 100);
    }

    public static void recordMediumTimesHistogram(String str, long j) {
        recordCustomTimesHistogramMilliseconds(str, j, 10L, LiveFeedPageSdk.REFRESH_TIME, 50);
    }

    public static void recordMemoryKBHistogram(String str, int i) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, i, 1000, 500000, 50);
    }

    public static void recordPercentageHistogram(String str, int i) {
        recordExactLinearHistogram(str, i, 101);
    }

    public static void recordSparseHistogram(String str, int i) {
        UmaRecorderHolder.get().recordSparseHistogram(str, i);
    }

    public static void recordTimesHistogram(String str, long j) {
        recordCustomTimesHistogramMilliseconds(str, j, 1L, 10000L, 50);
    }

    public static void recordCustomCountHistogram(String str, int i, int i2, int i3, int i4) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, i, i2, i3, i4);
    }

    public static void recordCustomTimesHistogram(String str, long j, long j2, long j3, int i) {
        recordCustomTimesHistogramMilliseconds(str, j, j2, j3, i);
    }

    public static void recordCustomTimesHistogramMilliseconds(String str, long j, long j2, long j3, int i) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, clampToInt(j), clampToInt(j2), clampToInt(j3), i);
    }

    public static void recordLinearCountHistogram(String str, int i, int i2, int i3, int i4) {
        UmaRecorderHolder.get().recordLinearHistogram(str, i, i2, i3, i4);
    }

    public static void recordEnumeratedHistogram(String str, int i, int i2) {
        recordExactLinearHistogram(str, i, i2);
    }

    public static void recordExactLinearHistogram(String str, int i, int i2) {
        UmaRecorderHolder.get().recordLinearHistogram(str, i, 1, i2, i2 + 1);
    }
}
