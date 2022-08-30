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
/* loaded from: classes7.dex */
public class AACTrackImpl extends AbstractTrack {
    public static /* synthetic */ Interceptable $ic;
    public static Map<Integer, String> audioObjectTypes;
    public static Map<Integer, Integer> samplingFrequencyIndexMap;
    public transient /* synthetic */ FieldHolder $fh;
    public long avgBitRate;
    public int bufferSizeDB;
    public long[] decTimes;
    public AdtsHeader firstHeader;
    public String lang;
    public long maxBitRate;
    public SampleDescriptionBox sampleDescriptionBox;
    public List<Sample> samples;
    public TrackMetaData trackMetaData;

    /* loaded from: classes7.dex */
    public class AdtsHeader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int bufferFullness;
        public int channelconfig;
        public int copyrightStart;
        public int copyrightedStream;
        public int frameLength;
        public int home;
        public int layer;
        public int mpegVersion;
        public int numAacFramesPerAdtsFrame;
        public int original;
        public int profile;
        public int protectionAbsent;
        public int sampleFrequencyIndex;
        public int sampleRate;
        public final /* synthetic */ AACTrackImpl this$0;

        public AdtsHeader(AACTrackImpl aACTrackImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aACTrackImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = aACTrackImpl;
        }

        public int getSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (this.protectionAbsent == 0 ? 2 : 0) + 7;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-731103246, "Lcom/googlecode/mp4parser/authoring/tracks/AACTrackImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-731103246, "Lcom/googlecode/mp4parser/authoring/tracks/AACTrackImpl;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        audioObjectTypes = hashMap;
        hashMap.put(1, "AAC Main");
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
        HashMap hashMap2 = new HashMap();
        samplingFrequencyIndexMap = hashMap2;
        hashMap2.put(96000, 0);
        samplingFrequencyIndexMap.put(88200, 1);
        samplingFrequencyIndexMap.put(64000, 2);
        samplingFrequencyIndexMap.put(48000, 3);
        samplingFrequencyIndexMap.put(44100, 4);
        samplingFrequencyIndexMap.put(32000, 5);
        samplingFrequencyIndexMap.put(24000, 6);
        samplingFrequencyIndexMap.put(22050, 7);
        samplingFrequencyIndexMap.put(16000, 8);
        samplingFrequencyIndexMap.put(12000, 9);
        samplingFrequencyIndexMap.put(11025, 10);
        samplingFrequencyIndexMap.put(8000, 11);
        samplingFrequencyIndexMap.put(0, 96000);
        samplingFrequencyIndexMap.put(1, 88200);
        samplingFrequencyIndexMap.put(2, 64000);
        samplingFrequencyIndexMap.put(3, 48000);
        samplingFrequencyIndexMap.put(4, 44100);
        samplingFrequencyIndexMap.put(5, 32000);
        samplingFrequencyIndexMap.put(6, 24000);
        samplingFrequencyIndexMap.put(7, 22050);
        samplingFrequencyIndexMap.put(8, 16000);
        samplingFrequencyIndexMap.put(9, 12000);
        samplingFrequencyIndexMap.put(10, 11025);
        samplingFrequencyIndexMap.put(11, 8000);
    }

    public AACTrackImpl(DataSource dataSource, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSource, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.trackMetaData = new TrackMetaData();
        this.lang = "eng";
        this.lang = str;
        parse(dataSource);
    }

    private void parse(DataSource dataSource) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, dataSource) == null) {
            this.samples = new ArrayList();
            AdtsHeader readSamples = readSamples(dataSource);
            this.firstHeader = readSamples;
            double d = readSamples.sampleRate / 1024.0d;
            double size = this.samples.size() / d;
            LinkedList linkedList = new LinkedList();
            Iterator<Sample> it = this.samples.iterator();
            long j = 0;
            while (true) {
                int i = 0;
                if (!it.hasNext()) {
                    break;
                }
                int size2 = (int) it.next().getSize();
                j += size2;
                linkedList.add(Integer.valueOf(size2));
                while (linkedList.size() > d) {
                    linkedList.pop();
                }
                if (linkedList.size() == ((int) d)) {
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        i += ((Integer) it2.next()).intValue();
                    }
                    double size3 = ((i * 8.0d) / linkedList.size()) * d;
                    if (size3 > this.maxBitRate) {
                        this.maxBitRate = (int) size3;
                    }
                }
            }
            this.avgBitRate = (int) ((j * 8) / size);
            this.bufferSizeDB = 1536;
            this.sampleDescriptionBox = new SampleDescriptionBox();
            AudioSampleEntry audioSampleEntry = new AudioSampleEntry(AudioSampleEntry.TYPE3);
            int i2 = this.firstHeader.channelconfig;
            if (i2 == 7) {
                audioSampleEntry.setChannelCount(8);
            } else {
                audioSampleEntry.setChannelCount(i2);
            }
            audioSampleEntry.setSampleRate(this.firstHeader.sampleRate);
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
            audioSpecificConfig.setSamplingFrequencyIndex(this.firstHeader.sampleFrequencyIndex);
            audioSpecificConfig.setChannelConfiguration(this.firstHeader.channelconfig);
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
            this.trackMetaData.setTimescale(this.firstHeader.sampleRate);
            long[] jArr = new long[this.samples.size()];
            this.decTimes = jArr;
            Arrays.fill(jArr, 1024L);
        }
    }

    private AdtsHeader readADTSHeader(DataSource dataSource) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dataSource)) == null) {
            AdtsHeader adtsHeader = new AdtsHeader(this);
            ByteBuffer allocate = ByteBuffer.allocate(7);
            while (allocate.position() < 7) {
                if (dataSource.read(allocate) == -1) {
                    return null;
                }
            }
            BitReaderBuffer bitReaderBuffer = new BitReaderBuffer((ByteBuffer) allocate.rewind());
            if (bitReaderBuffer.readBits(12) == 4095) {
                adtsHeader.mpegVersion = bitReaderBuffer.readBits(1);
                adtsHeader.layer = bitReaderBuffer.readBits(2);
                adtsHeader.protectionAbsent = bitReaderBuffer.readBits(1);
                adtsHeader.profile = bitReaderBuffer.readBits(2) + 1;
                int readBits = bitReaderBuffer.readBits(4);
                adtsHeader.sampleFrequencyIndex = readBits;
                adtsHeader.sampleRate = samplingFrequencyIndexMap.get(Integer.valueOf(readBits)).intValue();
                bitReaderBuffer.readBits(1);
                adtsHeader.channelconfig = bitReaderBuffer.readBits(3);
                adtsHeader.original = bitReaderBuffer.readBits(1);
                adtsHeader.home = bitReaderBuffer.readBits(1);
                adtsHeader.copyrightedStream = bitReaderBuffer.readBits(1);
                adtsHeader.copyrightStart = bitReaderBuffer.readBits(1);
                adtsHeader.frameLength = bitReaderBuffer.readBits(13);
                adtsHeader.bufferFullness = bitReaderBuffer.readBits(11);
                int readBits2 = bitReaderBuffer.readBits(2) + 1;
                adtsHeader.numAacFramesPerAdtsFrame = readBits2;
                if (readBits2 == 1) {
                    if (adtsHeader.protectionAbsent == 0) {
                        dataSource.read(ByteBuffer.allocate(2));
                    }
                    return adtsHeader;
                }
                throw new IOException("This muxer can only work with 1 AAC frame per ADTS frame");
            }
            throw new IOException("Expected Start Word 0xfff");
        }
        return (AdtsHeader) invokeL.objValue;
    }

    private AdtsHeader readSamples(DataSource dataSource) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65541, this, dataSource)) != null) {
            return (AdtsHeader) invokeL.objValue;
        }
        AdtsHeader adtsHeader = null;
        while (true) {
            AdtsHeader readADTSHeader = readADTSHeader(dataSource);
            if (readADTSHeader == null) {
                return adtsHeader;
            }
            if (adtsHeader == null) {
                adtsHeader = readADTSHeader;
            }
            ByteBuffer map = dataSource.map(dataSource.position(), readADTSHeader.frameLength - readADTSHeader.getSize());
            this.samples.add(new SampleImpl(map));
            dataSource.position((dataSource.position() + readADTSHeader.frameLength) - readADTSHeader.getSize());
            map.rewind();
        }
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "soun" : (String) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new SoundMediaHeaderBox() : (Box) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.sampleDescriptionBox : (SampleDescriptionBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.decTimes : (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.samples : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (SubSampleInformationBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.trackMetaData : (TrackMetaData) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "AACTrackImpl{sampleRate=" + this.firstHeader.sampleRate + ", channelconfig=" + this.firstHeader.channelconfig + '}';
        }
        return (String) invokeV.objValue;
    }

    public AACTrackImpl(DataSource dataSource) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSource};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.trackMetaData = new TrackMetaData();
        this.lang = "eng";
        parse(dataSource);
    }
}
