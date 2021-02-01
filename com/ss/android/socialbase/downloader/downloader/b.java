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
    private static volatile Context f13134a;
    private static volatile ExecutorService ciJ;
    private static volatile ExecutorService p;
    private static volatile ExecutorService ppQ;
    private static volatile k qeH;
    private static volatile l qeI;
    private static volatile i qeJ;
    private static volatile com.ss.android.socialbase.downloader.d.r qeK;
    private static volatile com.ss.android.socialbase.downloader.impls.a qeL;
    private static volatile p qeM;
    private static volatile ab qeN;
    private static volatile p qeO;
    private static volatile com.ss.android.socialbase.downloader.i.h qeP;
    private static volatile com.ss.android.socialbase.downloader.i.f qeQ;
    private static volatile com.ss.android.socialbase.downloader.i.h qeR;
    private static volatile com.ss.android.socialbase.downloader.i.f qeS;
    private static volatile m qeT;
    private static volatile ExecutorService qeU;
    private static volatile ExecutorService qeV;
    private static volatile ExecutorService qeW;
    private static volatile ExecutorService qeX;
    private static volatile ExecutorService qeY;
    private static volatile h qeZ;
    private static volatile DownloadReceiver qfa;
    private static volatile s qfb;
    private static volatile q qfc;
    private static volatile com.ss.android.socialbase.downloader.d.e qfd;
    private static volatile AlarmManager qff;
    private static com.ss.android.socialbase.downloader.h.c qfg;
    private static r qfh;
    private static com.ss.android.socialbase.downloader.h.b qfi;
    private static volatile List<com.ss.android.socialbase.downloader.d.t> B = new ArrayList();
    private static volatile boolean C = false;
    private static volatile OkHttpClient qfe = null;
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
                    a(gVar.eGA());
                    a(gVar.eGB());
                    b(gVar.eFz());
                    a(gVar.eGI());
                    b(gVar.p());
                    a(gVar.eGC());
                    a(gVar.eFX());
                    a(gVar.eGD());
                    c(gVar.eGE());
                    d(gVar.eGF());
                    e(gVar.i());
                    f(gVar.eGc());
                    g(gVar.uj());
                    h(gVar.eGd());
                    i(gVar.eGe());
                    j(gVar.eGf());
                    b(gVar.eGG());
                    if (gVar.eGH() != null) {
                        qfc = gVar.eGH();
                    }
                    if (gVar.s() > 1024) {
                        L = gVar.s();
                    }
                    b(gVar.eFA());
                    if (gVar.t()) {
                        C = true;
                    }
                    P = gVar.v();
                    a(gVar.eGJ());
                    a(gVar.w());
                }
                if (qeH == null) {
                    qeH = new com.ss.android.socialbase.downloader.impls.d();
                }
                if (qeM == null) {
                    qeM = new com.ss.android.socialbase.downloader.impls.h();
                }
                if (qeO == null) {
                    qeO = new com.ss.android.socialbase.downloader.impls.n();
                }
                if (qeI == null) {
                    qeI = new com.ss.android.socialbase.downloader.impls.i();
                }
                if (qeL == null) {
                    qeL = new com.ss.android.socialbase.downloader.impls.e();
                }
                if (qeJ == null) {
                    qeJ = new com.ss.android.socialbase.downloader.impls.c();
                }
                if (qeZ == null) {
                    qeZ = new com.ss.android.socialbase.downloader.impls.b();
                }
                if (qfb == null) {
                    qfb = new com.ss.android.socialbase.downloader.impls.j();
                }
                if (G <= 0 || G > H) {
                    G = H;
                }
                L();
                if (C && !z && !com.ss.android.socialbase.downloader.m.d.c()) {
                    com.ss.android.socialbase.downloader.impls.l.CO(true).d();
                } else if (com.ss.android.socialbase.downloader.m.d.d()) {
                    ExecutorService uj = uj();
                    if (uj != null) {
                        uj.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.b.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Context eGu = b.eGu();
                                if (eGu != null) {
                                    com.ss.android.socialbase.downloader.m.d.c(eGu);
                                }
                            }
                        });
                    }
                } else {
                    Context eGu = eGu();
                    if (eGu != null) {
                        com.ss.android.socialbase.downloader.m.d.c(eGu);
                    }
                }
                U = true;
            }
        }
    }

    private static void L() {
        if (qfa == null) {
            qfa = new DownloadReceiver();
        }
        if (!F) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                f13134a.registerReceiver(qfa, intentFilter);
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
                Intent intent = new Intent(eGu(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
                eGu().startService(intent);
                if (!com.ss.android.socialbase.downloader.m.d.c()) {
                    com.ss.android.socialbase.downloader.impls.l.CO(true).d();
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

    public static com.ss.android.socialbase.downloader.i.h eFW() {
        return qeP;
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

    public static com.ss.android.socialbase.downloader.i.f eFX() {
        return qeQ;
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
        int[] Rm = Rm(i2);
        int length = Rm.length;
        int i3 = 0;
        while (i3 < length) {
            try {
                a2 = a(i, str, list, Rm[i3], z2, cVar);
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
        com.ss.android.socialbase.downloader.i.h eFW = i2 == 1 ? eFW() : eFY();
        if (eFW == null) {
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
        com.ss.android.socialbase.downloader.i.g a2 = eFW.a(i, str, list);
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
        for (int i2 : Rm(i)) {
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
        com.ss.android.socialbase.downloader.i.f eFX = i == 1 ? eFX() : eFZ();
        if (eFX == null) {
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
        com.ss.android.socialbase.downloader.i.e v = eFX.v(str, list);
        if (z) {
            com.ss.android.socialbase.downloader.h.a.a(v, str, System.currentTimeMillis() - j, "head", i, null, cVar);
        }
        return v;
    }

    private static int[] Rm(int i) {
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

    public static com.ss.android.socialbase.downloader.i.h eFY() {
        if (qeR == null) {
            synchronized (b.class) {
                if (qeR == null) {
                    qeR = new com.ss.android.socialbase.downloader.impls.g();
                }
            }
        }
        return qeR;
    }

    public static com.ss.android.socialbase.downloader.i.f eFZ() {
        if (qeS == null) {
            synchronized (b.class) {
                if (qeS == null) {
                    qeS = new com.ss.android.socialbase.downloader.impls.f();
                }
            }
        }
        return qeS;
    }

    public static AlarmManager eGa() {
        if (qff == null) {
            synchronized (b.class) {
                if (qff == null && f13134a != null) {
                    qff = (AlarmManager) f13134a.getSystemService(NotificationCompat.CATEGORY_ALARM);
                }
            }
        }
        return qff;
    }

    public static synchronized void a(m mVar) {
        synchronized (b.class) {
            if (mVar != null) {
                qeT = mVar;
                if (qeH instanceof com.ss.android.socialbase.downloader.impls.d) {
                    ((com.ss.android.socialbase.downloader.impls.d) qeH).g();
                }
            }
        }
    }

    private static void c(ExecutorService executorService) {
        if (executorService != null) {
            ciJ = executorService;
        }
    }

    private static void d(ExecutorService executorService) {
        if (executorService != null) {
            p = executorService;
        }
    }

    private static void e(ExecutorService executorService) {
        if (executorService != null) {
            qeU = executorService;
        }
    }

    private static void f(ExecutorService executorService) {
        if (executorService != null) {
            qeV = executorService;
        }
    }

    private static void g(ExecutorService executorService) {
        if (executorService != null) {
            qeW = executorService;
        }
    }

    private static void h(ExecutorService executorService) {
        if (executorService != null) {
            ppQ = executorService;
        }
    }

    public static void i(ExecutorService executorService) {
        if (executorService != null) {
            qeX = executorService;
        }
    }

    public static void j(ExecutorService executorService) {
        if (executorService != null) {
            qeY = executorService;
        }
    }

    private static void b(ab abVar) {
        if (qeN == null) {
            qeN = abVar;
        }
    }

    public static synchronized q eGb() {
        q qVar;
        synchronized (b.class) {
            qVar = qfc;
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
                eGc().execute(runnable);
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
                eGh().execute(runnable);
            }
        }
    }

    public static ExecutorService eGc() {
        if (ciJ == null) {
            synchronized (b.class) {
                if (ciJ == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(H, H, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-cpu-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    ciJ = threadPoolExecutor;
                }
            }
        }
        return ciJ;
    }

    public static ExecutorService uj() {
        return p != null ? p : eGc();
    }

    public static ExecutorService eGd() {
        return qeV != null ? qeV : eGf();
    }

    public static ExecutorService eGe() {
        return qeW != null ? qeW : eGf();
    }

    public static ExecutorService eGf() {
        if (qeU == null) {
            synchronized (b.class) {
                if (qeU == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(J, J, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-mix-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    qeU = threadPoolExecutor;
                }
            }
        }
        return qeU;
    }

    public static ExecutorService eGg() {
        if (qeX == null) {
            synchronized (b.class) {
                if (qeX == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(I, I, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-chunk-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    qeX = threadPoolExecutor;
                }
            }
        }
        return qeX;
    }

    public static ExecutorService eGh() {
        if (ppQ == null) {
            synchronized (b.class) {
                if (ppQ == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(K, K, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-db-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    ppQ = threadPoolExecutor;
                }
            }
        }
        return ppQ;
    }

    public static OkHttpClient eGi() {
        if (qfe == null) {
            synchronized (b.class) {
                if (qfe == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
                    if (qeY != null) {
                        builder.dispatcher(new Dispatcher(qeY));
                    }
                    qfe = builder.build();
                }
            }
        }
        return qfe;
    }

    public static synchronized m eGj() {
        m mVar;
        synchronized (b.class) {
            mVar = qeT;
        }
        return mVar;
    }

    private static void a(com.ss.android.socialbase.downloader.i.h hVar) {
        if (hVar != null) {
            qeP = hVar;
        }
        M = qeP != null;
    }

    private static void a(com.ss.android.socialbase.downloader.i.f fVar) {
        if (fVar != null) {
            qeQ = fVar;
        }
    }

    public static k eGk() {
        if (qeH == null) {
            synchronized (b.class) {
                if (qeH == null) {
                    qeH = new com.ss.android.socialbase.downloader.impls.d();
                }
            }
        }
        return qeH;
    }

    private static void a(k kVar) {
        if (kVar != null) {
            qeH = kVar;
        }
    }

    public static p eGl() {
        if (qeM == null) {
            synchronized (b.class) {
                if (qeM == null) {
                    qeM = new com.ss.android.socialbase.downloader.impls.h();
                }
            }
        }
        return qeM;
    }

    public static p eGm() {
        if (qeO == null) {
            synchronized (b.class) {
                if (qeO == null) {
                    qeO = new com.ss.android.socialbase.downloader.impls.n();
                }
            }
        }
        return qeO;
    }

    public static ab eGn() {
        return qeN;
    }

    public static l eGo() {
        if (qeI == null) {
            synchronized (b.class) {
                if (qeI == null) {
                    qeI = new com.ss.android.socialbase.downloader.impls.i();
                }
            }
        }
        return qeI;
    }

    public static com.ss.android.socialbase.downloader.impls.a eGp() {
        if (qeL == null) {
            synchronized (b.class) {
                if (qeL == null) {
                    qeL = new com.ss.android.socialbase.downloader.impls.e();
                }
            }
        }
        return qeL;
    }

    private static void a(l lVar) {
        if (lVar != null) {
            qeI = lVar;
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
    public static JSONObject eDX() {
        if (qfd == null || qfd.a() == null) {
            return com.ss.android.socialbase.downloader.b.e.g;
        }
        JSONObject a2 = qfd.a();
        a(a2);
        return a2;
    }

    private static void a(JSONObject jSONObject) {
        if (jSONObject != null && TextUtils.isEmpty(com.ss.android.socialbase.downloader.b.e.c)) {
            com.ss.android.socialbase.downloader.b.e.c = jSONObject.optString("kllk");
            if (!TextUtils.isEmpty(com.ss.android.socialbase.downloader.b.e.c)) {
                com.ss.android.socialbase.downloader.b.e.f13075b = com.ss.android.socialbase.downloader.b.e.c.toUpperCase();
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.d.e eVar) {
        qfd = eVar;
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

    public static i eGq() {
        if (qeJ == null) {
            synchronized (b.class) {
                if (qeJ == null) {
                    qeJ = new com.ss.android.socialbase.downloader.impls.c();
                }
            }
        }
        return qeJ;
    }

    private static void b(i iVar) {
        if (iVar != null) {
            qeJ = iVar;
        }
    }

    public static void a(com.ss.android.socialbase.downloader.d.r rVar) {
        if (rVar != null) {
            qeK = rVar;
        }
    }

    public static com.ss.android.socialbase.downloader.d.r eGr() {
        return qeK;
    }

    public static h eGs() {
        if (qeZ == null) {
            synchronized (b.class) {
                if (qeZ == null) {
                    qeZ = new com.ss.android.socialbase.downloader.impls.b();
                }
            }
        }
        return qeZ;
    }

    private static void b(h hVar) {
        if (hVar != null) {
            qeZ = hVar;
        }
    }

    public static s eGt() {
        if (qfb == null) {
            synchronized (b.class) {
                if (qfb == null) {
                    qfb = new com.ss.android.socialbase.downloader.impls.j();
                }
            }
        }
        return qfb;
    }

    public static synchronized Context eGu() {
        Context context;
        synchronized (b.class) {
            context = f13134a;
        }
        return context;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (context != null) {
                if (f13134a == null) {
                    f13134a = context.getApplicationContext();
                    com.ss.android.socialbase.downloader.a.a.eFQ().a(f13134a);
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
        l eGo = eGo();
        if (eGo == null) {
            return 0;
        }
        return eGo.a(str, str2);
    }

    public static synchronized boolean H() {
        boolean z;
        synchronized (b.class) {
            z = M;
        }
        return z;
    }

    public static com.ss.android.socialbase.downloader.h.c eGv() {
        return qfg;
    }

    public static com.ss.android.socialbase.downloader.h.b eGw() {
        return qfi;
    }

    public static r eGx() {
        return qfh;
    }

    public static void a(com.ss.android.socialbase.downloader.h.b bVar) {
        qfi = bVar;
    }

    public static void a(r rVar) {
    }
}
