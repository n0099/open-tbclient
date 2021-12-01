package com.facebook.imageutils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class StreamProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StreamProcessor() {
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

    public static int readPackedInt(InputStream inputStream, int i2, boolean z) throws IOException {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{inputStream, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int read = inputStream.read();
                if (read == -1) {
                    throw new IOException("no more bytes");
                }
                if (z) {
                    i3 = (read & 255) << (i5 * 8);
                } else {
                    i4 <<= 8;
                    i3 = read & 255;
                }
                i4 |= i3;
            }
            return i4;
        }
        return invokeCommon.intValue;
    }
}
