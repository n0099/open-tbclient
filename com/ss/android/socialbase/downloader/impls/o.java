package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.d.ah;
import com.ss.android.socialbase.downloader.d.t;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.j;
import java.util.List;
/* loaded from: classes4.dex */
public class o implements com.ss.android.socialbase.downloader.downloader.n, com.ss.android.socialbase.downloader.downloader.o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13494a = o.class.getSimpleName();
    private volatile com.ss.android.socialbase.downloader.downloader.j qbr;
    private com.ss.android.socialbase.downloader.downloader.n qbt = new p();
    private com.ss.android.socialbase.downloader.downloader.p<IndependentProcessDownloadService> qbs = com.ss.android.socialbase.downloader.downloader.b.eHL();

    public o() {
        this.qbs.a(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i) {
        if (this.qbr != null) {
            try {
                this.qbr.a(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, boolean z) {
        if (this.qbr == null) {
            this.qbt.a(i, z);
            return;
        }
        try {
            this.qbr.a(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b(int i) {
        if (this.qbr == null) {
            return false;
        }
        try {
            return this.qbr.b(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i) {
        if (this.qbr != null) {
            try {
                this.qbr.c(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d(int i) {
        if (this.qbr != null) {
            try {
                this.qbr.d(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a() {
        if (this.qbr != null) {
            try {
                this.qbr.a();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public long e(int i) {
        if (this.qbr == null) {
            return 0L;
        }
        try {
            return this.qbr.e(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int f(int i) {
        if (this.qbr == null) {
            return 0;
        }
        try {
            return this.qbr.f(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g(int i) {
        if (this.qbr == null) {
            return false;
        }
        try {
            return this.qbr.g(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        if (this.qbr == null) {
            return this.qbt.h(i);
        }
        try {
            return this.qbr.h(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        if (this.qbr == null) {
            return this.qbt.a(str);
        }
        try {
            return this.qbr.a(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.b> i(int i) {
        if (this.qbr == null) {
            return this.qbt.i(i);
        }
        try {
            return this.qbr.i(i);
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
        if (this.qbr == null) {
            return this.qbt.b(str);
        }
        try {
            return this.qbr.b(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        if (this.qbr == null) {
            return this.qbt.c(str);
        }
        try {
            return this.qbr.c(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(List<String> list) {
        if (this.qbr == null) {
            this.qbt.a(list);
            return;
        }
        try {
            this.qbr.a(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(List<String> list) {
        if (this.qbr == null) {
            this.qbt.b(list);
            return;
        }
        try {
            this.qbr.b(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, boolean z) {
        if (this.qbr == null) {
            this.qbt.b(i, z);
            return;
        }
        try {
            this.qbr.b(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void j(int i) {
        if (this.qbr == null) {
            this.qbt.j(i);
            return;
        }
        try {
            this.qbr.j(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.qbr != null) {
            try {
                this.qbr.b(i, i2, com.ss.android.socialbase.downloader.m.e.a(bVar, hVar != com.ss.android.socialbase.downloader.b.h.SUB), hVar.ordinal(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z, boolean z2) {
        if (this.qbr != null) {
            try {
                this.qbr.a(i, i2, com.ss.android.socialbase.downloader.m.e.a(bVar, hVar != com.ss.android.socialbase.downloader.b.h.SUB), hVar.ordinal(), z, z2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.qbr != null) {
            try {
                this.qbr.a(i, i2, com.ss.android.socialbase.downloader.m.e.a(bVar, hVar != com.ss.android.socialbase.downloader.b.h.SUB), hVar.ordinal(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (this.qbr == null) {
            return this.qbt.a(cVar);
        }
        try {
            this.qbr.a(cVar);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, Notification notification) {
        if (this.qbr == null) {
            com.ss.android.socialbase.downloader.f.a.d(f13494a, "startForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.f.a.c(f13494a, "aidlService.startForeground, id = " + i);
        try {
            this.qbr.a(i, notification);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(boolean z, boolean z2) {
        if (this.qbr == null) {
            com.ss.android.socialbase.downloader.f.a.d(f13494a, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.f.a.c(f13494a, "aidlService.stopForeground");
        try {
            this.qbr.a(z2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b() {
        if (this.qbr == null) {
            com.ss.android.socialbase.downloader.f.a.d(f13494a, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.f.a.c(f13494a, "aidlService.isServiceForeground");
        try {
            return this.qbr.e();
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
        if (this.qbr == null) {
            return this.qbt.d(str);
        }
        try {
            return this.qbr.e(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> e(String str) {
        if (this.qbr != null) {
            try {
                return this.qbr.d(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null && this.qbs != null) {
            this.qbs.b(dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null && this.qbs != null) {
            this.qbs.c(dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean SH(int i) {
        if (this.qbr == null) {
            return false;
        }
        try {
            return this.qbr.k(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void k(int i) {
        if (this.qbs != null) {
            this.qbs.a(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d() {
        if (this.qbs != null) {
            this.qbs.f();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean e() {
        if (this.qbr == null) {
            return this.qbt.e();
        }
        try {
            return this.qbr.c();
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
        if (this.qbr != null) {
            try {
                this.qbr.b(i, list);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i, boolean z) {
        if (this.qbr != null) {
            try {
                this.qbr.d(i, z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int m(int i) {
        if (this.qbr == null) {
            return com.ss.android.socialbase.downloader.downloader.c.eHX().b(i);
        }
        try {
            return this.qbr.m(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        if (this.qbr == null) {
            this.qbt.a(bVar);
            return;
        }
        try {
            this.qbr.a(bVar);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
        if (this.qbr == null) {
            return this.qbt.c(cVar);
        }
        try {
            return this.qbr.b(cVar);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean n(int i) {
        if (this.qbr == null) {
            return this.qbt.n(i);
        }
        try {
            return this.qbr.n(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void o(int i) {
        if (this.qbr == null) {
            this.qbt.o(i);
            return;
        }
        try {
            this.qbr.o(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, long j) {
        if (this.qbr == null) {
            this.qbt.a(i, i2, j);
            return;
        }
        try {
            this.qbr.a(i, i2, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, long j) {
        if (this.qbr == null) {
            this.qbt.a(i, i2, i3, j);
            return;
        }
        try {
            this.qbr.a(i, i2, i3, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, int i4) {
        if (this.qbr == null) {
            this.qbt.a(i, i2, i3, i4);
            return;
        }
        try {
            this.qbr.a(i, i2, i3, i4);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean p(int i) {
        if (this.qbr == null) {
            return this.qbt.p(i);
        }
        try {
            return this.qbr.p(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void f() {
        if (this.qbr == null) {
            this.qbt.f();
            return;
        }
        try {
            this.qbr.d();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        if (this.qbr == null) {
            this.qbt.b(i, list);
            return;
        }
        try {
            this.qbr.a(i, list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g() {
        return this.qbr != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(t tVar) {
        if (this.qbr != null) {
            try {
                this.qbr.a(com.ss.android.socialbase.downloader.m.e.b(tVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2) {
        if (this.qbr != null) {
            try {
                this.qbr.a(i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.d SI(int i) {
        if (this.qbr != null) {
            try {
                return com.ss.android.socialbase.downloader.m.e.a(this.qbr.q(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.r SJ(int i) {
        if (this.qbr != null) {
            try {
                return com.ss.android.socialbase.downloader.m.e.a(this.qbr.r(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, com.ss.android.socialbase.downloader.d.d dVar) {
        if (this.qbr != null) {
            try {
                this.qbr.a(i, com.ss.android.socialbase.downloader.m.e.c(dVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public ah SK(int i) {
        if (this.qbr != null) {
            try {
                return com.ss.android.socialbase.downloader.m.e.a(this.qbr.s(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(IBinder iBinder) {
        this.qbr = j.a.a(iBinder);
        if (com.ss.android.socialbase.downloader.m.d.a()) {
            a(new t() { // from class: com.ss.android.socialbase.downloader.impls.o.1
                @Override // com.ss.android.socialbase.downloader.d.t
                public void a(int i, int i2) {
                    if (i2 == 1) {
                        com.ss.android.socialbase.downloader.downloader.f.iA(com.ss.android.socialbase.downloader.downloader.b.eHT()).a(i);
                        List<com.ss.android.socialbase.downloader.g.b> i3 = l.Cy(false).i(i);
                        if (i3 != null) {
                            l.Cy(true).a(i, com.ss.android.socialbase.downloader.m.d.a(i3));
                        }
                    } else if (i2 == 2) {
                        com.ss.android.socialbase.downloader.downloader.f.iA(com.ss.android.socialbase.downloader.downloader.b.eHT()).b(i);
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void h() {
        this.qbr = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, long j) {
        if (this.qbr != null) {
            try {
                this.qbr.a(i, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
