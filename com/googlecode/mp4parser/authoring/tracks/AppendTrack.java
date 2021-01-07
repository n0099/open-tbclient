package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.SampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderConfigDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import com.googlecode.mp4parser.util.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class AppendTrack extends AbstractTrack {
    private static Logger LOG = Logger.getLogger(AppendTrack.class);
    SampleDescriptionBox stsd;
    Track[] tracks;

    public AppendTrack(Track... trackArr) throws IOException {
        this.tracks = trackArr;
        for (Track track : trackArr) {
            if (this.stsd == null) {
                this.stsd = new SampleDescriptionBox();
                this.stsd.addBox((Box) track.getSampleDescriptionBox().getBoxes(SampleEntry.class).get(0));
            } else {
                this.stsd = mergeStsds(this.stsd, track.getSampleDescriptionBox());
            }
        }
    }

    private SampleDescriptionBox mergeStsds(SampleDescriptionBox sampleDescriptionBox, SampleDescriptionBox sampleDescriptionBox2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            sampleDescriptionBox.getBox(Channels.newChannel(byteArrayOutputStream));
            sampleDescriptionBox2.getBox(Channels.newChannel(byteArrayOutputStream2));
            if (!Arrays.equals(byteArrayOutputStream2.toByteArray(), byteArrayOutputStream.toByteArray())) {
                SampleEntry mergeSampleEntry = mergeSampleEntry((SampleEntry) sampleDescriptionBox.getBoxes(SampleEntry.class).get(0), (SampleEntry) sampleDescriptionBox2.getBoxes(SampleEntry.class).get(0));
                if (mergeSampleEntry != null) {
                    sampleDescriptionBox.setBoxes(Collections.singletonList(mergeSampleEntry));
                    return sampleDescriptionBox;
                }
                throw new IOException("Cannot merge " + sampleDescriptionBox.getBoxes(SampleEntry.class).get(0) + " and " + sampleDescriptionBox2.getBoxes(SampleEntry.class).get(0));
            }
            return sampleDescriptionBox;
        } catch (IOException e) {
            LOG.logError(e.getMessage());
            return null;
        }
    }

    private SampleEntry mergeSampleEntry(SampleEntry sampleEntry, SampleEntry sampleEntry2) {
        if (sampleEntry.getType().equals(sampleEntry2.getType())) {
            if ((sampleEntry instanceof VisualSampleEntry) && (sampleEntry2 instanceof VisualSampleEntry)) {
                return mergeVisualSampleEntry((VisualSampleEntry) sampleEntry, (VisualSampleEntry) sampleEntry2);
            }
            if ((sampleEntry instanceof AudioSampleEntry) && (sampleEntry2 instanceof AudioSampleEntry)) {
                return mergeAudioSampleEntries((AudioSampleEntry) sampleEntry, (AudioSampleEntry) sampleEntry2);
            }
            return null;
        }
        return null;
    }

    private VisualSampleEntry mergeVisualSampleEntry(VisualSampleEntry visualSampleEntry, VisualSampleEntry visualSampleEntry2) {
        VisualSampleEntry visualSampleEntry3 = new VisualSampleEntry();
        if (visualSampleEntry.getHorizresolution() == visualSampleEntry2.getHorizresolution()) {
            visualSampleEntry3.setHorizresolution(visualSampleEntry.getHorizresolution());
            visualSampleEntry3.setCompressorname(visualSampleEntry.getCompressorname());
            if (visualSampleEntry.getDepth() == visualSampleEntry2.getDepth()) {
                visualSampleEntry3.setDepth(visualSampleEntry.getDepth());
                if (visualSampleEntry.getFrameCount() == visualSampleEntry2.getFrameCount()) {
                    visualSampleEntry3.setFrameCount(visualSampleEntry.getFrameCount());
                    if (visualSampleEntry.getHeight() == visualSampleEntry2.getHeight()) {
                        visualSampleEntry3.setHeight(visualSampleEntry.getHeight());
                        if (visualSampleEntry.getWidth() == visualSampleEntry2.getWidth()) {
                            visualSampleEntry3.setWidth(visualSampleEntry.getWidth());
                            if (visualSampleEntry.getVertresolution() == visualSampleEntry2.getVertresolution()) {
                                visualSampleEntry3.setVertresolution(visualSampleEntry.getVertresolution());
                                if (visualSampleEntry.getHorizresolution() == visualSampleEntry2.getHorizresolution()) {
                                    visualSampleEntry3.setHorizresolution(visualSampleEntry.getHorizresolution());
                                    if (visualSampleEntry.getBoxes().size() == visualSampleEntry2.getBoxes().size()) {
                                        Iterator<Box> it = visualSampleEntry2.getBoxes().iterator();
                                        for (Box box : visualSampleEntry.getBoxes()) {
                                            Box next = it.next();
                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                            try {
                                                box.getBox(Channels.newChannel(byteArrayOutputStream));
                                                next.getBox(Channels.newChannel(byteArrayOutputStream2));
                                                if (Arrays.equals(byteArrayOutputStream.toByteArray(), byteArrayOutputStream2.toByteArray())) {
                                                    visualSampleEntry3.addBox(box);
                                                } else if ((box instanceof AbstractDescriptorBox) && (next instanceof AbstractDescriptorBox)) {
                                                    ((AbstractDescriptorBox) box).setDescriptor(mergeDescriptors(((AbstractDescriptorBox) box).getDescriptor(), ((AbstractDescriptorBox) next).getDescriptor()));
                                                    visualSampleEntry3.addBox(box);
                                                }
                                            } catch (IOException e) {
                                                LOG.logWarn(e.getMessage());
                                                return null;
                                            }
                                        }
                                    }
                                    return visualSampleEntry3;
                                }
                                LOG.logError("horizontal resolution differs");
                                return null;
                            }
                            LOG.logError("vert resolution differs");
                            return null;
                        }
                        LOG.logError("width differs");
                        return null;
                    }
                    LOG.logError("height differs");
                    return null;
                }
                LOG.logError("frame count differs");
                return null;
            }
            LOG.logError("Depth differs");
            return null;
        }
        LOG.logError("Horizontal Resolution differs");
        return null;
    }

    private AudioSampleEntry mergeAudioSampleEntries(AudioSampleEntry audioSampleEntry, AudioSampleEntry audioSampleEntry2) {
        AudioSampleEntry audioSampleEntry3 = new AudioSampleEntry(audioSampleEntry2.getType());
        if (audioSampleEntry.getBytesPerFrame() == audioSampleEntry2.getBytesPerFrame()) {
            LOG.logError("BytesPerFrame differ");
            audioSampleEntry3.setBytesPerFrame(audioSampleEntry.getBytesPerFrame());
            if (audioSampleEntry.getBytesPerPacket() == audioSampleEntry2.getBytesPerPacket()) {
                audioSampleEntry3.setBytesPerPacket(audioSampleEntry.getBytesPerPacket());
                if (audioSampleEntry.getBytesPerSample() == audioSampleEntry2.getBytesPerSample()) {
                    LOG.logError("BytesPerSample differ");
                    audioSampleEntry3.setBytesPerSample(audioSampleEntry.getBytesPerSample());
                    if (audioSampleEntry.getChannelCount() == audioSampleEntry2.getChannelCount()) {
                        LOG.logError("ChannelCount differ");
                        audioSampleEntry3.setChannelCount(audioSampleEntry.getChannelCount());
                        if (audioSampleEntry.getPacketSize() == audioSampleEntry2.getPacketSize()) {
                            audioSampleEntry3.setPacketSize(audioSampleEntry.getPacketSize());
                            if (audioSampleEntry.getCompressionId() == audioSampleEntry2.getCompressionId()) {
                                audioSampleEntry3.setCompressionId(audioSampleEntry.getCompressionId());
                                if (audioSampleEntry.getSampleRate() == audioSampleEntry2.getSampleRate()) {
                                    audioSampleEntry3.setSampleRate(audioSampleEntry.getSampleRate());
                                    if (audioSampleEntry.getSampleSize() == audioSampleEntry2.getSampleSize()) {
                                        audioSampleEntry3.setSampleSize(audioSampleEntry.getSampleSize());
                                        if (audioSampleEntry.getSamplesPerPacket() == audioSampleEntry2.getSamplesPerPacket()) {
                                            audioSampleEntry3.setSamplesPerPacket(audioSampleEntry.getSamplesPerPacket());
                                            if (audioSampleEntry.getSoundVersion() == audioSampleEntry2.getSoundVersion()) {
                                                audioSampleEntry3.setSoundVersion(audioSampleEntry.getSoundVersion());
                                                if (Arrays.equals(audioSampleEntry.getSoundVersion2Data(), audioSampleEntry2.getSoundVersion2Data())) {
                                                    audioSampleEntry3.setSoundVersion2Data(audioSampleEntry.getSoundVersion2Data());
                                                    if (audioSampleEntry.getBoxes().size() == audioSampleEntry2.getBoxes().size()) {
                                                        Iterator<Box> it = audioSampleEntry2.getBoxes().iterator();
                                                        for (Box box : audioSampleEntry.getBoxes()) {
                                                            Box next = it.next();
                                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                                            try {
                                                                box.getBox(Channels.newChannel(byteArrayOutputStream));
                                                                next.getBox(Channels.newChannel(byteArrayOutputStream2));
                                                                if (Arrays.equals(byteArrayOutputStream.toByteArray(), byteArrayOutputStream2.toByteArray())) {
                                                                    audioSampleEntry3.addBox(box);
                                                                } else if (ESDescriptorBox.TYPE.equals(box.getType()) && ESDescriptorBox.TYPE.equals(next.getType())) {
                                                                    ESDescriptorBox eSDescriptorBox = (ESDescriptorBox) box;
                                                                    eSDescriptorBox.setDescriptor(mergeDescriptors(eSDescriptorBox.getEsDescriptor(), ((ESDescriptorBox) next).getEsDescriptor()));
                                                                    audioSampleEntry3.addBox(box);
                                                                }
                                                            } catch (IOException e) {
                                                                LOG.logWarn(e.getMessage());
                                                                return null;
                                                            }
                                                        }
                                                    }
                                                    return audioSampleEntry3;
                                                }
                                                return null;
                                            }
                                            return null;
                                        }
                                        return null;
                                    }
                                    return null;
                                }
                                return null;
                            }
                            return null;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private ESDescriptor mergeDescriptors(BaseDescriptor baseDescriptor, BaseDescriptor baseDescriptor2) {
        if ((baseDescriptor instanceof ESDescriptor) && (baseDescriptor2 instanceof ESDescriptor)) {
            ESDescriptor eSDescriptor = (ESDescriptor) baseDescriptor;
            ESDescriptor eSDescriptor2 = (ESDescriptor) baseDescriptor2;
            if (eSDescriptor.getURLFlag() != eSDescriptor2.getURLFlag()) {
                return null;
            }
            eSDescriptor.getURLLength();
            eSDescriptor2.getURLLength();
            if (eSDescriptor.getDependsOnEsId() == eSDescriptor2.getDependsOnEsId() && eSDescriptor.getEsId() == eSDescriptor2.getEsId() && eSDescriptor.getoCREsId() == eSDescriptor2.getoCREsId() && eSDescriptor.getoCRstreamFlag() == eSDescriptor2.getoCRstreamFlag() && eSDescriptor.getRemoteODFlag() == eSDescriptor2.getRemoteODFlag() && eSDescriptor.getStreamDependenceFlag() == eSDescriptor2.getStreamDependenceFlag()) {
                eSDescriptor.getStreamPriority();
                eSDescriptor2.getStreamPriority();
                if (eSDescriptor.getURLString() != null) {
                    eSDescriptor.getURLString().equals(eSDescriptor2.getURLString());
                } else {
                    eSDescriptor2.getURLString();
                }
                if (eSDescriptor.getDecoderConfigDescriptor() == null ? eSDescriptor2.getDecoderConfigDescriptor() != null : !eSDescriptor.getDecoderConfigDescriptor().equals(eSDescriptor2.getDecoderConfigDescriptor())) {
                    DecoderConfigDescriptor decoderConfigDescriptor = eSDescriptor.getDecoderConfigDescriptor();
                    DecoderConfigDescriptor decoderConfigDescriptor2 = eSDescriptor2.getDecoderConfigDescriptor();
                    if (decoderConfigDescriptor.getAudioSpecificInfo() != null && decoderConfigDescriptor2.getAudioSpecificInfo() != null && !decoderConfigDescriptor.getAudioSpecificInfo().equals(decoderConfigDescriptor2.getAudioSpecificInfo())) {
                        return null;
                    }
                    if (decoderConfigDescriptor.getAvgBitRate() != decoderConfigDescriptor2.getAvgBitRate()) {
                        decoderConfigDescriptor.setAvgBitRate((decoderConfigDescriptor.getAvgBitRate() + decoderConfigDescriptor2.getAvgBitRate()) / 2);
                    }
                    decoderConfigDescriptor.getBufferSizeDB();
                    decoderConfigDescriptor2.getBufferSizeDB();
                    if (decoderConfigDescriptor.getDecoderSpecificInfo() == null ? decoderConfigDescriptor2.getDecoderSpecificInfo() != null : !decoderConfigDescriptor.getDecoderSpecificInfo().equals(decoderConfigDescriptor2.getDecoderSpecificInfo())) {
                        return null;
                    }
                    if (decoderConfigDescriptor.getMaxBitRate() != decoderConfigDescriptor2.getMaxBitRate()) {
                        decoderConfigDescriptor.setMaxBitRate(Math.max(decoderConfigDescriptor.getMaxBitRate(), decoderConfigDescriptor2.getMaxBitRate()));
                    }
                    if (!decoderConfigDescriptor.getProfileLevelIndicationDescriptors().equals(decoderConfigDescriptor2.getProfileLevelIndicationDescriptors())) {
                        return null;
                    }
                    if (decoderConfigDescriptor.getObjectTypeIndication() != decoderConfigDescriptor2.getObjectTypeIndication()) {
                        return null;
                    }
                    if (decoderConfigDescriptor.getStreamType() != decoderConfigDescriptor2.getStreamType()) {
                        return null;
                    }
                    if (decoderConfigDescriptor.getUpStream() != decoderConfigDescriptor2.getUpStream()) {
                        return null;
                    }
                }
                if (eSDescriptor.getOtherDescriptors() == null ? eSDescriptor2.getOtherDescriptors() != null : !eSDescriptor.getOtherDescriptors().equals(eSDescriptor2.getOtherDescriptors())) {
                    return null;
                }
                if (eSDescriptor.getSlConfigDescriptor() != null) {
                    if (eSDescriptor.getSlConfigDescriptor().equals(eSDescriptor2.getSlConfigDescriptor())) {
                        return eSDescriptor;
                    }
                } else if (eSDescriptor2.getSlConfigDescriptor() == null) {
                    return eSDescriptor;
                }
                return null;
            }
            return null;
        }
        LOG.logError("I can only merge ESDescriptors");
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        ArrayList arrayList = new ArrayList();
        for (Track track : this.tracks) {
            arrayList.addAll(track.getSamples());
        }
        return arrayList;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.stsd;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSampleDurations() {
        long[] jArr;
        int i = 0;
        for (Track track : this.tracks) {
            i += track.getSampleDurations().length;
        }
        jArr = new long[i];
        int i2 = 0;
        for (Track track2 : this.tracks) {
            long[] sampleDurations = track2.getSampleDurations();
            int length = sampleDurations.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = i2 + 1;
                jArr[i2] = sampleDurations[i3];
                i3++;
                i2 = i4;
            }
        }
        return jArr;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        if (this.tracks[0].getCompositionTimeEntries() != null && !this.tracks[0].getCompositionTimeEntries().isEmpty()) {
            LinkedList<int[]> linkedList = new LinkedList();
            for (Track track : this.tracks) {
                linkedList.add(CompositionTimeToSample.blowupCompositionTimes(track.getCompositionTimeEntries()));
            }
            LinkedList linkedList2 = new LinkedList();
            for (int[] iArr : linkedList) {
                for (int i : iArr) {
                    if (linkedList2.isEmpty() || ((CompositionTimeToSample.Entry) linkedList2.getLast()).getOffset() != i) {
                        linkedList2.add(new CompositionTimeToSample.Entry(1, i));
                    } else {
                        CompositionTimeToSample.Entry entry = (CompositionTimeToSample.Entry) linkedList2.getLast();
                        entry.setCount(entry.getCount() + 1);
                    }
                }
            }
            return linkedList2;
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        if (this.tracks[0].getSyncSamples() != null && this.tracks[0].getSyncSamples().length > 0) {
            int i = 0;
            for (Track track : this.tracks) {
                i += track.getSyncSamples().length;
            }
            long[] jArr = new long[i];
            int i2 = 0;
            long j = 0;
            for (Track track2 : this.tracks) {
                long[] syncSamples = track2.getSyncSamples();
                int length = syncSamples.length;
                int i3 = 0;
                while (i3 < length) {
                    jArr[i2] = syncSamples[i3] + j;
                    i3++;
                    i2++;
                }
                j += track2.getSamples().size();
            }
            return jArr;
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        if (this.tracks[0].getSampleDependencies() != null && !this.tracks[0].getSampleDependencies().isEmpty()) {
            LinkedList linkedList = new LinkedList();
            for (Track track : this.tracks) {
                linkedList.addAll(track.getSampleDependencies());
            }
            return linkedList;
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.tracks[0].getTrackMetaData();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return this.tracks[0].getHandler();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        return this.tracks[0].getMediaHeaderBox();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return this.tracks[0].getSubsampleInformationBox();
    }
}
