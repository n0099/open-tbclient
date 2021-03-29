package d.o.a.e.b.k;

import android.annotation.SuppressLint;
import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.g.j;
import d.o.a.e.b.o.k;
import java.io.IOException;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.b f67090e;

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.b f67091f;

    /* renamed from: g  reason: collision with root package name */
    public d.o.a.e.b.g.f f67092g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadInfo f67093h;
    public final f i;
    public k j;
    public j k;
    public volatile boolean l;
    public volatile boolean m;
    public boolean n;

    public b(com.ss.android.socialbase.downloader.model.b bVar, d.o.a.e.b.n.a aVar, f fVar) {
        this.n = false;
        this.f67091f = bVar;
        if (aVar != null) {
            this.f67093h = aVar.H();
        }
        this.i = fVar;
        this.k = d.o.a.e.b.g.d.I0();
        this.f67091f.f(this);
    }

    public void a() {
        this.l = true;
        d.o.a.e.b.g.f fVar = this.f67092g;
        if (fVar != null) {
            fVar.h();
        }
    }

    public void b(long j, long j2) {
        d.o.a.e.b.g.f fVar = this.f67092g;
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
        com.ss.android.socialbase.downloader.exception.g f2;
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
                    String f3 = f();
                    boolean z3 = this.j != null;
                    this.n = z3;
                    bVar.m(z3);
                    try {
                        try {
                            if (!this.n) {
                                List<com.ss.android.socialbase.downloader.model.c> q = d.o.a.e.b.l.e.q(this.f67093h.S(), this.f67093h.U0(), j3, j4);
                                q.add(new com.ss.android.socialbase.downloader.model.c("Chunk-Index", String.valueOf(bVar.F())));
                                d.o.a.e.b.l.e.B(q, this.f67093h);
                                this.j = d.o.a.e.b.g.d.x(this.f67093h.A1(), this.f67093h.j0(), f3, q);
                            }
                            if (this.j != null) {
                                try {
                                    if (this.i != null) {
                                        try {
                                            int b2 = this.j.b();
                                            if (b2 < 200 || b2 >= 300) {
                                                this.i.b(this.j);
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
                                        this.i.e(e3);
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
                                        this.f67092g = new d.o.a.e.b.g.f(this.f67093h, f3, this.j, bVar, this.i);
                                        if (bVar2 != null) {
                                            long n = bVar2.n(false);
                                            if (j4 != 0 && j4 >= j3) {
                                                n = (j4 - j3) + 1;
                                            }
                                            this.f67092g.e(bVar2.A(), bVar2.C(), n);
                                        }
                                        try {
                                            this.f67092g.k();
                                            return true;
                                        } catch (BaseException e5) {
                                            e = e5;
                                            z2 = true;
                                            if (h()) {
                                                return true;
                                            }
                                            if (d.o.a.e.b.l.e.e0(e)) {
                                                this.i.g(e, z);
                                                return z;
                                            } else if (this.i.a(e)) {
                                                if (d.o.a.e.b.l.e.I(e)) {
                                                    this.i.g(e, true);
                                                    return z;
                                                }
                                                if (z2) {
                                                    if (this.f67092g != null) {
                                                        if (d.o.a.e.b.l.a.a(32)) {
                                                            j2 = this.f67092g.a() - this.f67092g.l();
                                                            int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                                                            if (i > 0) {
                                                                c(bVar, this.f67092g.l());
                                                            } else if (i < 0) {
                                                            }
                                                            if (!d.o.a.e.b.l.a.a(16)) {
                                                                f2 = this.i.c(bVar, e, j2);
                                                            } else {
                                                                f2 = this.i.f(e, j2);
                                                            }
                                                            if (f2 != com.ss.android.socialbase.downloader.exception.g.RETURN) {
                                                                return z;
                                                            }
                                                            bVar.m(z);
                                                            g();
                                                        } else {
                                                            long j6 = j;
                                                            j5 = this.f67092g.a() - j6;
                                                            c(bVar, j6);
                                                        }
                                                    } else {
                                                        this.i.e(e);
                                                        return z;
                                                    }
                                                }
                                                j2 = j5;
                                                if (!d.o.a.e.b.l.a.a(16)) {
                                                }
                                                if (f2 != com.ss.android.socialbase.downloader.exception.g.RETURN) {
                                                }
                                            } else if (this.f67093h.z1() && !this.f67093h.i1() && this.f67093h.B() > 1 && d.o.a.e.b.l.e.J(e, this.f67093h)) {
                                                this.i.d(e);
                                                return z;
                                            } else {
                                                this.i.e(e);
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
                            if (this.j != null && this.i != null) {
                                try {
                                    int b4 = this.j.b();
                                    if (b4 < 200 || b4 >= 300) {
                                        this.i.b(this.j);
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
        d.o.a.e.b.g.f fVar = this.f67092g;
        if (fVar != null) {
            fVar.j();
        }
    }

    public final String f() {
        return this.f67093h.C();
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
        r3.f67090e.i(false);
     */
    @Override // java.lang.Runnable
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        this.f67090e = this.f67091f;
        while (true) {
            try {
                this.f67090e.f(this);
                if (!d(this.f67090e)) {
                    break;
                }
                this.f67090e.i(false);
                if (!h()) {
                    this.f67090e = this.i.a(this.f67090e.F());
                    if (h() || this.f67090e == null) {
                        break;
                    }
                    Thread.sleep(50L);
                } else {
                    break;
                }
            } finally {
                com.ss.android.socialbase.downloader.model.b bVar = this.f67090e;
                if (bVar != null) {
                    bVar.i(false);
                }
                g();
                this.i.h(this);
            }
        }
    }

    public b(com.ss.android.socialbase.downloader.model.b bVar, d.o.a.e.b.n.a aVar, k kVar, f fVar) {
        this(bVar, aVar, fVar);
        this.j = kVar;
    }
}
