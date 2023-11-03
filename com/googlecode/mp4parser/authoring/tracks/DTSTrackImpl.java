package com.googlecode.mp4parser.authoring.tracks;

import com.baidu.searchbox.anr.impl.ANRMonitor;
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
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.UShort;
/* loaded from: classes10.dex */
public class DTSTrackImpl extends AbstractTrack {
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

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "soun";
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        return null;
    }

    public DTSTrackImpl(DataSource dataSource) throws IOException {
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

    public DTSTrackImpl(DataSource dataSource, String str) throws IOException {
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

    private List<Sample> readSamples() throws IOException {
        ArrayList arrayList = new ArrayList(CastUtils.l2i(this.dataSource.size() / this.frameSize));
        final int i = this.dataOffset;
        while (this.frameSize + i < this.dataSource.size()) {
            arrayList.add(new Sample() { // from class: com.googlecode.mp4parser.authoring.tracks.DTSTrackImpl.1
                @Override // com.googlecode.mp4parser.authoring.Sample
                public ByteBuffer asByteBuffer() {
                    try {
                        return DTSTrackImpl.this.dataSource.map(i, DTSTrackImpl.this.frameSize);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override // com.googlecode.mp4parser.authoring.Sample
                public long getSize() {
                    return DTSTrackImpl.this.frameSize;
                }

                @Override // com.googlecode.mp4parser.authoring.Sample
                public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
                    DTSTrackImpl.this.dataSource.transferTo(i, DTSTrackImpl.this.frameSize, writableByteChannel);
                }
            });
            i += this.frameSize;
        }
        long[] jArr = new long[arrayList.size()];
        this.sampleDurations = jArr;
        Arrays.fill(jArr, (this.samplesPerFrame * this.samplerate) / this.trackMetaData.getTimescale());
        return arrayList;
    }

    private boolean parseAuprhdr(int i, ByteBuffer byteBuffer) {
        int i2;
        byteBuffer.get();
        short s = byteBuffer.getShort();
        this.maxSampleRate = (byteBuffer.get() << 16) | (byteBuffer.getShort() & UShort.MAX_VALUE);
        this.numFramesTotal = byteBuffer.getInt();
        this.samplesPerFrameAtMaxFs = byteBuffer.getShort();
        this.numSamplesOrigAudioAtMaxFs = (byteBuffer.get() << 32) | (byteBuffer.getInt() & 65535);
        this.channelMask = byteBuffer.getShort();
        this.codecDelayAtMaxFs = byteBuffer.getShort();
        if ((s & 3) == 3) {
            this.bcCoreMaxSampleRate = (byteBuffer.get() << 16) | (byteBuffer.getShort() & UShort.MAX_VALUE);
            this.bcCoreBitRate = byteBuffer.getShort();
            this.bcCoreChannelMask = byteBuffer.getShort();
            i2 = 28;
        } else {
            i2 = 21;
        }
        if ((s & 4) > 0) {
            this.lsbTrimPercent = byteBuffer.get();
            i2++;
        }
        if ((s & 8) > 0) {
            this.lbrCodingPresent = 1;
        }
        while (i2 < i) {
            byteBuffer.get();
            i2++;
        }
        return true;
    }

    private boolean parseCoressmd(int i, ByteBuffer byteBuffer) {
        this.coreMaxSampleRate = (byteBuffer.get() << 16) | (byteBuffer.getShort() & UShort.MAX_VALUE);
        this.coreBitRate = byteBuffer.getShort();
        this.coreChannelMask = byteBuffer.getShort();
        this.coreFramePayloadInBytes = byteBuffer.getInt();
        for (int i2 = 11; i2 < i; i2++) {
            byteBuffer.get();
        }
        return true;
    }

    private boolean parseDtshdhdr(int i, ByteBuffer byteBuffer) {
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
        for (int i2 = 14; i2 < i; i2++) {
            byteBuffer.get();
        }
        return true;
    }

    private boolean parseExtssmd(int i, ByteBuffer byteBuffer) {
        int i2;
        this.extAvgBitrate = (byteBuffer.get() << 16) | (byteBuffer.getShort() & UShort.MAX_VALUE);
        if (this.isVBR) {
            this.extPeakBitrate = (byteBuffer.get() << 16) | (byteBuffer.getShort() & UShort.MAX_VALUE);
            this.extSmoothBuffSize = byteBuffer.getShort();
            i2 = 8;
        } else {
            this.extFramePayloadInBytes = byteBuffer.getInt();
            i2 = 7;
        }
        while (i2 < i) {
            byteBuffer.get();
            i2++;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x011b, code lost:
        r2 = 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x011f, code lost:
        if (r13 != false) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0121, code lost:
        if (r14 != false) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0124, code lost:
        if (r2 != true) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0126, code lost:
        if (r4 != false) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0128, code lost:
        if (r9 != false) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x012a, code lost:
        if (r12 != false) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x012c, code lost:
        r2 = 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0130, code lost:
        if (r13 != false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0133, code lost:
        if (r14 != true) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0135, code lost:
        if (r2 != true) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0137, code lost:
        if (r4 != false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0139, code lost:
        if (r9 != false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x013b, code lost:
        if (r12 != false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x013d, code lost:
        r2 = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0141, code lost:
        if (r13 != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0143, code lost:
        if (r14 != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0145, code lost:
        if (r2 != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0147, code lost:
        if (r4 != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x014a, code lost:
        if (r9 != true) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x014c, code lost:
        if (r12 != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x014e, code lost:
        r2 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0152, code lost:
        r2 = r16;
        r4 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0156, code lost:
        if (r15 != 0) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0158, code lost:
        if (r13 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x015a, code lost:
        if (r14 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x015c, code lost:
        if (r2 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x015f, code lost:
        if (r4 != true) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0161, code lost:
        if (r9 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0163, code lost:
        if (r12 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0165, code lost:
        r2 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0169, code lost:
        if (r15 != 6) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x016b, code lost:
        if (r13 != false) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x016d, code lost:
        if (r14 != false) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x016f, code lost:
        if (r2 != false) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
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
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0172, code lost:
        if (r4 != true) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0174, code lost:
        if (r9 != false) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0176, code lost:
        if (r12 != false) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0178, code lost:
        r2 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x017b, code lost:
        if (r15 != 0) goto L341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x017d, code lost:
        if (r13 != false) goto L341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x017f, code lost:
        if (r14 != false) goto L341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0182, code lost:
        if (r2 != true) goto L341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0184, code lost:
        if (r4 != false) goto L341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0186, code lost:
        if (r9 != false) goto L341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0188, code lost:
        if (r12 != false) goto L341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x018a, code lost:
        r2 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x018e, code lost:
        if (r15 != 6) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0190, code lost:
        if (r13 != false) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0192, code lost:
        if (r14 != false) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0195, code lost:
        if (r2 != true) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
        if (r3 == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0197, code lost:
        if (r4 != false) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0199, code lost:
        if (r9 != false) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x019b, code lost:
        if (r12 != false) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x019d, code lost:
        r2 = 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01a0, code lost:
        if (r15 != 0) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x01a2, code lost:
        if (r13 != false) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x01a4, code lost:
        if (r14 != false) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x01a6, code lost:
        if (r2 != false) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x01a8, code lost:
        if (r4 != false) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
        r1 = r22.samplesPerFrame;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x01ab, code lost:
        if (r9 != true) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x01ad, code lost:
        if (r12 != false) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x01af, code lost:
        r2 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x01b2, code lost:
        if (r15 != 2) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x01b4, code lost:
        if (r13 != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x01b6, code lost:
        if (r14 != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x01b8, code lost:
        if (r2 != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x01ba, code lost:
        if (r4 != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x01bd, code lost:
        if (r9 != true) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (r1 == 512) goto L372;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x01bf, code lost:
        if (r12 != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x01c1, code lost:
        r2 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x01c3, code lost:
        r22.ddts.setDTSSamplingFrequency(r22.maxSampleRate);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x01cd, code lost:
        if (r22.isVBR == false) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x01cf, code lost:
        r22.ddts.setMaxBitRate((r22.coreBitRate + r22.extPeakBitrate) * 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x01dd, code lost:
        r22.ddts.setMaxBitRate((r22.coreBitRate + r22.extAvgBitrate) * 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x01ea, code lost:
        r22.ddts.setAvgBitRate((r22.coreBitRate + r22.extAvgBitrate) * 1000);
        r22.ddts.setPcmSampleDepth(r22.sampleSize);
        r22.ddts.setFrameDuration(r1);
        r22.ddts.setStreamConstruction(r2);
        r1 = r22.coreChannelMask;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x020c, code lost:
        if ((r1 & 8) > 0) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x020f, code lost:
        if ((r1 & 4096) <= 0) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
        if (r1 == 1024) goto L371;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0212, code lost:
        r22.ddts.setCoreLFEPresent(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0219, code lost:
        r22.ddts.setCoreLFEPresent(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x021f, code lost:
        r22.ddts.setCoreLayout(r6);
        r22.ddts.setCoreSize(r22.coreFramePayloadInBytes);
        r22.ddts.setStereoDownmix(0);
        r22.ddts.setRepresentationType(4);
        r22.ddts.setChannelLayout(r22.channelMask);
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0240, code lost:
        if (r22.coreMaxSampleRate <= 0) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0244, code lost:
        if (r22.extAvgBitrate <= 0) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0246, code lost:
        r22.ddts.setMultiAssetFlag(1);
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x024e, code lost:
        r2 = 0;
        r22.ddts.setMultiAssetFlag(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0254, code lost:
        r22.ddts.setLBRDurationMod(r22.lbrCodingPresent);
        r22.ddts.setReservedBoxPresent(r2);
        r22.channelCount = r2;
        r1 = 16;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0265, code lost:
        if (r5 < r1) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0267, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x026e, code lost:
        if (((r22.channelMask >> r5) & 1) != 1) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0272, code lost:
        if (r5 == 0) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0274, code lost:
        if (r5 == 12) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0278, code lost:
        if (r5 == 14) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
        if (r1 == 2048) goto L370;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x027b, code lost:
        if (r5 == 3) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x027e, code lost:
        if (r5 == 4) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0281, code lost:
        if (r5 == 7) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0285, code lost:
        if (r5 == 8) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0287, code lost:
        r22.channelCount += 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x028d, code lost:
        r22.channelCount++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
        if (r1 == 4096) goto L369;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0297, code lost:
        r5 = r5 + 1;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x029c, code lost:
        r20 = r16;
        r21 = r17;
        r19 = r1.position();
        r5 = r1.getInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x02ae, code lost:
        if (r5 != 2147385345) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x02b0, code lost:
        if (r4 != 1) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x02b2, code lost:
        r16 = r20;
        r17 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x02b8, code lost:
        r2 = new com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer(r1);
        r4 = r2.readBits(1);
        r6 = r2.readBits(5);
        r5 = r2.readBits(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x02ca, code lost:
        if (r4 != 1) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
        r1 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x02ce, code lost:
        if (r6 != 31) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x02d0, code lost:
        if (r5 == 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x02d4, code lost:
        r22.samplesPerFrame = (r2.readBits(7) + 1) * 32;
        r4 = r2.readBits(14);
        r22.frameSize += r4 + 1;
        r7 = r2.readBits(6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x02f5, code lost:
        switch(r2.readBits(4)) {
            case 1: goto L155;
            case 2: goto L154;
            case 3: goto L153;
            case 4: goto L156;
            case 5: goto L156;
            case 6: goto L152;
            case 7: goto L151;
            case 8: goto L150;
            case 9: goto L156;
            case 10: goto L156;
            case 11: goto L149;
            case 12: goto L148;
            case 13: goto L83;
            default: goto L156;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x02f8, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x02fa, code lost:
        r22.samplerate = com.google.android.exoplayer2.extractor.ogg.OpusReader.SAMPLE_RATE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0300, code lost:
        r22.samplerate = 24000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0305, code lost:
        r22.samplerate = 12000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x030a, code lost:
        r22.samplerate = 44100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0310, code lost:
        r22.samplerate = 22050;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0315, code lost:
        r22.samplerate = 11025;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x031a, code lost:
        r22.samplerate = 32000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x031f, code lost:
        r22.samplerate = 16000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0324, code lost:
        r22.samplerate = 8000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x032d, code lost:
        switch(r2.readBits(5)) {
            case 0: goto L145;
            case 1: goto L144;
            case 2: goto L143;
            case 3: goto L142;
            case 4: goto L141;
            case 5: goto L140;
            case 6: goto L139;
            case 7: goto L138;
            case 8: goto L137;
            case 9: goto L136;
            case 10: goto L135;
            case 11: goto L134;
            case 12: goto L133;
            case 13: goto L132;
            case 14: goto L131;
            case 15: goto L130;
            case 16: goto L129;
            case 17: goto L128;
            case 18: goto L127;
            case 19: goto L126;
            case 20: goto L125;
            case 21: goto L124;
            case 22: goto L123;
            case 23: goto L122;
            case 24: goto L121;
            case 25: goto L86;
            default: goto L146;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0330, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0332, code lost:
        r22.bitrate = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0337, code lost:
        r22.bitrate = 1536;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x033d, code lost:
        r22.bitrate = 1472;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0343, code lost:
        r22.bitrate = 1411;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0349, code lost:
        r22.bitrate = 1408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x034f, code lost:
        r22.bitrate = 1344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0355, code lost:
        r22.bitrate = 1280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x035b, code lost:
        r22.bitrate = com.googlecode.mp4parser.authoring.tracks.MP3TrackImpl.SAMPLES_PER_FRAME;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0360, code lost:
        r22.bitrate = 1024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0365, code lost:
        r22.bitrate = 960;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x036a, code lost:
        r22.bitrate = 768;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x036f, code lost:
        r22.bitrate = 640;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0374, code lost:
        r22.bitrate = 576;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0379, code lost:
        r22.bitrate = 512;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x037e, code lost:
        r22.bitrate = com.baidu.pass.face.platform.utils.FileUtils.S_IRWXU;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0383, code lost:
        r22.bitrate = 384;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0388, code lost:
        r22.bitrate = 320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x038d, code lost:
        r22.bitrate = 256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0392, code lost:
        r22.bitrate = 224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0397, code lost:
        r22.bitrate = 192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x039c, code lost:
        r22.bitrate = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x03a1, code lost:
        r22.bitrate = 112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x03a6, code lost:
        r22.bitrate = 96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x03ab, code lost:
        r22.bitrate = 64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x03b0, code lost:
        r22.bitrate = 56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x03b5, code lost:
        r22.bitrate = 32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x03be, code lost:
        if (r2.readBits(1) == 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x03c0, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x03c2, code lost:
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
    /* JADX WARN: Code restructure failed: missing block: B:281:0x03e3, code lost:
        if (r5 != 1) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x03e5, code lost:
        r2.readBits(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x03ea, code lost:
        r2.readBits(1);
        r6 = r2.readBits(4);
        r2.readBits(2);
        r3 = r2.readBits(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x03fa, code lost:
        if (r3 == 0) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x03fd, code lost:
        if (r3 == 1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0400, code lost:
        if (r3 == 2) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
        if (r1 != (-1)) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0403, code lost:
        if (r3 == 3) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0406, code lost:
        if (r3 == 5) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0409, code lost:
        if (r3 == 6) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x040b, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x040d, code lost:
        r22.sampleSize = 24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0412, code lost:
        r22.sampleSize = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0417, code lost:
        r22.sampleSize = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x041b, code lost:
        r2.readBits(1);
        r2.readBits(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x0423, code lost:
        if (r6 == 6) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0426, code lost:
        if (r6 == 7) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x0428, code lost:
        r2.readBits(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x042d, code lost:
        r2.readBits(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0432, code lost:
        r2.readBits(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0436, code lost:
        r1.position((r19 + r4) + 1);
        r6 = r7;
        r3 = r18;
        r16 = r20;
        r17 = r21;
        r4 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x0447, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x0449, code lost:
        r18 = r3;
        r3 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x0452, code lost:
        if (r5 != 1683496997) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x0455, code lost:
        if (r4 != 65535) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0457, code lost:
        r22.samplesPerFrame = r22.samplesPerFrameAtMaxFs;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x045c, code lost:
        r7 = new com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer(r1);
        r8 = 8;
        r7.readBits(8);
        r7.readBits(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x046f, code lost:
        if (r7.readBits(1) != 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x0471, code lost:
        r3 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0474, code lost:
        r8 = 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x0476, code lost:
        r3 = r7.readBits(r3) + 1;
        r1.position(r19 + (r7.readBits(r8) + 1));
        r7 = r1.getInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x048c, code lost:
        if (r7 != 1515870810) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x048e, code lost:
        if (r10 != true) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0490, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0492, code lost:
        r16 = r4;
        r8 = r20;
        r17 = r21;
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x049e, code lost:
        if (r7 != 1191201283) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x04a0, code lost:
        if (r14 != true) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x04a2, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x04a4, code lost:
        r16 = r4;
        r8 = r20;
        r17 = r21;
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0070, code lost:
        if (r6 == 0) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x04af, code lost:
        if (r7 != 496366178) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x04b3, code lost:
        if (r20 != true) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x04b5, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x04b7, code lost:
        r16 = r4;
        r17 = r21;
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x04bd, code lost:
        r8 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x04c2, code lost:
        if (r7 != 1700671838) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x04c6, code lost:
        if (r21 != true) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x04c8, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0072, code lost:
        if (r6 == 2) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x04ca, code lost:
        r16 = r4;
        r17 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x04cf, code lost:
        r16 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x04d6, code lost:
        if (r7 != 176167201) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x04d8, code lost:
        if (r12 != true) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x04da, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x04dc, code lost:
        r17 = r21;
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x04e3, code lost:
        if (r7 != 1101174087) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x04e5, code lost:
        if (r9 != true) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x04e7, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0074, code lost:
        switch(r6) {
            case 4: goto L182;
            case 5: goto L182;
            case 6: goto L182;
            case 7: goto L182;
            case 8: goto L182;
            case 9: goto L182;
            default: goto L181;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x04e9, code lost:
        r17 = r21;
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x04f0, code lost:
        if (r7 != 45126241) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x04f2, code lost:
        if (r13 != true) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x04f4, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x04f6, code lost:
        r17 = r21;
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x04fa, code lost:
        r17 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x04fc, code lost:
        if (r18 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x04fe, code lost:
        r22.frameSize += r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0503, code lost:
        r1.position(r19 + r3);
        r4 = r16;
        r3 = r18;
        r16 = r8;
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
        r6 = 31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0511, code lost:
        r17 = r21;
        r16 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0518, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
        if (r4 != 0) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007e, code lost:
        if (r9 != true) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
        if (r13 != false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0082, code lost:
        r2 = 17;
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0089, code lost:
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
        r2 = 21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0090, code lost:
        if (r12 != true) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0092, code lost:
        r2 = 18;
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
        if (r13 != true) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009d, code lost:
        if (r14 != false) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009f, code lost:
        if (r9 != false) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a1, code lost:
        r2 = 19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
        if (r14 != true) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a6, code lost:
        if (r9 != false) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a8, code lost:
        r2 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ab, code lost:
        if (r14 != false) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ad, code lost:
        if (r9 != true) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b0, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b1, code lost:
        r22.samplerate = r22.maxSampleRate;
        r22.sampleSize = 24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00bc, code lost:
        if (r8 >= 1) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c0, code lost:
        if (r11 <= 0) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c2, code lost:
        if (r15 == 0) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c4, code lost:
        if (r15 == 2) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c7, code lost:
        if (r15 == 6) goto L256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c9, code lost:
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cb, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ce, code lost:
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
        r2 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d3, code lost:
        r22.type = "dtsc";
        r2 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00d8, code lost:
        r22.type = "dtsc";
        r2 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00dd, code lost:
        r22.type = "dtsc";
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e2, code lost:
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e4, code lost:
        if (r11 != 0) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e6, code lost:
        if (r13 != false) goto L311;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e9, code lost:
        if (r14 != true) goto L311;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00eb, code lost:
        r2 = r16;
        r4 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ef, code lost:
        if (r2 != false) goto L271;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00f1, code lost:
        if (r4 != false) goto L271;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00f3, code lost:
        if (r9 != false) goto L271;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00f5, code lost:
        if (r12 != false) goto L271;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00f7, code lost:
        r2 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00fa, code lost:
        r2 = r16;
        r4 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00fe, code lost:
        if (r13 != false) goto L310;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0100, code lost:
        if (r14 != false) goto L310;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0102, code lost:
        if (r2 != false) goto L310;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0104, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0105, code lost:
        if (r4 != true) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0107, code lost:
        if (r9 != false) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0109, code lost:
        if (r12 != false) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x010b, code lost:
        r2 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x010e, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x010f, code lost:
        if (r13 != false) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0111, code lost:
        if (r14 != r5) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0113, code lost:
        if (r2 != false) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0115, code lost:
        if (r4 != r5) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0117, code lost:
        if (r9 != false) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0119, code lost:
        if (r12 != false) goto L286;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean readVariables() throws IOException {
        ByteBuffer map = this.dataSource.map(0L, ANRMonitor.ANR_TIMEOUT_MS);
        int i = map.getInt();
        int i2 = map.getInt();
        if (i != 1146377032 || i2 != 1145586770) {
            return false;
        }
        while (true) {
            if ((i != 1398035021 || i2 != 1145132097) && map.remaining() > 100) {
                int i3 = (int) map.getLong();
                if (i == 1146377032 && i2 == 1145586770) {
                    if (!parseDtshdhdr(i3, map)) {
                        return false;
                    }
                } else if (i == 1129271877 && i2 == 1397968196) {
                    if (!parseCoressmd(i3, map)) {
                        return false;
                    }
                } else if (i == 1096110162 && i2 == 759710802) {
                    if (!parseAuprhdr(i3, map)) {
                        return false;
                    }
                } else if (i == 1163416659 && i2 == 1398754628) {
                    if (!parseExtssmd(i3, map)) {
                        return false;
                    }
                } else {
                    for (int i4 = 0; i4 < i3; i4++) {
                        map.get();
                    }
                }
                i = map.getInt();
                i2 = map.getInt();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.googlecode.mp4parser.authoring.Track
    public AbstractMediaHeaderBox getMediaHeaderBox() {
        return new SoundMediaHeaderBox();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.sampleDurations;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }
}
