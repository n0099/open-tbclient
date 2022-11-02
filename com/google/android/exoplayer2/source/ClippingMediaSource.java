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
/* loaded from: classes7.dex */
public final class ClippingMediaSource implements MediaSource, MediaSource.Listener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean enableInitialDiscontinuity;
    public final long endUs;
    public final ArrayList<ClippingMediaPeriod> mediaPeriods;
    public final MediaSource mediaSource;
    public MediaSource.Listener sourceListener;
    public final long startUs;

    /* loaded from: classes7.dex */
    public static final class ClippingTimeline extends ForwardingTimeline {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long endUs;
        public final long startUs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClippingTimeline(Timeline timeline, long j, long j2) {
            super(timeline);
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
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
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), window, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
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

    public ClippingMediaSource(MediaSource mediaSource, long j, long j2, boolean z) {
        boolean z2;
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

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mediaSource.releaseSource();
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
}
