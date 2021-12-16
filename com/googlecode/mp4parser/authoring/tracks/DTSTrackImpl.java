package com.googlecode.mp4parser.authoring.tracks;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.AbstractMediaHeaderBox;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.DTSSpecificBox;
import com.googlecode.mp4parser.util.CastUtils;
import com.kwad.yoga.YogaNodeJNIBase;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.UShort;
/* loaded from: classes3.dex */
public class DTSTrackImpl extends AbstractTrack {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bcCoreBitRate;
    public int bcCoreChannelMask;
    public int bcCoreMaxSampleRate;
    public int bitrate;
    public int channelCount;
    public int channelMask;
    public int codecDelayAtMaxFs;
    public int coreBitRate;
    public int coreChannelMask;
    public int coreFramePayloadInBytes;
    public int coreMaxSampleRate;
    public boolean coreSubStreamPresent;
    public int dataOffset;
    public DataSource dataSource;
    public DTSSpecificBox ddts;
    public int extAvgBitrate;
    public int extFramePayloadInBytes;
    public int extPeakBitrate;
    public int extSmoothBuffSize;
    public boolean extensionSubStreamPresent;
    public int frameSize;
    public boolean isVBR;
    public String lang;
    public int lbrCodingPresent;
    public int lsbTrimPercent;
    public int maxSampleRate;
    public int numExtSubStreams;
    public int numFramesTotal;
    public int numSamplesOrigAudioAtMaxFs;
    public SampleDescriptionBox sampleDescriptionBox;
    public long[] sampleDurations;
    public int sampleSize;
    public int samplerate;
    public List<Sample> samples;
    public int samplesPerFrame;
    public int samplesPerFrameAtMaxFs;
    public TrackMetaData trackMetaData;
    public String type;

    public DTSTrackImpl(DataSource dataSource, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSource, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.trackMetaData = new TrackMetaData();
        this.frameSize = 0;
        this.dataOffset = 0;
        this.ddts = new DTSSpecificBox();
        this.isVBR = false;
        this.coreSubStreamPresent = false;
        this.extensionSubStreamPresent = false;
        this.numExtSubStreams = 0;
        this.coreMaxSampleRate = 0;
        this.coreBitRate = 0;
        this.coreChannelMask = 0;
        this.coreFramePayloadInBytes = 0;
        this.extAvgBitrate = 0;
        this.extPeakBitrate = 0;
        this.extSmoothBuffSize = 0;
        this.extFramePayloadInBytes = 0;
        this.maxSampleRate = 0;
        this.lbrCodingPresent = 0;
        this.numFramesTotal = 0;
        this.samplesPerFrameAtMaxFs = 0;
        this.numSamplesOrigAudioAtMaxFs = 0;
        this.channelMask = 0;
        this.codecDelayAtMaxFs = 0;
        this.bcCoreMaxSampleRate = 0;
        this.bcCoreBitRate = 0;
        this.bcCoreChannelMask = 0;
        this.lsbTrimPercent = 0;
        this.type = "none";
        this.lang = "eng";
        this.lang = str;
        this.dataSource = dataSource;
        parse();
    }

    private void parse() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (readVariables()) {
                this.sampleDescriptionBox = new SampleDescriptionBox();
                AudioSampleEntry audioSampleEntry = new AudioSampleEntry(this.type);
                audioSampleEntry.setChannelCount(this.channelCount);
                audioSampleEntry.setSampleRate(this.samplerate);
                audioSampleEntry.setDataReferenceIndex(1);
                audioSampleEntry.setSampleSize(16);
                audioSampleEntry.addBox(this.ddts);
                this.sampleDescriptionBox.addBox(audioSampleEntry);
                this.trackMetaData.setCreationTime(new Date());
                this.trackMetaData.setModificationTime(new Date());
                this.trackMetaData.setLanguage(this.lang);
                this.trackMetaData.setTimescale(this.samplerate);
                this.samples = readSamples();
                return;
            }
            throw new IOException();
        }
    }

    private boolean parseAuprhdr(int i2, ByteBuffer byteBuffer) {
        InterceptResult invokeIL;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, byteBuffer)) == null) {
            byteBuffer.get();
            short s = byteBuffer.getShort();
            this.maxSampleRate = (byteBuffer.get() << YogaNodeJNIBase.HAS_NEW_LAYOUT) | (byteBuffer.getShort() & UShort.MAX_VALUE);
            this.numFramesTotal = byteBuffer.getInt();
            this.samplesPerFrameAtMaxFs = byteBuffer.getShort();
            this.numSamplesOrigAudioAtMaxFs = (byteBuffer.get() << 32) | (byteBuffer.getInt() & 65535);
            this.channelMask = byteBuffer.getShort();
            this.codecDelayAtMaxFs = byteBuffer.getShort();
            if ((s & 3) == 3) {
                this.bcCoreMaxSampleRate = (byteBuffer.get() << YogaNodeJNIBase.HAS_NEW_LAYOUT) | (byteBuffer.getShort() & UShort.MAX_VALUE);
                this.bcCoreBitRate = byteBuffer.getShort();
                this.bcCoreChannelMask = byteBuffer.getShort();
                i3 = 28;
            } else {
                i3 = 21;
            }
            if ((s & 4) > 0) {
                this.lsbTrimPercent = byteBuffer.get();
                i3++;
            }
            if ((s & 8) > 0) {
                this.lbrCodingPresent = 1;
            }
            while (i3 < i2) {
                byteBuffer.get();
                i3++;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    private boolean parseCoressmd(int i2, ByteBuffer byteBuffer) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, this, i2, byteBuffer)) == null) {
            this.coreMaxSampleRate = (byteBuffer.get() << YogaNodeJNIBase.HAS_NEW_LAYOUT) | (byteBuffer.getShort() & UShort.MAX_VALUE);
            this.coreBitRate = byteBuffer.getShort();
            this.coreChannelMask = byteBuffer.getShort();
            this.coreFramePayloadInBytes = byteBuffer.getInt();
            for (int i3 = 11; i3 < i2; i3++) {
                byteBuffer.get();
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    private boolean parseDtshdhdr(int i2, ByteBuffer byteBuffer) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65542, this, i2, byteBuffer)) == null) {
            byteBuffer.getInt();
            byteBuffer.get();
            byteBuffer.getInt();
            byteBuffer.get();
            short s = byteBuffer.getShort();
            byteBuffer.get();
            this.numExtSubStreams = byteBuffer.get();
            if ((s & 1) == 1) {
                this.isVBR = true;
            }
            if ((s & 8) == 8) {
                this.coreSubStreamPresent = true;
            }
            if ((s & 16) == 16) {
                this.extensionSubStreamPresent = true;
                this.numExtSubStreams++;
            } else {
                this.numExtSubStreams = 0;
            }
            for (int i3 = 14; i3 < i2; i3++) {
                byteBuffer.get();
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    private boolean parseExtssmd(int i2, ByteBuffer byteBuffer) {
        InterceptResult invokeIL;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65543, this, i2, byteBuffer)) == null) {
            this.extAvgBitrate = (byteBuffer.get() << YogaNodeJNIBase.HAS_NEW_LAYOUT) | (byteBuffer.getShort() & UShort.MAX_VALUE);
            if (this.isVBR) {
                this.extPeakBitrate = (byteBuffer.get() << YogaNodeJNIBase.HAS_NEW_LAYOUT) | (byteBuffer.getShort() & UShort.MAX_VALUE);
                this.extSmoothBuffSize = byteBuffer.getShort();
                i3 = 8;
            } else {
                this.extFramePayloadInBytes = byteBuffer.getInt();
                i3 = 7;
            }
            while (i3 < i2) {
                byteBuffer.get();
                i3++;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    private List<Sample> readSamples() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ArrayList arrayList = new ArrayList(CastUtils.l2i(this.dataSource.size() / this.frameSize));
            int i2 = this.dataOffset;
            while (this.frameSize + i2 < this.dataSource.size()) {
                arrayList.add(new Sample(this, i2) { // from class: com.googlecode.mp4parser.authoring.tracks.DTSTrackImpl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DTSTrackImpl this$0;
                    public final /* synthetic */ int val$currentPosition;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$currentPosition = i2;
                    }

                    @Override // com.googlecode.mp4parser.authoring.Sample
                    public ByteBuffer asByteBuffer() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                            try {
                                return this.this$0.dataSource.map(this.val$currentPosition, this.this$0.frameSize);
                            } catch (IOException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                        return (ByteBuffer) invokeV2.objValue;
                    }

                    @Override // com.googlecode.mp4parser.authoring.Sample
                    public long getSize() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.frameSize : invokeV2.longValue;
                    }

                    @Override // com.googlecode.mp4parser.authoring.Sample
                    public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, writableByteChannel) == null) {
                            this.this$0.dataSource.transferTo(this.val$currentPosition, this.this$0.frameSize, writableByteChannel);
                        }
                    }
                });
                i2 += this.frameSize;
            }
            long[] jArr = new long[arrayList.size()];
            this.sampleDurations = jArr;
            Arrays.fill(jArr, (this.samplesPerFrame * this.samplerate) / this.trackMetaData.getTimescale());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x011b, code lost:
        if (r9 != false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x011d, code lost:
        if (r12 != false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x011f, code lost:
        r2 = 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0123, code lost:
        if (r13 != false) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0125, code lost:
        if (r14 != false) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0128, code lost:
        if (r2 != true) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x012a, code lost:
        if (r4 != false) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x012c, code lost:
        if (r9 != false) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x012e, code lost:
        if (r12 != false) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0130, code lost:
        r2 = 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0134, code lost:
        if (r13 != false) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0137, code lost:
        if (r14 != true) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0139, code lost:
        if (r2 != true) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x013b, code lost:
        if (r4 != false) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x013d, code lost:
        if (r9 != false) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x013f, code lost:
        if (r12 != false) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0141, code lost:
        r2 = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0145, code lost:
        if (r13 != false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0147, code lost:
        if (r14 != false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0149, code lost:
        if (r2 != false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x014b, code lost:
        if (r4 != false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x014e, code lost:
        if (r9 != true) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0150, code lost:
        if (r12 != false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0152, code lost:
        r2 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0156, code lost:
        r2 = r16;
        r4 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x015a, code lost:
        if (r15 != 0) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x015c, code lost:
        if (r13 != false) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x015e, code lost:
        if (r14 != false) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0160, code lost:
        if (r2 != false) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0163, code lost:
        if (r4 != true) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0165, code lost:
        if (r9 != false) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0167, code lost:
        if (r12 != false) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0169, code lost:
        r2 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x016d, code lost:
        if (r15 != 6) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x016f, code lost:
        if (r13 != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0171, code lost:
        if (r14 != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0173, code lost:
        if (r2 != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0176, code lost:
        if (r4 != true) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0178, code lost:
        if (r9 != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x017a, code lost:
        if (r12 != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x017c, code lost:
        r2 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x017f, code lost:
        if (r15 != 0) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0181, code lost:
        if (r13 != false) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0183, code lost:
        if (r14 != false) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0186, code lost:
        if (r2 != true) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0188, code lost:
        if (r4 != false) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x018a, code lost:
        if (r9 != false) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x018c, code lost:
        if (r12 != false) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x018e, code lost:
        r2 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0192, code lost:
        if (r15 != 6) goto L353;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0194, code lost:
        if (r13 != false) goto L353;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0196, code lost:
        if (r14 != false) goto L353;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        r1.getLong();
        r22.dataOffset = r1.position();
        r3 = false;
        r4 = 65535;
        r6 = -1;
        r8 = 65535;
        r9 = false;
        r10 = false;
        r11 = 0;
        r12 = false;
        r13 = false;
        r14 = false;
        r15 = 0;
        r16 = false;
        r17 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0199, code lost:
        if (r2 != true) goto L353;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x019b, code lost:
        if (r4 != false) goto L353;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x019d, code lost:
        if (r9 != false) goto L353;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x019f, code lost:
        if (r12 != false) goto L353;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x01a1, code lost:
        r2 = 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x01a4, code lost:
        if (r15 != 0) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x01a6, code lost:
        if (r13 != false) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x01a8, code lost:
        if (r14 != false) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x01aa, code lost:
        if (r2 != false) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x01ac, code lost:
        if (r4 != false) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x01af, code lost:
        if (r9 != true) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x01b1, code lost:
        if (r12 != false) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x01b3, code lost:
        r2 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x01b6, code lost:
        if (r15 != 2) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x01b8, code lost:
        if (r13 != false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x01ba, code lost:
        if (r14 != false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x01bc, code lost:
        if (r2 != false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x01be, code lost:
        if (r4 != false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (r3 == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x01c1, code lost:
        if (r9 != true) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x01c3, code lost:
        if (r12 != false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x01c5, code lost:
        r2 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x01c7, code lost:
        r22.ddts.setDTSSamplingFrequency(r22.maxSampleRate);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x01d1, code lost:
        if (r22.isVBR == false) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x01d3, code lost:
        r22.ddts.setMaxBitRate((r22.coreBitRate + r22.extPeakBitrate) * 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x01e1, code lost:
        r22.ddts.setMaxBitRate((r22.coreBitRate + r22.extAvgBitrate) * 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x01ee, code lost:
        r22.ddts.setAvgBitRate((r22.coreBitRate + r22.extAvgBitrate) * 1000);
        r22.ddts.setPcmSampleDepth(r22.sampleSize);
        r22.ddts.setFrameDuration(r1);
        r22.ddts.setStreamConstruction(r2);
        r1 = r22.coreChannelMask;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0210, code lost:
        if ((r1 & 8) > 0) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
        r1 = r22.samplesPerFrame;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0213, code lost:
        if ((r1 & 4096) <= 0) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0216, code lost:
        r22.ddts.setCoreLFEPresent(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x021d, code lost:
        r22.ddts.setCoreLFEPresent(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0223, code lost:
        r22.ddts.setCoreLayout(r6);
        r22.ddts.setCoreSize(r22.coreFramePayloadInBytes);
        r22.ddts.setStereoDownmix(0);
        r22.ddts.setRepresentationType(4);
        r22.ddts.setChannelLayout(r22.channelMask);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0244, code lost:
        if (r22.coreMaxSampleRate <= 0) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0248, code lost:
        if (r22.extAvgBitrate <= 0) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x024a, code lost:
        r22.ddts.setMultiAssetFlag(1);
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
        if (r1 == 512) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0252, code lost:
        r2 = 0;
        r22.ddts.setMultiAssetFlag(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0258, code lost:
        r22.ddts.setLBRDurationMod(r22.lbrCodingPresent);
        r22.ddts.setReservedBoxPresent(r2);
        r22.channelCount = r2;
        r1 = 16;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0269, code lost:
        if (r5 < r1) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x026b, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0272, code lost:
        if (((r22.channelMask >> r5) & 1) != 1) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0276, code lost:
        if (r5 == 0) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0278, code lost:
        if (r5 == 12) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
        if (r1 == 1024) goto L373;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x027c, code lost:
        if (r5 == 14) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x027f, code lost:
        if (r5 == 3) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0282, code lost:
        if (r5 == 4) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0285, code lost:
        if (r5 == 7) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0289, code lost:
        if (r5 == 8) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x028b, code lost:
        r22.channelCount += 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0291, code lost:
        r22.channelCount++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x029b, code lost:
        r5 = r5 + 1;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x02a0, code lost:
        r20 = r16;
        r21 = r17;
        r19 = r1.position();
        r5 = r1.getInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x02b2, code lost:
        if (r5 != 2147385345) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x02b4, code lost:
        if (r4 != 1) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x02b6, code lost:
        r16 = r20;
        r17 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x02bc, code lost:
        r2 = new com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer(r1);
        r4 = r2.readBits(1);
        r6 = r2.readBits(5);
        r5 = r2.readBits(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
        if (r1 == 2048) goto L372;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x02ce, code lost:
        if (r4 != 1) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x02d2, code lost:
        if (r6 != 31) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x02d4, code lost:
        if (r5 == 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x02d8, code lost:
        r22.samplesPerFrame = (r2.readBits(7) + 1) * 32;
        r4 = r2.readBits(14);
        r22.frameSize += r4 + 1;
        r7 = r2.readBits(6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x02f9, code lost:
        switch(r2.readBits(4)) {
            case 1: goto L157;
            case 2: goto L156;
            case 3: goto L155;
            case 4: goto L158;
            case 5: goto L158;
            case 6: goto L154;
            case 7: goto L153;
            case 8: goto L152;
            case 9: goto L158;
            case 10: goto L158;
            case 11: goto L151;
            case 12: goto L150;
            case 13: goto L85;
            default: goto L158;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x02fc, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x02fe, code lost:
        r22.samplerate = com.baidu.rtc.record.MediaEncodeParams.AUDIO_SAMPLE_RATE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        if (r1 == 4096) goto L371;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0304, code lost:
        r22.samplerate = 24000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0309, code lost:
        r22.samplerate = com.kuaishou.weapon.un.w0.X3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x030e, code lost:
        r22.samplerate = 44100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0314, code lost:
        r22.samplerate = 22050;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0319, code lost:
        r22.samplerate = 11025;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x031e, code lost:
        r22.samplerate = 32000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0323, code lost:
        r22.samplerate = 16000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0328, code lost:
        r22.samplerate = 8000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0331, code lost:
        switch(r2.readBits(5)) {
            case 0: goto L147;
            case 1: goto L146;
            case 2: goto L145;
            case 3: goto L144;
            case 4: goto L143;
            case 5: goto L142;
            case 6: goto L141;
            case 7: goto L140;
            case 8: goto L139;
            case 9: goto L138;
            case 10: goto L137;
            case 11: goto L136;
            case 12: goto L135;
            case 13: goto L134;
            case 14: goto L133;
            case 15: goto L132;
            case 16: goto L131;
            case 17: goto L130;
            case 18: goto L129;
            case 19: goto L128;
            case 20: goto L127;
            case 21: goto L126;
            case 22: goto L125;
            case 23: goto L124;
            case 24: goto L123;
            case 25: goto L88;
            default: goto L148;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
        r1 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0334, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0336, code lost:
        r22.bitrate = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x033b, code lost:
        r22.bitrate = org.apache.commons.codec.digest4util.PureJavaCrc32C.T8_6_start;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0341, code lost:
        r22.bitrate = 1472;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0347, code lost:
        r22.bitrate = 1411;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x034d, code lost:
        r22.bitrate = 1408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0353, code lost:
        r22.bitrate = 1344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0359, code lost:
        r22.bitrate = 1280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x035f, code lost:
        r22.bitrate = com.googlecode.mp4parser.authoring.tracks.MP3TrackImpl.SAMPLES_PER_FRAME;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0364, code lost:
        r22.bitrate = 1024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0369, code lost:
        r22.bitrate = 960;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x036e, code lost:
        r22.bitrate = 768;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0373, code lost:
        r22.bitrate = 640;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0378, code lost:
        r22.bitrate = 576;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x037d, code lost:
        r22.bitrate = 512;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0382, code lost:
        r22.bitrate = com.baidu.pass.face.platform.utils.FileUtils.S_IRWXU;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x0387, code lost:
        r22.bitrate = 384;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x038c, code lost:
        r22.bitrate = android.support.v4.media.session.MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0391, code lost:
        r22.bitrate = 256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0396, code lost:
        r22.bitrate = com.kuaishou.weapon.un.w0.Q;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x039b, code lost:
        r22.bitrate = 192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x03a0, code lost:
        r22.bitrate = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x03a5, code lost:
        r22.bitrate = 112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x03aa, code lost:
        r22.bitrate = 96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x03af, code lost:
        r22.bitrate = 64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x03b4, code lost:
        r22.bitrate = 56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x03b9, code lost:
        r22.bitrate = 32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x03c2, code lost:
        if (r2.readBits(1) == 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x03c4, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x03c6, code lost:
        r2.readBits(1);
        r2.readBits(1);
        r2.readBits(1);
        r2.readBits(1);
        r15 = r2.readBits(3);
        r11 = r2.readBits(1);
        r2.readBits(1);
        r18 = r3;
        r2.readBits(2);
        r2.readBits(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x03e7, code lost:
        if (r5 != 1) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x03e9, code lost:
        r2.readBits(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x03ee, code lost:
        r2.readBits(1);
        r6 = r2.readBits(4);
        r2.readBits(2);
        r3 = r2.readBits(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x03fe, code lost:
        if (r3 == 0) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0401, code lost:
        if (r3 == 1) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0404, code lost:
        if (r3 == 2) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0407, code lost:
        if (r3 == 3) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x040a, code lost:
        if (r3 == 5) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x040d, code lost:
        if (r3 == 6) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x040f, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0411, code lost:
        r22.sampleSize = 24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x0416, code lost:
        r22.sampleSize = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x041b, code lost:
        r22.sampleSize = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x041f, code lost:
        r2.readBits(1);
        r2.readBits(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0427, code lost:
        if (r6 == 6) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x042a, code lost:
        if (r6 == 7) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x042c, code lost:
        r2.readBits(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0431, code lost:
        r2.readBits(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x0436, code lost:
        r2.readBits(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x043a, code lost:
        r1.position((r19 + r4) + 1);
        r6 = r7;
        r3 = r18;
        r16 = r20;
        r17 = r21;
        r4 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
        if (r1 != (-1)) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x044b, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x044d, code lost:
        r18 = r3;
        r3 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x0456, code lost:
        if (r5 != 1683496997) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x0459, code lost:
        if (r4 != 65535) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x045b, code lost:
        r22.samplesPerFrame = r22.samplesPerFrameAtMaxFs;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x0460, code lost:
        r7 = new com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer(r1);
        r8 = 8;
        r7.readBits(8);
        r7.readBits(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0473, code lost:
        if (r7.readBits(1) != 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x0475, code lost:
        r3 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x0478, code lost:
        r8 = 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x047a, code lost:
        r3 = r7.readBits(r3) + 1;
        r1.position(r19 + (r7.readBits(r8) + 1));
        r7 = r1.getInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0490, code lost:
        if (r7 != 1515870810) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0492, code lost:
        if (r10 != true) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0494, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0496, code lost:
        r16 = r4;
        r8 = r20;
        r17 = r21;
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x04a2, code lost:
        if (r7 != 1191201283) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x04a4, code lost:
        if (r14 != true) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x04a6, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x04a8, code lost:
        r16 = r4;
        r8 = r20;
        r17 = r21;
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x04b3, code lost:
        if (r7 != 496366178) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x04b7, code lost:
        if (r20 != true) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x04b9, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x04bb, code lost:
        r16 = r4;
        r17 = r21;
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x04c1, code lost:
        r8 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x04c6, code lost:
        if (r7 != 1700671838) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x04ca, code lost:
        if (r21 != true) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x04cc, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x04ce, code lost:
        r16 = r4;
        r17 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x04d3, code lost:
        r16 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x04da, code lost:
        if (r7 != 176167201) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x04dc, code lost:
        if (r12 != true) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x04de, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x04e0, code lost:
        r17 = r21;
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x04e7, code lost:
        if (r7 != 1101174087) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0074, code lost:
        if (r6 == 0) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x04e9, code lost:
        if (r9 != true) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x04eb, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x04ed, code lost:
        r17 = r21;
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x04f4, code lost:
        if (r7 != 45126241) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x04f6, code lost:
        if (r13 != true) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x04f8, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x04fa, code lost:
        r17 = r21;
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x04fe, code lost:
        r17 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0500, code lost:
        if (r18 != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0076, code lost:
        if (r6 == 2) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0502, code lost:
        r22.frameSize += r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0507, code lost:
        r1.position(r19 + r3);
        r4 = r16;
        r3 = r18;
        r16 = r8;
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0515, code lost:
        r17 = r21;
        r16 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x051c, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0078, code lost:
        switch(r6) {
            case 4: goto L184;
            case 5: goto L184;
            case 6: goto L184;
            case 7: goto L184;
            case 8: goto L184;
            case 9: goto L184;
            default: goto L183;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
        r6 = 31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007f, code lost:
        if (r4 != 0) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0082, code lost:
        if (r9 != true) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0084, code lost:
        if (r13 != false) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0086, code lost:
        r2 = 17;
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008d, code lost:
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
        r2 = 21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0094, code lost:
        if (r12 != true) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0096, code lost:
        r2 = 18;
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009d, code lost:
        if (r13 != true) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009f, code lost:
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a1, code lost:
        if (r14 != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a3, code lost:
        if (r9 != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a5, code lost:
        r2 = 19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a8, code lost:
        if (r14 != true) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00aa, code lost:
        if (r9 != false) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ac, code lost:
        r2 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00af, code lost:
        if (r14 != false) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b1, code lost:
        if (r9 != true) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b4, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b5, code lost:
        r22.samplerate = r22.maxSampleRate;
        r22.sampleSize = 24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c0, code lost:
        if (r8 >= 1) goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c4, code lost:
        if (r11 <= 0) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
        if (r15 == 0) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c8, code lost:
        if (r15 == 2) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cb, code lost:
        if (r15 == 6) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00cd, code lost:
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00cf, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00d2, code lost:
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
        r2 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00d7, code lost:
        r22.type = "dtsc";
        r2 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00dc, code lost:
        r22.type = "dtsc";
        r2 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e1, code lost:
        r22.type = "dtsc";
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e6, code lost:
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e8, code lost:
        if (r11 != 0) goto L314;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00ea, code lost:
        if (r13 != false) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ed, code lost:
        if (r14 != true) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00ef, code lost:
        r2 = r16;
        r4 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00f3, code lost:
        if (r2 != false) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00f5, code lost:
        if (r4 != false) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00f7, code lost:
        if (r9 != false) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00f9, code lost:
        if (r12 != false) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00fb, code lost:
        r2 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00fe, code lost:
        r2 = r16;
        r4 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0102, code lost:
        if (r13 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0104, code lost:
        if (r14 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0106, code lost:
        if (r2 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0108, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0109, code lost:
        if (r4 != true) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x010b, code lost:
        if (r9 != false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x010d, code lost:
        if (r12 != false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x010f, code lost:
        r2 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0112, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0113, code lost:
        if (r13 != false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0115, code lost:
        if (r14 != r5) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0117, code lost:
        if (r2 != false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0119, code lost:
        if (r4 != r5) goto L288;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean readVariables() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65545, this)) != null) {
            return invokeV.booleanValue;
        }
        ByteBuffer map = this.dataSource.map(0L, 25000L);
        int i2 = map.getInt();
        int i3 = map.getInt();
        if (i2 != 1146377032 || i3 != 1145586770) {
            return false;
        }
        while (true) {
            if ((i2 != 1398035021 || i3 != 1145132097) && map.remaining() > 100) {
                int i4 = (int) map.getLong();
                if (i2 == 1146377032 && i3 == 1145586770) {
                    if (!parseDtshdhdr(i4, map)) {
                        return false;
                    }
                } else if (i2 == 1129271877 && i3 == 1397968196) {
                    if (!parseCoressmd(i4, map)) {
                        return false;
                    }
                } else if (i2 == 1096110162 && i3 == 759710802) {
                    if (!parseAuprhdr(i4, map)) {
                        return false;
                    }
                } else if (i2 != 1163416659 || i3 != 1398754628) {
                    for (int i5 = 0; i5 < i4; i5++) {
                        map.get();
                    }
                } else if (!parseExtssmd(i4, map)) {
                    return false;
                }
                i2 = map.getInt();
                i3 = map.getInt();
            }
        }
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "soun" : (String) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.sampleDescriptionBox : (SampleDescriptionBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.sampleDurations : (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.samples : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.trackMetaData : (TrackMetaData) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.googlecode.mp4parser.authoring.Track
    public AbstractMediaHeaderBox getMediaHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new SoundMediaHeaderBox() : (AbstractMediaHeaderBox) invokeV.objValue;
    }

    public DTSTrackImpl(DataSource dataSource) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.trackMetaData = new TrackMetaData();
        this.frameSize = 0;
        this.dataOffset = 0;
        this.ddts = new DTSSpecificBox();
        this.isVBR = false;
        this.coreSubStreamPresent = false;
        this.extensionSubStreamPresent = false;
        this.numExtSubStreams = 0;
        this.coreMaxSampleRate = 0;
        this.coreBitRate = 0;
        this.coreChannelMask = 0;
        this.coreFramePayloadInBytes = 0;
        this.extAvgBitrate = 0;
        this.extPeakBitrate = 0;
        this.extSmoothBuffSize = 0;
        this.extFramePayloadInBytes = 0;
        this.maxSampleRate = 0;
        this.lbrCodingPresent = 0;
        this.numFramesTotal = 0;
        this.samplesPerFrameAtMaxFs = 0;
        this.numSamplesOrigAudioAtMaxFs = 0;
        this.channelMask = 0;
        this.codecDelayAtMaxFs = 0;
        this.bcCoreMaxSampleRate = 0;
        this.bcCoreBitRate = 0;
        this.bcCoreChannelMask = 0;
        this.lsbTrimPercent = 0;
        this.type = "none";
        this.lang = "eng";
        this.dataSource = dataSource;
        parse();
    }
}
