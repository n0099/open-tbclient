package com.googlecode.mp4parser.authoring.tracks;

import com.baidu.ala.livePlayer.StreamConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.AudioSpecificConfig;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderConfigDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.SLConfigDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class AACTrackImpl extends AbstractTrack {
    static Map<Integer, String> audioObjectTypes = new HashMap();
    public static Map<Integer, Integer> samplingFrequencyIndexMap;
    long avgBitRate;
    int bufferSizeDB;
    long[] decTimes;
    a firstHeader;
    private String lang;
    long maxBitRate;
    SampleDescriptionBox sampleDescriptionBox;
    private List<Sample> samples;
    TrackMetaData trackMetaData;

    static {
        audioObjectTypes.put(1, "AAC Main");
        audioObjectTypes.put(2, "AAC LC (Low Complexity)");
        audioObjectTypes.put(3, "AAC SSR (Scalable Sample Rate)");
        audioObjectTypes.put(4, "AAC LTP (Long Term Prediction)");
        audioObjectTypes.put(5, "SBR (Spectral Band Replication)");
        audioObjectTypes.put(6, "AAC Scalable");
        audioObjectTypes.put(7, "TwinVQ");
        audioObjectTypes.put(8, "CELP (Code Excited Linear Prediction)");
        audioObjectTypes.put(9, "HXVC (Harmonic Vector eXcitation Coding)");
        audioObjectTypes.put(10, "Reserved");
        audioObjectTypes.put(11, "Reserved");
        audioObjectTypes.put(12, "TTSI (Text-To-Speech Interface)");
        audioObjectTypes.put(13, "Main Synthesis");
        audioObjectTypes.put(14, "Wavetable Synthesis");
        audioObjectTypes.put(15, "General MIDI");
        audioObjectTypes.put(16, "Algorithmic Synthesis and Audio Effects");
        audioObjectTypes.put(17, "ER (Error Resilient) AAC LC");
        audioObjectTypes.put(18, "Reserved");
        audioObjectTypes.put(19, "ER AAC LTP");
        audioObjectTypes.put(20, "ER AAC Scalable");
        audioObjectTypes.put(21, "ER TwinVQ");
        audioObjectTypes.put(22, "ER BSAC (Bit-Sliced Arithmetic Coding)");
        audioObjectTypes.put(23, "ER AAC LD (Low Delay)");
        audioObjectTypes.put(24, "ER CELP");
        audioObjectTypes.put(25, "ER HVXC");
        audioObjectTypes.put(26, "ER HILN (Harmonic and Individual Lines plus Noise)");
        audioObjectTypes.put(27, "ER Parametric");
        audioObjectTypes.put(28, "SSC (SinuSoidal Coding)");
        audioObjectTypes.put(29, "PS (Parametric Stereo)");
        audioObjectTypes.put(30, "MPEG Surround");
        audioObjectTypes.put(31, "(Escape value)");
        audioObjectTypes.put(32, "Layer-1");
        audioObjectTypes.put(33, "Layer-2");
        audioObjectTypes.put(34, "Layer-3");
        audioObjectTypes.put(35, "DST (Direct Stream Transfer)");
        audioObjectTypes.put(36, "ALS (Audio Lossless)");
        audioObjectTypes.put(37, "SLS (Scalable LosslesS)");
        audioObjectTypes.put(38, "SLS non-core");
        audioObjectTypes.put(39, "ER AAC ELD (Enhanced Low Delay)");
        audioObjectTypes.put(40, "SMR (Symbolic Music Representation) Simple");
        audioObjectTypes.put(41, "SMR Main");
        audioObjectTypes.put(42, "USAC (Unified Speech and Audio Coding) (no SBR)");
        audioObjectTypes.put(43, "SAOC (Spatial Audio Object Coding)");
        audioObjectTypes.put(44, "LD MPEG Surround");
        audioObjectTypes.put(45, "USAC");
        samplingFrequencyIndexMap = new HashMap();
        samplingFrequencyIndexMap.put(96000, 0);
        samplingFrequencyIndexMap.put(88200, 1);
        samplingFrequencyIndexMap.put(64000, 2);
        samplingFrequencyIndexMap.put(Integer.valueOf((int) StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K), 3);
        samplingFrequencyIndexMap.put(Integer.valueOf((int) StreamConfig.Audio.AUDIO_FREQUENCY), 4);
        samplingFrequencyIndexMap.put(Integer.valueOf((int) StreamConfig.Audio.AUDIO_RTC_FREQUENCY_32K), 5);
        samplingFrequencyIndexMap.put(24000, 6);
        samplingFrequencyIndexMap.put(22050, 7);
        samplingFrequencyIndexMap.put(Integer.valueOf((int) StreamConfig.Audio.AUDIO_RTC_FREQUENCY_16K), 8);
        samplingFrequencyIndexMap.put(12000, 9);
        samplingFrequencyIndexMap.put(Integer.valueOf((int) RequestResponseCode.REQUEST_LOGIN_PB_AT), 10);
        samplingFrequencyIndexMap.put(8000, 11);
        samplingFrequencyIndexMap.put(0, 96000);
        samplingFrequencyIndexMap.put(1, 88200);
        samplingFrequencyIndexMap.put(2, 64000);
        samplingFrequencyIndexMap.put(3, Integer.valueOf((int) StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K));
        samplingFrequencyIndexMap.put(4, Integer.valueOf((int) StreamConfig.Audio.AUDIO_FREQUENCY));
        samplingFrequencyIndexMap.put(5, Integer.valueOf((int) StreamConfig.Audio.AUDIO_RTC_FREQUENCY_32K));
        samplingFrequencyIndexMap.put(6, 24000);
        samplingFrequencyIndexMap.put(7, 22050);
        samplingFrequencyIndexMap.put(8, Integer.valueOf((int) StreamConfig.Audio.AUDIO_RTC_FREQUENCY_16K));
        samplingFrequencyIndexMap.put(9, 12000);
        samplingFrequencyIndexMap.put(10, Integer.valueOf((int) RequestResponseCode.REQUEST_LOGIN_PB_AT));
        samplingFrequencyIndexMap.put(11, 8000);
    }

    public AACTrackImpl(DataSource dataSource, String str) throws IOException {
        this.trackMetaData = new TrackMetaData();
        this.lang = "eng";
        this.lang = str;
        parse(dataSource);
    }

    public AACTrackImpl(DataSource dataSource) throws IOException {
        this.trackMetaData = new TrackMetaData();
        this.lang = "eng";
        parse(dataSource);
    }

    private void parse(DataSource dataSource) throws IOException {
        int i;
        double size;
        this.samples = new ArrayList();
        this.firstHeader = readSamples(dataSource);
        double d = this.firstHeader.aWk / 1024.0d;
        double size2 = this.samples.size() / d;
        LinkedList linkedList = new LinkedList();
        long j = 0;
        for (Sample sample : this.samples) {
            int size3 = (int) sample.getSize();
            j += size3;
            linkedList.add(Integer.valueOf(size3));
            while (linkedList.size() > d) {
                linkedList.pop();
            }
            if (linkedList.size() == ((int) d)) {
                int i2 = 0;
                Iterator it = linkedList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    i2 = ((Integer) it.next()).intValue() + i;
                }
                if (((i * 8.0d) / linkedList.size()) * d > this.maxBitRate) {
                    this.maxBitRate = (int) size;
                }
            }
        }
        this.avgBitRate = (int) ((8 * j) / size2);
        this.bufferSizeDB = 1536;
        this.sampleDescriptionBox = new SampleDescriptionBox();
        AudioSampleEntry audioSampleEntry = new AudioSampleEntry(AudioSampleEntry.TYPE3);
        if (this.firstHeader.krU == 7) {
            audioSampleEntry.setChannelCount(8);
        } else {
            audioSampleEntry.setChannelCount(this.firstHeader.krU);
        }
        audioSampleEntry.setSampleRate(this.firstHeader.aWk);
        audioSampleEntry.setDataReferenceIndex(1);
        audioSampleEntry.setSampleSize(16);
        ESDescriptorBox eSDescriptorBox = new ESDescriptorBox();
        ESDescriptor eSDescriptor = new ESDescriptor();
        eSDescriptor.setEsId(0);
        SLConfigDescriptor sLConfigDescriptor = new SLConfigDescriptor();
        sLConfigDescriptor.setPredefined(2);
        eSDescriptor.setSlConfigDescriptor(sLConfigDescriptor);
        DecoderConfigDescriptor decoderConfigDescriptor = new DecoderConfigDescriptor();
        decoderConfigDescriptor.setObjectTypeIndication(64);
        decoderConfigDescriptor.setStreamType(5);
        decoderConfigDescriptor.setBufferSizeDB(this.bufferSizeDB);
        decoderConfigDescriptor.setMaxBitRate(this.maxBitRate);
        decoderConfigDescriptor.setAvgBitRate(this.avgBitRate);
        AudioSpecificConfig audioSpecificConfig = new AudioSpecificConfig();
        audioSpecificConfig.setAudioObjectType(2);
        audioSpecificConfig.setSamplingFrequencyIndex(this.firstHeader.krQ);
        audioSpecificConfig.setChannelConfiguration(this.firstHeader.krU);
        decoderConfigDescriptor.setAudioSpecificInfo(audioSpecificConfig);
        eSDescriptor.setDecoderConfigDescriptor(decoderConfigDescriptor);
        ByteBuffer serialize = eSDescriptor.serialize();
        eSDescriptorBox.setEsDescriptor(eSDescriptor);
        eSDescriptorBox.setData(serialize);
        audioSampleEntry.addBox(eSDescriptorBox);
        this.sampleDescriptionBox.addBox(audioSampleEntry);
        this.trackMetaData.setCreationTime(new Date());
        this.trackMetaData.setModificationTime(new Date());
        this.trackMetaData.setLanguage(this.lang);
        this.trackMetaData.setVolume(1.0f);
        this.trackMetaData.setTimescale(this.firstHeader.aWk);
        this.decTimes = new long[this.samples.size()];
        Arrays.fill(this.decTimes, 1024L);
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.decTimes;
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

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        return new SoundMediaHeaderBox();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a {
        int aWk;
        int home;
        int krQ;
        int krR;
        int krS;
        int krT;
        int krU;
        int krV;
        int krW;
        int krX;
        int krY;
        int krZ;
        int ksa;
        int layer;

        a() {
        }

        int getSize() {
            return (this.krS == 0 ? 2 : 0) + 7;
        }
    }

    private a readADTSHeader(DataSource dataSource) throws IOException {
        a aVar = new a();
        ByteBuffer allocate = ByteBuffer.allocate(7);
        while (allocate.position() < 7) {
            if (dataSource.read(allocate) == -1) {
                return null;
            }
        }
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer((ByteBuffer) allocate.rewind());
        if (bitReaderBuffer.readBits(12) != 4095) {
            throw new IOException("Expected Start Word 0xfff");
        }
        aVar.krR = bitReaderBuffer.readBits(1);
        aVar.layer = bitReaderBuffer.readBits(2);
        aVar.krS = bitReaderBuffer.readBits(1);
        aVar.krT = bitReaderBuffer.readBits(2) + 1;
        aVar.krQ = bitReaderBuffer.readBits(4);
        aVar.aWk = samplingFrequencyIndexMap.get(Integer.valueOf(aVar.krQ)).intValue();
        bitReaderBuffer.readBits(1);
        aVar.krU = bitReaderBuffer.readBits(3);
        aVar.krV = bitReaderBuffer.readBits(1);
        aVar.home = bitReaderBuffer.readBits(1);
        aVar.krW = bitReaderBuffer.readBits(1);
        aVar.krX = bitReaderBuffer.readBits(1);
        aVar.krY = bitReaderBuffer.readBits(13);
        aVar.krZ = bitReaderBuffer.readBits(11);
        aVar.ksa = bitReaderBuffer.readBits(2) + 1;
        if (aVar.ksa != 1) {
            throw new IOException("This muxer can only work with 1 AAC frame per ADTS frame");
        }
        if (aVar.krS == 0) {
            dataSource.read(ByteBuffer.allocate(2));
        }
        return aVar;
    }

    private a readSamples(DataSource dataSource) throws IOException {
        a aVar = null;
        while (true) {
            a readADTSHeader = readADTSHeader(dataSource);
            if (readADTSHeader != null) {
                if (aVar == null) {
                    aVar = readADTSHeader;
                }
                ByteBuffer map = dataSource.map(dataSource.position(), readADTSHeader.krY - readADTSHeader.getSize());
                this.samples.add(new SampleImpl(map));
                dataSource.position((dataSource.position() + readADTSHeader.krY) - readADTSHeader.getSize());
                map.rewind();
            } else {
                return aVar;
            }
        }
    }

    public String toString() {
        return "AACTrackImpl{sampleRate=" + this.firstHeader.aWk + ", channelconfig=" + this.firstHeader.krU + '}';
    }
}
