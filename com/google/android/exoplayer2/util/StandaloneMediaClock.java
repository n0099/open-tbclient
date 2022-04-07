package com.google.android.exoplayer2.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackParameters;
/* loaded from: classes4.dex */
public final class StandaloneMediaClock implements MediaClock {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long baseElapsedMs;
    public long baseUs;
    public PlaybackParameters playbackParameters;
    public boolean started;

    public StandaloneMediaClock() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.playbackParameters = PlaybackParameters.DEFAULT;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.playbackParameters : (PlaybackParameters) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        InterceptResult invokeV;
        long speedAdjustedDurationUs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j = this.baseUs;
            if (this.started) {
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.baseElapsedMs;
                PlaybackParameters playbackParameters = this.playbackParameters;
                if (playbackParameters.speed == 1.0f) {
                    speedAdjustedDurationUs = C.msToUs(elapsedRealtime);
                } else {
                    speedAdjustedDurationUs = playbackParameters.getSpeedAdjustedDurationUs(elapsedRealtime);
                }
                return j + speedAdjustedDurationUs;
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, playbackParameters)) == null) {
            if (this.started) {
                setPositionUs(getPositionUs());
            }
            this.playbackParameters = playbackParameters;
            return playbackParameters;
        }
        return (PlaybackParameters) invokeL.objValue;
    }

    public void setPositionUs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.baseUs = j;
            if (this.started) {
                this.baseElapsedMs = android.os.SystemClock.elapsedRealtime();
            }
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.started) {
            return;
        }
        this.baseElapsedMs = android.os.SystemClock.elapsedRealtime();
        this.started = true;
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.started) {
            setPositionUs(getPositionUs());
            this.started = false;
        }
    }
}
