package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.util.devices.RomUtils;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static volatile com.ss.android.socialbase.downloader.d.b A;
    public static volatile aa B;
    public static volatile com.ss.android.socialbase.downloader.network.f F;
    public static volatile com.ss.android.socialbase.downloader.network.f G;
    public static volatile u H;
    public static int K;
    public static final int N;
    public static final int O;
    public static int P;
    public static boolean Q;
    public static final List<com.ss.android.socialbase.downloader.depend.k> R;
    public static final List<ab> S;
    public static int T;
    public static boolean U;
    public static boolean V;
    public static r W;
    public static com.ss.android.socialbase.downloader.d.c X;
    public static volatile boolean Y;
    public static volatile Context a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile j f59955b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile k f59956c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile h f59957d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile af f59958e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile com.ss.android.socialbase.downloader.impls.a f59959f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile o f59960g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile o f59961h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f59962i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile IDownloadHttpService f59963j;
    public static volatile com.ss.android.socialbase.downloader.network.h k;
    public static volatile IDownloadHttpService l;
    public static volatile com.ss.android.socialbase.downloader.network.h m;
    public static volatile l n;
    public static volatile ExecutorService o;
    public static volatile ExecutorService p;
    public static volatile ExecutorService q;
    public static volatile ExecutorService r;
    public static volatile ExecutorService s;
    public static volatile ExecutorService t;
    public static volatile ExecutorService u;
    public static volatile ExecutorService v;
    public static volatile g w;
    public static volatile DownloadReceiver x;
    public static volatile s y;
    public static volatile q z;
    public static volatile List<ak> C = new ArrayList();
    public static volatile boolean D = false;
    public static volatile OkHttpClient E = null;
    public static final List<com.ss.android.socialbase.downloader.depend.m> I = new ArrayList();
    public static boolean J = false;
    public static final int L = Runtime.getRuntime().availableProcessors() + 1;
    public static final int M = (Runtime.getRuntime().availableProcessors() * 2) + 1;

    /* loaded from: classes3.dex */
    public interface a {

        /* renamed from: com.ss.android.socialbase.downloader.downloader.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public interface InterfaceC2216a {
            void a();
        }

        o a();

        t a(InterfaceC2216a interfaceC2216a);

        m b();
    }

    static {
        int i2 = L;
        N = i2;
        O = i2;
        P = 8192;
        R = new ArrayList();
        S = new ArrayList();
        U = true;
        V = false;
        Y = false;
    }

    public static List<com.ss.android.socialbase.downloader.depend.m> A() {
        return I;
    }

    public static k B() {
        if (f59956c == null) {
            synchronized (c.class) {
                if (f59956c == null) {
                    f59956c = new com.ss.android.socialbase.downloader.impls.i();
                }
            }
        }
        return f59956c;
    }

    public static com.ss.android.socialbase.downloader.impls.a C() {
        if (f59959f == null) {
            synchronized (c.class) {
                if (f59959f == null) {
                    f59959f = new com.ss.android.socialbase.downloader.impls.e();
                }
            }
        }
        return f59959f;
    }

    public static int D() {
        return T;
    }

    @NonNull
    public static JSONObject E() {
        if (B != null && B.a() != null) {
            return B.a();
        }
        return com.ss.android.socialbase.downloader.constants.e.f59910i;
    }

    public static void F() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.e.f59904c)) {
            com.ss.android.socialbase.downloader.constants.e.f59904c = RomUtils.MANUFACTURER_OPPO;
            com.ss.android.socialbase.downloader.constants.e.f59903b = com.ss.android.socialbase.downloader.constants.e.f59904c.toUpperCase();
        }
    }

    public static boolean G() {
        return U;
    }

    public static synchronized int H() {
        int i2;
        synchronized (c.class) {
            i2 = P;
        }
        return i2;
    }

    public static h I() {
        if (f59957d == null) {
            synchronized (c.class) {
                if (f59957d == null) {
                    f59957d = new com.ss.android.socialbase.downloader.impls.c();
                }
            }
        }
        return f59957d;
    }

    public static af J() {
        return f59958e;
    }

    public static g K() {
        if (w == null) {
            synchronized (c.class) {
                if (w == null) {
                    w = new com.ss.android.socialbase.downloader.impls.b();
                }
            }
        }
        return w;
    }

    public static s L() {
        if (y == null) {
            synchronized (c.class) {
                if (y == null) {
                    y = new com.ss.android.socialbase.downloader.impls.j();
                }
            }
        }
        return y;
    }

    public static u M() {
        if (H == null) {
            synchronized (c.class) {
                if (H == null) {
                    H = new u.a();
                }
            }
        }
        return H;
    }

    public static synchronized Context N() {
        Context context;
        synchronized (c.class) {
            context = a;
        }
        return context;
    }

    public static synchronized boolean O() {
        boolean z2;
        synchronized (c.class) {
            z2 = Q;
        }
        return z2;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.d.c P() {
        if (X == null) {
            X = new com.ss.android.socialbase.downloader.d.c() { // from class: com.ss.android.socialbase.downloader.downloader.c.3
                @Override // com.ss.android.socialbase.downloader.d.c
                public void a(int i2, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.d.c
                public void b(int i2, String str, JSONObject jSONObject) {
                }
            };
        }
        return X;
    }

    public static r Q() {
        return W;
    }

    public static boolean R() {
        return Y;
    }

    public static boolean S() {
        StringBuilder sb = new StringBuilder();
        sb.append("supportMultiProc::=");
        sb.append(f59962i != null);
        com.ss.android.socialbase.downloader.c.a.a("wjd", sb.toString());
        return f59962i != null;
    }

    public static a T() {
        return f59962i;
    }

    public static void U() {
        if (x == null) {
            x = new DownloadReceiver();
        }
        if (J) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            a.registerReceiver(x, intentFilter);
            J = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized void a(DownloaderBuilder downloaderBuilder) {
        synchronized (c.class) {
            if (Y) {
                com.ss.android.socialbase.downloader.c.a.e("DownloadComponentManager", "component has init");
                return;
            }
            boolean z2 = D;
            c(downloaderBuilder);
            if (f59955b == null) {
                f59955b = new com.ss.android.socialbase.downloader.impls.d();
            }
            if (f59960g == null) {
                f59960g = new com.ss.android.socialbase.downloader.impls.h();
            }
            if (f59961h == null && f59962i != null) {
                f59961h = f59962i.a();
            }
            if (f59956c == null) {
                f59956c = new com.ss.android.socialbase.downloader.impls.i();
            }
            if (f59959f == null) {
                f59959f = new com.ss.android.socialbase.downloader.impls.e();
            }
            if (f59957d == null) {
                f59957d = new com.ss.android.socialbase.downloader.impls.c();
            }
            if (w == null) {
                w = new com.ss.android.socialbase.downloader.impls.b();
            }
            if (y == null) {
                y = new com.ss.android.socialbase.downloader.impls.j();
            }
            if (K <= 0 || K > L) {
                K = L;
            }
            U();
            if (D && !z2 && !com.ss.android.socialbase.downloader.i.f.c()) {
                com.ss.android.socialbase.downloader.impls.l.a(true).startService();
            } else if (com.ss.android.socialbase.downloader.i.f.d()) {
                ExecutorService m2 = m();
                if (m2 != null) {
                    m2.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Context N2 = c.N();
                            if (N2 != null) {
                                com.ss.android.socialbase.downloader.i.f.d(N2);
                            }
                        }
                    });
                }
            } else {
                Context N2 = N();
                if (N2 != null) {
                    com.ss.android.socialbase.downloader.i.f.d(N2);
                }
            }
            F();
            Y = true;
        }
    }

    public static void a(r rVar) {
    }

    public static synchronized void b(DownloaderBuilder downloaderBuilder) {
        synchronized (c.class) {
            c(downloaderBuilder);
        }
    }

    public static void c(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                a(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                a(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                a(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                a(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                a(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                b(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                a(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                a(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                a(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                c(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                d(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                e(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                f(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                g(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                h(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                a(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                b(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                a(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                z = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                P = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                a(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                D = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                T = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                a(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                F = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                H = downloaderBuilder.getTTNetHandler();
                if (H.a()) {
                    a(H.b());
                    a(H.c());
                } else {
                    a(h());
                    a(i());
                }
            }
            b(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                a(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    public static IDownloadHttpService d() {
        return f59963j;
    }

    public static List<ak> e() {
        List<ak> list;
        synchronized (C) {
            list = C;
        }
        return list;
    }

    public static com.ss.android.socialbase.downloader.network.h f() {
        return k;
    }

    public static com.ss.android.socialbase.downloader.d.b g() {
        return A;
    }

    public static IDownloadHttpService h() {
        if (l == null) {
            synchronized (c.class) {
                if (l == null) {
                    l = new com.ss.android.socialbase.downloader.impls.g();
                }
            }
        }
        return l;
    }

    public static com.ss.android.socialbase.downloader.network.h i() {
        if (m == null) {
            synchronized (c.class) {
                if (m == null) {
                    m = new com.ss.android.socialbase.downloader.impls.f();
                }
            }
        }
        return m;
    }

    public static boolean j() {
        return com.ss.android.socialbase.downloader.g.a.c().a("switch_not_auto_boot_service", V ? 1 : 0) > 0;
    }

    public static synchronized q k() {
        q qVar;
        synchronized (c.class) {
            qVar = z;
        }
        return qVar;
    }

    public static ExecutorService l() {
        if (o == null) {
            synchronized (c.class) {
                if (o == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(L, L, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-cpu-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    o = threadPoolExecutor;
                }
            }
        }
        return o;
    }

    public static ExecutorService m() {
        return p != null ? p : l();
    }

    public static ExecutorService n() {
        return r != null ? r : p();
    }

    public static ExecutorService o() {
        return s != null ? s : p();
    }

    public static ExecutorService p() {
        if (q == null) {
            synchronized (c.class) {
                if (q == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(N, N, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-mix-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    q = threadPoolExecutor;
                }
            }
        }
        return q;
    }

    public static ExecutorService q() {
        if (u == null) {
            synchronized (c.class) {
                if (u == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(M, M, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-chunk-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    u = threadPoolExecutor;
                }
            }
        }
        return u;
    }

    public static ExecutorService r() {
        if (t == null) {
            synchronized (c.class) {
                if (t == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(O, O, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-db-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    t = threadPoolExecutor;
                }
            }
        }
        return t;
    }

    public static OkHttpClient s() {
        if (E == null) {
            synchronized (c.class) {
                if (E == null) {
                    E = t().build();
                }
            }
        }
        return E;
    }

    public static OkHttpClient.Builder t() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (v != null) {
            builder.dispatcher(new Dispatcher(v));
        }
        return builder;
    }

    public static com.ss.android.socialbase.downloader.network.f u() {
        return F;
    }

    public static com.ss.android.socialbase.downloader.network.f v() {
        if (G == null) {
            synchronized (c.class) {
                if (G == null) {
                    G = new com.ss.android.socialbase.downloader.network.f() { // from class: com.ss.android.socialbase.downloader.downloader.c.2
                        @Override // com.ss.android.socialbase.downloader.network.f
                        public List<InetAddress> a(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return G;
    }

    public static synchronized l w() {
        l lVar;
        synchronized (c.class) {
            lVar = n;
        }
        return lVar;
    }

    public static j x() {
        if (f59955b == null) {
            synchronized (c.class) {
                if (f59955b == null) {
                    f59955b = new com.ss.android.socialbase.downloader.impls.d();
                }
            }
        }
        return f59955b;
    }

    public static o y() {
        if (f59960g == null) {
            synchronized (c.class) {
                if (f59960g == null) {
                    f59960g = new com.ss.android.socialbase.downloader.impls.h();
                }
            }
        }
        return f59960g;
    }

    public static o z() {
        if (f59961h == null) {
            synchronized (c.class) {
                if (f59961h == null) {
                    f59961h = f59962i.a();
                }
            }
        }
        return f59961h;
    }

    public static void d(ExecutorService executorService) {
        if (executorService != null) {
            p = executorService;
        }
    }

    public static void f(ExecutorService executorService) {
        if (executorService != null) {
            r = executorService;
        }
    }

    public static void g(ExecutorService executorService) {
        if (executorService != null) {
            s = executorService;
        }
    }

    public static synchronized void b() {
        synchronized (c.class) {
            if (D) {
                return;
            }
            D = true;
            Intent intent = new Intent(N(), DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            N().startService(intent);
            if (!com.ss.android.socialbase.downloader.i.f.c()) {
                com.ss.android.socialbase.downloader.impls.l.a(true).startService();
            }
        }
    }

    public static void e(ExecutorService executorService) {
        if (executorService != null) {
            q = executorService;
        }
    }

    public static void h(ExecutorService executorService) {
        if (executorService != null) {
            t = executorService;
        }
    }

    public static void b(com.ss.android.socialbase.downloader.depend.k kVar) {
        synchronized (R) {
            if (kVar != null) {
                if (R.contains(kVar)) {
                    R.remove(kVar);
                }
            }
        }
    }

    public static void b(DownloadTask downloadTask, int i2) {
        synchronized (S) {
            for (ab abVar : S) {
                if (abVar != null) {
                    abVar.b(downloadTask, i2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.ss.android.socialbase.downloader.network.g b(String str, List<com.ss.android.socialbase.downloader.model.c> list, int i2, boolean z2, DownloadInfo downloadInfo) throws BaseException, IOException {
        IOException iOException;
        com.ss.android.socialbase.downloader.network.h f2 = i2 == 1 ? f() : i();
        if (f2 != null) {
            long j2 = 0;
            if (z2) {
                try {
                    j2 = System.currentTimeMillis();
                } catch (IOException e2) {
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        iOException = e2;
                        th = th;
                        if (z2) {
                            com.ss.android.socialbase.downloader.d.a.a(null, str, null, System.currentTimeMillis() - j2, "head", i2, iOException, downloadInfo);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    iOException = null;
                    if (z2) {
                    }
                    throw th;
                }
            }
            com.ss.android.socialbase.downloader.network.g a2 = f2.a(str, list);
            if (z2) {
                com.ss.android.socialbase.downloader.d.a.a(a2, str, null, System.currentTimeMillis() - j2, "head", i2, null, downloadInfo);
            }
            return a2;
        }
        throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i2));
    }

    public static void b(ExecutorService executorService) {
        if (executorService != null) {
            v = executorService;
        }
    }

    public static void b(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.i.f.d()) {
            runnable.run();
        } else {
            m().execute(runnable);
        }
    }

    public static synchronized void a() {
        synchronized (c.class) {
            try {
                if (J && x != null && a != null) {
                    a.unregisterReceiver(x);
                    J = false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.i.f.d()) {
            runnable.run();
        } else {
            r().execute(runnable);
        }
    }

    public static void b(int i2) {
        if (i2 > 0) {
            K = i2;
        }
    }

    public static void a(ak akVar) {
        if (akVar == null) {
            return;
        }
        synchronized (C) {
            C.add(akVar);
        }
    }

    public static void b(boolean z2) {
        U = z2;
    }

    public static void a(com.ss.android.socialbase.downloader.depend.k kVar) {
        synchronized (R) {
            if (kVar != null) {
                if (!R.contains(kVar)) {
                    R.add(kVar);
                }
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.constants.d dVar) {
        synchronized (R) {
            for (com.ss.android.socialbase.downloader.depend.k kVar : R) {
                if (kVar != null) {
                    if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_START) {
                        kVar.a();
                    } else if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                        kVar.b();
                    }
                }
            }
            if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                R.clear();
            }
        }
    }

    public static void a(DownloadTask downloadTask, int i2) {
        synchronized (S) {
            for (ab abVar : S) {
                if (abVar != null) {
                    abVar.a(downloadTask, i2);
                }
            }
        }
    }

    public static synchronized boolean c() {
        boolean z2;
        synchronized (c.class) {
            z2 = D;
        }
        return z2;
    }

    public static void c(ExecutorService executorService) {
        if (executorService != null) {
            o = executorService;
        }
    }

    public static com.ss.android.socialbase.downloader.network.i a(boolean z2, int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        return a(z2, i2, str, null, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.i a(boolean z2, int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.c> list, int i3, boolean z3, DownloadInfo downloadInfo) throws Exception {
        List<com.ss.android.socialbase.downloader.model.c> list2;
        int i4;
        com.ss.android.socialbase.downloader.network.i a2;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.model.c> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i4 = 1;
        } else if (z2) {
            list2 = list;
            i4 = i3;
        } else {
            i4 = 2;
            list2 = list;
        }
        int[] a3 = a(i4);
        Exception exc = null;
        for (int i5 : a3) {
            try {
                a2 = a(i2, str, str2, list2, i5, z3, downloadInfo);
            } catch (Exception e2) {
                if (downloadInfo.isExpiredRedownload() && com.ss.android.socialbase.downloader.i.f.g(e2) && com.ss.android.socialbase.downloader.i.f.c(list2)) {
                    com.ss.android.socialbase.downloader.c.a.a("dcach::http exception 304, throw excepiton, not retry " + e2);
                    throw e2;
                }
                exc = e2;
            }
            if (a2 != null) {
                return a2;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.ss.android.socialbase.downloader.network.i a(int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.c> list, int i3, boolean z2, DownloadInfo downloadInfo) throws BaseException, IOException {
        IOException iOException;
        IDownloadHttpService d2 = i3 == 1 ? d() : h();
        if (d2 != null) {
            IOException iOException2 = null;
            long j2 = 0;
            if (z2) {
                try {
                    j2 = System.currentTimeMillis();
                } catch (IOException e2) {
                    e = e2;
                    iOException = e;
                    try {
                        throw iOException;
                    } catch (Throwable th) {
                        th = th;
                        iOException2 = iOException;
                        if (z2) {
                            com.ss.android.socialbase.downloader.d.a.a(null, str, str2, System.currentTimeMillis() - j2, "get", i3, iOException2, downloadInfo);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (z2) {
                    }
                    throw th;
                }
            }
            try {
                com.ss.android.socialbase.downloader.network.i downloadWithConnection = d2.downloadWithConnection(i2, str, list);
                if (z2) {
                    com.ss.android.socialbase.downloader.d.a.a(downloadWithConnection, str, str2, System.currentTimeMillis() - j2, "get", i3, null, downloadInfo);
                }
                return downloadWithConnection;
            } catch (IOException e3) {
                e = e3;
                iOException = e;
                throw iOException;
            } catch (Throwable th3) {
                th = th3;
                if (z2) {
                }
                throw th;
            }
        }
        throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i3));
    }

    public static com.ss.android.socialbase.downloader.network.g a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        return a(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.g a(String str, List<com.ss.android.socialbase.downloader.model.c> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        com.ss.android.socialbase.downloader.network.g b2;
        Exception e2 = null;
        for (int i3 : a(i2)) {
            try {
                b2 = b(str, list, i3, z2, downloadInfo);
            } catch (Exception e3) {
                e2 = e3;
            }
            if (b2 != null) {
                return b2;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    public static int[] a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    public static synchronized void a(l lVar) {
        synchronized (c.class) {
            if (lVar != null) {
                n = lVar;
                if (f59955b instanceof com.ss.android.socialbase.downloader.impls.d) {
                    ((com.ss.android.socialbase.downloader.impls.d) f59955b).h();
                }
            }
        }
    }

    public static void a(ExecutorService executorService) {
        if (executorService != null) {
            u = executorService;
        }
    }

    public static void a(List<com.ss.android.socialbase.downloader.depend.m> list) {
        if (I.isEmpty()) {
            synchronized (I) {
                I.addAll(list);
            }
        }
    }

    public static void a(boolean z2) {
        V = z2;
    }

    public static void a(Runnable runnable) {
        b(runnable, false);
    }

    public static void a(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.i.f.d()) {
            runnable.run();
        } else {
            l().execute(runnable);
        }
    }

    public static void a(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            f59963j = iDownloadHttpService;
        }
        Q = f59963j != null;
    }

    public static void a(com.ss.android.socialbase.downloader.network.h hVar) {
        if (hVar != null) {
            k = hVar;
        }
    }

    public static void a(j jVar) {
        if (jVar != null) {
            f59955b = jVar;
        }
    }

    public static void a(k kVar) {
        if (kVar != null) {
            f59956c = kVar;
        }
    }

    public static void a(com.ss.android.socialbase.downloader.d.b bVar) {
        if (bVar != null) {
            A = bVar;
        }
    }

    public static void a(aa aaVar) {
        B = aaVar;
        com.ss.android.socialbase.downloader.g.a.a();
    }

    public static void a(h hVar) {
        if (hVar != null) {
            f59957d = hVar;
        }
    }

    public static void a(af afVar) {
        if (afVar != null) {
            f59958e = afVar;
        }
    }

    public static void a(g gVar) {
        if (gVar != null) {
            w = gVar;
        }
    }

    public static synchronized void a(Context context) {
        synchronized (c.class) {
            if (context != null) {
                if (a == null) {
                    a = context.getApplicationContext();
                    com.ss.android.socialbase.downloader.a.a.a().a(a);
                }
            }
        }
    }

    public static int a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        return a(downloadInfo.getUrl(), downloadInfo.getSavePath());
    }

    public static int a(String str, String str2) {
        k B2 = B();
        if (B2 == null) {
            return 0;
        }
        return B2.a(str, str2);
    }

    public static void a(com.ss.android.socialbase.downloader.d.c cVar) {
        X = cVar;
    }

    public static void a(a aVar) {
        com.ss.android.socialbase.downloader.c.a.a("wjd", "setIndependentServiceCreator::creator=" + aVar);
        f59962i = aVar;
    }
}
