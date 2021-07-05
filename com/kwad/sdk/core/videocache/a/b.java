package com.kwad.sdk.core.videocache.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.core.videocache.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public File f36657a;

    /* renamed from: b  reason: collision with root package name */
    public final a f36658b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f36659c;

    public b(File file, a aVar) {
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f36658b = aVar;
            d.a(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                File parentFile = file.getParentFile();
                file2 = new File(parentFile, file.getName() + ".download");
            }
            this.f36657a = file2;
            this.f36659c = new RandomAccessFile(this.f36657a, exists ? r.f7745a : "rw");
        } catch (IOException e2) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e2);
        }
    }

    private boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, file)) == null) ? file.getName().endsWith(".download") : invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized int a(byte[] bArr, long j, int i2) {
        InterceptResult invokeCommon;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            synchronized (this) {
                try {
                    this.f36659c.seek(j);
                    read = this.f36659c.read(bArr, 0, i2);
                } catch (IOException e2) {
                    throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e2);
                }
            }
            return read;
        }
        return invokeCommon.intValue;
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized long a() {
        InterceptResult invokeV;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                try {
                    length = (int) this.f36659c.length();
                } catch (IOException e2) {
                    throw new ProxyCacheException("Error reading length of file " + this.f36657a, e2);
                }
            }
            return length;
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void a(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bArr, i2) == null) {
            synchronized (this) {
                try {
                    if (d()) {
                        throw new ProxyCacheException("Error append cache: cache file " + this.f36657a + " is completed!");
                    }
                    this.f36659c.seek(a());
                    this.f36659c.write(bArr, 0, i2);
                } catch (IOException e2) {
                    throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.f36659c, Integer.valueOf(bArr.length)), e2);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                try {
                    this.f36659c.close();
                    this.f36658b.a(this.f36657a);
                } catch (IOException e2) {
                    throw new ProxyCacheException("Error closing file " + this.f36657a, e2);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (d()) {
                    return;
                }
                b();
                File file = new File(this.f36657a.getParentFile(), this.f36657a.getName().substring(0, this.f36657a.getName().length() - 9));
                if (!this.f36657a.renameTo(file)) {
                    throw new ProxyCacheException("Error renaming file " + this.f36657a + " to " + file + " for completion!");
                }
                this.f36657a = file;
                try {
                    this.f36659c = new RandomAccessFile(this.f36657a, r.f7745a);
                    this.f36658b.a(this.f36657a);
                } catch (IOException e2) {
                    throw new ProxyCacheException("Error opening " + this.f36657a + " as disc cache", e2);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                z = !a(this.f36657a);
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
