package com.ss.android.socialbase.downloader.downloader;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.ss.android.socialbase.downloader.d.aa;
import com.ss.android.socialbase.downloader.d.ab;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private static int G;
    private static boolean M;
    private static int P;

    /* renamed from: a  reason: collision with root package name */
    private static volatile Context f13432a;
    private static volatile ExecutorService cjn;
    private static volatile ExecutorService p;
    private static volatile AlarmManager pZA;
    private static com.ss.android.socialbase.downloader.h.c pZC;
    private static r pZD;
    private static com.ss.android.socialbase.downloader.h.b pZE;
    private static volatile k pZc;
    private static volatile l pZd;
    private static volatile i pZe;
    private static volatile com.ss.android.socialbase.downloader.d.r pZf;
    private static volatile com.ss.android.socialbase.downloader.impls.a pZg;
    private static volatile p pZh;
    private static volatile ab pZi;
    private static volatile p pZj;
    private static volatile com.ss.android.socialbase.downloader.i.h pZk;
    private static volatile com.ss.android.socialbase.downloader.i.f pZl;
    private static volatile com.ss.android.socialbase.downloader.i.h pZm;
    private static volatile com.ss.android.socialbase.downloader.i.f pZn;
    private static volatile m pZo;
    private static volatile ExecutorService pZp;
    private static volatile ExecutorService pZq;
    private static volatile ExecutorService pZr;
    private static volatile ExecutorService pZs;
    private static volatile ExecutorService pZt;
    private static volatile h pZu;
    private static volatile DownloadReceiver pZv;
    private static volatile s pZw;
    private static volatile q pZx;
    private static volatile com.ss.android.socialbase.downloader.d.e pZy;
    private static volatile ExecutorService pkc;
    private static volatile List<com.ss.android.socialbase.downloader.d.t> B = new ArrayList();
    private static volatile boolean C = false;
    private static volatile OkHttpClient pZz = null;
    private static boolean F = false;
    private static final int H = Runtime.getRuntime().availableProcessors() + 1;
    private static final int I = (Runtime.getRuntime().availableProcessors() * 2) + 1;
    private static final int J = H;
    private static final int K = H;
    private static int L = 8192;
    private static final List<aa> pZB = new ArrayList();
    private static final List<com.ss.android.socialbase.downloader.d.l> O = new ArrayList();
    private static boolean Q = true;
    private static volatile boolean U = false;

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void b(g gVar) {
        synchronized (b.class) {
            if (U) {
                com.ss.android.socialbase.downloader.f.a.e("DownloadComponentManager", "component has init");
            } else {
                boolean z = C;
                if (gVar != null) {
                    a(gVar.a());
                    a(gVar.eHZ());
                    a(gVar.eIa());
                    b(gVar.eGY());
                    a(gVar.eIh());
                    b(gVar.p());
                    a(gVar.eIb());
                    a(gVar.eHw());
                    a(gVar.eIc());
                    c(gVar.eId());
                    d(gVar.eIe());
                    e(gVar.i());
                    f(gVar.eHB());
                    g(gVar.ut());
                    h(gVar.eHC());
                    a(gVar.eHD());
                    i(gVar.eHE());
                    b(gVar.eIf());
                    if (gVar.eIg() != null) {
                        pZx = gVar.eIg();
                    }
                    if (gVar.s() > 1024) {
                        L = gVar.s();
                    }
                    b(gVar.eGZ());
                    if (gVar.t()) {
                        C = true;
                    }
                    P = gVar.v();
                    a(gVar.eIi());
                    a(gVar.w());
                }
                if (pZc == null) {
                    pZc = new com.ss.android.socialbase.downloader.impls.d();
                }
                if (pZh == null) {
                    pZh = new com.ss.android.socialbase.downloader.impls.h();
                }
                if (pZj == null) {
                    pZj = new com.ss.android.socialbase.downloader.impls.n();
                }
                if (pZd == null) {
                    pZd = new com.ss.android.socialbase.downloader.impls.i();
                }
                if (pZg == null) {
                    pZg = new com.ss.android.socialbase.downloader.impls.e();
                }
                if (pZe == null) {
                    pZe = new com.ss.android.socialbase.downloader.impls.c();
                }
                if (pZu == null) {
                    pZu = new com.ss.android.socialbase.downloader.impls.b();
                }
                if (pZw == null) {
                    pZw = new com.ss.android.socialbase.downloader.impls.j();
                }
                if (G <= 0 || G > H) {
                    G = H;
                }
                L();
                if (C && !z && !com.ss.android.socialbase.downloader.m.d.c()) {
                    com.ss.android.socialbase.downloader.impls.l.Cy(true).d();
                } else if (com.ss.android.socialbase.downloader.m.d.d()) {
                    ExecutorService ut = ut();
                    if (ut != null) {
                        ut.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.b.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Context eHT = b.eHT();
                                if (eHT != null) {
                                    com.ss.android.socialbase.downloader.m.d.c(eHT);
                                }
                            }
                        });
                    }
                } else {
                    Context eHT = eHT();
                    if (eHT != null) {
                        com.ss.android.socialbase.downloader.m.d.c(eHT);
                    }
                }
                U = true;
            }
        }
    }

    private static void L() {
        if (pZv == null) {
            pZv = new DownloadReceiver();
        }
        if (!F) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                f13432a.registerReceiver(pZv, intentFilter);
                F = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized void a() {
        synchronized (b.class) {
            if (!C) {
                C = true;
                Intent intent = new Intent(eHT(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
                eHT().startService(intent);
                if (!com.ss.android.socialbase.downloader.m.d.c()) {
                    com.ss.android.socialbase.downloader.impls.l.Cy(true).d();
                }
            }
        }
    }

    public static synchronized boolean b() {
        boolean z;
        synchronized (b.class) {
            z = C;
        }
        return z;
    }

    public static com.ss.android.socialbase.downloader.i.h eHv() {
        return pZk;
    }

    public static void a(com.ss.android.socialbase.downloader.d.t tVar) {
        if (tVar != null) {
            synchronized (B) {
                B.add(tVar);
            }
        }
    }

    public static List<com.ss.android.socialbase.downloader.d.t> d() {
        List<com.ss.android.socialbase.downloader.d.t> list;
        synchronized (B) {
            list = B;
        }
        return list;
    }

    public static void a(com.ss.android.socialbase.downloader.b.d dVar) {
        synchronized (pZB) {
            if (pZB != null) {
                for (aa aaVar : pZB) {
                    if (aaVar != null) {
                        if (dVar == com.ss.android.socialbase.downloader.b.d.SYNC_START) {
                            aaVar.a();
                        } else if (dVar == com.ss.android.socialbase.downloader.b.d.SYNC_SUCCESS) {
                            aaVar.b();
                        }
                    }
                }
                pZB.clear();
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.g.d dVar, int i) {
        synchronized (O) {
            for (com.ss.android.socialbase.downloader.d.l lVar : O) {
                if (lVar != null) {
                    lVar.a(dVar, i);
                }
            }
        }
    }

    public static void b(com.ss.android.socialbase.downloader.g.d dVar, int i) {
        synchronized (O) {
            for (com.ss.android.socialbase.downloader.d.l lVar : O) {
                if (lVar != null) {
                    lVar.b(dVar, i);
                }
            }
        }
    }

    public static com.ss.android.socialbase.downloader.i.f eHw() {
        return pZl;
    }

    public static com.ss.android.socialbase.downloader.i.g b(boolean z, int i, String str, List<com.ss.android.socialbase.downloader.g.e> list) throws Exception {
        return a(z, i, str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.i.g a(boolean z, int i, String str, List<com.ss.android.socialbase.downloader.g.e> list, int i2, boolean z2, com.ss.android.socialbase.downloader.g.c cVar) throws Exception {
        com.ss.android.socialbase.downloader.i.g a2;
        if (!z) {
            i2 = 2;
        }
        Exception exc = null;
        int[] Sy = Sy(i2);
        int length = Sy.length;
        int i3 = 0;
        while (i3 < length) {
            try {
                a2 = a(i, str, list, Sy[i3], z2, cVar);
            } catch (Exception e) {
                e = e;
            }
            if (a2 == null) {
                e = exc;
                i3++;
                exc = e;
            } else {
                return a2;
            }
        }
        if (exc != null) {
            throw exc;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.ss.android.socialbase.downloader.i.g a(int i, String str, List<com.ss.android.socialbase.downloader.g.e> list, int i2, boolean z, com.ss.android.socialbase.downloader.g.c cVar) throws com.ss.android.socialbase.downloader.e.a, IOException {
        Throwable th;
        com.ss.android.socialbase.downloader.i.h eHv = i2 == 1 ? eHv() : eHx();
        if (eHv == null) {
            throw new com.ss.android.socialbase.downloader.e.a(1022, new IOException("httpService not exist, netLib = " + i2));
        }
        IOException iOException = null;
        long j = 0;
        if (z) {
            try {
                j = System.currentTimeMillis();
            } catch (IOException e) {
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    iOException = e;
                    if (z) {
                        com.ss.android.socialbase.downloader.h.a.a(null, str, System.currentTimeMillis() - j, "get", i2, iOException, cVar);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                }
                throw th;
            }
        }
        com.ss.android.socialbase.downloader.i.g a2 = eHv.a(i, str, list);
        if (z) {
            com.ss.android.socialbase.downloader.h.a.a(a2, str, System.currentTimeMillis() - j, "get", i2, null, cVar);
        }
        return a2;
    }

    public static com.ss.android.socialbase.downloader.i.e v(String str, List<com.ss.android.socialbase.downloader.g.e> list) throws Exception {
        return a(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.i.e a(String str, List<com.ss.android.socialbase.downloader.g.e> list, int i, boolean z, com.ss.android.socialbase.downloader.g.c cVar) throws Exception {
        com.ss.android.socialbase.downloader.i.e b2;
        Exception e = null;
        for (int i2 : Sy(i)) {
            try {
                b2 = b(str, list, i2, z, cVar);
            } catch (Exception e2) {
                e = e2;
            }
            if (b2 != null) {
                return b2;
            }
        }
        if (e != null) {
            throw e;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.ss.android.socialbase.downloader.i.e b(String str, List<com.ss.android.socialbase.downloader.g.e> list, int i, boolean z, com.ss.android.socialbase.downloader.g.c cVar) throws com.ss.android.socialbase.downloader.e.a, IOException {
        Throwable th;
        com.ss.android.socialbase.downloader.i.f eHw = i == 1 ? eHw() : eHy();
        if (eHw == null) {
            throw new com.ss.android.socialbase.downloader.e.a(1022, new IOException("httpService not exist, netLib = " + i));
        }
        IOException iOException = null;
        long j = 0;
        if (z) {
            try {
                j = System.currentTimeMillis();
            } catch (IOException e) {
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    iOException = e;
                    if (z) {
                        com.ss.android.socialbase.downloader.h.a.a(null, str, System.currentTimeMillis() - j, "head", i, iOException, cVar);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                }
                throw th;
            }
        }
        com.ss.android.socialbase.downloader.i.e v = eHw.v(str, list);
        if (z) {
            com.ss.android.socialbase.downloader.h.a.a(v, str, System.currentTimeMillis() - j, "head", i, null, cVar);
        }
        return v;
    }

    private static int[] Sy(int i) {
        switch (i) {
            case 1:
                return new int[]{0};
            case 2:
                return new int[]{1};
            case 3:
                return new int[]{0, 1};
            default:
                return new int[]{1, 0};
        }
    }

    public static com.ss.android.socialbase.downloader.i.h eHx() {
        if (pZm == null) {
            synchronized (b.class) {
                if (pZm == null) {
                    pZm = new com.ss.android.socialbase.downloader.impls.g();
                }
            }
        }
        return pZm;
    }

    public static com.ss.android.socialbase.downloader.i.f eHy() {
        if (pZn == null) {
            synchronized (b.class) {
                if (pZn == null) {
                    pZn = new com.ss.android.socialbase.downloader.impls.f();
                }
            }
        }
        return pZn;
    }

    public static AlarmManager eHz() {
        if (pZA == null) {
            synchronized (b.class) {
                if (pZA == null && f13432a != null) {
                    pZA = (AlarmManager) f13432a.getSystemService(NotificationCompat.CATEGORY_ALARM);
                }
            }
        }
        return pZA;
    }

    public static synchronized void a(m mVar) {
        synchronized (b.class) {
            if (mVar != null) {
                pZo = mVar;
                if (pZc instanceof com.ss.android.socialbase.downloader.impls.d) {
                    ((com.ss.android.socialbase.downloader.impls.d) pZc).g();
                }
            }
        }
    }

    private static void c(ExecutorService executorService) {
        if (executorService != null) {
            cjn = executorService;
        }
    }

    private static void d(ExecutorService executorService) {
        if (executorService != null) {
            p = executorService;
        }
    }

    private static void e(ExecutorService executorService) {
        if (executorService != null) {
            pZp = executorService;
        }
    }

    private static void f(ExecutorService executorService) {
        if (executorService != null) {
            pZq = executorService;
        }
    }

    private static void g(ExecutorService executorService) {
        if (executorService != null) {
            pZr = executorService;
        }
    }

    private static void h(ExecutorService executorService) {
        if (executorService != null) {
            pkc = executorService;
        }
    }

    public static void a(ExecutorService executorService) {
        if (executorService != null) {
            pZs = executorService;
        }
    }

    public static void i(ExecutorService executorService) {
        if (executorService != null) {
            pZt = executorService;
        }
    }

    private static void b(ab abVar) {
        if (pZi == null) {
            pZi = abVar;
        }
    }

    public static synchronized q eHA() {
        q qVar;
        synchronized (b.class) {
            qVar = pZx;
        }
        return qVar;
    }

    public static void a(Runnable runnable) {
        d(runnable, false);
    }

    public static void c(Runnable runnable, boolean z) {
        if (runnable != null) {
            if (z && !com.ss.android.socialbase.downloader.m.d.d()) {
                runnable.run();
            } else {
                eHB().execute(runnable);
            }
        }
    }

    public static void d(Runnable runnable, boolean z) {
        if (runnable != null) {
            if (z && !com.ss.android.socialbase.downloader.m.d.d()) {
                runnable.run();
            } else {
                ut().execute(runnable);
            }
        }
    }

    public static void b(Runnable runnable) {
        if (runnable != null) {
            if (!com.ss.android.socialbase.downloader.m.d.d()) {
                runnable.run();
            } else {
                eHG().execute(runnable);
            }
        }
    }

    public static ExecutorService eHB() {
        if (cjn == null) {
            synchronized (b.class) {
                if (cjn == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(H, H, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-cpu-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    cjn = threadPoolExecutor;
                }
            }
        }
        return cjn;
    }

    public static ExecutorService ut() {
        return p != null ? p : eHB();
    }

    public static ExecutorService eHC() {
        return pZq != null ? pZq : eHE();
    }

    public static ExecutorService eHD() {
        return pZr != null ? pZr : eHE();
    }

    public static ExecutorService eHE() {
        if (pZp == null) {
            synchronized (b.class) {
                if (pZp == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(J, J, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-mix-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    pZp = threadPoolExecutor;
                }
            }
        }
        return pZp;
    }

    public static ExecutorService eHF() {
        if (pZs == null) {
            synchronized (b.class) {
                if (pZs == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(I, I, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-chunk-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    pZs = threadPoolExecutor;
                }
            }
        }
        return pZs;
    }

    public static ExecutorService eHG() {
        if (pkc == null) {
            synchronized (b.class) {
                if (pkc == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(K, K, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-db-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    pkc = threadPoolExecutor;
                }
            }
        }
        return pkc;
    }

    public static OkHttpClient eHH() {
        if (pZz == null) {
            synchronized (b.class) {
                if (pZz == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
                    if (pZt != null) {
                        builder.dispatcher(new Dispatcher(pZt));
                    }
                    pZz = builder.build();
                }
            }
        }
        return pZz;
    }

    public static synchronized m eHI() {
        m mVar;
        synchronized (b.class) {
            mVar = pZo;
        }
        return mVar;
    }

    private static void a(com.ss.android.socialbase.downloader.i.h hVar) {
        if (hVar != null) {
            pZk = hVar;
        }
        M = pZk != null;
    }

    private static void a(com.ss.android.socialbase.downloader.i.f fVar) {
        if (fVar != null) {
            pZl = fVar;
        }
    }

    public static k eHJ() {
        if (pZc == null) {
            synchronized (b.class) {
                if (pZc == null) {
                    pZc = new com.ss.android.socialbase.downloader.impls.d();
                }
            }
        }
        return pZc;
    }

    private static void a(k kVar) {
        if (kVar != null) {
            pZc = kVar;
        }
    }

    public static p eHK() {
        if (pZh == null) {
            synchronized (b.class) {
                if (pZh == null) {
                    pZh = new com.ss.android.socialbase.downloader.impls.h();
                }
            }
        }
        return pZh;
    }

    public static p eHL() {
        if (pZj == null) {
            synchronized (b.class) {
                if (pZj == null) {
                    pZj = new com.ss.android.socialbase.downloader.impls.n();
                }
            }
        }
        return pZj;
    }

    public static ab eHM() {
        return pZi;
    }

    public static l eHN() {
        if (pZd == null) {
            synchronized (b.class) {
                if (pZd == null) {
                    pZd = new com.ss.android.socialbase.downloader.impls.i();
                }
            }
        }
        return pZd;
    }

    public static com.ss.android.socialbase.downloader.impls.a eHO() {
        if (pZg == null) {
            synchronized (b.class) {
                if (pZg == null) {
                    pZg = new com.ss.android.socialbase.downloader.impls.e();
                }
            }
        }
        return pZg;
    }

    private static void a(l lVar) {
        if (lVar != null) {
            pZd = lVar;
        }
    }

    private static void b(int i) {
        if (i > 0) {
            G = i;
        }
    }

    public static int y() {
        return P;
    }

    @NonNull
    public static JSONObject eFx() {
        if (pZy == null || pZy.a() == null) {
            return com.ss.android.socialbase.downloader.b.e.g;
        }
        JSONObject a2 = pZy.a();
        a(a2);
        return a2;
    }

    private static void a(JSONObject jSONObject) {
        if (jSONObject != null && TextUtils.isEmpty(com.ss.android.socialbase.downloader.b.e.c)) {
            com.ss.android.socialbase.downloader.b.e.c = jSONObject.optString("kllk");
            if (!TextUtils.isEmpty(com.ss.android.socialbase.downloader.b.e.c)) {
                com.ss.android.socialbase.downloader.b.e.f13373b = com.ss.android.socialbase.downloader.b.e.c.toUpperCase();
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.d.e eVar) {
        pZy = eVar;
        com.ss.android.socialbase.downloader.k.a.a();
        a(eVar.a());
    }

    private static void a(boolean z) {
        Q = z;
    }

    public static boolean A() {
        return Q;
    }

    public static synchronized int B() {
        int i;
        synchronized (b.class) {
            i = L;
        }
        return i;
    }

    public static i eHP() {
        if (pZe == null) {
            synchronized (b.class) {
                if (pZe == null) {
                    pZe = new com.ss.android.socialbase.downloader.impls.c();
                }
            }
        }
        return pZe;
    }

    private static void b(i iVar) {
        if (iVar != null) {
            pZe = iVar;
        }
    }

    public static void a(com.ss.android.socialbase.downloader.d.r rVar) {
        if (rVar != null) {
            pZf = rVar;
        }
    }

    public static com.ss.android.socialbase.downloader.d.r eHQ() {
        return pZf;
    }

    public static h eHR() {
        if (pZu == null) {
            synchronized (b.class) {
                if (pZu == null) {
                    pZu = new com.ss.android.socialbase.downloader.impls.b();
                }
            }
        }
        return pZu;
    }

    private static void b(h hVar) {
        if (hVar != null) {
            pZu = hVar;
        }
    }

    public static s eHS() {
        if (pZw == null) {
            synchronized (b.class) {
                if (pZw == null) {
                    pZw = new com.ss.android.socialbase.downloader.impls.j();
                }
            }
        }
        return pZw;
    }

    public static synchronized Context eHT() {
        Context context;
        synchronized (b.class) {
            context = f13432a;
        }
        return context;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (context != null) {
                if (f13432a == null) {
                    f13432a = context.getApplicationContext();
                    com.ss.android.socialbase.downloader.a.a.eHp().a(f13432a);
                }
            }
        }
    }

    public static int r(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar == null) {
            return 0;
        }
        return a(cVar.j(), cVar.k());
    }

    public static int a(String str, String str2) {
        l eHN = eHN();
        if (eHN == null) {
            return 0;
        }
        return eHN.a(str, str2);
    }

    public static synchronized boolean H() {
        boolean z;
        synchronized (b.class) {
            z = M;
        }
        return z;
    }

    public static com.ss.android.socialbase.downloader.h.c eHU() {
        return pZC;
    }

    public static com.ss.android.socialbase.downloader.h.b eHV() {
        return pZE;
    }

    public static r eHW() {
        return pZD;
    }

    public static void a(com.ss.android.socialbase.downloader.h.b bVar) {
        pZE = bVar;
    }

    public static void a(r rVar) {
    }
}
