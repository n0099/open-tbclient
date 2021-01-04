package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.d.ah;
import com.ss.android.socialbase.downloader.d.t;
import java.util.List;
/* loaded from: classes4.dex */
public class p implements com.ss.android.socialbase.downloader.downloader.n {
    private final boolean d;
    private final com.ss.android.socialbase.downloader.downloader.k pXu;
    private final com.ss.android.socialbase.downloader.downloader.p pZK;
    private final a pZN;

    public p() {
        this(false);
    }

    public p(boolean z) {
        this.pZN = com.ss.android.socialbase.downloader.downloader.b.eHk();
        this.pXu = com.ss.android.socialbase.downloader.downloader.b.eHf();
        if (!z) {
            this.pZK = com.ss.android.socialbase.downloader.downloader.b.eHg();
        } else {
            this.pZK = com.ss.android.socialbase.downloader.downloader.b.eHh();
        }
        this.d = com.ss.android.socialbase.downloader.k.a.eJs().b("judge_service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i) {
        if (this.pZN != null) {
            this.pZN.e(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, boolean z) {
        if (this.pZN != null) {
            this.pZN.a(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b(int i) {
        if (this.pZN != null) {
            return this.pZN.n(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i) {
        if (this.pZN != null) {
            this.pZN.f(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d(int i) {
        if (this.pZN != null) {
            this.pZN.g(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a() {
        if (this.pZN != null) {
            this.pZN.b();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        if (this.pXu != null) {
            return this.pXu.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(List<String> list) {
        if (this.pZN != null) {
            this.pZN.a(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(List<String> list) {
        if (this.pZN != null) {
            this.pZN.b(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public long e(int i) {
        com.ss.android.socialbase.downloader.g.c b2;
        if (this.pXu == null || (b2 = this.pXu.b(i)) == null) {
            return 0L;
        }
        int eIH = b2.eIH();
        if (eIH <= 1) {
            return b2.eHV();
        }
        List<com.ss.android.socialbase.downloader.g.b> c = this.pXu.c(i);
        if (c == null || c.size() != eIH) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.m.d.b(c);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int f(int i) {
        com.ss.android.socialbase.downloader.g.c SL;
        if (this.pZN == null || (SL = this.pZN.SL(i)) == null) {
            return 0;
        }
        return SL.q();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g(int i) {
        if (this.pZN != null) {
            return this.pZN.a(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        if (this.pZN != null) {
            return this.pZN.SL(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        if (this.pZN != null) {
            return this.pZN.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.b> i(int i) {
        return this.pXu.c(i);
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
        if (this.pXu != null) {
            return this.pXu.c(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, boolean z) {
        if (this.pZN != null) {
            this.pZN.b(i, z);
        }
    }

    public void d(int i, boolean z) {
        if (this.pZN != null) {
            this.pZN.c(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void j(int i) {
        if (this.pZN != null) {
            this.pZN.m(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.pZN != null) {
            this.pZN.b(i, i2, bVar, hVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z, boolean z2) {
        if (this.pZN != null) {
            this.pZN.a(i, i2, bVar, hVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.pZN != null) {
            this.pZN.a(i, i2, bVar, hVar, z);
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
        if (this.pZK != null) {
            this.pZK.a(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(boolean z, boolean z2) {
        if (this.pZK != null) {
            this.pZK.a(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b() {
        if (this.pZK != null) {
            return this.pZK.b();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c() {
        return com.ss.android.socialbase.downloader.downloader.b.H();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        if (this.pXu != null) {
            return this.pXu.d(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> e(String str) {
        if (this.pZN != null) {
            return this.pZN.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.d dVar) {
        if (this.pZK != null) {
            this.pZK.b(dVar);
        } else if (dVar != null) {
            com.ss.android.socialbase.downloader.h.a.a(dVar.eIX(), dVar.a(), new com.ss.android.socialbase.downloader.e.a(1003, "downloadServiceHandler is null"), dVar.a() != null ? dVar.a().q() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.d dVar) {
        if (this.pZK != null) {
            this.pZK.c(dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean Sr(int i) {
        if (this.pZN != null) {
            return this.pZN.k(i);
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
        return this.pXu.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        this.pXu.b(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        this.pXu.a(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.c.eHt().a(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int m(int i) {
        return com.ss.android.socialbase.downloader.downloader.c.eHt().a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        this.pXu.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
        return this.pXu.a(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean n(int i) {
        return this.pXu.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void o(int i) {
        this.pXu.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, long j) {
        this.pXu.a(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, long j) {
        this.pXu.a(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, int i4) {
        this.pXu.a(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean p(int i) {
        return this.pXu.f(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void f() {
        this.pXu.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        this.pXu.b(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g() {
        return this.d && this.pZK != null && this.pZK.a();
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
    public com.ss.android.socialbase.downloader.d.d Ss(int i) {
        if (this.pZN != null) {
            return this.pZN.So(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.r St(int i) {
        com.ss.android.socialbase.downloader.d.r rVar = null;
        if (this.pZN != null) {
            rVar = this.pZN.SM(i);
        }
        if (rVar == null) {
            return com.ss.android.socialbase.downloader.downloader.b.eHm();
        }
        return rVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, com.ss.android.socialbase.downloader.d.d dVar) {
        if (this.pZN != null) {
            this.pZN.a(i, dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public ah Su(int i) {
        if (this.pZN != null) {
            return this.pZN.SN(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, long j) {
        if (this.pZN != null) {
            this.pZN.b(i, j);
        }
    }
}
