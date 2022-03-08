package com.google.android.exoplayer2.extractor.ogg;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.FlacStreamInfo;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes7.dex */
public final class FlacReader extends StreamReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte AUDIO_PACKET_TYPE = -1;
    public static final int FRAME_HEADER_SAMPLE_NUMBER_OFFSET = 4;
    public static final byte SEEKTABLE_PACKET_TYPE = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public FlacOggSeeker flacOggSeeker;
    public FlacStreamInfo streamInfo;

    /* loaded from: classes7.dex */
    public class FlacOggSeeker implements OggSeeker, SeekMap {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int METADATA_LENGTH_OFFSET = 1;
        public static final int SEEK_POINT_SIZE = 18;
        public transient /* synthetic */ FieldHolder $fh;
        public long firstFrameOffset;
        public long pendingSeekGranule;
        public long[] seekPointGranules;
        public long[] seekPointOffsets;
        public final /* synthetic */ FlacReader this$0;

        public FlacOggSeeker(FlacReader flacReader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flacReader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flacReader;
            this.firstFrameOffset = -1L;
            this.pendingSeekGranule = -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public SeekMap createSeekMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (SeekMap) invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.streamInfo.durationUs() : invokeV.longValue;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getPosition(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? this.firstFrameOffset + this.seekPointOffsets[Util.binarySearchFloor(this.seekPointGranules, this.this$0.convertTimeToGranule(j2), true, true)] : invokeJ.longValue;
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

        public void parseSeekTable(ParsableByteArray parsableByteArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, parsableByteArray) == null) {
                parsableByteArray.skipBytes(1);
                int readUnsignedInt24 = parsableByteArray.readUnsignedInt24() / 18;
                this.seekPointGranules = new long[readUnsignedInt24];
                this.seekPointOffsets = new long[readUnsignedInt24];
                for (int i2 = 0; i2 < readUnsignedInt24; i2++) {
                    this.seekPointGranules[i2] = parsableByteArray.readLong();
                    this.seekPointOffsets[i2] = parsableByteArray.readLong();
                    parsableByteArray.skipBytes(2);
                }
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long read(ExtractorInput extractorInput) throws IOException, InterruptedException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, extractorInput)) == null) {
                long j2 = this.pendingSeekGranule;
                if (j2 >= 0) {
                    long j3 = -(j2 + 2);
                    this.pendingSeekGranule = -1L;
                    return j3;
                }
                return -1L;
            }
            return invokeL.longValue;
        }

        public void setFirstFrameOffset(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
                this.firstFrameOffset = j2;
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long startSeek(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                long convertTimeToGranule = this.this$0.convertTimeToGranule(j2);
                this.pendingSeekGranule = this.seekPointGranules[Util.binarySearchFloor(this.seekPointGranules, convertTimeToGranule, true, true)];
                return convertTimeToGranule;
            }
            return invokeJ.longValue;
        }
    }

    public FlacReader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private int getFlacFrameBlockSize(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, parsableByteArray)) == null) {
            int i4 = (parsableByteArray.data[2] & 255) >> 4;
            switch (i4) {
                case 1:
                    return 192;
                case 2:
                case 3:
                case 4:
                case 5:
                    i2 = 576;
                    i3 = i4 - 2;
                    break;
                case 6:
                case 7:
                    parsableByteArray.skipBytes(4);
                    parsableByteArray.readUtf8EncodedLong();
                    int readUnsignedByte = i4 == 6 ? parsableByteArray.readUnsignedByte() : parsableByteArray.readUnsignedShort();
                    parsableByteArray.setPosition(0);
                    return readUnsignedByte + 1;
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    i2 = 256;
                    i3 = i4 - 8;
                    break;
                default:
                    return -1;
            }
            return i2 << i3;
        }
        return invokeL.intValue;
    }

    public static boolean isAudioPacket(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) ? bArr[0] == -1 : invokeL.booleanValue;
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parsableByteArray)) == null) ? parsableByteArray.bytesLeft() >= 5 && parsableByteArray.readUnsignedByte() == 127 && parsableByteArray.readUnsignedInt() == 1179402563 : invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long preparePayload(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parsableByteArray)) == null) {
            if (isAudioPacket(parsableByteArray.data)) {
                return getFlacFrameBlockSize(parsableByteArray);
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public boolean readHeaders(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{parsableByteArray, Long.valueOf(j2), setupData})) == null) {
            byte[] bArr = parsableByteArray.data;
            if (this.streamInfo == null) {
                this.streamInfo = new FlacStreamInfo(bArr, 17);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, parsableByteArray.limit());
                copyOfRange[4] = Byte.MIN_VALUE;
                List singletonList = Collections.singletonList(copyOfRange);
                int bitRate = this.streamInfo.bitRate();
                FlacStreamInfo flacStreamInfo = this.streamInfo;
                setupData.format = Format.createAudioSampleFormat(null, MimeTypes.AUDIO_FLAC, null, -1, bitRate, flacStreamInfo.channels, flacStreamInfo.sampleRate, singletonList, null, 0, null);
                return true;
            } else if ((bArr[0] & ByteCompanionObject.MAX_VALUE) == 3) {
                FlacOggSeeker flacOggSeeker = new FlacOggSeeker(this);
                this.flacOggSeeker = flacOggSeeker;
                flacOggSeeker.parseSeekTable(parsableByteArray);
                return true;
            } else if (isAudioPacket(bArr)) {
                FlacOggSeeker flacOggSeeker2 = this.flacOggSeeker;
                if (flacOggSeeker2 != null) {
                    flacOggSeeker2.setFirstFrameOffset(j2);
                    setupData.oggSeeker = this.flacOggSeeker;
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            super.reset(z);
            if (z) {
                this.streamInfo = null;
                this.flacOggSeeker = null;
            }
        }
    }
}
