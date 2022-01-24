package com.sdk.base.framework.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
/* loaded from: classes4.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    public final void a(InputStream inputStream, OutputStream outputStream) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048576, this, inputStream, outputStream) != null) {
            return;
        }
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        while (true) {
            int i4 = 0;
            while (true) {
                i2 = i4 + 4;
                i3 = 4;
                if (i2 >= 72) {
                    break;
                }
                try {
                    a(pushbackInputStream, outputStream, 4);
                    i4 = i2;
                } catch (c unused) {
                    return;
                }
            }
            if (i2 != 72) {
                i3 = 72 - i4;
            }
            a(pushbackInputStream, outputStream, i3);
        }
    }

    public void a(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pushbackInputStream, outputStream, i2) == null) {
            throw new c();
        }
    }
}
