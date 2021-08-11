package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes10.dex */
public class ji extends jl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InputStream f77672a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f820a;

    public ji() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77672a = null;
        this.f820a = null;
    }

    public ji(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f77672a = null;
        this.f820a = null;
        this.f820a = outputStream;
    }

    @Override // com.xiaomi.push.jl
    public int a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            InputStream inputStream = this.f77672a;
            if (inputStream != null) {
                try {
                    int read = inputStream.read(bArr, i2, i3);
                    if (read >= 0) {
                        return read;
                    }
                    throw new jm(4);
                } catch (IOException e2) {
                    throw new jm(0, e2);
                }
            }
            throw new jm(1, "Cannot read from null inputStream");
        }
        return invokeLII.intValue;
    }

    @Override // com.xiaomi.push.jl
    public void a(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3) == null) {
            OutputStream outputStream = this.f820a;
            if (outputStream == null) {
                throw new jm(1, "Cannot write to null outputStream");
            }
            try {
                outputStream.write(bArr, i2, i3);
            } catch (IOException e2) {
                throw new jm(0, e2);
            }
        }
    }
}
