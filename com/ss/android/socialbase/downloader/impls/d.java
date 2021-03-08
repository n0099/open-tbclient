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
    private t qhT;
    private com.ss.android.socialbase.downloader.l.f qhV;
    private f.a qhU = new f.a() { // from class: com.ss.android.socialbase.downloader.impls.d.1
        @Override // com.ss.android.socialbase.downloader.l.f.a
        public void a(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.b.eGo().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.d.1.1
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
    private final k qhS = new k();

    public d() {
        this.qhV = null;
        if (com.ss.android.socialbase.downloader.k.a.eIH().a("fix_sigbus_downloader_db")) {
            if (com.ss.android.socialbase.downloader.m.d.a()) {
                this.qhT = new com.ss.android.socialbase.downloader.c.e();
            } else {
                com.ss.android.socialbase.downloader.c.f fVar = new com.ss.android.socialbase.downloader.c.f();
                fVar.a(new f.a() { // from class: com.ss.android.socialbase.downloader.impls.d.2
                    @Override // com.ss.android.socialbase.downloader.c.f.a
                    public void a() {
                        d.this.qhT = new com.ss.android.socialbase.downloader.c.e();
                        Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                    }
                });
                this.qhT = fVar;
            }
        } else {
            this.qhT = new com.ss.android.socialbase.downloader.c.e();
        }
        this.c = false;
        this.qhV = new com.ss.android.socialbase.downloader.l.f(Looper.getMainLooper(), this.qhU);
        f();
    }

    public k eIA() {
        return this.qhS;
    }

    public t eIB() {
        return this.qhT;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c g(int i) {
        com.ss.android.socialbase.downloader.g.c g = this.qhS.g(i);
        c(g);
        return g;
    }

    public void f() {
        com.ss.android.socialbase.downloader.downloader.b.a(com.ss.android.socialbase.downloader.b.d.SYNC_START);
        this.qhT.a(this.qhS.a(), this.qhS.eIC(), new com.ss.android.socialbase.downloader.c.d() { // from class: com.ss.android.socialbase.downloader.impls.d.3
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
        if (com.ss.android.socialbase.downloader.k.a.eIH().a("task_resume_delay")) {
            j = 4000;
        } else if (Build.VERSION.SDK_INT >= 23) {
            j = 1000;
        } else {
            j = 5000;
        }
        this.qhV.sendMessageDelayed(this.qhV.obtainMessage(1), j);
    }

    public void h() {
        com.ss.android.socialbase.downloader.downloader.m eGv;
        List<String> a2;
        SparseArray<com.ss.android.socialbase.downloader.g.c> a3;
        com.ss.android.socialbase.downloader.g.c cVar;
        if (this.c) {
            if (this.d) {
                com.ss.android.socialbase.downloader.f.a.b("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.d = true;
            if (com.ss.android.socialbase.downloader.m.d.a() && (eGv = com.ss.android.socialbase.downloader.downloader.b.eGv()) != null && (a2 = eGv.a()) != null && !a2.isEmpty() && (a3 = this.qhS.a()) != null) {
                ArrayList arrayList = new ArrayList();
                synchronized (a3) {
                    for (int i = 0; i < a3.size(); i++) {
                        int keyAt = a3.keyAt(i);
                        if (keyAt != 0 && (cVar = a3.get(keyAt)) != null && cVar.at() != null && a2.contains(cVar.at()) && (cVar.w() != -2 || cVar.U())) {
                            cVar.d(false);
                            arrayList.add(cVar);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    eGv.a(arrayList, 1);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i) {
        return this.qhS.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        return this.qhS.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        return this.qhS.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        return this.qhS.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        return this.qhS.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.b> c(int i) {
        return this.qhS.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void d(int i) {
        this.qhS.d(i);
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CM = l.CM(true);
            if (CM != null) {
                CM.o(i);
                return;
            } else {
                this.qhT.d(i);
                return;
            }
        }
        this.qhT.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        this.qhS.a(bVar);
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CM = l.CM(true);
            if (CM != null) {
                CM.a(bVar);
                return;
            } else {
                this.qhT.a(bVar);
                return;
            }
        }
        this.qhT.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.b bVar) {
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CM = l.CM(true);
            if (CM != null) {
                CM.a(bVar);
                return;
            } else {
                this.qhT.a(bVar);
                return;
            }
        }
        this.qhT.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, long j) {
        this.qhS.a(i, i2, j);
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CM = l.CM(true);
            if (CM != null) {
                CM.a(i, i2, j);
                return;
            } else {
                this.qhT.a(i, i2, j);
                return;
            }
        }
        this.qhT.a(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, long j) {
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CM = l.CM(true);
            if (CM != null) {
                CM.a(i, i2, i3, j);
                return;
            } else {
                this.qhT.a(i, i2, i3, j);
                return;
            }
        }
        this.qhT.a(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, int i4) {
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CM = l.CM(true);
            if (CM != null) {
                CM.a(i, i2, i3, i4);
                return;
            } else {
                this.qhT.a(i, i2, i3, i4);
                return;
            }
        }
        this.qhT.a(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, int i2) {
        com.ss.android.socialbase.downloader.g.c a2 = this.qhS.a(i, i2);
        c(a2);
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean a2 = this.qhS.a(cVar);
        c(cVar);
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean e(int i) {
        try {
            if (com.ss.android.socialbase.downloader.m.d.b()) {
                com.ss.android.socialbase.downloader.downloader.n CM = l.CM(true);
                if (CM != null) {
                    CM.n(i);
                } else {
                    this.qhT.e(i);
                }
            } else {
                this.qhT.e(i);
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        return this.qhS.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean f(int i) {
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CM = l.CM(true);
            if (CM != null) {
                CM.p(i);
            } else {
                this.qhT.f(i);
            }
        } else {
            this.qhT.f(i);
        }
        return this.qhS.f(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b() {
        try {
            this.qhS.b();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.m.d.b()) {
            com.ss.android.socialbase.downloader.downloader.n CM = l.CM(true);
            if (CM != null) {
                CM.f();
                return;
            } else {
                this.qhT.b();
                return;
            }
        }
        this.qhT.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j, String str, String str2) {
        com.ss.android.socialbase.downloader.g.c a2 = this.qhS.a(i, j, str, str2);
        c(a2);
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j) {
        com.ss.android.socialbase.downloader.g.c a2 = this.qhS.a(i, j);
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
                    com.ss.android.socialbase.downloader.downloader.n CM = l.CM(true);
                    if (CM != null) {
                        CM.c(cVar);
                        return;
                    } else {
                        this.qhT.a(cVar);
                        return;
                    }
                }
                return;
            }
            this.qhT.a(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i, long j) {
        com.ss.android.socialbase.downloader.g.c b = this.qhS.b(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.g.b>) null);
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        com.ss.android.socialbase.downloader.g.c h = this.qhS.h(i);
        c(h);
        return h;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c c(int i, long j) {
        com.ss.android.socialbase.downloader.g.c c = this.qhS.c(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.g.b>) null);
        return c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c d(int i, long j) {
        com.ss.android.socialbase.downloader.g.c d = this.qhS.d(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.g.b>) null);
        return d;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c i(int i) {
        com.ss.android.socialbase.downloader.g.c i2 = this.qhS.i(i);
        c(i2);
        return i2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c j(int i) {
        com.ss.android.socialbase.downloader.g.c j = this.qhS.j(i);
        c(j);
        return j;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null) {
            this.qhS.a(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        if (list != null && list.size() != 0) {
            this.qhS.a(i, list);
            if (com.ss.android.socialbase.downloader.m.d.c()) {
                this.qhT.b(i, list);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        try {
            a(this.qhS.b(i));
            if (list == null) {
                list = this.qhS.c(i);
            }
            if (com.ss.android.socialbase.downloader.m.d.b()) {
                com.ss.android.socialbase.downloader.downloader.n CM = l.CM(true);
                if (CM != null) {
                    CM.b(i, list);
                    return;
                } else {
                    this.qhT.b(i, list);
                    return;
                }
            }
            this.qhT.b(i, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
