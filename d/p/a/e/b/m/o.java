package d.p.a.e.b.m;

import android.app.Notification;
import com.baidubce.auth.NTLMEngineImpl;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.e.b.f.u;
import java.util.List;
/* loaded from: classes6.dex */
public class o implements d.p.a.e.b.g.m {

    /* renamed from: a  reason: collision with root package name */
    public final a f68307a;

    /* renamed from: b  reason: collision with root package name */
    public final d.p.a.e.b.g.j f68308b;

    /* renamed from: c  reason: collision with root package name */
    public final d.p.a.e.b.g.o f68309c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f68310d;

    public o() {
        this(false);
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.G(i);
        }
    }

    @Override // d.p.a.e.b.g.m
    public boolean b(int i) {
        a aVar = this.f68307a;
        if (aVar != null) {
            return aVar.P(i);
        }
        return false;
    }

    @Override // d.p.a.e.b.g.m
    public void c(int i) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.H(i);
        }
    }

    @Override // d.p.a.e.b.g.m
    public void d() {
    }

    @Override // d.p.a.e.b.g.m
    public void d(int i) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.I(i);
        }
    }

    @Override // d.p.a.e.b.g.m
    public long e(int i) {
        DownloadInfo b2;
        d.p.a.e.b.g.j jVar = this.f68308b;
        if (jVar == null || (b2 = jVar.b(i)) == null) {
            return 0L;
        }
        int B = b2.B();
        if (B <= 1) {
            return b2.E();
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = this.f68308b.c(i);
        if (c2 == null || c2.size() != B) {
            return 0L;
        }
        return d.p.a.e.b.l.e.U(c2);
    }

    @Override // d.p.a.e.b.g.m
    public int f(int i) {
        DownloadInfo D;
        a aVar = this.f68307a;
        if (aVar == null || (D = aVar.D(i)) == null) {
            return 0;
        }
        return D.H0();
    }

    @Override // d.p.a.e.b.g.m
    public boolean g(int i) {
        a aVar = this.f68307a;
        if (aVar != null) {
            return aVar.p(i);
        }
        return false;
    }

    @Override // d.p.a.e.b.g.m
    public DownloadInfo h(int i) {
        a aVar = this.f68307a;
        if (aVar != null) {
            return aVar.D(i);
        }
        return null;
    }

    @Override // d.p.a.e.b.g.m
    public List<com.ss.android.socialbase.downloader.model.b> i(int i) {
        return this.f68308b.c(i);
    }

    @Override // d.p.a.e.b.g.m
    public void j(int i) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.O(i);
        }
    }

    @Override // d.p.a.e.b.g.m
    public void k(int i) {
        d.p.a.e.b.c.a.a(i);
    }

    @Override // d.p.a.e.b.g.m
    public boolean l(int i) {
        a aVar = this.f68307a;
        if (aVar != null) {
            return aVar.M(i);
        }
        return false;
    }

    @Override // d.p.a.e.b.g.m
    public int m(int i) {
        return d.p.a.e.b.g.e.c().a(i);
    }

    @Override // d.p.a.e.b.g.m
    public boolean n(int i) {
        return this.f68308b.e(i);
    }

    @Override // d.p.a.e.b.g.m
    public void o(int i) {
        this.f68308b.d(i);
    }

    @Override // d.p.a.e.b.g.m
    public boolean p(int i) {
        return this.f68308b.f(i);
    }

    @Override // d.p.a.e.b.g.m
    public d.p.a.e.b.f.d q(int i) {
        a aVar = this.f68307a;
        if (aVar != null) {
            return aVar.K(i);
        }
        return null;
    }

    @Override // d.p.a.e.b.g.m
    public d.p.a.e.b.f.i r(int i) {
        a aVar = this.f68307a;
        d.p.a.e.b.f.i J = aVar != null ? aVar.J(i) : null;
        return J == null ? d.p.a.e.b.g.d.i() : J;
    }

    @Override // d.p.a.e.b.g.m
    public u s(int i) {
        a aVar = this.f68307a;
        if (aVar != null) {
            return aVar.L(i);
        }
        return null;
    }

    public o(boolean z) {
        this.f68307a = d.p.a.e.b.g.d.c();
        this.f68308b = d.p.a.e.b.g.d.I0();
        if (!z) {
            this.f68309c = d.p.a.e.b.g.d.J0();
        } else {
            this.f68309c = d.p.a.e.b.g.d.K0();
        }
        this.f68310d = d.p.a.e.b.j.a.r().q("service_alive", false);
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, boolean z) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.q(i, z);
        }
    }

    @Override // d.p.a.e.b.g.m
    public List<DownloadInfo> b(String str) {
        d.p.a.e.b.g.j jVar = this.f68308b;
        if (jVar != null) {
            return jVar.b(str);
        }
        return null;
    }

    @Override // d.p.a.e.b.g.m
    public List<DownloadInfo> c(String str) {
        d.p.a.e.b.g.j jVar = this.f68308b;
        if (jVar != null) {
            return jVar.c(str);
        }
        return null;
    }

    @Override // d.p.a.e.b.g.m
    public List<DownloadInfo> d(String str) {
        d.p.a.e.b.g.j jVar = this.f68308b;
        if (jVar != null) {
            return jVar.d(str);
        }
        return null;
    }

    @Override // d.p.a.e.b.g.m
    public void g(int i, int i2, d.p.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.d(i, i2, bVar, gVar, z);
        }
    }

    public void h(int i, boolean z) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.C(i, z);
        }
    }

    @Override // d.p.a.e.b.g.m
    public void f(int i, int i2, d.p.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.u(i, i2, bVar, gVar, z);
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a() {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.s();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void b(List<String> list) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.z(list);
        }
    }

    @Override // d.p.a.e.b.g.m
    public void c(int i, int i2, d.p.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z, boolean z2) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.e(i, i2, bVar, gVar, z, z2);
        }
    }

    @Override // d.p.a.e.b.g.m
    public void d(d.p.a.e.b.f.k kVar) {
        d.p.a.e.b.g.d.E(kVar);
    }

    @Override // d.p.a.e.b.g.m
    public boolean g() {
        d.p.a.e.b.g.o oVar;
        return this.f68310d && (oVar = this.f68309c) != null && oVar.a();
    }

    @Override // d.p.a.e.b.g.m
    public void f() {
        this.f68308b.b();
    }

    @Override // d.p.a.e.b.g.m
    public void a(List<String> list) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.o(list);
        }
    }

    @Override // d.p.a.e.b.g.m
    public DownloadInfo b(String str, String str2) {
        return h(d.p.a.e.b.g.d.s(str, str2));
    }

    @Override // d.p.a.e.b.g.m
    public boolean c() {
        return d.p.a.e.b.g.d.m();
    }

    @Override // d.p.a.e.b.g.m
    public void c(int i, boolean z) {
        d.p.a.e.b.g.e.c().h(i, z);
    }

    @Override // d.p.a.e.b.g.m
    public List<DownloadInfo> e(String str) {
        a aVar = this.f68307a;
        if (aVar != null) {
            return aVar.r(str);
        }
        return null;
    }

    @Override // d.p.a.e.b.g.m
    public List<DownloadInfo> a(String str) {
        a aVar = this.f68307a;
        if (aVar != null) {
            return aVar.b(str);
        }
        return null;
    }

    @Override // d.p.a.e.b.g.m
    public void b(int i, boolean z) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.w(i, z);
        }
    }

    @Override // d.p.a.e.b.g.m
    public boolean c(DownloadInfo downloadInfo) {
        return this.f68308b.a(downloadInfo);
    }

    @Override // d.p.a.e.b.g.m
    public void e(d.p.a.e.b.n.a aVar) {
        d.p.a.e.b.g.o oVar = this.f68309c;
        if (oVar != null) {
            oVar.a(aVar);
        } else if (aVar != null) {
            d.p.a.e.b.e.a.e(aVar.O(), aVar.H(), new BaseException(1003, "downloadServiceHandler is null"), aVar.H() != null ? aVar.H().H0() : 0);
        }
    }

    @Override // d.p.a.e.b.g.m
    public int a(String str, String str2) {
        return d.p.a.e.b.g.d.s(str, str2);
    }

    @Override // d.p.a.e.b.g.m
    public boolean b() {
        d.p.a.e.b.g.o oVar = this.f68309c;
        if (oVar != null) {
            return oVar.b();
        }
        return false;
    }

    @Override // d.p.a.e.b.g.m
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean G = d.p.a.e.b.l.e.G(downloadInfo.H0(), downloadInfo.F0(), downloadInfo.q0());
        if (G) {
            if (d.p.a.e.b.l.a.a(NTLMEngineImpl.FLAG_REQUEST_VERSION)) {
                b(downloadInfo.c0(), true);
            } else {
                h(downloadInfo.c0(), true);
            }
        }
        return G;
    }

    @Override // d.p.a.e.b.g.m
    public void b(DownloadInfo downloadInfo) {
        this.f68308b.b(downloadInfo);
    }

    @Override // d.p.a.e.b.g.m
    public boolean e() {
        return this.f68308b.c();
    }

    @Override // d.p.a.e.b.g.m
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        this.f68308b.b(i, list);
    }

    @Override // d.p.a.e.b.g.m
    public void b(int i, d.p.a.e.b.f.d dVar) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.g(i, dVar);
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, Notification notification) {
        d.p.a.e.b.g.o oVar = this.f68309c;
        if (oVar != null) {
            oVar.a(i, notification);
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(boolean z, boolean z2) {
        d.p.a.e.b.g.o oVar = this.f68309c;
        if (oVar != null) {
            oVar.a(z2);
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(d.p.a.e.b.n.a aVar) {
        d.p.a.e.b.g.o oVar = this.f68309c;
        if (oVar != null) {
            oVar.b(aVar);
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        this.f68308b.a(i, list);
    }

    @Override // d.p.a.e.b.g.m
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        this.f68308b.a(bVar);
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, int i2, long j) {
        this.f68308b.a(i, i2, j);
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, int i2, int i3, long j) {
        this.f68308b.a(i, i2, i3, j);
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, int i2, int i3, int i4) {
        this.f68308b.a(i, i2, i3, i4);
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, int i2) {
        if (d.p.a.e.b.g.d.l0() != null) {
            for (d.p.a.e.b.f.k kVar : d.p.a.e.b.g.d.l0()) {
                if (kVar != null) {
                    kVar.a(i2, i);
                }
            }
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, long j) {
        a aVar = this.f68307a;
        if (aVar != null) {
            aVar.v(i, j);
        }
    }
}
