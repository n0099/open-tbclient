package com.google.android.exoplayer2.extractor.ts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes6.dex */
public final class DtsReader implements ElementaryStreamReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HEADER_SIZE = 15;
    public static final int STATE_FINDING_SYNC = 0;
    public static final int STATE_READING_HEADER = 1;
    public static final int STATE_READING_SAMPLE = 2;
    public static final int SYNC_VALUE = 2147385345;
    public static final int SYNC_VALUE_SIZE = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public int bytesRead;
    public Format format;
    public String formatId;
    public final ParsableByteArray headerScratchBytes;
    public final String language;
    public TrackOutput output;
    public long sampleDurationUs;
    public int sampleSize;
    public int state;
    public int syncBytes;
    public long timeUs;

    public DtsReader(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(new byte[15]);
        this.headerScratchBytes = parsableByteArray;
        byte[] bArr = parsableByteArray.data;
        bArr[0] = ByteCompanionObject.MAX_VALUE;
        bArr[1] = -2;
        bArr[2] = Byte.MIN_VALUE;
        bArr[3] = 1;
        this.state = 0;
        this.language = str;
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, this, parsableByteArray, bArr, i)) == null) {
            int min = Math.min(parsableByteArray.bytesLeft(), i - this.bytesRead);
            parsableByteArray.readBytes(bArr, this.bytesRead, min);
            int i2 = this.bytesRead + min;
            this.bytesRead = i2;
            return i2 == i;
        }
        return invokeLLI.booleanValue;
    }

    private void parseHeader() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            byte[] bArr = this.headerScratchBytes.data;
            if (this.format == null) {
                Format parseDtsFormat = DtsUtil.parseDtsFormat(bArr, this.formatId, this.language, null);
                this.format = parseDtsFormat;
                this.output.format(parseDtsFormat);
            }
            this.sampleSize = DtsUtil.getDtsFrameSize(bArr);
            this.sampleDurationUs = (int) ((DtsUtil.parseDtsAudioSampleCount(bArr) * 1000000) / this.format.sampleRate);
        }
    }

    private boolean skipToNextSync(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, parsableByteArray)) == null) {
            while (parsableByteArray.bytesLeft() > 0) {
                int i = this.syncBytes << 8;
                this.syncBytes = i;
                int readUnsignedByte = i | parsableByteArray.readUnsignedByte();
                this.syncBytes = readUnsignedByte;
                if (readUnsignedByte == 2147385345) {
                    this.syncBytes = 0;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, parsableByteArray) == null) {
            while (parsableByteArray.bytesLeft() > 0) {
                int i = this.state;
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            int min = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                            this.output.sampleData(parsableByteArray, min);
                            int i2 = this.bytesRead + min;
                            this.bytesRead = i2;
                            int i3 = this.sampleSize;
                            if (i2 == i3) {
                                this.output.sampleMetadata(this.timeUs, 1, i3, 0, null);
                                this.timeUs += this.sampleDurationUs;
                                this.state = 0;
                            }
                        }
                    } else if (continueRead(parsableByteArray, this.headerScratchBytes.data, 15)) {
                        parseHeader();
                        this.headerScratchBytes.setPosition(0);
                        this.output.sampleData(this.headerScratchBytes, 15);
                        this.state = 2;
                    }
                } else if (skipToNextSync(parsableByteArray)) {
                    this.bytesRead = 4;
                    this.state = 1;
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
    public void packetStarted(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.timeUs = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.state = 0;
            this.bytesRead = 0;
            this.syncBytes = 0;
        }
    }
}
