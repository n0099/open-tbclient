package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
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
/* loaded from: classes7.dex */
public final class DynamicConcatenatingMediaSource implements MediaSource, ExoPlayer.ExoPlayerComponent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_ADD = 0;
    public static final int MSG_ADD_MULTIPLE = 1;
    public static final int MSG_MOVE = 3;
    public static final int MSG_ON_COMPLETION = 4;
    public static final int MSG_REMOVE = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final List deferredMediaPeriods;
    public MediaSource.Listener listener;
    public final Map mediaSourceByMediaPeriod;
    public final List mediaSourceHolders;
    public final List mediaSourcesPublic;
    public int periodCount;
    public ExoPlayer player;
    public boolean preventListenerNotification;
    public final MediaSourceHolder query;
    public ShuffleOrder shuffleOrder;
    public int windowCount;

    /* loaded from: classes7.dex */
    public final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
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
        public ConcatenatedTimeline(Collection collection, int i, int i2, ShuffleOrder shuffleOrder) {
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
            Iterator it = collection.iterator();
            int i5 = 0;
            while (it.hasNext()) {
                MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) it.next();
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
                if (!(obj instanceof Integer) || (i = this.childIndexByUid.get(((Integer) obj).intValue(), -1)) == -1) {
                    return -1;
                }
                return i;
            }
            return invokeL.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByPeriodIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return Util.binarySearchFloor(this.firstPeriodInChildIndices, i + 1, false, false);
            }
            return invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByWindowIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return Util.binarySearchFloor(this.firstWindowInChildIndices, i + 1, false, false);
            }
            return invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Object getChildUidByChildIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return Integer.valueOf(this.uids[i]);
            }
            return invokeI.objValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstPeriodIndexByChildIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                return this.firstPeriodInChildIndices[i];
            }
            return invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstWindowIndexByChildIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                return this.firstWindowInChildIndices[i];
            }
            return invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Timeline getTimelineByChildIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                return this.timelines[i];
            }
            return (Timeline) invokeI.objValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.periodCount;
            }
            return invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.windowCount;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class DeferredMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
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
                if (mediaPeriod != null && mediaPeriod.continueLoading(j)) {
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void discardBuffer(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                this.mediaPeriod.discardBuffer(j);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
        public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, mediaPeriod) == null) {
                this.callback.onContinueLoadingRequested(this);
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
        public long seekToUs(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) {
                return this.mediaPeriod.seekToUs(j);
            }
            return invokeJ.longValue;
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

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getBufferedPositionUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mediaPeriod.getBufferedPositionUs();
            }
            return invokeV.longValue;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getNextLoadPositionUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mediaPeriod.getNextLoadPositionUs();
            }
            return invokeV.longValue;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public TrackGroupArray getTrackGroups() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mediaPeriod.getTrackGroups();
            }
            return (TrackGroupArray) invokeV.objValue;
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

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long readDiscontinuity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.mediaPeriod.readDiscontinuity();
            }
            return invokeV.longValue;
        }

        public void releasePeriod() {
            MediaPeriod mediaPeriod;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (mediaPeriod = this.mediaPeriod) != null) {
                this.mediaSource.releasePeriod(mediaPeriod);
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
        public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{trackSelectionArr, zArr, sampleStreamArr, zArr2, Long.valueOf(j)})) == null) {
                return this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr, zArr2, j);
            }
            return invokeCommon.longValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class DeferredTimeline extends Timeline {
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.timeline;
            }
            return (Timeline) invokeV.objValue;
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

        public DeferredTimeline cloneWithNewTimeline(Timeline timeline) {
            InterceptResult invokeL;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, timeline)) == null) {
                if (this.replacedID == null && timeline.getPeriodCount() > 0) {
                    obj = timeline.getPeriod(0, period, true).uid;
                } else {
                    obj = this.replacedID;
                }
                return new DeferredTimeline(timeline, obj);
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
            return invokeL.intValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period2, boolean z) {
            InterceptResult invokeCommon;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), period2, Boolean.valueOf(z)})) == null) {
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
            return (Timeline.Period) invokeCommon.objValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, boolean z, long j) {
            InterceptResult invokeCommon;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), window, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
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
            return (Timeline.Window) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class EventDispatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler eventHandler;
        public final Runnable runnable;

        public EventDispatcher(Runnable runnable) {
            Looper mainLooper;
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
            if (Looper.myLooper() != null) {
                mainLooper = Looper.myLooper();
            } else {
                mainLooper = Looper.getMainLooper();
            }
            this.eventHandler = new Handler(mainLooper);
        }

        public void dispatchEvent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.eventHandler.post(this.runnable);
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class MediaSourceHolder implements Comparable {
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
        public int compareTo(MediaSourceHolder mediaSourceHolder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaSourceHolder)) == null) {
                return this.firstPeriodIndexInChild - mediaSourceHolder.firstPeriodIndexInChild;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class MessageData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final EventDispatcher actionOnCompletion;
        public final Object customData;
        public final int index;

        public MessageData(int i, Object obj, Runnable runnable) {
            EventDispatcher eventDispatcher;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), obj, runnable};
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
            if (runnable != null) {
                eventDispatcher = new EventDispatcher(runnable);
            } else {
                eventDispatcher = null;
            }
            this.actionOnCompletion = eventDispatcher;
            this.customData = obj;
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

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (int i = 0; i < this.mediaSourceHolders.size(); i++) {
                ((MediaSourceHolder) this.mediaSourceHolders.get(i)).mediaSource.maybeThrowSourceInfoRefreshError();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (int i = 0; i < this.mediaSourceHolders.size(); i++) {
                ((MediaSourceHolder) this.mediaSourceHolders.get(i)).mediaSource.releaseSource();
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

    private void addMediaSourceInternal(int i, MediaSource mediaSource) {
        MediaSourceHolder mediaSourceHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i, mediaSource) == null) {
            Integer valueOf = Integer.valueOf(System.identityHashCode(mediaSource));
            DeferredTimeline deferredTimeline = new DeferredTimeline();
            if (i > 0) {
                MediaSourceHolder mediaSourceHolder2 = (MediaSourceHolder) this.mediaSourceHolders.get(i - 1);
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
                    if (interceptable2 != null && interceptable2.invokeLLL(1048576, this, mediaSource2, timeline, obj) != null) {
                        return;
                    }
                    this.this$0.updateMediaSourceInternal(this.val$newMediaSourceHolder, timeline);
                }
            });
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
                        if (((DeferredMediaPeriod) this.deferredMediaPeriods.get(size)).mediaSource == mediaSourceHolder.mediaSource) {
                            ((DeferredMediaPeriod) this.deferredMediaPeriods.get(size)).createPeriod();
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

    private void addMediaSourcesInternal(int i, Collection collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, collection) == null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                addMediaSourceInternal(i, (MediaSource) it.next());
                i++;
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

    public synchronized void addMediaSources(int i, Collection collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, collection) == null) {
            synchronized (this) {
                addMediaSources(i, collection, null);
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

    private void correctOffsets(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65541, this, i, i2, i3) == null) {
            this.windowCount += i2;
            this.periodCount += i3;
            while (i < this.mediaSourceHolders.size()) {
                ((MediaSourceHolder) this.mediaSourceHolders.get(i)).firstWindowIndexInChild += i2;
                ((MediaSourceHolder) this.mediaSourceHolders.get(i)).firstPeriodIndexInChild += i3;
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
                if (((MediaSourceHolder) this.mediaSourceHolders.get(i2)).firstPeriodIndexInChild != i) {
                    break;
                }
                binarySearch = i2;
            }
            return binarySearch;
        }
        return invokeI.intValue;
    }

    private void maybeNotifyListener(EventDispatcher eventDispatcher) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, eventDispatcher) == null) && !this.preventListenerNotification) {
            this.listener.onSourceInfoRefreshed(this, new ConcatenatedTimeline(this.mediaSourceHolders, this.windowCount, this.periodCount, this.shuffleOrder), null);
            if (eventDispatcher != null) {
                this.player.sendMessages(new ExoPlayer.ExoPlayerMessage(this, 4, eventDispatcher));
            }
        }
    }

    private void moveMediaSourceInternal(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65544, this, i, i2) == null) {
            int min = Math.min(i, i2);
            int max = Math.max(i, i2);
            int i3 = ((MediaSourceHolder) this.mediaSourceHolders.get(min)).firstWindowIndexInChild;
            int i4 = ((MediaSourceHolder) this.mediaSourceHolders.get(min)).firstPeriodIndexInChild;
            List list = this.mediaSourceHolders;
            list.add(i2, list.remove(i));
            while (min <= max) {
                MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.mediaSourceHolders.get(min);
                mediaSourceHolder.firstWindowIndexInChild = i3;
                mediaSourceHolder.firstPeriodIndexInChild = i4;
                i3 += mediaSourceHolder.timeline.getWindowCount();
                i4 += mediaSourceHolder.timeline.getPeriodCount();
                min++;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        InterceptResult invokeLL;
        MediaPeriod createPeriod;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaPeriodId, allocator)) == null) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.mediaSourceHolders.get(findMediaSourceHolderByPeriodIndex(mediaPeriodId.periodIndex));
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

    private void removeMediaSourceInternal(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i) == null) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.mediaSourceHolders.get(i);
            this.mediaSourceHolders.remove(i);
            DeferredTimeline deferredTimeline = mediaSourceHolder.timeline;
            correctOffsets(i, -deferredTimeline.getWindowCount(), -deferredTimeline.getPeriodCount());
            mediaSourceHolder.mediaSource.releaseSource();
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

    public synchronized void addMediaSources(Collection collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, collection) == null) {
            synchronized (this) {
                addMediaSources(this.mediaSourcesPublic.size(), collection, null);
            }
        }
    }

    public synchronized MediaSource getMediaSource(int i) {
        InterceptResult invokeI;
        MediaSource mediaSource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            synchronized (this) {
                mediaSource = (MediaSource) this.mediaSourcesPublic.get(i);
            }
            return mediaSource;
        }
        return (MediaSource) invokeI.objValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, mediaPeriod) == null) {
            MediaSource mediaSource = (MediaSource) this.mediaSourceByMediaPeriod.get(mediaPeriod);
            this.mediaSourceByMediaPeriod.remove(mediaPeriod);
            if (mediaPeriod instanceof DeferredMediaPeriod) {
                this.deferredMediaPeriods.remove(mediaPeriod);
                ((DeferredMediaPeriod) mediaPeriod).releasePeriod();
                return;
            }
            mediaSource.releasePeriod(mediaPeriod);
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

    public synchronized void addMediaSource(int i, MediaSource mediaSource, Runnable runnable) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, mediaSource, runnable) == null) {
            synchronized (this) {
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
        }
    }

    public synchronized void addMediaSources(int i, Collection collection, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, collection, runnable) == null) {
            synchronized (this) {
                Iterator it = collection.iterator();
                while (true) {
                    boolean z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    MediaSource mediaSource = (MediaSource) it.next();
                    Assertions.checkNotNull(mediaSource);
                    if (!this.mediaSourcesPublic.contains(mediaSource)) {
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

    public synchronized void moveMediaSource(int i, int i2, Runnable runnable) {
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

    public synchronized void addMediaSource(MediaSource mediaSource, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, mediaSource, runnable) == null) {
            synchronized (this) {
                addMediaSource(this.mediaSourcesPublic.size(), mediaSource, runnable);
            }
        }
    }

    public synchronized void addMediaSources(Collection collection, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, collection, runnable) == null) {
            synchronized (this) {
                addMediaSources(this.mediaSourcesPublic.size(), collection, runnable);
            }
        }
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

    public synchronized void removeMediaSource(int i, Runnable runnable) {
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
}
