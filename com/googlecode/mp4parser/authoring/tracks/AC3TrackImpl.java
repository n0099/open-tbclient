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
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
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
/* loaded from: classes7.dex */
public class AC3TrackImpl extends AbstractTrack {
    public static /* synthetic */ Interceptable $ic;
    public static int[][][][] bitRateAndFrameSizeTable;
    public transient /* synthetic */ FieldHolder $fh;
    public final DataSource dataSource;
    public long[] duration;
    public SampleDescriptionBox sampleDescriptionBox;
    public List samples;
    public TrackMetaData trackMetaData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1786487136, "Lcom/googlecode/mp4parser/authoring/tracks/AC3TrackImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1786487136, "Lcom/googlecode/mp4parser/authoring/tracks/AC3TrackImpl;");
                return;
            }
        }
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
    public List getCompositionTimeEntries() {
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
    public List getSampleDependencies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AC3TrackImpl(DataSource dataSource) throws IOException {
        this(dataSource, "eng");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSource};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((DataSource) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public AC3TrackImpl(DataSource dataSource, String str) throws IOException {
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
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(((Sample) this.samples.get(0)).asByteBuffer());
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
                    i = 48000;
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
        return (AudioSampleEntry) invokeV.objValue;
    }

    private int getFrameSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i, i2)) == null) {
            int i3 = i >>> 1;
            int i4 = i & 1;
            if (i3 <= 18 && i4 <= 1 && i2 <= 2) {
                return bitRateAndFrameSizeTable[i3][i4][i2][1] * 2;
            }
            throw new RuntimeException("Cannot determine framesize of current sample");
        }
        return invokeII.intValue;
    }

    private List readSamples() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            ArrayList arrayList = new ArrayList();
            while (-1 != this.dataSource.read(allocate)) {
                long frameSize = getFrameSize(allocate.get(4) & 63, allocate.get(4) >> 6);
                arrayList.add(new Sample(this, this.dataSource.position() - 5, frameSize, this.dataSource) { // from class: com.googlecode.mp4parser.authoring.tracks.AC3TrackImpl.1SampleImpl
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final DataSource dataSource;
                    public final long size;
                    public final long start;
                    public final /* synthetic */ AC3TrackImpl this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(r7), Long.valueOf(frameSize), r11};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.start = r7;
                        this.size = frameSize;
                        this.dataSource = r11;
                    }

                    @Override // com.googlecode.mp4parser.authoring.Sample
                    public ByteBuffer asByteBuffer() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                            try {
                                return this.dataSource.map(this.start, this.size);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        return (ByteBuffer) invokeV2.objValue;
                    }

                    @Override // com.googlecode.mp4parser.authoring.Sample
                    public long getSize() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return this.size;
                        }
                        return invokeV2.longValue;
                    }

                    @Override // com.googlecode.mp4parser.authoring.Sample
                    public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, writableByteChannel) == null) {
                            this.dataSource.transferTo(this.start, this.size, writableByteChannel);
                        }
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
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public Box getMediaHeaderBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new SoundMediaHeaderBox();
        }
        return (Box) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.sampleDescriptionBox;
        }
        return (SampleDescriptionBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSampleDurations() {
        InterceptResult invokeV;
        long[] jArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                jArr = this.duration;
            }
            return jArr;
        }
        return (long[]) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List getSamples() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.samples;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.trackMetaData;
        }
        return (TrackMetaData) invokeV.objValue;
    }
}
