package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
/* loaded from: classes9.dex */
public final class MediaPeriodInfoSequence {
    public int repeatMode;
    public boolean shuffleModeEnabled;
    public Timeline timeline;
    public final Timeline.Period period = new Timeline.Period();
    public final Timeline.Window window = new Timeline.Window();

    /* loaded from: classes9.dex */
    public static final class MediaPeriodInfo {
        public final long contentPositionUs;
        public final long durationUs;
        public final long endPositionUs;
        public final MediaSource.MediaPeriodId id;
        public final boolean isFinal;
        public final boolean isLastInTimelinePeriod;
        public final long startPositionUs;

        public MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            this.id = mediaPeriodId;
            this.startPositionUs = j;
            this.endPositionUs = j2;
            this.contentPositionUs = j3;
            this.durationUs = j4;
            this.isLastInTimelinePeriod = z;
            this.isFinal = z2;
        }

        public MediaPeriodInfo copyWithPeriodIndex(int i) {
            return new MediaPeriodInfo(this.id.copyWithPeriodIndex(i), this.startPositionUs, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
        }

        public MediaPeriodInfo copyWithStartPositionUs(long j) {
            return new MediaPeriodInfo(this.id, j, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
        }
    }

    private MediaPeriodInfo getMediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2) {
        long adGroupTimeUs;
        this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        if (mediaPeriodId.isAd()) {
            if (!this.period.isAdAvailable(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup)) {
                return null;
            }
            return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, j);
        }
        int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j2);
        if (adGroupIndexAfterPositionUs == -1) {
            adGroupTimeUs = Long.MIN_VALUE;
        } else {
            adGroupTimeUs = this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs);
        }
        return getMediaPeriodInfoForContent(mediaPeriodId.periodIndex, j2, adGroupTimeUs);
    }

    private MediaPeriodInfo getMediaPeriodInfoForContent(int i, long j, long j2) {
        long j3;
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(i);
        boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, j2);
        boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
        this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        if (j2 == Long.MIN_VALUE) {
            j3 = this.period.getDurationUs();
        } else {
            j3 = j2;
        }
        return new MediaPeriodInfo(mediaPeriodId, j, j2, C.TIME_UNSET, j3, isLastInPeriod, isLastInTimeline);
    }

    private MediaPeriodInfo getMediaPeriodInfoForAd(int i, int i2, int i3, long j) {
        long j2;
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(i, i2, i3);
        boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, Long.MIN_VALUE);
        boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
        long adDurationUs = this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        if (i3 == this.period.getPlayedAdCount(i2)) {
            j2 = this.period.getAdResumePositionUs();
        } else {
            j2 = 0;
        }
        return new MediaPeriodInfo(mediaPeriodId, j2, Long.MIN_VALUE, j, adDurationUs, isLastInPeriod, isLastInTimeline);
    }

    private MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo, MediaSource.MediaPeriodId mediaPeriodId) {
        long j;
        long durationUs;
        long j2 = mediaPeriodInfo.startPositionUs;
        long j3 = mediaPeriodInfo.endPositionUs;
        boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, j3);
        boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
        this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        if (mediaPeriodId.isAd()) {
            durationUs = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        } else if (j3 == Long.MIN_VALUE) {
            durationUs = this.period.getDurationUs();
        } else {
            j = j3;
            return new MediaPeriodInfo(mediaPeriodId, j2, j3, mediaPeriodInfo.contentPositionUs, j, isLastInPeriod, isLastInTimeline);
        }
        j = durationUs;
        return new MediaPeriodInfo(mediaPeriodId, j2, j3, mediaPeriodInfo.contentPositionUs, j, isLastInPeriod, isLastInTimeline);
    }

    private boolean isLastInPeriod(MediaSource.MediaPeriodId mediaPeriodId, long j) {
        boolean z;
        int adGroupCount = this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).getAdGroupCount();
        if (adGroupCount == 0) {
            return true;
        }
        int i = adGroupCount - 1;
        boolean isAd = mediaPeriodId.isAd();
        if (this.period.getAdGroupTimeUs(i) != Long.MIN_VALUE) {
            if (!isAd && j == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }
        int adCountInAdGroup = this.period.getAdCountInAdGroup(i);
        if (adCountInAdGroup == -1) {
            return false;
        }
        if (isAd && mediaPeriodId.adGroupIndex == i && mediaPeriodId.adIndexInAdGroup == adCountInAdGroup - 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        if (!isAd && this.period.getPlayedAdCount(i) == adCountInAdGroup) {
            return true;
        }
        return false;
    }

    private boolean isLastInTimeline(MediaSource.MediaPeriodId mediaPeriodId, boolean z) {
        if (!this.timeline.getWindow(this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).windowIndex, this.window).isDynamic && this.timeline.isLastPeriod(mediaPeriodId.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled) && z) {
            return true;
        }
        return false;
    }

    public MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo, int i) {
        return getUpdatedMediaPeriodInfo(mediaPeriodInfo, mediaPeriodInfo.id.copyWithPeriodIndex(i));
    }

    public MediaSource.MediaPeriodId resolvePeriodPositionForAds(int i, long j) {
        this.timeline.getPeriod(i, this.period);
        int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(j);
        if (adGroupIndexForPositionUs == -1) {
            return new MediaSource.MediaPeriodId(i);
        }
        return new MediaSource.MediaPeriodId(i, adGroupIndexForPositionUs, this.period.getPlayedAdCount(adGroupIndexForPositionUs));
    }

    public MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo playbackInfo) {
        return getMediaPeriodInfo(playbackInfo.periodId, playbackInfo.contentPositionUs, playbackInfo.startPositionUs);
    }

    public MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo) {
        return getUpdatedMediaPeriodInfo(mediaPeriodInfo, mediaPeriodInfo.id);
    }

    public void setRepeatMode(int i) {
        this.repeatMode = i;
    }

    public void setShuffleModeEnabled(boolean z) {
        this.shuffleModeEnabled = z;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public MediaPeriodInfo getNextMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo, long j, long j2) {
        long adGroupTimeUs;
        if (mediaPeriodInfo.isLastInTimelinePeriod) {
            int nextPeriodIndex = this.timeline.getNextPeriodIndex(mediaPeriodInfo.id.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int i = this.timeline.getPeriod(nextPeriodIndex, this.period).windowIndex;
            long j3 = 0;
            if (this.timeline.getWindow(i, this.window).firstPeriodIndex == nextPeriodIndex) {
                Pair<Integer, Long> periodPosition = this.timeline.getPeriodPosition(this.window, this.period, i, C.TIME_UNSET, Math.max(0L, (j + mediaPeriodInfo.durationUs) - j2));
                if (periodPosition == null) {
                    return null;
                }
                nextPeriodIndex = ((Integer) periodPosition.first).intValue();
                j3 = ((Long) periodPosition.second).longValue();
            }
            return getMediaPeriodInfo(resolvePeriodPositionForAds(nextPeriodIndex, j3), j3, j3);
        }
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.id;
        if (mediaPeriodId.isAd()) {
            int i2 = mediaPeriodId.adGroupIndex;
            this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
            int adCountInAdGroup = this.period.getAdCountInAdGroup(i2);
            if (adCountInAdGroup == -1) {
                return null;
            }
            int i3 = mediaPeriodId.adIndexInAdGroup + 1;
            if (i3 < adCountInAdGroup) {
                if (!this.period.isAdAvailable(i2, i3)) {
                    return null;
                }
                return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, i2, i3, mediaPeriodInfo.contentPositionUs);
            }
            int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(mediaPeriodInfo.contentPositionUs);
            if (adGroupIndexAfterPositionUs == -1) {
                adGroupTimeUs = Long.MIN_VALUE;
            } else {
                adGroupTimeUs = this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs);
            }
            return getMediaPeriodInfoForContent(mediaPeriodId.periodIndex, mediaPeriodInfo.contentPositionUs, adGroupTimeUs);
        }
        long j4 = mediaPeriodInfo.endPositionUs;
        if (j4 != Long.MIN_VALUE) {
            int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(j4);
            if (!this.period.isAdAvailable(adGroupIndexForPositionUs, 0)) {
                return null;
            }
            return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, adGroupIndexForPositionUs, 0, mediaPeriodInfo.endPositionUs);
        }
        int adGroupCount = this.period.getAdGroupCount();
        if (adGroupCount != 0) {
            int i4 = adGroupCount - 1;
            if (this.period.getAdGroupTimeUs(i4) == Long.MIN_VALUE && !this.period.hasPlayedAdGroup(i4) && this.period.isAdAvailable(i4, 0)) {
                return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, i4, 0, this.period.getDurationUs());
            }
        }
        return null;
    }
}
