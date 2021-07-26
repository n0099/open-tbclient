package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f34804a;

    /* renamed from: b  reason: collision with root package name */
    public int f34805b;

    /* renamed from: c  reason: collision with root package name */
    public long f34806c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f34807d;

    /* renamed from: e  reason: collision with root package name */
    public int f34808e;

    /* renamed from: f  reason: collision with root package name */
    public long f34809f;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f34810g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f34811h;

    /* renamed from: i  reason: collision with root package name */
    public int f34812i;

    public c(@NonNull InputStream inputStream, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34804a = -1;
        this.f34805b = 10000;
        this.f34806c = -1L;
        this.f34809f = -1L;
        this.f34812i = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;
        i2 = i2 < 20480 ? LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA : i2;
        this.f34807d = inputStream;
        this.f34810g = i2 / 1000.0f;
    }

    private long a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
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
    private void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            try {
                Thread.sleep(j);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f34804a = 0;
            this.f34806c = System.currentTimeMillis();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.f34804a < this.f34805b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f34806c;
        float f2 = this.f34804a / this.f34810g;
        this.f34811h = a(this.f34808e, currentTimeMillis - this.f34809f);
        float f3 = (float) j;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34811h : invokeV.longValue;
    }

    @Override // java.io.InputStream
    public int available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34807d.available() : invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f34807d.close();
            b.a(this);
            this.f34809f = -1L;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            synchronized (this) {
                this.f34807d.mark(i2);
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34807d.markSupported() : invokeV.booleanValue;
    }

    @Override // java.io.InputStream
    public int read() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f34809f <= 0) {
                this.f34809f = System.currentTimeMillis();
            }
            this.f34808e++;
            if (b.f34800b && b.f34799a) {
                if (this.f34804a < 0) {
                    b();
                }
                int read = this.f34807d.read();
                this.f34804a++;
                c();
                return read;
            }
            return this.f34807d.read();
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                this.f34807d.reset();
            }
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) ? this.f34807d.skip(j) : invokeJ.longValue;
    }
}
