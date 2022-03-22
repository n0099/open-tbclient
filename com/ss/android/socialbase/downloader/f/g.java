package com.ss.android.socialbase.downloader.f;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f43294c;

    /* renamed from: e  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.g.a f43296e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.h.f f43297f;

    /* renamed from: g  reason: collision with root package name */
    public final c f43298g;

    /* renamed from: h  reason: collision with root package name */
    public BaseException f43299h;
    public final boolean m;
    public final long n;
    public final long o;
    public final boolean p;
    public long q;
    public final List<l> a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public final List<l> f43293b = new ArrayList();
    public volatile boolean i = false;
    public volatile boolean j = false;
    public volatile boolean k = false;
    public volatile long r = 0;
    public volatile long s = 0;

    /* renamed from: d  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.downloader.j f43295d = com.ss.android.socialbase.downloader.downloader.c.x();
    public final com.ss.android.socialbase.downloader.a.a l = com.ss.android.socialbase.downloader.a.a.a();

    public g(DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.h.f fVar, c cVar) {
        this.f43294c = downloadInfo;
        this.f43297f = fVar;
        this.f43298g = cVar;
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.f43296e = a;
        boolean z = a.a("sync_strategy", 0) == 1;
        this.m = z;
        if (z) {
            this.n = Math.max(this.f43296e.a("sync_interval_ms_fg", 5000), 500L);
            this.o = Math.max(this.f43296e.a("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.n = 0L;
            this.o = 0L;
        }
        this.p = this.f43296e.b("monitor_rw") == 1;
    }

    private boolean a(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    private void b(List<l> list) throws IOException {
        for (l lVar : list) {
            lVar.c();
        }
    }

    private void c() throws IOException {
        boolean z = this.p;
        long nanoTime = z ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.f43294c;
        com.ss.android.socialbase.downloader.downloader.j jVar = this.f43295d;
        List<l> list = this.a;
        List<l> list2 = this.f43293b;
        Map<Long, i> l = jVar.l(downloadInfo.getId());
        if (l == null) {
            l = new HashMap<>(4);
        }
        synchronized (this) {
            a(list);
            b(list);
            a(list, l);
            if (list2.size() > 0) {
                c(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (1 != 0) {
            downloadInfo.updateRealDownloadTime(true);
            jVar.a(downloadInfo.getId(), l);
            jVar.a(downloadInfo);
            this.r = downloadInfo.getCurBytes();
        }
        if (z) {
            this.q += System.nanoTime() - nanoTime;
        }
    }

    public void a(l lVar) {
        synchronized (this) {
            this.a.add(lVar);
        }
    }

    public void b() {
        this.j = true;
        this.i = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:208:0x02a2, code lost:
        r3.b(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b8, code lost:
        if (r13 <= 0) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bb, code lost:
        r3.b(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f3 A[Catch: all -> 0x03d7, TryCatch #27 {all -> 0x03d7, blocks: (B:158:0x01ef, B:160:0x01f3, B:163:0x01f9, B:165:0x01ff, B:166:0x0202, B:167:0x0218, B:204:0x029c, B:205:0x029e, B:244:0x0325, B:246:0x032f, B:248:0x0333, B:285:0x03b5, B:287:0x03bb, B:288:0x03be, B:289:0x03d6), top: B:361:0x0027, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ff A[Catch: all -> 0x03d7, TryCatch #27 {all -> 0x03d7, blocks: (B:158:0x01ef, B:160:0x01f3, B:163:0x01f9, B:165:0x01ff, B:166:0x0202, B:167:0x0218, B:204:0x029c, B:205:0x029e, B:244:0x0325, B:246:0x032f, B:248:0x0333, B:285:0x03b5, B:287:0x03bb, B:288:0x03be, B:289:0x03d6), top: B:361:0x0027, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x032f A[Catch: all -> 0x03d7, TryCatch #27 {all -> 0x03d7, blocks: (B:158:0x01ef, B:160:0x01f3, B:163:0x01f9, B:165:0x01ff, B:166:0x0202, B:167:0x0218, B:204:0x029c, B:205:0x029e, B:244:0x0325, B:246:0x032f, B:248:0x0333, B:285:0x03b5, B:287:0x03bb, B:288:0x03be, B:289:0x03d6), top: B:361:0x0027, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03bb A[Catch: all -> 0x03d7, TryCatch #27 {all -> 0x03d7, blocks: (B:158:0x01ef, B:160:0x01f3, B:163:0x01f9, B:165:0x01ff, B:166:0x0202, B:167:0x0218, B:204:0x029c, B:205:0x029e, B:244:0x0325, B:246:0x032f, B:248:0x0333, B:285:0x03b5, B:287:0x03bb, B:288:0x03be, B:289:0x03d6), top: B:361:0x0027, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0229 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x02ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0362 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0415 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x03f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0248 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x02ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar) throws BaseException {
        DownloadInfo downloadInfo;
        long curBytes;
        long nanoTime;
        boolean z;
        boolean z2;
        long j;
        long j2;
        long j3;
        long j4;
        Throwable th;
        int i;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        Throwable th5;
        Throwable th6;
        if (this.j || this.k) {
            return;
        }
        com.ss.android.socialbase.downloader.network.b.e();
        this.f43299h = null;
        downloadInfo = this.f43294c;
        com.ss.android.socialbase.downloader.h.f fVar = this.f43297f;
        c cVar = this.f43298g;
        curBytes = downloadInfo.getCurBytes();
        nanoTime = System.nanoTime();
        z = this.p;
        long j5 = 0;
        z2 = true;
        int i2 = 0;
        boolean z3 = false;
        try {
            try {
                downloadInfo.updateRealStartDownloadTime();
                long j6 = 0;
                long j7 = 0;
                long j8 = 0;
                int i3 = 0;
                while (true) {
                    if (z) {
                        try {
                            j6 = System.nanoTime();
                        } catch (p e2) {
                            e = e2;
                            i2 = i3;
                            j4 = j7;
                            try {
                                this.f43299h = e;
                                throw e;
                            } catch (Throwable th7) {
                                th = th7;
                                j2 = j5;
                                j = j4;
                                if (i2 > 0) {
                                }
                                if (!this.k) {
                                }
                                th5 = null;
                                synchronized (this) {
                                }
                            }
                        } catch (BaseException e3) {
                            e = e3;
                            j2 = j5;
                            i = i3;
                            j3 = j7;
                            if (!this.f43296e.a("ignore_base_ex_on_stop_status") && (this.j || this.k)) {
                                if (i > 0) {
                                    try {
                                        fVar.b(i);
                                    } catch (Throwable unused) {
                                    }
                                }
                                if (!this.k) {
                                    try {
                                        c();
                                    } catch (Throwable th8) {
                                        th4 = th8;
                                        com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th4);
                                        synchronized (this) {
                                            c(this.a);
                                            this.a.clear();
                                        }
                                        com.ss.android.socialbase.downloader.d.a.a(this.f43296e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.f43299h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j3, this.q, null);
                                        if (th4 != null) {
                                            if (!this.j && !this.k && this.f43299h == null) {
                                                z2 = false;
                                            }
                                            if (z2) {
                                                return;
                                            }
                                            try {
                                                com.ss.android.socialbase.downloader.i.f.a(th4, "loopAndWrite_finally");
                                                return;
                                            } catch (BaseException e4) {
                                                this.f43299h = e4;
                                                throw e4;
                                            }
                                        }
                                        return;
                                    }
                                }
                                th4 = null;
                                synchronized (this) {
                                }
                            } else {
                                if (com.ss.android.socialbase.downloader.c.a.a()) {
                                    e.printStackTrace();
                                }
                                com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                this.f43299h = e;
                                throw e;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            j2 = j5;
                            i2 = i3;
                            j = j7;
                            if (!this.j && !this.k) {
                                if (com.ss.android.socialbase.downloader.c.a.a()) {
                                    th.printStackTrace();
                                }
                                com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  e = " + th);
                                try {
                                    com.ss.android.socialbase.downloader.i.f.a(th, "loopAndWrite");
                                    if (i2 > 0) {
                                        try {
                                            fVar.b(i2);
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    if (!this.k) {
                                        try {
                                            c();
                                        } catch (Throwable th10) {
                                            th3 = th10;
                                            com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th3);
                                            synchronized (this) {
                                                c(this.a);
                                                this.a.clear();
                                            }
                                            com.ss.android.socialbase.downloader.d.a.a(this.f43296e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.f43299h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j, this.q, null);
                                            if (th3 != null) {
                                                if (!this.j && !this.k && this.f43299h == null) {
                                                    z2 = false;
                                                }
                                                if (z2) {
                                                    return;
                                                }
                                                try {
                                                    com.ss.android.socialbase.downloader.i.f.a(th3, "loopAndWrite_finally");
                                                    return;
                                                } catch (BaseException e5) {
                                                    this.f43299h = e5;
                                                    throw e5;
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    th3 = null;
                                    synchronized (this) {
                                    }
                                } catch (BaseException e6) {
                                    this.f43299h = e6;
                                    throw e6;
                                }
                            }
                            if (!this.k) {
                                try {
                                    c();
                                } catch (Throwable th11) {
                                    th2 = th11;
                                    com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th2);
                                    synchronized (this) {
                                        c(this.a);
                                        this.a.clear();
                                    }
                                    com.ss.android.socialbase.downloader.d.a.a(this.f43296e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.f43299h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j, this.q, null);
                                    if (th2 != null) {
                                        if (!this.j && !this.k && this.f43299h == null) {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            return;
                                        }
                                        try {
                                            com.ss.android.socialbase.downloader.i.f.a(th2, "loopAndWrite_finally");
                                            return;
                                        } catch (BaseException e7) {
                                            this.f43299h = e7;
                                            throw e7;
                                        }
                                    }
                                    return;
                                }
                            }
                            th2 = null;
                            synchronized (this) {
                            }
                        }
                    }
                    try {
                        a a = dVar.a();
                        if (z) {
                            j5 += System.nanoTime() - j6;
                        }
                        j2 = j5;
                        try {
                            int i4 = a.f43284c;
                            if (i4 == -1) {
                                try {
                                    a(a.f43283b);
                                    cVar.a(a);
                                    j5 = j2;
                                } catch (p e8) {
                                    e = e8;
                                    i2 = i3;
                                    j4 = j7;
                                    j5 = j2;
                                    this.f43299h = e;
                                    throw e;
                                } catch (BaseException e9) {
                                    e = e9;
                                    i = i3;
                                    j3 = j7;
                                    if (!this.f43296e.a("ignore_base_ex_on_stop_status")) {
                                    }
                                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                                    }
                                    com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                    this.f43299h = e;
                                    throw e;
                                } catch (Throwable th12) {
                                    th = th12;
                                    i2 = i3;
                                    j = j7;
                                    if (!this.j) {
                                    }
                                    if (!this.k) {
                                    }
                                    th2 = null;
                                    synchronized (this) {
                                    }
                                }
                            } else {
                                if (z) {
                                    j6 = System.nanoTime();
                                }
                                a.f43283b.b(a);
                                if (z) {
                                    j7 += System.nanoTime() - j6;
                                }
                                j4 = j7;
                                try {
                                    cVar.a(a);
                                    if (this.i) {
                                        if (this.j) {
                                            break;
                                        }
                                        try {
                                            if (this.k) {
                                                break;
                                            }
                                            this.i = z3;
                                        } catch (p e10) {
                                            e = e10;
                                            i2 = i3;
                                            j5 = j2;
                                            this.f43299h = e;
                                            throw e;
                                        } catch (BaseException e11) {
                                            e = e11;
                                            i = i3;
                                            j3 = j4;
                                            if (!this.f43296e.a("ignore_base_ex_on_stop_status")) {
                                            }
                                            if (com.ss.android.socialbase.downloader.c.a.a()) {
                                            }
                                            com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                            this.f43299h = e;
                                            throw e;
                                        } catch (Throwable th13) {
                                            th = th13;
                                            i2 = i3;
                                            j = j4;
                                            if (!this.j) {
                                                if (com.ss.android.socialbase.downloader.c.a.a()) {
                                                }
                                                com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  e = " + th);
                                                com.ss.android.socialbase.downloader.i.f.a(th, "loopAndWrite");
                                                if (i2 > 0) {
                                                }
                                                if (!this.k) {
                                                }
                                                th3 = null;
                                                synchronized (this) {
                                                }
                                            }
                                            if (!this.k) {
                                            }
                                            th2 = null;
                                            synchronized (this) {
                                            }
                                        }
                                    }
                                    i3 += i4;
                                    if (i3 >= 65536) {
                                        try {
                                            long uptimeMillis = SystemClock.uptimeMillis();
                                            if (uptimeMillis - j8 > 100) {
                                                long j9 = j6;
                                                try {
                                                    a(uptimeMillis, fVar.b(i3));
                                                    if (!com.ss.android.socialbase.downloader.network.b.a) {
                                                        if (!downloadInfo.isOnlyWifi()) {
                                                            if (downloadInfo.isDownloadFromReserveWifi() && downloadInfo.isPauseReserveOnWifi()) {
                                                                throw new com.ss.android.socialbase.downloader.exception.e();
                                                            }
                                                        } else {
                                                            throw new com.ss.android.socialbase.downloader.exception.c();
                                                        }
                                                    }
                                                    j8 = uptimeMillis;
                                                    j5 = j2;
                                                    j7 = j4;
                                                    j6 = j9;
                                                    i3 = 0;
                                                    z3 = false;
                                                } catch (p e12) {
                                                    e = e12;
                                                    j5 = j2;
                                                    i2 = 0;
                                                    this.f43299h = e;
                                                    throw e;
                                                } catch (BaseException e13) {
                                                    e = e13;
                                                    j3 = j4;
                                                    i = 0;
                                                    if (!this.f43296e.a("ignore_base_ex_on_stop_status")) {
                                                    }
                                                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                                                    }
                                                    com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                                    this.f43299h = e;
                                                    throw e;
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                    j = j4;
                                                    i2 = 0;
                                                    if (!this.j) {
                                                    }
                                                    if (!this.k) {
                                                    }
                                                    th2 = null;
                                                    synchronized (this) {
                                                    }
                                                }
                                            }
                                        } catch (p e14) {
                                            e = e14;
                                            i2 = i3;
                                            j5 = j2;
                                            this.f43299h = e;
                                            throw e;
                                        } catch (BaseException e15) {
                                            e = e15;
                                            i = i3;
                                            j3 = j4;
                                            if (!this.f43296e.a("ignore_base_ex_on_stop_status")) {
                                            }
                                            if (com.ss.android.socialbase.downloader.c.a.a()) {
                                            }
                                            com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                            this.f43299h = e;
                                            throw e;
                                        } catch (Throwable th15) {
                                            th = th15;
                                            i2 = i3;
                                            j = j4;
                                            if (!this.j) {
                                            }
                                            if (!this.k) {
                                            }
                                            th2 = null;
                                            synchronized (this) {
                                            }
                                        }
                                    }
                                    j5 = j2;
                                    j7 = j4;
                                    j6 = j6;
                                    z3 = false;
                                } catch (p e16) {
                                    e = e16;
                                } catch (BaseException e17) {
                                    e = e17;
                                } catch (Throwable th16) {
                                    th = th16;
                                }
                            }
                        } catch (p e18) {
                            e = e18;
                            i2 = i3;
                            j4 = j7;
                        } catch (BaseException e19) {
                            e = e19;
                            i = i3;
                            j3 = j7;
                            if (!this.f43296e.a("ignore_base_ex_on_stop_status")) {
                            }
                            if (com.ss.android.socialbase.downloader.c.a.a()) {
                            }
                            com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                            this.f43299h = e;
                            throw e;
                        } catch (Throwable th17) {
                            th = th17;
                            i2 = i3;
                            j = j7;
                            if (!this.j) {
                            }
                            if (!this.k) {
                            }
                            th2 = null;
                            synchronized (this) {
                            }
                        }
                    } catch (p e20) {
                        e = e20;
                        i2 = i3;
                        j4 = j7;
                    } catch (BaseException e21) {
                        e = e21;
                        j2 = j5;
                    } catch (Throwable th18) {
                        th = th18;
                        j2 = j5;
                    }
                }
            } catch (Throwable th19) {
                th = th19;
                if (i2 > 0) {
                    try {
                        fVar.b(i2);
                    } catch (Throwable unused3) {
                    }
                }
                if (!this.k) {
                    try {
                        c();
                    } catch (Throwable th20) {
                        com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th20);
                        th5 = th20;
                        synchronized (this) {
                        }
                    }
                }
                th5 = null;
                synchronized (this) {
                    c(this.a);
                    this.a.clear();
                }
                com.ss.android.socialbase.downloader.d.a.a(this.f43296e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.f43299h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j, this.q, null);
                if (th5 != null) {
                    if (!this.j && !this.k && this.f43299h == null) {
                        z2 = false;
                    }
                    if (!z2) {
                        try {
                            com.ss.android.socialbase.downloader.i.f.a(th5, "loopAndWrite_finally");
                        } catch (BaseException e22) {
                            this.f43299h = e22;
                            throw e22;
                        }
                    }
                }
                throw th;
            }
        } catch (p e23) {
            e = e23;
            j4 = 0;
        } catch (BaseException e24) {
            e = e24;
            j3 = 0;
            j2 = 0;
        } catch (Throwable th21) {
            th = th21;
            j = 0;
            j2 = 0;
        }
        if (!this.k) {
            try {
                c();
            } catch (Throwable th22) {
                th6 = th22;
                com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th6);
                synchronized (this) {
                    c(this.a);
                    this.a.clear();
                }
                com.ss.android.socialbase.downloader.d.a.a(this.f43296e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.f43299h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j4, this.q, null);
                if (th6 != null) {
                    if (!this.j && !this.k && this.f43299h == null) {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                    try {
                        com.ss.android.socialbase.downloader.i.f.a(th6, "loopAndWrite_finally");
                        return;
                    } catch (BaseException e25) {
                        this.f43299h = e25;
                        throw e25;
                    }
                }
                return;
            }
        }
        th6 = null;
        synchronized (this) {
        }
    }

    private void c(List<l> list) {
        for (l lVar : list) {
            lVar.d();
        }
    }

    private void a(long j, boolean z) throws IOException {
        long j2 = j - this.s;
        if (this.m) {
            if (j2 > (this.l.b() ? this.n : this.o)) {
                c();
                this.s = j;
                return;
            }
            return;
        }
        long curBytes = this.f43294c.getCurBytes() - this.r;
        if (z || a(curBytes, j2)) {
            c();
            this.s = j;
        }
    }

    private void a(e eVar) {
        synchronized (this) {
            this.f43293b.add((l) eVar);
        }
    }

    private void a(List<l> list) throws IOException {
        for (l lVar : list) {
            lVar.b();
        }
    }

    private void a(List<l> list, Map<Long, i> map) {
        for (l lVar : list) {
            i e2 = lVar.e();
            i iVar = map.get(Long.valueOf(e2.c()));
            if (iVar == null) {
                map.put(Long.valueOf(e2.c()), new i(e2));
            } else {
                iVar.a(e2.d());
                iVar.c(e2.f());
            }
        }
    }

    public void a() {
        this.k = true;
        this.i = true;
    }
}
