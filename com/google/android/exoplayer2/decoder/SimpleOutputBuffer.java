package com.google.android.exoplayer2.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public ByteBuffer init(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            this.timeUs = j;
            ByteBuffer byteBuffer = this.data;
            if (byteBuffer == null || byteBuffer.capacity() < i) {
                this.data = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
            }
            this.data.position(0);
            this.data.limit(i);
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
