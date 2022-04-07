package com.google.android.exoplayer2.source;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class ClippingMediaSource implements MediaSource, MediaSource.Listener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean enableInitialDiscontinuity;
    public final long endUs;
    public final ArrayList<ClippingMediaPeriod> mediaPeriods;
    public final MediaSource mediaSource;
    public MediaSource.Listener sourceListener;
    public final long startUs;

    /* loaded from: classes4.dex */
    public static final class ClippingTimeline extends ForwardingTimeline {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long endUs;
        public final long startUs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClippingTimeline(Timeline timeline, long j, long j2) {
            super(timeline);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {timeline, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Timeline) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Assertions.checkArgument(timeline.getWindowCount() == 1);
            Assertions.checkArgument(timeline.getPeriodCount() == 1);
            Timeline.Window window = timeline.getWindow(0, new Timeline.Window(), false);
            Assertions.checkArgument(!window.isDynamic);
            j2 = j2 == Long.MIN_VALUE ? window.durationUs : j2;
            long j3 = window.durationUs;
            if (j3 != C.TIME_UNSET) {
                j2 = j2 > j3 ? j3 : j2;
                Assertions.checkArgument(j == 0 || window.isSeekable);
                Assertions.checkArgument(j <= j2);
            }
            Assertions.checkArgument(timeline.getPeriod(0, new Timeline.Period()).getPositionInWindowUs() == 0);
            this.startUs = j;
            this.endUs = j2;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), period, Boolean.valueOf(z)})) == null) {
                Timeline.Period period2 = this.timeline.getPeriod(0, period, z);
                long j = this.endUs;
                long j2 = C.TIME_UNSET;
                if (j != C.TIME_UNSET) {
                    j2 = j - this.startUs;
                }
                period2.durationUs = j2;
                return period2;
            }
            return (Timeline.Period) invokeCommon.objValue;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, boolean z, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), window, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
                Timeline.Window window2 = this.timeline.getWindow(0, window, z, j);
                long j2 = this.endUs;
                window2.durationUs = j2 != C.TIME_UNSET ? j2 - this.startUs : -9223372036854775807L;
                long j3 = window2.defaultPositionUs;
                if (j3 != C.TIME_UNSET) {
                    long max = Math.max(j3, this.startUs);
                    window2.defaultPositionUs = max;
                    long j4 = this.endUs;
                    if (j4 != C.TIME_UNSET) {
                        max = Math.min(max, j4);
                    }
                    window2.defaultPositionUs = max;
                    window2.defaultPositionUs = max - this.startUs;
                }
                long usToMs = C.usToMs(this.startUs);
                long j5 = window2.presentationStartTimeMs;
                if (j5 != C.TIME_UNSET) {
                    window2.presentationStartTimeMs = j5 + usToMs;
                }
                long j6 = window2.windowStartTimeMs;
                if (j6 != C.TIME_UNSET) {
                    window2.windowStartTimeMs = j6 + usToMs;
                }
                return window2;
            }
            return (Timeline.Window) invokeCommon.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClippingMediaSource(MediaSource mediaSource, long j, long j2) {
        this(mediaSource, j, j2, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r9;
            Object[] objArr = {mediaSource, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MediaSource) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaPeriodId, allocator)) == null) {
            ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.mediaSource.createPeriod(mediaPeriodId, allocator), this.enableInitialDiscontinuity);
            this.mediaPeriods.add(clippingMediaPeriod);
            clippingMediaPeriod.setClipping(this.startUs, this.endUs);
            return clippingMediaPeriod;
        }
        return (MediaPeriod) invokeLL.objValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mediaSource.maybeThrowSourceInfoRefreshError();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Listener
    public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mediaSource, timeline, obj) == null) {
            this.sourceListener.onSourceInfoRefreshed(this, new ClippingTimeline(timeline, this.startUs, this.endUs), obj);
            int size = this.mediaPeriods.size();
            for (int i = 0; i < size; i++) {
                this.mediaPeriods.get(i).setClipping(this.startUs, this.endUs);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{exoPlayer, Boolean.valueOf(z), listener}) == null) {
            this.sourceListener = listener;
            this.mediaSource.prepareSource(exoPlayer, false, this);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mediaPeriod) == null) {
            Assertions.checkState(this.mediaPeriods.remove(mediaPeriod));
            this.mediaSource.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mediaSource.releaseSource();
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaSource, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Assertions.checkArgument(j >= 0);
        this.mediaSource = (MediaSource) Assertions.checkNotNull(mediaSource);
        this.startUs = j;
        this.endUs = j2;
        this.enableInitialDiscontinuity = z;
        this.mediaPeriods = new ArrayList<>();
    }
}
