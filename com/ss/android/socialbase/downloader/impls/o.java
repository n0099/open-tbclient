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
    private static final String f13196a = o.class.getSimpleName();
    private volatile com.ss.android.socialbase.downloader.downloader.j qhv;
    private com.ss.android.socialbase.downloader.downloader.n qhx = new p();
    private com.ss.android.socialbase.downloader.downloader.p<IndependentProcessDownloadService> qhw = com.ss.android.socialbase.downloader.downloader.b.eGu();

    public o() {
        this.qhw.a(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i) {
        if (this.qhv != null) {
            try {
                this.qhv.a(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, boolean z) {
        if (this.qhv == null) {
            this.qhx.a(i, z);
            return;
        }
        try {
            this.qhv.a(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b(int i) {
        if (this.qhv == null) {
            return false;
        }
        try {
            return this.qhv.b(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i) {
        if (this.qhv != null) {
            try {
                this.qhv.c(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d(int i) {
        if (this.qhv != null) {
            try {
                this.qhv.d(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a() {
        if (this.qhv != null) {
            try {
                this.qhv.a();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public long e(int i) {
        if (this.qhv == null) {
            return 0L;
        }
        try {
            return this.qhv.e(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int f(int i) {
        if (this.qhv == null) {
            return 0;
        }
        try {
            return this.qhv.f(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g(int i) {
        if (this.qhv == null) {
            return false;
        }
        try {
            return this.qhv.g(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        if (this.qhv == null) {
            return this.qhx.h(i);
        }
        try {
            return this.qhv.h(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        if (this.qhv == null) {
            return this.qhx.a(str);
        }
        try {
            return this.qhv.a(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.b> i(int i) {
        if (this.qhv == null) {
            return this.qhx.i(i);
        }
        try {
            return this.qhv.i(i);
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
        if (this.qhv == null) {
            return this.qhx.b(str);
        }
        try {
            return this.qhv.b(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        if (this.qhv == null) {
            return this.qhx.c(str);
        }
        try {
            return this.qhv.c(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(List<String> list) {
        if (this.qhv == null) {
            this.qhx.a(list);
            return;
        }
        try {
            this.qhv.a(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(List<String> list) {
        if (this.qhv == null) {
            this.qhx.b(list);
            return;
        }
        try {
            this.qhv.b(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, boolean z) {
        if (this.qhv == null) {
            this.qhx.b(i, z);
            return;
        }
        try {
            this.qhv.b(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void j(int i) {
        if (this.qhv == null) {
            this.qhx.j(i);
            return;
        }
        try {
            this.qhv.j(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.qhv != null) {
            try {
                this.qhv.b(i, i2, com.ss.android.socialbase.downloader.m.e.a(bVar, hVar != com.ss.android.socialbase.downloader.b.h.SUB), hVar.ordinal(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z, boolean z2) {
        if (this.qhv != null) {
            try {
                this.qhv.a(i, i2, com.ss.android.socialbase.downloader.m.e.a(bVar, hVar != com.ss.android.socialbase.downloader.b.h.SUB), hVar.ordinal(), z, z2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.qhv != null) {
            try {
                this.qhv.a(i, i2, com.ss.android.socialbase.downloader.m.e.a(bVar, hVar != com.ss.android.socialbase.downloader.b.h.SUB), hVar.ordinal(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (this.qhv == null) {
            return this.qhx.a(cVar);
        }
        try {
            this.qhv.a(cVar);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, Notification notification) {
        if (this.qhv == null) {
            com.ss.android.socialbase.downloader.f.a.d(f13196a, "startForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.f.a.c(f13196a, "aidlService.startForeground, id = " + i);
        try {
            this.qhv.a(i, notification);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(boolean z, boolean z2) {
        if (this.qhv == null) {
            com.ss.android.socialbase.downloader.f.a.d(f13196a, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.f.a.c(f13196a, "aidlService.stopForeground");
        try {
            this.qhv.a(z2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b() {
        if (this.qhv == null) {
            com.ss.android.socialbase.downloader.f.a.d(f13196a, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.f.a.c(f13196a, "aidlService.isServiceForeground");
        try {
            return this.qhv.e();
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
        if (this.qhv == null) {
            return this.qhx.d(str);
        }
        try {
            return this.qhv.e(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> e(String str) {
        if (this.qhv != null) {
            try {
                return this.qhv.d(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null && this.qhw != null) {
            this.qhw.b(dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null && this.qhw != null) {
            this.qhw.c(dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean Rw(int i) {
        if (this.qhv == null) {
            return false;
        }
        try {
            return this.qhv.k(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void k(int i) {
        if (this.qhw != null) {
            this.qhw.a(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d() {
        if (this.qhw != null) {
            this.qhw.f();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean e() {
        if (this.qhv == null) {
            return this.qhx.e();
        }
        try {
            return this.qhv.c();
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
        if (this.qhv != null) {
            try {
                this.qhv.b(i, list);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i, boolean z) {
        if (this.qhv != null) {
            try {
                this.qhv.d(i, z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int m(int i) {
        if (this.qhv == null) {
            return com.ss.android.socialbase.downloader.downloader.c.eGG().b(i);
        }
        try {
            return this.qhv.m(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        if (this.qhv == null) {
            this.qhx.a(bVar);
            return;
        }
        try {
            this.qhv.a(bVar);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
        if (this.qhv == null) {
            return this.qhx.c(cVar);
        }
        try {
            return this.qhv.b(cVar);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean n(int i) {
        if (this.qhv == null) {
            return this.qhx.n(i);
        }
        try {
            return this.qhv.n(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void o(int i) {
        if (this.qhv == null) {
            this.qhx.o(i);
            return;
        }
        try {
            this.qhv.o(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, long j) {
        if (this.qhv == null) {
            this.qhx.a(i, i2, j);
            return;
        }
        try {
            this.qhv.a(i, i2, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, long j) {
        if (this.qhv == null) {
            this.qhx.a(i, i2, i3, j);
            return;
        }
        try {
            this.qhv.a(i, i2, i3, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, int i4) {
        if (this.qhv == null) {
            this.qhx.a(i, i2, i3, i4);
            return;
        }
        try {
            this.qhv.a(i, i2, i3, i4);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean p(int i) {
        if (this.qhv == null) {
            return this.qhx.p(i);
        }
        try {
            return this.qhv.p(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void f() {
        if (this.qhv == null) {
            this.qhx.f();
            return;
        }
        try {
            this.qhv.d();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        if (this.qhv == null) {
            this.qhx.b(i, list);
            return;
        }
        try {
            this.qhv.a(i, list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g() {
        return this.qhv != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(t tVar) {
        if (this.qhv != null) {
            try {
                this.qhv.a(com.ss.android.socialbase.downloader.m.e.b(tVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2) {
        if (this.qhv != null) {
            try {
                this.qhv.a(i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.d Rx(int i) {
        if (this.qhv != null) {
            try {
                return com.ss.android.socialbase.downloader.m.e.a(this.qhv.q(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.r Ry(int i) {
        if (this.qhv != null) {
            try {
                return com.ss.android.socialbase.downloader.m.e.a(this.qhv.r(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, com.ss.android.socialbase.downloader.d.d dVar) {
        if (this.qhv != null) {
            try {
                this.qhv.a(i, com.ss.android.socialbase.downloader.m.e.c(dVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public ah Rz(int i) {
        if (this.qhv != null) {
            try {
                return com.ss.android.socialbase.downloader.m.e.a(this.qhv.s(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(IBinder iBinder) {
        this.qhv = j.a.a(iBinder);
        if (com.ss.android.socialbase.downloader.m.d.a()) {
            a(new t() { // from class: com.ss.android.socialbase.downloader.impls.o.1
                @Override // com.ss.android.socialbase.downloader.d.t
                public void a(int i, int i2) {
                    if (i2 == 1) {
                        com.ss.android.socialbase.downloader.downloader.f.iB(com.ss.android.socialbase.downloader.downloader.b.eGC()).a(i);
                        List<com.ss.android.socialbase.downloader.g.b> i3 = l.CO(false).i(i);
                        if (i3 != null) {
                            l.CO(true).a(i, com.ss.android.socialbase.downloader.m.d.a(i3));
                        }
                    } else if (i2 == 2) {
                        com.ss.android.socialbase.downloader.downloader.f.iB(com.ss.android.socialbase.downloader.downloader.b.eGC()).b(i);
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void h() {
        this.qhv = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, long j) {
        if (this.qhv != null) {
            try {
                this.qhv.a(i, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
