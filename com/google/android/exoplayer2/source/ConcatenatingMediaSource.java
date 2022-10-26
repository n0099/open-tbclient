package com.google.android.exoplayer2.source;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public final class ConcatenatingMediaSource implements MediaSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean[] duplicateFlags;
    public final boolean isAtomic;
    public MediaSource.Listener listener;
    public final Object[] manifests;
    public final MediaSource[] mediaSources;
    public final ShuffleOrder shuffleOrder;
    public final Map sourceIndexByMediaPeriod;
    public ConcatenatedTimeline timeline;
    public final Timeline[] timelines;

    /* loaded from: classes7.dex */
    public final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean isAtomic;
        public final int[] sourcePeriodOffsets;
        public final int[] sourceWindowOffsets;
        public final Timeline[] timelines;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConcatenatedTimeline(Timeline[] timelineArr, boolean z, ShuffleOrder shuffleOrder) {
            super(shuffleOrder);
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {timelineArr, Boolean.valueOf(z), shuffleOrder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ShuffleOrder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int[] iArr = new int[timelineArr.length];
            int[] iArr2 = new int[timelineArr.length];
            long j = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < timelineArr.length; i4++) {
                Timeline timeline = timelineArr[i4];
                j += timeline.getPeriodCount();
                if (j <= 2147483647L) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.checkState(z2, "ConcatenatingMediaSource children contain too many periods");
                iArr[i4] = (int) j;
                i3 += timeline.getWindowCount();
                iArr2[i4] = i3;
            }
            this.timelines = timelineArr;
            this.sourcePeriodOffsets = iArr;
            this.sourceWindowOffsets = iArr2;
            this.isAtomic = z;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByChildUid(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (!(obj instanceof Integer)) {
                    return -1;
                }
                return ((Integer) obj).intValue();
            }
            return invokeL.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByPeriodIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return Util.binarySearchFloor(this.sourcePeriodOffsets, i + 1, false, false) + 1;
            }
            return invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByWindowIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return Util.binarySearchFloor(this.sourceWindowOffsets, i + 1, false, false) + 1;
            }
            return invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Object getChildUidByChildIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return Integer.valueOf(i);
            }
            return invokeI.objValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstPeriodIndexByChildIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                if (i == 0) {
                    return 0;
                }
                return this.sourcePeriodOffsets[i - 1];
            }
            return invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline, com.google.android.exoplayer2.Timeline
        public int getFirstWindowIndex(boolean z) {
            InterceptResult invokeZ;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                if (!this.isAtomic && z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                return super.getFirstWindowIndex(z2);
            }
            return invokeZ.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstWindowIndexByChildIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                if (i == 0) {
                    return 0;
                }
                return this.sourceWindowOffsets[i - 1];
            }
            return invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline, com.google.android.exoplayer2.Timeline
        public int getLastWindowIndex(boolean z) {
            InterceptResult invokeZ;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                if (!this.isAtomic && z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                return super.getLastWindowIndex(z2);
            }
            return invokeZ.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Timeline getTimelineByChildIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                return this.timelines[i];
            }
            return (Timeline) invokeI.objValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline, com.google.android.exoplayer2.Timeline
        public int getNextWindowIndex(int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                boolean z2 = true;
                if (this.isAtomic && i2 == 1) {
                    i2 = 2;
                }
                return super.getNextWindowIndex(i, i2, (this.isAtomic || !z) ? false : false);
            }
            return invokeCommon.intValue;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline, com.google.android.exoplayer2.Timeline
        public int getPreviousWindowIndex(int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                boolean z2 = true;
                if (this.isAtomic && i2 == 1) {
                    i2 = 2;
                }
                return super.getPreviousWindowIndex(i, i2, (this.isAtomic || !z) ? false : false);
            }
            return invokeCommon.intValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                int[] iArr = this.sourcePeriodOffsets;
                return iArr[iArr.length - 1];
            }
            return invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                int[] iArr = this.sourceWindowOffsets;
                return iArr[iArr.length - 1];
            }
            return invokeV.intValue;
        }
    }

    public ConcatenatingMediaSource(boolean z, ShuffleOrder shuffleOrder, MediaSource... mediaSourceArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), shuffleOrder, mediaSourceArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConcatenatingMediaSource(boolean z, MediaSource... mediaSourceArr) {
        this(z, new ShuffleOrder.DefaultShuffleOrder(mediaSourceArr.length), mediaSourceArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), mediaSourceArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (ShuffleOrder) objArr2[1], (MediaSource[]) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConcatenatingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaSourceArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (MediaSource[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public static boolean[] buildDuplicateFlags(MediaSource[] mediaSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaSourceArr)) == null) {
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
        return (boolean[]) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSourceInfoRefreshed(int i, Timeline timeline, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65541, this, i, timeline, obj) == null) {
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
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{exoPlayer, Boolean.valueOf(z), listener}) == null) {
            this.listener = listener;
            if (this.mediaSources.length == 0) {
                listener.onSourceInfoRefreshed(this, Timeline.EMPTY, null);
                return;
            }
            int i = 0;
            while (true) {
                MediaSource[] mediaSourceArr = this.mediaSources;
                if (i < mediaSourceArr.length) {
                    if (!this.duplicateFlags[i]) {
                        mediaSourceArr[i].prepareSource(exoPlayer, false, new MediaSource.Listener(this, i) { // from class: com.google.android.exoplayer2.source.ConcatenatingMediaSource.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ConcatenatingMediaSource this$0;
                            public final /* synthetic */ int val$index;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i)};
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
                                this.val$index = i;
                            }

                            @Override // com.google.android.exoplayer2.source.MediaSource.Listener
                            public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null && interceptable2.invokeLLL(1048576, this, mediaSource, timeline, obj) != null) {
                                    return;
                                }
                                this.this$0.handleSourceInfoRefreshed(this.val$index, timeline, obj);
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

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaPeriodId, allocator)) == null) {
            int childIndexByPeriodIndex = this.timeline.getChildIndexByPeriodIndex(mediaPeriodId.periodIndex);
            MediaPeriod createPeriod = this.mediaSources[childIndexByPeriodIndex].createPeriod(mediaPeriodId.copyWithPeriodIndex(mediaPeriodId.periodIndex - this.timeline.getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex)), allocator);
            this.sourceIndexByMediaPeriod.put(createPeriod, Integer.valueOf(childIndexByPeriodIndex));
            return createPeriod;
        }
        return (MediaPeriod) invokeLL.objValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mediaPeriod) == null) {
            int intValue = ((Integer) this.sourceIndexByMediaPeriod.get(mediaPeriod)).intValue();
            this.sourceIndexByMediaPeriod.remove(mediaPeriod);
            this.mediaSources[intValue].releasePeriod(mediaPeriod);
        }
    }
}
