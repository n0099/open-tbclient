package com.googlecode.mp4parser.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
/* loaded from: classes7.dex */
public class ByteBufferByteChannel implements ByteChannel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer byteBuffer;

    public ByteBufferByteChannel(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.byteBuffer = byteBuffer;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer)) == null) {
            int remaining = byteBuffer.remaining();
            if (this.byteBuffer.remaining() <= 0) {
                return -1;
            }
            byteBuffer.put((ByteBuffer) this.byteBuffer.duplicate().limit(this.byteBuffer.position() + byteBuffer.remaining()));
            ByteBuffer byteBuffer2 = this.byteBuffer;
            byteBuffer2.position(byteBuffer2.position() + remaining);
            return remaining;
        }
        return invokeL.intValue;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) {
            int remaining = byteBuffer.remaining();
            this.byteBuffer.put(byteBuffer);
            return remaining;
        }
        return invokeL.intValue;
    }
}
