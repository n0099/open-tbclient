package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.c.f;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.l.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements com.ss.android.socialbase.downloader.downloader.k {
    private volatile boolean c;
    private volatile boolean d;
    private com.ss.android.socialbase.downloader.l.f pWA;
    private t pWy;
    private f.a pWz = new f.a() { // from class: com.ss.android.socialbase.downloader.impls.d.1
        @Override // com.ss.android.socialbase.downloader.l.f.a
        public void a(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.b.eDL().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            d.this.h();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    };
    private final k pWx = new k();

    public d() {
        this.pWA = null;
        if (com.ss.android.socialbase.downloader.k.a.eGg().a("fix_sigbus_downloader_db")) {
            if (com.ss.android.socialbase.downloader.m.d.a()) {
                this.pWy = new com.ss.android.socialbase.downloader.c.e();
            } else {
                com.ss.android.socialbase.downloader.c.f fVar = new com.ss.android.socialbase.downloader.c.f();
                fVar.a(new f.a() { // from class: com.ss.android.socialbase.downloader.impls.d.2
                    @Override // com.ss.android.socialbase.downloader.c.f.a
                    public void a() {
                        d.this.pWy = new com.ss.android.socialbase.downloader.c.e();
                        Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                    }
                });
                this.pWy = fVar;
            }
        } else {
            this.pWy = new com.ss.android.socialbase.downloader.c.e();
        }
        this.c = false;
        this.pWA = new com.ss.android.socialbase.downloader.l.f(Looper.getMainLooper(), this.pWz);
        f();
    }

    public k eFZ() {
        return this.pWx;
    }

    public t eGa() {
        return this.pWy;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c g(int i) {
        com.ss.android.socialbase.downloader.g.c g = this.pWx.g(i);
        c(g);
        return g;
    }

    public void f() {
        com.ss.android.socialbase.downloader.downloader.b.a(com.ss.android.socialbase.downloader.b.d.SYNC_START);
        this.pWy.a(this.pWx.a(), this.pWx.eGb(), new com.ss.android.socialbase.downloader.c.d() { // from class: com.ss.android.socialbase.downloader.impls.d.3
            @Override // com.ss.android.socialbase.downloader.c.d
            public void a() {
                d.this.i();
                d.this.g();
                com.ss.android.socialbase.downloader.downloader.b.a(com.ss.android.socialbase.downloader.b.d.SYNC_SUCCESS);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        synchronized (this) {
            this.c = true;
            notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean d() {
        if (this.c) {
            return true;
        }
        synchronized (this) {
            if (!this.c) {
                com.ss.android.socialbase.downloader.f.a.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                com.ss.android.socialbase.downloader.f.a.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean c() {
        return this.c;
    }

    public void g() {
        long j;
        if (com.ss.android.socialbase.downloader.k.a.eGg().a("task_resume_delay")) {
            j = 4000;
        } else if (Build.VERSION.SDK_INT >= 23) {
            j = 1000;
        } else {
            j = 5000;
        }
        this.pWA.sendMessageDelayed(this.pWA.obtainMessage(1), j);
    }

    public void h() {
        com.ss.android.socialbase.downloader.downloader.m eDS;
        List<String> a2;
        SparseArray<com.ss.android.socialbase.downloader.g.c> a3;
        com.ss.android.socialbase.downloader.g.c cVar;
        if (this.c) {
            if (this.d) {
                com.ss.android.socialbase.downloader.f.a.b("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.d = true;
            if (com.ss.android.socialbase.downloader.m.d.a() && (eDS = com.ss.android.socialbase.downloader.downloader.b.eDS()) != null && (a2 = eDS.a()) != null && !a2.isEmpty() && (a3 = this.pWx.a()) != null) {
                ArrayList arrayList = new ArrayList();
                synchronized (a3) {
                    for (int i = 0; i < a3.size(); i++) {
                        int keyAt = a3.keyAt(i);
                        if (keyAt != 0 && (cVar = a3.get(keyAt)) != null && cVar.eEO() != null && a2.contains(cVar.eEO()) && (cVar.w() != -2 || cVar.U())) {
                            cVar.d(false);
                            arrayList.add(cVar);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    eDS.a(arrayList, 1);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i) {
        return this.pWx.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        return this.pWx.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        return this.pWx.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        return this.pWx.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        return this.pWx.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.b> c(int i) {
        return this.pWx.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void d(int i) {
        this.pWx.d(i);
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n Cu = l.Cu(true);
            if (Cu != null) {
                Cu.o(i);
                return;
            } else {
                this.pWy.d(i);
                return;
            }
        }
        this.pWy.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        this.pWx.a(bVar);
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n Cu = l.Cu(true);
            if (Cu != null) {
                Cu.a(bVar);
                return;
            } else {
                this.pWy.a(bVar);
                return;
            }
        }
        this.pWy.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.b bVar) {
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n Cu = l.Cu(true);
            if (Cu != null) {
                Cu.a(bVar);
                return;
            } else {
                this.pWy.a(bVar);
                return;
            }
        }
        this.pWy.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, long j) {
        this.pWx.a(i, i2, j);
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n Cu = l.Cu(true);
            if (Cu != null) {
                Cu.a(i, i2, j);
                return;
            } else {
                this.pWy.a(i, i2, j);
                return;
            }
        }
        this.pWy.a(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, long j) {
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n Cu = l.Cu(true);
            if (Cu != null) {
                Cu.a(i, i2, i3, j);
                return;
            } else {
                this.pWy.a(i, i2, i3, j);
                return;
            }
        }
        this.pWy.a(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, int i4) {
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n Cu = l.Cu(true);
            if (Cu != null) {
                Cu.a(i, i2, i3, i4);
                return;
            } else {
                this.pWy.a(i, i2, i3, i4);
                return;
            }
        }
        this.pWy.a(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, int i2) {
        com.ss.android.socialbase.downloader.g.c a2 = this.pWx.a(i, i2);
        c(a2);
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean a2 = this.pWx.a(cVar);
        c(cVar);
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean e(int i) {
        try {
            if (com.ss.android.socialbase.downloader.m.d.b()) {
                com.ss.android.socialbase.downloader.downloader.n Cu = l.Cu(true);
                if (Cu != null) {
                    Cu.n(i);
                } else {
                    this.pWy.e(i);
                }
            } else {
                this.pWy.e(i);
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        return this.pWx.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean f(int i) {
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n Cu = l.Cu(true);
            if (Cu != null) {
                Cu.p(i);
            } else {
                this.pWy.f(i);
            }
        } else {
            this.pWy.f(i);
        }
        return this.pWx.f(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b() {
        try {
            this.pWx.b();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n Cu = l.Cu(true);
            if (Cu != null) {
                Cu.f();
                return;
            } else {
                this.pWy.b();
                return;
            }
        }
        this.pWy.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j, String str, String str2) {
        com.ss.android.socialbase.downloader.g.c a2 = this.pWx.a(i, j, str, str2);
        c(a2);
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j) {
        com.ss.android.socialbase.downloader.g.c a2 = this.pWx.a(i, j);
        a(a2, false);
        return a2;
    }

    private void c(com.ss.android.socialbase.downloader.g.c cVar) {
        a(cVar, true);
    }

    private void a(com.ss.android.socialbase.downloader.g.c cVar, boolean z) {
        if (cVar != null) {
            if (com.ss.android.socialbase.downloader.m.d.b()) {
                if (z) {
                    com.ss.android.socialbase.downloader.downloader.n Cu = l.Cu(true);
                    if (Cu != null) {
                        Cu.c(cVar);
                        return;
                    } else {
                        this.pWy.a(cVar);
                        return;
                    }
                }
                return;
            }
            this.pWy.a(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i, long j) {
        com.ss.android.socialbase.downloader.g.c b2 = this.pWx.b(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.g.b>) null);
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        com.ss.android.socialbase.downloader.g.c h = this.pWx.h(i);
        c(h);
        return h;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c c(int i, long j) {
        com.ss.android.socialbase.downloader.g.c c = this.pWx.c(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.g.b>) null);
        return c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c d(int i, long j) {
        com.ss.android.socialbase.downloader.g.c d = this.pWx.d(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.g.b>) null);
        return d;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c i(int i) {
        com.ss.android.socialbase.downloader.g.c i2 = this.pWx.i(i);
        c(i2);
        return i2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c j(int i) {
        com.ss.android.socialbase.downloader.g.c j = this.pWx.j(i);
        c(j);
        return j;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null) {
            this.pWx.a(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        if (list != null && list.size() != 0) {
            this.pWx.a(i, list);
            if (com.ss.android.socialbase.downloader.m.d.c()) {
                this.pWy.b(i, list);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        try {
            a(this.pWx.b(i));
            if (list == null) {
                list = this.pWx.c(i);
            }
            if (com.ss.android.socialbase.downloader.m.d.b()) {
                com.ss.android.socialbase.downloader.downloader.n Cu = l.Cu(true);
                if (Cu != null) {
                    Cu.b(i, list);
                    return;
                } else {
                    this.pWy.b(i, list);
                    return;
                }
            }
            this.pWy.b(i, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
