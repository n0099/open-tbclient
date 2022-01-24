package com.coremedia.iso.boxes.mdat;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.logging.Logger;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public final class MediaDataBox implements Box {
    public static /* synthetic */ Interceptable $ic = null;
    public static Logger LOG = null;
    public static final String TYPE = "mdat";
    public transient /* synthetic */ FieldHolder $fh;
    public DataSource dataSource;
    public boolean largeBox;
    public long offset;
    public Container parent;
    public long size;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1526142301, "Lcom/coremedia/iso/boxes/mdat/MediaDataBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1526142301, "Lcom/coremedia/iso/boxes/mdat/MediaDataBox;");
                return;
            }
        }
        LOG = Logger.getLogger(MediaDataBox.class.getName());
    }

    public MediaDataBox() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.largeBox = false;
    }

    public static void transfer(DataSource dataSource, long j2, long j3, WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{dataSource, Long.valueOf(j2), Long.valueOf(j3), writableByteChannel}) == null) {
            long j4 = 0;
            while (j4 < j3) {
                j4 += dataSource.transferTo(j2 + j4, Math.min(67076096L, j3 - j4), writableByteChannel);
            }
        }
    }

    @Override // com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writableByteChannel) == null) {
            transfer(this.dataSource, this.offset, this.size, writableByteChannel);
        }
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.offset : invokeV.longValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public Container getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.parent : (Container) invokeV.objValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.size : invokeV.longValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TYPE : (String) invokeV.objValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j2, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j2), boxParser}) == null) {
            this.offset = dataSource.position() - byteBuffer.remaining();
            this.dataSource = dataSource;
            this.size = byteBuffer.remaining() + j2;
            dataSource.position(dataSource.position() + j2);
        }
    }

    @Override // com.coremedia.iso.boxes.Box
    public void setParent(Container container) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, container) == null) {
            this.parent = container;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "MediaDataBox{size=" + this.size + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
