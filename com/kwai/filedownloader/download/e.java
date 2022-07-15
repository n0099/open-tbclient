package com.kwai.filedownloader.download;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final f b;
    public final int c;
    public final int d;
    public final c e;
    public final com.kwai.filedownloader.kwai.b f;
    public final boolean g;
    public final long h;
    public final long i;
    public final long j;
    public final String k;
    public com.kwai.filedownloader.d.a l;
    public volatile boolean m;
    public final com.kwai.filedownloader.a.a n;
    public volatile long o;
    public volatile long p;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;
        public com.kwai.filedownloader.kwai.b b;
        public com.kwai.filedownloader.download.a c;
        public f d;
        public String e;
        public Boolean f;
        public Integer g;
        public Integer h;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final a a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.g = Integer.valueOf(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a a(com.kwai.filedownloader.download.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                this.c = aVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                this.a = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
                this.d = fVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(com.kwai.filedownloader.kwai.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
                this.b = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f = Boolean.valueOf(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final e a() {
            InterceptResult invokeV;
            com.kwai.filedownloader.kwai.b bVar;
            com.kwai.filedownloader.download.a aVar;
            Integer num;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.f == null || (bVar = this.b) == null || (aVar = this.c) == null || this.d == null || this.e == null || (num = this.h) == null || this.g == null) {
                    throw new IllegalArgumentException();
                }
                return new e(bVar, aVar, this.a, num.intValue(), this.g.intValue(), this.f.booleanValue(), this.d, this.e, (byte) 0);
            }
            return (e) invokeV.objValue;
        }

        public final a b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.h = Integer.valueOf(i);
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    public e(com.kwai.filedownloader.kwai.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, aVar, cVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), fVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 0L;
        this.p = 0L;
        this.b = fVar;
        this.k = str;
        this.f = bVar;
        this.g = z;
        this.e = cVar;
        this.d = i2;
        this.c = i;
        this.n = b.a().c();
        this.h = aVar.a;
        this.i = aVar.c;
        this.a = aVar.b;
        this.j = aVar.d;
    }

    public /* synthetic */ e(com.kwai.filedownloader.kwai.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str, byte b) {
        this(bVar, aVar, cVar, i, i2, z, fVar, str);
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (com.kwai.filedownloader.e.f.a(this.a - this.o, elapsedRealtime - this.p)) {
                d();
                this.o = this.a;
                this.p = elapsedRealtime;
            }
        }
    }

    private void d() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                this.l.a();
                z = true;
            } catch (IOException e) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
                }
                z = false;
            }
            if (z) {
                if (this.e != null) {
                    this.n.a(this.c, this.d, this.a);
                } else {
                    this.b.c();
                }
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.c), Integer.valueOf(this.d), Long.valueOf(this.a), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.m = true;
        }
    }

    public final void b() {
        com.kwai.filedownloader.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.m) {
            return;
        }
        long b = com.kwai.filedownloader.e.f.b(this.d, this.f);
        int i = 0;
        if (b == 0) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.a("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.c), Integer.valueOf(this.d)));
        }
        long j = this.j;
        if (j > 0 && b != j) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.a("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.i == 0 ? com.kwai.filedownloader.e.f.a("range[%d-)", Long.valueOf(this.a)) : com.kwai.filedownloader.e.f.a("range[%d-%d)", Long.valueOf(this.a), Long.valueOf(this.i)), Long.valueOf(this.j), Long.valueOf(b), Integer.valueOf(this.c), Integer.valueOf(this.d)));
        }
        long j2 = this.a;
        try {
            boolean e = b.a().e();
            if (this.e != null && !e) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            aVar = com.kwai.filedownloader.e.f.h(this.k);
            try {
                this.l = aVar;
                if (e) {
                    aVar.a(this.a);
                }
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.d), Long.valueOf(this.h), Long.valueOf(this.i), Long.valueOf(this.a));
                }
                InputStream a2 = this.f.a();
                byte[] bArr = new byte[4096];
                if (this.m) {
                    com.kwad.sdk.crash.utils.b.a(a2);
                    com.kwad.sdk.crash.utils.b.a(aVar);
                    return;
                }
                while (true) {
                    int read = a2.read(bArr);
                    if (read == -1) {
                        if (aVar != null) {
                            d();
                        }
                        com.kwad.sdk.crash.utils.b.a(a2);
                        com.kwad.sdk.crash.utils.b.a(aVar);
                        long j3 = this.a - j2;
                        if (b != -1 && b != j3) {
                            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.a("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", Long.valueOf(j3), Long.valueOf(b), Long.valueOf(this.h), Long.valueOf(this.i), Long.valueOf(this.a), Long.valueOf(j2)));
                        }
                        this.b.a(this.e, this.h, this.i);
                        return;
                    }
                    aVar.a(bArr, i, read);
                    long j4 = read;
                    this.a += j4;
                    this.b.a(j4);
                    c();
                    if (this.m) {
                        com.kwad.sdk.crash.utils.b.a(a2);
                        com.kwad.sdk.crash.utils.b.a(aVar);
                        return;
                    }
                    if (this.g && com.kwai.filedownloader.e.f.a()) {
                        throw new FileDownloadNetworkPolicyException();
                    }
                    i = 0;
                }
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.a((Closeable) null);
                com.kwad.sdk.crash.utils.b.a(aVar);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            aVar = null;
        }
    }
}
