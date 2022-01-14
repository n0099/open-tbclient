package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class m extends i.a {
    public static final String a = m.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.downloader.m f60170b = new p(true);

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.b(com.ss.android.socialbase.downloader.i.g.a(aVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean b(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return false;
        }
        return mVar.b(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void c(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.c(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void d(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.d(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public long e(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return 0L;
        }
        return mVar.e(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public int f(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return 0;
        }
        return mVar.f(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean g(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return false;
        }
        return mVar.g(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo h(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return null;
        }
        return mVar.h(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<com.ss.android.socialbase.downloader.model.b> i(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return null;
        }
        return mVar.i(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void j(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.j(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean k(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return false;
        }
        return mVar.l(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void l(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.k(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public int m(int i2) throws RemoteException {
        return com.ss.android.socialbase.downloader.downloader.d.a().b(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean n(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return false;
        }
        return mVar.n(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void o(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.o(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean p(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return false;
        }
        return mVar.p(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public y q(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.i.g.a(mVar.q(i2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public ae r(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.i.g.a(mVar.r(i2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public com.ss.android.socialbase.downloader.depend.g s(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.i.g.a(mVar.s(i2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo b(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return null;
        }
        return mVar.b(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> c(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return null;
        }
        return mVar.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> d(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return null;
        }
        return mVar.e(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> e(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return null;
        }
        return mVar.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean f() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return false;
        }
        return mVar.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> b(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return null;
        }
        return mVar.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void c(int i2, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.b(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean d() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return false;
        }
        return mVar.e();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void e() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.f();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> b() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return null;
        }
        return mVar.d();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean c() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return false;
        }
        return mVar.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void d(int i2, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.d.a().b(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> a(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return null;
        }
        return mVar.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar != null) {
            mVar.b(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public int a(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return 0;
        }
        return mVar.a(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(int i2, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.b(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(int i2, int i3, com.ss.android.socialbase.downloader.depend.i iVar, int i4, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(i2, i3, com.ss.android.socialbase.downloader.i.g.a(iVar), com.ss.android.socialbase.downloader.i.f.e(i4), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3, com.ss.android.socialbase.downloader.depend.i iVar, int i4, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.b(i2, i3, com.ss.android.socialbase.downloader.i.g.a(iVar), com.ss.android.socialbase.downloader.i.f.e(i4), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean b(DownloadInfo downloadInfo) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return false;
        }
        return mVar.c(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3, com.ss.android.socialbase.downloader.depend.i iVar, int i4, boolean z, boolean z2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(i2, i3, com.ss.android.socialbase.downloader.i.g.a(iVar), com.ss.android.socialbase.downloader.i.f.e(i4), z, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean a(DownloadInfo downloadInfo) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return false;
        }
        return mVar.a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, Notification notification) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(i2, notification);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(true, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, long j2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(i2, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(com.ss.android.socialbase.downloader.model.b bVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3, long j2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(i2, i3, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3, int i4, long j2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(i2, i3, i4, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3, int i4, int i5) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(i2, i3, i4, i5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.b(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(aj ajVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(com.ss.android.socialbase.downloader.i.g.a(ajVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(i2, i3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, y yVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f60170b;
        if (mVar == null) {
            return;
        }
        mVar.a(i2, com.ss.android.socialbase.downloader.i.g.a(yVar));
    }
}
