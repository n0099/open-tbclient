package com.googlecode.mp4parser.authoring.tracks;

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
/* loaded from: classes20.dex */
public class DTSTrackImpl extends AbstractTrack {
    int bcCoreBitRate;
    int bcCoreChannelMask;
    int bcCoreMaxSampleRate;
    int bitrate;
    int channelCount;
    int channelMask;
    int codecDelayAtMaxFs;
    int coreBitRate;
    int coreChannelMask;
    int coreFramePayloadInBytes;
    int coreMaxSampleRate;
    boolean coreSubStreamPresent;
    private int dataOffset;
    private DataSource dataSource;
    DTSSpecificBox ddts;
    int extAvgBitrate;
    int extFramePayloadInBytes;
    int extPeakBitrate;
    int extSmoothBuffSize;
    boolean extensionSubStreamPresent;
    int frameSize;
    boolean isVBR;
    private String lang;
    int lbrCodingPresent;
    int lsbTrimPercent;
    int maxSampleRate;
    int numExtSubStreams;
    int numFramesTotal;
    int numSamplesOrigAudioAtMaxFs;
    SampleDescriptionBox sampleDescriptionBox;
    private long[] sampleDurations;
    int sampleSize;
    int samplerate;
    private List<Sample> samples;
    int samplesPerFrame;
    int samplesPerFrameAtMaxFs;
    TrackMetaData trackMetaData;
    String type;

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

    private void parse() throws IOException {
        if (!readVariables()) {
            throw new IOException();
        }
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
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.sampleDurations;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "soun";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.googlecode.mp4parser.authoring.Track
    public AbstractMediaHeaderBox getMediaHeaderBox() {
        return new SoundMediaHeaderBox();
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

    private boolean parseCoressmd(int i, ByteBuffer byteBuffer) {
        this.coreMaxSampleRate = (byteBuffer.get() << 16) | (byteBuffer.getShort() & 65535);
        this.coreBitRate = byteBuffer.getShort();
        this.coreChannelMask = byteBuffer.getShort();
        this.coreFramePayloadInBytes = byteBuffer.getInt();
        for (int i2 = 11; i2 < i; i2++) {
            byteBuffer.get();
        }
        return true;
    }

    private boolean parseAuprhdr(int i, ByteBuffer byteBuffer) {
        byteBuffer.get();
        short s = byteBuffer.getShort();
        this.maxSampleRate = (byteBuffer.get() << 16) | (byteBuffer.getShort() & 65535);
        this.numFramesTotal = byteBuffer.getInt();
        this.samplesPerFrameAtMaxFs = byteBuffer.getShort();
        this.numSamplesOrigAudioAtMaxFs = (byteBuffer.get() << 32) | (byteBuffer.getInt() & 65535);
        this.channelMask = byteBuffer.getShort();
        this.codecDelayAtMaxFs = byteBuffer.getShort();
        int i2 = 21;
        if ((s & 3) == 3) {
            this.bcCoreMaxSampleRate = (byteBuffer.get() << 16) | (byteBuffer.getShort() & 65535);
            this.bcCoreBitRate = byteBuffer.getShort();
            this.bcCoreChannelMask = byteBuffer.getShort();
            i2 = 28;
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

    private boolean parseExtssmd(int i, ByteBuffer byteBuffer) {
        int i2;
        this.extAvgBitrate = (byteBuffer.get() << 16) | (byteBuffer.getShort() & 65535);
        if (this.isVBR) {
            this.extPeakBitrate = (byteBuffer.get() << 16) | (byteBuffer.getShort() & 65535);
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

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01fd, code lost:
        r22.bitrate = 1024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0204, code lost:
        r22.bitrate = 1152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x020c, code lost:
        r22.bitrate = io.flutter.plugin.platform.PlatformPlugin.DEFAULT_SYSTEM_UI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0214, code lost:
        r22.bitrate = 1344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x021c, code lost:
        r22.bitrate = 1408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0224, code lost:
        r22.bitrate = 1411;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x022c, code lost:
        r22.bitrate = 1472;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0234, code lost:
        r22.bitrate = 1536;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x023c, code lost:
        r22.bitrate = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0243, code lost:
        r15.readBits(1);
        r15.readBits(1);
        r15.readBits(1);
        r15.readBits(1);
        r4 = r15.readBits(3);
        r3 = r15.readBits(1);
        r15.readBits(1);
        r15.readBits(2);
        r15.readBits(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0278, code lost:
        if (r16 != 1) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x027a, code lost:
        r15.readBits(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x027f, code lost:
        r15.readBits(1);
        r16 = r15.readBits(4);
        r15.readBits(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0299, code lost:
        switch(r15.readBits(3)) {
            case 0: goto L98;
            case 1: goto L98;
            case 2: goto L106;
            case 3: goto L106;
            case 4: goto L108;
            case 5: goto L107;
            case 6: goto L107;
            default: goto L108;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x029c, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x029f, code lost:
        r22.sampleSize = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02a7, code lost:
        r15.readBits(1);
        r15.readBits(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02b5, code lost:
        switch(r16) {
            case 6: goto L104;
            case 7: goto L105;
            default: goto L101;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02b8, code lost:
        r15.readBits(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02bd, code lost:
        r17.position((r18 + r19) + 1);
        r15 = r3;
        r16 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02cb, code lost:
        r22.sampleSize = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02d4, code lost:
        r22.sampleSize = 24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02dd, code lost:
        r15 = -(r15.readBits(4) + 16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02e7, code lost:
        r15 = -r15.readBits(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02f2, code lost:
        if (r3 != 1683496997) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02f5, code lost:
        if (r2 != true) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02f7, code lost:
        r2 = false;
        r22.samplesPerFrame = r22.samplesPerFrameAtMaxFs;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0300, code lost:
        r14 = 1;
        r19 = new com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer(r17);
        r19.readBits(8);
        r19.readBits(2);
        r4 = 12;
        r3 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0322, code lost:
        if (r19.readBits(1) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0324, code lost:
        r4 = 8;
        r3 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0328, code lost:
        r19 = r19.readBits(r3) + 1;
        r17.position(r18 + (r19.readBits(r4) + 1));
        r3 = r17.getInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0346, code lost:
        if (r3 != 1515870810) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0349, code lost:
        if (r13 != true) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x034b, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x034c, code lost:
        r5 = r3;
        r3 = r7;
        r7 = r9;
        r9 = r11;
        r11 = true;
        r4 = r8;
        r8 = r10;
        r10 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0355, code lost:
        if (r5 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0357, code lost:
        r22.frameSize += r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0361, code lost:
        r17.position(r18 + r19);
        r12 = r10;
        r13 = r11;
        r10 = r8;
        r11 = r9;
        r9 = r7;
        r8 = r4;
        r7 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0374, code lost:
        if (r3 != 1191201283) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0377, code lost:
        if (r12 != true) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0379, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x037a, code lost:
        r4 = r8;
        r8 = r10;
        r10 = true;
        r3 = r7;
        r7 = r9;
        r9 = r11;
        r11 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0386, code lost:
        if (r3 != 496366178) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0389, code lost:
        if (r11 != true) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x038b, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x038c, code lost:
        r4 = r8;
        r11 = r13;
        r8 = r10;
        r10 = r12;
        r3 = r7;
        r7 = r9;
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x039b, code lost:
        if (r3 != 1700671838) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x039e, code lost:
        if (r10 != true) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03a0, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03a1, code lost:
        r4 = r8;
        r10 = r12;
        r8 = true;
        r3 = r7;
        r7 = r9;
        r9 = r11;
        r11 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03ad, code lost:
        if (r3 != 176167201) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03b0, code lost:
        if (r9 != true) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x03b2, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x03b3, code lost:
        r4 = r8;
        r9 = r11;
        r8 = r10;
        r11 = r13;
        r10 = r12;
        r21 = r7;
        r7 = true;
        r3 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x03c2, code lost:
        if (r3 != 1101174087) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03c5, code lost:
        if (r8 != true) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03c7, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03c8, code lost:
        r4 = true;
        r8 = r10;
        r3 = r7;
        r10 = r12;
        r7 = r9;
        r9 = r11;
        r11 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x03d4, code lost:
        if (r3 != 45126241) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x03d7, code lost:
        if (r7 != true) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03d9, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x03da, code lost:
        r3 = true;
        r4 = r8;
        r7 = r9;
        r8 = r10;
        r9 = r11;
        r10 = r12;
        r11 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x03e3, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x03e6, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x03ea, code lost:
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x03ee, code lost:
        r5 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x03f2, code lost:
        r5 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x03f8, code lost:
        switch(r6) {
            case 0: goto L341;
            case 1: goto L166;
            case 2: goto L341;
            case 3: goto L166;
            case 4: goto L341;
            case 5: goto L341;
            case 6: goto L341;
            case 7: goto L341;
            case 8: goto L341;
            case 9: goto L341;
            default: goto L166;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x03fb, code lost:
        r4 = 31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03fc, code lost:
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03fd, code lost:
        if (r2 != false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0400, code lost:
        if (r8 != true) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0402, code lost:
        if (r7 != false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0404, code lost:
        r2 = 17;
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x040d, code lost:
        r22.samplerate = r22.maxSampleRate;
        r22.sampleSize = 24;
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x041c, code lost:
        r22.ddts.setDTSSamplingFrequency(r22.maxSampleRate);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x042c, code lost:
        if (r22.isVBR == false) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x042e, code lost:
        r22.ddts.setMaxBitRate((r22.coreBitRate + r22.extPeakBitrate) * 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0441, code lost:
        r22.ddts.setAvgBitRate((r22.coreBitRate + r22.extAvgBitrate) * 1000);
        r22.ddts.setPcmSampleDepth(r22.sampleSize);
        r22.ddts.setFrameDuration(r5);
        r22.ddts.setStreamConstruction(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0473, code lost:
        if ((r22.coreChannelMask & 8) > 0) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x047b, code lost:
        if ((r22.coreChannelMask & 4096) <= 0) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x047d, code lost:
        r22.ddts.setCoreLFEPresent(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0485, code lost:
        r22.ddts.setCoreLayout(r4);
        r22.ddts.setCoreSize(r22.coreFramePayloadInBytes);
        r22.ddts.setStereoDownmix(0);
        r22.ddts.setRepresentationType(4);
        r22.ddts.setChannelLayout(r22.channelMask);
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x04b6, code lost:
        if (r22.coreMaxSampleRate <= 0) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x04bc, code lost:
        if (r22.extAvgBitrate <= 0) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x04be, code lost:
        r22.ddts.setMultiAssetFlag(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x04c6, code lost:
        r22.ddts.setLBRDurationMod(r22.lbrCodingPresent);
        r22.ddts.setReservedBoxPresent(0);
        r22.channelCount = 0;
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x04e1, code lost:
        if (r2 < 16) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x04e3, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x04e6, code lost:
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x04e9, code lost:
        r2 = 21;
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04f5, code lost:
        if (r9 != true) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x04f7, code lost:
        r2 = 18;
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0503, code lost:
        if (r7 != true) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0505, code lost:
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x050c, code lost:
        if (r12 != false) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x050e, code lost:
        if (r8 != false) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0510, code lost:
        r2 = 19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0515, code lost:
        if (r12 != true) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0517, code lost:
        if (r8 != false) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0519, code lost:
        r2 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x051d, code lost:
        if (r12 != false) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0520, code lost:
        if (r8 != true) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0522, code lost:
        r2 = 21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0527, code lost:
        if (r14 >= 1) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0529, code lost:
        if (r15 <= 0) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x052b, code lost:
        switch(r16) {
            case 0: goto L228;
            case 2: goto L229;
            case 6: goto L230;
            default: goto L227;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x052e, code lost:
        r3 = 0;
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0538, code lost:
        r3 = 2;
        r22.type = "dtsc";
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0542, code lost:
        r3 = 4;
        r22.type = "dtsc";
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x054c, code lost:
        r3 = 3;
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0556, code lost:
        r3 = 1;
        r22.type = "dtsc";
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0560, code lost:
        r22.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0567, code lost:
        if (r15 != 0) goto L284;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0569, code lost:
        if (r7 != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x056c, code lost:
        if (r12 != true) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x056e, code lost:
        if (r11 != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0570, code lost:
        if (r10 != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0572, code lost:
        if (r8 != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0574, code lost:
        if (r9 != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0576, code lost:
        r3 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0579, code lost:
        if (r7 != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x057b, code lost:
        if (r12 != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x057d, code lost:
        if (r11 != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0580, code lost:
        if (r10 != true) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0582, code lost:
        if (r8 != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0584, code lost:
        if (r9 != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0586, code lost:
        r3 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0589, code lost:
        if (r7 != false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x058c, code lost:
        if (r12 != true) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x058e, code lost:
        if (r11 != false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0591, code lost:
        if (r10 != true) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0593, code lost:
        if (r8 != false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0595, code lost:
        if (r9 != false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0597, code lost:
        r3 = 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x059b, code lost:
        if (r7 != false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x059d, code lost:
        if (r12 != false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x05a0, code lost:
        if (r11 != true) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x05a2, code lost:
        if (r10 != false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x05a4, code lost:
        if (r8 != false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x05a6, code lost:
        if (r9 != false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x05a8, code lost:
        r3 = 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x05ac, code lost:
        if (r7 != false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x05af, code lost:
        if (r12 != true) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x05b2, code lost:
        if (r11 != true) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x05b4, code lost:
        if (r10 != false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x05b6, code lost:
        if (r8 != false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x05b8, code lost:
        if (r9 != false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x05ba, code lost:
        r3 = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x05be, code lost:
        if (r7 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x05c0, code lost:
        if (r12 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x05c2, code lost:
        if (r11 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x05c4, code lost:
        if (r10 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x05c7, code lost:
        if (r8 != true) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x05c9, code lost:
        if (r9 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x05cb, code lost:
        r3 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x05cf, code lost:
        if (r16 != 0) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x05d1, code lost:
        if (r7 != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x05d3, code lost:
        if (r12 != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x05d5, code lost:
        if (r11 != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x05d8, code lost:
        if (r10 != true) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x05da, code lost:
        if (r8 != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x05dc, code lost:
        if (r9 != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x05de, code lost:
        r3 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x05e4, code lost:
        if (r16 != 6) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x05e6, code lost:
        if (r7 != false) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x05e8, code lost:
        if (r12 != false) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x05ea, code lost:
        if (r11 != false) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x05ed, code lost:
        if (r10 != true) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x05ef, code lost:
        if (r8 != false) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x05f1, code lost:
        if (r9 != false) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x05f3, code lost:
        r3 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x05f7, code lost:
        if (r16 != 0) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x05f9, code lost:
        if (r7 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x05fb, code lost:
        if (r12 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x05fe, code lost:
        if (r11 != true) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x0600, code lost:
        if (r10 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0602, code lost:
        if (r8 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x0604, code lost:
        if (r9 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x0606, code lost:
        r3 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x060d, code lost:
        if (r16 != 6) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x060f, code lost:
        if (r7 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x0611, code lost:
        if (r12 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0614, code lost:
        if (r11 != true) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0616, code lost:
        if (r10 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0618, code lost:
        if (r8 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x061a, code lost:
        if (r9 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x061c, code lost:
        r3 = 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0620, code lost:
        if (r16 != 0) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x0622, code lost:
        if (r7 != false) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0624, code lost:
        if (r12 != false) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0626, code lost:
        if (r11 != false) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x0628, code lost:
        if (r10 != false) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x062b, code lost:
        if (r8 != true) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x062d, code lost:
        if (r9 != false) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x062f, code lost:
        r3 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0636, code lost:
        if (r16 != 2) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0638, code lost:
        if (r7 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x063a, code lost:
        if (r12 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x063c, code lost:
        if (r11 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x063e, code lost:
        if (r10 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x0641, code lost:
        if (r8 != true) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0643, code lost:
        if (r9 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0645, code lost:
        r3 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x0649, code lost:
        r22.ddts.setMaxBitRate((r22.coreBitRate + r22.extAvgBitrate) * 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x065e, code lost:
        r22.ddts.setCoreLFEPresent(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x0668, code lost:
        r22.ddts.setMultiAssetFlag(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x067a, code lost:
        if (((r22.channelMask >> r2) & 1) != 1) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x067c, code lost:
        switch(r2) {
            case 0: goto L196;
            case 1: goto L193;
            case 2: goto L193;
            case 3: goto L196;
            case 4: goto L196;
            case 5: goto L193;
            case 6: goto L193;
            case 7: goto L196;
            case 8: goto L196;
            case 9: goto L193;
            case 10: goto L193;
            case 11: goto L193;
            case 12: goto L196;
            case 13: goto L193;
            case 14: goto L196;
            default: goto L193;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x067f, code lost:
        r22.channelCount += 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x0689, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x068d, code lost:
        r22.channelCount++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x0698, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x069b, code lost:
        r3 = r7;
        r4 = r8;
        r7 = r9;
        r8 = r10;
        r9 = r11;
        r10 = r12;
        r11 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x06a4, code lost:
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009a, code lost:
        r17.getLong();
        r22.dataOffset = r17.position();
        r13 = false;
        r12 = false;
        r11 = false;
        r10 = false;
        r9 = false;
        r8 = false;
        r7 = false;
        r5 = false;
        r15 = 0;
        r16 = 0;
        r6 = -1;
        r14 = 65535;
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b8, code lost:
        if (r5 == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bf, code lost:
        switch(r22.samplesPerFrame) {
            case 512: goto L342;
            case 1024: goto L343;
            case 2048: goto L344;
            case 4096: goto L345;
            default: goto L160;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c2, code lost:
        r5 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c4, code lost:
        if (r5 != (-1)) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c6, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00cf, code lost:
        r18 = r17.position();
        r3 = r17.getInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00da, code lost:
        if (r3 != 2147385345) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00dd, code lost:
        if (r2 != true) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00df, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e1, code lost:
        r2 = true;
        r15 = new com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer(r17);
        r3 = r15.readBits(1);
        r4 = r15.readBits(5);
        r16 = r15.readBits(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f9, code lost:
        if (r3 != 1) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00fd, code lost:
        if (r4 != 31) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ff, code lost:
        if (r16 == 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0101, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0104, code lost:
        r22.samplesPerFrame = (r15.readBits(7) + 1) * 32;
        r19 = r15.readBits(14);
        r22.frameSize += r19 + 1;
        r6 = r15.readBits(6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x012c, code lost:
        switch(r15.readBits(4)) {
            case 1: goto L87;
            case 2: goto L140;
            case 3: goto L141;
            case 4: goto L148;
            case 5: goto L148;
            case 6: goto L142;
            case 7: goto L143;
            case 8: goto L144;
            case 9: goto L148;
            case 10: goto L148;
            case 11: goto L145;
            case 12: goto L146;
            case 13: goto L147;
            default: goto L148;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x012f, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0132, code lost:
        r22.samplerate = com.baidu.searchbox.ui.CoolPraiseGuideLottieView.ANIM_DURATION;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x013d, code lost:
        switch(r15.readBits(5)) {
            case 0: goto L90;
            case 1: goto L113;
            case 2: goto L114;
            case 3: goto L115;
            case 4: goto L116;
            case 5: goto L117;
            case 6: goto L118;
            case 7: goto L119;
            case 8: goto L120;
            case 9: goto L121;
            case 10: goto L122;
            case 11: goto L123;
            case 12: goto L124;
            case 13: goto L125;
            case 14: goto L126;
            case 15: goto L127;
            case 16: goto L128;
            case 17: goto L129;
            case 18: goto L130;
            case 19: goto L131;
            case 20: goto L132;
            case 21: goto L133;
            case 22: goto L134;
            case 23: goto L135;
            case 24: goto L136;
            case 25: goto L137;
            default: goto L138;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0140, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0143, code lost:
        r22.samplerate = 16000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x014a, code lost:
        r22.samplerate = com.baidu.ala.helper.StreamConfig.Audio.AUDIO_RTC_FREQUENCY_32K;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0151, code lost:
        r22.samplerate = com.baidu.live.tbadk.core.data.RequestResponseCode.REQUEST_LOGIN_PB_AT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0158, code lost:
        r22.samplerate = 22050;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x015f, code lost:
        r22.samplerate = 44100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0167, code lost:
        r22.samplerate = 12000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x016e, code lost:
        r22.samplerate = 24000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0175, code lost:
        r22.samplerate = com.baidu.ala.helper.StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x017d, code lost:
        r22.bitrate = 32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0188, code lost:
        if (r15.readBits(1) == 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x018a, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x018d, code lost:
        r22.bitrate = 56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0194, code lost:
        r22.bitrate = 64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x019b, code lost:
        r22.bitrate = 96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01a2, code lost:
        r22.bitrate = 112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a9, code lost:
        r22.bitrate = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01b0, code lost:
        r22.bitrate = 192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01b7, code lost:
        r22.bitrate = 224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01be, code lost:
        r22.bitrate = 256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01c5, code lost:
        r22.bitrate = 320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01cc, code lost:
        r22.bitrate = 384;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d3, code lost:
        r22.bitrate = 448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01da, code lost:
        r22.bitrate = 512;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01e1, code lost:
        r22.bitrate = 576;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01e8, code lost:
        r22.bitrate = 640;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01ef, code lost:
        r22.bitrate = 768;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f6, code lost:
        r22.bitrate = com.baidu.tbadk.TbConfig.HEAD_IMG_SIZE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean readVariables() throws IOException {
        ByteBuffer map = this.dataSource.map(0L, 25000L);
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

    private List<Sample> readSamples() throws IOException {
        ArrayList arrayList = new ArrayList(CastUtils.l2i(this.dataSource.size() / this.frameSize));
        final int i = this.dataOffset;
        while (this.frameSize + i < this.dataSource.size()) {
            arrayList.add(new Sample() { // from class: com.googlecode.mp4parser.authoring.tracks.DTSTrackImpl.1
                @Override // com.googlecode.mp4parser.authoring.Sample
                public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
                    DTSTrackImpl.this.dataSource.transferTo(i, DTSTrackImpl.this.frameSize, writableByteChannel);
                }

                @Override // com.googlecode.mp4parser.authoring.Sample
                public long getSize() {
                    return DTSTrackImpl.this.frameSize;
                }

                @Override // com.googlecode.mp4parser.authoring.Sample
                public ByteBuffer asByteBuffer() {
                    try {
                        return DTSTrackImpl.this.dataSource.map(i, DTSTrackImpl.this.frameSize);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            i += this.frameSize;
        }
        this.sampleDurations = new long[arrayList.size()];
        Arrays.fill(this.sampleDurations, (this.samplesPerFrame * this.samplerate) / this.trackMetaData.getTimescale());
        return arrayList;
    }
}
