package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class PsExtractor implements Extractor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUDIO_STREAM = 192;
    public static final int AUDIO_STREAM_MASK = 224;
    public static final ExtractorsFactory FACTORY;
    public static final long MAX_SEARCH_LENGTH = 1048576;
    public static final int MAX_STREAM_ID_PLUS_ONE = 256;
    public static final int MPEG_PROGRAM_END_CODE = 441;
    public static final int PACKET_START_CODE_PREFIX = 1;
    public static final int PACK_START_CODE = 442;
    public static final int PRIVATE_STREAM_1 = 189;
    public static final int SYSTEM_HEADER_START_CODE = 443;
    public static final int VIDEO_STREAM = 224;
    public static final int VIDEO_STREAM_MASK = 240;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean foundAllTracks;
    public boolean foundAudioTrack;
    public boolean foundVideoTrack;
    public ExtractorOutput output;
    public final ParsableByteArray psPacketBuffer;
    public final SparseArray<PesReader> psPayloadReaders;
    public final TimestampAdjuster timestampAdjuster;

    /* loaded from: classes4.dex */
    public static final class PesReader {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int PES_SCRATCH_SIZE = 64;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean dtsFlag;
        public int extendedHeaderLength;
        public final ElementaryStreamReader pesPayloadReader;
        public final ParsableBitArray pesScratch;
        public boolean ptsFlag;
        public boolean seenFirstDts;
        public long timeUs;
        public final TimestampAdjuster timestampAdjuster;

        public PesReader(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {elementaryStreamReader, timestampAdjuster};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pesPayloadReader = elementaryStreamReader;
            this.timestampAdjuster = timestampAdjuster;
            this.pesScratch = new ParsableBitArray(new byte[64]);
        }

        private void parseHeader() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.pesScratch.skipBits(8);
                this.ptsFlag = this.pesScratch.readBit();
                this.dtsFlag = this.pesScratch.readBit();
                this.pesScratch.skipBits(6);
                this.extendedHeaderLength = this.pesScratch.readBits(8);
            }
        }

        private void parseHeaderExtension() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.timeUs = 0L;
                if (this.ptsFlag) {
                    this.pesScratch.skipBits(4);
                    this.pesScratch.skipBits(1);
                    this.pesScratch.skipBits(1);
                    long readBits = (this.pesScratch.readBits(3) << 30) | (this.pesScratch.readBits(15) << 15) | this.pesScratch.readBits(15);
                    this.pesScratch.skipBits(1);
                    if (!this.seenFirstDts && this.dtsFlag) {
                        this.pesScratch.skipBits(4);
                        this.pesScratch.skipBits(1);
                        this.pesScratch.skipBits(1);
                        this.pesScratch.skipBits(1);
                        this.timestampAdjuster.adjustTsTimestamp((this.pesScratch.readBits(3) << 30) | (this.pesScratch.readBits(15) << 15) | this.pesScratch.readBits(15));
                        this.seenFirstDts = true;
                    }
                    this.timeUs = this.timestampAdjuster.adjustTsTimestamp(readBits);
                }
            }
        }

        public void consume(ParsableByteArray parsableByteArray) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, parsableByteArray) == null) {
                parsableByteArray.readBytes(this.pesScratch.data, 0, 3);
                this.pesScratch.setPosition(0);
                parseHeader();
                parsableByteArray.readBytes(this.pesScratch.data, 0, this.extendedHeaderLength);
                this.pesScratch.setPosition(0);
                parseHeaderExtension();
                this.pesPayloadReader.packetStarted(this.timeUs, true);
                this.pesPayloadReader.consume(parsableByteArray);
                this.pesPayloadReader.packetFinished();
            }
        }

        public void seek() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.seenFirstDts = false;
                this.pesPayloadReader.seek();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1170872161, "Lcom/google/android/exoplayer2/extractor/ts/PsExtractor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1170872161, "Lcom/google/android/exoplayer2/extractor/ts/PsExtractor;");
                return;
            }
        }
        FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.ts.PsExtractor.1
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
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Extractor[]{new PsExtractor()} : (Extractor[]) invokeV.objValue;
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PsExtractor() {
        this(new TimestampAdjuster(0L));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((TimestampAdjuster) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, extractorOutput) == null) {
            this.output = extractorOutput;
            extractorOutput.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extractorInput, positionHolder)) == null) {
            if (extractorInput.peekFully(this.psPacketBuffer.data, 0, 4, true)) {
                this.psPacketBuffer.setPosition(0);
                int readInt = this.psPacketBuffer.readInt();
                if (readInt == 441) {
                    return -1;
                }
                if (readInt == 442) {
                    extractorInput.peekFully(this.psPacketBuffer.data, 0, 10);
                    this.psPacketBuffer.setPosition(9);
                    extractorInput.skipFully((this.psPacketBuffer.readUnsignedByte() & 7) + 14);
                    return 0;
                } else if (readInt == 443) {
                    extractorInput.peekFully(this.psPacketBuffer.data, 0, 2);
                    this.psPacketBuffer.setPosition(0);
                    extractorInput.skipFully(this.psPacketBuffer.readUnsignedShort() + 6);
                    return 0;
                } else if (((readInt & (-256)) >> 8) != 1) {
                    extractorInput.skipFully(1);
                    return 0;
                } else {
                    int i = readInt & 255;
                    PesReader pesReader = this.psPayloadReaders.get(i);
                    if (!this.foundAllTracks) {
                        if (pesReader == null) {
                            ElementaryStreamReader elementaryStreamReader = null;
                            if (!this.foundAudioTrack && i == 189) {
                                elementaryStreamReader = new Ac3Reader();
                                this.foundAudioTrack = true;
                            } else if (!this.foundAudioTrack && (i & 224) == 192) {
                                elementaryStreamReader = new MpegAudioReader();
                                this.foundAudioTrack = true;
                            } else if (!this.foundVideoTrack && (i & 240) == 224) {
                                elementaryStreamReader = new H262Reader();
                                this.foundVideoTrack = true;
                            }
                            if (elementaryStreamReader != null) {
                                elementaryStreamReader.createTracks(this.output, new TsPayloadReader.TrackIdGenerator(i, 256));
                                pesReader = new PesReader(elementaryStreamReader, this.timestampAdjuster);
                                this.psPayloadReaders.put(i, pesReader);
                            }
                        }
                        if ((this.foundAudioTrack && this.foundVideoTrack) || extractorInput.getPosition() > 1048576) {
                            this.foundAllTracks = true;
                            this.output.endTracks();
                        }
                    }
                    extractorInput.peekFully(this.psPacketBuffer.data, 0, 2);
                    this.psPacketBuffer.setPosition(0);
                    int readUnsignedShort = this.psPacketBuffer.readUnsignedShort() + 6;
                    if (pesReader == null) {
                        extractorInput.skipFully(readUnsignedShort);
                    } else {
                        this.psPacketBuffer.reset(readUnsignedShort);
                        extractorInput.readFully(this.psPacketBuffer.data, 0, readUnsignedShort);
                        this.psPacketBuffer.setPosition(6);
                        pesReader.consume(this.psPacketBuffer);
                        ParsableByteArray parsableByteArray = this.psPacketBuffer;
                        parsableByteArray.setLimit(parsableByteArray.capacity());
                    }
                    return 0;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.timestampAdjuster.reset();
            for (int i = 0; i < this.psPayloadReaders.size(); i++) {
                this.psPayloadReaders.valueAt(i).seek();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, extractorInput)) == null) {
            byte[] bArr = new byte[14];
            extractorInput.peekFully(bArr, 0, 14);
            if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
                extractorInput.advancePeekPosition(bArr[13] & 7);
                extractorInput.peekFully(bArr, 0, 3);
                return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public PsExtractor(TimestampAdjuster timestampAdjuster) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {timestampAdjuster};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.timestampAdjuster = timestampAdjuster;
        this.psPacketBuffer = new ParsableByteArray(4096);
        this.psPayloadReaders = new SparseArray<>();
    }
}
