package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class ConcatenatingMediaSource implements MediaSource {
    public final boolean[] duplicateFlags;
    public final boolean isAtomic;
    public MediaSource.Listener listener;
    public final Object[] manifests;
    public final MediaSource[] mediaSources;
    public final ShuffleOrder shuffleOrder;
    public final Map<MediaPeriod, Integer> sourceIndexByMediaPeriod;
    public ConcatenatedTimeline timeline;
    public final Timeline[] timelines;

    /* loaded from: classes9.dex */
    public static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
        public final boolean isAtomic;
        public final int[] sourcePeriodOffsets;
        public final int[] sourceWindowOffsets;
        public final Timeline[] timelines;

        public ConcatenatedTimeline(Timeline[] timelineArr, boolean z, ShuffleOrder shuffleOrder) {
            super(shuffleOrder);
            boolean z2;
            int[] iArr = new int[timelineArr.length];
            int[] iArr2 = new int[timelineArr.length];
            long j = 0;
            int i = 0;
            for (int i2 = 0; i2 < timelineArr.length; i2++) {
                Timeline timeline = timelineArr[i2];
                j += timeline.getPeriodCount();
                if (j <= 2147483647L) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.checkState(z2, "ConcatenatingMediaSource children contain too many periods");
                iArr[i2] = (int) j;
                i += timeline.getWindowCount();
                iArr2[i2] = i;
            }
            this.timelines = timelineArr;
            this.sourcePeriodOffsets = iArr;
            this.sourceWindowOffsets = iArr2;
            this.isAtomic = z;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByChildUid(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByPeriodIndex(int i) {
            return Util.binarySearchFloor(this.sourcePeriodOffsets, i + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByWindowIndex(int i) {
            return Util.binarySearchFloor(this.sourceWindowOffsets, i + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Object getChildUidByChildIndex(int i) {
            return Integer.valueOf(i);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstPeriodIndexByChildIndex(int i) {
            if (i == 0) {
                return 0;
            }
            return this.sourcePeriodOffsets[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline, com.google.android.exoplayer2.Timeline
        public int getFirstWindowIndex(boolean z) {
            boolean z2;
            if (!this.isAtomic && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            return super.getFirstWindowIndex(z2);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstWindowIndexByChildIndex(int i) {
            if (i == 0) {
                return 0;
            }
            return this.sourceWindowOffsets[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline, com.google.android.exoplayer2.Timeline
        public int getLastWindowIndex(boolean z) {
            boolean z2;
            if (!this.isAtomic && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            return super.getLastWindowIndex(z2);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Timeline getTimelineByChildIndex(int i) {
            return this.timelines[i];
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline, com.google.android.exoplayer2.Timeline
        public int getNextWindowIndex(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.isAtomic && i2 == 1) {
                i2 = 2;
            }
            return super.getNextWindowIndex(i, i2, (this.isAtomic || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline, com.google.android.exoplayer2.Timeline
        public int getPreviousWindowIndex(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.isAtomic && i2 == 1) {
                i2 = 2;
            }
            return super.getPreviousWindowIndex(i, i2, (this.isAtomic || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            int[] iArr = this.sourcePeriodOffsets;
            return iArr[iArr.length - 1];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            int[] iArr = this.sourceWindowOffsets;
            return iArr[iArr.length - 1];
        }
    }

    public ConcatenatingMediaSource(boolean z, ShuffleOrder shuffleOrder, MediaSource... mediaSourceArr) {
        for (MediaSource mediaSource : mediaSourceArr) {
            Assertions.checkNotNull(mediaSource);
        }
        Assertions.checkArgument(shuffleOrder.getLength() == mediaSourceArr.length);
        this.mediaSources = mediaSourceArr;
        this.isAtomic = z;
        this.shuffleOrder = shuffleOrder;
        this.timelines = new Timeline[mediaSourceArr.length];
        this.manifests = new Object[mediaSourceArr.length];
        this.sourceIndexByMediaPeriod = new HashMap();
        this.duplicateFlags = buildDuplicateFlags(mediaSourceArr);
    }

    public ConcatenatingMediaSource(boolean z, MediaSource... mediaSourceArr) {
        this(z, new ShuffleOrder.DefaultShuffleOrder(mediaSourceArr.length), mediaSourceArr);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        int childIndexByPeriodIndex = this.timeline.getChildIndexByPeriodIndex(mediaPeriodId.periodIndex);
        MediaPeriod createPeriod = this.mediaSources[childIndexByPeriodIndex].createPeriod(mediaPeriodId.copyWithPeriodIndex(mediaPeriodId.periodIndex - this.timeline.getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex)), allocator);
        this.sourceIndexByMediaPeriod.put(createPeriod, Integer.valueOf(childIndexByPeriodIndex));
        return createPeriod;
    }

    public ConcatenatingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    public static boolean[] buildDuplicateFlags(MediaSource[] mediaSourceArr) {
        boolean[] zArr = new boolean[mediaSourceArr.length];
        IdentityHashMap identityHashMap = new IdentityHashMap(mediaSourceArr.length);
        for (int i = 0; i < mediaSourceArr.length; i++) {
            MediaSource mediaSource = mediaSourceArr[i];
            if (!identityHashMap.containsKey(mediaSource)) {
                identityHashMap.put(mediaSource, null);
            } else {
                zArr[i] = true;
            }
        }
        return zArr;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        int intValue = this.sourceIndexByMediaPeriod.get(mediaPeriod).intValue();
        this.sourceIndexByMediaPeriod.remove(mediaPeriod);
        this.mediaSources[intValue].releasePeriod(mediaPeriod);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSourceInfoRefreshed(int i, Timeline timeline, Object obj) {
        this.timelines[i] = timeline;
        this.manifests[i] = obj;
        int i2 = i + 1;
        while (true) {
            MediaSource[] mediaSourceArr = this.mediaSources;
            if (i2 >= mediaSourceArr.length) {
                break;
            }
            if (mediaSourceArr[i2] == mediaSourceArr[i]) {
                this.timelines[i2] = timeline;
                this.manifests[i2] = obj;
            }
            i2++;
        }
        for (Timeline timeline2 : this.timelines) {
            if (timeline2 == null) {
                return;
            }
        }
        ConcatenatedTimeline concatenatedTimeline = new ConcatenatedTimeline((Timeline[]) this.timelines.clone(), this.isAtomic, this.shuffleOrder);
        this.timeline = concatenatedTimeline;
        this.listener.onSourceInfoRefreshed(this, concatenatedTimeline, this.manifests.clone());
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        int i = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.mediaSources;
            if (i < mediaSourceArr.length) {
                if (!this.duplicateFlags[i]) {
                    mediaSourceArr[i].maybeThrowSourceInfoRefreshError();
                }
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        int i = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.mediaSources;
            if (i < mediaSourceArr.length) {
                if (!this.duplicateFlags[i]) {
                    mediaSourceArr[i].releaseSource();
                }
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        this.listener = listener;
        if (this.mediaSources.length == 0) {
            listener.onSourceInfoRefreshed(this, Timeline.EMPTY, null);
            return;
        }
        final int i = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.mediaSources;
            if (i < mediaSourceArr.length) {
                if (!this.duplicateFlags[i]) {
                    mediaSourceArr[i].prepareSource(exoPlayer, false, new MediaSource.Listener() { // from class: com.google.android.exoplayer2.source.ConcatenatingMediaSource.1
                        @Override // com.google.android.exoplayer2.source.MediaSource.Listener
                        public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj) {
                            ConcatenatingMediaSource.this.handleSourceInfoRefreshed(i, timeline, obj);
                        }
                    });
                }
                i++;
            } else {
                return;
            }
        }
    }
}
