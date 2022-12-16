package org.apache.commons.codec.digest4util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes9.dex */
public class B64 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String B64T = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public transient /* synthetic */ FieldHolder $fh;

    public B64() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void b64from24bit(byte b, byte b2, byte b3, int i, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b), Byte.valueOf(b2), Byte.valueOf(b3), Integer.valueOf(i), sb}) == null) {
            int i2 = ((b << 16) & 16777215) | ((b2 << 8) & 65535) | (b3 & 255);
            while (true) {
                int i3 = i - 1;
                if (i > 0) {
                    sb.append(B64T.charAt(i2 & 63));
                    i2 >>= 6;
                    i = i3;
                } else {
                    return;
                }
            }
        }
    }

    public static String getRandomSalt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 1; i2 <= i; i2++) {
                sb.append(B64T.charAt(new Random().nextInt(64)));
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }
}
