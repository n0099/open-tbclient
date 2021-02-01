package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.d.ah;
import com.ss.android.socialbase.downloader.d.t;
import java.util.List;
/* loaded from: classes6.dex */
public class p implements com.ss.android.socialbase.downloader.downloader.n {
    private final boolean d;
    private final com.ss.android.socialbase.downloader.downloader.k qeH;
    private final com.ss.android.socialbase.downloader.downloader.p qgW;
    private final a qgZ;

    public p() {
        this(false);
    }

    public p(boolean z) {
        this.qgZ = com.ss.android.socialbase.downloader.downloader.b.eGp();
        this.qeH = com.ss.android.socialbase.downloader.downloader.b.eGk();
        if (!z) {
            this.qgW = com.ss.android.socialbase.downloader.downloader.b.eGl();
        } else {
            this.qgW = com.ss.android.socialbase.downloader.downloader.b.eGm();
        }
        this.d = com.ss.android.socialbase.downloader.k.a.eIx().b("judge_service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i) {
        if (this.qgZ != null) {
            this.qgZ.e(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, boolean z) {
        if (this.qgZ != null) {
            this.qgZ.a(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b(int i) {
        if (this.qgZ != null) {
            return this.qgZ.n(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i) {
        if (this.qgZ != null) {
            this.qgZ.f(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d(int i) {
        if (this.qgZ != null) {
            this.qgZ.g(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a() {
        if (this.qgZ != null) {
            this.qgZ.b();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        if (this.qeH != null) {
            return this.qeH.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(List<String> list) {
        if (this.qgZ != null) {
            this.qgZ.a(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(List<String> list) {
        if (this.qgZ != null) {
            this.qgZ.b(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public long e(int i) {
        com.ss.android.socialbase.downloader.g.c b2;
        if (this.qeH == null || (b2 = this.qeH.b(i)) == null) {
            return 0L;
        }
        int eHM = b2.eHM();
        if (eHM <= 1) {
            return b2.eHa();
        }
        List<com.ss.android.socialbase.downloader.g.b> c = this.qeH.c(i);
        if (c == null || c.size() != eHM) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.m.d.b(c);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int f(int i) {
        com.ss.android.socialbase.downloader.g.c RP;
        if (this.qgZ == null || (RP = this.qgZ.RP(i)) == null) {
            return 0;
        }
        return RP.q();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g(int i) {
        if (this.qgZ != null) {
            return this.qgZ.a(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        if (this.qgZ != null) {
            return this.qgZ.RP(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        if (this.qgZ != null) {
            return this.qgZ.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.b> i(int i) {
        return this.qeH.c(i);
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
        if (this.qeH != null) {
            return this.qeH.c(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, boolean z) {
        if (this.qgZ != null) {
            this.qgZ.b(i, z);
        }
    }

    public void d(int i, boolean z) {
        if (this.qgZ != null) {
            this.qgZ.c(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void j(int i) {
        if (this.qgZ != null) {
            this.qgZ.m(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.qgZ != null) {
            this.qgZ.b(i, i2, bVar, hVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z, boolean z2) {
        if (this.qgZ != null) {
            this.qgZ.a(i, i2, bVar, hVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.qgZ != null) {
            this.qgZ.a(i, i2, bVar, hVar, z);
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
        if (this.qgW != null) {
            this.qgW.a(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(boolean z, boolean z2) {
        if (this.qgW != null) {
            this.qgW.a(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b() {
        if (this.qgW != null) {
            return this.qgW.b();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c() {
        return com.ss.android.socialbase.downloader.downloader.b.H();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        if (this.qeH != null) {
            return this.qeH.d(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> e(String str) {
        if (this.qgZ != null) {
            return this.qgZ.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.d dVar) {
        if (this.qgW != null) {
            this.qgW.b(dVar);
        } else if (dVar != null) {
            com.ss.android.socialbase.downloader.h.a.a(dVar.eIc(), dVar.a(), new com.ss.android.socialbase.downloader.e.a(1003, "downloadServiceHandler is null"), dVar.a() != null ? dVar.a().q() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.d dVar) {
        if (this.qgW != null) {
            this.qgW.c(dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean Rv(int i) {
        if (this.qgZ != null) {
            return this.qgZ.k(i);
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
        return this.qeH.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        this.qeH.b(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        this.qeH.a(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.c.eGy().a(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int m(int i) {
        return com.ss.android.socialbase.downloader.downloader.c.eGy().a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        this.qeH.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
        return this.qeH.a(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean n(int i) {
        return this.qeH.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void o(int i) {
        this.qeH.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, long j) {
        this.qeH.a(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, long j) {
        this.qeH.a(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, int i4) {
        this.qeH.a(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean p(int i) {
        return this.qeH.f(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void f() {
        this.qeH.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        this.qeH.b(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g() {
        return this.d && this.qgW != null && this.qgW.a();
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
    public com.ss.android.socialbase.downloader.d.d Rw(int i) {
        if (this.qgZ != null) {
            return this.qgZ.Rs(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.r Rx(int i) {
        com.ss.android.socialbase.downloader.d.r rVar = null;
        if (this.qgZ != null) {
            rVar = this.qgZ.RQ(i);
        }
        if (rVar == null) {
            return com.ss.android.socialbase.downloader.downloader.b.eGr();
        }
        return rVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, com.ss.android.socialbase.downloader.d.d dVar) {
        if (this.qgZ != null) {
            this.qgZ.a(i, dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public ah Ry(int i) {
        if (this.qgZ != null) {
            return this.qgZ.RR(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, long j) {
        if (this.qgZ != null) {
            this.qgZ.b(i, j);
        }
    }
}
