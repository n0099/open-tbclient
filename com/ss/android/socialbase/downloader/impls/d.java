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
/* loaded from: classes6.dex */
public class d implements com.ss.android.socialbase.downloader.downloader.k {
    private volatile boolean c;
    private volatile boolean d;
    private t qhc;
    private com.ss.android.socialbase.downloader.l.f qhe;
    private f.a qhd = new f.a() { // from class: com.ss.android.socialbase.downloader.impls.d.1
        @Override // com.ss.android.socialbase.downloader.l.f.a
        public void a(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.b.eGk().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.d.1.1
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
    private final k qhb = new k();

    public d() {
        this.qhe = null;
        if (com.ss.android.socialbase.downloader.k.a.eIF().a("fix_sigbus_downloader_db")) {
            if (com.ss.android.socialbase.downloader.m.d.a()) {
                this.qhc = new com.ss.android.socialbase.downloader.c.e();
            } else {
                com.ss.android.socialbase.downloader.c.f fVar = new com.ss.android.socialbase.downloader.c.f();
                fVar.a(new f.a() { // from class: com.ss.android.socialbase.downloader.impls.d.2
                    @Override // com.ss.android.socialbase.downloader.c.f.a
                    public void a() {
                        d.this.qhc = new com.ss.android.socialbase.downloader.c.e();
                        Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                    }
                });
                this.qhc = fVar;
            }
        } else {
            this.qhc = new com.ss.android.socialbase.downloader.c.e();
        }
        this.c = false;
        this.qhe = new com.ss.android.socialbase.downloader.l.f(Looper.getMainLooper(), this.qhd);
        f();
    }

    public k eIy() {
        return this.qhb;
    }

    public t eIz() {
        return this.qhc;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c g(int i) {
        com.ss.android.socialbase.downloader.g.c g = this.qhb.g(i);
        c(g);
        return g;
    }

    public void f() {
        com.ss.android.socialbase.downloader.downloader.b.a(com.ss.android.socialbase.downloader.b.d.SYNC_START);
        this.qhc.a(this.qhb.a(), this.qhb.eIA(), new com.ss.android.socialbase.downloader.c.d() { // from class: com.ss.android.socialbase.downloader.impls.d.3
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
        if (com.ss.android.socialbase.downloader.k.a.eIF().a("task_resume_delay")) {
            j = 4000;
        } else if (Build.VERSION.SDK_INT >= 23) {
            j = 1000;
        } else {
            j = 5000;
        }
        this.qhe.sendMessageDelayed(this.qhe.obtainMessage(1), j);
    }

    public void h() {
        com.ss.android.socialbase.downloader.downloader.m eGr;
        List<String> a2;
        SparseArray<com.ss.android.socialbase.downloader.g.c> a3;
        com.ss.android.socialbase.downloader.g.c cVar;
        if (this.c) {
            if (this.d) {
                com.ss.android.socialbase.downloader.f.a.b("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.d = true;
            if (com.ss.android.socialbase.downloader.m.d.a() && (eGr = com.ss.android.socialbase.downloader.downloader.b.eGr()) != null && (a2 = eGr.a()) != null && !a2.isEmpty() && (a3 = this.qhb.a()) != null) {
                ArrayList arrayList = new ArrayList();
                synchronized (a3) {
                    for (int i = 0; i < a3.size(); i++) {
                        int keyAt = a3.keyAt(i);
                        if (keyAt != 0 && (cVar = a3.get(keyAt)) != null && cVar.eHn() != null && a2.contains(cVar.eHn()) && (cVar.w() != -2 || cVar.U())) {
                            cVar.d(false);
                            arrayList.add(cVar);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    eGr.a(arrayList, 1);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i) {
        return this.qhb.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        return this.qhb.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        return this.qhb.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        return this.qhb.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        return this.qhb.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.b> c(int i) {
        return this.qhb.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void d(int i) {
        this.qhb.d(i);
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CO = l.CO(true);
            if (CO != null) {
                CO.o(i);
                return;
            } else {
                this.qhc.d(i);
                return;
            }
        }
        this.qhc.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        this.qhb.a(bVar);
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CO = l.CO(true);
            if (CO != null) {
                CO.a(bVar);
                return;
            } else {
                this.qhc.a(bVar);
                return;
            }
        }
        this.qhc.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.b bVar) {
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CO = l.CO(true);
            if (CO != null) {
                CO.a(bVar);
                return;
            } else {
                this.qhc.a(bVar);
                return;
            }
        }
        this.qhc.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, long j) {
        this.qhb.a(i, i2, j);
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CO = l.CO(true);
            if (CO != null) {
                CO.a(i, i2, j);
                return;
            } else {
                this.qhc.a(i, i2, j);
                return;
            }
        }
        this.qhc.a(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, long j) {
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CO = l.CO(true);
            if (CO != null) {
                CO.a(i, i2, i3, j);
                return;
            } else {
                this.qhc.a(i, i2, i3, j);
                return;
            }
        }
        this.qhc.a(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, int i4) {
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CO = l.CO(true);
            if (CO != null) {
                CO.a(i, i2, i3, i4);
                return;
            } else {
                this.qhc.a(i, i2, i3, i4);
                return;
            }
        }
        this.qhc.a(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, int i2) {
        com.ss.android.socialbase.downloader.g.c a2 = this.qhb.a(i, i2);
        c(a2);
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean a2 = this.qhb.a(cVar);
        c(cVar);
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean e(int i) {
        try {
            if (com.ss.android.socialbase.downloader.m.d.b()) {
                com.ss.android.socialbase.downloader.downloader.n CO = l.CO(true);
                if (CO != null) {
                    CO.n(i);
                } else {
                    this.qhc.e(i);
                }
            } else {
                this.qhc.e(i);
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        return this.qhb.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean f(int i) {
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CO = l.CO(true);
            if (CO != null) {
                CO.p(i);
            } else {
                this.qhc.f(i);
            }
        } else {
            this.qhc.f(i);
        }
        return this.qhb.f(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b() {
        try {
            this.qhb.b();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CO = l.CO(true);
            if (CO != null) {
                CO.f();
                return;
            } else {
                this.qhc.b();
                return;
            }
        }
        this.qhc.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j, String str, String str2) {
        com.ss.android.socialbase.downloader.g.c a2 = this.qhb.a(i, j, str, str2);
        c(a2);
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j) {
        com.ss.android.socialbase.downloader.g.c a2 = this.qhb.a(i, j);
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
                    com.ss.android.socialbase.downloader.downloader.n CO = l.CO(true);
                    if (CO != null) {
                        CO.c(cVar);
                        return;
                    } else {
                        this.qhc.a(cVar);
                        return;
                    }
                }
                return;
            }
            this.qhc.a(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i, long j) {
        com.ss.android.socialbase.downloader.g.c b2 = this.qhb.b(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.g.b>) null);
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        com.ss.android.socialbase.downloader.g.c h = this.qhb.h(i);
        c(h);
        return h;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c c(int i, long j) {
        com.ss.android.socialbase.downloader.g.c c = this.qhb.c(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.g.b>) null);
        return c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c d(int i, long j) {
        com.ss.android.socialbase.downloader.g.c d = this.qhb.d(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.g.b>) null);
        return d;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c i(int i) {
        com.ss.android.socialbase.downloader.g.c i2 = this.qhb.i(i);
        c(i2);
        return i2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c j(int i) {
        com.ss.android.socialbase.downloader.g.c j = this.qhb.j(i);
        c(j);
        return j;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null) {
            this.qhb.a(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        if (list != null && list.size() != 0) {
            this.qhb.a(i, list);
            if (com.ss.android.socialbase.downloader.m.d.c()) {
                this.qhc.b(i, list);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        try {
            a(this.qhb.b(i));
            if (list == null) {
                list = this.qhb.c(i);
            }
            if (com.ss.android.socialbase.downloader.m.d.b()) {
                com.ss.android.socialbase.downloader.downloader.n CO = l.CO(true);
                if (CO != null) {
                    CO.b(i, list);
                    return;
                } else {
                    this.qhc.b(i, list);
                    return;
                }
            }
            this.qhc.b(i, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
