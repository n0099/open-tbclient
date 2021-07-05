package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class h extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f37769a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NonNull InputStream inputStream) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
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
        this.f37769a = Integer.MIN_VALUE;
    }

    private long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, this, j)) == null) {
            int i2 = this.f37769a;
            if (i2 == 0) {
                return -1L;
            }
            return (i2 == Integer.MIN_VALUE || j <= ((long) i2)) ? j : i2;
        }
        return invokeJ.longValue;
    }

    private void b(long j) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65538, this, j) == null) || (i2 = this.f37769a) == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f37769a = (int) (i2 - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f37769a;
            return i2 == Integer.MIN_VALUE ? super.available() : Math.min(i2, super.available());
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            synchronized (this) {
                super.mark(i2);
                this.f37769a = i2;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (a(1L) == -1) {
                return -1;
            }
            int read = super.read();
            b(1L);
            return read;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            int a2 = (int) a(i3);
            if (a2 == -1) {
                return -1;
            }
            int read = super.read(bArr, i2, a2);
            b(read);
            return read;
        }
        return invokeLII.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                super.reset();
                this.f37769a = Integer.MIN_VALUE;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            long a2 = a(j);
            if (a2 == -1) {
                return 0L;
            }
            long skip = super.skip(a2);
            b(skip);
            return skip;
        }
        return invokeJ.longValue;
    }
}
