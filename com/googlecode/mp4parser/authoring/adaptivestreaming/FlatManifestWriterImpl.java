package com.googlecode.mp4parser.authoring.adaptivestreaming;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.baidu.webkit.internal.utils.UtilsBlink;
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
import io.flutter.plugin.common.StandardMessageCodec;
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
import kotlin.jvm.internal.ByteCompanionObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/* loaded from: classes6.dex */
public class FlatManifestWriterImpl extends AbstractManifestWriter {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Logger LOG = Logger.getLogger(FlatManifestWriterImpl.class.getName());

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public byte f31021a;

        /* renamed from: b  reason: collision with root package name */
        public byte f31022b;

        /* renamed from: c  reason: collision with root package name */
        public EC3SpecificBox.Entry f31023c;

        public a(FlatManifestWriterImpl flatManifestWriterImpl, byte b2, byte b3, EC3SpecificBox.Entry entry) {
            this.f31021a = b2;
            this.f31022b = b3;
            this.f31023c = entry;
        }

        public byte a() {
            return this.f31021a;
        }

        public byte b() {
            return this.f31022b;
        }

        public a c() {
            int i = this.f31023c.chan_loc;
            if (i == 0) {
                this.f31021a = (byte) (this.f31021a | 3);
            } else if (i == 1) {
                this.f31021a = (byte) (this.f31021a | StandardMessageCodec.LIST);
            } else if (i == 2) {
                this.f31022b = (byte) (this.f31022b | ByteCompanionObject.MIN_VALUE);
            } else if (i == 3) {
                this.f31022b = (byte) (this.f31022b | 8);
            } else if (i == 6) {
                this.f31022b = (byte) (this.f31022b | 5);
            } else if (i == 7) {
                this.f31022b = (byte) (this.f31022b | 2);
            }
            return this;
        }
    }

    public FlatManifestWriterImpl(FragmentIntersectionFinder fragmentIntersectionFinder) {
        super(fragmentIntersectionFinder);
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

    private String getAudioCodecPrivateData(AudioSpecificConfig audioSpecificConfig) {
        return Hex.encodeHex(audioSpecificConfig.getConfigBytes());
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
        } catch (IOException unused) {
            throw new RuntimeException("ByteArrayOutputStream do not throw IOException ?!?!?");
        }
    }

    private AudioQuality getDtsAudioQuality(Track track, AudioSampleEntry audioSampleEntry) {
        DTSSpecificBox dTSSpecificBox = (DTSSpecificBox) audioSampleEntry.getBoxes(DTSSpecificBox.class).get(0);
        if (dTSSpecificBox != null) {
            ByteBuffer allocate = ByteBuffer.allocate(22);
            int frameDuration = dTSSpecificBox.getFrameDuration();
            int i = frameDuration != 0 ? frameDuration != 1 ? frameDuration != 2 ? frameDuration != 3 ? 0 : 4096 : 2048 : 1024 : 512;
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
            audioQuality.audioTag = FragmentActivity.MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            audioQuality.samplingRate = dTSSpecificBox.getDTSSamplingFrequency();
            audioQuality.channels = getNumChannelsAndMask(dTSSpecificBox)[0];
            audioQuality.bitPerSample = 16;
            audioQuality.packetSize = (int) track.getSamples().get(0).getSize();
            audioQuality.codecPrivateData = String.valueOf(Hex.encodeHex(allocate.array())) + Hex.encodeHex(allocate2.array());
            return audioQuality;
        }
        throw new RuntimeException("DTS track misses DTSSpecificBox!");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0194 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x001b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AudioQuality getEc3AudioQuality(Track track, AudioSampleEntry audioSampleEntry) {
        int i;
        byte b2;
        int i2;
        int i3;
        EC3SpecificBox eC3SpecificBox = (EC3SpecificBox) audioSampleEntry.getBoxes(EC3SpecificBox.class).get(0);
        if (eC3SpecificBox != null) {
            byte b3 = 0;
            byte b4 = 0;
            short s = 0;
            short s2 = 0;
            for (EC3SpecificBox.Entry entry : eC3SpecificBox.getEntries()) {
                switch (entry.acmod) {
                    case 0:
                        throw new RuntimeException("Smooth Streaming doesn't support DDP 1+1 mode");
                    case 1:
                        s = (short) (s + 1);
                        if (entry.num_dep_sub > 0) {
                            a aVar = new a(this, b3, b4, entry);
                            aVar.c();
                            b3 = (byte) (b3 | aVar.a());
                            b2 = aVar.b();
                            i3 = b4 | b2;
                            b4 = (byte) i3;
                            if (entry.lfeon == 1) {
                                s2 = (short) (s2 + 1);
                                b3 = (byte) (b3 | 16);
                            }
                        } else {
                            i = b3 | 32;
                            b3 = (byte) i;
                            if (entry.lfeon == 1) {
                            }
                        }
                    case 2:
                        s = (short) (s + 2);
                        if (entry.num_dep_sub > 0) {
                            a aVar2 = new a(this, b3, b4, entry);
                            aVar2.c();
                            b3 = (byte) (b3 | aVar2.a());
                            b2 = aVar2.b();
                            i3 = b4 | b2;
                            b4 = (byte) i3;
                            if (entry.lfeon == 1) {
                            }
                        } else {
                            i = b3 | ExifInterface.MARKER_SOF0;
                            b3 = (byte) i;
                            if (entry.lfeon == 1) {
                            }
                        }
                        break;
                    case 3:
                        s = (short) (s + 3);
                        if (entry.num_dep_sub > 0) {
                            a aVar3 = new a(this, b3, b4, entry);
                            aVar3.c();
                            b3 = (byte) (b3 | aVar3.a());
                            b2 = aVar3.b();
                            i3 = b4 | b2;
                            b4 = (byte) i3;
                            if (entry.lfeon == 1) {
                            }
                        } else {
                            i = b3 | 224;
                            b3 = (byte) i;
                            if (entry.lfeon == 1) {
                            }
                        }
                        break;
                    case 4:
                        s = (short) (s + 3);
                        if (entry.num_dep_sub > 0) {
                            a aVar4 = new a(this, b3, b4, entry);
                            aVar4.c();
                            b3 = (byte) (b3 | aVar4.a());
                            b2 = aVar4.b();
                            i3 = b4 | b2;
                            b4 = (byte) i3;
                            if (entry.lfeon == 1) {
                            }
                        } else {
                            i2 = b3 | ExifInterface.MARKER_SOF0;
                            b3 = (byte) i2;
                            i3 = b4 | ByteCompanionObject.MIN_VALUE;
                            b4 = (byte) i3;
                            if (entry.lfeon == 1) {
                            }
                        }
                        break;
                    case 5:
                        s = (short) (s + 4);
                        if (entry.num_dep_sub > 0) {
                            a aVar5 = new a(this, b3, b4, entry);
                            aVar5.c();
                            b3 = (byte) (b3 | aVar5.a());
                            b2 = aVar5.b();
                            i3 = b4 | b2;
                            b4 = (byte) i3;
                            if (entry.lfeon == 1) {
                            }
                        } else {
                            i2 = b3 | 224;
                            b3 = (byte) i2;
                            i3 = b4 | ByteCompanionObject.MIN_VALUE;
                            b4 = (byte) i3;
                            if (entry.lfeon == 1) {
                            }
                        }
                        break;
                    case 6:
                        s = (short) (s + 4);
                        if (entry.num_dep_sub > 0) {
                            a aVar6 = new a(this, b3, b4, entry);
                            aVar6.c();
                            b3 = (byte) (b3 | aVar6.a());
                            b2 = aVar6.b();
                            i3 = b4 | b2;
                            b4 = (byte) i3;
                            if (entry.lfeon == 1) {
                            }
                        } else {
                            i = b3 | 204;
                            b3 = (byte) i;
                            if (entry.lfeon == 1) {
                            }
                        }
                        break;
                    case 7:
                        s = (short) (s + 5);
                        if (entry.num_dep_sub > 0) {
                            a aVar7 = new a(this, b3, b4, entry);
                            aVar7.c();
                            b3 = (byte) (b3 | aVar7.a());
                            b2 = aVar7.b();
                            i3 = b4 | b2;
                            b4 = (byte) i3;
                            if (entry.lfeon == 1) {
                            }
                        } else {
                            i = b3 | 236;
                            b3 = (byte) i;
                            if (entry.lfeon == 1) {
                            }
                        }
                        break;
                    default:
                        if (entry.lfeon == 1) {
                        }
                        break;
                }
            }
            ByteBuffer allocate = ByteBuffer.allocate(22);
            allocate.put(new byte[]{0, 6});
            allocate.put(b3);
            allocate.put(b4);
            allocate.put(new byte[2]);
            allocate.put(new byte[]{-81, -121, -5, -89, 2, UtilsBlink.VER_TYPE_SEPARATOR, -5, 66, -92, -44, 5, ExifInterface.MARKER_SOF13, -109, -124, 59, -35});
            ByteBuffer allocate2 = ByteBuffer.allocate((int) eC3SpecificBox.getContentSize());
            eC3SpecificBox.getContent(allocate2);
            AudioQuality audioQuality = new AudioQuality();
            audioQuality.fourCC = "EC-3";
            audioQuality.bitrate = getBitrate(track);
            audioQuality.audioTag = FragmentActivity.MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            audioQuality.samplingRate = audioSampleEntry.getSampleRate();
            audioQuality.channels = s + s2;
            audioQuality.bitPerSample = 16;
            audioQuality.packetSize = (int) track.getSamples().get(0).getSize();
            audioQuality.codecPrivateData = String.valueOf(Hex.encodeHex(allocate.array())) + Hex.encodeHex(allocate2.array());
            return audioQuality;
        }
        throw new RuntimeException("EC-3 track misses EC3SpecificBox!");
    }

    private int[] getNumChannelsAndMask(DTSSpecificBox dTSSpecificBox) {
        int i;
        int i2;
        int channelLayout = dTSSpecificBox.getChannelLayout();
        if ((channelLayout & 1) == 1) {
            i = 1;
            i2 = 4;
        } else {
            i = 0;
            i2 = 0;
        }
        if ((channelLayout & 2) == 2) {
            i += 2;
            i2 = i2 | 1 | 2;
        }
        if ((channelLayout & 4) == 4) {
            i += 2;
            i2 = i2 | 16 | 32;
        }
        if ((channelLayout & 8) == 8) {
            i++;
            i2 |= 8;
        }
        if ((channelLayout & 16) == 16) {
            i++;
            i2 |= 256;
        }
        if ((channelLayout & 32) == 32) {
            i += 2;
            i2 = i2 | 4096 | 16384;
        }
        if ((channelLayout & 64) == 64) {
            i += 2;
            i2 = i2 | 16 | 32;
        }
        if ((channelLayout & 128) == 128) {
            i++;
            i2 |= 8192;
        }
        if ((channelLayout & 256) == 256) {
            i++;
            i2 |= 2048;
        }
        if ((channelLayout & 512) == 512) {
            i += 2;
            i2 = i2 | 64 | 128;
        }
        if ((channelLayout & 1024) == 1024) {
            i += 2;
            i2 = i2 | 512 | 1024;
        }
        if ((channelLayout & 2048) == 2048) {
            i += 2;
            i2 = i2 | 16 | 32;
        }
        if ((channelLayout & 4096) == 4096) {
            i++;
            i2 |= 8;
        }
        if ((channelLayout & 8192) == 8192) {
            i += 2;
            i2 = i2 | 16 | 32;
        }
        if ((channelLayout & 16384) == 16384) {
            i++;
            i2 |= 65536;
        }
        if ((channelLayout & 32768) == 32768) {
            i += 2;
            i2 = 32768 | i2 | 131072;
        }
        if ((channelLayout & 65536) == 65536) {
            i++;
        }
        if ((channelLayout & 131072) == 131072) {
            i += 2;
        }
        return new int[]{i, i2};
    }

    private d.h.a.a.a.a getVideoQuality(Track track, VisualSampleEntry visualSampleEntry) {
        if (VisualSampleEntry.TYPE3.equals(getFormat(visualSampleEntry))) {
            AvcConfigurationBox avcConfigurationBox = (AvcConfigurationBox) visualSampleEntry.getBoxes(AvcConfigurationBox.class).get(0);
            d.h.a.a.a.a aVar = new d.h.a.a.a.a();
            aVar.f66180a = getBitrate(track);
            aVar.f66184e = Hex.encodeHex(getAvcCodecPrivateData(avcConfigurationBox));
            aVar.f66181b = "AVC1";
            aVar.f66182c = visualSampleEntry.getWidth();
            aVar.f66183d = visualSampleEntry.getHeight();
            aVar.f66185f = avcConfigurationBox.getLengthSizeMinusOne() + 1;
            return aVar;
        }
        throw new InternalError("I don't know how to handle video of type " + getFormat(visualSampleEntry));
    }

    public Document customizeManifest(Document document) {
        return document;
    }

    @Override // com.googlecode.mp4parser.authoring.adaptivestreaming.ManifestWriter
    public String getManifest(Movie movie) throws IOException {
        Element element;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        long j = -1;
        long j2 = -1;
        for (Track track : movie.getTracks()) {
            if (track.getMediaHeaderBox() instanceof VideoMediaHeaderBox) {
                this.videoFragmentsDurations = checkFragmentsAlign(this.videoFragmentsDurations, calculateFragmentDurations(track, movie));
                linkedList.add(getVideoQuality(track, (VisualSampleEntry) track.getSampleDescriptionBox().getSampleEntry()));
                if (j == -1) {
                    j = track.getTrackMetaData().getTimescale();
                }
            }
            if (track.getMediaHeaderBox() instanceof SoundMediaHeaderBox) {
                this.audioFragmentsDurations = checkFragmentsAlign(this.audioFragmentsDurations, calculateFragmentDurations(track, movie));
                linkedList2.add(getAudioQuality(track, (AudioSampleEntry) track.getSampleDescriptionBox().getSampleEntry()));
                if (j2 == -1) {
                    j2 = track.getTrackMetaData().getTimescale();
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
            String str8 = "StreamIndex";
            Element createElement2 = newDocument.createElement("StreamIndex");
            String str9 = "Type";
            createElement2.setAttribute("Type", "video");
            String str10 = "TimeScale";
            createElement2.setAttribute("TimeScale", Long.toString(j));
            String str11 = "Chunks";
            createElement2.setAttribute("Chunks", Integer.toString(this.videoFragmentsDurations.length));
            String str12 = "Url";
            createElement2.setAttribute("Url", "video/{bitrate}/{start time}");
            String str13 = "QualityLevels";
            createElement2.setAttribute("QualityLevels", Integer.toString(linkedList.size()));
            createElement.appendChild(createElement2);
            int i = 0;
            while (true) {
                int size = linkedList.size();
                LinkedList linkedList3 = linkedList;
                element = createElement2;
                str = "CodecPrivateData";
                str2 = "Bitrate";
                str3 = "Index";
                str4 = "FourCC";
                str5 = "QualityLevel";
                if (i >= size) {
                    break;
                }
                String str14 = str9;
                String str15 = str11;
                createElement2 = element;
                linkedList = linkedList3;
                d.h.a.a.a.a aVar = (d.h.a.a.a.a) linkedList.get(i);
                Element createElement3 = newDocument.createElement("QualityLevel");
                createElement3.setAttribute("Index", Integer.toString(i));
                createElement3.setAttribute(str2, Long.toString(aVar.f66180a));
                createElement3.setAttribute(str4, aVar.f66181b);
                createElement3.setAttribute("MaxWidth", Long.toString(aVar.f66182c));
                createElement3.setAttribute("MaxHeight", Long.toString(aVar.f66183d));
                createElement3.setAttribute(str, aVar.f66184e);
                createElement3.setAttribute("NALUnitLengthField", Integer.toString(aVar.f66185f));
                createElement2.appendChild(createElement3);
                i++;
                str13 = str13;
                createElement = createElement;
                str8 = str8;
                str12 = str12;
                str10 = str10;
                str9 = str14;
                str11 = str15;
            }
            int i2 = 0;
            while (true) {
                str6 = str3;
                str7 = str5;
                if (i2 >= this.videoFragmentsDurations.length) {
                    break;
                }
                Element element2 = createElement;
                String str16 = str;
                Element createElement4 = newDocument.createElement("c");
                createElement4.setAttribute("n", Integer.toString(i2));
                createElement4.setAttribute("d", Long.toString(this.videoFragmentsDurations[i2]));
                element.appendChild(createElement4);
                i2++;
                str3 = str6;
                str5 = str7;
                str10 = str10;
                str9 = str9;
                str11 = str11;
                str4 = str4;
                str8 = str8;
                str = str16;
                createElement = element2;
                str2 = str2;
                str12 = str12;
            }
            if (this.audioFragmentsDurations != null) {
                Element createElement5 = newDocument.createElement(str8);
                createElement5.setAttribute(str9, "audio");
                createElement5.setAttribute(str10, Long.toString(j2));
                createElement5.setAttribute(str11, Integer.toString(this.audioFragmentsDurations.length));
                createElement5.setAttribute(str12, "audio/{bitrate}/{start time}");
                createElement5.setAttribute(str13, Integer.toString(linkedList2.size()));
                createElement.appendChild(createElement5);
                for (int i3 = 0; i3 < linkedList2.size(); i3++) {
                    AudioQuality audioQuality = (AudioQuality) linkedList2.get(i3);
                    Element createElement6 = newDocument.createElement(str7);
                    createElement6.setAttribute(str6, Integer.toString(i3));
                    createElement6.setAttribute(str4, audioQuality.fourCC);
                    createElement6.setAttribute(str2, Long.toString(audioQuality.bitrate));
                    createElement6.setAttribute("AudioTag", Integer.toString(audioQuality.audioTag));
                    createElement6.setAttribute("SamplingRate", Long.toString(audioQuality.samplingRate));
                    createElement6.setAttribute("Channels", Integer.toString(audioQuality.channels));
                    createElement6.setAttribute(ExifInterface.TAG_BITS_PER_SAMPLE, Integer.toString(audioQuality.bitPerSample));
                    createElement6.setAttribute("PacketSize", Integer.toString(audioQuality.packetSize));
                    createElement6.setAttribute(str, audioQuality.codecPrivateData);
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
            } catch (TransformerConfigurationException e2) {
                throw new IOException(e2);
            } catch (TransformerException e3) {
                throw new IOException(e3);
            }
        } catch (ParserConfigurationException e4) {
            throw new IOException(e4);
        }
    }
}
