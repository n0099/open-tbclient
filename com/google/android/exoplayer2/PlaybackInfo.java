package com.google.android.exoplayer2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.MediaSource;
/* loaded from: classes7.dex */
public final class PlaybackInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile long bufferedPositionUs;
    public final long contentPositionUs;
    public final Object manifest;
    public final MediaSource.MediaPeriodId periodId;
    public volatile long positionUs;
    public final long startPositionUs;
    public final Timeline timeline;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlaybackInfo(Timeline timeline, Object obj, int i, long j) {
        this(timeline, obj, new MediaSource.MediaPeriodId(i), j, C.TIME_UNSET);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {timeline, obj, Integer.valueOf(i), Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Timeline) objArr2[0], objArr2[1], (MediaSource.MediaPeriodId) objArr2[2], ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public PlaybackInfo(Timeline timeline, Object obj, MediaSource.MediaPeriodId mediaPeriodId, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {timeline, obj, mediaPeriodId, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.timeline = timeline;
        this.manifest = obj;
        this.periodId = mediaPeriodId;
        this.startPositionUs = j;
        this.contentPositionUs = j2;
        this.positionUs = j;
        this.bufferedPositionUs = j;
    }

    public static void copyMutablePositions(PlaybackInfo playbackInfo, PlaybackInfo playbackInfo2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, playbackInfo, playbackInfo2) == null) {
            playbackInfo2.positionUs = playbackInfo.positionUs;
            playbackInfo2.bufferedPositionUs = playbackInfo.bufferedPositionUs;
        }
    }

    public PlaybackInfo copyWithTimeline(Timeline timeline, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, timeline, obj)) == null) {
            PlaybackInfo playbackInfo = new PlaybackInfo(timeline, obj, this.periodId, this.startPositionUs, this.contentPositionUs);
            copyMutablePositions(this, playbackInfo);
            return playbackInfo;
        }
        return (PlaybackInfo) invokeLL.objValue;
    }

    public PlaybackInfo copyWithPeriodIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            PlaybackInfo playbackInfo = new PlaybackInfo(this.timeline, this.manifest, this.periodId.copyWithPeriodIndex(i), this.startPositionUs, this.contentPositionUs);
            copyMutablePositions(this, playbackInfo);
            return playbackInfo;
        }
        return (PlaybackInfo) invokeI.objValue;
    }

    public PlaybackInfo fromNewPosition(int i, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return fromNewPosition(new MediaSource.MediaPeriodId(i), j, j2);
        }
        return (PlaybackInfo) invokeCommon.objValue;
    }

    public PlaybackInfo fromNewPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{mediaPeriodId, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return new PlaybackInfo(this.timeline, this.manifest, mediaPeriodId, j, j2);
        }
        return (PlaybackInfo) invokeCommon.objValue;
    }
}
