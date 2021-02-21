package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.ss.android.socialbase.downloader.d.ab;
import com.ss.android.socialbase.downloader.d.ad;
import com.ss.android.socialbase.downloader.d.y;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13137a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final boolean f13138b;
    private final Handler e;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> g;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> h;
    private int n;
    private long o;
    private com.ss.android.socialbase.downloader.g.c qfY;
    private final k qfZ;
    private com.ss.android.socialbase.downloader.g.d qga;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> qgb;
    private ad qgd;
    private com.ss.android.socialbase.downloader.d.c qge;
    private boolean j = false;
    private volatile long k = 0;
    private final AtomicLong qgc = new AtomicLong();
    private boolean m = false;

    public e(com.ss.android.socialbase.downloader.g.d dVar, Handler handler) {
        this.qga = dVar;
        j();
        this.e = handler;
        this.qfZ = b.eGs();
        com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
        if (a2 != null) {
            this.f13138b = com.ss.android.socialbase.downloader.k.a.RW(a2.g()).a("fix_start_with_file_exist_update_error");
        } else {
            this.f13138b = false;
        }
    }

    private void j() {
        if (this.qga != null) {
            this.qfY = this.qga.a();
            this.g = this.qga.b(com.ss.android.socialbase.downloader.b.h.MAIN);
            this.qgb = this.qga.b(com.ss.android.socialbase.downloader.b.h.NOTIFICATION);
            this.h = this.qga.b(com.ss.android.socialbase.downloader.b.h.SUB);
            this.qgd = this.qga.eIj();
            this.qge = this.qga.eIk();
        }
    }

    public void a() {
        if (!this.qfY.eHy()) {
            this.qfY.c(1);
            k();
        }
    }

    private void k() {
        ExecutorService eGk = b.eGk();
        if (eGk != null) {
            eGk.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.qfZ.i(e.this.qfY.g());
                    e.this.a(1, (com.ss.android.socialbase.downloader.e.a) null);
                }
            });
        }
    }

    public void b() {
        if (this.qfY.eHy()) {
            this.qfY.aH();
            return;
        }
        this.qfZ.g(this.qfY.g());
        if (this.qfY.eHR()) {
            a(6, (com.ss.android.socialbase.downloader.e.a) null);
        }
        a(2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(long j, String str, String str2) {
        this.qfY.f(j);
        this.qfY.c(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.qfY.h())) {
            this.qfY.d(str2);
        }
        try {
            this.qfZ.a(this.qfY.g(), j, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(3, (com.ss.android.socialbase.downloader.e.a) null);
        this.o = this.qfY.jn(j);
        this.n = this.qfY.eHL();
        this.j = true;
        com.ss.android.socialbase.downloader.impls.r.eIB().e();
    }

    public boolean a(long j) {
        this.qgc.addAndGet(j);
        this.qfY.e(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    public void c() {
        a(-4, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void d() {
        this.qfY.c(-2);
        try {
            this.qfZ.d(this.qfY.g(), this.qfY.eHi());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void e() {
        this.qfY.c(-7);
        try {
            this.qfZ.j(this.qfY.g());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-7, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.qfY.g(false);
        this.qgc.set(0L);
        c(aVar, z);
    }

    public void a(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.qfY.g(false);
        this.qgc.set(0L);
        this.qfZ.h(this.qfY.g());
        a(z ? 10 : 9, aVar, true);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
        this.qfY.g(false);
        b(aVar);
    }

    private void b(com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar != null && aVar.getCause() != null && (aVar.getCause() instanceof SQLiteFullException)) {
            try {
                this.qfZ.f(this.qfY.g());
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.qfZ.b(this.qfY.g(), this.qfY.eHi());
            } catch (SQLiteException e2) {
                try {
                    this.qfZ.f(this.qfY.g());
                } catch (SQLiteException e3) {
                    e3.printStackTrace();
                }
            }
        }
        com.ss.android.socialbase.downloader.e.a c = c(aVar);
        this.qfY.a(c);
        a(c instanceof com.ss.android.socialbase.downloader.e.f ? -2 : -1, c);
        if (com.ss.android.socialbase.downloader.k.a.RW(this.qfY.g()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.eIB().a(this.qfY);
        }
    }

    private com.ss.android.socialbase.downloader.e.a c(com.ss.android.socialbase.downloader.e.a aVar) {
        Context eGC;
        if (com.ss.android.socialbase.downloader.k.a.RW(this.qfY.g()).a("download_failed_check_net", 0) == 1 && com.ss.android.socialbase.downloader.m.d.J(aVar) && (eGC = b.eGC()) != null && !com.ss.android.socialbase.downloader.m.d.b(eGC)) {
            return new com.ss.android.socialbase.downloader.e.a(this.qfY.x() ? 1013 : 1049, aVar.b());
        }
        return aVar;
    }

    public void f() {
        this.qfY.g(false);
        if (!this.qfY.ag() && this.qfY.eHi() != this.qfY.eir()) {
            com.ss.android.socialbase.downloader.f.a.b(f13137a, this.qfY.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes changed with process : " + this.qfY.eHj()));
        } else if (this.qfY.eHi() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f13137a, this.qfY.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, "curBytes is 0, bytes changed with process : " + this.qfY.eHj()));
        } else if (!this.qfY.ag() && this.qfY.eir() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f13137a, this.qfY.d());
            a(new com.ss.android.socialbase.downloader.e.g(1044, "TotalBytes is 0, bytes changed with process : " + this.qfY.eHj()));
        } else {
            com.ss.android.socialbase.downloader.f.a.b(f13137a, "" + this.qfY.h() + " onCompleted start save file as target name");
            com.ss.android.socialbase.downloader.d.c cVar = this.qge;
            if (this.qga != null) {
                cVar = this.qga.eIk();
            }
            if (this.qfY.ah()) {
                com.ss.android.socialbase.downloader.m.d.a(this.qfY, cVar, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.2
                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a() {
                        e.this.l();
                    }

                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
                        com.ss.android.socialbase.downloader.f.a.b(e.f13137a, "saveFileAsTargetName onFailed : " + (aVar != null ? aVar.b() : ""));
                        e.this.a(aVar);
                    }
                });
            } else {
                com.ss.android.socialbase.downloader.m.d.a(this.qfY, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.3
                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a() {
                        e.this.l();
                    }

                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
                        com.ss.android.socialbase.downloader.f.a.b(e.f13137a, "saveFileAsTargetName onFailed : " + (aVar != null ? aVar.b() : ""));
                        e.this.a(aVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.ss.android.socialbase.downloader.f.a.b(f13137a, "saveFileAsTargetName onSuccess");
            try {
                m();
                this.qfY.h(false);
                a(-3, (com.ss.android.socialbase.downloader.e.a) null);
                this.qfZ.c(this.qfY.g(), this.qfY.eir());
                this.qfZ.d(this.qfY.g());
            } catch (com.ss.android.socialbase.downloader.e.a e) {
                a(e);
            }
        } catch (Throwable th) {
            a(new com.ss.android.socialbase.downloader.e.a(1008, com.ss.android.socialbase.downloader.m.d.c(th, "onCompleted")));
        }
    }

    public void g() throws com.ss.android.socialbase.downloader.e.a {
        if (this.f13138b) {
            m();
            com.ss.android.socialbase.downloader.f.a.b(f13137a, "onCompleteForFileExist");
            a(-3, (com.ss.android.socialbase.downloader.e.a) null);
            this.qfZ.c(this.qfY.g(), this.qfY.eir());
            this.qfZ.d(this.qfY.g());
            this.qfZ.a(this.qfY);
            return;
        }
        m();
        com.ss.android.socialbase.downloader.f.a.b(f13137a, "onCompleteForFileExist");
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
        this.qfZ.c(this.qfY.g(), this.qfY.eir());
        this.qfZ.d(this.qfY.g());
    }

    public void a(String str) throws com.ss.android.socialbase.downloader.e.a {
        com.ss.android.socialbase.downloader.f.a.b(f13137a, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.qfY.h());
        if (this.f13138b) {
            com.ss.android.socialbase.downloader.m.d.a(this.qfY, str);
            m();
            a(-3, (com.ss.android.socialbase.downloader.e.a) null);
            this.qfZ.a(this.qfY);
            return;
        }
        this.qfZ.a(this.qfY);
        com.ss.android.socialbase.downloader.m.d.a(this.qfY, str);
        m();
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
    }

    private void m() throws com.ss.android.socialbase.downloader.e.a {
        ab eIt = this.qga.eIt();
        if (eIt != null) {
            try {
                com.ss.android.socialbase.downloader.g.c cVar = this.qfY;
                if (eIt.b(cVar)) {
                    a(11, (com.ss.android.socialbase.downloader.e.a) null);
                    this.qfZ.a(cVar);
                    eIt.a(cVar);
                    this.qfZ.a(cVar);
                }
            } catch (com.ss.android.socialbase.downloader.e.a e) {
                throw e;
            } catch (Throwable th) {
                throw new com.ss.android.socialbase.downloader.e.a(1071, th);
            }
        }
    }

    private boolean a(long j, boolean z) {
        boolean z2 = false;
        if (this.qfY.eHi() == this.qfY.eir()) {
            try {
                this.qfZ.a(this.qfY.g(), this.qfY.eHi());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (this.j) {
            this.j = false;
            this.qfY.c(4);
        }
        if (this.qfY.eHJ() && z) {
            z2 = true;
        }
        a(4, (com.ss.android.socialbase.downloader.e.a) null, z2);
        return z;
    }

    private boolean b(long j) {
        boolean z = true;
        if (!this.m) {
            this.m = true;
        } else {
            long j2 = j - this.k;
            if (this.qgc.get() < this.o && j2 < this.n) {
                z = false;
            }
            if (z) {
                this.k = j;
                this.qgc.set(0L);
            }
        }
        return z;
    }

    private void c(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.qfZ.h(this.qfY.g());
        a(z ? 7 : 5, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.ss.android.socialbase.downloader.e.a aVar) {
        a(i, aVar, true);
    }

    public void h() {
        this.qfY.c(8);
        this.qfY.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a eGx = b.eGx();
        if (eGx != null) {
            eGx.a(this.qfY.g(), 8);
        }
    }

    private void a(int i, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        boolean z2;
        int[] a2;
        int q = this.qfY.q();
        if (q != -3 || i != 4) {
            j();
            if (i != 4 && com.ss.android.socialbase.downloader.b.f.e(i)) {
                this.qfY.f(false);
                if (com.ss.android.socialbase.downloader.b.f.d(i)) {
                    this.qfY.aa();
                }
            }
            if (this.qge != null && (this.qge instanceof y) && (a2 = ((y) this.qge).a()) != null && a2.length > 0) {
                for (int i2 : a2) {
                    if (i == i2) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (com.ss.android.socialbase.downloader.b.f.c(i) || z2) {
                try {
                    if (this.qgd != null) {
                        this.qgd.a(this.qfY, aVar, i);
                    }
                } catch (Throwable th) {
                }
                com.ss.android.socialbase.downloader.h.a.a(this.qge, this.qfY, aVar, i);
            }
            if (i == 6) {
                this.qfY.c(2);
            } else if (i == -6) {
                this.qfY.c(-3);
            } else {
                this.qfY.c(i);
            }
            if (q == -3 || q == -1) {
                if (this.qfY.eHw() == com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADING) {
                    this.qfY.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADED);
                }
                if (this.qfY.eHx() == com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADING) {
                    this.qfY.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADED);
                }
                if (this.qfY.eHj() == com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                    this.qfY.a(com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
                }
            }
            com.ss.android.socialbase.downloader.m.c.a(i, this.h, true, this.qfY, aVar);
            if (i != -4) {
                if (z && (((this.g != null && this.g.size() > 0) || (this.qgb != null && this.qgb.size() > 0 && this.qfY.eHm())) && this.e != null)) {
                    this.e.obtainMessage(i, this.qfY.g(), 0, aVar).sendToTarget();
                    return;
                }
                com.ss.android.socialbase.downloader.impls.a eGx = b.eGx();
                if (eGx != null) {
                    eGx.a(this.qfY.g(), i);
                }
            }
        }
    }
}
