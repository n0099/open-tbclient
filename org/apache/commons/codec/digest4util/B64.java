package org.apache.commons.codec.digest4util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes10.dex */
public class B64 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String B64T = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public transient /* synthetic */ FieldHolder $fh;

    public B64() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void b64from24bit(byte b2, byte b3, byte b4, int i2, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3), Byte.valueOf(b4), Integer.valueOf(i2), sb}) != null) {
            return;
        }
        int i3 = ((b2 << 16) & 16777215) | ((b3 << 8) & 65535) | (b4 & 255);
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            sb.append(B64T.charAt(i3 & 63));
            i3 >>= 6;
            i2 = i4;
        }
    }

    public static String getRandomSalt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 1; i3 <= i2; i3++) {
                sb.append(B64T.charAt(new Random().nextInt(64)));
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }
}
