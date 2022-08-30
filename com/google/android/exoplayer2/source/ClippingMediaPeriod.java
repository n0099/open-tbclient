package com.google.android.exoplayer2.source;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPeriod.Callback callback;
    public long endUs;
    public final MediaPeriod mediaPeriod;
    public boolean pendingInitialDiscontinuity;
    public ClippingSampleStream[] sampleStreams;
    public long startUs;

    /* loaded from: classes7.dex */
    public static final class ClippingSampleStream implements SampleStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long endUs;
        public final MediaPeriod mediaPeriod;
        public boolean pendingDiscontinuity;
        public boolean sentEos;
        public final long startUs;
        public final SampleStream stream;

        public ClippingSampleStream(MediaPeriod mediaPeriod, SampleStream sampleStream, long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaPeriod, sampleStream, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mediaPeriod = mediaPeriod;
            this.stream = sampleStream;
            this.startUs = j;
            this.endUs = j2;
            this.pendingDiscontinuity = z;
        }

        public void clearPendingDiscontinuity() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.pendingDiscontinuity = false;
            }
        }

        public void clearSentEos() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.sentEos = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.stream.isReady() : invokeV.booleanValue;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.stream.maybeThrowError();
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, formatHolder, decoderInputBuffer, z)) == null) {
                if (this.pendingDiscontinuity) {
                    return -3;
                }
                if (this.sentEos) {
                    decoderInputBuffer.setFlags(4);
                    return -4;
                }
                int readData = this.stream.readData(formatHolder, decoderInputBuffer, z);
                if (readData == -5) {
                    Format format = formatHolder.format;
                    formatHolder.format = format.copyWithGaplessInfo(this.startUs != 0 ? 0 : format.encoderDelay, this.endUs == Long.MIN_VALUE ? format.encoderPadding : 0);
                    return -5;
                }
                long j = this.endUs;
                if (j != Long.MIN_VALUE && ((readData == -4 && decoderInputBuffer.timeUs >= j) || (readData == -3 && this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE))) {
                    decoderInputBuffer.clear();
                    decoderInputBuffer.setFlags(4);
                    this.sentEos = true;
                    return -4;
                }
                if (readData == -4 && !decoderInputBuffer.isEndOfStream()) {
                    decoderInputBuffer.timeUs -= this.startUs;
                }
                return readData;
            }
            return invokeLLZ.intValue;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) ? this.stream.skipData(this.startUs + j) : invokeJ.intValue;
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaPeriod, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mediaPeriod = mediaPeriod;
        this.startUs = C.TIME_UNSET;
        this.endUs = C.TIME_UNSET;
        this.sampleStreams = new ClippingSampleStream[0];
        this.pendingInitialDiscontinuity = z;
    }

    public static boolean shouldKeepInitialDiscontinuity(TrackSelection[] trackSelectionArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, trackSelectionArr)) == null) {
            for (TrackSelection trackSelection : trackSelectionArr) {
                if (trackSelection != null && !MimeTypes.isAudio(trackSelection.getSelectedFormat().sampleMimeType)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.mediaPeriod.continueLoading(j + this.startUs) : invokeJ.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.mediaPeriod.discardBuffer(j + this.startUs);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
            if (bufferedPositionUs != Long.MIN_VALUE) {
                long j = this.endUs;
                if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                    return Math.max(0L, bufferedPositionUs - this.startUs);
                }
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                long j = this.endUs;
                if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                    return nextLoadPositionUs - this.startUs;
                }
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mediaPeriod.getTrackGroups() : (TrackGroupArray) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mediaPeriod.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaPeriod) == null) {
            Assertions.checkState((this.startUs == C.TIME_UNSET || this.endUs == C.TIME_UNSET) ? false : true);
            this.callback.onPrepared(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, callback, j) == null) {
            this.callback = callback;
            this.mediaPeriod.prepare(this, this.startUs + j);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        InterceptResult invokeV;
        ClippingSampleStream[] clippingSampleStreamArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            boolean z = false;
            if (this.pendingInitialDiscontinuity) {
                for (ClippingSampleStream clippingSampleStream : this.sampleStreams) {
                    if (clippingSampleStream != null) {
                        clippingSampleStream.clearPendingDiscontinuity();
                    }
                }
                this.pendingInitialDiscontinuity = false;
                long readDiscontinuity = readDiscontinuity();
                if (readDiscontinuity != C.TIME_UNSET) {
                    return readDiscontinuity;
                }
                return 0L;
            }
            long readDiscontinuity2 = this.mediaPeriod.readDiscontinuity();
            if (readDiscontinuity2 == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            Assertions.checkState(readDiscontinuity2 >= this.startUs);
            long j = this.endUs;
            Assertions.checkState((j == Long.MIN_VALUE || readDiscontinuity2 <= j) ? true : true);
            return readDiscontinuity2 - this.startUs;
        }
        return invokeV.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r0 > r7) goto L20;
     */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long seekToUs(long j) {
        InterceptResult invokeJ;
        ClippingSampleStream[] clippingSampleStreamArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            boolean z = false;
            for (ClippingSampleStream clippingSampleStream : this.sampleStreams) {
                if (clippingSampleStream != null) {
                    clippingSampleStream.clearSentEos();
                }
            }
            long seekToUs = this.mediaPeriod.seekToUs(this.startUs + j);
            long j2 = this.startUs;
            if (seekToUs != j + j2) {
                if (seekToUs >= j2) {
                    long j3 = this.endUs;
                    if (j3 != Long.MIN_VALUE) {
                    }
                }
                Assertions.checkState(z);
                return seekToUs - this.startUs;
            }
            z = true;
            Assertions.checkState(z);
            return seekToUs - this.startUs;
        }
        return invokeJ.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        if (r12 > r3) goto L30;
     */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{trackSelectionArr, zArr, sampleStreamArr, zArr2, Long.valueOf(j)})) == null) {
            this.sampleStreams = new ClippingSampleStream[sampleStreamArr.length];
            SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
            int i = 0;
            while (true) {
                SampleStream sampleStream = null;
                if (i >= sampleStreamArr.length) {
                    break;
                }
                ClippingSampleStream[] clippingSampleStreamArr = this.sampleStreams;
                clippingSampleStreamArr[i] = (ClippingSampleStream) sampleStreamArr[i];
                if (clippingSampleStreamArr[i] != null) {
                    sampleStream = clippingSampleStreamArr[i].stream;
                }
                sampleStreamArr2[i] = sampleStream;
                i++;
            }
            long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr2, zArr2, j + this.startUs);
            boolean z = true;
            if (this.pendingInitialDiscontinuity) {
                this.pendingInitialDiscontinuity = this.startUs != 0 && shouldKeepInitialDiscontinuity(trackSelectionArr);
            }
            long j2 = this.startUs;
            if (selectTracks != j + j2) {
                if (selectTracks >= j2) {
                    long j3 = this.endUs;
                    if (j3 != Long.MIN_VALUE) {
                    }
                }
                z = false;
            }
            Assertions.checkState(z);
            for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
                if (sampleStreamArr2[i2] == null) {
                    this.sampleStreams[i2] = null;
                } else if (sampleStreamArr[i2] == null || this.sampleStreams[i2].stream != sampleStreamArr2[i2]) {
                    this.sampleStreams[i2] = new ClippingSampleStream(this, sampleStreamArr2[i2], this.startUs, this.endUs, this.pendingInitialDiscontinuity);
                }
                sampleStreamArr[i2] = this.sampleStreams[i2];
            }
            return selectTracks - this.startUs;
        }
        return invokeCommon.longValue;
    }

    public void setClipping(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.startUs = j;
            this.endUs = j2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mediaPeriod) == null) {
            this.callback.onContinueLoadingRequested(this);
        }
    }
}
