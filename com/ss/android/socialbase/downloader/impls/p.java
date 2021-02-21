package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.d.ah;
import com.ss.android.socialbase.downloader.d.t;
import java.util.List;
/* loaded from: classes6.dex */
public class p implements com.ss.android.socialbase.downloader.downloader.n {
    private final boolean d;
    private final com.ss.android.socialbase.downloader.downloader.k qfh;
    private final com.ss.android.socialbase.downloader.downloader.p qhw;
    private final a qhz;

    public p() {
        this(false);
    }

    public p(boolean z) {
        this.qhz = com.ss.android.socialbase.downloader.downloader.b.eGx();
        this.qfh = com.ss.android.socialbase.downloader.downloader.b.eGs();
        if (!z) {
            this.qhw = com.ss.android.socialbase.downloader.downloader.b.eGt();
        } else {
            this.qhw = com.ss.android.socialbase.downloader.downloader.b.eGu();
        }
        this.d = com.ss.android.socialbase.downloader.k.a.eIF().b("judge_service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i) {
        if (this.qhz != null) {
            this.qhz.e(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, boolean z) {
        if (this.qhz != null) {
            this.qhz.a(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b(int i) {
        if (this.qhz != null) {
            return this.qhz.n(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i) {
        if (this.qhz != null) {
            this.qhz.f(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d(int i) {
        if (this.qhz != null) {
            this.qhz.g(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a() {
        if (this.qhz != null) {
            this.qhz.b();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        if (this.qfh != null) {
            return this.qfh.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(List<String> list) {
        if (this.qhz != null) {
            this.qhz.a(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(List<String> list) {
        if (this.qhz != null) {
            this.qhz.b(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public long e(int i) {
        com.ss.android.socialbase.downloader.g.c b2;
        if (this.qfh == null || (b2 = this.qfh.b(i)) == null) {
            return 0L;
        }
        int eHU = b2.eHU();
        if (eHU <= 1) {
            return b2.eHi();
        }
        List<com.ss.android.socialbase.downloader.g.b> c = this.qfh.c(i);
        if (c == null || c.size() != eHU) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.m.d.b(c);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int f(int i) {
        com.ss.android.socialbase.downloader.g.c RQ;
        if (this.qhz == null || (RQ = this.qhz.RQ(i)) == null) {
            return 0;
        }
        return RQ.q();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g(int i) {
        if (this.qhz != null) {
            return this.qhz.a(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        if (this.qhz != null) {
            return this.qhz.RQ(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        if (this.qhz != null) {
            return this.qhz.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.b> i(int i) {
        return this.qfh.c(i);
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
        if (this.qfh != null) {
            return this.qfh.c(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, boolean z) {
        if (this.qhz != null) {
            this.qhz.b(i, z);
        }
    }

    public void d(int i, boolean z) {
        if (this.qhz != null) {
            this.qhz.c(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void j(int i) {
        if (this.qhz != null) {
            this.qhz.m(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.qhz != null) {
            this.qhz.b(i, i2, bVar, hVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z, boolean z2) {
        if (this.qhz != null) {
            this.qhz.a(i, i2, bVar, hVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.qhz != null) {
            this.qhz.a(i, i2, bVar, hVar, z);
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
        if (this.qhw != null) {
            this.qhw.a(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(boolean z, boolean z2) {
        if (this.qhw != null) {
            this.qhw.a(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b() {
        if (this.qhw != null) {
            return this.qhw.b();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c() {
        return com.ss.android.socialbase.downloader.downloader.b.H();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        if (this.qfh != null) {
            return this.qfh.d(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> e(String str) {
        if (this.qhz != null) {
            return this.qhz.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.d dVar) {
        if (this.qhw != null) {
            this.qhw.b(dVar);
        } else if (dVar != null) {
            com.ss.android.socialbase.downloader.h.a.a(dVar.eIk(), dVar.a(), new com.ss.android.socialbase.downloader.e.a(1003, "downloadServiceHandler is null"), dVar.a() != null ? dVar.a().q() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.d dVar) {
        if (this.qhw != null) {
            this.qhw.c(dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean Rw(int i) {
        if (this.qhz != null) {
            return this.qhz.k(i);
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
        return this.qfh.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        this.qfh.b(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        this.qfh.a(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.c.eGG().a(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int m(int i) {
        return com.ss.android.socialbase.downloader.downloader.c.eGG().a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        this.qfh.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
        return this.qfh.a(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean n(int i) {
        return this.qfh.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void o(int i) {
        this.qfh.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, long j) {
        this.qfh.a(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, long j) {
        this.qfh.a(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, int i4) {
        this.qfh.a(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean p(int i) {
        return this.qfh.f(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void f() {
        this.qfh.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        this.qfh.b(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g() {
        return this.d && this.qhw != null && this.qhw.a();
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
    public com.ss.android.socialbase.downloader.d.d Rx(int i) {
        if (this.qhz != null) {
            return this.qhz.Rt(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.r Ry(int i) {
        com.ss.android.socialbase.downloader.d.r rVar = null;
        if (this.qhz != null) {
            rVar = this.qhz.RR(i);
        }
        if (rVar == null) {
            return com.ss.android.socialbase.downloader.downloader.b.eGz();
        }
        return rVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, com.ss.android.socialbase.downloader.d.d dVar) {
        if (this.qhz != null) {
            this.qhz.a(i, dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public ah Rz(int i) {
        if (this.qhz != null) {
            return this.qhz.RS(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, long j) {
        if (this.qhz != null) {
            this.qhz.b(i, j);
        }
    }
}
