package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderConfigDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.SLConfigDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class MP3TrackImpl extends AbstractTrack {
    private static final int ES_OBJECT_TYPE_INDICATION = 107;
    private static final int ES_STREAM_TYPE = 5;
    private static final int MPEG_L3 = 1;
    private static final int MPEG_V1 = 3;
    private static final int SAMPLES_PER_FRAME = 1152;
    long avgBitRate;
    private long[] durations;
    a firstHeader;
    private String lang;
    long maxBitRate;
    SampleDescriptionBox sampleDescriptionBox;
    private List<Sample> samples;
    TrackMetaData trackMetaData;
    private static final int[] SAMPLE_RATE = {44100, 48000, 32000};
    private static final int[] BIT_RATE = {0, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    public MP3TrackImpl(DataSource dataSource, String str) throws IOException {
        this.trackMetaData = new TrackMetaData();
        this.lang = "eng";
        this.lang = str;
        parse(dataSource);
    }

    public MP3TrackImpl(DataSource dataSource) throws IOException {
        this.trackMetaData = new TrackMetaData();
        this.lang = "eng";
        parse(dataSource);
    }

    private void parse(DataSource dataSource) throws IOException {
        double size;
        this.samples = new LinkedList();
        this.firstHeader = readSamples(dataSource);
        double d = this.firstHeader.gxA / 1152.0d;
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
                Iterator it = linkedList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    i = ((Integer) it.next()).intValue() + i;
                }
                if (((i * 8.0d) / linkedList.size()) * d > this.maxBitRate) {
                    this.maxBitRate = (int) size;
                }
            }
        }
        this.avgBitRate = (int) ((8 * j) / size2);
        this.sampleDescriptionBox = new SampleDescriptionBox();
        AudioSampleEntry audioSampleEntry = new AudioSampleEntry(AudioSampleEntry.TYPE3);
        audioSampleEntry.setChannelCount(this.firstHeader.channelCount);
        audioSampleEntry.setSampleRate(this.firstHeader.gxA);
        audioSampleEntry.setDataReferenceIndex(1);
        audioSampleEntry.setSampleSize(16);
        ESDescriptorBox eSDescriptorBox = new ESDescriptorBox();
        ESDescriptor eSDescriptor = new ESDescriptor();
        eSDescriptor.setEsId(0);
        SLConfigDescriptor sLConfigDescriptor = new SLConfigDescriptor();
        sLConfigDescriptor.setPredefined(2);
        eSDescriptor.setSlConfigDescriptor(sLConfigDescriptor);
        DecoderConfigDescriptor decoderConfigDescriptor = new DecoderConfigDescriptor();
        decoderConfigDescriptor.setObjectTypeIndication(107);
        decoderConfigDescriptor.setStreamType(5);
        decoderConfigDescriptor.setMaxBitRate(this.maxBitRate);
        decoderConfigDescriptor.setAvgBitRate(this.avgBitRate);
        eSDescriptor.setDecoderConfigDescriptor(decoderConfigDescriptor);
        eSDescriptorBox.setData(eSDescriptor.serialize());
        audioSampleEntry.addBox(eSDescriptorBox);
        this.sampleDescriptionBox.addBox(audioSampleEntry);
        this.trackMetaData.setCreationTime(new Date());
        this.trackMetaData.setModificationTime(new Date());
        this.trackMetaData.setLanguage(this.lang);
        this.trackMetaData.setVolume(1.0f);
        this.trackMetaData.setTimescale(this.firstHeader.gxA);
        this.durations = new long[this.samples.size()];
        Arrays.fill(this.durations, 1152L);
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.durations;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        int channelCount;
        int gZA;
        int gZf;
        int gZg;
        int gZh;
        int gZy;
        int gZz;
        int gxA;
        int layer;
        int padding;

        a() {
        }

        int bFF() {
            return ((this.gZz * 144) / this.gxA) + this.padding;
        }
    }

    private a readSamples(DataSource dataSource) throws IOException {
        a aVar = null;
        while (true) {
            long position = dataSource.position();
            a readMP3Header = readMP3Header(dataSource);
            if (readMP3Header != null) {
                if (aVar == null) {
                    aVar = readMP3Header;
                }
                dataSource.position(position);
                ByteBuffer allocate = ByteBuffer.allocate(readMP3Header.bFF());
                dataSource.read(allocate);
                allocate.rewind();
                this.samples.add(new SampleImpl(allocate));
            } else {
                return aVar;
            }
        }
    }

    private a readMP3Header(DataSource dataSource) throws IOException {
        a aVar = new a();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        while (allocate.position() < 4) {
            if (dataSource.read(allocate) == -1) {
                return null;
            }
        }
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer((ByteBuffer) allocate.rewind());
        if (bitReaderBuffer.readBits(11) != 2047) {
            throw new IOException("Expected Start Word 0x7ff");
        }
        aVar.gZg = bitReaderBuffer.readBits(2);
        if (aVar.gZg != 3) {
            throw new IOException("Expected MPEG Version 1 (ISO/IEC 11172-3)");
        }
        aVar.layer = bitReaderBuffer.readBits(2);
        if (aVar.layer != 1) {
            throw new IOException("Expected Layer III");
        }
        aVar.gZh = bitReaderBuffer.readBits(1);
        aVar.gZy = bitReaderBuffer.readBits(4);
        aVar.gZz = BIT_RATE[aVar.gZy];
        if (aVar.gZz == 0) {
            throw new IOException("Unexpected (free/bad) bit rate");
        }
        aVar.gZf = bitReaderBuffer.readBits(2);
        aVar.gxA = SAMPLE_RATE[aVar.gZf];
        if (aVar.gxA == 0) {
            throw new IOException("Unexpected (reserved) sample rate frequency");
        }
        aVar.padding = bitReaderBuffer.readBits(1);
        bitReaderBuffer.readBits(1);
        aVar.gZA = bitReaderBuffer.readBits(2);
        aVar.channelCount = aVar.gZA == 3 ? 1 : 2;
        return aVar;
    }

    public String toString() {
        return "MP3TrackImpl";
    }
}
