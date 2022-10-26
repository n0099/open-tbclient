package com.google.android.exoplayer2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;
/* loaded from: classes7.dex */
public abstract class BaseRenderer implements Renderer, RendererCapabilities {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RendererConfiguration configuration;
    public int index;
    public boolean readEndOfStream;
    public int state;
    public SampleStream stream;
    public boolean streamIsFinal;
    public long streamOffsetUs;
    public final int trackType;

    @Override // com.google.android.exoplayer2.Renderer
    public final RendererCapabilities getCapabilities() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (RendererCapabilities) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public MediaClock getMediaClock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (MediaClock) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.ExoPlayerComponent
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, obj) == null) {
        }
    }

    public void onDisabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public void onEnabled(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
        }
    }

    public void onStarted() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public void onStopped() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public void onStreamChanged(Format[] formatArr, long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048595, this, formatArr, j) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public BaseRenderer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.trackType = i;
        this.readEndOfStream = true;
    }

    public static boolean supportsFormatDrm(DrmSessionManager drmSessionManager, DrmInitData drmInitData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, drmSessionManager, drmInitData)) == null) {
            if (drmInitData == null) {
                return true;
            }
            if (drmSessionManager == null) {
                return false;
            }
            return drmSessionManager.canAcquireSession(drmInitData);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void disable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = true;
            if (this.state != 1) {
                z = false;
            }
            Assertions.checkState(z);
            this.state = 0;
            this.stream = null;
            this.streamIsFinal = false;
            onDisabled();
        }
    }

    public final RendererConfiguration getConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.configuration;
        }
        return (RendererConfiguration) invokeV.objValue;
    }

    public final int getIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.index;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.state;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final SampleStream getStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.stream;
        }
        return (SampleStream) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.trackType;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.readEndOfStream;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.streamIsFinal;
        }
        return invokeV.booleanValue;
    }

    public final boolean isSourceReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.readEndOfStream) {
                return this.streamIsFinal;
            }
            return this.stream.isReady();
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.stream.maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setCurrentStreamFinal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.streamIsFinal = true;
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void start() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            boolean z = true;
            if (this.state != 1) {
                z = false;
            }
            Assertions.checkState(z);
            this.state = 2;
            onStarted();
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void stop() throws ExoPlaybackException {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.state == 2) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            this.state = 1;
            onStopped();
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j, boolean z, long j2) throws ExoPlaybackException {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{rendererConfiguration, formatArr, sampleStream, Long.valueOf(j), Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            if (this.state == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkState(z2);
            this.configuration = rendererConfiguration;
            this.state = 1;
            onEnabled(z);
            replaceStream(formatArr, sampleStream, j2);
            onPositionReset(j, z);
        }
    }

    public final int readSource(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048596, this, formatHolder, decoderInputBuffer, z)) == null) {
            int readData = this.stream.readData(formatHolder, decoderInputBuffer, z);
            if (readData == -4) {
                if (decoderInputBuffer.isEndOfStream()) {
                    this.readEndOfStream = true;
                    if (this.streamIsFinal) {
                        return -4;
                    }
                    return -3;
                }
                decoderInputBuffer.timeUs += this.streamOffsetUs;
            } else if (readData == -5) {
                Format format = formatHolder.format;
                long j = format.subsampleOffsetUs;
                if (j != Long.MAX_VALUE) {
                    formatHolder.format = format.copyWithSubsampleOffsetUs(j + this.streamOffsetUs);
                }
            }
            return readData;
        }
        return invokeLLZ.intValue;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{formatArr, sampleStream, Long.valueOf(j)}) == null) {
            Assertions.checkState(!this.streamIsFinal);
            this.stream = sampleStream;
            this.readEndOfStream = false;
            this.streamOffsetUs = j;
            onStreamChanged(formatArr, j);
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            this.streamIsFinal = false;
            this.readEndOfStream = false;
            onPositionReset(j, false);
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.index = i;
        }
    }

    public int skipSource(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048601, this, j)) == null) {
            return this.stream.skipData(j - this.streamOffsetUs);
        }
        return invokeJ.intValue;
    }
}
