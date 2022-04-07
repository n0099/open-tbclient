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
import com.coremedia.iso.Utf8;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes4.dex */
public final class VisualSampleEntry extends AbstractSampleEntry implements Container {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE1 = "mp4v";
    public static final String TYPE2 = "s263";
    public static final String TYPE3 = "avc1";
    public static final String TYPE4 = "avc3";
    public static final String TYPE5 = "drmi";
    public static final String TYPE_ENCRYPTED = "encv";
    public transient /* synthetic */ FieldHolder $fh;
    public String compressorname;
    public int depth;
    public int frameCount;
    public int height;
    public double horizresolution;
    public long[] predefined;
    public double vertresolution;
    public int width;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(760863326, "Lcom/coremedia/iso/boxes/sampleentry/VisualSampleEntry;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(760863326, "Lcom/coremedia/iso/boxes/sampleentry/VisualSampleEntry;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisualSampleEntry() {
        super("avc1");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
        this.horizresolution = 72.0d;
        this.vertresolution = 72.0d;
        this.frameCount = 1;
        this.compressorname = "";
        this.depth = 24;
        this.predefined = new long[3];
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writableByteChannel) == null) {
            writableByteChannel.write(getHeader());
            ByteBuffer allocate = ByteBuffer.allocate(78);
            allocate.position(6);
            IsoTypeWriter.writeUInt16(allocate, this.dataReferenceIndex);
            IsoTypeWriter.writeUInt16(allocate, 0);
            IsoTypeWriter.writeUInt16(allocate, 0);
            IsoTypeWriter.writeUInt32(allocate, this.predefined[0]);
            IsoTypeWriter.writeUInt32(allocate, this.predefined[1]);
            IsoTypeWriter.writeUInt32(allocate, this.predefined[2]);
            IsoTypeWriter.writeUInt16(allocate, getWidth());
            IsoTypeWriter.writeUInt16(allocate, getHeight());
            IsoTypeWriter.writeFixedPoint1616(allocate, getHorizresolution());
            IsoTypeWriter.writeFixedPoint1616(allocate, getVertresolution());
            IsoTypeWriter.writeUInt32(allocate, 0L);
            IsoTypeWriter.writeUInt16(allocate, getFrameCount());
            IsoTypeWriter.writeUInt8(allocate, Utf8.utf8StringLengthInBytes(getCompressorname()));
            allocate.put(Utf8.convert(getCompressorname()));
            int utf8StringLengthInBytes = Utf8.utf8StringLengthInBytes(getCompressorname());
            while (utf8StringLengthInBytes < 31) {
                utf8StringLengthInBytes++;
                allocate.put((byte) 0);
            }
            IsoTypeWriter.writeUInt16(allocate, getDepth());
            IsoTypeWriter.writeUInt16(allocate, 65535);
            writableByteChannel.write((ByteBuffer) allocate.rewind());
            writeContainer(writableByteChannel);
        }
    }

    public String getCompressorname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.compressorname : (String) invokeV.objValue;
    }

    public int getDepth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.depth : invokeV.intValue;
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.frameCount : invokeV.intValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.height : invokeV.intValue;
    }

    public double getHorizresolution() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.horizresolution : invokeV.doubleValue;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long containerSize = getContainerSize() + 78;
            return containerSize + ((this.largeBox || 8 + containerSize >= 4294967296L) ? 16 : 8);
        }
        return invokeV.longValue;
    }

    public double getVertresolution() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.vertresolution : invokeV.doubleValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.width : invokeV.intValue;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j), boxParser}) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(78);
            dataSource.read(allocate);
            allocate.position(6);
            this.dataReferenceIndex = IsoTypeReader.readUInt16(allocate);
            IsoTypeReader.readUInt16(allocate);
            IsoTypeReader.readUInt16(allocate);
            this.predefined[0] = IsoTypeReader.readUInt32(allocate);
            this.predefined[1] = IsoTypeReader.readUInt32(allocate);
            this.predefined[2] = IsoTypeReader.readUInt32(allocate);
            this.width = IsoTypeReader.readUInt16(allocate);
            this.height = IsoTypeReader.readUInt16(allocate);
            this.horizresolution = IsoTypeReader.readFixedPoint1616(allocate);
            this.vertresolution = IsoTypeReader.readFixedPoint1616(allocate);
            IsoTypeReader.readUInt32(allocate);
            this.frameCount = IsoTypeReader.readUInt16(allocate);
            int readUInt8 = IsoTypeReader.readUInt8(allocate);
            if (readUInt8 > 31) {
                PrintStream printStream = System.out;
                printStream.println("invalid compressor name displayable data: " + readUInt8);
                readUInt8 = 31;
            }
            byte[] bArr = new byte[readUInt8];
            allocate.get(bArr);
            this.compressorname = Utf8.convert(bArr);
            if (readUInt8 < 31) {
                allocate.get(new byte[31 - readUInt8]);
            }
            this.depth = IsoTypeReader.readUInt16(allocate);
            IsoTypeReader.readUInt16(allocate);
            parseContainer(dataSource, j - 78, boxParser);
        }
    }

    public void setCompressorname(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.compressorname = str;
        }
    }

    public void setDepth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.depth = i;
        }
    }

    public void setFrameCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.frameCount = i;
        }
    }

    public void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.height = i;
        }
    }

    public void setHorizresolution(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Double.valueOf(d)}) == null) {
            this.horizresolution = d;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.type = str;
        }
    }

    public void setVertresolution(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Double.valueOf(d)}) == null) {
            this.vertresolution = d;
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.width = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisualSampleEntry(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.horizresolution = 72.0d;
        this.vertresolution = 72.0d;
        this.frameCount = 1;
        this.compressorname = "";
        this.depth = 24;
        this.predefined = new long[3];
    }
}
