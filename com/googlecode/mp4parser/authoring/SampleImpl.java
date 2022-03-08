package com.googlecode.mp4parser.authoring;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes7.dex */
public class SampleImpl implements Sample {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer[] data;
    public final long offset;
    public final Container parent;
    public final long size;

    public SampleImpl(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.offset = -1L;
        this.size = byteBuffer.limit();
        this.data = new ByteBuffer[]{byteBuffer};
        this.parent = null;
    }

    @Override // com.googlecode.mp4parser.authoring.Sample
    public ByteBuffer asByteBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ensureData();
            ByteBuffer wrap = ByteBuffer.wrap(new byte[CastUtils.l2i(this.size)]);
            for (ByteBuffer byteBuffer : this.data) {
                wrap.put(byteBuffer.duplicate());
            }
            wrap.rewind();
            return wrap;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    public void ensureData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.data == null) {
            Container container = this.parent;
            if (container != null) {
                try {
                    this.data = new ByteBuffer[]{container.getByteBuffer(this.offset, this.size)};
                    return;
                } catch (IOException e2) {
                    throw new RuntimeException("couldn't read sample " + this, e2);
                }
            }
            throw new RuntimeException("Missing parent container, can't read sample " + this);
        }
    }

    @Override // com.googlecode.mp4parser.authoring.Sample
    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.size : invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "SampleImpl{offset=" + this.offset + "{size=" + this.size + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.Sample
    public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writableByteChannel) == null) {
            ensureData();
            for (ByteBuffer byteBuffer : this.data) {
                writableByteChannel.write(byteBuffer.duplicate());
            }
        }
    }

    public SampleImpl(ByteBuffer[] byteBufferArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBufferArr};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.offset = -1L;
        int i4 = 0;
        for (ByteBuffer byteBuffer : byteBufferArr) {
            i4 += byteBuffer.remaining();
        }
        this.size = i4;
        this.data = byteBufferArr;
        this.parent = null;
    }

    public SampleImpl(long j2, long j3, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), byteBuffer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.offset = j2;
        this.size = j3;
        this.data = new ByteBuffer[]{byteBuffer};
        this.parent = null;
    }

    public SampleImpl(long j2, long j3, Container container) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), container};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.offset = j2;
        this.size = j3;
        this.data = null;
        this.parent = container;
    }
}
