package com.googlecode.mp4parser;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes7.dex */
public class AbstractContainerBox extends BasicContainer implements Box {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer header;
    public boolean largeBox;
    public long offset;
    public Container parent;
    public String type;

    public AbstractContainerBox(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = str;
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writableByteChannel) == null) {
            writableByteChannel.write(getHeader());
            writeContainer(writableByteChannel);
        }
    }

    public ByteBuffer getHeader() {
        InterceptResult invokeV;
        ByteBuffer wrap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.largeBox && getSize() < 4294967296L) {
                wrap = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, this.type.getBytes()[0], this.type.getBytes()[1], this.type.getBytes()[2], this.type.getBytes()[3]});
                IsoTypeWriter.writeUInt32(wrap, getSize());
            } else {
                byte[] bArr = new byte[16];
                bArr[3] = 1;
                bArr[4] = this.type.getBytes()[0];
                bArr[5] = this.type.getBytes()[1];
                bArr[6] = this.type.getBytes()[2];
                bArr[7] = this.type.getBytes()[3];
                wrap = ByteBuffer.wrap(bArr);
                wrap.position(8);
                IsoTypeWriter.writeUInt64(wrap, getSize());
            }
            wrap.rewind();
            return wrap;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.offset : invokeV.longValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public Container getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.parent : (Container) invokeV.objValue;
    }

    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long containerSize = getContainerSize();
            return containerSize + ((this.largeBox || 8 + containerSize >= 4294967296L) ? 16 : 8);
        }
        return invokeV.longValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.type : (String) invokeV.objValue;
    }

    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j2, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j2), boxParser}) == null) {
            this.offset = dataSource.position() - byteBuffer.remaining();
            this.largeBox = byteBuffer.remaining() == 16;
            parseContainer(dataSource, j2, boxParser);
        }
    }

    @Override // com.coremedia.iso.boxes.Box
    public void setParent(Container container) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, container) == null) {
            this.parent = container;
        }
    }
}
