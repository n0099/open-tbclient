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
/* loaded from: classes10.dex */
public class c extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f71747a;

    /* renamed from: b  reason: collision with root package name */
    public int f71748b;

    /* renamed from: c  reason: collision with root package name */
    public long f71749c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f71750d;

    /* renamed from: e  reason: collision with root package name */
    public int f71751e;

    /* renamed from: f  reason: collision with root package name */
    public long f71752f;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f71753g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f71754h;

    /* renamed from: i  reason: collision with root package name */
    public int f71755i;

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
        this.f71747a = -1;
        this.f71748b = 10000;
        this.f71749c = -1L;
        this.f71752f = -1L;
        this.f71755i = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;
        i2 = i2 < 20480 ? LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA : i2;
        this.f71750d = inputStream;
        this.f71753g = i2 / 1000.0f;
    }

    private long a(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (j2 <= 0) {
                return 0L;
            }
            if (j3 <= 0) {
                return -1L;
            }
            return j2 / j3;
        }
        return invokeCommon.longValue;
    }

    @WorkerThread
    private void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            try {
                Thread.sleep(j2);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f71747a = 0;
            this.f71749c = System.currentTimeMillis();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.f71747a < this.f71748b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.f71749c;
        float f2 = this.f71747a / this.f71753g;
        this.f71754h = a(this.f71751e, currentTimeMillis - this.f71752f);
        float f3 = (float) j2;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71754h : invokeV.longValue;
    }

    @Override // java.io.InputStream
    public int available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71750d.available() : invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f71750d.close();
            b.a(this);
            this.f71752f = -1L;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            synchronized (this) {
                this.f71750d.mark(i2);
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f71750d.markSupported() : invokeV.booleanValue;
    }

    @Override // java.io.InputStream
    public int read() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f71752f <= 0) {
                this.f71752f = System.currentTimeMillis();
            }
            this.f71751e++;
            if (b.f71743b && b.f71742a) {
                if (this.f71747a < 0) {
                    b();
                }
                int read = this.f71750d.read();
                this.f71747a++;
                c();
                return read;
            }
            return this.f71750d.read();
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                this.f71750d.reset();
            }
        }
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) ? this.f71750d.skip(j2) : invokeJ.longValue;
    }
}
