package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import com.baidu.clientupdate.download.DownloadManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
/* loaded from: classes8.dex */
public class e {
    public static String b = "ResponseHandler";
    public long A;
    public long B;
    public long C;
    public long D;
    public final DownloadInfo c;
    public final String d;
    public final com.ss.android.socialbase.downloader.model.b e;
    public final com.ss.android.socialbase.downloader.network.i f;
    public j g;
    public com.ss.android.socialbase.downloader.impls.k h;
    public t i;
    public com.ss.android.socialbase.downloader.model.e j;
    public BaseException k;
    public volatile boolean l;
    public volatile boolean m;
    public final com.ss.android.socialbase.downloader.h.f n;
    public long o;
    public long p;
    public volatile long q;
    public volatile long r;
    public final boolean s;
    public final com.ss.android.socialbase.downloader.g.a t;
    public final com.ss.android.socialbase.downloader.a.a u;
    public final boolean v;
    public final long w;
    public final long x;
    public final boolean y;
    public boolean z;
    public boolean a = false;
    public volatile long E = 0;
    public volatile long F = 0;

    public e(DownloadInfo downloadInfo, String str, com.ss.android.socialbase.downloader.network.i iVar, com.ss.android.socialbase.downloader.model.b bVar, com.ss.android.socialbase.downloader.h.f fVar) {
        this.c = downloadInfo;
        this.d = str;
        j x = c.x();
        this.g = x;
        if (x instanceof com.ss.android.socialbase.downloader.impls.d) {
            com.ss.android.socialbase.downloader.impls.d dVar = (com.ss.android.socialbase.downloader.impls.d) x;
            this.h = dVar.a();
            this.i = dVar.f();
        }
        this.f = iVar;
        this.e = bVar;
        this.n = fVar;
        long n = bVar.n();
        this.o = n;
        this.p = n;
        if (bVar.d()) {
            this.r = bVar.q();
        } else {
            this.r = bVar.c(false);
        }
        this.q = bVar.p();
        this.u = com.ss.android.socialbase.downloader.a.a.a();
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.t = a;
        boolean z = a.a("sync_strategy", 0) == 1;
        this.v = z;
        if (z) {
            this.w = Math.max(this.t.a("sync_interval_ms_fg", 5000), 500L);
            this.x = Math.max(this.t.a("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.w = 0L;
            this.x = 0L;
        }
        this.y = this.t.b("monitor_rw") == 1;
        this.s = com.ss.android.socialbase.downloader.i.a.a(65536);
    }

    private boolean b(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    private boolean f() {
        return this.l || this.m;
    }

    private void g() {
        ExecutorService l;
        if (this.f == null || (l = c.l()) == null) {
            return;
        }
        l.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.e.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.f.d();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void h() {
        boolean z;
        long nanoTime = this.y ? System.nanoTime() : 0L;
        try {
            this.j.a();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.c.updateRealDownloadTime(true);
            boolean z2 = this.c.getChunkCount() > 1;
            m a = com.ss.android.socialbase.downloader.impls.l.a(com.ss.android.socialbase.downloader.i.f.b());
            if (z2) {
                a(this.i);
                if (a != null) {
                    a.c(this.c);
                } else {
                    this.i.a(this.c.getId(), this.c.getCurBytes());
                }
            } else if (a != null) {
                a.c(this.c);
            } else {
                this.i.a(this.e.k(), this.o);
            }
            this.E = this.o;
        }
        if (this.y) {
            this.C += System.nanoTime() - nanoTime;
        }
    }

    public void b() {
        if (this.l) {
            return;
        }
        this.l = true;
        g();
    }

    public void c() {
        if (this.m) {
            return;
        }
        synchronized (this.n) {
            this.m = true;
        }
        g();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:145:0x028a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:147:0x028c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:169:0x02d4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:171:0x02d6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:338:0x002b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:340:0x005e */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02e5 A[Catch: all -> 0x04df, TRY_ENTER, TryCatch #29 {all -> 0x04df, blocks: (B:177:0x02e5, B:178:0x02ec, B:207:0x0365, B:209:0x036b, B:210:0x036e, B:251:0x045a, B:252:0x045c, B:256:0x0463, B:258:0x0483, B:286:0x04d3, B:288:0x04d9, B:289:0x04dc, B:290:0x04de), top: B:338:0x002b, inners: #22 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0365 A[Catch: all -> 0x04df, TRY_ENTER, TryCatch #29 {all -> 0x04df, blocks: (B:177:0x02e5, B:178:0x02ec, B:207:0x0365, B:209:0x036b, B:210:0x036e, B:251:0x045a, B:252:0x045c, B:256:0x0463, B:258:0x0483, B:286:0x04d3, B:288:0x04d9, B:289:0x04dc, B:290:0x04de), top: B:338:0x002b, inners: #22 }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0483 A[Catch: all -> 0x04df, TRY_LEAVE, TryCatch #29 {all -> 0x04df, blocks: (B:177:0x02e5, B:178:0x02ec, B:207:0x0365, B:209:0x036b, B:210:0x036e, B:251:0x045a, B:252:0x045c, B:256:0x0463, B:258:0x0483, B:286:0x04d3, B:288:0x04d9, B:289:0x04dc, B:290:0x04de), top: B:338:0x002b, inners: #22 }] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04d9 A[Catch: all -> 0x04df, TryCatch #29 {all -> 0x04df, blocks: (B:177:0x02e5, B:178:0x02ec, B:207:0x0365, B:209:0x036b, B:210:0x036e, B:251:0x045a, B:252:0x045c, B:256:0x0463, B:258:0x0483, B:286:0x04d3, B:288:0x04d9, B:289:0x04dc, B:290:0x04de), top: B:338:0x002b, inners: #22 }] */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v3, types: [int] */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() throws BaseException {
        long j;
        long j2;
        boolean z;
        char c;
        com.ss.android.socialbase.downloader.e.b bVar;
        com.ss.android.socialbase.downloader.g.a aVar;
        DownloadInfo downloadInfo;
        String str;
        com.ss.android.socialbase.downloader.network.i iVar;
        boolean z2;
        boolean z3;
        boolean z4;
        com.ss.android.socialbase.downloader.network.i iVar2;
        String str2;
        DownloadInfo downloadInfo2;
        com.ss.android.socialbase.downloader.g.a aVar2;
        char c2;
        int i;
        InputStream a;
        long j3;
        long j4;
        long currentTimeMillis;
        long j5;
        long j6;
        if (f() || this.e == null) {
            return;
        }
        long a2 = com.ss.android.socialbase.downloader.i.f.a(this.f);
        if (a2 != 0) {
            int l = this.e.l();
            long nanoTime = System.nanoTime();
            boolean z5 = this.y;
            boolean z6 = this.f instanceof com.ss.android.socialbase.downloader.network.a;
            int i2 = 1;
            try {
                try {
                    i = -1;
                    com.ss.android.socialbase.downloader.model.e a3 = com.ss.android.socialbase.downloader.i.f.a(this.c, this.c.getTempPath(), this.c.getTempName(), this.t.a("flush_buffer_size_byte", -1));
                    this.j = a3;
                    try {
                        try {
                            a3.a(this.o);
                            a = this.f.a();
                        } catch (IOException e) {
                            throw new BaseException(1054, e);
                        }
                    } catch (BaseException e2) {
                        e = e2;
                        bVar = null;
                        com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: BaseException e = " + e);
                        if (!this.t.a("ignore_base_ex_on_stop_status")) {
                        }
                        if (com.ss.android.socialbase.downloader.c.a.a()) {
                        }
                        this.k = e;
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        bVar = null;
                        if (z6) {
                        }
                        com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: e = " + th);
                        if (!f()) {
                        }
                    }
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.network.i iVar3 = this.f;
                    if (iVar3 != null) {
                        iVar3.d();
                    }
                    if (bVar != null) {
                        bVar.b();
                    }
                    try {
                        if (this.s) {
                            synchronized (this.n) {
                                if (!this.m) {
                                    a(this.h);
                                    if (this.j != null) {
                                        h();
                                    }
                                }
                            }
                        } else {
                            a(this.h);
                            if (this.j != null) {
                                h();
                            }
                        }
                        Closeable[] closeableArr = new Closeable[l];
                        closeableArr[c] = this.j;
                        com.ss.android.socialbase.downloader.i.f.a(closeableArr);
                        this.D = System.nanoTime() - nanoTime;
                        com.ss.android.socialbase.downloader.d.a.a(this.t, this.c, this.d, this.f, this.l, this.m, this.k, this.o - this.p, this.D, z, this.A, this.B, this.C, null);
                        throw th2;
                    } catch (Throwable th3) {
                        Closeable[] closeableArr2 = new Closeable[l];
                        closeableArr2[c] = this.j;
                        com.ss.android.socialbase.downloader.i.f.a(closeableArr2);
                        throw th3;
                    }
                }
            } catch (BaseException e3) {
                e = e3;
                z = z5;
            } catch (Throwable th4) {
                th = th4;
                j = a2;
                j2 = l;
                z = z5;
            }
            if (a != null) {
                this.c.updateRealStartDownloadTime();
                bVar = a(a);
                try {
                    this.c.setIsRwConcurrent(this.z);
                    this.a = this.c.getOpenLimitSpeed();
                    long j7 = com.ss.android.socialbase.downloader.constants.e.d;
                    j3 = com.ss.android.socialbase.downloader.constants.e.e;
                    j4 = j7 / (1000 / j3);
                    currentTimeMillis = System.currentTimeMillis();
                    j5 = 0;
                    j6 = 0;
                    l = l;
                } catch (BaseException e4) {
                    e = e4;
                    z = z5;
                } catch (Throwable th5) {
                    th = th5;
                    j = a2;
                    j2 = l;
                    z = z5;
                }
                while (!f()) {
                    z = z5;
                    if (z) {
                        try {
                            try {
                                j5 = System.nanoTime();
                            } catch (Throwable th6) {
                                th = th6;
                                j = a2;
                                j2 = l;
                                if (z6) {
                                }
                                com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: e = " + th);
                                if (!f()) {
                                }
                            }
                        } catch (BaseException e5) {
                            e = e5;
                            com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: BaseException e = " + e);
                            if (!this.t.a("ignore_base_ex_on_stop_status") && f()) {
                                com.ss.android.socialbase.downloader.network.i iVar4 = this.f;
                                if (iVar4 != null) {
                                    iVar4.d();
                                }
                                if (bVar != null) {
                                    bVar.b();
                                }
                                try {
                                    if (this.s) {
                                        synchronized (this.n) {
                                            if (!this.m) {
                                                a(this.h);
                                                if (this.j != null) {
                                                    h();
                                                }
                                            }
                                        }
                                    } else {
                                        a(this.h);
                                        if (this.j != null) {
                                            h();
                                        }
                                    }
                                    Closeable[] closeableArr3 = new Closeable[l];
                                    closeableArr3[c] = this.j;
                                    com.ss.android.socialbase.downloader.i.f.a(closeableArr3);
                                    this.D = System.nanoTime() - nanoTime;
                                    aVar2 = this.t;
                                    downloadInfo2 = this.c;
                                    str2 = this.d;
                                    iVar2 = this.f;
                                    z4 = this.l;
                                    z3 = this.m;
                                    com.ss.android.socialbase.downloader.d.a.a(aVar2, downloadInfo2, str2, iVar2, z4, z3, this.k, this.o - this.p, this.D, z, this.A, this.B, this.C, null);
                                    return;
                                } catch (Throwable th7) {
                                    Closeable[] closeableArr4 = new Closeable[l];
                                    closeableArr4[c] = this.j;
                                    com.ss.android.socialbase.downloader.i.f.a(closeableArr4);
                                    throw th7;
                                }
                            }
                            if (com.ss.android.socialbase.downloader.c.a.a()) {
                                e.printStackTrace();
                            }
                            this.k = e;
                            throw e;
                        }
                    }
                    com.ss.android.socialbase.downloader.f.a a4 = bVar.a();
                    if (z) {
                        this.A += System.nanoTime() - j5;
                    }
                    int i3 = a4.c;
                    if (i3 == i) {
                        j = a2;
                        j2 = l;
                    } else {
                        if (this.c.isIgnoreDataVerify()) {
                            j = a2;
                            j2 = l;
                        } else {
                            j2 = l;
                            try {
                                if (this.r > this.o - this.p) {
                                    j = a2;
                                    try {
                                        if (this.r < (this.o - this.p) + i3) {
                                            i3 = (int) (this.r - (this.o - this.p));
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        if (z6) {
                                            ((com.ss.android.socialbase.downloader.network.a) this.f).a(th);
                                        }
                                        com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: e = " + th);
                                        if (!f()) {
                                            com.ss.android.socialbase.downloader.network.i iVar5 = this.f;
                                            if (iVar5 != null) {
                                                iVar5.d();
                                            }
                                            if (bVar != null) {
                                                bVar.b();
                                            }
                                            try {
                                                if (this.s) {
                                                    synchronized (this.n) {
                                                        if (!this.m) {
                                                            a(this.h);
                                                            if (this.j != null) {
                                                                h();
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    a(this.h);
                                                    if (this.j != null) {
                                                        h();
                                                    }
                                                }
                                                Closeable[] closeableArr5 = new Closeable[l];
                                                closeableArr5[c] = this.j;
                                                com.ss.android.socialbase.downloader.i.f.a(closeableArr5);
                                                this.D = System.nanoTime() - nanoTime;
                                                aVar2 = this.t;
                                                downloadInfo2 = this.c;
                                                str2 = this.d;
                                                iVar2 = this.f;
                                                z4 = this.l;
                                                z3 = this.m;
                                                com.ss.android.socialbase.downloader.d.a.a(aVar2, downloadInfo2, str2, iVar2, z4, z3, this.k, this.o - this.p, this.D, z, this.A, this.B, this.C, null);
                                                return;
                                            } catch (Throwable th9) {
                                                Closeable[] closeableArr6 = new Closeable[l];
                                                closeableArr6[c] = this.j;
                                                com.ss.android.socialbase.downloader.i.f.a(closeableArr6);
                                                throw th9;
                                            }
                                        }
                                        if (com.ss.android.socialbase.downloader.c.a.a()) {
                                            th.printStackTrace();
                                        }
                                        try {
                                            com.ss.android.socialbase.downloader.i.f.a(th, "ResponseHandler");
                                            com.ss.android.socialbase.downloader.network.i iVar6 = this.f;
                                            if (iVar6 != null) {
                                                iVar6.d();
                                            }
                                            if (bVar != null) {
                                                bVar.b();
                                            }
                                            try {
                                                if (this.s) {
                                                    synchronized (this.n) {
                                                        if (!this.m) {
                                                            a(this.h);
                                                            if (this.j != null) {
                                                                h();
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    a(this.h);
                                                    if (this.j != null) {
                                                        h();
                                                    }
                                                }
                                                Closeable[] closeableArr7 = new Closeable[l];
                                                closeableArr7[c] = this.j;
                                                com.ss.android.socialbase.downloader.i.f.a(closeableArr7);
                                                this.D = System.nanoTime() - nanoTime;
                                                aVar = this.t;
                                                downloadInfo = this.c;
                                                str = this.d;
                                                iVar = this.f;
                                                z2 = this.l;
                                                c2 = l;
                                                com.ss.android.socialbase.downloader.d.a.a(aVar, downloadInfo, str, iVar, z2, this.m, this.k, this.o - this.p, this.D, z, this.A, this.B, this.C, null);
                                                if (this.c.isIgnoreDataVerify()) {
                                                }
                                            } catch (Throwable th10) {
                                                Closeable[] closeableArr8 = new Closeable[l];
                                                closeableArr8[c] = this.j;
                                                com.ss.android.socialbase.downloader.i.f.a(closeableArr8);
                                                throw th10;
                                            }
                                        } catch (BaseException e6) {
                                            this.k = e6;
                                            throw e6;
                                        }
                                    }
                                } else {
                                    j = a2;
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                j = a2;
                            }
                        }
                        if (z) {
                            j5 = System.nanoTime();
                        }
                        this.j.a(a4.a, 0, i3);
                        if (z) {
                            this.B += System.nanoTime() - j5;
                        }
                        bVar.a(a4);
                        long j8 = i3;
                        this.o += j8;
                        j6 += j8;
                        synchronized (this.n) {
                            try {
                                if (this.s) {
                                    if (!this.m) {
                                        boolean b2 = this.n.b(j8);
                                        a(this.h);
                                        a(b2);
                                    }
                                } else {
                                    boolean b3 = this.n.b(j8);
                                    a(this.h);
                                    a(b3);
                                }
                            } finally {
                                th = th;
                                while (true) {
                                    try {
                                        break;
                                    } catch (Throwable th12) {
                                        th = th12;
                                    }
                                }
                            }
                        }
                        if (this.c.isDownloadWithWifiValid()) {
                            if (this.c.isPauseReserveWithWifiValid()) {
                                if (this.c.isIgnoreDataVerify() || this.r < 0 || this.r > this.o - this.p) {
                                    try {
                                        if (this.a && j6 > j4) {
                                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                            if (currentTimeMillis2 < j3) {
                                                try {
                                                    Thread.sleep(j3 - currentTimeMillis2);
                                                } catch (InterruptedException e7) {
                                                    e7.printStackTrace();
                                                }
                                            }
                                            currentTimeMillis = System.currentTimeMillis();
                                            j6 = 0;
                                        }
                                        z5 = z;
                                        a2 = j;
                                        l = j2;
                                        i = -1;
                                        i2 = 1;
                                    } catch (BaseException e8) {
                                        e = e8;
                                        com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: BaseException e = " + e);
                                        if (!this.t.a("ignore_base_ex_on_stop_status")) {
                                        }
                                        if (com.ss.android.socialbase.downloader.c.a.a()) {
                                        }
                                        this.k = e;
                                        throw e;
                                    } catch (Throwable th13) {
                                        th = th13;
                                        if (z6) {
                                        }
                                        com.ss.android.socialbase.downloader.c.a.d(b, "handleResponse: e = " + th);
                                        if (!f()) {
                                        }
                                    }
                                }
                            } else {
                                throw new com.ss.android.socialbase.downloader.exception.e();
                            }
                        } else {
                            throw new com.ss.android.socialbase.downloader.exception.c();
                        }
                    }
                    com.ss.android.socialbase.downloader.network.i iVar7 = this.f;
                    if (iVar7 != null) {
                        iVar7.d();
                    }
                    if (bVar != null) {
                        bVar.b();
                    }
                    try {
                        if (this.s) {
                            synchronized (this.n) {
                                if (!this.m) {
                                    a(this.h);
                                    if (this.j != null) {
                                        h();
                                    }
                                }
                            }
                        } else {
                            a(this.h);
                            if (this.j != null) {
                                h();
                            }
                        }
                        com.ss.android.socialbase.downloader.i.f.a(this.j);
                        this.D = System.nanoTime() - nanoTime;
                        aVar = this.t;
                        downloadInfo = this.c;
                        str = this.d;
                        iVar = this.f;
                        c = 0;
                        z2 = this.l;
                        c2 = 1;
                        com.ss.android.socialbase.downloader.d.a.a(aVar, downloadInfo, str, iVar, z2, this.m, this.k, this.o - this.p, this.D, z, this.A, this.B, this.C, null);
                        if (this.c.isIgnoreDataVerify()) {
                            long j9 = this.o - this.p;
                            if (j9 < 0 || this.r < 0 || this.r == j9) {
                                return;
                            }
                            Object[] objArr = new Object[7];
                            objArr[c] = Long.valueOf(j9);
                            objArr[c2] = Long.valueOf(j);
                            objArr[2] = Long.valueOf(this.r);
                            objArr[3] = Long.valueOf(j2);
                            objArr[4] = Long.valueOf(this.q);
                            objArr[5] = Long.valueOf(this.o);
                            objArr[6] = Long.valueOf(this.p);
                            throw new BaseException(1051, String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", objArr));
                        }
                        return;
                    } catch (Throwable th14) {
                        com.ss.android.socialbase.downloader.i.f.a(this.j);
                        throw th14;
                    }
                }
                com.ss.android.socialbase.downloader.network.i iVar8 = this.f;
                if (iVar8 != null) {
                    iVar8.d();
                }
                if (bVar != null) {
                    bVar.b();
                }
                try {
                    if (this.s) {
                        synchronized (this.n) {
                            if (!this.m) {
                                a(this.h);
                                if (this.j != null) {
                                    h();
                                }
                            }
                        }
                    } else {
                        a(this.h);
                        if (this.j != null) {
                            h();
                        }
                    }
                    Closeable[] closeableArr9 = new Closeable[i2];
                    closeableArr9[0] = this.j;
                    com.ss.android.socialbase.downloader.i.f.a(closeableArr9);
                    this.D = System.nanoTime() - nanoTime;
                    aVar2 = this.t;
                    downloadInfo2 = this.c;
                    str2 = this.d;
                    iVar2 = this.f;
                    z4 = this.l;
                    z = z5;
                    z3 = this.m;
                    com.ss.android.socialbase.downloader.d.a.a(aVar2, downloadInfo2, str2, iVar2, z4, z3, this.k, this.o - this.p, this.D, z, this.A, this.B, this.C, null);
                    return;
                } catch (Throwable th15) {
                    Closeable[] closeableArr10 = new Closeable[i2];
                    closeableArr10[0] = this.j;
                    com.ss.android.socialbase.downloader.i.f.a(closeableArr10);
                    throw th15;
                }
            }
            throw new BaseException(1042, new IOException("inputStream is null"));
        }
        throw new com.ss.android.socialbase.downloader.exception.f(1004, "the content-length is 0");
    }

    public long e() {
        return this.E;
    }

    public long a() {
        return this.o;
    }

    public void a(long j, long j2, long j3) {
        this.o = j;
        this.p = j;
        this.q = j2;
        this.r = j3;
    }

    public void a(long j, long j2) {
        this.q = j;
        this.r = j2;
    }

    private com.ss.android.socialbase.downloader.e.b a(InputStream inputStream) {
        int H = c.H();
        if (this.t.a("rw_concurrent", 0) == 1 && this.c.getChunkCount() == 1 && this.c.getTotalBytes() > DownloadManager.MIN_LEFT_SIZE) {
            try {
                com.ss.android.socialbase.downloader.e.a aVar = new com.ss.android.socialbase.downloader.e.a(inputStream, H, this.t.a("rw_concurrent_max_buffer_count", 4));
                this.z = true;
                return aVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        com.ss.android.socialbase.downloader.e.c cVar = new com.ss.android.socialbase.downloader.e.c(inputStream, H);
        this.z = false;
        return cVar;
    }

    private void a(boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.F;
        if (this.v) {
            if (j > (this.u.b() ? this.w : this.x)) {
                h();
                this.F = uptimeMillis;
                return;
            }
            return;
        }
        long j2 = this.o - this.E;
        if (z || b(j2, j)) {
            h();
            this.F = uptimeMillis;
        }
    }

    private void a(j jVar) {
        com.ss.android.socialbase.downloader.model.b bVar;
        com.ss.android.socialbase.downloader.model.b bVar2;
        if (jVar == null) {
            return;
        }
        m mVar = null;
        boolean z = jVar instanceof com.ss.android.socialbase.downloader.b.e;
        if (z && (mVar = com.ss.android.socialbase.downloader.impls.l.a(com.ss.android.socialbase.downloader.i.f.b())) == null) {
            return;
        }
        m mVar2 = mVar;
        if (this.e.d()) {
            bVar = this.e.e();
        } else {
            bVar = this.e;
        }
        com.ss.android.socialbase.downloader.model.b bVar3 = bVar;
        if (bVar3 != null) {
            bVar3.b(this.o);
            if (z && mVar2 != null) {
                mVar2.a(bVar3.k(), bVar3.s(), bVar3.b(), this.o);
                bVar2 = bVar3;
            } else {
                bVar2 = bVar3;
                jVar.a(bVar3.k(), bVar3.s(), bVar3.b(), this.o);
            }
            if (bVar2.h()) {
                boolean z2 = false;
                if (bVar2.i()) {
                    long j = bVar2.j();
                    if (j > this.o) {
                        if (z && mVar2 != null) {
                            mVar2.a(bVar2.k(), bVar2.b(), j);
                        } else {
                            jVar.a(bVar2.k(), bVar2.b(), j);
                        }
                        z2 = true;
                    }
                }
                if (z2) {
                    return;
                }
                if (z && mVar2 != null) {
                    mVar2.a(bVar2.k(), bVar2.b(), this.o);
                } else {
                    jVar.a(bVar2.k(), bVar2.b(), this.o);
                }
            }
        } else if (this.e.d()) {
            if (z && mVar2 != null) {
                mVar2.a(this.e.k(), this.e.s(), this.o);
            } else {
                jVar.a(this.e.k(), this.e.s(), this.o);
            }
        }
    }
}
