package d.o.a.e.b.g;

import android.os.SystemClock;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class f {
    public static String F = "ResponseHandler";
    public long A;
    public long B;
    public long C;

    /* renamed from: a  reason: collision with root package name */
    public final DownloadInfo f66490a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66491b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.model.b f66492c;

    /* renamed from: d  reason: collision with root package name */
    public final d.o.a.e.b.o.k f66493d;

    /* renamed from: e  reason: collision with root package name */
    public j f66494e;

    /* renamed from: f  reason: collision with root package name */
    public d.o.a.e.b.m.k f66495f;

    /* renamed from: g  reason: collision with root package name */
    public s f66496g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.n.c f66497h;

    /* renamed from: i  reason: collision with root package name */
    public BaseException f66498i;
    public volatile boolean j;
    public volatile boolean k;
    public final d.o.a.e.b.k.f l;
    public long m;
    public long n;
    public volatile long o;
    public volatile long p;
    public final boolean q;
    public final d.o.a.e.b.j.a r;
    public final d.o.a.e.b.a.a s;
    public final boolean t;
    public final long u;
    public final long v;
    public final boolean w;
    public boolean x;
    public long z;
    public boolean y = false;
    public volatile long D = 0;
    public volatile long E = 0;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.f66493d.d();
            } catch (Throwable unused) {
            }
        }
    }

    public f(DownloadInfo downloadInfo, String str, d.o.a.e.b.o.k kVar, com.ss.android.socialbase.downloader.model.b bVar, d.o.a.e.b.k.f fVar) {
        this.f66490a = downloadInfo;
        this.f66491b = str;
        j I0 = d.I0();
        this.f66494e = I0;
        if (I0 instanceof d.o.a.e.b.m.d) {
            d.o.a.e.b.m.d dVar = (d.o.a.e.b.m.d) I0;
            this.f66495f = dVar.e();
            this.f66496g = dVar.i();
        }
        this.f66493d = kVar;
        this.f66492c = bVar;
        this.l = fVar;
        long A = bVar.A();
        this.m = A;
        this.n = A;
        if (bVar.q()) {
            this.p = bVar.D();
        } else {
            this.p = bVar.n(false);
        }
        this.o = bVar.C();
        this.s = d.o.a.e.b.a.a.c();
        d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(downloadInfo.c0());
        this.r = d2;
        boolean z = d2.b("sync_strategy", 0) == 1;
        this.t = z;
        if (z) {
            this.u = Math.max(this.r.b("sync_interval_ms_fg", 5000), 500L);
            this.v = Math.max(this.r.b("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.u = 0L;
            this.v = 0L;
        }
        this.w = this.r.m("monitor_rw") == 1;
        this.q = d.o.a.e.b.l.a.a(65536);
    }

    public long a() {
        return this.m;
    }

    public final d.o.a.e.b.h.b b(InputStream inputStream) {
        int g2 = d.g();
        if (this.r.b("rw_concurrent", 0) == 1 && this.f66490a.B() == 1 && this.f66490a.Q0() > DownloadManager.MIN_LEFT_SIZE) {
            try {
                d.o.a.e.b.h.a aVar = new d.o.a.e.b.h.a(inputStream, g2, this.r.b("rw_concurrent_max_buffer_count", 4));
                this.x = true;
                return aVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        d.o.a.e.b.h.c cVar = new d.o.a.e.b.h.c(inputStream, g2);
        this.x = false;
        return cVar;
    }

    public void d(long j, long j2) {
        this.o = j;
        this.p = j2;
    }

    public void e(long j, long j2, long j3) {
        this.m = j;
        this.n = j;
        this.o = j2;
        this.p = j3;
    }

    public final void f(j jVar) {
        com.ss.android.socialbase.downloader.model.b bVar;
        com.ss.android.socialbase.downloader.model.b bVar2;
        if (jVar == null) {
            return;
        }
        m mVar = null;
        boolean z = jVar instanceof com.ss.android.socialbase.downloader.b.e;
        if (z && (mVar = d.o.a.e.b.m.l.a(d.o.a.e.b.l.e.b0())) == null) {
            return;
        }
        m mVar2 = mVar;
        if (this.f66492c.q()) {
            bVar = this.f66492c.r();
        } else {
            bVar = this.f66492c;
        }
        com.ss.android.socialbase.downloader.model.b bVar3 = bVar;
        if (bVar3 != null) {
            bVar3.l(this.m);
            if (z && mVar2 != null) {
                mVar2.a(bVar3.x(), bVar3.F(), bVar3.j(), this.m);
                bVar2 = bVar3;
            } else {
                bVar2 = bVar3;
                jVar.a(bVar3.x(), bVar3.F(), bVar3.j(), this.m);
            }
            if (bVar2.u()) {
                boolean z2 = false;
                if (bVar2.v()) {
                    long w = bVar2.w();
                    if (w > this.m) {
                        if (z && mVar2 != null) {
                            mVar2.a(bVar2.x(), bVar2.j(), w);
                        } else {
                            jVar.a(bVar2.x(), bVar2.j(), w);
                        }
                        z2 = true;
                    }
                }
                if (z2) {
                    return;
                }
                if (z && mVar2 != null) {
                    mVar2.a(bVar2.x(), bVar2.j(), this.m);
                } else {
                    jVar.a(bVar2.x(), bVar2.j(), this.m);
                }
            }
        } else if (this.f66492c.q()) {
            if (z && mVar2 != null) {
                mVar2.a(this.f66492c.x(), this.f66492c.F(), this.m);
            } else {
                jVar.a(this.f66492c.x(), this.f66492c.F(), this.m);
            }
        }
    }

    public final void g(boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.E;
        if (this.t) {
            if (j > (this.s.j() ? this.u : this.v)) {
                o();
                this.E = uptimeMillis;
                return;
            }
            return;
        }
        long j2 = this.m - this.D;
        if (z || i(j2, j)) {
            o();
            this.E = uptimeMillis;
        }
    }

    public void h() {
        if (this.j) {
            return;
        }
        this.j = true;
        n();
    }

    public final boolean i(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    public void j() {
        if (this.k) {
            return;
        }
        synchronized (this.l) {
            this.k = true;
        }
        n();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:168:0x0322 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:170:0x0325 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:196:0x0371 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:198:0x0373 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:246:0x041f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x040b A[Catch: all -> 0x041f, TRY_ENTER, TryCatch #33 {all -> 0x041f, blocks: (B:207:0x038a, B:208:0x0391, B:237:0x040b, B:239:0x0411, B:240:0x0414, B:244:0x041c, B:245:0x041e), top: B:343:0x038a, inners: #30 }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x044b A[Catch: all -> 0x04a7, TRY_LEAVE, TryCatch #28 {all -> 0x04a7, blocks: (B:250:0x042b, B:252:0x044b, B:280:0x049b, B:282:0x04a1, B:283:0x04a4, B:284:0x04a6), top: B:349:0x042b }] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04a1 A[Catch: all -> 0x04a7, TryCatch #28 {all -> 0x04a7, blocks: (B:250:0x042b, B:252:0x044b, B:280:0x049b, B:282:0x04a1, B:283:0x04a4, B:284:0x04a6), top: B:349:0x042b }] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04b9 A[Catch: all -> 0x051c, TryCatch #31 {all -> 0x051c, blocks: (B:292:0x04b5, B:294:0x04b9, B:295:0x04bb, B:306:0x04d1, B:308:0x04da, B:296:0x04bc, B:298:0x04c0, B:300:0x04c9, B:301:0x04cc), top: B:342:0x04b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x04d1 A[Catch: all -> 0x051c, TryCatch #31 {all -> 0x051c, blocks: (B:292:0x04b5, B:294:0x04b9, B:295:0x04bb, B:306:0x04d1, B:308:0x04da, B:296:0x04bc, B:298:0x04c0, B:300:0x04c9, B:301:0x04cc), top: B:342:0x04b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x038a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k() throws BaseException {
        long j;
        boolean z;
        int i2;
        d.o.a.e.b.h.b bVar;
        d.o.a.e.b.h.b bVar2;
        d.o.a.e.b.o.k kVar;
        boolean z2;
        boolean z3;
        d.o.a.e.b.o.k kVar2;
        String str;
        DownloadInfo downloadInfo;
        d.o.a.e.b.j.a aVar;
        int i3;
        d.o.a.e.b.n.c f2;
        InputStream a2;
        boolean z4;
        long j2;
        if (m() || this.f66492c == null) {
            return;
        }
        long d2 = d.o.a.e.b.l.e.d(this.f66493d);
        if (d2 != 0) {
            ?? y = this.f66492c.y();
            long nanoTime = System.nanoTime();
            boolean z5 = this.w;
            boolean z6 = this.f66493d instanceof d.o.a.e.b.o.c;
            int i4 = 1;
            int i5 = 0;
            try {
                try {
                    try {
                        i3 = -1;
                        f2 = d.o.a.e.b.l.e.f(this.f66490a.N0(), this.f66490a.M0(), this.r.b("flush_buffer_size_byte", -1));
                        this.f66497h = f2;
                    } catch (BaseException e2) {
                        e = e2;
                        j = nanoTime;
                        z = z5;
                        y = 0;
                        i2 = 1;
                    }
                } catch (Throwable th) {
                    th = th;
                    j = nanoTime;
                    z = z5;
                    y = 0;
                    i2 = 1;
                    z5 = z6;
                }
            } catch (BaseException e3) {
                e = e3;
                j = nanoTime;
                z = z5;
                y = 0;
                i2 = 1;
                bVar = null;
            }
            try {
                try {
                    f2.a(this.m);
                    a2 = this.f66493d.a();
                } catch (IOException e4) {
                    throw new BaseException(1054, e4);
                }
            } catch (BaseException e5) {
                e = e5;
                bVar = null;
                y = y;
                try {
                    d.o.a.e.b.c.a.i(F, "handleResponse: BaseException e = " + e);
                    if (!this.r.l("ignore_base_ex_on_stop_status")) {
                    }
                    if (d.o.a.e.b.c.a.e()) {
                    }
                    this.f66498i = e;
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    bVar2 = bVar;
                    kVar = this.f66493d;
                    if (kVar != null) {
                    }
                    if (bVar2 != null) {
                    }
                    try {
                        if (!this.q) {
                        }
                        Closeable[] closeableArr = new Closeable[i2];
                        closeableArr[y] = this.f66497h;
                        d.o.a.e.b.l.e.C(closeableArr);
                        this.C = System.nanoTime() - j;
                        d.o.a.e.b.e.a.f(this.r, this.f66490a, this.f66491b, this.f66493d, this.j, this.k, this.f66498i, this.m - this.n, this.C, z, this.z, this.A, this.B, null);
                        throw th;
                    } catch (Throwable th3) {
                        Closeable[] closeableArr2 = new Closeable[i2];
                        closeableArr2[y] = this.f66497h;
                        d.o.a.e.b.l.e.C(closeableArr2);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bVar2 = null;
                if (z5) {
                }
                d.o.a.e.b.c.a.i(F, "handleResponse: e = " + th);
                if (m()) {
                }
            }
            if (a2 != null) {
                this.f66490a.r3();
                bVar2 = b(a2);
                try {
                    this.f66490a.E2(this.x);
                    this.y = this.f66490a.t0();
                    long j3 = d.o.a.e.b.d.c.f66452d;
                    long j4 = d.o.a.e.b.d.c.f66453e;
                    long j5 = j3 / (1000 / j4);
                    long currentTimeMillis = System.currentTimeMillis();
                    long j6 = 0;
                    long j7 = 0;
                    long j8 = y;
                    while (!m()) {
                        z = z5;
                        if (z) {
                            try {
                                try {
                                    j6 = System.nanoTime();
                                } catch (Throwable th5) {
                                    th = th5;
                                    j = nanoTime;
                                    z5 = z6;
                                    y = 0;
                                    i2 = 1;
                                    if (z5) {
                                    }
                                    d.o.a.e.b.c.a.i(F, "handleResponse: e = " + th);
                                    if (m()) {
                                    }
                                }
                            } catch (BaseException e6) {
                                e = e6;
                                bVar = bVar2;
                                j = nanoTime;
                                y = 0;
                                i2 = 1;
                                d.o.a.e.b.c.a.i(F, "handleResponse: BaseException e = " + e);
                                if (!this.r.l("ignore_base_ex_on_stop_status")) {
                                }
                                if (d.o.a.e.b.c.a.e()) {
                                }
                                this.f66498i = e;
                                throw e;
                            }
                        }
                        try {
                            d.o.a.e.b.i.a a3 = bVar2.a();
                            if (z) {
                                this.z += System.nanoTime() - j6;
                            }
                            int i6 = a3.f66526c;
                            if (i6 == i3) {
                                j2 = j8;
                                j = nanoTime;
                            } else {
                                if (this.f66490a.y1()) {
                                    j2 = j8;
                                    j = nanoTime;
                                    z5 = z6;
                                } else {
                                    j2 = j8;
                                    try {
                                        j = nanoTime;
                                        try {
                                            try {
                                                z5 = z6;
                                                try {
                                                    if (this.p > this.m - this.n && this.p < (this.m - this.n) + i6) {
                                                        i6 = (int) (this.p - (this.m - this.n));
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    y = 0;
                                                    i2 = 1;
                                                    if (z5) {
                                                        try {
                                                            ((d.o.a.e.b.o.c) this.f66493d).b(th);
                                                        } catch (Throwable th7) {
                                                            th = th7;
                                                            kVar = this.f66493d;
                                                            if (kVar != null) {
                                                                kVar.d();
                                                            }
                                                            if (bVar2 != null) {
                                                                bVar2.b();
                                                            }
                                                            if (!this.q) {
                                                                synchronized (this.l) {
                                                                    if (!this.k) {
                                                                        f(this.f66495f);
                                                                        if (this.f66497h != null) {
                                                                            o();
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                f(this.f66495f);
                                                                if (this.f66497h != null) {
                                                                    o();
                                                                }
                                                            }
                                                            Closeable[] closeableArr3 = new Closeable[i2];
                                                            closeableArr3[y] = this.f66497h;
                                                            d.o.a.e.b.l.e.C(closeableArr3);
                                                            this.C = System.nanoTime() - j;
                                                            d.o.a.e.b.e.a.f(this.r, this.f66490a, this.f66491b, this.f66493d, this.j, this.k, this.f66498i, this.m - this.n, this.C, z, this.z, this.A, this.B, null);
                                                            throw th;
                                                        }
                                                    }
                                                    d.o.a.e.b.c.a.i(F, "handleResponse: e = " + th);
                                                    if (m()) {
                                                        d.o.a.e.b.o.k kVar3 = this.f66493d;
                                                        if (kVar3 != null) {
                                                            kVar3.d();
                                                        }
                                                        if (bVar2 != null) {
                                                            bVar2.b();
                                                        }
                                                        try {
                                                            if (this.q) {
                                                                synchronized (this.l) {
                                                                    if (!this.k) {
                                                                        f(this.f66495f);
                                                                        if (this.f66497h != null) {
                                                                            o();
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                f(this.f66495f);
                                                                if (this.f66497h != null) {
                                                                    o();
                                                                }
                                                            }
                                                            Closeable[] closeableArr4 = new Closeable[i2];
                                                            closeableArr4[y] = this.f66497h;
                                                            d.o.a.e.b.l.e.C(closeableArr4);
                                                            this.C = System.nanoTime() - j;
                                                            aVar = this.r;
                                                            downloadInfo = this.f66490a;
                                                            str = this.f66491b;
                                                            kVar2 = this.f66493d;
                                                            z3 = this.j;
                                                            z2 = this.k;
                                                            d.o.a.e.b.e.a.f(aVar, downloadInfo, str, kVar2, z3, z2, this.f66498i, this.m - this.n, this.C, z, this.z, this.A, this.B, null);
                                                            return;
                                                        } catch (Throwable th8) {
                                                            Closeable[] closeableArr5 = new Closeable[i2];
                                                            closeableArr5[y] = this.f66497h;
                                                            d.o.a.e.b.l.e.C(closeableArr5);
                                                            throw th8;
                                                        }
                                                    }
                                                    if (d.o.a.e.b.c.a.e()) {
                                                        th.printStackTrace();
                                                    }
                                                    try {
                                                        d.o.a.e.b.l.e.A(th, "ResponseHandler");
                                                        throw null;
                                                    } catch (BaseException e7) {
                                                        this.f66498i = e7;
                                                        throw e7;
                                                    }
                                                }
                                            } catch (BaseException e8) {
                                                e = e8;
                                                bVar = bVar2;
                                                y = 0;
                                                i2 = 1;
                                                d.o.a.e.b.c.a.i(F, "handleResponse: BaseException e = " + e);
                                                if (!this.r.l("ignore_base_ex_on_stop_status") && m()) {
                                                    d.o.a.e.b.o.k kVar4 = this.f66493d;
                                                    if (kVar4 != null) {
                                                        kVar4.d();
                                                    }
                                                    if (bVar != null) {
                                                        bVar.b();
                                                    }
                                                    try {
                                                        if (this.q) {
                                                            synchronized (this.l) {
                                                                if (!this.k) {
                                                                    f(this.f66495f);
                                                                    if (this.f66497h != null) {
                                                                        o();
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            f(this.f66495f);
                                                            if (this.f66497h != null) {
                                                                o();
                                                            }
                                                        }
                                                        Closeable[] closeableArr6 = new Closeable[i2];
                                                        closeableArr6[y] = this.f66497h;
                                                        d.o.a.e.b.l.e.C(closeableArr6);
                                                        this.C = System.nanoTime() - j;
                                                        aVar = this.r;
                                                        downloadInfo = this.f66490a;
                                                        str = this.f66491b;
                                                        kVar2 = this.f66493d;
                                                        z3 = this.j;
                                                        z2 = this.k;
                                                        d.o.a.e.b.e.a.f(aVar, downloadInfo, str, kVar2, z3, z2, this.f66498i, this.m - this.n, this.C, z, this.z, this.A, this.B, null);
                                                        return;
                                                    } catch (Throwable th9) {
                                                        Closeable[] closeableArr7 = new Closeable[i2];
                                                        closeableArr7[y] = this.f66497h;
                                                        d.o.a.e.b.l.e.C(closeableArr7);
                                                        throw th9;
                                                    }
                                                }
                                                if (d.o.a.e.b.c.a.e()) {
                                                    e.printStackTrace();
                                                }
                                                this.f66498i = e;
                                                throw e;
                                            }
                                        } catch (Throwable th10) {
                                            th = th10;
                                            z5 = z6;
                                            y = 0;
                                            i2 = 1;
                                            if (z5) {
                                            }
                                            d.o.a.e.b.c.a.i(F, "handleResponse: e = " + th);
                                            if (m()) {
                                            }
                                        }
                                    } catch (BaseException e9) {
                                        e = e9;
                                        j = nanoTime;
                                    }
                                }
                                if (z) {
                                    j6 = System.nanoTime();
                                }
                                try {
                                    this.f66497h.a(a3.f66524a, i5, i6);
                                    if (z) {
                                        this.A += System.nanoTime() - j6;
                                    }
                                    bVar2.a(a3);
                                    long j9 = i6;
                                    this.m += j9;
                                    j7 += j9;
                                    synchronized (this.l) {
                                        if (this.q) {
                                            if (!this.k) {
                                                boolean b2 = this.l.b(j9);
                                                f(this.f66495f);
                                                g(b2);
                                            }
                                        } else {
                                            boolean b3 = this.l.b(j9);
                                            f(this.f66495f);
                                            g(b3);
                                        }
                                    }
                                    if (this.f66490a.n1()) {
                                        if (this.f66490a.M1()) {
                                            if (this.f66490a.y1() || this.p < 0 || this.p > this.m - this.n) {
                                                y = 0;
                                                z4 = false;
                                                i2 = 1;
                                                try {
                                                    if (this.y && j7 > j5) {
                                                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                                        if (currentTimeMillis2 < j4) {
                                                            try {
                                                                Thread.sleep(j4 - currentTimeMillis2);
                                                            } catch (InterruptedException e10) {
                                                                e10.printStackTrace();
                                                            }
                                                        }
                                                        j7 = 0;
                                                        currentTimeMillis = System.currentTimeMillis();
                                                    }
                                                    z6 = z5;
                                                    nanoTime = j;
                                                    z5 = z;
                                                    j8 = j2;
                                                    i3 = -1;
                                                    i5 = 0;
                                                    i4 = 1;
                                                } catch (BaseException e11) {
                                                    e = e11;
                                                    bVar = bVar2;
                                                    y = z4;
                                                    d.o.a.e.b.c.a.i(F, "handleResponse: BaseException e = " + e);
                                                    if (!this.r.l("ignore_base_ex_on_stop_status")) {
                                                    }
                                                    if (d.o.a.e.b.c.a.e()) {
                                                    }
                                                    this.f66498i = e;
                                                    throw e;
                                                } catch (Throwable th11) {
                                                    th = th11;
                                                    if (z5) {
                                                    }
                                                    d.o.a.e.b.c.a.i(F, "handleResponse: e = " + th);
                                                    if (m()) {
                                                    }
                                                }
                                            }
                                        } else {
                                            throw new com.ss.android.socialbase.downloader.exception.e();
                                        }
                                    } else {
                                        throw new com.ss.android.socialbase.downloader.exception.c();
                                    }
                                } catch (BaseException e12) {
                                    e = e12;
                                    z4 = false;
                                    i2 = 1;
                                    bVar = bVar2;
                                    y = z4;
                                    d.o.a.e.b.c.a.i(F, "handleResponse: BaseException e = " + e);
                                    if (!this.r.l("ignore_base_ex_on_stop_status")) {
                                    }
                                    if (d.o.a.e.b.c.a.e()) {
                                    }
                                    this.f66498i = e;
                                    throw e;
                                }
                            }
                            d.o.a.e.b.o.k kVar5 = this.f66493d;
                            if (kVar5 != null) {
                                kVar5.d();
                            }
                            if (bVar2 != null) {
                                bVar2.b();
                            }
                            try {
                                if (this.q) {
                                    synchronized (this.l) {
                                        if (!this.k) {
                                            f(this.f66495f);
                                            if (this.f66497h != null) {
                                                o();
                                            }
                                        }
                                    }
                                } else {
                                    f(this.f66495f);
                                    if (this.f66497h != null) {
                                        o();
                                    }
                                }
                                Closeable[] closeableArr8 = new Closeable[1];
                                closeableArr8[i5] = this.f66497h;
                                d.o.a.e.b.l.e.C(closeableArr8);
                                this.C = System.nanoTime() - j;
                                d.o.a.e.b.e.a.f(this.r, this.f66490a, this.f66491b, this.f66493d, this.j, this.k, this.f66498i, this.m - this.n, this.C, z, this.z, this.A, this.B, null);
                                if (this.f66490a.y1()) {
                                    return;
                                }
                                long j10 = this.m - this.n;
                                if (j10 >= 0 && this.p >= 0 && this.p != j10) {
                                    throw new BaseException(1051, String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", Long.valueOf(j10), Long.valueOf(d2), Long.valueOf(this.p), Long.valueOf(j2), Long.valueOf(this.o), Long.valueOf(this.m), Long.valueOf(this.n)));
                                }
                                return;
                            } catch (Throwable th12) {
                                d.o.a.e.b.l.e.C(this.f66497h);
                                throw th12;
                            }
                        } catch (BaseException e13) {
                            e = e13;
                            j = nanoTime;
                        }
                    }
                    d.o.a.e.b.o.k kVar6 = this.f66493d;
                    if (kVar6 != null) {
                        kVar6.d();
                    }
                    if (bVar2 != null) {
                        bVar2.b();
                    }
                    try {
                        if (this.q) {
                            synchronized (this.l) {
                                if (!this.k) {
                                    f(this.f66495f);
                                    if (this.f66497h != null) {
                                        o();
                                    }
                                }
                            }
                        } else {
                            f(this.f66495f);
                            if (this.f66497h != null) {
                                o();
                            }
                        }
                        Closeable[] closeableArr9 = new Closeable[i4];
                        closeableArr9[i5] = this.f66497h;
                        d.o.a.e.b.l.e.C(closeableArr9);
                        this.C = System.nanoTime() - nanoTime;
                        aVar = this.r;
                        downloadInfo = this.f66490a;
                        str = this.f66491b;
                        kVar2 = this.f66493d;
                        z3 = this.j;
                        z = z5;
                        z2 = this.k;
                    } catch (Throwable th13) {
                        Closeable[] closeableArr10 = new Closeable[i4];
                        closeableArr10[i5] = this.f66497h;
                        d.o.a.e.b.l.e.C(closeableArr10);
                        throw th13;
                    }
                } catch (BaseException e14) {
                    e = e14;
                    j = nanoTime;
                    z = z5;
                } catch (Throwable th14) {
                    th = th14;
                    j = nanoTime;
                    z = z5;
                    y = 0;
                    i2 = 1;
                    z5 = z6;
                }
                d.o.a.e.b.e.a.f(aVar, downloadInfo, str, kVar2, z3, z2, this.f66498i, this.m - this.n, this.C, z, this.z, this.A, this.B, null);
                return;
            }
            throw new BaseException((int) SDKLogTypeConstants.LOCAL_THIRD_IMPRESSION_MONITOR, new IOException("inputStream is null"));
        }
        throw new com.ss.android.socialbase.downloader.exception.f(1004, "the content-length is 0");
    }

    public long l() {
        return this.D;
    }

    public final boolean m() {
        return this.j || this.k;
    }

    public final void n() {
        ExecutorService w0;
        if (this.f66493d == null || (w0 = d.w0()) == null) {
            return;
        }
        w0.execute(new a());
    }

    public final void o() {
        boolean z;
        long nanoTime = this.w ? System.nanoTime() : 0L;
        try {
            this.f66497h.n();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.f66490a.q3(true);
            boolean z2 = this.f66490a.B() > 1;
            m a2 = d.o.a.e.b.m.l.a(d.o.a.e.b.l.e.b0());
            if (z2) {
                f(this.f66496g);
                if (a2 != null) {
                    a2.c(this.f66490a);
                } else {
                    this.f66496g.a(this.f66490a.c0(), this.f66490a.E());
                }
            } else if (a2 != null) {
                a2.c(this.f66490a);
            } else {
                this.f66496g.a(this.f66492c.x(), this.m);
            }
            this.D = this.m;
        }
        if (this.w) {
            this.B += System.nanoTime() - nanoTime;
        }
    }
}
