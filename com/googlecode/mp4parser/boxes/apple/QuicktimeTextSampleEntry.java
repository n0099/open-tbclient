package com.googlecode.mp4parser.boxes.apple;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;
/* loaded from: classes7.dex */
public class QuicktimeTextSampleEntry extends AbstractSampleEntry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "text";
    public transient /* synthetic */ FieldHolder $fh;
    public int backgroundB;
    public int backgroundG;
    public int backgroundR;
    public int dataReferenceIndex;
    public long defaultTextBox;
    public int displayFlags;
    public short fontFace;
    public String fontName;
    public short fontNumber;
    public int foregroundB;
    public int foregroundG;
    public int foregroundR;
    public long reserved1;
    public byte reserved2;
    public short reserved3;
    public int textJustification;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuicktimeTextSampleEntry() {
        super("text");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.foregroundR = 65535;
        this.foregroundG = 65535;
        this.foregroundB = 65535;
        this.fontName = "";
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public long getSize() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            long containerSize = getContainerSize() + 52;
            String str = this.fontName;
            if (str != null) {
                i = str.length();
            } else {
                i = 0;
            }
            long j = containerSize + i;
            if (!this.largeBox && 8 + j < 4294967296L) {
                i2 = 8;
            } else {
                i2 = 16;
            }
            return j + i2;
        }
        return invokeV.longValue;
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public void addBox(Box box) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, box) == null) {
            throw new RuntimeException("QuicktimeTextSampleEntries may not have child boxes");
        }
    }

    public void setBackgroundB(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.backgroundB = i;
        }
    }

    public void setBackgroundG(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.backgroundG = i;
        }
    }

    public void setBackgroundR(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.backgroundR = i;
        }
    }

    @Override // com.googlecode.mp4parser.BasicContainer, com.coremedia.iso.boxes.Container
    public void setBoxes(List<Box> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            throw new RuntimeException("QuicktimeTextSampleEntries may not have child boxes");
        }
    }

    public void setDefaultTextBox(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.defaultTextBox = j;
        }
    }

    public void setDisplayFlags(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.displayFlags = i;
        }
    }

    public void setFontFace(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Short.valueOf(s)}) == null) {
            this.fontFace = s;
        }
    }

    public void setFontName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.fontName = str;
        }
    }

    public void setFontNumber(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Short.valueOf(s)}) == null) {
            this.fontNumber = s;
        }
    }

    public void setForegroundB(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.foregroundB = i;
        }
    }

    public void setForegroundG(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.foregroundG = i;
        }
    }

    public void setForegroundR(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.foregroundR = i;
        }
    }

    public void setReserved1(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j) == null) {
            this.reserved1 = j;
        }
    }

    public void setReserved2(byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048608, this, b) == null) {
            this.reserved2 = b;
        }
    }

    public void setReserved3(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Short.valueOf(s)}) == null) {
            this.reserved3 = s;
        }
    }

    public void setTextJustification(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.textJustification = i;
        }
    }

    public int getBackgroundB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.backgroundB;
        }
        return invokeV.intValue;
    }

    public int getBackgroundG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.backgroundG;
        }
        return invokeV.intValue;
    }

    public int getBackgroundR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.backgroundR;
        }
        return invokeV.intValue;
    }

    public long getDefaultTextBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.defaultTextBox;
        }
        return invokeV.longValue;
    }

    public int getDisplayFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.displayFlags;
        }
        return invokeV.intValue;
    }

    public short getFontFace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.fontFace;
        }
        return invokeV.shortValue;
    }

    public String getFontName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.fontName;
        }
        return (String) invokeV.objValue;
    }

    public short getFontNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.fontNumber;
        }
        return invokeV.shortValue;
    }

    public int getForegroundB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.foregroundB;
        }
        return invokeV.intValue;
    }

    public int getForegroundG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.foregroundG;
        }
        return invokeV.intValue;
    }

    public int getForegroundR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.foregroundR;
        }
        return invokeV.intValue;
    }

    public long getReserved1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.reserved1;
        }
        return invokeV.longValue;
    }

    public byte getReserved2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.reserved2;
        }
        return invokeV.byteValue;
    }

    public short getReserved3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.reserved3;
        }
        return invokeV.shortValue;
    }

    public int getTextJustification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.textJustification;
        }
        return invokeV.intValue;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writableByteChannel) == null) {
            writableByteChannel.write(getHeader());
            String str = this.fontName;
            if (str != null) {
                i = str.length();
            } else {
                i = 0;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i + 52);
            allocate.position(6);
            IsoTypeWriter.writeUInt16(allocate, this.dataReferenceIndex);
            allocate.putInt(this.displayFlags);
            allocate.putInt(this.textJustification);
            IsoTypeWriter.writeUInt16(allocate, this.backgroundR);
            IsoTypeWriter.writeUInt16(allocate, this.backgroundG);
            IsoTypeWriter.writeUInt16(allocate, this.backgroundB);
            IsoTypeWriter.writeUInt64(allocate, this.defaultTextBox);
            IsoTypeWriter.writeUInt64(allocate, this.reserved1);
            allocate.putShort(this.fontNumber);
            allocate.putShort(this.fontFace);
            allocate.put(this.reserved2);
            allocate.putShort(this.reserved3);
            IsoTypeWriter.writeUInt16(allocate, this.foregroundR);
            IsoTypeWriter.writeUInt16(allocate, this.foregroundG);
            IsoTypeWriter.writeUInt16(allocate, this.foregroundB);
            String str2 = this.fontName;
            if (str2 != null) {
                IsoTypeWriter.writeUInt8(allocate, str2.length());
                allocate.put(this.fontName.getBytes());
            }
            writableByteChannel.write((ByteBuffer) allocate.rewind());
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j), boxParser}) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(CastUtils.l2i(j));
            dataSource.read(allocate);
            allocate.position(6);
            this.dataReferenceIndex = IsoTypeReader.readUInt16(allocate);
            this.displayFlags = allocate.getInt();
            this.textJustification = allocate.getInt();
            this.backgroundR = IsoTypeReader.readUInt16(allocate);
            this.backgroundG = IsoTypeReader.readUInt16(allocate);
            this.backgroundB = IsoTypeReader.readUInt16(allocate);
            this.defaultTextBox = IsoTypeReader.readUInt64(allocate);
            this.reserved1 = IsoTypeReader.readUInt64(allocate);
            this.fontNumber = allocate.getShort();
            this.fontFace = allocate.getShort();
            this.reserved2 = allocate.get();
            this.reserved3 = allocate.getShort();
            this.foregroundR = IsoTypeReader.readUInt16(allocate);
            this.foregroundG = IsoTypeReader.readUInt16(allocate);
            this.foregroundB = IsoTypeReader.readUInt16(allocate);
            if (allocate.remaining() > 0) {
                byte[] bArr = new byte[IsoTypeReader.readUInt8(allocate)];
                allocate.get(bArr);
                this.fontName = new String(bArr);
                return;
            }
            this.fontName = null;
        }
    }
}
