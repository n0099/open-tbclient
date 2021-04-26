package d.o.a.e.b.k;

import android.annotation.SuppressLint;
import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.g.j;
import d.o.a.e.b.o.k;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.b f66598e;

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.b f66599f;

    /* renamed from: g  reason: collision with root package name */
    public d.o.a.e.b.g.f f66600g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadInfo f66601h;

    /* renamed from: i  reason: collision with root package name */
    public final f f66602i;
    public k j;
    public j k;
    public volatile boolean l;
    public volatile boolean m;
    public boolean n;

    public b(com.ss.android.socialbase.downloader.model.b bVar, d.o.a.e.b.n.a aVar, f fVar) {
        this.n = false;
        this.f66599f = bVar;
        if (aVar != null) {
            this.f66601h = aVar.H();
        }
        this.f66602i = fVar;
        this.k = d.o.a.e.b.g.d.I0();
        this.f66599f.f(this);
    }

    public void a() {
        this.l = true;
        d.o.a.e.b.g.f fVar = this.f66600g;
        if (fVar != null) {
            fVar.h();
        }
    }

    public void b(long j, long j2) {
        d.o.a.e.b.g.f fVar = this.f66600g;
        if (fVar == null) {
            return;
        }
        fVar.d(j, j2);
    }

    public final void c(com.ss.android.socialbase.downloader.model.b bVar, long j) {
        com.ss.android.socialbase.downloader.model.b r = bVar.q() ? bVar.r() : bVar;
        if (r != null) {
            if (r.u()) {
                this.k.a(r.x(), r.j(), j);
            }
            r.l(j);
            this.k.a(r.x(), r.F(), r.j(), j);
        } else if (bVar.q()) {
            this.k.a(bVar.x(), bVar.F(), j);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0107, code lost:
        throw new com.ss.android.socialbase.downloader.exception.BaseException(1002, java.lang.String.format("Http response error , code is : %s ", java.lang.String.valueOf(r0)));
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01c6 A[Catch: all -> 0x028b, TRY_ENTER, TryCatch #8 {all -> 0x028b, BaseException -> 0x01ad, blocks: (B:125:0x01bc, B:129:0x01c6, B:131:0x01cc, B:134:0x01d5, B:136:0x01dd, B:138:0x01e3, B:142:0x01ee, B:144:0x01f2, B:146:0x01fa, B:148:0x020b, B:157:0x0233, B:159:0x0239, B:161:0x0246, B:165:0x024e, B:160:0x0240, B:151:0x0218, B:152:0x0226, B:167:0x0259, B:169:0x0261, B:171:0x0269, B:173:0x0271, B:175:0x0279, B:178:0x0282, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:191:0x01bc }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0239 A[Catch: all -> 0x028b, TryCatch #8 {all -> 0x028b, BaseException -> 0x01ad, blocks: (B:125:0x01bc, B:129:0x01c6, B:131:0x01cc, B:134:0x01d5, B:136:0x01dd, B:138:0x01e3, B:142:0x01ee, B:144:0x01f2, B:146:0x01fa, B:148:0x020b, B:157:0x0233, B:159:0x0239, B:161:0x0246, B:165:0x024e, B:160:0x0240, B:151:0x0218, B:152:0x0226, B:167:0x0259, B:169:0x0261, B:171:0x0269, B:173:0x0271, B:175:0x0279, B:178:0x0282, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:191:0x01bc }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0240 A[Catch: all -> 0x028b, TryCatch #8 {all -> 0x028b, BaseException -> 0x01ad, blocks: (B:125:0x01bc, B:129:0x01c6, B:131:0x01cc, B:134:0x01d5, B:136:0x01dd, B:138:0x01e3, B:142:0x01ee, B:144:0x01f2, B:146:0x01fa, B:148:0x020b, B:157:0x0233, B:159:0x0239, B:161:0x0246, B:165:0x024e, B:160:0x0240, B:151:0x0218, B:152:0x0226, B:167:0x0259, B:169:0x0261, B:171:0x0269, B:173:0x0271, B:175:0x0279, B:178:0x0282, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:191:0x01bc }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x024e A[Catch: all -> 0x028b, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x028b, BaseException -> 0x01ad, blocks: (B:125:0x01bc, B:129:0x01c6, B:131:0x01cc, B:134:0x01d5, B:136:0x01dd, B:138:0x01e3, B:142:0x01ee, B:144:0x01f2, B:146:0x01fa, B:148:0x020b, B:157:0x0233, B:159:0x0239, B:161:0x0246, B:165:0x024e, B:160:0x0240, B:151:0x0218, B:152:0x0226, B:167:0x0259, B:169:0x0261, B:171:0x0269, B:173:0x0271, B:175:0x0279, B:178:0x0282, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:191:0x01bc }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x024a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x01c2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(com.ss.android.socialbase.downloader.model.b bVar) {
        long j;
        boolean z;
        long j2;
        com.ss.android.socialbase.downloader.exception.g h2;
        com.ss.android.socialbase.downloader.model.b r;
        while (true) {
            com.ss.android.socialbase.downloader.model.b bVar2 = (bVar.q() && bVar.s() && (r = bVar.r()) != null && r.F() == bVar.F()) ? r : null;
            if (bVar2 != null && bVar2.v()) {
                return true;
            }
            long A = bVar.A();
            long C = bVar.C();
            long A2 = bVar.A();
            if (bVar2 != null) {
                A2 = bVar2.A();
                A = bVar2.A();
                C = bVar2.C();
            }
            long j3 = A;
            long j4 = C;
            long j5 = 0;
            boolean z2 = false;
            try {
                try {
                    if (h()) {
                        return false;
                    }
                    String f2 = f();
                    boolean z3 = this.j != null;
                    this.n = z3;
                    bVar.m(z3);
                    try {
                        try {
                            if (!this.n) {
                                List<com.ss.android.socialbase.downloader.model.c> q = d.o.a.e.b.l.e.q(this.f66601h.S(), this.f66601h.U0(), j3, j4);
                                q.add(new com.ss.android.socialbase.downloader.model.c("Chunk-Index", String.valueOf(bVar.F())));
                                d.o.a.e.b.l.e.B(q, this.f66601h);
                                this.j = d.o.a.e.b.g.d.x(this.f66601h.A1(), this.f66601h.j0(), f2, q);
                            }
                            if (this.j != null) {
                                try {
                                    if (this.f66602i != null) {
                                        try {
                                            int b2 = this.j.b();
                                            if (b2 < 200 || b2 >= 300) {
                                                this.f66602i.e(this.j);
                                            }
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                } catch (BaseException e2) {
                                    e = e2;
                                    j = A2;
                                    z = false;
                                    try {
                                        if (h()) {
                                        }
                                    } catch (BaseException e3) {
                                        this.f66602i.g(e3);
                                        return z;
                                    } finally {
                                        g();
                                    }
                                }
                            }
                            if (h()) {
                                return false;
                            }
                            if (this.j != null) {
                                if (!this.n) {
                                    try {
                                        int b3 = this.j.b();
                                        if (!d.o.a.e.b.l.e.z0(b3)) {
                                            break;
                                        }
                                    } catch (BaseException e4) {
                                        throw e4;
                                    } catch (Throwable th2) {
                                        d.o.a.e.b.l.e.A(th2, "ChunkRunnableGetResponseCode");
                                        throw null;
                                    }
                                }
                                z = false;
                                j = A2;
                                try {
                                    try {
                                        this.f66600g = new d.o.a.e.b.g.f(this.f66601h, f2, this.j, bVar, this.f66602i);
                                        if (bVar2 != null) {
                                            long n = bVar2.n(false);
                                            if (j4 != 0 && j4 >= j3) {
                                                n = (j4 - j3) + 1;
                                            }
                                            this.f66600g.e(bVar2.A(), bVar2.C(), n);
                                        }
                                        try {
                                            this.f66600g.k();
                                            return true;
                                        } catch (BaseException e5) {
                                            e = e5;
                                            z2 = true;
                                            if (h()) {
                                                return true;
                                            }
                                            if (d.o.a.e.b.l.e.e0(e)) {
                                                this.f66602i.i(e, z);
                                                return z;
                                            } else if (this.f66602i.a(e)) {
                                                if (d.o.a.e.b.l.e.I(e)) {
                                                    this.f66602i.i(e, true);
                                                    return z;
                                                }
                                                if (z2) {
                                                    if (this.f66600g != null) {
                                                        if (d.o.a.e.b.l.a.a(32)) {
                                                            j2 = this.f66600g.a() - this.f66600g.l();
                                                            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                                                            if (i2 > 0) {
                                                                c(bVar, this.f66600g.l());
                                                            } else if (i2 < 0) {
                                                            }
                                                            if (!d.o.a.e.b.l.a.a(16)) {
                                                                h2 = this.f66602i.b(bVar, e, j2);
                                                            } else {
                                                                h2 = this.f66602i.h(e, j2);
                                                            }
                                                            if (h2 != com.ss.android.socialbase.downloader.exception.g.RETURN) {
                                                                return z;
                                                            }
                                                            bVar.m(z);
                                                            g();
                                                        } else {
                                                            long j6 = j;
                                                            j5 = this.f66600g.a() - j6;
                                                            c(bVar, j6);
                                                        }
                                                    } else {
                                                        this.f66602i.g(e);
                                                        return z;
                                                    }
                                                }
                                                j2 = j5;
                                                if (!d.o.a.e.b.l.a.a(16)) {
                                                }
                                                if (h2 != com.ss.android.socialbase.downloader.exception.g.RETURN) {
                                                }
                                            } else if (this.f66601h.z1() && !this.f66601h.i1() && this.f66601h.B() > 1 && d.o.a.e.b.l.e.J(e, this.f66601h)) {
                                                this.f66602i.f(e);
                                                return z;
                                            } else {
                                                this.f66602i.g(e);
                                                return z;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        if (h()) {
                                            return true;
                                        }
                                        d.o.a.e.b.l.e.A(th, "downloadChunkInner");
                                        throw null;
                                    }
                                } catch (BaseException e6) {
                                    e = e6;
                                    z2 = false;
                                    if (h()) {
                                    }
                                }
                            } else {
                                throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                            }
                        } catch (Throwable th4) {
                            if (this.j != null && this.f66602i != null) {
                                try {
                                    int b4 = this.j.b();
                                    if (b4 < 200 || b4 >= 300) {
                                        this.f66602i.e(this.j);
                                    }
                                } catch (Throwable th5) {
                                    th5.printStackTrace();
                                }
                            }
                            throw th4;
                        }
                    } catch (BaseException e7) {
                        throw e7;
                    } catch (Throwable th6) {
                        d.o.a.e.b.l.e.A(th6, "ChunkRunnableConnection");
                        throw null;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    z = false;
                }
            } catch (BaseException e8) {
                e = e8;
                j = A2;
                z = false;
            }
        }
    }

    public void e() {
        this.m = true;
        d.o.a.e.b.g.f fVar = this.f66600g;
        if (fVar != null) {
            fVar.j();
        }
    }

    public final String f() {
        return this.f66601h.C();
    }

    public final void g() {
        k kVar = this.j;
        if (kVar != null) {
            kVar.d();
            this.j = null;
        }
    }

    public final boolean h() {
        return this.l || this.m;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
        r3.f66598e.i(false);
     */
    @Override // java.lang.Runnable
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        this.f66598e = this.f66599f;
        while (true) {
            try {
                this.f66598e.f(this);
                if (!d(this.f66598e)) {
                    break;
                }
                this.f66598e.i(false);
                if (!h()) {
                    this.f66598e = this.f66602i.a(this.f66598e.F());
                    if (h() || this.f66598e == null) {
                        break;
                    }
                    Thread.sleep(50L);
                } else {
                    break;
                }
            } finally {
                com.ss.android.socialbase.downloader.model.b bVar = this.f66598e;
                if (bVar != null) {
                    bVar.i(false);
                }
                g();
                this.f66602i.c(this);
            }
        }
    }

    public b(com.ss.android.socialbase.downloader.model.b bVar, d.o.a.e.b.n.a aVar, k kVar, f fVar) {
        this(bVar, aVar, fVar);
        this.j = kVar;
    }
}
