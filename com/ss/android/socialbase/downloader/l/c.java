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
    private static final String f7868a = c.class.getSimpleName();
    private String F;
    private long G;
    private long H;
    private Future b;
    private AtomicInteger e;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private final AtomicBoolean m;
    private final com.ss.android.socialbase.downloader.g.d qiT;
    private volatile com.ss.android.socialbase.downloader.downloader.d qiU;
    private final k qiW;
    private com.ss.android.socialbase.downloader.g.c qiX;
    private i qiY;
    private final i qiZ;
    private h qja;
    private final h qjb;
    private s qjc;
    private final com.ss.android.socialbase.downloader.downloader.e qjd;
    private AlarmManager qje;
    private volatile com.ss.android.socialbase.downloader.e.a qjf;
    private g qjg;
    private com.ss.android.socialbase.downloader.i.e qjh;
    private al qji;
    private af qjj;
    private final com.ss.android.socialbase.downloader.k.a qjk;
    private volatile boolean d = false;
    private final ArrayList<b> f = new ArrayList<>();
    private volatile j qiV = j.RUN_STATUS_NONE;
    private volatile int C = 5;
    private boolean D = false;
    private boolean E = false;

    public c(com.ss.android.socialbase.downloader.g.d dVar, Handler handler) {
        this.qiT = dVar;
        if (dVar != null) {
            this.qiX = dVar.a();
            this.qiY = dVar.eIn();
            this.qja = dVar.eIu();
            this.qji = dVar.eIp();
            this.qjj = dVar.eIq();
            this.qjc = e(dVar);
            this.qjk = com.ss.android.socialbase.downloader.k.a.Sa(this.qiX.g());
        } else {
            this.qjk = com.ss.android.socialbase.downloader.k.a.eIH();
        }
        h();
        this.qiW = com.ss.android.socialbase.downloader.downloader.b.eGw();
        this.qiZ = com.ss.android.socialbase.downloader.downloader.b.eGC();
        this.qjb = com.ss.android.socialbase.downloader.downloader.b.eGE();
        this.qjd = new com.ss.android.socialbase.downloader.downloader.e(dVar, handler);
        this.qje = com.ss.android.socialbase.downloader.downloader.b.eGm();
        this.m = new AtomicBoolean(true);
    }

    private void h() {
        if (this.qiX != null) {
            int J = this.qiX.J() - this.qiX.ax();
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
        this.qiV = j.RUN_STATUS_PAUSE;
        if (this.qiU != null) {
            this.qiU.b();
        } else {
            p();
            this.qiV = j.RUN_STATUS_PAUSE;
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
        this.qiV = j.RUN_STATUS_CANCELED;
        if (this.qiU != null) {
            this.qiU.c();
        } else {
            p();
            this.qiV = j.RUN_STATUS_CANCELED;
            m();
        }
        F();
    }

    public com.ss.android.socialbase.downloader.g.d eII() {
        return this.qiT;
    }

    private int c(long j, List<com.ss.android.socialbase.downloader.g.b> list) {
        int i;
        int a2;
        if (z()) {
            if (this.i) {
                if (list != null) {
                    i = list.size();
                } else {
                    i = this.qiX.eHW();
                }
            } else {
                if (this.qiY != null) {
                    a2 = this.qiY.a(j);
                } else {
                    a2 = this.qiZ.a(j);
                }
                com.ss.android.socialbase.downloader.i.k eIz = com.ss.android.socialbase.downloader.i.j.eIy().eIz();
                com.ss.android.socialbase.downloader.f.a.b(f7868a, String.format("NetworkQuality is : %s", eIz.name()));
                this.qiX.f(eIz.name());
                if (this.qja != null) {
                    i = this.qja.a(a2, eIz);
                } else {
                    i = this.qjb.a(a2, eIz);
                }
            }
            if (i <= 0) {
                i = 1;
            }
        } else {
            i = 1;
        }
        if (com.ss.android.socialbase.downloader.f.a.a()) {
            com.ss.android.socialbase.downloader.f.a.b(f7868a, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(i), this.qiX.h(), String.valueOf(j)));
        }
        return i;
    }

    private boolean i() {
        int q = this.qiX.q();
        if (q == 1 || this.qiX.eHA()) {
            return true;
        }
        if (q != -2 && q != -4) {
            b(new com.ss.android.socialbase.downloader.e.a(1000, "The download Task can't start, because its status is not prepare:" + q));
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [302=4] */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r8.qjk.a("fix_file_exist_update_download_info") != false) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j() throws com.ss.android.socialbase.downloader.e.b {
        boolean z;
        boolean z2 = true;
        try {
            try {
                int g = this.qiX.g();
                if (this.qiW != null) {
                    if (com.ss.android.socialbase.downloader.m.a.a(2048)) {
                        this.qiW.d();
                    }
                    com.ss.android.socialbase.downloader.g.c b = this.qiW.b(g);
                    if (b == null || b.bk()) {
                        this.qiX.eHO();
                        z = true;
                    } else {
                        String k = this.qiX.k();
                        String F = this.qiX.F();
                        this.qiX.a(b, true);
                        z = com.ss.android.socialbase.downloader.m.a.a(4096) && b != this.qiX;
                        try {
                            if (k.equals(b.k()) && com.ss.android.socialbase.downloader.m.d.a(b, false, F)) {
                                try {
                                    throw new com.ss.android.socialbase.downloader.e.b(b.h());
                                } catch (com.ss.android.socialbase.downloader.e.b e) {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    if (this.qiT != null && this.qiX != null) {
                                        com.ss.android.socialbase.downloader.h.a.a(this.qiT.eIm(), this.qiX, new com.ss.android.socialbase.downloader.e.a(1003, com.ss.android.socialbase.downloader.m.d.c(th, "checkTaskCache")), this.qiX.q());
                                    }
                                    if (z) {
                                        if (z2) {
                                            try {
                                                if (!this.qjk.a("fix_file_exist_update_download_info")) {
                                                    return;
                                                }
                                            } catch (SQLiteException e2) {
                                                e2.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.qiW.a(this.qiX);
                                        return;
                                    }
                                    return;
                                }
                            } else if (com.ss.android.socialbase.downloader.downloader.b.r(b) != g) {
                                try {
                                    this.qiW.f(g);
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
                                this.qiW.a(this.qiX);
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
                        this.qiW.a(this.qiX);
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
        com.ss.android.socialbase.downloader.downloader.b.a(this.qiT, 3);
        k();
        com.ss.android.socialbase.downloader.downloader.b.b(this.qiT, 3);
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
            if (this.qiX != null && this.H > 0) {
                this.qiX.c(System.currentTimeMillis() - this.H);
            }
        } catch (Throwable th) {
        }
        try {
            an eIk = this.qiT.eIk();
            if (eIk != null) {
                if (eIk.a()) {
                    this.qjd.e();
                    return;
                }
            }
        } finally {
            if (i()) {
            }
        }
        if (i()) {
            com.ss.android.socialbase.downloader.h.a.a(this.qiT.eIm(), this.qiX, new com.ss.android.socialbase.downloader.e.a(1003, "task status is invalid"), this.qiX != null ? this.qiX.q() : 0);
            return;
        }
        while (true) {
            l();
            if (this.D) {
                if (this.C > 0) {
                    this.C--;
                } else if (this.qiX.eHm() != this.qiX.am()) {
                    com.ss.android.socialbase.downloader.f.a.b(f7868a, this.qiX.d());
                    this.qjd.a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.qiX.eHn()));
                    return;
                } else if (this.qiX.eHm() <= 0) {
                    com.ss.android.socialbase.downloader.f.a.b(f7868a, this.qiX.d());
                    this.qjd.a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, "curBytes is 0, bytes invalid retry status is : " + this.qiX.eHn()));
                    return;
                } else if (this.qiX.am() <= 0) {
                    com.ss.android.socialbase.downloader.f.a.b(f7868a, this.qiX.d());
                    this.qjd.a(new com.ss.android.socialbase.downloader.e.g(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.qiX.eHn()));
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
            this.qiV = j.RUN_STATUS_NONE;
            this.qiX.Q();
            this.qiX.ac();
            long currentTimeMillis = System.currentTimeMillis();
            this.qiX.a(-1L);
            boolean z = false;
            try {
                j();
            } catch (com.ss.android.socialbase.downloader.e.b e) {
                com.ss.android.socialbase.downloader.f.a.b(f7868a, "file exist " + e.c());
                this.F = e.c();
                z = true;
            }
            if (!this.D) {
                this.qjd.b();
            }
            this.D = false;
            if (s()) {
                return;
            }
            if (!TextUtils.isEmpty(this.F) && z) {
                if (com.ss.android.socialbase.downloader.k.a.eIH().b("fix_end_for_file_exist_error", true)) {
                    if (this.F.equals(this.qiX.h())) {
                        this.qiV = j.RUN_STATUS_END_RIGHT_NOW;
                    } else {
                        this.qiV = j.RUN_STATUS_END_FOR_FILE_EXIST;
                    }
                } else if (this.F.equals(this.qiX.n())) {
                    this.qiV = j.RUN_STATUS_END_RIGHT_NOW;
                } else {
                    this.qiV = j.RUN_STATUS_END_FOR_FILE_EXIST;
                }
                return;
            }
            com.ss.android.socialbase.downloader.i.b.eIx().b();
            while (!s()) {
                try {
                    try {
                        C();
                        y();
                        B();
                        c = this.qiW.c(this.qiX.g());
                        D();
                        O = this.qiX.O();
                    } catch (com.ss.android.socialbase.downloader.e.a e2) {
                        com.ss.android.socialbase.downloader.f.a.d(f7868a, "downloadInner: baseException = " + e2);
                        if (this.qiV != j.RUN_STATUS_PAUSE) {
                            if (e2.a() == 1025 || e2.a() == 1009) {
                                this.qiV = j.RUN_STATUS_END_RIGHT_NOW;
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
                    com.ss.android.socialbase.downloader.f.a.d(f7868a, "downloadInner: retry throwable for " + e3.a());
                    if (this.qiV != j.RUN_STATUS_PAUSE) {
                        if (this.e != null && this.e.get() > 0) {
                            this.qiX.h(this.e.decrementAndGet());
                            this.qiX.c(5);
                            p();
                        } else if (this.e == null) {
                            b(new com.ss.android.socialbase.downloader.e.a(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e3.a()));
                        } else if (this.qiX.aY()) {
                            this.qiX.c(5);
                            this.e.set(this.qiX.J());
                            this.qiX.h(this.e.get());
                            p();
                        } else {
                            b(new com.ss.android.socialbase.downloader.e.a(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.qiX.J()), e3.a())));
                        }
                    }
                    p();
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.f.a.d(f7868a, "downloadInner: throwable =  " + th);
                    if (this.qiV != j.RUN_STATUS_PAUSE) {
                        b(new com.ss.android.socialbase.downloader.e.a(1045, th));
                    }
                    p();
                }
                if (s()) {
                    p();
                    return;
                }
                long t = this.i ? com.ss.android.socialbase.downloader.m.d.t(this.qiX) : 0L;
                com.ss.android.socialbase.downloader.g.b jt = jt(t);
                List<com.ss.android.socialbase.downloader.g.e> e4 = e(jt);
                com.ss.android.socialbase.downloader.m.d.a(e4, this.qiX);
                this.qiX.n(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    b(O, e4, t);
                    this.qiX.b(System.currentTimeMillis() - currentTimeMillis2);
                    if (s()) {
                        p();
                        return;
                    }
                    long am = this.qiX.am();
                    a(am, this.qiX.l(), this.qiX.m());
                    int c2 = c(am, c);
                    if (s()) {
                        p();
                        return;
                    } else if (c2 <= 0) {
                        throw new com.ss.android.socialbase.downloader.e.a((int) DebugConstants.HTTP_ERRCODE_NOT_FIND, "chunkCount is 0");
                    } else {
                        this.h = c2 == 1;
                        if (this.h) {
                            if (this.qjg == null) {
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
                                this.qiX.a(System.currentTimeMillis() - currentTimeMillis);
                                a(jt, O, this.qjg);
                            }
                        } else {
                            if (!this.qiX.ad()) {
                                o();
                            }
                            if (s()) {
                                p();
                                return;
                            }
                            this.qiX.a(System.currentTimeMillis() - currentTimeMillis);
                            if (this.i) {
                                a(c2, c);
                            } else {
                                a(am, c2);
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
        if (this.qjh != null) {
            try {
                a(this.qjh, j);
            } catch (Throwable th) {
                this.E = true;
            }
        }
        if (this.qjh == null || this.E) {
            a(str, list);
            a(this.qjg, j);
        }
    }

    private void m() {
        boolean z;
        boolean z2;
        boolean z3 = (this.qiV == j.RUN_STATUS_PAUSE || this.qiV == j.RUN_STATUS_CANCELED) ? false : true;
        try {
            z2 = t();
            z = false;
        } catch (Exception e) {
            if (e instanceof com.ss.android.socialbase.downloader.e.a) {
                this.qjd.a((com.ss.android.socialbase.downloader.e.a) e);
            } else {
                this.qjd.a(new com.ss.android.socialbase.downloader.e.a(1046, e));
            }
            z = true;
            z2 = true;
        }
        if (z2 || z) {
            this.m.set(false);
            if (z3) {
                try {
                    com.ss.android.socialbase.downloader.impls.a eGB = com.ss.android.socialbase.downloader.downloader.b.eGB();
                    if (eGB != null) {
                        eGB.a(this);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.h.a.a(this.qiT.eIm(), this.qiX, new com.ss.android.socialbase.downloader.e.a(1014, com.ss.android.socialbase.downloader.m.d.c(th, "removeDownloadRunnable")), this.qiX != null ? this.qiX.q() : 0);
                    return;
                }
            }
            return;
        }
        this.D = true;
        com.ss.android.socialbase.downloader.f.a.b(f7868a, "jump to restart");
    }

    private void c(String str, List<com.ss.android.socialbase.downloader.g.e> list, long j) throws com.ss.android.socialbase.downloader.e.a, a {
        com.ss.android.socialbase.downloader.i.a.c w;
        if (this.qiX.eHW() == 1 && (w = com.ss.android.socialbase.downloader.i.a.a.eIw().w(str, list)) != null) {
            this.qjh = w;
            this.qiX.n(1);
        }
        if (this.qjh == null && !this.E && this.qiX.af()) {
            try {
                this.qjh = com.ss.android.socialbase.downloader.downloader.b.a(str, list, this.qjk.b("net_lib_strategy"), this.qjk.b("monitor_download_connect") > 0, this.qiX);
            } catch (Throwable th) {
                this.qiX.a(com.ss.android.socialbase.downloader.m.d.K(th));
            }
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.g.e> list) throws com.ss.android.socialbase.downloader.e.a, a {
        if (this.qjg == null) {
            com.ss.android.socialbase.downloader.i.a.d dVar = null;
            if (this.qiX.eHW() == 1) {
                dVar = com.ss.android.socialbase.downloader.i.a.a.eIw().x(str, list);
            }
            try {
                if (dVar != null) {
                    a(this.qjg);
                    this.qiX.n(2);
                    this.qjg = dVar;
                } else {
                    try {
                        this.qjg = com.ss.android.socialbase.downloader.downloader.b.a(this.qiX.o(), this.qiX.I(), str, list, this.qjk.b("net_lib_strategy"), this.qjk.b("monitor_download_connect") > 0, this.qiX);
                        a(this.qjg);
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
                        a(this.qjg);
                    }
                }
                if (this.qjg == null) {
                    throw new com.ss.android.socialbase.downloader.e.a(1022, new IOException("download can't continue, firstConnection is null"));
                }
            } catch (Throwable th2) {
                a(this.qjg);
                throw th2;
            }
        }
    }

    private void n() {
        if (this.qjh != null) {
            this.qjh.c();
            this.qjh = null;
        }
    }

    private void o() {
        if (this.qjg != null) {
            this.qjg.d();
            this.qjg = null;
        }
    }

    private void p() {
        n();
        o();
    }

    private com.ss.android.socialbase.downloader.g.b jt(long j) {
        return new b.a(this.qiX.g()).RG(-1).ji(0L).jm(j).jj(j).jk(0L).jl(this.qiX.am() - j).eGZ();
    }

    private List<com.ss.android.socialbase.downloader.g.e> e(com.ss.android.socialbase.downloader.g.b bVar) {
        return com.ss.android.socialbase.downloader.m.d.a(this.qiX.eHf(), this.qiX.eHo(), bVar);
    }

    private void q() throws com.ss.android.socialbase.downloader.e.a {
        if (this.qiU != null) {
            if (this.qiV == j.RUN_STATUS_CANCELED) {
                this.qiX.c(-4);
                this.qiU.c();
            } else if (this.qiV == j.RUN_STATUS_PAUSE) {
                this.qiX.c(-2);
                this.qiU.b();
            } else {
                this.qiU.d();
            }
        }
    }

    private boolean r() {
        return this.qiV == j.RUN_STATUS_CANCELED || this.qiV == j.RUN_STATUS_PAUSE;
    }

    private boolean s() {
        if (r() || this.qiX.q() == -2) {
            if (!r()) {
                if (this.qiX.q() == -2) {
                    this.qiV = j.RUN_STATUS_PAUSE;
                } else if (this.qiX.q() == -4) {
                    this.qiV = j.RUN_STATUS_CANCELED;
                }
            }
            return true;
        }
        return false;
    }

    private boolean t() {
        com.ss.android.socialbase.downloader.i.b.eIx().c();
        if (this.qiV == j.RUN_STATUS_ERROR) {
            this.qjd.a(this.qjf);
            return true;
        } else if (this.qiV == j.RUN_STATUS_CANCELED) {
            this.qjd.c();
            return true;
        } else if (this.qiV == j.RUN_STATUS_PAUSE) {
            this.qjd.d();
            return true;
        } else if (this.qiV == j.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.qjd.g();
                return true;
            } catch (com.ss.android.socialbase.downloader.e.a e) {
                this.qjd.a(e);
                return true;
            }
        } else if (this.qiV == j.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.qjd.a(this.F);
                return true;
            } catch (com.ss.android.socialbase.downloader.e.a e2) {
                this.qjd.a(e2);
                return true;
            }
        } else if (this.qiV == j.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.qjd.a(this.qjf, false);
            return false;
        } else if (this.qiV != j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            if (this.qiV == j.RUN_STATUS_RETRY_DELAY && !u()) {
                com.ss.android.socialbase.downloader.f.a.b(f7868a, "doTaskStatusHandle retryDelay");
                w();
                return this.qiV == j.RUN_STATUS_RETRY_DELAY;
            }
            try {
                if (v()) {
                    this.qjd.f();
                    r.eID().d();
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
        if (this.qiX.eHW() <= 1) {
            return this.qiX.eHm() > 0 && this.qiX.eHm() == this.qiX.am();
        }
        List<com.ss.android.socialbase.downloader.g.b> c = this.qiW.c(this.qiX.g());
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
        if (this.qiX.eHK()) {
            this.qiX.f(this.qiX.eHm());
        }
        if (this.qiX.eHm() <= 0 || (!this.qiX.ag() && (this.qiX.am() <= 0 || this.qiX.eHm() != this.qiX.am()))) {
            this.qiX.a(com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_RESTART);
            this.qiX.eHO();
            this.qiW.a(this.qiX);
            this.qiW.d(this.qiX.g());
            com.ss.android.socialbase.downloader.m.d.a(this.qiX);
            return false;
        }
        return true;
    }

    private void w() {
        boolean z;
        long eoy = eoy();
        try {
            Intent intent = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
            intent.putExtra("extra_download_id", this.qiX.g());
            intent.setClass(com.ss.android.socialbase.downloader.downloader.b.eGG(), DownloadHandleService.class);
            if (Build.VERSION.SDK_INT >= 19) {
                this.qje.setExact(2, SystemClock.elapsedRealtime() + eoy, PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eGG(), this.qiX.g(), intent, 1073741824));
            } else {
                this.qje.set(2, SystemClock.elapsedRealtime() + eoy, PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eGG(), this.qiX.g(), intent, 1073741824));
            }
        } catch (Throwable th) {
            try {
                if (th instanceof NoSuchMethodError) {
                    try {
                        Intent intent2 = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
                        intent2.setClass(com.ss.android.socialbase.downloader.downloader.b.eGG(), DownloadHandleService.class);
                        intent2.putExtra("extra_download_id", this.qiX.g());
                        this.qje.set(2, eoy + SystemClock.elapsedRealtime(), PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eGG(), this.qiX.g(), intent2, 1073741824));
                        z = true;
                    } catch (Throwable th2) {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    this.qiV = j.RUN_STATUS_NONE;
                }
            } finally {
                this.qiV = j.RUN_STATUS_RETRY_DELAY;
                this.qiX.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_WAITING);
                this.qiW.a(this.qiX);
            }
        }
    }

    private long eoy() {
        return this.qjc.a(this.qiX.ur(), this.qiX.L());
    }

    private void y() throws a, com.ss.android.socialbase.downloader.e.a {
        com.ss.android.socialbase.downloader.impls.a eGB;
        int g = this.qiX.g();
        int r = com.ss.android.socialbase.downloader.downloader.b.r(this.qiX);
        if (this.qiX.aX()) {
            throw new com.ss.android.socialbase.downloader.e.a(1009, "file has downloaded");
        }
        com.ss.android.socialbase.downloader.g.c b = this.qiW.b(r);
        if (b != null && (eGB = com.ss.android.socialbase.downloader.downloader.b.eGB()) != null && b.g() != g && b.a(this.qiX)) {
            if (eGB.a(b.g())) {
                this.qiW.f(g);
                throw new com.ss.android.socialbase.downloader.e.a(1025, "another same task is downloading");
            }
            List<com.ss.android.socialbase.downloader.g.b> c = this.qiW.c(r);
            com.ss.android.socialbase.downloader.m.d.a(this.qiX);
            this.qiW.f(r);
            if (b != null && b.eHS()) {
                this.qiX.a(b, false);
                this.qiW.a(this.qiX);
                if (c != null) {
                    for (com.ss.android.socialbase.downloader.g.b bVar : c) {
                        bVar.b(g);
                        this.qiW.a(bVar);
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
        a(list, this.qiX.am());
    }

    private void a(long j, int i) throws com.ss.android.socialbase.downloader.e.a {
        long j2;
        long j3 = 0;
        long j4 = j / i;
        int g = this.qiX.g();
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
                com.ss.android.socialbase.downloader.g.b eGZ = new b.a(g).RG(i3).ji(j3).jm(j3).jj(j3).jk(j2).eGZ();
                arrayList.add(eGZ);
                this.qiW.a(eGZ);
                j3 += j4;
                i2 = i3 + 1;
            } else {
                this.qiX.d(i);
                this.qiW.a(g, i);
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
                    if (this.qiX.ad() && this.qjg != null && (!this.qiX.af() || this.E)) {
                        if (bVar.s() == 0) {
                            this.f.add(new b(bVar, this.qiT, this.qjg, this));
                        } else if (bVar.s() > 0) {
                            this.f.add(new b(bVar, this.qiT, this));
                        }
                    } else {
                        this.f.add(new b(bVar, this.qiT, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.m.a.a(64)) {
            ArrayList arrayList = new ArrayList(this.f.size());
            Iterator<b> it = this.f.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (this.qiV == j.RUN_STATUS_CANCELED) {
                    next.b();
                } else if (this.qiV == j.RUN_STATUS_PAUSE) {
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
            if (this.qiV == j.RUN_STATUS_CANCELED) {
                next2.b();
            } else if (this.qiV == j.RUN_STATUS_PAUSE) {
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
        bVar.a(this.qiX.am() - bVar.n());
        this.qiX.d(1);
        this.qiW.a(this.qiX.g(), 1);
        this.qiU = new com.ss.android.socialbase.downloader.downloader.d(this.qiX, str, gVar, bVar, this);
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends Throwable {
        private String b;

        public a(String str) {
            super(str);
            this.b = str;
        }

        public String a() {
            return this.b;
        }
    }

    private boolean z() {
        if (this.qiX == null || ((this.i && this.qiX.eHW() <= 1) || this.qiX.eHx())) {
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
                com.ss.android.socialbase.downloader.k.a Sa = com.ss.android.socialbase.downloader.k.a.Sa(this.qiX.g());
                if (Sa.a("space_fill_part_download", 0) == 1) {
                    this.G = 0L;
                    long am = j4 <= 0 ? this.qiX.am() - this.qiX.eHm() : j4;
                    if (c < am) {
                        com.ss.android.socialbase.downloader.f.a.d(f7868a, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.m.d.a(j) + "MB, downloaded = " + com.ss.android.socialbase.downloader.m.d.a(length) + "MB, required = " + com.ss.android.socialbase.downloader.m.d.a(am) + "MB, available = " + com.ss.android.socialbase.downloader.m.d.a(c) + "MB");
                        if (c > 0) {
                            int a2 = Sa.a("space_fill_min_keep_mb", 100);
                            if (a2 > 0) {
                                j2 = c - (a2 * 1048576);
                                com.ss.android.socialbase.downloader.f.a.d(f7868a, "checkSpaceOverflow: minKeep = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.m.d.a(j2) + "MB");
                                if (j2 <= 0) {
                                    throw new com.ss.android.socialbase.downloader.e.e(c, am);
                                }
                                this.G = this.qiX.eHm() + j2;
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
                        } else if (Sa.a("download_when_space_negative", 0) != 1) {
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
            j = com.ss.android.socialbase.downloader.m.d.c(this.qiX.l());
        } catch (com.ss.android.socialbase.downloader.e.a e) {
            j = 0;
        }
        com.ss.android.socialbase.downloader.f.a.c(f7868a, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.m.d.a(j) + "MB");
        if (j > 0) {
            long am = this.qiX.am() - this.qiX.eHm();
            if (j < am && (a2 = com.ss.android.socialbase.downloader.k.a.Sa(this.qiX.g()).a("space_fill_min_keep_mb", 100)) > 0) {
                long j2 = j - (a2 * 1048576);
                com.ss.android.socialbase.downloader.f.a.c(f7868a, "checkSpaceOverflowInProgress: minKeep  = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.m.d.a(j2) + "MB");
                if (j2 <= 0) {
                    this.G = 0L;
                    throw new com.ss.android.socialbase.downloader.e.e(j, am);
                } else {
                    this.G = this.qiX.eHm() + j2 + 1048576;
                    return;
                }
            }
        }
        this.G = 0L;
    }

    private void B() throws com.ss.android.socialbase.downloader.e.g {
        if (this.qiX.x() && !com.ss.android.socialbase.downloader.m.d.a(com.ss.android.socialbase.downloader.downloader.b.eGG(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.ss.android.socialbase.downloader.e.g(1019, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.qiX.eHH()) {
            throw new com.ss.android.socialbase.downloader.e.d();
        }
        if (!this.qiX.eHI()) {
            throw new com.ss.android.socialbase.downloader.e.f();
        }
    }

    private void C() throws com.ss.android.socialbase.downloader.e.a {
        if (TextUtils.isEmpty(this.qiX.k())) {
            throw new com.ss.android.socialbase.downloader.e.a((int) ARPMessageType.MSG_TYPE_VIDEO_STOP_RES, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.qiX.h())) {
            throw new com.ss.android.socialbase.downloader.e.a((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_FAILED, "download name can not be empty");
        }
        File file = new File(this.qiX.k());
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
            return (i == 201 || i == 416) && this.qiX.eHm() > 0;
        }
        return true;
    }

    private void a(String str, String str2) throws a {
        this.qiW.d(this.qiX.g());
        com.ss.android.socialbase.downloader.m.d.a(this.qiX);
        this.i = false;
        this.qiX.j(str);
        this.qiW.a(this.qiX);
        throw new a(str2);
    }

    private void a(com.ss.android.socialbase.downloader.i.e eVar, long j) throws com.ss.android.socialbase.downloader.e.a, a {
        String str;
        String str2;
        long j2;
        if (eVar != null) {
            try {
                int b = eVar.b();
                String a2 = eVar.a("Accept-Ranges");
                String a3 = eVar.a("Content-Type");
                if (TextUtils.isEmpty(this.qiX.at()) && !TextUtils.isEmpty(a3)) {
                    this.qiX.h(a3);
                }
                this.j = com.ss.android.socialbase.downloader.m.d.a(b, a2);
                this.k = com.ss.android.socialbase.downloader.m.d.c(b);
                this.qiX.i(this.j);
                String eHo = this.qiX.eHo();
                String a4 = eVar.a("Etag");
                if (!s(b, eHo, a4)) {
                    str = a4;
                } else if (eVar instanceof g) {
                    if (!TextUtils.isEmpty(eHo) && eHo.equals(a4)) {
                        a4 = "";
                    }
                    a(a4, "eTag of server file changed");
                    str = a4;
                } else {
                    throw new com.ss.android.socialbase.downloader.e.c(1002, b, "");
                }
                if (this.j || this.k) {
                    if (this.k && j > 0) {
                        if (eVar instanceof g) {
                            a("", "http head request not support");
                        } else {
                            throw new com.ss.android.socialbase.downloader.e.a(1004, "isResponseFromBegin but firstOffset > 0");
                        }
                    }
                    long b2 = com.ss.android.socialbase.downloader.m.d.b(eVar);
                    if (!TextUtils.isEmpty(this.qiX.h())) {
                        str2 = "";
                    } else {
                        str2 = com.ss.android.socialbase.downloader.m.d.a(eVar, this.qiX.j());
                    }
                    if (com.ss.android.socialbase.downloader.m.a.a(8)) {
                        this.l = com.ss.android.socialbase.downloader.m.d.d(eVar);
                    } else {
                        this.l = com.ss.android.socialbase.downloader.m.d.b(b2);
                    }
                    if (!this.l && b2 == 0 && !(eVar instanceof g)) {
                        throw new com.ss.android.socialbase.downloader.e.a(1004, "");
                    }
                    if (!this.l) {
                        String b3 = com.ss.android.socialbase.downloader.m.d.b(eVar, Headers.CONTENT_RANGE);
                        if (!TextUtils.isEmpty(b3) && com.ss.android.socialbase.downloader.m.a.a(2)) {
                            j2 = com.ss.android.socialbase.downloader.m.d.a(b3);
                        } else {
                            j2 = j + b2;
                        }
                    } else {
                        j2 = -1;
                    }
                    if (!s()) {
                        if (this.qiX.eEu() > 0 && com.ss.android.socialbase.downloader.k.a.Sa(this.qiX.g()).b("force_check_file_length") == 1 && this.qiX.eEu() != j2) {
                            throw new com.ss.android.socialbase.downloader.e.a(1070, "expectFileLength = " + this.qiX.eEu() + " , totalLength = " + j2);
                        }
                        this.qjd.a(j2, str, str2);
                    }
                } else if (b == 403) {
                    throw new com.ss.android.socialbase.downloader.e.a(1047, "response code error : 403");
                } else {
                    throw new com.ss.android.socialbase.downloader.e.c(1004, b, "response code error : " + b);
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
        if (this.qiX != null) {
            return this.qiX.g();
        }
        return 0;
    }

    public void f() {
        this.H = System.currentTimeMillis();
        this.qjd.a();
    }

    private void D() {
        long u = com.ss.android.socialbase.downloader.m.d.u(this.qiX);
        this.qiX.d(u);
        this.i = u > 0;
        if (!this.i) {
            this.qiW.d(this.qiX.g());
            com.ss.android.socialbase.downloader.m.d.a(this.qiX);
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public boolean a(long j) throws com.ss.android.socialbase.downloader.e.a {
        if (this.G > 0 && this.qiX.eHm() > this.G) {
            A();
        }
        return this.qjd.a(j);
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
            return ((this.e != null && this.e.get() > 0) || this.qiX.aZ() || (aVar != null && ((aVar.a() == 1011 || (aVar.getCause() != null && (aVar.getCause() instanceof SSLHandshakeException))) && this.qiX.ba()))) && !(aVar instanceof com.ss.android.socialbase.downloader.e.g);
        } else if (!this.h || this.d) {
            return true;
        } else {
            com.ss.android.socialbase.downloader.m.d.a(this.qiX);
            this.d = true;
            return true;
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void b(com.ss.android.socialbase.downloader.e.a aVar) {
        com.ss.android.socialbase.downloader.f.a.b(f7868a, "onError:" + aVar.getMessage());
        this.qiV = j.RUN_STATUS_ERROR;
        this.qjf = aVar;
        F();
    }

    private void E() {
        try {
            this.qiW.d(this.qiX.g());
            com.ss.android.socialbase.downloader.m.d.a(this.qiX);
            this.i = false;
            this.qiX.j("");
            this.qiW.a(this.qiX);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void e(com.ss.android.socialbase.downloader.e.a aVar) {
        if (this.qiX != null) {
            this.qiX.m(true);
        }
        a(aVar, false);
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        com.ss.android.socialbase.downloader.f.a.b(f7868a, "onAllChunkRetryWithReset");
        this.qiV = j.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.qjf = aVar;
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
            com.ss.android.socialbase.downloader.f.a.c(f7868a, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.qiX.a(list, this.qiV == j.RUN_STATUS_WAITING_ASYNC_HANDLER);
            com.ss.android.socialbase.downloader.impls.a eGB = com.ss.android.socialbase.downloader.downloader.b.eGB();
            if (eGB != null) {
                eGB.RA(this.qiX.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.ss.android.socialbase.downloader.impls.a eGB;
        if (!s() && (eGB = com.ss.android.socialbase.downloader.downloader.b.eGB()) != null) {
            eGB.RA(this.qiX.g());
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
        this.qjf = aVar;
        this.qiX.e(-j);
        this.qiW.a(this.qiX);
        if (f(aVar)) {
            return com.ss.android.socialbase.downloader.e.h.RETURN;
        }
        this.qjd.a(bVar, aVar, this.qiV == j.RUN_STATUS_RETRY_DELAY);
        if (this.qiV != j.RUN_STATUS_RETRY_DELAY && this.qiX.av()) {
            long eoy = eoy();
            if (eoy > 0) {
                com.ss.android.socialbase.downloader.f.a.c(f7868a, "onSingleChunkRetry with delay time " + eoy);
                try {
                    Thread.sleep(eoy);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.f.a.d(f7868a, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.e.h.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public com.ss.android.socialbase.downloader.e.h a(com.ss.android.socialbase.downloader.e.a aVar, long j) {
        long j2;
        long am;
        boolean z;
        this.qjf = aVar;
        this.qiX.e(-j);
        this.qiW.a(this.qiX);
        if (r()) {
            return com.ss.android.socialbase.downloader.e.h.RETURN;
        }
        if (aVar != null && aVar.a() == 1047) {
            if (this.qji == null || this.qiX.eiJ()) {
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
                boolean a2 = this.qji.a(uVar);
                this.qiX.eHv();
                if (a2) {
                    if (!uVar.a()) {
                        F();
                        this.qjd.h();
                        this.qiV = j.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    }
                    z = true;
                }
            }
            z = false;
        } else if (com.ss.android.socialbase.downloader.m.d.I(aVar)) {
            if (this.qjj == null) {
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
                am = ((com.ss.android.socialbase.downloader.e.e) aVar).d();
            } else {
                j2 = -1;
                am = this.qiX.am();
            }
            synchronized (this) {
                if (this.qjj.a(j2, am, aeVar)) {
                    if (!com.ss.android.socialbase.downloader.k.a.Sa(this.qiX.g()).b("not_delete_when_clean_space", false)) {
                        v();
                    }
                    if (!atomicBoolean.get()) {
                        if (this.qiV != j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                            this.qiV = j.RUN_STATUS_WAITING_ASYNC_HANDLER;
                            F();
                            this.qjd.h();
                        }
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    } else if (f(aVar)) {
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    } else {
                        z = true;
                    }
                } else if (this.qiV == j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
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
        this.qjd.a(aVar, this.qiV == j.RUN_STATUS_RETRY_DELAY);
        return this.qiV == j.RUN_STATUS_RETRY_DELAY ? com.ss.android.socialbase.downloader.e.h.RETURN : com.ss.android.socialbase.downloader.e.h.CONTINUE;
    }

    private boolean f(com.ss.android.socialbase.downloader.e.a aVar) {
        boolean z = true;
        if (this.e != null) {
            if (this.e.get() <= 0 || (aVar != null && aVar.a() == 1070)) {
                if (this.qiX.aY()) {
                    this.e.set(this.qiX.K());
                    this.qiX.h(this.e.get());
                    z = false;
                } else if (aVar != null && ((aVar.a() == 1011 || (aVar.getCause() != null && (aVar.getCause() instanceof SSLHandshakeException))) && this.qiX.ba())) {
                    this.e.set(this.qiX.J());
                    this.qiX.h(this.e.get());
                    this.qiX.k(true);
                    z = false;
                } else {
                    b(new com.ss.android.socialbase.downloader.e.a(aVar.a(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.e), String.valueOf(this.qiX.J()), aVar.b())));
                    return true;
                }
            }
            if (this.qiV != j.RUN_STATUS_RETRY_DELAY && z) {
                this.qiX.h(this.e.decrementAndGet());
            }
            return false;
        }
        b(new com.ss.android.socialbase.downloader.e.a(1043, "retry for exception, but retain retry time is null, last error is :" + aVar.b()));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public synchronized com.ss.android.socialbase.downloader.g.b Sc(int i) {
        com.ss.android.socialbase.downloader.g.b bVar;
        if (this.qiX.eHW() >= 2) {
            List<com.ss.android.socialbase.downloader.g.b> c = this.qiW.c(this.qiX.g());
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
                int b = eVar.b();
                this.qiX.f(b);
                this.qiX.g(com.ss.android.socialbase.downloader.m.b.a(b));
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z) {
                this.qiX.f(-1);
                this.qiX.g("");
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
            long Cl = bVar.Cl(true);
            com.ss.android.socialbase.downloader.f.a.b(f7868a, "reuseChunk retainLen:" + Cl + " chunkIndex:" + i);
            boolean z = false;
            if (!bVar.f() && Cl > com.ss.android.socialbase.downloader.b.e.d && this.qiX.p()) {
                List<com.ss.android.socialbase.downloader.g.b> F = bVar.F(this.qiX.eHW(), this.qiX.am());
                if (F != null) {
                    for (com.ss.android.socialbase.downloader.g.b bVar3 : F) {
                        this.qiW.b(bVar3);
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
                        com.ss.android.socialbase.downloader.f.a.b(f7868a, "check can checkUnCompletedChunk -- chunkIndex:" + bVar2.s() + " currentOffset:" + bVar2.n() + "  startOffset:" + bVar2.l() + " contentLen:" + bVar2.q());
                        if (bVar2.s() < 0) {
                            break;
                        } else if (!bVar2.i() && !bVar2.c()) {
                            break;
                        }
                    }
                    i2++;
                }
                if (bVar2 != null) {
                    com.ss.android.socialbase.downloader.f.a.b(f7868a, "unComplete chunk " + bVar.s() + " curOffset:" + bVar.n() + " reuseChunk chunkIndex:" + i + " for subChunk:" + bVar2.s());
                    this.qiW.a(bVar2.k(), bVar2.s(), bVar2.b(), i);
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
        if (this.qiV == j.RUN_STATUS_RETRY_DELAY || this.qje == null || !this.qiX.av() || eoy() <= 0) {
            return false;
        }
        this.qiV = j.RUN_STATUS_RETRY_DELAY;
        return true;
    }

    private s e(com.ss.android.socialbase.downloader.g.d dVar) {
        s eIo = dVar.eIo();
        if (eIo == null) {
            com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
            if (a2 != null) {
                String eHu = a2.eHu();
                if (!TextUtils.isEmpty(eHu)) {
                    return new q(eHu);
                }
            }
            return com.ss.android.socialbase.downloader.downloader.b.eGF();
        }
        return eIo;
    }

    public Future eIJ() {
        return this.b;
    }

    public void a(Future future) {
        this.b = future;
    }

    public void b(long j) {
        if (this.qjg != null && (this.qjg instanceof com.ss.android.socialbase.downloader.i.a)) {
            try {
                ((com.ss.android.socialbase.downloader.i.a) this.qjg).a(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
