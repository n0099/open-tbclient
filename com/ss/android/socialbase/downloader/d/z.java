package com.ss.android.socialbase.downloader.d;
/* loaded from: classes4.dex */
public abstract class z extends x implements ag {
    protected abstract com.ss.android.socialbase.downloader.notification.a eGp();

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
        if (cVar != null && cVar.eHZ()) {
            com.ss.android.socialbase.downloader.notification.a SX = com.ss.android.socialbase.downloader.notification.b.eJw().SX(cVar.g());
            if (SX == null) {
                com.ss.android.socialbase.downloader.notification.b.eJw().a(eGp());
                return;
            }
            SX.a(cVar);
        }
    }

    private void a(int i, com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        if (cVar != null && cVar.eHZ() && i != 4) {
            com.ss.android.socialbase.downloader.notification.a SX = com.ss.android.socialbase.downloader.notification.b.eJw().SX(cVar.g());
            if (SX == null) {
                SX = eGp();
            }
            SX.b(cVar.ejK());
            if (i == -3) {
                SX.a(cVar.ejK());
            } else {
                SX.a(cVar.eHV());
            }
            SX.a(i, aVar, z);
        }
    }

    private void q(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null && cVar.eHZ() && cVar.q() == 4) {
            com.ss.android.socialbase.downloader.notification.a SX = com.ss.android.socialbase.downloader.notification.b.eJw().SX(cVar.g());
            if (SX == null) {
                SX = eGp();
            }
            SX.a(cVar.eHV(), cVar.ejK());
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.ag
    public void g(com.ss.android.socialbase.downloader.g.c cVar) {
        a(11, cVar, null, true);
    }
}
