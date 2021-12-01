package com.coremedia.iso.boxes.sampleentry;

import android.support.v4.media.session.PlaybackStateCompat;
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
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
/* loaded from: classes12.dex */
public class TextSampleEntry extends AbstractSampleEntry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE1 = "tx3g";
    public static final String TYPE_ENCRYPTED = "enct";
    public transient /* synthetic */ FieldHolder $fh;
    public int[] backgroundColorRgba;
    public BoxRecord boxRecord;
    public long displayFlags;
    public int horizontalJustification;
    public StyleRecord styleRecord;
    public int verticalJustification;

    /* loaded from: classes12.dex */
    public static class BoxRecord {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int bottom;
        public int left;
        public int right;
        public int top;

        public BoxRecord() {
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

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || BoxRecord.class != obj.getClass()) {
                    return false;
                }
                BoxRecord boxRecord = (BoxRecord) obj;
                return this.bottom == boxRecord.bottom && this.left == boxRecord.left && this.right == boxRecord.right && this.top == boxRecord.top;
            }
            return invokeL.booleanValue;
        }

        public void getContent(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
                IsoTypeWriter.writeUInt16(byteBuffer, this.top);
                IsoTypeWriter.writeUInt16(byteBuffer, this.left);
                IsoTypeWriter.writeUInt16(byteBuffer, this.bottom);
                IsoTypeWriter.writeUInt16(byteBuffer, this.right);
            }
        }

        public int getSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 8;
            }
            return invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (((((this.top * 31) + this.left) * 31) + this.bottom) * 31) + this.right : invokeV.intValue;
        }

        public void parse(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
                this.top = IsoTypeReader.readUInt16(byteBuffer);
                this.left = IsoTypeReader.readUInt16(byteBuffer);
                this.bottom = IsoTypeReader.readUInt16(byteBuffer);
                this.right = IsoTypeReader.readUInt16(byteBuffer);
            }
        }

        public BoxRecord(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.top = i2;
            this.left = i3;
            this.bottom = i4;
            this.right = i5;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextSampleEntry() {
        super(TYPE1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.backgroundColorRgba = new int[4];
        this.boxRecord = new BoxRecord();
        this.styleRecord = new StyleRecord();
    }

    public int[] getBackgroundColorRgba() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.backgroundColorRgba : (int[]) invokeV.objValue;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writableByteChannel) == null) {
            writableByteChannel.write(getHeader());
            ByteBuffer allocate = ByteBuffer.allocate(38);
            allocate.position(6);
            IsoTypeWriter.writeUInt16(allocate, this.dataReferenceIndex);
            IsoTypeWriter.writeUInt32(allocate, this.displayFlags);
            IsoTypeWriter.writeUInt8(allocate, this.horizontalJustification);
            IsoTypeWriter.writeUInt8(allocate, this.verticalJustification);
            IsoTypeWriter.writeUInt8(allocate, this.backgroundColorRgba[0]);
            IsoTypeWriter.writeUInt8(allocate, this.backgroundColorRgba[1]);
            IsoTypeWriter.writeUInt8(allocate, this.backgroundColorRgba[2]);
            IsoTypeWriter.writeUInt8(allocate, this.backgroundColorRgba[3]);
            this.boxRecord.getContent(allocate);
            this.styleRecord.getContent(allocate);
            writableByteChannel.write((ByteBuffer) allocate.rewind());
            writeContainer(writableByteChannel);
        }
    }

    public BoxRecord getBoxRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.boxRecord : (BoxRecord) invokeV.objValue;
    }

    public int getHorizontalJustification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.horizontalJustification : invokeV.intValue;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long containerSize = getContainerSize() + 38;
            return containerSize + ((this.largeBox || containerSize >= 4294967296L) ? 16 : 8);
        }
        return invokeV.longValue;
    }

    public StyleRecord getStyleRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.styleRecord : (StyleRecord) invokeV.objValue;
    }

    public int getVerticalJustification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.verticalJustification : invokeV.intValue;
    }

    public boolean isContinuousKaraoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (this.displayFlags & 2048) == 2048 : invokeV.booleanValue;
    }

    public boolean isFillTextRegion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.displayFlags & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) == PlaybackStateCompat.ACTION_SET_REPEAT_MODE : invokeV.booleanValue;
    }

    public boolean isScrollDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.displayFlags & 384) == 384 : invokeV.booleanValue;
    }

    public boolean isScrollIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.displayFlags & 32) == 32 : invokeV.booleanValue;
    }

    public boolean isScrollOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (this.displayFlags & 64) == 64 : invokeV.booleanValue;
    }

    public boolean isWriteTextVertically() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.displayFlags & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) == PlaybackStateCompat.ACTION_PREPARE_FROM_URI : invokeV.booleanValue;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j2, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j2), boxParser}) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(38);
            dataSource.read(allocate);
            allocate.position(6);
            this.dataReferenceIndex = IsoTypeReader.readUInt16(allocate);
            this.displayFlags = IsoTypeReader.readUInt32(allocate);
            this.horizontalJustification = IsoTypeReader.readUInt8(allocate);
            this.verticalJustification = IsoTypeReader.readUInt8(allocate);
            int[] iArr = new int[4];
            this.backgroundColorRgba = iArr;
            iArr[0] = IsoTypeReader.readUInt8(allocate);
            this.backgroundColorRgba[1] = IsoTypeReader.readUInt8(allocate);
            this.backgroundColorRgba[2] = IsoTypeReader.readUInt8(allocate);
            this.backgroundColorRgba[3] = IsoTypeReader.readUInt8(allocate);
            BoxRecord boxRecord = new BoxRecord();
            this.boxRecord = boxRecord;
            boxRecord.parse(allocate);
            StyleRecord styleRecord = new StyleRecord();
            this.styleRecord = styleRecord;
            styleRecord.parse(allocate);
            parseContainer(dataSource, j2 - 38, boxParser);
        }
    }

    public void setBackgroundColorRgba(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iArr) == null) {
            this.backgroundColorRgba = iArr;
        }
    }

    public void setBoxRecord(BoxRecord boxRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, boxRecord) == null) {
            this.boxRecord = boxRecord;
        }
    }

    public void setContinuousKaraoke(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                this.displayFlags |= 2048;
            } else {
                this.displayFlags &= -2049;
            }
        }
    }

    public void setFillTextRegion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                this.displayFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            } else {
                this.displayFlags &= -262145;
            }
        }
    }

    public void setHorizontalJustification(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.horizontalJustification = i2;
        }
    }

    public void setScrollDirection(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.displayFlags |= 384;
            } else {
                this.displayFlags &= -385;
            }
        }
    }

    public void setScrollIn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            if (z) {
                this.displayFlags |= 32;
            } else {
                this.displayFlags &= -33;
            }
        }
    }

    public void setScrollOut(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (z) {
                this.displayFlags |= 64;
            } else {
                this.displayFlags &= -65;
            }
        }
    }

    public void setStyleRecord(StyleRecord styleRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, styleRecord) == null) {
            this.styleRecord = styleRecord;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.type = str;
        }
    }

    public void setVerticalJustification(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.verticalJustification = i2;
        }
    }

    public void setWriteTextVertically(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (z) {
                this.displayFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            } else {
                this.displayFlags &= -131073;
            }
        }
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? "TextSampleEntry" : (String) invokeV.objValue;
    }

    /* loaded from: classes12.dex */
    public static class StyleRecord {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int endChar;
        public int faceStyleFlags;
        public int fontId;
        public int fontSize;
        public int startChar;
        public int[] textColor;

        public StyleRecord() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.textColor = new int[]{255, 255, 255, 255};
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || StyleRecord.class != obj.getClass()) {
                    return false;
                }
                StyleRecord styleRecord = (StyleRecord) obj;
                return this.endChar == styleRecord.endChar && this.faceStyleFlags == styleRecord.faceStyleFlags && this.fontId == styleRecord.fontId && this.fontSize == styleRecord.fontSize && this.startChar == styleRecord.startChar && Arrays.equals(this.textColor, styleRecord.textColor);
            }
            return invokeL.booleanValue;
        }

        public void getContent(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
                IsoTypeWriter.writeUInt16(byteBuffer, this.startChar);
                IsoTypeWriter.writeUInt16(byteBuffer, this.endChar);
                IsoTypeWriter.writeUInt16(byteBuffer, this.fontId);
                IsoTypeWriter.writeUInt8(byteBuffer, this.faceStyleFlags);
                IsoTypeWriter.writeUInt8(byteBuffer, this.fontSize);
                IsoTypeWriter.writeUInt8(byteBuffer, this.textColor[0]);
                IsoTypeWriter.writeUInt8(byteBuffer, this.textColor[1]);
                IsoTypeWriter.writeUInt8(byteBuffer, this.textColor[2]);
                IsoTypeWriter.writeUInt8(byteBuffer, this.textColor[3]);
            }
        }

        public int getSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 12;
            }
            return invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i2 = ((((((((this.startChar * 31) + this.endChar) * 31) + this.fontId) * 31) + this.faceStyleFlags) * 31) + this.fontSize) * 31;
                int[] iArr = this.textColor;
                return i2 + (iArr != null ? Arrays.hashCode(iArr) : 0);
            }
            return invokeV.intValue;
        }

        public void parse(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
                this.startChar = IsoTypeReader.readUInt16(byteBuffer);
                this.endChar = IsoTypeReader.readUInt16(byteBuffer);
                this.fontId = IsoTypeReader.readUInt16(byteBuffer);
                this.faceStyleFlags = IsoTypeReader.readUInt8(byteBuffer);
                this.fontSize = IsoTypeReader.readUInt8(byteBuffer);
                int[] iArr = new int[4];
                this.textColor = iArr;
                iArr[0] = IsoTypeReader.readUInt8(byteBuffer);
                this.textColor[1] = IsoTypeReader.readUInt8(byteBuffer);
                this.textColor[2] = IsoTypeReader.readUInt8(byteBuffer);
                this.textColor[3] = IsoTypeReader.readUInt8(byteBuffer);
            }
        }

        public StyleRecord(int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), iArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.textColor = new int[]{255, 255, 255, 255};
            this.startChar = i2;
            this.endChar = i3;
            this.fontId = i4;
            this.faceStyleFlags = i5;
            this.fontSize = i6;
            this.textColor = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextSampleEntry(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.backgroundColorRgba = new int[4];
        this.boxRecord = new BoxRecord();
        this.styleRecord = new StyleRecord();
    }
}
