package com.googlecode.mp4parser.authoring.adaptivestreaming;

import com.coremedia.iso.Hex;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.h264.AvcConfigurationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.Version;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder;
import com.googlecode.mp4parser.boxes.DTSSpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.AudioSpecificConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/* loaded from: classes2.dex */
public class FlatManifestWriterImpl extends AbstractManifestWriter {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Logger LOG;

    static {
        $assertionsDisabled = !FlatManifestWriterImpl.class.desiredAssertionStatus();
        LOG = Logger.getLogger(FlatManifestWriterImpl.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FlatManifestWriterImpl(FragmentIntersectionFinder fragmentIntersectionFinder) {
        super(fragmentIntersectionFinder);
    }

    protected Document customizeManifest(Document document) {
        return document;
    }

    @Override // com.googlecode.mp4parser.authoring.adaptivestreaming.ManifestWriter
    public String getManifest(Movie movie) throws IOException {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        long j = -1;
        long j2 = -1;
        for (Track track : movie.getTracks()) {
            if (track.getMediaHeaderBox() instanceof VideoMediaHeaderBox) {
                this.videoFragmentsDurations = checkFragmentsAlign(this.videoFragmentsDurations, calculateFragmentDurations(track, movie));
                linkedList.add(getVideoQuality(track, (VisualSampleEntry) track.getSampleDescriptionBox().getSampleEntry()));
                if (j2 == -1) {
                    j2 = track.getTrackMetaData().getTimescale();
                } else if (!$assertionsDisabled && j2 != track.getTrackMetaData().getTimescale()) {
                    throw new AssertionError();
                }
            }
            if (track.getMediaHeaderBox() instanceof SoundMediaHeaderBox) {
                this.audioFragmentsDurations = checkFragmentsAlign(this.audioFragmentsDurations, calculateFragmentDurations(track, movie));
                linkedList2.add(getAudioQuality(track, (AudioSampleEntry) track.getSampleDescriptionBox().getSampleEntry()));
                if (j == -1) {
                    j = track.getTrackMetaData().getTimescale();
                } else if (!$assertionsDisabled && j != track.getTrackMetaData().getTimescale()) {
                    throw new AssertionError();
                }
            }
        }
        try {
            Document newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element createElement = newDocument.createElement("SmoothStreamingMedia");
            newDocument.appendChild(createElement);
            createElement.setAttribute("MajorVersion", "2");
            createElement.setAttribute("MinorVersion", "1");
            createElement.setAttribute("Duration", "0");
            createElement.appendChild(newDocument.createComment(Version.VERSION));
            Element createElement2 = newDocument.createElement("StreamIndex");
            createElement2.setAttribute("Type", "video");
            createElement2.setAttribute("TimeScale", Long.toString(j2));
            createElement2.setAttribute("Chunks", Integer.toString(this.videoFragmentsDurations.length));
            createElement2.setAttribute("Url", "video/{bitrate}/{start time}");
            createElement2.setAttribute("QualityLevels", Integer.toString(linkedList.size()));
            createElement.appendChild(createElement2);
            for (int i = 0; i < linkedList.size(); i++) {
                com.googlecode.mp4parser.authoring.adaptivestreaming.a aVar = (com.googlecode.mp4parser.authoring.adaptivestreaming.a) linkedList.get(i);
                Element createElement3 = newDocument.createElement("QualityLevel");
                createElement3.setAttribute("Index", Integer.toString(i));
                createElement3.setAttribute("Bitrate", Long.toString(aVar.bitrate));
                createElement3.setAttribute("FourCC", aVar.fourCC);
                createElement3.setAttribute("MaxWidth", Long.toString(aVar.width));
                createElement3.setAttribute("MaxHeight", Long.toString(aVar.height));
                createElement3.setAttribute("CodecPrivateData", aVar.codecPrivateData);
                createElement3.setAttribute("NALUnitLengthField", Integer.toString(aVar.hYX));
                createElement2.appendChild(createElement3);
            }
            for (int i2 = 0; i2 < this.videoFragmentsDurations.length; i2++) {
                Element createElement4 = newDocument.createElement("c");
                createElement4.setAttribute("n", Integer.toString(i2));
                createElement4.setAttribute("d", Long.toString(this.videoFragmentsDurations[i2]));
                createElement2.appendChild(createElement4);
            }
            if (this.audioFragmentsDurations != null) {
                Element createElement5 = newDocument.createElement("StreamIndex");
                createElement5.setAttribute("Type", "audio");
                createElement5.setAttribute("TimeScale", Long.toString(j));
                createElement5.setAttribute("Chunks", Integer.toString(this.audioFragmentsDurations.length));
                createElement5.setAttribute("Url", "audio/{bitrate}/{start time}");
                createElement5.setAttribute("QualityLevels", Integer.toString(linkedList2.size()));
                createElement.appendChild(createElement5);
                for (int i3 = 0; i3 < linkedList2.size(); i3++) {
                    AudioQuality audioQuality = (AudioQuality) linkedList2.get(i3);
                    Element createElement6 = newDocument.createElement("QualityLevel");
                    createElement6.setAttribute("Index", Integer.toString(i3));
                    createElement6.setAttribute("FourCC", audioQuality.fourCC);
                    createElement6.setAttribute("Bitrate", Long.toString(audioQuality.bitrate));
                    createElement6.setAttribute("AudioTag", Integer.toString(audioQuality.audioTag));
                    createElement6.setAttribute("SamplingRate", Long.toString(audioQuality.samplingRate));
                    createElement6.setAttribute("Channels", Integer.toString(audioQuality.channels));
                    createElement6.setAttribute("BitsPerSample", Integer.toString(audioQuality.bitPerSample));
                    createElement6.setAttribute("PacketSize", Integer.toString(audioQuality.packetSize));
                    createElement6.setAttribute("CodecPrivateData", audioQuality.codecPrivateData);
                    createElement5.appendChild(createElement6);
                }
                for (int i4 = 0; i4 < this.audioFragmentsDurations.length; i4++) {
                    Element createElement7 = newDocument.createElement("c");
                    createElement7.setAttribute("n", Integer.toString(i4));
                    createElement7.setAttribute("d", Long.toString(this.audioFragmentsDurations[i4]));
                    createElement5.appendChild(createElement7);
                }
            }
            newDocument.setXmlStandalone(true);
            DOMSource dOMSource = new DOMSource(customizeManifest(newDocument));
            StringWriter stringWriter = new StringWriter();
            StreamResult streamResult = new StreamResult(stringWriter);
            try {
                Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
                newTransformer.setOutputProperty("indent", "yes");
                newTransformer.transform(dOMSource, streamResult);
                return stringWriter.getBuffer().toString();
            } catch (TransformerConfigurationException e) {
                throw new IOException(e);
            } catch (TransformerException e2) {
                throw new IOException(e2);
            }
        } catch (ParserConfigurationException e3) {
            throw new IOException(e3);
        }
    }

    private AudioQuality getAudioQuality(Track track, AudioSampleEntry audioSampleEntry) {
        if (getFormat(audioSampleEntry).equals(AudioSampleEntry.TYPE3)) {
            return getAacAudioQuality(track, audioSampleEntry);
        }
        if (getFormat(audioSampleEntry).equals(AudioSampleEntry.TYPE9)) {
            return getEc3AudioQuality(track, audioSampleEntry);
        }
        if (getFormat(audioSampleEntry).startsWith("dts")) {
            return getDtsAudioQuality(track, audioSampleEntry);
        }
        throw new InternalError("I don't know what to do with audio of type " + getFormat(audioSampleEntry));
    }

    private AudioQuality getAacAudioQuality(Track track, AudioSampleEntry audioSampleEntry) {
        AudioQuality audioQuality = new AudioQuality();
        AudioSpecificConfig audioSpecificInfo = ((ESDescriptorBox) audioSampleEntry.getBoxes(ESDescriptorBox.class).get(0)).getEsDescriptor().getDecoderConfigDescriptor().getAudioSpecificInfo();
        if (audioSpecificInfo.getSbrPresentFlag() == 1) {
            audioQuality.fourCC = "AACH";
        } else if (audioSpecificInfo.getPsPresentFlag() == 1) {
            audioQuality.fourCC = "AACP";
        } else {
            audioQuality.fourCC = "AACL";
        }
        audioQuality.bitrate = getBitrate(track);
        audioQuality.audioTag = 255;
        audioQuality.samplingRate = audioSampleEntry.getSampleRate();
        audioQuality.channels = audioSampleEntry.getChannelCount();
        audioQuality.bitPerSample = audioSampleEntry.getSampleSize();
        audioQuality.packetSize = 4;
        audioQuality.codecPrivateData = getAudioCodecPrivateData(audioSpecificInfo);
        return audioQuality;
    }

    private AudioQuality getEc3AudioQuality(Track track, AudioSampleEntry audioSampleEntry) {
        ByteBuffer allocate;
        EC3SpecificBox eC3SpecificBox = (EC3SpecificBox) audioSampleEntry.getBoxes(EC3SpecificBox.class).get(0);
        if (eC3SpecificBox == null) {
            throw new RuntimeException("EC-3 track misses EC3SpecificBox!");
        }
        byte b = 0;
        byte b2 = 0;
        short s = 0;
        short s2 = 0;
        for (EC3SpecificBox.Entry entry : eC3SpecificBox.getEntries()) {
            switch (entry.acmod) {
                case 0:
                    short s3 = (short) (s2 + 2);
                    throw new RuntimeException("Smooth Streaming doesn't support DDP 1+1 mode");
                case 1:
                    s2 = (short) (s2 + 1);
                    if (entry.num_dep_sub > 0) {
                        a bNf = new a(b2, b, entry).bNf();
                        b2 = (byte) (b2 | bNf.bNd());
                        b = (byte) (b | bNf.bNe());
                        break;
                    } else {
                        b2 = (byte) (b2 | 32);
                        break;
                    }
                case 2:
                    s2 = (short) (s2 + 2);
                    if (entry.num_dep_sub > 0) {
                        a bNf2 = new a(b2, b, entry).bNf();
                        b2 = (byte) (b2 | bNf2.bNd());
                        b = (byte) (b | bNf2.bNe());
                        break;
                    } else {
                        b2 = (byte) (b2 | 192);
                        break;
                    }
                case 3:
                    s2 = (short) (s2 + 3);
                    if (entry.num_dep_sub > 0) {
                        a bNf3 = new a(b2, b, entry).bNf();
                        b2 = (byte) (b2 | bNf3.bNd());
                        b = (byte) (b | bNf3.bNe());
                        break;
                    } else {
                        b2 = (byte) (b2 | 224);
                        break;
                    }
                case 4:
                    s2 = (short) (s2 + 3);
                    if (entry.num_dep_sub > 0) {
                        a bNf4 = new a(b2, b, entry).bNf();
                        b2 = (byte) (b2 | bNf4.bNd());
                        b = (byte) (b | bNf4.bNe());
                        break;
                    } else {
                        b2 = (byte) (b2 | 192);
                        b = (byte) (b | 128);
                        break;
                    }
                case 5:
                    s2 = (short) (s2 + 4);
                    if (entry.num_dep_sub > 0) {
                        a bNf5 = new a(b2, b, entry).bNf();
                        b2 = (byte) (b2 | bNf5.bNd());
                        b = (byte) (b | bNf5.bNe());
                        break;
                    } else {
                        b2 = (byte) (b2 | 224);
                        b = (byte) (b | 128);
                        break;
                    }
                case 6:
                    s2 = (short) (s2 + 4);
                    if (entry.num_dep_sub > 0) {
                        a bNf6 = new a(b2, b, entry).bNf();
                        b2 = (byte) (b2 | bNf6.bNd());
                        b = (byte) (b | bNf6.bNe());
                        break;
                    } else {
                        b2 = (byte) (b2 | 204);
                        break;
                    }
                case 7:
                    s2 = (short) (s2 + 5);
                    if (entry.num_dep_sub > 0) {
                        a bNf7 = new a(b2, b, entry).bNf();
                        b2 = (byte) (b2 | bNf7.bNd());
                        b = (byte) (b | bNf7.bNe());
                        break;
                    } else {
                        b2 = (byte) (b2 | 236);
                        break;
                    }
            }
            if (entry.lfeon == 1) {
                s = (short) (s + 1);
                b2 = (byte) (b2 | 16);
            }
        }
        ByteBuffer allocate2 = ByteBuffer.allocate(22);
        allocate2.put(new byte[]{0, 6});
        allocate2.put(b2);
        allocate2.put(b);
        allocate2.put(new byte[2]);
        allocate2.put(new byte[]{-81, -121, -5, -89, 2, 45, -5, 66, -92, -44, 5, -51, -109, -124, 59, -35});
        eC3SpecificBox.getContent(ByteBuffer.allocate((int) eC3SpecificBox.getContentSize()));
        AudioQuality audioQuality = new AudioQuality();
        audioQuality.fourCC = "EC-3";
        audioQuality.bitrate = getBitrate(track);
        audioQuality.audioTag = 65534;
        audioQuality.samplingRate = audioSampleEntry.getSampleRate();
        audioQuality.channels = s2 + s;
        audioQuality.bitPerSample = 16;
        audioQuality.packetSize = (int) track.getSamples().get(0).getSize();
        audioQuality.codecPrivateData = String.valueOf(Hex.encodeHex(allocate2.array())) + Hex.encodeHex(allocate.array());
        return audioQuality;
    }

    private AudioQuality getDtsAudioQuality(Track track, AudioSampleEntry audioSampleEntry) {
        int i;
        DTSSpecificBox dTSSpecificBox = (DTSSpecificBox) audioSampleEntry.getBoxes(DTSSpecificBox.class).get(0);
        if (dTSSpecificBox == null) {
            throw new RuntimeException("DTS track misses DTSSpecificBox!");
        }
        ByteBuffer allocate = ByteBuffer.allocate(22);
        switch (dTSSpecificBox.getFrameDuration()) {
            case 0:
                i = 512;
                break;
            case 1:
                i = 1024;
                break;
            case 2:
                i = 2048;
                break;
            case 3:
                i = 4096;
                break;
            default:
                i = 0;
                break;
        }
        allocate.put((byte) (i & 255));
        allocate.put((byte) (i >>> 8));
        int i2 = getNumChannelsAndMask(dTSSpecificBox)[1];
        allocate.put((byte) (i2 & 255));
        allocate.put((byte) (i2 >>> 8));
        allocate.put((byte) (i2 >>> 16));
        allocate.put((byte) (i2 >>> 24));
        allocate.put(new byte[]{-82, -28, -65, 94, 97, 94, 65, -121, -110, -4, -92, -127, 38, -103, 2, 17});
        ByteBuffer allocate2 = ByteBuffer.allocate(8);
        allocate2.put((byte) dTSSpecificBox.getStreamConstruction());
        int channelLayout = dTSSpecificBox.getChannelLayout();
        allocate2.put((byte) (channelLayout & 255));
        allocate2.put((byte) (channelLayout >>> 8));
        allocate2.put((byte) (channelLayout >>> 16));
        allocate2.put((byte) (channelLayout >>> 24));
        allocate2.put((byte) (((byte) (dTSSpecificBox.getMultiAssetFlag() << 1)) | dTSSpecificBox.getLBRDurationMod()));
        allocate2.put(new byte[2]);
        AudioQuality audioQuality = new AudioQuality();
        audioQuality.fourCC = getFormat(audioSampleEntry);
        audioQuality.bitrate = dTSSpecificBox.getAvgBitRate();
        audioQuality.audioTag = 65534;
        audioQuality.samplingRate = dTSSpecificBox.getDTSSamplingFrequency();
        audioQuality.channels = getNumChannelsAndMask(dTSSpecificBox)[0];
        audioQuality.bitPerSample = 16;
        audioQuality.packetSize = (int) track.getSamples().get(0).getSize();
        audioQuality.codecPrivateData = String.valueOf(Hex.encodeHex(allocate.array())) + Hex.encodeHex(allocate2.array());
        return audioQuality;
    }

    private int[] getNumChannelsAndMask(DTSSpecificBox dTSSpecificBox) {
        int i;
        int i2;
        int i3;
        int i4;
        int channelLayout = dTSSpecificBox.getChannelLayout();
        if ((channelLayout & 1) == 1) {
            i = 4;
            i2 = 1;
        } else {
            i = 0;
            i2 = 0;
        }
        if ((channelLayout & 2) == 2) {
            i2 += 2;
            i = i | 1 | 2;
        }
        if ((channelLayout & 4) == 4) {
            i2 += 2;
            i = i | 16 | 32;
        }
        if ((channelLayout & 8) == 8) {
            i2++;
            i |= 8;
        }
        if ((channelLayout & 16) == 16) {
            i2++;
            i |= 256;
        }
        if ((channelLayout & 32) == 32) {
            i2 += 2;
            i = i | 4096 | 16384;
        }
        if ((channelLayout & 64) == 64) {
            i2 += 2;
            i = i | 16 | 32;
        }
        if ((channelLayout & 128) == 128) {
            i2++;
            i |= 8192;
        }
        if ((channelLayout & 256) == 256) {
            i2++;
            i |= 2048;
        }
        if ((channelLayout & 512) == 512) {
            i2 += 2;
            i = i | 64 | 128;
        }
        if ((channelLayout & 1024) == 1024) {
            i2 += 2;
            i = i | 512 | 1024;
        }
        if ((channelLayout & 2048) == 2048) {
            i2 += 2;
            i = i | 16 | 32;
        }
        if ((channelLayout & 4096) == 4096) {
            i2++;
            i |= 8;
        }
        if ((channelLayout & 8192) == 8192) {
            i2 += 2;
            i = i | 16 | 32;
        }
        if ((channelLayout & 16384) == 16384) {
            i2++;
            i |= 65536;
        }
        if ((channelLayout & 32768) == 32768) {
            int i5 = i | 32768 | 131072;
            i3 = i2 + 2;
            i4 = i5;
        } else {
            int i6 = i;
            i3 = i2;
            i4 = i6;
        }
        if ((channelLayout & 65536) == 65536) {
            i3++;
        }
        if ((channelLayout & 131072) == 131072) {
            i3 += 2;
        }
        return new int[]{i3, i4};
    }

    private String getAudioCodecPrivateData(AudioSpecificConfig audioSpecificConfig) {
        return Hex.encodeHex(audioSpecificConfig.getConfigBytes());
    }

    private com.googlecode.mp4parser.authoring.adaptivestreaming.a getVideoQuality(Track track, VisualSampleEntry visualSampleEntry) {
        if (VisualSampleEntry.TYPE3.equals(getFormat(visualSampleEntry))) {
            AvcConfigurationBox avcConfigurationBox = (AvcConfigurationBox) visualSampleEntry.getBoxes(AvcConfigurationBox.class).get(0);
            com.googlecode.mp4parser.authoring.adaptivestreaming.a aVar = new com.googlecode.mp4parser.authoring.adaptivestreaming.a();
            aVar.bitrate = getBitrate(track);
            aVar.codecPrivateData = Hex.encodeHex(getAvcCodecPrivateData(avcConfigurationBox));
            aVar.fourCC = "AVC1";
            aVar.width = visualSampleEntry.getWidth();
            aVar.height = visualSampleEntry.getHeight();
            aVar.hYX = avcConfigurationBox.getLengthSizeMinusOne() + 1;
            return aVar;
        }
        throw new InternalError("I don't know how to handle video of type " + getFormat(visualSampleEntry));
    }

    private byte[] getAvcCodecPrivateData(AvcConfigurationBox avcConfigurationBox) {
        List<byte[]> sequenceParameterSets = avcConfigurationBox.getSequenceParameterSets();
        List<byte[]> pictureParameterSets = avcConfigurationBox.getPictureParameterSets();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[4];
            bArr[3] = 1;
            byteArrayOutputStream.write(bArr);
            for (byte[] bArr2 : sequenceParameterSets) {
                byteArrayOutputStream.write(bArr2);
            }
            byte[] bArr3 = new byte[4];
            bArr3[3] = 1;
            byteArrayOutputStream.write(bArr3);
            for (byte[] bArr4 : pictureParameterSets) {
                byteArrayOutputStream.write(bArr4);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("ByteArrayOutputStream do not throw IOException ?!?!?");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        private byte hYT;
        private byte hYU;
        private EC3SpecificBox.Entry hYV;

        public a(byte b, byte b2, EC3SpecificBox.Entry entry) {
            this.hYT = b;
            this.hYU = b2;
            this.hYV = entry;
        }

        public byte bNd() {
            return this.hYT;
        }

        public byte bNe() {
            return this.hYU;
        }

        public a bNf() {
            switch (this.hYV.chan_loc) {
                case 0:
                    this.hYT = (byte) (this.hYT | 3);
                    break;
                case 1:
                    this.hYT = (byte) (this.hYT | 12);
                    break;
                case 2:
                    this.hYU = (byte) (this.hYU | 128);
                    break;
                case 3:
                    this.hYU = (byte) (this.hYU | 8);
                    break;
                case 6:
                    this.hYU = (byte) (this.hYU | 5);
                    break;
                case 7:
                    this.hYU = (byte) (this.hYU | 2);
                    break;
            }
            return this;
        }
    }
}
