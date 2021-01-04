package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.d.ac;
import com.ss.android.socialbase.downloader.d.ai;
import com.ss.android.socialbase.downloader.d.am;
import com.ss.android.socialbase.downloader.downloader.j;
import java.util.List;
/* loaded from: classes4.dex */
public class m extends j.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13491a = m.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.n f13492b = new p(true);

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.g.a aVar) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.b(com.ss.android.socialbase.downloader.m.e.b(aVar));
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, boolean z) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean b(int i) throws RemoteException {
        if (this.f13492b == null) {
            return false;
        }
        return this.f13492b.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void c(int i) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.c(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void d(int i) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.d(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a() throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public long e(int i) throws RemoteException {
        if (this.f13492b == null) {
            return 0L;
        }
        return this.f13492b.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public int f(int i) throws RemoteException {
        if (this.f13492b == null) {
            return 0;
        }
        return this.f13492b.f(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean g(int i) throws RemoteException {
        if (this.f13492b == null) {
            return false;
        }
        return this.f13492b.g(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public com.ss.android.socialbase.downloader.g.c h(int i) throws RemoteException {
        if (this.f13492b == null) {
            return null;
        }
        return this.f13492b.h(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) throws RemoteException {
        if (this.f13492b == null) {
            return null;
        }
        return this.f13492b.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.g.b> i(int i) throws RemoteException {
        if (this.f13492b == null) {
            return null;
        }
        return this.f13492b.i(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public int a(String str, String str2) throws RemoteException {
        if (this.f13492b == null) {
            return 0;
        }
        return this.f13492b.a(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public com.ss.android.socialbase.downloader.g.c b(String str, String str2) throws RemoteException {
        if (this.f13492b == null) {
            return null;
        }
        return this.f13492b.b(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) throws RemoteException {
        if (this.f13492b == null) {
            return null;
        }
        return this.f13492b.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) throws RemoteException {
        if (this.f13492b == null) {
            return null;
        }
        return this.f13492b.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) throws RemoteException {
        if (this.f13492b == null) {
            return null;
        }
        return this.f13492b.e(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(List<String> list) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(List<String> list) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.b(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i, boolean z) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.b(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void c(int i, boolean z) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.b(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void j(int i) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.j(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.j jVar, int i3, boolean z) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.b(i, i2, com.ss.android.socialbase.downloader.m.e.a(jVar), com.ss.android.socialbase.downloader.m.d.SV(i3), z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i, int i2, com.ss.android.socialbase.downloader.d.j jVar, int i3, boolean z) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(i, i2, com.ss.android.socialbase.downloader.m.e.a(jVar), com.ss.android.socialbase.downloader.m.d.SV(i3), z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2, com.ss.android.socialbase.downloader.d.j jVar, int i3, boolean z, boolean z2) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(i, i2, com.ss.android.socialbase.downloader.m.e.a(jVar), com.ss.android.socialbase.downloader.m.d.SV(i3), z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
        if (this.f13492b == null) {
            return false;
        }
        return this.f13492b.a(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, Notification notification) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(boolean z) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(true, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e() throws RemoteException {
        if (this.f13492b == null) {
            return false;
        }
        return this.f13492b.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, long j) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(i, j);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean b() throws RemoteException {
        if (this.f13492b == null) {
            return false;
        }
        return this.f13492b.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.g.c> e(String str) throws RemoteException {
        if (this.f13492b == null) {
            return null;
        }
        return this.f13492b.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean k(int i) throws RemoteException {
        if (this.f13492b == null) {
            return false;
        }
        return this.f13492b.Sr(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void l(int i) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.k(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean c() throws RemoteException {
        if (this.f13492b == null) {
            return false;
        }
        return this.f13492b.e();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void d(int i, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.c.eHt().b(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public int m(int i) throws RemoteException {
        return com.ss.android.socialbase.downloader.downloader.c.eHt().b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.g.b bVar) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(bVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean b(com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
        if (this.f13492b == null) {
            return false;
        }
        return this.f13492b.c(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean n(int i) throws RemoteException {
        if (this.f13492b == null) {
            return false;
        }
        return this.f13492b.n(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void o(int i) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.o(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2, long j) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(i, i2, j);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2, int i3, long j) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(i, i2, i3, j);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2, int i3, int i4) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(i, i2, i3, i4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean p(int i) throws RemoteException {
        if (this.f13492b == null) {
            return false;
        }
        return this.f13492b.p(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void d() throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.f();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.b(i, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(i, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(am amVar) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(com.ss.android.socialbase.downloader.m.e.b(amVar));
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(i, i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public ac q(int i) throws RemoteException {
        if (this.f13492b == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.m.e.c(this.f13492b.Ss(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public ai r(int i) throws RemoteException {
        if (this.f13492b == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.m.e.d(this.f13492b.St(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, ac acVar) throws RemoteException {
        if (this.f13492b != null) {
            this.f13492b.a(i, com.ss.android.socialbase.downloader.m.e.a(acVar));
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public com.ss.android.socialbase.downloader.d.h s(int i) throws RemoteException {
        if (this.f13492b == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.m.e.c(this.f13492b.Su(i));
    }
}
