package com.google.android.exoplayer2.source.ads;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.util.Assertions;
/* loaded from: classes7.dex */
public final class SinglePeriodAdTimeline extends ForwardingTimeline {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] adCounts;
    public final long[][] adDurationsUs;
    public final long[] adGroupTimesUs;
    public final long adResumePositionUs;
    public final int[] adsLoadedCounts;
    public final int[] adsPlayedCounts;
    public final long contentDurationUs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SinglePeriodAdTimeline(Timeline timeline, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j, long j2) {
        super(timeline);
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {timeline, jArr, iArr, iArr2, iArr3, jArr2, Long.valueOf(j), Long.valueOf(j2)};
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
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), period, Boolean.valueOf(z)})) == null) {
            this.timeline.getPeriod(i, period, z);
            period.set(period.id, period.uid, period.windowIndex, period.durationUs, period.getPositionInWindowUs(), this.adGroupTimesUs, this.adCounts, this.adsLoadedCounts, this.adsPlayedCounts, this.adDurationsUs, this.adResumePositionUs);
            return period;
        }
        return (Timeline.Period) invokeCommon.objValue;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public Timeline.Window getWindow(int i, Timeline.Window window, boolean z, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), window, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
            Timeline.Window window2 = super.getWindow(i, window, z, j);
            if (window2.durationUs == C.TIME_UNSET) {
                window2.durationUs = this.contentDurationUs;
            }
            return window2;
        }
        return (Timeline.Window) invokeCommon.objValue;
    }
}
