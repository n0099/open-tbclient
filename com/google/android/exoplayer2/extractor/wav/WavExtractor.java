package com.google.android.exoplayer2.extractor.wav;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class WavExtractor implements Extractor, SeekMap {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ExtractorsFactory FACTORY;
    public static final int MAX_INPUT_SIZE = 32768;
    public transient /* synthetic */ FieldHolder $fh;
    public int bytesPerFrame;
    public ExtractorOutput extractorOutput;
    public int pendingBytes;
    public TrackOutput trackOutput;
    public WavHeader wavHeader;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-986683497, "Lcom/google/android/exoplayer2/extractor/wav/WavExtractor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-986683497, "Lcom/google/android/exoplayer2/extractor/wav/WavExtractor;");
                return;
            }
        }
        FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.wav.WavExtractor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
            public Extractor[] createExtractors() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Extractor[]{new WavExtractor()} : (Extractor[]) invokeV.objValue;
            }
        };
    }

    public WavExtractor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.wavHeader.getDurationUs() : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getPosition(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? this.wavHeader.getPosition(j) : invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, extractorOutput) == null) {
            this.extractorOutput = extractorOutput;
            this.trackOutput = extractorOutput.track(0, 1);
            this.wavHeader = null;
            extractorOutput.endTracks();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, extractorInput, positionHolder)) == null) {
            if (this.wavHeader == null) {
                WavHeader peek = WavHeaderReader.peek(extractorInput);
                this.wavHeader = peek;
                if (peek != null) {
                    this.trackOutput.format(Format.createAudioSampleFormat(null, MimeTypes.AUDIO_RAW, null, peek.getBitrate(), 32768, this.wavHeader.getNumChannels(), this.wavHeader.getSampleRateHz(), this.wavHeader.getEncoding(), null, null, 0, null));
                    this.bytesPerFrame = this.wavHeader.getBytesPerFrame();
                } else {
                    throw new ParserException("Unsupported or unrecognized wav header.");
                }
            }
            if (!this.wavHeader.hasDataBounds()) {
                WavHeaderReader.skipToData(extractorInput, this.wavHeader);
                this.extractorOutput.seekMap(this);
            }
            int sampleData = this.trackOutput.sampleData(extractorInput, 32768 - this.pendingBytes, true);
            if (sampleData != -1) {
                this.pendingBytes += sampleData;
            }
            int i = this.pendingBytes / this.bytesPerFrame;
            if (i > 0) {
                long timeUs = this.wavHeader.getTimeUs(extractorInput.getPosition() - this.pendingBytes);
                int i2 = i * this.bytesPerFrame;
                int i3 = this.pendingBytes - i2;
                this.pendingBytes = i3;
                this.trackOutput.sampleMetadata(timeUs, 1, i2, i3, null);
            }
            return sampleData == -1 ? -1 : 0;
        }
        return invokeLL.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.pendingBytes = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, extractorInput)) == null) ? WavHeaderReader.peek(extractorInput) != null : invokeL.booleanValue;
    }
}
