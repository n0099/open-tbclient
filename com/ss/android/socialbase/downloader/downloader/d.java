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
    private static String f13434a = "ResponseHandler";
    private long A;
    private long B;
    private long C;
    private final String c;
    private volatile boolean k;
    private volatile boolean l;
    private long n;
    private long o;
    private volatile long p;
    private final com.ss.android.socialbase.downloader.g.c pZI;
    private final com.ss.android.socialbase.downloader.g.b pZJ;
    private final com.ss.android.socialbase.downloader.i.g pZK;
    private com.ss.android.socialbase.downloader.impls.k pZM;
    private t pZN;
    private com.ss.android.socialbase.downloader.g.f pZO;
    private com.ss.android.socialbase.downloader.e.a pZP;
    private final com.ss.android.socialbase.downloader.l.e pZQ;
    private final com.ss.android.socialbase.downloader.k.a pZR;
    private final com.ss.android.socialbase.downloader.a.a pZS;
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
    private k pZL = b.eHJ();

    public d(com.ss.android.socialbase.downloader.g.c cVar, String str, com.ss.android.socialbase.downloader.i.g gVar, com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.l.e eVar) {
        this.pZI = cVar;
        this.c = str;
        if (this.pZL instanceof com.ss.android.socialbase.downloader.impls.d) {
            com.ss.android.socialbase.downloader.impls.d dVar = (com.ss.android.socialbase.downloader.impls.d) this.pZL;
            this.pZM = dVar.eJP();
            this.pZN = dVar.eJQ();
        }
        this.pZK = gVar;
        this.pZJ = bVar;
        this.pZQ = eVar;
        this.n = bVar.n();
        this.o = this.n;
        if (bVar.d()) {
            this.q = bVar.q();
        } else {
            this.q = bVar.BX(false);
        }
        this.p = bVar.p();
        this.pZS = com.ss.android.socialbase.downloader.a.a.eHp();
        this.pZR = com.ss.android.socialbase.downloader.k.a.Th(cVar.g());
        this.u = this.pZR.a("sync_strategy", 0) == 1;
        if (this.u) {
            this.v = Math.max(this.pZR.a("sync_interval_ms_fg", 5000), 500L);
            this.w = Math.max(this.pZR.a("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.v = 0L;
            this.w = 0L;
        }
        this.x = this.pZR.b("monitor_rw") == 1;
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
            synchronized (this.pZQ) {
                this.l = true;
            }
            g();
        }
    }

    private void g() {
        ExecutorService eHB;
        if (this.pZK != null && (eHB = b.eHB()) != null) {
            eHB.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.pZK.d();
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
        if (f() || this.pZJ == null) {
            return;
        }
        long b2 = com.ss.android.socialbase.downloader.m.d.b(this.pZK);
        if (b2 == 0) {
            throw new com.ss.android.socialbase.downloader.e.g(1004, "the content-length is 0");
        }
        long l = this.pZJ.l();
        long nanoTime = System.nanoTime();
        boolean z = this.x;
        com.ss.android.socialbase.downloader.j.c cVar = null;
        boolean z2 = this.pZK instanceof com.ss.android.socialbase.downloader.i.a;
        try {
            try {
                this.pZO = com.ss.android.socialbase.downloader.m.d.A(this.pZI.l(), this.pZI.m(), this.pZR.a("flush_buffer_size_byte", -1));
                try {
                    this.pZO.a(this.n);
                    InputStream a2 = this.pZK.a();
                    if (a2 == null) {
                        throw new com.ss.android.socialbase.downloader.e.a(1042, new IOException("inputStream is null"));
                    }
                    this.pZI.ab();
                    com.ss.android.socialbase.downloader.j.c O = O(a2);
                    this.pZI.e(this.y);
                    long j = 0;
                    while (!f()) {
                        if (z) {
                            j = System.nanoTime();
                        }
                        com.ss.android.socialbase.downloader.j.b eJT = O.eJT();
                        if (z) {
                            this.z += System.nanoTime() - j;
                        }
                        int i = eJT.f13505b;
                        if (i != -1) {
                            if (!this.pZI.ag() && this.q > this.n - this.o && this.q < (this.n - this.o) + i) {
                                i = (int) (this.q - (this.n - this.o));
                            }
                            if (z) {
                                j = System.nanoTime();
                            }
                            this.pZO.a(eJT.f13504a, 0, i);
                            if (z) {
                                this.A += System.nanoTime() - j;
                            }
                            O.a(eJT);
                            this.n += i;
                            synchronized (this.pZQ) {
                                if (!this.r) {
                                    boolean a3 = this.pZQ.a(i);
                                    a(this.pZM);
                                    a(a3);
                                } else if (!this.l) {
                                    boolean a4 = this.pZQ.a(i);
                                    a(this.pZM);
                                    a(a4);
                                }
                            }
                            if (!this.pZI.eIW()) {
                                throw new com.ss.android.socialbase.downloader.e.d();
                            }
                            if (!this.pZI.eIX()) {
                                throw new com.ss.android.socialbase.downloader.e.f();
                            }
                            if (this.pZI.ag() || this.q < 0 || this.q > this.n - this.o) {
                            }
                        }
                        if (this.pZK != null) {
                            this.pZK.d();
                        }
                        if (O != null) {
                            O.b();
                        }
                        try {
                            if (this.r) {
                                synchronized (this.pZQ) {
                                    if (!this.l) {
                                        a(this.pZM);
                                        if (this.pZO != null) {
                                            h();
                                        }
                                    }
                                }
                            } else {
                                a(this.pZM);
                                if (this.pZO != null) {
                                    h();
                                }
                            }
                            com.ss.android.socialbase.downloader.m.d.a(this.pZO);
                            this.C = System.nanoTime() - nanoTime;
                            a((this.n - this.o) / 1048576.0d);
                            if (this.pZI.ag()) {
                                return;
                            }
                            long j2 = this.n - this.o;
                            if (j2 >= 0 && this.q >= 0 && this.q != j2) {
                                throw new com.ss.android.socialbase.downloader.e.a(1051, String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", Long.valueOf(j2), Long.valueOf(b2), Long.valueOf(this.q), Long.valueOf(l), Long.valueOf(this.p), Long.valueOf(this.n), Long.valueOf(this.o)));
                            }
                            return;
                        } catch (Throwable th) {
                            com.ss.android.socialbase.downloader.m.d.a(this.pZO);
                            throw th;
                        }
                    }
                    if (this.pZK != null) {
                        this.pZK.d();
                    }
                    if (O != null) {
                        O.b();
                    }
                    try {
                        if (this.r) {
                            synchronized (this.pZQ) {
                                if (!this.l) {
                                    a(this.pZM);
                                    if (this.pZO != null) {
                                        h();
                                    }
                                }
                            }
                        } else {
                            a(this.pZM);
                            if (this.pZO != null) {
                                h();
                            }
                        }
                        com.ss.android.socialbase.downloader.m.d.a(this.pZO);
                        this.C = System.nanoTime() - nanoTime;
                        a((this.n - this.o) / 1048576.0d);
                    } catch (Throwable th2) {
                        com.ss.android.socialbase.downloader.m.d.a(this.pZO);
                        throw th2;
                    }
                } catch (IOException e) {
                    throw new com.ss.android.socialbase.downloader.e.a(1054, e);
                }
            } catch (com.ss.android.socialbase.downloader.e.a e2) {
                com.ss.android.socialbase.downloader.f.a.d(f13434a, "handleResponse: BaseException e = " + e2);
                if (!this.pZR.a("ignore_base_ex_on_stop_status") || !f()) {
                    if (com.ss.android.socialbase.downloader.f.a.a()) {
                        e2.printStackTrace();
                    }
                    this.pZP = e2;
                    throw e2;
                }
                if (this.pZK != null) {
                    this.pZK.d();
                }
                if (0 != 0) {
                    cVar.b();
                }
                try {
                    if (this.r) {
                        synchronized (this.pZQ) {
                            if (!this.l) {
                                a(this.pZM);
                                if (this.pZO != null) {
                                    h();
                                }
                            }
                        }
                    } else {
                        a(this.pZM);
                        if (this.pZO != null) {
                            h();
                        }
                    }
                    com.ss.android.socialbase.downloader.m.d.a(this.pZO);
                    this.C = System.nanoTime() - nanoTime;
                    a((this.n - this.o) / 1048576.0d);
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.m.d.a(this.pZO);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            if (this.pZK != null) {
                this.pZK.d();
            }
            if (0 != 0) {
                cVar.b();
            }
            try {
                if (this.r) {
                    synchronized (this.pZQ) {
                        if (!this.l) {
                            a(this.pZM);
                            if (this.pZO != null) {
                                h();
                            }
                        }
                    }
                } else {
                    a(this.pZM);
                    if (this.pZO != null) {
                        h();
                    }
                }
                com.ss.android.socialbase.downloader.m.d.a(this.pZO);
                this.C = System.nanoTime() - nanoTime;
                a((this.n - this.o) / 1048576.0d);
                throw th4;
            } catch (Throwable th5) {
                com.ss.android.socialbase.downloader.m.d.a(this.pZO);
                throw th5;
            }
        }
    }

    private com.ss.android.socialbase.downloader.j.c O(InputStream inputStream) {
        int B = b.B();
        if (this.pZR.a("rw_concurrent", 0) == 1 && this.pZI.eJl() == 1 && this.pZI.ejL() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.j.a aVar = new com.ss.android.socialbase.downloader.j.a(inputStream, B, this.pZR.a("rw_concurrent_max_buffer_count", 4));
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
            if (j > (this.pZS.b() ? this.v : this.w)) {
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
            this.pZO.a();
            z = true;
        } catch (Exception e) {
            z = false;
        }
        if (z) {
            this.pZI.f(true);
            boolean z2 = this.pZI.eJl() > 1;
            n Cy = com.ss.android.socialbase.downloader.impls.l.Cy(com.ss.android.socialbase.downloader.m.d.b());
            if (z2) {
                a(this.pZN);
                if (Cy != null) {
                    Cy.c(this.pZI);
                } else {
                    this.pZN.a(this.pZI.g(), this.pZI.eIz());
                }
            } else if (Cy != null) {
                Cy.c(this.pZI);
            } else {
                this.pZN.a(this.pZJ.k(), this.n);
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
            if (!(kVar instanceof com.ss.android.socialbase.downloader.c.e) || (nVar = com.ss.android.socialbase.downloader.impls.l.Cy(com.ss.android.socialbase.downloader.m.d.b())) != null) {
                if (this.pZJ.d()) {
                    bVar = this.pZJ.eIl();
                } else {
                    bVar = this.pZJ;
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
                } else if (this.pZJ.d()) {
                    if ((kVar instanceof com.ss.android.socialbase.downloader.c.e) && nVar != null) {
                        nVar.a(this.pZJ.k(), this.pZJ.s(), this.n);
                    } else {
                        kVar.a(this.pZJ.k(), this.pZJ.s(), this.n);
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
        com.ss.android.socialbase.downloader.h.c eHU;
        com.ss.android.socialbase.downloader.h.b eHV;
        int b2 = this.pZR.b("monitor_download_io");
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
                        com.ss.android.socialbase.downloader.e.a aVar = this.pZP;
                        if (aVar != null) {
                            if (!com.ss.android.socialbase.downloader.m.d.b(b.eHT())) {
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
                    if (this.pZK != null && (this.pZK instanceof com.ss.android.socialbase.downloader.i.d)) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    double nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("setting_tag", this.pZR.d("setting_tag"));
                    jSONObject.put("url_host", host);
                    jSONObject.put("url_path", str);
                    jSONObject.put("url_file", lastPathSegment);
                    jSONObject.put("net_lib", i2);
                    jSONObject.put("status_code", i);
                    if (str2 != null) {
                        jSONObject.put("err_msg", com.ss.android.socialbase.downloader.m.d.a(str2, this.pZR.a("exception_msg_length", 500)));
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
                    jSONObject.put("pkg_name", this.pZI.D());
                    jSONObject.put("name", this.pZI.i());
                    if ((b2 == 1 || b2 == 3) && (eHU = b.eHU()) != null) {
                        eHU.a("download_io", jSONObject);
                    }
                    if ((b2 == 2 || b2 == 3) && (eHV = b.eHV()) != null) {
                        eHV.a(this.pZI, "download_io", jSONObject);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }
}
