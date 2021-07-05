package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class c extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f37756a;

    /* renamed from: b  reason: collision with root package name */
    public int f37757b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((InputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37756a = j;
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            if (i2 >= 0) {
                this.f37757b += i2;
            } else if (this.f37756a - this.f37757b > 0) {
                throw new IOException("Failed to read all expected data, expected: " + this.f37756a + ", but read: " + this.f37757b);
            }
            return i2;
        }
        return invokeI.intValue;
    }

    @NonNull
    public static InputStream a(@NonNull InputStream inputStream, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, inputStream, j)) == null) ? new c(inputStream, j) : (InputStream) invokeLJ.objValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InterceptResult invokeV;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                max = (int) Math.max(this.f37756a - this.f37757b, ((FilterInputStream) this).in.available());
            }
            return max;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        InterceptResult invokeV;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                read = super.read();
                a(read >= 0 ? 1 : -1);
            }
            return read;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) ? read(bArr, 0, bArr.length) : invokeL.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            synchronized (this) {
                a2 = a(super.read(bArr, i2, i3));
            }
            return a2;
        }
        return invokeLII.intValue;
    }
}
