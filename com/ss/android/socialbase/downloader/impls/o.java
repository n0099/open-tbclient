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
/* loaded from: classes7.dex */
public class o implements com.ss.android.socialbase.downloader.downloader.m, com.ss.android.socialbase.downloader.downloader.n {
    public static final String a = "o";

    /* renamed from: b  reason: collision with root package name */
    public volatile com.ss.android.socialbase.downloader.downloader.i f43437b;

    /* renamed from: c  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> f43438c;

    /* renamed from: d  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.m f43439d = new p();

    public o() {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> z = com.ss.android.socialbase.downloader.downloader.c.z();
        this.f43438c = z;
        z.a(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i) {
        if (this.f43437b == null) {
            return;
        }
        try {
            this.f43437b.a(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b(int i) {
        if (this.f43437b == null) {
            return false;
        }
        try {
            return this.f43437b.b(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i) {
        if (this.f43437b == null) {
            return;
        }
        try {
            this.f43437b.c(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void d(int i) {
        if (this.f43437b == null) {
            return;
        }
        try {
            this.f43437b.d(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public long e(int i) {
        if (this.f43437b == null) {
            return 0L;
        }
        try {
            return this.f43437b.e(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int f(int i) {
        if (this.f43437b == null) {
            return 0;
        }
        try {
            return this.f43437b.f(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean g(int i) {
        if (this.f43437b == null) {
            return false;
        }
        try {
            return this.f43437b.g(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public DownloadInfo h(int i) {
        if (this.f43437b == null) {
            return this.f43439d.h(i);
        }
        try {
            return this.f43437b.h(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<com.ss.android.socialbase.downloader.model.b> i(int i) {
        if (this.f43437b == null) {
            return this.f43439d.i(i);
        }
        try {
            return this.f43437b.i(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void j(int i) {
        if (this.f43437b == null) {
            this.f43439d.j(i);
            return;
        }
        try {
            this.f43437b.j(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void k(int i) {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar = this.f43438c;
        if (oVar != null) {
            oVar.a(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean l(int i) {
        if (this.f43437b == null) {
            return false;
        }
        try {
            return this.f43437b.k(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int m(int i) {
        if (this.f43437b == null) {
            return com.ss.android.socialbase.downloader.downloader.d.a().b(i);
        }
        try {
            return this.f43437b.m(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean n(int i) {
        if (this.f43437b == null) {
            return this.f43439d.n(i);
        }
        try {
            return this.f43437b.n(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void o(int i) {
        if (this.f43437b == null) {
            this.f43439d.o(i);
            return;
        }
        try {
            this.f43437b.o(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean p(int i) {
        if (this.f43437b == null) {
            return this.f43439d.p(i);
        }
        try {
            return this.f43437b.p(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public z q(int i) {
        if (this.f43437b != null) {
            try {
                return com.ss.android.socialbase.downloader.i.g.a(this.f43437b.q(i));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public af r(int i) {
        if (this.f43437b != null) {
            try {
                return com.ss.android.socialbase.downloader.i.g.a(this.f43437b.r(i));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public IDownloadFileUriProvider s(int i) {
        if (this.f43437b != null) {
            try {
                return com.ss.android.socialbase.downloader.i.g.a(this.f43437b.s(i));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar = this.f43438c;
        if (oVar != null) {
            oVar.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, boolean z) {
        if (this.f43437b == null) {
            return;
        }
        try {
            this.f43437b.a(i, z);
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
        if (this.f43437b == null) {
            return this.f43439d.c(str);
        }
        try {
            return this.f43437b.c(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> d() {
        if (this.f43437b == null) {
            return this.f43439d.d();
        }
        try {
            return this.f43437b.b();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> e(String str) {
        if (this.f43437b != null) {
            try {
                return this.f43437b.d(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void f() {
        if (this.f43437b == null) {
            this.f43439d.f();
            return;
        }
        try {
            this.f43437b.e();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean g() {
        return this.f43437b != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void h() {
        this.f43437b = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> b(String str) {
        if (this.f43437b == null) {
            return this.f43439d.b(str);
        }
        try {
            return this.f43437b.b(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a() {
        if (this.f43437b == null) {
            return;
        }
        try {
            this.f43437b.a();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean e() {
        if (this.f43437b == null) {
            return this.f43439d.e();
        }
        try {
            return this.f43437b.d();
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
        if (this.f43437b == null) {
            return this.f43439d.d(str);
        }
        try {
            return this.f43437b.e(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i, boolean z) {
        if (this.f43437b == null) {
            return;
        }
        try {
            this.f43437b.d(i, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> a(String str) {
        if (this.f43437b == null) {
            return this.f43439d.a(str);
        }
        try {
            return this.f43437b.a(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(List<String> list) {
        if (this.f43437b == null) {
            this.f43439d.b(list);
            return;
        }
        try {
            this.f43437b.b(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean c(DownloadInfo downloadInfo) {
        if (this.f43437b == null) {
            return this.f43439d.c(downloadInfo);
        }
        try {
            return this.f43437b.b(downloadInfo);
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
    public void b(int i, boolean z) {
        if (this.f43437b == null) {
            this.f43439d.b(i, z);
            return;
        }
        try {
            this.f43437b.b(i, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(List<String> list) {
        if (this.f43437b == null) {
            this.f43439d.a(list);
            return;
        }
        try {
            this.f43437b.a(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        if (this.f43437b == null) {
            return;
        }
        try {
            this.f43437b.a(i, i2, com.ss.android.socialbase.downloader.i.g.a(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.SUB), fVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        if (this.f43437b == null) {
            return;
        }
        try {
            this.f43437b.b(i, i2, com.ss.android.socialbase.downloader.i.g.a(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.SUB), fVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b() {
        if (this.f43437b == null) {
            com.ss.android.socialbase.downloader.c.a.d(a, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.c.a.c(a, "aidlService.isServiceForeground");
        try {
            return this.f43437b.f();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        if (this.f43437b == null) {
            return;
        }
        try {
            this.f43437b.a(i, i2, com.ss.android.socialbase.downloader.i.g.a(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.SUB), fVar.ordinal(), z, z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean a(DownloadInfo downloadInfo) {
        if (this.f43437b == null) {
            return this.f43439d.a(downloadInfo);
        }
        try {
            this.f43437b.a(downloadInfo);
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar;
        if (downloadTask == null || (oVar = this.f43438c) == null) {
            return;
        }
        oVar.c(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.f43437b == null) {
            this.f43439d.b(i, list);
            return;
        }
        try {
            this.f43437b.a(i, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, Notification notification) {
        if (this.f43437b == null) {
            com.ss.android.socialbase.downloader.c.a.d(a, "startForeground, aidlService is null");
            return;
        }
        String str = a;
        com.ss.android.socialbase.downloader.c.a.c(str, "aidlService.startForeground, id = " + i);
        try {
            this.f43437b.a(i, notification);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(boolean z, boolean z2) {
        if (this.f43437b == null) {
            com.ss.android.socialbase.downloader.c.a.d(a, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.c.a.c(a, "aidlService.stopForeground");
        try {
            this.f43437b.a(z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar;
        if (downloadTask == null || (oVar = this.f43438c) == null) {
            return;
        }
        oVar.b(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.f43437b == null) {
            return;
        }
        try {
            this.f43437b.b(i, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        if (this.f43437b == null) {
            this.f43439d.a(bVar);
            return;
        }
        try {
            this.f43437b.a(bVar);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, long j) {
        if (this.f43437b == null) {
            this.f43439d.a(i, i2, j);
            return;
        }
        try {
            this.f43437b.a(i, i2, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, int i3, long j) {
        if (this.f43437b == null) {
            this.f43439d.a(i, i2, i3, j);
            return;
        }
        try {
            this.f43437b.a(i, i2, i3, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2, int i3, int i4) {
        if (this.f43437b == null) {
            this.f43439d.a(i, i2, i3, i4);
            return;
        }
        try {
            this.f43437b.a(i, i2, i3, i4);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(ak akVar) {
        if (this.f43437b != null) {
            try {
                this.f43437b.a(com.ss.android.socialbase.downloader.i.g.a(akVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, int i2) {
        if (this.f43437b != null) {
            try {
                this.f43437b.a(i, i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, z zVar) {
        if (this.f43437b != null) {
            try {
                this.f43437b.a(i, com.ss.android.socialbase.downloader.i.g.a(zVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(IBinder iBinder) {
        this.f43437b = i.a.a(iBinder);
        if (com.ss.android.socialbase.downloader.i.f.a()) {
            a(new ak() { // from class: com.ss.android.socialbase.downloader.impls.o.1
                @Override // com.ss.android.socialbase.downloader.depend.ak
                public void a(int i, int i2) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(i);
                            return;
                        }
                        return;
                    }
                    Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).pause(i);
                    List<com.ss.android.socialbase.downloader.model.b> i3 = l.a(false).i(i);
                    if (i3 != null) {
                        l.a(true).a(i, com.ss.android.socialbase.downloader.i.f.a(i3));
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i, long j) {
        if (this.f43437b == null) {
            return;
        }
        try {
            this.f43437b.a(i, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
