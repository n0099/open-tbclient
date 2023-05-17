package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class ClippingMediaSource implements MediaSource, MediaSource.Listener {
    public final boolean enableInitialDiscontinuity;
    public final long endUs;
    public final ArrayList<ClippingMediaPeriod> mediaPeriods;
    public final MediaSource mediaSource;
    public MediaSource.Listener sourceListener;
    public final long startUs;

    /* loaded from: classes9.dex */
    public static final class ClippingTimeline extends ForwardingTimeline {
        public final long endUs;
        public final long startUs;

        public ClippingTimeline(Timeline timeline, long j, long j2) {
            super(timeline);
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            if (timeline.getWindowCount() == 1) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            if (timeline.getPeriodCount() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkArgument(z2);
            Timeline.Window window = timeline.getWindow(0, new Timeline.Window(), false);
            Assertions.checkArgument(!window.isDynamic);
            j2 = j2 == Long.MIN_VALUE ? window.durationUs : j2;
            long j3 = window.durationUs;
            if (j3 != C.TIME_UNSET) {
                j2 = j2 > j3 ? j3 : j2;
                if (j != 0 && !window.isSeekable) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                Assertions.checkArgument(z3);
                if (j <= j2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Assertions.checkArgument(z4);
            }
            Assertions.checkArgument(timeline.getPeriod(0, new Timeline.Period()).getPositionInWindowUs() == 0);
            this.startUs = j;
            this.endUs = j2;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            Timeline.Period period2 = this.timeline.getPeriod(0, period, z);
            long j = this.endUs;
            long j2 = C.TIME_UNSET;
            if (j != C.TIME_UNSET) {
                j2 = j - this.startUs;
            }
            period2.durationUs = j2;
            return period2;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, boolean z, long j) {
            long j2;
            Timeline.Window window2 = this.timeline.getWindow(0, window, z, j);
            long j3 = this.endUs;
            if (j3 != C.TIME_UNSET) {
                j2 = j3 - this.startUs;
            } else {
                j2 = -9223372036854775807L;
            }
            window2.durationUs = j2;
            long j4 = window2.defaultPositionUs;
            if (j4 != C.TIME_UNSET) {
                long max = Math.max(j4, this.startUs);
                window2.defaultPositionUs = max;
                long j5 = this.endUs;
                if (j5 != C.TIME_UNSET) {
                    max = Math.min(max, j5);
                }
                window2.defaultPositionUs = max;
                window2.defaultPositionUs = max - this.startUs;
            }
            long usToMs = C.usToMs(this.startUs);
            long j6 = window2.presentationStartTimeMs;
            if (j6 != C.TIME_UNSET) {
                window2.presentationStartTimeMs = j6 + usToMs;
            }
            long j7 = window2.windowStartTimeMs;
            if (j7 != C.TIME_UNSET) {
                window2.windowStartTimeMs = j7 + usToMs;
            }
            return window2;
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j, long j2) {
        this(mediaSource, j, j2, true);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Listener
    public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj) {
        this.sourceListener.onSourceInfoRefreshed(this, new ClippingTimeline(timeline, this.startUs, this.endUs), obj);
        int size = this.mediaPeriods.size();
        for (int i = 0; i < size; i++) {
            this.mediaPeriods.get(i).setClipping(this.startUs, this.endUs);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        this.sourceListener = listener;
        this.mediaSource.prepareSource(exoPlayer, false, this);
    }

    public ClippingMediaSource(MediaSource mediaSource, long j, long j2, boolean z) {
        boolean z2;
        if (j >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.checkArgument(z2);
        this.mediaSource = (MediaSource) Assertions.checkNotNull(mediaSource);
        this.startUs = j;
        this.endUs = j2;
        this.enableInitialDiscontinuity = z;
        this.mediaPeriods = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.mediaSource.createPeriod(mediaPeriodId, allocator), this.enableInitialDiscontinuity);
        this.mediaPeriods.add(clippingMediaPeriod);
        clippingMediaPeriod.setClipping(this.startUs, this.endUs);
        return clippingMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.mediaSource.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        this.mediaSource.releaseSource();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Assertions.checkState(this.mediaPeriods.remove(mediaPeriod));
        this.mediaSource.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
    }
}
