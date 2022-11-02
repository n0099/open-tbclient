package com.kwad.components.core.l;

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
/* loaded from: classes7.dex */
public final class c extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int IC;
    public int ID;
    public long IE;
    public InputStream IF;
    public int IG;
    public long IH;
    public volatile float II;
    public volatile long IJ;
    public int IK;

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
        this.IC = -1;
        this.ID = 10000;
        this.IE = -1L;
        this.IH = -1L;
        this.IK = 20480;
        i = i < 20480 ? 20480 : i;
        this.IF = inputStream;
        this.II = i / 1000.0f;
    }

    public static long c(long j, long j2) {
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

    private void ot() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.IC = 0;
            this.IE = System.currentTimeMillis();
        }
    }

    private void ou() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.IC < this.ID) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.IE;
        float f = this.IC / this.II;
        this.IJ = c(this.IG, currentTimeMillis - this.IH);
        float f2 = (float) j;
        if (f > f2) {
            p(f - f2);
        }
        ot();
    }

    @WorkerThread
    public static void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j) == null) {
            try {
                Thread.sleep(j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.IF.available() : invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.IF.close();
            b.a(this);
            this.IH = -1L;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            synchronized (this) {
                this.IF.mark(i);
            }
        }
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.IF.markSupported() : invokeV.booleanValue;
    }

    public final long os() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.IJ : invokeV.longValue;
    }

    @Override // java.io.InputStream
    public final int read() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.IH <= 0) {
                this.IH = System.currentTimeMillis();
            }
            this.IG++;
            if (b.IA && b.Iz) {
                if (this.IC < 0) {
                    ot();
                }
                int read = this.IF.read();
                this.IC++;
                ou();
                return read;
            }
            return this.IF.read();
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                this.IF.reset();
            }
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) ? this.IF.skip(j) : invokeJ.longValue;
    }
}
