package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.d.ah;
import com.ss.android.socialbase.downloader.d.t;
import java.util.List;
/* loaded from: classes6.dex */
public class p implements com.ss.android.socialbase.downloader.downloader.n {
    private final boolean d;
    private final com.ss.android.socialbase.downloader.downloader.k qfW;
    private final com.ss.android.socialbase.downloader.downloader.p qin;
    private final a qiq;

    public p() {
        this(false);
    }

    public p(boolean z) {
        this.qiq = com.ss.android.socialbase.downloader.downloader.b.eGB();
        this.qfW = com.ss.android.socialbase.downloader.downloader.b.eGw();
        if (!z) {
            this.qin = com.ss.android.socialbase.downloader.downloader.b.eGx();
        } else {
            this.qin = com.ss.android.socialbase.downloader.downloader.b.eGy();
        }
        this.d = com.ss.android.socialbase.downloader.k.a.eIH().b("judge_service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i) {
        if (this.qiq != null) {
            this.qiq.e(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, boolean z) {
        if (this.qiq != null) {
            this.qiq.a(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b(int i) {
        if (this.qiq != null) {
            return this.qiq.n(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i) {
        if (this.qiq != null) {
            this.qiq.f(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d(int i) {
        if (this.qiq != null) {
            this.qiq.g(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a() {
        if (this.qiq != null) {
            this.qiq.b();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        if (this.qfW != null) {
            return this.qfW.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(List<String> list) {
        if (this.qiq != null) {
            this.qiq.a(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(List<String> list) {
        if (this.qiq != null) {
            this.qiq.b(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public long e(int i) {
        com.ss.android.socialbase.downloader.g.c b;
        if (this.qfW == null || (b = this.qfW.b(i)) == null) {
            return 0L;
        }
        int eHW = b.eHW();
        if (eHW <= 1) {
            return b.eHm();
        }
        List<com.ss.android.socialbase.downloader.g.b> c = this.qfW.c(i);
        if (c == null || c.size() != eHW) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.m.d.b(c);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int f(int i) {
        com.ss.android.socialbase.downloader.g.c RU;
        if (this.qiq == null || (RU = this.qiq.RU(i)) == null) {
            return 0;
        }
        return RU.q();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g(int i) {
        if (this.qiq != null) {
            return this.qiq.a(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        if (this.qiq != null) {
            return this.qiq.RU(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        if (this.qiq != null) {
            return this.qiq.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.b> i(int i) {
        return this.qfW.c(i);
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
        if (this.qfW != null) {
            return this.qfW.c(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, boolean z) {
        if (this.qiq != null) {
            this.qiq.b(i, z);
        }
    }

    public void d(int i, boolean z) {
        if (this.qiq != null) {
            this.qiq.c(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void j(int i) {
        if (this.qiq != null) {
            this.qiq.m(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.qiq != null) {
            this.qiq.b(i, i2, bVar, hVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z, boolean z2) {
        if (this.qiq != null) {
            this.qiq.a(i, i2, bVar, hVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.qiq != null) {
            this.qiq.a(i, i2, bVar, hVar, z);
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
        if (this.qin != null) {
            this.qin.a(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(boolean z, boolean z2) {
        if (this.qin != null) {
            this.qin.a(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b() {
        if (this.qin != null) {
            return this.qin.b();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c() {
        return com.ss.android.socialbase.downloader.downloader.b.H();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        if (this.qfW != null) {
            return this.qfW.d(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> e(String str) {
        if (this.qiq != null) {
            return this.qiq.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.d dVar) {
        if (this.qin != null) {
            this.qin.b(dVar);
        } else if (dVar != null) {
            com.ss.android.socialbase.downloader.h.a.a(dVar.eIm(), dVar.a(), new com.ss.android.socialbase.downloader.e.a(1003, "downloadServiceHandler is null"), dVar.a() != null ? dVar.a().q() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.d dVar) {
        if (this.qin != null) {
            this.qin.c(dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean RA(int i) {
        if (this.qiq != null) {
            return this.qiq.k(i);
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
        return this.qfW.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        this.qfW.b(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        this.qfW.a(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.c.eGK().a(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int m(int i) {
        return com.ss.android.socialbase.downloader.downloader.c.eGK().a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        this.qfW.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
        return this.qfW.a(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean n(int i) {
        return this.qfW.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void o(int i) {
        this.qfW.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, long j) {
        this.qfW.a(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, long j) {
        this.qfW.a(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, int i4) {
        this.qfW.a(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean p(int i) {
        return this.qfW.f(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void f() {
        this.qfW.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        this.qfW.b(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g() {
        return this.d && this.qin != null && this.qin.a();
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
    public com.ss.android.socialbase.downloader.d.d RB(int i) {
        if (this.qiq != null) {
            return this.qiq.Rx(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.r RC(int i) {
        com.ss.android.socialbase.downloader.d.r rVar = null;
        if (this.qiq != null) {
            rVar = this.qiq.RV(i);
        }
        if (rVar == null) {
            return com.ss.android.socialbase.downloader.downloader.b.eGD();
        }
        return rVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, com.ss.android.socialbase.downloader.d.d dVar) {
        if (this.qiq != null) {
            this.qiq.a(i, dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public ah RD(int i) {
        if (this.qiq != null) {
            return this.qiq.RW(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, long j) {
        if (this.qiq != null) {
            this.qiq.b(i, j);
        }
    }
}
