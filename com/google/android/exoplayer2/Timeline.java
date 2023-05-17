package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.util.Assertions;
/* loaded from: classes9.dex */
public abstract class Timeline {
    public static final Timeline EMPTY = new Timeline() { // from class: com.google.android.exoplayer2.Timeline.1
        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Period getPeriod(int i, Period period, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Window getWindow(int i, Window window, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }
    };

    public abstract int getIndexOfPeriod(Object obj);

    public abstract Period getPeriod(int i, Period period, boolean z);

    public abstract int getPeriodCount();

    public abstract Window getWindow(int i, Window window, boolean z, long j);

    public abstract int getWindowCount();

    /* loaded from: classes9.dex */
    public static final class Period {
        public int[] adCounts;
        public long[][] adDurationsUs;
        public long[] adGroupTimesUs;
        public long adResumePositionUs;
        public int[] adsLoadedCounts;
        public int[] adsPlayedCounts;
        public long durationUs;
        public Object id;
        public long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        public int getAdGroupCount() {
            long[] jArr = this.adGroupTimesUs;
            if (jArr == null) {
                return 0;
            }
            return jArr.length;
        }

        public long getAdResumePositionUs() {
            return this.adResumePositionUs;
        }

        public long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInWindowMs() {
            return C.usToMs(this.positionInWindowUs);
        }

        public long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public int getAdCountInAdGroup(int i) {
            return this.adCounts[i];
        }

        public int getAdGroupIndexAfterPositionUs(long j) {
            if (this.adGroupTimesUs == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                long[] jArr = this.adGroupTimesUs;
                if (i >= jArr.length || jArr[i] == Long.MIN_VALUE || (j < jArr[i] && !hasPlayedAdGroup(i))) {
                    break;
                }
                i++;
            }
            if (i >= this.adGroupTimesUs.length) {
                return -1;
            }
            return i;
        }

        public int getAdGroupIndexForPositionUs(long j) {
            long[] jArr = this.adGroupTimesUs;
            if (jArr == null) {
                return -1;
            }
            int length = jArr.length - 1;
            while (length >= 0) {
                long[] jArr2 = this.adGroupTimesUs;
                if (jArr2[length] != Long.MIN_VALUE && jArr2[length] <= j) {
                    break;
                }
                length--;
            }
            if (length < 0 || hasPlayedAdGroup(length)) {
                return -1;
            }
            return length;
        }

        public long getAdGroupTimeUs(int i) {
            return this.adGroupTimesUs[i];
        }

        public int getPlayedAdCount(int i) {
            return this.adsPlayedCounts[i];
        }

        public boolean hasPlayedAdGroup(int i) {
            int[] iArr = this.adCounts;
            if (iArr[i] != -1 && this.adsPlayedCounts[i] == iArr[i]) {
                return true;
            }
            return false;
        }

        public long getAdDurationUs(int i, int i2) {
            long[][] jArr = this.adDurationsUs;
            if (i2 >= jArr[i].length) {
                return C.TIME_UNSET;
            }
            return jArr[i][i2];
        }

        public boolean isAdAvailable(int i, int i2) {
            if (i2 < this.adsLoadedCounts[i]) {
                return true;
            }
            return false;
        }

        public Period set(Object obj, Object obj2, int i, long j, long j2) {
            return set(obj, obj2, i, j, j2, null, null, null, null, null, C.TIME_UNSET);
        }

        public Period set(Object obj, Object obj2, int i, long j, long j2, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j3) {
            this.id = obj;
            this.uid = obj2;
            this.windowIndex = i;
            this.durationUs = j;
            this.positionInWindowUs = j2;
            this.adGroupTimesUs = jArr;
            this.adCounts = iArr;
            this.adsLoadedCounts = iArr2;
            this.adsPlayedCounts = iArr3;
            this.adDurationsUs = jArr2;
            this.adResumePositionUs = j3;
            return this;
        }
    }

    /* loaded from: classes9.dex */
    public static final class Window {
        public long defaultPositionUs;
        public long durationUs;
        public int firstPeriodIndex;
        public Object id;
        public boolean isDynamic;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        public long windowStartTimeMs;

        public long getDefaultPositionMs() {
            return C.usToMs(this.defaultPositionUs);
        }

        public long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInFirstPeriodMs() {
            return C.usToMs(this.positionInFirstPeriodUs);
        }

        public long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public Window set(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            this.id = obj;
            this.presentationStartTimeMs = j;
            this.windowStartTimeMs = j2;
            this.isSeekable = z;
            this.isDynamic = z2;
            this.defaultPositionUs = j3;
            this.durationUs = j4;
            this.firstPeriodIndex = i;
            this.lastPeriodIndex = i2;
            this.positionInFirstPeriodUs = j5;
            return this;
        }
    }

    public final boolean isEmpty() {
        if (getWindowCount() == 0) {
            return true;
        }
        return false;
    }

    public int getFirstWindowIndex(boolean z) {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    public int getLastWindowIndex(boolean z) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public final int getNextPeriodIndex(int i, Period period, Window window, int i2, boolean z) {
        int i3 = getPeriod(i, period).windowIndex;
        if (getWindow(i3, window).lastPeriodIndex == i) {
            int nextWindowIndex = getNextWindowIndex(i3, i2, z);
            if (nextWindowIndex == -1) {
                return -1;
            }
            return getWindow(nextWindowIndex, window).firstPeriodIndex;
        }
        return i + 1;
    }

    public final boolean isLastPeriod(int i, Period period, Window window, int i2, boolean z) {
        if (getNextPeriodIndex(i, period, window, i2, z) == -1) {
            return true;
        }
        return false;
    }

    public int getNextWindowIndex(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == getLastWindowIndex(z)) {
                        return getFirstWindowIndex(z);
                    }
                    return i + 1;
                }
                throw new IllegalStateException();
            }
            return i;
        } else if (i == getLastWindowIndex(z)) {
            return -1;
        } else {
            return i + 1;
        }
    }

    public int getPreviousWindowIndex(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == getFirstWindowIndex(z)) {
                        return getLastWindowIndex(z);
                    }
                    return i - 1;
                }
                throw new IllegalStateException();
            }
            return i;
        } else if (i == getFirstWindowIndex(z)) {
            return -1;
        } else {
            return i - 1;
        }
    }

    public final Window getWindow(int i, Window window, boolean z) {
        return getWindow(i, window, z, 0L);
    }

    public final Period getPeriod(int i, Period period) {
        return getPeriod(i, period, false);
    }

    public final Window getWindow(int i, Window window) {
        return getWindow(i, window, false);
    }

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i, long j) {
        return getPeriodPosition(window, period, i, j, 0L);
    }

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i, long j, long j2) {
        Assertions.checkIndex(i, 0, getWindowCount());
        getWindow(i, window, false, j2);
        if (j == C.TIME_UNSET) {
            j = window.getDefaultPositionUs();
            if (j == C.TIME_UNSET) {
                return null;
            }
        }
        int i2 = window.firstPeriodIndex;
        long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs() + j;
        long durationUs = getPeriod(i2, period).getDurationUs();
        while (durationUs != C.TIME_UNSET && positionInFirstPeriodUs >= durationUs && i2 < window.lastPeriodIndex) {
            positionInFirstPeriodUs -= durationUs;
            i2++;
            durationUs = getPeriod(i2, period).getDurationUs();
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(positionInFirstPeriodUs));
    }
}
