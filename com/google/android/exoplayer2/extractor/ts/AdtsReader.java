package com.google.android.exoplayer2.extractor.ts;

import android.util.Log;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
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
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes7.dex */
public final class AdtsReader implements ElementaryStreamReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CRC_SIZE = 2;
    public static final int HEADER_SIZE = 5;
    public static final int ID3_HEADER_SIZE = 10;
    public static final byte[] ID3_IDENTIFIER;
    public static final int ID3_SIZE_OFFSET = 6;
    public static final int MATCH_STATE_FF = 512;
    public static final int MATCH_STATE_I = 768;
    public static final int MATCH_STATE_ID = 1024;
    public static final int MATCH_STATE_START = 256;
    public static final int MATCH_STATE_VALUE_SHIFT = 8;
    public static final int STATE_FINDING_SAMPLE = 0;
    public static final int STATE_READING_ADTS_HEADER = 2;
    public static final int STATE_READING_ID3_HEADER = 1;
    public static final int STATE_READING_SAMPLE = 3;
    public static final String TAG = "AdtsReader";
    public transient /* synthetic */ FieldHolder $fh;
    public final ParsableBitArray adtsScratch;
    public int bytesRead;
    public TrackOutput currentOutput;
    public long currentSampleDuration;
    public final boolean exposeId3;
    public String formatId;
    public boolean hasCrc;
    public boolean hasOutputFormat;
    public final ParsableByteArray id3HeaderBuffer;
    public TrackOutput id3Output;
    public final String language;
    public int matchState;
    public TrackOutput output;
    public long sampleDurationUs;
    public int sampleSize;
    public int state;
    public long timeUs;

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1722339249, "Lcom/google/android/exoplayer2/extractor/ts/AdtsReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1722339249, "Lcom/google/android/exoplayer2/extractor/ts/AdtsReader;");
                return;
            }
        }
        ID3_IDENTIFIER = new byte[]{73, 68, 51};
    }

    private void parseId3Header() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.id3Output.sampleData(this.id3HeaderBuffer, 10);
            this.id3HeaderBuffer.setPosition(6);
            setReadingSampleState(this.id3Output, 0L, 10, this.id3HeaderBuffer.readSynchSafeInt() + 10);
        }
    }

    private void setFindingSampleState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.state = 0;
            this.bytesRead = 0;
            this.matchState = 256;
        }
    }

    private void setReadingAdtsHeaderState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.state = 2;
            this.bytesRead = 0;
        }
    }

    private void setReadingId3HeaderState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.state = 1;
            this.bytesRead = ID3_IDENTIFIER.length;
            this.sampleSize = 0;
            this.id3HeaderBuffer.setPosition(0);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setFindingSampleState();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdtsReader(boolean z) {
        this(z, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void readSample(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, parsableByteArray) == null) {
            int min = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
            this.currentOutput.sampleData(parsableByteArray, min);
            int i = this.bytesRead + min;
            this.bytesRead = i;
            int i2 = this.sampleSize;
            if (i == i2) {
                this.currentOutput.sampleMetadata(this.timeUs, 1, i2, 0, null);
                this.timeUs += this.currentSampleDuration;
                setFindingSampleState();
            }
        }
    }

    public AdtsReader(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.adtsScratch = new ParsableBitArray(new byte[7]);
        this.id3HeaderBuffer = new ParsableByteArray(Arrays.copyOf(ID3_IDENTIFIER, 10));
        setFindingSampleState();
        this.exposeId3 = z;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extractorOutput, trackIdGenerator) == null) {
            trackIdGenerator.generateNewId();
            this.formatId = trackIdGenerator.getFormatId();
            this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
            if (this.exposeId3) {
                trackIdGenerator.generateNewId();
                TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
                this.id3Output = track;
                track.format(Format.createSampleFormat(trackIdGenerator.getFormatId(), MimeTypes.APPLICATION_ID3, null, -1, null));
                return;
            }
            this.id3Output = new DummyTrackOutput();
        }
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, this, parsableByteArray, bArr, i)) == null) {
            int min = Math.min(parsableByteArray.bytesLeft(), i - this.bytesRead);
            parsableByteArray.readBytes(bArr, this.bytesRead, min);
            int i2 = this.bytesRead + min;
            this.bytesRead = i2;
            if (i2 == i) {
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    private void findNextSample(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, parsableByteArray) == null) {
            byte[] bArr = parsableByteArray.data;
            int position = parsableByteArray.getPosition();
            int limit = parsableByteArray.limit();
            while (position < limit) {
                int i = position + 1;
                int i2 = bArr[position] & 255;
                if (this.matchState == 512 && i2 >= 240 && i2 != 255) {
                    boolean z = true;
                    if ((i2 & 1) != 0) {
                        z = false;
                    }
                    this.hasCrc = z;
                    setReadingAdtsHeaderState();
                    parsableByteArray.setPosition(i);
                    return;
                }
                int i3 = this.matchState;
                int i4 = i2 | i3;
                if (i4 != 329) {
                    if (i4 != 511) {
                        if (i4 != 836) {
                            if (i4 != 1075) {
                                if (i3 != 256) {
                                    this.matchState = 256;
                                    i--;
                                }
                            } else {
                                setReadingId3HeaderState();
                                parsableByteArray.setPosition(i);
                                return;
                            }
                        } else {
                            this.matchState = 1024;
                        }
                    } else {
                        this.matchState = 512;
                    }
                } else {
                    this.matchState = 768;
                }
                position = i;
            }
            parsableByteArray.setPosition(position);
        }
    }

    private void parseAdtsHeader() throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.adtsScratch.setPosition(0);
            if (!this.hasOutputFormat) {
                int readBits = this.adtsScratch.readBits(2) + 1;
                if (readBits != 2) {
                    Log.w(TAG, "Detected audio object type: " + readBits + ", but assuming AAC LC.");
                    readBits = 2;
                }
                int readBits2 = this.adtsScratch.readBits(4);
                this.adtsScratch.skipBits(1);
                byte[] buildAacAudioSpecificConfig = CodecSpecificDataUtil.buildAacAudioSpecificConfig(readBits, readBits2, this.adtsScratch.readBits(3));
                Pair parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(buildAacAudioSpecificConfig);
                Format createAudioSampleFormat = Format.createAudioSampleFormat(this.formatId, "audio/mp4a-latm", null, -1, -1, ((Integer) parseAacAudioSpecificConfig.second).intValue(), ((Integer) parseAacAudioSpecificConfig.first).intValue(), Collections.singletonList(buildAacAudioSpecificConfig), null, 0, this.language);
                this.sampleDurationUs = 1024000000 / createAudioSampleFormat.sampleRate;
                this.output.format(createAudioSampleFormat);
                this.hasOutputFormat = true;
            } else {
                this.adtsScratch.skipBits(10);
            }
            this.adtsScratch.skipBits(4);
            int readBits3 = (this.adtsScratch.readBits(13) - 2) - 5;
            if (this.hasCrc) {
                readBits3 -= 2;
            }
            setReadingSampleState(this.output, this.sampleDurationUs, 0, readBits3);
        }
    }

    private void setReadingSampleState(TrackOutput trackOutput, long j, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{trackOutput, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            this.state = 3;
            this.bytesRead = i;
            this.currentOutput = trackOutput;
            this.currentSampleDuration = j;
            this.sampleSize = i2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) throws ParserException {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, parsableByteArray) == null) {
            while (parsableByteArray.bytesLeft() > 0) {
                int i2 = this.state;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 == 3) {
                                readSample(parsableByteArray);
                            }
                        } else {
                            if (this.hasCrc) {
                                i = 7;
                            } else {
                                i = 5;
                            }
                            if (continueRead(parsableByteArray, this.adtsScratch.data, i)) {
                                parseAdtsHeader();
                            }
                        }
                    } else if (continueRead(parsableByteArray, this.id3HeaderBuffer.data, 10)) {
                        parseId3Header();
                    }
                } else {
                    findNextSample(parsableByteArray);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.timeUs = j;
        }
    }
}
