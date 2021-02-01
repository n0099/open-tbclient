package com.ss.android.socialbase.downloader.l;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.constants.DebugConstants;
import com.baidubce.http.Headers;
import com.ss.android.socialbase.downloader.b.j;
import com.ss.android.socialbase.downloader.d.ae;
import com.ss.android.socialbase.downloader.d.af;
import com.ss.android.socialbase.downloader.d.al;
import com.ss.android.socialbase.downloader.d.an;
import com.ss.android.socialbase.downloader.d.u;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.g.b;
import com.ss.android.socialbase.downloader.i.g;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.q;
import com.ss.android.socialbase.downloader.impls.r;
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
/* loaded from: classes6.dex */
public class c implements e, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13212a = c.class.getSimpleName();
    private String F;
    private long G;
    private long H;

    /* renamed from: b  reason: collision with root package name */
    private Future f13213b;
    private AtomicInteger e;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private final AtomicBoolean m;
    private final com.ss.android.socialbase.downloader.g.d qhD;
    private volatile com.ss.android.socialbase.downloader.downloader.d qhE;
    private final k qhG;
    private com.ss.android.socialbase.downloader.g.c qhH;
    private i qhI;
    private final i qhJ;
    private h qhK;
    private final h qhL;
    private s qhM;
    private final com.ss.android.socialbase.downloader.downloader.e qhN;
    private AlarmManager qhO;
    private volatile com.ss.android.socialbase.downloader.e.a qhP;
    private g qhQ;
    private com.ss.android.socialbase.downloader.i.e qhR;
    private al qhS;
    private af qhT;
    private final com.ss.android.socialbase.downloader.k.a qhU;
    private volatile boolean d = false;
    private final ArrayList<b> f = new ArrayList<>();
    private volatile j qhF = j.RUN_STATUS_NONE;
    private volatile int C = 5;
    private boolean D = false;
    private boolean E = false;

    public c(com.ss.android.socialbase.downloader.g.d dVar, Handler handler) {
        this.qhD = dVar;
        if (dVar != null) {
            this.qhH = dVar.a();
            this.qhI = dVar.eId();
            this.qhK = dVar.eIk();
            this.qhS = dVar.eIf();
            this.qhT = dVar.eIg();
            this.qhM = e(dVar);
            this.qhU = com.ss.android.socialbase.downloader.k.a.RV(this.qhH.g());
        } else {
            this.qhU = com.ss.android.socialbase.downloader.k.a.eIx();
        }
        h();
        this.qhG = com.ss.android.socialbase.downloader.downloader.b.eGk();
        this.qhJ = com.ss.android.socialbase.downloader.downloader.b.eGq();
        this.qhL = com.ss.android.socialbase.downloader.downloader.b.eGs();
        this.qhN = new com.ss.android.socialbase.downloader.downloader.e(dVar, handler);
        this.qhO = com.ss.android.socialbase.downloader.downloader.b.eGa();
        this.m = new AtomicBoolean(true);
    }

    private void h() {
        if (this.qhH != null) {
            int J = this.qhH.J() - this.qhH.ax();
            if (J < 0) {
                J = 0;
            }
            if (this.e == null) {
                this.e = new AtomicInteger(J);
            } else {
                this.e.set(J);
            }
        }
    }

    public void a() {
        this.qhF = j.RUN_STATUS_PAUSE;
        if (this.qhE != null) {
            this.qhE.b();
        } else {
            p();
            this.qhF = j.RUN_STATUS_PAUSE;
            m();
        }
        try {
            Iterator it = ((ArrayList) this.f.clone()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null) {
                    bVar.a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b() {
        this.qhF = j.RUN_STATUS_CANCELED;
        if (this.qhE != null) {
            this.qhE.c();
        } else {
            p();
            this.qhF = j.RUN_STATUS_CANCELED;
            m();
        }
        F();
    }

    public com.ss.android.socialbase.downloader.g.d eIy() {
        return this.qhD;
    }

    private int c(long j, List<com.ss.android.socialbase.downloader.g.b> list) {
        int i;
        int a2;
        if (z()) {
            if (this.i) {
                if (list != null) {
                    i = list.size();
                } else {
                    i = this.qhH.eHM();
                }
            } else {
                if (this.qhI != null) {
                    a2 = this.qhI.a(j);
                } else {
                    a2 = this.qhJ.a(j);
                }
                com.ss.android.socialbase.downloader.i.k eIp = com.ss.android.socialbase.downloader.i.j.eIo().eIp();
                com.ss.android.socialbase.downloader.f.a.b(f13212a, String.format("NetworkQuality is : %s", eIp.name()));
                this.qhH.f(eIp.name());
                if (this.qhK != null) {
                    i = this.qhK.a(a2, eIp);
                } else {
                    i = this.qhL.a(a2, eIp);
                }
            }
            if (i <= 0) {
                i = 1;
            }
        } else {
            i = 1;
        }
        if (com.ss.android.socialbase.downloader.f.a.a()) {
            com.ss.android.socialbase.downloader.f.a.b(f13212a, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(i), this.qhH.h(), String.valueOf(j)));
        }
        return i;
    }

    private boolean i() {
        int q = this.qhH.q();
        if (q == 1 || this.qhH.eHq()) {
            return true;
        }
        if (q != -2 && q != -4) {
            b(new com.ss.android.socialbase.downloader.e.a(1000, "The download Task can't start, because its status is not prepare:" + q));
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [302=4] */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r8.qhU.a("fix_file_exist_update_download_info") != false) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j() throws com.ss.android.socialbase.downloader.e.b {
        boolean z;
        boolean z2 = true;
        try {
            try {
                int g = this.qhH.g();
                if (this.qhG != null) {
                    if (com.ss.android.socialbase.downloader.m.a.a(2048)) {
                        this.qhG.d();
                    }
                    com.ss.android.socialbase.downloader.g.c b2 = this.qhG.b(g);
                    if (b2 == null || b2.bk()) {
                        this.qhH.eHE();
                        z = true;
                    } else {
                        String k = this.qhH.k();
                        String F = this.qhH.F();
                        this.qhH.a(b2, true);
                        z = com.ss.android.socialbase.downloader.m.a.a(4096) && b2 != this.qhH;
                        try {
                            if (k.equals(b2.k()) && com.ss.android.socialbase.downloader.m.d.a(b2, false, F)) {
                                try {
                                    throw new com.ss.android.socialbase.downloader.e.b(b2.h());
                                } catch (com.ss.android.socialbase.downloader.e.b e) {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    if (this.qhD != null && this.qhH != null) {
                                        com.ss.android.socialbase.downloader.h.a.a(this.qhD.eIc(), this.qhH, new com.ss.android.socialbase.downloader.e.a(1003, com.ss.android.socialbase.downloader.m.d.c(th, "checkTaskCache")), this.qhH.q());
                                    }
                                    if (z) {
                                        if (z2) {
                                            try {
                                                if (!this.qhU.a("fix_file_exist_update_download_info")) {
                                                    return;
                                                }
                                            } catch (SQLiteException e2) {
                                                e2.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.qhG.a(this.qhH);
                                        return;
                                    }
                                    return;
                                }
                            } else if (com.ss.android.socialbase.downloader.downloader.b.r(b2) != g) {
                                try {
                                    this.qhG.f(g);
                                } catch (SQLiteException e3) {
                                    e3.printStackTrace();
                                }
                                z = true;
                            }
                        } catch (com.ss.android.socialbase.downloader.e.b e4) {
                            throw e4;
                        } catch (Throwable th2) {
                            th = th2;
                            z2 = false;
                            if (z) {
                                if (z2) {
                                    try {
                                    } catch (SQLiteException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                this.qhG.a(this.qhH);
                            }
                            throw th;
                        }
                    }
                } else {
                    z = false;
                }
                h();
                if (z) {
                    try {
                        this.qhG.a(this.qhH);
                    } catch (SQLiteException e6) {
                        e6.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (com.ss.android.socialbase.downloader.e.b e7) {
        } catch (Throwable th4) {
            th = th4;
            z2 = false;
            z = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.b.a(this.qhD, 3);
        k();
        com.ss.android.socialbase.downloader.downloader.b.b(this.qhD, 3);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069 A[LOOP:0: B:28:0x0069->B:54:0x0069, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k() {
        Process.setThreadPriority(10);
        try {
            if (this.qhH != null && this.H > 0) {
                this.qhH.c(System.currentTimeMillis() - this.H);
            }
        } catch (Throwable th) {
        }
        try {
            an eIa = this.qhD.eIa();
            if (eIa != null) {
                if (eIa.a()) {
                    this.qhN.e();
                    return;
                }
            }
        } finally {
            if (i()) {
            }
        }
        if (i()) {
            com.ss.android.socialbase.downloader.h.a.a(this.qhD.eIc(), this.qhH, new com.ss.android.socialbase.downloader.e.a(1003, "task status is invalid"), this.qhH != null ? this.qhH.q() : 0);
            return;
        }
        while (true) {
            l();
            if (this.D) {
                if (this.C > 0) {
                    this.C--;
                } else if (this.qhH.eHa() != this.qhH.eij()) {
                    com.ss.android.socialbase.downloader.f.a.b(f13212a, this.qhH.d());
                    this.qhN.a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.qhH.eHb()));
                    return;
                } else if (this.qhH.eHa() <= 0) {
                    com.ss.android.socialbase.downloader.f.a.b(f13212a, this.qhH.d());
                    this.qhN.a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, "curBytes is 0, bytes invalid retry status is : " + this.qhH.eHb()));
                    return;
                } else if (this.qhH.eij() <= 0) {
                    com.ss.android.socialbase.downloader.f.a.b(f13212a, this.qhH.d());
                    this.qhN.a(new com.ss.android.socialbase.downloader.e.g(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.qhH.eHb()));
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [571=15, 577=12] */
    private void l() {
        List<com.ss.android.socialbase.downloader.g.b> c;
        String O;
        try {
            this.qhF = j.RUN_STATUS_NONE;
            this.qhH.Q();
            this.qhH.eGZ();
            long currentTimeMillis = System.currentTimeMillis();
            this.qhH.a(-1L);
            boolean z = false;
            try {
                j();
            } catch (com.ss.android.socialbase.downloader.e.b e) {
                com.ss.android.socialbase.downloader.f.a.b(f13212a, "file exist " + e.c());
                this.F = e.c();
                z = true;
            }
            if (!this.D) {
                this.qhN.b();
            }
            this.D = false;
            if (s()) {
                return;
            }
            if (!TextUtils.isEmpty(this.F) && z) {
                if (com.ss.android.socialbase.downloader.k.a.eIx().b("fix_end_for_file_exist_error", true)) {
                    if (this.F.equals(this.qhH.h())) {
                        this.qhF = j.RUN_STATUS_END_RIGHT_NOW;
                    } else {
                        this.qhF = j.RUN_STATUS_END_FOR_FILE_EXIST;
                    }
                } else if (this.F.equals(this.qhH.n())) {
                    this.qhF = j.RUN_STATUS_END_RIGHT_NOW;
                } else {
                    this.qhF = j.RUN_STATUS_END_FOR_FILE_EXIST;
                }
                return;
            }
            com.ss.android.socialbase.downloader.i.b.eIn().b();
            while (!s()) {
                try {
                    try {
                        C();
                        y();
                        B();
                        c = this.qhG.c(this.qhH.g());
                        D();
                        O = this.qhH.O();
                    } catch (com.ss.android.socialbase.downloader.e.a e2) {
                        com.ss.android.socialbase.downloader.f.a.d(f13212a, "downloadInner: baseException = " + e2);
                        if (this.qhF != j.RUN_STATUS_PAUSE) {
                            if (e2.a() == 1025 || e2.a() == 1009) {
                                this.qhF = j.RUN_STATUS_END_RIGHT_NOW;
                                p();
                                return;
                            } else if (d(e2)) {
                                if (com.ss.android.socialbase.downloader.m.d.d(e2)) {
                                    E();
                                }
                                if (a(e2, 0L) == com.ss.android.socialbase.downloader.e.h.RETURN) {
                                    p();
                                    return;
                                }
                                p();
                            } else {
                                b(e2);
                            }
                        }
                        p();
                    }
                } catch (a e3) {
                    com.ss.android.socialbase.downloader.f.a.d(f13212a, "downloadInner: retry throwable for " + e3.a());
                    if (this.qhF != j.RUN_STATUS_PAUSE) {
                        if (this.e != null && this.e.get() > 0) {
                            this.qhH.h(this.e.decrementAndGet());
                            this.qhH.c(5);
                            p();
                        } else if (this.e == null) {
                            b(new com.ss.android.socialbase.downloader.e.a(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e3.a()));
                        } else if (this.qhH.aY()) {
                            this.qhH.c(5);
                            this.e.set(this.qhH.J());
                            this.qhH.h(this.e.get());
                            p();
                        } else {
                            b(new com.ss.android.socialbase.downloader.e.a(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.qhH.J()), e3.a())));
                        }
                    }
                    p();
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.f.a.d(f13212a, "downloadInner: throwable =  " + th);
                    if (this.qhF != j.RUN_STATUS_PAUSE) {
                        b(new com.ss.android.socialbase.downloader.e.a(1045, th));
                    }
                    p();
                }
                if (s()) {
                    p();
                    return;
                }
                long t = this.i ? com.ss.android.socialbase.downloader.m.d.t(this.qhH) : 0L;
                com.ss.android.socialbase.downloader.g.b jt = jt(t);
                List<com.ss.android.socialbase.downloader.g.e> e4 = e(jt);
                com.ss.android.socialbase.downloader.m.d.a(e4, this.qhH);
                this.qhH.n(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    b(O, e4, t);
                    this.qhH.b(System.currentTimeMillis() - currentTimeMillis2);
                    if (s()) {
                        p();
                        return;
                    }
                    long eij = this.qhH.eij();
                    a(eij, this.qhH.l(), this.qhH.m());
                    int c2 = c(eij, c);
                    if (s()) {
                        p();
                        return;
                    } else if (c2 <= 0) {
                        throw new com.ss.android.socialbase.downloader.e.a((int) DebugConstants.HTTP_ERRCODE_NOT_FIND, "chunkCount is 0");
                    } else {
                        this.h = c2 == 1;
                        if (this.h) {
                            if (this.qhQ == null) {
                                try {
                                    currentTimeMillis2 = System.currentTimeMillis();
                                    a(O, e4);
                                } finally {
                                }
                            }
                            if (s()) {
                                p();
                                return;
                            } else {
                                this.qhH.a(System.currentTimeMillis() - currentTimeMillis);
                                a(jt, O, this.qhQ);
                            }
                        } else {
                            if (!this.qhH.ad()) {
                                o();
                            }
                            if (s()) {
                                p();
                                return;
                            }
                            this.qhH.a(System.currentTimeMillis() - currentTimeMillis);
                            if (this.i) {
                                a(c2, c);
                            } else {
                                a(eij, c2);
                            }
                        }
                        p();
                        return;
                    }
                } finally {
                }
            }
        } finally {
            m();
        }
    }

    private void b(String str, List<com.ss.android.socialbase.downloader.g.e> list, long j) throws com.ss.android.socialbase.downloader.e.a, a {
        c(str, list, j);
        if (this.qhR != null) {
            try {
                a(this.qhR, j);
            } catch (Throwable th) {
                this.E = true;
            }
        }
        if (this.qhR == null || this.E) {
            a(str, list);
            a(this.qhQ, j);
        }
    }

    private void m() {
        boolean z;
        boolean z2;
        boolean z3 = (this.qhF == j.RUN_STATUS_PAUSE || this.qhF == j.RUN_STATUS_CANCELED) ? false : true;
        try {
            z2 = t();
            z = false;
        } catch (Exception e) {
            if (e instanceof com.ss.android.socialbase.downloader.e.a) {
                this.qhN.a((com.ss.android.socialbase.downloader.e.a) e);
            } else {
                this.qhN.a(new com.ss.android.socialbase.downloader.e.a(1046, e));
            }
            z = true;
            z2 = true;
        }
        if (z2 || z) {
            this.m.set(false);
            if (z3) {
                try {
                    com.ss.android.socialbase.downloader.impls.a eGp = com.ss.android.socialbase.downloader.downloader.b.eGp();
                    if (eGp != null) {
                        eGp.a(this);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.h.a.a(this.qhD.eIc(), this.qhH, new com.ss.android.socialbase.downloader.e.a(1014, com.ss.android.socialbase.downloader.m.d.c(th, "removeDownloadRunnable")), this.qhH != null ? this.qhH.q() : 0);
                    return;
                }
            }
            return;
        }
        this.D = true;
        com.ss.android.socialbase.downloader.f.a.b(f13212a, "jump to restart");
    }

    private void c(String str, List<com.ss.android.socialbase.downloader.g.e> list, long j) throws com.ss.android.socialbase.downloader.e.a, a {
        com.ss.android.socialbase.downloader.i.a.c w;
        if (this.qhH.eHM() == 1 && (w = com.ss.android.socialbase.downloader.i.a.a.eIm().w(str, list)) != null) {
            this.qhR = w;
            this.qhH.n(1);
        }
        if (this.qhR == null && !this.E && this.qhH.af()) {
            try {
                this.qhR = com.ss.android.socialbase.downloader.downloader.b.a(str, list, this.qhU.b("net_lib_strategy"), this.qhU.b("monitor_download_connect") > 0, this.qhH);
            } catch (Throwable th) {
                this.qhH.a(com.ss.android.socialbase.downloader.m.d.K(th));
            }
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.g.e> list) throws com.ss.android.socialbase.downloader.e.a, a {
        if (this.qhQ == null) {
            com.ss.android.socialbase.downloader.i.a.d dVar = null;
            if (this.qhH.eHM() == 1) {
                dVar = com.ss.android.socialbase.downloader.i.a.a.eIm().x(str, list);
            }
            try {
                if (dVar != null) {
                    a(this.qhQ);
                    this.qhH.n(2);
                    this.qhQ = dVar;
                } else {
                    try {
                        this.qhQ = com.ss.android.socialbase.downloader.downloader.b.a(this.qhH.o(), this.qhH.I(), str, list, this.qhU.b("net_lib_strategy"), this.qhU.b("monitor_download_connect") > 0, this.qhH);
                        a(this.qhQ);
                    } catch (com.ss.android.socialbase.downloader.e.a e) {
                        throw e;
                    } catch (Throwable th) {
                        if (com.ss.android.socialbase.downloader.m.d.H(th)) {
                            a("", "http code 416");
                        } else if (com.ss.android.socialbase.downloader.m.d.G(th)) {
                            a("", "http code 412");
                        } else {
                            com.ss.android.socialbase.downloader.m.d.a(th, "CreateFirstConnection");
                        }
                        a(this.qhQ);
                    }
                }
                if (this.qhQ == null) {
                    throw new com.ss.android.socialbase.downloader.e.a(1022, new IOException("download can't continue, firstConnection is null"));
                }
            } catch (Throwable th2) {
                a(this.qhQ);
                throw th2;
            }
        }
    }

    private void n() {
        if (this.qhR != null) {
            this.qhR.c();
            this.qhR = null;
        }
    }

    private void o() {
        if (this.qhQ != null) {
            this.qhQ.d();
            this.qhQ = null;
        }
    }

    private void p() {
        n();
        o();
    }

    private com.ss.android.socialbase.downloader.g.b jt(long j) {
        return new b.a(this.qhH.g()).RB(-1).ji(0L).jm(j).jj(j).jk(0L).jl(this.qhH.eij() - j).eGN();
    }

    private List<com.ss.android.socialbase.downloader.g.e> e(com.ss.android.socialbase.downloader.g.b bVar) {
        return com.ss.android.socialbase.downloader.m.d.a(this.qhH.eGT(), this.qhH.an(), bVar);
    }

    private void q() throws com.ss.android.socialbase.downloader.e.a {
        if (this.qhE != null) {
            if (this.qhF == j.RUN_STATUS_CANCELED) {
                this.qhH.c(-4);
                this.qhE.c();
            } else if (this.qhF == j.RUN_STATUS_PAUSE) {
                this.qhH.c(-2);
                this.qhE.b();
            } else {
                this.qhE.d();
            }
        }
    }

    private boolean r() {
        return this.qhF == j.RUN_STATUS_CANCELED || this.qhF == j.RUN_STATUS_PAUSE;
    }

    private boolean s() {
        if (r() || this.qhH.q() == -2) {
            if (!r()) {
                if (this.qhH.q() == -2) {
                    this.qhF = j.RUN_STATUS_PAUSE;
                } else if (this.qhH.q() == -4) {
                    this.qhF = j.RUN_STATUS_CANCELED;
                }
            }
            return true;
        }
        return false;
    }

    private boolean t() {
        com.ss.android.socialbase.downloader.i.b.eIn().c();
        if (this.qhF == j.RUN_STATUS_ERROR) {
            this.qhN.a(this.qhP);
            return true;
        } else if (this.qhF == j.RUN_STATUS_CANCELED) {
            this.qhN.c();
            return true;
        } else if (this.qhF == j.RUN_STATUS_PAUSE) {
            this.qhN.d();
            return true;
        } else if (this.qhF == j.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.qhN.g();
                return true;
            } catch (com.ss.android.socialbase.downloader.e.a e) {
                this.qhN.a(e);
                return true;
            }
        } else if (this.qhF == j.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.qhN.a(this.F);
                return true;
            } catch (com.ss.android.socialbase.downloader.e.a e2) {
                this.qhN.a(e2);
                return true;
            }
        } else if (this.qhF == j.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.qhN.a(this.qhP, false);
            return false;
        } else if (this.qhF != j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            if (this.qhF == j.RUN_STATUS_RETRY_DELAY && !u()) {
                com.ss.android.socialbase.downloader.f.a.b(f13212a, "doTaskStatusHandle retryDelay");
                w();
                return this.qhF == j.RUN_STATUS_RETRY_DELAY;
            }
            try {
                if (v()) {
                    this.qhN.f();
                    r.eIt().d();
                    return true;
                }
                return false;
            } catch (Throwable th) {
                b(new com.ss.android.socialbase.downloader.e.a(1008, com.ss.android.socialbase.downloader.m.d.c(th, "doTaskStatusHandle onComplete")));
                return true;
            }
        } else {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean u() {
        if (this.qhH.eHM() <= 1) {
            return this.qhH.eHa() > 0 && this.qhH.eHa() == this.qhH.eij();
        }
        List<com.ss.android.socialbase.downloader.g.b> c = this.qhG.c(this.qhH.g());
        if (c == null || c.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.g.b bVar : c) {
            if (bVar == null || !bVar.i()) {
                return false;
            }
            while (r3.hasNext()) {
            }
        }
        return true;
    }

    private boolean v() {
        if (this.qhH.eHA()) {
            this.qhH.f(this.qhH.eHa());
        }
        if (this.qhH.eHa() <= 0 || (!this.qhH.ag() && (this.qhH.eij() <= 0 || this.qhH.eHa() != this.qhH.eij()))) {
            this.qhH.a(com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_RESTART);
            this.qhH.eHE();
            this.qhG.a(this.qhH);
            this.qhG.d(this.qhH.g());
            com.ss.android.socialbase.downloader.m.d.a(this.qhH);
            return false;
        }
        return true;
    }

    private void w() {
        boolean z;
        long eoj = eoj();
        try {
            Intent intent = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
            intent.putExtra("extra_download_id", this.qhH.g());
            intent.setClass(com.ss.android.socialbase.downloader.downloader.b.eGu(), DownloadHandleService.class);
            if (Build.VERSION.SDK_INT >= 19) {
                this.qhO.setExact(2, SystemClock.elapsedRealtime() + eoj, PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eGu(), this.qhH.g(), intent, 1073741824));
            } else {
                this.qhO.set(2, SystemClock.elapsedRealtime() + eoj, PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eGu(), this.qhH.g(), intent, 1073741824));
            }
        } catch (Throwable th) {
            try {
                if (th instanceof NoSuchMethodError) {
                    try {
                        Intent intent2 = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
                        intent2.setClass(com.ss.android.socialbase.downloader.downloader.b.eGu(), DownloadHandleService.class);
                        intent2.putExtra("extra_download_id", this.qhH.g());
                        this.qhO.set(2, eoj + SystemClock.elapsedRealtime(), PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eGu(), this.qhH.g(), intent2, 1073741824));
                        z = true;
                    } catch (Throwable th2) {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    this.qhF = j.RUN_STATUS_NONE;
                }
            } finally {
                this.qhF = j.RUN_STATUS_RETRY_DELAY;
                this.qhH.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_WAITING);
                this.qhG.a(this.qhH);
            }
        }
    }

    private long eoj() {
        return this.qhM.a(this.qhH.up(), this.qhH.eGU());
    }

    private void y() throws a, com.ss.android.socialbase.downloader.e.a {
        com.ss.android.socialbase.downloader.impls.a eGp;
        int g = this.qhH.g();
        int r = com.ss.android.socialbase.downloader.downloader.b.r(this.qhH);
        if (this.qhH.aX()) {
            throw new com.ss.android.socialbase.downloader.e.a(1009, "file has downloaded");
        }
        com.ss.android.socialbase.downloader.g.c b2 = this.qhG.b(r);
        if (b2 != null && (eGp = com.ss.android.socialbase.downloader.downloader.b.eGp()) != null && b2.g() != g && b2.a(this.qhH)) {
            if (eGp.a(b2.g())) {
                this.qhG.f(g);
                throw new com.ss.android.socialbase.downloader.e.a(1025, "another same task is downloading");
            }
            List<com.ss.android.socialbase.downloader.g.b> c = this.qhG.c(r);
            com.ss.android.socialbase.downloader.m.d.a(this.qhH);
            this.qhG.f(r);
            if (b2 != null && b2.eHI()) {
                this.qhH.a(b2, false);
                this.qhG.a(this.qhH);
                if (c != null) {
                    for (com.ss.android.socialbase.downloader.g.b bVar : c) {
                        bVar.b(g);
                        this.qhG.a(bVar);
                    }
                }
                throw new a("retry task because id generator changed");
            }
        }
    }

    private void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) throws com.ss.android.socialbase.downloader.e.a {
        if (list.size() != i) {
            throw new com.ss.android.socialbase.downloader.e.a((int) DebugConstants.HTTP_ERRCODE_VERSION_HIGH, new IllegalArgumentException());
        }
        a(list, this.qhH.eij());
    }

    private void a(long j, int i) throws com.ss.android.socialbase.downloader.e.a {
        long j2;
        long j3 = 0;
        long j4 = j / i;
        int g = this.qhH.g();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < i) {
                if (i3 == i - 1) {
                    j2 = 0;
                } else {
                    j2 = (j3 + j4) - 1;
                }
                com.ss.android.socialbase.downloader.g.b eGN = new b.a(g).RB(i3).ji(j3).jm(j3).jj(j3).jk(j2).eGN();
                arrayList.add(eGN);
                this.qhG.a(eGN);
                j3 += j4;
                i2 = i3 + 1;
            } else {
                this.qhH.d(i);
                this.qhG.a(g, i);
                a(arrayList, j);
                return;
            }
        }
    }

    private void a(List<com.ss.android.socialbase.downloader.g.b> list, long j) throws com.ss.android.socialbase.downloader.e.a {
        long p;
        for (com.ss.android.socialbase.downloader.g.b bVar : list) {
            if (bVar != null) {
                if (bVar.p() == 0) {
                    p = j - bVar.n();
                } else {
                    p = (bVar.p() - bVar.n()) + 1;
                }
                if (p > 0) {
                    bVar.a(p);
                    if (this.qhH.ad() && this.qhQ != null && (!this.qhH.af() || this.E)) {
                        if (bVar.s() == 0) {
                            this.f.add(new b(bVar, this.qhD, this.qhQ, this));
                        } else if (bVar.s() > 0) {
                            this.f.add(new b(bVar, this.qhD, this));
                        }
                    } else {
                        this.f.add(new b(bVar, this.qhD, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.m.a.a(64)) {
            ArrayList arrayList = new ArrayList(this.f.size());
            Iterator<b> it = this.f.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (this.qhF == j.RUN_STATUS_CANCELED) {
                    next.b();
                } else if (this.qhF == j.RUN_STATUS_PAUSE) {
                    next.a();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> hb = com.ss.android.socialbase.downloader.impls.e.hb(arrayList);
                for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = com.ss.android.socialbase.downloader.impls.e.hc(hb)) {
                    if (!s()) {
                        runnable.run();
                    } else {
                        return;
                    }
                }
                if (hb != null && !hb.isEmpty()) {
                    for (Future future : hb) {
                        if (future != null && !future.isDone()) {
                            try {
                                future.get();
                            } catch (Throwable th) {
                            }
                        }
                    }
                    return;
                }
                return;
            } catch (Throwable th2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.f.size());
        Iterator<b> it2 = this.f.iterator();
        while (it2.hasNext()) {
            b next2 = it2.next();
            if (this.qhF == j.RUN_STATUS_CANCELED) {
                next2.b();
            } else if (this.qhF == j.RUN_STATUS_PAUSE) {
                next2.a();
            } else {
                arrayList2.add(Executors.callable(next2));
            }
        }
        if (!s()) {
            try {
                com.ss.android.socialbase.downloader.impls.e.c(arrayList2);
            } catch (InterruptedException e) {
                throw new com.ss.android.socialbase.downloader.e.a(1020, e);
            }
        }
    }

    private void a(com.ss.android.socialbase.downloader.g.b bVar, String str, g gVar) throws com.ss.android.socialbase.downloader.e.a {
        bVar.a(this.qhH.eij() - bVar.n());
        this.qhH.d(1);
        this.qhG.a(this.qhH.g(), 1);
        this.qhE = new com.ss.android.socialbase.downloader.downloader.d(this.qhH, str, gVar, bVar, this);
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends Throwable {

        /* renamed from: b  reason: collision with root package name */
        private String f13217b;

        public a(String str) {
            super(str);
            this.f13217b = str;
        }

        public String a() {
            return this.f13217b;
        }
    }

    private boolean z() {
        if (this.qhH == null || ((this.i && this.qhH.eHM() <= 1) || this.qhH.eHn())) {
            return false;
        }
        return this.j && !this.l;
    }

    private void a(long j, String str, String str2) throws com.ss.android.socialbase.downloader.e.a {
        long j2;
        long j3;
        if (!com.ss.android.socialbase.downloader.m.d.b(j)) {
            com.ss.android.socialbase.downloader.g.f A = com.ss.android.socialbase.downloader.m.d.A(str, str2, -1);
            try {
                long length = new File(str, str2).length();
                long j4 = j - length;
                long c = com.ss.android.socialbase.downloader.m.d.c(str);
                com.ss.android.socialbase.downloader.k.a RV = com.ss.android.socialbase.downloader.k.a.RV(this.qhH.g());
                if (RV.a("space_fill_part_download", 0) == 1) {
                    this.G = 0L;
                    long eij = j4 <= 0 ? this.qhH.eij() - this.qhH.eHa() : j4;
                    if (c < eij) {
                        com.ss.android.socialbase.downloader.f.a.d(f13212a, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.m.d.a(j) + "MB, downloaded = " + com.ss.android.socialbase.downloader.m.d.a(length) + "MB, required = " + com.ss.android.socialbase.downloader.m.d.a(eij) + "MB, available = " + com.ss.android.socialbase.downloader.m.d.a(c) + "MB");
                        if (c > 0) {
                            int a2 = RV.a("space_fill_min_keep_mb", 100);
                            if (a2 > 0) {
                                j2 = c - (a2 * 1048576);
                                com.ss.android.socialbase.downloader.f.a.d(f13212a, "checkSpaceOverflow: minKeep = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.m.d.a(j2) + "MB");
                                if (j2 <= 0) {
                                    throw new com.ss.android.socialbase.downloader.e.e(c, eij);
                                }
                                this.G = this.qhH.eHa() + j2;
                            } else {
                                j2 = c;
                            }
                            if (length < j) {
                                j3 = j2 + length;
                                if (j3 > j) {
                                    j3 = j;
                                }
                            } else {
                                j3 = j;
                            }
                        } else if (RV.a("download_when_space_negative", 0) != 1) {
                            throw new com.ss.android.socialbase.downloader.e.a(1052, "availableSpace " + (c == 0 ? "=" : "<") + " 0");
                        }
                        A.b(j);
                        com.ss.android.socialbase.downloader.m.d.a(A);
                    }
                } else if (c <= 0) {
                    throw new com.ss.android.socialbase.downloader.e.a(1052, "availableSpace " + (c == 0 ? "=" : "<") + " 0");
                } else if (c < j4) {
                    throw new com.ss.android.socialbase.downloader.e.e(c, j4);
                }
                A.b(j);
                com.ss.android.socialbase.downloader.m.d.a(A);
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.m.d.a(A);
                throw th;
            }
        }
    }

    private void A() throws com.ss.android.socialbase.downloader.e.a {
        long j;
        int a2;
        try {
            j = com.ss.android.socialbase.downloader.m.d.c(this.qhH.l());
        } catch (com.ss.android.socialbase.downloader.e.a e) {
            j = 0;
        }
        com.ss.android.socialbase.downloader.f.a.c(f13212a, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.m.d.a(j) + "MB");
        if (j > 0) {
            long eij = this.qhH.eij() - this.qhH.eHa();
            if (j < eij && (a2 = com.ss.android.socialbase.downloader.k.a.RV(this.qhH.g()).a("space_fill_min_keep_mb", 100)) > 0) {
                long j2 = j - (a2 * 1048576);
                com.ss.android.socialbase.downloader.f.a.c(f13212a, "checkSpaceOverflowInProgress: minKeep  = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.m.d.a(j2) + "MB");
                if (j2 <= 0) {
                    this.G = 0L;
                    throw new com.ss.android.socialbase.downloader.e.e(j, eij);
                } else {
                    this.G = this.qhH.eHa() + j2 + 1048576;
                    return;
                }
            }
        }
        this.G = 0L;
    }

    private void B() throws com.ss.android.socialbase.downloader.e.g {
        if (this.qhH.x() && !com.ss.android.socialbase.downloader.m.d.a(com.ss.android.socialbase.downloader.downloader.b.eGu(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.ss.android.socialbase.downloader.e.g(1019, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.qhH.eHx()) {
            throw new com.ss.android.socialbase.downloader.e.d();
        }
        if (!this.qhH.eHy()) {
            throw new com.ss.android.socialbase.downloader.e.f();
        }
    }

    private void C() throws com.ss.android.socialbase.downloader.e.a {
        if (TextUtils.isEmpty(this.qhH.k())) {
            throw new com.ss.android.socialbase.downloader.e.a((int) ARPMessageType.MSG_TYPE_VIDEO_STOP_RES, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.qhH.h())) {
            throw new com.ss.android.socialbase.downloader.e.a((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_FAILED, "download name can not be empty");
        }
        File file = new File(this.qhH.k());
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new com.ss.android.socialbase.downloader.e.a(1030, "download savePath directory can not created");
            }
        } else if (!file.isDirectory()) {
            throw new com.ss.android.socialbase.downloader.e.a(1031, "download savePath is not a directory");
        }
    }

    private boolean s(int i, String str, String str2) {
        if (i == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.k || this.j)) {
            return (i == 201 || i == 416) && this.qhH.eHa() > 0;
        }
        return true;
    }

    private void a(String str, String str2) throws a {
        this.qhG.d(this.qhH.g());
        com.ss.android.socialbase.downloader.m.d.a(this.qhH);
        this.i = false;
        this.qhH.j(str);
        this.qhG.a(this.qhH);
        throw new a(str2);
    }

    private void a(com.ss.android.socialbase.downloader.i.e eVar, long j) throws com.ss.android.socialbase.downloader.e.a, a {
        String str;
        String str2;
        long j2;
        if (eVar != null) {
            try {
                int b2 = eVar.b();
                String a2 = eVar.a("Accept-Ranges");
                String a3 = eVar.a("Content-Type");
                if (TextUtils.isEmpty(this.qhH.eHf()) && !TextUtils.isEmpty(a3)) {
                    this.qhH.h(a3);
                }
                this.j = com.ss.android.socialbase.downloader.m.d.a(b2, a2);
                this.k = com.ss.android.socialbase.downloader.m.d.c(b2);
                this.qhH.i(this.j);
                String an = this.qhH.an();
                String a4 = eVar.a("Etag");
                if (!s(b2, an, a4)) {
                    str = a4;
                } else if (eVar instanceof g) {
                    if (!TextUtils.isEmpty(an) && an.equals(a4)) {
                        a4 = "";
                    }
                    a(a4, "eTag of server file changed");
                    str = a4;
                } else {
                    throw new com.ss.android.socialbase.downloader.e.c(1002, b2, "");
                }
                if (this.j || this.k) {
                    if (this.k && j > 0) {
                        if (eVar instanceof g) {
                            a("", "http head request not support");
                        } else {
                            throw new com.ss.android.socialbase.downloader.e.a(1004, "isResponseFromBegin but firstOffset > 0");
                        }
                    }
                    long b3 = com.ss.android.socialbase.downloader.m.d.b(eVar);
                    if (!TextUtils.isEmpty(this.qhH.h())) {
                        str2 = "";
                    } else {
                        str2 = com.ss.android.socialbase.downloader.m.d.a(eVar, this.qhH.j());
                    }
                    if (com.ss.android.socialbase.downloader.m.a.a(8)) {
                        this.l = com.ss.android.socialbase.downloader.m.d.d(eVar);
                    } else {
                        this.l = com.ss.android.socialbase.downloader.m.d.b(b3);
                    }
                    if (!this.l && b3 == 0 && !(eVar instanceof g)) {
                        throw new com.ss.android.socialbase.downloader.e.a(1004, "");
                    }
                    if (!this.l) {
                        String b4 = com.ss.android.socialbase.downloader.m.d.b(eVar, Headers.CONTENT_RANGE);
                        if (!TextUtils.isEmpty(b4) && com.ss.android.socialbase.downloader.m.a.a(2)) {
                            j2 = com.ss.android.socialbase.downloader.m.d.a(b4);
                        } else {
                            j2 = j + b3;
                        }
                    } else {
                        j2 = -1;
                    }
                    if (!s()) {
                        if (this.qhH.eEi() > 0 && com.ss.android.socialbase.downloader.k.a.RV(this.qhH.g()).b("force_check_file_length") == 1 && this.qhH.eEi() != j2) {
                            throw new com.ss.android.socialbase.downloader.e.a(1070, "expectFileLength = " + this.qhH.eEi() + " , totalLength = " + j2);
                        }
                        this.qhN.a(j2, str, str2);
                    }
                } else if (b2 == 403) {
                    throw new com.ss.android.socialbase.downloader.e.a(1047, "response code error : 403");
                } else {
                    throw new com.ss.android.socialbase.downloader.e.c(1004, b2, "response code error : " + b2);
                }
            } catch (com.ss.android.socialbase.downloader.e.a e) {
                throw e;
            } catch (a e2) {
                throw e2;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.m.d.a(th, "HandleFirstConnection");
            }
        }
    }

    public boolean d() {
        return this.m.get();
    }

    public int e() {
        if (this.qhH != null) {
            return this.qhH.g();
        }
        return 0;
    }

    public void f() {
        this.H = System.currentTimeMillis();
        this.qhN.a();
    }

    private void D() {
        long u = com.ss.android.socialbase.downloader.m.d.u(this.qhH);
        this.qhH.d(u);
        this.i = u > 0;
        if (!this.i) {
            this.qhG.d(this.qhH.g());
            com.ss.android.socialbase.downloader.m.d.a(this.qhH);
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public boolean a(long j) throws com.ss.android.socialbase.downloader.e.a {
        if (this.G > 0 && this.qhH.eHa() > this.G) {
            A();
        }
        return this.qhN.a(j);
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void a(b bVar) {
        if (!this.h) {
            synchronized (this) {
                this.f.remove(bVar);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public boolean d(com.ss.android.socialbase.downloader.e.a aVar) {
        if (!com.ss.android.socialbase.downloader.m.d.g(aVar)) {
            return ((this.e != null && this.e.get() > 0) || this.qhH.aZ() || (aVar != null && ((aVar.a() == 1011 || (aVar.getCause() != null && (aVar.getCause() instanceof SSLHandshakeException))) && this.qhH.ba()))) && !(aVar instanceof com.ss.android.socialbase.downloader.e.g);
        } else if (!this.h || this.d) {
            return true;
        } else {
            com.ss.android.socialbase.downloader.m.d.a(this.qhH);
            this.d = true;
            return true;
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void b(com.ss.android.socialbase.downloader.e.a aVar) {
        com.ss.android.socialbase.downloader.f.a.b(f13212a, "onError:" + aVar.getMessage());
        this.qhF = j.RUN_STATUS_ERROR;
        this.qhP = aVar;
        F();
    }

    private void E() {
        try {
            this.qhG.d(this.qhH.g());
            com.ss.android.socialbase.downloader.m.d.a(this.qhH);
            this.i = false;
            this.qhH.j("");
            this.qhG.a(this.qhH);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void e(com.ss.android.socialbase.downloader.e.a aVar) {
        if (this.qhH != null) {
            this.qhH.m(true);
        }
        a(aVar, false);
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        com.ss.android.socialbase.downloader.f.a.b(f13212a, "onAllChunkRetryWithReset");
        this.qhF = j.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.qhP = aVar;
        F();
        boolean z2 = false;
        if (z) {
            z2 = f(aVar);
        }
        if (!z2) {
            E();
        }
    }

    private void F() {
        try {
            Iterator it = ((ArrayList) this.f.clone()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null) {
                    bVar.b();
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.f.a.c(f13212a, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.qhH.a(list, this.qhF == j.RUN_STATUS_WAITING_ASYNC_HANDLER);
            com.ss.android.socialbase.downloader.impls.a eGp = com.ss.android.socialbase.downloader.downloader.b.eGp();
            if (eGp != null) {
                eGp.Rv(this.qhH.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.ss.android.socialbase.downloader.impls.a eGp;
        if (!s() && (eGp = com.ss.android.socialbase.downloader.downloader.b.eGp()) != null) {
            eGp.Rv(this.qhH.g());
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public com.ss.android.socialbase.downloader.e.h a(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.e.a aVar, long j) {
        if (r()) {
            return com.ss.android.socialbase.downloader.e.h.RETURN;
        }
        if (aVar != null && (aVar.a() == 1047 || com.ss.android.socialbase.downloader.m.d.I(aVar))) {
            return a(aVar, j);
        }
        this.qhP = aVar;
        this.qhH.e(-j);
        this.qhG.a(this.qhH);
        if (f(aVar)) {
            return com.ss.android.socialbase.downloader.e.h.RETURN;
        }
        this.qhN.a(bVar, aVar, this.qhF == j.RUN_STATUS_RETRY_DELAY);
        if (this.qhF != j.RUN_STATUS_RETRY_DELAY && this.qhH.eHh()) {
            long eoj = eoj();
            if (eoj > 0) {
                com.ss.android.socialbase.downloader.f.a.c(f13212a, "onSingleChunkRetry with delay time " + eoj);
                try {
                    Thread.sleep(eoj);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.f.a.d(f13212a, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.e.h.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public com.ss.android.socialbase.downloader.e.h a(com.ss.android.socialbase.downloader.e.a aVar, long j) {
        long j2;
        long eij;
        boolean z;
        this.qhP = aVar;
        this.qhH.e(-j);
        this.qhG.a(this.qhH);
        if (r()) {
            return com.ss.android.socialbase.downloader.e.h.RETURN;
        }
        if (aVar != null && aVar.a() == 1047) {
            if (this.qhS == null || this.qhH.eir()) {
                if (f(aVar)) {
                    return com.ss.android.socialbase.downloader.e.h.RETURN;
                }
            } else {
                u uVar = new u() { // from class: com.ss.android.socialbase.downloader.l.c.1
                    @Override // com.ss.android.socialbase.downloader.d.u, com.ss.android.socialbase.downloader.d.aj
                    public void a(List<String> list) {
                        super.a(list);
                        c.this.a(list);
                    }
                };
                boolean a2 = this.qhS.a(uVar);
                this.qhH.eHj();
                if (a2) {
                    if (!uVar.a()) {
                        F();
                        this.qhN.h();
                        this.qhF = j.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    }
                    z = true;
                }
            }
            z = false;
        } else if (com.ss.android.socialbase.downloader.m.d.I(aVar)) {
            if (this.qhT == null) {
                b(aVar);
                return com.ss.android.socialbase.downloader.e.h.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ae aeVar = new ae() { // from class: com.ss.android.socialbase.downloader.l.c.2
                @Override // com.ss.android.socialbase.downloader.d.ae
                public void a() {
                    synchronized (c.this) {
                        atomicBoolean.set(true);
                        c.this.G();
                    }
                }
            };
            if (aVar instanceof com.ss.android.socialbase.downloader.e.e) {
                j2 = ((com.ss.android.socialbase.downloader.e.e) aVar).c();
                eij = ((com.ss.android.socialbase.downloader.e.e) aVar).d();
            } else {
                j2 = -1;
                eij = this.qhH.eij();
            }
            synchronized (this) {
                if (this.qhT.a(j2, eij, aeVar)) {
                    if (!com.ss.android.socialbase.downloader.k.a.RV(this.qhH.g()).b("not_delete_when_clean_space", false)) {
                        v();
                    }
                    if (!atomicBoolean.get()) {
                        if (this.qhF != j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                            this.qhF = j.RUN_STATUS_WAITING_ASYNC_HANDLER;
                            F();
                            this.qhN.h();
                        }
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    } else if (f(aVar)) {
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    } else {
                        z = true;
                    }
                } else if (this.qhF == j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                    return com.ss.android.socialbase.downloader.e.h.RETURN;
                } else {
                    b(aVar);
                    return com.ss.android.socialbase.downloader.e.h.RETURN;
                }
            }
        } else {
            if (f(aVar)) {
                return com.ss.android.socialbase.downloader.e.h.RETURN;
            }
            z = false;
        }
        if (!z && H()) {
            F();
        }
        this.qhN.a(aVar, this.qhF == j.RUN_STATUS_RETRY_DELAY);
        return this.qhF == j.RUN_STATUS_RETRY_DELAY ? com.ss.android.socialbase.downloader.e.h.RETURN : com.ss.android.socialbase.downloader.e.h.CONTINUE;
    }

    private boolean f(com.ss.android.socialbase.downloader.e.a aVar) {
        boolean z = true;
        if (this.e != null) {
            if (this.e.get() <= 0 || (aVar != null && aVar.a() == 1070)) {
                if (this.qhH.aY()) {
                    this.e.set(this.qhH.K());
                    this.qhH.h(this.e.get());
                    z = false;
                } else if (aVar != null && ((aVar.a() == 1011 || (aVar.getCause() != null && (aVar.getCause() instanceof SSLHandshakeException))) && this.qhH.ba())) {
                    this.e.set(this.qhH.J());
                    this.qhH.h(this.e.get());
                    this.qhH.k(true);
                    z = false;
                } else {
                    b(new com.ss.android.socialbase.downloader.e.a(aVar.a(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.e), String.valueOf(this.qhH.J()), aVar.b())));
                    return true;
                }
            }
            if (this.qhF != j.RUN_STATUS_RETRY_DELAY && z) {
                this.qhH.h(this.e.decrementAndGet());
            }
            return false;
        }
        b(new com.ss.android.socialbase.downloader.e.a(1043, "retry for exception, but retain retry time is null, last error is :" + aVar.b()));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public synchronized com.ss.android.socialbase.downloader.g.b RX(int i) {
        com.ss.android.socialbase.downloader.g.b bVar;
        if (this.qhH.eHM() >= 2) {
            List<com.ss.android.socialbase.downloader.g.b> c = this.qhG.c(this.qhH.g());
            if (c != null && !c.isEmpty()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= c.size()) {
                        bVar = null;
                        break;
                    }
                    com.ss.android.socialbase.downloader.g.b bVar2 = c.get(i2);
                    if (bVar2 != null && (bVar = a(bVar2, i)) != null) {
                        break;
                    }
                    i2++;
                }
            } else {
                bVar = null;
            }
        } else {
            bVar = null;
        }
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // com.ss.android.socialbase.downloader.l.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.ss.android.socialbase.downloader.i.e eVar) {
        boolean z;
        if (eVar != null) {
            try {
                int b2 = eVar.b();
                this.qhH.f(b2);
                this.qhH.g(com.ss.android.socialbase.downloader.m.b.a(b2));
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z) {
                this.qhH.f(-1);
                this.qhH.g("");
                return;
            }
            return;
        }
        z = false;
        if (z) {
        }
    }

    private com.ss.android.socialbase.downloader.g.b a(com.ss.android.socialbase.downloader.g.b bVar, int i) {
        com.ss.android.socialbase.downloader.g.b bVar2;
        if (bVar.d()) {
            long Cn = bVar.Cn(true);
            com.ss.android.socialbase.downloader.f.a.b(f13212a, "reuseChunk retainLen:" + Cn + " chunkIndex:" + i);
            boolean z = false;
            if (!bVar.f() && Cn > com.ss.android.socialbase.downloader.b.e.d && this.qhH.p()) {
                List<com.ss.android.socialbase.downloader.g.b> F = bVar.F(this.qhH.eHM(), this.qhH.eij());
                if (F != null) {
                    for (com.ss.android.socialbase.downloader.g.b bVar3 : F) {
                        this.qhG.b(bVar3);
                    }
                }
                z = true;
            } else if (bVar.f()) {
                z = true;
            }
            if (z && bVar.f()) {
                int i2 = 1;
                while (true) {
                    if (i2 >= bVar.g().size()) {
                        bVar2 = null;
                        break;
                    }
                    bVar2 = bVar.g().get(i2);
                    if (bVar2 != null) {
                        com.ss.android.socialbase.downloader.f.a.b(f13212a, "check can checkUnCompletedChunk -- chunkIndex:" + bVar2.s() + " currentOffset:" + bVar2.n() + "  startOffset:" + bVar2.l() + " contentLen:" + bVar2.q());
                        if (bVar2.s() < 0) {
                            break;
                        } else if (!bVar2.i() && !bVar2.c()) {
                            break;
                        }
                    }
                    i2++;
                }
                if (bVar2 != null) {
                    com.ss.android.socialbase.downloader.f.a.b(f13212a, "unComplete chunk " + bVar.s() + " curOffset:" + bVar.n() + " reuseChunk chunkIndex:" + i + " for subChunk:" + bVar2.s());
                    this.qhG.a(bVar2.k(), bVar2.s(), bVar2.b(), i);
                    bVar2.c(i);
                    bVar2.a(true);
                    return bVar2;
                }
                return bVar2;
            }
            return null;
        }
        return null;
    }

    private boolean H() {
        if (this.qhF == j.RUN_STATUS_RETRY_DELAY || this.qhO == null || !this.qhH.eHh() || eoj() <= 0) {
            return false;
        }
        this.qhF = j.RUN_STATUS_RETRY_DELAY;
        return true;
    }

    private s e(com.ss.android.socialbase.downloader.g.d dVar) {
        s eIe = dVar.eIe();
        if (eIe == null) {
            com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
            if (a2 != null) {
                String eHi = a2.eHi();
                if (!TextUtils.isEmpty(eHi)) {
                    return new q(eHi);
                }
            }
            return com.ss.android.socialbase.downloader.downloader.b.eGt();
        }
        return eIe;
    }

    public Future eIz() {
        return this.f13213b;
    }

    public void a(Future future) {
        this.f13213b = future;
    }

    public void b(long j) {
        if (this.qhQ != null && (this.qhQ instanceof com.ss.android.socialbase.downloader.i.a)) {
            try {
                ((com.ss.android.socialbase.downloader.i.a) this.qhQ).a(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
