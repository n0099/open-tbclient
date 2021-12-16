package com.googlecode.mp4parser.authoring.tracks;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes3.dex */
public class AppendTrack extends AbstractTrack {
    public static /* synthetic */ Interceptable $ic;
    public static Logger LOG;
    public transient /* synthetic */ FieldHolder $fh;
    public SampleDescriptionBox stsd;
    public Track[] tracks;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1456130965, "Lcom/googlecode/mp4parser/authoring/tracks/AppendTrack;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1456130965, "Lcom/googlecode/mp4parser/authoring/tracks/AppendTrack;");
                return;
            }
        }
        LOG = Logger.getLogger(AppendTrack.class);
    }

    public AppendTrack(Track... trackArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {trackArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tracks = trackArr;
        for (Track track : trackArr) {
            SampleDescriptionBox sampleDescriptionBox = this.stsd;
            if (sampleDescriptionBox == null) {
                SampleDescriptionBox sampleDescriptionBox2 = new SampleDescriptionBox();
                this.stsd = sampleDescriptionBox2;
                sampleDescriptionBox2.addBox((Box) track.getSampleDescriptionBox().getBoxes(SampleEntry.class).get(0));
            } else {
                this.stsd = mergeStsds(sampleDescriptionBox, track.getSampleDescriptionBox());
            }
        }
    }

    private AudioSampleEntry mergeAudioSampleEntries(AudioSampleEntry audioSampleEntry, AudioSampleEntry audioSampleEntry2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, audioSampleEntry, audioSampleEntry2)) == null) {
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
                                                                } catch (IOException e2) {
                                                                    LOG.logWarn(e2.getMessage());
                                                                    return null;
                                                                }
                                                            }
                                                        }
                                                        return audioSampleEntry3;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }
        return (AudioSampleEntry) invokeLL.objValue;
    }

    private ESDescriptor mergeDescriptors(BaseDescriptor baseDescriptor, BaseDescriptor baseDescriptor2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, baseDescriptor, baseDescriptor2)) == null) {
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
                        if (!decoderConfigDescriptor.getProfileLevelIndicationDescriptors().equals(decoderConfigDescriptor2.getProfileLevelIndicationDescriptors()) || decoderConfigDescriptor.getObjectTypeIndication() != decoderConfigDescriptor2.getObjectTypeIndication() || decoderConfigDescriptor.getStreamType() != decoderConfigDescriptor2.getStreamType() || decoderConfigDescriptor.getUpStream() != decoderConfigDescriptor2.getUpStream()) {
                            return null;
                        }
                    }
                    if (eSDescriptor.getOtherDescriptors() == null ? eSDescriptor2.getOtherDescriptors() == null : eSDescriptor.getOtherDescriptors().equals(eSDescriptor2.getOtherDescriptors())) {
                        if (eSDescriptor.getSlConfigDescriptor() == null ? eSDescriptor2.getSlConfigDescriptor() == null : eSDescriptor.getSlConfigDescriptor().equals(eSDescriptor2.getSlConfigDescriptor())) {
                            return eSDescriptor;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
            LOG.logError("I can only merge ESDescriptors");
            return null;
        }
        return (ESDescriptor) invokeLL.objValue;
    }

    private SampleEntry mergeSampleEntry(SampleEntry sampleEntry, SampleEntry sampleEntry2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, sampleEntry, sampleEntry2)) == null) {
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
        return (SampleEntry) invokeLL.objValue;
    }

    private SampleDescriptionBox mergeStsds(SampleDescriptionBox sampleDescriptionBox, SampleDescriptionBox sampleDescriptionBox2) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, sampleDescriptionBox, sampleDescriptionBox2)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                sampleDescriptionBox.getBox(Channels.newChannel(byteArrayOutputStream));
                sampleDescriptionBox2.getBox(Channels.newChannel(byteArrayOutputStream2));
                if (!Arrays.equals(byteArrayOutputStream2.toByteArray(), byteArrayOutputStream.toByteArray())) {
                    SampleEntry mergeSampleEntry = mergeSampleEntry((SampleEntry) sampleDescriptionBox.getBoxes(SampleEntry.class).get(0), (SampleEntry) sampleDescriptionBox2.getBoxes(SampleEntry.class).get(0));
                    if (mergeSampleEntry == null) {
                        throw new IOException("Cannot merge " + sampleDescriptionBox.getBoxes(SampleEntry.class).get(0) + " and " + sampleDescriptionBox2.getBoxes(SampleEntry.class).get(0));
                    }
                    sampleDescriptionBox.setBoxes(Collections.singletonList(mergeSampleEntry));
                }
                return sampleDescriptionBox;
            } catch (IOException e2) {
                LOG.logError(e2.getMessage());
                return null;
            }
        }
        return (SampleDescriptionBox) invokeLL.objValue;
    }

    private VisualSampleEntry mergeVisualSampleEntry(VisualSampleEntry visualSampleEntry, VisualSampleEntry visualSampleEntry2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, visualSampleEntry, visualSampleEntry2)) == null) {
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
                                                        AbstractDescriptorBox abstractDescriptorBox = (AbstractDescriptorBox) box;
                                                        abstractDescriptorBox.setDescriptor(mergeDescriptors(abstractDescriptorBox.getDescriptor(), ((AbstractDescriptorBox) next).getDescriptor()));
                                                        visualSampleEntry3.addBox(box);
                                                    }
                                                } catch (IOException e2) {
                                                    LOG.logWarn(e2.getMessage());
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
        return (VisualSampleEntry) invokeLL.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.tracks[0].getCompositionTimeEntries() == null || this.tracks[0].getCompositionTimeEntries().isEmpty()) {
                return null;
            }
            LinkedList<int[]> linkedList = new LinkedList();
            for (Track track : this.tracks) {
                linkedList.add(CompositionTimeToSample.blowupCompositionTimes(track.getCompositionTimeEntries()));
            }
            LinkedList linkedList2 = new LinkedList();
            for (int[] iArr : linkedList) {
                for (int i2 : iArr) {
                    if (!linkedList2.isEmpty() && ((CompositionTimeToSample.Entry) linkedList2.getLast()).getOffset() == i2) {
                        CompositionTimeToSample.Entry entry = (CompositionTimeToSample.Entry) linkedList2.getLast();
                        entry.setCount(entry.getCount() + 1);
                    } else {
                        linkedList2.add(new CompositionTimeToSample.Entry(1, i2));
                    }
                }
            }
            return linkedList2;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.tracks[0].getHandler() : (String) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.tracks[0].getMediaHeaderBox() : (Box) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.tracks[0].getSampleDependencies() == null || this.tracks[0].getSampleDependencies().isEmpty()) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (Track track : this.tracks) {
                linkedList.addAll(track.getSampleDependencies());
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.stsd : (SampleDescriptionBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSampleDurations() {
        InterceptResult invokeV;
        long[] jArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                int i2 = 0;
                for (Track track : this.tracks) {
                    i2 += track.getSampleDurations().length;
                }
                jArr = new long[i2];
                int i3 = 0;
                for (Track track2 : this.tracks) {
                    long[] sampleDurations = track2.getSampleDurations();
                    int length = sampleDurations.length;
                    int i4 = 0;
                    while (i4 < length) {
                        jArr[i3] = sampleDurations[i4];
                        i4++;
                        i3++;
                    }
                }
            }
            return jArr;
        }
        return (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Track track : this.tracks) {
                arrayList.addAll(track.getSamples());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.tracks[0].getSubsampleInformationBox() : (SubSampleInformationBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.tracks[0].getSyncSamples() == null || this.tracks[0].getSyncSamples().length <= 0) {
                return null;
            }
            int i2 = 0;
            for (Track track : this.tracks) {
                i2 += track.getSyncSamples().length;
            }
            long[] jArr = new long[i2];
            long j2 = 0;
            int i3 = 0;
            for (Track track2 : this.tracks) {
                long[] syncSamples = track2.getSyncSamples();
                int length = syncSamples.length;
                int i4 = 0;
                while (i4 < length) {
                    jArr[i3] = syncSamples[i4] + j2;
                    i4++;
                    i3++;
                }
                j2 += track2.getSamples().size();
            }
            return jArr;
        }
        return (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.tracks[0].getTrackMetaData() : (TrackMetaData) invokeV.objValue;
    }
}
