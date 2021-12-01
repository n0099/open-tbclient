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
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public final f f59968b;

    /* renamed from: c  reason: collision with root package name */
    public final int f59969c;

    /* renamed from: d  reason: collision with root package name */
    public final int f59970d;

    /* renamed from: e  reason: collision with root package name */
    public final c f59971e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwai.filedownloader.kwai.b f59972f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f59973g;

    /* renamed from: h  reason: collision with root package name */
    public final long f59974h;

    /* renamed from: i  reason: collision with root package name */
    public final long f59975i;

    /* renamed from: j  reason: collision with root package name */
    public final long f59976j;

    /* renamed from: k  reason: collision with root package name */
    public final String f59977k;
    public com.kwai.filedownloader.d.a l;
    public volatile boolean m;
    public final com.kwai.filedownloader.a.a n;
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
        public c a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwai.filedownloader.kwai.b f59978b;

        /* renamed from: c  reason: collision with root package name */
        public com.kwai.filedownloader.download.a f59979c;

        /* renamed from: d  reason: collision with root package name */
        public f f59980d;

        /* renamed from: e  reason: collision with root package name */
        public String f59981e;

        /* renamed from: f  reason: collision with root package name */
        public Boolean f59982f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f59983g;

        /* renamed from: h  reason: collision with root package name */
        public Integer f59984h;

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
                this.f59983g = Integer.valueOf(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                this.f59979c = aVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                this.a = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
                this.f59980d = fVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(com.kwai.filedownloader.kwai.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
                this.f59978b = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f59981e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f59982f = Boolean.valueOf(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public e a() {
            InterceptResult invokeV;
            com.kwai.filedownloader.kwai.b bVar;
            com.kwai.filedownloader.download.a aVar;
            Integer num;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.f59982f == null || (bVar = this.f59978b) == null || (aVar = this.f59979c) == null || this.f59980d == null || this.f59981e == null || (num = this.f59984h) == null || this.f59983g == null) {
                    throw new IllegalArgumentException();
                }
                return new e(bVar, aVar, this.a, num.intValue(), this.f59983g.intValue(), this.f59982f.booleanValue(), this.f59980d, this.f59981e, null);
            }
            return (e) invokeV.objValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.f59984h = Integer.valueOf(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    public e(com.kwai.filedownloader.kwai.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i2, int i3, boolean z, f fVar, String str) {
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
        this.f59968b = fVar;
        this.f59977k = str;
        this.f59972f = bVar;
        this.f59973g = z;
        this.f59971e = cVar;
        this.f59970d = i3;
        this.f59969c = i2;
        this.n = b.a().c();
        this.f59974h = aVar.a;
        this.f59975i = aVar.f59938c;
        this.a = aVar.f59937b;
        this.f59976j = aVar.f59939d;
    }

    public /* synthetic */ e(com.kwai.filedownloader.kwai.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i2, int i3, boolean z, f fVar, String str, AnonymousClass1 anonymousClass1) {
        this(bVar, aVar, cVar, i2, i3, z, fVar, str);
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
            } catch (IOException e2) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e2);
                }
                z = false;
            }
            if (z) {
                if (this.f59971e != null) {
                    this.n.a(this.f59969c, this.f59970d, this.a);
                } else {
                    this.f59968b.c();
                }
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.f59969c), Integer.valueOf(this.f59970d), Long.valueOf(this.a), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
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
        com.kwai.filedownloader.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.m) {
            return;
        }
        long b2 = com.kwai.filedownloader.e.f.b(this.f59970d, this.f59972f);
        if (b2 == 0) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.a("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.f59969c), Integer.valueOf(this.f59970d)));
        }
        long j2 = this.f59976j;
        char c2 = 3;
        if (j2 > 0 && b2 != j2) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.a("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.f59975i == 0 ? com.kwai.filedownloader.e.f.a("range[%d-)", Long.valueOf(this.a)) : com.kwai.filedownloader.e.f.a("range[%d-%d)", Long.valueOf(this.a), Long.valueOf(this.f59975i)), Long.valueOf(this.f59976j), Long.valueOf(b2), Integer.valueOf(this.f59969c), Integer.valueOf(this.f59970d)));
        }
        long j3 = this.a;
        InputStream inputStream = null;
        try {
            boolean e2 = b.a().e();
            if (this.f59971e != null && !e2) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            aVar = com.kwai.filedownloader.e.f.l(this.f59977k);
            try {
                this.l = aVar;
                if (e2) {
                    aVar.a(this.a);
                }
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.f59970d), Long.valueOf(this.f59974h), Long.valueOf(this.f59975i), Long.valueOf(this.a));
                }
                inputStream = this.f59972f.a();
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
                        long j4 = this.a - j3;
                        if (b2 == -1 || b2 == j4) {
                            this.f59968b.a(this.f59971e, this.f59974h, this.f59975i);
                            return;
                        }
                        Object[] objArr = new Object[6];
                        objArr[0] = Long.valueOf(j4);
                        objArr[1] = Long.valueOf(b2);
                        objArr[2] = Long.valueOf(this.f59974h);
                        objArr[c2] = Long.valueOf(this.f59975i);
                        objArr[4] = Long.valueOf(this.a);
                        objArr[5] = Long.valueOf(j3);
                        throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.a("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", objArr));
                    }
                    aVar.a(bArr, 0, read);
                    long j5 = read;
                    this.a += j5;
                    this.f59968b.a(j5);
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
                    if (this.f59973g && com.kwai.filedownloader.e.f.d()) {
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
