package com.google.android.exoplayer2.extractor.mp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes6.dex */
public final class Mp3Extractor implements Extractor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ExtractorsFactory FACTORY;
    public static final int FLAG_DISABLE_ID3_METADATA = 2;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    public static final int MAX_SNIFF_BYTES = 16384;
    public static final int MAX_SYNC_BYTES = 131072;
    public static final int MPEG_AUDIO_HEADER_MASK = -128000;
    public static final int SCRATCH_LENGTH = 10;
    public static final int SEEK_HEADER_INFO;
    public static final int SEEK_HEADER_UNSET = 0;
    public static final int SEEK_HEADER_VBRI;
    public static final int SEEK_HEADER_XING;
    public transient /* synthetic */ FieldHolder $fh;
    public long basisTimeUs;
    public ExtractorOutput extractorOutput;
    public final int flags;
    public final long forcedFirstSampleTimestampUs;
    public final GaplessInfoHolder gaplessInfoHolder;
    public Metadata metadata;
    public int sampleBytesRemaining;
    public long samplesRead;
    public final ParsableByteArray scratch;
    public Seeker seeker;
    public final MpegAudioHeader synchronizedHeader;
    public int synchronizedHeaderData;
    public TrackOutput trackOutput;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface Flags {
    }

    /* loaded from: classes6.dex */
    public interface Seeker extends SeekMap {
        long getTimeUs(long j);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2082247583, "Lcom/google/android/exoplayer2/extractor/mp3/Mp3Extractor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2082247583, "Lcom/google/android/exoplayer2/extractor/mp3/Mp3Extractor;");
                return;
            }
        }
        FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.1
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
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Extractor[]{new Mp3Extractor()} : (Extractor[]) invokeV.objValue;
            }
        };
        SEEK_HEADER_XING = Util.getIntegerCodeForString("Xing");
        SEEK_HEADER_INFO = Util.getIntegerCodeForString("Info");
        SEEK_HEADER_VBRI = Util.getIntegerCodeForString("VBRI");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Mp3Extractor() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private Seeker getConstantBitrateSeeker(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, extractorInput)) == null) {
            extractorInput.peekFully(this.scratch.data, 0, 4);
            this.scratch.setPosition(0);
            MpegAudioHeader.populateHeader(this.scratch.readInt(), this.synchronizedHeader);
            return new ConstantBitrateSeeker(extractorInput.getPosition(), this.synchronizedHeader.bitrate, extractorInput.getLength());
        }
        return (Seeker) invokeL.objValue;
    }

    public static int getSeekFrameHeader(ParsableByteArray parsableByteArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, parsableByteArray, i)) == null) {
            if (parsableByteArray.limit() >= i + 4) {
                parsableByteArray.setPosition(i);
                int readInt = parsableByteArray.readInt();
                if (readInt == SEEK_HEADER_XING || readInt == SEEK_HEADER_INFO) {
                    return readInt;
                }
            }
            if (parsableByteArray.limit() >= 40) {
                parsableByteArray.setPosition(36);
                int readInt2 = parsableByteArray.readInt();
                int i2 = SEEK_HEADER_VBRI;
                if (readInt2 == i2) {
                    return i2;
                }
                return 0;
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public static boolean headersMatch(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) ? ((long) (i & MPEG_AUDIO_HEADER_MASK)) == (j & (-128000)) : invokeCommon.booleanValue;
    }

    private Seeker maybeReadSeekFrame(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, extractorInput)) == null) {
            ParsableByteArray parsableByteArray = new ParsableByteArray(this.synchronizedHeader.frameSize);
            extractorInput.peekFully(parsableByteArray.data, 0, this.synchronizedHeader.frameSize);
            MpegAudioHeader mpegAudioHeader = this.synchronizedHeader;
            int i2 = mpegAudioHeader.version & 1;
            int i3 = mpegAudioHeader.channels;
            if (i2 != 0) {
                if (i3 != 1) {
                    i = 36;
                }
                i = 21;
            } else {
                if (i3 == 1) {
                    i = 13;
                }
                i = 21;
            }
            int seekFrameHeader = getSeekFrameHeader(parsableByteArray, i);
            if (seekFrameHeader != SEEK_HEADER_XING && seekFrameHeader != SEEK_HEADER_INFO) {
                if (seekFrameHeader == SEEK_HEADER_VBRI) {
                    VbriSeeker create = VbriSeeker.create(this.synchronizedHeader, parsableByteArray, extractorInput.getPosition(), extractorInput.getLength());
                    extractorInput.skipFully(this.synchronizedHeader.frameSize);
                    return create;
                }
                extractorInput.resetPeekPosition();
                return null;
            }
            XingSeeker create2 = XingSeeker.create(this.synchronizedHeader, parsableByteArray, extractorInput.getPosition(), extractorInput.getLength());
            if (create2 != null && !this.gaplessInfoHolder.hasGaplessInfo()) {
                extractorInput.resetPeekPosition();
                extractorInput.advancePeekPosition(i + Cea708Decoder.COMMAND_DLY);
                extractorInput.peekFully(this.scratch.data, 0, 3);
                this.scratch.setPosition(0);
                this.gaplessInfoHolder.setFromXingHeaderValue(this.scratch.readUnsignedInt24());
            }
            extractorInput.skipFully(this.synchronizedHeader.frameSize);
            return (create2 == null || create2.isSeekable() || seekFrameHeader != SEEK_HEADER_INFO) ? create2 : getConstantBitrateSeeker(extractorInput);
        }
        return (Seeker) invokeL.objValue;
    }

    private void peekId3Data(ExtractorInput extractorInput) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65544, this, extractorInput) != null) {
            return;
        }
        int i = 0;
        while (true) {
            extractorInput.peekFully(this.scratch.data, 0, 10);
            this.scratch.setPosition(0);
            if (this.scratch.readUnsignedInt24() != Id3Decoder.ID3_TAG) {
                extractorInput.resetPeekPosition();
                extractorInput.advancePeekPosition(i);
                return;
            }
            this.scratch.skipBytes(3);
            int readSynchSafeInt = this.scratch.readSynchSafeInt();
            int i2 = readSynchSafeInt + 10;
            if (this.metadata == null) {
                byte[] bArr = new byte[i2];
                System.arraycopy(this.scratch.data, 0, bArr, 0, 10);
                extractorInput.peekFully(bArr, 10, readSynchSafeInt);
                Metadata decode = new Id3Decoder((this.flags & 2) != 0 ? GaplessInfoHolder.GAPLESS_INFO_ID3_FRAME_PREDICATE : null).decode(bArr, i2);
                this.metadata = decode;
                if (decode != null) {
                    this.gaplessInfoHolder.setFromMetadata(decode);
                }
            } else {
                extractorInput.advancePeekPosition(readSynchSafeInt);
            }
            i += i2;
        }
    }

    private int readSample(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        MpegAudioHeader mpegAudioHeader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, extractorInput)) == null) {
            if (this.sampleBytesRemaining == 0) {
                extractorInput.resetPeekPosition();
                if (!extractorInput.peekFully(this.scratch.data, 0, 4, true)) {
                    return -1;
                }
                this.scratch.setPosition(0);
                int readInt = this.scratch.readInt();
                if (headersMatch(readInt, this.synchronizedHeaderData) && MpegAudioHeader.getFrameSize(readInt) != -1) {
                    MpegAudioHeader.populateHeader(readInt, this.synchronizedHeader);
                    if (this.basisTimeUs == C.TIME_UNSET) {
                        this.basisTimeUs = this.seeker.getTimeUs(extractorInput.getPosition());
                        if (this.forcedFirstSampleTimestampUs != C.TIME_UNSET) {
                            this.basisTimeUs += this.forcedFirstSampleTimestampUs - this.seeker.getTimeUs(0L);
                        }
                    }
                    this.sampleBytesRemaining = this.synchronizedHeader.frameSize;
                } else {
                    extractorInput.skipFully(1);
                    this.synchronizedHeaderData = 0;
                    return 0;
                }
            }
            int sampleData = this.trackOutput.sampleData(extractorInput, this.sampleBytesRemaining, true);
            if (sampleData == -1) {
                return -1;
            }
            int i = this.sampleBytesRemaining - sampleData;
            this.sampleBytesRemaining = i;
            if (i > 0) {
                return 0;
            }
            this.trackOutput.sampleMetadata(this.basisTimeUs + ((this.samplesRead * 1000000) / mpegAudioHeader.sampleRate), 1, this.synchronizedHeader.frameSize, 0, null);
            this.samplesRead += this.synchronizedHeader.samplesPerFrame;
            this.sampleBytesRemaining = 0;
            return 0;
        }
        return invokeL.intValue;
    }

    private boolean synchronize(ExtractorInput extractorInput, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeLZ;
        int i;
        int i2;
        int frameSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, this, extractorInput, z)) == null) {
            int i3 = z ? 16384 : 131072;
            extractorInput.resetPeekPosition();
            if (extractorInput.getPosition() == 0) {
                peekId3Data(extractorInput);
                i2 = (int) extractorInput.getPeekPosition();
                if (!z) {
                    extractorInput.skipFully(i2);
                }
                i = 0;
            } else {
                i = 0;
                i2 = 0;
            }
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (!extractorInput.peekFully(this.scratch.data, 0, 4, i > 0)) {
                    break;
                }
                this.scratch.setPosition(0);
                int readInt = this.scratch.readInt();
                if ((i4 == 0 || headersMatch(readInt, i4)) && (frameSize = MpegAudioHeader.getFrameSize(readInt)) != -1) {
                    i++;
                    if (i != 1) {
                        if (i == 4) {
                            break;
                        }
                    } else {
                        MpegAudioHeader.populateHeader(readInt, this.synchronizedHeader);
                        i4 = readInt;
                    }
                    extractorInput.advancePeekPosition(frameSize - 4);
                } else {
                    int i6 = i5 + 1;
                    if (i5 == i3) {
                        if (z) {
                            return false;
                        }
                        throw new ParserException("Searched too many bytes.");
                    }
                    if (z) {
                        extractorInput.resetPeekPosition();
                        extractorInput.advancePeekPosition(i2 + i6);
                    } else {
                        extractorInput.skipFully(1);
                    }
                    i5 = i6;
                    i = 0;
                    i4 = 0;
                }
            }
            if (z) {
                extractorInput.skipFully(i2 + i5);
            } else {
                extractorInput.resetPeekPosition();
            }
            this.synchronizedHeaderData = i4;
            return true;
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, extractorOutput) == null) {
            this.extractorOutput = extractorOutput;
            this.trackOutput = extractorOutput.track(0, 1);
            this.extractorOutput.endTracks();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extractorInput, positionHolder)) == null) {
            if (this.synchronizedHeaderData == 0) {
                try {
                    synchronize(extractorInput, false);
                } catch (EOFException unused) {
                    return -1;
                }
            }
            if (this.seeker == null) {
                Seeker maybeReadSeekFrame = maybeReadSeekFrame(extractorInput);
                this.seeker = maybeReadSeekFrame;
                if (maybeReadSeekFrame == null || (!maybeReadSeekFrame.isSeekable() && (this.flags & 1) != 0)) {
                    this.seeker = getConstantBitrateSeeker(extractorInput);
                }
                this.extractorOutput.seekMap(this.seeker);
                TrackOutput trackOutput = this.trackOutput;
                MpegAudioHeader mpegAudioHeader = this.synchronizedHeader;
                String str = mpegAudioHeader.mimeType;
                int i = mpegAudioHeader.channels;
                int i2 = mpegAudioHeader.sampleRate;
                GaplessInfoHolder gaplessInfoHolder = this.gaplessInfoHolder;
                trackOutput.format(Format.createAudioSampleFormat(null, str, null, -1, 4096, i, i2, -1, gaplessInfoHolder.encoderDelay, gaplessInfoHolder.encoderPadding, null, null, 0, null, (this.flags & 2) != 0 ? null : this.metadata));
            }
            return readSample(extractorInput);
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
            this.synchronizedHeaderData = 0;
            this.basisTimeUs = C.TIME_UNSET;
            this.samplesRead = 0L;
            this.sampleBytesRemaining = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, extractorInput)) == null) ? synchronize(extractorInput, true) : invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Mp3Extractor(int i) {
        this(i, C.TIME_UNSET);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Long) objArr2[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public Mp3Extractor(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Long.valueOf(j)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.flags = i;
        this.forcedFirstSampleTimestampUs = j;
        this.scratch = new ParsableByteArray(10);
        this.synchronizedHeader = new MpegAudioHeader();
        this.gaplessInfoHolder = new GaplessInfoHolder();
        this.basisTimeUs = C.TIME_UNSET;
    }
}
