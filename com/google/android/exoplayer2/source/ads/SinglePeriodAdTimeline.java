package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.util.Assertions;
/* loaded from: classes9.dex */
public final class SinglePeriodAdTimeline extends ForwardingTimeline {
    public final int[] adCounts;
    public final long[][] adDurationsUs;
    public final long[] adGroupTimesUs;
    public final long adResumePositionUs;
    public final int[] adsLoadedCounts;
    public final int[] adsPlayedCounts;
    public final long contentDurationUs;

    public SinglePeriodAdTimeline(Timeline timeline, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j, long j2) {
        super(timeline);
        boolean z;
        if (timeline.getPeriodCount() == 1) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        Assertions.checkState(timeline.getWindowCount() == 1);
        this.adGroupTimesUs = jArr;
        this.adCounts = iArr;
        this.adsLoadedCounts = iArr2;
        this.adsPlayedCounts = iArr3;
        this.adDurationsUs = jArr2;
        this.adResumePositionUs = j;
        this.contentDurationUs = j2;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        this.timeline.getPeriod(i, period, z);
        period.set(period.id, period.uid, period.windowIndex, period.durationUs, period.getPositionInWindowUs(), this.adGroupTimesUs, this.adCounts, this.adsLoadedCounts, this.adsPlayedCounts, this.adDurationsUs, this.adResumePositionUs);
        return period;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public Timeline.Window getWindow(int i, Timeline.Window window, boolean z, long j) {
        Timeline.Window window2 = super.getWindow(i, window, z, j);
        if (window2.durationUs == C.TIME_UNSET) {
            window2.durationUs = this.contentDurationUs;
        }
        return window2;
    }
}
