package d.o.a.e.b.m;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.u;
import java.util.List;
/* loaded from: classes7.dex */
public class o implements d.o.a.e.b.g.m {

    /* renamed from: a  reason: collision with root package name */
    public final a f71195a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.g.j f71196b;

    /* renamed from: c  reason: collision with root package name */
    public final d.o.a.e.b.g.o f71197c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f71198d;

    public o() {
        this(false);
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.G(i2);
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean b(int i2) {
        a aVar = this.f71195a;
        if (aVar != null) {
            return aVar.P(i2);
        }
        return false;
    }

    @Override // d.o.a.e.b.g.m
    public void c(int i2) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.H(i2);
        }
    }

    @Override // d.o.a.e.b.g.m
    public void d() {
    }

    @Override // d.o.a.e.b.g.m
    public void d(int i2) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.I(i2);
        }
    }

    @Override // d.o.a.e.b.g.m
    public long e(int i2) {
        DownloadInfo b2;
        d.o.a.e.b.g.j jVar = this.f71196b;
        if (jVar == null || (b2 = jVar.b(i2)) == null) {
            return 0L;
        }
        int B = b2.B();
        if (B <= 1) {
            return b2.E();
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = this.f71196b.c(i2);
        if (c2 == null || c2.size() != B) {
            return 0L;
        }
        return d.o.a.e.b.l.e.U(c2);
    }

    @Override // d.o.a.e.b.g.m
    public int f(int i2) {
        DownloadInfo D;
        a aVar = this.f71195a;
        if (aVar == null || (D = aVar.D(i2)) == null) {
            return 0;
        }
        return D.H0();
    }

    @Override // d.o.a.e.b.g.m
    public boolean g(int i2) {
        a aVar = this.f71195a;
        if (aVar != null) {
            return aVar.p(i2);
        }
        return false;
    }

    @Override // d.o.a.e.b.g.m
    public DownloadInfo h(int i2) {
        a aVar = this.f71195a;
        if (aVar != null) {
            return aVar.D(i2);
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public List<com.ss.android.socialbase.downloader.model.b> i(int i2) {
        return this.f71196b.c(i2);
    }

    @Override // d.o.a.e.b.g.m
    public void j(int i2) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.O(i2);
        }
    }

    @Override // d.o.a.e.b.g.m
    public void k(int i2) {
        d.o.a.e.b.c.a.a(i2);
    }

    @Override // d.o.a.e.b.g.m
    public boolean l(int i2) {
        a aVar = this.f71195a;
        if (aVar != null) {
            return aVar.M(i2);
        }
        return false;
    }

    @Override // d.o.a.e.b.g.m
    public int m(int i2) {
        return d.o.a.e.b.g.e.c().a(i2);
    }

    @Override // d.o.a.e.b.g.m
    public boolean n(int i2) {
        return this.f71196b.e(i2);
    }

    @Override // d.o.a.e.b.g.m
    public void o(int i2) {
        this.f71196b.d(i2);
    }

    @Override // d.o.a.e.b.g.m
    public boolean p(int i2) {
        return this.f71196b.f(i2);
    }

    @Override // d.o.a.e.b.g.m
    public d.o.a.e.b.f.d q(int i2) {
        a aVar = this.f71195a;
        if (aVar != null) {
            return aVar.K(i2);
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public d.o.a.e.b.f.i r(int i2) {
        a aVar = this.f71195a;
        d.o.a.e.b.f.i J = aVar != null ? aVar.J(i2) : null;
        return J == null ? d.o.a.e.b.g.d.i() : J;
    }

    @Override // d.o.a.e.b.g.m
    public u s(int i2) {
        a aVar = this.f71195a;
        if (aVar != null) {
            return aVar.L(i2);
        }
        return null;
    }

    public o(boolean z) {
        this.f71195a = d.o.a.e.b.g.d.c();
        this.f71196b = d.o.a.e.b.g.d.I0();
        if (!z) {
            this.f71197c = d.o.a.e.b.g.d.J0();
        } else {
            this.f71197c = d.o.a.e.b.g.d.K0();
        }
        this.f71198d = d.o.a.e.b.j.a.r().q("service_alive", false);
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, boolean z) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.q(i2, z);
        }
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> b(String str) {
        d.o.a.e.b.g.j jVar = this.f71196b;
        if (jVar != null) {
            return jVar.b(str);
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> c(String str) {
        d.o.a.e.b.g.j jVar = this.f71196b;
        if (jVar != null) {
            return jVar.c(str);
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public void d(int i2, int i3, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z, boolean z2) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.e(i2, i3, bVar, gVar, z, z2);
        }
    }

    @Override // d.o.a.e.b.g.m
    public void g(int i2, int i3, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.d(i2, i3, bVar, gVar, z);
        }
    }

    public void h(int i2, boolean z) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.C(i2, z);
        }
    }

    @Override // d.o.a.e.b.g.m
    public void f(int i2, int i3, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.u(i2, i3, bVar, gVar, z);
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a() {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.s();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void b(List<String> list) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.z(list);
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean c() {
        return d.o.a.e.b.g.d.m();
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> d(String str) {
        d.o.a.e.b.g.j jVar = this.f71196b;
        if (jVar != null) {
            return jVar.d(str);
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public boolean g() {
        d.o.a.e.b.g.o oVar;
        return this.f71198d && (oVar = this.f71197c) != null && oVar.a();
    }

    @Override // d.o.a.e.b.g.m
    public void c(int i2, boolean z) {
        d.o.a.e.b.g.e.c().h(i2, z);
    }

    @Override // d.o.a.e.b.g.m
    public void f() {
        this.f71196b.b();
    }

    @Override // d.o.a.e.b.g.m
    public void a(List<String> list) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.o(list);
        }
    }

    @Override // d.o.a.e.b.g.m
    public DownloadInfo b(String str, String str2) {
        return h(d.o.a.e.b.g.d.s(str, str2));
    }

    @Override // d.o.a.e.b.g.m
    public boolean c(DownloadInfo downloadInfo) {
        return this.f71196b.a(downloadInfo);
    }

    @Override // d.o.a.e.b.g.m
    public void c(int i2, d.o.a.e.b.f.d dVar) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.g(i2, dVar);
        }
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> e(String str) {
        a aVar = this.f71195a;
        if (aVar != null) {
            return aVar.r(str);
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> a(String str) {
        a aVar = this.f71195a;
        if (aVar != null) {
            return aVar.b(str);
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public void b(int i2, boolean z) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.w(i2, z);
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean e() {
        return this.f71196b.c();
    }

    @Override // d.o.a.e.b.g.m
    public int a(String str, String str2) {
        return d.o.a.e.b.g.d.s(str, str2);
    }

    @Override // d.o.a.e.b.g.m
    public boolean b() {
        d.o.a.e.b.g.o oVar = this.f71197c;
        if (oVar != null) {
            return oVar.b();
        }
        return false;
    }

    @Override // d.o.a.e.b.g.m
    public void e(d.o.a.e.b.f.k kVar) {
        d.o.a.e.b.g.d.E(kVar);
    }

    @Override // d.o.a.e.b.g.m
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean G = d.o.a.e.b.l.e.G(downloadInfo.H0(), downloadInfo.F0(), downloadInfo.q0());
        if (G) {
            if (d.o.a.e.b.l.a.a(33554432)) {
                b(downloadInfo.c0(), true);
            } else {
                h(downloadInfo.c0(), true);
            }
        }
        return G;
    }

    @Override // d.o.a.e.b.g.m
    public void b(d.o.a.e.b.n.a aVar) {
        d.o.a.e.b.g.o oVar = this.f71197c;
        if (oVar != null) {
            oVar.a(aVar);
        } else if (aVar != null) {
            d.o.a.e.b.e.a.e(aVar.O(), aVar.H(), new BaseException(1003, "downloadServiceHandler is null"), aVar.H() != null ? aVar.H().H0() : 0);
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, Notification notification) {
        d.o.a.e.b.g.o oVar = this.f71197c;
        if (oVar != null) {
            oVar.a(i2, notification);
        }
    }

    @Override // d.o.a.e.b.g.m
    public void b(DownloadInfo downloadInfo) {
        this.f71196b.b(downloadInfo);
    }

    @Override // d.o.a.e.b.g.m
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        this.f71196b.b(i2, list);
    }

    @Override // d.o.a.e.b.g.m
    public void a(boolean z, boolean z2) {
        d.o.a.e.b.g.o oVar = this.f71197c;
        if (oVar != null) {
            oVar.a(z2);
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(d.o.a.e.b.n.a aVar) {
        d.o.a.e.b.g.o oVar = this.f71197c;
        if (oVar != null) {
            oVar.b(aVar);
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        this.f71196b.a(i2, list);
    }

    @Override // d.o.a.e.b.g.m
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        this.f71196b.a(bVar);
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, int i3, long j) {
        this.f71196b.a(i2, i3, j);
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, int i3, int i4, long j) {
        this.f71196b.a(i2, i3, i4, j);
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, int i3, int i4, int i5) {
        this.f71196b.a(i2, i3, i4, i5);
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, int i3) {
        if (d.o.a.e.b.g.d.l0() != null) {
            for (d.o.a.e.b.f.k kVar : d.o.a.e.b.g.d.l0()) {
                if (kVar != null) {
                    kVar.a(i3, i2);
                }
            }
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, long j) {
        a aVar = this.f71195a;
        if (aVar != null) {
            aVar.v(i2, j);
        }
    }
}
