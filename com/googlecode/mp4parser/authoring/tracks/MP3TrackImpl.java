package com.googlecode.mp4parser.authoring.tracks;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.record.EncoderParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
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
/* loaded from: classes8.dex */
public class MP3TrackImpl extends AbstractTrack {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] BIT_RATE;
    public static final int ES_OBJECT_TYPE_INDICATION = 107;
    public static final int ES_STREAM_TYPE = 5;
    public static final int MPEG_L3 = 1;
    public static final int MPEG_V1 = 3;
    public static final int SAMPLES_PER_FRAME = 1152;
    public static final int[] SAMPLE_RATE;
    public transient /* synthetic */ FieldHolder $fh;
    public long avgBitRate;
    public long[] durations;
    public MP3Header firstHeader;
    public String lang;
    public long maxBitRate;
    public SampleDescriptionBox sampleDescriptionBox;
    public List<Sample> samples;
    public TrackMetaData trackMetaData;

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "soun" : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "MP3TrackImpl" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class MP3Header {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int bitRate;
        public int bitRateIndex;
        public int channelCount;
        public int channelMode;
        public int layer;
        public int mpegVersion;
        public int padding;
        public int protectionAbsent;
        public int sampleFrequencyIndex;
        public int sampleRate;
        public final /* synthetic */ MP3TrackImpl this$0;

        public MP3Header(MP3TrackImpl mP3TrackImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mP3TrackImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mP3TrackImpl;
        }

        public int getFrameLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return ((this.bitRate * Cea708Decoder.COMMAND_SPA) / this.sampleRate) + this.padding;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(665719423, "Lcom/googlecode/mp4parser/authoring/tracks/MP3TrackImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(665719423, "Lcom/googlecode/mp4parser/authoring/tracks/MP3TrackImpl;");
                return;
            }
        }
        SAMPLE_RATE = new int[]{44100, 48000, 32000};
        BIT_RATE = new int[]{0, 32000, SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, 48000, 56000, 64000, 80000, 96000, 112000, EncoderParams.AUDIO_BIT_RATE, 160000, 192000, 224000, 256000, 320000};
    }

    public MP3TrackImpl(DataSource dataSource) throws IOException {
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

    private MP3Header readSamples(DataSource dataSource) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, dataSource)) == null) {
            MP3Header mP3Header = null;
            while (true) {
                long position = dataSource.position();
                MP3Header readMP3Header = readMP3Header(dataSource);
                if (readMP3Header == null) {
                    return mP3Header;
                }
                if (mP3Header == null) {
                    mP3Header = readMP3Header;
                }
                dataSource.position(position);
                ByteBuffer allocate = ByteBuffer.allocate(readMP3Header.getFrameLength());
                dataSource.read(allocate);
                allocate.rewind();
                this.samples.add(new SampleImpl(allocate));
            }
        } else {
            return (MP3Header) invokeL.objValue;
        }
    }

    public MP3TrackImpl(DataSource dataSource, String str) throws IOException {
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
            this.samples = new LinkedList();
            MP3Header readSamples = readSamples(dataSource);
            this.firstHeader = readSamples;
            double d = readSamples.sampleRate / 1152.0d;
            double size = this.samples.size() / d;
            LinkedList linkedList = new LinkedList();
            Iterator<Sample> it = this.samples.iterator();
            long j = 0;
            while (true) {
                int i = 0;
                if (!it.hasNext()) {
                    this.avgBitRate = (int) ((j * 8) / size);
                    this.sampleDescriptionBox = new SampleDescriptionBox();
                    AudioSampleEntry audioSampleEntry = new AudioSampleEntry(AudioSampleEntry.TYPE3);
                    audioSampleEntry.setChannelCount(this.firstHeader.channelCount);
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
                    this.trackMetaData.setTimescale(this.firstHeader.sampleRate);
                    long[] jArr = new long[this.samples.size()];
                    this.durations = jArr;
                    Arrays.fill(jArr, 1152L);
                    return;
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
        }
    }

    private MP3Header readMP3Header(DataSource dataSource) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dataSource)) == null) {
            MP3Header mP3Header = new MP3Header(this);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            while (allocate.position() < 4) {
                if (dataSource.read(allocate) == -1) {
                    return null;
                }
            }
            BitReaderBuffer bitReaderBuffer = new BitReaderBuffer((ByteBuffer) allocate.rewind());
            if (bitReaderBuffer.readBits(11) == 2047) {
                int i = 2;
                int readBits = bitReaderBuffer.readBits(2);
                mP3Header.mpegVersion = readBits;
                if (readBits == 3) {
                    int readBits2 = bitReaderBuffer.readBits(2);
                    mP3Header.layer = readBits2;
                    if (readBits2 == 1) {
                        mP3Header.protectionAbsent = bitReaderBuffer.readBits(1);
                        int readBits3 = bitReaderBuffer.readBits(4);
                        mP3Header.bitRateIndex = readBits3;
                        int i2 = BIT_RATE[readBits3];
                        mP3Header.bitRate = i2;
                        if (i2 != 0) {
                            int readBits4 = bitReaderBuffer.readBits(2);
                            mP3Header.sampleFrequencyIndex = readBits4;
                            int i3 = SAMPLE_RATE[readBits4];
                            mP3Header.sampleRate = i3;
                            if (i3 != 0) {
                                mP3Header.padding = bitReaderBuffer.readBits(1);
                                bitReaderBuffer.readBits(1);
                                int readBits5 = bitReaderBuffer.readBits(2);
                                mP3Header.channelMode = readBits5;
                                if (readBits5 == 3) {
                                    i = 1;
                                }
                                mP3Header.channelCount = i;
                                return mP3Header;
                            }
                            throw new IOException("Unexpected (reserved) sample rate frequency");
                        }
                        throw new IOException("Unexpected (free/bad) bit rate");
                    }
                    throw new IOException("Expected Layer III");
                }
                throw new IOException("Expected MPEG Version 1 (ISO/IEC 11172-3)");
            }
            throw new IOException("Expected Start Word 0x7ff");
        }
        return (MP3Header) invokeL.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new SoundMediaHeaderBox();
        }
        return (Box) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.sampleDescriptionBox;
        }
        return (SampleDescriptionBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.durations;
        }
        return (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.samples;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.trackMetaData;
        }
        return (TrackMetaData) invokeV.objValue;
    }
}
