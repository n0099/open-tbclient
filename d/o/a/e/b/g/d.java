package d.o.a.e.b.g;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.downloader.DownloadReceiver;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
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
/* loaded from: classes7.dex */
public class d {
    public static volatile d.o.a.e.b.f.e A;
    public static volatile d.o.a.e.b.o.h E;
    public static volatile d.o.a.e.b.o.h F;
    public static int I;
    public static final int L;
    public static final int M;
    public static int N;
    public static boolean O;
    public static final List<d.o.a.e.b.f.o> P;
    public static final List<d.o.a.e.b.f.f> Q;
    public static int R;
    public static boolean S;
    public static boolean T;
    public static q U;
    public static d.o.a.e.b.e.c V;
    public static volatile boolean W;

    /* renamed from: a  reason: collision with root package name */
    public static volatile Context f71094a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile j f71095b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile k f71096c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile i f71097d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile d.o.a.e.b.f.i f71098e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile d.o.a.e.b.m.a f71099f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile o f71100g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile o f71101h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile d.o.a.e.b.o.a f71102i;
    public static volatile d.o.a.e.b.o.j j;
    public static volatile d.o.a.e.b.o.a k;
    public static volatile d.o.a.e.b.o.j l;
    public static volatile l m;
    public static volatile ExecutorService n;
    public static volatile ExecutorService o;
    public static volatile ExecutorService p;
    public static volatile ExecutorService q;
    public static volatile ExecutorService r;
    public static volatile ExecutorService s;
    public static volatile ExecutorService t;
    public static volatile ExecutorService u;
    public static volatile h v;
    public static volatile DownloadReceiver w;
    public static volatile r x;
    public static volatile p y;
    public static volatile d.o.a.e.b.e.b z;
    public static volatile List<d.o.a.e.b.f.k> B = new ArrayList();
    public static volatile boolean C = false;
    public static volatile OkHttpClient D = null;
    public static final List<d.o.a.e.b.f.p> G = new ArrayList();
    public static boolean H = false;
    public static final int J = Runtime.getRuntime().availableProcessors() + 1;
    public static final int K = (Runtime.getRuntime().availableProcessors() * 2) + 1;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Context l = d.l();
            if (l != null) {
                d.o.a.e.b.l.e.x0(l);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements d.o.a.e.b.o.h {
        @Override // d.o.a.e.b.o.h
        public List<InetAddress> a(String str) throws UnknownHostException {
            return Dns.SYSTEM.lookup(str);
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements d.o.a.e.b.e.c {
        @Override // d.o.a.e.b.e.c
        public void a(int i2, String str, JSONObject jSONObject) {
        }

        @Override // d.o.a.e.b.e.c
        public void b(int i2, String str, JSONObject jSONObject) {
        }
    }

    static {
        int i2 = J;
        L = i2;
        M = i2;
        N = 8192;
        P = new ArrayList();
        Q = new ArrayList();
        S = true;
        T = false;
        W = false;
    }

    public static void A(d.o.a.e.b.e.b bVar) {
        if (bVar != null) {
            z = bVar;
        }
    }

    public static ExecutorService A0() {
        if (p == null) {
            synchronized (d.class) {
                if (p == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(L, L, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d.o.a.e.b.k.a("DownloadThreadPool-mix-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    p = threadPoolExecutor;
                }
            }
        }
        return p;
    }

    public static void B(d.o.a.e.b.e.c cVar) {
        V = cVar;
    }

    public static ExecutorService B0() {
        if (t == null) {
            synchronized (d.class) {
                if (t == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(K, K, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d.o.a.e.b.k.a("DownloadThreadPool-chunk-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    t = threadPoolExecutor;
                }
            }
        }
        return t;
    }

    public static void C(d.o.a.e.b.f.e eVar) {
        A = eVar;
        d.o.a.e.b.j.a.i();
        U(eVar.a());
    }

    public static ExecutorService C0() {
        if (s == null) {
            synchronized (d.class) {
                if (s == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(M, M, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d.o.a.e.b.k.a("DownloadThreadPool-db-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    s = threadPoolExecutor;
                }
            }
        }
        return s;
    }

    public static void D(d.o.a.e.b.f.i iVar) {
        if (iVar != null) {
            f71098e = iVar;
        }
    }

    public static OkHttpClient D0() {
        if (D == null) {
            synchronized (d.class) {
                if (D == null) {
                    D = E0().build();
                }
            }
        }
        return D;
    }

    public static void E(d.o.a.e.b.f.k kVar) {
        if (kVar == null) {
            return;
        }
        synchronized (B) {
            B.add(kVar);
        }
    }

    public static OkHttpClient.Builder E0() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (u != null) {
            builder.dispatcher(new Dispatcher(u));
        }
        return builder;
    }

    public static void F(d.o.a.e.b.f.o oVar) {
        synchronized (P) {
            if (oVar != null) {
                if (!P.contains(oVar)) {
                    P.add(oVar);
                }
            }
        }
    }

    public static d.o.a.e.b.o.h F0() {
        return E;
    }

    public static synchronized void G(d.o.a.e.b.g.b bVar) {
        synchronized (d.class) {
            if (W) {
                d.o.a.e.b.c.a.j("DownloadComponentManager", "component has init");
                return;
            }
            boolean z2 = C;
            g0(bVar);
            if (f71095b == null) {
                f71095b = new d.o.a.e.b.m.d();
            }
            if (f71100g == null) {
                f71100g = new d.o.a.e.b.m.h();
            }
            if (f71101h == null) {
                f71101h = new d.o.a.e.b.m.m();
            }
            if (f71096c == null) {
                f71096c = new d.o.a.e.b.m.i();
            }
            if (f71099f == null) {
                f71099f = new d.o.a.e.b.m.e();
            }
            if (f71097d == null) {
                f71097d = new d.o.a.e.b.m.c();
            }
            if (v == null) {
                v = new d.o.a.e.b.m.b();
            }
            if (x == null) {
                x = new d.o.a.e.b.m.j();
            }
            if (I <= 0 || I > J) {
                I = J;
            }
            q();
            if (C && !z2 && !d.o.a.e.b.l.e.n0()) {
                d.o.a.e.b.m.l.a(true).d();
            } else if (d.o.a.e.b.l.e.y0()) {
                ExecutorService x0 = x0();
                if (x0 != null) {
                    x0.execute(new a());
                }
            } else {
                Context l2 = l();
                if (l2 != null) {
                    d.o.a.e.b.l.e.x0(l2);
                }
            }
            W = true;
        }
    }

    public static d.o.a.e.b.o.h G0() {
        if (F == null) {
            synchronized (d.class) {
                if (F == null) {
                    F = new b();
                }
            }
        }
        return F;
    }

    public static void H(h hVar) {
        if (hVar != null) {
            v = hVar;
        }
    }

    public static synchronized l H0() {
        l lVar;
        synchronized (d.class) {
            lVar = m;
        }
        return lVar;
    }

    public static void I(i iVar) {
        if (iVar != null) {
            f71097d = iVar;
        }
    }

    public static j I0() {
        if (f71095b == null) {
            synchronized (d.class) {
                if (f71095b == null) {
                    f71095b = new d.o.a.e.b.m.d();
                }
            }
        }
        return f71095b;
    }

    public static void J(j jVar) {
        if (jVar != null) {
            f71095b = jVar;
        }
    }

    public static o J0() {
        if (f71100g == null) {
            synchronized (d.class) {
                if (f71100g == null) {
                    f71100g = new d.o.a.e.b.m.h();
                }
            }
        }
        return f71100g;
    }

    public static void K(k kVar) {
        if (kVar != null) {
            f71096c = kVar;
        }
    }

    public static o K0() {
        if (f71101h == null) {
            synchronized (d.class) {
                if (f71101h == null) {
                    f71101h = new d.o.a.e.b.m.m();
                }
            }
        }
        return f71101h;
    }

    public static synchronized void L(l lVar) {
        synchronized (d.class) {
            if (lVar != null) {
                m = lVar;
                if (f71095b instanceof d.o.a.e.b.m.d) {
                    ((d.o.a.e.b.m.d) f71095b).k();
                }
            }
        }
    }

    public static void M(q qVar) {
    }

    public static void N(d.o.a.e.b.n.a aVar, int i2) {
        synchronized (Q) {
            for (d.o.a.e.b.f.f fVar : Q) {
                if (fVar != null) {
                    fVar.a(aVar, i2);
                }
            }
        }
    }

    public static void O(d.o.a.e.b.o.a aVar) {
        if (aVar != null) {
            f71102i = aVar;
        }
        O = f71102i != null;
    }

    public static void P(d.o.a.e.b.o.j jVar) {
        if (jVar != null) {
            j = jVar;
        }
    }

    public static void Q(Runnable runnable) {
        d0(runnable, false);
    }

    public static void R(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !d.o.a.e.b.l.e.y0()) {
            runnable.run();
        } else {
            w0().execute(runnable);
        }
    }

    public static void S(List<d.o.a.e.b.f.p> list) {
        if (G.isEmpty()) {
            synchronized (G) {
                G.addAll(list);
            }
        }
    }

    public static void T(ExecutorService executorService) {
        if (executorService != null) {
            t = executorService;
        }
    }

    public static void U(JSONObject jSONObject) {
        if (jSONObject == null || !TextUtils.isEmpty(d.o.a.e.b.d.c.f71070c)) {
            return;
        }
        d.o.a.e.b.d.c.f71070c = jSONObject.optString("kllk");
        if (TextUtils.isEmpty(d.o.a.e.b.d.c.f71070c)) {
            return;
        }
        d.o.a.e.b.d.c.f71069b = d.o.a.e.b.d.c.f71070c.toUpperCase();
    }

    public static void V(boolean z2) {
        T = z2;
    }

    public static int[] W(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d.o.a.e.b.o.i X(String str, List<com.ss.android.socialbase.downloader.model.c> list, int i2, boolean z2, DownloadInfo downloadInfo) throws BaseException, IOException {
        IOException iOException;
        d.o.a.e.b.o.j n0 = i2 == 1 ? n0() : t0();
        if (n0 != null) {
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
                            d.o.a.e.b.e.a.i(null, str, null, System.currentTimeMillis() - j2, "head", i2, iOException, downloadInfo);
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
            d.o.a.e.b.o.i a2 = n0.a(str, list);
            if (z2) {
                d.o.a.e.b.e.a.i(a2, str, null, System.currentTimeMillis() - j2, "head", i2, null, downloadInfo);
            }
            return a2;
        }
        throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i2));
    }

    public static synchronized void Y() {
        synchronized (d.class) {
            if (C) {
                return;
            }
            C = true;
            Intent intent = new Intent(l(), DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            l().startService(intent);
            if (!d.o.a.e.b.l.e.n0()) {
                d.o.a.e.b.m.l.a(true).d();
            }
        }
    }

    public static void Z(int i2) {
        if (i2 > 0) {
            I = i2;
        }
    }

    public static List<d.o.a.e.b.f.p> a() {
        return G;
    }

    public static synchronized void a0(d.o.a.e.b.g.b bVar) {
        synchronized (d.class) {
            g0(bVar);
        }
    }

    public static k b() {
        if (f71096c == null) {
            synchronized (d.class) {
                if (f71096c == null) {
                    f71096c = new d.o.a.e.b.m.i();
                }
            }
        }
        return f71096c;
    }

    public static void b0(d.o.a.e.b.n.a aVar, int i2) {
        synchronized (Q) {
            for (d.o.a.e.b.f.f fVar : Q) {
                if (fVar != null) {
                    fVar.b(aVar, i2);
                }
            }
        }
    }

    public static d.o.a.e.b.m.a c() {
        if (f71099f == null) {
            synchronized (d.class) {
                if (f71099f == null) {
                    f71099f = new d.o.a.e.b.m.e();
                }
            }
        }
        return f71099f;
    }

    public static void c0(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!d.o.a.e.b.l.e.y0()) {
            runnable.run();
        } else {
            C0().execute(runnable);
        }
    }

    public static int d() {
        return R;
    }

    public static void d0(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !d.o.a.e.b.l.e.y0()) {
            runnable.run();
        } else {
            x0().execute(runnable);
        }
    }

    @NonNull
    public static JSONObject e() {
        if (A != null && A.a() != null) {
            JSONObject a2 = A.a();
            U(a2);
            return a2;
        }
        return d.o.a.e.b.d.c.f71074g;
    }

    public static void e0(ExecutorService executorService) {
        if (executorService != null) {
            u = executorService;
        }
    }

    public static boolean f() {
        return S;
    }

    public static void f0(boolean z2) {
        S = z2;
    }

    public static synchronized int g() {
        int i2;
        synchronized (d.class) {
            i2 = N;
        }
        return i2;
    }

    public static void g0(d.o.a.e.b.g.b bVar) {
        if (bVar != null) {
            if (bVar.j() != null) {
                y(bVar.j());
            }
            if (bVar.l() != null) {
                J(bVar.l());
            }
            if (bVar.v() != null) {
                K(bVar.v());
            }
            if (bVar.h() != null) {
                I(bVar.h());
            }
            if (bVar.B() != null) {
                D(bVar.B());
            }
            if (bVar.w() != 0) {
                Z(bVar.w());
            }
            if (bVar.t() != null) {
                O(bVar.t());
            }
            if (bVar.s() != null) {
                P(bVar.s());
            }
            if (bVar.p() != null) {
                L(bVar.p());
            }
            if (bVar.f() != null) {
                h0(bVar.f());
            }
            if (bVar.u() != null) {
                k0(bVar.u());
            }
            if (bVar.y() != null) {
                m0(bVar.y());
            }
            if (bVar.z() != null) {
                o0(bVar.z());
            }
            if (bVar.x() != null) {
                q0(bVar.x());
            }
            if (bVar.k() != null) {
                s0(bVar.k());
            }
            if (bVar.i() != null) {
                T(bVar.i());
            }
            if (bVar.C() != null) {
                e0(bVar.C());
            }
            if (!bVar.m().isEmpty()) {
                S(bVar.m());
            }
            if (bVar.A() != null) {
                y = bVar.A();
            }
            if (bVar.D() > 1024) {
                N = bVar.D();
            }
            if (bVar.g() != null) {
                H(bVar.g());
            }
            if (bVar.F()) {
                C = true;
            }
            if (bVar.o() != 0) {
                R = bVar.o();
            }
            if (bVar.r() != null) {
                C(bVar.r());
            }
            if (bVar.n() != null) {
                E = bVar.n();
            }
            f0(bVar.G());
            if (bVar.q() != null) {
                A(bVar.q());
            }
        }
    }

    public static i h() {
        if (f71097d == null) {
            synchronized (d.class) {
                if (f71097d == null) {
                    f71097d = new d.o.a.e.b.m.c();
                }
            }
        }
        return f71097d;
    }

    public static void h0(ExecutorService executorService) {
        if (executorService != null) {
            n = executorService;
        }
    }

    public static d.o.a.e.b.f.i i() {
        return f71098e;
    }

    public static synchronized boolean i0() {
        boolean z2;
        synchronized (d.class) {
            z2 = C;
        }
        return z2;
    }

    public static h j() {
        if (v == null) {
            synchronized (d.class) {
                if (v == null) {
                    v = new d.o.a.e.b.m.b();
                }
            }
        }
        return v;
    }

    public static d.o.a.e.b.o.a j0() {
        return f71102i;
    }

    public static r k() {
        if (x == null) {
            synchronized (d.class) {
                if (x == null) {
                    x = new d.o.a.e.b.m.j();
                }
            }
        }
        return x;
    }

    public static void k0(ExecutorService executorService) {
        if (executorService != null) {
            o = executorService;
        }
    }

    public static synchronized Context l() {
        Context context;
        synchronized (d.class) {
            context = f71094a;
        }
        return context;
    }

    public static List<d.o.a.e.b.f.k> l0() {
        List<d.o.a.e.b.f.k> list;
        synchronized (B) {
            list = B;
        }
        return list;
    }

    public static synchronized boolean m() {
        boolean z2;
        synchronized (d.class) {
            z2 = O;
        }
        return z2;
    }

    public static void m0(ExecutorService executorService) {
        if (executorService != null) {
            p = executorService;
        }
    }

    @NonNull
    public static d.o.a.e.b.e.c n() {
        if (V == null) {
            V = new c();
        }
        return V;
    }

    public static d.o.a.e.b.o.j n0() {
        return j;
    }

    public static q o() {
        return U;
    }

    public static void o0(ExecutorService executorService) {
        if (executorService != null) {
            q = executorService;
        }
    }

    public static boolean p() {
        return W;
    }

    public static d.o.a.e.b.e.b p0() {
        return z;
    }

    public static void q() {
        if (w == null) {
            w = new DownloadReceiver();
        }
        if (H) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            f71094a.registerReceiver(w, intentFilter);
            H = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void q0(ExecutorService executorService) {
        if (executorService != null) {
            r = executorService;
        }
    }

    public static int r(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        return s(downloadInfo.T0(), downloadInfo.F0());
    }

    public static d.o.a.e.b.o.a r0() {
        if (k == null) {
            synchronized (d.class) {
                if (k == null) {
                    k = new d.o.a.e.b.m.g();
                }
            }
        }
        return k;
    }

    public static int s(String str, String str2) {
        k b2 = b();
        if (b2 == null) {
            return 0;
        }
        return b2.a(str, str2);
    }

    public static void s0(ExecutorService executorService) {
        if (executorService != null) {
            s = executorService;
        }
    }

    public static d.o.a.e.b.o.i t(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        return u(str, list, 0, false, null);
    }

    public static d.o.a.e.b.o.j t0() {
        if (l == null) {
            synchronized (d.class) {
                if (l == null) {
                    l = new d.o.a.e.b.m.f();
                }
            }
        }
        return l;
    }

    public static d.o.a.e.b.o.i u(String str, List<com.ss.android.socialbase.downloader.model.c> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        d.o.a.e.b.o.i X;
        Exception e2 = null;
        for (int i3 : W(i2)) {
            try {
                X = X(str, list, i3, z2, downloadInfo);
            } catch (Exception e3) {
                e2 = e3;
            }
            if (X != null) {
                return X;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    public static boolean u0() {
        return d.o.a.e.b.j.a.r().b("switch_not_auto_boot_service", T ? 1 : 0) > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d.o.a.e.b.o.k v(int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.c> list, int i3, boolean z2, DownloadInfo downloadInfo) throws BaseException, IOException {
        IOException iOException;
        d.o.a.e.b.o.a j0 = i3 == 1 ? j0() : r0();
        if (j0 != null) {
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
                            d.o.a.e.b.e.a.i(null, str, str2, System.currentTimeMillis() - j2, "get", i3, iOException2, downloadInfo);
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
                d.o.a.e.b.o.k downloadWithConnection = j0.downloadWithConnection(i2, str, list);
                if (z2) {
                    d.o.a.e.b.e.a.i(downloadWithConnection, str, str2, System.currentTimeMillis() - j2, "get", i3, null, downloadInfo);
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

    public static synchronized p v0() {
        p pVar;
        synchronized (d.class) {
            pVar = y;
        }
        return pVar;
    }

    public static d.o.a.e.b.o.k w(boolean z2, int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.c> list, int i3, boolean z3, DownloadInfo downloadInfo) throws Exception {
        List<com.ss.android.socialbase.downloader.model.c> list2;
        int i4;
        d.o.a.e.b.o.k v2;
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
        int[] W2 = W(i4);
        Exception e2 = null;
        for (int i5 : W2) {
            try {
                v2 = v(i2, str, str2, list2, i5, z3, downloadInfo);
            } catch (Exception e3) {
                e2 = e3;
            }
            if (v2 != null) {
                return v2;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    public static ExecutorService w0() {
        if (n == null) {
            synchronized (d.class) {
                if (n == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(J, J, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d.o.a.e.b.k.a("DownloadThreadPool-cpu-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    n = threadPoolExecutor;
                }
            }
        }
        return n;
    }

    public static d.o.a.e.b.o.k x(boolean z2, int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        return w(z2, i2, str, null, list, 0, false, null);
    }

    public static ExecutorService x0() {
        return o != null ? o : w0();
    }

    public static synchronized void y(Context context) {
        synchronized (d.class) {
            if (context != null) {
                if (f71094a == null) {
                    f71094a = context.getApplicationContext();
                    d.o.a.e.b.a.a.c().e(f71094a);
                }
            }
        }
    }

    public static ExecutorService y0() {
        return q != null ? q : A0();
    }

    public static void z(com.ss.android.socialbase.downloader.constants.d dVar) {
        synchronized (P) {
            for (d.o.a.e.b.f.o oVar : P) {
                if (oVar != null) {
                    if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_START) {
                        oVar.a();
                    } else if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                        oVar.b();
                    }
                }
            }
            if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                P.clear();
            }
        }
    }

    public static ExecutorService z0() {
        return r != null ? r : A0();
    }
}
