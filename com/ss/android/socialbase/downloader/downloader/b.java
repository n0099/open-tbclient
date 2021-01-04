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
    private static volatile Context f13431a;
    private static volatile ExecutorService cjn;
    private static volatile ExecutorService p;
    private static volatile ab pXA;
    private static volatile p pXB;
    private static volatile com.ss.android.socialbase.downloader.i.h pXC;
    private static volatile com.ss.android.socialbase.downloader.i.f pXD;
    private static volatile com.ss.android.socialbase.downloader.i.h pXE;
    private static volatile com.ss.android.socialbase.downloader.i.f pXF;
    private static volatile m pXG;
    private static volatile ExecutorService pXH;
    private static volatile ExecutorService pXI;
    private static volatile ExecutorService pXJ;
    private static volatile ExecutorService pXK;
    private static volatile ExecutorService pXL;
    private static volatile h pXM;
    private static volatile DownloadReceiver pXN;
    private static volatile s pXO;
    private static volatile q pXP;
    private static volatile com.ss.android.socialbase.downloader.d.e pXQ;
    private static volatile AlarmManager pXS;
    private static com.ss.android.socialbase.downloader.h.c pXU;
    private static r pXV;
    private static com.ss.android.socialbase.downloader.h.b pXW;
    private static volatile k pXu;
    private static volatile l pXv;
    private static volatile i pXw;
    private static volatile com.ss.android.socialbase.downloader.d.r pXx;
    private static volatile com.ss.android.socialbase.downloader.impls.a pXy;
    private static volatile p pXz;
    private static volatile ExecutorService pkc;
    private static volatile List<com.ss.android.socialbase.downloader.d.t> B = new ArrayList();
    private static volatile boolean C = false;
    private static volatile OkHttpClient pXR = null;
    private static boolean F = false;
    private static final int H = Runtime.getRuntime().availableProcessors() + 1;
    private static final int I = (Runtime.getRuntime().availableProcessors() * 2) + 1;
    private static final int J = H;
    private static final int K = H;
    private static int L = 8192;
    private static final List<aa> pXT = new ArrayList();
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
                    a(gVar.eHv());
                    a(gVar.eHw());
                    b(gVar.eGu());
                    a(gVar.eHD());
                    b(gVar.p());
                    a(gVar.eHx());
                    a(gVar.eGS());
                    a(gVar.eHy());
                    c(gVar.eHz());
                    d(gVar.eHA());
                    e(gVar.i());
                    f(gVar.eGX());
                    g(gVar.ut());
                    h(gVar.eGY());
                    a(gVar.eGZ());
                    i(gVar.eHa());
                    b(gVar.eHB());
                    if (gVar.eHC() != null) {
                        pXP = gVar.eHC();
                    }
                    if (gVar.s() > 1024) {
                        L = gVar.s();
                    }
                    b(gVar.eGv());
                    if (gVar.t()) {
                        C = true;
                    }
                    P = gVar.v();
                    a(gVar.eHE());
                    a(gVar.w());
                }
                if (pXu == null) {
                    pXu = new com.ss.android.socialbase.downloader.impls.d();
                }
                if (pXz == null) {
                    pXz = new com.ss.android.socialbase.downloader.impls.h();
                }
                if (pXB == null) {
                    pXB = new com.ss.android.socialbase.downloader.impls.n();
                }
                if (pXv == null) {
                    pXv = new com.ss.android.socialbase.downloader.impls.i();
                }
                if (pXy == null) {
                    pXy = new com.ss.android.socialbase.downloader.impls.e();
                }
                if (pXw == null) {
                    pXw = new com.ss.android.socialbase.downloader.impls.c();
                }
                if (pXM == null) {
                    pXM = new com.ss.android.socialbase.downloader.impls.b();
                }
                if (pXO == null) {
                    pXO = new com.ss.android.socialbase.downloader.impls.j();
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
                                Context eHp = b.eHp();
                                if (eHp != null) {
                                    com.ss.android.socialbase.downloader.m.d.c(eHp);
                                }
                            }
                        });
                    }
                } else {
                    Context eHp = eHp();
                    if (eHp != null) {
                        com.ss.android.socialbase.downloader.m.d.c(eHp);
                    }
                }
                U = true;
            }
        }
    }

    private static void L() {
        if (pXN == null) {
            pXN = new DownloadReceiver();
        }
        if (!F) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                f13431a.registerReceiver(pXN, intentFilter);
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
                Intent intent = new Intent(eHp(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
                eHp().startService(intent);
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

    public static com.ss.android.socialbase.downloader.i.h eGR() {
        return pXC;
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
        synchronized (pXT) {
            if (pXT != null) {
                for (aa aaVar : pXT) {
                    if (aaVar != null) {
                        if (dVar == com.ss.android.socialbase.downloader.b.d.SYNC_START) {
                            aaVar.a();
                        } else if (dVar == com.ss.android.socialbase.downloader.b.d.SYNC_SUCCESS) {
                            aaVar.b();
                        }
                    }
                }
                pXT.clear();
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

    public static com.ss.android.socialbase.downloader.i.f eGS() {
        return pXD;
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
        int[] Si = Si(i2);
        int length = Si.length;
        int i3 = 0;
        while (i3 < length) {
            try {
                a2 = a(i, str, list, Si[i3], z2, cVar);
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
        com.ss.android.socialbase.downloader.i.h eGR = i2 == 1 ? eGR() : eGT();
        if (eGR == null) {
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
        com.ss.android.socialbase.downloader.i.g a2 = eGR.a(i, str, list);
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
        for (int i2 : Si(i)) {
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
        com.ss.android.socialbase.downloader.i.f eGS = i == 1 ? eGS() : eGU();
        if (eGS == null) {
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
        com.ss.android.socialbase.downloader.i.e v = eGS.v(str, list);
        if (z) {
            com.ss.android.socialbase.downloader.h.a.a(v, str, System.currentTimeMillis() - j, "head", i, null, cVar);
        }
        return v;
    }

    private static int[] Si(int i) {
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

    public static com.ss.android.socialbase.downloader.i.h eGT() {
        if (pXE == null) {
            synchronized (b.class) {
                if (pXE == null) {
                    pXE = new com.ss.android.socialbase.downloader.impls.g();
                }
            }
        }
        return pXE;
    }

    public static com.ss.android.socialbase.downloader.i.f eGU() {
        if (pXF == null) {
            synchronized (b.class) {
                if (pXF == null) {
                    pXF = new com.ss.android.socialbase.downloader.impls.f();
                }
            }
        }
        return pXF;
    }

    public static AlarmManager eGV() {
        if (pXS == null) {
            synchronized (b.class) {
                if (pXS == null && f13431a != null) {
                    pXS = (AlarmManager) f13431a.getSystemService(NotificationCompat.CATEGORY_ALARM);
                }
            }
        }
        return pXS;
    }

    public static synchronized void a(m mVar) {
        synchronized (b.class) {
            if (mVar != null) {
                pXG = mVar;
                if (pXu instanceof com.ss.android.socialbase.downloader.impls.d) {
                    ((com.ss.android.socialbase.downloader.impls.d) pXu).g();
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
            pXH = executorService;
        }
    }

    private static void f(ExecutorService executorService) {
        if (executorService != null) {
            pXI = executorService;
        }
    }

    private static void g(ExecutorService executorService) {
        if (executorService != null) {
            pXJ = executorService;
        }
    }

    private static void h(ExecutorService executorService) {
        if (executorService != null) {
            pkc = executorService;
        }
    }

    public static void a(ExecutorService executorService) {
        if (executorService != null) {
            pXK = executorService;
        }
    }

    public static void i(ExecutorService executorService) {
        if (executorService != null) {
            pXL = executorService;
        }
    }

    private static void b(ab abVar) {
        if (pXA == null) {
            pXA = abVar;
        }
    }

    public static synchronized q eGW() {
        q qVar;
        synchronized (b.class) {
            qVar = pXP;
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
                eGX().execute(runnable);
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
                eHc().execute(runnable);
            }
        }
    }

    public static ExecutorService eGX() {
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
        return p != null ? p : eGX();
    }

    public static ExecutorService eGY() {
        return pXI != null ? pXI : eHa();
    }

    public static ExecutorService eGZ() {
        return pXJ != null ? pXJ : eHa();
    }

    public static ExecutorService eHa() {
        if (pXH == null) {
            synchronized (b.class) {
                if (pXH == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(J, J, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-mix-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    pXH = threadPoolExecutor;
                }
            }
        }
        return pXH;
    }

    public static ExecutorService eHb() {
        if (pXK == null) {
            synchronized (b.class) {
                if (pXK == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(I, I, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-chunk-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    pXK = threadPoolExecutor;
                }
            }
        }
        return pXK;
    }

    public static ExecutorService eHc() {
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

    public static OkHttpClient eHd() {
        if (pXR == null) {
            synchronized (b.class) {
                if (pXR == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
                    if (pXL != null) {
                        builder.dispatcher(new Dispatcher(pXL));
                    }
                    pXR = builder.build();
                }
            }
        }
        return pXR;
    }

    public static synchronized m eHe() {
        m mVar;
        synchronized (b.class) {
            mVar = pXG;
        }
        return mVar;
    }

    private static void a(com.ss.android.socialbase.downloader.i.h hVar) {
        if (hVar != null) {
            pXC = hVar;
        }
        M = pXC != null;
    }

    private static void a(com.ss.android.socialbase.downloader.i.f fVar) {
        if (fVar != null) {
            pXD = fVar;
        }
    }

    public static k eHf() {
        if (pXu == null) {
            synchronized (b.class) {
                if (pXu == null) {
                    pXu = new com.ss.android.socialbase.downloader.impls.d();
                }
            }
        }
        return pXu;
    }

    private static void a(k kVar) {
        if (kVar != null) {
            pXu = kVar;
        }
    }

    public static p eHg() {
        if (pXz == null) {
            synchronized (b.class) {
                if (pXz == null) {
                    pXz = new com.ss.android.socialbase.downloader.impls.h();
                }
            }
        }
        return pXz;
    }

    public static p eHh() {
        if (pXB == null) {
            synchronized (b.class) {
                if (pXB == null) {
                    pXB = new com.ss.android.socialbase.downloader.impls.n();
                }
            }
        }
        return pXB;
    }

    public static ab eHi() {
        return pXA;
    }

    public static l eHj() {
        if (pXv == null) {
            synchronized (b.class) {
                if (pXv == null) {
                    pXv = new com.ss.android.socialbase.downloader.impls.i();
                }
            }
        }
        return pXv;
    }

    public static com.ss.android.socialbase.downloader.impls.a eHk() {
        if (pXy == null) {
            synchronized (b.class) {
                if (pXy == null) {
                    pXy = new com.ss.android.socialbase.downloader.impls.e();
                }
            }
        }
        return pXy;
    }

    private static void a(l lVar) {
        if (lVar != null) {
            pXv = lVar;
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
    public static JSONObject eET() {
        if (pXQ == null || pXQ.a() == null) {
            return com.ss.android.socialbase.downloader.b.e.g;
        }
        JSONObject a2 = pXQ.a();
        a(a2);
        return a2;
    }

    private static void a(JSONObject jSONObject) {
        if (jSONObject != null && TextUtils.isEmpty(com.ss.android.socialbase.downloader.b.e.c)) {
            com.ss.android.socialbase.downloader.b.e.c = jSONObject.optString("kllk");
            if (!TextUtils.isEmpty(com.ss.android.socialbase.downloader.b.e.c)) {
                com.ss.android.socialbase.downloader.b.e.f13372b = com.ss.android.socialbase.downloader.b.e.c.toUpperCase();
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.d.e eVar) {
        pXQ = eVar;
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

    public static i eHl() {
        if (pXw == null) {
            synchronized (b.class) {
                if (pXw == null) {
                    pXw = new com.ss.android.socialbase.downloader.impls.c();
                }
            }
        }
        return pXw;
    }

    private static void b(i iVar) {
        if (iVar != null) {
            pXw = iVar;
        }
    }

    public static void a(com.ss.android.socialbase.downloader.d.r rVar) {
        if (rVar != null) {
            pXx = rVar;
        }
    }

    public static com.ss.android.socialbase.downloader.d.r eHm() {
        return pXx;
    }

    public static h eHn() {
        if (pXM == null) {
            synchronized (b.class) {
                if (pXM == null) {
                    pXM = new com.ss.android.socialbase.downloader.impls.b();
                }
            }
        }
        return pXM;
    }

    private static void b(h hVar) {
        if (hVar != null) {
            pXM = hVar;
        }
    }

    public static s eHo() {
        if (pXO == null) {
            synchronized (b.class) {
                if (pXO == null) {
                    pXO = new com.ss.android.socialbase.downloader.impls.j();
                }
            }
        }
        return pXO;
    }

    public static synchronized Context eHp() {
        Context context;
        synchronized (b.class) {
            context = f13431a;
        }
        return context;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (context != null) {
                if (f13431a == null) {
                    f13431a = context.getApplicationContext();
                    com.ss.android.socialbase.downloader.a.a.eGL().a(f13431a);
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
        l eHj = eHj();
        if (eHj == null) {
            return 0;
        }
        return eHj.a(str, str2);
    }

    public static synchronized boolean H() {
        boolean z;
        synchronized (b.class) {
            z = M;
        }
        return z;
    }

    public static com.ss.android.socialbase.downloader.h.c eHq() {
        return pXU;
    }

    public static com.ss.android.socialbase.downloader.h.b eHr() {
        return pXW;
    }

    public static r eHs() {
        return pXV;
    }

    public static void a(com.ss.android.socialbase.downloader.h.b bVar) {
        pXW = bVar;
    }

    public static void a(r rVar) {
    }
}
