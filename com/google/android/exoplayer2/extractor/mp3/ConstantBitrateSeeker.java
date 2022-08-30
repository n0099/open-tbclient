package com.google.android.exoplayer2.extractor.mp3;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes7.dex */
public final class ConstantBitrateSeeker implements Mp3Extractor.Seeker {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BITS_PER_BYTE = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bitrate;
    public final long durationUs;
    public final long firstFramePosition;

    public ConstantBitrateSeeker(long j, int i, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.firstFramePosition = j;
        this.bitrate = i;
        this.durationUs = j2 == -1 ? C.TIME_UNSET : getTimeUs(j2);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.durationUs : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getPosition(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            long j2 = this.durationUs;
            if (j2 == C.TIME_UNSET) {
                return 0L;
            }
            return this.firstFramePosition + ((Util.constrainValue(j, 0L, j2) * this.bitrate) / 8000000);
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? ((Math.max(0L, j - this.firstFramePosition) * 1000000) * 8) / this.bitrate : invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.durationUs != C.TIME_UNSET : invokeV.booleanValue;
    }
}
