package com.sdk.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
/* loaded from: classes8.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    public abstract void a(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i);

    public byte[] a(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
            return (byte[]) invokeL.objValue;
        }
        byte[] bArr = new byte[str.length()];
        str.getBytes(0, str.length(), bArr, 0);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream);
        while (true) {
            try {
                a aVar = (a) this;
                int i2 = 0;
                while (true) {
                    a aVar2 = (a) this;
                    i = i2 + 4;
                    if (i >= 72) {
                        break;
                    }
                    a aVar3 = (a) this;
                    a(pushbackInputStream, byteArrayOutputStream, 4);
                    a aVar4 = (a) this;
                    a aVar5 = (a) this;
                    i2 = i;
                }
                a aVar6 = (a) this;
                if (i == 72) {
                    a aVar7 = (a) this;
                    a(pushbackInputStream, byteArrayOutputStream, 4);
                    a aVar8 = (a) this;
                } else {
                    a(pushbackInputStream, byteArrayOutputStream, 72 - i2);
                }
            } catch (c unused) {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
