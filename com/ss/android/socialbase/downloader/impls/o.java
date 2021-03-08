package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.d.ah;
import com.ss.android.socialbase.downloader.d.t;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.j;
import java.util.List;
/* loaded from: classes6.dex */
public class o implements com.ss.android.socialbase.downloader.downloader.n, com.ss.android.socialbase.downloader.downloader.o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7858a = o.class.getSimpleName();
    private volatile com.ss.android.socialbase.downloader.downloader.j qim;
    private com.ss.android.socialbase.downloader.downloader.n qio = new p();
    private com.ss.android.socialbase.downloader.downloader.p<IndependentProcessDownloadService> qin = com.ss.android.socialbase.downloader.downloader.b.eGy();

    public o() {
        this.qin.a(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i) {
        if (this.qim != null) {
            try {
                this.qim.a(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, boolean z) {
        if (this.qim == null) {
            this.qio.a(i, z);
            return;
        }
        try {
            this.qim.a(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b(int i) {
        if (this.qim == null) {
            return false;
        }
        try {
            return this.qim.b(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i) {
        if (this.qim != null) {
            try {
                this.qim.c(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d(int i) {
        if (this.qim != null) {
            try {
                this.qim.d(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a() {
        if (this.qim != null) {
            try {
                this.qim.a();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public long e(int i) {
        if (this.qim == null) {
            return 0L;
        }
        try {
            return this.qim.e(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int f(int i) {
        if (this.qim == null) {
            return 0;
        }
        try {
            return this.qim.f(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g(int i) {
        if (this.qim == null) {
            return false;
        }
        try {
            return this.qim.g(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        if (this.qim == null) {
            return this.qio.h(i);
        }
        try {
            return this.qim.h(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        if (this.qim == null) {
            return this.qio.a(str);
        }
        try {
            return this.qim.a(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.b> i(int i) {
        if (this.qim == null) {
            return this.qio.i(i);
        }
        try {
            return this.qim.i(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int a(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.b.a(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.g.c b(String str, String str2) {
        return h(a(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        if (this.qim == null) {
            return this.qio.b(str);
        }
        try {
            return this.qim.b(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        if (this.qim == null) {
            return this.qio.c(str);
        }
        try {
            return this.qim.c(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(List<String> list) {
        if (this.qim == null) {
            this.qio.a(list);
            return;
        }
        try {
            this.qim.a(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(List<String> list) {
        if (this.qim == null) {
            this.qio.b(list);
            return;
        }
        try {
            this.qim.b(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, boolean z) {
        if (this.qim == null) {
            this.qio.b(i, z);
            return;
        }
        try {
            this.qim.b(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void j(int i) {
        if (this.qim == null) {
            this.qio.j(i);
            return;
        }
        try {
            this.qim.j(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.qim != null) {
            try {
                this.qim.b(i, i2, com.ss.android.socialbase.downloader.m.e.a(bVar, hVar != com.ss.android.socialbase.downloader.b.h.SUB), hVar.ordinal(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z, boolean z2) {
        if (this.qim != null) {
            try {
                this.qim.a(i, i2, com.ss.android.socialbase.downloader.m.e.a(bVar, hVar != com.ss.android.socialbase.downloader.b.h.SUB), hVar.ordinal(), z, z2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.qim != null) {
            try {
                this.qim.a(i, i2, com.ss.android.socialbase.downloader.m.e.a(bVar, hVar != com.ss.android.socialbase.downloader.b.h.SUB), hVar.ordinal(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (this.qim == null) {
            return this.qio.a(cVar);
        }
        try {
            this.qim.a(cVar);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, Notification notification) {
        if (this.qim == null) {
            com.ss.android.socialbase.downloader.f.a.d(f7858a, "startForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.f.a.c(f7858a, "aidlService.startForeground, id = " + i);
        try {
            this.qim.a(i, notification);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(boolean z, boolean z2) {
        if (this.qim == null) {
            com.ss.android.socialbase.downloader.f.a.d(f7858a, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.f.a.c(f7858a, "aidlService.stopForeground");
        try {
            this.qim.a(z2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b() {
        if (this.qim == null) {
            com.ss.android.socialbase.downloader.f.a.d(f7858a, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.f.a.c(f7858a, "aidlService.isServiceForeground");
        try {
            return this.qim.e();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c() {
        return com.ss.android.socialbase.downloader.downloader.b.H();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        if (this.qim == null) {
            return this.qio.d(str);
        }
        try {
            return this.qim.e(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> e(String str) {
        if (this.qim != null) {
            try {
                return this.qim.d(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null && this.qin != null) {
            this.qin.b(dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null && this.qin != null) {
            this.qin.c(dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean RA(int i) {
        if (this.qim == null) {
            return false;
        }
        try {
            return this.qim.k(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void k(int i) {
        if (this.qin != null) {
            this.qin.a(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d() {
        if (this.qin != null) {
            this.qin.f();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean e() {
        if (this.qim == null) {
            return this.qio.e();
        }
        try {
            return this.qim.c();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        if (this.qim != null) {
            try {
                this.qim.b(i, list);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i, boolean z) {
        if (this.qim != null) {
            try {
                this.qim.d(i, z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int m(int i) {
        if (this.qim == null) {
            return com.ss.android.socialbase.downloader.downloader.c.eGK().b(i);
        }
        try {
            return this.qim.m(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        if (this.qim == null) {
            this.qio.a(bVar);
            return;
        }
        try {
            this.qim.a(bVar);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
        if (this.qim == null) {
            return this.qio.c(cVar);
        }
        try {
            return this.qim.b(cVar);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean n(int i) {
        if (this.qim == null) {
            return this.qio.n(i);
        }
        try {
            return this.qim.n(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void o(int i) {
        if (this.qim == null) {
            this.qio.o(i);
            return;
        }
        try {
            this.qim.o(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, long j) {
        if (this.qim == null) {
            this.qio.a(i, i2, j);
            return;
        }
        try {
            this.qim.a(i, i2, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, long j) {
        if (this.qim == null) {
            this.qio.a(i, i2, i3, j);
            return;
        }
        try {
            this.qim.a(i, i2, i3, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, int i4) {
        if (this.qim == null) {
            this.qio.a(i, i2, i3, i4);
            return;
        }
        try {
            this.qim.a(i, i2, i3, i4);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean p(int i) {
        if (this.qim == null) {
            return this.qio.p(i);
        }
        try {
            return this.qim.p(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void f() {
        if (this.qim == null) {
            this.qio.f();
            return;
        }
        try {
            this.qim.d();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        if (this.qim == null) {
            this.qio.b(i, list);
            return;
        }
        try {
            this.qim.a(i, list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g() {
        return this.qim != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(t tVar) {
        if (this.qim != null) {
            try {
                this.qim.a(com.ss.android.socialbase.downloader.m.e.b(tVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2) {
        if (this.qim != null) {
            try {
                this.qim.a(i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.d RB(int i) {
        if (this.qim != null) {
            try {
                return com.ss.android.socialbase.downloader.m.e.a(this.qim.q(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.r RC(int i) {
        if (this.qim != null) {
            try {
                return com.ss.android.socialbase.downloader.m.e.a(this.qim.r(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, com.ss.android.socialbase.downloader.d.d dVar) {
        if (this.qim != null) {
            try {
                this.qim.a(i, com.ss.android.socialbase.downloader.m.e.c(dVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public ah RD(int i) {
        if (this.qim != null) {
            try {
                return com.ss.android.socialbase.downloader.m.e.a(this.qim.s(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(IBinder iBinder) {
        this.qim = j.a.a(iBinder);
        if (com.ss.android.socialbase.downloader.m.d.a()) {
            a(new t() { // from class: com.ss.android.socialbase.downloader.impls.o.1
                @Override // com.ss.android.socialbase.downloader.d.t
                public void a(int i, int i2) {
                    if (i2 == 1) {
                        com.ss.android.socialbase.downloader.downloader.f.iC(com.ss.android.socialbase.downloader.downloader.b.eGG()).a(i);
                        List<com.ss.android.socialbase.downloader.g.b> i3 = l.CM(false).i(i);
                        if (i3 != null) {
                            l.CM(true).a(i, com.ss.android.socialbase.downloader.m.d.a(i3));
                        }
                    } else if (i2 == 2) {
                        com.ss.android.socialbase.downloader.downloader.f.iC(com.ss.android.socialbase.downloader.downloader.b.eGG()).b(i);
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void h() {
        this.qim = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, long j) {
        if (this.qim != null) {
            try {
                this.qim.a(i, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
