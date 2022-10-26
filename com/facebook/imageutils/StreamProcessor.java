package com.facebook.imageutils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class StreamProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StreamProcessor() {
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

    public static int readPackedInt(InputStream inputStream, int i, boolean z) throws IOException {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{inputStream, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                int read = inputStream.read();
                if (read != -1) {
                    if (z) {
                        i2 = (read & 255) << (i4 * 8);
                    } else {
                        i3 <<= 8;
                        i2 = read & 255;
                    }
                    i3 |= i2;
                } else {
                    throw new IOException("no more bytes");
                }
            }
            return i3;
        }
        return invokeCommon.intValue;
    }
}
