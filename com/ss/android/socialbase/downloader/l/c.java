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
/* loaded from: classes4.dex */
public class c implements e, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13210a = c.class.getSimpleName();
    private String F;
    private long G;
    private long H;

    /* renamed from: b  reason: collision with root package name */
    private Future f13211b;
    private AtomicInteger e;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private final AtomicBoolean m;
    private volatile com.ss.android.socialbase.downloader.downloader.d pXA;
    private final k pXC;
    private com.ss.android.socialbase.downloader.g.c pXD;
    private i pXE;
    private final i pXF;
    private h pXG;
    private final h pXH;
    private s pXI;
    private final com.ss.android.socialbase.downloader.downloader.e pXJ;
    private AlarmManager pXK;
    private volatile com.ss.android.socialbase.downloader.e.a pXL;
    private g pXM;
    private com.ss.android.socialbase.downloader.i.e pXN;
    private al pXO;
    private af pXP;
    private final com.ss.android.socialbase.downloader.k.a pXQ;
    private final com.ss.android.socialbase.downloader.g.d pXz;
    private volatile boolean d = false;
    private final ArrayList<b> f = new ArrayList<>();
    private volatile j pXB = j.RUN_STATUS_NONE;
    private volatile int C = 5;
    private boolean D = false;
    private boolean E = false;

    public c(com.ss.android.socialbase.downloader.g.d dVar, Handler handler) {
        this.pXz = dVar;
        if (dVar != null) {
            this.pXD = dVar.a();
            this.pXE = dVar.eFM();
            this.pXG = dVar.eFT();
            this.pXO = dVar.eFO();
            this.pXP = dVar.eFP();
            this.pXI = e(dVar);
            this.pXQ = com.ss.android.socialbase.downloader.k.a.RA(this.pXD.g());
        } else {
            this.pXQ = com.ss.android.socialbase.downloader.k.a.eGg();
        }
        h();
        this.pXC = com.ss.android.socialbase.downloader.downloader.b.eDT();
        this.pXF = com.ss.android.socialbase.downloader.downloader.b.eDZ();
        this.pXH = com.ss.android.socialbase.downloader.downloader.b.eEb();
        this.pXJ = new com.ss.android.socialbase.downloader.downloader.e(dVar, handler);
        this.pXK = com.ss.android.socialbase.downloader.downloader.b.eDJ();
        this.m = new AtomicBoolean(true);
    }

    private void h() {
        if (this.pXD != null) {
            int J = this.pXD.J() - this.pXD.ax();
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
        this.pXB = j.RUN_STATUS_PAUSE;
        if (this.pXA != null) {
            this.pXA.b();
        } else {
            p();
            this.pXB = j.RUN_STATUS_PAUSE;
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
        this.pXB = j.RUN_STATUS_CANCELED;
        if (this.pXA != null) {
            this.pXA.c();
        } else {
            p();
            this.pXB = j.RUN_STATUS_CANCELED;
            m();
        }
        F();
    }

    public com.ss.android.socialbase.downloader.g.d eGh() {
        return this.pXz;
    }

    private int c(long j, List<com.ss.android.socialbase.downloader.g.b> list) {
        int i;
        int a2;
        if (z()) {
            if (this.i) {
                if (list != null) {
                    i = list.size();
                } else {
                    i = this.pXD.eFv();
                }
            } else {
                if (this.pXE != null) {
                    a2 = this.pXE.a(j);
                } else {
                    a2 = this.pXF.a(j);
                }
                com.ss.android.socialbase.downloader.i.k eFY = com.ss.android.socialbase.downloader.i.j.eFX().eFY();
                com.ss.android.socialbase.downloader.f.a.b(f13210a, String.format("NetworkQuality is : %s", eFY.name()));
                this.pXD.f(eFY.name());
                if (this.pXG != null) {
                    i = this.pXG.a(a2, eFY);
                } else {
                    i = this.pXH.a(a2, eFY);
                }
            }
            if (i <= 0) {
                i = 1;
            }
        } else {
            i = 1;
        }
        if (com.ss.android.socialbase.downloader.f.a.a()) {
            com.ss.android.socialbase.downloader.f.a.b(f13210a, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(i), this.pXD.h(), String.valueOf(j)));
        }
        return i;
    }

    private boolean i() {
        int q = this.pXD.q();
        if (q == 1 || this.pXD.eEZ()) {
            return true;
        }
        if (q != -2 && q != -4) {
            b(new com.ss.android.socialbase.downloader.e.a(1000, "The download Task can't start, because its status is not prepare:" + q));
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [302=4] */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r8.pXQ.a("fix_file_exist_update_download_info") != false) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j() throws com.ss.android.socialbase.downloader.e.b {
        boolean z;
        boolean z2 = true;
        try {
            try {
                int g = this.pXD.g();
                if (this.pXC != null) {
                    if (com.ss.android.socialbase.downloader.m.a.a(2048)) {
                        this.pXC.d();
                    }
                    com.ss.android.socialbase.downloader.g.c b2 = this.pXC.b(g);
                    if (b2 == null || b2.bk()) {
                        this.pXD.eFn();
                        z = true;
                    } else {
                        String k = this.pXD.k();
                        String F = this.pXD.F();
                        this.pXD.a(b2, true);
                        z = com.ss.android.socialbase.downloader.m.a.a(4096) && b2 != this.pXD;
                        try {
                            if (k.equals(b2.k()) && com.ss.android.socialbase.downloader.m.d.a(b2, false, F)) {
                                try {
                                    throw new com.ss.android.socialbase.downloader.e.b(b2.h());
                                } catch (com.ss.android.socialbase.downloader.e.b e) {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    if (this.pXz != null && this.pXD != null) {
                                        com.ss.android.socialbase.downloader.h.a.a(this.pXz.eFL(), this.pXD, new com.ss.android.socialbase.downloader.e.a(1003, com.ss.android.socialbase.downloader.m.d.c(th, "checkTaskCache")), this.pXD.q());
                                    }
                                    if (z) {
                                        if (z2) {
                                            try {
                                                if (!this.pXQ.a("fix_file_exist_update_download_info")) {
                                                    return;
                                                }
                                            } catch (SQLiteException e2) {
                                                e2.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.pXC.a(this.pXD);
                                        return;
                                    }
                                    return;
                                }
                            } else if (com.ss.android.socialbase.downloader.downloader.b.r(b2) != g) {
                                try {
                                    this.pXC.f(g);
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
                                this.pXC.a(this.pXD);
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
                        this.pXC.a(this.pXD);
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
        com.ss.android.socialbase.downloader.downloader.b.a(this.pXz, 3);
        k();
        com.ss.android.socialbase.downloader.downloader.b.b(this.pXz, 3);
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
            if (this.pXD != null && this.H > 0) {
                this.pXD.c(System.currentTimeMillis() - this.H);
            }
        } catch (Throwable th) {
        }
        try {
            an eFJ = this.pXz.eFJ();
            if (eFJ != null) {
                if (eFJ.a()) {
                    this.pXJ.e();
                    return;
                }
            }
        } finally {
            if (i()) {
            }
        }
        if (i()) {
            com.ss.android.socialbase.downloader.h.a.a(this.pXz.eFL(), this.pXD, new com.ss.android.socialbase.downloader.e.a(1003, "task status is invalid"), this.pXD != null ? this.pXD.q() : 0);
            return;
        }
        while (true) {
            l();
            if (this.D) {
                if (this.C > 0) {
                    this.C--;
                } else if (this.pXD.eEJ() != this.pXD.efR()) {
                    com.ss.android.socialbase.downloader.f.a.b(f13210a, this.pXD.d());
                    this.pXJ.a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.pXD.eEK()));
                    return;
                } else if (this.pXD.eEJ() <= 0) {
                    com.ss.android.socialbase.downloader.f.a.b(f13210a, this.pXD.d());
                    this.pXJ.a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, "curBytes is 0, bytes invalid retry status is : " + this.pXD.eEK()));
                    return;
                } else if (this.pXD.efR() <= 0) {
                    com.ss.android.socialbase.downloader.f.a.b(f13210a, this.pXD.d());
                    this.pXJ.a(new com.ss.android.socialbase.downloader.e.g(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.pXD.eEK()));
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
            this.pXB = j.RUN_STATUS_NONE;
            this.pXD.Q();
            this.pXD.eEI();
            long currentTimeMillis = System.currentTimeMillis();
            this.pXD.a(-1L);
            boolean z = false;
            try {
                j();
            } catch (com.ss.android.socialbase.downloader.e.b e) {
                com.ss.android.socialbase.downloader.f.a.b(f13210a, "file exist " + e.c());
                this.F = e.c();
                z = true;
            }
            if (!this.D) {
                this.pXJ.b();
            }
            this.D = false;
            if (s()) {
                return;
            }
            if (!TextUtils.isEmpty(this.F) && z) {
                if (com.ss.android.socialbase.downloader.k.a.eGg().b("fix_end_for_file_exist_error", true)) {
                    if (this.F.equals(this.pXD.h())) {
                        this.pXB = j.RUN_STATUS_END_RIGHT_NOW;
                    } else {
                        this.pXB = j.RUN_STATUS_END_FOR_FILE_EXIST;
                    }
                } else if (this.F.equals(this.pXD.n())) {
                    this.pXB = j.RUN_STATUS_END_RIGHT_NOW;
                } else {
                    this.pXB = j.RUN_STATUS_END_FOR_FILE_EXIST;
                }
                return;
            }
            com.ss.android.socialbase.downloader.i.b.eFW().b();
            while (!s()) {
                try {
                    try {
                        C();
                        y();
                        B();
                        c = this.pXC.c(this.pXD.g());
                        D();
                        O = this.pXD.O();
                    } catch (com.ss.android.socialbase.downloader.e.a e2) {
                        com.ss.android.socialbase.downloader.f.a.d(f13210a, "downloadInner: baseException = " + e2);
                        if (this.pXB != j.RUN_STATUS_PAUSE) {
                            if (e2.a() == 1025 || e2.a() == 1009) {
                                this.pXB = j.RUN_STATUS_END_RIGHT_NOW;
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
                    com.ss.android.socialbase.downloader.f.a.d(f13210a, "downloadInner: retry throwable for " + e3.a());
                    if (this.pXB != j.RUN_STATUS_PAUSE) {
                        if (this.e != null && this.e.get() > 0) {
                            this.pXD.h(this.e.decrementAndGet());
                            this.pXD.c(5);
                            p();
                        } else if (this.e == null) {
                            b(new com.ss.android.socialbase.downloader.e.a(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e3.a()));
                        } else if (this.pXD.aY()) {
                            this.pXD.c(5);
                            this.e.set(this.pXD.J());
                            this.pXD.h(this.e.get());
                            p();
                        } else {
                            b(new com.ss.android.socialbase.downloader.e.a(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.pXD.J()), e3.a())));
                        }
                    }
                    p();
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.f.a.d(f13210a, "downloadInner: throwable =  " + th);
                    if (this.pXB != j.RUN_STATUS_PAUSE) {
                        b(new com.ss.android.socialbase.downloader.e.a(1045, th));
                    }
                    p();
                }
                if (s()) {
                    p();
                    return;
                }
                long t = this.i ? com.ss.android.socialbase.downloader.m.d.t(this.pXD) : 0L;
                com.ss.android.socialbase.downloader.g.b jq = jq(t);
                List<com.ss.android.socialbase.downloader.g.e> e4 = e(jq);
                com.ss.android.socialbase.downloader.m.d.a(e4, this.pXD);
                this.pXD.n(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    b(O, e4, t);
                    this.pXD.b(System.currentTimeMillis() - currentTimeMillis2);
                    if (s()) {
                        p();
                        return;
                    }
                    long efR = this.pXD.efR();
                    a(efR, this.pXD.l(), this.pXD.m());
                    int c2 = c(efR, c);
                    if (s()) {
                        p();
                        return;
                    } else if (c2 <= 0) {
                        throw new com.ss.android.socialbase.downloader.e.a((int) DebugConstants.HTTP_ERRCODE_NOT_FIND, "chunkCount is 0");
                    } else {
                        this.h = c2 == 1;
                        if (this.h) {
                            if (this.pXM == null) {
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
                                this.pXD.a(System.currentTimeMillis() - currentTimeMillis);
                                a(jq, O, this.pXM);
                            }
                        } else {
                            if (!this.pXD.ad()) {
                                o();
                            }
                            if (s()) {
                                p();
                                return;
                            }
                            this.pXD.a(System.currentTimeMillis() - currentTimeMillis);
                            if (this.i) {
                                a(c2, c);
                            } else {
                                a(efR, c2);
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
        if (this.pXN != null) {
            try {
                a(this.pXN, j);
            } catch (Throwable th) {
                this.E = true;
            }
        }
        if (this.pXN == null || this.E) {
            a(str, list);
            a(this.pXM, j);
        }
    }

    private void m() {
        boolean z;
        boolean z2;
        boolean z3 = (this.pXB == j.RUN_STATUS_PAUSE || this.pXB == j.RUN_STATUS_CANCELED) ? false : true;
        try {
            z2 = t();
            z = false;
        } catch (Exception e) {
            if (e instanceof com.ss.android.socialbase.downloader.e.a) {
                this.pXJ.a((com.ss.android.socialbase.downloader.e.a) e);
            } else {
                this.pXJ.a(new com.ss.android.socialbase.downloader.e.a(1046, e));
            }
            z = true;
            z2 = true;
        }
        if (z2 || z) {
            this.m.set(false);
            if (z3) {
                try {
                    com.ss.android.socialbase.downloader.impls.a eDY = com.ss.android.socialbase.downloader.downloader.b.eDY();
                    if (eDY != null) {
                        eDY.a(this);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.h.a.a(this.pXz.eFL(), this.pXD, new com.ss.android.socialbase.downloader.e.a(1014, com.ss.android.socialbase.downloader.m.d.c(th, "removeDownloadRunnable")), this.pXD != null ? this.pXD.q() : 0);
                    return;
                }
            }
            return;
        }
        this.D = true;
        com.ss.android.socialbase.downloader.f.a.b(f13210a, "jump to restart");
    }

    private void c(String str, List<com.ss.android.socialbase.downloader.g.e> list, long j) throws com.ss.android.socialbase.downloader.e.a, a {
        com.ss.android.socialbase.downloader.i.a.c w;
        if (this.pXD.eFv() == 1 && (w = com.ss.android.socialbase.downloader.i.a.a.eFV().w(str, list)) != null) {
            this.pXN = w;
            this.pXD.n(1);
        }
        if (this.pXN == null && !this.E && this.pXD.af()) {
            try {
                this.pXN = com.ss.android.socialbase.downloader.downloader.b.a(str, list, this.pXQ.b("net_lib_strategy"), this.pXQ.b("monitor_download_connect") > 0, this.pXD);
            } catch (Throwable th) {
                this.pXD.a(com.ss.android.socialbase.downloader.m.d.L(th));
            }
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.g.e> list) throws com.ss.android.socialbase.downloader.e.a, a {
        if (this.pXM == null) {
            com.ss.android.socialbase.downloader.i.a.d dVar = null;
            if (this.pXD.eFv() == 1) {
                dVar = com.ss.android.socialbase.downloader.i.a.a.eFV().x(str, list);
            }
            try {
                if (dVar != null) {
                    a(this.pXM);
                    this.pXD.n(2);
                    this.pXM = dVar;
                } else {
                    try {
                        this.pXM = com.ss.android.socialbase.downloader.downloader.b.a(this.pXD.o(), this.pXD.I(), str, list, this.pXQ.b("net_lib_strategy"), this.pXQ.b("monitor_download_connect") > 0, this.pXD);
                        a(this.pXM);
                    } catch (com.ss.android.socialbase.downloader.e.a e) {
                        throw e;
                    } catch (Throwable th) {
                        if (com.ss.android.socialbase.downloader.m.d.I(th)) {
                            a("", "http code 416");
                        } else if (com.ss.android.socialbase.downloader.m.d.H(th)) {
                            a("", "http code 412");
                        } else {
                            com.ss.android.socialbase.downloader.m.d.a(th, "CreateFirstConnection");
                        }
                        a(this.pXM);
                    }
                }
                if (this.pXM == null) {
                    throw new com.ss.android.socialbase.downloader.e.a(1022, new IOException("download can't continue, firstConnection is null"));
                }
            } catch (Throwable th2) {
                a(this.pXM);
                throw th2;
            }
        }
    }

    private void n() {
        if (this.pXN != null) {
            this.pXN.c();
            this.pXN = null;
        }
    }

    private void o() {
        if (this.pXM != null) {
            this.pXM.d();
            this.pXM = null;
        }
    }

    private void p() {
        n();
        o();
    }

    private com.ss.android.socialbase.downloader.g.b jq(long j) {
        return new b.a(this.pXD.g()).Rg(-1).jf(0L).jj(j).jg(j).jh(0L).ji(this.pXD.efR() - j).eEw();
    }

    private List<com.ss.android.socialbase.downloader.g.e> e(com.ss.android.socialbase.downloader.g.b bVar) {
        return com.ss.android.socialbase.downloader.m.d.a(this.pXD.eEC(), this.pXD.an(), bVar);
    }

    private void q() throws com.ss.android.socialbase.downloader.e.a {
        if (this.pXA != null) {
            if (this.pXB == j.RUN_STATUS_CANCELED) {
                this.pXD.c(-4);
                this.pXA.c();
            } else if (this.pXB == j.RUN_STATUS_PAUSE) {
                this.pXD.c(-2);
                this.pXA.b();
            } else {
                this.pXA.d();
            }
        }
    }

    private boolean r() {
        return this.pXB == j.RUN_STATUS_CANCELED || this.pXB == j.RUN_STATUS_PAUSE;
    }

    private boolean s() {
        if (r() || this.pXD.q() == -2) {
            if (!r()) {
                if (this.pXD.q() == -2) {
                    this.pXB = j.RUN_STATUS_PAUSE;
                } else if (this.pXD.q() == -4) {
                    this.pXB = j.RUN_STATUS_CANCELED;
                }
            }
            return true;
        }
        return false;
    }

    private boolean t() {
        com.ss.android.socialbase.downloader.i.b.eFW().c();
        if (this.pXB == j.RUN_STATUS_ERROR) {
            this.pXJ.a(this.pXL);
            return true;
        } else if (this.pXB == j.RUN_STATUS_CANCELED) {
            this.pXJ.c();
            return true;
        } else if (this.pXB == j.RUN_STATUS_PAUSE) {
            this.pXJ.d();
            return true;
        } else if (this.pXB == j.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.pXJ.g();
                return true;
            } catch (com.ss.android.socialbase.downloader.e.a e) {
                this.pXJ.a(e);
                return true;
            }
        } else if (this.pXB == j.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.pXJ.a(this.F);
                return true;
            } catch (com.ss.android.socialbase.downloader.e.a e2) {
                this.pXJ.a(e2);
                return true;
            }
        } else if (this.pXB == j.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.pXJ.a(this.pXL, false);
            return false;
        } else if (this.pXB != j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            if (this.pXB == j.RUN_STATUS_RETRY_DELAY && !u()) {
                com.ss.android.socialbase.downloader.f.a.b(f13210a, "doTaskStatusHandle retryDelay");
                w();
                return this.pXB == j.RUN_STATUS_RETRY_DELAY;
            }
            try {
                if (v()) {
                    this.pXJ.f();
                    r.eGc().d();
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
        if (this.pXD.eFv() <= 1) {
            return this.pXD.eEJ() > 0 && this.pXD.eEJ() == this.pXD.efR();
        }
        List<com.ss.android.socialbase.downloader.g.b> c = this.pXC.c(this.pXD.g());
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
        if (this.pXD.eFj()) {
            this.pXD.f(this.pXD.eEJ());
        }
        if (this.pXD.eEJ() <= 0 || (!this.pXD.ag() && (this.pXD.efR() <= 0 || this.pXD.eEJ() != this.pXD.efR()))) {
            this.pXD.a(com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_RESTART);
            this.pXD.eFn();
            this.pXC.a(this.pXD);
            this.pXC.d(this.pXD.g());
            com.ss.android.socialbase.downloader.m.d.a(this.pXD);
            return false;
        }
        return true;
    }

    private void w() {
        boolean z;
        long elP = elP();
        try {
            Intent intent = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
            intent.putExtra("extra_download_id", this.pXD.g());
            intent.setClass(com.ss.android.socialbase.downloader.downloader.b.eEd(), DownloadHandleService.class);
            if (Build.VERSION.SDK_INT >= 19) {
                this.pXK.setExact(2, SystemClock.elapsedRealtime() + elP, PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eEd(), this.pXD.g(), intent, 1073741824));
            } else {
                this.pXK.set(2, SystemClock.elapsedRealtime() + elP, PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eEd(), this.pXD.g(), intent, 1073741824));
            }
        } catch (Throwable th) {
            try {
                if (th instanceof NoSuchMethodError) {
                    try {
                        Intent intent2 = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
                        intent2.setClass(com.ss.android.socialbase.downloader.downloader.b.eEd(), DownloadHandleService.class);
                        intent2.putExtra("extra_download_id", this.pXD.g());
                        this.pXK.set(2, elP + SystemClock.elapsedRealtime(), PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eEd(), this.pXD.g(), intent2, 1073741824));
                        z = true;
                    } catch (Throwable th2) {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    this.pXB = j.RUN_STATUS_NONE;
                }
            } finally {
                this.pXB = j.RUN_STATUS_RETRY_DELAY;
                this.pXD.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_WAITING);
                this.pXC.a(this.pXD);
            }
        }
    }

    private long elP() {
        return this.pXI.a(this.pXD.us(), this.pXD.eED());
    }

    private void y() throws a, com.ss.android.socialbase.downloader.e.a {
        com.ss.android.socialbase.downloader.impls.a eDY;
        int g = this.pXD.g();
        int r = com.ss.android.socialbase.downloader.downloader.b.r(this.pXD);
        if (this.pXD.aX()) {
            throw new com.ss.android.socialbase.downloader.e.a(1009, "file has downloaded");
        }
        com.ss.android.socialbase.downloader.g.c b2 = this.pXC.b(r);
        if (b2 != null && (eDY = com.ss.android.socialbase.downloader.downloader.b.eDY()) != null && b2.g() != g && b2.a(this.pXD)) {
            if (eDY.a(b2.g())) {
                this.pXC.f(g);
                throw new com.ss.android.socialbase.downloader.e.a(1025, "another same task is downloading");
            }
            List<com.ss.android.socialbase.downloader.g.b> c = this.pXC.c(r);
            com.ss.android.socialbase.downloader.m.d.a(this.pXD);
            this.pXC.f(r);
            if (b2 != null && b2.eFr()) {
                this.pXD.a(b2, false);
                this.pXC.a(this.pXD);
                if (c != null) {
                    for (com.ss.android.socialbase.downloader.g.b bVar : c) {
                        bVar.b(g);
                        this.pXC.a(bVar);
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
        a(list, this.pXD.efR());
    }

    private void a(long j, int i) throws com.ss.android.socialbase.downloader.e.a {
        long j2;
        long j3 = 0;
        long j4 = j / i;
        int g = this.pXD.g();
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
                com.ss.android.socialbase.downloader.g.b eEw = new b.a(g).Rg(i3).jf(j3).jj(j3).jg(j3).jh(j2).eEw();
                arrayList.add(eEw);
                this.pXC.a(eEw);
                j3 += j4;
                i2 = i3 + 1;
            } else {
                this.pXD.d(i);
                this.pXC.a(g, i);
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
                    if (this.pXD.ad() && this.pXM != null && (!this.pXD.af() || this.E)) {
                        if (bVar.s() == 0) {
                            this.f.add(new b(bVar, this.pXz, this.pXM, this));
                        } else if (bVar.s() > 0) {
                            this.f.add(new b(bVar, this.pXz, this));
                        }
                    } else {
                        this.f.add(new b(bVar, this.pXz, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.m.a.a(64)) {
            ArrayList arrayList = new ArrayList(this.f.size());
            Iterator<b> it = this.f.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (this.pXB == j.RUN_STATUS_CANCELED) {
                    next.b();
                } else if (this.pXB == j.RUN_STATUS_PAUSE) {
                    next.a();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> hd = com.ss.android.socialbase.downloader.impls.e.hd(arrayList);
                for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = com.ss.android.socialbase.downloader.impls.e.he(hd)) {
                    if (!s()) {
                        runnable.run();
                    } else {
                        return;
                    }
                }
                if (hd != null && !hd.isEmpty()) {
                    for (Future future : hd) {
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
            if (this.pXB == j.RUN_STATUS_CANCELED) {
                next2.b();
            } else if (this.pXB == j.RUN_STATUS_PAUSE) {
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
        bVar.a(this.pXD.efR() - bVar.n());
        this.pXD.d(1);
        this.pXC.a(this.pXD.g(), 1);
        this.pXA = new com.ss.android.socialbase.downloader.downloader.d(this.pXD, str, gVar, bVar, this);
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends Throwable {

        /* renamed from: b  reason: collision with root package name */
        private String f13215b;

        public a(String str) {
            super(str);
            this.f13215b = str;
        }

        public String a() {
            return this.f13215b;
        }
    }

    private boolean z() {
        if (this.pXD == null || ((this.i && this.pXD.eFv() <= 1) || this.pXD.eEW())) {
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
                com.ss.android.socialbase.downloader.k.a RA = com.ss.android.socialbase.downloader.k.a.RA(this.pXD.g());
                if (RA.a("space_fill_part_download", 0) == 1) {
                    this.G = 0L;
                    long efR = j4 <= 0 ? this.pXD.efR() - this.pXD.eEJ() : j4;
                    if (c < efR) {
                        com.ss.android.socialbase.downloader.f.a.d(f13210a, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.m.d.a(j) + "MB, downloaded = " + com.ss.android.socialbase.downloader.m.d.a(length) + "MB, required = " + com.ss.android.socialbase.downloader.m.d.a(efR) + "MB, available = " + com.ss.android.socialbase.downloader.m.d.a(c) + "MB");
                        if (c > 0) {
                            int a2 = RA.a("space_fill_min_keep_mb", 100);
                            if (a2 > 0) {
                                j2 = c - (a2 * 1048576);
                                com.ss.android.socialbase.downloader.f.a.d(f13210a, "checkSpaceOverflow: minKeep = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.m.d.a(j2) + "MB");
                                if (j2 <= 0) {
                                    throw new com.ss.android.socialbase.downloader.e.e(c, efR);
                                }
                                this.G = this.pXD.eEJ() + j2;
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
                        } else if (RA.a("download_when_space_negative", 0) != 1) {
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
            j = com.ss.android.socialbase.downloader.m.d.c(this.pXD.l());
        } catch (com.ss.android.socialbase.downloader.e.a e) {
            j = 0;
        }
        com.ss.android.socialbase.downloader.f.a.c(f13210a, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.m.d.a(j) + "MB");
        if (j > 0) {
            long efR = this.pXD.efR() - this.pXD.eEJ();
            if (j < efR && (a2 = com.ss.android.socialbase.downloader.k.a.RA(this.pXD.g()).a("space_fill_min_keep_mb", 100)) > 0) {
                long j2 = j - (a2 * 1048576);
                com.ss.android.socialbase.downloader.f.a.c(f13210a, "checkSpaceOverflowInProgress: minKeep  = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.m.d.a(j2) + "MB");
                if (j2 <= 0) {
                    this.G = 0L;
                    throw new com.ss.android.socialbase.downloader.e.e(j, efR);
                } else {
                    this.G = this.pXD.eEJ() + j2 + 1048576;
                    return;
                }
            }
        }
        this.G = 0L;
    }

    private void B() throws com.ss.android.socialbase.downloader.e.g {
        if (this.pXD.x() && !com.ss.android.socialbase.downloader.m.d.a(com.ss.android.socialbase.downloader.downloader.b.eEd(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.ss.android.socialbase.downloader.e.g(1019, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.pXD.eFg()) {
            throw new com.ss.android.socialbase.downloader.e.d();
        }
        if (!this.pXD.eFh()) {
            throw new com.ss.android.socialbase.downloader.e.f();
        }
    }

    private void C() throws com.ss.android.socialbase.downloader.e.a {
        if (TextUtils.isEmpty(this.pXD.k())) {
            throw new com.ss.android.socialbase.downloader.e.a((int) ARPMessageType.MSG_TYPE_VIDEO_STOP_RES, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.pXD.h())) {
            throw new com.ss.android.socialbase.downloader.e.a((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_FAILED, "download name can not be empty");
        }
        File file = new File(this.pXD.k());
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
            return (i == 201 || i == 416) && this.pXD.eEJ() > 0;
        }
        return true;
    }

    private void a(String str, String str2) throws a {
        this.pXC.d(this.pXD.g());
        com.ss.android.socialbase.downloader.m.d.a(this.pXD);
        this.i = false;
        this.pXD.j(str);
        this.pXC.a(this.pXD);
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
                if (TextUtils.isEmpty(this.pXD.eEO()) && !TextUtils.isEmpty(a3)) {
                    this.pXD.h(a3);
                }
                this.j = com.ss.android.socialbase.downloader.m.d.a(b2, a2);
                this.k = com.ss.android.socialbase.downloader.m.d.c(b2);
                this.pXD.i(this.j);
                String an = this.pXD.an();
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
                    if (!TextUtils.isEmpty(this.pXD.h())) {
                        str2 = "";
                    } else {
                        str2 = com.ss.android.socialbase.downloader.m.d.a(eVar, this.pXD.j());
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
                        if (this.pXD.eBR() > 0 && com.ss.android.socialbase.downloader.k.a.RA(this.pXD.g()).b("force_check_file_length") == 1 && this.pXD.eBR() != j2) {
                            throw new com.ss.android.socialbase.downloader.e.a(1070, "expectFileLength = " + this.pXD.eBR() + " , totalLength = " + j2);
                        }
                        this.pXJ.a(j2, str, str2);
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
        if (this.pXD != null) {
            return this.pXD.g();
        }
        return 0;
    }

    public void f() {
        this.H = System.currentTimeMillis();
        this.pXJ.a();
    }

    private void D() {
        long u = com.ss.android.socialbase.downloader.m.d.u(this.pXD);
        this.pXD.d(u);
        this.i = u > 0;
        if (!this.i) {
            this.pXC.d(this.pXD.g());
            com.ss.android.socialbase.downloader.m.d.a(this.pXD);
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public boolean a(long j) throws com.ss.android.socialbase.downloader.e.a {
        if (this.G > 0 && this.pXD.eEJ() > this.G) {
            A();
        }
        return this.pXJ.a(j);
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
            return ((this.e != null && this.e.get() > 0) || this.pXD.aZ() || (aVar != null && ((aVar.a() == 1011 || (aVar.getCause() != null && (aVar.getCause() instanceof SSLHandshakeException))) && this.pXD.ba()))) && !(aVar instanceof com.ss.android.socialbase.downloader.e.g);
        } else if (!this.h || this.d) {
            return true;
        } else {
            com.ss.android.socialbase.downloader.m.d.a(this.pXD);
            this.d = true;
            return true;
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void b(com.ss.android.socialbase.downloader.e.a aVar) {
        com.ss.android.socialbase.downloader.f.a.b(f13210a, "onError:" + aVar.getMessage());
        this.pXB = j.RUN_STATUS_ERROR;
        this.pXL = aVar;
        F();
    }

    private void E() {
        try {
            this.pXC.d(this.pXD.g());
            com.ss.android.socialbase.downloader.m.d.a(this.pXD);
            this.i = false;
            this.pXD.j("");
            this.pXC.a(this.pXD);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void e(com.ss.android.socialbase.downloader.e.a aVar) {
        if (this.pXD != null) {
            this.pXD.m(true);
        }
        a(aVar, false);
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        com.ss.android.socialbase.downloader.f.a.b(f13210a, "onAllChunkRetryWithReset");
        this.pXB = j.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.pXL = aVar;
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
            com.ss.android.socialbase.downloader.f.a.c(f13210a, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.pXD.a(list, this.pXB == j.RUN_STATUS_WAITING_ASYNC_HANDLER);
            com.ss.android.socialbase.downloader.impls.a eDY = com.ss.android.socialbase.downloader.downloader.b.eDY();
            if (eDY != null) {
                eDY.Ra(this.pXD.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.ss.android.socialbase.downloader.impls.a eDY;
        if (!s() && (eDY = com.ss.android.socialbase.downloader.downloader.b.eDY()) != null) {
            eDY.Ra(this.pXD.g());
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public com.ss.android.socialbase.downloader.e.h a(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.e.a aVar, long j) {
        if (r()) {
            return com.ss.android.socialbase.downloader.e.h.RETURN;
        }
        if (aVar != null && (aVar.a() == 1047 || com.ss.android.socialbase.downloader.m.d.J(aVar))) {
            return a(aVar, j);
        }
        this.pXL = aVar;
        this.pXD.e(-j);
        this.pXC.a(this.pXD);
        if (f(aVar)) {
            return com.ss.android.socialbase.downloader.e.h.RETURN;
        }
        this.pXJ.a(bVar, aVar, this.pXB == j.RUN_STATUS_RETRY_DELAY);
        if (this.pXB != j.RUN_STATUS_RETRY_DELAY && this.pXD.eEQ()) {
            long elP = elP();
            if (elP > 0) {
                com.ss.android.socialbase.downloader.f.a.c(f13210a, "onSingleChunkRetry with delay time " + elP);
                try {
                    Thread.sleep(elP);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.f.a.d(f13210a, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.e.h.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public com.ss.android.socialbase.downloader.e.h a(com.ss.android.socialbase.downloader.e.a aVar, long j) {
        long j2;
        long efR;
        boolean z;
        this.pXL = aVar;
        this.pXD.e(-j);
        this.pXC.a(this.pXD);
        if (r()) {
            return com.ss.android.socialbase.downloader.e.h.RETURN;
        }
        if (aVar != null && aVar.a() == 1047) {
            if (this.pXO == null || this.pXD.efZ()) {
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
                boolean a2 = this.pXO.a(uVar);
                this.pXD.eES();
                if (a2) {
                    if (!uVar.a()) {
                        F();
                        this.pXJ.h();
                        this.pXB = j.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    }
                    z = true;
                }
            }
            z = false;
        } else if (com.ss.android.socialbase.downloader.m.d.J(aVar)) {
            if (this.pXP == null) {
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
                efR = ((com.ss.android.socialbase.downloader.e.e) aVar).d();
            } else {
                j2 = -1;
                efR = this.pXD.efR();
            }
            synchronized (this) {
                if (this.pXP.a(j2, efR, aeVar)) {
                    if (!com.ss.android.socialbase.downloader.k.a.RA(this.pXD.g()).b("not_delete_when_clean_space", false)) {
                        v();
                    }
                    if (!atomicBoolean.get()) {
                        if (this.pXB != j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                            this.pXB = j.RUN_STATUS_WAITING_ASYNC_HANDLER;
                            F();
                            this.pXJ.h();
                        }
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    } else if (f(aVar)) {
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    } else {
                        z = true;
                    }
                } else if (this.pXB == j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
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
        this.pXJ.a(aVar, this.pXB == j.RUN_STATUS_RETRY_DELAY);
        return this.pXB == j.RUN_STATUS_RETRY_DELAY ? com.ss.android.socialbase.downloader.e.h.RETURN : com.ss.android.socialbase.downloader.e.h.CONTINUE;
    }

    private boolean f(com.ss.android.socialbase.downloader.e.a aVar) {
        boolean z = true;
        if (this.e != null) {
            if (this.e.get() <= 0 || (aVar != null && aVar.a() == 1070)) {
                if (this.pXD.aY()) {
                    this.e.set(this.pXD.K());
                    this.pXD.h(this.e.get());
                    z = false;
                } else if (aVar != null && ((aVar.a() == 1011 || (aVar.getCause() != null && (aVar.getCause() instanceof SSLHandshakeException))) && this.pXD.ba())) {
                    this.e.set(this.pXD.J());
                    this.pXD.h(this.e.get());
                    this.pXD.k(true);
                    z = false;
                } else {
                    b(new com.ss.android.socialbase.downloader.e.a(aVar.a(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.e), String.valueOf(this.pXD.J()), aVar.b())));
                    return true;
                }
            }
            if (this.pXB != j.RUN_STATUS_RETRY_DELAY && z) {
                this.pXD.h(this.e.decrementAndGet());
            }
            return false;
        }
        b(new com.ss.android.socialbase.downloader.e.a(1043, "retry for exception, but retain retry time is null, last error is :" + aVar.b()));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public synchronized com.ss.android.socialbase.downloader.g.b RC(int i) {
        com.ss.android.socialbase.downloader.g.b bVar;
        if (this.pXD.eFv() >= 2) {
            List<com.ss.android.socialbase.downloader.g.b> c = this.pXC.c(this.pXD.g());
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
                this.pXD.f(b2);
                this.pXD.g(com.ss.android.socialbase.downloader.m.b.a(b2));
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z) {
                this.pXD.f(-1);
                this.pXD.g("");
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
            long BT = bVar.BT(true);
            com.ss.android.socialbase.downloader.f.a.b(f13210a, "reuseChunk retainLen:" + BT + " chunkIndex:" + i);
            boolean z = false;
            if (!bVar.f() && BT > com.ss.android.socialbase.downloader.b.e.d && this.pXD.p()) {
                List<com.ss.android.socialbase.downloader.g.b> D = bVar.D(this.pXD.eFv(), this.pXD.efR());
                if (D != null) {
                    for (com.ss.android.socialbase.downloader.g.b bVar3 : D) {
                        this.pXC.b(bVar3);
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
                        com.ss.android.socialbase.downloader.f.a.b(f13210a, "check can checkUnCompletedChunk -- chunkIndex:" + bVar2.s() + " currentOffset:" + bVar2.n() + "  startOffset:" + bVar2.l() + " contentLen:" + bVar2.q());
                        if (bVar2.s() < 0) {
                            break;
                        } else if (!bVar2.i() && !bVar2.c()) {
                            break;
                        }
                    }
                    i2++;
                }
                if (bVar2 != null) {
                    com.ss.android.socialbase.downloader.f.a.b(f13210a, "unComplete chunk " + bVar.s() + " curOffset:" + bVar.n() + " reuseChunk chunkIndex:" + i + " for subChunk:" + bVar2.s());
                    this.pXC.a(bVar2.k(), bVar2.s(), bVar2.b(), i);
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
        if (this.pXB == j.RUN_STATUS_RETRY_DELAY || this.pXK == null || !this.pXD.eEQ() || elP() <= 0) {
            return false;
        }
        this.pXB = j.RUN_STATUS_RETRY_DELAY;
        return true;
    }

    private s e(com.ss.android.socialbase.downloader.g.d dVar) {
        s eFN = dVar.eFN();
        if (eFN == null) {
            com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
            if (a2 != null) {
                String eER = a2.eER();
                if (!TextUtils.isEmpty(eER)) {
                    return new q(eER);
                }
            }
            return com.ss.android.socialbase.downloader.downloader.b.eEc();
        }
        return eFN;
    }

    public Future eGi() {
        return this.f13211b;
    }

    public void a(Future future) {
        this.f13211b = future;
    }

    public void b(long j) {
        if (this.pXM != null && (this.pXM instanceof com.ss.android.socialbase.downloader.i.a)) {
            try {
                ((com.ss.android.socialbase.downloader.i.a) this.pXM).a(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
