package d.l.a.e.b.k;

import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.constants.DebugConstants;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.b;
import com.ss.android.socialbase.downloader.network.l;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import d.l.a.e.b.f.m;
import d.l.a.e.b.f.t;
import d.l.a.e.b.f.x;
import d.l.a.e.b.f.y;
import d.l.a.e.b.f.z;
import d.l.a.e.b.g.s;
import d.l.a.e.b.i.j;
import d.l.a.e.b.m.p;
import d.l.a.e.b.m.q;
import d.l.a.e.b.o.i;
import d.l.a.e.b.o.k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c implements f, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final String O;
    public transient /* synthetic */ FieldHolder $fh;
    public k A;
    public i B;
    public x C;
    public t D;
    public volatile int E;
    public boolean F;
    public boolean G;
    public String H;
    public boolean I;
    public long J;
    public long K;
    public final d.l.a.e.b.j.a L;
    public int M;
    public volatile j N;

    /* renamed from: e  reason: collision with root package name */
    public Future f74839e;

    /* renamed from: f  reason: collision with root package name */
    public final d.l.a.e.b.n.a f74840f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f74841g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f74842h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<d.l.a.e.b.k.b> f74843i;
    public volatile d.l.a.e.b.g.g j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final AtomicBoolean p;
    public volatile com.ss.android.socialbase.downloader.constants.i q;
    public final d.l.a.e.b.g.k r;
    public DownloadInfo s;
    public d.l.a.e.b.g.j t;
    public final d.l.a.e.b.g.j u;
    public d.l.a.e.b.g.i v;
    public final d.l.a.e.b.g.i w;
    public s x;
    public final d.l.a.e.b.g.h y;
    public volatile BaseException z;

    /* loaded from: classes10.dex */
    public class a extends m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f74844b;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74844b = cVar;
        }

        @Override // d.l.a.e.b.f.m, d.l.a.e.b.f.w
        public void a(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                super.a(list);
                this.f74844b.I(list);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements d.l.a.e.b.f.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f74845a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f74846b;

        public b(c cVar, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74846b = cVar;
            this.f74845a = atomicBoolean;
        }

        @Override // d.l.a.e.b.f.s
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f74846b) {
                    this.f74845a.set(true);
                    this.f74846b.s();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1799718235, "Ld/l/a/e/b/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1799718235, "Ld/l/a/e/b/k/c;");
                return;
            }
        }
        O = c.class.getSimpleName();
    }

    public c(d.l.a.e.b.n.a aVar, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f74841g = false;
        this.f74843i = new ArrayList<>();
        this.q = com.ss.android.socialbase.downloader.constants.i.f41469a;
        this.E = 5;
        this.F = false;
        this.G = false;
        this.I = false;
        this.M = 0;
        this.N = null;
        this.f74840f = aVar;
        if (aVar != null) {
            this.s = aVar.J();
            this.t = aVar.D();
            this.v = aVar.C();
            this.C = aVar.O();
            this.D = aVar.F();
            this.x = v(aVar);
            this.L = d.l.a.e.b.j.a.d(this.s.getId());
        } else {
            this.L = d.l.a.e.b.j.a.r();
        }
        V();
        this.r = d.l.a.e.b.g.e.M0();
        this.u = d.l.a.e.b.g.e.i();
        this.w = d.l.a.e.b.g.e.k();
        this.y = new d.l.a.e.b.g.h(aVar, handler);
        this.p = new AtomicBoolean(true);
    }

    public static com.ss.android.socialbase.downloader.model.b w(DownloadInfo downloadInfo, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65540, null, downloadInfo, j)) == null) {
            b.C0550b c0550b = new b.C0550b(downloadInfo.getId());
            c0550b.b(-1);
            c0550b.c(0L);
            c0550b.m(j);
            c0550b.g(j);
            c0550b.i(0L);
            c0550b.k(downloadInfo.getTotalBytes() - j);
            return c0550b.e();
        }
        return (com.ss.android.socialbase.downloader.model.b) invokeLJ.objValue;
    }

    public final void A(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, list) == null) {
            if (list.size() == i2) {
                J(list, this.s.getTotalBytes());
                return;
            }
            throw new BaseException((int) DebugConstants.HTTP_ERRCODE_VERSION_HIGH, new IllegalArgumentException());
        }
    }

    public final void B(long j, int i2) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            long j2 = j / i2;
            int id = this.s.getId();
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            long j3 = 0;
            while (i3 < i2) {
                long j4 = i3 == i2 + (-1) ? 0L : (j3 + j2) - 1;
                b.C0550b c0550b = new b.C0550b(id);
                c0550b.b(i3);
                c0550b.c(j3);
                c0550b.m(j3);
                c0550b.g(j3);
                c0550b.i(j4);
                com.ss.android.socialbase.downloader.model.b e2 = c0550b.e();
                arrayList.add(e2);
                this.r.a(e2);
                j3 += j2;
                i3++;
            }
            this.s.setChunkCount(i2);
            this.r.a(id, i2);
            J(arrayList, j);
        }
    }

    public final void E(com.ss.android.socialbase.downloader.model.b bVar, String str, k kVar) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bVar, str, kVar) == null) {
            bVar.a(this.s.getTotalBytes() - bVar.n());
            this.s.setChunkCount(1);
            this.r.a(this.s.getId(), 1);
            this.j = new d.l.a.e.b.g.g(this.s, str, kVar, bVar, this);
            h0();
        }
    }

    public final void F(String str, String str2) throws com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.r.d(this.s.getId());
            this.r.m(this.s.getId());
            d.l.a.e.b.l.f.w(this.s);
            this.l = false;
            this.s.resetDataForEtagEndure(str);
            this.r.a(this.s);
            throw new com.ss.android.socialbase.downloader.exception.i(str2);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    public final void G(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) && this.A == null) {
            d.l.a.e.b.o.b.d f2 = this.s.getChunkCount() == 1 ? d.l.a.e.b.o.b.a.a().f(str, list) : null;
            try {
                if (f2 != null) {
                    e(this.A);
                    this.s.setPreconnectLevel(2);
                    this.A = f2;
                } else {
                    try {
                        k A = d.l.a.e.b.g.e.A(this.s.isNeedDefaultHttpServiceBackUp(), this.s.getMaxBytes(), str, null, list, this.L.m("net_lib_strategy"), this.L.b("monitor_download_connect", 0) > 0, this.s);
                        this.A = A;
                        e(A);
                    } catch (BaseException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        if (this.s.isExpiredRedownload() && d.l.a.e.b.l.f.S0(th) && d.l.a.e.b.l.f.x0(list)) {
                            d.l.a.e.b.c.a.g(O, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.s.getCacheControl());
                            long W0 = d.l.a.e.b.l.f.W0(this.s.getCacheControl());
                            if (W0 <= 0) {
                                W0 = d.l.a.e.b.j.a.d(this.s.getId()).b("default_304_max_age", 300);
                            }
                            this.s.setCacheExpiredTime(System.currentTimeMillis() + (W0 * 1000));
                            throw new com.ss.android.socialbase.downloader.exception.a(this.H);
                        } else if (!d.l.a.e.b.l.f.P0(th)) {
                            if (d.l.a.e.b.l.f.L0(th)) {
                                F("", "http code 412");
                                throw null;
                            } else {
                                d.l.a.e.b.l.f.B(th, "CreateFirstConnection");
                                throw null;
                            }
                        } else {
                            F("", "http code 416");
                            throw null;
                        }
                    }
                }
                if (this.A == null) {
                    throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
                }
            } catch (Throwable th2) {
                e(this.A);
                throw th2;
            }
        }
    }

    public final void H(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, list, Long.valueOf(j)}) == null) {
            N(str, list, j);
            i iVar = this.B;
            if (iVar != null) {
                try {
                    d(str, iVar, j);
                } catch (Throwable unused) {
                    this.G = true;
                }
            }
            if (this.B == null || this.G) {
                G(str, list);
                d(str, this.A, j);
            }
        }
    }

    public final void I(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.s.setForbiddenBackupUrls(list, this.q == com.ss.android.socialbase.downloader.constants.i.f41475g);
        d.l.a.e.b.m.a c2 = d.l.a.e.b.g.e.c();
        if (c2 != null) {
            c2.Q(this.s.getId());
        }
    }

    public final void J(List<com.ss.android.socialbase.downloader.model.b> list, long j) throws BaseException {
        long p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, list, j) == null) {
            for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                if (bVar != null) {
                    if (bVar.p() == 0) {
                        p = j - bVar.n();
                    } else {
                        p = (bVar.p() - bVar.n()) + 1;
                    }
                    if (p > 0) {
                        bVar.a(p);
                        if (this.s.isNeedReuseFirstConnection() && this.A != null && (!this.s.isHeadConnectionAvailable() || this.G)) {
                            if (bVar.s() == 0) {
                                this.f74843i.add(new d.l.a.e.b.k.b(bVar, this.f74840f, this.A, this));
                            } else if (bVar.s() > 0) {
                                this.f74843i.add(new d.l.a.e.b.k.b(bVar, this.f74840f, this));
                            }
                        } else {
                            this.f74843i.add(new d.l.a.e.b.k.b(bVar, this.f74840f, this));
                        }
                    }
                }
            }
            if (d.l.a.e.b.l.a.a(64)) {
                ArrayList arrayList = new ArrayList(this.f74843i.size());
                Iterator<d.l.a.e.b.k.b> it = this.f74843i.iterator();
                while (it.hasNext()) {
                    d.l.a.e.b.k.b next = it.next();
                    if (this.q == com.ss.android.socialbase.downloader.constants.i.f41471c) {
                        next.e();
                    } else if (this.q == com.ss.android.socialbase.downloader.constants.i.f41470b) {
                        next.a();
                    } else {
                        arrayList.add(next);
                    }
                }
                try {
                    List<Future> W = d.l.a.e.b.m.e.W(arrayList);
                    for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = d.l.a.e.b.m.e.X(W)) {
                        if (j0()) {
                            return;
                        }
                        runnable.run();
                    }
                    if (W == null || W.isEmpty()) {
                        return;
                    }
                    for (Future future : W) {
                        if (future != null && !future.isDone()) {
                            try {
                                future.get();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
            ArrayList arrayList2 = new ArrayList(this.f74843i.size());
            Iterator<d.l.a.e.b.k.b> it2 = this.f74843i.iterator();
            while (it2.hasNext()) {
                d.l.a.e.b.k.b next2 = it2.next();
                if (this.q == com.ss.android.socialbase.downloader.constants.i.f41471c) {
                    next2.e();
                } else if (this.q == com.ss.android.socialbase.downloader.constants.i.f41470b) {
                    next2.a();
                } else {
                    arrayList2.add(Executors.callable(next2));
                }
            }
            if (j0()) {
                return;
            }
            try {
                d.l.a.e.b.m.e.V(arrayList2);
            } catch (InterruptedException e2) {
                throw new BaseException(1020, e2);
            }
        }
    }

    public void K(Future future) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, future) == null) {
            this.f74839e = future;
        }
    }

    public final boolean L(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, str, str2)) == null) {
            if (i2 == 412) {
                return true;
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.n || this.m)) {
                return (i2 == 201 || i2 == 416) && this.s.getCurBytes() > 0;
            }
            return true;
        }
        return invokeILL.booleanValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.q = com.ss.android.socialbase.downloader.constants.i.f41471c;
            if (this.N != null) {
                this.N.r();
            }
            if (this.j != null) {
                this.j.j();
            }
            if (this.N == null && this.j == null) {
                g0();
                this.q = com.ss.android.socialbase.downloader.constants.i.f41471c;
                d0();
            }
            r();
        }
    }

    public final void N(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        d.l.a.e.b.o.b.c b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, list, Long.valueOf(j)}) == null) {
            boolean z = true;
            if (this.s.getChunkCount() == 1 && (b2 = d.l.a.e.b.o.b.a.a().b(str, list)) != null) {
                this.B = b2;
                this.s.setPreconnectLevel(1);
            }
            if (this.B == null && !this.G && this.s.isHeadConnectionAvailable()) {
                try {
                    int m = this.L.m("net_lib_strategy");
                    if (this.L.b("monitor_download_connect", 0) <= 0) {
                        z = false;
                    }
                    this.B = d.l.a.e.b.g.e.y(str, list, m, z, this.s);
                } catch (Throwable th) {
                    this.s.setHeadConnectionException(d.l.a.e.b.l.f.a1(th));
                }
            }
        }
    }

    public d.l.a.e.b.n.a O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f74840f : (d.l.a.e.b.n.a) invokeV.objValue;
    }

    public void P(long j) {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048589, this, j) == null) && (kVar = this.A) != null && (kVar instanceof d.l.a.e.b.o.c)) {
            try {
                ((d.l.a.e.b.o.c) kVar).a(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.p.get() : invokeV.booleanValue;
    }

    public final boolean R(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, baseException)) == null) {
            AtomicInteger atomicInteger = this.f74842h;
            boolean z = true;
            if (atomicInteger != null) {
                if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                    if (this.s.trySwitchToNextBackupUrl()) {
                        this.f74842h.set(this.s.getBackUpUrlRetryCount());
                        this.s.updateCurRetryTime(this.f74842h.get());
                    } else if (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.s.canReplaceHttpForRetry())) {
                        this.f74842h.set(this.s.getRetryCount());
                        this.s.updateCurRetryTime(this.f74842h.get());
                        this.s.setHttpsToHttpRetryUsed(true);
                    } else {
                        g(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.f74842h), String.valueOf(this.s.getRetryCount()), baseException.getErrorMessage())));
                        return true;
                    }
                    z = false;
                }
                if (this.q != com.ss.android.socialbase.downloader.constants.i.f41474f && z) {
                    this.s.updateCurRetryTime(this.f74842h.decrementAndGet());
                }
                return false;
            }
            g(new BaseException((int) SDKLogTypeConstants.TYPE_NATIVE_CPU_CLICK, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
            return true;
        }
        return invokeL.booleanValue;
    }

    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            DownloadInfo downloadInfo = this.s;
            if (downloadInfo != null) {
                return downloadInfo.getId();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.K = System.currentTimeMillis();
            this.y.b();
        }
    }

    public Future U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f74839e : (Future) invokeV.objValue;
    }

    public final void V() {
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (downloadInfo = this.s) == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.s.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.f74842h;
        if (atomicInteger == null) {
            this.f74842h = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    public final boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int status = this.s.getStatus();
            if (status == 1 || this.s.canSkipStatusHandler()) {
                return true;
            }
            if (status == -2 || status == -4) {
                return false;
            }
            g(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x00f9, code lost:
        if (r9.L.l("fix_file_exist_update_download_info") != false) goto L89;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af A[Catch: all -> 0x00ee, TryCatch #10 {all -> 0x00ee, blocks: (B:58:0x00ab, B:60:0x00af, B:62:0x00b3, B:75:0x00ed), top: B:96:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X() throws com.ss.android.socialbase.downloader.exception.a {
        Throwable th;
        com.ss.android.socialbase.downloader.exception.a e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            boolean z = false;
            boolean z2 = true;
            try {
                try {
                    try {
                        int id = this.s.getId();
                        if (this.r != null) {
                            if (d.l.a.e.b.l.a.a(2048)) {
                                this.r.e();
                            }
                            DownloadInfo b2 = this.r.b(id);
                            if (b2 != null && !b2.isNewTask()) {
                                String savePath = this.s.getSavePath();
                                String md5 = this.s.getMd5();
                                this.s.copyFromCacheData(b2, true);
                                boolean z3 = d.l.a.e.b.l.a.a(4096) && b2 != this.s;
                                try {
                                    if (savePath.equals(b2.getSavePath()) && d.l.a.e.b.l.f.M(b2, false, md5)) {
                                        try {
                                            throw new com.ss.android.socialbase.downloader.exception.a(b2.getName());
                                        } catch (com.ss.android.socialbase.downloader.exception.a e3) {
                                            throw e3;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            z = z3;
                                            if (this.f74840f != null) {
                                            }
                                            if (z) {
                                            }
                                        }
                                    } else if (d.l.a.e.b.g.e.v(b2) != id) {
                                        try {
                                            this.r.f(id);
                                        } catch (SQLiteException e4) {
                                            e4.printStackTrace();
                                        }
                                    } else {
                                        z2 = z3;
                                    }
                                } catch (com.ss.android.socialbase.downloader.exception.a e5) {
                                    e2 = e5;
                                    throw e2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    z = z3;
                                    z2 = false;
                                    if (this.f74840f != null) {
                                        d.l.a.e.b.e.a.e(this.f74840f.R(), this.s, new BaseException(1003, d.l.a.e.b.l.f.a0(th, "checkTaskCache")), this.s.getStatus());
                                    }
                                    if (z) {
                                    }
                                }
                            }
                            this.s.reset();
                        } else {
                            z2 = false;
                        }
                        try {
                            V();
                        } catch (com.ss.android.socialbase.downloader.exception.a e6) {
                            e2 = e6;
                            throw e2;
                        } catch (Throwable th4) {
                            th = th4;
                            z = z2;
                            z2 = false;
                            if (this.f74840f != null && this.s != null) {
                                d.l.a.e.b.e.a.e(this.f74840f.R(), this.s, new BaseException(1003, d.l.a.e.b.l.f.a0(th, "checkTaskCache")), this.s.getStatus());
                            }
                            if (z) {
                                if (!z2 || this.L.l("fix_file_exist_update_download_info")) {
                                    this.r.a(this.s);
                                }
                            }
                            return;
                        }
                    } catch (SQLiteException e7) {
                        e7.printStackTrace();
                        return;
                    }
                } catch (com.ss.android.socialbase.downloader.exception.a e8) {
                    e2 = e8;
                } catch (Throwable th5) {
                    th = th5;
                }
                if (z2) {
                    this.r.a(this.s);
                }
            } catch (Throwable th6) {
                if (0 != 0) {
                    if (1 != 0) {
                        try {
                        } catch (SQLiteException e9) {
                            e9.printStackTrace();
                        }
                    }
                    this.r.a(this.s);
                }
                throw th6;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e A[LOOP:0: B:26:0x005e->B:60:0x005e, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048598, this) != null) {
            return;
        }
        Process.setThreadPriority(10);
        try {
            if (this.s != null && this.K > 0) {
                this.s.increaseDownloadPrepareTime(System.currentTimeMillis() - this.K);
            }
        } catch (Throwable unused) {
        }
        try {
            y Q = this.f74840f.Q();
            if (Q != null) {
                if (Q.a()) {
                    this.y.v();
                    return;
                }
            }
        } finally {
            if (W()) {
            }
        }
        if (W()) {
            z R = this.f74840f.R();
            DownloadInfo downloadInfo = this.s;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo2 = this.s;
            d.l.a.e.b.e.a.e(R, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            return;
        }
        while (true) {
            Z();
            if (!this.F) {
                return;
            }
            if (this.E > 0) {
                this.E--;
            } else if (this.s.getCurBytes() != this.s.getTotalBytes()) {
                d.l.a.e.b.c.a.g(O, this.s.getErrorBytesLog());
                this.y.g(new com.ss.android.socialbase.downloader.exception.f(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.s.getByteInvalidRetryStatus()));
                return;
            } else if (this.s.getCurBytes() <= 0) {
                d.l.a.e.b.c.a.g(O, this.s.getErrorBytesLog());
                this.y.g(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes invalid retry status is : " + this.s.getByteInvalidRetryStatus()));
                return;
            } else if (this.s.getTotalBytes() <= 0) {
                d.l.a.e.b.c.a.g(O, this.s.getErrorBytesLog());
                this.y.g(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.s.getByteInvalidRetryStatus()));
                return;
            }
        }
    }

    public final void Z() {
        boolean z;
        List<com.ss.android.socialbase.downloader.model.b> c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            try {
                this.q = com.ss.android.socialbase.downloader.constants.i.f41469a;
                this.s.updateStartDownloadTime();
                this.s.resetRealStartDownloadTime();
                long currentTimeMillis = System.currentTimeMillis();
                this.s.setFirstSpeedTime(-1L);
                try {
                    X();
                    z = false;
                } catch (com.ss.android.socialbase.downloader.exception.a e2) {
                    String str = O;
                    d.l.a.e.b.c.a.g(str, "file exist " + e2.a());
                    this.H = e2.a();
                    z = true;
                }
                if (!this.F) {
                    this.y.n();
                }
                this.F = false;
                if (j0()) {
                    return;
                }
                if (!TextUtils.isEmpty(this.H) && z) {
                    if (this.s.isExpiredRedownload()) {
                        this.I = d.l.a.e.b.l.f.D0(this.s);
                    }
                    if (!this.I) {
                        a0();
                        return;
                    }
                }
                while (!j0()) {
                    try {
                        try {
                            try {
                                o();
                                k();
                                n();
                                c2 = this.r.c(this.s.getId());
                                p();
                            } catch (BaseException e3) {
                                String str2 = O;
                                d.l.a.e.b.c.a.j(str2, "downloadInner: baseException = " + e3);
                                if (this.q != com.ss.android.socialbase.downloader.constants.i.f41470b) {
                                    if (e3.getErrorCode() != 1025 && e3.getErrorCode() != 1009) {
                                        if (a(e3)) {
                                            if (d.l.a.e.b.l.f.K(e3)) {
                                                q();
                                            }
                                            if (h(e3, 0L) != com.ss.android.socialbase.downloader.exception.h.f41524a) {
                                                g0();
                                            } else {
                                                g0();
                                                return;
                                            }
                                        } else {
                                            g(e3);
                                        }
                                    }
                                    this.q = com.ss.android.socialbase.downloader.constants.i.f41473e;
                                    g0();
                                    return;
                                }
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.a unused) {
                            a0();
                        }
                    } catch (com.ss.android.socialbase.downloader.exception.i e4) {
                        String str3 = O;
                        d.l.a.e.b.c.a.j(str3, "downloadInner: retry throwable for " + e4.a());
                        if (this.q != com.ss.android.socialbase.downloader.constants.i.f41470b) {
                            if (this.f74842h != null && this.f74842h.get() > 0) {
                                this.s.updateCurRetryTime(this.f74842h.decrementAndGet());
                                this.s.setStatus(5);
                            } else if (this.f74842h != null) {
                                if (this.s.trySwitchToNextBackupUrl()) {
                                    this.s.setStatus(5);
                                    this.f74842h.set(this.s.getRetryCount());
                                    this.s.updateCurRetryTime(this.f74842h.get());
                                } else {
                                    g(new BaseException(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.s.getRetryCount()), e4.a())));
                                }
                            } else {
                                g(new BaseException((int) SDKLogTypeConstants.TYPE_NATIVE_CPU_CLICK, "retry for Throwable, but retain retry time is NULL, last error is" + e4.a()));
                            }
                            g0();
                        }
                    } catch (Throwable th) {
                        String str4 = O;
                        d.l.a.e.b.c.a.j(str4, "downloadInner: throwable =  " + th);
                        if (this.q != com.ss.android.socialbase.downloader.constants.i.f41470b) {
                            g(new BaseException(1045, th));
                        }
                    }
                    if (b0()) {
                        d.l.a.e.b.c.a.i(O, "downloadSegments return");
                        g0();
                        return;
                    }
                    String connectionUrl = this.s.getConnectionUrl();
                    if (j0()) {
                        g0();
                        return;
                    }
                    long G0 = this.l ? d.l.a.e.b.l.f.G0(this.s) : 0L;
                    com.ss.android.socialbase.downloader.model.b w = w(this.s, G0);
                    List<com.ss.android.socialbase.downloader.model.c> y = y(w);
                    d.l.a.e.b.l.f.C(y, this.s);
                    d.l.a.e.b.l.f.d0(y, this.s);
                    this.s.setPreconnectLevel(0);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    try {
                        H(connectionUrl, y, G0);
                        this.s.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                        if (j0()) {
                            g0();
                            return;
                        }
                        long totalBytes = this.s.getTotalBytes();
                        a(totalBytes);
                        int u = u(totalBytes, c2);
                        if (j0()) {
                            g0();
                            return;
                        } else if (u > 0) {
                            boolean z2 = u == 1;
                            this.k = z2;
                            if (z2) {
                                if (this.A == null) {
                                    try {
                                        currentTimeMillis2 = System.currentTimeMillis();
                                        G(connectionUrl, y);
                                        this.s.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                                    } finally {
                                    }
                                }
                                if (j0()) {
                                    g0();
                                    return;
                                }
                                this.s.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                                c0();
                                E(w, connectionUrl, this.A);
                            } else {
                                if (!this.s.isNeedReuseFirstConnection()) {
                                    f0();
                                }
                                if (j0()) {
                                    g0();
                                    return;
                                }
                                c0();
                                this.s.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                                if (this.l) {
                                    A(u, c2);
                                } else {
                                    B(totalBytes, u);
                                }
                            }
                            g0();
                            return;
                        } else {
                            throw new BaseException(1032, "chunkCount is 0");
                        }
                    } finally {
                    }
                }
            } finally {
                d0();
            }
        }
    }

    @Override // d.l.a.e.b.k.f
    public void a(long j) throws BaseException {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            String tempPath = this.s.getTempPath();
            String tempName = this.s.getTempName();
            if (d.l.a.e.b.l.f.f0(j)) {
                return;
            }
            d.l.a.e.b.n.c f2 = d.l.a.e.b.l.f.f(this.s, tempPath, tempName, -1);
            try {
                long length = new File(tempPath, tempName).length();
                long j3 = j - length;
                long y0 = d.l.a.e.b.l.f.y0(tempPath);
                d.l.a.e.b.j.a d2 = d.l.a.e.b.j.a.d(this.s.getId());
                if (d2.b("space_fill_part_download", 0) == 1) {
                    this.J = 0L;
                    if (j3 <= 0) {
                        j3 = this.s.getTotalBytes() - this.s.getCurBytes();
                    }
                    if (y0 < j3) {
                        String str = O;
                        d.l.a.e.b.c.a.j(str, "checkSpaceOverflow: contentLength = " + d.l.a.e.b.l.f.a(j) + "MB, downloaded = " + d.l.a.e.b.l.f.a(length) + "MB, required = " + d.l.a.e.b.l.f.a(j3) + "MB, available = " + d.l.a.e.b.l.f.a(y0) + "MB");
                        int i2 = (y0 > 0L ? 1 : (y0 == 0L ? 0 : -1));
                        if (i2 > 0) {
                            int b2 = d2.b("space_fill_min_keep_mb", 100);
                            if (b2 > 0) {
                                j2 = y0 - (b2 * 1048576);
                                String str2 = O;
                                d.l.a.e.b.c.a.j(str2, "checkSpaceOverflow: minKeep = " + b2 + "MB, canDownload = " + d.l.a.e.b.l.f.a(j2) + "MB");
                                if (j2 > 0) {
                                    this.J = this.s.getCurBytes() + j2;
                                } else {
                                    throw new com.ss.android.socialbase.downloader.exception.d(y0, j3);
                                }
                            } else {
                                j2 = y0;
                            }
                            if (length < j) {
                                if (j2 + length > j) {
                                }
                                f2.o(j);
                                d.l.a.e.b.l.f.E(f2);
                            }
                        } else if (d2.b("download_when_space_negative", 0) != 1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("availableSpace ");
                            sb.append(i2 == 0 ? "=" : "<");
                            sb.append(" 0");
                            throw new BaseException((int) RevenueServerConst.GetChargeCouponDiscountRequest, sb.toString());
                        } else {
                            f2.o(j);
                            d.l.a.e.b.l.f.E(f2);
                        }
                    }
                } else {
                    int i3 = (y0 > 0L ? 1 : (y0 == 0L ? 0 : -1));
                    if (i3 <= 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("availableSpace ");
                        sb2.append(i3 == 0 ? "=" : "<");
                        sb2.append(" 0");
                        throw new BaseException((int) RevenueServerConst.GetChargeCouponDiscountRequest, sb2.toString());
                    } else if (y0 < j3) {
                        throw new com.ss.android.socialbase.downloader.exception.d(y0, j3);
                    }
                }
                f2.o(j);
                d.l.a.e.b.l.f.E(f2);
            } catch (Throwable th) {
                d.l.a.e.b.l.f.E(f2);
                throw th;
            }
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            d.l.a.e.b.c.a.g(O, "finishWithFileExist");
            if (d.l.a.e.b.j.a.r().q("fix_end_for_file_exist_error", true)) {
                if (this.H.equals(this.s.getName())) {
                    this.q = com.ss.android.socialbase.downloader.constants.i.f41473e;
                } else {
                    this.q = com.ss.android.socialbase.downloader.constants.i.f41476h;
                }
            } else if (this.H.equals(this.s.getTargetFilePath())) {
                this.q = com.ss.android.socialbase.downloader.constants.i.f41473e;
            } else {
                this.q = com.ss.android.socialbase.downloader.constants.i.f41476h;
            }
        }
    }

    @Override // d.l.a.e.b.k.f
    public boolean b(long j) throws BaseException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048605, this, j)) == null) {
            if (this.J > 0 && this.s.getCurBytes() > this.J) {
                m();
            }
            return this.y.k(j);
        }
        return invokeJ.booleanValue;
    }

    public final boolean b0() throws BaseException, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (!this.s.isExpiredRedownload() && this.s.getChunkCount() == 1 && this.s.getThrottleNetSpeed() <= 0) {
                JSONObject u = d.l.a.e.b.j.a.d(this.s.getId()).u("segment_config");
                List<d.l.a.e.b.i.i> n = this.r.n(this.s.getId());
                if (this.s.getCurBytes() > 0) {
                    if (n == null || n.isEmpty()) {
                        return false;
                    }
                    if (u == null) {
                        u = new JSONObject();
                    }
                }
                if (u == null) {
                    return false;
                }
                this.N = new j(this.s, d.l.a.e.b.i.m.b(u), this);
                if (j0()) {
                    d.l.a.e.b.c.a.i(O, "downloadSegments: is stopped by user");
                    if (this.q == com.ss.android.socialbase.downloader.constants.i.f41471c) {
                        this.N.r();
                    } else {
                        this.N.C();
                    }
                    return true;
                }
                return this.N.A(n);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.l.a.e.b.k.f
    public void c(d.l.a.e.b.k.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, bVar) == null) || this.k) {
            return;
        }
        synchronized (this) {
            this.f74843i.remove(bVar);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && d.l.a.e.b.j.a.d(this.s.getId()).b("reset_retain_retry_times", 0) == 1 && this.M < 3) {
            this.f74842h.set(this.s.isBackUpUrlUsed() ? this.s.getBackUpUrlRetryCount() : this.s.getRetryCount());
            this.M++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0141, code lost:
        d.l.a.e.b.l.f.w(r18.s);
     */
    @Override // d.l.a.e.b.k.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str, i iVar, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        long j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{str, iVar, Long.valueOf(j)}) == null) || iVar == null) {
            return;
        }
        try {
            d.l.a.e.b.n.b bVar = new d.l.a.e.b.n.b(str, iVar);
            int i2 = bVar.f74962c;
            String d2 = bVar.d();
            if (TextUtils.isEmpty(this.s.getMimeType()) && !TextUtils.isEmpty(d2)) {
                this.s.setMimeType(d2);
            }
            boolean b2 = bVar.b();
            this.m = b2;
            this.s.setSupportPartial(b2);
            this.n = bVar.a();
            String str2 = this.s.geteTag();
            String c2 = bVar.c();
            String f2 = bVar.f();
            String g2 = bVar.g();
            String str3 = O;
            d.l.a.e.b.c.a.g(str3, "dcache=responseCode=" + i2 + " last_modified=" + f2 + " CACHE_CONTROL=" + g2 + " max-age=" + bVar.k() + " isDeleteCacheIfCheckFailed=" + this.s.isDeleteCacheIfCheckFailed());
            String str4 = O;
            d.l.a.e.b.c.a.g(str4, "dcache=firstOffset=" + j + " cur=" + f2 + " before=" + this.s.getLastModified() + " cur=" + bVar.j() + " before=" + this.s.getTotalBytes());
            if (!TextUtils.isEmpty(g2)) {
                this.s.setCacheControl(g2);
                if (bVar.k() > 0) {
                    this.s.setCacheExpiredTime(System.currentTimeMillis() + (bVar.k() * 1000));
                }
            }
            if (this.s.isExpiredRedownload() && this.I && !TextUtils.isEmpty(this.H)) {
                boolean z = false;
                if (i2 != 304) {
                    if ((!TextUtils.isEmpty(this.s.getLastModified()) || !this.s.isDeleteCacheIfCheckFailed()) && TextUtils.equals(f2, this.s.getLastModified())) {
                    }
                    String str5 = O;
                    d.l.a.e.b.c.a.g(str5, "dcache=responseCode=" + i2 + " lastModified not changed, use local file  " + f2);
                    throw new com.ss.android.socialbase.downloader.exception.a(this.H);
                }
                z = true;
                String str52 = O;
                d.l.a.e.b.c.a.g(str52, "dcache=responseCode=" + i2 + " lastModified not changed, use local file  " + f2);
                throw new com.ss.android.socialbase.downloader.exception.a(this.H);
            }
            int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i3 > 0 && this.s.isExpiredRedownload() && !TextUtils.equals(f2, this.s.getLastModified())) {
                d.l.a.e.b.c.a.g(O, "dcache cdn file change, so retry");
                F("", "cdn file changed");
                throw null;
            }
            if (!TextUtils.isEmpty(f2)) {
                this.s.setLastModified(f2);
            }
            if (L(i2, str2, c2)) {
                if (iVar instanceof k) {
                    F((TextUtils.isEmpty(str2) || !str2.equals(c2)) ? c2 : "", "eTag of server file changed");
                    throw null;
                }
                throw new com.ss.android.socialbase.downloader.exception.b(1002, i2, "");
            }
            if (!this.m && !this.n) {
                if (i2 == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "response code error : " + i2);
            }
            if (this.n && i3 > 0) {
                if (iVar instanceof k) {
                    F("", "http head request not support");
                    throw null;
                }
                throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
            }
            long h2 = bVar.h();
            if (!(iVar instanceof k) && h2 < 0 && d.l.a.e.b.l.d.a(this.s)) {
                throw new BaseException(1004, "");
            }
            String g3 = TextUtils.isEmpty(this.s.getName()) ? d.l.a.e.b.l.f.g(iVar, this.s.getUrl()) : "";
            boolean i4 = bVar.i();
            this.o = i4;
            if (!i4 && h2 == 0 && !(iVar instanceof k)) {
                throw new BaseException(1004, "");
            }
            if (this.o) {
                j2 = -1;
            } else {
                String Y = d.l.a.e.b.l.f.Y(iVar, "Content-Range");
                String str6 = O;
                d.l.a.e.b.c.a.i(str6, "firstConnection: contentRange = " + Y);
                if (!TextUtils.isEmpty(Y) && this.L.q("fix_get_total_bytes", true)) {
                    j2 = d.l.a.e.b.l.f.V(Y);
                    String str7 = O;
                    d.l.a.e.b.c.a.i(str7, "firstConnection: 1 totalLength = " + j2);
                } else {
                    long j3 = j + h2;
                    String str8 = O;
                    d.l.a.e.b.c.a.k(str8, "firstConnection: 2 totalLength = " + j3 + ", contentLength = " + h2);
                    j2 = j3;
                }
            }
            if (j0()) {
                return;
            }
            if (this.s.getExpectFileLength() > 0 && d.l.a.e.b.j.a.d(this.s.getId()).m("force_check_file_length") == 1 && this.s.getExpectFileLength() != j2) {
                throw new BaseException(1070, "expectFileLength = " + this.s.getExpectFileLength() + " , totalLength = " + j2);
            }
            this.y.e(j2, c2, g3);
        } catch (BaseException e2) {
            throw e2;
        } catch (com.ss.android.socialbase.downloader.exception.i e3) {
            throw e3;
        } catch (Throwable th) {
            d.l.a.e.b.l.f.B(th, "HandleFirstConnection");
            throw null;
        }
    }

    public final void d0() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            String str = O;
            d.l.a.e.b.c.a.g(str, "endDownloadRunnable::runStatus=" + this.q);
            boolean z3 = (this.q == com.ss.android.socialbase.downloader.constants.i.f41470b || this.q == com.ss.android.socialbase.downloader.constants.i.f41471c) ? false : true;
            try {
                z = k0();
                z2 = false;
            } catch (Exception e2) {
                if (e2 instanceof BaseException) {
                    this.y.g((BaseException) e2);
                } else {
                    this.y.g(new BaseException(1046, e2));
                }
                z = true;
                z2 = true;
            }
            if (!z && !z2) {
                this.F = true;
                d.l.a.e.b.c.a.g(O, "jump to restart");
                return;
            }
            this.p.set(false);
            if (z3) {
                try {
                    d.l.a.e.b.m.a c2 = d.l.a.e.b.g.e.c();
                    if (c2 != null) {
                        c2.l(this);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    z R = this.f74840f.R();
                    DownloadInfo downloadInfo = this.s;
                    BaseException baseException = new BaseException(1014, d.l.a.e.b.l.f.a0(th, "removeDownloadRunnable"));
                    DownloadInfo downloadInfo2 = this.s;
                    d.l.a.e.b.e.a.e(R, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // d.l.a.e.b.k.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(i iVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048611, this, iVar) != null) {
            return;
        }
        if (iVar != null) {
            try {
                int b2 = iVar.b();
                this.s.setHttpStatusCode(b2);
                this.s.setHttpStatusMessage(d.l.a.e.b.l.b.a(b2));
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z) {
                this.s.setHttpStatusCode(-1);
                this.s.setHttpStatusMessage("");
                return;
            }
            return;
        }
        z = false;
        if (z) {
        }
    }

    public final void e0() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (iVar = this.B) == null) {
            return;
        }
        iVar.c();
        this.B = null;
    }

    @Override // d.l.a.e.b.k.f
    public void f(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, baseException) == null) {
            DownloadInfo downloadInfo = this.s;
            if (downloadInfo != null) {
                downloadInfo.setChunkDowngradeRetryUsed(true);
            }
            i(baseException, false);
        }
    }

    public final void f0() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (kVar = this.A) == null) {
            return;
        }
        kVar.d();
        this.A = null;
    }

    @Override // d.l.a.e.b.k.f
    public void g(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, baseException) == null) {
            String str = O;
            d.l.a.e.b.c.a.g(str, "onError:" + baseException.getMessage());
            this.q = com.ss.android.socialbase.downloader.constants.i.f41472d;
            this.z = baseException;
            r();
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            e0();
            f0();
        }
    }

    @Override // d.l.a.e.b.k.f
    public com.ss.android.socialbase.downloader.exception.h h(BaseException baseException, long j) {
        InterceptResult invokeLJ;
        long totalBytes;
        long j2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048617, this, baseException, j)) == null) {
            this.z = baseException;
            this.s.increaseCurBytes(-j);
            this.r.a(this.s);
            if (i0()) {
                return com.ss.android.socialbase.downloader.exception.h.f41524a;
            }
            if (baseException != null && baseException.getErrorCode() == 1047) {
                if (this.C != null && !this.s.isForbiddenRetryed()) {
                    a aVar = new a(this);
                    boolean a2 = this.C.a(aVar);
                    this.s.setForbiddenRetryed();
                    if (a2) {
                        if (!aVar.a()) {
                            r();
                            this.y.y();
                            this.q = com.ss.android.socialbase.downloader.constants.i.f41475g;
                            return com.ss.android.socialbase.downloader.exception.h.f41524a;
                        }
                        z = true;
                    }
                } else if (R(baseException)) {
                    return com.ss.android.socialbase.downloader.exception.h.f41524a;
                }
                z = false;
            } else if (d.l.a.e.b.l.f.V0(baseException)) {
                if (this.D == null) {
                    g(baseException);
                    return com.ss.android.socialbase.downloader.exception.h.f41524a;
                }
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                b bVar = new b(this, atomicBoolean);
                if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
                    com.ss.android.socialbase.downloader.exception.d dVar = (com.ss.android.socialbase.downloader.exception.d) baseException;
                    j2 = dVar.a();
                    totalBytes = dVar.b();
                } else {
                    totalBytes = this.s.getTotalBytes();
                    j2 = -1;
                }
                synchronized (this) {
                    if (this.D.a(j2, totalBytes, bVar)) {
                        if (!d.l.a.e.b.j.a.d(this.s.getId()).q("not_delete_when_clean_space", false)) {
                            m0();
                        }
                        if (!atomicBoolean.get()) {
                            if (this.q != com.ss.android.socialbase.downloader.constants.i.f41475g) {
                                this.q = com.ss.android.socialbase.downloader.constants.i.f41475g;
                                r();
                                this.y.y();
                            }
                            return com.ss.android.socialbase.downloader.exception.h.f41524a;
                        }
                        if (R(baseException)) {
                            return com.ss.android.socialbase.downloader.exception.h.f41524a;
                        }
                        z = true;
                    } else if (this.q == com.ss.android.socialbase.downloader.constants.i.f41475g) {
                        return com.ss.android.socialbase.downloader.exception.h.f41524a;
                    } else {
                        g(baseException);
                        return com.ss.android.socialbase.downloader.exception.h.f41524a;
                    }
                }
            } else {
                if (R(baseException)) {
                    return com.ss.android.socialbase.downloader.exception.h.f41524a;
                }
                z = false;
            }
            if (!z && t()) {
                r();
            }
            this.y.h(baseException, this.q == com.ss.android.socialbase.downloader.constants.i.f41474f);
            return this.q == com.ss.android.socialbase.downloader.constants.i.f41474f ? com.ss.android.socialbase.downloader.exception.h.f41524a : com.ss.android.socialbase.downloader.exception.h.f41525b;
        }
        return (com.ss.android.socialbase.downloader.exception.h) invokeLJ.objValue;
    }

    public final void h0() throws BaseException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || this.j == null) {
            return;
        }
        if (this.q == com.ss.android.socialbase.downloader.constants.i.f41471c) {
            this.s.setStatus(-4);
            this.j.j();
        } else if (this.q == com.ss.android.socialbase.downloader.constants.i.f41470b) {
            this.s.setStatus(-2);
            this.j.h();
        } else {
            this.j.k();
        }
    }

    @Override // d.l.a.e.b.k.f
    public void i(BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048619, this, baseException, z) == null) {
            d.l.a.e.b.c.a.g(O, "onAllChunkRetryWithReset");
            this.q = com.ss.android.socialbase.downloader.constants.i.f41477i;
            this.z = baseException;
            r();
            if (z ? R(baseException) : false) {
                return;
            }
            q();
        }
    }

    public final boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.q == com.ss.android.socialbase.downloader.constants.i.f41471c || this.q == com.ss.android.socialbase.downloader.constants.i.f41470b : invokeV.booleanValue;
    }

    public final long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.x.a(this.s.getCurRetryTimeInTotal(), this.s.getTotalRetryCount()) : invokeV.longValue;
    }

    public final boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (i0() || this.s.getStatus() == -2) {
                if (i0()) {
                    return true;
                }
                if (this.s.getStatus() == -2) {
                    this.q = com.ss.android.socialbase.downloader.constants.i.f41470b;
                    return true;
                } else if (this.s.getStatus() == -4) {
                    this.q = com.ss.android.socialbase.downloader.constants.i.f41471c;
                    return true;
                } else {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k() throws com.ss.android.socialbase.downloader.exception.i, BaseException {
        d.l.a.e.b.m.a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            int id = this.s.getId();
            int v = d.l.a.e.b.g.e.v(this.s);
            if (this.s.isDownloaded() && !this.s.isExpiredRedownload() && !this.I) {
                throw new BaseException(1009, "file has downloaded");
            }
            DownloadInfo b2 = this.r.b(v);
            if (b2 == null || (c2 = d.l.a.e.b.g.e.c()) == null || b2.getId() == id || !b2.equalsTask(this.s)) {
                return;
            }
            if (!c2.r(b2.getId())) {
                List<com.ss.android.socialbase.downloader.model.b> c3 = this.r.c(v);
                d.l.a.e.b.l.f.w(this.s);
                this.r.f(v);
                if (b2 == null || !b2.isBreakpointAvailable()) {
                    return;
                }
                this.s.copyFromCacheData(b2, false);
                this.r.a(this.s);
                if (c3 != null) {
                    for (com.ss.android.socialbase.downloader.model.b bVar : c3) {
                        bVar.b(id);
                        this.r.a(bVar);
                    }
                }
                throw new com.ss.android.socialbase.downloader.exception.i("retry task because id generator changed");
            }
            this.r.f(id);
            throw new BaseException(1025, "another same task is downloading");
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.q == com.ss.android.socialbase.downloader.constants.i.f41472d) {
                this.y.g(this.z);
            } else if (this.q == com.ss.android.socialbase.downloader.constants.i.f41471c) {
                this.y.s();
            } else if (this.q == com.ss.android.socialbase.downloader.constants.i.f41470b) {
                this.y.u();
            } else if (this.q == com.ss.android.socialbase.downloader.constants.i.f41473e) {
                try {
                    this.y.x();
                } catch (BaseException e2) {
                    this.y.g(e2);
                }
            } else if (this.q == com.ss.android.socialbase.downloader.constants.i.f41476h) {
                try {
                    this.y.j(this.H);
                } catch (BaseException e3) {
                    this.y.g(e3);
                }
            } else if (this.q == com.ss.android.socialbase.downloader.constants.i.f41477i) {
                this.y.h(this.z, false);
                return false;
            } else if (this.q == com.ss.android.socialbase.downloader.constants.i.f41475g) {
                return true;
            } else {
                if (this.q == com.ss.android.socialbase.downloader.constants.i.f41474f && !l0()) {
                    d.l.a.e.b.c.a.g(O, "doTaskStatusHandle retryDelay");
                    n0();
                    return this.q == com.ss.android.socialbase.downloader.constants.i.f41474f;
                }
                try {
                    if (!m0()) {
                        return false;
                    }
                    this.y.w();
                    q.d().w();
                } catch (Throwable th) {
                    g(new BaseException(1008, d.l.a.e.b.l.f.a0(th, "doTaskStatusHandle onComplete")));
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            DownloadInfo downloadInfo = this.s;
            if (downloadInfo == null || downloadInfo.isExpiredRedownload()) {
                return false;
            }
            return (!this.l || this.s.getChunkCount() > 1) && !this.s.isChunkDowngradeRetryUsed() && this.m && !this.o;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.s.getChunkCount() <= 1) {
                return this.s.getCurBytes() > 0 && this.s.getCurBytes() == this.s.getTotalBytes();
            }
            List<com.ss.android.socialbase.downloader.model.b> c2 = this.r.c(this.s.getId());
            if (c2 == null || c2.size() <= 1) {
                return false;
            }
            for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
                if (bVar == null || !bVar.i()) {
                    return false;
                }
                while (r0.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void m() throws BaseException {
        long j;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            try {
                j = d.l.a.e.b.l.f.y0(this.s.getTempPath());
            } catch (BaseException unused) {
                j = 0;
            }
            d.l.a.e.b.c.a.i(O, "checkSpaceOverflowInProgress: available = " + d.l.a.e.b.l.f.a(j) + "MB");
            if (j > 0) {
                long totalBytes = this.s.getTotalBytes() - this.s.getCurBytes();
                if (j < totalBytes && (b2 = d.l.a.e.b.j.a.d(this.s.getId()).b("space_fill_min_keep_mb", 100)) > 0) {
                    long j2 = j - (b2 * 1048576);
                    d.l.a.e.b.c.a.i(O, "checkSpaceOverflowInProgress: minKeep  = " + b2 + "MB, canDownload = " + d.l.a.e.b.l.f.a(j2) + "MB");
                    if (j2 > 0) {
                        this.J = this.s.getCurBytes() + j2 + 1048576;
                        return;
                    } else {
                        this.J = 0L;
                        throw new com.ss.android.socialbase.downloader.exception.d(j, totalBytes);
                    }
                }
            }
            this.J = 0L;
        }
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.s.isChunked()) {
                DownloadInfo downloadInfo = this.s;
                downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
            }
            String str = O;
            d.l.a.e.b.c.a.i(str, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.s.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.s.getTotalBytes());
            if (this.s.getCurBytes() > 0) {
                if (this.s.isIgnoreDataVerify()) {
                    return true;
                }
                if (this.s.getTotalBytes() > 0 && this.s.getCurBytes() == this.s.getTotalBytes()) {
                    return true;
                }
            }
            this.s.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.f41448b);
            this.s.reset();
            this.r.a(this.s);
            this.r.d(this.s.getId());
            this.r.m(this.s.getId());
            d.l.a.e.b.l.f.w(this.s);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n() throws com.ss.android.socialbase.downloader.exception.f {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (this.s.isOnlyWifi() && !d.l.a.e.b.l.f.J(d.l.a.e.b.g.e.n(), DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
                throw new com.ss.android.socialbase.downloader.exception.f(1019, String.format("download task need permission:%s", DefaultConnectivityMonitorFactory.NETWORK_PERMISSION));
            }
            if (this.s.isDownloadWithWifiValid()) {
                if (!this.s.isPauseReserveWithWifiValid()) {
                    throw new com.ss.android.socialbase.downloader.exception.e();
                }
                return;
            }
            throw new com.ss.android.socialbase.downloader.exception.c();
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.q = com.ss.android.socialbase.downloader.constants.i.f41469a;
        }
    }

    public final void o() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (!TextUtils.isEmpty(this.s.getSavePath())) {
                if (!TextUtils.isEmpty(this.s.getName())) {
                    File file = new File(this.s.getSavePath());
                    if (!file.exists()) {
                        boolean mkdirs = file.mkdirs();
                        if (mkdirs || file.exists()) {
                            return;
                        }
                        int i2 = 0;
                        if (d.l.a.e.b.j.a.d(this.s.getId()).b("opt_mkdir_failed", 0) == 1) {
                            while (!mkdirs) {
                                int i3 = i2 + 1;
                                if (i2 >= 3) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                    mkdirs = file.mkdirs();
                                    i2 = i3;
                                } catch (InterruptedException unused) {
                                }
                            }
                            if (mkdirs || file.exists()) {
                                return;
                            }
                            if (d.l.a.e.b.l.f.y0(this.s.getSavePath()) < 16384) {
                                throw new BaseException(1006, "download savePath directory can not created:" + this.s.getSavePath());
                            }
                            throw new BaseException(1030, "download savePath directory can not created:" + this.s.getSavePath());
                        }
                        throw new BaseException(1030, "download savePath directory can not created:" + this.s.getSavePath());
                    } else if (file.isDirectory()) {
                        return;
                    } else {
                        if (d.l.a.e.b.l.d.b(this.s)) {
                            file.delete();
                            if (file.mkdirs() || file.exists()) {
                                return;
                            }
                            throw new BaseException((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not directory:path=" + this.s.getSavePath());
                        }
                        throw new BaseException((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not a directory:" + this.s.getSavePath());
                    }
                }
                throw new BaseException(1029, "download name can not be empty");
            }
            throw new BaseException(1028, "download savePath can not be empty");
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            long M0 = d.l.a.e.b.l.f.M0(this.s);
            long curBytes = this.s.getCurBytes();
            if (M0 != curBytes) {
                String str = O;
                d.l.a.e.b.c.a.j(str, "checkTaskCanResume: offset = " + M0 + ", curBytes = " + curBytes);
            }
            this.s.setCurBytes(M0);
            boolean z = M0 > 0;
            this.l = z;
            if (z || this.I) {
                return;
            }
            d.l.a.e.b.c.a.i(O, "checkTaskCanResume: deleteAllDownloadFiles");
            this.r.d(this.s.getId());
            this.r.m(this.s.getId());
            d.l.a.e.b.l.f.w(this.s);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            String str = O;
            d.l.a.e.b.c.a.j(str, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
            try {
                this.r.d(this.s.getId());
                this.r.m(this.s.getId());
                d.l.a.e.b.l.f.w(this.s);
                this.l = false;
                this.s.resetDataForEtagEndure("");
                this.r.a(this.s);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            try {
                Iterator it = ((ArrayList) this.f74843i.clone()).iterator();
                while (it.hasNext()) {
                    d.l.a.e.b.k.b bVar = (d.l.a.e.b.k.b) it.next();
                    if (bVar != null) {
                        bVar.e();
                    }
                }
            } catch (Throwable th) {
                String str = O;
                d.l.a.e.b.c.a.i(str, "cancelAllChunkRunnable: " + th.toString());
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            d.l.a.e.b.g.e.S(this.f74840f, 3);
            try {
                d.l.a.e.b.o.d.a().b();
                Y();
                d.l.a.e.b.o.d.a().c();
                d.l.a.e.b.g.e.f0(this.f74840f, 3);
            } catch (Throwable th) {
                d.l.a.e.b.o.d.a().c();
                throw th;
            }
        }
    }

    public final void s() {
        d.l.a.e.b.m.a c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || j0() || (c2 = d.l.a.e.b.g.e.c()) == null) {
            return;
        }
        c2.Q(this.s.getId());
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (r9 <= 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int u(long j, List<com.ss.android.socialbase.downloader.model.b> list) {
        InterceptResult invokeJL;
        int i2;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048638, this, j, list)) == null) {
            if (l()) {
                if (!this.l) {
                    d.l.a.e.b.g.j jVar = this.t;
                    if (jVar != null) {
                        a2 = jVar.a(j);
                    } else {
                        a2 = this.u.a(j);
                    }
                    l d2 = d.l.a.e.b.o.m.a().d();
                    d.l.a.e.b.c.a.g(O, String.format("NetworkQuality is : %s", d2.name()));
                    this.s.setNetworkQuality(d2.name());
                    d.l.a.e.b.g.i iVar = this.v;
                    if (iVar != null) {
                        i2 = iVar.a(a2, d2);
                    } else {
                        i2 = this.w.a(a2, d2);
                    }
                } else if (list != null) {
                    i2 = list.size();
                } else {
                    i2 = this.s.getChunkCount();
                }
            }
            i2 = 1;
            if (d.l.a.e.b.c.a.e()) {
                d.l.a.e.b.c.a.g(O, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(i2), this.s.getName(), String.valueOf(j)));
            }
            return i2;
        }
        return invokeJL.intValue;
    }

    public final s v(d.l.a.e.b.n.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, aVar)) == null) {
            s U = aVar.U();
            if (U != null) {
                return U;
            }
            DownloadInfo J = aVar.J();
            if (J != null) {
                String retryDelayTimeArray = J.getRetryDelayTimeArray();
                if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                    return new p(retryDelayTimeArray);
                }
            }
            return d.l.a.e.b.g.e.l();
        }
        return (s) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        if (r9.f() != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.ss.android.socialbase.downloader.model.b x(com.ss.android.socialbase.downloader.model.b bVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048640, this, bVar, i2)) == null) {
            com.ss.android.socialbase.downloader.model.b bVar2 = null;
            if (bVar.d()) {
                long c2 = bVar.c(true);
                String str = O;
                d.l.a.e.b.c.a.g(str, "reuseChunk retainLen:" + c2 + " chunkIndex:" + i2);
                boolean z = false;
                if (!bVar.f() && c2 > d.l.a.e.b.d.c.f74689f && this.s.isNeedReuseChunkRunnable()) {
                    List<com.ss.android.socialbase.downloader.model.b> a2 = bVar.a(this.s.getChunkCount(), this.s.getTotalBytes());
                    if (a2 != null) {
                        for (com.ss.android.socialbase.downloader.model.b bVar3 : a2) {
                            this.r.b(bVar3);
                        }
                    }
                }
                z = true;
                if (z && bVar.f()) {
                    for (int i3 = 1; i3 < bVar.g().size(); i3++) {
                        com.ss.android.socialbase.downloader.model.b bVar4 = bVar.g().get(i3);
                        if (bVar4 != null) {
                            String str2 = O;
                            d.l.a.e.b.c.a.g(str2, "check can checkUnCompletedChunk -- chunkIndex:" + bVar4.s() + " currentOffset:" + bVar4.n() + "  startOffset:" + bVar4.l() + " contentLen:" + bVar4.q());
                            if (bVar4.s() < 0 || (!bVar4.i() && !bVar4.c())) {
                                bVar2 = bVar4;
                                break;
                            }
                        }
                    }
                    if (bVar2 != null) {
                        long n = bVar.n();
                        String str3 = O;
                        d.l.a.e.b.c.a.g(str3, "unComplete chunk " + bVar.s() + " curOffset:" + n + " reuseChunk chunkIndex:" + i2 + " for subChunk:" + bVar2.s());
                        this.r.a(bVar2.k(), bVar2.s(), bVar2.b(), i2);
                        bVar2.c(i2);
                        bVar2.a(true);
                    }
                }
                return bVar2;
            }
            return null;
        }
        return (com.ss.android.socialbase.downloader.model.b) invokeLI.objValue;
    }

    public final List<com.ss.android.socialbase.downloader.model.c> y(com.ss.android.socialbase.downloader.model.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, bVar)) == null) {
            List<com.ss.android.socialbase.downloader.model.c> t = d.l.a.e.b.l.f.t(this.s.getExtraHeaders(), this.s.geteTag(), bVar);
            if (this.s.isExpiredRedownload() && this.I && this.s.getLastModified() != null) {
                t.add(new com.ss.android.socialbase.downloader.model.c("if-modified-since", this.s.getLastModified()));
                t.add(new com.ss.android.socialbase.downloader.model.c("download-tc21-1-15", "download-tc21-1-15"));
                String str = O;
                d.l.a.e.b.c.a.g(str, "dcache::add head IF_MODIFIED_SINCE=" + this.s.getLastModified());
            }
            return t;
        }
        return (List) invokeL.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.q = com.ss.android.socialbase.downloader.constants.i.f41470b;
            if (this.N != null) {
                this.N.C();
            }
            if (this.j != null) {
                this.j.h();
            }
            if (this.N == null && this.j == null) {
                g0();
                this.q = com.ss.android.socialbase.downloader.constants.i.f41470b;
                d0();
            }
            try {
                Iterator it = ((ArrayList) this.f74843i.clone()).iterator();
                while (it.hasNext()) {
                    d.l.a.e.b.k.b bVar = (d.l.a.e.b.k.b) it.next();
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.k.f
    public com.ss.android.socialbase.downloader.exception.h b(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{bVar, baseException, Long.valueOf(j)})) == null) {
            if (i0()) {
                return com.ss.android.socialbase.downloader.exception.h.f41524a;
            }
            if (baseException != null && (baseException.getErrorCode() == 1047 || d.l.a.e.b.l.f.V0(baseException))) {
                return h(baseException, j);
            }
            this.z = baseException;
            this.s.increaseCurBytes(-j);
            this.r.a(this.s);
            if (R(baseException)) {
                return com.ss.android.socialbase.downloader.exception.h.f41524a;
            }
            this.y.i(bVar, baseException, this.q == com.ss.android.socialbase.downloader.constants.i.f41474f);
            if (this.q != com.ss.android.socialbase.downloader.constants.i.f41474f && this.s.isNeedRetryDelay()) {
                long j2 = j();
                if (j2 > 0) {
                    String str = O;
                    d.l.a.e.b.c.a.i(str, "onSingleChunkRetry with delay time " + j2);
                    try {
                        Thread.sleep(j2);
                    } catch (Throwable th) {
                        String str2 = O;
                        d.l.a.e.b.c.a.j(str2, "onSingleChunkRetry:" + th.getMessage());
                    }
                }
            }
            return com.ss.android.socialbase.downloader.exception.h.f41525b;
        }
        return (com.ss.android.socialbase.downloader.exception.h) invokeCommon.objValue;
    }

    @Override // d.l.a.e.b.k.f
    public boolean a(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, baseException)) == null) {
            if (this.N == null || !d.l.a.e.b.l.f.Y0(baseException) || this.f74842h.get() >= this.s.getRetryCount()) {
                if (d.l.a.e.b.l.f.h0(baseException)) {
                    if (this.k && !this.f74841g) {
                        d.l.a.e.b.l.f.w(this.s);
                        this.f74841g = true;
                    }
                    return true;
                }
                AtomicInteger atomicInteger = this.f74842h;
                if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.s.hasNextBackupUrl()) {
                    if (baseException == null) {
                        return false;
                    }
                    if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.s.canReplaceHttpForRetry()) {
                        return false;
                    }
                }
                return !(baseException instanceof com.ss.android.socialbase.downloader.exception.f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.l.a.e.b.k.f
    public synchronized com.ss.android.socialbase.downloader.model.b a(int i2) {
        InterceptResult invokeI;
        com.ss.android.socialbase.downloader.model.b x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            synchronized (this) {
                if (this.s.getChunkCount() < 2) {
                    return null;
                }
                List<com.ss.android.socialbase.downloader.model.b> c2 = this.r.c(this.s.getId());
                if (c2 != null && !c2.isEmpty()) {
                    for (int i3 = 0; i3 < c2.size(); i3++) {
                        com.ss.android.socialbase.downloader.model.b bVar = c2.get(i3);
                        if (bVar != null && (x = x(bVar, i2)) != null) {
                            return x;
                        }
                    }
                    return null;
                }
                return null;
            }
        }
        return (com.ss.android.socialbase.downloader.model.b) invokeI.objValue;
    }
}
