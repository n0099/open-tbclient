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
/* loaded from: classes6.dex */
public class b {
    private static int G;
    private static boolean M;
    private static int P;

    /* renamed from: a  reason: collision with root package name */
    private static volatile Context f7819a;
    private static volatile ExecutorService ckj;
    private static volatile ExecutorService p;
    private static volatile ExecutorService psv;
    private static volatile k qfW;
    private static volatile l qfX;
    private static volatile i qfY;
    private static volatile com.ss.android.socialbase.downloader.d.r qfZ;
    private static volatile com.ss.android.socialbase.downloader.impls.a qga;
    private static volatile p qgb;
    private static volatile ab qgc;
    private static volatile p qgd;
    private static volatile com.ss.android.socialbase.downloader.i.h qge;
    private static volatile com.ss.android.socialbase.downloader.i.f qgf;
    private static volatile com.ss.android.socialbase.downloader.i.h qgg;
    private static volatile com.ss.android.socialbase.downloader.i.f qgh;
    private static volatile m qgi;
    private static volatile ExecutorService qgj;
    private static volatile ExecutorService qgk;
    private static volatile ExecutorService qgl;
    private static volatile ExecutorService qgm;
    private static volatile ExecutorService qgn;
    private static volatile h qgo;
    private static volatile DownloadReceiver qgp;
    private static volatile s qgq;
    private static volatile q qgr;
    private static volatile com.ss.android.socialbase.downloader.d.e qgs;
    private static volatile AlarmManager qgu;
    private static com.ss.android.socialbase.downloader.h.c qgv;
    private static r qgw;
    private static com.ss.android.socialbase.downloader.h.b qgx;
    private static volatile List<com.ss.android.socialbase.downloader.d.t> B = new ArrayList();
    private static volatile boolean C = false;
    private static volatile OkHttpClient qgt = null;
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
                    a(gVar.eGM());
                    a(gVar.eGN());
                    b(gVar.eFL());
                    a(gVar.eGU());
                    b(gVar.p());
                    a(gVar.eGO());
                    a(gVar.eGj());
                    a(gVar.eGP());
                    b(gVar.eGQ());
                    c(gVar.eGR());
                    d(gVar.i());
                    e(gVar.eGo());
                    f(gVar.uj());
                    g(gVar.eGp());
                    h(gVar.eGq());
                    i(gVar.eGr());
                    b(gVar.eGS());
                    if (gVar.eGT() != null) {
                        qgr = gVar.eGT();
                    }
                    if (gVar.s() > 1024) {
                        L = gVar.s();
                    }
                    b(gVar.eFM());
                    if (gVar.t()) {
                        C = true;
                    }
                    P = gVar.v();
                    a(gVar.eGV());
                    a(gVar.w());
                }
                if (qfW == null) {
                    qfW = new com.ss.android.socialbase.downloader.impls.d();
                }
                if (qgb == null) {
                    qgb = new com.ss.android.socialbase.downloader.impls.h();
                }
                if (qgd == null) {
                    qgd = new com.ss.android.socialbase.downloader.impls.n();
                }
                if (qfX == null) {
                    qfX = new com.ss.android.socialbase.downloader.impls.i();
                }
                if (qga == null) {
                    qga = new com.ss.android.socialbase.downloader.impls.e();
                }
                if (qfY == null) {
                    qfY = new com.ss.android.socialbase.downloader.impls.c();
                }
                if (qgo == null) {
                    qgo = new com.ss.android.socialbase.downloader.impls.b();
                }
                if (qgq == null) {
                    qgq = new com.ss.android.socialbase.downloader.impls.j();
                }
                if (G <= 0 || G > H) {
                    G = H;
                }
                L();
                if (C && !z && !com.ss.android.socialbase.downloader.m.d.c()) {
                    com.ss.android.socialbase.downloader.impls.l.CM(true).d();
                } else if (com.ss.android.socialbase.downloader.m.d.d()) {
                    ExecutorService uj = uj();
                    if (uj != null) {
                        uj.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.b.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Context eGG = b.eGG();
                                if (eGG != null) {
                                    com.ss.android.socialbase.downloader.m.d.c(eGG);
                                }
                            }
                        });
                    }
                } else {
                    Context eGG = eGG();
                    if (eGG != null) {
                        com.ss.android.socialbase.downloader.m.d.c(eGG);
                    }
                }
                U = true;
            }
        }
    }

    private static void L() {
        if (qgp == null) {
            qgp = new DownloadReceiver();
        }
        if (!F) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                f7819a.registerReceiver(qgp, intentFilter);
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
                Intent intent = new Intent(eGG(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
                eGG().startService(intent);
                if (!com.ss.android.socialbase.downloader.m.d.c()) {
                    com.ss.android.socialbase.downloader.impls.l.CM(true).d();
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

    public static com.ss.android.socialbase.downloader.i.h eGi() {
        return qge;
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

    public static com.ss.android.socialbase.downloader.i.f eGj() {
        return qgf;
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
        int[] Rr = Rr(i2);
        int length = Rr.length;
        int i3 = 0;
        while (i3 < length) {
            try {
                a2 = a(i, str, list, Rr[i3], z2, cVar);
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
        com.ss.android.socialbase.downloader.i.h eGi = i2 == 1 ? eGi() : eGk();
        if (eGi == null) {
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
        com.ss.android.socialbase.downloader.i.g a2 = eGi.a(i, str, list);
        if (z) {
            com.ss.android.socialbase.downloader.h.a.a(a2, str, System.currentTimeMillis() - j, "get", i2, null, cVar);
        }
        return a2;
    }

    public static com.ss.android.socialbase.downloader.i.e v(String str, List<com.ss.android.socialbase.downloader.g.e> list) throws Exception {
        return a(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.i.e a(String str, List<com.ss.android.socialbase.downloader.g.e> list, int i, boolean z, com.ss.android.socialbase.downloader.g.c cVar) throws Exception {
        com.ss.android.socialbase.downloader.i.e b;
        Exception e = null;
        for (int i2 : Rr(i)) {
            try {
                b = b(str, list, i2, z, cVar);
            } catch (Exception e2) {
                e = e2;
            }
            if (b != null) {
                return b;
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
        com.ss.android.socialbase.downloader.i.f eGj = i == 1 ? eGj() : eGl();
        if (eGj == null) {
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
        com.ss.android.socialbase.downloader.i.e v = eGj.v(str, list);
        if (z) {
            com.ss.android.socialbase.downloader.h.a.a(v, str, System.currentTimeMillis() - j, "head", i, null, cVar);
        }
        return v;
    }

    private static int[] Rr(int i) {
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

    public static com.ss.android.socialbase.downloader.i.h eGk() {
        if (qgg == null) {
            synchronized (b.class) {
                if (qgg == null) {
                    qgg = new com.ss.android.socialbase.downloader.impls.g();
                }
            }
        }
        return qgg;
    }

    public static com.ss.android.socialbase.downloader.i.f eGl() {
        if (qgh == null) {
            synchronized (b.class) {
                if (qgh == null) {
                    qgh = new com.ss.android.socialbase.downloader.impls.f();
                }
            }
        }
        return qgh;
    }

    public static AlarmManager eGm() {
        if (qgu == null) {
            synchronized (b.class) {
                if (qgu == null && f7819a != null) {
                    qgu = (AlarmManager) f7819a.getSystemService(NotificationCompat.CATEGORY_ALARM);
                }
            }
        }
        return qgu;
    }

    public static synchronized void a(m mVar) {
        synchronized (b.class) {
            if (mVar != null) {
                qgi = mVar;
                if (qfW instanceof com.ss.android.socialbase.downloader.impls.d) {
                    ((com.ss.android.socialbase.downloader.impls.d) qfW).g();
                }
            }
        }
    }

    private static void b(ExecutorService executorService) {
        if (executorService != null) {
            ckj = executorService;
        }
    }

    private static void c(ExecutorService executorService) {
        if (executorService != null) {
            p = executorService;
        }
    }

    private static void d(ExecutorService executorService) {
        if (executorService != null) {
            qgj = executorService;
        }
    }

    private static void e(ExecutorService executorService) {
        if (executorService != null) {
            qgk = executorService;
        }
    }

    private static void f(ExecutorService executorService) {
        if (executorService != null) {
            qgl = executorService;
        }
    }

    private static void g(ExecutorService executorService) {
        if (executorService != null) {
            psv = executorService;
        }
    }

    public static void h(ExecutorService executorService) {
        if (executorService != null) {
            qgm = executorService;
        }
    }

    public static void i(ExecutorService executorService) {
        if (executorService != null) {
            qgn = executorService;
        }
    }

    private static void b(ab abVar) {
        if (qgc == null) {
            qgc = abVar;
        }
    }

    public static synchronized q eGn() {
        q qVar;
        synchronized (b.class) {
            qVar = qgr;
        }
        return qVar;
    }

    public static void a(Runnable runnable) {
        e(runnable, false);
    }

    public static void d(Runnable runnable, boolean z) {
        if (runnable != null) {
            if (z && !com.ss.android.socialbase.downloader.m.d.d()) {
                runnable.run();
            } else {
                eGo().execute(runnable);
            }
        }
    }

    public static void e(Runnable runnable, boolean z) {
        if (runnable != null) {
            if (z && !com.ss.android.socialbase.downloader.m.d.d()) {
                runnable.run();
            } else {
                uj().execute(runnable);
            }
        }
    }

    public static void b(Runnable runnable) {
        if (runnable != null) {
            if (!com.ss.android.socialbase.downloader.m.d.d()) {
                runnable.run();
            } else {
                eGt().execute(runnable);
            }
        }
    }

    public static ExecutorService eGo() {
        if (ckj == null) {
            synchronized (b.class) {
                if (ckj == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(H, H, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-cpu-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    ckj = threadPoolExecutor;
                }
            }
        }
        return ckj;
    }

    public static ExecutorService uj() {
        return p != null ? p : eGo();
    }

    public static ExecutorService eGp() {
        return qgk != null ? qgk : eGr();
    }

    public static ExecutorService eGq() {
        return qgl != null ? qgl : eGr();
    }

    public static ExecutorService eGr() {
        if (qgj == null) {
            synchronized (b.class) {
                if (qgj == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(J, J, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-mix-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    qgj = threadPoolExecutor;
                }
            }
        }
        return qgj;
    }

    public static ExecutorService eGs() {
        if (qgm == null) {
            synchronized (b.class) {
                if (qgm == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(I, I, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-chunk-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    qgm = threadPoolExecutor;
                }
            }
        }
        return qgm;
    }

    public static ExecutorService eGt() {
        if (psv == null) {
            synchronized (b.class) {
                if (psv == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(K, K, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-db-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    psv = threadPoolExecutor;
                }
            }
        }
        return psv;
    }

    public static OkHttpClient eGu() {
        if (qgt == null) {
            synchronized (b.class) {
                if (qgt == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
                    if (qgn != null) {
                        builder.dispatcher(new Dispatcher(qgn));
                    }
                    qgt = builder.build();
                }
            }
        }
        return qgt;
    }

    public static synchronized m eGv() {
        m mVar;
        synchronized (b.class) {
            mVar = qgi;
        }
        return mVar;
    }

    private static void a(com.ss.android.socialbase.downloader.i.h hVar) {
        if (hVar != null) {
            qge = hVar;
        }
        M = qge != null;
    }

    private static void a(com.ss.android.socialbase.downloader.i.f fVar) {
        if (fVar != null) {
            qgf = fVar;
        }
    }

    public static k eGw() {
        if (qfW == null) {
            synchronized (b.class) {
                if (qfW == null) {
                    qfW = new com.ss.android.socialbase.downloader.impls.d();
                }
            }
        }
        return qfW;
    }

    private static void a(k kVar) {
        if (kVar != null) {
            qfW = kVar;
        }
    }

    public static p eGx() {
        if (qgb == null) {
            synchronized (b.class) {
                if (qgb == null) {
                    qgb = new com.ss.android.socialbase.downloader.impls.h();
                }
            }
        }
        return qgb;
    }

    public static p eGy() {
        if (qgd == null) {
            synchronized (b.class) {
                if (qgd == null) {
                    qgd = new com.ss.android.socialbase.downloader.impls.n();
                }
            }
        }
        return qgd;
    }

    public static ab eGz() {
        return qgc;
    }

    public static l eGA() {
        if (qfX == null) {
            synchronized (b.class) {
                if (qfX == null) {
                    qfX = new com.ss.android.socialbase.downloader.impls.i();
                }
            }
        }
        return qfX;
    }

    public static com.ss.android.socialbase.downloader.impls.a eGB() {
        if (qga == null) {
            synchronized (b.class) {
                if (qga == null) {
                    qga = new com.ss.android.socialbase.downloader.impls.e();
                }
            }
        }
        return qga;
    }

    private static void a(l lVar) {
        if (lVar != null) {
            qfX = lVar;
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
    public static JSONObject z() {
        if (qgs == null || qgs.a() == null) {
            return com.ss.android.socialbase.downloader.b.e.g;
        }
        JSONObject a2 = qgs.a();
        a(a2);
        return a2;
    }

    private static void a(JSONObject jSONObject) {
        if (jSONObject != null && TextUtils.isEmpty(com.ss.android.socialbase.downloader.b.e.c)) {
            com.ss.android.socialbase.downloader.b.e.c = jSONObject.optString("kllk");
            if (!TextUtils.isEmpty(com.ss.android.socialbase.downloader.b.e.c)) {
                com.ss.android.socialbase.downloader.b.e.b = com.ss.android.socialbase.downloader.b.e.c.toUpperCase();
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.d.e eVar) {
        qgs = eVar;
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

    public static i eGC() {
        if (qfY == null) {
            synchronized (b.class) {
                if (qfY == null) {
                    qfY = new com.ss.android.socialbase.downloader.impls.c();
                }
            }
        }
        return qfY;
    }

    private static void b(i iVar) {
        if (iVar != null) {
            qfY = iVar;
        }
    }

    public static void a(com.ss.android.socialbase.downloader.d.r rVar) {
        if (rVar != null) {
            qfZ = rVar;
        }
    }

    public static com.ss.android.socialbase.downloader.d.r eGD() {
        return qfZ;
    }

    public static h eGE() {
        if (qgo == null) {
            synchronized (b.class) {
                if (qgo == null) {
                    qgo = new com.ss.android.socialbase.downloader.impls.b();
                }
            }
        }
        return qgo;
    }

    private static void b(h hVar) {
        if (hVar != null) {
            qgo = hVar;
        }
    }

    public static s eGF() {
        if (qgq == null) {
            synchronized (b.class) {
                if (qgq == null) {
                    qgq = new com.ss.android.socialbase.downloader.impls.j();
                }
            }
        }
        return qgq;
    }

    public static synchronized Context eGG() {
        Context context;
        synchronized (b.class) {
            context = f7819a;
        }
        return context;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (context != null) {
                if (f7819a == null) {
                    f7819a = context.getApplicationContext();
                    com.ss.android.socialbase.downloader.a.a.eGc().a(f7819a);
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
        l eGA = eGA();
        if (eGA == null) {
            return 0;
        }
        return eGA.a(str, str2);
    }

    public static synchronized boolean H() {
        boolean z;
        synchronized (b.class) {
            z = M;
        }
        return z;
    }

    public static com.ss.android.socialbase.downloader.h.c eGH() {
        return qgv;
    }

    public static com.ss.android.socialbase.downloader.h.b eGI() {
        return qgx;
    }

    public static r eGJ() {
        return qgw;
    }

    public static void a(com.ss.android.socialbase.downloader.h.b bVar) {
        qgx = bVar;
    }

    public static void a(r rVar) {
    }
}
