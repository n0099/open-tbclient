package com.google.android.exoplayer2.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes7.dex */
public class SimpleOutputBuffer extends OutputBuffer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer data;
    public final SimpleDecoder<?, SimpleOutputBuffer, ?> owner;

    public SimpleOutputBuffer(SimpleDecoder<?, SimpleOutputBuffer, ?> simpleDecoder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {simpleDecoder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.owner = simpleDecoder;
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.clear();
            ByteBuffer byteBuffer = this.data;
            if (byteBuffer != null) {
                byteBuffer.clear();
            }
        }
    }

    public ByteBuffer init(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            this.timeUs = j2;
            ByteBuffer byteBuffer = this.data;
            if (byteBuffer == null || byteBuffer.capacity() < i2) {
                this.data = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
            }
            this.data.position(0);
            this.data.limit(i2);
            return this.data;
        }
        return (ByteBuffer) invokeCommon.objValue;
    }

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.owner.releaseOutputBuffer(this);
        }
    }
}
