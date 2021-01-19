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
    private final com.ss.android.socialbase.downloader.g.c pVi;
    private final com.ss.android.socialbase.downloader.g.b pVj;
    private final com.ss.android.socialbase.downloader.i.g pVk;
    private com.ss.android.socialbase.downloader.impls.k pVm;
    private t pVn;
    private com.ss.android.socialbase.downloader.g.f pVo;
    private com.ss.android.socialbase.downloader.e.a pVp;
    private final com.ss.android.socialbase.downloader.l.e pVq;
    private final com.ss.android.socialbase.downloader.k.a pVr;
    private final com.ss.android.socialbase.downloader.a.a pVs;
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
    private k pVl = b.eDT();

    public d(com.ss.android.socialbase.downloader.g.c cVar, String str, com.ss.android.socialbase.downloader.i.g gVar, com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.l.e eVar) {
        this.pVi = cVar;
        this.c = str;
        if (this.pVl instanceof com.ss.android.socialbase.downloader.impls.d) {
            com.ss.android.socialbase.downloader.impls.d dVar = (com.ss.android.socialbase.downloader.impls.d) this.pVl;
            this.pVm = dVar.eFZ();
            this.pVn = dVar.eGa();
        }
        this.pVk = gVar;
        this.pVj = bVar;
        this.pVq = eVar;
        this.n = bVar.n();
        this.o = this.n;
        if (bVar.d()) {
            this.q = bVar.q();
        } else {
            this.q = bVar.BT(false);
        }
        this.p = bVar.p();
        this.pVs = com.ss.android.socialbase.downloader.a.a.eDz();
        this.pVr = com.ss.android.socialbase.downloader.k.a.RA(cVar.g());
        this.u = this.pVr.a("sync_strategy", 0) == 1;
        if (this.u) {
            this.v = Math.max(this.pVr.a("sync_interval_ms_fg", 5000), 500L);
            this.w = Math.max(this.pVr.a("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.v = 0L;
            this.w = 0L;
        }
        this.x = this.pVr.b("monitor_rw") == 1;
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
            synchronized (this.pVq) {
                this.l = true;
            }
            g();
        }
    }

    private void g() {
        ExecutorService eDL;
        if (this.pVk != null && (eDL = b.eDL()) != null) {
            eDL.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.pVk.d();
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
        if (f() || this.pVj == null) {
            return;
        }
        long b2 = com.ss.android.socialbase.downloader.m.d.b(this.pVk);
        if (b2 == 0) {
            throw new com.ss.android.socialbase.downloader.e.g(1004, "the content-length is 0");
        }
        long l = this.pVj.l();
        long nanoTime = System.nanoTime();
        boolean z = this.x;
        com.ss.android.socialbase.downloader.j.c cVar = null;
        boolean z2 = this.pVk instanceof com.ss.android.socialbase.downloader.i.a;
        try {
            try {
                this.pVo = com.ss.android.socialbase.downloader.m.d.A(this.pVi.l(), this.pVi.m(), this.pVr.a("flush_buffer_size_byte", -1));
                try {
                    this.pVo.a(this.n);
                    InputStream a2 = this.pVk.a();
                    if (a2 == null) {
                        throw new com.ss.android.socialbase.downloader.e.a(1042, new IOException("inputStream is null"));
                    }
                    this.pVi.ab();
                    com.ss.android.socialbase.downloader.j.c O = O(a2);
                    this.pVi.e(this.y);
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
                            if (!this.pVi.ag() && this.q > this.n - this.o && this.q < (this.n - this.o) + i) {
                                i = (int) (this.q - (this.n - this.o));
                            }
                            if (z) {
                                j = System.nanoTime();
                            }
                            this.pVo.a(eGd.f13204a, 0, i);
                            if (z) {
                                this.A += System.nanoTime() - j;
                            }
                            O.a(eGd);
                            this.n += i;
                            synchronized (this.pVq) {
                                if (!this.r) {
                                    boolean a3 = this.pVq.a(i);
                                    a(this.pVm);
                                    a(a3);
                                } else if (!this.l) {
                                    boolean a4 = this.pVq.a(i);
                                    a(this.pVm);
                                    a(a4);
                                }
                            }
                            if (!this.pVi.eFg()) {
                                throw new com.ss.android.socialbase.downloader.e.d();
                            }
                            if (!this.pVi.eFh()) {
                                throw new com.ss.android.socialbase.downloader.e.f();
                            }
                            if (this.pVi.ag() || this.q < 0 || this.q > this.n - this.o) {
                            }
                        }
                        if (this.pVk != null) {
                            this.pVk.d();
                        }
                        if (O != null) {
                            O.b();
                        }
                        try {
                            if (this.r) {
                                synchronized (this.pVq) {
                                    if (!this.l) {
                                        a(this.pVm);
                                        if (this.pVo != null) {
                                            h();
                                        }
                                    }
                                }
                            } else {
                                a(this.pVm);
                                if (this.pVo != null) {
                                    h();
                                }
                            }
                            com.ss.android.socialbase.downloader.m.d.a(this.pVo);
                            this.C = System.nanoTime() - nanoTime;
                            a((this.n - this.o) / 1048576.0d);
                            if (this.pVi.ag()) {
                                return;
                            }
                            long j2 = this.n - this.o;
                            if (j2 >= 0 && this.q >= 0 && this.q != j2) {
                                throw new com.ss.android.socialbase.downloader.e.a(1051, String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", Long.valueOf(j2), Long.valueOf(b2), Long.valueOf(this.q), Long.valueOf(l), Long.valueOf(this.p), Long.valueOf(this.n), Long.valueOf(this.o)));
                            }
                            return;
                        } catch (Throwable th) {
                            com.ss.android.socialbase.downloader.m.d.a(this.pVo);
                            throw th;
                        }
                    }
                    if (this.pVk != null) {
                        this.pVk.d();
                    }
                    if (O != null) {
                        O.b();
                    }
                    try {
                        if (this.r) {
                            synchronized (this.pVq) {
                                if (!this.l) {
                                    a(this.pVm);
                                    if (this.pVo != null) {
                                        h();
                                    }
                                }
                            }
                        } else {
                            a(this.pVm);
                            if (this.pVo != null) {
                                h();
                            }
                        }
                        com.ss.android.socialbase.downloader.m.d.a(this.pVo);
                        this.C = System.nanoTime() - nanoTime;
                        a((this.n - this.o) / 1048576.0d);
                    } catch (Throwable th2) {
                        com.ss.android.socialbase.downloader.m.d.a(this.pVo);
                        throw th2;
                    }
                } catch (IOException e) {
                    throw new com.ss.android.socialbase.downloader.e.a(1054, e);
                }
            } catch (com.ss.android.socialbase.downloader.e.a e2) {
                com.ss.android.socialbase.downloader.f.a.d(f13134a, "handleResponse: BaseException e = " + e2);
                if (!this.pVr.a("ignore_base_ex_on_stop_status") || !f()) {
                    if (com.ss.android.socialbase.downloader.f.a.a()) {
                        e2.printStackTrace();
                    }
                    this.pVp = e2;
                    throw e2;
                }
                if (this.pVk != null) {
                    this.pVk.d();
                }
                if (0 != 0) {
                    cVar.b();
                }
                try {
                    if (this.r) {
                        synchronized (this.pVq) {
                            if (!this.l) {
                                a(this.pVm);
                                if (this.pVo != null) {
                                    h();
                                }
                            }
                        }
                    } else {
                        a(this.pVm);
                        if (this.pVo != null) {
                            h();
                        }
                    }
                    com.ss.android.socialbase.downloader.m.d.a(this.pVo);
                    this.C = System.nanoTime() - nanoTime;
                    a((this.n - this.o) / 1048576.0d);
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.m.d.a(this.pVo);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            if (this.pVk != null) {
                this.pVk.d();
            }
            if (0 != 0) {
                cVar.b();
            }
            try {
                if (this.r) {
                    synchronized (this.pVq) {
                        if (!this.l) {
                            a(this.pVm);
                            if (this.pVo != null) {
                                h();
                            }
                        }
                    }
                } else {
                    a(this.pVm);
                    if (this.pVo != null) {
                        h();
                    }
                }
                com.ss.android.socialbase.downloader.m.d.a(this.pVo);
                this.C = System.nanoTime() - nanoTime;
                a((this.n - this.o) / 1048576.0d);
                throw th4;
            } catch (Throwable th5) {
                com.ss.android.socialbase.downloader.m.d.a(this.pVo);
                throw th5;
            }
        }
    }

    private com.ss.android.socialbase.downloader.j.c O(InputStream inputStream) {
        int B = b.B();
        if (this.pVr.a("rw_concurrent", 0) == 1 && this.pVi.eFv() == 1 && this.pVi.efR() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.j.a aVar = new com.ss.android.socialbase.downloader.j.a(inputStream, B, this.pVr.a("rw_concurrent_max_buffer_count", 4));
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
            if (j > (this.pVs.b() ? this.v : this.w)) {
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
            this.pVo.a();
            z = true;
        } catch (Exception e) {
            z = false;
        }
        if (z) {
            this.pVi.f(true);
            boolean z2 = this.pVi.eFv() > 1;
            n Cu = com.ss.android.socialbase.downloader.impls.l.Cu(com.ss.android.socialbase.downloader.m.d.b());
            if (z2) {
                a(this.pVn);
                if (Cu != null) {
                    Cu.c(this.pVi);
                } else {
                    this.pVn.a(this.pVi.g(), this.pVi.eEJ());
                }
            } else if (Cu != null) {
                Cu.c(this.pVi);
            } else {
                this.pVn.a(this.pVj.k(), this.n);
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
                if (this.pVj.d()) {
                    bVar = this.pVj.eEv();
                } else {
                    bVar = this.pVj;
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
                } else if (this.pVj.d()) {
                    if ((kVar instanceof com.ss.android.socialbase.downloader.c.e) && nVar != null) {
                        nVar.a(this.pVj.k(), this.pVj.s(), this.n);
                    } else {
                        kVar.a(this.pVj.k(), this.pVj.s(), this.n);
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
        int b2 = this.pVr.b("monitor_download_io");
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
                        com.ss.android.socialbase.downloader.e.a aVar = this.pVp;
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
                    if (this.pVk != null && (this.pVk instanceof com.ss.android.socialbase.downloader.i.d)) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    double nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("setting_tag", this.pVr.d("setting_tag"));
                    jSONObject.put("url_host", host);
                    jSONObject.put("url_path", str);
                    jSONObject.put("url_file", lastPathSegment);
                    jSONObject.put("net_lib", i2);
                    jSONObject.put("status_code", i);
                    if (str2 != null) {
                        jSONObject.put("err_msg", com.ss.android.socialbase.downloader.m.d.a(str2, this.pVr.a("exception_msg_length", 500)));
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
                    jSONObject.put("pkg_name", this.pVi.D());
                    jSONObject.put("name", this.pVi.i());
                    if ((b2 == 1 || b2 == 3) && (eEe = b.eEe()) != null) {
                        eEe.a("download_io", jSONObject);
                    }
                    if ((b2 == 2 || b2 == 3) && (eEf = b.eEf()) != null) {
                        eEf.a(this.pVi, "download_io", jSONObject);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }
}
