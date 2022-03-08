package com.google.android.exoplayer2.extractor.ts;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
/* loaded from: classes7.dex */
public final class MpegAudioReader implements ElementaryStreamReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HEADER_SIZE = 4;
    public static final int STATE_FINDING_HEADER = 0;
    public static final int STATE_READING_FRAME = 2;
    public static final int STATE_READING_HEADER = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String formatId;
    public int frameBytesRead;
    public long frameDurationUs;
    public int frameSize;
    public boolean hasOutputFormat;
    public final MpegAudioHeader header;
    public final ParsableByteArray headerScratch;
    public final String language;
    public boolean lastByteWasFF;
    public TrackOutput output;
    public int state;
    public long timeUs;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MpegAudioReader() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void findHeader(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, parsableByteArray) == null) {
            byte[] bArr = parsableByteArray.data;
            int limit = parsableByteArray.limit();
            for (int position = parsableByteArray.getPosition(); position < limit; position++) {
                boolean z = (bArr[position] & 255) == 255;
                boolean z2 = this.lastByteWasFF && (bArr[position] & 224) == 224;
                this.lastByteWasFF = z;
                if (z2) {
                    parsableByteArray.setPosition(position + 1);
                    this.lastByteWasFF = false;
                    this.headerScratch.data[1] = bArr[position];
                    this.frameBytesRead = 2;
                    this.state = 1;
                    return;
                }
            }
            parsableByteArray.setPosition(limit);
        }
    }

    private void readFrameRemainder(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, parsableByteArray) == null) {
            int min = Math.min(parsableByteArray.bytesLeft(), this.frameSize - this.frameBytesRead);
            this.output.sampleData(parsableByteArray, min);
            int i2 = this.frameBytesRead + min;
            this.frameBytesRead = i2;
            int i3 = this.frameSize;
            if (i2 < i3) {
                return;
            }
            this.output.sampleMetadata(this.timeUs, 1, i3, 0, null);
            this.timeUs += this.frameDurationUs;
            this.frameBytesRead = 0;
            this.state = 0;
        }
    }

    private void readHeaderRemainder(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, parsableByteArray) == null) {
            int min = Math.min(parsableByteArray.bytesLeft(), 4 - this.frameBytesRead);
            parsableByteArray.readBytes(this.headerScratch.data, this.frameBytesRead, min);
            int i2 = this.frameBytesRead + min;
            this.frameBytesRead = i2;
            if (i2 < 4) {
                return;
            }
            this.headerScratch.setPosition(0);
            if (!MpegAudioHeader.populateHeader(this.headerScratch.readInt(), this.header)) {
                this.frameBytesRead = 0;
                this.state = 1;
                return;
            }
            MpegAudioHeader mpegAudioHeader = this.header;
            this.frameSize = mpegAudioHeader.frameSize;
            if (!this.hasOutputFormat) {
                int i3 = mpegAudioHeader.sampleRate;
                this.frameDurationUs = (mpegAudioHeader.samplesPerFrame * 1000000) / i3;
                this.output.format(Format.createAudioSampleFormat(this.formatId, mpegAudioHeader.mimeType, null, -1, 4096, mpegAudioHeader.channels, i3, null, null, 0, this.language));
                this.hasOutputFormat = true;
            }
            this.headerScratch.setPosition(0);
            this.output.sampleData(this.headerScratch, 4);
            this.state = 2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, parsableByteArray) == null) {
            while (parsableByteArray.bytesLeft() > 0) {
                int i2 = this.state;
                if (i2 == 0) {
                    findHeader(parsableByteArray);
                } else if (i2 == 1) {
                    readHeaderRemainder(parsableByteArray);
                } else if (i2 == 2) {
                    readFrameRemainder(parsableByteArray);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extractorOutput, trackIdGenerator) == null) {
            trackIdGenerator.generateNewId();
            this.formatId = trackIdGenerator.getFormatId();
            this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.timeUs = j2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.state = 0;
            this.frameBytesRead = 0;
            this.lastByteWasFF = false;
        }
    }

    public MpegAudioReader(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.state = 0;
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.headerScratch = parsableByteArray;
        parsableByteArray.data[0] = -1;
        this.header = new MpegAudioHeader();
        this.language = str;
    }
}
