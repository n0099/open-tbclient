package com.coremedia.iso.boxes;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes8.dex */
public class ItemProtectionBox extends AbstractContainerBox implements FullBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "ipro";
    public transient /* synthetic */ FieldHolder $fh;
    public int flags;
    public int version;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemProtectionBox() {
        super(TYPE);
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
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public int getFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.flags;
        }
        return invokeV.intValue;
    }

    public SchemeInformationBox getItemProtectionScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!getBoxes(SchemeInformationBox.class).isEmpty()) {
                return (SchemeInformationBox) getBoxes(SchemeInformationBox.class).get(0);
            }
            return null;
        }
        return (SchemeInformationBox) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public long getSize() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long containerSize = getContainerSize() + 6;
            if (!this.largeBox && containerSize < 4294967296L) {
                i = 8;
            } else {
                i = 16;
            }
            return containerSize + i;
        }
        return invokeV.longValue;
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.version;
        }
        return invokeV.intValue;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writableByteChannel) == null) {
            writableByteChannel.write(getHeader());
            ByteBuffer allocate = ByteBuffer.allocate(6);
            IsoTypeWriter.writeUInt8(allocate, this.version);
            IsoTypeWriter.writeUInt24(allocate, this.flags);
            IsoTypeWriter.writeUInt16(allocate, getBoxes().size());
            writableByteChannel.write((ByteBuffer) allocate.rewind());
            writeContainer(writableByteChannel);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j), boxParser}) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(6);
            dataSource.read(allocate);
            allocate.rewind();
            this.version = IsoTypeReader.readUInt8(allocate);
            this.flags = IsoTypeReader.readUInt24(allocate);
            parseContainer(dataSource, j - 6, boxParser);
        }
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public void setFlags(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.flags = i;
        }
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public void setVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.version = i;
        }
    }
}
