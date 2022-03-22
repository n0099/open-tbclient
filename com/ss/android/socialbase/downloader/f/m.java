package com.ss.android.socialbase.downloader.f;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class m implements Runnable {
    public Thread A;
    public volatile boolean B;
    public int C;
    public int D;
    public int E;
    public long F;
    public int G;
    public boolean H;
    public BaseException I;
    public boolean J;
    public boolean K;
    public com.ss.android.socialbase.downloader.i.e L;
    public volatile i a;

    /* renamed from: b  reason: collision with root package name */
    public q f43318b;

    /* renamed from: c  reason: collision with root package name */
    public final int f43319c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f43320d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f43321e;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f43322f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f43323g;

    /* renamed from: h  reason: collision with root package name */
    public String f43324h;
    public String i;
    public String j;
    public final f k;
    public final c l;
    public final DownloadInfo m;
    public final com.ss.android.socialbase.downloader.g.a n;
    public com.ss.android.socialbase.downloader.network.i o;
    public com.ss.android.socialbase.downloader.model.d p;
    public long r;
    public volatile long s;
    public volatile long t;
    public volatile long v;
    public Future w;
    public volatile boolean x;
    public volatile boolean y;
    public volatile boolean z;
    public final List<i> q = new ArrayList();
    public volatile long u = -1;

    public m(DownloadInfo downloadInfo, k kVar, c cVar, q qVar, int i) {
        this.m = downloadInfo;
        this.k = kVar;
        this.l = cVar;
        this.n = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.f43318b = qVar;
        this.f43319c = i;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private boolean a(i iVar) throws BaseException {
        k();
        while (true) {
            try {
                b(iVar);
                d(iVar);
                return true;
            } catch (j e2) {
                this.I = e2;
                throw e2;
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "download: e = " + th + ", threadIndex = " + this.f43319c + ", reconnect = " + this.y + ", closed = " + this.x);
                    if (this.x) {
                        return false;
                    }
                    if (this.y) {
                        this.y = false;
                        Thread.interrupted();
                        if (this.z) {
                            this.z = false;
                            throw new j(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        BaseException e3 = null;
                        if (th instanceof BaseException) {
                            e3 = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.i.f.a((Throwable) th, "download");
                            } catch (BaseException e4) {
                                e3 = e4;
                            }
                        }
                        if (e3 == null || !a(iVar, e3)) {
                            return false;
                        }
                    }
                } finally {
                    i();
                }
            }
        }
        return false;
    }

    private void b(i iVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        c(iVar);
        this.k.a(this, iVar, this.f43318b, this.p);
        this.f43318b.c();
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    private void c(i iVar) throws BaseException {
        String str;
        String str2;
        com.ss.android.socialbase.downloader.network.i a;
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.f43321e = 0L;
                this.f43320d = currentTimeMillis;
                this.r = iVar.e();
                this.t = iVar.f();
                if (this.t > 0 && this.r > this.t) {
                    throw new j(6, "createConn, " + iVar);
                }
                this.L = new com.ss.android.socialbase.downloader.i.e();
                List<com.ss.android.socialbase.downloader.model.c> a2 = com.ss.android.socialbase.downloader.i.f.a(this.m.getExtraHeaders(), this.m.geteTag(), this.r, this.t);
                a2.add(new com.ss.android.socialbase.downloader.model.c("Segment-Index", String.valueOf(iVar.g())));
                a2.add(new com.ss.android.socialbase.downloader.model.c("Thread-Index", String.valueOf(this.f43319c)));
                com.ss.android.socialbase.downloader.i.f.a(a2, this.m);
                com.ss.android.socialbase.downloader.i.f.b(a2, this.m);
                str = this.f43318b.a;
                if (this.H && !TextUtils.isEmpty(str) && str.startsWith("https")) {
                    str = str.replaceFirst("https", "http");
                }
                str2 = this.f43318b.f43326b;
                com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + iVar + ", threadIndex = " + this.f43319c);
                this.f43324h = str;
                this.i = str2;
                a = com.ss.android.socialbase.downloader.downloader.c.a(this.m.isNeedDefaultHttpServiceBackUp(), this.m.getMaxBytes(), str, str2, a2, 0, currentTimeMillis - this.F > 3000 && this.n.b("monitor_download_connect") > 0, this.m);
            } finally {
                this.f43321e = System.currentTimeMillis();
            }
        } catch (BaseException e2) {
            throw e2;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.i.f.a(th, "createConn");
        }
        if (a != null) {
            this.o = a;
            this.p = new com.ss.android.socialbase.downloader.model.d(str, a);
            if (!this.x) {
                if (a instanceof com.ss.android.socialbase.downloader.network.a) {
                    this.j = ((com.ss.android.socialbase.downloader.network.a) a).e();
                }
                Log.i("SegmentReader", "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.j + ", threadIndex = " + this.f43319c);
                return;
            }
            throw new p("createConn");
        }
        throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x012c, code lost:
        r7 = r11 + 1;
        r11 = r13 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0136, code lost:
        if (r11 <= 0) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0138, code lost:
        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: redundant = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014e, code lost:
        r31.u = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0151, code lost:
        r13 = r7;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0155, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x015e, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0166, code lost:
        throw new com.ss.android.socialbase.downloader.f.p("loopAndRead");
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01c2, code lost:
        r6 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03a8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x015c -> B:78:0x015d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(i iVar) throws BaseException {
        long j;
        e eVar;
        InputStream inputStream;
        a aVar;
        a aVar2;
        a aVar3;
        f fVar;
        long f2;
        int i;
        long j2;
        long j3;
        a aVar4;
        int i2;
        a aVar5;
        int i3;
        i iVar2 = iVar;
        c cVar = this.l;
        this.f43322f = System.currentTimeMillis();
        long e2 = iVar.e();
        boolean z = false;
        try {
            try {
                inputStream = this.o.a();
                try {
                } catch (BaseException e3) {
                    e = e3;
                } catch (Throwable th) {
                    th = th;
                    j = e2;
                    eVar = null;
                }
            } catch (Throwable th2) {
                com.ss.android.socialbase.downloader.i.f.a(inputStream);
                if (eVar != null) {
                    if (aVar == null) {
                        try {
                            aVar = cVar.b();
                        } catch (Throwable unused) {
                            aVar2 = aVar;
                            if (aVar2 != null) {
                            }
                            this.f43323g = System.currentTimeMillis();
                            if (j > e2) {
                            }
                            this.k.c(this, iVar2);
                            throw th2;
                        }
                    }
                    aVar.f43284c = -1;
                    eVar.b(aVar);
                    aVar2 = null;
                    if (aVar2 != null) {
                        cVar.a(aVar2);
                    }
                    this.f43323g = System.currentTimeMillis();
                    if (j > e2) {
                        com.ss.android.socialbase.downloader.d.a.a(this.n, this.m, this.f43324h, this.i, this.j, this.x || this.y, this.o, this.I, j - e2, TimeUnit.MILLISECONDS.toNanos(this.f43323g - this.f43322f));
                    }
                    this.k.c(this, iVar2);
                    throw th2;
                }
                aVar2 = aVar;
                if (aVar2 != null) {
                }
                this.f43323g = System.currentTimeMillis();
                if (j > e2) {
                }
                this.k.c(this, iVar2);
                throw th2;
            }
        } catch (BaseException e4) {
            e = e4;
        } catch (Throwable th3) {
            th = th3;
            j = e2;
            eVar = null;
            inputStream = null;
        }
        if (inputStream != null) {
            long h2 = this.p.h();
            int i4 = (h2 > 0L ? 1 : (h2 == 0L ? 0 : -1));
            if (i4 != 0) {
                aVar = a(cVar, inputStream);
                try {
                } catch (BaseException e5) {
                    e = e5;
                } catch (Throwable th4) {
                    th = th4;
                    j = e2;
                    eVar = null;
                }
                if (!this.y && !this.x) {
                    this.k.b(this, iVar2);
                    eVar = this.k.d(this, iVar2);
                    try {
                        f2 = iVar.f();
                        if (f2 <= 0) {
                            f2 = i4 > 0 ? (h2 + e2) - 1 : Long.MAX_VALUE;
                        }
                        i = aVar.f43284c;
                        j2 = i;
                        j = e2 + j2;
                        try {
                        } catch (BaseException e6) {
                            e = e6;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (BaseException e7) {
                        e = e7;
                    } catch (Throwable th6) {
                        th = th6;
                        j = e2;
                    }
                    if (j > f2) {
                        long j4 = f2 + 1;
                        if (j > j4 && (i3 = (int) (j2 - (j - j4))) > 0 && i3 < i) {
                            aVar.f43284c = i3;
                            j = j4;
                        }
                        this.u = j;
                        eVar.b(aVar);
                        com.ss.android.socialbase.downloader.i.f.a(inputStream);
                        if (eVar != null) {
                            try {
                                a b2 = cVar.b();
                                try {
                                    b2.f43284c = -1;
                                    eVar.b(b2);
                                } catch (Throwable unused2) {
                                    aVar5 = b2;
                                }
                            } catch (Throwable unused3) {
                            }
                        }
                        aVar5 = null;
                        if (aVar5 != null) {
                            cVar.a(aVar5);
                        }
                        this.f43323g = System.currentTimeMillis();
                        if (j > e2) {
                            com.ss.android.socialbase.downloader.d.a.a(this.n, this.m, this.f43324h, this.i, this.j, this.x || this.y, this.o, this.I, j - e2, TimeUnit.MILLISECONDS.toNanos(this.f43323g - this.f43322f));
                        }
                        this.k.c(this, iVar2);
                        return;
                    }
                    this.u = j;
                    eVar.b(aVar);
                    long j5 = f2;
                    while (true) {
                        try {
                            if (this.B) {
                                try {
                                    synchronized (this) {
                                        this.B = z;
                                        if (this.y || this.x) {
                                            break;
                                        }
                                    }
                                    synchronized (this.k) {
                                        try {
                                            if (this.s != 0) {
                                                com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "loopAndRead:  change readEnd = " + j5 + ", segmentNewEndOffset = " + this.s + ", segment = " + iVar2);
                                                j5 = m();
                                                if (j > j5) {
                                                    break;
                                                }
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                        }
                                    }
                                } catch (BaseException e8) {
                                    e = e8;
                                    this.I = e;
                                    throw e;
                                } catch (Throwable th8) {
                                    th = th8;
                                    iVar2 = iVar;
                                    aVar = null;
                                    com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                    th.printStackTrace();
                                    try {
                                        com.ss.android.socialbase.downloader.i.f.a(th, "loopAndRead");
                                        com.ss.android.socialbase.downloader.i.f.a(inputStream);
                                        if (eVar != null) {
                                            if (aVar == null) {
                                                try {
                                                    aVar = cVar.b();
                                                } catch (Throwable unused4) {
                                                    aVar3 = aVar;
                                                    if (aVar3 != null) {
                                                        cVar.a(aVar3);
                                                    }
                                                    this.f43323g = System.currentTimeMillis();
                                                    if (j > e2) {
                                                        com.ss.android.socialbase.downloader.d.a.a(this.n, this.m, this.f43324h, this.i, this.j, this.x || this.y, this.o, this.I, j - e2, TimeUnit.MILLISECONDS.toNanos(this.f43323g - this.f43322f));
                                                    }
                                                    fVar = this.k;
                                                    fVar.c(this, iVar2);
                                                    return;
                                                }
                                            }
                                            aVar.f43284c = -1;
                                            eVar.b(aVar);
                                            aVar3 = null;
                                            if (aVar3 != null) {
                                            }
                                            this.f43323g = System.currentTimeMillis();
                                            if (j > e2) {
                                            }
                                            fVar = this.k;
                                            fVar.c(this, iVar2);
                                            return;
                                        }
                                        aVar3 = aVar;
                                        if (aVar3 != null) {
                                        }
                                        this.f43323g = System.currentTimeMillis();
                                        if (j > e2) {
                                        }
                                        fVar = this.k;
                                        fVar.c(this, iVar2);
                                        return;
                                    } catch (BaseException e9) {
                                        this.I = e9;
                                        throw e9;
                                    }
                                }
                            }
                            aVar = cVar.b();
                        } catch (BaseException e10) {
                            e = e10;
                        } catch (Throwable th9) {
                            th = th9;
                        }
                        try {
                            int read = inputStream.read(aVar.a);
                            aVar.f43284c = read;
                            if (read == -1) {
                                eVar.b(aVar);
                                j3 = 0;
                                eVar = null;
                                break;
                            }
                            long j6 = read;
                            j += j6;
                            if (j > j5) {
                                long j7 = j5 + 1;
                                if (j > j7 && (i2 = (int) (j6 - (j - j7))) > 0 && i2 < read) {
                                    aVar.f43284c = i2;
                                    j = j7;
                                }
                                this.u = j;
                                eVar.b(aVar);
                                com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "loopAndRead: bytesRead = " + (j - e2) + ", url = " + this.f43318b.a);
                            } else {
                                iVar2 = iVar;
                                this.u = j;
                                eVar.b(aVar);
                                z = false;
                            }
                        } catch (BaseException e11) {
                            e = e11;
                            this.I = e;
                            throw e;
                        } catch (Throwable th10) {
                            th = th10;
                            iVar2 = iVar;
                            com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                            th.printStackTrace();
                            com.ss.android.socialbase.downloader.i.f.a(th, "loopAndRead");
                            com.ss.android.socialbase.downloader.i.f.a(inputStream);
                            if (eVar != null) {
                            }
                            aVar3 = aVar;
                            if (aVar3 != null) {
                            }
                            this.f43323g = System.currentTimeMillis();
                            if (j > e2) {
                            }
                            fVar = this.k;
                            fVar.c(this, iVar2);
                            return;
                        }
                    }
                    if (j5 > j3 && j5 != Long.MAX_VALUE && j <= j5) {
                        throw new BaseException(1051, String.format("range[%d, %d] , but readCurrent[%d] , readStart[%d]", Long.valueOf(e2), Long.valueOf(j5), Long.valueOf(j), Long.valueOf(e2)));
                    }
                    com.ss.android.socialbase.downloader.i.f.a(inputStream);
                    if (eVar != null) {
                        try {
                            a b3 = cVar.b();
                            try {
                                b3.f43284c = -1;
                                eVar.b(b3);
                            } catch (Throwable unused5) {
                                aVar4 = b3;
                            }
                        } catch (Throwable unused6) {
                        }
                    }
                    aVar4 = null;
                    if (aVar4 != null) {
                        cVar.a(aVar4);
                    }
                    this.f43323g = System.currentTimeMillis();
                    if (j > e2) {
                        com.ss.android.socialbase.downloader.d.a.a(this.n, this.m, this.f43324h, this.i, this.j, this.x || this.y, this.o, this.I, j - e2, TimeUnit.MILLISECONDS.toNanos(this.f43323g - this.f43322f));
                    }
                    fVar = this.k;
                    iVar2 = iVar;
                    fVar.c(this, iVar2);
                    return;
                }
                throw new p("probe");
            }
            throw new com.ss.android.socialbase.downloader.exception.f(1004, "the content-length is 0, contentLength = " + h2);
        }
        throw new BaseException(1042, new IOException("inputStream is null"));
    }

    private void i() {
        this.F = this.f43320d;
        this.f43320d = -1L;
        this.f43321e = -1L;
        this.f43322f = -1L;
        this.f43323g = -1L;
        j();
    }

    private void j() {
        com.ss.android.socialbase.downloader.network.i iVar = this.o;
        if (iVar != null) {
            try {
                com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "closeConnection: thread = " + this.f43319c);
                iVar.d();
                iVar.c();
            } catch (Throwable unused) {
            }
        }
    }

    private void k() {
        this.H = false;
        l();
    }

    private void l() {
        this.D = this.f43318b.f43328d ? this.m.getRetryCount() : this.m.getBackUpUrlRetryCount();
        this.E = 0;
    }

    private long m() {
        long j = this.s;
        this.s = 0L;
        if (j <= 0) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    public void e() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "close: threadIndex = " + this.f43319c);
        synchronized (this) {
            this.x = true;
            this.B = true;
        }
        j();
        Future future = this.w;
        if (future != null) {
            this.w = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void f() {
        a(false);
    }

    public boolean g() {
        return this.J;
    }

    public long h() {
        return this.r;
    }

    /* JADX DEBUG: Null dom frontier in handler: all -> 0x00fd */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
        r6.a = null;
        r2 = r6.k;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        i a;
        f fVar;
        f fVar2;
        Process.setThreadPriority(10);
        try {
            this.A = Thread.currentThread();
            this.k.a(this);
            this.f43318b.a(this);
            while (true) {
                a = this.k.a(this, this.f43318b);
                if (a == null) {
                    com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "no more segment, thread_index = " + this.f43319c);
                    break;
                }
                this.a = a;
                try {
                } catch (j e2) {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "run: SegmentApplyException, e = " + e2);
                    if (this.C >= 50) {
                        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "segment apply failed " + this.C + "times, thread_index = " + this.f43319c);
                        this.a = null;
                        fVar = this.k;
                        break;
                    }
                    this.C++;
                    this.a = null;
                    fVar2 = this.k;
                }
                if (a(a)) {
                    this.q.add(a);
                    this.a = null;
                    fVar2 = this.k;
                    fVar2.a(this, a);
                } else if (!this.x) {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "download segment failed, segment = " + a + ", thread_index = " + this.f43319c + ", failedException = " + this.I);
                    break;
                } else {
                    break;
                }
            }
            fVar.a(this, a);
            this.f43318b.b(this);
            this.k.b(this);
        } catch (Throwable unused) {
        }
        this.A = null;
    }

    public long b() {
        long c2;
        synchronized (this.k) {
            c2 = this.v + c();
        }
        return c2;
    }

    public void b(boolean z) {
        this.J = z;
    }

    public void b(long j) {
        long j2 = this.u;
        com.ss.android.socialbase.downloader.i.e eVar = this.L;
        if (j2 < 0 || eVar == null) {
            return;
        }
        Log.i("SegmentReader", "markProgress: curSegmentReadOffset = " + j2 + ", threadIndex = " + this.f43319c);
        eVar.a(j2, j);
    }

    public boolean a(q qVar) {
        int i = this.G;
        if (i >= 30) {
            return false;
        }
        this.G = i + 1;
        q qVar2 = this.f43318b;
        if (qVar2 != null) {
            qVar2.b(this);
        }
        qVar.a(this);
        this.f43318b = qVar;
        l();
        return true;
    }

    private boolean a(i iVar, BaseException baseException) {
        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.E + ", retryCount = " + this.D);
        this.I = baseException;
        this.f43318b.b();
        this.k.a(this, this.f43318b, iVar, baseException, this.E, this.D);
        int i = this.E;
        if (i < this.D) {
            this.E = i + 1;
            return true;
        } else if (a(baseException)) {
            return true;
        } else {
            this.k.a(this, this.f43318b, iVar, baseException);
            return false;
        }
    }

    public long c() {
        synchronized (this.k) {
            long j = this.u;
            long j2 = this.r;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    private boolean a(BaseException baseException) {
        if (com.ss.android.socialbase.downloader.i.f.c(baseException)) {
            String str = this.f43318b.a;
            if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.m.isNeedHttpsToHttpRetry() || this.H) {
                return false;
            }
            this.H = true;
            l();
            return true;
        }
        return false;
    }

    public void c(boolean z) {
        this.K = z;
    }

    private a a(c cVar, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        int i;
        a b2 = cVar.b();
        try {
            i = inputStream.read(b2.a);
        } catch (Throwable th) {
            th = th;
            i = -1;
        }
        try {
            if (i != -1) {
                b2.f43284c = i;
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

    public boolean a(long j) {
        long j2 = this.t;
        if (j > 0 || j2 <= 0) {
            if (j <= j2 || j2 <= 0) {
                this.s = j;
                this.B = true;
                return true;
            }
            return false;
        }
        return false;
    }

    public void a() {
        q qVar = this.f43318b;
        try {
            synchronized (this.k) {
                long c2 = c();
                if (c2 > 0) {
                    this.v += c2;
                    qVar.a(c2);
                }
                this.u = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "reconnect: threadIndex = " + this.f43319c);
        synchronized (this) {
            this.z = z;
            this.y = true;
            this.B = true;
        }
        j();
        Thread thread = this.A;
        if (thread != null) {
            try {
                Log.i("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.f43319c);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Future future) {
        this.w = future;
    }

    public long a(long j, long j2) {
        com.ss.android.socialbase.downloader.i.e eVar = this.L;
        if (eVar == null) {
            return -1L;
        }
        return eVar.b(j, j2);
    }

    public long d() {
        return this.u;
    }
}
