package com.google.android.exoplayer2.text;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class SubtitleOutputBuffer extends OutputBuffer implements Subtitle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long subsampleOffsetUs;
    public Subtitle subtitle;

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer
    public abstract void release();

    public SubtitleOutputBuffer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.clear();
            this.subtitle = null;
        }
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.subtitle.getEventTimeCount();
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            return this.subtitle.getCues(j - this.subsampleOffsetUs);
        }
        return (List) invokeJ.objValue;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return this.subtitle.getEventTime(i) + this.subsampleOffsetUs;
        }
        return invokeI.longValue;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            return this.subtitle.getNextEventTimeIndex(j - this.subsampleOffsetUs);
        }
        return invokeJ.intValue;
    }

    public void setContent(long j, Subtitle subtitle, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), subtitle, Long.valueOf(j2)}) == null) {
            this.timeUs = j;
            this.subtitle = subtitle;
            if (j2 != Long.MAX_VALUE) {
                j = j2;
            }
            this.subsampleOffsetUs = j;
        }
    }
}
