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
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f66939a;

    /* renamed from: b  reason: collision with root package name */
    public final f f66940b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66941c;

    /* renamed from: d  reason: collision with root package name */
    public final int f66942d;

    /* renamed from: e  reason: collision with root package name */
    public final c f66943e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwai.filedownloader.a.b f66944f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f66945g;

    /* renamed from: h  reason: collision with root package name */
    public final long f66946h;

    /* renamed from: i  reason: collision with root package name */
    public final long f66947i;
    public final long j;
    public final String k;
    public com.kwai.filedownloader.e.a l;
    public volatile boolean m;
    public final com.kwai.filedownloader.b.a n;
    public volatile long o;
    public volatile long p;

    /* renamed from: com.kwai.filedownloader.download.e$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f66948a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwai.filedownloader.a.b f66949b;

        /* renamed from: c  reason: collision with root package name */
        public com.kwai.filedownloader.download.a f66950c;

        /* renamed from: d  reason: collision with root package name */
        public f f66951d;

        /* renamed from: e  reason: collision with root package name */
        public String f66952e;

        /* renamed from: f  reason: collision with root package name */
        public Boolean f66953f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f66954g;

        /* renamed from: h  reason: collision with root package name */
        public Integer f66955h;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f66954g = Integer.valueOf(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(com.kwai.filedownloader.a.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
                this.f66949b = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.f66950c = aVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
                this.f66948a = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) {
                this.f66951d = fVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f66952e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f66953f = Boolean.valueOf(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public e a() {
            InterceptResult invokeV;
            com.kwai.filedownloader.a.b bVar;
            com.kwai.filedownloader.download.a aVar;
            Integer num;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.f66953f == null || (bVar = this.f66949b) == null || (aVar = this.f66950c) == null || this.f66951d == null || this.f66952e == null || (num = this.f66955h) == null || this.f66954g == null) {
                    throw new IllegalArgumentException();
                }
                return new e(bVar, aVar, this.f66948a, num.intValue(), this.f66954g.intValue(), this.f66953f.booleanValue(), this.f66951d, this.f66952e, null);
            }
            return (e) invokeV.objValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.f66955h = Integer.valueOf(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    public e(com.kwai.filedownloader.a.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i2, int i3, boolean z, f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, aVar, cVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), fVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 0L;
        this.p = 0L;
        this.f66940b = fVar;
        this.k = str;
        this.f66944f = bVar;
        this.f66945g = z;
        this.f66943e = cVar;
        this.f66942d = i3;
        this.f66941c = i2;
        this.n = b.a().c();
        this.f66946h = aVar.f66903a;
        this.f66947i = aVar.f66905c;
        this.f66939a = aVar.f66904b;
        this.j = aVar.f66906d;
    }

    public /* synthetic */ e(com.kwai.filedownloader.a.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i2, int i3, boolean z, f fVar, String str, AnonymousClass1 anonymousClass1) {
        this(bVar, aVar, cVar, i2, i3, z, fVar, str);
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (com.kwai.filedownloader.f.f.a(this.f66939a - this.o, elapsedRealtime - this.p)) {
                d();
                this.o = this.f66939a;
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
            } catch (IOException e2) {
                if (com.kwai.filedownloader.f.d.f66974a) {
                    com.kwai.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e2);
                }
                z = false;
            }
            if (z) {
                if (this.f66943e != null) {
                    this.n.a(this.f66941c, this.f66942d, this.f66939a);
                } else {
                    this.f66940b.c();
                }
                if (com.kwai.filedownloader.f.d.f66974a) {
                    com.kwai.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.f66941c), Integer.valueOf(this.f66942d), Long.valueOf(this.f66939a), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.m = true;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01eb, code lost:
        throw new com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        Throwable th;
        com.kwai.filedownloader.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.m) {
            return;
        }
        long b2 = com.kwai.filedownloader.f.f.b(this.f66942d, this.f66944f);
        if (b2 == 0) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.f66941c), Integer.valueOf(this.f66942d)));
        }
        long j = this.j;
        char c2 = 3;
        if (j > 0 && b2 != j) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.f66947i == 0 ? com.kwai.filedownloader.f.f.a("range[%d-)", Long.valueOf(this.f66939a)) : com.kwai.filedownloader.f.f.a("range[%d-%d)", Long.valueOf(this.f66939a), Long.valueOf(this.f66947i)), Long.valueOf(this.j), Long.valueOf(b2), Integer.valueOf(this.f66941c), Integer.valueOf(this.f66942d)));
        }
        long j2 = this.f66939a;
        InputStream inputStream = null;
        try {
            boolean e2 = b.a().e();
            if (this.f66943e != null && !e2) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            aVar = com.kwai.filedownloader.f.f.l(this.k);
            try {
                this.l = aVar;
                if (e2) {
                    aVar.a(this.f66939a);
                }
                if (com.kwai.filedownloader.f.d.f66974a) {
                    com.kwai.filedownloader.f.d.c(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.f66942d), Long.valueOf(this.f66946h), Long.valueOf(this.f66947i), Long.valueOf(this.f66939a));
                }
                inputStream = this.f66944f.a();
                byte[] bArr = new byte[4096];
                if (this.m) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (aVar != null) {
                        try {
                            d();
                        } finally {
                        }
                    }
                    if (aVar != null) {
                        try {
                            aVar.b();
                            return;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (aVar != null) {
                            try {
                                d();
                            } finally {
                                if (aVar != null) {
                                    try {
                                        aVar.b();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                            }
                        }
                        if (aVar != null) {
                            try {
                                aVar.b();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        long j3 = this.f66939a - j2;
                        if (b2 == -1 || b2 == j3) {
                            this.f66940b.a(this.f66943e, this.f66946h, this.f66947i);
                            return;
                        }
                        Object[] objArr = new Object[6];
                        objArr[0] = Long.valueOf(j3);
                        objArr[1] = Long.valueOf(b2);
                        objArr[2] = Long.valueOf(this.f66946h);
                        objArr[c2] = Long.valueOf(this.f66947i);
                        objArr[4] = Long.valueOf(this.f66939a);
                        objArr[5] = Long.valueOf(j2);
                        throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", objArr));
                    }
                    aVar.a(bArr, 0, read);
                    long j4 = read;
                    this.f66939a += j4;
                    this.f66940b.a(j4);
                    c();
                    if (this.m) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (aVar != null) {
                            try {
                                d();
                            } finally {
                            }
                        }
                        if (aVar != null) {
                            try {
                                aVar.b();
                                return;
                            } catch (IOException e9) {
                                e9.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    if (this.f66945g && com.kwai.filedownloader.f.f.d()) {
                        break;
                    }
                    c2 = 3;
                }
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                if (aVar != null) {
                    try {
                        d();
                    } finally {
                        if (aVar != null) {
                            try {
                                aVar.b();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                    }
                }
                if (aVar != null) {
                    try {
                        aVar.b();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            aVar = null;
        }
    }
}
