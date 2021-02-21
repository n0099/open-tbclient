package com.ss.android.socialbase.downloader.d;
/* loaded from: classes6.dex */
public abstract class z extends x implements ag {
    protected abstract com.ss.android.socialbase.downloader.notification.a eFC();

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
        if (cVar != null && cVar.eHm()) {
            com.ss.android.socialbase.downloader.notification.a Sc = com.ss.android.socialbase.downloader.notification.b.eIJ().Sc(cVar.g());
            if (Sc == null) {
                com.ss.android.socialbase.downloader.notification.b.eIJ().a(eFC());
                return;
            }
            Sc.a(cVar);
        }
    }

    private void a(int i, com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        if (cVar != null && cVar.eHm() && i != 4) {
            com.ss.android.socialbase.downloader.notification.a Sc = com.ss.android.socialbase.downloader.notification.b.eIJ().Sc(cVar.g());
            if (Sc == null) {
                Sc = eFC();
            }
            Sc.b(cVar.eir());
            if (i == -3) {
                Sc.a(cVar.eir());
            } else {
                Sc.a(cVar.eHi());
            }
            Sc.a(i, aVar, z);
        }
    }

    private void q(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null && cVar.eHm() && cVar.q() == 4) {
            com.ss.android.socialbase.downloader.notification.a Sc = com.ss.android.socialbase.downloader.notification.b.eIJ().Sc(cVar.g());
            if (Sc == null) {
                Sc = eFC();
            }
            Sc.a(cVar.eHi(), cVar.eir());
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.ag
    public void g(com.ss.android.socialbase.downloader.g.c cVar) {
        a(11, cVar, null, true);
    }
}
