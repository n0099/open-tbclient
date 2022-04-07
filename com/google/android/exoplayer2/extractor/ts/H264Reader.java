package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
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
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class H264Reader implements ElementaryStreamReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NAL_UNIT_TYPE_PPS = 8;
    public static final int NAL_UNIT_TYPE_SEI = 6;
    public static final int NAL_UNIT_TYPE_SPS = 7;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean allowNonIdrKeyframes;
    public final boolean detectAccessUnits;
    public String formatId;
    public boolean hasOutputFormat;
    public TrackOutput output;
    public long pesTimeUs;
    public final NalUnitTargetBuffer pps;
    public final boolean[] prefixFlags;
    public SampleReader sampleReader;
    public final NalUnitTargetBuffer sei;
    public final SeiReader seiReader;
    public final ParsableByteArray seiWrapper;
    public final NalUnitTargetBuffer sps;
    public long totalBytesWritten;

    /* renamed from: com.google.android.exoplayer2.extractor.ts.H264Reader$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class SampleReader {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DEFAULT_BUFFER_SIZE = 128;
        public static final int NAL_UNIT_TYPE_AUD = 9;
        public static final int NAL_UNIT_TYPE_IDR = 5;
        public static final int NAL_UNIT_TYPE_NON_IDR = 1;
        public static final int NAL_UNIT_TYPE_PARTITION_A = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean allowNonIdrKeyframes;
        public final ParsableNalUnitBitArray bitArray;
        public byte[] buffer;
        public int bufferLength;
        public final boolean detectAccessUnits;
        public boolean isFilling;
        public long nalUnitStartPosition;
        public long nalUnitTimeUs;
        public int nalUnitType;
        public final TrackOutput output;
        public final SparseArray<NalUnitUtil.PpsData> pps;
        public SliceHeaderData previousSliceHeader;
        public boolean readingSample;
        public boolean sampleIsKeyframe;
        public long samplePosition;
        public long sampleTimeUs;
        public SliceHeaderData sliceHeader;
        public final SparseArray<NalUnitUtil.SpsData> sps;

        /* loaded from: classes4.dex */
        public static final class SliceHeaderData {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int SLICE_TYPE_ALL_I = 7;
            public static final int SLICE_TYPE_I = 2;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean bottomFieldFlag;
            public boolean bottomFieldFlagPresent;
            public int deltaPicOrderCnt0;
            public int deltaPicOrderCnt1;
            public int deltaPicOrderCntBottom;
            public boolean fieldPicFlag;
            public int frameNum;
            public boolean hasSliceType;
            public boolean idrPicFlag;
            public int idrPicId;
            public boolean isComplete;
            public int nalRefIdc;
            public int picOrderCntLsb;
            public int picParameterSetId;
            public int sliceType;
            public NalUnitUtil.SpsData spsData;

            public SliceHeaderData() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean isFirstVclNalUnitOfPicture(SliceHeaderData sliceHeaderData) {
                InterceptResult invokeL;
                boolean z;
                boolean z2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, sliceHeaderData)) == null) {
                    if (this.isComplete) {
                        if (!sliceHeaderData.isComplete || this.frameNum != sliceHeaderData.frameNum || this.picParameterSetId != sliceHeaderData.picParameterSetId || this.fieldPicFlag != sliceHeaderData.fieldPicFlag) {
                            return true;
                        }
                        if (this.bottomFieldFlagPresent && sliceHeaderData.bottomFieldFlagPresent && this.bottomFieldFlag != sliceHeaderData.bottomFieldFlag) {
                            return true;
                        }
                        int i = this.nalRefIdc;
                        int i2 = sliceHeaderData.nalRefIdc;
                        if (i != i2 && (i == 0 || i2 == 0)) {
                            return true;
                        }
                        if (this.spsData.picOrderCountType == 0 && sliceHeaderData.spsData.picOrderCountType == 0 && (this.picOrderCntLsb != sliceHeaderData.picOrderCntLsb || this.deltaPicOrderCntBottom != sliceHeaderData.deltaPicOrderCntBottom)) {
                            return true;
                        }
                        if ((this.spsData.picOrderCountType == 1 && sliceHeaderData.spsData.picOrderCountType == 1 && (this.deltaPicOrderCnt0 != sliceHeaderData.deltaPicOrderCnt0 || this.deltaPicOrderCnt1 != sliceHeaderData.deltaPicOrderCnt1)) || (z = this.idrPicFlag) != (z2 = sliceHeaderData.idrPicFlag)) {
                            return true;
                        }
                        if (z && z2 && this.idrPicId != sliceHeaderData.idrPicId) {
                            return true;
                        }
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            public void clear() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.hasSliceType = false;
                    this.isComplete = false;
                }
            }

            public boolean isISlice() {
                InterceptResult invokeV;
                int i;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.hasSliceType && ((i = this.sliceType) == 7 || i == 2) : invokeV.booleanValue;
            }

            public void setAll(NalUnitUtil.SpsData spsData, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{spsData, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                    this.spsData = spsData;
                    this.nalRefIdc = i;
                    this.sliceType = i2;
                    this.frameNum = i3;
                    this.picParameterSetId = i4;
                    this.fieldPicFlag = z;
                    this.bottomFieldFlagPresent = z2;
                    this.bottomFieldFlag = z3;
                    this.idrPicFlag = z4;
                    this.idrPicId = i5;
                    this.picOrderCntLsb = i6;
                    this.deltaPicOrderCntBottom = i7;
                    this.deltaPicOrderCnt0 = i8;
                    this.deltaPicOrderCnt1 = i9;
                    this.isComplete = true;
                    this.hasSliceType = true;
                }
            }

            public void setSliceType(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                    this.sliceType = i;
                    this.hasSliceType = true;
                }
            }

            public /* synthetic */ SliceHeaderData(AnonymousClass1 anonymousClass1) {
                this();
            }
        }

        public SampleReader(TrackOutput trackOutput, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {trackOutput, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.allowNonIdrKeyframes = z;
            this.detectAccessUnits = z2;
            this.sps = new SparseArray<>();
            this.pps = new SparseArray<>();
            this.previousSliceHeader = new SliceHeaderData(null);
            this.sliceHeader = new SliceHeaderData(null);
            byte[] bArr = new byte[128];
            this.buffer = bArr;
            this.bitArray = new ParsableNalUnitBitArray(bArr, 0, 0);
            reset();
        }

        private void outputSample(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
                boolean z = this.sampleIsKeyframe;
                this.output.sampleMetadata(this.sampleTimeUs, z ? 1 : 0, (int) (this.nalUnitStartPosition - this.samplePosition), i, null);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x010a  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x011c  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0122  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0152  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void appendToNalUnit(byte[] bArr, int i, int i2) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int readSignedExpGolombCodedInt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, bArr, i, i2) == null) && this.isFilling) {
                int i8 = i2 - i;
                byte[] bArr2 = this.buffer;
                int length = bArr2.length;
                int i9 = this.bufferLength;
                if (length < i9 + i8) {
                    this.buffer = Arrays.copyOf(bArr2, (i9 + i8) * 2);
                }
                System.arraycopy(bArr, i, this.buffer, this.bufferLength, i8);
                int i10 = this.bufferLength + i8;
                this.bufferLength = i10;
                this.bitArray.reset(this.buffer, 0, i10);
                if (this.bitArray.canReadBits(8)) {
                    this.bitArray.skipBit();
                    int readBits = this.bitArray.readBits(2);
                    this.bitArray.skipBits(5);
                    if (this.bitArray.canReadExpGolombCodedNum()) {
                        this.bitArray.readUnsignedExpGolombCodedInt();
                        if (this.bitArray.canReadExpGolombCodedNum()) {
                            int readUnsignedExpGolombCodedInt = this.bitArray.readUnsignedExpGolombCodedInt();
                            if (!this.detectAccessUnits) {
                                this.isFilling = false;
                                this.sliceHeader.setSliceType(readUnsignedExpGolombCodedInt);
                            } else if (this.bitArray.canReadExpGolombCodedNum()) {
                                int readUnsignedExpGolombCodedInt2 = this.bitArray.readUnsignedExpGolombCodedInt();
                                if (this.pps.indexOfKey(readUnsignedExpGolombCodedInt2) < 0) {
                                    this.isFilling = false;
                                    return;
                                }
                                NalUnitUtil.PpsData ppsData = this.pps.get(readUnsignedExpGolombCodedInt2);
                                NalUnitUtil.SpsData spsData = this.sps.get(ppsData.seqParameterSetId);
                                if (spsData.separateColorPlaneFlag) {
                                    if (!this.bitArray.canReadBits(2)) {
                                        return;
                                    }
                                    this.bitArray.skipBits(2);
                                }
                                if (this.bitArray.canReadBits(spsData.frameNumLength)) {
                                    int readBits2 = this.bitArray.readBits(spsData.frameNumLength);
                                    if (spsData.frameMbsOnlyFlag) {
                                        z = false;
                                    } else if (!this.bitArray.canReadBits(1)) {
                                        return;
                                    } else {
                                        boolean readBit = this.bitArray.readBit();
                                        if (readBit) {
                                            if (this.bitArray.canReadBits(1)) {
                                                z = readBit;
                                                z3 = this.bitArray.readBit();
                                                z2 = true;
                                                z4 = this.nalUnitType != 5;
                                                if (z4) {
                                                    i3 = 0;
                                                } else if (!this.bitArray.canReadExpGolombCodedNum()) {
                                                    return;
                                                } else {
                                                    i3 = this.bitArray.readUnsignedExpGolombCodedInt();
                                                }
                                                i4 = spsData.picOrderCountType;
                                                if (i4 != 0) {
                                                    if (!this.bitArray.canReadBits(spsData.picOrderCntLsbLength)) {
                                                        return;
                                                    }
                                                    int readBits3 = this.bitArray.readBits(spsData.picOrderCntLsbLength);
                                                    if (ppsData.bottomFieldPicOrderInFramePresentFlag && !z) {
                                                        if (this.bitArray.canReadExpGolombCodedNum()) {
                                                            i7 = this.bitArray.readSignedExpGolombCodedInt();
                                                            i5 = readBits3;
                                                            i6 = 0;
                                                            readSignedExpGolombCodedInt = 0;
                                                            this.sliceHeader.setAll(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z, z2, z3, z4, i3, i5, i7, i6, readSignedExpGolombCodedInt);
                                                            this.isFilling = false;
                                                        }
                                                        return;
                                                    }
                                                    i5 = readBits3;
                                                } else if (i4 == 1 && !spsData.deltaPicOrderAlwaysZeroFlag) {
                                                    if (this.bitArray.canReadExpGolombCodedNum()) {
                                                        int readSignedExpGolombCodedInt2 = this.bitArray.readSignedExpGolombCodedInt();
                                                        if (ppsData.bottomFieldPicOrderInFramePresentFlag && !z) {
                                                            if (this.bitArray.canReadExpGolombCodedNum()) {
                                                                readSignedExpGolombCodedInt = this.bitArray.readSignedExpGolombCodedInt();
                                                                i6 = readSignedExpGolombCodedInt2;
                                                                i5 = 0;
                                                                i7 = 0;
                                                                this.sliceHeader.setAll(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z, z2, z3, z4, i3, i5, i7, i6, readSignedExpGolombCodedInt);
                                                                this.isFilling = false;
                                                            }
                                                            return;
                                                        }
                                                        i6 = readSignedExpGolombCodedInt2;
                                                        i5 = 0;
                                                        i7 = 0;
                                                        readSignedExpGolombCodedInt = 0;
                                                        this.sliceHeader.setAll(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z, z2, z3, z4, i3, i5, i7, i6, readSignedExpGolombCodedInt);
                                                        this.isFilling = false;
                                                    }
                                                    return;
                                                } else {
                                                    i5 = 0;
                                                }
                                                i7 = 0;
                                                i6 = 0;
                                                readSignedExpGolombCodedInt = 0;
                                                this.sliceHeader.setAll(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z, z2, z3, z4, i3, i5, i7, i6, readSignedExpGolombCodedInt);
                                                this.isFilling = false;
                                            }
                                            return;
                                        }
                                        z = readBit;
                                    }
                                    z2 = false;
                                    z3 = false;
                                    if (this.nalUnitType != 5) {
                                    }
                                    if (z4) {
                                    }
                                    i4 = spsData.picOrderCountType;
                                    if (i4 != 0) {
                                    }
                                    i7 = 0;
                                    i6 = 0;
                                    readSignedExpGolombCodedInt = 0;
                                    this.sliceHeader.setAll(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z, z2, z3, z4, i3, i5, i7, i6, readSignedExpGolombCodedInt);
                                    this.isFilling = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public void endNalUnit(long j, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
                boolean z = false;
                if (this.nalUnitType == 9 || (this.detectAccessUnits && this.sliceHeader.isFirstVclNalUnitOfPicture(this.previousSliceHeader))) {
                    if (this.readingSample) {
                        outputSample(i + ((int) (j - this.nalUnitStartPosition)));
                    }
                    this.samplePosition = this.nalUnitStartPosition;
                    this.sampleTimeUs = this.nalUnitTimeUs;
                    this.sampleIsKeyframe = false;
                    this.readingSample = true;
                }
                boolean z2 = this.sampleIsKeyframe;
                int i2 = this.nalUnitType;
                if (i2 == 5 || (this.allowNonIdrKeyframes && i2 == 1 && this.sliceHeader.isISlice())) {
                    z = true;
                }
                this.sampleIsKeyframe = z2 | z;
            }
        }

        public boolean needsSpsPps() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.detectAccessUnits : invokeV.booleanValue;
        }

        public void putPps(NalUnitUtil.PpsData ppsData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, ppsData) == null) {
                this.pps.append(ppsData.picParameterSetId, ppsData);
            }
        }

        public void putSps(NalUnitUtil.SpsData spsData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, spsData) == null) {
                this.sps.append(spsData.seqParameterSetId, spsData);
            }
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.isFilling = false;
                this.readingSample = false;
                this.sliceHeader.clear();
            }
        }

        public void startNalUnit(long j, int i, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) {
                this.nalUnitType = i;
                this.nalUnitTimeUs = j2;
                this.nalUnitStartPosition = j;
                if (!this.allowNonIdrKeyframes || i != 1) {
                    if (!this.detectAccessUnits) {
                        return;
                    }
                    int i2 = this.nalUnitType;
                    if (i2 != 5 && i2 != 1 && i2 != 2) {
                        return;
                    }
                }
                SliceHeaderData sliceHeaderData = this.previousSliceHeader;
                this.previousSliceHeader = this.sliceHeader;
                this.sliceHeader = sliceHeaderData;
                sliceHeaderData.clear();
                this.bufferLength = 0;
                this.isFilling = true;
            }
        }
    }

    public H264Reader(SeiReader seiReader, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {seiReader, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
        this.allowNonIdrKeyframes = z;
        this.detectAccessUnits = z2;
        this.prefixFlags = new boolean[3];
        this.sps = new NalUnitTargetBuffer(7, 128);
        this.pps = new NalUnitTargetBuffer(8, 128);
        this.sei = new NalUnitTargetBuffer(6, 128);
        this.seiWrapper = new ParsableByteArray();
    }

    private void endNalUnit(long j, int i, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
                this.sps.endNalUnit(i2);
                this.pps.endNalUnit(i2);
                if (!this.hasOutputFormat) {
                    if (this.sps.isCompleted() && this.pps.isCompleted()) {
                        ArrayList arrayList = new ArrayList();
                        NalUnitTargetBuffer nalUnitTargetBuffer = this.sps;
                        arrayList.add(Arrays.copyOf(nalUnitTargetBuffer.nalData, nalUnitTargetBuffer.nalLength));
                        NalUnitTargetBuffer nalUnitTargetBuffer2 = this.pps;
                        arrayList.add(Arrays.copyOf(nalUnitTargetBuffer2.nalData, nalUnitTargetBuffer2.nalLength));
                        NalUnitTargetBuffer nalUnitTargetBuffer3 = this.sps;
                        NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit(nalUnitTargetBuffer3.nalData, 3, nalUnitTargetBuffer3.nalLength);
                        NalUnitTargetBuffer nalUnitTargetBuffer4 = this.pps;
                        NalUnitUtil.PpsData parsePpsNalUnit = NalUnitUtil.parsePpsNalUnit(nalUnitTargetBuffer4.nalData, 3, nalUnitTargetBuffer4.nalLength);
                        this.output.format(Format.createVideoSampleFormat(this.formatId, "video/avc", null, -1, -1, parseSpsNalUnit.width, parseSpsNalUnit.height, -1.0f, arrayList, -1, parseSpsNalUnit.pixelWidthAspectRatio, null));
                        this.hasOutputFormat = true;
                        this.sampleReader.putSps(parseSpsNalUnit);
                        this.sampleReader.putPps(parsePpsNalUnit);
                        this.sps.reset();
                        this.pps.reset();
                    }
                } else if (this.sps.isCompleted()) {
                    NalUnitTargetBuffer nalUnitTargetBuffer5 = this.sps;
                    this.sampleReader.putSps(NalUnitUtil.parseSpsNalUnit(nalUnitTargetBuffer5.nalData, 3, nalUnitTargetBuffer5.nalLength));
                    this.sps.reset();
                } else if (this.pps.isCompleted()) {
                    NalUnitTargetBuffer nalUnitTargetBuffer6 = this.pps;
                    this.sampleReader.putPps(NalUnitUtil.parsePpsNalUnit(nalUnitTargetBuffer6.nalData, 3, nalUnitTargetBuffer6.nalLength));
                    this.pps.reset();
                }
            }
            if (this.sei.endNalUnit(i2)) {
                NalUnitTargetBuffer nalUnitTargetBuffer7 = this.sei;
                this.seiWrapper.reset(this.sei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer7.nalData, nalUnitTargetBuffer7.nalLength));
                this.seiWrapper.setPosition(4);
                this.seiReader.consume(j2, this.seiWrapper);
            }
            this.sampleReader.endNalUnit(j, i);
        }
    }

    private void nalUnitData(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, this, bArr, i, i2) == null) {
            if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
                this.sps.appendToNalUnit(bArr, i, i2);
                this.pps.appendToNalUnit(bArr, i, i2);
            }
            this.sei.appendToNalUnit(bArr, i, i2);
            this.sampleReader.appendToNalUnit(bArr, i, i2);
        }
    }

    private void startNalUnit(long j, int i, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) {
            if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
                this.sps.startNalUnit(i);
                this.pps.startNalUnit(i);
            }
            this.sei.startNalUnit(i);
            this.sampleReader.startNalUnit(j, i, j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, parsableByteArray) != null) {
            return;
        }
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] bArr = parsableByteArray.data;
        this.totalBytesWritten += parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int findNalUnit = NalUnitUtil.findNalUnit(bArr, position, limit, this.prefixFlags);
            if (findNalUnit == limit) {
                nalUnitData(bArr, position, limit);
                return;
            }
            int nalUnitType = NalUnitUtil.getNalUnitType(bArr, findNalUnit);
            int i = findNalUnit - position;
            if (i > 0) {
                nalUnitData(bArr, position, findNalUnit);
            }
            int i2 = limit - findNalUnit;
            long j = this.totalBytesWritten - i2;
            endNalUnit(j, i2, i < 0 ? -i : 0, this.pesTimeUs);
            startNalUnit(j, nalUnitType, this.pesTimeUs);
            position = findNalUnit + 3;
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
            this.sampleReader = new SampleReader(track, this.allowNonIdrKeyframes, this.detectAccessUnits);
            this.seiReader.createTracks(extractorOutput, trackIdGenerator);
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
            this.pesTimeUs = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            NalUnitUtil.clearPrefixFlags(this.prefixFlags);
            this.sps.reset();
            this.pps.reset();
            this.sei.reset();
            this.sampleReader.reset();
            this.totalBytesWritten = 0L;
        }
    }
}
