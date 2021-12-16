package io.flutter.plugin.common;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public final class BinaryCodec implements MessageCodec<ByteBuffer> {
    public static /* synthetic */ Interceptable $ic;
    public static final BinaryCodec INSTANCE;
    public static final BinaryCodec INSTANCE_DIRECT;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean returnsDirectByteBufferFromDecoding;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1606941118, "Lio/flutter/plugin/common/BinaryCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1606941118, "Lio/flutter/plugin/common/BinaryCodec;");
                return;
            }
        }
        INSTANCE = new BinaryCodec();
        INSTANCE_DIRECT = new BinaryCodec(true);
    }

    public BinaryCodec() {
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
        this.returnsDirectByteBufferFromDecoding = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.flutter.plugin.common.MessageCodec
    public ByteBuffer encodeMessage(@Nullable ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) ? byteBuffer : (ByteBuffer) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.flutter.plugin.common.MessageCodec
    public ByteBuffer decodeMessage(@Nullable ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer)) == null) {
            if (byteBuffer == null || this.returnsDirectByteBufferFromDecoding) {
                return byteBuffer;
            }
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
            allocate.put(byteBuffer);
            allocate.rewind();
            return allocate;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public BinaryCodec(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.returnsDirectByteBufferFromDecoding = z;
    }
}
