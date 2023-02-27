package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;
/* loaded from: classes7.dex */
public final class SinglePeriodTimeline extends Timeline {
    public static final Object ID = new Object();
    public final boolean isDynamic;
    public final boolean isSeekable;
    public final long periodDurationUs;
    public final long presentationStartTimeMs;
    public final long windowDefaultStartPositionUs;
    public final long windowDurationUs;
    public final long windowPositionInPeriodUs;
    public final long windowStartTimeMs;

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return 1;
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.presentationStartTimeMs = j;
        this.windowStartTimeMs = j2;
        this.periodDurationUs = j3;
        this.windowDurationUs = j4;
        this.windowPositionInPeriodUs = j5;
        this.windowDefaultStartPositionUs = j6;
        this.isSeekable = z;
        this.isDynamic = z2;
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this(C.TIME_UNSET, C.TIME_UNSET, j, j2, j3, j4, z, z2);
    }

    public SinglePeriodTimeline(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(Object obj) {
        if (ID.equals(obj)) {
            return 0;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        Object obj;
        Assertions.checkIndex(i, 0, 1);
        if (z) {
            obj = ID;
        } else {
            obj = null;
        }
        Object obj2 = obj;
        return period.set(obj2, obj2, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Window getWindow(int i, Timeline.Window window, boolean z, long j) {
        Object obj;
        Assertions.checkIndex(i, 0, 1);
        if (z) {
            obj = ID;
        } else {
            obj = null;
        }
        Object obj2 = obj;
        long j2 = this.windowDefaultStartPositionUs;
        if (this.isDynamic) {
            j2 += j;
            if (j2 > this.windowDurationUs) {
                j2 = C.TIME_UNSET;
            }
        }
        return window.set(obj2, this.presentationStartTimeMs, this.windowStartTimeMs, this.isSeekable, this.isDynamic, j2, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs);
    }
}
