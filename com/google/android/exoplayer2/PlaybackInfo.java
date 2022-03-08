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
    public PlaybackInfo(Timeline timeline, Object obj, int i2, long j2) {
        this(timeline, obj, new MediaSource.MediaPeriodId(i2), j2, C.TIME_UNSET);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {timeline, obj, Integer.valueOf(i2), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Timeline) objArr2[0], objArr2[1], (MediaSource.MediaPeriodId) objArr2[2], ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void copyMutablePositions(PlaybackInfo playbackInfo, PlaybackInfo playbackInfo2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, playbackInfo, playbackInfo2) == null) {
            playbackInfo2.positionUs = playbackInfo.positionUs;
            playbackInfo2.bufferedPositionUs = playbackInfo.bufferedPositionUs;
        }
    }

    public PlaybackInfo copyWithPeriodIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            PlaybackInfo playbackInfo = new PlaybackInfo(this.timeline, this.manifest, this.periodId.copyWithPeriodIndex(i2), this.startPositionUs, this.contentPositionUs);
            copyMutablePositions(this, playbackInfo);
            return playbackInfo;
        }
        return (PlaybackInfo) invokeI.objValue;
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

    public PlaybackInfo fromNewPosition(int i2, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? fromNewPosition(new MediaSource.MediaPeriodId(i2), j2, j3) : (PlaybackInfo) invokeCommon.objValue;
    }

    public PlaybackInfo(Timeline timeline, Object obj, MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {timeline, obj, mediaPeriodId, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.timeline = timeline;
        this.manifest = obj;
        this.periodId = mediaPeriodId;
        this.startPositionUs = j2;
        this.contentPositionUs = j3;
        this.positionUs = j2;
        this.bufferedPositionUs = j2;
    }

    public PlaybackInfo fromNewPosition(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{mediaPeriodId, Long.valueOf(j2), Long.valueOf(j3)})) == null) ? new PlaybackInfo(this.timeline, this.manifest, mediaPeriodId, j2, j3) : (PlaybackInfo) invokeCommon.objValue;
    }
}
