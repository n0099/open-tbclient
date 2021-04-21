package d.p.a.e.b.m;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.e.b.f.u;
import java.util.List;
/* loaded from: classes6.dex */
public class n implements d.p.a.e.b.g.m, d.p.a.e.b.g.n {

    /* renamed from: d  reason: collision with root package name */
    public static final String f68303d = "n";

    /* renamed from: a  reason: collision with root package name */
    public volatile com.ss.android.socialbase.downloader.downloader.h f68304a;

    /* renamed from: b  reason: collision with root package name */
    public d.p.a.e.b.g.o<IndependentProcessDownloadService> f68305b;

    /* renamed from: c  reason: collision with root package name */
    public d.p.a.e.b.g.m f68306c = new o();

    /* loaded from: classes6.dex */
    public class a implements d.p.a.e.b.f.k {
        public a(n nVar) {
        }

        @Override // d.p.a.e.b.f.k
        public void a(int i, int i2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    d.p.a.e.b.g.a.l(d.p.a.e.b.g.d.l()).b(i);
                    return;
                }
                return;
            }
            d.p.a.e.b.g.a.l(d.p.a.e.b.g.d.l()).v(i);
            List<com.ss.android.socialbase.downloader.model.b> i3 = l.a(false).i(i);
            if (i3 != null) {
                l.a(true).a(i, d.p.a.e.b.l.e.p(i3));
            }
        }
    }

    public n() {
        d.p.a.e.b.g.o<IndependentProcessDownloadService> K0 = d.p.a.e.b.g.d.K0();
        this.f68305b = K0;
        K0.d(this);
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i) {
        if (this.f68304a == null) {
            return;
        }
        try {
            this.f68304a.a(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void b(DownloadInfo downloadInfo) {
    }

    @Override // d.p.a.e.b.g.m
    public boolean b(int i) {
        if (this.f68304a == null) {
            return false;
        }
        try {
            return this.f68304a.b(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.p.a.e.b.g.m
    public void c(int i) {
        if (this.f68304a == null) {
            return;
        }
        try {
            this.f68304a.c(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void d(int i) {
        if (this.f68304a == null) {
            return;
        }
        try {
            this.f68304a.d(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public long e(int i) {
        if (this.f68304a == null) {
            return 0L;
        }
        try {
            return this.f68304a.e(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    @Override // d.p.a.e.b.g.m
    public int f(int i) {
        if (this.f68304a == null) {
            return 0;
        }
        try {
            return this.f68304a.f(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // d.p.a.e.b.g.m
    public boolean g(int i) {
        if (this.f68304a == null) {
            return false;
        }
        try {
            return this.f68304a.g(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.p.a.e.b.g.m
    public DownloadInfo h(int i) {
        if (this.f68304a == null) {
            return this.f68306c.h(i);
        }
        try {
            return this.f68304a.h(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.p.a.e.b.g.m
    public List<com.ss.android.socialbase.downloader.model.b> i(int i) {
        if (this.f68304a == null) {
            return this.f68306c.i(i);
        }
        try {
            return this.f68304a.i(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.p.a.e.b.g.m
    public void j(int i) {
        if (this.f68304a == null) {
            this.f68306c.j(i);
            return;
        }
        try {
            this.f68304a.j(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void k(int i) {
        d.p.a.e.b.g.o<IndependentProcessDownloadService> oVar = this.f68305b;
        if (oVar != null) {
            oVar.a(i);
        }
    }

    @Override // d.p.a.e.b.g.m
    public boolean l(int i) {
        if (this.f68304a == null) {
            return false;
        }
        try {
            return this.f68304a.k(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.p.a.e.b.g.m
    public int m(int i) {
        if (this.f68304a == null) {
            return d.p.a.e.b.g.e.c().m(i);
        }
        try {
            return this.f68304a.m(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // d.p.a.e.b.g.m
    public boolean n(int i) {
        if (this.f68304a == null) {
            return this.f68306c.n(i);
        }
        try {
            return this.f68304a.n(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.p.a.e.b.g.m
    public void o(int i) {
        if (this.f68304a == null) {
            this.f68306c.o(i);
            return;
        }
        try {
            this.f68304a.o(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public boolean p(int i) {
        if (this.f68304a == null) {
            return this.f68306c.p(i);
        }
        try {
            return this.f68304a.p(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.p.a.e.b.g.m
    public d.p.a.e.b.f.d q(int i) {
        if (this.f68304a != null) {
            try {
                return com.ss.android.socialbase.downloader.i.f.d(this.f68304a.q(i));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // d.p.a.e.b.g.m
    public d.p.a.e.b.f.i r(int i) {
        if (this.f68304a != null) {
            try {
                return com.ss.android.socialbase.downloader.i.f.f(this.f68304a.r(i));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // d.p.a.e.b.g.m
    public u s(int i) {
        if (this.f68304a != null) {
            try {
                return com.ss.android.socialbase.downloader.i.f.w(this.f68304a.s(i));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, boolean z) {
        if (this.f68304a == null) {
            return;
        }
        try {
            this.f68304a.a(i, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public DownloadInfo b(String str, String str2) {
        return h(a(str, str2));
    }

    @Override // d.p.a.e.b.g.m
    public List<DownloadInfo> c(String str) {
        if (this.f68304a == null) {
            return this.f68306c.c(str);
        }
        try {
            return this.f68304a.c(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.p.a.e.b.g.m
    public List<DownloadInfo> d(String str) {
        if (this.f68304a == null) {
            return this.f68306c.d(str);
        }
        try {
            return this.f68304a.e(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.p.a.e.b.g.m
    public List<DownloadInfo> e(String str) {
        if (this.f68304a != null) {
            try {
                return this.f68304a.d(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // d.p.a.e.b.g.m
    public void f(int i, int i2, d.p.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        if (this.f68304a == null) {
            return;
        }
        try {
            this.f68304a.b(i, i2, com.ss.android.socialbase.downloader.i.f.n(bVar, gVar != com.ss.android.socialbase.downloader.constants.g.SUB), gVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void g(int i, int i2, d.p.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        if (this.f68304a == null) {
            return;
        }
        try {
            this.f68304a.a(i, i2, com.ss.android.socialbase.downloader.i.f.n(bVar, gVar != com.ss.android.socialbase.downloader.constants.g.SUB), gVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.n
    public void h() {
        this.f68304a = null;
    }

    @Override // d.p.a.e.b.g.m
    public List<DownloadInfo> b(String str) {
        if (this.f68304a == null) {
            return this.f68306c.b(str);
        }
        try {
            return this.f68304a.b(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a() {
        if (this.f68304a == null) {
            return;
        }
        try {
            this.f68304a.a();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void e(d.p.a.e.b.n.a aVar) {
        d.p.a.e.b.g.o<IndependentProcessDownloadService> oVar;
        if (aVar == null || (oVar = this.f68305b) == null) {
            return;
        }
        oVar.a(aVar);
    }

    @Override // d.p.a.e.b.g.m
    public void f() {
        if (this.f68304a == null) {
            this.f68306c.f();
            return;
        }
        try {
            this.f68304a.d();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public boolean g() {
        return this.f68304a != null;
    }

    @Override // d.p.a.e.b.g.m
    public void c(int i, int i2, d.p.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z, boolean z2) {
        if (this.f68304a == null) {
            return;
        }
        try {
            this.f68304a.a(i, i2, com.ss.android.socialbase.downloader.i.f.n(bVar, gVar != com.ss.android.socialbase.downloader.constants.g.SUB), gVar.ordinal(), z, z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void d() {
        d.p.a.e.b.g.o<IndependentProcessDownloadService> oVar = this.f68305b;
        if (oVar != null) {
            oVar.f();
        }
    }

    @Override // d.p.a.e.b.g.m
    public boolean e() {
        if (this.f68304a == null) {
            return this.f68306c.e();
        }
        try {
            return this.f68304a.c();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.p.a.e.b.g.m
    public List<DownloadInfo> a(String str) {
        if (this.f68304a == null) {
            return this.f68306c.a(str);
        }
        try {
            return this.f68304a.a(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.p.a.e.b.g.m
    public void b(List<String> list) {
        if (this.f68304a == null) {
            this.f68306c.b(list);
            return;
        }
        try {
            this.f68304a.b(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void d(d.p.a.e.b.f.k kVar) {
        if (this.f68304a != null) {
            try {
                this.f68304a.a(com.ss.android.socialbase.downloader.i.f.h(kVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.p.a.e.b.g.m
    public boolean c() {
        return d.p.a.e.b.g.d.m();
    }

    @Override // d.p.a.e.b.g.m
    public void c(int i, boolean z) {
        if (this.f68304a == null) {
            return;
        }
        try {
            this.f68304a.d(i, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public int a(String str, String str2) {
        return d.p.a.e.b.g.d.s(str, str2);
    }

    @Override // d.p.a.e.b.g.m
    public void b(int i, boolean z) {
        if (this.f68304a == null) {
            this.f68306c.b(i, z);
            return;
        }
        try {
            this.f68304a.b(i, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(List<String> list) {
        if (this.f68304a == null) {
            this.f68306c.a(list);
            return;
        }
        try {
            this.f68304a.a(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public boolean c(DownloadInfo downloadInfo) {
        if (this.f68304a == null) {
            return this.f68306c.c(downloadInfo);
        }
        try {
            return this.f68304a.b(downloadInfo);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.p.a.e.b.g.m
    public boolean b() {
        if (this.f68304a == null) {
            d.p.a.e.b.c.a.i(f68303d, "isServiceForeground, aidlService is null");
            return false;
        }
        d.p.a.e.b.c.a.h(f68303d, "aidlService.isServiceForeground");
        try {
            return this.f68304a.e();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.p.a.e.b.g.m
    public boolean a(DownloadInfo downloadInfo) {
        if (this.f68304a == null) {
            return this.f68306c.a(downloadInfo);
        }
        try {
            this.f68304a.a(downloadInfo);
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, Notification notification) {
        if (this.f68304a == null) {
            d.p.a.e.b.c.a.i(f68303d, "startForeground, aidlService is null");
            return;
        }
        String str = f68303d;
        d.p.a.e.b.c.a.h(str, "aidlService.startForeground, id = " + i);
        try {
            this.f68304a.a(i, notification);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.f68304a == null) {
            this.f68306c.b(i, list);
            return;
        }
        try {
            this.f68304a.a(i, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void b(int i, d.p.a.e.b.f.d dVar) {
        if (this.f68304a != null) {
            try {
                this.f68304a.a(i, com.ss.android.socialbase.downloader.i.f.c(dVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(boolean z, boolean z2) {
        if (this.f68304a == null) {
            d.p.a.e.b.c.a.i(f68303d, "stopForeground, aidlService is null");
            return;
        }
        d.p.a.e.b.c.a.h(f68303d, "aidlService.stopForeground");
        try {
            this.f68304a.a(z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(d.p.a.e.b.n.a aVar) {
        d.p.a.e.b.g.o<IndependentProcessDownloadService> oVar;
        if (aVar == null || (oVar = this.f68305b) == null) {
            return;
        }
        oVar.b(aVar);
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.f68304a == null) {
            return;
        }
        try {
            this.f68304a.b(i, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        if (this.f68304a == null) {
            this.f68306c.a(bVar);
            return;
        }
        try {
            this.f68304a.a(bVar);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, int i2, long j) {
        if (this.f68304a == null) {
            this.f68306c.a(i, i2, j);
            return;
        }
        try {
            this.f68304a.a(i, i2, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, int i2, int i3, long j) {
        if (this.f68304a == null) {
            this.f68306c.a(i, i2, i3, j);
            return;
        }
        try {
            this.f68304a.a(i, i2, i3, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, int i2, int i3, int i4) {
        if (this.f68304a == null) {
            this.f68306c.a(i, i2, i3, i4);
            return;
        }
        try {
            this.f68304a.a(i, i2, i3, i4);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, int i2) {
        if (this.f68304a != null) {
            try {
                this.f68304a.a(i, i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.p.a.e.b.g.n
    public void a(IBinder iBinder) {
        this.f68304a = h.a.a(iBinder);
        if (d.p.a.e.b.l.e.D()) {
            d(new a(this));
        }
    }

    @Override // d.p.a.e.b.g.m
    public void a(int i, long j) {
        if (this.f68304a == null) {
            return;
        }
        try {
            this.f68304a.a(i, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
