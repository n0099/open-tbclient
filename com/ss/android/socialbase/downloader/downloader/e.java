package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f62316b = "ResponseHandler";
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public long D;
    public volatile long E;
    public volatile long F;
    public boolean a;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f62317c;

    /* renamed from: d  reason: collision with root package name */
    public final String f62318d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.model.b f62319e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.network.i f62320f;

    /* renamed from: g  reason: collision with root package name */
    public j f62321g;

    /* renamed from: h  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.impls.k f62322h;

    /* renamed from: i  reason: collision with root package name */
    public t f62323i;

    /* renamed from: j  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.e f62324j;

    /* renamed from: k  reason: collision with root package name */
    public BaseException f62325k;
    public volatile boolean l;
    public volatile boolean m;
    public final com.ss.android.socialbase.downloader.h.f n;
    public long o;
    public long p;
    public volatile long q;
    public volatile long r;
    public final boolean s;
    public final com.ss.android.socialbase.downloader.g.a t;
    public final com.ss.android.socialbase.downloader.a.a u;
    public final boolean v;
    public final long w;
    public final long x;
    public final boolean y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(326251570, "Lcom/ss/android/socialbase/downloader/downloader/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(326251570, "Lcom/ss/android/socialbase/downloader/downloader/e;");
        }
    }

    public e(DownloadInfo downloadInfo, String str, com.ss.android.socialbase.downloader.network.i iVar, com.ss.android.socialbase.downloader.model.b bVar, com.ss.android.socialbase.downloader.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo, str, iVar, bVar, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.E = 0L;
        this.F = 0L;
        this.f62317c = downloadInfo;
        this.f62318d = str;
        j x = c.x();
        this.f62321g = x;
        if (x instanceof com.ss.android.socialbase.downloader.impls.d) {
            com.ss.android.socialbase.downloader.impls.d dVar = (com.ss.android.socialbase.downloader.impls.d) x;
            this.f62322h = dVar.a();
            this.f62323i = dVar.f();
        }
        this.f62320f = iVar;
        this.f62319e = bVar;
        this.n = fVar;
        long n = bVar.n();
        this.o = n;
        this.p = n;
        if (bVar.d()) {
            this.r = bVar.q();
        } else {
            this.r = bVar.c(false);
        }
        this.q = bVar.p();
        this.u = com.ss.android.socialbase.downloader.a.a.a();
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.t = a;
        boolean z = a.a("sync_strategy", 0) == 1;
        this.v = z;
        if (z) {
            this.w = Math.max(this.t.a("sync_interval_ms_fg", 5000), 500L);
            this.x = Math.max(this.t.a("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.w = 0L;
            this.x = 0L;
        }
        this.y = this.t.b("monitor_rw") == 1;
        this.s = com.ss.android.socialbase.downloader.i.a.a(65536);
    }

    private boolean b(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? j2 > 65536 && j3 > 500 : invokeCommon.booleanValue;
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.l || this.m : invokeV.booleanValue;
    }

    private void g() {
        ExecutorService l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f62320f == null || (l = c.l()) == null) {
            return;
        }
        l.execute(new Runnable(this) { // from class: com.ss.android.socialbase.downloader.downloader.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        this.a.f62320f.d();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    private void h() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            long nanoTime = this.y ? System.nanoTime() : 0L;
            try {
                this.f62324j.a();
                z = true;
            } catch (Exception unused) {
                z = false;
            }
            if (z) {
                this.f62317c.updateRealDownloadTime(true);
                boolean z2 = this.f62317c.getChunkCount() > 1;
                m a = com.ss.android.socialbase.downloader.impls.l.a(com.ss.android.socialbase.downloader.i.f.b());
                if (z2) {
                    a(this.f62323i);
                    if (a != null) {
                        a.c(this.f62317c);
                    } else {
                        this.f62323i.a(this.f62317c.getId(), this.f62317c.getCurBytes());
                    }
                } else if (a != null) {
                    a.c(this.f62317c);
                } else {
                    this.f62323i.a(this.f62319e.k(), this.o);
                }
                this.E = this.o;
            }
            if (this.y) {
                this.C += System.nanoTime() - nanoTime;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.l) {
            return;
        }
        this.l = true;
        g();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.m) {
            return;
        }
        synchronized (this.n) {
            this.m = true;
        }
        g();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:147:0x028e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:149:0x0290 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:153:0x0295 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:171:0x02d8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:173:0x02da */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:344:0x0062 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:348:0x002f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:358:0x01e7 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02e9 A[Catch: all -> 0x04e3, TRY_ENTER, TryCatch #27 {all -> 0x04e3, blocks: (B:179:0x02e9, B:180:0x02f0, B:209:0x0369, B:211:0x036f, B:212:0x0372, B:253:0x045e, B:254:0x0460, B:258:0x0467, B:260:0x0487, B:288:0x04d7, B:290:0x04dd, B:291:0x04e0, B:292:0x04e2), top: B:348:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0369 A[Catch: all -> 0x04e3, TRY_ENTER, TryCatch #27 {all -> 0x04e3, blocks: (B:179:0x02e9, B:180:0x02f0, B:209:0x0369, B:211:0x036f, B:212:0x0372, B:253:0x045e, B:254:0x0460, B:258:0x0467, B:260:0x0487, B:288:0x04d7, B:290:0x04dd, B:291:0x04e0, B:292:0x04e2), top: B:348:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0487 A[Catch: all -> 0x04e3, TRY_LEAVE, TryCatch #27 {all -> 0x04e3, blocks: (B:179:0x02e9, B:180:0x02f0, B:209:0x0369, B:211:0x036f, B:212:0x0372, B:253:0x045e, B:254:0x0460, B:258:0x0467, B:260:0x0487, B:288:0x04d7, B:290:0x04dd, B:291:0x04e0, B:292:0x04e2), top: B:348:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04dd A[Catch: all -> 0x04e3, TryCatch #27 {all -> 0x04e3, blocks: (B:179:0x02e9, B:180:0x02f0, B:209:0x0369, B:211:0x036f, B:212:0x0372, B:253:0x045e, B:254:0x0460, B:258:0x0467, B:260:0x0487, B:288:0x04d7, B:290:0x04dd, B:291:0x04e0, B:292:0x04e2), top: B:348:0x002f }] */
    /* JADX WARN: Type inference failed for: r32v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r32v10 */
    /* JADX WARN: Type inference failed for: r32v14 */
    /* JADX WARN: Type inference failed for: r32v15 */
    /* JADX WARN: Type inference failed for: r32v16 */
    /* JADX WARN: Type inference failed for: r32v17 */
    /* JADX WARN: Type inference failed for: r32v18 */
    /* JADX WARN: Type inference failed for: r32v2 */
    /* JADX WARN: Type inference failed for: r32v3 */
    /* JADX WARN: Type inference failed for: r32v4 */
    /* JADX WARN: Type inference failed for: r32v8 */
    /* JADX WARN: Type inference failed for: r32v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v3, types: [int] */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() throws BaseException {
        long j2;
        long j3;
        boolean z;
        char c2;
        com.ss.android.socialbase.downloader.e.b bVar;
        com.ss.android.socialbase.downloader.g.a aVar;
        DownloadInfo downloadInfo;
        String str;
        com.ss.android.socialbase.downloader.network.i iVar;
        boolean z2;
        boolean z3;
        boolean z4;
        com.ss.android.socialbase.downloader.network.i iVar2;
        String str2;
        DownloadInfo downloadInfo2;
        com.ss.android.socialbase.downloader.g.a aVar2;
        long j4;
        char c3;
        int i2;
        com.ss.android.socialbase.downloader.model.e a;
        InputStream a2;
        long j5;
        long j6;
        long currentTimeMillis;
        long j7;
        long j8;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            j2 = interceptable;
            if (j2.invokeV(1048581, this) != null) {
                return;
            }
        }
        if (f() || this.f62319e == null) {
            return;
        }
        long a3 = com.ss.android.socialbase.downloader.i.f.a(this.f62320f);
        if (a3 != 0) {
            int l = this.f62319e.l();
            long nanoTime = System.nanoTime();
            boolean z5 = this.y;
            boolean z6 = this.f62320f instanceof com.ss.android.socialbase.downloader.network.a;
            int i3 = 1;
            try {
                try {
                    i2 = -1;
                    a = com.ss.android.socialbase.downloader.i.f.a(this.f62317c, this.f62317c.getTempPath(), this.f62317c.getTempName(), this.t.a("flush_buffer_size_byte", -1));
                    this.f62324j = a;
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.network.i iVar3 = this.f62320f;
                    if (iVar3 != null) {
                        iVar3.d();
                    }
                    if (bVar != null) {
                        bVar.b();
                    }
                    try {
                        if (this.s) {
                            synchronized (this.n) {
                                if (!this.m) {
                                    a(this.f62322h);
                                    if (this.f62324j != null) {
                                        h();
                                    }
                                }
                            }
                        } else {
                            a(this.f62322h);
                            if (this.f62324j != null) {
                                h();
                            }
                        }
                        Closeable[] closeableArr = new Closeable[l];
                        closeableArr[c2] = this.f62324j;
                        com.ss.android.socialbase.downloader.i.f.a(closeableArr);
                        this.D = System.nanoTime() - nanoTime;
                        com.ss.android.socialbase.downloader.d.a.a(this.t, this.f62317c, this.f62318d, this.f62320f, this.l, this.m, this.f62325k, this.o - this.p, this.D, z, this.A, this.B, this.C, null);
                        throw th;
                    } catch (Throwable th2) {
                        Closeable[] closeableArr2 = new Closeable[l];
                        closeableArr2[c2] = this.f62324j;
                        com.ss.android.socialbase.downloader.i.f.a(closeableArr2);
                        throw th2;
                    }
                }
            } catch (BaseException e2) {
                e = e2;
                z = z5;
            } catch (Throwable th3) {
                th = th3;
                j3 = a3;
                j2 = l;
                z = z5;
            }
            try {
                try {
                    a.a(this.o);
                    a2 = this.f62320f.a();
                } catch (IOException e3) {
                    throw new BaseException((int) RevenueServerConst.ChargeCurrencyHistoryRequest, e3);
                }
            } catch (BaseException e4) {
                e = e4;
                bVar = null;
                com.ss.android.socialbase.downloader.c.a.d(f62316b, "handleResponse: BaseException e = " + e);
                if (!this.t.a("ignore_base_ex_on_stop_status")) {
                }
                if (com.ss.android.socialbase.downloader.c.a.a()) {
                }
                this.f62325k = e;
                throw e;
            } catch (Throwable th4) {
                th = th4;
                bVar = null;
                if (z6) {
                }
                com.ss.android.socialbase.downloader.c.a.d(f62316b, "handleResponse: e = " + th);
                if (!f()) {
                }
            }
            if (a2 != null) {
                this.f62317c.updateRealStartDownloadTime();
                bVar = a(a2);
                try {
                    this.f62317c.setIsRwConcurrent(this.z);
                    this.a = this.f62317c.getOpenLimitSpeed();
                    long j9 = com.ss.android.socialbase.downloader.constants.e.f62251d;
                    j5 = com.ss.android.socialbase.downloader.constants.e.f62252e;
                    j6 = j9 / (1000 / j5);
                    currentTimeMillis = System.currentTimeMillis();
                    j7 = 0;
                    j8 = 0;
                    l = l;
                } catch (BaseException e5) {
                    e = e5;
                    z = z5;
                } catch (Throwable th5) {
                    th = th5;
                    j3 = a3;
                    j2 = l;
                    z = z5;
                }
                while (!f()) {
                    z = z5;
                    if (z) {
                        try {
                            try {
                                j7 = System.nanoTime();
                            } catch (BaseException e6) {
                                e = e6;
                                com.ss.android.socialbase.downloader.c.a.d(f62316b, "handleResponse: BaseException e = " + e);
                                if (!this.t.a("ignore_base_ex_on_stop_status") && f()) {
                                    com.ss.android.socialbase.downloader.network.i iVar4 = this.f62320f;
                                    if (iVar4 != null) {
                                        iVar4.d();
                                    }
                                    if (bVar != null) {
                                        bVar.b();
                                    }
                                    try {
                                        if (this.s) {
                                            synchronized (this.n) {
                                                if (!this.m) {
                                                    a(this.f62322h);
                                                    if (this.f62324j != null) {
                                                        h();
                                                    }
                                                }
                                            }
                                        } else {
                                            a(this.f62322h);
                                            if (this.f62324j != null) {
                                                h();
                                            }
                                        }
                                        Closeable[] closeableArr3 = new Closeable[l];
                                        closeableArr3[c2] = this.f62324j;
                                        com.ss.android.socialbase.downloader.i.f.a(closeableArr3);
                                        this.D = System.nanoTime() - nanoTime;
                                        aVar2 = this.t;
                                        downloadInfo2 = this.f62317c;
                                        str2 = this.f62318d;
                                        iVar2 = this.f62320f;
                                        z4 = this.l;
                                        z3 = this.m;
                                        com.ss.android.socialbase.downloader.d.a.a(aVar2, downloadInfo2, str2, iVar2, z4, z3, this.f62325k, this.o - this.p, this.D, z, this.A, this.B, this.C, null);
                                        return;
                                    } catch (Throwable th6) {
                                        Closeable[] closeableArr4 = new Closeable[l];
                                        closeableArr4[c2] = this.f62324j;
                                        com.ss.android.socialbase.downloader.i.f.a(closeableArr4);
                                        throw th6;
                                    }
                                }
                                if (com.ss.android.socialbase.downloader.c.a.a()) {
                                    e.printStackTrace();
                                }
                                this.f62325k = e;
                                throw e;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            j3 = a3;
                            j2 = l;
                            if (z6) {
                            }
                            com.ss.android.socialbase.downloader.c.a.d(f62316b, "handleResponse: e = " + th);
                            if (!f()) {
                            }
                        }
                    }
                    com.ss.android.socialbase.downloader.f.a a4 = bVar.a();
                    if (z) {
                        this.A += System.nanoTime() - j7;
                    }
                    int i4 = a4.f62352c;
                    if (i4 == i2) {
                        j3 = a3;
                        j2 = l;
                    } else {
                        if (this.f62317c.isIgnoreDataVerify()) {
                            j3 = a3;
                            j2 = l;
                        } else {
                            j2 = l;
                            try {
                                if (this.r > this.o - this.p) {
                                    j3 = a3;
                                    try {
                                        j2 = j2;
                                        if (this.r < (this.o - this.p) + i4) {
                                            i4 = (int) (this.r - (this.o - this.p));
                                            j2 = j2;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        if (z6) {
                                            ((com.ss.android.socialbase.downloader.network.a) this.f62320f).a(th);
                                        }
                                        com.ss.android.socialbase.downloader.c.a.d(f62316b, "handleResponse: e = " + th);
                                        if (!f()) {
                                            com.ss.android.socialbase.downloader.network.i iVar5 = this.f62320f;
                                            if (iVar5 != null) {
                                                iVar5.d();
                                            }
                                            if (bVar != null) {
                                                bVar.b();
                                            }
                                            try {
                                                if (this.s) {
                                                    synchronized (this.n) {
                                                        if (!this.m) {
                                                            a(this.f62322h);
                                                            if (this.f62324j != null) {
                                                                h();
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    a(this.f62322h);
                                                    if (this.f62324j != null) {
                                                        h();
                                                    }
                                                }
                                                Closeable[] closeableArr5 = new Closeable[l];
                                                closeableArr5[c2] = this.f62324j;
                                                com.ss.android.socialbase.downloader.i.f.a(closeableArr5);
                                                this.D = System.nanoTime() - nanoTime;
                                                aVar2 = this.t;
                                                downloadInfo2 = this.f62317c;
                                                str2 = this.f62318d;
                                                iVar2 = this.f62320f;
                                                z4 = this.l;
                                                z3 = this.m;
                                                com.ss.android.socialbase.downloader.d.a.a(aVar2, downloadInfo2, str2, iVar2, z4, z3, this.f62325k, this.o - this.p, this.D, z, this.A, this.B, this.C, null);
                                                return;
                                            } catch (Throwable th9) {
                                                Closeable[] closeableArr6 = new Closeable[l];
                                                closeableArr6[c2] = this.f62324j;
                                                com.ss.android.socialbase.downloader.i.f.a(closeableArr6);
                                                throw th9;
                                            }
                                        }
                                        if (com.ss.android.socialbase.downloader.c.a.a()) {
                                            th.printStackTrace();
                                        }
                                        try {
                                            com.ss.android.socialbase.downloader.i.f.a(th, "ResponseHandler");
                                            com.ss.android.socialbase.downloader.network.i iVar6 = this.f62320f;
                                            if (iVar6 != null) {
                                                iVar6.d();
                                            }
                                            if (bVar != null) {
                                                bVar.b();
                                            }
                                            try {
                                                if (this.s) {
                                                    synchronized (this.n) {
                                                        if (!this.m) {
                                                            a(this.f62322h);
                                                            if (this.f62324j != null) {
                                                                h();
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    a(this.f62322h);
                                                    if (this.f62324j != null) {
                                                        h();
                                                    }
                                                }
                                                Closeable[] closeableArr7 = new Closeable[l];
                                                closeableArr7[c2] = this.f62324j;
                                                com.ss.android.socialbase.downloader.i.f.a(closeableArr7);
                                                this.D = System.nanoTime() - nanoTime;
                                                aVar = this.t;
                                                downloadInfo = this.f62317c;
                                                str = this.f62318d;
                                                iVar = this.f62320f;
                                                z2 = this.l;
                                                c3 = l;
                                                j4 = j2;
                                                com.ss.android.socialbase.downloader.d.a.a(aVar, downloadInfo, str, iVar, z2, this.m, this.f62325k, this.o - this.p, this.D, z, this.A, this.B, this.C, null);
                                                if (this.f62317c.isIgnoreDataVerify()) {
                                                }
                                            } catch (Throwable th10) {
                                                Closeable[] closeableArr8 = new Closeable[l];
                                                closeableArr8[c2] = this.f62324j;
                                                com.ss.android.socialbase.downloader.i.f.a(closeableArr8);
                                                throw th10;
                                            }
                                        } catch (BaseException e7) {
                                            this.f62325k = e7;
                                            throw e7;
                                        }
                                    }
                                } else {
                                    j3 = a3;
                                    j2 = j2;
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                j3 = a3;
                            }
                        }
                        if (z) {
                            j7 = System.nanoTime();
                        }
                        this.f62324j.a(a4.a, 0, i4);
                        if (z) {
                            this.B += System.nanoTime() - j7;
                        }
                        bVar.a(a4);
                        long j10 = i4;
                        this.o += j10;
                        j8 += j10;
                        synchronized (this.n) {
                            try {
                                if (this.s) {
                                    if (!this.m) {
                                        boolean b2 = this.n.b(j10);
                                        a(this.f62322h);
                                        a(b2);
                                    }
                                } else {
                                    boolean b3 = this.n.b(j10);
                                    a(this.f62322h);
                                    a(b3);
                                }
                            } finally {
                                th = th;
                                while (true) {
                                    try {
                                        break;
                                    } catch (Throwable th12) {
                                        th = th12;
                                    }
                                }
                            }
                        }
                        if (this.f62317c.isDownloadWithWifiValid()) {
                            if (this.f62317c.isPauseReserveWithWifiValid()) {
                                if (this.f62317c.isIgnoreDataVerify() || this.r < 0 || this.r > this.o - this.p) {
                                    try {
                                        if (this.a && j8 > j6) {
                                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                            if (currentTimeMillis2 < j5) {
                                                try {
                                                    Thread.sleep(j5 - currentTimeMillis2);
                                                } catch (InterruptedException e8) {
                                                    e8.printStackTrace();
                                                }
                                            }
                                            currentTimeMillis = System.currentTimeMillis();
                                            j8 = 0;
                                        }
                                        z5 = z;
                                        a3 = j3;
                                        l = j2;
                                        i2 = -1;
                                        i3 = 1;
                                    } catch (BaseException e9) {
                                        e = e9;
                                        com.ss.android.socialbase.downloader.c.a.d(f62316b, "handleResponse: BaseException e = " + e);
                                        if (!this.t.a("ignore_base_ex_on_stop_status")) {
                                        }
                                        if (com.ss.android.socialbase.downloader.c.a.a()) {
                                        }
                                        this.f62325k = e;
                                        throw e;
                                    } catch (Throwable th13) {
                                        th = th13;
                                        if (z6) {
                                        }
                                        com.ss.android.socialbase.downloader.c.a.d(f62316b, "handleResponse: e = " + th);
                                        if (!f()) {
                                        }
                                    }
                                }
                            } else {
                                throw new com.ss.android.socialbase.downloader.exception.e();
                            }
                        } else {
                            throw new com.ss.android.socialbase.downloader.exception.c();
                        }
                    }
                    com.ss.android.socialbase.downloader.network.i iVar7 = this.f62320f;
                    if (iVar7 != null) {
                        iVar7.d();
                    }
                    if (bVar != null) {
                        bVar.b();
                    }
                    try {
                        if (this.s) {
                            synchronized (this.n) {
                                if (!this.m) {
                                    a(this.f62322h);
                                    if (this.f62324j != null) {
                                        h();
                                    }
                                }
                            }
                        } else {
                            a(this.f62322h);
                            if (this.f62324j != null) {
                                h();
                            }
                        }
                        com.ss.android.socialbase.downloader.i.f.a(this.f62324j);
                        this.D = System.nanoTime() - nanoTime;
                        aVar = this.t;
                        downloadInfo = this.f62317c;
                        str = this.f62318d;
                        iVar = this.f62320f;
                        c2 = 0;
                        z2 = this.l;
                        c3 = 1;
                        j4 = j2;
                        com.ss.android.socialbase.downloader.d.a.a(aVar, downloadInfo, str, iVar, z2, this.m, this.f62325k, this.o - this.p, this.D, z, this.A, this.B, this.C, null);
                        if (this.f62317c.isIgnoreDataVerify()) {
                            long j11 = this.o - this.p;
                            if (j11 < 0 || this.r < 0 || this.r == j11) {
                                return;
                            }
                            Object[] objArr = new Object[7];
                            objArr[c2] = Long.valueOf(j11);
                            objArr[c3] = Long.valueOf(j3);
                            objArr[2] = Long.valueOf(this.r);
                            objArr[3] = Long.valueOf(j4);
                            objArr[4] = Long.valueOf(this.q);
                            objArr[5] = Long.valueOf(this.o);
                            objArr[6] = Long.valueOf(this.p);
                            throw new BaseException(1051, String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", objArr));
                        }
                        return;
                    } catch (Throwable th14) {
                        com.ss.android.socialbase.downloader.i.f.a(this.f62324j);
                        throw th14;
                    }
                }
                com.ss.android.socialbase.downloader.network.i iVar8 = this.f62320f;
                if (iVar8 != null) {
                    iVar8.d();
                }
                if (bVar != null) {
                    bVar.b();
                }
                try {
                    if (this.s) {
                        synchronized (this.n) {
                            if (!this.m) {
                                a(this.f62322h);
                                if (this.f62324j != null) {
                                    h();
                                }
                            }
                        }
                    } else {
                        a(this.f62322h);
                        if (this.f62324j != null) {
                            h();
                        }
                    }
                    Closeable[] closeableArr9 = new Closeable[i3];
                    closeableArr9[0] = this.f62324j;
                    com.ss.android.socialbase.downloader.i.f.a(closeableArr9);
                    this.D = System.nanoTime() - nanoTime;
                    aVar2 = this.t;
                    downloadInfo2 = this.f62317c;
                    str2 = this.f62318d;
                    iVar2 = this.f62320f;
                    z4 = this.l;
                    z = z5;
                    z3 = this.m;
                    com.ss.android.socialbase.downloader.d.a.a(aVar2, downloadInfo2, str2, iVar2, z4, z3, this.f62325k, this.o - this.p, this.D, z, this.A, this.B, this.C, null);
                    return;
                } catch (Throwable th15) {
                    Closeable[] closeableArr10 = new Closeable[i3];
                    closeableArr10[0] = this.f62324j;
                    com.ss.android.socialbase.downloader.i.f.a(closeableArr10);
                    throw th15;
                }
            }
            throw new BaseException((int) BeanConstants.BEAN_ID_FOR_BACKUP_INIT, new IOException("inputStream is null"));
        }
        throw new com.ss.android.socialbase.downloader.exception.f(1004, "the content-length is 0");
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.E : invokeV.longValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : invokeV.longValue;
    }

    public void a(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            this.o = j2;
            this.p = j2;
            this.q = j3;
            this.r = j4;
        }
    }

    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.q = j2;
            this.r = j3;
        }
    }

    private com.ss.android.socialbase.downloader.e.b a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, inputStream)) == null) {
            int H = c.H();
            if (this.t.a("rw_concurrent", 0) == 1 && this.f62317c.getChunkCount() == 1 && this.f62317c.getTotalBytes() > DownloadManager.MIN_LEFT_SIZE) {
                try {
                    com.ss.android.socialbase.downloader.e.a aVar = new com.ss.android.socialbase.downloader.e.a(inputStream, H, this.t.a("rw_concurrent_max_buffer_count", 4));
                    this.z = true;
                    return aVar;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            com.ss.android.socialbase.downloader.e.c cVar = new com.ss.android.socialbase.downloader.e.c(inputStream, H);
            this.z = false;
            return cVar;
        }
        return (com.ss.android.socialbase.downloader.e.b) invokeL.objValue;
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j2 = uptimeMillis - this.F;
            if (this.v) {
                if (j2 > (this.u.b() ? this.w : this.x)) {
                    h();
                    this.F = uptimeMillis;
                    return;
                }
                return;
            }
            long j3 = this.o - this.E;
            if (z || b(j3, j2)) {
                h();
                this.F = uptimeMillis;
            }
        }
    }

    private void a(j jVar) {
        com.ss.android.socialbase.downloader.model.b bVar;
        com.ss.android.socialbase.downloader.model.b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jVar) == null) || jVar == null) {
            return;
        }
        m mVar = null;
        boolean z = jVar instanceof com.ss.android.socialbase.downloader.b.e;
        if (z && (mVar = com.ss.android.socialbase.downloader.impls.l.a(com.ss.android.socialbase.downloader.i.f.b())) == null) {
            return;
        }
        m mVar2 = mVar;
        if (this.f62319e.d()) {
            bVar = this.f62319e.e();
        } else {
            bVar = this.f62319e;
        }
        com.ss.android.socialbase.downloader.model.b bVar3 = bVar;
        if (bVar3 != null) {
            bVar3.b(this.o);
            if (z && mVar2 != null) {
                mVar2.a(bVar3.k(), bVar3.s(), bVar3.b(), this.o);
                bVar2 = bVar3;
            } else {
                bVar2 = bVar3;
                jVar.a(bVar3.k(), bVar3.s(), bVar3.b(), this.o);
            }
            if (bVar2.h()) {
                boolean z2 = false;
                if (bVar2.i()) {
                    long j2 = bVar2.j();
                    if (j2 > this.o) {
                        if (z && mVar2 != null) {
                            mVar2.a(bVar2.k(), bVar2.b(), j2);
                        } else {
                            jVar.a(bVar2.k(), bVar2.b(), j2);
                        }
                        z2 = true;
                    }
                }
                if (z2) {
                    return;
                }
                if (z && mVar2 != null) {
                    mVar2.a(bVar2.k(), bVar2.b(), this.o);
                } else {
                    jVar.a(bVar2.k(), bVar2.b(), this.o);
                }
            }
        } else if (this.f62319e.d()) {
            if (z && mVar2 != null) {
                mVar2.a(this.f62319e.k(), this.f62319e.s(), this.o);
            } else {
                jVar.a(this.f62319e.k(), this.f62319e.s(), this.o);
            }
        }
    }
}
