package com.googlecode.mp4parser.authoring.tracks;

import androidx.core.internal.view.SupportMenu;
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
/* loaded from: classes6.dex */
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
        this.numSamplesOrigAudioAtMaxFs = (byteBuffer.get() << 32) | (byteBuffer.getInt() & SupportMenu.USER_MASK);
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

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01fa, code lost:
        r21.bitrate = 1024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0201, code lost:
        r21.bitrate = 1152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0209, code lost:
        r21.bitrate = 1280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0211, code lost:
        r21.bitrate = 1344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0219, code lost:
        r21.bitrate = 1408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0221, code lost:
        r21.bitrate = 1411;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0229, code lost:
        r21.bitrate = 1472;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0231, code lost:
        r21.bitrate = 1536;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0239, code lost:
        r21.bitrate = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0240, code lost:
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
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0275, code lost:
        if (r16 != 1) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0277, code lost:
        r15.readBits(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x027c, code lost:
        r15.readBits(1);
        r16 = r15.readBits(4);
        r15.readBits(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0296, code lost:
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
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0299, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x029c, code lost:
        r21.sampleSize = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02a4, code lost:
        r15.readBits(1);
        r15.readBits(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02b2, code lost:
        switch(r16) {
            case 6: goto L104;
            case 7: goto L105;
            default: goto L101;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02b5, code lost:
        r15.readBits(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02ba, code lost:
        r17.position((r18 + r19) + 1);
        r15 = r3;
        r16 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02c8, code lost:
        r21.sampleSize = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02d1, code lost:
        r21.sampleSize = 24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02da, code lost:
        r15 = -(r15.readBits(4) + 16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02e4, code lost:
        r15 = -r15.readBits(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02ef, code lost:
        if (r3 != 1683496997) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02f2, code lost:
        if (r2 != 65535) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02f4, code lost:
        r2 = 0;
        r21.samplesPerFrame = r21.samplesPerFrameAtMaxFs;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02fd, code lost:
        r14 = 1;
        r19 = new com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer(r17);
        r19.readBits(8);
        r19.readBits(2);
        r4 = 12;
        r3 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x031f, code lost:
        if (r19.readBits(1) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0321, code lost:
        r4 = 8;
        r3 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0325, code lost:
        r19 = r19.readBits(r3) + 1;
        r17.position(r18 + (r19.readBits(r4) + 1));
        r3 = r17.getInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0343, code lost:
        if (r3 != 1515870810) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0346, code lost:
        if (r13 != true) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0348, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0349, code lost:
        r13 = true;
        r5 = r3;
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x034c, code lost:
        if (r5 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x034e, code lost:
        r21.frameSize += r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0358, code lost:
        r17.position(r18 + r19);
        r7 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0365, code lost:
        if (r3 != 1191201283) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0368, code lost:
        if (r12 != true) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x036a, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x036b, code lost:
        r4 = r7;
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0372, code lost:
        if (r3 != 496366178) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0375, code lost:
        if (r11 != true) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0377, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0378, code lost:
        r4 = r7;
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x037f, code lost:
        if (r3 != 1700671838) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0382, code lost:
        if (r10 != true) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0384, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0385, code lost:
        r4 = r7;
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x038c, code lost:
        if (r3 != 176167201) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x038f, code lost:
        if (r9 != true) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0391, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0392, code lost:
        r4 = r7;
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0399, code lost:
        if (r3 != 1101174087) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x039c, code lost:
        if (r8 != true) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x039e, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x039f, code lost:
        r4 = r7;
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x03a6, code lost:
        if (r3 != 45126241) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x03a9, code lost:
        if (r7 != true) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03ab, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x03ac, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x03af, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x03b2, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x03b6, code lost:
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x03ba, code lost:
        r5 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x03be, code lost:
        r5 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x03c4, code lost:
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
    /* JADX WARN: Code restructure failed: missing block: B:184:0x03c7, code lost:
        r4 = 31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03c8, code lost:
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03c9, code lost:
        if (r2 != 0) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x03cc, code lost:
        if (r8 != true) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x03ce, code lost:
        if (r7 != false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x03d0, code lost:
        r2 = 17;
        r21.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x03d9, code lost:
        r21.samplerate = r21.maxSampleRate;
        r21.sampleSize = 24;
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x03e8, code lost:
        r21.ddts.setDTSSamplingFrequency(r21.maxSampleRate);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03f8, code lost:
        if (r21.isVBR == false) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x03fa, code lost:
        r21.ddts.setMaxBitRate((r21.coreBitRate + r21.extPeakBitrate) * 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x040d, code lost:
        r21.ddts.setAvgBitRate((r21.coreBitRate + r21.extAvgBitrate) * 1000);
        r21.ddts.setPcmSampleDepth(r21.sampleSize);
        r21.ddts.setFrameDuration(r5);
        r21.ddts.setStreamConstruction(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x043f, code lost:
        if ((r21.coreChannelMask & 8) > 0) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0447, code lost:
        if ((r21.coreChannelMask & 4096) <= 0) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0449, code lost:
        r21.ddts.setCoreLFEPresent(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0451, code lost:
        r21.ddts.setCoreLayout(r4);
        r21.ddts.setCoreSize(r21.coreFramePayloadInBytes);
        r21.ddts.setStereoDownmix(0);
        r21.ddts.setRepresentationType(4);
        r21.ddts.setChannelLayout(r21.channelMask);
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0482, code lost:
        if (r21.coreMaxSampleRate <= 0) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0488, code lost:
        if (r21.extAvgBitrate <= 0) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x048a, code lost:
        r21.ddts.setMultiAssetFlag(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0492, code lost:
        r21.ddts.setLBRDurationMod(r21.lbrCodingPresent);
        r21.ddts.setReservedBoxPresent(0);
        r21.channelCount = 0;
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x04ad, code lost:
        if (r2 < 16) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x04af, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x04b2, code lost:
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x04b5, code lost:
        r2 = 21;
        r21.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04c1, code lost:
        if (r9 != true) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x04c3, code lost:
        r2 = 18;
        r21.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x04cf, code lost:
        if (r7 != true) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x04d1, code lost:
        r21.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x04d8, code lost:
        if (r12 != false) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x04da, code lost:
        if (r8 != false) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x04dc, code lost:
        r2 = 19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x04e1, code lost:
        if (r12 != true) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x04e3, code lost:
        if (r8 != false) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x04e5, code lost:
        r2 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x04e9, code lost:
        if (r12 != false) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x04ec, code lost:
        if (r8 != true) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x04ee, code lost:
        r2 = 21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x04f3, code lost:
        if (r14 >= 1) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x04f5, code lost:
        if (r15 <= 0) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x04f7, code lost:
        switch(r16) {
            case 0: goto L228;
            case 2: goto L229;
            case 6: goto L230;
            default: goto L227;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x04fa, code lost:
        r3 = 0;
        r21.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0504, code lost:
        r3 = 2;
        r21.type = "dtsc";
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x050e, code lost:
        r3 = 4;
        r21.type = "dtsc";
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0518, code lost:
        r3 = 3;
        r21.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0522, code lost:
        r3 = 1;
        r21.type = "dtsc";
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x052c, code lost:
        r21.type = com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0533, code lost:
        if (r15 != 0) goto L284;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0535, code lost:
        if (r7 != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0538, code lost:
        if (r12 != true) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x053a, code lost:
        if (r11 != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x053c, code lost:
        if (r10 != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x053e, code lost:
        if (r8 != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0540, code lost:
        if (r9 != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0542, code lost:
        r3 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0545, code lost:
        if (r7 != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0547, code lost:
        if (r12 != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0549, code lost:
        if (r11 != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x054c, code lost:
        if (r10 != true) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x054e, code lost:
        if (r8 != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0550, code lost:
        if (r9 != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0552, code lost:
        r3 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0555, code lost:
        if (r7 != false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0558, code lost:
        if (r12 != true) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x055a, code lost:
        if (r11 != false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x055d, code lost:
        if (r10 != true) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x055f, code lost:
        if (r8 != false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0561, code lost:
        if (r9 != false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0563, code lost:
        r3 = 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0567, code lost:
        if (r7 != false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0569, code lost:
        if (r12 != false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x056c, code lost:
        if (r11 != true) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x056e, code lost:
        if (r10 != false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0570, code lost:
        if (r8 != false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0572, code lost:
        if (r9 != false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0574, code lost:
        r3 = 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0578, code lost:
        if (r7 != false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x057b, code lost:
        if (r12 != true) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x057e, code lost:
        if (r11 != true) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0580, code lost:
        if (r10 != false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0582, code lost:
        if (r8 != false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0584, code lost:
        if (r9 != false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0586, code lost:
        r3 = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x058a, code lost:
        if (r7 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x058c, code lost:
        if (r12 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x058e, code lost:
        if (r11 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x0590, code lost:
        if (r10 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0593, code lost:
        if (r8 != true) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0595, code lost:
        if (r9 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0597, code lost:
        r3 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x059b, code lost:
        if (r16 != 0) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x059d, code lost:
        if (r7 != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x059f, code lost:
        if (r12 != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x05a1, code lost:
        if (r11 != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x05a4, code lost:
        if (r10 != true) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x05a6, code lost:
        if (r8 != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x05a8, code lost:
        if (r9 != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x05aa, code lost:
        r3 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x05b0, code lost:
        if (r16 != 6) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x05b2, code lost:
        if (r7 != false) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x05b4, code lost:
        if (r12 != false) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x05b6, code lost:
        if (r11 != false) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x05b9, code lost:
        if (r10 != true) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x05bb, code lost:
        if (r8 != false) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x05bd, code lost:
        if (r9 != false) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x05bf, code lost:
        r3 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x05c3, code lost:
        if (r16 != 0) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x05c5, code lost:
        if (r7 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x05c7, code lost:
        if (r12 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x05ca, code lost:
        if (r11 != true) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x05cc, code lost:
        if (r10 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x05ce, code lost:
        if (r8 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x05d0, code lost:
        if (r9 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x05d2, code lost:
        r3 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x05d9, code lost:
        if (r16 != 6) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x05db, code lost:
        if (r7 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x05dd, code lost:
        if (r12 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x05e0, code lost:
        if (r11 != true) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x05e2, code lost:
        if (r10 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x05e4, code lost:
        if (r8 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x05e6, code lost:
        if (r9 != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x05e8, code lost:
        r3 = 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x05ec, code lost:
        if (r16 != 0) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x05ee, code lost:
        if (r7 != false) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x05f0, code lost:
        if (r12 != false) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x05f2, code lost:
        if (r11 != false) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x05f4, code lost:
        if (r10 != false) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x05f7, code lost:
        if (r8 != true) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x05f9, code lost:
        if (r9 != false) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x05fb, code lost:
        r3 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0602, code lost:
        if (r16 != 2) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0604, code lost:
        if (r7 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x0606, code lost:
        if (r12 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x0608, code lost:
        if (r11 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x060a, code lost:
        if (r10 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x060d, code lost:
        if (r8 != true) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x060f, code lost:
        if (r9 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0611, code lost:
        r3 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x0615, code lost:
        r21.ddts.setMaxBitRate((r21.coreBitRate + r21.extAvgBitrate) * 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x062a, code lost:
        r21.ddts.setCoreLFEPresent(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x0634, code lost:
        r21.ddts.setMultiAssetFlag(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0646, code lost:
        if (((r21.channelMask >> r2) & 1) != 1) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x0648, code lost:
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
    /* JADX WARN: Code restructure failed: missing block: B:352:0x064b, code lost:
        r21.channelCount += 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x0655, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0659, code lost:
        r21.channelCount++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x0664, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x0667, code lost:
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x066a, code lost:
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009a, code lost:
        r17.getLong();
        r21.dataOffset = r17.position();
        r6 = -1;
        r16 = 0;
        r2 = 65535;
        r13 = false;
        r12 = false;
        r11 = false;
        r10 = false;
        r9 = false;
        r8 = false;
        r7 = false;
        r5 = false;
        r14 = 65535;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b5, code lost:
        if (r5 == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bc, code lost:
        switch(r21.samplesPerFrame) {
            case 512: goto L342;
            case 1024: goto L343;
            case 2048: goto L344;
            case 4096: goto L345;
            default: goto L160;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00bf, code lost:
        r5 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c1, code lost:
        if (r5 != (-1)) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c3, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00cc, code lost:
        r18 = r17.position();
        r3 = r17.getInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d7, code lost:
        if (r3 != 2147385345) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00da, code lost:
        if (r2 != 1) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00dc, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00de, code lost:
        r2 = 1;
        r15 = new com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer(r17);
        r3 = r15.readBits(1);
        r4 = r15.readBits(5);
        r16 = r15.readBits(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f6, code lost:
        if (r3 != 1) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00fa, code lost:
        if (r4 != 31) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00fc, code lost:
        if (r16 == 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00fe, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0101, code lost:
        r21.samplesPerFrame = (r15.readBits(7) + 1) * 32;
        r19 = r15.readBits(14);
        r21.frameSize += r19 + 1;
        r6 = r15.readBits(6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0129, code lost:
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
    /* JADX WARN: Code restructure failed: missing block: B:67:0x012c, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x012f, code lost:
        r21.samplerate = 8000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x013a, code lost:
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
    /* JADX WARN: Code restructure failed: missing block: B:71:0x013d, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0140, code lost:
        r21.samplerate = 16000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0147, code lost:
        r21.samplerate = 32000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x014e, code lost:
        r21.samplerate = com.baidu.live.tbadk.core.data.RequestResponseCode.REQUEST_LOGIN_PB_AT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0155, code lost:
        r21.samplerate = 22050;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x015c, code lost:
        r21.samplerate = 44100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0164, code lost:
        r21.samplerate = 12000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x016b, code lost:
        r21.samplerate = 24000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0172, code lost:
        r21.samplerate = 48000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x017a, code lost:
        r21.bitrate = 32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0185, code lost:
        if (r15.readBits(1) == 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0187, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x018a, code lost:
        r21.bitrate = 56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0191, code lost:
        r21.bitrate = 64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0198, code lost:
        r21.bitrate = 96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x019f, code lost:
        r21.bitrate = 112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a6, code lost:
        r21.bitrate = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01ad, code lost:
        r21.bitrate = 192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01b4, code lost:
        r21.bitrate = 224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01bb, code lost:
        r21.bitrate = 256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01c2, code lost:
        r21.bitrate = com.yy.videoplayer.decoder.VideoConstant.THUMBNAIL_WIDTH;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01c9, code lost:
        r21.bitrate = 384;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d0, code lost:
        r21.bitrate = 448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d7, code lost:
        r21.bitrate = 512;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01de, code lost:
        r21.bitrate = 576;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01e5, code lost:
        r21.bitrate = 640;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01ec, code lost:
        r21.bitrate = 768;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f3, code lost:
        r21.bitrate = 960;
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
