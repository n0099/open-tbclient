package d.o.a.e.b.m;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.u;
import java.util.List;
/* loaded from: classes7.dex */
public class n implements d.o.a.e.b.g.m, d.o.a.e.b.g.n {

    /* renamed from: d  reason: collision with root package name */
    public static final String f67158d = "n";

    /* renamed from: a  reason: collision with root package name */
    public volatile com.ss.android.socialbase.downloader.downloader.h f67159a;

    /* renamed from: b  reason: collision with root package name */
    public d.o.a.e.b.g.o<IndependentProcessDownloadService> f67160b;

    /* renamed from: c  reason: collision with root package name */
    public d.o.a.e.b.g.m f67161c = new o();

    /* loaded from: classes7.dex */
    public class a implements d.o.a.e.b.f.k {
        public a(n nVar) {
        }

        @Override // d.o.a.e.b.f.k
        public void a(int i, int i2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).b(i);
                    return;
                }
                return;
            }
            d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).v(i);
            List<com.ss.android.socialbase.downloader.model.b> i3 = l.a(false).i(i);
            if (i3 != null) {
                l.a(true).a(i, d.o.a.e.b.l.e.p(i3));
            }
        }
    }

    public n() {
        d.o.a.e.b.g.o<IndependentProcessDownloadService> K0 = d.o.a.e.b.g.d.K0();
        this.f67160b = K0;
        K0.d(this);
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i) {
        if (this.f67159a == null) {
            return;
        }
        try {
            this.f67159a.a(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void b(DownloadInfo downloadInfo) {
    }

    @Override // d.o.a.e.b.g.m
    public boolean b(int i) {
        if (this.f67159a == null) {
            return false;
        }
        try {
            return this.f67159a.b(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void c(int i) {
        if (this.f67159a == null) {
            return;
        }
        try {
            this.f67159a.c(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void d(int i) {
        if (this.f67159a == null) {
            return;
        }
        try {
            this.f67159a.d(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public long e(int i) {
        if (this.f67159a == null) {
            return 0L;
        }
        try {
            return this.f67159a.e(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    @Override // d.o.a.e.b.g.m
    public int f(int i) {
        if (this.f67159a == null) {
            return 0;
        }
        try {
            return this.f67159a.f(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean g(int i) {
        if (this.f67159a == null) {
            return false;
        }
        try {
            return this.f67159a.g(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public DownloadInfo h(int i) {
        if (this.f67159a == null) {
            return this.f67161c.h(i);
        }
        try {
            return this.f67159a.h(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.m
    public List<com.ss.android.socialbase.downloader.model.b> i(int i) {
        if (this.f67159a == null) {
            return this.f67161c.i(i);
        }
        try {
            return this.f67159a.i(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void j(int i) {
        if (this.f67159a == null) {
            this.f67161c.j(i);
            return;
        }
        try {
            this.f67159a.j(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void k(int i) {
        d.o.a.e.b.g.o<IndependentProcessDownloadService> oVar = this.f67160b;
        if (oVar != null) {
            oVar.a(i);
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean l(int i) {
        if (this.f67159a == null) {
            return false;
        }
        try {
            return this.f67159a.k(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public int m(int i) {
        if (this.f67159a == null) {
            return d.o.a.e.b.g.e.c().m(i);
        }
        try {
            return this.f67159a.m(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean n(int i) {
        if (this.f67159a == null) {
            return this.f67161c.n(i);
        }
        try {
            return this.f67159a.n(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void o(int i) {
        if (this.f67159a == null) {
            this.f67161c.o(i);
            return;
        }
        try {
            this.f67159a.o(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean p(int i) {
        if (this.f67159a == null) {
            return this.f67161c.p(i);
        }
        try {
            return this.f67159a.p(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public d.o.a.e.b.f.d q(int i) {
        if (this.f67159a != null) {
            try {
                return com.ss.android.socialbase.downloader.i.f.d(this.f67159a.q(i));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public d.o.a.e.b.f.i r(int i) {
        if (this.f67159a != null) {
            try {
                return com.ss.android.socialbase.downloader.i.f.f(this.f67159a.r(i));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public u s(int i) {
        if (this.f67159a != null) {
            try {
                return com.ss.android.socialbase.downloader.i.f.w(this.f67159a.s(i));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i, boolean z) {
        if (this.f67159a == null) {
            return;
        }
        try {
            this.f67159a.a(i, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public DownloadInfo b(String str, String str2) {
        return h(a(str, str2));
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> c(String str) {
        if (this.f67159a == null) {
            return this.f67161c.c(str);
        }
        try {
            return this.f67159a.c(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> d(String str) {
        if (this.f67159a == null) {
            return this.f67161c.d(str);
        }
        try {
            return this.f67159a.e(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> e(String str) {
        if (this.f67159a != null) {
            try {
                return this.f67159a.d(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public void f(int i, int i2, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        if (this.f67159a == null) {
            return;
        }
        try {
            this.f67159a.b(i, i2, com.ss.android.socialbase.downloader.i.f.n(bVar, gVar != com.ss.android.socialbase.downloader.constants.g.SUB), gVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void g(int i, int i2, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        if (this.f67159a == null) {
            return;
        }
        try {
            this.f67159a.a(i, i2, com.ss.android.socialbase.downloader.i.f.n(bVar, gVar != com.ss.android.socialbase.downloader.constants.g.SUB), gVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.n
    public void h() {
        this.f67159a = null;
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> b(String str) {
        if (this.f67159a == null) {
            return this.f67161c.b(str);
        }
        try {
            return this.f67159a.b(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a() {
        if (this.f67159a == null) {
            return;
        }
        try {
            this.f67159a.a();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void e(d.o.a.e.b.n.a aVar) {
        d.o.a.e.b.g.o<IndependentProcessDownloadService> oVar;
        if (aVar == null || (oVar = this.f67160b) == null) {
            return;
        }
        oVar.a(aVar);
    }

    @Override // d.o.a.e.b.g.m
    public void f() {
        if (this.f67159a == null) {
            this.f67161c.f();
            return;
        }
        try {
            this.f67159a.d();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean g() {
        return this.f67159a != null;
    }

    @Override // d.o.a.e.b.g.m
    public void c(int i, int i2, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z, boolean z2) {
        if (this.f67159a == null) {
            return;
        }
        try {
            this.f67159a.a(i, i2, com.ss.android.socialbase.downloader.i.f.n(bVar, gVar != com.ss.android.socialbase.downloader.constants.g.SUB), gVar.ordinal(), z, z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void d() {
        d.o.a.e.b.g.o<IndependentProcessDownloadService> oVar = this.f67160b;
        if (oVar != null) {
            oVar.f();
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean e() {
        if (this.f67159a == null) {
            return this.f67161c.e();
        }
        try {
            return this.f67159a.c();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> a(String str) {
        if (this.f67159a == null) {
            return this.f67161c.a(str);
        }
        try {
            return this.f67159a.a(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void b(List<String> list) {
        if (this.f67159a == null) {
            this.f67161c.b(list);
            return;
        }
        try {
            this.f67159a.b(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void d(d.o.a.e.b.f.k kVar) {
        if (this.f67159a != null) {
            try {
                this.f67159a.a(com.ss.android.socialbase.downloader.i.f.h(kVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean c() {
        return d.o.a.e.b.g.d.m();
    }

    @Override // d.o.a.e.b.g.m
    public void c(int i, boolean z) {
        if (this.f67159a == null) {
            return;
        }
        try {
            this.f67159a.d(i, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public int a(String str, String str2) {
        return d.o.a.e.b.g.d.s(str, str2);
    }

    @Override // d.o.a.e.b.g.m
    public void b(int i, boolean z) {
        if (this.f67159a == null) {
            this.f67161c.b(i, z);
            return;
        }
        try {
            this.f67159a.b(i, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(List<String> list) {
        if (this.f67159a == null) {
            this.f67161c.a(list);
            return;
        }
        try {
            this.f67159a.a(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean c(DownloadInfo downloadInfo) {
        if (this.f67159a == null) {
            return this.f67161c.c(downloadInfo);
        }
        try {
            return this.f67159a.b(downloadInfo);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean b() {
        if (this.f67159a == null) {
            d.o.a.e.b.c.a.i(f67158d, "isServiceForeground, aidlService is null");
            return false;
        }
        d.o.a.e.b.c.a.h(f67158d, "aidlService.isServiceForeground");
        try {
            return this.f67159a.e();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean a(DownloadInfo downloadInfo) {
        if (this.f67159a == null) {
            return this.f67161c.a(downloadInfo);
        }
        try {
            this.f67159a.a(downloadInfo);
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i, Notification notification) {
        if (this.f67159a == null) {
            d.o.a.e.b.c.a.i(f67158d, "startForeground, aidlService is null");
            return;
        }
        String str = f67158d;
        d.o.a.e.b.c.a.h(str, "aidlService.startForeground, id = " + i);
        try {
            this.f67159a.a(i, notification);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.f67159a == null) {
            this.f67161c.b(i, list);
            return;
        }
        try {
            this.f67159a.a(i, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void b(int i, d.o.a.e.b.f.d dVar) {
        if (this.f67159a != null) {
            try {
                this.f67159a.a(i, com.ss.android.socialbase.downloader.i.f.c(dVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(boolean z, boolean z2) {
        if (this.f67159a == null) {
            d.o.a.e.b.c.a.i(f67158d, "stopForeground, aidlService is null");
            return;
        }
        d.o.a.e.b.c.a.h(f67158d, "aidlService.stopForeground");
        try {
            this.f67159a.a(z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(d.o.a.e.b.n.a aVar) {
        d.o.a.e.b.g.o<IndependentProcessDownloadService> oVar;
        if (aVar == null || (oVar = this.f67160b) == null) {
            return;
        }
        oVar.b(aVar);
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.f67159a == null) {
            return;
        }
        try {
            this.f67159a.b(i, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        if (this.f67159a == null) {
            this.f67161c.a(bVar);
            return;
        }
        try {
            this.f67159a.a(bVar);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i, int i2, long j) {
        if (this.f67159a == null) {
            this.f67161c.a(i, i2, j);
            return;
        }
        try {
            this.f67159a.a(i, i2, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i, int i2, int i3, long j) {
        if (this.f67159a == null) {
            this.f67161c.a(i, i2, i3, j);
            return;
        }
        try {
            this.f67159a.a(i, i2, i3, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i, int i2, int i3, int i4) {
        if (this.f67159a == null) {
            this.f67161c.a(i, i2, i3, i4);
            return;
        }
        try {
            this.f67159a.a(i, i2, i3, i4);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i, int i2) {
        if (this.f67159a != null) {
            try {
                this.f67159a.a(i, i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.o.a.e.b.g.n
    public void a(IBinder iBinder) {
        this.f67159a = h.a.a(iBinder);
        if (d.o.a.e.b.l.e.D()) {
            d(new a(this));
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i, long j) {
        if (this.f67159a == null) {
            return;
        }
        try {
            this.f67159a.a(i, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
