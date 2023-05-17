package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public final class DynamicConcatenatingMediaSource implements MediaSource, ExoPlayer.ExoPlayerComponent {
    public static final int MSG_ADD = 0;
    public static final int MSG_ADD_MULTIPLE = 1;
    public static final int MSG_MOVE = 3;
    public static final int MSG_ON_COMPLETION = 4;
    public static final int MSG_REMOVE = 2;
    public final List<DeferredMediaPeriod> deferredMediaPeriods;
    public MediaSource.Listener listener;
    public final Map<MediaPeriod, MediaSource> mediaSourceByMediaPeriod;
    public final List<MediaSourceHolder> mediaSourceHolders;
    public final List<MediaSource> mediaSourcesPublic;
    public int periodCount;
    public ExoPlayer player;
    public boolean preventListenerNotification;
    public final MediaSourceHolder query;
    public ShuffleOrder shuffleOrder;
    public int windowCount;

    /* loaded from: classes9.dex */
    public static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
        public final SparseIntArray childIndexByUid;
        public final int[] firstPeriodInChildIndices;
        public final int[] firstWindowInChildIndices;
        public final int periodCount;
        public final Timeline[] timelines;
        public final int[] uids;
        public final int windowCount;

        public ConcatenatedTimeline(Collection<MediaSourceHolder> collection, int i, int i2, ShuffleOrder shuffleOrder) {
            super(shuffleOrder);
            this.windowCount = i;
            this.periodCount = i2;
            int size = collection.size();
            this.firstPeriodInChildIndices = new int[size];
            this.firstWindowInChildIndices = new int[size];
            this.timelines = new Timeline[size];
            this.uids = new int[size];
            this.childIndexByUid = new SparseIntArray();
            int i3 = 0;
            for (MediaSourceHolder mediaSourceHolder : collection) {
                this.timelines[i3] = mediaSourceHolder.timeline;
                this.firstPeriodInChildIndices[i3] = mediaSourceHolder.firstPeriodIndexInChild;
                this.firstWindowInChildIndices[i3] = mediaSourceHolder.firstWindowIndexInChild;
                this.uids[i3] = ((Integer) mediaSourceHolder.uid).intValue();
                this.childIndexByUid.put(this.uids[i3], i3);
                i3++;
            }
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByChildUid(Object obj) {
            int i;
            if (!(obj instanceof Integer) || (i = this.childIndexByUid.get(((Integer) obj).intValue(), -1)) == -1) {
                return -1;
            }
            return i;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByPeriodIndex(int i) {
            return Util.binarySearchFloor(this.firstPeriodInChildIndices, i + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByWindowIndex(int i) {
            return Util.binarySearchFloor(this.firstWindowInChildIndices, i + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Object getChildUidByChildIndex(int i) {
            return Integer.valueOf(this.uids[i]);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstPeriodIndexByChildIndex(int i) {
            return this.firstPeriodInChildIndices[i];
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstWindowIndexByChildIndex(int i) {
            return this.firstWindowInChildIndices[i];
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Timeline getTimelineByChildIndex(int i) {
            return this.timelines[i];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.periodCount;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.windowCount;
        }
    }

    /* loaded from: classes9.dex */
    public static final class DeferredMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
        public final Allocator allocator;
        public MediaPeriod.Callback callback;
        public final MediaSource.MediaPeriodId id;
        public MediaPeriod mediaPeriod;
        public final MediaSource mediaSource;
        public long preparePositionUs;

        public DeferredMediaPeriod(MediaSource mediaSource, MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
            this.id = mediaPeriodId;
            this.allocator = allocator;
            this.mediaSource = mediaSource;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean continueLoading(long j) {
            MediaPeriod mediaPeriod = this.mediaPeriod;
            if (mediaPeriod != null && mediaPeriod.continueLoading(j)) {
                return true;
            }
            return false;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void discardBuffer(long j) {
            this.mediaPeriod.discardBuffer(j);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
        public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
            this.callback.onContinueLoadingRequested(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
        public void onPrepared(MediaPeriod mediaPeriod) {
            this.callback.onPrepared(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long seekToUs(long j) {
            return this.mediaPeriod.seekToUs(j);
        }

        public void createPeriod() {
            MediaPeriod createPeriod = this.mediaSource.createPeriod(this.id, this.allocator);
            this.mediaPeriod = createPeriod;
            if (this.callback != null) {
                createPeriod.prepare(this, this.preparePositionUs);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getBufferedPositionUs() {
            return this.mediaPeriod.getBufferedPositionUs();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getNextLoadPositionUs() {
            return this.mediaPeriod.getNextLoadPositionUs();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public TrackGroupArray getTrackGroups() {
            return this.mediaPeriod.getTrackGroups();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void maybeThrowPrepareError() throws IOException {
            MediaPeriod mediaPeriod = this.mediaPeriod;
            if (mediaPeriod != null) {
                mediaPeriod.maybeThrowPrepareError();
            } else {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long readDiscontinuity() {
            return this.mediaPeriod.readDiscontinuity();
        }

        public void releasePeriod() {
            MediaPeriod mediaPeriod = this.mediaPeriod;
            if (mediaPeriod != null) {
                this.mediaSource.releasePeriod(mediaPeriod);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void prepare(MediaPeriod.Callback callback, long j) {
            this.callback = callback;
            this.preparePositionUs = j;
            MediaPeriod mediaPeriod = this.mediaPeriod;
            if (mediaPeriod != null) {
                mediaPeriod.prepare(this, j);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            return this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr, zArr2, j);
        }
    }

    /* loaded from: classes9.dex */
    public static final class DeferredTimeline extends Timeline {
        public static final Object DUMMY_ID = new Object();
        public static final Timeline.Period period = new Timeline.Period();
        public final Object replacedID;
        public final Timeline timeline;

        public DeferredTimeline() {
            this.timeline = null;
            this.replacedID = null;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            Timeline timeline = this.timeline;
            if (timeline == null) {
                return 1;
            }
            return timeline.getPeriodCount();
        }

        public Timeline getTimeline() {
            return this.timeline;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            Timeline timeline = this.timeline;
            if (timeline == null) {
                return 1;
            }
            return timeline.getWindowCount();
        }

        public DeferredTimeline(Timeline timeline, Object obj) {
            this.timeline = timeline;
            this.replacedID = obj;
        }

        public DeferredTimeline cloneWithNewTimeline(Timeline timeline) {
            Object obj;
            if (this.replacedID == null && timeline.getPeriodCount() > 0) {
                obj = timeline.getPeriod(0, period, true).uid;
            } else {
                obj = this.replacedID;
            }
            return new DeferredTimeline(timeline, obj);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            Timeline timeline = this.timeline;
            if (timeline == null) {
                if (obj == DUMMY_ID) {
                    return 0;
                }
                return -1;
            }
            if (obj == DUMMY_ID) {
                obj = this.replacedID;
            }
            return timeline.getIndexOfPeriod(obj);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period2, boolean z) {
            Object obj;
            Timeline timeline = this.timeline;
            if (timeline == null) {
                Object obj2 = null;
                if (z) {
                    obj = DUMMY_ID;
                } else {
                    obj = null;
                }
                if (z) {
                    obj2 = DUMMY_ID;
                }
                return period2.set(obj, obj2, 0, C.TIME_UNSET, C.TIME_UNSET);
            }
            timeline.getPeriod(i, period2, z);
            if (period2.uid == this.replacedID) {
                period2.uid = DUMMY_ID;
            }
            return period2;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, boolean z, long j) {
            Object obj;
            Timeline timeline = this.timeline;
            if (timeline == null) {
                if (z) {
                    obj = DUMMY_ID;
                } else {
                    obj = null;
                }
                return window.set(obj, C.TIME_UNSET, C.TIME_UNSET, false, true, 0L, C.TIME_UNSET, 0, 0, 0L);
            }
            return timeline.getWindow(i, window, z, j);
        }
    }

    /* loaded from: classes9.dex */
    public static final class EventDispatcher {
        public final Handler eventHandler;
        public final Runnable runnable;

        public EventDispatcher(Runnable runnable) {
            Looper mainLooper;
            this.runnable = runnable;
            if (Looper.myLooper() != null) {
                mainLooper = Looper.myLooper();
            } else {
                mainLooper = Looper.getMainLooper();
            }
            this.eventHandler = new Handler(mainLooper);
        }

        public void dispatchEvent() {
            this.eventHandler.post(this.runnable);
        }
    }

    /* loaded from: classes9.dex */
    public static final class MediaSourceHolder implements Comparable<MediaSourceHolder> {
        public int firstPeriodIndexInChild;
        public int firstWindowIndexInChild;
        public boolean isPrepared;
        public final MediaSource mediaSource;
        public DeferredTimeline timeline;
        public final Object uid;

        public MediaSourceHolder(MediaSource mediaSource, DeferredTimeline deferredTimeline, int i, int i2, Object obj) {
            this.mediaSource = mediaSource;
            this.timeline = deferredTimeline;
            this.firstWindowIndexInChild = i;
            this.firstPeriodIndexInChild = i2;
            this.uid = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(@NonNull MediaSourceHolder mediaSourceHolder) {
            return this.firstPeriodIndexInChild - mediaSourceHolder.firstPeriodIndexInChild;
        }
    }

    /* loaded from: classes9.dex */
    public static final class MessageData<CustomType> {
        @Nullable
        public final EventDispatcher actionOnCompletion;
        public final CustomType customData;
        public final int index;

        public MessageData(int i, CustomType customtype, @Nullable Runnable runnable) {
            EventDispatcher eventDispatcher;
            this.index = i;
            if (runnable != null) {
                eventDispatcher = new EventDispatcher(runnable);
            } else {
                eventDispatcher = null;
            }
            this.actionOnCompletion = eventDispatcher;
            this.customData = customtype;
        }
    }

    public DynamicConcatenatingMediaSource() {
        this(new ShuffleOrder.DefaultShuffleOrder(0));
    }

    public synchronized int getSize() {
        return this.mediaSourcesPublic.size();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        for (int i = 0; i < this.mediaSourceHolders.size(); i++) {
            this.mediaSourceHolders.get(i).mediaSource.maybeThrowSourceInfoRefreshError();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        for (int i = 0; i < this.mediaSourceHolders.size(); i++) {
            this.mediaSourceHolders.get(i).mediaSource.releaseSource();
        }
    }

    public DynamicConcatenatingMediaSource(ShuffleOrder shuffleOrder) {
        this.shuffleOrder = shuffleOrder;
        this.mediaSourceByMediaPeriod = new IdentityHashMap();
        this.mediaSourcesPublic = new ArrayList();
        this.mediaSourceHolders = new ArrayList();
        this.deferredMediaPeriods = new ArrayList(1);
        this.query = new MediaSourceHolder(null, null, -1, -1, -1);
    }

    private void correctOffsets(int i, int i2, int i3) {
        this.windowCount += i2;
        this.periodCount += i3;
        while (i < this.mediaSourceHolders.size()) {
            this.mediaSourceHolders.get(i).firstWindowIndexInChild += i2;
            this.mediaSourceHolders.get(i).firstPeriodIndexInChild += i3;
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public synchronized void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        this.player = exoPlayer;
        this.listener = listener;
        this.preventListenerNotification = true;
        this.shuffleOrder = this.shuffleOrder.cloneAndInsert(0, this.mediaSourcesPublic.size());
        addMediaSourcesInternal(0, this.mediaSourcesPublic);
        this.preventListenerNotification = false;
        maybeNotifyListener(null);
    }

    private void addMediaSourceInternal(int i, MediaSource mediaSource) {
        final MediaSourceHolder mediaSourceHolder;
        Integer valueOf = Integer.valueOf(System.identityHashCode(mediaSource));
        DeferredTimeline deferredTimeline = new DeferredTimeline();
        if (i > 0) {
            MediaSourceHolder mediaSourceHolder2 = this.mediaSourceHolders.get(i - 1);
            mediaSourceHolder = new MediaSourceHolder(mediaSource, deferredTimeline, mediaSourceHolder2.firstWindowIndexInChild + mediaSourceHolder2.timeline.getWindowCount(), mediaSourceHolder2.firstPeriodIndexInChild + mediaSourceHolder2.timeline.getPeriodCount(), valueOf);
        } else {
            mediaSourceHolder = new MediaSourceHolder(mediaSource, deferredTimeline, 0, 0, valueOf);
        }
        correctOffsets(i, deferredTimeline.getWindowCount(), deferredTimeline.getPeriodCount());
        this.mediaSourceHolders.add(i, mediaSourceHolder);
        mediaSourceHolder.mediaSource.prepareSource(this.player, false, new MediaSource.Listener() { // from class: com.google.android.exoplayer2.source.DynamicConcatenatingMediaSource.1
            @Override // com.google.android.exoplayer2.source.MediaSource.Listener
            public void onSourceInfoRefreshed(MediaSource mediaSource2, Timeline timeline, Object obj) {
                DynamicConcatenatingMediaSource.this.updateMediaSourceInternal(mediaSourceHolder, timeline);
            }
        });
    }

    private void addMediaSourcesInternal(int i, Collection<MediaSource> collection) {
        for (MediaSource mediaSource : collection) {
            addMediaSourceInternal(i, mediaSource);
            i++;
        }
    }

    public synchronized void addMediaSource(int i, MediaSource mediaSource) {
        addMediaSource(i, mediaSource, null);
    }

    public synchronized void addMediaSources(int i, Collection<MediaSource> collection) {
        addMediaSources(i, collection, null);
    }

    public synchronized void moveMediaSource(int i, int i2) {
        moveMediaSource(i, i2, null);
    }

    public synchronized void removeMediaSource(int i, @Nullable Runnable runnable) {
        this.mediaSourcesPublic.remove(i);
        if (this.player != null) {
            this.player.sendMessages(new ExoPlayer.ExoPlayerMessage(this, 2, new MessageData(i, null, runnable)));
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private int findMediaSourceHolderByPeriodIndex(int i) {
        MediaSourceHolder mediaSourceHolder = this.query;
        mediaSourceHolder.firstPeriodIndexInChild = i;
        int binarySearch = Collections.binarySearch(this.mediaSourceHolders, mediaSourceHolder);
        if (binarySearch < 0) {
            return (-binarySearch) - 2;
        }
        while (binarySearch < this.mediaSourceHolders.size() - 1) {
            int i2 = binarySearch + 1;
            if (this.mediaSourceHolders.get(i2).firstPeriodIndexInChild != i) {
                break;
            }
            binarySearch = i2;
        }
        return binarySearch;
    }

    private void maybeNotifyListener(@Nullable EventDispatcher eventDispatcher) {
        if (!this.preventListenerNotification) {
            this.listener.onSourceInfoRefreshed(this, new ConcatenatedTimeline(this.mediaSourceHolders, this.windowCount, this.periodCount, this.shuffleOrder), null);
            if (eventDispatcher != null) {
                this.player.sendMessages(new ExoPlayer.ExoPlayerMessage(this, 4, eventDispatcher));
            }
        }
    }

    private void removeMediaSourceInternal(int i) {
        MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i);
        this.mediaSourceHolders.remove(i);
        DeferredTimeline deferredTimeline = mediaSourceHolder.timeline;
        correctOffsets(i, -deferredTimeline.getWindowCount(), -deferredTimeline.getPeriodCount());
        mediaSourceHolder.mediaSource.releaseSource();
    }

    public synchronized void addMediaSource(MediaSource mediaSource) {
        addMediaSource(this.mediaSourcesPublic.size(), mediaSource, null);
    }

    public synchronized void addMediaSources(Collection<MediaSource> collection) {
        addMediaSources(this.mediaSourcesPublic.size(), collection, null);
    }

    public synchronized MediaSource getMediaSource(int i) {
        return this.mediaSourcesPublic.get(i);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        MediaSource mediaSource = this.mediaSourceByMediaPeriod.get(mediaPeriod);
        this.mediaSourceByMediaPeriod.remove(mediaPeriod);
        if (mediaPeriod instanceof DeferredMediaPeriod) {
            this.deferredMediaPeriods.remove(mediaPeriod);
            ((DeferredMediaPeriod) mediaPeriod).releasePeriod();
            return;
        }
        mediaSource.releasePeriod(mediaPeriod);
    }

    public synchronized void removeMediaSource(int i) {
        removeMediaSource(i, null);
    }

    private void moveMediaSourceInternal(int i, int i2) {
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        int i3 = this.mediaSourceHolders.get(min).firstWindowIndexInChild;
        int i4 = this.mediaSourceHolders.get(min).firstPeriodIndexInChild;
        List<MediaSourceHolder> list = this.mediaSourceHolders;
        list.add(i2, list.remove(i));
        while (min <= max) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(min);
            mediaSourceHolder.firstWindowIndexInChild = i3;
            mediaSourceHolder.firstPeriodIndexInChild = i4;
            i3 += mediaSourceHolder.timeline.getWindowCount();
            i4 += mediaSourceHolder.timeline.getPeriodCount();
            min++;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: java.util.List<com.google.android.exoplayer2.source.DynamicConcatenatingMediaSource$DeferredMediaPeriod> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        MediaPeriod createPeriod;
        MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(findMediaSourceHolderByPeriodIndex(mediaPeriodId.periodIndex));
        MediaSource.MediaPeriodId copyWithPeriodIndex = mediaPeriodId.copyWithPeriodIndex(mediaPeriodId.periodIndex - mediaSourceHolder.firstPeriodIndexInChild);
        if (!mediaSourceHolder.isPrepared) {
            createPeriod = new DeferredMediaPeriod(mediaSourceHolder.mediaSource, copyWithPeriodIndex, allocator);
            this.deferredMediaPeriods.add(createPeriod);
        } else {
            createPeriod = mediaSourceHolder.mediaSource.createPeriod(copyWithPeriodIndex, allocator);
        }
        this.mediaSourceByMediaPeriod.put(createPeriod, mediaSourceHolder.mediaSource);
        return createPeriod;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMediaSourceInternal(MediaSourceHolder mediaSourceHolder, Timeline timeline) {
        if (mediaSourceHolder != null) {
            DeferredTimeline deferredTimeline = mediaSourceHolder.timeline;
            if (deferredTimeline.getTimeline() == timeline) {
                return;
            }
            int windowCount = timeline.getWindowCount() - deferredTimeline.getWindowCount();
            int periodCount = timeline.getPeriodCount() - deferredTimeline.getPeriodCount();
            if (windowCount != 0 || periodCount != 0) {
                correctOffsets(findMediaSourceHolderByPeriodIndex(mediaSourceHolder.firstPeriodIndexInChild) + 1, windowCount, periodCount);
            }
            mediaSourceHolder.timeline = deferredTimeline.cloneWithNewTimeline(timeline);
            if (!mediaSourceHolder.isPrepared) {
                for (int size = this.deferredMediaPeriods.size() - 1; size >= 0; size--) {
                    if (this.deferredMediaPeriods.get(size).mediaSource == mediaSourceHolder.mediaSource) {
                        this.deferredMediaPeriods.get(size).createPeriod();
                        this.deferredMediaPeriods.remove(size);
                    }
                }
            }
            mediaSourceHolder.isPrepared = true;
            maybeNotifyListener(null);
            return;
        }
        throw new IllegalArgumentException();
    }

    public synchronized void addMediaSource(int i, MediaSource mediaSource, @Nullable Runnable runnable) {
        boolean z;
        Assertions.checkNotNull(mediaSource);
        if (!this.mediaSourcesPublic.contains(mediaSource)) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        this.mediaSourcesPublic.add(i, mediaSource);
        if (this.player != null) {
            this.player.sendMessages(new ExoPlayer.ExoPlayerMessage(this, 0, new MessageData(i, mediaSource, runnable)));
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public synchronized void moveMediaSource(int i, int i2, @Nullable Runnable runnable) {
        if (i == i2) {
            return;
        }
        this.mediaSourcesPublic.add(i2, this.mediaSourcesPublic.remove(i));
        if (this.player != null) {
            this.player.sendMessages(new ExoPlayer.ExoPlayerMessage(this, 3, new MessageData(i, Integer.valueOf(i2), runnable)));
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public synchronized void addMediaSource(MediaSource mediaSource, @Nullable Runnable runnable) {
        addMediaSource(this.mediaSourcesPublic.size(), mediaSource, runnable);
    }

    public synchronized void addMediaSources(Collection<MediaSource> collection, @Nullable Runnable runnable) {
        addMediaSources(this.mediaSourcesPublic.size(), collection, runnable);
    }

    public synchronized void addMediaSources(int i, Collection<MediaSource> collection, @Nullable Runnable runnable) {
        Iterator<MediaSource> it = collection.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            MediaSource next = it.next();
            Assertions.checkNotNull(next);
            if (!this.mediaSourcesPublic.contains(next)) {
                z = true;
            }
            Assertions.checkArgument(z);
        }
        this.mediaSourcesPublic.addAll(i, collection);
        if (this.player != null && !collection.isEmpty()) {
            this.player.sendMessages(new ExoPlayer.ExoPlayerMessage(this, 1, new MessageData(i, collection, runnable)));
        } else if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.ExoPlayerComponent
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        EventDispatcher eventDispatcher;
        if (i == 4) {
            ((EventDispatcher) obj).dispatchEvent();
            return;
        }
        this.preventListenerNotification = true;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        MessageData messageData = (MessageData) obj;
                        ShuffleOrder cloneAndRemove = this.shuffleOrder.cloneAndRemove(messageData.index);
                        this.shuffleOrder = cloneAndRemove;
                        this.shuffleOrder = cloneAndRemove.cloneAndInsert(((Integer) messageData.customData).intValue(), 1);
                        moveMediaSourceInternal(messageData.index, ((Integer) messageData.customData).intValue());
                        eventDispatcher = messageData.actionOnCompletion;
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    MessageData messageData2 = (MessageData) obj;
                    this.shuffleOrder = this.shuffleOrder.cloneAndRemove(messageData2.index);
                    removeMediaSourceInternal(messageData2.index);
                    eventDispatcher = messageData2.actionOnCompletion;
                }
            } else {
                MessageData messageData3 = (MessageData) obj;
                this.shuffleOrder = this.shuffleOrder.cloneAndInsert(messageData3.index, ((Collection) messageData3.customData).size());
                addMediaSourcesInternal(messageData3.index, (Collection) messageData3.customData);
                eventDispatcher = messageData3.actionOnCompletion;
            }
        } else {
            MessageData messageData4 = (MessageData) obj;
            this.shuffleOrder = this.shuffleOrder.cloneAndInsert(messageData4.index, 1);
            addMediaSourceInternal(messageData4.index, (MediaSource) messageData4.customData);
            eventDispatcher = messageData4.actionOnCompletion;
        }
        this.preventListenerNotification = false;
        maybeNotifyListener(eventDispatcher);
    }
}
