package com.coremedia.iso.boxes.sampleentry;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes7.dex */
public final class AudioSampleEntry extends AbstractSampleEntry {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE1 = "samr";
    public static final String TYPE10 = "mlpa";
    public static final String TYPE11 = "dtsl";
    public static final String TYPE12 = "dtsh";
    public static final String TYPE13 = "dtse";
    public static final String TYPE2 = "sawb";
    public static final String TYPE3 = "mp4a";
    public static final String TYPE4 = "drms";
    public static final String TYPE5 = "alac";
    public static final String TYPE7 = "owma";
    public static final String TYPE8 = "ac-3";
    public static final String TYPE9 = "ec-3";
    public static final String TYPE_ENCRYPTED = "enca";
    public transient /* synthetic */ FieldHolder $fh;
    public long bytesPerFrame;
    public long bytesPerPacket;
    public long bytesPerSample;
    public int channelCount;
    public int compressionId;
    public int packetSize;
    public int reserved1;
    public long reserved2;
    public long sampleRate;
    public int sampleSize;
    public long samplesPerPacket;
    public int soundVersion;
    public byte[] soundVersion2Data;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1630404802, "Lcom/coremedia/iso/boxes/sampleentry/AudioSampleEntry;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1630404802, "Lcom/coremedia/iso/boxes/sampleentry/AudioSampleEntry;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioSampleEntry(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writableByteChannel) == null) {
            writableByteChannel.write(getHeader());
            ByteBuffer allocate = ByteBuffer.allocate((this.soundVersion == 1 ? 16 : 0) + 28 + (this.soundVersion == 2 ? 36 : 0));
            allocate.position(6);
            IsoTypeWriter.writeUInt16(allocate, this.dataReferenceIndex);
            IsoTypeWriter.writeUInt16(allocate, this.soundVersion);
            IsoTypeWriter.writeUInt16(allocate, this.reserved1);
            IsoTypeWriter.writeUInt32(allocate, this.reserved2);
            IsoTypeWriter.writeUInt16(allocate, this.channelCount);
            IsoTypeWriter.writeUInt16(allocate, this.sampleSize);
            IsoTypeWriter.writeUInt16(allocate, this.compressionId);
            IsoTypeWriter.writeUInt16(allocate, this.packetSize);
            if (this.type.equals(TYPE10)) {
                IsoTypeWriter.writeUInt32(allocate, getSampleRate());
            } else {
                IsoTypeWriter.writeUInt32(allocate, getSampleRate() << 16);
            }
            if (this.soundVersion == 1) {
                IsoTypeWriter.writeUInt32(allocate, this.samplesPerPacket);
                IsoTypeWriter.writeUInt32(allocate, this.bytesPerPacket);
                IsoTypeWriter.writeUInt32(allocate, this.bytesPerFrame);
                IsoTypeWriter.writeUInt32(allocate, this.bytesPerSample);
            }
            if (this.soundVersion == 2) {
                IsoTypeWriter.writeUInt32(allocate, this.samplesPerPacket);
                IsoTypeWriter.writeUInt32(allocate, this.bytesPerPacket);
                IsoTypeWriter.writeUInt32(allocate, this.bytesPerFrame);
                IsoTypeWriter.writeUInt32(allocate, this.bytesPerSample);
                allocate.put(this.soundVersion2Data);
            }
            writableByteChannel.write((ByteBuffer) allocate.rewind());
            writeContainer(writableByteChannel);
        }
    }

    public long getBytesPerFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bytesPerFrame : invokeV.longValue;
    }

    public long getBytesPerPacket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bytesPerPacket : invokeV.longValue;
    }

    public long getBytesPerSample() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.bytesPerSample : invokeV.longValue;
    }

    public int getChannelCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.channelCount : invokeV.intValue;
    }

    public int getCompressionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.compressionId : invokeV.intValue;
    }

    public int getPacketSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.packetSize : invokeV.intValue;
    }

    public int getReserved1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.reserved1 : invokeV.intValue;
    }

    public long getReserved2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.reserved2 : invokeV.longValue;
    }

    public long getSampleRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.sampleRate : invokeV.longValue;
    }

    public int getSampleSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.sampleSize : invokeV.intValue;
    }

    public long getSamplesPerPacket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.samplesPerPacket : invokeV.longValue;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = 16;
            long containerSize = (this.soundVersion == 1 ? 16 : 0) + 28 + (this.soundVersion == 2 ? 36 : 0) + getContainerSize();
            if (!this.largeBox && 8 + containerSize < 4294967296L) {
                i = 8;
            }
            return containerSize + i;
        }
        return invokeV.longValue;
    }

    public int getSoundVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.soundVersion : invokeV.intValue;
    }

    public byte[] getSoundVersion2Data() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.soundVersion2Data : (byte[]) invokeV.objValue;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j), boxParser}) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(28);
            dataSource.read(allocate);
            allocate.position(6);
            this.dataReferenceIndex = IsoTypeReader.readUInt16(allocate);
            this.soundVersion = IsoTypeReader.readUInt16(allocate);
            this.reserved1 = IsoTypeReader.readUInt16(allocate);
            this.reserved2 = IsoTypeReader.readUInt32(allocate);
            this.channelCount = IsoTypeReader.readUInt16(allocate);
            this.sampleSize = IsoTypeReader.readUInt16(allocate);
            this.compressionId = IsoTypeReader.readUInt16(allocate);
            this.packetSize = IsoTypeReader.readUInt16(allocate);
            this.sampleRate = IsoTypeReader.readUInt32(allocate);
            if (!this.type.equals(TYPE10)) {
                this.sampleRate >>>= 16;
            }
            if (this.soundVersion == 1) {
                ByteBuffer allocate2 = ByteBuffer.allocate(16);
                dataSource.read(allocate2);
                allocate2.rewind();
                this.samplesPerPacket = IsoTypeReader.readUInt32(allocate2);
                this.bytesPerPacket = IsoTypeReader.readUInt32(allocate2);
                this.bytesPerFrame = IsoTypeReader.readUInt32(allocate2);
                this.bytesPerSample = IsoTypeReader.readUInt32(allocate2);
            }
            if (this.soundVersion == 2) {
                ByteBuffer allocate3 = ByteBuffer.allocate(36);
                dataSource.read(allocate3);
                allocate3.rewind();
                this.samplesPerPacket = IsoTypeReader.readUInt32(allocate3);
                this.bytesPerPacket = IsoTypeReader.readUInt32(allocate3);
                this.bytesPerFrame = IsoTypeReader.readUInt32(allocate3);
                this.bytesPerSample = IsoTypeReader.readUInt32(allocate3);
                byte[] bArr = new byte[20];
                this.soundVersion2Data = bArr;
                allocate3.get(bArr);
            }
            if (TYPE7.equals(this.type)) {
                System.err.println(TYPE7);
                long j2 = ((j - 28) - (this.soundVersion != 1 ? 0 : 16)) - (this.soundVersion != 2 ? 0 : 36);
                ByteBuffer allocate4 = ByteBuffer.allocate(CastUtils.l2i(j2));
                dataSource.read(allocate4);
                addBox(new Box(this, j2, allocate4) { // from class: com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AudioSampleEntry this$0;
                    public final /* synthetic */ ByteBuffer val$owmaSpecifics;
                    public final /* synthetic */ long val$remaining;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(j2), allocate4};
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
                        this.val$remaining = j2;
                        this.val$owmaSpecifics = allocate4;
                    }

                    @Override // com.coremedia.iso.boxes.Box
                    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, writableByteChannel) == null) {
                            this.val$owmaSpecifics.rewind();
                            writableByteChannel.write(this.val$owmaSpecifics);
                        }
                    }

                    @Override // com.coremedia.iso.boxes.Box
                    public long getOffset() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return 0L;
                        }
                        return invokeV.longValue;
                    }

                    @Override // com.coremedia.iso.boxes.Box
                    public Container getParent() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0 : (Container) invokeV.objValue;
                    }

                    @Override // com.coremedia.iso.boxes.Box
                    public long getSize() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.val$remaining : invokeV.longValue;
                    }

                    @Override // com.coremedia.iso.boxes.Box
                    public String getType() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) ? "----" : (String) invokeV.objValue;
                    }

                    @Override // com.coremedia.iso.boxes.Box
                    public void parse(DataSource dataSource2, ByteBuffer byteBuffer2, long j3, BoxParser boxParser2) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{dataSource2, byteBuffer2, Long.valueOf(j3), boxParser2}) == null) {
                            throw new RuntimeException("NotImplemented");
                        }
                    }

                    @Override // com.coremedia.iso.boxes.Box
                    public void setParent(Container container) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048582, this, container) == null) && !AudioSampleEntry.$assertionsDisabled && container != this.this$0) {
                            throw new AssertionError("you cannot diswown this special box");
                        }
                    }
                });
                return;
            }
            parseContainer(dataSource, ((j - 28) - (this.soundVersion != 1 ? 0 : 16)) - (this.soundVersion != 2 ? 0 : 36), boxParser);
        }
    }

    public void setBytesPerFrame(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.bytesPerFrame = j;
        }
    }

    public void setBytesPerPacket(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.bytesPerPacket = j;
        }
    }

    public void setBytesPerSample(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.bytesPerSample = j;
        }
    }

    public void setChannelCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.channelCount = i;
        }
    }

    public void setCompressionId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.compressionId = i;
        }
    }

    public void setPacketSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.packetSize = i;
        }
    }

    public void setReserved1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.reserved1 = i;
        }
    }

    public void setReserved2(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.reserved2 = j;
        }
    }

    public void setSampleRate(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.sampleRate = j;
        }
    }

    public void setSampleSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.sampleSize = i;
        }
    }

    public void setSamplesPerPacket(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j) == null) {
            this.samplesPerPacket = j;
        }
    }

    public void setSoundVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.soundVersion = i;
        }
    }

    public void setSoundVersion2Data(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bArr) == null) {
            this.soundVersion2Data = bArr;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.type = str;
        }
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return "AudioSampleEntry{bytesPerSample=" + this.bytesPerSample + ", bytesPerFrame=" + this.bytesPerFrame + ", bytesPerPacket=" + this.bytesPerPacket + ", samplesPerPacket=" + this.samplesPerPacket + ", packetSize=" + this.packetSize + ", compressionId=" + this.compressionId + ", soundVersion=" + this.soundVersion + ", sampleRate=" + this.sampleRate + ", sampleSize=" + this.sampleSize + ", channelCount=" + this.channelCount + ", boxes=" + getBoxes() + '}';
        }
        return (String) invokeV.objValue;
    }
}
