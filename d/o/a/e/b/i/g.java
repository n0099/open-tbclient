package d.o.a.e.b.i;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f66539c;

    /* renamed from: e  reason: collision with root package name */
    public final d.o.a.e.b.j.a f66541e;

    /* renamed from: f  reason: collision with root package name */
    public final d.o.a.e.b.k.f f66542f;

    /* renamed from: g  reason: collision with root package name */
    public final c f66543g;

    /* renamed from: h  reason: collision with root package name */
    public BaseException f66544h;
    public final boolean m;
    public final long n;
    public final long o;
    public final boolean p;
    public long q;

    /* renamed from: a  reason: collision with root package name */
    public final List<k> f66537a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public final List<k> f66538b = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f66545i = false;
    public volatile boolean j = false;
    public volatile boolean k = false;
    public volatile long r = 0;
    public volatile long s = 0;

    /* renamed from: d  reason: collision with root package name */
    public final d.o.a.e.b.g.j f66540d = d.o.a.e.b.g.d.I0();
    public final d.o.a.e.b.a.a l = d.o.a.e.b.a.a.c();

    public g(DownloadInfo downloadInfo, d.o.a.e.b.k.f fVar, c cVar) {
        this.f66539c = downloadInfo;
        this.f66542f = fVar;
        this.f66543g = cVar;
        d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(downloadInfo.c0());
        this.f66541e = d2;
        boolean z = d2.b("sync_strategy", 0) == 1;
        this.m = z;
        if (z) {
            this.n = Math.max(this.f66541e.b("sync_interval_ms_fg", 5000), 500L);
            this.o = Math.max(this.f66541e.b("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.n = 0L;
            this.o = 0L;
        }
        this.p = this.f66541e.m("monitor_rw") == 1;
    }

    public void a() {
        this.k = true;
        this.f66545i = true;
    }

    public final void b(long j, boolean z) throws IOException {
        long j2 = j - this.s;
        if (this.m) {
            if (j2 > (this.l.j() ? this.n : this.o)) {
                k();
                this.s = j;
                return;
            }
            return;
        }
        long E = this.f66539c.E() - this.r;
        if (z || h(E, j2)) {
            k();
            this.s = j;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:177:0x0227, code lost:
        r3.b(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b8, code lost:
        if (r13 <= 0) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bb, code lost:
        r3.b(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f5 A[Catch: all -> 0x0360, TryCatch #0 {all -> 0x0360, blocks: (B:160:0x01f1, B:162:0x01f5, B:165:0x01fa, B:167:0x0200, B:168:0x0203, B:169:0x0219, B:173:0x0221, B:174:0x0223, B:215:0x02ac, B:217:0x02b6, B:219:0x02ba, B:258:0x033e, B:260:0x0344, B:261:0x0347, B:262:0x035f), top: B:309:0x0027, inners: #39 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0200 A[Catch: all -> 0x0360, TryCatch #0 {all -> 0x0360, blocks: (B:160:0x01f1, B:162:0x01f5, B:165:0x01fa, B:167:0x0200, B:168:0x0203, B:169:0x0219, B:173:0x0221, B:174:0x0223, B:215:0x02ac, B:217:0x02b6, B:219:0x02ba, B:258:0x033e, B:260:0x0344, B:261:0x0347, B:262:0x035f), top: B:309:0x0027, inners: #39 }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02b6 A[Catch: all -> 0x0360, TryCatch #0 {all -> 0x0360, blocks: (B:160:0x01f1, B:162:0x01f5, B:165:0x01fa, B:167:0x0200, B:168:0x0203, B:169:0x0219, B:173:0x0221, B:174:0x0223, B:215:0x02ac, B:217:0x02b6, B:219:0x02ba, B:258:0x033e, B:260:0x0344, B:261:0x0347, B:262:0x035f), top: B:309:0x0027, inners: #39 }] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0344 A[Catch: all -> 0x0360, TryCatch #0 {all -> 0x0360, blocks: (B:160:0x01f1, B:162:0x01f5, B:165:0x01fa, B:167:0x0200, B:168:0x0203, B:169:0x0219, B:173:0x0221, B:174:0x0223, B:215:0x02ac, B:217:0x02b6, B:219:0x02ba, B:258:0x033e, B:260:0x0344, B:261:0x0347, B:262:0x035f), top: B:309:0x0027, inners: #39 }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x024f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x039e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0230 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x02e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x037e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(d dVar) throws BaseException {
        DownloadInfo downloadInfo;
        long E;
        long nanoTime;
        boolean z;
        boolean z2;
        long j;
        long j2;
        long j3;
        long j4;
        Throwable th;
        int i2;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        Throwable th5;
        if (this.j || this.k) {
            return;
        }
        d.o.a.e.b.o.d.e();
        this.f66544h = null;
        downloadInfo = this.f66539c;
        d.o.a.e.b.k.f fVar = this.f66542f;
        c cVar = this.f66543g;
        E = downloadInfo.E();
        nanoTime = System.nanoTime();
        z = this.p;
        z2 = true;
        long j5 = 0;
        int i3 = 0;
        boolean z3 = false;
        try {
            try {
                downloadInfo.r3();
                long j6 = 0;
                long j7 = 0;
                long j8 = 0;
                int i4 = 0;
                while (true) {
                    if (z) {
                        try {
                            j6 = System.nanoTime();
                        } catch (p e2) {
                            e = e2;
                            i3 = i4;
                            j4 = j7;
                            try {
                                this.f66544h = e;
                                throw e;
                            } catch (Throwable th6) {
                                th = th6;
                                j2 = j5;
                                j = j4;
                                if (i3 > 0) {
                                }
                                if (!this.k) {
                                }
                                th4 = null;
                                synchronized (this) {
                                }
                            }
                        } catch (BaseException e3) {
                            e = e3;
                            j2 = j5;
                            i2 = i4;
                            j3 = j7;
                            if (!this.f66541e.l("ignore_base_ex_on_stop_status")) {
                            }
                            if (d.o.a.e.b.c.a.e()) {
                            }
                            d.o.a.e.b.c.a.i("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                            this.f66544h = e;
                            throw e;
                        } catch (Throwable th7) {
                            th = th7;
                            j2 = j5;
                            i3 = i4;
                            j = j7;
                            if (!this.j) {
                            }
                            if (!this.k) {
                            }
                            th2 = null;
                            synchronized (this) {
                            }
                        }
                    }
                    try {
                        a a2 = dVar.a();
                        if (z) {
                            j5 += System.nanoTime() - j6;
                        }
                        j2 = j5;
                        try {
                            int i5 = a2.f66526c;
                            if (i5 == -1) {
                                try {
                                    d(a2.f66525b);
                                    cVar.a(a2);
                                    j5 = j2;
                                } catch (p e4) {
                                    e = e4;
                                    i3 = i4;
                                    j4 = j7;
                                    j5 = j2;
                                    this.f66544h = e;
                                    throw e;
                                } catch (BaseException e5) {
                                    e = e5;
                                    i2 = i4;
                                    j3 = j7;
                                    if (!this.f66541e.l("ignore_base_ex_on_stop_status") && (this.j || this.k)) {
                                        if (i2 > 0) {
                                            try {
                                                fVar.b(i2);
                                            } catch (Throwable unused) {
                                            }
                                        }
                                        if (!this.k) {
                                            try {
                                                k();
                                            } catch (Throwable th8) {
                                                th3 = th8;
                                                d.o.a.e.b.c.a.i("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th3);
                                                synchronized (this) {
                                                    l(this.f66537a);
                                                    this.f66537a.clear();
                                                }
                                                d.o.a.e.b.e.a.f(this.f66541e, downloadInfo, downloadInfo.T0(), null, this.j, this.k, this.f66544h, downloadInfo.E() - E, System.nanoTime() - nanoTime, z, j2, j3, this.q, null);
                                                if (th3 != null) {
                                                    if (!this.j && !this.k && this.f66544h == null) {
                                                        z2 = false;
                                                    }
                                                    if (z2) {
                                                        return;
                                                    }
                                                    try {
                                                        d.o.a.e.b.l.e.A(th3, "loopAndWrite_finally");
                                                        throw null;
                                                    } catch (BaseException e6) {
                                                        this.f66544h = e6;
                                                        throw e6;
                                                    }
                                                }
                                                return;
                                            }
                                        }
                                        th3 = null;
                                        synchronized (this) {
                                        }
                                    } else {
                                        if (d.o.a.e.b.c.a.e()) {
                                            e.printStackTrace();
                                        }
                                        d.o.a.e.b.c.a.i("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                        this.f66544h = e;
                                        throw e;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    i3 = i4;
                                    j = j7;
                                    if (!this.j && !this.k) {
                                        if (d.o.a.e.b.c.a.e()) {
                                            th.printStackTrace();
                                        }
                                        d.o.a.e.b.c.a.i("MultiSegmentWriter", "loopAndWrite:  e = " + th);
                                        try {
                                            d.o.a.e.b.l.e.A(th, "loopAndWrite");
                                            throw null;
                                        } catch (BaseException e7) {
                                            this.f66544h = e7;
                                            throw e7;
                                        }
                                    }
                                    if (!this.k) {
                                        try {
                                            k();
                                        } catch (Throwable th10) {
                                            th2 = th10;
                                            d.o.a.e.b.c.a.i("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th2);
                                            synchronized (this) {
                                                l(this.f66537a);
                                                this.f66537a.clear();
                                            }
                                            d.o.a.e.b.e.a.f(this.f66541e, downloadInfo, downloadInfo.T0(), null, this.j, this.k, this.f66544h, downloadInfo.E() - E, System.nanoTime() - nanoTime, z, j2, j, this.q, null);
                                            if (th2 != null) {
                                                if (!this.j && !this.k && this.f66544h == null) {
                                                    z2 = false;
                                                }
                                                if (z2) {
                                                    return;
                                                }
                                                try {
                                                    d.o.a.e.b.l.e.A(th2, "loopAndWrite_finally");
                                                    throw null;
                                                } catch (BaseException e8) {
                                                    this.f66544h = e8;
                                                    throw e8;
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    th2 = null;
                                    synchronized (this) {
                                    }
                                }
                            } else {
                                if (z) {
                                    j6 = System.nanoTime();
                                }
                                a2.f66525b.b(a2);
                                if (z) {
                                    j7 += System.nanoTime() - j6;
                                }
                                j4 = j7;
                                try {
                                    cVar.a(a2);
                                    if (this.f66545i) {
                                        if (this.j) {
                                            break;
                                        }
                                        try {
                                            if (this.k) {
                                                break;
                                            }
                                            this.f66545i = z3;
                                        } catch (p e9) {
                                            e = e9;
                                            i3 = i4;
                                            j5 = j2;
                                            this.f66544h = e;
                                            throw e;
                                        } catch (BaseException e10) {
                                            e = e10;
                                            i2 = i4;
                                            j3 = j4;
                                            if (!this.f66541e.l("ignore_base_ex_on_stop_status")) {
                                            }
                                            if (d.o.a.e.b.c.a.e()) {
                                            }
                                            d.o.a.e.b.c.a.i("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                            this.f66544h = e;
                                            throw e;
                                        } catch (Throwable th11) {
                                            th = th11;
                                            i3 = i4;
                                            j = j4;
                                            if (!this.j) {
                                                if (d.o.a.e.b.c.a.e()) {
                                                }
                                                d.o.a.e.b.c.a.i("MultiSegmentWriter", "loopAndWrite:  e = " + th);
                                                d.o.a.e.b.l.e.A(th, "loopAndWrite");
                                                throw null;
                                            }
                                            if (!this.k) {
                                            }
                                            th2 = null;
                                            synchronized (this) {
                                            }
                                        }
                                    }
                                    i4 += i5;
                                    if (i4 >= 65536) {
                                        try {
                                            long uptimeMillis = SystemClock.uptimeMillis();
                                            if (uptimeMillis - j8 > 100) {
                                                long j9 = j6;
                                                try {
                                                    b(uptimeMillis, fVar.b(i4));
                                                    if (!d.o.a.e.b.o.d.f66748f) {
                                                        if (!downloadInfo.K1()) {
                                                            if (downloadInfo.l1() && downloadInfo.L1()) {
                                                                throw new com.ss.android.socialbase.downloader.exception.e();
                                                            }
                                                        } else {
                                                            throw new com.ss.android.socialbase.downloader.exception.c();
                                                        }
                                                    }
                                                    j8 = uptimeMillis;
                                                    j6 = j9;
                                                    j5 = j2;
                                                    j7 = j4;
                                                    i4 = 0;
                                                    z3 = false;
                                                } catch (p e11) {
                                                    e = e11;
                                                    j5 = j2;
                                                    i3 = 0;
                                                    this.f66544h = e;
                                                    throw e;
                                                } catch (BaseException e12) {
                                                    e = e12;
                                                    j3 = j4;
                                                    i2 = 0;
                                                    if (!this.f66541e.l("ignore_base_ex_on_stop_status")) {
                                                    }
                                                    if (d.o.a.e.b.c.a.e()) {
                                                    }
                                                    d.o.a.e.b.c.a.i("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                                    this.f66544h = e;
                                                    throw e;
                                                } catch (Throwable th12) {
                                                    th = th12;
                                                    j = j4;
                                                    i3 = 0;
                                                    if (!this.j) {
                                                    }
                                                    if (!this.k) {
                                                    }
                                                    th2 = null;
                                                    synchronized (this) {
                                                    }
                                                }
                                            }
                                        } catch (p e13) {
                                            e = e13;
                                            i3 = i4;
                                            j5 = j2;
                                            this.f66544h = e;
                                            throw e;
                                        } catch (BaseException e14) {
                                            e = e14;
                                            i2 = i4;
                                            j3 = j4;
                                            if (!this.f66541e.l("ignore_base_ex_on_stop_status")) {
                                            }
                                            if (d.o.a.e.b.c.a.e()) {
                                            }
                                            d.o.a.e.b.c.a.i("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                            this.f66544h = e;
                                            throw e;
                                        } catch (Throwable th13) {
                                            th = th13;
                                            i3 = i4;
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
                                    j6 = j6;
                                    j5 = j2;
                                    j7 = j4;
                                    z3 = false;
                                } catch (p e15) {
                                    e = e15;
                                } catch (BaseException e16) {
                                    e = e16;
                                } catch (Throwable th14) {
                                    th = th14;
                                }
                            }
                        } catch (p e17) {
                            e = e17;
                            i3 = i4;
                            j4 = j7;
                        } catch (BaseException e18) {
                            e = e18;
                            i2 = i4;
                            j3 = j7;
                            if (!this.f66541e.l("ignore_base_ex_on_stop_status")) {
                            }
                            if (d.o.a.e.b.c.a.e()) {
                            }
                            d.o.a.e.b.c.a.i("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                            this.f66544h = e;
                            throw e;
                        } catch (Throwable th15) {
                            th = th15;
                            i3 = i4;
                            j = j7;
                            if (!this.j) {
                            }
                            if (!this.k) {
                            }
                            th2 = null;
                            synchronized (this) {
                            }
                        }
                    } catch (p e19) {
                        e = e19;
                        i3 = i4;
                        j4 = j7;
                    } catch (BaseException e20) {
                        e = e20;
                        j2 = j5;
                    } catch (Throwable th16) {
                        th = th16;
                        j2 = j5;
                    }
                }
            } catch (Throwable th17) {
                th = th17;
                if (i3 > 0) {
                    try {
                        fVar.b(i3);
                    } catch (Throwable unused2) {
                    }
                }
                if (!this.k) {
                    try {
                        k();
                    } catch (Throwable th18) {
                        d.o.a.e.b.c.a.i("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th18);
                        th4 = th18;
                        synchronized (this) {
                        }
                    }
                }
                th4 = null;
                synchronized (this) {
                    l(this.f66537a);
                    this.f66537a.clear();
                }
                d.o.a.e.b.e.a.f(this.f66541e, downloadInfo, downloadInfo.T0(), null, this.j, this.k, this.f66544h, downloadInfo.E() - E, System.nanoTime() - nanoTime, z, j2, j, this.q, null);
                if (th4 != null) {
                    if (!this.j && !this.k && this.f66544h == null) {
                        z2 = false;
                    }
                    if (!z2) {
                        try {
                            d.o.a.e.b.l.e.A(th4, "loopAndWrite_finally");
                            throw null;
                        } catch (BaseException e21) {
                            this.f66544h = e21;
                            throw e21;
                        }
                    }
                }
                throw th;
            }
        } catch (p e22) {
            e = e22;
            j4 = 0;
        } catch (BaseException e23) {
            e = e23;
            j3 = 0;
            j2 = 0;
        } catch (Throwable th19) {
            th = th19;
            j = 0;
            j2 = 0;
        }
        if (!this.k) {
            try {
                k();
            } catch (Throwable th20) {
                th5 = th20;
                d.o.a.e.b.c.a.i("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th5);
                synchronized (this) {
                    l(this.f66537a);
                    this.f66537a.clear();
                }
                d.o.a.e.b.e.a.f(this.f66541e, downloadInfo, downloadInfo.T0(), null, this.j, this.k, this.f66544h, downloadInfo.E() - E, System.nanoTime() - nanoTime, z, j2, j4, this.q, null);
                if (th5 != null) {
                    if (!this.j && !this.k && this.f66544h == null) {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                    try {
                        d.o.a.e.b.l.e.A(th5, "loopAndWrite_finally");
                        throw null;
                    } catch (BaseException e24) {
                        this.f66544h = e24;
                        throw e24;
                    }
                }
                return;
            }
        }
        th5 = null;
        synchronized (this) {
        }
    }

    public final void d(e eVar) {
        synchronized (this) {
            this.f66538b.add((k) eVar);
        }
    }

    public void e(k kVar) {
        synchronized (this) {
            this.f66537a.add(kVar);
        }
    }

    public final void f(List<k> list) throws IOException {
        for (k kVar : list) {
            kVar.d();
        }
    }

    public final void g(List<k> list, Map<Long, i> map) {
        for (k kVar : list) {
            i g2 = kVar.g();
            i iVar = map.get(Long.valueOf(g2.g()));
            if (iVar == null) {
                map.put(Long.valueOf(g2.g()), new i(g2));
            } else {
                iVar.c(g2.i());
                iVar.h(g2.l());
            }
        }
    }

    public final boolean h(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    public void i() {
        this.j = true;
        this.f66545i = true;
    }

    public final void j(List<k> list) throws IOException {
        for (k kVar : list) {
            kVar.e();
        }
    }

    public final void k() throws IOException {
        boolean z = this.p;
        long nanoTime = z ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.f66539c;
        d.o.a.e.b.g.j jVar = this.f66540d;
        List<k> list = this.f66537a;
        List<k> list2 = this.f66538b;
        Map<Long, i> l = jVar.l(downloadInfo.c0());
        if (l == null) {
            l = new HashMap<>(4);
        }
        synchronized (this) {
            f(list);
            j(list);
            g(list, l);
            if (list2.size() > 0) {
                l(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (1 != 0) {
            downloadInfo.q3(true);
            jVar.a(downloadInfo.c0(), l);
            jVar.a(downloadInfo);
            this.r = downloadInfo.E();
        }
        if (z) {
            this.q += System.nanoTime() - nanoTime;
        }
    }

    public final void l(List<k> list) {
        for (k kVar : list) {
            kVar.f();
        }
    }
}
