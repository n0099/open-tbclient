package com.ss.android.socialbase.downloader.d;
/* loaded from: classes4.dex */
public abstract class z extends x implements ag {
    protected abstract com.ss.android.socialbase.downloader.notification.a eGT();

    @Override // com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
    public void a(com.ss.android.socialbase.downloader.g.c cVar) {
        super.a(cVar);
        o(cVar);
        a(1, cVar, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        super.b(cVar);
        a(2, cVar, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
    public void c(com.ss.android.socialbase.downloader.g.c cVar) {
        super.c(cVar);
        q(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
    public void d(com.ss.android.socialbase.downloader.g.c cVar) {
        super.d(cVar);
        a(-2, cVar, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
    public void e(com.ss.android.socialbase.downloader.g.c cVar) {
        super.e(cVar);
        a(-3, cVar, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
    public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar) {
        super.a(cVar, aVar);
        a(-1, cVar, aVar, false);
    }

    private void o(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null && cVar.eID()) {
            com.ss.android.socialbase.downloader.notification.a Tn = com.ss.android.socialbase.downloader.notification.b.eKa().Tn(cVar.g());
            if (Tn == null) {
                com.ss.android.socialbase.downloader.notification.b.eKa().a(eGT());
                return;
            }
            Tn.a(cVar);
        }
    }

    private void a(int i, com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        if (cVar != null && cVar.eID() && i != 4) {
            com.ss.android.socialbase.downloader.notification.a Tn = com.ss.android.socialbase.downloader.notification.b.eKa().Tn(cVar.g());
            if (Tn == null) {
                Tn = eGT();
            }
            Tn.b(cVar.ejL());
            if (i == -3) {
                Tn.a(cVar.ejL());
            } else {
                Tn.a(cVar.eIz());
            }
            Tn.a(i, aVar, z);
        }
    }

    private void q(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null && cVar.eID() && cVar.q() == 4) {
            com.ss.android.socialbase.downloader.notification.a Tn = com.ss.android.socialbase.downloader.notification.b.eKa().Tn(cVar.g());
            if (Tn == null) {
                Tn = eGT();
            }
            Tn.a(cVar.eIz(), cVar.ejL());
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.ag
    public void g(com.ss.android.socialbase.downloader.g.c cVar) {
        a(11, cVar, null, true);
    }
}
