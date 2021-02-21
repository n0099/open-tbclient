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
    private static volatile ExecutorService pqq;
    private static volatile DownloadReceiver qfA;
    private static volatile s qfB;
    private static volatile q qfC;
    private static volatile com.ss.android.socialbase.downloader.d.e qfD;
    private static volatile AlarmManager qfF;
    private static com.ss.android.socialbase.downloader.h.c qfG;
    private static r qfH;
    private static com.ss.android.socialbase.downloader.h.b qfI;
    private static volatile k qfh;
    private static volatile l qfi;
    private static volatile i qfj;
    private static volatile com.ss.android.socialbase.downloader.d.r qfk;
    private static volatile com.ss.android.socialbase.downloader.impls.a qfl;
    private static volatile p qfm;
    private static volatile ab qfn;
    private static volatile p qfo;
    private static volatile com.ss.android.socialbase.downloader.i.h qfp;
    private static volatile com.ss.android.socialbase.downloader.i.f qfq;
    private static volatile com.ss.android.socialbase.downloader.i.h qfr;
    private static volatile com.ss.android.socialbase.downloader.i.f qfs;
    private static volatile m qft;
    private static volatile ExecutorService qfu;
    private static volatile ExecutorService qfv;
    private static volatile ExecutorService qfw;
    private static volatile ExecutorService qfx;
    private static volatile ExecutorService qfy;
    private static volatile h qfz;
    private static volatile List<com.ss.android.socialbase.downloader.d.t> B = new ArrayList();
    private static volatile boolean C = false;
    private static volatile OkHttpClient qfE = null;
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
                    a(gVar.eGI());
                    a(gVar.eGJ());
                    b(gVar.eFH());
                    a(gVar.eGQ());
                    b(gVar.p());
                    a(gVar.eGK());
                    a(gVar.eGf());
                    a(gVar.eGL());
                    c(gVar.eGM());
                    d(gVar.eGN());
                    e(gVar.i());
                    f(gVar.eGk());
                    g(gVar.uj());
                    h(gVar.eGl());
                    i(gVar.eGm());
                    j(gVar.eGn());
                    b(gVar.eGO());
                    if (gVar.eGP() != null) {
                        qfC = gVar.eGP();
                    }
                    if (gVar.s() > 1024) {
                        L = gVar.s();
                    }
                    b(gVar.eFI());
                    if (gVar.t()) {
                        C = true;
                    }
                    P = gVar.v();
                    a(gVar.eGR());
                    a(gVar.w());
                }
                if (qfh == null) {
                    qfh = new com.ss.android.socialbase.downloader.impls.d();
                }
                if (qfm == null) {
                    qfm = new com.ss.android.socialbase.downloader.impls.h();
                }
                if (qfo == null) {
                    qfo = new com.ss.android.socialbase.downloader.impls.n();
                }
                if (qfi == null) {
                    qfi = new com.ss.android.socialbase.downloader.impls.i();
                }
                if (qfl == null) {
                    qfl = new com.ss.android.socialbase.downloader.impls.e();
                }
                if (qfj == null) {
                    qfj = new com.ss.android.socialbase.downloader.impls.c();
                }
                if (qfz == null) {
                    qfz = new com.ss.android.socialbase.downloader.impls.b();
                }
                if (qfB == null) {
                    qfB = new com.ss.android.socialbase.downloader.impls.j();
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
                                Context eGC = b.eGC();
                                if (eGC != null) {
                                    com.ss.android.socialbase.downloader.m.d.c(eGC);
                                }
                            }
                        });
                    }
                } else {
                    Context eGC = eGC();
                    if (eGC != null) {
                        com.ss.android.socialbase.downloader.m.d.c(eGC);
                    }
                }
                U = true;
            }
        }
    }

    private static void L() {
        if (qfA == null) {
            qfA = new DownloadReceiver();
        }
        if (!F) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                f13134a.registerReceiver(qfA, intentFilter);
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
                Intent intent = new Intent(eGC(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
                eGC().startService(intent);
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

    public static com.ss.android.socialbase.downloader.i.h eGe() {
        return qfp;
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

    public static com.ss.android.socialbase.downloader.i.f eGf() {
        return qfq;
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
        int[] Rn = Rn(i2);
        int length = Rn.length;
        int i3 = 0;
        while (i3 < length) {
            try {
                a2 = a(i, str, list, Rn[i3], z2, cVar);
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
        com.ss.android.socialbase.downloader.i.h eGe = i2 == 1 ? eGe() : eGg();
        if (eGe == null) {
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
        com.ss.android.socialbase.downloader.i.g a2 = eGe.a(i, str, list);
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
        for (int i2 : Rn(i)) {
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
        com.ss.android.socialbase.downloader.i.f eGf = i == 1 ? eGf() : eGh();
        if (eGf == null) {
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
        com.ss.android.socialbase.downloader.i.e v = eGf.v(str, list);
        if (z) {
            com.ss.android.socialbase.downloader.h.a.a(v, str, System.currentTimeMillis() - j, "head", i, null, cVar);
        }
        return v;
    }

    private static int[] Rn(int i) {
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

    public static com.ss.android.socialbase.downloader.i.h eGg() {
        if (qfr == null) {
            synchronized (b.class) {
                if (qfr == null) {
                    qfr = new com.ss.android.socialbase.downloader.impls.g();
                }
            }
        }
        return qfr;
    }

    public static com.ss.android.socialbase.downloader.i.f eGh() {
        if (qfs == null) {
            synchronized (b.class) {
                if (qfs == null) {
                    qfs = new com.ss.android.socialbase.downloader.impls.f();
                }
            }
        }
        return qfs;
    }

    public static AlarmManager eGi() {
        if (qfF == null) {
            synchronized (b.class) {
                if (qfF == null && f13134a != null) {
                    qfF = (AlarmManager) f13134a.getSystemService(NotificationCompat.CATEGORY_ALARM);
                }
            }
        }
        return qfF;
    }

    public static synchronized void a(m mVar) {
        synchronized (b.class) {
            if (mVar != null) {
                qft = mVar;
                if (qfh instanceof com.ss.android.socialbase.downloader.impls.d) {
                    ((com.ss.android.socialbase.downloader.impls.d) qfh).g();
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
            qfu = executorService;
        }
    }

    private static void f(ExecutorService executorService) {
        if (executorService != null) {
            qfv = executorService;
        }
    }

    private static void g(ExecutorService executorService) {
        if (executorService != null) {
            qfw = executorService;
        }
    }

    private static void h(ExecutorService executorService) {
        if (executorService != null) {
            pqq = executorService;
        }
    }

    public static void i(ExecutorService executorService) {
        if (executorService != null) {
            qfx = executorService;
        }
    }

    public static void j(ExecutorService executorService) {
        if (executorService != null) {
            qfy = executorService;
        }
    }

    private static void b(ab abVar) {
        if (qfn == null) {
            qfn = abVar;
        }
    }

    public static synchronized q eGj() {
        q qVar;
        synchronized (b.class) {
            qVar = qfC;
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
                eGk().execute(runnable);
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
                eGp().execute(runnable);
            }
        }
    }

    public static ExecutorService eGk() {
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
        return p != null ? p : eGk();
    }

    public static ExecutorService eGl() {
        return qfv != null ? qfv : eGn();
    }

    public static ExecutorService eGm() {
        return qfw != null ? qfw : eGn();
    }

    public static ExecutorService eGn() {
        if (qfu == null) {
            synchronized (b.class) {
                if (qfu == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(J, J, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-mix-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    qfu = threadPoolExecutor;
                }
            }
        }
        return qfu;
    }

    public static ExecutorService eGo() {
        if (qfx == null) {
            synchronized (b.class) {
                if (qfx == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(I, I, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-chunk-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    qfx = threadPoolExecutor;
                }
            }
        }
        return qfx;
    }

    public static ExecutorService eGp() {
        if (pqq == null) {
            synchronized (b.class) {
                if (pqq == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(K, K, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.l.a("DownloadThreadPool-db-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    pqq = threadPoolExecutor;
                }
            }
        }
        return pqq;
    }

    public static OkHttpClient eGq() {
        if (qfE == null) {
            synchronized (b.class) {
                if (qfE == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
                    if (qfy != null) {
                        builder.dispatcher(new Dispatcher(qfy));
                    }
                    qfE = builder.build();
                }
            }
        }
        return qfE;
    }

    public static synchronized m eGr() {
        m mVar;
        synchronized (b.class) {
            mVar = qft;
        }
        return mVar;
    }

    private static void a(com.ss.android.socialbase.downloader.i.h hVar) {
        if (hVar != null) {
            qfp = hVar;
        }
        M = qfp != null;
    }

    private static void a(com.ss.android.socialbase.downloader.i.f fVar) {
        if (fVar != null) {
            qfq = fVar;
        }
    }

    public static k eGs() {
        if (qfh == null) {
            synchronized (b.class) {
                if (qfh == null) {
                    qfh = new com.ss.android.socialbase.downloader.impls.d();
                }
            }
        }
        return qfh;
    }

    private static void a(k kVar) {
        if (kVar != null) {
            qfh = kVar;
        }
    }

    public static p eGt() {
        if (qfm == null) {
            synchronized (b.class) {
                if (qfm == null) {
                    qfm = new com.ss.android.socialbase.downloader.impls.h();
                }
            }
        }
        return qfm;
    }

    public static p eGu() {
        if (qfo == null) {
            synchronized (b.class) {
                if (qfo == null) {
                    qfo = new com.ss.android.socialbase.downloader.impls.n();
                }
            }
        }
        return qfo;
    }

    public static ab eGv() {
        return qfn;
    }

    public static l eGw() {
        if (qfi == null) {
            synchronized (b.class) {
                if (qfi == null) {
                    qfi = new com.ss.android.socialbase.downloader.impls.i();
                }
            }
        }
        return qfi;
    }

    public static com.ss.android.socialbase.downloader.impls.a eGx() {
        if (qfl == null) {
            synchronized (b.class) {
                if (qfl == null) {
                    qfl = new com.ss.android.socialbase.downloader.impls.e();
                }
            }
        }
        return qfl;
    }

    private static void a(l lVar) {
        if (lVar != null) {
            qfi = lVar;
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
    public static JSONObject eEf() {
        if (qfD == null || qfD.a() == null) {
            return com.ss.android.socialbase.downloader.b.e.g;
        }
        JSONObject a2 = qfD.a();
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
        qfD = eVar;
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

    public static i eGy() {
        if (qfj == null) {
            synchronized (b.class) {
                if (qfj == null) {
                    qfj = new com.ss.android.socialbase.downloader.impls.c();
                }
            }
        }
        return qfj;
    }

    private static void b(i iVar) {
        if (iVar != null) {
            qfj = iVar;
        }
    }

    public static void a(com.ss.android.socialbase.downloader.d.r rVar) {
        if (rVar != null) {
            qfk = rVar;
        }
    }

    public static com.ss.android.socialbase.downloader.d.r eGz() {
        return qfk;
    }

    public static h eGA() {
        if (qfz == null) {
            synchronized (b.class) {
                if (qfz == null) {
                    qfz = new com.ss.android.socialbase.downloader.impls.b();
                }
            }
        }
        return qfz;
    }

    private static void b(h hVar) {
        if (hVar != null) {
            qfz = hVar;
        }
    }

    public static s eGB() {
        if (qfB == null) {
            synchronized (b.class) {
                if (qfB == null) {
                    qfB = new com.ss.android.socialbase.downloader.impls.j();
                }
            }
        }
        return qfB;
    }

    public static synchronized Context eGC() {
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
                    com.ss.android.socialbase.downloader.a.a.eFY().a(f13134a);
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
        l eGw = eGw();
        if (eGw == null) {
            return 0;
        }
        return eGw.a(str, str2);
    }

    public static synchronized boolean H() {
        boolean z;
        synchronized (b.class) {
            z = M;
        }
        return z;
    }

    public static com.ss.android.socialbase.downloader.h.c eGD() {
        return qfG;
    }

    public static com.ss.android.socialbase.downloader.h.b eGE() {
        return qfI;
    }

    public static r eGF() {
        return qfH;
    }

    public static void a(com.ss.android.socialbase.downloader.h.b bVar) {
        qfI = bVar;
    }

    public static void a(r rVar) {
    }
}
