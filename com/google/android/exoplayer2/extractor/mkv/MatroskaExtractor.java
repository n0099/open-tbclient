package com.google.android.exoplayer2.extractor.mkv;

import android.util.Log;
import android.util.SparseArray;
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
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.HevcConfig;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes4.dex */
public final class MatroskaExtractor implements Extractor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BLOCK_STATE_DATA = 2;
    public static final int BLOCK_STATE_HEADER = 1;
    public static final int BLOCK_STATE_START = 0;
    public static final String CODEC_ID_AAC = "A_AAC";
    public static final String CODEC_ID_AC3 = "A_AC3";
    public static final String CODEC_ID_ACM = "A_MS/ACM";
    public static final String CODEC_ID_ASS = "S_TEXT/ASS";
    public static final String CODEC_ID_DTS = "A_DTS";
    public static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    public static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    public static final String CODEC_ID_DVBSUB = "S_DVBSUB";
    public static final String CODEC_ID_E_AC3 = "A_EAC3";
    public static final String CODEC_ID_FLAC = "A_FLAC";
    public static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    public static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    public static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    public static final String CODEC_ID_MP2 = "A_MPEG/L2";
    public static final String CODEC_ID_MP3 = "A_MPEG/L3";
    public static final String CODEC_ID_MPEG2 = "V_MPEG2";
    public static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    public static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    public static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    public static final String CODEC_ID_OPUS = "A_OPUS";
    public static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    public static final String CODEC_ID_PGS = "S_HDMV/PGS";
    public static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    public static final String CODEC_ID_THEORA = "V_THEORA";
    public static final String CODEC_ID_TRUEHD = "A_TRUEHD";
    public static final String CODEC_ID_VOBSUB = "S_VOBSUB";
    public static final String CODEC_ID_VORBIS = "A_VORBIS";
    public static final String CODEC_ID_VP8 = "V_VP8";
    public static final String CODEC_ID_VP9 = "V_VP9";
    public static final String DOC_TYPE_MATROSKA = "matroska";
    public static final String DOC_TYPE_WEBM = "webm";
    public static final int ENCRYPTION_IV_SIZE = 8;
    public static final ExtractorsFactory FACTORY;
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    public static final int FOURCC_COMPRESSION_VC1 = 826496599;
    public static final int ID_AUDIO = 225;
    public static final int ID_AUDIO_BIT_DEPTH = 25188;
    public static final int ID_BLOCK = 161;
    public static final int ID_BLOCK_DURATION = 155;
    public static final int ID_BLOCK_GROUP = 160;
    public static final int ID_CHANNELS = 159;
    public static final int ID_CLUSTER = 524531317;
    public static final int ID_CODEC_DELAY = 22186;
    public static final int ID_CODEC_ID = 134;
    public static final int ID_CODEC_PRIVATE = 25506;
    public static final int ID_COLOUR = 21936;
    public static final int ID_COLOUR_PRIMARIES = 21947;
    public static final int ID_COLOUR_RANGE = 21945;
    public static final int ID_COLOUR_TRANSFER = 21946;
    public static final int ID_CONTENT_COMPRESSION = 20532;
    public static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    public static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    public static final int ID_CONTENT_ENCODING = 25152;
    public static final int ID_CONTENT_ENCODINGS = 28032;
    public static final int ID_CONTENT_ENCODING_ORDER = 20529;
    public static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    public static final int ID_CONTENT_ENCRYPTION = 20533;
    public static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    public static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    public static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    public static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    public static final int ID_CUES = 475249515;
    public static final int ID_CUE_CLUSTER_POSITION = 241;
    public static final int ID_CUE_POINT = 187;
    public static final int ID_CUE_TIME = 179;
    public static final int ID_CUE_TRACK_POSITIONS = 183;
    public static final int ID_DEFAULT_DURATION = 2352003;
    public static final int ID_DISPLAY_HEIGHT = 21690;
    public static final int ID_DISPLAY_UNIT = 21682;
    public static final int ID_DISPLAY_WIDTH = 21680;
    public static final int ID_DOC_TYPE = 17026;
    public static final int ID_DOC_TYPE_READ_VERSION = 17029;
    public static final int ID_DURATION = 17545;
    public static final int ID_EBML = 440786851;
    public static final int ID_EBML_READ_VERSION = 17143;
    public static final int ID_FLAG_DEFAULT = 136;
    public static final int ID_FLAG_FORCED = 21930;
    public static final int ID_INFO = 357149030;
    public static final int ID_LANGUAGE = 2274716;
    public static final int ID_LUMNINANCE_MAX = 21977;
    public static final int ID_LUMNINANCE_MIN = 21978;
    public static final int ID_MASTERING_METADATA = 21968;
    public static final int ID_MAX_CLL = 21948;
    public static final int ID_MAX_FALL = 21949;
    public static final int ID_PIXEL_HEIGHT = 186;
    public static final int ID_PIXEL_WIDTH = 176;
    public static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
    public static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
    public static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
    public static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
    public static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
    public static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    public static final int ID_PROJECTION = 30320;
    public static final int ID_PROJECTION_PRIVATE = 30322;
    public static final int ID_REFERENCE_BLOCK = 251;
    public static final int ID_SAMPLING_FREQUENCY = 181;
    public static final int ID_SEEK = 19899;
    public static final int ID_SEEK_HEAD = 290298740;
    public static final int ID_SEEK_ID = 21419;
    public static final int ID_SEEK_POSITION = 21420;
    public static final int ID_SEEK_PRE_ROLL = 22203;
    public static final int ID_SEGMENT = 408125543;
    public static final int ID_SEGMENT_INFO = 357149030;
    public static final int ID_SIMPLE_BLOCK = 163;
    public static final int ID_STEREO_MODE = 21432;
    public static final int ID_TIMECODE_SCALE = 2807729;
    public static final int ID_TIME_CODE = 231;
    public static final int ID_TRACKS = 374648427;
    public static final int ID_TRACK_ENTRY = 174;
    public static final int ID_TRACK_NUMBER = 215;
    public static final int ID_TRACK_TYPE = 131;
    public static final int ID_VIDEO = 224;
    public static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
    public static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
    public static final int LACING_EBML = 3;
    public static final int LACING_FIXED_SIZE = 2;
    public static final int LACING_NONE = 0;
    public static final int LACING_XIPH = 1;
    public static final int OPUS_MAX_INPUT_SIZE = 5760;
    public static final byte[] SSA_DIALOGUE_FORMAT;
    public static final byte[] SSA_PREFIX;
    public static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    public static final byte[] SSA_TIMECODE_EMPTY;
    public static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    public static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000;
    public static final byte[] SUBRIP_PREFIX;
    public static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    public static final byte[] SUBRIP_TIMECODE_EMPTY;
    public static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    public static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    public static final String TAG = "MatroskaExtractor";
    public static final int TRACK_TYPE_AUDIO = 2;
    public static final int UNSET_ENTRY_ID = -1;
    public static final int VORBIS_MAX_INPUT_SIZE = 8192;
    public static final int WAVE_FORMAT_EXTENSIBLE = 65534;
    public static final int WAVE_FORMAT_PCM = 1;
    public static final int WAVE_FORMAT_SIZE = 18;
    public static final UUID WAVE_SUBFORMAT_PCM;
    public transient /* synthetic */ FieldHolder $fh;
    public long blockDurationUs;
    public int blockFlags;
    public int blockLacingSampleCount;
    public int blockLacingSampleIndex;
    public int[] blockLacingSampleSizes;
    public int blockState;
    public long blockTimeUs;
    public int blockTrackNumber;
    public int blockTrackNumberLength;
    public long clusterTimecodeUs;
    public LongArray cueClusterPositions;
    public LongArray cueTimesUs;
    public long cuesContentPosition;
    public Track currentTrack;
    public long durationTimecode;
    public long durationUs;
    public final ParsableByteArray encryptionInitializationVector;
    public final ParsableByteArray encryptionSubsampleData;
    public ByteBuffer encryptionSubsampleDataBuffer;
    public ExtractorOutput extractorOutput;
    public final ParsableByteArray nalLength;
    public final ParsableByteArray nalStartCode;
    public final EbmlReader reader;
    public int sampleBytesRead;
    public int sampleBytesWritten;
    public int sampleCurrentNalBytesRemaining;
    public boolean sampleEncodingHandled;
    public boolean sampleInitializationVectorRead;
    public int samplePartitionCount;
    public boolean samplePartitionCountRead;
    public boolean sampleRead;
    public boolean sampleSeenReferenceBlock;
    public byte sampleSignalByte;
    public boolean sampleSignalByteRead;
    public final ParsableByteArray sampleStrippedBytes;
    public final ParsableByteArray scratch;
    public int seekEntryId;
    public final ParsableByteArray seekEntryIdBytes;
    public long seekEntryPosition;
    public boolean seekForCues;
    public final boolean seekForCuesEnabled;
    public long seekPositionAfterBuildingCues;
    public boolean seenClusterPositionForCurrentCuePoint;
    public long segmentContentPosition;
    public long segmentContentSize;
    public boolean sentSeekMap;
    public final ParsableByteArray subtitleSample;
    public long timecodeScale;
    public final SparseArray<Track> tracks;
    public final VarintReader varintReader;
    public final ParsableByteArray vorbisNumPageSamples;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface Flags {
    }

    /* loaded from: classes4.dex */
    public final class InnerEbmlReaderOutput implements EbmlReaderOutput {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MatroskaExtractor this$0;

        public InnerEbmlReaderOutput(MatroskaExtractor matroskaExtractor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {matroskaExtractor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = matroskaExtractor;
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void binaryElement(int i, int i2, ExtractorInput extractorInput) throws IOException, InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, extractorInput) == null) {
                this.this$0.binaryElement(i, i2, extractorInput);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void endMasterElement(int i) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.this$0.endMasterElement(i);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void floatElement(int i, double d) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d)}) == null) {
                this.this$0.floatElement(i, d);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public int getElementType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.this$0.getElementType(i) : invokeI.intValue;
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void integerElement(int i, long j) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.this$0.integerElement(i, j);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public boolean isLevel1Element(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? this.this$0.isLevel1Element(i) : invokeI.booleanValue;
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void startMasterElement(int i, long j, long j2) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.this$0.startMasterElement(i, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void stringElement(int i, String str) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048583, this, i, str) == null) {
                this.this$0.stringElement(i, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Track {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DEFAULT_MAX_CLL = 1000;
        public static final int DEFAULT_MAX_FALL = 200;
        public static final int DISPLAY_UNIT_PIXELS = 0;
        public static final int MAX_CHROMATICITY = 50000;
        public transient /* synthetic */ FieldHolder $fh;
        public int audioBitDepth;
        public int channelCount;
        public long codecDelayNs;
        public String codecId;
        public byte[] codecPrivate;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public int displayHeight;
        public int displayUnit;
        public int displayWidth;
        public DrmInitData drmInitData;
        public boolean flagDefault;
        public boolean flagForced;
        public boolean hasColorInfo;
        public boolean hasContentEncryption;
        public int height;
        public String language;
        public int maxContentLuminance;
        public int maxFrameAverageLuminance;
        public float maxMasteringLuminance;
        public float minMasteringLuminance;
        public int nalUnitLengthFieldLength;
        public int number;
        public TrackOutput output;
        public float primaryBChromaticityX;
        public float primaryBChromaticityY;
        public float primaryGChromaticityX;
        public float primaryGChromaticityY;
        public float primaryRChromaticityX;
        public float primaryRChromaticityY;
        public byte[] projectionData;
        public int sampleRate;
        public byte[] sampleStrippedBytes;
        public long seekPreRollNs;
        public int stereoMode;
        public int type;
        public float whitePointChromaticityX;
        public float whitePointChromaticityY;
        public int width;

        public Track() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.width = -1;
            this.height = -1;
            this.displayWidth = -1;
            this.displayHeight = -1;
            this.displayUnit = 0;
            this.projectionData = null;
            this.stereoMode = -1;
            this.hasColorInfo = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.maxContentLuminance = 1000;
            this.maxFrameAverageLuminance = 200;
            this.primaryRChromaticityX = -1.0f;
            this.primaryRChromaticityY = -1.0f;
            this.primaryGChromaticityX = -1.0f;
            this.primaryGChromaticityY = -1.0f;
            this.primaryBChromaticityX = -1.0f;
            this.primaryBChromaticityY = -1.0f;
            this.whitePointChromaticityX = -1.0f;
            this.whitePointChromaticityY = -1.0f;
            this.maxMasteringLuminance = -1.0f;
            this.minMasteringLuminance = -1.0f;
            this.channelCount = 1;
            this.audioBitDepth = -1;
            this.sampleRate = 8000;
            this.codecDelayNs = 0L;
            this.seekPreRollNs = 0L;
            this.flagDefault = true;
            this.language = "eng";
        }

        private byte[] getHdrStaticInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                    return null;
                }
                byte[] bArr = new byte[25];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.put((byte) 0);
                wrap.putShort((short) ((this.primaryRChromaticityX * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.primaryRChromaticityY * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.primaryGChromaticityX * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.primaryGChromaticityY * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.primaryBChromaticityX * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.primaryBChromaticityY * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.whitePointChromaticityX * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.whitePointChromaticityY * 50000.0f) + 0.5f));
                wrap.putShort((short) (this.maxMasteringLuminance + 0.5f));
                wrap.putShort((short) (this.minMasteringLuminance + 0.5f));
                wrap.putShort((short) this.maxContentLuminance);
                wrap.putShort((short) this.maxFrameAverageLuminance);
                return bArr;
            }
            return (byte[]) invokeV.objValue;
        }

        public static List<byte[]> parseFourCcVc1Private(ParsableByteArray parsableByteArray) throws ParserException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parsableByteArray)) == null) {
                try {
                    parsableByteArray.skipBytes(16);
                    if (parsableByteArray.readLittleEndianUnsignedInt() != 826496599) {
                        return null;
                    }
                    byte[] bArr = parsableByteArray.data;
                    for (int position = parsableByteArray.getPosition() + 20; position < bArr.length - 4; position++) {
                        if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                            return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                        }
                    }
                    throw new ParserException("Failed to find FourCC VC1 initialization data");
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new ParserException("Error parsing FourCC VC1 codec private");
                }
            }
            return (List) invokeL.objValue;
        }

        public static boolean parseMsAcmCodecPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, parsableByteArray)) == null) {
                try {
                    int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                    if (readLittleEndianUnsignedShort == 1) {
                        return true;
                    }
                    if (readLittleEndianUnsignedShort == 65534) {
                        parsableByteArray.setPosition(24);
                        if (parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits()) {
                            if (parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits()) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new ParserException("Error parsing MS/ACM codec private");
                }
            }
            return invokeL.booleanValue;
        }

        public static List<byte[]> parseVorbisCodecPrivate(byte[] bArr) throws ParserException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
                try {
                    if (bArr[0] == 2) {
                        int i = 1;
                        int i2 = 0;
                        while (bArr[i] == -1) {
                            i2 += 255;
                            i++;
                        }
                        int i3 = i + 1;
                        int i4 = i2 + bArr[i];
                        int i5 = 0;
                        while (bArr[i3] == -1) {
                            i5 += 255;
                            i3++;
                        }
                        int i6 = i3 + 1;
                        int i7 = i5 + bArr[i3];
                        if (bArr[i6] == 1) {
                            byte[] bArr2 = new byte[i4];
                            System.arraycopy(bArr, i6, bArr2, 0, i4);
                            int i8 = i6 + i4;
                            if (bArr[i8] == 3) {
                                int i9 = i8 + i7;
                                if (bArr[i9] == 5) {
                                    byte[] bArr3 = new byte[bArr.length - i9];
                                    System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                                    ArrayList arrayList = new ArrayList(2);
                                    arrayList.add(bArr2);
                                    arrayList.add(bArr3);
                                    return arrayList;
                                }
                                throw new ParserException("Error parsing vorbis codec private");
                            }
                            throw new ParserException("Error parsing vorbis codec private");
                        }
                        throw new ParserException("Error parsing vorbis codec private");
                    }
                    throw new ParserException("Error parsing vorbis codec private");
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
            }
            return (List) invokeL.objValue;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public void initializeOutput(ExtractorOutput extractorOutput, int i) throws ParserException {
            char c;
            String str;
            List<byte[]> singletonList;
            String str2;
            List<byte[]> list;
            int i2;
            int i3;
            String str3;
            int pcmEncoding;
            Format createImageSampleFormat;
            int i4;
            int i5;
            int i6;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, extractorOutput, i) == null) {
                String str4 = this.codecId;
                int i7 = 1;
                switch (str4.hashCode()) {
                    case -2095576542:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_MPEG4_AP)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -2095575984:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_MPEG4_SP)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1985379776:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_ACM)) {
                            c = 22;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1784763192:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_TRUEHD)) {
                            c = 17;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1730367663:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_VORBIS)) {
                            c = '\n';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1482641358:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_MP2)) {
                            c = '\r';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1482641357:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_MP3)) {
                            c = 14;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1373388978:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_FOURCC)) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case -933872740:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_DVBSUB)) {
                            c = DecodedBitStreamParser.FS;
                            break;
                        }
                        c = 65535;
                        break;
                    case -538363189:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_MPEG4_ASP)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -538363109:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_H264)) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -425012669:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_VOBSUB)) {
                            c = 26;
                            break;
                        }
                        c = 65535;
                        break;
                    case -356037306:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_DTS_LOSSLESS)) {
                            c = 20;
                            break;
                        }
                        c = 65535;
                        break;
                    case 62923557:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_AAC)) {
                            c = '\f';
                            break;
                        }
                        c = 65535;
                        break;
                    case 62923603:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_AC3)) {
                            c = 15;
                            break;
                        }
                        c = 65535;
                        break;
                    case 62927045:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_DTS)) {
                            c = 18;
                            break;
                        }
                        c = 65535;
                        break;
                    case 82338133:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_VP8)) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 82338134:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_VP9)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 99146302:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_PGS)) {
                            c = 27;
                            break;
                        }
                        c = 65535;
                        break;
                    case 444813526:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_THEORA)) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case 542569478:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_DTS_EXPRESS)) {
                            c = 19;
                            break;
                        }
                        c = 65535;
                        break;
                    case 725957860:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_PCM_INT_LIT)) {
                            c = 23;
                            break;
                        }
                        c = 65535;
                        break;
                    case 738597099:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_ASS)) {
                            c = 25;
                            break;
                        }
                        c = 65535;
                        break;
                    case 855502857:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_H265)) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1422270023:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_SUBRIP)) {
                            c = 24;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1809237540:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_MPEG2)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1950749482:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_E_AC3)) {
                            c = 16;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1950789798:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_FLAC)) {
                            c = 21;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1951062397:
                        if (str4.equals(MatroskaExtractor.CODEC_ID_OPUS)) {
                            c = 11;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                String str5 = MimeTypes.AUDIO_UNKNOWN;
                switch (c) {
                    case 0:
                        str = "video/x-vnd.on2.vp8";
                        str5 = str;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 1:
                        str = "video/x-vnd.on2.vp9";
                        str5 = str;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 2:
                        str = MimeTypes.VIDEO_MPEG2;
                        str5 = str;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 3:
                    case 4:
                    case 5:
                        byte[] bArr = this.codecPrivate;
                        singletonList = bArr == null ? null : Collections.singletonList(bArr);
                        str2 = MimeTypes.VIDEO_MP4V;
                        str5 = str2;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 6:
                        AvcConfig parse = AvcConfig.parse(new ParsableByteArray(this.codecPrivate));
                        list = parse.initializationData;
                        this.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                        str2 = "video/avc";
                        singletonList = list;
                        str5 = str2;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 7:
                        HevcConfig parse2 = HevcConfig.parse(new ParsableByteArray(this.codecPrivate));
                        list = parse2.initializationData;
                        this.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                        str2 = MimeTypes.VIDEO_H265;
                        singletonList = list;
                        str5 = str2;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case '\b':
                        singletonList = parseFourCcVc1Private(new ParsableByteArray(this.codecPrivate));
                        if (singletonList != null) {
                            str2 = MimeTypes.VIDEO_VC1;
                            str5 = str2;
                            i2 = -1;
                            i3 = -1;
                            break;
                        } else {
                            Log.w(MatroskaExtractor.TAG, "Unsupported FourCC. Setting mimeType to video/x-unknown");
                            str5 = MimeTypes.VIDEO_UNKNOWN;
                            i2 = -1;
                            i3 = -1;
                        }
                    case '\t':
                        str5 = MimeTypes.VIDEO_UNKNOWN;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case '\n':
                        singletonList = parseVorbisCodecPrivate(this.codecPrivate);
                        str5 = MimeTypes.AUDIO_VORBIS;
                        i2 = -1;
                        i3 = 8192;
                        break;
                    case 11:
                        singletonList = new ArrayList<>(3);
                        singletonList.add(this.codecPrivate);
                        singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.codecDelayNs).array());
                        singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.seekPreRollNs).array());
                        str5 = MimeTypes.AUDIO_OPUS;
                        i2 = -1;
                        i3 = MatroskaExtractor.OPUS_MAX_INPUT_SIZE;
                        break;
                    case '\f':
                        singletonList = Collections.singletonList(this.codecPrivate);
                        str2 = "audio/mp4a-latm";
                        str5 = str2;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case '\r':
                        str3 = MimeTypes.AUDIO_MPEG_L2;
                        str5 = str3;
                        singletonList = null;
                        i2 = -1;
                        i3 = 4096;
                        break;
                    case 14:
                        str3 = MimeTypes.AUDIO_MPEG;
                        str5 = str3;
                        singletonList = null;
                        i2 = -1;
                        i3 = 4096;
                        break;
                    case 15:
                        str = MimeTypes.AUDIO_AC3;
                        str5 = str;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 16:
                        str = MimeTypes.AUDIO_E_AC3;
                        str5 = str;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 17:
                        str = MimeTypes.AUDIO_TRUEHD;
                        str5 = str;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 18:
                    case 19:
                        str = MimeTypes.AUDIO_DTS;
                        str5 = str;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 20:
                        str = MimeTypes.AUDIO_DTS_HD;
                        str5 = str;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 21:
                        singletonList = Collections.singletonList(this.codecPrivate);
                        str2 = MimeTypes.AUDIO_FLAC;
                        str5 = str2;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 22:
                        if (parseMsAcmCodecPrivate(new ParsableByteArray(this.codecPrivate))) {
                            pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                            if (pcmEncoding == 0) {
                                Log.w(MatroskaExtractor.TAG, "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                            }
                            i2 = pcmEncoding;
                            str5 = MimeTypes.AUDIO_RAW;
                            singletonList = null;
                            i3 = -1;
                            break;
                        } else {
                            Log.w(MatroskaExtractor.TAG, "Non-PCM MS/ACM is unsupported. Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                        }
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                    case 23:
                        pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                        if (pcmEncoding == 0) {
                            Log.w(MatroskaExtractor.TAG, "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to " + MimeTypes.AUDIO_UNKNOWN);
                            singletonList = null;
                            i2 = -1;
                            i3 = -1;
                            break;
                        }
                        i2 = pcmEncoding;
                        str5 = MimeTypes.AUDIO_RAW;
                        singletonList = null;
                        i3 = -1;
                    case 24:
                        str5 = MimeTypes.APPLICATION_SUBRIP;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 25:
                        str5 = MimeTypes.TEXT_SSA;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 26:
                        singletonList = Collections.singletonList(this.codecPrivate);
                        str5 = MimeTypes.APPLICATION_VOBSUB;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 27:
                        str5 = MimeTypes.APPLICATION_PGS;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        break;
                    case 28:
                        byte[] bArr2 = this.codecPrivate;
                        singletonList = Collections.singletonList(new byte[]{bArr2[0], bArr2[1], bArr2[2], bArr2[3]});
                        str5 = MimeTypes.APPLICATION_DVBSUBS;
                        i2 = -1;
                        i3 = -1;
                        break;
                    default:
                        throw new ParserException("Unrecognized codec identifier.");
                }
                int i8 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                if (MimeTypes.isAudio(str5)) {
                    createImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str5, null, -1, i3, this.channelCount, this.sampleRate, i2, singletonList, this.drmInitData, i8, this.language);
                } else if (MimeTypes.isVideo(str5)) {
                    if (this.displayUnit == 0) {
                        int i9 = this.displayWidth;
                        i4 = -1;
                        if (i9 == -1) {
                            i9 = this.width;
                        }
                        this.displayWidth = i9;
                        int i10 = this.displayHeight;
                        if (i10 == -1) {
                            i10 = this.height;
                        }
                        this.displayHeight = i10;
                    } else {
                        i4 = -1;
                    }
                    createImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str5, null, -1, i3, this.width, this.height, -1.0f, singletonList, -1, (this.displayWidth == i4 || (i6 = this.displayHeight) == i4) ? -1.0f : (this.height * i5) / (this.width * i6), this.projectionData, this.stereoMode, this.hasColorInfo ? new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo()) : null, this.drmInitData);
                    i7 = 2;
                } else {
                    if (MimeTypes.APPLICATION_SUBRIP.equals(str5)) {
                        createImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str5, i8, this.language, this.drmInitData);
                    } else if (MimeTypes.TEXT_SSA.equals(str5)) {
                        ArrayList arrayList = new ArrayList(2);
                        arrayList.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                        arrayList.add(this.codecPrivate);
                        createImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str5, null, -1, i8, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList);
                    } else if (!MimeTypes.APPLICATION_VOBSUB.equals(str5) && !MimeTypes.APPLICATION_PGS.equals(str5) && !MimeTypes.APPLICATION_DVBSUBS.equals(str5)) {
                        throw new ParserException("Unexpected MIME type.");
                    } else {
                        createImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str5, null, -1, singletonList, this.language, this.drmInitData);
                    }
                    i7 = 3;
                }
                TrackOutput track = extractorOutput.track(this.number, i7);
                this.output = track;
                track.format(createImageSampleFormat);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1045596259, "Lcom/google/android/exoplayer2/extractor/mkv/MatroskaExtractor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1045596259, "Lcom/google/android/exoplayer2/extractor/mkv/MatroskaExtractor;");
                return;
            }
        }
        FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.1
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
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Extractor[]{new MatroskaExtractor()} : (Extractor[]) invokeV.objValue;
            }
        };
        SUBRIP_PREFIX = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 48, 48, 48, 10};
        SUBRIP_TIMECODE_EMPTY = new byte[]{32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
        SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        SSA_PREFIX = new byte[]{68, 105, 97, 108, 111, 103, 117, Constants.SHORT_PING_CMD_TYPE, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY};
        SSA_TIMECODE_EMPTY = new byte[]{32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
        WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MatroskaExtractor() {
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

    private SeekMap buildSeekMap() {
        InterceptResult invokeV;
        LongArray longArray;
        LongArray longArray2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65542, this)) != null) {
            return (SeekMap) invokeV.objValue;
        }
        if (this.segmentContentPosition != -1 && this.durationUs != C.TIME_UNSET && (longArray = this.cueTimesUs) != null && longArray.size() != 0 && (longArray2 = this.cueClusterPositions) != null && longArray2.size() == this.cueTimesUs.size()) {
            int size = this.cueTimesUs.size();
            int[] iArr = new int[size];
            long[] jArr = new long[size];
            long[] jArr2 = new long[size];
            long[] jArr3 = new long[size];
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                jArr3[i2] = this.cueTimesUs.get(i2);
                jArr[i2] = this.segmentContentPosition + this.cueClusterPositions.get(i2);
            }
            while (true) {
                int i3 = size - 1;
                if (i < i3) {
                    int i4 = i + 1;
                    iArr[i] = (int) (jArr[i4] - jArr[i]);
                    jArr2[i] = jArr3[i4] - jArr3[i];
                    i = i4;
                } else {
                    iArr[i3] = (int) ((this.segmentContentPosition + this.segmentContentSize) - jArr[i3]);
                    jArr2[i3] = this.durationUs - jArr3[i3];
                    this.cueTimesUs = null;
                    this.cueClusterPositions = null;
                    return new ChunkIndex(iArr, jArr, jArr2, jArr3);
                }
            }
        } else {
            this.cueTimesUs = null;
            this.cueClusterPositions = null;
            return new SeekMap.Unseekable(this.durationUs);
        }
    }

    private void commitSampleToOutput(Track track, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, this, track, j) == null) {
            if (CODEC_ID_SUBRIP.equals(track.codecId)) {
                commitSubtitleSample(track, SUBRIP_TIMECODE_FORMAT, 19, 1000L, SUBRIP_TIMECODE_EMPTY);
            } else if (CODEC_ID_ASS.equals(track.codecId)) {
                commitSubtitleSample(track, SSA_TIMECODE_FORMAT, 21, 10000L, SSA_TIMECODE_EMPTY);
            }
            track.output.sampleMetadata(j, this.blockFlags, this.sampleBytesWritten, 0, track.cryptoData);
            this.sampleRead = true;
            resetSample();
        }
    }

    private void commitSubtitleSample(Track track, String str, int i, long j, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{track, str, Integer.valueOf(i), Long.valueOf(j), bArr}) == null) {
            setSampleDuration(this.subtitleSample.data, this.blockDurationUs, str, i, j, bArr);
            TrackOutput trackOutput = track.output;
            ParsableByteArray parsableByteArray = this.subtitleSample;
            trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
            this.sampleBytesWritten += this.subtitleSample.limit();
        }
    }

    public static int[] ensureArrayCapacity(int[] iArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, iArr, i)) == null) {
            if (iArr == null) {
                return new int[i];
            }
            return iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
        }
        return (int[]) invokeLI.objValue;
    }

    public static boolean isCodecSupported(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? CODEC_ID_VP8.equals(str) || CODEC_ID_VP9.equals(str) || CODEC_ID_MPEG2.equals(str) || CODEC_ID_MPEG4_SP.equals(str) || CODEC_ID_MPEG4_ASP.equals(str) || CODEC_ID_MPEG4_AP.equals(str) || CODEC_ID_H264.equals(str) || CODEC_ID_H265.equals(str) || CODEC_ID_FOURCC.equals(str) || CODEC_ID_THEORA.equals(str) || CODEC_ID_OPUS.equals(str) || CODEC_ID_VORBIS.equals(str) || CODEC_ID_AAC.equals(str) || CODEC_ID_MP2.equals(str) || CODEC_ID_MP3.equals(str) || CODEC_ID_AC3.equals(str) || CODEC_ID_E_AC3.equals(str) || CODEC_ID_TRUEHD.equals(str) || CODEC_ID_DTS.equals(str) || CODEC_ID_DTS_EXPRESS.equals(str) || CODEC_ID_DTS_LOSSLESS.equals(str) || CODEC_ID_FLAC.equals(str) || CODEC_ID_ACM.equals(str) || CODEC_ID_PCM_INT_LIT.equals(str) || CODEC_ID_SUBRIP.equals(str) || CODEC_ID_ASS.equals(str) || CODEC_ID_VOBSUB.equals(str) || CODEC_ID_PGS.equals(str) || CODEC_ID_DVBSUB.equals(str) : invokeL.booleanValue;
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65547, this, positionHolder, j)) == null) {
            if (this.seekForCues) {
                this.seekPositionAfterBuildingCues = j;
                positionHolder.position = this.cuesContentPosition;
                this.seekForCues = false;
                return true;
            }
            if (this.sentSeekMap) {
                long j2 = this.seekPositionAfterBuildingCues;
                if (j2 != -1) {
                    positionHolder.position = j2;
                    this.seekPositionAfterBuildingCues = -1L;
                    return true;
                }
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    private void readScratch(ExtractorInput extractorInput, int i) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65548, this, extractorInput, i) == null) || this.scratch.limit() >= i) {
            return;
        }
        if (this.scratch.capacity() < i) {
            ParsableByteArray parsableByteArray = this.scratch;
            byte[] bArr = parsableByteArray.data;
            parsableByteArray.reset(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i)), this.scratch.limit());
        }
        ParsableByteArray parsableByteArray2 = this.scratch;
        extractorInput.readFully(parsableByteArray2.data, parsableByteArray2.limit(), i - this.scratch.limit());
        this.scratch.setLimit(i);
    }

    private int readToOutput(ExtractorInput extractorInput, TrackOutput trackOutput, int i) throws IOException, InterruptedException {
        InterceptResult invokeLLI;
        int sampleData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65549, this, extractorInput, trackOutput, i)) == null) {
            int bytesLeft = this.sampleStrippedBytes.bytesLeft();
            if (bytesLeft > 0) {
                sampleData = Math.min(i, bytesLeft);
                trackOutput.sampleData(this.sampleStrippedBytes, sampleData);
            } else {
                sampleData = trackOutput.sampleData(extractorInput, i, false);
            }
            this.sampleBytesRead += sampleData;
            this.sampleBytesWritten += sampleData;
            return sampleData;
        }
        return invokeLLI.intValue;
    }

    private void readToTarget(ExtractorInput extractorInput, byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65550, this, extractorInput, bArr, i, i2) == null) {
            int min = Math.min(i2, this.sampleStrippedBytes.bytesLeft());
            extractorInput.readFully(bArr, i + min, i2 - min);
            if (min > 0) {
                this.sampleStrippedBytes.readBytes(bArr, i, min);
            }
            this.sampleBytesRead += i2;
        }
    }

    private void resetSample() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.sampleBytesRead = 0;
            this.sampleBytesWritten = 0;
            this.sampleCurrentNalBytesRemaining = 0;
            this.sampleEncodingHandled = false;
            this.sampleSignalByteRead = false;
            this.samplePartitionCountRead = false;
            this.samplePartitionCount = 0;
            this.sampleSignalByte = (byte) 0;
            this.sampleInitializationVectorRead = false;
            this.sampleStrippedBytes.reset();
        }
    }

    private long scaleTimecodeToUs(long j) throws ParserException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65552, this, j)) == null) {
            long j2 = this.timecodeScale;
            if (j2 != C.TIME_UNSET) {
                return Util.scaleLargeTimestamp(j, j2, 1000L);
            }
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return invokeJ.longValue;
    }

    public static void setSampleDuration(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        byte[] utf8Bytes;
        byte[] bArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{bArr, Long.valueOf(j), str, Integer.valueOf(i), Long.valueOf(j2), bArr2}) == null) {
            if (j == C.TIME_UNSET) {
                utf8Bytes = bArr2;
                bArr3 = utf8Bytes;
            } else {
                int i2 = (int) (j / 3600000000L);
                long j3 = j - ((i2 * 3600) * 1000000);
                int i3 = (int) (j3 / 60000000);
                long j4 = j3 - ((i3 * 60) * 1000000);
                int i4 = (int) (j4 / 1000000);
                utf8Bytes = Util.getUtf8Bytes(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j4 - (i4 * 1000000)) / j2))));
                bArr3 = bArr2;
            }
            System.arraycopy(utf8Bytes, 0, bArr, i, bArr3.length);
        }
    }

    private void writeSampleData(ExtractorInput extractorInput, Track track, int i) throws IOException, InterruptedException {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65554, this, extractorInput, track, i) == null) {
            if (CODEC_ID_SUBRIP.equals(track.codecId)) {
                writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i);
            } else if (CODEC_ID_ASS.equals(track.codecId)) {
                writeSubtitleSampleData(extractorInput, SSA_PREFIX, i);
            } else {
                TrackOutput trackOutput = track.output;
                if (!this.sampleEncodingHandled) {
                    if (track.hasContentEncryption) {
                        this.blockFlags &= -1073741825;
                        if (!this.sampleSignalByteRead) {
                            extractorInput.readFully(this.scratch.data, 0, 1);
                            this.sampleBytesRead++;
                            byte[] bArr = this.scratch.data;
                            if ((bArr[0] & 128) != 128) {
                                this.sampleSignalByte = bArr[0];
                                this.sampleSignalByteRead = true;
                            } else {
                                throw new ParserException("Extension bit is set in signal byte");
                            }
                        }
                        if ((this.sampleSignalByte & 1) == 1) {
                            boolean z = (this.sampleSignalByte & 2) == 2;
                            this.blockFlags |= 1073741824;
                            if (!this.sampleInitializationVectorRead) {
                                extractorInput.readFully(this.encryptionInitializationVector.data, 0, 8);
                                this.sampleBytesRead += 8;
                                this.sampleInitializationVectorRead = true;
                                this.scratch.data[0] = (byte) ((z ? 128 : 0) | 8);
                                this.scratch.setPosition(0);
                                trackOutput.sampleData(this.scratch, 1);
                                this.sampleBytesWritten++;
                                this.encryptionInitializationVector.setPosition(0);
                                trackOutput.sampleData(this.encryptionInitializationVector, 8);
                                this.sampleBytesWritten += 8;
                            }
                            if (z) {
                                if (!this.samplePartitionCountRead) {
                                    extractorInput.readFully(this.scratch.data, 0, 1);
                                    this.sampleBytesRead++;
                                    this.scratch.setPosition(0);
                                    this.samplePartitionCount = this.scratch.readUnsignedByte();
                                    this.samplePartitionCountRead = true;
                                }
                                int i3 = this.samplePartitionCount * 4;
                                this.scratch.reset(i3);
                                extractorInput.readFully(this.scratch.data, 0, i3);
                                this.sampleBytesRead += i3;
                                short s = (short) ((this.samplePartitionCount / 2) + 1);
                                int i4 = (s * 6) + 2;
                                ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                                if (byteBuffer == null || byteBuffer.capacity() < i4) {
                                    this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i4);
                                }
                                this.encryptionSubsampleDataBuffer.position(0);
                                this.encryptionSubsampleDataBuffer.putShort(s);
                                int i5 = 0;
                                int i6 = 0;
                                while (true) {
                                    i2 = this.samplePartitionCount;
                                    if (i5 >= i2) {
                                        break;
                                    }
                                    int readUnsignedIntToInt = this.scratch.readUnsignedIntToInt();
                                    if (i5 % 2 == 0) {
                                        this.encryptionSubsampleDataBuffer.putShort((short) (readUnsignedIntToInt - i6));
                                    } else {
                                        this.encryptionSubsampleDataBuffer.putInt(readUnsignedIntToInt - i6);
                                    }
                                    i5++;
                                    i6 = readUnsignedIntToInt;
                                }
                                int i7 = (i - this.sampleBytesRead) - i6;
                                if (i2 % 2 == 1) {
                                    this.encryptionSubsampleDataBuffer.putInt(i7);
                                } else {
                                    this.encryptionSubsampleDataBuffer.putShort((short) i7);
                                    this.encryptionSubsampleDataBuffer.putInt(0);
                                }
                                this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i4);
                                trackOutput.sampleData(this.encryptionSubsampleData, i4);
                                this.sampleBytesWritten += i4;
                            }
                        }
                    } else {
                        byte[] bArr2 = track.sampleStrippedBytes;
                        if (bArr2 != null) {
                            this.sampleStrippedBytes.reset(bArr2, bArr2.length);
                        }
                    }
                    this.sampleEncodingHandled = true;
                }
                int limit = i + this.sampleStrippedBytes.limit();
                if (!CODEC_ID_H264.equals(track.codecId) && !CODEC_ID_H265.equals(track.codecId)) {
                    while (true) {
                        int i8 = this.sampleBytesRead;
                        if (i8 >= limit) {
                            break;
                        }
                        readToOutput(extractorInput, trackOutput, limit - i8);
                    }
                } else {
                    byte[] bArr3 = this.nalLength.data;
                    bArr3[0] = 0;
                    bArr3[1] = 0;
                    bArr3[2] = 0;
                    int i9 = track.nalUnitLengthFieldLength;
                    int i10 = 4 - i9;
                    while (this.sampleBytesRead < limit) {
                        int i11 = this.sampleCurrentNalBytesRemaining;
                        if (i11 == 0) {
                            readToTarget(extractorInput, bArr3, i10, i9);
                            this.nalLength.setPosition(0);
                            this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                            this.nalStartCode.setPosition(0);
                            trackOutput.sampleData(this.nalStartCode, 4);
                            this.sampleBytesWritten += 4;
                        } else {
                            this.sampleCurrentNalBytesRemaining = i11 - readToOutput(extractorInput, trackOutput, i11);
                        }
                    }
                }
                if (CODEC_ID_VORBIS.equals(track.codecId)) {
                    this.vorbisNumPageSamples.setPosition(0);
                    trackOutput.sampleData(this.vorbisNumPageSamples, 4);
                    this.sampleBytesWritten += 4;
                }
            }
        }
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] bArr, int i) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65555, this, extractorInput, bArr, i) == null) {
            int length = bArr.length + i;
            if (this.subtitleSample.capacity() < length) {
                this.subtitleSample.data = Arrays.copyOf(bArr, length + i);
            } else {
                System.arraycopy(bArr, 0, this.subtitleSample.data, 0, bArr.length);
            }
            extractorInput.readFully(this.subtitleSample.data, bArr.length, i);
            this.subtitleSample.reset(length);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x01f9, code lost:
        throw new com.google.android.exoplayer2.ParserException("EBML lacing sample size out of range.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void binaryElement(int i, int i2, ExtractorInput extractorInput) throws IOException, InterruptedException {
        char c;
        int i3;
        int i4;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIIL(1048576, this, i, i2, extractorInput) != null) {
            return;
        }
        int i5 = 0;
        int i6 = 1;
        if (i != 161 && i != 163) {
            if (i == 16981) {
                byte[] bArr = new byte[i2];
                this.currentTrack.sampleStrippedBytes = bArr;
                extractorInput.readFully(bArr, 0, i2);
                return;
            } else if (i == 18402) {
                byte[] bArr2 = new byte[i2];
                extractorInput.readFully(bArr2, 0, i2);
                this.currentTrack.cryptoData = new TrackOutput.CryptoData(1, bArr2, 0, 0);
                return;
            } else if (i == 21419) {
                Arrays.fill(this.seekEntryIdBytes.data, (byte) 0);
                extractorInput.readFully(this.seekEntryIdBytes.data, 4 - i2, i2);
                this.seekEntryIdBytes.setPosition(0);
                this.seekEntryId = (int) this.seekEntryIdBytes.readUnsignedInt();
                return;
            } else if (i == 25506) {
                byte[] bArr3 = new byte[i2];
                this.currentTrack.codecPrivate = bArr3;
                extractorInput.readFully(bArr3, 0, i2);
                return;
            } else if (i == 30322) {
                byte[] bArr4 = new byte[i2];
                this.currentTrack.projectionData = bArr4;
                extractorInput.readFully(bArr4, 0, i2);
                return;
            } else {
                throw new ParserException("Unexpected id: " + i);
            }
        }
        if (this.blockState == 0) {
            this.blockTrackNumber = (int) this.varintReader.readUnsignedVarint(extractorInput, false, true, 8);
            this.blockTrackNumberLength = this.varintReader.getLastLength();
            this.blockDurationUs = C.TIME_UNSET;
            this.blockState = 1;
            this.scratch.reset();
        }
        Track track = this.tracks.get(this.blockTrackNumber);
        if (track == null) {
            extractorInput.skipFully(i2 - this.blockTrackNumberLength);
            this.blockState = 0;
            return;
        }
        if (this.blockState == 1) {
            readScratch(extractorInput, 3);
            int i7 = (this.scratch.data[2] & 6) >> 1;
            byte b = 255;
            if (i7 == 0) {
                this.blockLacingSampleCount = 1;
                int[] ensureArrayCapacity = ensureArrayCapacity(this.blockLacingSampleSizes, 1);
                this.blockLacingSampleSizes = ensureArrayCapacity;
                ensureArrayCapacity[0] = (i2 - this.blockTrackNumberLength) - 3;
            } else if (i == 163) {
                int i8 = 4;
                readScratch(extractorInput, 4);
                int i9 = (this.scratch.data[3] & 255) + 1;
                this.blockLacingSampleCount = i9;
                int[] ensureArrayCapacity2 = ensureArrayCapacity(this.blockLacingSampleSizes, i9);
                this.blockLacingSampleSizes = ensureArrayCapacity2;
                if (i7 == 2) {
                    int i10 = this.blockLacingSampleCount;
                    Arrays.fill(ensureArrayCapacity2, 0, i10, ((i2 - this.blockTrackNumberLength) - 4) / i10);
                } else if (i7 == 1) {
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        i3 = this.blockLacingSampleCount;
                        if (i11 >= i3 - 1) {
                            break;
                        }
                        this.blockLacingSampleSizes[i11] = 0;
                        do {
                            i8++;
                            readScratch(extractorInput, i8);
                            i4 = this.scratch.data[i8 - 1] & 255;
                            iArr = this.blockLacingSampleSizes;
                            iArr[i11] = iArr[i11] + i4;
                        } while (i4 == 255);
                        i12 += iArr[i11];
                        i11++;
                    }
                    this.blockLacingSampleSizes[i3 - 1] = ((i2 - this.blockTrackNumberLength) - i8) - i12;
                } else if (i7 != 3) {
                    throw new ParserException("Unexpected lacing value: " + i7);
                } else {
                    int i13 = 0;
                    int i14 = 0;
                    while (true) {
                        int i15 = this.blockLacingSampleCount;
                        if (i13 < i15 - 1) {
                            this.blockLacingSampleSizes[i13] = i5;
                            i8++;
                            readScratch(extractorInput, i8);
                            int i16 = i8 - 1;
                            if (this.scratch.data[i16] == 0) {
                                throw new ParserException("No valid varint length mask found");
                            }
                            long j = 0;
                            int i17 = 0;
                            while (true) {
                                if (i17 >= 8) {
                                    break;
                                }
                                int i18 = i6 << (7 - i17);
                                if ((this.scratch.data[i16] & i18) != 0) {
                                    i8 += i17;
                                    readScratch(extractorInput, i8);
                                    long j2 = (~i18) & this.scratch.data[i16] & b;
                                    int i19 = i16 + 1;
                                    j = j2;
                                    while (i19 < i8) {
                                        b = 255;
                                        i19++;
                                        j = (j << 8) | (this.scratch.data[i19] & b);
                                    }
                                    if (i13 > 0) {
                                        j -= (1 << ((i17 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i17++;
                                    i6 = 1;
                                    b = 255;
                                }
                            }
                            long j3 = j;
                            if (j3 < -2147483648L || j3 > 2147483647L) {
                                break;
                            }
                            int i20 = (int) j3;
                            int[] iArr2 = this.blockLacingSampleSizes;
                            if (i13 != 0) {
                                i20 += iArr2[i13 - 1];
                            }
                            iArr2[i13] = i20;
                            i14 += this.blockLacingSampleSizes[i13];
                            i13++;
                            i5 = 0;
                            i6 = 1;
                            b = 255;
                        } else {
                            c = 1;
                            this.blockLacingSampleSizes[i15 - 1] = ((i2 - this.blockTrackNumberLength) - i8) - i14;
                            break;
                        }
                    }
                }
            } else {
                throw new ParserException("Lacing only supported in SimpleBlocks.");
            }
            c = 1;
            byte[] bArr5 = this.scratch.data;
            this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((bArr5[c] & 255) | (bArr5[0] << 8));
            this.blockFlags = ((this.scratch.data[2] & 8) == 8 ? Integer.MIN_VALUE : 0) | ((track.type == 2 || (i == 163 && (this.scratch.data[2] & 128) == 128)) ? 1 : 0);
            this.blockState = 2;
            this.blockLacingSampleIndex = 0;
        }
        if (i != 163) {
            writeSampleData(extractorInput, track, this.blockLacingSampleSizes[0]);
            return;
        }
        while (true) {
            int i21 = this.blockLacingSampleIndex;
            if (i21 < this.blockLacingSampleCount) {
                writeSampleData(extractorInput, track, this.blockLacingSampleSizes[i21]);
                commitSampleToOutput(track, this.blockTimeUs + ((this.blockLacingSampleIndex * track.defaultSampleDurationNs) / 1000));
                this.blockLacingSampleIndex++;
            } else {
                this.blockState = 0;
                return;
            }
        }
    }

    public void endMasterElement(int i) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i == 160) {
                if (this.blockState != 2) {
                    return;
                }
                if (!this.sampleSeenReferenceBlock) {
                    this.blockFlags |= 1;
                }
                commitSampleToOutput(this.tracks.get(this.blockTrackNumber), this.blockTimeUs);
                this.blockState = 0;
            } else if (i == 174) {
                if (isCodecSupported(this.currentTrack.codecId)) {
                    Track track = this.currentTrack;
                    track.initializeOutput(this.extractorOutput, track.number);
                    SparseArray<Track> sparseArray = this.tracks;
                    Track track2 = this.currentTrack;
                    sparseArray.put(track2.number, track2);
                }
                this.currentTrack = null;
            } else if (i == 19899) {
                int i2 = this.seekEntryId;
                if (i2 != -1) {
                    long j = this.seekEntryPosition;
                    if (j != -1) {
                        if (i2 == 475249515) {
                            this.cuesContentPosition = j;
                            return;
                        }
                        return;
                    }
                }
                throw new ParserException("Mandatory element SeekID or SeekPosition not found");
            } else if (i == 25152) {
                Track track3 = this.currentTrack;
                if (track3.hasContentEncryption) {
                    if (track3.cryptoData != null) {
                        track3.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C.UUID_NIL, MimeTypes.VIDEO_WEBM, this.currentTrack.cryptoData.encryptionKey));
                        return;
                    }
                    throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                }
            } else if (i == 28032) {
                Track track4 = this.currentTrack;
                if (track4.hasContentEncryption && track4.sampleStrippedBytes != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
            } else if (i == 357149030) {
                if (this.timecodeScale == C.TIME_UNSET) {
                    this.timecodeScale = 1000000L;
                }
                long j2 = this.durationTimecode;
                if (j2 != C.TIME_UNSET) {
                    this.durationUs = scaleTimecodeToUs(j2);
                }
            } else if (i != 374648427) {
                if (i == 475249515 && !this.sentSeekMap) {
                    this.extractorOutput.seekMap(buildSeekMap());
                    this.sentSeekMap = true;
                }
            } else if (this.tracks.size() != 0) {
                this.extractorOutput.endTracks();
            } else {
                throw new ParserException("No valid tracks were found");
            }
        }
    }

    public void floatElement(int i, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d)}) == null) {
            if (i == 181) {
                this.currentTrack.sampleRate = (int) d;
            } else if (i != 17545) {
                switch (i) {
                    case ID_PRIMARY_R_CHROMATICITY_X /* 21969 */:
                        this.currentTrack.primaryRChromaticityX = (float) d;
                        return;
                    case ID_PRIMARY_R_CHROMATICITY_Y /* 21970 */:
                        this.currentTrack.primaryRChromaticityY = (float) d;
                        return;
                    case ID_PRIMARY_G_CHROMATICITY_X /* 21971 */:
                        this.currentTrack.primaryGChromaticityX = (float) d;
                        return;
                    case ID_PRIMARY_G_CHROMATICITY_Y /* 21972 */:
                        this.currentTrack.primaryGChromaticityY = (float) d;
                        return;
                    case ID_PRIMARY_B_CHROMATICITY_X /* 21973 */:
                        this.currentTrack.primaryBChromaticityX = (float) d;
                        return;
                    case ID_PRIMARY_B_CHROMATICITY_Y /* 21974 */:
                        this.currentTrack.primaryBChromaticityY = (float) d;
                        return;
                    case ID_WHITE_POINT_CHROMATICITY_X /* 21975 */:
                        this.currentTrack.whitePointChromaticityX = (float) d;
                        return;
                    case ID_WHITE_POINT_CHROMATICITY_Y /* 21976 */:
                        this.currentTrack.whitePointChromaticityY = (float) d;
                        return;
                    case ID_LUMNINANCE_MAX /* 21977 */:
                        this.currentTrack.maxMasteringLuminance = (float) d;
                        return;
                    case ID_LUMNINANCE_MIN /* 21978 */:
                        this.currentTrack.minMasteringLuminance = (float) d;
                        return;
                    default:
                        return;
                }
            } else {
                this.durationTimecode = (long) d;
            }
        }
    }

    public int getElementType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            switch (i) {
                case 131:
                case 136:
                case 155:
                case 159:
                case ID_PIXEL_WIDTH /* 176 */:
                case 179:
                case ID_PIXEL_HEIGHT /* 186 */:
                case 215:
                case 231:
                case ID_CUE_CLUSTER_POSITION /* 241 */:
                case 251:
                case ID_CONTENT_COMPRESSION_ALGORITHM /* 16980 */:
                case ID_DOC_TYPE_READ_VERSION /* 17029 */:
                case ID_EBML_READ_VERSION /* 17143 */:
                case ID_CONTENT_ENCRYPTION_ALGORITHM /* 18401 */:
                case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /* 18408 */:
                case ID_CONTENT_ENCODING_ORDER /* 20529 */:
                case ID_CONTENT_ENCODING_SCOPE /* 20530 */:
                case ID_SEEK_POSITION /* 21420 */:
                case ID_STEREO_MODE /* 21432 */:
                case ID_DISPLAY_WIDTH /* 21680 */:
                case ID_DISPLAY_UNIT /* 21682 */:
                case ID_DISPLAY_HEIGHT /* 21690 */:
                case ID_FLAG_FORCED /* 21930 */:
                case ID_COLOUR_RANGE /* 21945 */:
                case ID_COLOUR_TRANSFER /* 21946 */:
                case ID_COLOUR_PRIMARIES /* 21947 */:
                case ID_MAX_CLL /* 21948 */:
                case ID_MAX_FALL /* 21949 */:
                case ID_CODEC_DELAY /* 22186 */:
                case ID_SEEK_PRE_ROLL /* 22203 */:
                case ID_AUDIO_BIT_DEPTH /* 25188 */:
                case ID_DEFAULT_DURATION /* 2352003 */:
                case ID_TIMECODE_SCALE /* 2807729 */:
                    return 2;
                case 134:
                case ID_DOC_TYPE /* 17026 */:
                case ID_LANGUAGE /* 2274716 */:
                    return 3;
                case 160:
                case ID_TRACK_ENTRY /* 174 */:
                case 183:
                case ID_CUE_POINT /* 187 */:
                case 224:
                case 225:
                case ID_CONTENT_ENCRYPTION_AES_SETTINGS /* 18407 */:
                case ID_SEEK /* 19899 */:
                case ID_CONTENT_COMPRESSION /* 20532 */:
                case ID_CONTENT_ENCRYPTION /* 20533 */:
                case ID_COLOUR /* 21936 */:
                case ID_MASTERING_METADATA /* 21968 */:
                case ID_CONTENT_ENCODING /* 25152 */:
                case ID_CONTENT_ENCODINGS /* 28032 */:
                case ID_PROJECTION /* 30320 */:
                case ID_SEEK_HEAD /* 290298740 */:
                case 357149030:
                case ID_TRACKS /* 374648427 */:
                case ID_SEGMENT /* 408125543 */:
                case 440786851:
                case ID_CUES /* 475249515 */:
                case ID_CLUSTER /* 524531317 */:
                    return 1;
                case 161:
                case ID_SIMPLE_BLOCK /* 163 */:
                case ID_CONTENT_COMPRESSION_SETTINGS /* 16981 */:
                case ID_CONTENT_ENCRYPTION_KEY_ID /* 18402 */:
                case ID_SEEK_ID /* 21419 */:
                case ID_CODEC_PRIVATE /* 25506 */:
                case ID_PROJECTION_PRIVATE /* 30322 */:
                    return 4;
                case 181:
                case ID_DURATION /* 17545 */:
                case ID_PRIMARY_R_CHROMATICITY_X /* 21969 */:
                case ID_PRIMARY_R_CHROMATICITY_Y /* 21970 */:
                case ID_PRIMARY_G_CHROMATICITY_X /* 21971 */:
                case ID_PRIMARY_G_CHROMATICITY_Y /* 21972 */:
                case ID_PRIMARY_B_CHROMATICITY_X /* 21973 */:
                case ID_PRIMARY_B_CHROMATICITY_Y /* 21974 */:
                case ID_WHITE_POINT_CHROMATICITY_X /* 21975 */:
                case ID_WHITE_POINT_CHROMATICITY_Y /* 21976 */:
                case ID_LUMNINANCE_MAX /* 21977 */:
                case ID_LUMNINANCE_MIN /* 21978 */:
                    return 5;
                default:
                    return 0;
            }
        }
        return invokeI.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, extractorOutput) == null) {
            this.extractorOutput = extractorOutput;
        }
    }

    public void integerElement(int i, long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (i == 20529) {
                if (j == 0) {
                    return;
                }
                throw new ParserException("ContentEncodingOrder " + j + " not supported");
            } else if (i == 20530) {
                if (j == 1) {
                    return;
                }
                throw new ParserException("ContentEncodingScope " + j + " not supported");
            } else {
                switch (i) {
                    case 131:
                        this.currentTrack.type = (int) j;
                        return;
                    case 136:
                        this.currentTrack.flagForced = j == 1;
                        return;
                    case 155:
                        this.blockDurationUs = scaleTimecodeToUs(j);
                        return;
                    case 159:
                        this.currentTrack.channelCount = (int) j;
                        return;
                    case ID_PIXEL_WIDTH /* 176 */:
                        this.currentTrack.width = (int) j;
                        return;
                    case 179:
                        this.cueTimesUs.add(scaleTimecodeToUs(j));
                        return;
                    case ID_PIXEL_HEIGHT /* 186 */:
                        this.currentTrack.height = (int) j;
                        return;
                    case 215:
                        this.currentTrack.number = (int) j;
                        return;
                    case 231:
                        this.clusterTimecodeUs = scaleTimecodeToUs(j);
                        return;
                    case ID_CUE_CLUSTER_POSITION /* 241 */:
                        if (this.seenClusterPositionForCurrentCuePoint) {
                            return;
                        }
                        this.cueClusterPositions.add(j);
                        this.seenClusterPositionForCurrentCuePoint = true;
                        return;
                    case 251:
                        this.sampleSeenReferenceBlock = true;
                        return;
                    case ID_CONTENT_COMPRESSION_ALGORITHM /* 16980 */:
                        if (j == 3) {
                            return;
                        }
                        throw new ParserException("ContentCompAlgo " + j + " not supported");
                    case ID_DOC_TYPE_READ_VERSION /* 17029 */:
                        if (j < 1 || j > 2) {
                            throw new ParserException("DocTypeReadVersion " + j + " not supported");
                        }
                        return;
                    case ID_EBML_READ_VERSION /* 17143 */:
                        if (j == 1) {
                            return;
                        }
                        throw new ParserException("EBMLReadVersion " + j + " not supported");
                    case ID_CONTENT_ENCRYPTION_ALGORITHM /* 18401 */:
                        if (j == 5) {
                            return;
                        }
                        throw new ParserException("ContentEncAlgo " + j + " not supported");
                    case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /* 18408 */:
                        if (j == 1) {
                            return;
                        }
                        throw new ParserException("AESSettingsCipherMode " + j + " not supported");
                    case ID_SEEK_POSITION /* 21420 */:
                        this.seekEntryPosition = j + this.segmentContentPosition;
                        return;
                    case ID_STEREO_MODE /* 21432 */:
                        int i2 = (int) j;
                        if (i2 == 0) {
                            this.currentTrack.stereoMode = 0;
                            return;
                        } else if (i2 == 1) {
                            this.currentTrack.stereoMode = 2;
                            return;
                        } else if (i2 == 3) {
                            this.currentTrack.stereoMode = 1;
                            return;
                        } else if (i2 != 15) {
                            return;
                        } else {
                            this.currentTrack.stereoMode = 3;
                            return;
                        }
                    case ID_DISPLAY_WIDTH /* 21680 */:
                        this.currentTrack.displayWidth = (int) j;
                        return;
                    case ID_DISPLAY_UNIT /* 21682 */:
                        this.currentTrack.displayUnit = (int) j;
                        return;
                    case ID_DISPLAY_HEIGHT /* 21690 */:
                        this.currentTrack.displayHeight = (int) j;
                        return;
                    case ID_FLAG_FORCED /* 21930 */:
                        this.currentTrack.flagDefault = j == 1;
                        return;
                    case ID_CODEC_DELAY /* 22186 */:
                        this.currentTrack.codecDelayNs = j;
                        return;
                    case ID_SEEK_PRE_ROLL /* 22203 */:
                        this.currentTrack.seekPreRollNs = j;
                        return;
                    case ID_AUDIO_BIT_DEPTH /* 25188 */:
                        this.currentTrack.audioBitDepth = (int) j;
                        return;
                    case ID_DEFAULT_DURATION /* 2352003 */:
                        this.currentTrack.defaultSampleDurationNs = (int) j;
                        return;
                    case ID_TIMECODE_SCALE /* 2807729 */:
                        this.timecodeScale = j;
                        return;
                    default:
                        switch (i) {
                            case ID_COLOUR_RANGE /* 21945 */:
                                int i3 = (int) j;
                                if (i3 == 1) {
                                    this.currentTrack.colorRange = 2;
                                    return;
                                } else if (i3 != 2) {
                                    return;
                                } else {
                                    this.currentTrack.colorRange = 1;
                                    return;
                                }
                            case ID_COLOUR_TRANSFER /* 21946 */:
                                int i4 = (int) j;
                                if (i4 != 1) {
                                    if (i4 == 16) {
                                        this.currentTrack.colorTransfer = 6;
                                        return;
                                    } else if (i4 == 18) {
                                        this.currentTrack.colorTransfer = 7;
                                        return;
                                    } else if (i4 != 6 && i4 != 7) {
                                        return;
                                    }
                                }
                                this.currentTrack.colorTransfer = 3;
                                return;
                            case ID_COLOUR_PRIMARIES /* 21947 */:
                                Track track = this.currentTrack;
                                track.hasColorInfo = true;
                                int i5 = (int) j;
                                if (i5 == 1) {
                                    track.colorSpace = 1;
                                    return;
                                } else if (i5 == 9) {
                                    track.colorSpace = 6;
                                    return;
                                } else if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                    this.currentTrack.colorSpace = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case ID_MAX_CLL /* 21948 */:
                                this.currentTrack.maxContentLuminance = (int) j;
                                return;
                            case ID_MAX_FALL /* 21949 */:
                                this.currentTrack.maxFrameAverageLuminance = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            }
        }
    }

    public boolean isLevel1Element(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427 : invokeI.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, extractorInput, positionHolder)) == null) {
            this.sampleRead = false;
            boolean z = true;
            while (z && !this.sampleRead) {
                z = this.reader.read(extractorInput);
                if (z && maybeSeekForCues(positionHolder, extractorInput.getPosition())) {
                    return 1;
                }
            }
            return z ? 0 : -1;
        }
        return invokeLL.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.clusterTimecodeUs = C.TIME_UNSET;
            this.blockState = 0;
            this.reader.reset();
            this.varintReader.reset();
            resetSample();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, extractorInput)) == null) ? new Sniffer().sniff(extractorInput) : invokeL.booleanValue;
    }

    public void startMasterElement(int i, long j, long j2) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (i == 160) {
                this.sampleSeenReferenceBlock = false;
            } else if (i == 174) {
                this.currentTrack = new Track();
            } else if (i == 187) {
                this.seenClusterPositionForCurrentCuePoint = false;
            } else if (i == 19899) {
                this.seekEntryId = -1;
                this.seekEntryPosition = -1L;
            } else if (i == 20533) {
                this.currentTrack.hasContentEncryption = true;
            } else if (i == 21968) {
                this.currentTrack.hasColorInfo = true;
            } else if (i == 408125543) {
                long j3 = this.segmentContentPosition;
                if (j3 != -1 && j3 != j) {
                    throw new ParserException("Multiple Segment elements not supported");
                }
                this.segmentContentPosition = j;
                this.segmentContentSize = j2;
            } else if (i != 475249515) {
                if (i == 524531317 && !this.sentSeekMap) {
                    if (this.seekForCuesEnabled && this.cuesContentPosition != -1) {
                        this.seekForCues = true;
                        return;
                    }
                    this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                    this.sentSeekMap = true;
                }
            } else {
                this.cueTimesUs = new LongArray();
                this.cueClusterPositions = new LongArray();
            }
        }
    }

    public void stringElement(int i, String str) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, str) == null) {
            if (i == 134) {
                this.currentTrack.codecId = str;
            } else if (i != 17026) {
                if (i != 2274716) {
                    return;
                }
                this.currentTrack.language = str;
            } else if (DOC_TYPE_WEBM.equals(str) || DOC_TYPE_MATROSKA.equals(str)) {
            } else {
                throw new ParserException("DocType " + str + " not supported");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MatroskaExtractor(int i) {
        this(new DefaultEbmlReader(), i);
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
                this((EbmlReader) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public MatroskaExtractor(EbmlReader ebmlReader, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ebmlReader, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.segmentContentPosition = -1L;
        this.timecodeScale = C.TIME_UNSET;
        this.durationTimecode = C.TIME_UNSET;
        this.durationUs = C.TIME_UNSET;
        this.cuesContentPosition = -1L;
        this.seekPositionAfterBuildingCues = -1L;
        this.clusterTimecodeUs = C.TIME_UNSET;
        this.reader = ebmlReader;
        ebmlReader.init(new InnerEbmlReaderOutput());
        this.seekForCuesEnabled = (i & 1) == 0;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray<>();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
    }
}
