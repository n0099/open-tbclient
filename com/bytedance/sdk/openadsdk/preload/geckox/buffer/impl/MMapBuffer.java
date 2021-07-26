package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.g;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class MMapBuffer implements com.bytedance.sdk.openadsdk.preload.geckox.buffer.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f32361a;

    /* renamed from: b  reason: collision with root package name */
    public long f32362b;

    /* renamed from: c  reason: collision with root package name */
    public long f32363c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f32364d;

    /* renamed from: e  reason: collision with root package name */
    public File f32365e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-681413529, "Lcom/bytedance/sdk/openadsdk/preload/geckox/buffer/impl/MMapBuffer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-681413529, "Lcom/bytedance/sdk/openadsdk/preload/geckox/buffer/impl/MMapBuffer;");
                return;
            }
        }
        g.a("buffer_pg");
    }

    public MMapBuffer(long j, File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), file};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32364d = new AtomicBoolean(false);
        d(j);
        this.f32365e = file;
        file.getParentFile().mkdirs();
        c(nCreate(file.getAbsolutePath(), j));
    }

    private native long nCreate(String str, long j) throws IOException;

    private native int nFlush(long j, long j2) throws IOException;

    private native void nRead(long j, long j2, byte[] bArr, int i2, int i3);

    private native int nRelease(long j, long j2);

    private native void nWrite(long j, long j2, byte[] bArr, int i2, int i3);

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.f32364d.get()) {
                nFlush(this.f32362b, this.f32361a);
                return;
            }
            throw new IOException("released!");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f32361a : invokeV.longValue;
    }

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.f32362b = j;
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.f32361a = j;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f32364d.getAndSet(true)) {
            return;
        }
        nRelease(this.f32362b, this.f32361a);
        this.f32362b = 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f32365e : (File) invokeV.objValue;
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.finalize();
            try {
                e();
            } catch (Exception e2) {
                com.bytedance.sdk.openadsdk.preload.geckox.utils.c.a(e2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r5 > r0) goto L7;
     */
    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            if (!this.f32364d.get()) {
                long j2 = 0;
                if (j >= 0) {
                    j2 = this.f32361a;
                }
                j = j2;
                this.f32363c = j;
                return;
            }
            throw new IOException("released!");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.f32364d.get()) {
                return this.f32363c;
            }
            throw new IOException("released!");
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int d() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            byte[] bArr = new byte[1];
            if (b(bArr) <= 0) {
                return -1;
            }
            return bArr[0];
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            a(new byte[]{(byte) i2});
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) {
            a(bArr, 0, bArr.length);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public synchronized long a(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            synchronized (this) {
                if (this.f32364d.get()) {
                    throw new IOException("released!");
                }
                if (j <= 0) {
                    return 0L;
                }
                long j2 = this.f32363c;
                long j3 = this.f32363c + j;
                this.f32363c = j3;
                if (j3 < 0) {
                    this.f32363c = 0L;
                } else if (j3 > this.f32361a) {
                    this.f32363c = this.f32361a;
                }
                return this.f32363c - j2;
            }
        }
        return invokeJ.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int b(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) ? b(bArr, 0, bArr.length) : invokeL.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int b(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, bArr, i2, i3)) == null) {
            if (!this.f32364d.get()) {
                if (bArr == null || i3 < 1 || i2 < 0 || i2 >= bArr.length) {
                    return 0;
                }
                if (i2 + i3 > bArr.length) {
                    i3 = bArr.length - i2;
                }
                synchronized (this) {
                    if (this.f32363c == this.f32361a) {
                        return -1;
                    }
                    if (this.f32363c + i3 > this.f32361a) {
                        i3 = (int) (this.f32361a - this.f32363c);
                    }
                    nRead(this.f32362b, this.f32363c, bArr, i2, i3);
                    this.f32363c += i3;
                    return i3;
                }
            }
            throw new IOException("released!");
        }
        return invokeLII.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int a(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            if (!this.f32364d.get()) {
                if (bArr == null || bArr.length == 0 || i3 < 1 || i2 < 0 || i2 >= bArr.length) {
                    return 0;
                }
                if (i2 + i3 > bArr.length) {
                    i3 = bArr.length - i2;
                }
                synchronized (this) {
                    if (this.f32363c == this.f32361a) {
                        return 0;
                    }
                    if (this.f32363c + i3 > this.f32361a) {
                        i3 = (int) (this.f32361a - this.f32363c);
                    }
                    nWrite(this.f32362b, this.f32363c, bArr, i2, i3);
                    this.f32363c += i3;
                    return i3;
                }
            }
            throw new IOException("released!");
        }
        return invokeLII.intValue;
    }
}
