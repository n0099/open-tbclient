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
    private static final String f13509a = c.class.getSimpleName();
    private String F;
    private long G;
    private long H;

    /* renamed from: b  reason: collision with root package name */
    private Future f13510b;
    private AtomicInteger e;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private final AtomicBoolean m;
    private s qaA;
    private final com.ss.android.socialbase.downloader.downloader.e qaB;
    private AlarmManager qaC;
    private volatile com.ss.android.socialbase.downloader.e.a qaD;
    private g qaE;
    private com.ss.android.socialbase.downloader.i.e qaF;
    private al qaG;
    private af qaH;
    private final com.ss.android.socialbase.downloader.k.a qaI;
    private final com.ss.android.socialbase.downloader.g.d qar;
    private volatile com.ss.android.socialbase.downloader.downloader.d qas;
    private final k qau;
    private com.ss.android.socialbase.downloader.g.c qav;
    private i qaw;
    private final i qax;
    private h qay;
    private final h qaz;
    private volatile boolean d = false;
    private final ArrayList<b> f = new ArrayList<>();
    private volatile j qat = j.RUN_STATUS_NONE;
    private volatile int C = 5;
    private boolean D = false;
    private boolean E = false;

    public c(com.ss.android.socialbase.downloader.g.d dVar, Handler handler) {
        this.qar = dVar;
        if (dVar != null) {
            this.qav = dVar.a();
            this.qaw = dVar.eIY();
            this.qay = dVar.eJf();
            this.qaG = dVar.eJa();
            this.qaH = dVar.eJb();
            this.qaA = e(dVar);
            this.qaI = com.ss.android.socialbase.downloader.k.a.SR(this.qav.g());
        } else {
            this.qaI = com.ss.android.socialbase.downloader.k.a.eJs();
        }
        h();
        this.qau = com.ss.android.socialbase.downloader.downloader.b.eHf();
        this.qax = com.ss.android.socialbase.downloader.downloader.b.eHl();
        this.qaz = com.ss.android.socialbase.downloader.downloader.b.eHn();
        this.qaB = new com.ss.android.socialbase.downloader.downloader.e(dVar, handler);
        this.qaC = com.ss.android.socialbase.downloader.downloader.b.eGV();
        this.m = new AtomicBoolean(true);
    }

    private void h() {
        if (this.qav != null) {
            int eHP = this.qav.eHP() - this.qav.ax();
            if (eHP < 0) {
                eHP = 0;
            }
            if (this.e == null) {
                this.e = new AtomicInteger(eHP);
            } else {
                this.e.set(eHP);
            }
        }
    }

    public void a() {
        this.qat = j.RUN_STATUS_PAUSE;
        if (this.qas != null) {
            this.qas.b();
        } else {
            p();
            this.qat = j.RUN_STATUS_PAUSE;
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
        this.qat = j.RUN_STATUS_CANCELED;
        if (this.qas != null) {
            this.qas.c();
        } else {
            p();
            this.qat = j.RUN_STATUS_CANCELED;
            m();
        }
        F();
    }

    public com.ss.android.socialbase.downloader.g.d eJt() {
        return this.qar;
    }

    private int c(long j, List<com.ss.android.socialbase.downloader.g.b> list) {
        int i;
        int a2;
        if (z()) {
            if (this.i) {
                if (list != null) {
                    i = list.size();
                } else {
                    i = this.qav.eIH();
                }
            } else {
                if (this.qaw != null) {
                    a2 = this.qaw.a(j);
                } else {
                    a2 = this.qax.a(j);
                }
                com.ss.android.socialbase.downloader.i.k eJk = com.ss.android.socialbase.downloader.i.j.eJj().eJk();
                com.ss.android.socialbase.downloader.f.a.b(f13509a, String.format("NetworkQuality is : %s", eJk.name()));
                this.qav.f(eJk.name());
                if (this.qay != null) {
                    i = this.qay.a(a2, eJk);
                } else {
                    i = this.qaz.a(a2, eJk);
                }
            }
            if (i <= 0) {
                i = 1;
            }
        } else {
            i = 1;
        }
        if (com.ss.android.socialbase.downloader.f.a.a()) {
            com.ss.android.socialbase.downloader.f.a.b(f13509a, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(i), this.qav.h(), String.valueOf(j)));
        }
        return i;
    }

    private boolean i() {
        int q = this.qav.q();
        if (q == 1 || this.qav.eIl()) {
            return true;
        }
        if (q != -2 && q != -4) {
            b(new com.ss.android.socialbase.downloader.e.a(1000, "The download Task can't start, because its status is not prepare:" + q));
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [302=4] */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r8.qaI.a("fix_file_exist_update_download_info") != false) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j() throws com.ss.android.socialbase.downloader.e.b {
        boolean z;
        boolean z2 = true;
        try {
            try {
                int g = this.qav.g();
                if (this.qau != null) {
                    if (com.ss.android.socialbase.downloader.m.a.a(2048)) {
                        this.qau.d();
                    }
                    com.ss.android.socialbase.downloader.g.c b2 = this.qau.b(g);
                    if (b2 == null || b2.bk()) {
                        this.qav.eIz();
                        z = true;
                    } else {
                        String k = this.qav.k();
                        String F = this.qav.F();
                        this.qav.a(b2, true);
                        z = com.ss.android.socialbase.downloader.m.a.a(4096) && b2 != this.qav;
                        try {
                            if (k.equals(b2.k()) && com.ss.android.socialbase.downloader.m.d.a(b2, false, F)) {
                                try {
                                    throw new com.ss.android.socialbase.downloader.e.b(b2.h());
                                } catch (com.ss.android.socialbase.downloader.e.b e) {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    if (this.qar != null && this.qav != null) {
                                        com.ss.android.socialbase.downloader.h.a.a(this.qar.eIX(), this.qav, new com.ss.android.socialbase.downloader.e.a(1003, com.ss.android.socialbase.downloader.m.d.c(th, "checkTaskCache")), this.qav.q());
                                    }
                                    if (z) {
                                        if (z2) {
                                            try {
                                                if (!this.qaI.a("fix_file_exist_update_download_info")) {
                                                    return;
                                                }
                                            } catch (SQLiteException e2) {
                                                e2.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.qau.a(this.qav);
                                        return;
                                    }
                                    return;
                                }
                            } else if (com.ss.android.socialbase.downloader.downloader.b.r(b2) != g) {
                                try {
                                    this.qau.f(g);
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
                                this.qau.a(this.qav);
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
                        this.qau.a(this.qav);
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
        com.ss.android.socialbase.downloader.downloader.b.a(this.qar, 3);
        k();
        com.ss.android.socialbase.downloader.downloader.b.b(this.qar, 3);
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
            if (this.qav != null && this.H > 0) {
                this.qav.c(System.currentTimeMillis() - this.H);
            }
        } catch (Throwable th) {
        }
        try {
            an eIV = this.qar.eIV();
            if (eIV != null) {
                if (eIV.a()) {
                    this.qaB.e();
                    return;
                }
            }
        } finally {
            if (i()) {
            }
        }
        if (i()) {
            com.ss.android.socialbase.downloader.h.a.a(this.qar.eIX(), this.qav, new com.ss.android.socialbase.downloader.e.a(1003, "task status is invalid"), this.qav != null ? this.qav.q() : 0);
            return;
        }
        while (true) {
            l();
            if (this.D) {
                if (this.C > 0) {
                    this.C--;
                } else if (this.qav.eHV() != this.qav.ejK()) {
                    com.ss.android.socialbase.downloader.f.a.b(f13509a, this.qav.d());
                    this.qaB.a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.qav.eHW()));
                    return;
                } else if (this.qav.eHV() <= 0) {
                    com.ss.android.socialbase.downloader.f.a.b(f13509a, this.qav.d());
                    this.qaB.a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, "curBytes is 0, bytes invalid retry status is : " + this.qav.eHW()));
                    return;
                } else if (this.qav.ejK() <= 0) {
                    com.ss.android.socialbase.downloader.f.a.b(f13509a, this.qav.d());
                    this.qaB.a(new com.ss.android.socialbase.downloader.e.g(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.qav.eHW()));
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
            this.qat = j.RUN_STATUS_NONE;
            this.qav.Q();
            this.qav.ac();
            long currentTimeMillis = System.currentTimeMillis();
            this.qav.a(-1L);
            boolean z = false;
            try {
                j();
            } catch (com.ss.android.socialbase.downloader.e.b e) {
                com.ss.android.socialbase.downloader.f.a.b(f13509a, "file exist " + e.c());
                this.F = e.c();
                z = true;
            }
            if (!this.D) {
                this.qaB.b();
            }
            this.D = false;
            if (s()) {
                return;
            }
            if (!TextUtils.isEmpty(this.F) && z) {
                if (com.ss.android.socialbase.downloader.k.a.eJs().b("fix_end_for_file_exist_error", true)) {
                    if (this.F.equals(this.qav.h())) {
                        this.qat = j.RUN_STATUS_END_RIGHT_NOW;
                    } else {
                        this.qat = j.RUN_STATUS_END_FOR_FILE_EXIST;
                    }
                } else if (this.F.equals(this.qav.n())) {
                    this.qat = j.RUN_STATUS_END_RIGHT_NOW;
                } else {
                    this.qat = j.RUN_STATUS_END_FOR_FILE_EXIST;
                }
                return;
            }
            com.ss.android.socialbase.downloader.i.b.eJi().b();
            while (!s()) {
                try {
                    try {
                        C();
                        y();
                        B();
                        c = this.qau.c(this.qav.g());
                        D();
                        O = this.qav.O();
                    } catch (com.ss.android.socialbase.downloader.e.a e2) {
                        com.ss.android.socialbase.downloader.f.a.d(f13509a, "downloadInner: baseException = " + e2);
                        if (this.qat != j.RUN_STATUS_PAUSE) {
                            if (e2.a() == 1025 || e2.a() == 1009) {
                                this.qat = j.RUN_STATUS_END_RIGHT_NOW;
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
                    com.ss.android.socialbase.downloader.f.a.d(f13509a, "downloadInner: retry throwable for " + e3.a());
                    if (this.qat != j.RUN_STATUS_PAUSE) {
                        if (this.e != null && this.e.get() > 0) {
                            this.qav.h(this.e.decrementAndGet());
                            this.qav.c(5);
                            p();
                        } else if (this.e == null) {
                            b(new com.ss.android.socialbase.downloader.e.a(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e3.a()));
                        } else if (this.qav.aY()) {
                            this.qav.c(5);
                            this.e.set(this.qav.eHP());
                            this.qav.h(this.e.get());
                            p();
                        } else {
                            b(new com.ss.android.socialbase.downloader.e.a(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.qav.eHP()), e3.a())));
                        }
                    }
                    p();
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.f.a.d(f13509a, "downloadInner: throwable =  " + th);
                    if (this.qat != j.RUN_STATUS_PAUSE) {
                        b(new com.ss.android.socialbase.downloader.e.a(1045, th));
                    }
                    p();
                }
                if (s()) {
                    p();
                    return;
                }
                long t = this.i ? com.ss.android.socialbase.downloader.m.d.t(this.qav) : 0L;
                com.ss.android.socialbase.downloader.g.b jn = jn(t);
                List<com.ss.android.socialbase.downloader.g.e> e4 = e(jn);
                com.ss.android.socialbase.downloader.m.d.a(e4, this.qav);
                this.qav.n(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    b(O, e4, t);
                    this.qav.b(System.currentTimeMillis() - currentTimeMillis2);
                    if (s()) {
                        p();
                        return;
                    }
                    long ejK = this.qav.ejK();
                    a(ejK, this.qav.l(), this.qav.m());
                    int c2 = c(ejK, c);
                    if (s()) {
                        p();
                        return;
                    } else if (c2 <= 0) {
                        throw new com.ss.android.socialbase.downloader.e.a((int) DebugConstants.HTTP_ERRCODE_NOT_FIND, "chunkCount is 0");
                    } else {
                        this.h = c2 == 1;
                        if (this.h) {
                            if (this.qaE == null) {
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
                                this.qav.a(System.currentTimeMillis() - currentTimeMillis);
                                a(jn, O, this.qaE);
                            }
                        } else {
                            if (!this.qav.ad()) {
                                o();
                            }
                            if (s()) {
                                p();
                                return;
                            }
                            this.qav.a(System.currentTimeMillis() - currentTimeMillis);
                            if (this.i) {
                                a(c2, c);
                            } else {
                                a(ejK, c2);
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
        if (this.qaF != null) {
            try {
                a(this.qaF, j);
            } catch (Throwable th) {
                this.E = true;
            }
        }
        if (this.qaF == null || this.E) {
            a(str, list);
            a(this.qaE, j);
        }
    }

    private void m() {
        boolean z;
        boolean z2;
        boolean z3 = (this.qat == j.RUN_STATUS_PAUSE || this.qat == j.RUN_STATUS_CANCELED) ? false : true;
        try {
            z2 = t();
            z = false;
        } catch (Exception e) {
            if (e instanceof com.ss.android.socialbase.downloader.e.a) {
                this.qaB.a((com.ss.android.socialbase.downloader.e.a) e);
            } else {
                this.qaB.a(new com.ss.android.socialbase.downloader.e.a(1046, e));
            }
            z = true;
            z2 = true;
        }
        if (z2 || z) {
            this.m.set(false);
            if (z3) {
                try {
                    com.ss.android.socialbase.downloader.impls.a eHk = com.ss.android.socialbase.downloader.downloader.b.eHk();
                    if (eHk != null) {
                        eHk.a(this);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.h.a.a(this.qar.eIX(), this.qav, new com.ss.android.socialbase.downloader.e.a(1014, com.ss.android.socialbase.downloader.m.d.c(th, "removeDownloadRunnable")), this.qav != null ? this.qav.q() : 0);
                    return;
                }
            }
            return;
        }
        this.D = true;
        com.ss.android.socialbase.downloader.f.a.b(f13509a, "jump to restart");
    }

    private void c(String str, List<com.ss.android.socialbase.downloader.g.e> list, long j) throws com.ss.android.socialbase.downloader.e.a, a {
        com.ss.android.socialbase.downloader.i.a.c w;
        if (this.qav.eIH() == 1 && (w = com.ss.android.socialbase.downloader.i.a.a.eJh().w(str, list)) != null) {
            this.qaF = w;
            this.qav.n(1);
        }
        if (this.qaF == null && !this.E && this.qav.af()) {
            try {
                this.qaF = com.ss.android.socialbase.downloader.downloader.b.a(str, list, this.qaI.b("net_lib_strategy"), this.qaI.b("monitor_download_connect") > 0, this.qav);
            } catch (Throwable th) {
                this.qav.a(com.ss.android.socialbase.downloader.m.d.L(th));
            }
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.g.e> list) throws com.ss.android.socialbase.downloader.e.a, a {
        if (this.qaE == null) {
            com.ss.android.socialbase.downloader.i.a.d dVar = null;
            if (this.qav.eIH() == 1) {
                dVar = com.ss.android.socialbase.downloader.i.a.a.eJh().x(str, list);
            }
            try {
                if (dVar != null) {
                    a(this.qaE);
                    this.qav.n(2);
                    this.qaE = dVar;
                } else {
                    try {
                        this.qaE = com.ss.android.socialbase.downloader.downloader.b.a(this.qav.o(), this.qav.I(), str, list, this.qaI.b("net_lib_strategy"), this.qaI.b("monitor_download_connect") > 0, this.qav);
                        a(this.qaE);
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
                        a(this.qaE);
                    }
                }
                if (this.qaE == null) {
                    throw new com.ss.android.socialbase.downloader.e.a(1022, new IOException("download can't continue, firstConnection is null"));
                }
            } catch (Throwable th2) {
                a(this.qaE);
                throw th2;
            }
        }
    }

    private void n() {
        if (this.qaF != null) {
            this.qaF.c();
            this.qaF = null;
        }
    }

    private void o() {
        if (this.qaE != null) {
            this.qaE.d();
            this.qaE = null;
        }
    }

    private void p() {
        n();
        o();
    }

    private com.ss.android.socialbase.downloader.g.b jn(long j) {
        return new b.a(this.qav.g()).Sx(-1).jc(0L).jg(j).jd(j).je(0L).jf(this.qav.ejK() - j).eHI();
    }

    private List<com.ss.android.socialbase.downloader.g.e> e(com.ss.android.socialbase.downloader.g.b bVar) {
        return com.ss.android.socialbase.downloader.m.d.a(this.qav.eHO(), this.qav.an(), bVar);
    }

    private void q() throws com.ss.android.socialbase.downloader.e.a {
        if (this.qas != null) {
            if (this.qat == j.RUN_STATUS_CANCELED) {
                this.qav.c(-4);
                this.qas.c();
            } else if (this.qat == j.RUN_STATUS_PAUSE) {
                this.qav.c(-2);
                this.qas.b();
            } else {
                this.qas.d();
            }
        }
    }

    private boolean r() {
        return this.qat == j.RUN_STATUS_CANCELED || this.qat == j.RUN_STATUS_PAUSE;
    }

    private boolean s() {
        if (r() || this.qav.q() == -2) {
            if (!r()) {
                if (this.qav.q() == -2) {
                    this.qat = j.RUN_STATUS_PAUSE;
                } else if (this.qav.q() == -4) {
                    this.qat = j.RUN_STATUS_CANCELED;
                }
            }
            return true;
        }
        return false;
    }

    private boolean t() {
        com.ss.android.socialbase.downloader.i.b.eJi().c();
        if (this.qat == j.RUN_STATUS_ERROR) {
            this.qaB.a(this.qaD);
            return true;
        } else if (this.qat == j.RUN_STATUS_CANCELED) {
            this.qaB.c();
            return true;
        } else if (this.qat == j.RUN_STATUS_PAUSE) {
            this.qaB.d();
            return true;
        } else if (this.qat == j.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.qaB.g();
                return true;
            } catch (com.ss.android.socialbase.downloader.e.a e) {
                this.qaB.a(e);
                return true;
            }
        } else if (this.qat == j.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.qaB.a(this.F);
                return true;
            } catch (com.ss.android.socialbase.downloader.e.a e2) {
                this.qaB.a(e2);
                return true;
            }
        } else if (this.qat == j.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.qaB.a(this.qaD, false);
            return false;
        } else if (this.qat != j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            if (this.qat == j.RUN_STATUS_RETRY_DELAY && !u()) {
                com.ss.android.socialbase.downloader.f.a.b(f13509a, "doTaskStatusHandle retryDelay");
                w();
                return this.qat == j.RUN_STATUS_RETRY_DELAY;
            }
            try {
                if (v()) {
                    this.qaB.f();
                    r.eJo().d();
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
        if (this.qav.eIH() <= 1) {
            return this.qav.eHV() > 0 && this.qav.eHV() == this.qav.ejK();
        }
        List<com.ss.android.socialbase.downloader.g.b> c = this.qau.c(this.qav.g());
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
        if (this.qav.eIv()) {
            this.qav.f(this.qav.eHV());
        }
        if (this.qav.eHV() <= 0 || (!this.qav.ag() && (this.qav.ejK() <= 0 || this.qav.eHV() != this.qav.ejK()))) {
            this.qav.a(com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_RESTART);
            this.qav.eIz();
            this.qau.a(this.qav);
            this.qau.d(this.qav.g());
            com.ss.android.socialbase.downloader.m.d.a(this.qav);
            return false;
        }
        return true;
    }

    private void w() {
        boolean z;
        long epK = epK();
        try {
            Intent intent = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
            intent.putExtra("extra_download_id", this.qav.g());
            intent.setClass(com.ss.android.socialbase.downloader.downloader.b.eHp(), DownloadHandleService.class);
            if (Build.VERSION.SDK_INT >= 19) {
                this.qaC.setExact(2, SystemClock.elapsedRealtime() + epK, PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eHp(), this.qav.g(), intent, 1073741824));
            } else {
                this.qaC.set(2, SystemClock.elapsedRealtime() + epK, PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eHp(), this.qav.g(), intent, 1073741824));
            }
        } catch (Throwable th) {
            try {
                if (th instanceof NoSuchMethodError) {
                    try {
                        Intent intent2 = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
                        intent2.setClass(com.ss.android.socialbase.downloader.downloader.b.eHp(), DownloadHandleService.class);
                        intent2.putExtra("extra_download_id", this.qav.g());
                        this.qaC.set(2, epK + SystemClock.elapsedRealtime(), PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eHp(), this.qav.g(), intent2, 1073741824));
                        z = true;
                    } catch (Throwable th2) {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    this.qat = j.RUN_STATUS_NONE;
                }
            } finally {
                this.qat = j.RUN_STATUS_RETRY_DELAY;
                this.qav.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_WAITING);
                this.qau.a(this.qav);
            }
        }
    }

    private long epK() {
        return this.qaA.a(this.qav.M(), this.qav.eHQ());
    }

    private void y() throws a, com.ss.android.socialbase.downloader.e.a {
        com.ss.android.socialbase.downloader.impls.a eHk;
        int g = this.qav.g();
        int r = com.ss.android.socialbase.downloader.downloader.b.r(this.qav);
        if (this.qav.aX()) {
            throw new com.ss.android.socialbase.downloader.e.a(1009, "file has downloaded");
        }
        com.ss.android.socialbase.downloader.g.c b2 = this.qau.b(r);
        if (b2 != null && (eHk = com.ss.android.socialbase.downloader.downloader.b.eHk()) != null && b2.g() != g && b2.a(this.qav)) {
            if (eHk.a(b2.g())) {
                this.qau.f(g);
                throw new com.ss.android.socialbase.downloader.e.a(1025, "another same task is downloading");
            }
            List<com.ss.android.socialbase.downloader.g.b> c = this.qau.c(r);
            com.ss.android.socialbase.downloader.m.d.a(this.qav);
            this.qau.f(r);
            if (b2 != null && b2.eID()) {
                this.qav.a(b2, false);
                this.qau.a(this.qav);
                if (c != null) {
                    for (com.ss.android.socialbase.downloader.g.b bVar : c) {
                        bVar.b(g);
                        this.qau.a(bVar);
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
        a(list, this.qav.ejK());
    }

    private void a(long j, int i) throws com.ss.android.socialbase.downloader.e.a {
        long j2;
        long j3 = 0;
        long j4 = j / i;
        int g = this.qav.g();
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
                com.ss.android.socialbase.downloader.g.b eHI = new b.a(g).Sx(i3).jc(j3).jg(j3).jd(j3).je(j2).eHI();
                arrayList.add(eHI);
                this.qau.a(eHI);
                j3 += j4;
                i2 = i3 + 1;
            } else {
                this.qav.d(i);
                this.qau.a(g, i);
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
                    if (this.qav.ad() && this.qaE != null && (!this.qav.af() || this.E)) {
                        if (bVar.s() == 0) {
                            this.f.add(new b(bVar, this.qar, this.qaE, this));
                        } else if (bVar.s() > 0) {
                            this.f.add(new b(bVar, this.qar, this));
                        }
                    } else {
                        this.f.add(new b(bVar, this.qar, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.m.a.a(64)) {
            ArrayList arrayList = new ArrayList(this.f.size());
            Iterator<b> it = this.f.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (this.qat == j.RUN_STATUS_CANCELED) {
                    next.b();
                } else if (this.qat == j.RUN_STATUS_PAUSE) {
                    next.a();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> hc = com.ss.android.socialbase.downloader.impls.e.hc(arrayList);
                for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = com.ss.android.socialbase.downloader.impls.e.hd(hc)) {
                    if (!s()) {
                        runnable.run();
                    } else {
                        return;
                    }
                }
                if (hc != null && !hc.isEmpty()) {
                    for (Future future : hc) {
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
            if (this.qat == j.RUN_STATUS_CANCELED) {
                next2.b();
            } else if (this.qat == j.RUN_STATUS_PAUSE) {
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
        bVar.a(this.qav.ejK() - bVar.n());
        this.qav.d(1);
        this.qau.a(this.qav.g(), 1);
        this.qas = new com.ss.android.socialbase.downloader.downloader.d(this.qav, str, gVar, bVar, this);
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends Throwable {

        /* renamed from: b  reason: collision with root package name */
        private String f13514b;

        public a(String str) {
            super(str);
            this.f13514b = str;
        }

        public String a() {
            return this.f13514b;
        }
    }

    private boolean z() {
        if (this.qav == null || ((this.i && this.qav.eIH() <= 1) || this.qav.eIi())) {
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
                com.ss.android.socialbase.downloader.k.a SR = com.ss.android.socialbase.downloader.k.a.SR(this.qav.g());
                if (SR.a("space_fill_part_download", 0) == 1) {
                    this.G = 0L;
                    long ejK = j4 <= 0 ? this.qav.ejK() - this.qav.eHV() : j4;
                    if (c < ejK) {
                        com.ss.android.socialbase.downloader.f.a.d(f13509a, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.m.d.a(j) + "MB, downloaded = " + com.ss.android.socialbase.downloader.m.d.a(length) + "MB, required = " + com.ss.android.socialbase.downloader.m.d.a(ejK) + "MB, available = " + com.ss.android.socialbase.downloader.m.d.a(c) + "MB");
                        if (c > 0) {
                            int a2 = SR.a("space_fill_min_keep_mb", 100);
                            if (a2 > 0) {
                                j2 = c - (a2 * 1048576);
                                com.ss.android.socialbase.downloader.f.a.d(f13509a, "checkSpaceOverflow: minKeep = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.m.d.a(j2) + "MB");
                                if (j2 <= 0) {
                                    throw new com.ss.android.socialbase.downloader.e.e(c, ejK);
                                }
                                this.G = this.qav.eHV() + j2;
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
                        } else if (SR.a("download_when_space_negative", 0) != 1) {
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
            j = com.ss.android.socialbase.downloader.m.d.c(this.qav.l());
        } catch (com.ss.android.socialbase.downloader.e.a e) {
            j = 0;
        }
        com.ss.android.socialbase.downloader.f.a.c(f13509a, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.m.d.a(j) + "MB");
        if (j > 0) {
            long ejK = this.qav.ejK() - this.qav.eHV();
            if (j < ejK && (a2 = com.ss.android.socialbase.downloader.k.a.SR(this.qav.g()).a("space_fill_min_keep_mb", 100)) > 0) {
                long j2 = j - (a2 * 1048576);
                com.ss.android.socialbase.downloader.f.a.c(f13509a, "checkSpaceOverflowInProgress: minKeep  = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.m.d.a(j2) + "MB");
                if (j2 <= 0) {
                    this.G = 0L;
                    throw new com.ss.android.socialbase.downloader.e.e(j, ejK);
                } else {
                    this.G = this.qav.eHV() + j2 + 1048576;
                    return;
                }
            }
        }
        this.G = 0L;
    }

    private void B() throws com.ss.android.socialbase.downloader.e.g {
        if (this.qav.x() && !com.ss.android.socialbase.downloader.m.d.a(com.ss.android.socialbase.downloader.downloader.b.eHp(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.ss.android.socialbase.downloader.e.g(1019, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.qav.eIs()) {
            throw new com.ss.android.socialbase.downloader.e.d();
        }
        if (!this.qav.eIt()) {
            throw new com.ss.android.socialbase.downloader.e.f();
        }
    }

    private void C() throws com.ss.android.socialbase.downloader.e.a {
        if (TextUtils.isEmpty(this.qav.k())) {
            throw new com.ss.android.socialbase.downloader.e.a((int) ARPMessageType.MSG_TYPE_VIDEO_STOP_RES, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.qav.h())) {
            throw new com.ss.android.socialbase.downloader.e.a((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_FAILED, "download name can not be empty");
        }
        File file = new File(this.qav.k());
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
            return (i == 201 || i == 416) && this.qav.eHV() > 0;
        }
        return true;
    }

    private void a(String str, String str2) throws a {
        this.qau.d(this.qav.g());
        com.ss.android.socialbase.downloader.m.d.a(this.qav);
        this.i = false;
        this.qav.j(str);
        this.qau.a(this.qav);
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
                if (TextUtils.isEmpty(this.qav.eIa()) && !TextUtils.isEmpty(a3)) {
                    this.qav.h(a3);
                }
                this.j = com.ss.android.socialbase.downloader.m.d.a(b2, a2);
                this.k = com.ss.android.socialbase.downloader.m.d.c(b2);
                this.qav.i(this.j);
                String an = this.qav.an();
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
                    if (!TextUtils.isEmpty(this.qav.h())) {
                        str2 = "";
                    } else {
                        str2 = com.ss.android.socialbase.downloader.m.d.a(eVar, this.qav.j());
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
                        if (this.qav.eFe() > 0 && com.ss.android.socialbase.downloader.k.a.SR(this.qav.g()).b("force_check_file_length") == 1 && this.qav.eFe() != j2) {
                            throw new com.ss.android.socialbase.downloader.e.a(1070, "expectFileLength = " + this.qav.eFe() + " , totalLength = " + j2);
                        }
                        this.qaB.a(j2, str, str2);
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
        if (this.qav != null) {
            return this.qav.g();
        }
        return 0;
    }

    public void f() {
        this.H = System.currentTimeMillis();
        this.qaB.a();
    }

    private void D() {
        long u = com.ss.android.socialbase.downloader.m.d.u(this.qav);
        this.qav.d(u);
        this.i = u > 0;
        if (!this.i) {
            this.qau.d(this.qav.g());
            com.ss.android.socialbase.downloader.m.d.a(this.qav);
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public boolean a(long j) throws com.ss.android.socialbase.downloader.e.a {
        if (this.G > 0 && this.qav.eHV() > this.G) {
            A();
        }
        return this.qaB.a(j);
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
            return ((this.e != null && this.e.get() > 0) || this.qav.aZ() || (aVar != null && ((aVar.a() == 1011 || (aVar.getCause() != null && (aVar.getCause() instanceof SSLHandshakeException))) && this.qav.ba()))) && !(aVar instanceof com.ss.android.socialbase.downloader.e.g);
        } else if (!this.h || this.d) {
            return true;
        } else {
            com.ss.android.socialbase.downloader.m.d.a(this.qav);
            this.d = true;
            return true;
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void b(com.ss.android.socialbase.downloader.e.a aVar) {
        com.ss.android.socialbase.downloader.f.a.b(f13509a, "onError:" + aVar.getMessage());
        this.qat = j.RUN_STATUS_ERROR;
        this.qaD = aVar;
        F();
    }

    private void E() {
        try {
            this.qau.d(this.qav.g());
            com.ss.android.socialbase.downloader.m.d.a(this.qav);
            this.i = false;
            this.qav.j("");
            this.qau.a(this.qav);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void e(com.ss.android.socialbase.downloader.e.a aVar) {
        if (this.qav != null) {
            this.qav.m(true);
        }
        a(aVar, false);
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        com.ss.android.socialbase.downloader.f.a.b(f13509a, "onAllChunkRetryWithReset");
        this.qat = j.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.qaD = aVar;
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
            com.ss.android.socialbase.downloader.f.a.c(f13509a, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.qav.a(list, this.qat == j.RUN_STATUS_WAITING_ASYNC_HANDLER);
            com.ss.android.socialbase.downloader.impls.a eHk = com.ss.android.socialbase.downloader.downloader.b.eHk();
            if (eHk != null) {
                eHk.Sr(this.qav.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.ss.android.socialbase.downloader.impls.a eHk;
        if (!s() && (eHk = com.ss.android.socialbase.downloader.downloader.b.eHk()) != null) {
            eHk.Sr(this.qav.g());
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
        this.qaD = aVar;
        this.qav.e(-j);
        this.qau.a(this.qav);
        if (f(aVar)) {
            return com.ss.android.socialbase.downloader.e.h.RETURN;
        }
        this.qaB.a(bVar, aVar, this.qat == j.RUN_STATUS_RETRY_DELAY);
        if (this.qat != j.RUN_STATUS_RETRY_DELAY && this.qav.eIc()) {
            long epK = epK();
            if (epK > 0) {
                com.ss.android.socialbase.downloader.f.a.c(f13509a, "onSingleChunkRetry with delay time " + epK);
                try {
                    Thread.sleep(epK);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.f.a.d(f13509a, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.e.h.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public com.ss.android.socialbase.downloader.e.h a(com.ss.android.socialbase.downloader.e.a aVar, long j) {
        long j2;
        long ejK;
        boolean z;
        this.qaD = aVar;
        this.qav.e(-j);
        this.qau.a(this.qav);
        if (r()) {
            return com.ss.android.socialbase.downloader.e.h.RETURN;
        }
        if (aVar != null && aVar.a() == 1047) {
            if (this.qaG == null || this.qav.ejS()) {
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
                boolean a2 = this.qaG.a(uVar);
                this.qav.eIe();
                if (a2) {
                    if (!uVar.a()) {
                        F();
                        this.qaB.h();
                        this.qat = j.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    }
                    z = true;
                }
            }
            z = false;
        } else if (com.ss.android.socialbase.downloader.m.d.J(aVar)) {
            if (this.qaH == null) {
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
                ejK = ((com.ss.android.socialbase.downloader.e.e) aVar).d();
            } else {
                j2 = -1;
                ejK = this.qav.ejK();
            }
            synchronized (this) {
                if (this.qaH.a(j2, ejK, aeVar)) {
                    if (!com.ss.android.socialbase.downloader.k.a.SR(this.qav.g()).b("not_delete_when_clean_space", false)) {
                        v();
                    }
                    if (!atomicBoolean.get()) {
                        if (this.qat != j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                            this.qat = j.RUN_STATUS_WAITING_ASYNC_HANDLER;
                            F();
                            this.qaB.h();
                        }
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    } else if (f(aVar)) {
                        return com.ss.android.socialbase.downloader.e.h.RETURN;
                    } else {
                        z = true;
                    }
                } else if (this.qat == j.RUN_STATUS_WAITING_ASYNC_HANDLER) {
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
        this.qaB.a(aVar, this.qat == j.RUN_STATUS_RETRY_DELAY);
        return this.qat == j.RUN_STATUS_RETRY_DELAY ? com.ss.android.socialbase.downloader.e.h.RETURN : com.ss.android.socialbase.downloader.e.h.CONTINUE;
    }

    private boolean f(com.ss.android.socialbase.downloader.e.a aVar) {
        boolean z = true;
        if (this.e != null) {
            if (this.e.get() <= 0 || (aVar != null && aVar.a() == 1070)) {
                if (this.qav.aY()) {
                    this.e.set(this.qav.K());
                    this.qav.h(this.e.get());
                    z = false;
                } else if (aVar != null && ((aVar.a() == 1011 || (aVar.getCause() != null && (aVar.getCause() instanceof SSLHandshakeException))) && this.qav.ba())) {
                    this.e.set(this.qav.eHP());
                    this.qav.h(this.e.get());
                    this.qav.k(true);
                    z = false;
                } else {
                    b(new com.ss.android.socialbase.downloader.e.a(aVar.a(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.e), String.valueOf(this.qav.eHP()), aVar.b())));
                    return true;
                }
            }
            if (this.qat != j.RUN_STATUS_RETRY_DELAY && z) {
                this.qav.h(this.e.decrementAndGet());
            }
            return false;
        }
        b(new com.ss.android.socialbase.downloader.e.a(1043, "retry for exception, but retain retry time is null, last error is :" + aVar.b()));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.l.e
    public synchronized com.ss.android.socialbase.downloader.g.b ST(int i) {
        com.ss.android.socialbase.downloader.g.b bVar;
        if (this.qav.eIH() >= 2) {
            List<com.ss.android.socialbase.downloader.g.b> c = this.qau.c(this.qav.g());
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
                this.qav.f(b2);
                this.qav.g(com.ss.android.socialbase.downloader.m.b.a(b2));
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z) {
                this.qav.f(-1);
                this.qav.g("");
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
            long BX = bVar.BX(true);
            com.ss.android.socialbase.downloader.f.a.b(f13509a, "reuseChunk retainLen:" + BX + " chunkIndex:" + i);
            boolean z = false;
            if (!bVar.f() && BX > com.ss.android.socialbase.downloader.b.e.d && this.qav.p()) {
                List<com.ss.android.socialbase.downloader.g.b> D = bVar.D(this.qav.eIH(), this.qav.ejK());
                if (D != null) {
                    for (com.ss.android.socialbase.downloader.g.b bVar3 : D) {
                        this.qau.b(bVar3);
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
                        com.ss.android.socialbase.downloader.f.a.b(f13509a, "check can checkUnCompletedChunk -- chunkIndex:" + bVar2.s() + " currentOffset:" + bVar2.n() + "  startOffset:" + bVar2.l() + " contentLen:" + bVar2.q());
                        if (bVar2.s() < 0) {
                            break;
                        } else if (!bVar2.i() && !bVar2.c()) {
                            break;
                        }
                    }
                    i2++;
                }
                if (bVar2 != null) {
                    com.ss.android.socialbase.downloader.f.a.b(f13509a, "unComplete chunk " + bVar.s() + " curOffset:" + bVar.n() + " reuseChunk chunkIndex:" + i + " for subChunk:" + bVar2.s());
                    this.qau.a(bVar2.k(), bVar2.s(), bVar2.b(), i);
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
        if (this.qat == j.RUN_STATUS_RETRY_DELAY || this.qaC == null || !this.qav.eIc() || epK() <= 0) {
            return false;
        }
        this.qat = j.RUN_STATUS_RETRY_DELAY;
        return true;
    }

    private s e(com.ss.android.socialbase.downloader.g.d dVar) {
        s eIZ = dVar.eIZ();
        if (eIZ == null) {
            com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
            if (a2 != null) {
                String eId = a2.eId();
                if (!TextUtils.isEmpty(eId)) {
                    return new q(eId);
                }
            }
            return com.ss.android.socialbase.downloader.downloader.b.eHo();
        }
        return eIZ;
    }

    public Future eJu() {
        return this.f13510b;
    }

    public void a(Future future) {
        this.f13510b = future;
    }

    public void b(long j) {
        if (this.qaE != null && (this.qaE instanceof com.ss.android.socialbase.downloader.i.a)) {
            try {
                ((com.ss.android.socialbase.downloader.i.a) this.qaE).a(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
