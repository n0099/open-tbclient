package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.google.android.exoplayer2.extractor.ogg.OpusReader;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/* loaded from: classes9.dex */
public class AC3TrackImpl extends AbstractTrack {
    public static int[][][][] bitRateAndFrameSizeTable;
    public final DataSource dataSource;
    public long[] duration;
    public SampleDescriptionBox sampleDescriptionBox;
    public List<Sample> samples;
    public TrackMetaData trackMetaData;

    static {
        int[][][][] iArr = (int[][][][]) Array.newInstance(int.class, 19, 2, 3, 2);
        bitRateAndFrameSizeTable = iArr;
        iArr[0][0][0][0] = 32;
        iArr[0][1][0][0] = 32;
        iArr[0][0][0][1] = 64;
        iArr[0][1][0][1] = 64;
        iArr[1][0][0][0] = 40;
        iArr[1][1][0][0] = 40;
        iArr[1][0][0][1] = 80;
        iArr[1][1][0][1] = 80;
        iArr[2][0][0][0] = 48;
        iArr[2][1][0][0] = 48;
        iArr[2][0][0][1] = 96;
        iArr[2][1][0][1] = 96;
        iArr[3][0][0][0] = 56;
        iArr[3][1][0][0] = 56;
        iArr[3][0][0][1] = 112;
        iArr[3][1][0][1] = 112;
        iArr[4][0][0][0] = 64;
        iArr[4][1][0][0] = 64;
        iArr[4][0][0][1] = 128;
        iArr[4][1][0][1] = 128;
        iArr[5][0][0][0] = 80;
        iArr[5][1][0][0] = 80;
        iArr[5][0][0][1] = 160;
        iArr[5][1][0][1] = 160;
        iArr[6][0][0][0] = 96;
        iArr[6][1][0][0] = 96;
        iArr[6][0][0][1] = 192;
        iArr[6][1][0][1] = 192;
        iArr[7][0][0][0] = 112;
        iArr[7][1][0][0] = 112;
        iArr[7][0][0][1] = 224;
        iArr[7][1][0][1] = 224;
        iArr[8][0][0][0] = 128;
        iArr[8][1][0][0] = 128;
        iArr[8][0][0][1] = 256;
        iArr[8][1][0][1] = 256;
        iArr[9][0][0][0] = 160;
        iArr[9][1][0][0] = 160;
        iArr[9][0][0][1] = 320;
        iArr[9][1][0][1] = 320;
        iArr[10][0][0][0] = 192;
        iArr[10][1][0][0] = 192;
        iArr[10][0][0][1] = 384;
        iArr[10][1][0][1] = 384;
        iArr[11][0][0][0] = 224;
        iArr[11][1][0][0] = 224;
        iArr[11][0][0][1] = 448;
        iArr[11][1][0][1] = 448;
        iArr[12][0][0][0] = 256;
        iArr[12][1][0][0] = 256;
        iArr[12][0][0][1] = 512;
        iArr[12][1][0][1] = 512;
        iArr[13][0][0][0] = 320;
        iArr[13][1][0][0] = 320;
        iArr[13][0][0][1] = 640;
        iArr[13][1][0][1] = 640;
        iArr[14][0][0][0] = 384;
        iArr[14][1][0][0] = 384;
        iArr[14][0][0][1] = 768;
        iArr[14][1][0][1] = 768;
        iArr[15][0][0][0] = 448;
        iArr[15][1][0][0] = 448;
        iArr[15][0][0][1] = 896;
        iArr[15][1][0][1] = 896;
        iArr[16][0][0][0] = 512;
        iArr[16][1][0][0] = 512;
        iArr[16][0][0][1] = 1024;
        iArr[16][1][0][1] = 1024;
        iArr[17][0][0][0] = 576;
        iArr[17][1][0][0] = 576;
        iArr[17][0][0][1] = 1152;
        iArr[17][1][0][1] = 1152;
        iArr[18][0][0][0] = 640;
        iArr[18][1][0][0] = 640;
        iArr[18][0][0][1] = 1280;
        iArr[18][1][0][1] = 1280;
        iArr[0][0][1][0] = 32;
        iArr[0][1][1][0] = 32;
        iArr[0][0][1][1] = 69;
        iArr[0][1][1][1] = 70;
        iArr[1][0][1][0] = 40;
        iArr[1][1][1][0] = 40;
        iArr[1][0][1][1] = 87;
        iArr[1][1][1][1] = 88;
        iArr[2][0][1][0] = 48;
        iArr[2][1][1][0] = 48;
        iArr[2][0][1][1] = 104;
        iArr[2][1][1][1] = 105;
        iArr[3][0][1][0] = 56;
        iArr[3][1][1][0] = 56;
        iArr[3][0][1][1] = 121;
        iArr[3][1][1][1] = 122;
        iArr[4][0][1][0] = 64;
        iArr[4][1][1][0] = 64;
        iArr[4][0][1][1] = 139;
        iArr[4][1][1][1] = 140;
        iArr[5][0][1][0] = 80;
        iArr[5][1][1][0] = 80;
        iArr[5][0][1][1] = 174;
        iArr[5][1][1][1] = 175;
        iArr[6][0][1][0] = 96;
        iArr[6][1][1][0] = 96;
        iArr[6][0][1][1] = 208;
        iArr[6][1][1][1] = 209;
        iArr[7][0][1][0] = 112;
        iArr[7][1][1][0] = 112;
        iArr[7][0][1][1] = 243;
        iArr[7][1][1][1] = 244;
        iArr[8][0][1][0] = 128;
        iArr[8][1][1][0] = 128;
        iArr[8][0][1][1] = 278;
        iArr[8][1][1][1] = 279;
        iArr[9][0][1][0] = 160;
        iArr[9][1][1][0] = 160;
        iArr[9][0][1][1] = 348;
        iArr[9][1][1][1] = 349;
        iArr[10][0][1][0] = 192;
        iArr[10][1][1][0] = 192;
        iArr[10][0][1][1] = 417;
        iArr[10][1][1][1] = 418;
        iArr[11][0][1][0] = 224;
        iArr[11][1][1][0] = 224;
        iArr[11][0][1][1] = 487;
        iArr[11][1][1][1] = 488;
        iArr[12][0][1][0] = 256;
        iArr[12][1][1][0] = 256;
        iArr[12][0][1][1] = 557;
        iArr[12][1][1][1] = 558;
        iArr[13][0][1][0] = 320;
        iArr[13][1][1][0] = 320;
        iArr[13][0][1][1] = 696;
        iArr[13][1][1][1] = 697;
        iArr[14][0][1][0] = 384;
        iArr[14][1][1][0] = 384;
        iArr[14][0][1][1] = 835;
        iArr[14][1][1][1] = 836;
        iArr[15][0][1][0] = 448;
        iArr[15][1][1][0] = 448;
        iArr[15][0][1][1] = 975;
        iArr[15][1][1][1] = 975;
        iArr[16][0][1][0] = 512;
        iArr[16][1][1][0] = 512;
        iArr[16][0][1][1] = 1114;
        iArr[16][1][1][1] = 1115;
        iArr[17][0][1][0] = 576;
        iArr[17][1][1][0] = 576;
        iArr[17][0][1][1] = 1253;
        iArr[17][1][1][1] = 1254;
        iArr[18][0][1][0] = 640;
        iArr[18][1][1][0] = 640;
        iArr[18][0][1][1] = 1393;
        iArr[18][1][1][1] = 1394;
        iArr[0][0][2][0] = 32;
        iArr[0][1][2][0] = 32;
        iArr[0][0][2][1] = 96;
        iArr[0][1][2][1] = 96;
        iArr[1][0][2][0] = 40;
        iArr[1][1][2][0] = 40;
        iArr[1][0][2][1] = 120;
        iArr[1][1][2][1] = 120;
        iArr[2][0][2][0] = 48;
        iArr[2][1][2][0] = 48;
        iArr[2][0][2][1] = 144;
        iArr[2][1][2][1] = 144;
        iArr[3][0][2][0] = 56;
        iArr[3][1][2][0] = 56;
        iArr[3][0][2][1] = 168;
        iArr[3][1][2][1] = 168;
        iArr[4][0][2][0] = 64;
        iArr[4][1][2][0] = 64;
        iArr[4][0][2][1] = 192;
        iArr[4][1][2][1] = 192;
        iArr[5][0][2][0] = 80;
        iArr[5][1][2][0] = 80;
        iArr[5][0][2][1] = 240;
        iArr[5][1][2][1] = 240;
        iArr[6][0][2][0] = 96;
        iArr[6][1][2][0] = 96;
        iArr[6][0][2][1] = 288;
        iArr[6][1][2][1] = 288;
        iArr[7][0][2][0] = 112;
        iArr[7][1][2][0] = 112;
        iArr[7][0][2][1] = 336;
        iArr[7][1][2][1] = 336;
        iArr[8][0][2][0] = 128;
        iArr[8][1][2][0] = 128;
        iArr[8][0][2][1] = 384;
        iArr[8][1][2][1] = 384;
        iArr[9][0][2][0] = 160;
        iArr[9][1][2][0] = 160;
        iArr[9][0][2][1] = 480;
        iArr[9][1][2][1] = 480;
        iArr[10][0][2][0] = 192;
        iArr[10][1][2][0] = 192;
        iArr[10][0][2][1] = 576;
        iArr[10][1][2][1] = 576;
        iArr[11][0][2][0] = 224;
        iArr[11][1][2][0] = 224;
        iArr[11][0][2][1] = 672;
        iArr[11][1][2][1] = 672;
        iArr[12][0][2][0] = 256;
        iArr[12][1][2][0] = 256;
        iArr[12][0][2][1] = 768;
        iArr[12][1][2][1] = 768;
        iArr[13][0][2][0] = 320;
        iArr[13][1][2][0] = 320;
        iArr[13][0][2][1] = 960;
        iArr[13][1][2][1] = 960;
        iArr[14][0][2][0] = 384;
        iArr[14][1][2][0] = 384;
        iArr[14][0][2][1] = 1152;
        iArr[14][1][2][1] = 1152;
        iArr[15][0][2][0] = 448;
        iArr[15][1][2][0] = 448;
        iArr[15][0][2][1] = 1344;
        iArr[15][1][2][1] = 1344;
        iArr[16][0][2][0] = 512;
        iArr[16][1][2][0] = 512;
        iArr[16][0][2][1] = 1536;
        iArr[16][1][2][1] = 1536;
        iArr[17][0][2][0] = 576;
        iArr[17][1][2][0] = 576;
        iArr[17][0][2][1] = 1728;
        iArr[17][1][2][1] = 1728;
        iArr[18][0][2][0] = 640;
        iArr[18][1][2][0] = 640;
        iArr[18][0][2][1] = 1920;
        iArr[18][1][2][1] = 1920;
    }

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
    public SubSampleInformationBox getSubsampleInformationBox() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        return null;
    }

    public AC3TrackImpl(DataSource dataSource) throws IOException {
        this(dataSource, "eng");
    }

    public AC3TrackImpl(DataSource dataSource, String str) throws IOException {
        TrackMetaData trackMetaData = new TrackMetaData();
        this.trackMetaData = trackMetaData;
        this.dataSource = dataSource;
        trackMetaData.setLanguage(str);
        this.samples = readSamples();
        this.sampleDescriptionBox = new SampleDescriptionBox();
        AudioSampleEntry createAudioSampleEntry = createAudioSampleEntry();
        this.sampleDescriptionBox.addBox(createAudioSampleEntry);
        this.trackMetaData.setCreationTime(new Date());
        this.trackMetaData.setModificationTime(new Date());
        this.trackMetaData.setLanguage(str);
        this.trackMetaData.setTimescale(createAudioSampleEntry.getSampleRate());
        this.trackMetaData.setVolume(1.0f);
    }

    private AudioSampleEntry createAudioSampleEntry() throws IOException {
        int i;
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(this.samples.get(0).asByteBuffer());
        if (bitReaderBuffer.readBits(16) == 2935) {
            bitReaderBuffer.readBits(16);
            int readBits = bitReaderBuffer.readBits(2);
            if (readBits != 0) {
                if (readBits != 1) {
                    if (readBits == 2) {
                        i = 32000;
                    } else {
                        throw new RuntimeException("Unsupported Sample Rate");
                    }
                } else {
                    i = 44100;
                }
            } else {
                i = OpusReader.SAMPLE_RATE;
            }
            int readBits2 = bitReaderBuffer.readBits(6);
            int readBits3 = bitReaderBuffer.readBits(5);
            int readBits4 = bitReaderBuffer.readBits(3);
            int readBits5 = bitReaderBuffer.readBits(3);
            if (readBits3 != 16) {
                if (readBits3 == 9) {
                    i /= 2;
                } else if (readBits3 != 8 && readBits3 != 6) {
                    throw new RuntimeException("Unsupported bsid");
                }
                if (readBits5 != 1 && (readBits5 & 1) == 1) {
                    bitReaderBuffer.readBits(2);
                }
                if ((readBits5 & 4) != 0) {
                    bitReaderBuffer.readBits(2);
                }
                if (readBits5 == 2) {
                    bitReaderBuffer.readBits(2);
                }
                switch (readBits5) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        int readBits6 = bitReaderBuffer.readBits(1);
                        AudioSampleEntry audioSampleEntry = new AudioSampleEntry(AudioSampleEntry.TYPE8);
                        audioSampleEntry.setChannelCount(2);
                        audioSampleEntry.setSampleRate(i);
                        audioSampleEntry.setDataReferenceIndex(1);
                        audioSampleEntry.setSampleSize(16);
                        AC3SpecificBox aC3SpecificBox = new AC3SpecificBox();
                        aC3SpecificBox.setAcmod(readBits5);
                        aC3SpecificBox.setBitRateCode(readBits2 >> 1);
                        aC3SpecificBox.setBsid(readBits3);
                        aC3SpecificBox.setBsmod(readBits4);
                        aC3SpecificBox.setFscod(readBits);
                        aC3SpecificBox.setLfeon(readBits6);
                        aC3SpecificBox.setReserved(0);
                        audioSampleEntry.addBox(aC3SpecificBox);
                        return audioSampleEntry;
                    default:
                        throw new RuntimeException("Unsupported acmod");
                }
            }
            throw new RuntimeException("You cannot read E-AC-3 track with AC3TrackImpl.class - user EC3TrackImpl.class");
        }
        throw new RuntimeException("Stream doesn't seem to be AC3");
    }

    private int getFrameSize(int i, int i2) {
        int i3 = i >>> 1;
        int i4 = i & 1;
        if (i3 <= 18 && i4 <= 1 && i2 <= 2) {
            return bitRateAndFrameSizeTable[i3][i4][i2][1] * 2;
        }
        throw new RuntimeException("Cannot determine framesize of current sample");
    }

    private List<Sample> readSamples() throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(5);
        ArrayList arrayList = new ArrayList();
        while (-1 != this.dataSource.read(allocate)) {
            long frameSize = getFrameSize(allocate.get(4) & 63, allocate.get(4) >> 6);
            arrayList.add(new Sample(this.dataSource.position() - 5, frameSize, this.dataSource) { // from class: com.googlecode.mp4parser.authoring.tracks.AC3TrackImpl.1SampleImpl
                public final DataSource dataSource;
                public final long size;
                public final long start;

                {
                    this.start = r2;
                    this.size = frameSize;
                    this.dataSource = r6;
                }

                @Override // com.googlecode.mp4parser.authoring.Sample
                public ByteBuffer asByteBuffer() {
                    try {
                        return this.dataSource.map(this.start, this.size);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override // com.googlecode.mp4parser.authoring.Sample
                public long getSize() {
                    return this.size;
                }

                @Override // com.googlecode.mp4parser.authoring.Sample
                public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
                    this.dataSource.transferTo(this.start, this.size, writableByteChannel);
                }
            });
            DataSource dataSource = this.dataSource;
            dataSource.position((dataSource.position() - 5) + frameSize);
            allocate.rewind();
        }
        long[] jArr = new long[arrayList.size()];
        this.duration = jArr;
        Arrays.fill(jArr, 1536L);
        return arrayList;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        return new SoundMediaHeaderBox();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSampleDurations() {
        return this.duration;
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
