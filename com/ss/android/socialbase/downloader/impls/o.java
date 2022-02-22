package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
/* loaded from: classes4.dex */
public class o implements com.ss.android.socialbase.downloader.downloader.m, com.ss.android.socialbase.downloader.downloader.n {
    public static final String a = "o";

    /* renamed from: b  reason: collision with root package name */
    public volatile com.ss.android.socialbase.downloader.downloader.i f60387b;

    /* renamed from: c  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> f60388c;

    /* renamed from: d  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.m f60389d = new p();

    public o() {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> z = com.ss.android.socialbase.downloader.downloader.c.z();
        this.f60388c = z;
        z.a(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2) {
        if (this.f60387b == null) {
            return;
        }
        try {
            this.f60387b.a(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b(int i2) {
        if (this.f60387b == null) {
            return false;
        }
        try {
            return this.f60387b.b(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i2) {
        if (this.f60387b == null) {
            return;
        }
        try {
            this.f60387b.c(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void d(int i2) {
        if (this.f60387b == null) {
            return;
        }
        try {
            this.f60387b.d(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public long e(int i2) {
        if (this.f60387b == null) {
            return 0L;
        }
        try {
            return this.f60387b.e(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int f(int i2) {
        if (this.f60387b == null) {
            return 0;
        }
        try {
            return this.f60387b.f(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean g(int i2) {
        if (this.f60387b == null) {
            return false;
        }
        try {
            return this.f60387b.g(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public DownloadInfo h(int i2) {
        if (this.f60387b == null) {
            return this.f60389d.h(i2);
        }
        try {
            return this.f60387b.h(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<com.ss.android.socialbase.downloader.model.b> i(int i2) {
        if (this.f60387b == null) {
            return this.f60389d.i(i2);
        }
        try {
            return this.f60387b.i(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void j(int i2) {
        if (this.f60387b == null) {
            this.f60389d.j(i2);
            return;
        }
        try {
            this.f60387b.j(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void k(int i2) {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar = this.f60388c;
        if (oVar != null) {
            oVar.a(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean l(int i2) {
        if (this.f60387b == null) {
            return false;
        }
        try {
            return this.f60387b.k(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int m(int i2) {
        if (this.f60387b == null) {
            return com.ss.android.socialbase.downloader.downloader.d.a().b(i2);
        }
        try {
            return this.f60387b.m(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean n(int i2) {
        if (this.f60387b == null) {
            return this.f60389d.n(i2);
        }
        try {
            return this.f60387b.n(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void o(int i2) {
        if (this.f60387b == null) {
            this.f60389d.o(i2);
            return;
        }
        try {
            this.f60387b.o(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean p(int i2) {
        if (this.f60387b == null) {
            return this.f60389d.p(i2);
        }
        try {
            return this.f60387b.p(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public z q(int i2) {
        if (this.f60387b != null) {
            try {
                return com.ss.android.socialbase.downloader.i.g.a(this.f60387b.q(i2));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public af r(int i2) {
        if (this.f60387b != null) {
            try {
                return com.ss.android.socialbase.downloader.i.g.a(this.f60387b.r(i2));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public IDownloadFileUriProvider s(int i2) {
        if (this.f60387b != null) {
            try {
                return com.ss.android.socialbase.downloader.i.g.a(this.f60387b.s(i2));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar = this.f60388c;
        if (oVar != null) {
            oVar.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, boolean z) {
        if (this.f60387b == null) {
            return;
        }
        try {
            this.f60387b.a(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public DownloadInfo b(String str, String str2) {
        return h(a(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> c(String str) {
        if (this.f60387b == null) {
            return this.f60389d.c(str);
        }
        try {
            return this.f60387b.c(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> d() {
        if (this.f60387b == null) {
            return this.f60389d.d();
        }
        try {
            return this.f60387b.b();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> e(String str) {
        if (this.f60387b != null) {
            try {
                return this.f60387b.d(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void f() {
        if (this.f60387b == null) {
            this.f60389d.f();
            return;
        }
        try {
            this.f60387b.e();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean g() {
        return this.f60387b != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void h() {
        this.f60387b = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> b(String str) {
        if (this.f60387b == null) {
            return this.f60389d.b(str);
        }
        try {
            return this.f60387b.b(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a() {
        if (this.f60387b == null) {
            return;
        }
        try {
            this.f60387b.a();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean e() {
        if (this.f60387b == null) {
            return this.f60389d.e();
        }
        try {
            return this.f60387b.d();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean c() {
        return com.ss.android.socialbase.downloader.downloader.c.O();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> d(String str) {
        if (this.f60387b == null) {
            return this.f60389d.d(str);
        }
        try {
            return this.f60387b.e(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i2, boolean z) {
        if (this.f60387b == null) {
            return;
        }
        try {
            this.f60387b.d(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> a(String str) {
        if (this.f60387b == null) {
            return this.f60389d.a(str);
        }
        try {
            return this.f60387b.a(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(List<String> list) {
        if (this.f60387b == null) {
            this.f60389d.b(list);
            return;
        }
        try {
            this.f60387b.b(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean c(DownloadInfo downloadInfo) {
        if (this.f60387b == null) {
            return this.f60389d.c(downloadInfo);
        }
        try {
            return this.f60387b.b(downloadInfo);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int a(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.c.a(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i2, boolean z) {
        if (this.f60387b == null) {
            this.f60389d.b(i2, z);
            return;
        }
        try {
            this.f60387b.b(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(List<String> list) {
        if (this.f60387b == null) {
            this.f60389d.a(list);
            return;
        }
        try {
            this.f60387b.a(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        if (this.f60387b == null) {
            return;
        }
        try {
            this.f60387b.a(i2, i3, com.ss.android.socialbase.downloader.i.g.a(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.SUB), fVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        if (this.f60387b == null) {
            return;
        }
        try {
            this.f60387b.b(i2, i3, com.ss.android.socialbase.downloader.i.g.a(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.SUB), fVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b() {
        if (this.f60387b == null) {
            com.ss.android.socialbase.downloader.c.a.d(a, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.c.a.c(a, "aidlService.isServiceForeground");
        try {
            return this.f60387b.f();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        if (this.f60387b == null) {
            return;
        }
        try {
            this.f60387b.a(i2, i3, com.ss.android.socialbase.downloader.i.g.a(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.SUB), fVar.ordinal(), z, z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean a(DownloadInfo downloadInfo) {
        if (this.f60387b == null) {
            return this.f60389d.a(downloadInfo);
        }
        try {
            this.f60387b.a(downloadInfo);
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar;
        if (downloadTask == null || (oVar = this.f60388c) == null) {
            return;
        }
        oVar.c(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.f60387b == null) {
            this.f60389d.b(i2, list);
            return;
        }
        try {
            this.f60387b.a(i2, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, Notification notification) {
        if (this.f60387b == null) {
            com.ss.android.socialbase.downloader.c.a.d(a, "startForeground, aidlService is null");
            return;
        }
        String str = a;
        com.ss.android.socialbase.downloader.c.a.c(str, "aidlService.startForeground, id = " + i2);
        try {
            this.f60387b.a(i2, notification);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(boolean z, boolean z2) {
        if (this.f60387b == null) {
            com.ss.android.socialbase.downloader.c.a.d(a, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.c.a.c(a, "aidlService.stopForeground");
        try {
            this.f60387b.a(z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar;
        if (downloadTask == null || (oVar = this.f60388c) == null) {
            return;
        }
        oVar.b(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.f60387b == null) {
            return;
        }
        try {
            this.f60387b.b(i2, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        if (this.f60387b == null) {
            this.f60389d.a(bVar);
            return;
        }
        try {
            this.f60387b.a(bVar);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, long j2) {
        if (this.f60387b == null) {
            this.f60389d.a(i2, i3, j2);
            return;
        }
        try {
            this.f60387b.a(i2, i3, j2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, int i4, long j2) {
        if (this.f60387b == null) {
            this.f60389d.a(i2, i3, i4, j2);
            return;
        }
        try {
            this.f60387b.a(i2, i3, i4, j2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, int i4, int i5) {
        if (this.f60387b == null) {
            this.f60389d.a(i2, i3, i4, i5);
            return;
        }
        try {
            this.f60387b.a(i2, i3, i4, i5);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(ak akVar) {
        if (this.f60387b != null) {
            try {
                this.f60387b.a(com.ss.android.socialbase.downloader.i.g.a(akVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3) {
        if (this.f60387b != null) {
            try {
                this.f60387b.a(i2, i3);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, z zVar) {
        if (this.f60387b != null) {
            try {
                this.f60387b.a(i2, com.ss.android.socialbase.downloader.i.g.a(zVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(IBinder iBinder) {
        this.f60387b = i.a.a(iBinder);
        if (com.ss.android.socialbase.downloader.i.f.a()) {
            a(new ak() { // from class: com.ss.android.socialbase.downloader.impls.o.1
                @Override // com.ss.android.socialbase.downloader.depend.ak
                public void a(int i2, int i3) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(i2);
                            return;
                        }
                        return;
                    }
                    Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).pause(i2);
                    List<com.ss.android.socialbase.downloader.model.b> i4 = l.a(false).i(i2);
                    if (i4 != null) {
                        l.a(true).a(i2, com.ss.android.socialbase.downloader.i.f.a(i4));
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, long j2) {
        if (this.f60387b == null) {
            return;
        }
        try {
            this.f60387b.a(i2, j2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
