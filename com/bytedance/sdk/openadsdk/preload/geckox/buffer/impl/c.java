package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class c implements com.bytedance.sdk.openadsdk.preload.geckox.buffer.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f69021a;

    /* renamed from: b  reason: collision with root package name */
    public long f69022b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f69023c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f69024d;

    /* renamed from: e  reason: collision with root package name */
    public File f69025e;

    public c(long j2, File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69024d = new AtomicBoolean(false);
        this.f69021a = j2;
        this.f69025e = file;
        file.getParentFile().mkdirs();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f69023c = randomAccessFile;
            randomAccessFile.setLength(j2);
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.f69023c);
            throw new IOException("create raf swap failed! path: " + file.getAbsolutePath() + " caused by: " + e2.getMessage(), e2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f69024d.get()) {
            throw new IOException("released!");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f69021a : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.f69024d.get()) {
                return this.f69022b;
            }
            throw new IOException("released!");
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int d() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            byte[] bArr = new byte[1];
            if (b(bArr) == 0) {
                return -1;
            }
            return bArr[0];
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f69024d.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.f69023c);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f69025e : (File) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r5 > r0) goto L7;
     */
    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            if (!this.f69024d.get()) {
                long j3 = 0;
                if (j2 >= 0) {
                    j3 = this.f69021a;
                }
                j2 = j3;
                this.f69022b = j2;
                this.f69023c.seek(j2);
                return;
            }
            throw new IOException("released!");
        }
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
    public synchronized long a(long j2) throws IOException {
        InterceptResult invokeJ;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            synchronized (this) {
                if (this.f69024d.get()) {
                    throw new IOException("released!");
                }
                int i2 = (int) j2;
                if (i2 == j2) {
                    int skipBytes = this.f69023c.skipBytes(i2);
                    this.f69022b = this.f69023c.getFilePointer();
                    j3 = skipBytes;
                } else {
                    throw new IOException("too large:" + j2);
                }
            }
            return j3;
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
            if (!this.f69024d.get()) {
                if (bArr == null || i3 < 1 || i2 < 0 || i2 >= bArr.length) {
                    return 0;
                }
                if (i2 + i3 > bArr.length) {
                    i3 = bArr.length - i2;
                }
                synchronized (this) {
                    if (this.f69022b == this.f69021a) {
                        return -1;
                    }
                    if (this.f69022b + i3 > this.f69021a) {
                        i3 = (int) (this.f69021a - this.f69022b);
                    }
                    int read = this.f69023c.read(bArr, i2, i3);
                    if (read == -1) {
                        return -1;
                    }
                    this.f69022b += read;
                    return read;
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
            if (!this.f69024d.get()) {
                if (bArr == null || bArr.length == 0 || i3 < 1 || i2 < 0 || i2 >= bArr.length) {
                    return 0;
                }
                if (i2 + i3 > bArr.length) {
                    i3 = bArr.length - i2;
                }
                synchronized (this) {
                    if (this.f69022b == this.f69021a) {
                        return 0;
                    }
                    if (this.f69022b + i3 > this.f69021a) {
                        i3 = (int) (this.f69021a - this.f69022b);
                    }
                    this.f69023c.write(bArr, i2, i3);
                    this.f69022b += i3;
                    return i3;
                }
            }
            throw new IOException("released!");
        }
        return invokeLII.intValue;
    }
}
