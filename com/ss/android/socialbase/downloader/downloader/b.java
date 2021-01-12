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
    private static volatile Context f13132a;
    private static volatile ExecutorService ceA;
    private static volatile ExecutorService p;
    private static volatile k pUC;
    private static volatile l pUD;
    private static volatile i pUE;
    private static volatile com.ss.android.socialbase.downloader.d.r pUF;
    private static volatile com.ss.android.socialbase.downloader.impls.a pUG;
    private static volatile p pUH;
    private static volatile ab pUI;
    private static volatile p pUJ;
    private static volatile com.ss.android.socialbase.downloader.i.h pUK;
    private static volatile com.ss.android.socialbase.downloader.i.f pUL;
    private static volatile com.ss.android.socialbase.downloader.i.h pUM;
    private static volatile com.ss.android.socialbase.downloader.i.f pUN;
    private static volatile m pUO;
    private static volatile ExecutorService pUP;
    private static volatile ExecutorService pUQ;
    private static volatile ExecutorService pUR;
    private static volatile ExecutorService pUS;
    private static volatile ExecutorService pUT;
    private static volatile h pUU;
    private static volatile DownloadReceiver pUV;
    private static volatile s pUW;
    private static volatile q pUX;
    private static volatile com.ss.android.socialbase.downloader.d.e pUY;
    private static volatile AlarmManager pVa;
    private static com.ss.android.socialbase.downloader.h.c pVb;
    private static r pVc;
    private static com.ss.android.socialbase.downloader.h.b pVd;
    private static volatile ExecutorService pfx;
    private static volatile List<com.ss.android.socialbase.downloader.d.t> B = new ArrayList();
    private static volatile boolean C = false;
    private static volatile OkHttpClient pUZ = null;
    private static boolean F = false;
    private static final int H = Runtime.getRuntime().availableProcessors() + 1;
    private static final int I = (Runtime.getRuntime().availableProcessors() * 2) + 1;
    private static final int J = H;
    private static final int K = H;
    private static int L = 8192;
    private static final List<aa> N = new ArrayList();
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
                    a(gVar.eEj());
                    a(gVar.eEk());
                    b(gVar.eDi());
                    a(gVar.eEr());
                    b(gVar.p());
                    a(gVar.eEl());
                    a(gVar.eDG());
                    a(gVar.eEm());
                    c(gVar.eEn());
                    d(gVar.eEo());
                    e(gVar.i());
                    f(gVar.eDL());
                    g(gVar.um());
                    h(gVar.eDM());
                    i(gVar.eDN());
                    j(gVar.eDO());
                    b(gVar.eEp());
                    if (gVar.eEq() != null) {
                        pUX = gVar.eEq();
                    }
                    if (gVar.s() > 1024) {
                        L = gVar.s();
                    }
                    b(gVar.eDj());
                    if (gVar.t()) {
                        C = true;
                    }
                    P = gVar.v();
                    a(gVar.eEs());
                    a(gVar.w());
                }
                if (pUC == null) {
                    pUC = new com.ss.android.socialbase.downloader.impls.d();
                }
                if (pUH == null) {
                    pUH = new com.ss.android.socialbase.downloader.impls.h();
                }
                if (pUJ == null) {
                    pUJ = new com.ss.android.socialbase.downloader.impls.n();
                }
                if (pUD == null) {
                    pUD = new com.ss.android.socialbase.downloader.impls.i();
                }
                if (pUG == null) {
                    pUG = new com.ss.android.socialbase.downloader.impls.e();
                }
                if (pUE == null) {
                    pUE = new com.ss.android.socialbase.downloader.impls.c();
                }
                if (pUU == null) {
                    pUU = new com.ss.android.socialbase.downloader.impls.b();
                }
                if (pUW == null) {
                    pUW = new com.ss.android.socialbase.downloader.impls.j();
                }
                if (G <= 0 || G > H) {
                    G = H;
                }
                L();
                if (C && !z && !com.ss.android.socialbase.downloader.m.d.c()) {
                    com.ss.android.socialbase.downloader.impls.l.Cu(true).d();
                } else if (com.ss.android.socialbase.downloader.m.d.d()) {
                    ExecutorService um = um();
                    if (um != null) {
                        um.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.b.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Context eEd = b.eEd();
                                if (eEd != null) {
                                    com.ss.android.socialbase.downloader.m.d.c(eEd);
                                }
                            }
                        });
                    }
                } else {
                    Context eEd = eEd();
                    if (eEd != null) {
                        com.ss.android.socialbase.downloader.m.d.c(eEd);
                    }
                }
                U = true;
            }
        }
    }

    private static void L() {
        if (pUV == null) {
            pUV = new DownloadReceiver();
        }
        if (!F) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                f13132a.registerReceiver(pUV, intentFilter);
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
                Intent intent = new Intent(eEd(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
                eEd().startService(intent);
                if (!com.ss.android.socialbase.downloader.m.d.c()) {
                    com.ss.android.socialbase.downloader.impls.l.Cu(true).d();
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

    public static com.ss.android.socialbase.downloader.i.h eDF() {
        return pUK;
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
        synchronized (N) {
            if (N != null) {
                for (aa aaVar : N) {
                    if (aaVar != null) {
                        if (dVar == com.ss.android.socialbase.downloader.b.d.SYNC_START) {
                            aaVar.a();
                        } else if (dVar == com.ss.android.socialbase.downloader.b.d.SYNC_SUCCESS) {
                            aaVar.b();
                        }
                    }
                }
                N.clear();
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

    public static com.ss.android.socialbase.downloader.i.f eDG() {
        return pUL;
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
        int[] QR = QR(i2);
        int length = QR.length;
        int i3 = 0;
        while (i3 < length) {
            try {
                a2 = a(i, str, list, QR[i3], z2, cVar);
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
        com.ss.android.socialbase.downloader.i.h eDF = i2 == 1 ? eDF() : eDH();
        if (eDF == null) {
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
        com.ss.android.socialbase.downloader.i.g a2 = eDF.a(i, str, list);
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
        for (int i2 : QR(i)) {
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
        com.ss.android.socialbase.downloader.i.f eDG = i == 1 ? eDG() : eDI();
        if (eDG == null) {
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
        com.ss.android.socialbase.downloader.i.e v = eDG.v(str, list);
        if (z) {
            com.ss.android.socialbase.downloader.h.a.a(v, str, System.currentTimeMillis() - j, "head", i, null, cVar);
        }
        return v;
    }

    private static int[] QR(int i) {
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

    public static com.ss.android.socialbase.downloader.i.h eDH() {
        if (pUM == null) {
            synchronized (b.class) {
                if (pUM == null) {
                    pUM = new com.ss.android.socialbase.downloader.impls.g();
                }
            }
        }
        return pUM;
    }

    public static com.ss.android.socialbase.downloader.i.f eDI() {
        if (pUN == null) {
            synchronized (b.class) {
                if (pUN == null) {
                    pUN = new com.ss.android.socialbase.downloader.impls.f();
                }
            }
        }
        return pUN;
    }

    public static AlarmManager eDJ() {
        if (pVa == null) {
            synchronized (b.class) {
                if (pVa == null && f13132a != null) {
                    pVa = (AlarmManager) f13132a.getSystemService(NotificationCompat.CATEGORY_ALARM);
                }
            }
        }
        return pVa;
    }

    public static synchronized void a(m mVar) {
        synchronized (b.class) {
            if (mVar != null) {
                pUO = mVar;
                if (pUC instanceof com.ss.android.socialbase.downloader.impls.d) {
                    ((com.ss.android.socialbase.downloader.impls.d) pUC).g();
                }
            }
        }
    }

    private static void c(ExecutorService executorService) {
        if (executorService != null) {
            ceA = executorService;
        }
    }

    private static void d(ExecutorService executorService) {
        if (executorService != null) {
            p = executorService;
        }
    }

    private static void e(ExecutorService executorService) {
        if (executorService != null) {
            pUP = executorService;
        }
    }

    private static void f(ExecutorService executorService) {
        if (executorService != null) {
            pUQ = executorService;
        }
    }

    private static void g(ExecutorService executorService) {
        if (executorService != null) {
            pUR = executorService;
        }
    }

    private static void h(ExecutorService executorService) {
        if (executorService != null) {
            pfx = executorService;
        }
    }

    public static void i(ExecutorService executorService) {
        if (executorService != null) {
            pUS = executorService;
        }
    }

    public static void j(ExecutorService executorService) {
        if (executorService != null) {
            pUT = executorService;
        }
    }

    private static void b(ab abVar) {
        if (pUI == null) {
            pUI = abVar;
        }
    }

    public static synchronized q eDK() {
        q qVar;
        synchronized (b.class) {
            qVar = pUX;
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
                eDL().execute(runnable);
            }
        }
    }

    public static void d(Runnable runnable, boolean z) {
        if (runnable != null) {
            if (z && !com.ss.android.socialbase.downloader.m.d.d()) {
                runnable.run();
            } else {
                um().execute(runnable);
            }
        }
    }

    public static void b(Runnable runnable) {
        if (runnable != null) {
            if (!com.ss.android.socialbase.downloader.m.d.d()) {
                runnable.run();
            } else {
                eDQ().execute(runnable);
            }
        }
    }

    public static ExecutorService eDL() {
        if (ceA == null) {
            synchronized (b.class) {
                if (ceA == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(H, H, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-cpu-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    ceA = threadPoolExecutor;
                }
            }
        }
        return ceA;
    }

    public static ExecutorService um() {
        return p != null ? p : eDL();
    }

    public static ExecutorService eDM() {
        return pUQ != null ? pUQ : eDO();
    }

    public static ExecutorService eDN() {
        return pUR != null ? pUR : eDO();
    }

    public static ExecutorService eDO() {
        if (pUP == null) {
            synchronized (b.class) {
                if (pUP == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(J, J, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-mix-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    pUP = threadPoolExecutor;
                }
            }
        }
        return pUP;
    }

    public static ExecutorService eDP() {
        if (pUS == null) {
            synchronized (b.class) {
                if (pUS == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(I, I, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-chunk-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    pUS = threadPoolExecutor;
                }
            }
        }
        return pUS;
    }

    public static ExecutorService eDQ() {
        if (pfx == null) {
            synchronized (b.class) {
                if (pfx == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(K, K, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-db-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    pfx = threadPoolExecutor;
                }
            }
        }
        return pfx;
    }

    public static OkHttpClient eDR() {
        if (pUZ == null) {
            synchronized (b.class) {
                if (pUZ == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
                    if (pUT != null) {
                        builder.dispatcher(new Dispatcher(pUT));
                    }
                    pUZ = builder.build();
                }
            }
        }
        return pUZ;
    }

    public static synchronized m eDS() {
        m mVar;
        synchronized (b.class) {
            mVar = pUO;
        }
        return mVar;
    }

    private static void a(com.ss.android.socialbase.downloader.i.h hVar) {
        if (hVar != null) {
            pUK = hVar;
        }
        M = pUK != null;
    }

    private static void a(com.ss.android.socialbase.downloader.i.f fVar) {
        if (fVar != null) {
            pUL = fVar;
        }
    }

    public static k eDT() {
        if (pUC == null) {
            synchronized (b.class) {
                if (pUC == null) {
                    pUC = new com.ss.android.socialbase.downloader.impls.d();
                }
            }
        }
        return pUC;
    }

    private static void a(k kVar) {
        if (kVar != null) {
            pUC = kVar;
        }
    }

    public static p eDU() {
        if (pUH == null) {
            synchronized (b.class) {
                if (pUH == null) {
                    pUH = new com.ss.android.socialbase.downloader.impls.h();
                }
            }
        }
        return pUH;
    }

    public static p eDV() {
        if (pUJ == null) {
            synchronized (b.class) {
                if (pUJ == null) {
                    pUJ = new com.ss.android.socialbase.downloader.impls.n();
                }
            }
        }
        return pUJ;
    }

    public static ab eDW() {
        return pUI;
    }

    public static l eDX() {
        if (pUD == null) {
            synchronized (b.class) {
                if (pUD == null) {
                    pUD = new com.ss.android.socialbase.downloader.impls.i();
                }
            }
        }
        return pUD;
    }

    public static com.ss.android.socialbase.downloader.impls.a eDY() {
        if (pUG == null) {
            synchronized (b.class) {
                if (pUG == null) {
                    pUG = new com.ss.android.socialbase.downloader.impls.e();
                }
            }
        }
        return pUG;
    }

    private static void a(l lVar) {
        if (lVar != null) {
            pUD = lVar;
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
    public static JSONObject eBG() {
        if (pUY == null || pUY.a() == null) {
            return com.ss.android.socialbase.downloader.b.e.g;
        }
        JSONObject a2 = pUY.a();
        a(a2);
        return a2;
    }

    private static void a(JSONObject jSONObject) {
        if (jSONObject != null && TextUtils.isEmpty(com.ss.android.socialbase.downloader.b.e.c)) {
            com.ss.android.socialbase.downloader.b.e.c = jSONObject.optString("kllk");
            if (!TextUtils.isEmpty(com.ss.android.socialbase.downloader.b.e.c)) {
                com.ss.android.socialbase.downloader.b.e.f13073b = com.ss.android.socialbase.downloader.b.e.c.toUpperCase();
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.d.e eVar) {
        pUY = eVar;
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

    public static i eDZ() {
        if (pUE == null) {
            synchronized (b.class) {
                if (pUE == null) {
                    pUE = new com.ss.android.socialbase.downloader.impls.c();
                }
            }
        }
        return pUE;
    }

    private static void b(i iVar) {
        if (iVar != null) {
            pUE = iVar;
        }
    }

    public static void a(com.ss.android.socialbase.downloader.d.r rVar) {
        if (rVar != null) {
            pUF = rVar;
        }
    }

    public static com.ss.android.socialbase.downloader.d.r eEa() {
        return pUF;
    }

    public static h eEb() {
        if (pUU == null) {
            synchronized (b.class) {
                if (pUU == null) {
                    pUU = new com.ss.android.socialbase.downloader.impls.b();
                }
            }
        }
        return pUU;
    }

    private static void b(h hVar) {
        if (hVar != null) {
            pUU = hVar;
        }
    }

    public static s eEc() {
        if (pUW == null) {
            synchronized (b.class) {
                if (pUW == null) {
                    pUW = new com.ss.android.socialbase.downloader.impls.j();
                }
            }
        }
        return pUW;
    }

    public static synchronized Context eEd() {
        Context context;
        synchronized (b.class) {
            context = f13132a;
        }
        return context;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (context != null) {
                if (f13132a == null) {
                    f13132a = context.getApplicationContext();
                    com.ss.android.socialbase.downloader.a.a.eDz().a(f13132a);
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
        l eDX = eDX();
        if (eDX == null) {
            return 0;
        }
        return eDX.a(str, str2);
    }

    public static synchronized boolean H() {
        boolean z;
        synchronized (b.class) {
            z = M;
        }
        return z;
    }

    public static com.ss.android.socialbase.downloader.h.c eEe() {
        return pVb;
    }

    public static com.ss.android.socialbase.downloader.h.b eEf() {
        return pVd;
    }

    public static r eEg() {
        return pVc;
    }

    public static void a(com.ss.android.socialbase.downloader.h.b bVar) {
        pVd = bVar;
    }

    public static void a(r rVar) {
    }
}
