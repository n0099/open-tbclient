package com.coremedia.iso.boxes.sampleentry;

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
/* loaded from: classes9.dex */
public class SubtitleSampleEntry extends AbstractSampleEntry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE1 = "stpp";
    public transient /* synthetic */ FieldHolder $fh;
    public String imageMimeType;
    public String namespace;
    public String schemaLocation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleSampleEntry() {
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
        this.namespace = "";
        this.schemaLocation = "";
        this.imageMimeType = "";
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writableByteChannel) == null) {
            writableByteChannel.write(getHeader());
            ByteBuffer allocate = ByteBuffer.allocate(this.namespace.length() + 8 + this.schemaLocation.length() + this.imageMimeType.length() + 3);
            allocate.position(6);
            IsoTypeWriter.writeUInt16(allocate, this.dataReferenceIndex);
            IsoTypeWriter.writeZeroTermUtf8String(allocate, this.namespace);
            IsoTypeWriter.writeZeroTermUtf8String(allocate, this.schemaLocation);
            IsoTypeWriter.writeZeroTermUtf8String(allocate, this.imageMimeType);
            writableByteChannel.write((ByteBuffer) allocate.rewind());
            writeContainer(writableByteChannel);
        }
    }

    public String getImageMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.imageMimeType : (String) invokeV.objValue;
    }

    public String getNamespace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.namespace : (String) invokeV.objValue;
    }

    public String getSchemaLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.schemaLocation : (String) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = 8;
            long containerSize = getContainerSize() + this.namespace.length() + 8 + this.schemaLocation.length() + this.imageMimeType.length() + 3;
            return containerSize + ((this.largeBox || 8 + containerSize >= 4294967296L) ? 16 : 16);
        }
        return invokeV.longValue;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j2, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j2), boxParser}) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            dataSource.read((ByteBuffer) allocate.rewind());
            allocate.position(6);
            this.dataReferenceIndex = IsoTypeReader.readUInt16(allocate);
            long position = dataSource.position();
            ByteBuffer allocate2 = ByteBuffer.allocate(1024);
            dataSource.read((ByteBuffer) allocate2.rewind());
            String readString = IsoTypeReader.readString((ByteBuffer) allocate2.rewind());
            this.namespace = readString;
            dataSource.position(readString.length() + position + 1);
            dataSource.read((ByteBuffer) allocate2.rewind());
            this.schemaLocation = IsoTypeReader.readString((ByteBuffer) allocate2.rewind());
            dataSource.position(this.namespace.length() + position + this.schemaLocation.length() + 2);
            dataSource.read((ByteBuffer) allocate2.rewind());
            this.imageMimeType = IsoTypeReader.readString((ByteBuffer) allocate2.rewind());
            dataSource.position(position + this.namespace.length() + this.schemaLocation.length() + this.imageMimeType.length() + 3);
            parseContainer(dataSource, j2 - ((((byteBuffer.remaining() + this.namespace.length()) + this.schemaLocation.length()) + this.imageMimeType.length()) + 3), boxParser);
        }
    }

    public void setImageMimeType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.imageMimeType = str;
        }
    }

    public void setNamespace(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.namespace = str;
        }
    }

    public void setSchemaLocation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.schemaLocation = str;
        }
    }
}
