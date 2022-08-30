package com.google.android.exoplayer2.extractor.ts;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
/* loaded from: classes7.dex */
public final class LatmReader implements ElementaryStreamReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INITIAL_BUFFER_SIZE = 1024;
    public static final int STATE_FINDING_SYNC_1 = 0;
    public static final int STATE_FINDING_SYNC_2 = 1;
    public static final int STATE_READING_HEADER = 2;
    public static final int STATE_READING_SAMPLE = 3;
    public static final int SYNC_BYTE_FIRST = 86;
    public static final int SYNC_BYTE_SECOND = 224;
    public transient /* synthetic */ FieldHolder $fh;
    public int audioMuxVersion;
    public int audioMuxVersionA;
    public int bytesRead;
    public int channelCount;
    public Format format;
    public String formatId;
    public int frameLengthType;
    public final String language;
    public int numSubframes;
    public long otherDataLenBits;
    public boolean otherDataPresent;
    public TrackOutput output;
    public final ParsableBitArray sampleBitArray;
    public final ParsableByteArray sampleDataBuffer;
    public long sampleDurationUs;
    public int sampleRateHz;
    public int sampleSize;
    public int secondHeaderByte;
    public int state;
    public boolean streamMuxRead;
    public long timeUs;

    public LatmReader(@Nullable String str) {
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
        this.language = str;
        ParsableByteArray parsableByteArray = new ParsableByteArray(1024);
        this.sampleDataBuffer = parsableByteArray;
        this.sampleBitArray = new ParsableBitArray(parsableByteArray.data);
    }

    public static long latmGetValue(ParsableBitArray parsableBitArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, parsableBitArray)) == null) ? parsableBitArray.readBits((parsableBitArray.readBits(2) + 1) * 8) : invokeL.longValue;
    }

    private void parseAudioMuxElement(ParsableBitArray parsableBitArray) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, parsableBitArray) == null) {
            if (!parsableBitArray.readBit()) {
                this.streamMuxRead = true;
                parseStreamMuxConfig(parsableBitArray);
            } else if (!this.streamMuxRead) {
                return;
            }
            if (this.audioMuxVersionA == 0) {
                if (this.numSubframes == 0) {
                    parsePayloadMux(parsableBitArray, parsePayloadLengthInfo(parsableBitArray));
                    if (this.otherDataPresent) {
                        parsableBitArray.skipBits((int) this.otherDataLenBits);
                        return;
                    }
                    return;
                }
                throw new ParserException();
            }
            throw new ParserException();
        }
    }

    private int parseAudioSpecificConfig(ParsableBitArray parsableBitArray) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, parsableBitArray)) == null) {
            int bitsLeft = parsableBitArray.bitsLeft();
            Pair<Integer, Integer> parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(parsableBitArray, true);
            this.sampleRateHz = ((Integer) parseAacAudioSpecificConfig.first).intValue();
            this.channelCount = ((Integer) parseAacAudioSpecificConfig.second).intValue();
            return bitsLeft - parsableBitArray.bitsLeft();
        }
        return invokeL.intValue;
    }

    private void parseFrameLength(ParsableBitArray parsableBitArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, parsableBitArray) == null) {
            int readBits = parsableBitArray.readBits(3);
            this.frameLengthType = readBits;
            if (readBits == 0) {
                parsableBitArray.skipBits(8);
            } else if (readBits == 1) {
                parsableBitArray.skipBits(9);
            } else if (readBits == 3 || readBits == 4 || readBits == 5) {
                parsableBitArray.skipBits(6);
            } else if (readBits == 6 || readBits == 7) {
                parsableBitArray.skipBits(1);
            }
        }
    }

    private int parsePayloadLengthInfo(ParsableBitArray parsableBitArray) throws ParserException {
        InterceptResult invokeL;
        int readBits;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, parsableBitArray)) == null) {
            if (this.frameLengthType == 0) {
                int i = 0;
                do {
                    readBits = parsableBitArray.readBits(8);
                    i += readBits;
                } while (readBits == 255);
                return i;
            }
            throw new ParserException();
        }
        return invokeL.intValue;
    }

    private void parsePayloadMux(ParsableBitArray parsableBitArray, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, this, parsableBitArray, i) == null) {
            int position = parsableBitArray.getPosition();
            if ((position & 7) == 0) {
                this.sampleDataBuffer.setPosition(position >> 3);
            } else {
                parsableBitArray.readBits(this.sampleDataBuffer.data, 0, i * 8);
                this.sampleDataBuffer.setPosition(0);
            }
            this.output.sampleData(this.sampleDataBuffer, i);
            this.output.sampleMetadata(this.timeUs, 1, i, 0, null);
            this.timeUs += this.sampleDurationUs;
        }
    }

    private void parseStreamMuxConfig(ParsableBitArray parsableBitArray) throws ParserException {
        boolean readBit;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, parsableBitArray) == null) {
            int readBits = parsableBitArray.readBits(1);
            this.audioMuxVersion = readBits;
            int readBits2 = readBits == 1 ? parsableBitArray.readBits(1) : 0;
            this.audioMuxVersionA = readBits2;
            if (readBits2 == 0) {
                if (this.audioMuxVersion == 1) {
                    latmGetValue(parsableBitArray);
                }
                if (parsableBitArray.readBit()) {
                    this.numSubframes = parsableBitArray.readBits(6);
                    int readBits3 = parsableBitArray.readBits(4);
                    int readBits4 = parsableBitArray.readBits(3);
                    if (readBits3 == 0 && readBits4 == 0) {
                        if (this.audioMuxVersion == 0) {
                            int position = parsableBitArray.getPosition();
                            int parseAudioSpecificConfig = parseAudioSpecificConfig(parsableBitArray);
                            parsableBitArray.setPosition(position);
                            byte[] bArr = new byte[(parseAudioSpecificConfig + 7) / 8];
                            parsableBitArray.readBits(bArr, 0, parseAudioSpecificConfig);
                            Format createAudioSampleFormat = Format.createAudioSampleFormat(this.formatId, "audio/mp4a-latm", null, -1, -1, this.channelCount, this.sampleRateHz, Collections.singletonList(bArr), null, 0, this.language);
                            if (!createAudioSampleFormat.equals(this.format)) {
                                this.format = createAudioSampleFormat;
                                this.sampleDurationUs = 1024000000 / createAudioSampleFormat.sampleRate;
                                this.output.format(createAudioSampleFormat);
                            }
                        } else {
                            parsableBitArray.skipBits(((int) latmGetValue(parsableBitArray)) - parseAudioSpecificConfig(parsableBitArray));
                        }
                        parseFrameLength(parsableBitArray);
                        boolean readBit2 = parsableBitArray.readBit();
                        this.otherDataPresent = readBit2;
                        this.otherDataLenBits = 0L;
                        if (readBit2) {
                            if (this.audioMuxVersion == 1) {
                                this.otherDataLenBits = latmGetValue(parsableBitArray);
                            } else {
                                do {
                                    readBit = parsableBitArray.readBit();
                                    this.otherDataLenBits = (this.otherDataLenBits << 8) + parsableBitArray.readBits(8);
                                } while (readBit);
                            }
                        }
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(8);
                            return;
                        }
                        return;
                    }
                    throw new ParserException();
                }
                throw new ParserException();
            }
            throw new ParserException();
        }
    }

    private void resetBufferForSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            this.sampleDataBuffer.reset(i);
            this.sampleBitArray.reset(this.sampleDataBuffer.data);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, parsableByteArray) == null) {
            while (parsableByteArray.bytesLeft() > 0) {
                int i = this.state;
                if (i != 0) {
                    if (i == 1) {
                        int readUnsignedByte = parsableByteArray.readUnsignedByte();
                        if ((readUnsignedByte & 224) == 224) {
                            this.secondHeaderByte = readUnsignedByte;
                            this.state = 2;
                        } else if (readUnsignedByte != 86) {
                            this.state = 0;
                        }
                    } else if (i == 2) {
                        int readUnsignedByte2 = ((this.secondHeaderByte & (-225)) << 8) | parsableByteArray.readUnsignedByte();
                        this.sampleSize = readUnsignedByte2;
                        if (readUnsignedByte2 > this.sampleDataBuffer.data.length) {
                            resetBufferForSize(readUnsignedByte2);
                        }
                        this.bytesRead = 0;
                        this.state = 3;
                    } else if (i == 3) {
                        int min = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                        parsableByteArray.readBytes(this.sampleBitArray.data, this.bytesRead, min);
                        int i2 = this.bytesRead + min;
                        this.bytesRead = i2;
                        if (i2 == this.sampleSize) {
                            this.sampleBitArray.setPosition(0);
                            parseAudioMuxElement(this.sampleBitArray);
                            this.state = 0;
                        }
                    }
                } else if (parsableByteArray.readUnsignedByte() == 86) {
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
            this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
            this.formatId = trackIdGenerator.getFormatId();
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
            this.streamMuxRead = false;
        }
    }
}
