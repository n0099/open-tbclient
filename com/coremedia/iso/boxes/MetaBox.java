package com.coremedia.iso.boxes;

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
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes6.dex */
public class MetaBox extends AbstractContainerBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "meta";
    public transient /* synthetic */ FieldHolder $fh;
    public int flags;
    public int version;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetaBox() {
        super("meta");
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

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writableByteChannel) == null) {
            writableByteChannel.write(getHeader());
            ByteBuffer allocate = ByteBuffer.allocate(4);
            writeVersionAndFlags(allocate);
            writableByteChannel.write((ByteBuffer) allocate.rewind());
            writeContainer(writableByteChannel);
        }
    }

    public int getFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.flags : invokeV.intValue;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long containerSize = getContainerSize() + 4;
            return containerSize + ((this.largeBox || containerSize >= 4294967296L) ? 16 : 8);
        }
        return invokeV.longValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.version : invokeV.intValue;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j), boxParser}) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            dataSource.read(allocate);
            parseVersionAndFlags((ByteBuffer) allocate.rewind());
            parseContainer(dataSource, j - 4, boxParser);
        }
    }

    public final long parseVersionAndFlags(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, byteBuffer)) == null) {
            this.version = IsoTypeReader.readUInt8(byteBuffer);
            this.flags = IsoTypeReader.readUInt24(byteBuffer);
            return 4L;
        }
        return invokeL.longValue;
    }

    public void setFlags(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.flags = i;
        }
    }

    public void setVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.version = i;
        }
    }

    public final void writeVersionAndFlags(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer) == null) {
            IsoTypeWriter.writeUInt8(byteBuffer, this.version);
            IsoTypeWriter.writeUInt24(byteBuffer, this.flags);
        }
    }
}
