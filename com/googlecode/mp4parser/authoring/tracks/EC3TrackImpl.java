package com.googlecode.mp4parser.authoring.tracks;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.AbstractMediaHeaderBox;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public class EC3TrackImpl extends AbstractTrack {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long MAX_FRAMES_PER_MMAP = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public List<BitStreamInfo> bitStreamInfos;
    public int bitrate;
    public final DataSource dataSource;
    public long[] decodingTimes;
    public int frameSize;
    public SampleDescriptionBox sampleDescriptionBox;
    public List<Sample> samples;
    public TrackMetaData trackMetaData;

    /* loaded from: classes2.dex */
    public static class BitStreamInfo extends EC3SpecificBox.Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int bitrate;
        public int chanmap;
        public int frameSize;
        public int samplerate;
        public int strmtyp;
        public int substreamid;

        public BitStreamInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.googlecode.mp4parser.boxes.EC3SpecificBox.Entry
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "BitStreamInfo{frameSize=" + this.frameSize + ", substreamid=" + this.substreamid + ", bitrate=" + this.bitrate + ", samplerate=" + this.samplerate + ", strmtyp=" + this.strmtyp + ", chanmap=" + this.chanmap + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    public EC3TrackImpl(DataSource dataSource) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.trackMetaData = new TrackMetaData();
        this.bitStreamInfos = new LinkedList();
        this.dataSource = dataSource;
        boolean z = false;
        while (!z) {
            BitStreamInfo readVariables = readVariables();
            if (readVariables != null) {
                for (BitStreamInfo bitStreamInfo : this.bitStreamInfos) {
                    if (readVariables.strmtyp != 1 && bitStreamInfo.substreamid == readVariables.substreamid) {
                        z = true;
                    }
                }
                if (!z) {
                    this.bitStreamInfos.add(readVariables);
                }
            } else {
                throw new IOException();
            }
        }
        if (this.bitStreamInfos.size() != 0) {
            int i4 = this.bitStreamInfos.get(0).samplerate;
            this.sampleDescriptionBox = new SampleDescriptionBox();
            AudioSampleEntry audioSampleEntry = new AudioSampleEntry(AudioSampleEntry.TYPE9);
            audioSampleEntry.setChannelCount(2);
            long j = i4;
            audioSampleEntry.setSampleRate(j);
            audioSampleEntry.setDataReferenceIndex(1);
            audioSampleEntry.setSampleSize(16);
            EC3SpecificBox eC3SpecificBox = new EC3SpecificBox();
            int[] iArr = new int[this.bitStreamInfos.size()];
            int[] iArr2 = new int[this.bitStreamInfos.size()];
            for (BitStreamInfo bitStreamInfo2 : this.bitStreamInfos) {
                if (bitStreamInfo2.strmtyp == 1) {
                    int i5 = bitStreamInfo2.substreamid;
                    iArr[i5] = iArr[i5] + 1;
                    int i6 = bitStreamInfo2.chanmap;
                    iArr2[i5] = ((i6 >> 5) & 255) | ((i6 >> 6) & 256);
                }
            }
            for (BitStreamInfo bitStreamInfo3 : this.bitStreamInfos) {
                if (bitStreamInfo3.strmtyp != 1) {
                    EC3SpecificBox.Entry entry = new EC3SpecificBox.Entry();
                    entry.fscod = bitStreamInfo3.fscod;
                    entry.bsid = bitStreamInfo3.bsid;
                    entry.bsmod = bitStreamInfo3.bsmod;
                    entry.acmod = bitStreamInfo3.acmod;
                    entry.lfeon = bitStreamInfo3.lfeon;
                    entry.reserved = 0;
                    int i7 = bitStreamInfo3.substreamid;
                    entry.num_dep_sub = iArr[i7];
                    entry.chan_loc = iArr2[i7];
                    entry.reserved2 = 0;
                    eC3SpecificBox.addEntry(entry);
                }
                this.bitrate += bitStreamInfo3.bitrate;
                this.frameSize += bitStreamInfo3.frameSize;
            }
            eC3SpecificBox.setDataRate(this.bitrate / 1000);
            audioSampleEntry.addBox(eC3SpecificBox);
            this.sampleDescriptionBox.addBox(audioSampleEntry);
            this.trackMetaData.setCreationTime(new Date());
            this.trackMetaData.setModificationTime(new Date());
            this.trackMetaData.setTimescale(j);
            this.trackMetaData.setVolume(1.0f);
            dataSource.position(0L);
            List<Sample> readSamples = readSamples();
            this.samples = readSamples;
            long[] jArr = new long[readSamples.size()];
            this.decodingTimes = jArr;
            Arrays.fill(jArr, 1536L);
            return;
        }
        throw new IOException();
    }

    private List<Sample> readSamples() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int l2i = CastUtils.l2i((this.dataSource.size() - this.dataSource.position()) / this.frameSize);
            ArrayList arrayList = new ArrayList(l2i);
            for (int i2 = 0; i2 < l2i; i2++) {
                arrayList.add(new Sample(this, this.frameSize * i2) { // from class: com.googlecode.mp4parser.authoring.tracks.EC3TrackImpl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ EC3TrackImpl this$0;
                    public final /* synthetic */ int val$start;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(r7)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$start = r7;
                    }

                    @Override // com.googlecode.mp4parser.authoring.Sample
                    public ByteBuffer asByteBuffer() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                            try {
                                return this.this$0.dataSource.map(this.val$start, this.this$0.frameSize);
                            } catch (IOException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                        return (ByteBuffer) invokeV2.objValue;
                    }

                    @Override // com.googlecode.mp4parser.authoring.Sample
                    public long getSize() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.frameSize : invokeV2.longValue;
                    }

                    @Override // com.googlecode.mp4parser.authoring.Sample
                    public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, writableByteChannel) == null) {
                            this.this$0.dataSource.transferTo(this.val$start, this.this$0.frameSize, writableByteChannel);
                        }
                    }
                });
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    private BitStreamInfo readVariables() throws IOException {
        InterceptResult invokeV;
        int readBits;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            long position = this.dataSource.position();
            ByteBuffer allocate = ByteBuffer.allocate(200);
            this.dataSource.read(allocate);
            allocate.rewind();
            BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(allocate);
            if (bitReaderBuffer.readBits(16) != 2935) {
                return null;
            }
            BitStreamInfo bitStreamInfo = new BitStreamInfo();
            bitStreamInfo.strmtyp = bitReaderBuffer.readBits(2);
            bitStreamInfo.substreamid = bitReaderBuffer.readBits(3);
            bitStreamInfo.frameSize = (bitReaderBuffer.readBits(11) + 1) * 2;
            int readBits2 = bitReaderBuffer.readBits(2);
            bitStreamInfo.fscod = readBits2;
            int i2 = -1;
            if (readBits2 == 3) {
                i2 = bitReaderBuffer.readBits(2);
                readBits = 3;
            } else {
                readBits = bitReaderBuffer.readBits(2);
            }
            int i3 = readBits != 0 ? readBits != 1 ? readBits != 2 ? readBits != 3 ? 0 : 6 : 3 : 2 : 1;
            bitStreamInfo.frameSize *= 6 / i3;
            bitStreamInfo.acmod = bitReaderBuffer.readBits(3);
            bitStreamInfo.lfeon = bitReaderBuffer.readBits(1);
            bitStreamInfo.bsid = bitReaderBuffer.readBits(5);
            bitReaderBuffer.readBits(5);
            if (1 == bitReaderBuffer.readBits(1)) {
                bitReaderBuffer.readBits(8);
            }
            if (bitStreamInfo.acmod == 0) {
                bitReaderBuffer.readBits(5);
                if (1 == bitReaderBuffer.readBits(1)) {
                    bitReaderBuffer.readBits(8);
                }
            }
            if (1 == bitStreamInfo.strmtyp && 1 == bitReaderBuffer.readBits(1)) {
                bitStreamInfo.chanmap = bitReaderBuffer.readBits(16);
            }
            if (1 == bitReaderBuffer.readBits(1)) {
                if (bitStreamInfo.acmod > 2) {
                    bitReaderBuffer.readBits(2);
                }
                int i4 = bitStreamInfo.acmod;
                if (1 == (i4 & 1) && i4 > 2) {
                    bitReaderBuffer.readBits(3);
                    bitReaderBuffer.readBits(3);
                }
                if ((bitStreamInfo.acmod & 4) > 0) {
                    bitReaderBuffer.readBits(3);
                    bitReaderBuffer.readBits(3);
                }
                if (1 == bitStreamInfo.lfeon && 1 == bitReaderBuffer.readBits(1)) {
                    bitReaderBuffer.readBits(5);
                }
                if (bitStreamInfo.strmtyp == 0) {
                    if (1 == bitReaderBuffer.readBits(1)) {
                        bitReaderBuffer.readBits(6);
                    }
                    if (bitStreamInfo.acmod == 0 && 1 == bitReaderBuffer.readBits(1)) {
                        bitReaderBuffer.readBits(6);
                    }
                    if (1 == bitReaderBuffer.readBits(1)) {
                        bitReaderBuffer.readBits(6);
                    }
                    int readBits3 = bitReaderBuffer.readBits(2);
                    if (1 == readBits3) {
                        bitReaderBuffer.readBits(5);
                    } else if (2 == readBits3) {
                        bitReaderBuffer.readBits(12);
                    } else if (3 == readBits3) {
                        int readBits4 = bitReaderBuffer.readBits(5);
                        if (1 == bitReaderBuffer.readBits(1)) {
                            bitReaderBuffer.readBits(5);
                            if (1 == bitReaderBuffer.readBits(1)) {
                                bitReaderBuffer.readBits(4);
                            }
                            if (1 == bitReaderBuffer.readBits(1)) {
                                bitReaderBuffer.readBits(4);
                            }
                            if (1 == bitReaderBuffer.readBits(1)) {
                                bitReaderBuffer.readBits(4);
                            }
                            if (1 == bitReaderBuffer.readBits(1)) {
                                bitReaderBuffer.readBits(4);
                            }
                            if (1 == bitReaderBuffer.readBits(1)) {
                                bitReaderBuffer.readBits(4);
                            }
                            if (1 == bitReaderBuffer.readBits(1)) {
                                bitReaderBuffer.readBits(4);
                            }
                            if (1 == bitReaderBuffer.readBits(1)) {
                                bitReaderBuffer.readBits(4);
                            }
                            if (1 == bitReaderBuffer.readBits(1)) {
                                if (1 == bitReaderBuffer.readBits(1)) {
                                    bitReaderBuffer.readBits(4);
                                }
                                if (1 == bitReaderBuffer.readBits(1)) {
                                    bitReaderBuffer.readBits(4);
                                }
                            }
                        }
                        if (1 == bitReaderBuffer.readBits(1)) {
                            bitReaderBuffer.readBits(5);
                            if (1 == bitReaderBuffer.readBits(1)) {
                                bitReaderBuffer.readBits(7);
                                if (1 == bitReaderBuffer.readBits(1)) {
                                    bitReaderBuffer.readBits(8);
                                }
                            }
                        }
                        for (int i5 = 0; i5 < readBits4 + 2; i5++) {
                            bitReaderBuffer.readBits(8);
                        }
                        bitReaderBuffer.byteSync();
                    }
                    if (bitStreamInfo.acmod < 2) {
                        if (1 == bitReaderBuffer.readBits(1)) {
                            bitReaderBuffer.readBits(14);
                        }
                        if (bitStreamInfo.acmod == 0 && 1 == bitReaderBuffer.readBits(1)) {
                            bitReaderBuffer.readBits(14);
                        }
                        if (1 == bitReaderBuffer.readBits(1)) {
                            if (readBits == 0) {
                                bitReaderBuffer.readBits(5);
                            } else {
                                for (int i6 = 0; i6 < i3; i6++) {
                                    if (1 == bitReaderBuffer.readBits(1)) {
                                        bitReaderBuffer.readBits(5);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (1 == bitReaderBuffer.readBits(1)) {
                bitStreamInfo.bsmod = bitReaderBuffer.readBits(3);
            }
            int i7 = bitStreamInfo.fscod;
            if (i7 == 0) {
                bitStreamInfo.samplerate = MediaEncodeParams.AUDIO_SAMPLE_RATE;
            } else if (i7 == 1) {
                bitStreamInfo.samplerate = 44100;
            } else if (i7 == 2) {
                bitStreamInfo.samplerate = 32000;
            } else if (i7 == 3) {
                if (i2 == 0) {
                    bitStreamInfo.samplerate = 24000;
                } else if (i2 == 1) {
                    bitStreamInfo.samplerate = 22050;
                } else if (i2 == 2) {
                    bitStreamInfo.samplerate = 16000;
                } else if (i2 == 3) {
                    bitStreamInfo.samplerate = 0;
                }
            }
            int i8 = bitStreamInfo.samplerate;
            if (i8 == 0) {
                return null;
            }
            int i9 = bitStreamInfo.frameSize;
            bitStreamInfo.bitrate = (int) ((i8 / 1536.0d) * i9 * 8.0d);
            this.dataSource.position(position + i9);
            return bitStreamInfo;
        }
        return (BitStreamInfo) invokeV.objValue;
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

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.sampleDescriptionBox : (SampleDescriptionBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.decodingTimes : (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.samples : (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (SubSampleInformationBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.trackMetaData : (TrackMetaData) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "EC3TrackImpl{bitrate=" + this.bitrate + ", bitStreamInfos=" + this.bitStreamInfos + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.googlecode.mp4parser.authoring.Track
    public AbstractMediaHeaderBox getMediaHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new SoundMediaHeaderBox() : (AbstractMediaHeaderBox) invokeV.objValue;
    }
}
