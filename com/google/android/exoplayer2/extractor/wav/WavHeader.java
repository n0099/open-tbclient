package com.google.android.exoplayer2.extractor.wav;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class WavHeader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int averageBytesPerSecond;
    public final int bitsPerSample;
    public final int blockAlignment;
    public long dataSize;
    public long dataStartPosition;
    public final int encoding;
    public final int numChannels;
    public final int sampleRateHz;

    public WavHeader(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.numChannels = i2;
        this.sampleRateHz = i3;
        this.averageBytesPerSecond = i4;
        this.blockAlignment = i5;
        this.bitsPerSample = i6;
        this.encoding = i7;
    }

    public int getBitrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.sampleRateHz * this.bitsPerSample * this.numChannels : invokeV.intValue;
    }

    public int getBytesPerFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.blockAlignment : invokeV.intValue;
    }

    public long getDurationUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((this.dataSize / this.blockAlignment) * 1000000) / this.sampleRateHz : invokeV.longValue;
    }

    public int getEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.encoding : invokeV.intValue;
    }

    public int getNumChannels() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.numChannels : invokeV.intValue;
    }

    public long getPosition(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            int i2 = this.blockAlignment;
            return Math.min((((j2 * this.averageBytesPerSecond) / 1000000) / i2) * i2, this.dataSize - i2) + this.dataStartPosition;
        }
        return invokeJ.longValue;
    }

    public int getSampleRateHz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.sampleRateHz : invokeV.intValue;
    }

    public long getTimeUs(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) ? (j2 * 1000000) / this.averageBytesPerSecond : invokeJ.longValue;
    }

    public boolean hasDataBounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.dataStartPosition == 0 || this.dataSize == 0) ? false : true : invokeV.booleanValue;
    }

    public void setDataBounds(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.dataStartPosition = j2;
            this.dataSize = j3;
        }
    }
}
