package com.google.android.exoplayer2.extractor.ts;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.Collections;
/* loaded from: classes7.dex */
public final class H265Reader implements ElementaryStreamReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BLA_W_LP = 16;
    public static final int CRA_NUT = 21;
    public static final int PPS_NUT = 34;
    public static final int PREFIX_SEI_NUT = 39;
    public static final int RASL_R = 9;
    public static final int SPS_NUT = 33;
    public static final int SUFFIX_SEI_NUT = 40;
    public static final String TAG = "H265Reader";
    public static final int VPS_NUT = 32;
    public transient /* synthetic */ FieldHolder $fh;
    public String formatId;
    public boolean hasOutputFormat;
    public TrackOutput output;
    public long pesTimeUs;
    public final NalUnitTargetBuffer pps;
    public final boolean[] prefixFlags;
    public final NalUnitTargetBuffer prefixSei;
    public SampleReader sampleReader;
    public final SeiReader seiReader;
    public final ParsableByteArray seiWrapper;
    public final NalUnitTargetBuffer sps;
    public final NalUnitTargetBuffer suffixSei;
    public long totalBytesWritten;
    public final NalUnitTargetBuffer vps;

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public final class SampleReader {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FIRST_SLICE_FLAG_OFFSET = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isFirstParameterSet;
        public boolean isFirstSlice;
        public boolean lookingForFirstSliceFlag;
        public int nalUnitBytesRead;
        public boolean nalUnitHasKeyframeData;
        public long nalUnitStartPosition;
        public long nalUnitTimeUs;
        public final TrackOutput output;
        public boolean readingSample;
        public boolean sampleIsKeyframe;
        public long samplePosition;
        public long sampleTimeUs;
        public boolean writingParameterSets;

        public SampleReader(TrackOutput trackOutput) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {trackOutput};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.output = trackOutput;
        }

        private void outputSample(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
                boolean z = this.sampleIsKeyframe;
                this.output.sampleMetadata(this.sampleTimeUs, z ? 1 : 0, (int) (this.nalUnitStartPosition - this.samplePosition), i, null);
            }
        }

        public void endNalUnit(long j, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
                if (this.writingParameterSets && this.isFirstSlice) {
                    this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
                    this.writingParameterSets = false;
                } else if (this.isFirstParameterSet || this.isFirstSlice) {
                    if (this.readingSample) {
                        outputSample(i + ((int) (j - this.nalUnitStartPosition)));
                    }
                    this.samplePosition = this.nalUnitStartPosition;
                    this.sampleTimeUs = this.nalUnitTimeUs;
                    this.readingSample = true;
                    this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
                }
            }
        }

        public void readNalUnitData(byte[] bArr, int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i, i2) == null) && this.lookingForFirstSliceFlag) {
                int i3 = this.nalUnitBytesRead;
                int i4 = (i + 2) - i3;
                if (i4 < i2) {
                    if ((bArr[i4] & 128) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.isFirstSlice = z;
                    this.lookingForFirstSliceFlag = false;
                    return;
                }
                this.nalUnitBytesRead = i3 + (i2 - i);
            }
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.lookingForFirstSliceFlag = false;
                this.isFirstSlice = false;
                this.isFirstParameterSet = false;
                this.readingSample = false;
                this.writingParameterSets = false;
            }
        }

        public void startNalUnit(long j, int i, int i2, long j2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                boolean z2 = false;
                this.isFirstSlice = false;
                this.isFirstParameterSet = false;
                this.nalUnitTimeUs = j2;
                this.nalUnitBytesRead = 0;
                this.nalUnitStartPosition = j;
                if (i2 >= 32) {
                    if (!this.writingParameterSets && this.readingSample) {
                        outputSample(i);
                        this.readingSample = false;
                    }
                    if (i2 <= 34) {
                        this.isFirstParameterSet = !this.writingParameterSets;
                        this.writingParameterSets = true;
                    }
                }
                if (i2 >= 16 && i2 <= 21) {
                    z = true;
                } else {
                    z = false;
                }
                this.nalUnitHasKeyframeData = z;
                this.lookingForFirstSliceFlag = (z || i2 <= 9) ? true : true;
            }
        }
    }

    public H265Reader(SeiReader seiReader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {seiReader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.seiReader = seiReader;
        this.prefixFlags = new boolean[3];
        this.vps = new NalUnitTargetBuffer(32, 128);
        this.sps = new NalUnitTargetBuffer(33, 128);
        this.pps = new NalUnitTargetBuffer(34, 128);
        this.prefixSei = new NalUnitTargetBuffer(39, 128);
        this.suffixSei = new NalUnitTargetBuffer(40, 128);
        this.seiWrapper = new ParsableByteArray();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, parsableByteArray) == null) {
            while (parsableByteArray.bytesLeft() > 0) {
                int position = parsableByteArray.getPosition();
                int limit = parsableByteArray.limit();
                byte[] bArr = parsableByteArray.data;
                this.totalBytesWritten += parsableByteArray.bytesLeft();
                this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
                while (position < limit) {
                    int findNalUnit = NalUnitUtil.findNalUnit(bArr, position, limit, this.prefixFlags);
                    if (findNalUnit == limit) {
                        nalUnitData(bArr, position, limit);
                        return;
                    }
                    int h265NalUnitType = NalUnitUtil.getH265NalUnitType(bArr, findNalUnit);
                    int i2 = findNalUnit - position;
                    if (i2 > 0) {
                        nalUnitData(bArr, position, findNalUnit);
                    }
                    int i3 = limit - findNalUnit;
                    long j = this.totalBytesWritten - i3;
                    if (i2 < 0) {
                        i = -i2;
                    } else {
                        i = 0;
                    }
                    endNalUnit(j, i3, i, this.pesTimeUs);
                    startNalUnit(j, i3, h265NalUnitType, this.pesTimeUs);
                    position = findNalUnit + 3;
                }
            }
        }
    }

    private void endNalUnit(long j, int i, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (this.hasOutputFormat) {
                this.sampleReader.endNalUnit(j, i);
            } else {
                this.vps.endNalUnit(i2);
                this.sps.endNalUnit(i2);
                this.pps.endNalUnit(i2);
                if (this.vps.isCompleted() && this.sps.isCompleted() && this.pps.isCompleted()) {
                    this.output.format(parseMediaFormat(this.formatId, this.vps, this.sps, this.pps));
                    this.hasOutputFormat = true;
                }
            }
            if (this.prefixSei.endNalUnit(i2)) {
                NalUnitTargetBuffer nalUnitTargetBuffer = this.prefixSei;
                this.seiWrapper.reset(this.prefixSei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer.nalData, nalUnitTargetBuffer.nalLength));
                this.seiWrapper.skipBytes(5);
                this.seiReader.consume(j2, this.seiWrapper);
            }
            if (this.suffixSei.endNalUnit(i2)) {
                NalUnitTargetBuffer nalUnitTargetBuffer2 = this.suffixSei;
                this.seiWrapper.reset(this.suffixSei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer2.nalData, nalUnitTargetBuffer2.nalLength));
                this.seiWrapper.skipBytes(5);
                this.seiReader.consume(j2, this.seiWrapper);
            }
        }
    }

    private void nalUnitData(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, this, bArr, i, i2) == null) {
            if (this.hasOutputFormat) {
                this.sampleReader.readNalUnitData(bArr, i, i2);
            } else {
                this.vps.appendToNalUnit(bArr, i, i2);
                this.sps.appendToNalUnit(bArr, i, i2);
                this.pps.appendToNalUnit(bArr, i, i2);
            }
            this.prefixSei.appendToNalUnit(bArr, i, i2);
            this.suffixSei.appendToNalUnit(bArr, i, i2);
        }
    }

    public static Format parseMediaFormat(String str, NalUnitTargetBuffer nalUnitTargetBuffer, NalUnitTargetBuffer nalUnitTargetBuffer2, NalUnitTargetBuffer nalUnitTargetBuffer3) {
        InterceptResult invokeLLLL;
        int i;
        float f;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, nalUnitTargetBuffer, nalUnitTargetBuffer2, nalUnitTargetBuffer3)) == null) {
            int i4 = nalUnitTargetBuffer.nalLength;
            byte[] bArr = new byte[nalUnitTargetBuffer2.nalLength + i4 + nalUnitTargetBuffer3.nalLength];
            System.arraycopy(nalUnitTargetBuffer.nalData, 0, bArr, 0, i4);
            System.arraycopy(nalUnitTargetBuffer2.nalData, 0, bArr, nalUnitTargetBuffer.nalLength, nalUnitTargetBuffer2.nalLength);
            System.arraycopy(nalUnitTargetBuffer3.nalData, 0, bArr, nalUnitTargetBuffer.nalLength + nalUnitTargetBuffer2.nalLength, nalUnitTargetBuffer3.nalLength);
            ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(nalUnitTargetBuffer2.nalData, 0, nalUnitTargetBuffer2.nalLength);
            parsableNalUnitBitArray.skipBits(44);
            int readBits = parsableNalUnitBitArray.readBits(3);
            parsableNalUnitBitArray.skipBit();
            parsableNalUnitBitArray.skipBits(88);
            parsableNalUnitBitArray.skipBits(8);
            int i5 = 0;
            for (int i6 = 0; i6 < readBits; i6++) {
                if (parsableNalUnitBitArray.readBit()) {
                    i5 += 89;
                }
                if (parsableNalUnitBitArray.readBit()) {
                    i5 += 8;
                }
            }
            parsableNalUnitBitArray.skipBits(i5);
            if (readBits > 0) {
                parsableNalUnitBitArray.skipBits((8 - readBits) * 2);
            }
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (readUnsignedExpGolombCodedInt == 3) {
                parsableNalUnitBitArray.skipBit();
            }
            int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (parsableNalUnitBitArray.readBit()) {
                int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                if (readUnsignedExpGolombCodedInt != 1 && readUnsignedExpGolombCodedInt != 2) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                if (readUnsignedExpGolombCodedInt == 1) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                readUnsignedExpGolombCodedInt2 -= i2 * (readUnsignedExpGolombCodedInt4 + readUnsignedExpGolombCodedInt5);
                readUnsignedExpGolombCodedInt3 -= i3 * (readUnsignedExpGolombCodedInt6 + readUnsignedExpGolombCodedInt7);
            }
            int i7 = readUnsignedExpGolombCodedInt2;
            int i8 = readUnsignedExpGolombCodedInt3;
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (parsableNalUnitBitArray.readBit()) {
                i = 0;
            } else {
                i = readBits;
            }
            while (i <= readBits) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                i++;
            }
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
                skipScalingList(parsableNalUnitBitArray);
            }
            parsableNalUnitBitArray.skipBits(2);
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBits(8);
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.skipBit();
            }
            skipShortTermRefPicSets(parsableNalUnitBitArray);
            if (parsableNalUnitBitArray.readBit()) {
                for (int i9 = 0; i9 < parsableNalUnitBitArray.readUnsignedExpGolombCodedInt(); i9++) {
                    parsableNalUnitBitArray.skipBits(readUnsignedExpGolombCodedInt8 + 4 + 1);
                }
            }
            parsableNalUnitBitArray.skipBits(2);
            float f2 = 1.0f;
            if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
                int readBits2 = parsableNalUnitBitArray.readBits(8);
                if (readBits2 == 255) {
                    int readBits3 = parsableNalUnitBitArray.readBits(16);
                    int readBits4 = parsableNalUnitBitArray.readBits(16);
                    if (readBits3 != 0 && readBits4 != 0) {
                        f2 = readBits3 / readBits4;
                    }
                    f = f2;
                } else {
                    float[] fArr = NalUnitUtil.ASPECT_RATIO_IDC_VALUES;
                    if (readBits2 < fArr.length) {
                        f = fArr[readBits2];
                    } else {
                        Log.w(TAG, "Unexpected aspect_ratio_idc value: " + readBits2);
                    }
                }
                return Format.createVideoSampleFormat(str, MimeTypes.VIDEO_H265, null, -1, -1, i7, i8, -1.0f, Collections.singletonList(bArr), -1, f, null);
            }
            f = 1.0f;
            return Format.createVideoSampleFormat(str, MimeTypes.VIDEO_H265, null, -1, -1, i7, i8, -1.0f, Collections.singletonList(bArr), -1, f, null);
        }
        return (Format) invokeLLLL.objValue;
    }

    public static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parsableNalUnitBitArray) == null) {
            for (int i = 0; i < 4; i++) {
                int i2 = 0;
                while (i2 < 6) {
                    int i3 = 1;
                    if (!parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    } else {
                        int min = Math.min(64, 1 << ((i << 1) + 4));
                        if (i > 1) {
                            parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                        }
                        for (int i4 = 0; i4 < min; i4++) {
                            parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                        }
                    }
                    if (i == 3) {
                        i3 = 3;
                    }
                    i2 += i3;
                }
            }
        }
    }

    public static void skipShortTermRefPicSets(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, parsableNalUnitBitArray) == null) {
            int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            boolean z = false;
            int i = 0;
            for (int i2 = 0; i2 < readUnsignedExpGolombCodedInt; i2++) {
                if (i2 != 0) {
                    z = parsableNalUnitBitArray.readBit();
                }
                if (z) {
                    parsableNalUnitBitArray.skipBit();
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    for (int i3 = 0; i3 <= i; i3++) {
                        if (parsableNalUnitBitArray.readBit()) {
                            parsableNalUnitBitArray.skipBit();
                        }
                    }
                } else {
                    int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int i4 = readUnsignedExpGolombCodedInt2 + readUnsignedExpGolombCodedInt3;
                    for (int i5 = 0; i5 < readUnsignedExpGolombCodedInt2; i5++) {
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.skipBit();
                    }
                    for (int i6 = 0; i6 < readUnsignedExpGolombCodedInt3; i6++) {
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.skipBit();
                    }
                    i = i4;
                }
            }
        }
    }

    private void startNalUnit(long j, int i, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (this.hasOutputFormat) {
                this.sampleReader.startNalUnit(j, i, i2, j2);
            } else {
                this.vps.startNalUnit(i2);
                this.sps.startNalUnit(i2);
                this.pps.startNalUnit(i2);
            }
            this.prefixSei.startNalUnit(i2);
            this.suffixSei.startNalUnit(i2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extractorOutput, trackIdGenerator) == null) {
            trackIdGenerator.generateNewId();
            this.formatId = trackIdGenerator.getFormatId();
            TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
            this.output = track;
            this.sampleReader = new SampleReader(track);
            this.seiReader.createTracks(extractorOutput, trackIdGenerator);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.pesTimeUs = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            NalUnitUtil.clearPrefixFlags(this.prefixFlags);
            this.vps.reset();
            this.sps.reset();
            this.pps.reset();
            this.prefixSei.reset();
            this.suffixSei.reset();
            this.sampleReader.reset();
            this.totalBytesWritten = 0L;
        }
    }
}
