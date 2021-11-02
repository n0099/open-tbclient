package com.ss.android.socialbase.downloader.f;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class m implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Thread A;
    public volatile boolean B;
    public int C;
    public int D;
    public int E;
    public long F;
    public int G;
    public boolean H;
    public BaseException I;
    public boolean J;
    public boolean K;
    public com.ss.android.socialbase.downloader.i.e L;

    /* renamed from: a  reason: collision with root package name */
    public volatile i f69363a;

    /* renamed from: b  reason: collision with root package name */
    public q f69364b;

    /* renamed from: c  reason: collision with root package name */
    public final int f69365c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f69366d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f69367e;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f69368f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f69369g;

    /* renamed from: h  reason: collision with root package name */
    public String f69370h;

    /* renamed from: i  reason: collision with root package name */
    public String f69371i;
    public String j;
    public final f k;
    public final c l;
    public final DownloadInfo m;
    public final com.ss.android.socialbase.downloader.g.a n;
    public com.ss.android.socialbase.downloader.network.i o;
    public com.ss.android.socialbase.downloader.model.d p;
    public final List<i> q;
    public long r;
    public volatile long s;
    public volatile long t;
    public volatile long u;
    public volatile long v;
    public Future w;
    public volatile boolean x;
    public volatile boolean y;
    public volatile boolean z;

    public m(DownloadInfo downloadInfo, k kVar, c cVar, q qVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo, kVar, cVar, qVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new ArrayList();
        this.u = -1L;
        this.m = downloadInfo;
        this.k = kVar;
        this.l = cVar;
        this.n = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.f69364b = qVar;
        this.f69365c = i2;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private boolean a(i iVar) throws BaseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, this, iVar)) != null) {
            return invokeL.booleanValue;
        }
        k();
        while (true) {
            try {
                b(iVar);
                d(iVar);
                return true;
            } catch (j e2) {
                this.I = e2;
                throw e2;
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "download: e = " + th + ", threadIndex = " + this.f69365c + ", reconnect = " + this.y + ", closed = " + this.x);
                    if (this.x) {
                        return false;
                    }
                    if (this.y) {
                        this.y = false;
                        Thread.interrupted();
                        if (this.z) {
                            this.z = false;
                            throw new j(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        BaseException e3 = null;
                        if (th instanceof BaseException) {
                            e3 = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.i.f.a((Throwable) th, "download");
                            } catch (BaseException e4) {
                                e3 = e4;
                            }
                        }
                        if (e3 == null || !a(iVar, e3)) {
                            return false;
                        }
                    }
                } finally {
                    i();
                }
            }
        }
    }

    private void b(i iVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, iVar) == null) {
            c(iVar);
            this.k.a(this, iVar, this.f69364b, this.p);
            this.f69364b.c();
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    private void c(i iVar) throws BaseException {
        String str;
        String str2;
        com.ss.android.socialbase.downloader.network.i a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, iVar) == null) {
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f69367e = 0L;
                    this.f69366d = currentTimeMillis;
                    this.r = iVar.e();
                    this.t = iVar.f();
                    if (this.t > 0 && this.r > this.t) {
                        throw new j(6, "createConn, " + iVar);
                    }
                    this.L = new com.ss.android.socialbase.downloader.i.e();
                    List<com.ss.android.socialbase.downloader.model.c> a3 = com.ss.android.socialbase.downloader.i.f.a(this.m.getExtraHeaders(), this.m.geteTag(), this.r, this.t);
                    a3.add(new com.ss.android.socialbase.downloader.model.c("Segment-Index", String.valueOf(iVar.g())));
                    a3.add(new com.ss.android.socialbase.downloader.model.c("Thread-Index", String.valueOf(this.f69365c)));
                    com.ss.android.socialbase.downloader.i.f.a(a3, this.m);
                    com.ss.android.socialbase.downloader.i.f.b(a3, this.m);
                    str = this.f69364b.f69374a;
                    if (this.H && !TextUtils.isEmpty(str) && str.startsWith("https")) {
                        str = str.replaceFirst("https", "http");
                    }
                    str2 = this.f69364b.f69375b;
                    com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + iVar + ", threadIndex = " + this.f69365c);
                    this.f69370h = str;
                    this.f69371i = str2;
                    a2 = com.ss.android.socialbase.downloader.downloader.c.a(this.m.isNeedDefaultHttpServiceBackUp(), this.m.getMaxBytes(), str, str2, a3, 0, currentTimeMillis - this.F > 3000 && this.n.b("monitor_download_connect") > 0, this.m);
                } finally {
                    this.f69367e = System.currentTimeMillis();
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.i.f.a(th, "createConn");
            }
            if (a2 != null) {
                this.o = a2;
                this.p = new com.ss.android.socialbase.downloader.model.d(str, a2);
                if (!this.x) {
                    if (a2 instanceof com.ss.android.socialbase.downloader.network.a) {
                        this.j = ((com.ss.android.socialbase.downloader.network.a) a2).e();
                    }
                    String str3 = "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.j + ", threadIndex = " + this.f69365c;
                    return;
                }
                throw new p("createConn");
            }
            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01c6, code lost:
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0130, code lost:
        r7 = r11 + 1;
        r11 = r13 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x013a, code lost:
        if (r11 <= 0) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x013c, code lost:
        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: redundant = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0152, code lost:
        r31.u = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0155, code lost:
        r13 = r7;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0159, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0162, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x016a, code lost:
        throw new com.ss.android.socialbase.downloader.f.p("loopAndRead");
     */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(i iVar) throws BaseException {
        long j;
        e eVar;
        InputStream inputStream;
        a aVar;
        a aVar2;
        a aVar3;
        f fVar;
        long f2;
        int i2;
        long j2;
        long j3;
        a aVar4;
        int i3;
        a aVar5;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, iVar) == null) {
            i iVar2 = iVar;
            c cVar = this.l;
            this.f69368f = System.currentTimeMillis();
            long e2 = iVar.e();
            boolean z = false;
            try {
                try {
                    inputStream = this.o.a();
                    try {
                    } catch (BaseException e3) {
                        e = e3;
                    } catch (Throwable th) {
                        th = th;
                        j = e2;
                        eVar = null;
                    }
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.i.f.a(inputStream);
                    if (eVar != null) {
                        if (aVar == null) {
                            try {
                                aVar = cVar.b();
                            } catch (Throwable unused) {
                                aVar2 = aVar;
                                if (aVar2 != null) {
                                }
                                this.f69369g = System.currentTimeMillis();
                                if (j > e2) {
                                }
                                this.k.c(this, iVar2);
                                throw th2;
                            }
                        }
                        aVar.f69317c = -1;
                        eVar.b(aVar);
                        aVar2 = null;
                        if (aVar2 != null) {
                            cVar.a(aVar2);
                        }
                        this.f69369g = System.currentTimeMillis();
                        if (j > e2) {
                            com.ss.android.socialbase.downloader.d.a.a(this.n, this.m, this.f69370h, this.f69371i, this.j, this.x || this.y, this.o, this.I, j - e2, TimeUnit.MILLISECONDS.toNanos(this.f69369g - this.f69368f));
                        }
                        this.k.c(this, iVar2);
                        throw th2;
                    }
                    aVar2 = aVar;
                    if (aVar2 != null) {
                    }
                    this.f69369g = System.currentTimeMillis();
                    if (j > e2) {
                    }
                    this.k.c(this, iVar2);
                    throw th2;
                }
            } catch (BaseException e4) {
                e = e4;
            } catch (Throwable th3) {
                th = th3;
                j = e2;
                eVar = null;
                inputStream = null;
            }
            if (inputStream != null) {
                long h2 = this.p.h();
                int i5 = (h2 > 0L ? 1 : (h2 == 0L ? 0 : -1));
                if (i5 != 0) {
                    aVar = a(cVar, inputStream);
                    try {
                    } catch (BaseException e5) {
                        e = e5;
                    } catch (Throwable th4) {
                        th = th4;
                        j = e2;
                        eVar = null;
                    }
                    if (!this.y && !this.x) {
                        this.k.b(this, iVar2);
                        eVar = this.k.d(this, iVar2);
                        try {
                            f2 = iVar.f();
                            if (f2 <= 0) {
                                f2 = i5 > 0 ? (h2 + e2) - 1 : Long.MAX_VALUE;
                            }
                            i2 = aVar.f69317c;
                            j2 = i2;
                            j = e2 + j2;
                            try {
                            } catch (BaseException e6) {
                                e = e6;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (BaseException e7) {
                            e = e7;
                        } catch (Throwable th6) {
                            th = th6;
                            j = e2;
                        }
                        if (j > f2) {
                            long j4 = f2 + 1;
                            if (j > j4 && (i4 = (int) (j2 - (j - j4))) > 0 && i4 < i2) {
                                aVar.f69317c = i4;
                                j = j4;
                            }
                            this.u = j;
                            eVar.b(aVar);
                            com.ss.android.socialbase.downloader.i.f.a(inputStream);
                            if (eVar != null) {
                                try {
                                    a b2 = cVar.b();
                                    try {
                                        b2.f69317c = -1;
                                        eVar.b(b2);
                                    } catch (Throwable unused2) {
                                        aVar5 = b2;
                                    }
                                } catch (Throwable unused3) {
                                }
                            }
                            aVar5 = null;
                            if (aVar5 != null) {
                                cVar.a(aVar5);
                            }
                            this.f69369g = System.currentTimeMillis();
                            if (j > e2) {
                                com.ss.android.socialbase.downloader.d.a.a(this.n, this.m, this.f69370h, this.f69371i, this.j, this.x || this.y, this.o, this.I, j - e2, TimeUnit.MILLISECONDS.toNanos(this.f69369g - this.f69368f));
                            }
                            this.k.c(this, iVar2);
                            return;
                        }
                        this.u = j;
                        eVar.b(aVar);
                        long j5 = f2;
                        while (true) {
                            try {
                                if (this.B) {
                                    try {
                                        synchronized (this) {
                                            this.B = z;
                                            if (this.y || this.x) {
                                                break;
                                            }
                                        }
                                        synchronized (this.k) {
                                            try {
                                                if (this.s != 0) {
                                                    com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "loopAndRead:  change readEnd = " + j5 + ", segmentNewEndOffset = " + this.s + ", segment = " + iVar2);
                                                    j5 = m();
                                                    if (j > j5) {
                                                        break;
                                                    }
                                                }
                                            } catch (Throwable th7) {
                                                th = th7;
                                            }
                                        }
                                    } catch (BaseException e8) {
                                        e = e8;
                                        this.I = e;
                                        throw e;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        iVar2 = iVar;
                                        aVar = null;
                                        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                        th.printStackTrace();
                                        try {
                                            com.ss.android.socialbase.downloader.i.f.a(th, "loopAndRead");
                                            com.ss.android.socialbase.downloader.i.f.a(inputStream);
                                            if (eVar != null) {
                                                if (aVar == null) {
                                                    try {
                                                        aVar = cVar.b();
                                                    } catch (Throwable unused4) {
                                                        aVar3 = aVar;
                                                        if (aVar3 != null) {
                                                            cVar.a(aVar3);
                                                        }
                                                        this.f69369g = System.currentTimeMillis();
                                                        if (j > e2) {
                                                            com.ss.android.socialbase.downloader.d.a.a(this.n, this.m, this.f69370h, this.f69371i, this.j, this.x || this.y, this.o, this.I, j - e2, TimeUnit.MILLISECONDS.toNanos(this.f69369g - this.f69368f));
                                                        }
                                                        fVar = this.k;
                                                        fVar.c(this, iVar2);
                                                        return;
                                                    }
                                                }
                                                aVar.f69317c = -1;
                                                eVar.b(aVar);
                                                aVar3 = null;
                                                if (aVar3 != null) {
                                                }
                                                this.f69369g = System.currentTimeMillis();
                                                if (j > e2) {
                                                }
                                                fVar = this.k;
                                                fVar.c(this, iVar2);
                                                return;
                                            }
                                            aVar3 = aVar;
                                            if (aVar3 != null) {
                                            }
                                            this.f69369g = System.currentTimeMillis();
                                            if (j > e2) {
                                            }
                                            fVar = this.k;
                                            fVar.c(this, iVar2);
                                            return;
                                        } catch (BaseException e9) {
                                            this.I = e9;
                                            throw e9;
                                        }
                                    }
                                }
                                aVar = cVar.b();
                            } catch (BaseException e10) {
                                e = e10;
                            } catch (Throwable th9) {
                                th = th9;
                            }
                            try {
                                int read = inputStream.read(aVar.f69315a);
                                aVar.f69317c = read;
                                if (read == -1) {
                                    eVar.b(aVar);
                                    j3 = 0;
                                    eVar = null;
                                    break;
                                }
                                long j6 = read;
                                j += j6;
                                if (j > j5) {
                                    long j7 = j5 + 1;
                                    if (j > j7 && (i3 = (int) (j6 - (j - j7))) > 0 && i3 < read) {
                                        aVar.f69317c = i3;
                                        j = j7;
                                    }
                                    this.u = j;
                                    eVar.b(aVar);
                                    com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "loopAndRead: bytesRead = " + (j - e2) + ", url = " + this.f69364b.f69374a);
                                } else {
                                    iVar2 = iVar;
                                    this.u = j;
                                    eVar.b(aVar);
                                    z = false;
                                }
                            } catch (BaseException e11) {
                                e = e11;
                                this.I = e;
                                throw e;
                            } catch (Throwable th10) {
                                th = th10;
                                iVar2 = iVar;
                                com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                th.printStackTrace();
                                com.ss.android.socialbase.downloader.i.f.a(th, "loopAndRead");
                                com.ss.android.socialbase.downloader.i.f.a(inputStream);
                                if (eVar != null) {
                                }
                                aVar3 = aVar;
                                if (aVar3 != null) {
                                }
                                this.f69369g = System.currentTimeMillis();
                                if (j > e2) {
                                }
                                fVar = this.k;
                                fVar.c(this, iVar2);
                                return;
                            }
                        }
                        if (j5 > j3 && j5 != Long.MAX_VALUE && j <= j5) {
                            throw new BaseException(1051, String.format("range[%d, %d] , but readCurrent[%d] , readStart[%d]", Long.valueOf(e2), Long.valueOf(j5), Long.valueOf(j), Long.valueOf(e2)));
                        }
                        com.ss.android.socialbase.downloader.i.f.a(inputStream);
                        if (eVar != null) {
                            try {
                                a b3 = cVar.b();
                                try {
                                    b3.f69317c = -1;
                                    eVar.b(b3);
                                } catch (Throwable unused5) {
                                    aVar4 = b3;
                                }
                            } catch (Throwable unused6) {
                            }
                        }
                        aVar4 = null;
                        if (aVar4 != null) {
                            cVar.a(aVar4);
                        }
                        this.f69369g = System.currentTimeMillis();
                        if (j > e2) {
                            com.ss.android.socialbase.downloader.d.a.a(this.n, this.m, this.f69370h, this.f69371i, this.j, this.x || this.y, this.o, this.I, j - e2, TimeUnit.MILLISECONDS.toNanos(this.f69369g - this.f69368f));
                        }
                        fVar = this.k;
                        iVar2 = iVar;
                        fVar.c(this, iVar2);
                        return;
                    }
                    throw new p("probe");
                }
                throw new com.ss.android.socialbase.downloader.exception.f(1004, "the content-length is 0, contentLength = " + h2);
            }
            throw new BaseException(1042, new IOException("inputStream is null"));
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.F = this.f69366d;
            this.f69366d = -1L;
            this.f69367e = -1L;
            this.f69368f = -1L;
            this.f69369g = -1L;
            j();
        }
    }

    private void j() {
        com.ss.android.socialbase.downloader.network.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (iVar = this.o) == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "closeConnection: thread = " + this.f69365c);
            iVar.d();
            iVar.c();
        } catch (Throwable unused) {
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.H = false;
            l();
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.D = this.f69364b.f69377d ? this.m.getRetryCount() : this.m.getBackUpUrlRetryCount();
            this.E = 0;
        }
    }

    private long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            long j = this.s;
            this.s = 0L;
            if (j <= 0) {
                return Long.MAX_VALUE;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "close: threadIndex = " + this.f69365c);
            synchronized (this) {
                this.x = true;
                this.B = true;
            }
            j();
            Future future = this.w;
            if (future != null) {
                this.w = null;
                try {
                    future.cancel(true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            a(false);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.J : invokeV.booleanValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.r : invokeV.longValue;
    }

    /* JADX DEBUG: Null dom frontier in handler: all -> 0x0101 */
    @Override // java.lang.Runnable
    public void run() {
        i a2;
        f fVar;
        f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Process.setThreadPriority(10);
            try {
                this.A = Thread.currentThread();
                this.k.a(this);
                this.f69364b.a(this);
                while (true) {
                    a2 = this.k.a(this, this.f69364b);
                    if (a2 == null) {
                        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "no more segment, thread_index = " + this.f69365c);
                        break;
                    }
                    this.f69363a = a2;
                    try {
                        try {
                        } catch (j e2) {
                            com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "run: SegmentApplyException, e = " + e2);
                            if (this.C >= 50) {
                                com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "segment apply failed " + this.C + "times, thread_index = " + this.f69365c);
                                this.f69363a = null;
                                fVar = this.k;
                                break;
                            }
                            this.C++;
                            this.f69363a = null;
                            fVar2 = this.k;
                        }
                        if (a(a2)) {
                            this.q.add(a2);
                            this.f69363a = null;
                            fVar2 = this.k;
                            fVar2.a(this, a2);
                        } else if (!this.x) {
                            com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "download segment failed, segment = " + a2 + ", thread_index = " + this.f69365c + ", failedException = " + this.I);
                            break;
                        } else {
                            break;
                        }
                    } catch (Throwable th) {
                        this.f69363a = null;
                        this.k.a(this, a2);
                        throw th;
                    }
                }
                this.f69363a = null;
                fVar = this.k;
                fVar.a(this, a2);
                this.f69364b.b(this);
                this.k.b(this);
            } catch (Throwable unused) {
            }
            this.A = null;
        }
    }

    public long b() {
        InterceptResult invokeV;
        long c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.k) {
                c2 = this.v + c();
            }
            return c2;
        }
        return invokeV.longValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.J = z;
        }
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            long j2 = this.u;
            com.ss.android.socialbase.downloader.i.e eVar = this.L;
            if (j2 < 0 || eVar == null) {
                return;
            }
            String str = "markProgress: curSegmentReadOffset = " + j2 + ", threadIndex = " + this.f69365c;
            eVar.a(j2, j);
        }
    }

    public boolean a(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qVar)) == null) {
            int i2 = this.G;
            if (i2 >= 30) {
                return false;
            }
            this.G = i2 + 1;
            q qVar2 = this.f69364b;
            if (qVar2 != null) {
                qVar2.b(this);
            }
            qVar.a(this);
            this.f69364b = qVar;
            l();
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean a(i iVar, BaseException baseException) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, iVar, baseException)) == null) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.E + ", retryCount = " + this.D);
            this.I = baseException;
            this.f69364b.b();
            this.k.a(this, this.f69364b, iVar, baseException, this.E, this.D);
            int i2 = this.E;
            if (i2 < this.D) {
                this.E = i2 + 1;
                return true;
            } else if (a(baseException)) {
                return true;
            } else {
                this.k.a(this, this.f69364b, iVar, baseException);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this.k) {
                long j = this.u;
                long j2 = this.r;
                if (j2 < 0 || j <= j2) {
                    return 0L;
                }
                return j - j2;
            }
        }
        return invokeV.longValue;
    }

    private boolean a(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, baseException)) == null) {
            if (com.ss.android.socialbase.downloader.i.f.c(baseException)) {
                String str = this.f69364b.f69374a;
                if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.m.isNeedHttpsToHttpRetry() || this.H) {
                    return false;
                }
                this.H = true;
                l();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.K = z;
        }
    }

    private a a(c cVar, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, cVar, inputStream)) == null) {
            a b2 = cVar.b();
            try {
                i2 = inputStream.read(b2.f69315a);
            } catch (Throwable th) {
                th = th;
                i2 = -1;
            }
            try {
                if (i2 != -1) {
                    b2.f69317c = i2;
                    if (i2 == -1) {
                        cVar.a(b2);
                    }
                    return b2;
                }
                throw new BaseException(1073, "probe");
            } catch (Throwable th2) {
                th = th2;
                if (i2 == -1) {
                    cVar.a(b2);
                }
                throw th;
            }
        }
        return (a) invokeLL.objValue;
    }

    public boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            long j2 = this.t;
            if (j > 0 || j2 <= 0) {
                if (j <= j2 || j2 <= 0) {
                    this.s = j;
                    this.B = true;
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            q qVar = this.f69364b;
            try {
                synchronized (this.k) {
                    long c2 = c();
                    if (c2 > 0) {
                        this.v += c2;
                        qVar.a(c2);
                    }
                    this.u = -1L;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "reconnect: threadIndex = " + this.f69365c);
            synchronized (this) {
                this.z = z;
                this.y = true;
                this.B = true;
            }
            j();
            Thread thread = this.A;
            if (thread != null) {
                try {
                    String str = "reconnect: t.interrupt threadIndex = " + this.f69365c;
                    thread.interrupt();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void a(Future future) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, future) == null) {
            this.w = future;
        }
    }

    public long a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            com.ss.android.socialbase.downloader.i.e eVar = this.L;
            if (eVar == null) {
                return -1L;
            }
            return eVar.b(j, j2);
        }
        return invokeCommon.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.u : invokeV.longValue;
    }
}
