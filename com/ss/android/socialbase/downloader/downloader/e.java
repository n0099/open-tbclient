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
    private static final String f7821a = e.class.getSimpleName();
    private final boolean b;
    private final Handler e;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> g;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> h;
    private int n;
    private long o;
    private com.ss.android.socialbase.downloader.g.c qgN;
    private final k qgO;
    private com.ss.android.socialbase.downloader.g.d qgP;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> qgQ;
    private ad qgS;
    private com.ss.android.socialbase.downloader.d.c qgT;
    private boolean j = false;
    private volatile long k = 0;
    private final AtomicLong qgR = new AtomicLong();
    private boolean m = false;

    public e(com.ss.android.socialbase.downloader.g.d dVar, Handler handler) {
        this.qgP = dVar;
        j();
        this.e = handler;
        this.qgO = b.eGw();
        com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
        if (a2 != null) {
            this.b = com.ss.android.socialbase.downloader.k.a.Sa(a2.g()).a("fix_start_with_file_exist_update_error");
        } else {
            this.b = false;
        }
    }

    private void j() {
        if (this.qgP != null) {
            this.qgN = this.qgP.a();
            this.g = this.qgP.b(com.ss.android.socialbase.downloader.b.h.MAIN);
            this.qgQ = this.qgP.b(com.ss.android.socialbase.downloader.b.h.NOTIFICATION);
            this.h = this.qgP.b(com.ss.android.socialbase.downloader.b.h.SUB);
            this.qgS = this.qgP.eIl();
            this.qgT = this.qgP.eIm();
        }
    }

    public void a() {
        if (!this.qgN.eHA()) {
            this.qgN.c(1);
            k();
        }
    }

    private void k() {
        ExecutorService eGo = b.eGo();
        if (eGo != null) {
            eGo.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.qgO.i(e.this.qgN.g());
                    e.this.a(1, (com.ss.android.socialbase.downloader.e.a) null);
                }
            });
        }
    }

    public void b() {
        if (this.qgN.eHA()) {
            this.qgN.aH();
            return;
        }
        this.qgO.g(this.qgN.g());
        if (this.qgN.eHT()) {
            a(6, (com.ss.android.socialbase.downloader.e.a) null);
        }
        a(2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(long j, String str, String str2) {
        this.qgN.f(j);
        this.qgN.c(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.qgN.h())) {
            this.qgN.d(str2);
        }
        try {
            this.qgO.a(this.qgN.g(), j, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(3, (com.ss.android.socialbase.downloader.e.a) null);
        this.o = this.qgN.jn(j);
        this.n = this.qgN.eHN();
        this.j = true;
        com.ss.android.socialbase.downloader.impls.r.eID().e();
    }

    public boolean a(long j) {
        this.qgR.addAndGet(j);
        this.qgN.e(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    public void c() {
        a(-4, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void d() {
        this.qgN.c(-2);
        try {
            this.qgO.d(this.qgN.g(), this.qgN.eHm());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void e() {
        this.qgN.c(-7);
        try {
            this.qgO.j(this.qgN.g());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-7, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.qgN.g(false);
        this.qgR.set(0L);
        c(aVar, z);
    }

    public void a(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.qgN.g(false);
        this.qgR.set(0L);
        this.qgO.h(this.qgN.g());
        a(z ? 10 : 9, aVar, true);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
        this.qgN.g(false);
        b(aVar);
    }

    private void b(com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar != null && aVar.getCause() != null && (aVar.getCause() instanceof SQLiteFullException)) {
            try {
                this.qgO.f(this.qgN.g());
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.qgO.b(this.qgN.g(), this.qgN.eHm());
            } catch (SQLiteException e2) {
                try {
                    this.qgO.f(this.qgN.g());
                } catch (SQLiteException e3) {
                    e3.printStackTrace();
                }
            }
        }
        com.ss.android.socialbase.downloader.e.a c = c(aVar);
        this.qgN.a(c);
        a(c instanceof com.ss.android.socialbase.downloader.e.f ? -2 : -1, c);
        if (com.ss.android.socialbase.downloader.k.a.Sa(this.qgN.g()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.eID().a(this.qgN);
        }
    }

    private com.ss.android.socialbase.downloader.e.a c(com.ss.android.socialbase.downloader.e.a aVar) {
        Context eGG;
        if (com.ss.android.socialbase.downloader.k.a.Sa(this.qgN.g()).a("download_failed_check_net", 0) == 1 && com.ss.android.socialbase.downloader.m.d.J(aVar) && (eGG = b.eGG()) != null && !com.ss.android.socialbase.downloader.m.d.b(eGG)) {
            return new com.ss.android.socialbase.downloader.e.a(this.qgN.x() ? 1013 : 1049, aVar.b());
        }
        return aVar;
    }

    public void f() {
        this.qgN.g(false);
        if (!this.qgN.ag() && this.qgN.eHm() != this.qgN.am()) {
            com.ss.android.socialbase.downloader.f.a.b(f7821a, this.qgN.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes changed with process : " + this.qgN.eHn()));
        } else if (this.qgN.eHm() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f7821a, this.qgN.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, "curBytes is 0, bytes changed with process : " + this.qgN.eHn()));
        } else if (!this.qgN.ag() && this.qgN.am() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f7821a, this.qgN.d());
            a(new com.ss.android.socialbase.downloader.e.g(1044, "TotalBytes is 0, bytes changed with process : " + this.qgN.eHn()));
        } else {
            com.ss.android.socialbase.downloader.f.a.b(f7821a, "" + this.qgN.h() + " onCompleted start save file as target name");
            com.ss.android.socialbase.downloader.d.c cVar = this.qgT;
            if (this.qgP != null) {
                cVar = this.qgP.eIm();
            }
            if (this.qgN.eHk()) {
                com.ss.android.socialbase.downloader.m.d.a(this.qgN, cVar, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.2
                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a() {
                        e.this.l();
                    }

                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
                        com.ss.android.socialbase.downloader.f.a.b(e.f7821a, "saveFileAsTargetName onFailed : " + (aVar != null ? aVar.b() : ""));
                        e.this.a(aVar);
                    }
                });
            } else {
                com.ss.android.socialbase.downloader.m.d.a(this.qgN, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.3
                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a() {
                        e.this.l();
                    }

                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
                        com.ss.android.socialbase.downloader.f.a.b(e.f7821a, "saveFileAsTargetName onFailed : " + (aVar != null ? aVar.b() : ""));
                        e.this.a(aVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.ss.android.socialbase.downloader.f.a.b(f7821a, "saveFileAsTargetName onSuccess");
            try {
                m();
                this.qgN.h(false);
                a(-3, (com.ss.android.socialbase.downloader.e.a) null);
                this.qgO.c(this.qgN.g(), this.qgN.am());
                this.qgO.d(this.qgN.g());
            } catch (com.ss.android.socialbase.downloader.e.a e) {
                a(e);
            }
        } catch (Throwable th) {
            a(new com.ss.android.socialbase.downloader.e.a(1008, com.ss.android.socialbase.downloader.m.d.c(th, "onCompleted")));
        }
    }

    public void g() throws com.ss.android.socialbase.downloader.e.a {
        if (this.b) {
            m();
            com.ss.android.socialbase.downloader.f.a.b(f7821a, "onCompleteForFileExist");
            a(-3, (com.ss.android.socialbase.downloader.e.a) null);
            this.qgO.c(this.qgN.g(), this.qgN.am());
            this.qgO.d(this.qgN.g());
            this.qgO.a(this.qgN);
            return;
        }
        m();
        com.ss.android.socialbase.downloader.f.a.b(f7821a, "onCompleteForFileExist");
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
        this.qgO.c(this.qgN.g(), this.qgN.am());
        this.qgO.d(this.qgN.g());
    }

    public void a(String str) throws com.ss.android.socialbase.downloader.e.a {
        com.ss.android.socialbase.downloader.f.a.b(f7821a, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.qgN.h());
        if (this.b) {
            com.ss.android.socialbase.downloader.m.d.a(this.qgN, str);
            m();
            a(-3, (com.ss.android.socialbase.downloader.e.a) null);
            this.qgO.a(this.qgN);
            return;
        }
        this.qgO.a(this.qgN);
        com.ss.android.socialbase.downloader.m.d.a(this.qgN, str);
        m();
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
    }

    private void m() throws com.ss.android.socialbase.downloader.e.a {
        ab eIv = this.qgP.eIv();
        if (eIv != null) {
            try {
                com.ss.android.socialbase.downloader.g.c cVar = this.qgN;
                if (eIv.b(cVar)) {
                    a(11, (com.ss.android.socialbase.downloader.e.a) null);
                    this.qgO.a(cVar);
                    eIv.a(cVar);
                    this.qgO.a(cVar);
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
        if (this.qgN.eHm() == this.qgN.am()) {
            try {
                this.qgO.a(this.qgN.g(), this.qgN.eHm());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (this.j) {
            this.j = false;
            this.qgN.c(4);
        }
        if (this.qgN.eHL() && z) {
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
            if (this.qgR.get() < this.o && j2 < this.n) {
                z = false;
            }
            if (z) {
                this.k = j;
                this.qgR.set(0L);
            }
        }
        return z;
    }

    private void c(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.qgO.h(this.qgN.g());
        a(z ? 7 : 5, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.ss.android.socialbase.downloader.e.a aVar) {
        a(i, aVar, true);
    }

    public void h() {
        this.qgN.c(8);
        this.qgN.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a eGB = b.eGB();
        if (eGB != null) {
            eGB.a(this.qgN.g(), 8);
        }
    }

    private void a(int i, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        boolean z2;
        int[] a2;
        int q = this.qgN.q();
        if (q != -3 || i != 4) {
            j();
            if (i != 4 && com.ss.android.socialbase.downloader.b.f.e(i)) {
                this.qgN.f(false);
                if (com.ss.android.socialbase.downloader.b.f.d(i)) {
                    this.qgN.aa();
                }
            }
            if (this.qgT != null && (this.qgT instanceof y) && (a2 = ((y) this.qgT).a()) != null && a2.length > 0) {
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
                    if (this.qgS != null) {
                        this.qgS.a(this.qgN, aVar, i);
                    }
                } catch (Throwable th) {
                }
                com.ss.android.socialbase.downloader.h.a.a(this.qgT, this.qgN, aVar, i);
            }
            if (i == 6) {
                this.qgN.c(2);
            } else if (i == -6) {
                this.qgN.c(-3);
            } else {
                this.qgN.c(i);
            }
            if (q == -3 || q == -1) {
                if (this.qgN.eHy() == com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADING) {
                    this.qgN.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADED);
                }
                if (this.qgN.eHz() == com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADING) {
                    this.qgN.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADED);
                }
                if (this.qgN.eHn() == com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                    this.qgN.a(com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
                }
            }
            com.ss.android.socialbase.downloader.m.c.a(i, this.h, true, this.qgN, aVar);
            if (i != -4) {
                if (z && (((this.g != null && this.g.size() > 0) || (this.qgQ != null && this.qgQ.size() > 0 && this.qgN.eHs())) && this.e != null)) {
                    this.e.obtainMessage(i, this.qgN.g(), 0, aVar).sendToTarget();
                    return;
                }
                com.ss.android.socialbase.downloader.impls.a eGB = b.eGB();
                if (eGB != null) {
                    eGB.a(this.qgN.g(), i);
                }
            }
        }
    }
}
