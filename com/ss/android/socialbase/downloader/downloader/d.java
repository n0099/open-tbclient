package com.ss.android.socialbase.downloader.downloader;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f13134a = "ResponseHandler";
    private long A;
    private long B;
    private long C;
    private final String c;
    private volatile boolean k;
    private volatile boolean l;
    private long n;
    private long o;
    private volatile long p;
    private final com.ss.android.socialbase.downloader.g.c pVh;
    private final com.ss.android.socialbase.downloader.g.b pVi;
    private final com.ss.android.socialbase.downloader.i.g pVj;
    private com.ss.android.socialbase.downloader.impls.k pVl;
    private t pVm;
    private com.ss.android.socialbase.downloader.g.f pVn;
    private com.ss.android.socialbase.downloader.e.a pVo;
    private final com.ss.android.socialbase.downloader.l.e pVp;
    private final com.ss.android.socialbase.downloader.k.a pVq;
    private final com.ss.android.socialbase.downloader.a.a pVr;
    private volatile long q;
    private final boolean r;
    private final boolean u;
    private final long v;
    private final long w;
    private final boolean x;
    private boolean y;
    private long z;
    private volatile long D = 0;
    private volatile long E = 0;
    private k pVk = b.eDT();

    public d(com.ss.android.socialbase.downloader.g.c cVar, String str, com.ss.android.socialbase.downloader.i.g gVar, com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.l.e eVar) {
        this.pVh = cVar;
        this.c = str;
        if (this.pVk instanceof com.ss.android.socialbase.downloader.impls.d) {
            com.ss.android.socialbase.downloader.impls.d dVar = (com.ss.android.socialbase.downloader.impls.d) this.pVk;
            this.pVl = dVar.eFZ();
            this.pVm = dVar.eGa();
        }
        this.pVj = gVar;
        this.pVi = bVar;
        this.pVp = eVar;
        this.n = bVar.n();
        this.o = this.n;
        if (bVar.d()) {
            this.q = bVar.q();
        } else {
            this.q = bVar.BT(false);
        }
        this.p = bVar.p();
        this.pVr = com.ss.android.socialbase.downloader.a.a.eDz();
        this.pVq = com.ss.android.socialbase.downloader.k.a.RA(cVar.g());
        this.u = this.pVq.a("sync_strategy", 0) == 1;
        if (this.u) {
            this.v = Math.max(this.pVq.a("sync_interval_ms_fg", 5000), 500L);
            this.w = Math.max(this.pVq.a("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.v = 0L;
            this.w = 0L;
        }
        this.x = this.pVq.b("monitor_rw") == 1;
        this.r = com.ss.android.socialbase.downloader.m.a.a(65536);
    }

    public long a() {
        return this.n;
    }

    private boolean f() {
        return this.k || this.l;
    }

    public void b() {
        if (!this.k) {
            this.k = true;
            g();
        }
    }

    public void c() {
        if (!this.l) {
            synchronized (this.pVp) {
                this.l = true;
            }
            g();
        }
    }

    private void g() {
        ExecutorService eDL;
        if (this.pVj != null && (eDL = b.eDL()) != null) {
            eDL.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.pVj.d();
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }

    public void a(long j, long j2, long j3) {
        this.n = j;
        this.o = j;
        this.p = j2;
        this.q = j3;
    }

    public void a(long j, long j2) {
        this.p = j;
        this.q = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [331=6, 332=6, 334=6, 335=6, 339=6, 340=6, 341=6, 343=6, 344=6, 345=6, 348=12, 350=6, 351=6, 352=6, 357=12, 360=6, 361=6, 373=6] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void d() throws com.ss.android.socialbase.downloader.e.a {
        if (f() || this.pVi == null) {
            return;
        }
        long b2 = com.ss.android.socialbase.downloader.m.d.b(this.pVj);
        if (b2 == 0) {
            throw new com.ss.android.socialbase.downloader.e.g(1004, "the content-length is 0");
        }
        long l = this.pVi.l();
        long nanoTime = System.nanoTime();
        boolean z = this.x;
        com.ss.android.socialbase.downloader.j.c cVar = null;
        boolean z2 = this.pVj instanceof com.ss.android.socialbase.downloader.i.a;
        try {
            try {
                this.pVn = com.ss.android.socialbase.downloader.m.d.A(this.pVh.l(), this.pVh.m(), this.pVq.a("flush_buffer_size_byte", -1));
                try {
                    this.pVn.a(this.n);
                    InputStream a2 = this.pVj.a();
                    if (a2 == null) {
                        throw new com.ss.android.socialbase.downloader.e.a(1042, new IOException("inputStream is null"));
                    }
                    this.pVh.ab();
                    com.ss.android.socialbase.downloader.j.c O = O(a2);
                    this.pVh.e(this.y);
                    long j = 0;
                    while (!f()) {
                        if (z) {
                            j = System.nanoTime();
                        }
                        com.ss.android.socialbase.downloader.j.b eGd = O.eGd();
                        if (z) {
                            this.z += System.nanoTime() - j;
                        }
                        int i = eGd.f13205b;
                        if (i != -1) {
                            if (!this.pVh.ag() && this.q > this.n - this.o && this.q < (this.n - this.o) + i) {
                                i = (int) (this.q - (this.n - this.o));
                            }
                            if (z) {
                                j = System.nanoTime();
                            }
                            this.pVn.a(eGd.f13204a, 0, i);
                            if (z) {
                                this.A += System.nanoTime() - j;
                            }
                            O.a(eGd);
                            this.n += i;
                            synchronized (this.pVp) {
                                if (!this.r) {
                                    boolean a3 = this.pVp.a(i);
                                    a(this.pVl);
                                    a(a3);
                                } else if (!this.l) {
                                    boolean a4 = this.pVp.a(i);
                                    a(this.pVl);
                                    a(a4);
                                }
                            }
                            if (!this.pVh.eFg()) {
                                throw new com.ss.android.socialbase.downloader.e.d();
                            }
                            if (!this.pVh.eFh()) {
                                throw new com.ss.android.socialbase.downloader.e.f();
                            }
                            if (this.pVh.ag() || this.q < 0 || this.q > this.n - this.o) {
                            }
                        }
                        if (this.pVj != null) {
                            this.pVj.d();
                        }
                        if (O != null) {
                            O.b();
                        }
                        try {
                            if (this.r) {
                                synchronized (this.pVp) {
                                    if (!this.l) {
                                        a(this.pVl);
                                        if (this.pVn != null) {
                                            h();
                                        }
                                    }
                                }
                            } else {
                                a(this.pVl);
                                if (this.pVn != null) {
                                    h();
                                }
                            }
                            com.ss.android.socialbase.downloader.m.d.a(this.pVn);
                            this.C = System.nanoTime() - nanoTime;
                            a((this.n - this.o) / 1048576.0d);
                            if (this.pVh.ag()) {
                                return;
                            }
                            long j2 = this.n - this.o;
                            if (j2 >= 0 && this.q >= 0 && this.q != j2) {
                                throw new com.ss.android.socialbase.downloader.e.a(1051, String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", Long.valueOf(j2), Long.valueOf(b2), Long.valueOf(this.q), Long.valueOf(l), Long.valueOf(this.p), Long.valueOf(this.n), Long.valueOf(this.o)));
                            }
                            return;
                        } catch (Throwable th) {
                            com.ss.android.socialbase.downloader.m.d.a(this.pVn);
                            throw th;
                        }
                    }
                    if (this.pVj != null) {
                        this.pVj.d();
                    }
                    if (O != null) {
                        O.b();
                    }
                    try {
                        if (this.r) {
                            synchronized (this.pVp) {
                                if (!this.l) {
                                    a(this.pVl);
                                    if (this.pVn != null) {
                                        h();
                                    }
                                }
                            }
                        } else {
                            a(this.pVl);
                            if (this.pVn != null) {
                                h();
                            }
                        }
                        com.ss.android.socialbase.downloader.m.d.a(this.pVn);
                        this.C = System.nanoTime() - nanoTime;
                        a((this.n - this.o) / 1048576.0d);
                    } catch (Throwable th2) {
                        com.ss.android.socialbase.downloader.m.d.a(this.pVn);
                        throw th2;
                    }
                } catch (IOException e) {
                    throw new com.ss.android.socialbase.downloader.e.a(1054, e);
                }
            } catch (com.ss.android.socialbase.downloader.e.a e2) {
                com.ss.android.socialbase.downloader.f.a.d(f13134a, "handleResponse: BaseException e = " + e2);
                if (!this.pVq.a("ignore_base_ex_on_stop_status") || !f()) {
                    if (com.ss.android.socialbase.downloader.f.a.a()) {
                        e2.printStackTrace();
                    }
                    this.pVo = e2;
                    throw e2;
                }
                if (this.pVj != null) {
                    this.pVj.d();
                }
                if (0 != 0) {
                    cVar.b();
                }
                try {
                    if (this.r) {
                        synchronized (this.pVp) {
                            if (!this.l) {
                                a(this.pVl);
                                if (this.pVn != null) {
                                    h();
                                }
                            }
                        }
                    } else {
                        a(this.pVl);
                        if (this.pVn != null) {
                            h();
                        }
                    }
                    com.ss.android.socialbase.downloader.m.d.a(this.pVn);
                    this.C = System.nanoTime() - nanoTime;
                    a((this.n - this.o) / 1048576.0d);
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.m.d.a(this.pVn);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            if (this.pVj != null) {
                this.pVj.d();
            }
            if (0 != 0) {
                cVar.b();
            }
            try {
                if (this.r) {
                    synchronized (this.pVp) {
                        if (!this.l) {
                            a(this.pVl);
                            if (this.pVn != null) {
                                h();
                            }
                        }
                    }
                } else {
                    a(this.pVl);
                    if (this.pVn != null) {
                        h();
                    }
                }
                com.ss.android.socialbase.downloader.m.d.a(this.pVn);
                this.C = System.nanoTime() - nanoTime;
                a((this.n - this.o) / 1048576.0d);
                throw th4;
            } catch (Throwable th5) {
                com.ss.android.socialbase.downloader.m.d.a(this.pVn);
                throw th5;
            }
        }
    }

    private com.ss.android.socialbase.downloader.j.c O(InputStream inputStream) {
        int B = b.B();
        if (this.pVq.a("rw_concurrent", 0) == 1 && this.pVh.eFv() == 1 && this.pVh.efR() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.j.a aVar = new com.ss.android.socialbase.downloader.j.a(inputStream, B, this.pVq.a("rw_concurrent_max_buffer_count", 4));
                this.y = true;
                return aVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        com.ss.android.socialbase.downloader.j.e eVar = new com.ss.android.socialbase.downloader.j.e(inputStream, B);
        this.y = false;
        return eVar;
    }

    private void a(boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.E;
        if (this.u) {
            if (j > (this.pVr.b() ? this.v : this.w)) {
                h();
                this.E = uptimeMillis;
                return;
            }
            return;
        }
        long j2 = this.n - this.D;
        if (z || Q(j2, j)) {
            h();
            this.E = uptimeMillis;
        }
    }

    private boolean Q(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    public long e() {
        return this.D;
    }

    private void h() {
        boolean z;
        long nanoTime = this.x ? System.nanoTime() : 0L;
        try {
            this.pVn.a();
            z = true;
        } catch (Exception e) {
            z = false;
        }
        if (z) {
            this.pVh.f(true);
            boolean z2 = this.pVh.eFv() > 1;
            n Cu = com.ss.android.socialbase.downloader.impls.l.Cu(com.ss.android.socialbase.downloader.m.d.b());
            if (z2) {
                a(this.pVm);
                if (Cu != null) {
                    Cu.c(this.pVh);
                } else {
                    this.pVm.a(this.pVh.g(), this.pVh.eEJ());
                }
            } else if (Cu != null) {
                Cu.c(this.pVh);
            } else {
                this.pVm.a(this.pVi.k(), this.n);
            }
            this.D = this.n;
        }
        if (this.x) {
            this.B = (System.nanoTime() - nanoTime) + this.B;
        }
    }

    private void a(k kVar) {
        com.ss.android.socialbase.downloader.g.b bVar;
        if (kVar != null) {
            n nVar = null;
            if (!(kVar instanceof com.ss.android.socialbase.downloader.c.e) || (nVar = com.ss.android.socialbase.downloader.impls.l.Cu(com.ss.android.socialbase.downloader.m.d.b())) != null) {
                if (this.pVi.d()) {
                    bVar = this.pVi.eEv();
                } else {
                    bVar = this.pVi;
                }
                if (bVar != null) {
                    bVar.b(this.n);
                    if ((kVar instanceof com.ss.android.socialbase.downloader.c.e) && nVar != null) {
                        nVar.a(bVar.k(), bVar.s(), bVar.b(), this.n);
                    } else {
                        kVar.a(bVar.k(), bVar.s(), bVar.b(), this.n);
                    }
                    if (bVar.h()) {
                        boolean z = false;
                        if (bVar.i()) {
                            long j = bVar.j();
                            if (j > this.n) {
                                if ((kVar instanceof com.ss.android.socialbase.downloader.c.e) && nVar != null) {
                                    nVar.a(bVar.k(), bVar.b(), j);
                                } else {
                                    kVar.a(bVar.k(), bVar.b(), j);
                                }
                                z = true;
                            }
                        }
                        if (!z) {
                            if ((kVar instanceof com.ss.android.socialbase.downloader.c.e) && nVar != null) {
                                nVar.a(bVar.k(), bVar.b(), this.n);
                            } else {
                                kVar.a(bVar.k(), bVar.b(), this.n);
                            }
                        }
                    }
                } else if (this.pVi.d()) {
                    if ((kVar instanceof com.ss.android.socialbase.downloader.c.e) && nVar != null) {
                        nVar.a(this.pVi.k(), this.pVi.s(), this.n);
                    } else {
                        kVar.a(this.pVi.k(), this.pVi.s(), this.n);
                    }
                }
            }
        }
    }

    private void a(double d) {
        String str;
        int i;
        String str2;
        int i2;
        com.ss.android.socialbase.downloader.h.c eEe;
        com.ss.android.socialbase.downloader.h.b eEf;
        int b2 = this.pVq.b("monitor_download_io");
        if (b2 != 0) {
            double d2 = this.C;
            if (d2 > 0.0d) {
                try {
                    Uri parse = Uri.parse(this.c);
                    String host = parse.getHost();
                    String path = parse.getPath();
                    String lastPathSegment = parse.getLastPathSegment();
                    if (TextUtils.isEmpty(path) || TextUtils.isEmpty(lastPathSegment)) {
                        str = path;
                    } else {
                        try {
                            str = path.substring(0, path.length() - lastPathSegment.length());
                        } catch (Throwable th) {
                            str = path;
                        }
                    }
                    if (this.k) {
                        i = 1;
                        str2 = null;
                    } else if (this.l) {
                        i = 2;
                        str2 = null;
                    } else {
                        com.ss.android.socialbase.downloader.e.a aVar = this.pVo;
                        if (aVar != null) {
                            if (!com.ss.android.socialbase.downloader.m.d.b(b.eEd())) {
                                i = 1049;
                            } else {
                                i = aVar.a();
                            }
                            str2 = aVar.b();
                        } else {
                            i = 0;
                            str2 = null;
                        }
                    }
                    if (this.pVj != null && (this.pVj instanceof com.ss.android.socialbase.downloader.i.d)) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    double nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("setting_tag", this.pVq.d("setting_tag"));
                    jSONObject.put("url_host", host);
                    jSONObject.put("url_path", str);
                    jSONObject.put("url_file", lastPathSegment);
                    jSONObject.put("net_lib", i2);
                    jSONObject.put("status_code", i);
                    if (str2 != null) {
                        jSONObject.put("err_msg", com.ss.android.socialbase.downloader.m.d.a(str2, this.pVq.a("exception_msg_length", 500)));
                    }
                    jSONObject.put("download_sec", nanos);
                    jSONObject.put("download_mb", d);
                    if (nanos > 0.0d) {
                        jSONObject.put("download_speed", d / nanos);
                    }
                    jSONObject.put("rw_concurrent", this.y ? 1 : 0);
                    if (this.x) {
                        jSONObject.put("rw_read_time", this.z / d2);
                        jSONObject.put("rw_write_time", this.A / d2);
                        jSONObject.put("rw_sync_time", this.B / d2);
                    }
                    jSONObject.put("pkg_name", this.pVh.D());
                    jSONObject.put("name", this.pVh.i());
                    if ((b2 == 1 || b2 == 3) && (eEe = b.eEe()) != null) {
                        eEe.a("download_io", jSONObject);
                    }
                    if ((b2 == 2 || b2 == 3) && (eEf = b.eEf()) != null) {
                        eEf.a(this.pVh, "download_io", jSONObject);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }
}
