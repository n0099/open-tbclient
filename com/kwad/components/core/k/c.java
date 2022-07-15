package com.kwad.components.core.k;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class c extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public long c;
    public InputStream d;
    public int e;
    public long f;
    public volatile float g;
    public volatile long h;
    public int i;

    public c(@NonNull InputStream inputStream, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = 10000;
        this.c = -1L;
        this.f = -1L;
        this.i = 20480;
        i = i < 20480 ? 20480 : i;
        this.d = inputStream;
        this.g = i / 1000.0f;
    }

    public static long a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j <= 0) {
                return 0L;
            }
            if (j2 <= 0) {
                return -1L;
            }
            return j / j2;
        }
        return invokeCommon.longValue;
    }

    @WorkerThread
    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j) == null) {
            try {
                Thread.sleep(j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.a = 0;
            this.c = System.currentTimeMillis();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.a < this.b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.c;
        float f = this.a / this.g;
        this.h = a(this.e, currentTimeMillis - this.f);
        float f2 = (float) j;
        if (f > f2) {
            a(f - f2);
        }
        b();
    }

    public final long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : invokeV.longValue;
    }

    @Override // java.io.InputStream
    public final int available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d.available() : invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.close();
            b.a(this);
            this.f = -1L;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (this) {
                this.d.mark(i);
            }
        }
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d.markSupported() : invokeV.booleanValue;
    }

    @Override // java.io.InputStream
    public final int read() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f <= 0) {
                this.f = System.currentTimeMillis();
            }
            this.e++;
            if (b.b && b.a) {
                if (this.a < 0) {
                    b();
                }
                int read = this.d.read();
                this.a++;
                c();
                return read;
            }
            return this.d.read();
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                this.d.reset();
            }
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) ? this.d.skip(j) : invokeJ.longValue;
    }
}
