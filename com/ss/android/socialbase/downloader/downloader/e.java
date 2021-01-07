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
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13435a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final boolean f13436b;
    private final Handler e;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> g;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> h;
    private int n;
    private long o;
    private com.ss.android.socialbase.downloader.g.c pZU;
    private final k pZV;
    private com.ss.android.socialbase.downloader.g.d pZW;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> pZX;
    private ad pZZ;
    private com.ss.android.socialbase.downloader.d.c qaa;
    private boolean j = false;
    private volatile long k = 0;
    private final AtomicLong pZY = new AtomicLong();
    private boolean m = false;

    public e(com.ss.android.socialbase.downloader.g.d dVar, Handler handler) {
        this.pZW = dVar;
        j();
        this.e = handler;
        this.pZV = b.eHJ();
        com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
        if (a2 != null) {
            this.f13436b = com.ss.android.socialbase.downloader.k.a.Th(a2.g()).a("fix_start_with_file_exist_update_error");
        } else {
            this.f13436b = false;
        }
    }

    private void j() {
        if (this.pZW != null) {
            this.pZU = this.pZW.a();
            this.g = this.pZW.b(com.ss.android.socialbase.downloader.b.h.MAIN);
            this.pZX = this.pZW.b(com.ss.android.socialbase.downloader.b.h.NOTIFICATION);
            this.h = this.pZW.b(com.ss.android.socialbase.downloader.b.h.SUB);
            this.pZZ = this.pZW.eJA();
            this.qaa = this.pZW.eJB();
        }
    }

    public void a() {
        if (!this.pZU.eIP()) {
            this.pZU.c(1);
            k();
        }
    }

    private void k() {
        ExecutorService eHB = b.eHB();
        if (eHB != null) {
            eHB.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.pZV.i(e.this.pZU.g());
                    e.this.a(1, (com.ss.android.socialbase.downloader.e.a) null);
                }
            });
        }
    }

    public void b() {
        if (this.pZU.eIP()) {
            this.pZU.aH();
            return;
        }
        this.pZV.g(this.pZU.g());
        if (this.pZU.eJi()) {
            a(6, (com.ss.android.socialbase.downloader.e.a) null);
        }
        a(2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(long j, String str, String str2) {
        this.pZU.f(j);
        this.pZU.c(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.pZU.h())) {
            this.pZU.d(str2);
        }
        try {
            this.pZV.a(this.pZU.g(), j, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(3, (com.ss.android.socialbase.downloader.e.a) null);
        this.o = this.pZU.jk(j);
        this.n = this.pZU.eJc();
        this.j = true;
        com.ss.android.socialbase.downloader.impls.r.eJS().e();
    }

    public boolean a(long j) {
        this.pZY.addAndGet(j);
        this.pZU.e(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    public void c() {
        a(-4, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void d() {
        this.pZU.c(-2);
        try {
            this.pZV.d(this.pZU.g(), this.pZU.eIz());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void e() {
        this.pZU.c(-7);
        try {
            this.pZV.j(this.pZU.g());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-7, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.pZU.g(false);
        this.pZY.set(0L);
        c(aVar, z);
    }

    public void a(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.pZU.g(false);
        this.pZY.set(0L);
        this.pZV.h(this.pZU.g());
        a(z ? 10 : 9, aVar, true);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
        this.pZU.g(false);
        b(aVar);
    }

    private void b(com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar != null && aVar.getCause() != null && (aVar.getCause() instanceof SQLiteFullException)) {
            try {
                this.pZV.f(this.pZU.g());
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.pZV.b(this.pZU.g(), this.pZU.eIz());
            } catch (SQLiteException e2) {
                try {
                    this.pZV.f(this.pZU.g());
                } catch (SQLiteException e3) {
                    e3.printStackTrace();
                }
            }
        }
        com.ss.android.socialbase.downloader.e.a c = c(aVar);
        this.pZU.a(c);
        a(c instanceof com.ss.android.socialbase.downloader.e.f ? -2 : -1, c);
        if (com.ss.android.socialbase.downloader.k.a.Th(this.pZU.g()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.eJS().a(this.pZU);
        }
    }

    private com.ss.android.socialbase.downloader.e.a c(com.ss.android.socialbase.downloader.e.a aVar) {
        Context eHT;
        if (com.ss.android.socialbase.downloader.k.a.Th(this.pZU.g()).a("download_failed_check_net", 0) == 1 && com.ss.android.socialbase.downloader.m.d.K(aVar) && (eHT = b.eHT()) != null && !com.ss.android.socialbase.downloader.m.d.b(eHT)) {
            return new com.ss.android.socialbase.downloader.e.a(this.pZU.x() ? 1013 : 1049, aVar.b());
        }
        return aVar;
    }

    public void f() {
        this.pZU.g(false);
        if (!this.pZU.ag() && this.pZU.eIz() != this.pZU.ejL()) {
            com.ss.android.socialbase.downloader.f.a.b(f13435a, this.pZU.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes changed with process : " + this.pZU.eIA()));
        } else if (this.pZU.eIz() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f13435a, this.pZU.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, "curBytes is 0, bytes changed with process : " + this.pZU.eIA()));
        } else if (!this.pZU.ag() && this.pZU.ejL() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f13435a, this.pZU.d());
            a(new com.ss.android.socialbase.downloader.e.g(1044, "TotalBytes is 0, bytes changed with process : " + this.pZU.eIA()));
        } else {
            com.ss.android.socialbase.downloader.f.a.b(f13435a, "" + this.pZU.h() + " onCompleted start save file as target name");
            com.ss.android.socialbase.downloader.d.c cVar = this.qaa;
            if (this.pZW != null) {
                cVar = this.pZW.eJB();
            }
            if (this.pZU.ah()) {
                com.ss.android.socialbase.downloader.m.d.a(this.pZU, cVar, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.2
                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a() {
                        e.this.l();
                    }

                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
                        com.ss.android.socialbase.downloader.f.a.b(e.f13435a, "saveFileAsTargetName onFailed : " + (aVar != null ? aVar.b() : ""));
                        e.this.a(aVar);
                    }
                });
            } else {
                com.ss.android.socialbase.downloader.m.d.a(this.pZU, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.3
                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a() {
                        e.this.l();
                    }

                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
                        com.ss.android.socialbase.downloader.f.a.b(e.f13435a, "saveFileAsTargetName onFailed : " + (aVar != null ? aVar.b() : ""));
                        e.this.a(aVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.ss.android.socialbase.downloader.f.a.b(f13435a, "saveFileAsTargetName onSuccess");
            try {
                m();
                this.pZU.h(false);
                a(-3, (com.ss.android.socialbase.downloader.e.a) null);
                this.pZV.c(this.pZU.g(), this.pZU.ejL());
                this.pZV.d(this.pZU.g());
            } catch (com.ss.android.socialbase.downloader.e.a e) {
                a(e);
            }
        } catch (Throwable th) {
            a(new com.ss.android.socialbase.downloader.e.a(1008, com.ss.android.socialbase.downloader.m.d.c(th, "onCompleted")));
        }
    }

    public void g() throws com.ss.android.socialbase.downloader.e.a {
        if (this.f13436b) {
            m();
            com.ss.android.socialbase.downloader.f.a.b(f13435a, "onCompleteForFileExist");
            a(-3, (com.ss.android.socialbase.downloader.e.a) null);
            this.pZV.c(this.pZU.g(), this.pZU.ejL());
            this.pZV.d(this.pZU.g());
            this.pZV.a(this.pZU);
            return;
        }
        m();
        com.ss.android.socialbase.downloader.f.a.b(f13435a, "onCompleteForFileExist");
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
        this.pZV.c(this.pZU.g(), this.pZU.ejL());
        this.pZV.d(this.pZU.g());
    }

    public void a(String str) throws com.ss.android.socialbase.downloader.e.a {
        com.ss.android.socialbase.downloader.f.a.b(f13435a, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.pZU.h());
        if (this.f13436b) {
            com.ss.android.socialbase.downloader.m.d.a(this.pZU, str);
            m();
            a(-3, (com.ss.android.socialbase.downloader.e.a) null);
            this.pZV.a(this.pZU);
            return;
        }
        this.pZV.a(this.pZU);
        com.ss.android.socialbase.downloader.m.d.a(this.pZU, str);
        m();
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
    }

    private void m() throws com.ss.android.socialbase.downloader.e.a {
        ab eJK = this.pZW.eJK();
        if (eJK != null) {
            try {
                com.ss.android.socialbase.downloader.g.c cVar = this.pZU;
                if (eJK.b(cVar)) {
                    a(11, (com.ss.android.socialbase.downloader.e.a) null);
                    this.pZV.a(cVar);
                    eJK.a(cVar);
                    this.pZV.a(cVar);
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
        if (this.pZU.eIz() == this.pZU.ejL()) {
            try {
                this.pZV.a(this.pZU.g(), this.pZU.eIz());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (this.j) {
            this.j = false;
            this.pZU.c(4);
        }
        if (this.pZU.eJa() && z) {
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
            if (this.pZY.get() < this.o && j2 < this.n) {
                z = false;
            }
            if (z) {
                this.k = j;
                this.pZY.set(0L);
            }
        }
        return z;
    }

    private void c(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.pZV.h(this.pZU.g());
        a(z ? 7 : 5, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.ss.android.socialbase.downloader.e.a aVar) {
        a(i, aVar, true);
    }

    public void h() {
        this.pZU.c(8);
        this.pZU.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a eHO = b.eHO();
        if (eHO != null) {
            eHO.a(this.pZU.g(), 8);
        }
    }

    private void a(int i, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        boolean z2;
        int[] a2;
        int q = this.pZU.q();
        if (q != -3 || i != 4) {
            j();
            if (i != 4 && com.ss.android.socialbase.downloader.b.f.e(i)) {
                this.pZU.f(false);
                if (com.ss.android.socialbase.downloader.b.f.d(i)) {
                    this.pZU.aa();
                }
            }
            if (this.qaa != null && (this.qaa instanceof y) && (a2 = ((y) this.qaa).a()) != null && a2.length > 0) {
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
                    if (this.pZZ != null) {
                        this.pZZ.a(this.pZU, aVar, i);
                    }
                } catch (Throwable th) {
                }
                com.ss.android.socialbase.downloader.h.a.a(this.qaa, this.pZU, aVar, i);
            }
            if (i == 6) {
                this.pZU.c(2);
            } else if (i == -6) {
                this.pZU.c(-3);
            } else {
                this.pZU.c(i);
            }
            if (q == -3 || q == -1) {
                if (this.pZU.eIN() == com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADING) {
                    this.pZU.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADED);
                }
                if (this.pZU.eIO() == com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADING) {
                    this.pZU.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADED);
                }
                if (this.pZU.eIA() == com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                    this.pZU.a(com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
                }
            }
            com.ss.android.socialbase.downloader.m.c.a(i, this.h, true, this.pZU, aVar);
            if (i != -4) {
                if (z && (((this.g != null && this.g.size() > 0) || (this.pZX != null && this.pZX.size() > 0 && this.pZU.eID())) && this.e != null)) {
                    this.e.obtainMessage(i, this.pZU.g(), 0, aVar).sendToTarget();
                    return;
                }
                com.ss.android.socialbase.downloader.impls.a eHO = b.eHO();
                if (eHO != null) {
                    eHO.a(this.pZU.g(), i);
                }
            }
        }
    }
}
