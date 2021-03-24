package d.o.a.e.b.i;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class l implements Runnable {
    public int A;
    public long B;
    public int C;
    public boolean D;
    public BaseException E;
    public boolean F;
    public d.o.a.e.b.l.d G;
    public volatile long H;
    public volatile long I;
    public volatile long J;
    public volatile long K;
    public String L;
    public String M;
    public String N;

    /* renamed from: e  reason: collision with root package name */
    public final f f67060e;

    /* renamed from: f  reason: collision with root package name */
    public final c f67061f;

    /* renamed from: g  reason: collision with root package name */
    public final DownloadInfo f67062g;

    /* renamed from: h  reason: collision with root package name */
    public final d.o.a.e.b.j.a f67063h;
    public d.o.a.e.b.o.k i;
    public d.o.a.e.b.n.b j;
    public o l;
    public long m;
    public volatile long n;
    public volatile long o;
    public volatile long q;
    public Future r;
    public volatile boolean s;
    public volatile boolean t;
    public volatile boolean u;
    public Thread v;
    public final int w;
    public volatile boolean x;
    public int y;
    public int z;
    public final List<i> k = new ArrayList();
    public volatile long p = -1;

    public l(DownloadInfo downloadInfo, j jVar, c cVar, o oVar, int i) {
        this.f67062g = downloadInfo;
        this.f67060e = jVar;
        this.f67061f = cVar;
        this.f67063h = d.o.a.e.b.j.a.d(downloadInfo.c0());
        this.l = oVar;
        this.w = i;
    }

    public final void A() {
        this.D = false;
        B();
    }

    public final void B() {
        this.z = this.l.f67069d ? this.f67062g.B0() : this.f67062g.v();
        this.A = 0;
    }

    public final long C() {
        long j = this.n;
        this.n = 0L;
        if (j <= 0) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    public long a(long j, long j2) {
        d.o.a.e.b.l.d dVar = this.G;
        if (dVar == null) {
            return -1L;
        }
        return dVar.d(j, j2);
    }

    public final a b(c cVar, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        int i;
        a b2 = cVar.b();
        try {
            i = inputStream.read(b2.f67017a, 0, Math.min(b2.f67017a.length, 1024));
        } catch (Throwable th) {
            th = th;
            i = -1;
        }
        try {
            if (i != -1) {
                b2.f67019c = i;
                if (i == -1) {
                    cVar.a(b2);
                }
                return b2;
            }
            throw new BaseException(1073, "probe");
        } catch (Throwable th2) {
            th = th2;
            if (i == -1) {
                cVar.a(b2);
            }
            throw th;
        }
    }

    public void c() {
        o oVar = this.l;
        try {
            synchronized (this.f67060e) {
                long p = p();
                if (p > 0) {
                    this.q += p;
                    oVar.c(p);
                }
                this.p = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public final void d(i iVar, d.o.a.e.b.n.b bVar) throws BaseException {
        if (bVar.b()) {
            return;
        }
        if (iVar.i() <= 0) {
            d.o.a.e.b.c.a.j("SegmentReader", "parseHttpResponse: segment.getCurrentOffset = " + iVar.i());
            if (bVar.a()) {
                return;
            }
            int i = bVar.f67196c;
            throw new com.ss.android.socialbase.downloader.exception.b(1004, i, "2: response code error : " + bVar.f67196c + " segment=" + iVar);
        }
        int i2 = bVar.f67196c;
        throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "1: response code error : " + bVar.f67196c + " segment=" + iVar);
    }

    public void e(Future future) {
        this.r = future;
    }

    public void f(boolean z) {
        d.o.a.e.b.c.a.h("SegmentReader", "reconnect: threadIndex = " + this.w);
        synchronized (this) {
            this.u = z;
            this.t = true;
            this.x = true;
        }
        z();
        Thread thread = this.v;
        if (thread != null) {
            try {
                Log.i("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.w);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    public boolean g(long j) {
        long j2 = this.o;
        if (j > 0 || j2 <= 0) {
            if (j <= j2 || j2 <= 0) {
                this.n = j;
                this.x = true;
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean h(BaseException baseException) {
        if (d.o.a.e.b.l.e.q0(baseException)) {
            String str = this.l.f67066a;
            if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.f67062g.B1() || this.D) {
                return false;
            }
            this.D = true;
            B();
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public final boolean i(i iVar) throws BaseException {
        A();
        while (true) {
            try {
                n(iVar);
                t(iVar);
                return true;
            } catch (com.ss.android.socialbase.downloader.f.j e2) {
                this.E = e2;
                throw e2;
            } catch (Throwable th) {
                try {
                    d.o.a.e.b.c.a.j("SegmentReader", "download: e = " + th + ", threadIndex = " + this.w + ", reconnect = " + this.t + ", closed = " + this.s);
                    if (this.s) {
                        return false;
                    }
                    if (this.t) {
                        this.t = false;
                        Thread.interrupted();
                        if (this.u) {
                            this.u = false;
                            throw new com.ss.android.socialbase.downloader.f.j(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        if (th instanceof BaseException) {
                            e = th;
                        } else {
                            try {
                                d.o.a.e.b.l.e.A(th, "download");
                                throw null;
                            } catch (BaseException e3) {
                                e = e3;
                                if (e == null || !j(iVar, e)) {
                                    return false;
                                }
                            }
                        }
                        if (e == null) {
                            break;
                        }
                        break;
                        return false;
                    }
                } finally {
                    y();
                }
            }
        }
        return false;
    }

    public final boolean j(i iVar, BaseException baseException) {
        d.o.a.e.b.c.a.j("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.A + ", retryCount = " + this.z);
        this.E = baseException;
        this.l.e();
        this.f67060e.c(this, this.l, iVar, baseException, this.A, this.z);
        int i = this.A;
        if (i < this.z) {
            this.A = i + 1;
            return true;
        } else if (h(baseException)) {
            return true;
        } else {
            this.f67060e.i(this, this.l, iVar, baseException);
            return false;
        }
    }

    public boolean k(o oVar) {
        int i = this.C;
        if (i >= 30) {
            return false;
        }
        this.C = i + 1;
        o oVar2 = this.l;
        if (oVar2 != null) {
            oVar2.f(this);
        }
        oVar.d(this);
        this.l = oVar;
        B();
        return true;
    }

    public long l() {
        long p;
        synchronized (this.f67060e) {
            p = this.q + p();
        }
        return p;
    }

    public void m(long j) {
        long j2 = this.p;
        d.o.a.e.b.l.d dVar = this.G;
        if (j2 < 0 || dVar == null) {
            return;
        }
        Log.i("SegmentReader", "markProgress: curSegmentReadOffset = " + j2 + ", threadIndex = " + this.w);
        dVar.c(j2, j);
    }

    public final void n(i iVar) throws BaseException, com.ss.android.socialbase.downloader.exception.h {
        q(iVar);
        d(iVar, this.j);
        this.f67060e.d(this, iVar, this.l, this.j);
        this.l.g();
    }

    public void o(boolean z) {
        this.F = z;
    }

    public long p() {
        synchronized (this.f67060e) {
            long j = this.p;
            long j2 = this.m;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    public final void q(i iVar) throws BaseException {
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.I = 0L;
                this.H = currentTimeMillis;
                this.m = iVar.i();
                this.o = iVar.l();
                this.p = this.m;
                this.G = new d.o.a.e.b.l.d();
                List<com.ss.android.socialbase.downloader.model.c> q = d.o.a.e.b.l.e.q(this.f67062g.S(), this.f67062g.U0(), this.m, this.o);
                q.add(new com.ss.android.socialbase.downloader.model.c("Segment-Index", String.valueOf(iVar.m())));
                q.add(new com.ss.android.socialbase.downloader.model.c("Thread-Index", String.valueOf(this.w)));
                d.o.a.e.b.l.e.B(q, this.f67062g);
                String str = this.l.f67066a;
                if (this.D && !TextUtils.isEmpty(str) && str.startsWith("https")) {
                    str = str.replaceFirst("https", "http");
                }
                String str2 = this.l.f67067b;
                d.o.a.e.b.c.a.h("SegmentReader", "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + iVar + ", threadIndex = " + this.w);
                this.L = str;
                this.M = str2;
                d.o.a.e.b.o.k w = d.o.a.e.b.g.d.w(this.f67062g.A1(), this.f67062g.j0(), str, str2, q, 0, currentTimeMillis - this.B > 3000 && this.f67063h.m("monitor_download_connect") > 0, this.f67062g);
                if (w != null) {
                    this.i = w;
                    this.j = new d.o.a.e.b.n.b(str, w);
                    if (!this.s) {
                        if (w instanceof d.o.a.e.b.o.c) {
                            this.N = ((d.o.a.e.b.o.c) w).e();
                        }
                        Log.i("SegmentReader", "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.N + ", threadIndex = " + this.w);
                        this.I = System.currentTimeMillis();
                        return;
                    }
                    throw new p("createConn");
                }
                throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
            } catch (BaseException e2) {
                throw e2;
            }
        }
    }

    public void r(boolean z) {
    }

    /* JADX DEBUG: Null dom frontier in handler: all -> 0x00da */
    @Override // java.lang.Runnable
    public void run() {
        i e2;
        f fVar;
        f fVar2;
        Process.setThreadPriority(10);
        try {
            this.v = Thread.currentThread();
            this.f67060e.a(this);
            this.l.d(this);
            while (true) {
                e2 = this.f67060e.e(this, this.l);
                if (e2 == null) {
                    d.o.a.e.b.c.a.h("SegmentReader", "no more segment, thread_index = " + this.w);
                    break;
                }
                try {
                    try {
                    } catch (Throwable th) {
                        this.f67060e.g(this, e2);
                        throw th;
                    }
                } catch (com.ss.android.socialbase.downloader.f.j unused) {
                    if (this.y >= 50) {
                        d.o.a.e.b.c.a.j("SegmentReader", "segment apply failed " + this.y + "times, thread_index = " + this.w);
                        fVar = this.f67060e;
                        break;
                    }
                    this.y++;
                    fVar2 = this.f67060e;
                }
                if (i(e2)) {
                    this.k.add(e2);
                    fVar2 = this.f67060e;
                    fVar2.g(this, e2);
                } else if (!this.s) {
                    d.o.a.e.b.c.a.j("SegmentReader", "download segment failed, segment = " + e2 + ", thread_index = " + this.w + ", failedException = " + this.E);
                    break;
                } else {
                    break;
                }
            }
            fVar = this.f67060e;
            fVar.g(this, e2);
            this.l.f(this);
            this.f67060e.b(this);
        } catch (Throwable unused2) {
        }
        this.v = null;
    }

    public long s() {
        return this.p;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:209:0x0319 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:242:0x0300 */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x015b, code lost:
        r15.f67019c = (int) (r6 - (r13 - r21));
        r13 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x015f, code lost:
        r31.p = r13;
        r8.b(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0164, code lost:
        r6 = new java.lang.StringBuilder();
        r6.append("loopAndRead: bytesRead = ");
        r29 = r11;
        r6.append(r13 - r4);
        r6.append(", url = ");
        r6.append(r31.l.f67066a);
        d.o.a.e.b.c.a.h("SegmentReader", r6.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x018a, code lost:
        r9 = r8;
        r23 = r13;
        r6 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0228, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0229, code lost:
        r9 = r8;
        r23 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x022e, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0253, code lost:
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ce, code lost:
        r11 = r6 + 1;
        r26 = r9;
        r8 = r23 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d6, code lost:
        if (r8 <= r13) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d8, code lost:
        d.o.a.e.b.c.a.j("SegmentReader", "loopAndRead: redundant = " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ee, code lost:
        r31.p = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f0, code lost:
        r23 = r11;
        r9 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f5, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f6, code lost:
        r23 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f9, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x010a, code lost:
        throw new com.ss.android.socialbase.downloader.f.p("loopAndRead");
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0111, code lost:
        r9 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0137, code lost:
        r8 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0139, code lost:
        r8.b(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x013c, code lost:
        r6 = r11;
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0141, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0144, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0150, code lost:
        r21 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0154, code lost:
        if (r13 <= r21) goto L102;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x01e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0137 A[EDGE_INSN: B:282:0x0137->B:87:0x0137 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:283:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0147  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t(i iVar) throws BaseException {
        ?? r6;
        a aVar;
        a aVar2;
        long j;
        e eVar;
        InputStream inputStream;
        long l;
        long j2;
        e eVar2;
        long C;
        a aVar3;
        e eVar3;
        int read;
        e eVar4;
        long j3;
        long j4;
        c cVar = this.f67061f;
        this.J = System.currentTimeMillis();
        long i = iVar.i();
        boolean z = false;
        try {
            try {
                try {
                    try {
                        inputStream = this.i.a();
                        try {
                            if (inputStream != null) {
                                long h2 = this.j.h();
                                long j5 = 0;
                                if (h2 != 0) {
                                    aVar = b(cVar, inputStream);
                                    try {
                                        if (!this.t && !this.s) {
                                            this.f67060e.f(this, iVar);
                                            eVar = this.f67060e.j(this, iVar);
                                            try {
                                                if (iVar.l() > 0) {
                                                    try {
                                                        l = iVar.l();
                                                    } catch (BaseException e2) {
                                                        e = e2;
                                                        this.E = e;
                                                        throw e;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        j = i;
                                                        try {
                                                            r6 = "SegmentReader";
                                                            d.o.a.e.b.c.a.j("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                                            th.printStackTrace();
                                                            try {
                                                                r6 = "loopAndRead";
                                                                d.o.a.e.b.l.e.A(th, "loopAndRead");
                                                                throw null;
                                                            } catch (BaseException e3) {
                                                                this.E = e3;
                                                                throw e3;
                                                            }
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            r6 = 0;
                                                            this.f67060e.h(this, iVar);
                                                            d.o.a.e.b.l.e.C(inputStream);
                                                            if (eVar != null) {
                                                                if (aVar == null) {
                                                                    try {
                                                                        aVar = cVar.b();
                                                                    } catch (Throwable unused) {
                                                                        aVar2 = aVar;
                                                                        if (aVar2 != null) {
                                                                            cVar.a(aVar2);
                                                                        }
                                                                        this.K = System.currentTimeMillis();
                                                                        if (j > i) {
                                                                            d.o.a.e.b.e.a.g(this.f67063h, this.f67062g, this.L, this.M, this.N, this.s || this.t, this.i, this.E, j - i, TimeUnit.MILLISECONDS.toNanos(this.K - this.J));
                                                                        }
                                                                        throw th;
                                                                    }
                                                                }
                                                                aVar.f67019c = -1;
                                                                eVar.b(aVar);
                                                                aVar2 = r6;
                                                                if (aVar2 != null) {
                                                                }
                                                                this.K = System.currentTimeMillis();
                                                                if (j > i) {
                                                                }
                                                                throw th;
                                                            }
                                                            aVar2 = aVar;
                                                            if (aVar2 != null) {
                                                            }
                                                            this.K = System.currentTimeMillis();
                                                            if (j > i) {
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                } else {
                                                    l = h2 > 0 ? (h2 + i) - 1 : Long.MAX_VALUE;
                                                }
                                                long j6 = aVar.f67019c;
                                                j = i + j6;
                                                try {
                                                    if (j > l) {
                                                        long j7 = l + 1;
                                                        if (j > j7) {
                                                            try {
                                                                aVar.f67019c = (int) (j6 - (j - j7));
                                                                j2 = j7;
                                                                this.p = j2;
                                                                eVar.b(aVar);
                                                                j = j2;
                                                                while (true) {
                                                                    try {
                                                                        try {
                                                                            try {
                                                                                if (this.x) {
                                                                                    try {
                                                                                        try {
                                                                                            try {
                                                                                                synchronized (this) {
                                                                                                    try {
                                                                                                        this.x = z;
                                                                                                        if (this.t || this.s) {
                                                                                                            break;
                                                                                                        } else if (this.n != j5) {
                                                                                                            d.o.a.e.b.c.a.h("SegmentReader", "loopAndRead:  change readEnd = " + l + ", segmentNewEndOffset = " + this.n + ", segment = " + iVar);
                                                                                                            C = C();
                                                                                                            if (j > C) {
                                                                                                                break;
                                                                                                            }
                                                                                                            eVar2 = eVar;
                                                                                                            l = C;
                                                                                                            aVar = cVar.b();
                                                                                                            read = inputStream.read(aVar.f67017a);
                                                                                                            aVar.f67019c = read;
                                                                                                            if (read == -1) {
                                                                                                                break;
                                                                                                            }
                                                                                                            eVar4 = eVar2;
                                                                                                            long j8 = read;
                                                                                                            j3 = j + j8;
                                                                                                            if (j3 > l) {
                                                                                                                break;
                                                                                                            }
                                                                                                            j4 = l;
                                                                                                            try {
                                                                                                                this.p = j3;
                                                                                                                eVar4.b(aVar);
                                                                                                                eVar = eVar4;
                                                                                                                j = j3;
                                                                                                                z = false;
                                                                                                                j5 = 0;
                                                                                                                l = j4;
                                                                                                            } catch (BaseException e4) {
                                                                                                                e = e4;
                                                                                                                this.E = e;
                                                                                                                throw e;
                                                                                                            } catch (Throwable th3) {
                                                                                                                th = th3;
                                                                                                                eVar = eVar4;
                                                                                                                j = j3;
                                                                                                                r6 = "SegmentReader";
                                                                                                                d.o.a.e.b.c.a.j("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                                                                                                th.printStackTrace();
                                                                                                                r6 = "loopAndRead";
                                                                                                                d.o.a.e.b.l.e.A(th, "loopAndRead");
                                                                                                                throw null;
                                                                                                            }
                                                                                                        }
                                                                                                    } catch (Throwable th4) {
                                                                                                        th = th4;
                                                                                                        throw th;
                                                                                                    }
                                                                                                }
                                                                                            } catch (Throwable th5) {
                                                                                                th = th5;
                                                                                            }
                                                                                        } catch (BaseException e5) {
                                                                                            e = e5;
                                                                                        } catch (Throwable th6) {
                                                                                            th = th6;
                                                                                        }
                                                                                    } catch (BaseException e6) {
                                                                                        e = e6;
                                                                                        this.E = e;
                                                                                        throw e;
                                                                                    } catch (Throwable th7) {
                                                                                        th = th7;
                                                                                        aVar = null;
                                                                                        r6 = "SegmentReader";
                                                                                        d.o.a.e.b.c.a.j("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                                                                        th.printStackTrace();
                                                                                        r6 = "loopAndRead";
                                                                                        d.o.a.e.b.l.e.A(th, "loopAndRead");
                                                                                        throw null;
                                                                                    }
                                                                                }
                                                                                read = inputStream.read(aVar.f67017a);
                                                                                aVar.f67019c = read;
                                                                                if (read == -1) {
                                                                                }
                                                                            } catch (BaseException e7) {
                                                                                e = e7;
                                                                                eVar3 = eVar2;
                                                                            } catch (Throwable th8) {
                                                                                th = th8;
                                                                                eVar3 = eVar2;
                                                                            }
                                                                            aVar = cVar.b();
                                                                        } catch (BaseException e8) {
                                                                            e = e8;
                                                                        } catch (Throwable th9) {
                                                                            th = th9;
                                                                            eVar = eVar2;
                                                                        }
                                                                        eVar2 = eVar;
                                                                    } catch (BaseException e9) {
                                                                        e = e9;
                                                                    } catch (Throwable th10) {
                                                                        th = th10;
                                                                    }
                                                                }
                                                                if (C <= 0 && C != Long.MAX_VALUE && j <= C) {
                                                                    try {
                                                                        throw new BaseException(1051, String.format("range[%d, %d] , but readCurrent[%d] , readStart[%d]", Long.valueOf(i), Long.valueOf(C), Long.valueOf(j), Long.valueOf(i)));
                                                                    } catch (BaseException e10) {
                                                                        e = e10;
                                                                        this.E = e;
                                                                        throw e;
                                                                    } catch (Throwable th11) {
                                                                        th = th11;
                                                                        aVar = null;
                                                                        r6 = "SegmentReader";
                                                                        d.o.a.e.b.c.a.j("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                                                        th.printStackTrace();
                                                                        r6 = "loopAndRead";
                                                                        d.o.a.e.b.l.e.A(th, "loopAndRead");
                                                                        throw null;
                                                                    }
                                                                }
                                                                this.f67060e.h(this, iVar);
                                                                d.o.a.e.b.l.e.C(inputStream);
                                                                if (eVar != null) {
                                                                    try {
                                                                        a b2 = cVar.b();
                                                                        try {
                                                                            b2.f67019c = -1;
                                                                            eVar.b(b2);
                                                                        } catch (Throwable unused2) {
                                                                            aVar3 = b2;
                                                                        }
                                                                    } catch (Throwable unused3) {
                                                                    }
                                                                }
                                                                aVar3 = null;
                                                                if (aVar3 != null) {
                                                                    cVar.a(aVar3);
                                                                }
                                                                this.K = System.currentTimeMillis();
                                                                if (j <= i) {
                                                                    d.o.a.e.b.e.a.g(this.f67063h, this.f67062g, this.L, this.M, this.N, this.s || this.t, this.i, this.E, j - i, TimeUnit.MILLISECONDS.toNanos(this.K - this.J));
                                                                    return;
                                                                }
                                                                return;
                                                            } catch (BaseException e11) {
                                                                e = e11;
                                                                this.E = e;
                                                                throw e;
                                                            } catch (Throwable th12) {
                                                                th = th12;
                                                                r6 = "SegmentReader";
                                                                d.o.a.e.b.c.a.j("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                                                th.printStackTrace();
                                                                r6 = "loopAndRead";
                                                                d.o.a.e.b.l.e.A(th, "loopAndRead");
                                                                throw null;
                                                            }
                                                        }
                                                    }
                                                    this.p = j2;
                                                    eVar.b(aVar);
                                                    j = j2;
                                                    while (true) {
                                                        if (this.x) {
                                                        }
                                                        eVar2 = eVar;
                                                        aVar = cVar.b();
                                                        read = inputStream.read(aVar.f67017a);
                                                        aVar.f67019c = read;
                                                        if (read == -1) {
                                                        }
                                                        eVar = eVar4;
                                                        j = j3;
                                                        z = false;
                                                        j5 = 0;
                                                        l = j4;
                                                    }
                                                    if (C <= 0) {
                                                    }
                                                    this.f67060e.h(this, iVar);
                                                    d.o.a.e.b.l.e.C(inputStream);
                                                    if (eVar != null) {
                                                    }
                                                    aVar3 = null;
                                                    if (aVar3 != null) {
                                                    }
                                                    this.K = System.currentTimeMillis();
                                                    if (j <= i) {
                                                    }
                                                } catch (BaseException e12) {
                                                    e = e12;
                                                } catch (Throwable th13) {
                                                    th = th13;
                                                    j = j2;
                                                }
                                                j2 = j;
                                            } catch (BaseException e13) {
                                                e = e13;
                                            } catch (Throwable th14) {
                                                th = th14;
                                            }
                                        } else {
                                            throw new p("probe");
                                        }
                                    } catch (BaseException e14) {
                                        e = e14;
                                    } catch (Throwable th15) {
                                        th = th15;
                                        j = i;
                                        eVar = null;
                                    }
                                } else {
                                    throw new com.ss.android.socialbase.downloader.exception.f(1004, "the content-length is 0, contentLength = " + h2);
                                }
                            } else {
                                throw new BaseException(1042, new IOException("inputStream is null"));
                            }
                        } catch (BaseException e15) {
                            e = e15;
                        } catch (Throwable th16) {
                            th = th16;
                            j = i;
                            eVar = null;
                        }
                    } catch (BaseException e16) {
                        e = e16;
                    }
                } catch (BaseException e17) {
                    e = e17;
                }
            } catch (Throwable th17) {
                th = th17;
                j = i;
                eVar = null;
                inputStream = null;
            }
        } catch (Throwable th18) {
            th = th18;
            this.f67060e.h(this, iVar);
            d.o.a.e.b.l.e.C(inputStream);
            if (eVar != null) {
            }
            aVar2 = aVar;
            if (aVar2 != null) {
            }
            this.K = System.currentTimeMillis();
            if (j > i) {
            }
            throw th;
        }
    }

    public void u() {
        d.o.a.e.b.c.a.h("SegmentReader", "close: threadIndex = " + this.w);
        synchronized (this) {
            this.s = true;
            this.x = true;
        }
        z();
        Future future = this.r;
        if (future != null) {
            this.r = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void v() {
        f(false);
    }

    public boolean w() {
        return this.F;
    }

    public long x() {
        return this.m;
    }

    public final void y() {
        this.B = this.H;
        this.H = -1L;
        this.I = -1L;
        this.J = -1L;
        this.K = -1L;
        z();
    }

    public final void z() {
        d.o.a.e.b.o.k kVar = this.i;
        if (kVar != null) {
            try {
                d.o.a.e.b.c.a.h("SegmentReader", "closeConnection: thread = " + this.w);
                kVar.d();
                kVar.c();
            } catch (Throwable unused) {
            }
        }
    }
}
