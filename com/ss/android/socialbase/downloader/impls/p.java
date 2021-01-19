package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.d.ah;
import com.ss.android.socialbase.downloader.d.t;
import java.util.List;
/* loaded from: classes4.dex */
public class p implements com.ss.android.socialbase.downloader.downloader.n {
    private final boolean d;
    private final com.ss.android.socialbase.downloader.downloader.k pUD;
    private final com.ss.android.socialbase.downloader.downloader.p pWS;
    private final a pWV;

    public p() {
        this(false);
    }

    public p(boolean z) {
        this.pWV = com.ss.android.socialbase.downloader.downloader.b.eDY();
        this.pUD = com.ss.android.socialbase.downloader.downloader.b.eDT();
        if (!z) {
            this.pWS = com.ss.android.socialbase.downloader.downloader.b.eDU();
        } else {
            this.pWS = com.ss.android.socialbase.downloader.downloader.b.eDV();
        }
        this.d = com.ss.android.socialbase.downloader.k.a.eGg().b("judge_service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i) {
        if (this.pWV != null) {
            this.pWV.e(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, boolean z) {
        if (this.pWV != null) {
            this.pWV.a(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b(int i) {
        if (this.pWV != null) {
            return this.pWV.n(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i) {
        if (this.pWV != null) {
            this.pWV.f(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d(int i) {
        if (this.pWV != null) {
            this.pWV.g(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a() {
        if (this.pWV != null) {
            this.pWV.b();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        if (this.pUD != null) {
            return this.pUD.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(List<String> list) {
        if (this.pWV != null) {
            this.pWV.a(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(List<String> list) {
        if (this.pWV != null) {
            this.pWV.b(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public long e(int i) {
        com.ss.android.socialbase.downloader.g.c b2;
        if (this.pUD == null || (b2 = this.pUD.b(i)) == null) {
            return 0L;
        }
        int eFv = b2.eFv();
        if (eFv <= 1) {
            return b2.eEJ();
        }
        List<com.ss.android.socialbase.downloader.g.b> c = this.pUD.c(i);
        if (c == null || c.size() != eFv) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.m.d.b(c);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int f(int i) {
        com.ss.android.socialbase.downloader.g.c Ru;
        if (this.pWV == null || (Ru = this.pWV.Ru(i)) == null) {
            return 0;
        }
        return Ru.q();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g(int i) {
        if (this.pWV != null) {
            return this.pWV.a(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        if (this.pWV != null) {
            return this.pWV.Ru(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        if (this.pWV != null) {
            return this.pWV.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.b> i(int i) {
        return this.pUD.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.g.c b(String str, String str2) {
        return h(com.ss.android.socialbase.downloader.downloader.b.a(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int a(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.b.a(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        if (this.pUD != null) {
            return this.pUD.c(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, boolean z) {
        if (this.pWV != null) {
            this.pWV.b(i, z);
        }
    }

    public void d(int i, boolean z) {
        if (this.pWV != null) {
            this.pWV.c(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void j(int i) {
        if (this.pWV != null) {
            this.pWV.m(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.pWV != null) {
            this.pWV.b(i, i2, bVar, hVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z, boolean z2) {
        if (this.pWV != null) {
            this.pWV.a(i, i2, bVar, hVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.pWV != null) {
            this.pWV.a(i, i2, bVar, hVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean s = com.ss.android.socialbase.downloader.m.d.s(cVar.q(), cVar.k(), cVar.h());
        if (s) {
            if (com.ss.android.socialbase.downloader.m.a.a(33554432)) {
                b(cVar.g(), true);
                return s;
            }
            d(cVar.g(), true);
            return s;
        }
        return s;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, Notification notification) {
        if (this.pWS != null) {
            this.pWS.a(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(boolean z, boolean z2) {
        if (this.pWS != null) {
            this.pWS.a(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b() {
        if (this.pWS != null) {
            return this.pWS.b();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c() {
        return com.ss.android.socialbase.downloader.downloader.b.H();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        if (this.pUD != null) {
            return this.pUD.d(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> e(String str) {
        if (this.pWV != null) {
            return this.pWV.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.d dVar) {
        if (this.pWS != null) {
            this.pWS.b(dVar);
        } else if (dVar != null) {
            com.ss.android.socialbase.downloader.h.a.a(dVar.eFL(), dVar.a(), new com.ss.android.socialbase.downloader.e.a(1003, "downloadServiceHandler is null"), dVar.a() != null ? dVar.a().q() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.d dVar) {
        if (this.pWS != null) {
            this.pWS.c(dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean Ra(int i) {
        if (this.pWV != null) {
            return this.pWV.k(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void k(int i) {
        com.ss.android.socialbase.downloader.f.a.a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean e() {
        return this.pUD.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        this.pUD.b(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        this.pUD.a(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.c.eEh().a(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int m(int i) {
        return com.ss.android.socialbase.downloader.downloader.c.eEh().a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        this.pUD.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
        return this.pUD.a(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean n(int i) {
        return this.pUD.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void o(int i) {
        this.pUD.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, long j) {
        this.pUD.a(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, long j) {
        this.pUD.a(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, int i4) {
        this.pUD.a(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean p(int i) {
        return this.pUD.f(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void f() {
        this.pUD.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        this.pUD.b(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g() {
        return this.d && this.pWS != null && this.pWS.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(t tVar) {
        com.ss.android.socialbase.downloader.downloader.b.a(tVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2) {
        if (com.ss.android.socialbase.downloader.downloader.b.d() != null) {
            for (t tVar : com.ss.android.socialbase.downloader.downloader.b.d()) {
                if (tVar != null) {
                    tVar.a(i2, i);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.d Rb(int i) {
        if (this.pWV != null) {
            return this.pWV.QX(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.r Rc(int i) {
        com.ss.android.socialbase.downloader.d.r rVar = null;
        if (this.pWV != null) {
            rVar = this.pWV.Rv(i);
        }
        if (rVar == null) {
            return com.ss.android.socialbase.downloader.downloader.b.eEa();
        }
        return rVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, com.ss.android.socialbase.downloader.d.d dVar) {
        if (this.pWV != null) {
            this.pWV.a(i, dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public ah Rd(int i) {
        if (this.pWV != null) {
            return this.pWV.Rw(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, long j) {
        if (this.pWV != null) {
            this.pWV.b(i, j);
        }
    }
}
