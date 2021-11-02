package io.flutter.plugin.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.StringUtils;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
public final class StringCodec implements MessageCodec<String> {
    public static /* synthetic */ Interceptable $ic;
    public static final StringCodec INSTANCE;
    public static final Charset UTF8;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1677459918, "Lio/flutter/plugin/common/StringCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1677459918, "Lio/flutter/plugin/common/StringCodec;");
                return;
            }
        }
        UTF8 = Charset.forName(StringUtils.UTF8);
        INSTANCE = new StringCodec();
    }

    public StringCodec() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.flutter.plugin.common.MessageCodec
    public String decodeMessage(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        byte[] bArr;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer)) == null) {
            if (byteBuffer == null) {
                return null;
            }
            int remaining = byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                bArr = byteBuffer.array();
                i2 = byteBuffer.arrayOffset();
            } else {
                bArr = new byte[remaining];
                byteBuffer.get(bArr);
                i2 = 0;
            }
            return new String(bArr, i2, remaining, UTF8);
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.flutter.plugin.common.MessageCodec
    public ByteBuffer encodeMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str == null) {
                return null;
            }
            byte[] bytes = str.getBytes(UTF8);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
            allocateDirect.put(bytes);
            return allocateDirect;
        }
        return (ByteBuffer) invokeL.objValue;
    }
}
