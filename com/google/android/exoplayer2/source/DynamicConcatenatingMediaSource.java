package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes6.dex */
public final class DynamicConcatenatingMediaSource implements MediaSource, ExoPlayer.ExoPlayerComponent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_ADD = 0;
    public static final int MSG_ADD_MULTIPLE = 1;
    public static final int MSG_MOVE = 3;
    public static final int MSG_ON_COMPLETION = 4;
    public static final int MSG_REMOVE = 2;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes6.dex */
    public static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SparseIntArray childIndexByUid;
        public final int[] firstPeriodInChildIndices;
        public final int[] firstWindowInChildIndices;
        public final int periodCount;
        public final Timeline[] timelines;
        public final int[] uids;
        public final int windowCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConcatenatedTimeline(Collection<MediaSourceHolder> collection, int i, int i2, ShuffleOrder shuffleOrder) {
            super(shuffleOrder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {collection, Integer.valueOf(i), Integer.valueOf(i2), shuffleOrder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((ShuffleOrder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.windowCount = i;
            this.periodCount = i2;
            int size = collection.size();
            this.firstPeriodInChildIndices = new int[size];
            this.firstWindowInChildIndices = new int[size];
            this.timelines = new Timeline[size];
            this.uids = new int[size];
            this.childIndexByUid = new SparseIntArray();
            int i5 = 0;
            for (MediaSourceHolder mediaSourceHolder : collection) {
                this.timelines[i5] = mediaSourceHolder.timeline;
                this.firstPeriodInChildIndices[i5] = mediaSourceHolder.firstPeriodIndexInChild;
                this.firstWindowInChildIndices[i5] = mediaSourceHolder.firstWindowIndexInChild;
                this.uids[i5] = ((Integer) mediaSourceHolder.uid).intValue();
                this.childIndexByUid.put(this.uids[i5], i5);
                i5++;
            }
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByChildUid(Object obj) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if ((obj instanceof Integer) && (i = this.childIndexByUid.get(((Integer) obj).intValue(), -1)) != -1) {
                    return i;
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByPeriodIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? Util.binarySearchFloor(this.firstPeriodInChildIndices, i + 1, false, false) : invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByWindowIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? Util.binarySearchFloor(this.firstWindowInChildIndices, i + 1, false, false) : invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Object getChildUidByChildIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? Integer.valueOf(this.uids[i]) : invokeI.objValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstPeriodIndexByChildIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? this.firstPeriodInChildIndices[i] : invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstWindowIndexByChildIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? this.firstWindowInChildIndices[i] : invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.periodCount : invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Timeline getTimelineByChildIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? this.timelines[i] : (Timeline) invokeI.objValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.windowCount : invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class DeferredMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Allocator allocator;
        public MediaPeriod.Callback callback;
        public final MediaSource.MediaPeriodId id;
        public MediaPeriod mediaPeriod;
        public final MediaSource mediaSource;
        public long preparePositionUs;

        public DeferredMediaPeriod(MediaSource mediaSource, MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSource, mediaPeriodId, allocator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.id = mediaPeriodId;
            this.allocator = allocator;
            this.mediaSource = mediaSource;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean continueLoading(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                MediaPeriod mediaPeriod = this.mediaPeriod;
                return mediaPeriod != null && mediaPeriod.continueLoading(j);
            }
            return invokeJ.booleanValue;
        }

        public void createPeriod() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                MediaPeriod createPeriod = this.mediaSource.createPeriod(this.id, this.allocator);
                this.mediaPeriod = createPeriod;
                if (this.callback != null) {
                    createPeriod.prepare(this, this.preparePositionUs);
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void discardBuffer(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                this.mediaPeriod.discardBuffer(j);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getBufferedPositionUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mediaPeriod.getBufferedPositionUs() : invokeV.longValue;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getNextLoadPositionUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mediaPeriod.getNextLoadPositionUs() : invokeV.longValue;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public TrackGroupArray getTrackGroups() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mediaPeriod.getTrackGroups() : (TrackGroupArray) invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void maybeThrowPrepareError() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                MediaPeriod mediaPeriod = this.mediaPeriod;
                if (mediaPeriod != null) {
                    mediaPeriod.maybeThrowPrepareError();
                } else {
                    this.mediaSource.maybeThrowSourceInfoRefreshError();
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
        public void onPrepared(MediaPeriod mediaPeriod) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, mediaPeriod) == null) {
                this.callback.onPrepared(this);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void prepare(MediaPeriod.Callback callback, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048586, this, callback, j) == null) {
                this.callback = callback;
                this.preparePositionUs = j;
                MediaPeriod mediaPeriod = this.mediaPeriod;
                if (mediaPeriod != null) {
                    mediaPeriod.prepare(this, j);
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long readDiscontinuity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mediaPeriod.readDiscontinuity() : invokeV.longValue;
        }

        public void releasePeriod() {
            MediaPeriod mediaPeriod;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (mediaPeriod = this.mediaPeriod) == null) {
                return;
            }
            this.mediaSource.releasePeriod(mediaPeriod);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long seekToUs(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) ? this.mediaPeriod.seekToUs(j) : invokeJ.longValue;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{trackSelectionArr, zArr, sampleStreamArr, zArr2, Long.valueOf(j)})) == null) ? this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr, zArr2, j) : invokeCommon.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
        public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, mediaPeriod) == null) {
                this.callback.onContinueLoadingRequested(this);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class EventDispatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler eventHandler;
        public final Runnable runnable;

        public EventDispatcher(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.runnable = runnable;
            this.eventHandler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        }

        public void dispatchEvent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.eventHandler.post(this.runnable);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class MediaSourceHolder implements Comparable<MediaSourceHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int firstPeriodIndexInChild;
        public int firstWindowIndexInChild;
        public boolean isPrepared;
        public final MediaSource mediaSource;
        public DeferredTimeline timeline;
        public final Object uid;

        public MediaSourceHolder(MediaSource mediaSource, DeferredTimeline deferredTimeline, int i, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSource, deferredTimeline, Integer.valueOf(i), Integer.valueOf(i2), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mediaSource = mediaSource;
            this.timeline = deferredTimeline;
            this.firstWindowIndexInChild = i;
            this.firstPeriodIndexInChild = i2;
            this.uid = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(@NonNull MediaSourceHolder mediaSourceHolder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaSourceHolder)) == null) ? this.firstPeriodIndexInChild - mediaSourceHolder.firstPeriodIndexInChild : invokeL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class MessageData<CustomType> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final EventDispatcher actionOnCompletion;
        public final CustomType customData;
        public final int index;

        public MessageData(int i, CustomType customtype, @Nullable Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), customtype, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.index = i;
            this.actionOnCompletion = runnable != null ? new EventDispatcher(runnable) : null;
            this.customData = customtype;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DynamicConcatenatingMediaSource() {
        this(new ShuffleOrder.DefaultShuffleOrder(0));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((ShuffleOrder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void addMediaSourceInternal(int i, MediaSource mediaSource) {
        MediaSourceHolder mediaSourceHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i, mediaSource) == null) {
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
            mediaSourceHolder.mediaSource.prepareSource(this.player, false, new MediaSource.Listener(this, mediaSourceHolder) { // from class: com.google.android.exoplayer2.source.DynamicConcatenatingMediaSource.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DynamicConcatenatingMediaSource this$0;
                public final /* synthetic */ MediaSourceHolder val$newMediaSourceHolder;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, mediaSourceHolder};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$newMediaSourceHolder = mediaSourceHolder;
                }

                @Override // com.google.android.exoplayer2.source.MediaSource.Listener
                public void onSourceInfoRefreshed(MediaSource mediaSource2, Timeline timeline, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, mediaSource2, timeline, obj) == null) {
                        this.this$0.updateMediaSourceInternal(this.val$newMediaSourceHolder, timeline);
                    }
                }
            });
        }
    }

    private void addMediaSourcesInternal(int i, Collection<MediaSource> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, collection) == null) {
            for (MediaSource mediaSource : collection) {
                addMediaSourceInternal(i, mediaSource);
                i++;
            }
        }
    }

    private void correctOffsets(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65541, this, i, i2, i3) == null) {
            this.windowCount += i2;
            this.periodCount += i3;
            while (i < this.mediaSourceHolders.size()) {
                this.mediaSourceHolders.get(i).firstWindowIndexInChild += i2;
                this.mediaSourceHolders.get(i).firstPeriodIndexInChild += i3;
                i++;
            }
        }
    }

    private int findMediaSourceHolderByPeriodIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i)) == null) {
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
        return invokeI.intValue;
    }

    private void maybeNotifyListener(@Nullable EventDispatcher eventDispatcher) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, eventDispatcher) == null) || this.preventListenerNotification) {
            return;
        }
        this.listener.onSourceInfoRefreshed(this, new ConcatenatedTimeline(this.mediaSourceHolders, this.windowCount, this.periodCount, this.shuffleOrder), null);
        if (eventDispatcher != null) {
            this.player.sendMessages(new ExoPlayer.ExoPlayerMessage(this, 4, eventDispatcher));
        }
    }

    private void moveMediaSourceInternal(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65544, this, i, i2) == null) {
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
    }

    private void removeMediaSourceInternal(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i) == null) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i);
            this.mediaSourceHolders.remove(i);
            DeferredTimeline deferredTimeline = mediaSourceHolder.timeline;
            correctOffsets(i, -deferredTimeline.getWindowCount(), -deferredTimeline.getPeriodCount());
            mediaSourceHolder.mediaSource.releaseSource();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMediaSourceInternal(MediaSourceHolder mediaSourceHolder, Timeline timeline) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, mediaSourceHolder, timeline) == null) {
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
    }

    public synchronized void addMediaSource(MediaSource mediaSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaSource) == null) {
            synchronized (this) {
                addMediaSource(this.mediaSourcesPublic.size(), mediaSource, null);
            }
        }
    }

    public synchronized void addMediaSources(Collection<MediaSource> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, collection) == null) {
            synchronized (this) {
                addMediaSources(this.mediaSourcesPublic.size(), collection, null);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: java.util.List<com.google.android.exoplayer2.source.DynamicConcatenatingMediaSource$DeferredMediaPeriod> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        InterceptResult invokeLL;
        MediaPeriod createPeriod;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaPeriodId, allocator)) == null) {
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
        return (MediaPeriod) invokeLL.objValue;
    }

    public synchronized MediaSource getMediaSource(int i) {
        InterceptResult invokeI;
        MediaSource mediaSource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            synchronized (this) {
                mediaSource = this.mediaSourcesPublic.get(i);
            }
            return mediaSource;
        }
        return (MediaSource) invokeI.objValue;
    }

    public synchronized int getSize() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                size = this.mediaSourcesPublic.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.ExoPlayerComponent
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        EventDispatcher eventDispatcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, obj) == null) {
            if (i == 4) {
                ((EventDispatcher) obj).dispatchEvent();
                return;
            }
            this.preventListenerNotification = true;
            if (i == 0) {
                MessageData messageData = (MessageData) obj;
                this.shuffleOrder = this.shuffleOrder.cloneAndInsert(messageData.index, 1);
                addMediaSourceInternal(messageData.index, (MediaSource) messageData.customData);
                eventDispatcher = messageData.actionOnCompletion;
            } else if (i == 1) {
                MessageData messageData2 = (MessageData) obj;
                this.shuffleOrder = this.shuffleOrder.cloneAndInsert(messageData2.index, ((Collection) messageData2.customData).size());
                addMediaSourcesInternal(messageData2.index, (Collection) messageData2.customData);
                eventDispatcher = messageData2.actionOnCompletion;
            } else if (i == 2) {
                MessageData messageData3 = (MessageData) obj;
                this.shuffleOrder = this.shuffleOrder.cloneAndRemove(messageData3.index);
                removeMediaSourceInternal(messageData3.index);
                eventDispatcher = messageData3.actionOnCompletion;
            } else if (i == 3) {
                MessageData messageData4 = (MessageData) obj;
                ShuffleOrder cloneAndRemove = this.shuffleOrder.cloneAndRemove(messageData4.index);
                this.shuffleOrder = cloneAndRemove;
                this.shuffleOrder = cloneAndRemove.cloneAndInsert(((Integer) messageData4.customData).intValue(), 1);
                moveMediaSourceInternal(messageData4.index, ((Integer) messageData4.customData).intValue());
                eventDispatcher = messageData4.actionOnCompletion;
            } else {
                throw new IllegalStateException();
            }
            this.preventListenerNotification = false;
            maybeNotifyListener(eventDispatcher);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (int i = 0; i < this.mediaSourceHolders.size(); i++) {
                this.mediaSourceHolders.get(i).mediaSource.maybeThrowSourceInfoRefreshError();
            }
        }
    }

    public synchronized void moveMediaSource(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            synchronized (this) {
                moveMediaSource(i, i2, null);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public synchronized void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{exoPlayer, Boolean.valueOf(z), listener}) == null) {
            synchronized (this) {
                this.player = exoPlayer;
                this.listener = listener;
                this.preventListenerNotification = true;
                this.shuffleOrder = this.shuffleOrder.cloneAndInsert(0, this.mediaSourcesPublic.size());
                addMediaSourcesInternal(0, this.mediaSourcesPublic);
                this.preventListenerNotification = false;
                maybeNotifyListener(null);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, mediaPeriod) == null) {
            MediaSource mediaSource = this.mediaSourceByMediaPeriod.get(mediaPeriod);
            this.mediaSourceByMediaPeriod.remove(mediaPeriod);
            if (mediaPeriod instanceof DeferredMediaPeriod) {
                this.deferredMediaPeriods.remove(mediaPeriod);
                ((DeferredMediaPeriod) mediaPeriod).releasePeriod();
                return;
            }
            mediaSource.releasePeriod(mediaPeriod);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (int i = 0; i < this.mediaSourceHolders.size(); i++) {
                this.mediaSourceHolders.get(i).mediaSource.releaseSource();
            }
        }
    }

    public synchronized void removeMediaSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            synchronized (this) {
                removeMediaSource(i, null);
            }
        }
    }

    public DynamicConcatenatingMediaSource(ShuffleOrder shuffleOrder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {shuffleOrder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.shuffleOrder = shuffleOrder;
        this.mediaSourceByMediaPeriod = new IdentityHashMap();
        this.mediaSourcesPublic = new ArrayList();
        this.mediaSourceHolders = new ArrayList();
        this.deferredMediaPeriods = new ArrayList(1);
        this.query = new MediaSourceHolder(null, null, -1, -1, -1);
    }

    /* loaded from: classes6.dex */
    public static final class DeferredTimeline extends Timeline {
        public static /* synthetic */ Interceptable $ic;
        public static final Object DUMMY_ID;
        public static final Timeline.Period period;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object replacedID;
        public final Timeline timeline;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1401859283, "Lcom/google/android/exoplayer2/source/DynamicConcatenatingMediaSource$DeferredTimeline;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1401859283, "Lcom/google/android/exoplayer2/source/DynamicConcatenatingMediaSource$DeferredTimeline;");
                    return;
                }
            }
            DUMMY_ID = new Object();
            period = new Timeline.Period();
        }

        public DeferredTimeline() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.timeline = null;
            this.replacedID = null;
        }

        public DeferredTimeline cloneWithNewTimeline(Timeline timeline) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, timeline)) == null) {
                return new DeferredTimeline(timeline, (this.replacedID != null || timeline.getPeriodCount() <= 0) ? this.replacedID : timeline.getPeriod(0, period, true).uid);
            }
            return (DeferredTimeline) invokeL.objValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                Timeline timeline = this.timeline;
                if (timeline == null) {
                    return obj == DUMMY_ID ? 0 : -1;
                }
                if (obj == DUMMY_ID) {
                    obj = this.replacedID;
                }
                return timeline.getIndexOfPeriod(obj);
            }
            return invokeL.intValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), period2, Boolean.valueOf(z)})) == null) {
                Timeline timeline = this.timeline;
                if (timeline == null) {
                    return period2.set(z ? DUMMY_ID : null, z ? DUMMY_ID : null, 0, C.TIME_UNSET, C.TIME_UNSET);
                }
                timeline.getPeriod(i, period2, z);
                if (period2.uid == this.replacedID) {
                    period2.uid = DUMMY_ID;
                }
                return period2;
            }
            return (Timeline.Period) invokeCommon.objValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Timeline timeline = this.timeline;
                if (timeline == null) {
                    return 1;
                }
                return timeline.getPeriodCount();
            }
            return invokeV.intValue;
        }

        public Timeline getTimeline() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.timeline : (Timeline) invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, boolean z, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), window, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
                Timeline timeline = this.timeline;
                if (timeline == null) {
                    return window.set(z ? DUMMY_ID : null, C.TIME_UNSET, C.TIME_UNSET, false, true, 0L, C.TIME_UNSET, 0, 0, 0L);
                }
                return timeline.getWindow(i, window, z, j);
            }
            return (Timeline.Window) invokeCommon.objValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Timeline timeline = this.timeline;
                if (timeline == null) {
                    return 1;
                }
                return timeline.getWindowCount();
            }
            return invokeV.intValue;
        }

        public DeferredTimeline(Timeline timeline, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {timeline, obj};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.timeline = timeline;
            this.replacedID = obj;
        }
    }

    public synchronized void addMediaSource(MediaSource mediaSource, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, mediaSource, runnable) == null) {
            synchronized (this) {
                addMediaSource(this.mediaSourcesPublic.size(), mediaSource, runnable);
            }
        }
    }

    public synchronized void addMediaSources(Collection<MediaSource> collection, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, collection, runnable) == null) {
            synchronized (this) {
                addMediaSources(this.mediaSourcesPublic.size(), collection, runnable);
            }
        }
    }

    public synchronized void moveMediaSource(int i, int i2, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i, i2, runnable) == null) {
            synchronized (this) {
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
        }
    }

    public synchronized void removeMediaSource(int i, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i, runnable) == null) {
            synchronized (this) {
                this.mediaSourcesPublic.remove(i);
                if (this.player != null) {
                    this.player.sendMessages(new ExoPlayer.ExoPlayerMessage(this, 2, new MessageData(i, null, runnable)));
                } else if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public synchronized void addMediaSource(int i, MediaSource mediaSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, mediaSource) == null) {
            synchronized (this) {
                addMediaSource(i, mediaSource, null);
            }
        }
    }

    public synchronized void addMediaSources(int i, Collection<MediaSource> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, collection) == null) {
            synchronized (this) {
                addMediaSources(i, collection, null);
            }
        }
    }

    public synchronized void addMediaSource(int i, MediaSource mediaSource, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, mediaSource, runnable) == null) {
            synchronized (this) {
                Assertions.checkNotNull(mediaSource);
                Assertions.checkArgument(!this.mediaSourcesPublic.contains(mediaSource));
                this.mediaSourcesPublic.add(i, mediaSource);
                if (this.player != null) {
                    this.player.sendMessages(new ExoPlayer.ExoPlayerMessage(this, 0, new MessageData(i, mediaSource, runnable)));
                } else if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public synchronized void addMediaSources(int i, Collection<MediaSource> collection, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, collection, runnable) == null) {
            synchronized (this) {
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
        }
    }
}
