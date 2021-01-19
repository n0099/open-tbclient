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
    private static final String f13194a = o.class.getSimpleName();
    private volatile com.ss.android.socialbase.downloader.downloader.j pWR;
    private com.ss.android.socialbase.downloader.downloader.n pWT = new p();
    private com.ss.android.socialbase.downloader.downloader.p<IndependentProcessDownloadService> pWS = com.ss.android.socialbase.downloader.downloader.b.eDV();

    public o() {
        this.pWS.a(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i) {
        if (this.pWR != null) {
            try {
                this.pWR.a(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, boolean z) {
        if (this.pWR == null) {
            this.pWT.a(i, z);
            return;
        }
        try {
            this.pWR.a(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b(int i) {
        if (this.pWR == null) {
            return false;
        }
        try {
            return this.pWR.b(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i) {
        if (this.pWR != null) {
            try {
                this.pWR.c(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d(int i) {
        if (this.pWR != null) {
            try {
                this.pWR.d(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a() {
        if (this.pWR != null) {
            try {
                this.pWR.a();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public long e(int i) {
        if (this.pWR == null) {
            return 0L;
        }
        try {
            return this.pWR.e(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int f(int i) {
        if (this.pWR == null) {
            return 0;
        }
        try {
            return this.pWR.f(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g(int i) {
        if (this.pWR == null) {
            return false;
        }
        try {
            return this.pWR.g(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        if (this.pWR == null) {
            return this.pWT.h(i);
        }
        try {
            return this.pWR.h(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        if (this.pWR == null) {
            return this.pWT.a(str);
        }
        try {
            return this.pWR.a(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.b> i(int i) {
        if (this.pWR == null) {
            return this.pWT.i(i);
        }
        try {
            return this.pWR.i(i);
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
        if (this.pWR == null) {
            return this.pWT.b(str);
        }
        try {
            return this.pWR.b(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        if (this.pWR == null) {
            return this.pWT.c(str);
        }
        try {
            return this.pWR.c(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(List<String> list) {
        if (this.pWR == null) {
            this.pWT.a(list);
            return;
        }
        try {
            this.pWR.a(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(List<String> list) {
        if (this.pWR == null) {
            this.pWT.b(list);
            return;
        }
        try {
            this.pWR.b(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, boolean z) {
        if (this.pWR == null) {
            this.pWT.b(i, z);
            return;
        }
        try {
            this.pWR.b(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void j(int i) {
        if (this.pWR == null) {
            this.pWT.j(i);
            return;
        }
        try {
            this.pWR.j(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.pWR != null) {
            try {
                this.pWR.b(i, i2, com.ss.android.socialbase.downloader.m.e.a(bVar, hVar != com.ss.android.socialbase.downloader.b.h.SUB), hVar.ordinal(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z, boolean z2) {
        if (this.pWR != null) {
            try {
                this.pWR.a(i, i2, com.ss.android.socialbase.downloader.m.e.a(bVar, hVar != com.ss.android.socialbase.downloader.b.h.SUB), hVar.ordinal(), z, z2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        if (this.pWR != null) {
            try {
                this.pWR.a(i, i2, com.ss.android.socialbase.downloader.m.e.a(bVar, hVar != com.ss.android.socialbase.downloader.b.h.SUB), hVar.ordinal(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (this.pWR == null) {
            return this.pWT.a(cVar);
        }
        try {
            this.pWR.a(cVar);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, Notification notification) {
        if (this.pWR == null) {
            com.ss.android.socialbase.downloader.f.a.d(f13194a, "startForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.f.a.c(f13194a, "aidlService.startForeground, id = " + i);
        try {
            this.pWR.a(i, notification);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(boolean z, boolean z2) {
        if (this.pWR == null) {
            com.ss.android.socialbase.downloader.f.a.d(f13194a, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.f.a.c(f13194a, "aidlService.stopForeground");
        try {
            this.pWR.a(z2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b() {
        if (this.pWR == null) {
            com.ss.android.socialbase.downloader.f.a.d(f13194a, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.f.a.c(f13194a, "aidlService.isServiceForeground");
        try {
            return this.pWR.e();
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
        if (this.pWR == null) {
            return this.pWT.d(str);
        }
        try {
            return this.pWR.e(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public List<com.ss.android.socialbase.downloader.g.c> e(String str) {
        if (this.pWR != null) {
            try {
                return this.pWR.d(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null && this.pWS != null) {
            this.pWS.b(dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null && this.pWS != null) {
            this.pWS.c(dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean Ra(int i) {
        if (this.pWR == null) {
            return false;
        }
        try {
            return this.pWR.k(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void k(int i) {
        if (this.pWS != null) {
            this.pWS.a(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d() {
        if (this.pWS != null) {
            this.pWS.f();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean e() {
        if (this.pWR == null) {
            return this.pWT.e();
        }
        try {
            return this.pWR.c();
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
        if (this.pWR != null) {
            try {
                this.pWR.b(i, list);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(int i, boolean z) {
        if (this.pWR != null) {
            try {
                this.pWR.d(i, z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public int m(int i) {
        if (this.pWR == null) {
            return com.ss.android.socialbase.downloader.downloader.c.eEh().b(i);
        }
        try {
            return this.pWR.m(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        if (this.pWR == null) {
            this.pWT.a(bVar);
            return;
        }
        try {
            this.pWR.a(bVar);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
        if (this.pWR == null) {
            return this.pWT.c(cVar);
        }
        try {
            return this.pWR.b(cVar);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean n(int i) {
        if (this.pWR == null) {
            return this.pWT.n(i);
        }
        try {
            return this.pWR.n(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void o(int i) {
        if (this.pWR == null) {
            this.pWT.o(i);
            return;
        }
        try {
            this.pWR.o(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, long j) {
        if (this.pWR == null) {
            this.pWT.a(i, i2, j);
            return;
        }
        try {
            this.pWR.a(i, i2, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, long j) {
        if (this.pWR == null) {
            this.pWT.a(i, i2, i3, j);
            return;
        }
        try {
            this.pWR.a(i, i2, i3, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2, int i3, int i4) {
        if (this.pWR == null) {
            this.pWT.a(i, i2, i3, i4);
            return;
        }
        try {
            this.pWR.a(i, i2, i3, i4);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean p(int i) {
        if (this.pWR == null) {
            return this.pWT.p(i);
        }
        try {
            return this.pWR.p(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void f() {
        if (this.pWR == null) {
            this.pWT.f();
            return;
        }
        try {
            this.pWR.d();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        if (this.pWR == null) {
            this.pWT.b(i, list);
            return;
        }
        try {
            this.pWR.a(i, list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean g() {
        return this.pWR != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(t tVar) {
        if (this.pWR != null) {
            try {
                this.pWR.a(com.ss.android.socialbase.downloader.m.e.b(tVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, int i2) {
        if (this.pWR != null) {
            try {
                this.pWR.a(i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.d Rb(int i) {
        if (this.pWR != null) {
            try {
                return com.ss.android.socialbase.downloader.m.e.a(this.pWR.q(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public com.ss.android.socialbase.downloader.d.r Rc(int i) {
        if (this.pWR != null) {
            try {
                return com.ss.android.socialbase.downloader.m.e.a(this.pWR.r(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, com.ss.android.socialbase.downloader.d.d dVar) {
        if (this.pWR != null) {
            try {
                this.pWR.a(i, com.ss.android.socialbase.downloader.m.e.c(dVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public ah Rd(int i) {
        if (this.pWR != null) {
            try {
                return com.ss.android.socialbase.downloader.m.e.a(this.pWR.s(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(IBinder iBinder) {
        this.pWR = j.a.a(iBinder);
        if (com.ss.android.socialbase.downloader.m.d.a()) {
            a(new t() { // from class: com.ss.android.socialbase.downloader.impls.o.1
                @Override // com.ss.android.socialbase.downloader.d.t
                public void a(int i, int i2) {
                    if (i2 == 1) {
                        com.ss.android.socialbase.downloader.downloader.f.iy(com.ss.android.socialbase.downloader.downloader.b.eEd()).a(i);
                        List<com.ss.android.socialbase.downloader.g.b> i3 = l.Cu(false).i(i);
                        if (i3 != null) {
                            l.Cu(true).a(i, com.ss.android.socialbase.downloader.m.d.a(i3));
                        }
                    } else if (i2 == 2) {
                        com.ss.android.socialbase.downloader.downloader.f.iy(com.ss.android.socialbase.downloader.downloader.b.eEd()).b(i);
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void h() {
        this.pWR = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int i, long j) {
        if (this.pWR != null) {
            try {
                this.pWR.a(i, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
