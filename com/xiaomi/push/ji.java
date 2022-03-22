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
/* loaded from: classes7.dex */
public class ji extends jl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InputStream a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f797a;

    public ji() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f797a = null;
    }

    public ji(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f797a = null;
        this.f797a = outputStream;
    }

    @Override // com.xiaomi.push.jl
    public int a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
            InputStream inputStream = this.a;
            if (inputStream != null) {
                try {
                    int read = inputStream.read(bArr, i, i2);
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
    public void a(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i, i2) == null) {
            OutputStream outputStream = this.f797a;
            if (outputStream == null) {
                throw new jm(1, "Cannot write to null outputStream");
            }
            try {
                outputStream.write(bArr, i, i2);
            } catch (IOException e2) {
                throw new jm(0, e2);
            }
        }
    }
}
