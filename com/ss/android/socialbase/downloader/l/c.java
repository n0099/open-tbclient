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
    private final com.ss.android.socialbase.downloader.g.d qid;
    private volatile com.ss.android.socialbase.downloader.downloader.d qie;
    private final k qig;
    private com.ss.android.socialbase.downloader.g.c qih;
    private i qii;
    private final i qij;
    private h qik;
    private final h qil;
    private s qim;
    private final com.ss.android.socialbase.downloader.downloader.e qin;
    private AlarmManager qio;
    private volatile com.ss.android.socialbase.downloader.e.a qip;
    private g qiq;
    private com.ss.android.socialbase.downloader.i.e qir;
    private al qis;
    private af qit;
    private final com.ss.android.socialbase.downloader.k.a qiu;
    private volatile boolean d = false;
    private final ArrayList<b> f = new ArrayList<>();
    private volatile j qif = j.RUN_STATUS_NONE;
    private volatile int C = 5;
    private boolean D = false;
    private boolean E = false;

    public c(com.ss.android.socialbase.downloader.g.d dVar, Handler handler) {
        this.qid = dVar;
        if (dVar != null) {
            this.qih = dVar.a();
            this.qii = dVar.eIl();
            this.qik = dVar.eIs();
            this.qis = dVar.eIn();
            this.qit = dVar.eIo();
            this.qim = e(dVar);
            this.qiu = com.ss.android.socialbase.downloader.k.a.RW(this.qih.g());
        } else {
            this.qiu = com.ss.android.socialbase.downloader.k.a.eIF();
        }
        h();
        this.qig = com.ss.android.socialbase.downloader.downloader.b.eGs();
        this.qij = com.ss.android.socialbase.downloader.downloader.b.eGy();
        this.qil = com.ss.android.socialbase.downloader.downloader.b.eGA();
        this.qin = new com.ss.android.socialbase.downloader.downloader.e(dVar, handler);
        this.qio = com.ss.android.socialbase.downloader.downloader.b.eGi();
        this.m = new AtomicBoolean(true);
    }

    private void h() {
        if (this.qih != null) {
            int J = this.qih.J() - this.qih.ax();
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
        this.qif = j.RUN_STATUS_PAUSE;
        if (this.qie != null) {
            this.qie.b();
        } else {
            p();
            this.qif = j.RUN_STATUS_PAUSE;
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
        this.qif = j.RUN_STATUS_CANCELED;
        if (this.qie != null) {
            this.qie.c();
        } else {
            p();
            this.qif = j.RUN_STATUS_CANCELED;
            m();
        }
        F();
    }

    public com.ss.android.socialbase.downloader.g.d eIG() {
        return this.qid;
    }

    private int c(long j, List<com.ss.android.socialbase.downloader.g.b> list) {
        int i;
        int a2;
        if (z()) {
            if (this.i) {
                if (list != null) {
                    i = list.size();
                } else {
                    i = this.qih.eHU();
                }
            } else {
                if (this.qii != null) {
                    a2 = this.qii.a(j);
                } else {
                    a2 = this.qij.a(j);
                }
                com.ss.android.socialbase.downloader.i.k eIx = com.ss.android.socialbase.downloader.i.j.eIw().eIx();
                com.ss.android.socialbase.downloader.f.a.b(f13212a, String.format("NetworkQuality is : %s", eIx.name()));
                this.qih.f(eIx.name());
                if (this.qik != null) {
                    i = this.qik.a(a2, eIx);
                } else {
                    i = this.qil.a(a2, eIx);
                }
            }
            if (i <= 0) {
                i = 1;
            }
        } else {
            i = 1;
        }
        if (com.ss.android.socialbase.downloader.f.a.a()) {
            com.ss.android.socialbase.downloader.f.a.b(f13212a, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(i), this.qih.h(), String.valueOf(j)));
        }
        return i;
    }

    private boolean i() {
        int q = this.qih.q();
        if (q == 1 || this.qih.eHy()) {
            return true;
        }
        if (q != -2 && q != -4) {
            b(new com.ss.android.socialbase.downloader.e.a(1000, "The download Task can't start, because its status is not prepare:" + q));
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [302=4] */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r8.qiu.a("fix_file_exist_update_download_info") != false) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j() throws com.ss.android.socialbase.downloader.e.b {
        boolean z;
        boolean z2 = true;
        try {
            try {
                int g = this.qih.g();
                if (this.qig != null) {
                    if (com.ss.android.socialbase.downloader.m.a.a(2048)) {
                        this.qig.d();
                    }
                    com.ss.android.socialbase.downloader.g.c b2 = this.qig.b(g);
                    if (b2 == null || b2.bk()) {
                        this.qih.eHM();
                        z = true;
                    } else {
                        String k = this.qih.k();
                        String F = this.qih.F();
                        this.qih.a(b2, true);
                        z = com.ss.android.socialbase.downloader.m.a.a(4096) && b2 != this.qih;
                        try {
                            if (k.equals(b2.k()) && com.ss.android.socialbase.downloader.m.d.a(b2, false, F)) {
                                try {
                                    throw new com.ss.android.socialbase.downloader.e.b(b2.h());
                                } catch (com.ss.android.socialbase.downloader.e.b e) {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    if (this.qid != null && this.qih != null) {
                                        com.ss.android.socialbase.downloader.h.a.a(this.qid.eIk(), this.qih, new com.ss.android.socialbase.downloader.e.a(1003, com.ss.android.socialbase.downloader.m.d.c(th, "checkTaskCache")), this.qih.q());
                                    }
                                    if (z) {
                                        if (z2) {
                                            try {
                                                if (!this.qiu.a("fix_file_exist_update_download_info")) {
                                                    return;
                                                }
                                            } catch (SQLiteException e2) {
                                                e2.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.qig.a(this.qih);
                                        return;
                                    }
                                    return;
                                }
                            } else if (com.ss.android.socialbase.downloader.downloader.b.r(b2) != g) {
                                try {
                                    this.qig.f(g);
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
                                this.qig.a(this.qih);
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
                        this.qig.a(this.qih);
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
        com.ss.android.socialbase.downloader.downloader.b.a(this.qid, 3);
        k();
        com.ss.android.socialbase.downloader.downloader.b.b(this.qid, 3);
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
            if (this.qih != null && this.H > 0) {
                this.qih.c(System.currentTimeMillis() - this.H);
            }
        } catch (Throwable th) {
        }
        try {
            an eIi = this.qid.eIi();
            if (eIi != null) {
                if (eIi.a()) {
                    this.qin.e();
                    return;
                }
            }
        } finally {
            if (i()) {
            }
        }
        if (i()) {
            com.ss.android.socialbase.downloader.h.a.a(this.qid.eIk(), this.qih, new com.ss.android.socialbase.downloader.e.a(1003, "task status is invalid"), this.qih != null ? this.qih.q() : 0);
            return;
        }
        while (true) {
            l();
            if (this.D) {
                if (this.C > 0) {
                    this.C--;
                } else if (this.qih.eHi() != this.qih.eir()) {
                    com.ss.android.socialbase.downloader.f.a.b(f13212a, this.qih.d());
                    this.qin.a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.qih.eHj()));
                    return;
                } else if (this.qih.eHi() <= 0) {
                    com.ss.android.socialbase.downloader.f.a.b(f13212a, this.qih.d());
                    this.qin.a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, "curBytes is 0, bytes invalid retry status is : " + this.qih.eHj()));
                    return;
                } else if (this.qih.eir() <= 0) {
                    com.ss.android.socialbase.downloader.f.a.b(f13212a, this.qih.d());
                    this.qin.a(new com.ss.android.socialbase.downloader.e.g(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.qih.eHj()));
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
            this.qif = j.RUN_STATUS_NONE;
            this.qih.Q();
            this.qih.eHh();
            long currentTimeMillis = System.currentTimeMillis();
            this.qih.a(-1L);
            boolean z = false;
            try {
                j();
            } catch (com.ss.android.socialbase.downloader.e.b e) {
                com.ss.android.socialbase.downloader.f.a.b(f13212a, "file exist " + e.c());
                this.F = e.c();
                z = true;
            }
            if (!this.D) {
                this.qin.b();
            }
            this.D = false;
            if (s()) {
                return;
            }
            if (!TextUtils.isEmpty(this.F) && z) {
                if (com.ss.android.socialbase.downloader.k.a.eIF().b("fix_end_for_file_exist_error", true)) {
                    if (this.F.equals(this.qih.h())) {
                        this.qif = j.RUN_STATUS_END_RIGHT_NOW;
                    } else {
                        this.qif = j.RUN_STATUS_END_FOR_FILE_EXIST;
                    }
                } else if (this.F.equals(this.qih.n())) {
                    this.qif = j.RUN_STATUS_END_RIGHT_NOW;
                } else {
                    this.qif = j.RUN_STATUS_END_FOR_FILE_EXIST;
                }
                return;
            }
            com.ss.android.socialbase.downloader.i.b.eIv().b();
            while (!s()) {
                try {
                    try {
                        C();
                        y();
                        B();
                        c = this.qig.c(this.qih.g());
                        D();
                        O = this.qih.O();
                    } catch (com.ss.android.socialbase.downloader.e.a e2) {
                        com.ss.android.socialbase.downloader.f.a.d(f13212a, "downloadInner: baseException = " + e2);
                        if (this.qif != j.RUN_STATUS_PAUSE) {
                            if (e2.a() == 1025 || e2.a() == 1009) {
                                this.qif = j.RUN_STATUS_END_RIGHT_NOW;
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
                    if (this.qif != j.RUN_STATUS_PAUSE) {
                        if (this.e != null && this.e.get() > 0) {
                            this.qih.h(this.e.decrementAndGet());
                            this.qih.c(5);
                            p();
                        } else if (this.e == null) {
                            b(new com.ss.android.socialbase.downloader.e.a(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e3.a()));
                        } else if (this.qih.aY()) {
                            this.qih.c(5);
                            this.e.set(this.qih.J());
                            this.qih.h(this.e.get());
                            p();
                        } else {
                            b(new com.ss.android.socialbase.downloader.e.a(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.qih.J()), e3.a())));
                        }
                    }
                    p();
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.f.a.d(f13212a, "downloadInner: throwable =  " + th);
                    if (this.qif != j.RUN_STATUS_PAUSE) {
                        b(new com.ss.android.socialbase.downloader.e.a(1045, th));
                    }
                    p();
                }
                if (s()) {
                    p();
                    return;
                }
                long t = this.i ? com.ss.android.socialbase.downloader.m.d.t(this.qih) : 0L;
                com.ss.android.socialbase.downloader.g.b jt = jt(t);
                List<com.ss.android.socialbase.downloader.g.e> e4 = e(jt);
                com.ss.android.socialbase.downloader.m.d.a(e4, this.qih);
                this.qih.n(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    b(O, e4, t);
                    this.qih.b(System.currentTimeMillis() - currentTimeMillis2);
                    if (s()) {
                        p();
                        return;
                    }
                    long eir = this.qih.eir();
                    a(eir, this.qih.l(), this.qih.m());
                    int c2 = c(eir, c);
                    if (s()) {
                        p();
                        return;
                    } else if (c2 <= 0) {
                        throw new com.ss.android.socialbase.downloader.e.a((int) DebugConstants.HTTP_ERRCODE_NOT_FIND, "chunkCount is 0");
                    } else {
                        this.h = c2 == 1;
                        if (this.h) {
                            if (this.qiq == null) {
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
                                this.qih.a(System.currentTimeMillis() - currentTimeMillis);
                                a(jt, O, this.qiq);
                            }
                        } else {
                            if (!this.qih.ad()) {
                                o();
                            }
                            if (s()) {
                                p();
                                return;
                            }
                            this.qih.a(System.currentTimeMillis() - currentTimeMillis);
                            if (this.i) {
                                a(c2, c);
                            } else {
                                a(eir, c2);
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
        if (this.qir != null) {
            try {
                a(this.qir, j);
            } catch (Throwable th) {
                this.E = true;
            }
        }
        if (this.qir == null || this.E) {
            a(str, list);
            a(this.qiq, j);
        }
    }

    private void m() {
        boolean z;
        boolean z2;
        boolean z3 = (this.qif == j.RUN_STATUS_PAUSE || this.qif == j.RUN_STATUS_CANCELED) ? false : true;
        try {
            z2 = t();
            z = false;
        } catch (Exception e) {
            if (e instanceof com.ss.android.socialbase.downloader.e.a) {
                this.qin.a((com.ss.android.socialbase.downloader.e.a) e);
            } else {
                this.qin.a(new com.ss.android.socialbase.downloader.e.a(1046, e));
            }
            z = true;
            z2 = true;
        }
        if (z2 || z) {
            this.m.set(false);
            if (z3) {
                try {
                    com.ss.android.socialbase.downloader.impls.a eGx = com.ss.android.socialbase.downloader.downloader.b.eGx();
                    if (eGx != null) {
                        eGx.a(this);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.h.a.a(this.qid.eIk(), this.qih, new com.ss.android.socialbase.downloader.e.a(1014, com.ss.android.socialbase.downloader.m.d.c(th, "removeDownloadRunnable")), this.qih != null ? this.qih.q() : 0);
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
        if (this.qih.eHU() == 1 && (w = com.ss.android.socialbase.downloader.i.a.a.eIu().w(str, list)) != null) {
            this.qir = w;
            this.qih.n(1);
        }
        if (this.qir == null && !this.E && this.qih.af()) {
            try {
                this.qir = com.ss.android.socialbase.downloader.downloader.b.a(str, list, this.qiu.b("net_lib_strategy"), this.qiu.b("monitor_download_connect") > 0, this.qih);
            } catch (Throwable th) {
                this.qih.a(com.ss.android.socialbase.downloader.m.d.K(th));
            }
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.g.e> list) throws com.ss.android.socialbase.downloader.e.a, a {
        if (this.qiq == null) {
            com.ss.android.socialbase.downloader.i.a.d dVar = null;
            if (this.qih.eHU() == 1) {
                dVar = com.ss.android.socialbase.downloader.i.a.a.eIu().x(str, list);
            }
            try {
                if (dVar != null) {
                    a(this.qiq);
                    this.qih.n(2);
                    this.qiq = dVar;
                } else {
                    try {
                        this.qiq = com.ss.android.socialbase.downloader.downloader.b.a(this.qih.o(), this.qih.I(), str, list, this.qiu.b("net_lib_strategy"), this.qiu.b("monitor_download_connect") > 0, this.qih);
                        a(this.qiq);
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
                        a(this.qiq);
                    }
                }
                if (this.qiq == null) {
                    throw new com.ss.android.socialbase.downloader.e.a(1022, new IOException("download can't continue, firstConnection is null"));
                }
            } catch (Throwable th2) {
                a(this.qiq);
                throw th2;
            }
        }
    }

    private void n() {
        if (this.qir != null) {
            this.qir.c();
            this.qir = null;
        }
    }

    private void o() {
        if (this.qiq != null) {
            this.qiq.d();
            this.qiq = null;
        }
    }

    private void p() {
        n();
        o();
    }

    private com.ss.android.socialbase.downloader.g.b jt(long j) {
        return new b.a(this.qih.g()).RC(-1).ji(0L).jm(j).jj(j).jk(0L).jl(this.qih.eir() - j).eGV();
    }

    private List<com.ss.android.socialbase.downloader.g.e> e(com.ss.android.socialbase.downloader.g.b bVar) {
        return com.ss.android.socialbase.downloader.m.d.a(this.qih.eHb(), this.qih.an(), bVar);
    }

    private void q() throws com.ss.android.socialbase.downloader.e.a {
        if (this.qie != null) {
            if (this.qif == j.RUN_STATUS_CANCELED) {
                this.qih.c(-4);
                this.qie.c();
            } else if (this.qif == j.RUN_STATUS_PAUSE) {
                this.qih.c(-2);
                this.qie.b();
            } else {
                this.qie.d();
            }
        }
    }

    private boolean r() {
        return this.qif == j.RUN_STATUS_CANCELED || this.qif == j.RUN_STATUS_PAUSE;
    }

    private boolean s() {
        if (r() || this.qih.q() == -2) {
            if (!r()) {
                if (this.qih.q() == -2) {
                    this.qif = j.RUN_STATUS_PAUSE;
                } else if (this.qih.q() == -4) {
                    this.qif = j.RUN_STATUS_CANCELED;
                }
            }
            return true;
        }
        return false;
    }

    private boolean t() {
        com.ss.android.socialbase.downloader.i.b.eIv().c();
        if (this.qif == j.RUN_STATUS_ERROR) {
            this.qin.a(this.qip);
            return true;
        } else if (this.qif == j.RUN_STATUS_CANCELED) {
            this.qin.c();
            return true;
        } else if (this.qif == j.RUN_STATUS_PAUSE) {
            this.qin.d();
            return true;
        } else if (this.qif == j.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.qin.g();
                return true;
            } catch (com.ss.android.socialbase.downloader.e.a e) {
                this.qin.a(e);
                return true;
            }
        } else if (this.qif == j.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.qin.a(this.F);
                return true;
            } catch (com.ss.android.socialbase.downloader.e.a e2) {
                this.qin.a(e2);
                return true;
            }
        } else if (this.qif == j.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.qin.a(this.qip, false);
            return false;
        } else if (this.qif != j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            if (this.qif == j.RUN_STATUS_RETRY_DELAY && !u()) {
                com.ss.android.socialbase.downloader.f.a.b(f13212a, "doTaskStatusHandle retryDelay");
                w();
                return this.qif == j.RUN_STATUS_RETRY_DELAY;
            }
            try {
                if (v()) {
                    this.qin.f();
                    r.eIB().d();
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
        if (this.qih.eHU() <= 1) {
            return this.qih.eHi() > 0 && this.qih.eHi() == this.qih.eir();
        }
        List<com.ss.android.socialbase.downloader.g.b> c = this.qig.c(this.qih.g());
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
        if (this.qih.eHI()) {
            this.qih.f(this.qih.eHi());
        }
        if (this.qih.eHi() <= 0 || (!this.qih.ag() && (this.qih.eir() <= 0 || this.qih.eHi() != this.qih.eir()))) {
            this.qih.a(com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_RESTART);
            this.qih.eHM();
            this.qig.a(this.qih);
            this.qig.d(this.qih.g());
            com.ss.android.socialbase.downloader.m.d.a(this.qih);
            return false;
        }
        return true;
    }

    private void w() {
        boolean z;
        long eor = eor();
        try {
            Intent intent = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
            intent.putExtra("extra_download_id", this.qih.g());
            intent.setClass(com.ss.android.socialbase.downloader.downloader.b.eGC(), DownloadHandleService.class);
            if (Build.VERSION.SDK_INT >= 19) {
                this.qio.setExact(2, SystemClock.elapsedRealtime() + eor, PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eGC(), this.qih.g(), intent, 1073741824));
            } else {
                this.qio.set(2, SystemClock.elapsedRealtime() + eor, PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eGC(), this.qih.g(), intent, 1073741824));
            }
        } catch (Throwable th) {
            try {
                if (th instanceof NoSuchMethodError) {
                    try {
                        Intent intent2 = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
                        intent2.setClass(com.ss.android.socialbase.downloader.downloader.b.eGC(), DownloadHandleService.class);
                        intent2.putExtra("extra_download_id", this.qih.g());
                        this.qio.set(2, eor + SystemClock.elapsedRealtime(), PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eGC(), this.qih.g(), intent2, 1073741824));
                        z = true;
                    } catch (Throwable th2) {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    this.qif = j.RUN_STATUS_NONE;
                }
            } finally {
                this.qif = j.RUN_STATUS_RETRY_DELAY;
                this.qih.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_WAITING);
                this.qig.a(this.qih);
            }
        }
    }

    private long eor() {
        return this.qim.a(this.qih.up(), this.qih.eHc());
    }

    private void y() throws a, com.ss.android.socialbase.downloader.e.a {
        com.ss.android.socialbase.downloader.impls.a eGx;
        int g = this.qih.g();
        int r = com.ss.android.socialbase.downloader.downloader.b.r(this.qih);
        if (this.qih.aX()) {
            throw new com.ss.android.socialbase.downloader.e.a(1009, "file has downloaded");
        }
        com.ss.android.socialbase.downloader.g.c b2 = this.qig.b(r);
        if (b2 != null && (eGx = com.ss.android.socialbase.downloader.downloader.b.eGx()) != null && b2.g() != g && b2.a(this.qih)) {
            if (eGx.a(b2.g())) {
                this.qig.f(g);
                throw new com.ss.android.socialbase.downloader.e.a(1025, "another same task is downloading");
            }
            List<com.ss.android.socialbase.downloader.g.b> c = this.qig.c(r);
            com.ss.android.socialbase.downloader.m.d.a(this.qih);
            this.qig.f(r);
            if (b2 != null && b2.eHQ()) {
                this.qih.a(b2, false);
                this.qig.a(this.qih);
                if (c != null) {
                    for (com.ss.android.socialbase.downloader.g.b bVar : c) {
                        bVar.b(g);
                        this.qig.a(bVar);
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
        a(list, this.qih.eir());
    }

    private void a(long j, int i) throws com.ss.android.socialbase.downloader.e.a {
        long j2;
        long j3 = 0;
        long j4 = j / i;
        int g = this.qih.g();
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
                com.ss.android.socialbase.downloader.g.b eGV = new b.a(g).RC(i3).ji(j3).jm(j3).jj(j3).jk(j2).eGV();
                arrayList.add(eGV);
                this.qig.a(eGV);
                j3 += j4;
                i2 = i3 + 1;
            } else {
                this.qih.d(i);
                this.qig.a(g, i);
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
                    if (this.qih.ad() && this.qiq != null && (!this.qih.af() || this.E)) {
                        if (bVar.s() == 0) {
                            this.f.add(new b(bVar, this.qid, this.qiq, this));
                        } else if (bVar.s() > 0) {
                            this.f.add(new b(bVar, this.qid, this));
                        }
                    } else {
                        this.f.add(new b(bVar, this.qid, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.m.a.a(64)) {
            ArrayList arrayList = new ArrayList(this.f.size());
            Iterator<b> it = this.f.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (this.qif == j.RUN_STATUS_CANCELED) {
                    next.b();
                } else if (this.qif == j.RUN_STATUS_PAUSE) {
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
            if (this.qif == j.RUN_STATUS_CANCELED) {
                next2.b();
            } else if (this.qif == j.RUN_STATUS_PAUSE) {
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
        bVar.a(this.qih.eir() - bVar.n());
        this.qih.d(1);
        this.qig.a(this.qih.g(), 1);
        this.qie = new com.ss.android.socialbase.downloader.downloader.d(this.qih, str, gVar, bVar, this);
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
        if (this.qih == null || ((this.i && this.qih.eHU() <= 1) || this.qih.eHv())) {
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
                com.ss.android.socialbase.downloader.k.a RW = com.ss.android.socialbase.downloader.k.a.RW(this.qih.g());
                if (RW.a("space_fill_part_download", 0) == 1) {
                    this.G = 0L;
                    long eir = j4 <= 0 ? this.qih.eir() - this.qih.eHi() : j4;
                    if (c < eir) {
                        com.ss.android.socialbase.downloader.f.a.d(f13212a, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.m.d.a(j) + "MB, downloaded = " + com.ss.android.socialbase.downloader.m.d.a(length) + "MB, required = " + com.ss.android.socialbase.downloader.m.d.a(eir) + "MB, available = " + com.ss.android.socialbase.downloader.m.d.a(c) + "MB");
                        if (c > 0) {
                            int a2 = RW.a("space_fill_min_keep_mb", 100);
                            if (a2 > 0) {
                                j2 = c - (a2 * 1048576);
                                com.ss.android.socialbase.downloader.f.a.d(f13212a, "checkSpaceOverflow: minKeep = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.m.d.a(j2) + "MB");
                                if (j2 <= 0) {
                                    throw new com.ss.android.socialbase.downloader.e.e(c, eir);
                                }
                                this.G = this.qih.eHi() + j2;
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
                        } else if (RW.a("download_when_space_negative", 0) != 1) {
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
            j = com.ss.android.socialbase.downloader.m.d.c(this.qih.l());
        } catch (com.ss.android.socialbase.downloader.e.a e) {
            j = 0;
        }
        com.ss.android.socialbase.downloader.f.a.c(f13212a, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.m.d.a(j) + "MB");
        if (j > 0) {
            long eir = this.qih.eir() - this.qih.eHi();
            if (j < eir && (a2 = com.ss.android.socialbase.downloader.k.a.RW(this.qih.g()).a("space_fill_min_keep_mb", 100)) > 0) {
                long j2 = j - (a2 * 1048576);
                com.ss.android.socialbase.downloader.f.a.c(f13212a, "checkSpaceOverflowInProgress: minKeep  = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.m.d.a(j2) + "MB");
                if (j2 <= 0) {
                    this.G = 0L;
                    throw new com.ss.android.socialbase.downloader.e.e(j, eir);
                } else {
                    this.G = this.qih.eHi() + j2 + 1048576;
                    return;
                }
            }
        }
        this.G = 0L;
    }

    private void B() throws com.ss.android.socialbase.downloader.e.g {
        if (this.qih.x() && !com.ss.android.socialbase.downloader.m.d.a(com.ss.android.socialbase.downloader.downloader.b.eGC(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.ss.android.socialbase.downloader.e.g(1019, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.qih.eHF()) {
            throw new com.ss.android.socialbase.downloader.e.d();
        }
        if (!this.qih.eHG()) {
            throw new com.ss.android.socialbase.downloader.e.f();
        }
    }

    private void C() throws com.ss.android.socialbase.downloader.e.a {
        if (TextUtils.isEmpty(this.qih.k())) {
            throw new com.ss.android.socialbase.downloader.e.a((int) ARPMessageType.MSG_TYPE_VIDEO_STOP_RES, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.qih.h())) {
            throw new com.ss.android.socialbase.downloader.e.a((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_FAILED, "download name can not be empty");
        }
        File file = new File(this.qih.k());
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
            return (i == 201 || i == 416) && this.qih.eHi() > 0;
        }
        return true;
    }

    private void a(String str, String str2) throws a {
        this.qig.d(this.qih.g());
        com.ss.android.socialbase.downloader.m.d.a(this.qih);
        this.i = false;
        this.qih.j(str);
        this.qig.a(this.qih);
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
                if (TextUtils.isEmpty(this.qih.eHn()) && !TextUtils.isEmpty(a3)) {
                    this.qih.h(a3);
                }
                this.j = com.ss.android.socialbase.downloader.m.d.a(b2, a2);
                this.k = com.ss.android.socialbase.downloader.m.d.c(b2);
                this.qih.i(this.j);
                String an = this.qih.an();
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
                    if (!TextUtils.isEmpty(this.qih.h())) {
                        str2 = "";
                    } else {
                        str2 = com.ss.android.socialbase.downloader.m.d.a(eVar, this.qih.j());
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
                        if (this.qih.eEq() > 0 && com.ss.android.socialbase.downloader.k.a.RW(this.qih.g()).b("force_check_file_length") == 1 && this.qih.eEq() != j2) {
                            throw new com.ss.android.socialbase.downloader.e.a(1070, "expectFileLength = " + this.qih.eEq() + " , totalLength = " + j2);
                        }
                        this.qin.a(j2, str, str2);
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
        if (this.qih != null) {
            return this.qih.g();
        }
        return 0;
    }

    public void f() {
        this.H = System.currentTimeMillis();
        this.qin.a();
    }

    private void D() {
        long u = com.ss.android.socialbase.downloader.m.d.u(this.qih);
        this.qih.d(u);
        this.i = u > 0;
        if (!this.i) {
            this.qig.d(this.qih.g());
            com.ss.android.socialbase.downloader.m.d.a(this.qih);
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public boolean a(long j) throws com.ss.android.socialbase.downloader.e.a {
        if (this.G > 0 && this.qih.eHi() > this.G) {
            A();
        }
        return this.qin.a(j);
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
            return ((this.e != null && this.e.get() > 0) || this.qih.aZ() || (aVar != null && ((aVar.a() == 1011 || (aVar.getCause() != null && (aVar.getCause() instanceof SSLHandshakeException))) && this.qih.ba()))) && !(aVar instanceof com.ss.android.socialbase.downloader.e.g);
        } else if (!this.h || this.d) {
            return true;
        } else {
            com.ss.android.socialbase.downloader.m.d.a(this.qih);
            this.d = true;
            return true;
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void b(com.ss.android.socialbase.downloader.e.a aVar) {
        com.ss.android.socialbase.downloader.f.a.b(f13212a, "onError:" + aVar.getMessage());
        this.qif = j.RUN_STATUS_ERROR;
        this.qip = aVar;
        F();
    }

    private void E() {
        try {
            this.qig.d(this.qih.g());
            com.ss.android.socialbase.downloader.m.d.a(this.qih);
            this.i = false;
            this.qih.j("");
            this.qig.a(this.qih);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void e(com.ss.android.socialbase.downloader.e.a aVar) {
        if (this.qih != null) {
            this.qih.m(true);
        }
        a(aVar, false);
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        com.ss.android.socialbase.downloader.f.a.b(f13212a, "onAllChunkRetryWithReset");
        this.qif = j.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.qip = aVar;
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
            this.qih.a(list, this.qif == j.RUN_STATUS_WAITING_ASYNC_HANDLER);
            com.ss.android.socialbase.downloader.impls.a eGx = com.ss.android.socialbase.downloader.downloader.b.eGx();
            if (eGx != null) {
                eGx.Rw(this.qih.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.ss.android.socialbase.downloader.impls.a eGx;
        if (!s() && (eGx = com.ss.android.socialbase.downloader.downloader.b.eGx()) != null) {
            eGx.Rw(this.qih.g());
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
        this.qip = aVar;
        this.qih.e(-j);
        this.qig.a(this.qih);
        if (f(aVar)) {
            return com.ss.android.socialbase.downloader.e.h.RETURN;
        }
        this.qin.a(bVar, aVar, this.qif == j.RUN_STATUS_RETRY_DELAY);
        if (this.qif != j.RUN_STATUS_RETRY_DELAY && this.qih.eHp()) {
            long eor = eor();
            if (eor > 0) {
                com.ss.android.socialbase.downloader.f.a.c(f13212a, "onSingleChunkRetry with delay time " + eor);
                try {
                    Thread.sleep(eor);
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
        long eir;
        boolean z;
        this.qip = aVar;
        this.qih.e(-j);
        this.qig.a(this.qih);
        if (r()) {
            return com.ss.android.socialbase.downloader.e.h.RETURN;
        }
        if (aVar != null && aVar.a() == 1047) {
            if (this.qis == null || this.qih.eiz()) {
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
                boolean a2 = this.qis.a(uVar);
                this.qih.eHr();
                if (a2) {
                    if (!uVar.a()) {
                        F();
                        this.qin.h();
                        this.qif = j.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    }
                    z = true;
                }
            }
            z = false;
        } else if (com.ss.android.socialbase.downloader.m.d.I(aVar)) {
            if (this.qit == null) {
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
                eir = ((com.ss.android.socialbase.downloader.e.e) aVar).d();
            } else {
                j2 = -1;
                eir = this.qih.eir();
            }
            synchronized (this) {
                if (this.qit.a(j2, eir, aeVar)) {
                    if (!com.ss.android.socialbase.downloader.k.a.RW(this.qih.g()).b("not_delete_when_clean_space", false)) {
                        v();
                    }
                    if (!atomicBoolean.get()) {
                        if (this.qif != j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                            this.qif = j.RUN_STATUS_WAITING_ASYNC_HANDLER;
                            F();
                            this.qin.h();
                        }
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    } else if (f(aVar)) {
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    } else {
                        z = true;
                    }
                } else if (this.qif == j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
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
        this.qin.a(aVar, this.qif == j.RUN_STATUS_RETRY_DELAY);
        return this.qif == j.RUN_STATUS_RETRY_DELAY ? com.ss.android.socialbase.downloader.e.h.RETURN : com.ss.android.socialbase.downloader.e.h.CONTINUE;
    }

    private boolean f(com.ss.android.socialbase.downloader.e.a aVar) {
        boolean z = true;
        if (this.e != null) {
            if (this.e.get() <= 0 || (aVar != null && aVar.a() == 1070)) {
                if (this.qih.aY()) {
                    this.e.set(this.qih.K());
                    this.qih.h(this.e.get());
                    z = false;
                } else if (aVar != null && ((aVar.a() == 1011 || (aVar.getCause() != null && (aVar.getCause() instanceof SSLHandshakeException))) && this.qih.ba())) {
                    this.e.set(this.qih.J());
                    this.qih.h(this.e.get());
                    this.qih.k(true);
                    z = false;
                } else {
                    b(new com.ss.android.socialbase.downloader.e.a(aVar.a(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.e), String.valueOf(this.qih.J()), aVar.b())));
                    return true;
                }
            }
            if (this.qif != j.RUN_STATUS_RETRY_DELAY && z) {
                this.qih.h(this.e.decrementAndGet());
            }
            return false;
        }
        b(new com.ss.android.socialbase.downloader.e.a(1043, "retry for exception, but retain retry time is null, last error is :" + aVar.b()));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public synchronized com.ss.android.socialbase.downloader.g.b RY(int i) {
        com.ss.android.socialbase.downloader.g.b bVar;
        if (this.qih.eHU() >= 2) {
            List<com.ss.android.socialbase.downloader.g.b> c = this.qig.c(this.qih.g());
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
                this.qih.f(b2);
                this.qih.g(com.ss.android.socialbase.downloader.m.b.a(b2));
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z) {
                this.qih.f(-1);
                this.qih.g("");
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
            if (!bVar.f() && Cn > com.ss.android.socialbase.downloader.b.e.d && this.qih.p()) {
                List<com.ss.android.socialbase.downloader.g.b> F = bVar.F(this.qih.eHU(), this.qih.eir());
                if (F != null) {
                    for (com.ss.android.socialbase.downloader.g.b bVar3 : F) {
                        this.qig.b(bVar3);
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
                    this.qig.a(bVar2.k(), bVar2.s(), bVar2.b(), i);
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
        if (this.qif == j.RUN_STATUS_RETRY_DELAY || this.qio == null || !this.qih.eHp() || eor() <= 0) {
            return false;
        }
        this.qif = j.RUN_STATUS_RETRY_DELAY;
        return true;
    }

    private s e(com.ss.android.socialbase.downloader.g.d dVar) {
        s eIm = dVar.eIm();
        if (eIm == null) {
            com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
            if (a2 != null) {
                String eHq = a2.eHq();
                if (!TextUtils.isEmpty(eHq)) {
                    return new q(eHq);
                }
            }
            return com.ss.android.socialbase.downloader.downloader.b.eGB();
        }
        return eIm;
    }

    public Future eIH() {
        return this.f13213b;
    }

    public void a(Future future) {
        this.f13213b = future;
    }

    public void b(long j) {
        if (this.qiq != null && (this.qiq instanceof com.ss.android.socialbase.downloader.i.a)) {
            try {
                ((com.ss.android.socialbase.downloader.i.a) this.qiq).a(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
