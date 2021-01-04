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
    private static final String f13434a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final boolean f13435b;
    private final Handler e;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> g;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> h;
    private int n;
    private long o;
    private com.ss.android.socialbase.downloader.g.c pYm;
    private final k pYn;
    private com.ss.android.socialbase.downloader.g.d pYo;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> pYp;
    private ad pYr;
    private com.ss.android.socialbase.downloader.d.c pYs;
    private boolean j = false;
    private volatile long k = 0;
    private final AtomicLong pYq = new AtomicLong();
    private boolean m = false;

    public e(com.ss.android.socialbase.downloader.g.d dVar, Handler handler) {
        this.pYo = dVar;
        j();
        this.e = handler;
        this.pYn = b.eHf();
        com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
        if (a2 != null) {
            this.f13435b = com.ss.android.socialbase.downloader.k.a.SR(a2.g()).a("fix_start_with_file_exist_update_error");
        } else {
            this.f13435b = false;
        }
    }

    private void j() {
        if (this.pYo != null) {
            this.pYm = this.pYo.a();
            this.g = this.pYo.b(com.ss.android.socialbase.downloader.b.h.MAIN);
            this.pYp = this.pYo.b(com.ss.android.socialbase.downloader.b.h.NOTIFICATION);
            this.h = this.pYo.b(com.ss.android.socialbase.downloader.b.h.SUB);
            this.pYr = this.pYo.eIW();
            this.pYs = this.pYo.eIX();
        }
    }

    public void a() {
        if (!this.pYm.eIl()) {
            this.pYm.c(1);
            k();
        }
    }

    private void k() {
        ExecutorService eGX = b.eGX();
        if (eGX != null) {
            eGX.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.pYn.i(e.this.pYm.g());
                    e.this.a(1, (com.ss.android.socialbase.downloader.e.a) null);
                }
            });
        }
    }

    public void b() {
        if (this.pYm.eIl()) {
            this.pYm.aH();
            return;
        }
        this.pYn.g(this.pYm.g());
        if (this.pYm.eIE()) {
            a(6, (com.ss.android.socialbase.downloader.e.a) null);
        }
        a(2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(long j, String str, String str2) {
        this.pYm.f(j);
        this.pYm.c(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.pYm.h())) {
            this.pYm.d(str2);
        }
        try {
            this.pYn.a(this.pYm.g(), j, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(3, (com.ss.android.socialbase.downloader.e.a) null);
        this.o = this.pYm.jh(j);
        this.n = this.pYm.eIy();
        this.j = true;
        com.ss.android.socialbase.downloader.impls.r.eJo().e();
    }

    public boolean a(long j) {
        this.pYq.addAndGet(j);
        this.pYm.e(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    public void c() {
        a(-4, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void d() {
        this.pYm.c(-2);
        try {
            this.pYn.d(this.pYm.g(), this.pYm.eHV());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void e() {
        this.pYm.c(-7);
        try {
            this.pYn.j(this.pYm.g());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-7, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.pYm.g(false);
        this.pYq.set(0L);
        c(aVar, z);
    }

    public void a(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.pYm.g(false);
        this.pYq.set(0L);
        this.pYn.h(this.pYm.g());
        a(z ? 10 : 9, aVar, true);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
        this.pYm.g(false);
        b(aVar);
    }

    private void b(com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar != null && aVar.getCause() != null && (aVar.getCause() instanceof SQLiteFullException)) {
            try {
                this.pYn.f(this.pYm.g());
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.pYn.b(this.pYm.g(), this.pYm.eHV());
            } catch (SQLiteException e2) {
                try {
                    this.pYn.f(this.pYm.g());
                } catch (SQLiteException e3) {
                    e3.printStackTrace();
                }
            }
        }
        com.ss.android.socialbase.downloader.e.a c = c(aVar);
        this.pYm.a(c);
        a(c instanceof com.ss.android.socialbase.downloader.e.f ? -2 : -1, c);
        if (com.ss.android.socialbase.downloader.k.a.SR(this.pYm.g()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.eJo().a(this.pYm);
        }
    }

    private com.ss.android.socialbase.downloader.e.a c(com.ss.android.socialbase.downloader.e.a aVar) {
        Context eHp;
        if (com.ss.android.socialbase.downloader.k.a.SR(this.pYm.g()).a("download_failed_check_net", 0) == 1 && com.ss.android.socialbase.downloader.m.d.K(aVar) && (eHp = b.eHp()) != null && !com.ss.android.socialbase.downloader.m.d.b(eHp)) {
            return new com.ss.android.socialbase.downloader.e.a(this.pYm.x() ? 1013 : 1049, aVar.b());
        }
        return aVar;
    }

    public void f() {
        this.pYm.g(false);
        if (!this.pYm.ag() && this.pYm.eHV() != this.pYm.ejK()) {
            com.ss.android.socialbase.downloader.f.a.b(f13434a, this.pYm.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes changed with process : " + this.pYm.eHW()));
        } else if (this.pYm.eHV() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f13434a, this.pYm.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, "curBytes is 0, bytes changed with process : " + this.pYm.eHW()));
        } else if (!this.pYm.ag() && this.pYm.ejK() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f13434a, this.pYm.d());
            a(new com.ss.android.socialbase.downloader.e.g(1044, "TotalBytes is 0, bytes changed with process : " + this.pYm.eHW()));
        } else {
            com.ss.android.socialbase.downloader.f.a.b(f13434a, "" + this.pYm.h() + " onCompleted start save file as target name");
            com.ss.android.socialbase.downloader.d.c cVar = this.pYs;
            if (this.pYo != null) {
                cVar = this.pYo.eIX();
            }
            if (this.pYm.ah()) {
                com.ss.android.socialbase.downloader.m.d.a(this.pYm, cVar, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.2
                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a() {
                        e.this.l();
                    }

                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
                        com.ss.android.socialbase.downloader.f.a.b(e.f13434a, "saveFileAsTargetName onFailed : " + (aVar != null ? aVar.b() : ""));
                        e.this.a(aVar);
                    }
                });
            } else {
                com.ss.android.socialbase.downloader.m.d.a(this.pYm, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.3
                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a() {
                        e.this.l();
                    }

                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
                        com.ss.android.socialbase.downloader.f.a.b(e.f13434a, "saveFileAsTargetName onFailed : " + (aVar != null ? aVar.b() : ""));
                        e.this.a(aVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.ss.android.socialbase.downloader.f.a.b(f13434a, "saveFileAsTargetName onSuccess");
            try {
                m();
                this.pYm.h(false);
                a(-3, (com.ss.android.socialbase.downloader.e.a) null);
                this.pYn.c(this.pYm.g(), this.pYm.ejK());
                this.pYn.d(this.pYm.g());
            } catch (com.ss.android.socialbase.downloader.e.a e) {
                a(e);
            }
        } catch (Throwable th) {
            a(new com.ss.android.socialbase.downloader.e.a(1008, com.ss.android.socialbase.downloader.m.d.c(th, "onCompleted")));
        }
    }

    public void g() throws com.ss.android.socialbase.downloader.e.a {
        if (this.f13435b) {
            m();
            com.ss.android.socialbase.downloader.f.a.b(f13434a, "onCompleteForFileExist");
            a(-3, (com.ss.android.socialbase.downloader.e.a) null);
            this.pYn.c(this.pYm.g(), this.pYm.ejK());
            this.pYn.d(this.pYm.g());
            this.pYn.a(this.pYm);
            return;
        }
        m();
        com.ss.android.socialbase.downloader.f.a.b(f13434a, "onCompleteForFileExist");
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
        this.pYn.c(this.pYm.g(), this.pYm.ejK());
        this.pYn.d(this.pYm.g());
    }

    public void a(String str) throws com.ss.android.socialbase.downloader.e.a {
        com.ss.android.socialbase.downloader.f.a.b(f13434a, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.pYm.h());
        if (this.f13435b) {
            com.ss.android.socialbase.downloader.m.d.a(this.pYm, str);
            m();
            a(-3, (com.ss.android.socialbase.downloader.e.a) null);
            this.pYn.a(this.pYm);
            return;
        }
        this.pYn.a(this.pYm);
        com.ss.android.socialbase.downloader.m.d.a(this.pYm, str);
        m();
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
    }

    private void m() throws com.ss.android.socialbase.downloader.e.a {
        ab eJg = this.pYo.eJg();
        if (eJg != null) {
            try {
                com.ss.android.socialbase.downloader.g.c cVar = this.pYm;
                if (eJg.b(cVar)) {
                    a(11, (com.ss.android.socialbase.downloader.e.a) null);
                    this.pYn.a(cVar);
                    eJg.a(cVar);
                    this.pYn.a(cVar);
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
        if (this.pYm.eHV() == this.pYm.ejK()) {
            try {
                this.pYn.a(this.pYm.g(), this.pYm.eHV());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (this.j) {
            this.j = false;
            this.pYm.c(4);
        }
        if (this.pYm.eIw() && z) {
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
            if (this.pYq.get() < this.o && j2 < this.n) {
                z = false;
            }
            if (z) {
                this.k = j;
                this.pYq.set(0L);
            }
        }
        return z;
    }

    private void c(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.pYn.h(this.pYm.g());
        a(z ? 7 : 5, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.ss.android.socialbase.downloader.e.a aVar) {
        a(i, aVar, true);
    }

    public void h() {
        this.pYm.c(8);
        this.pYm.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a eHk = b.eHk();
        if (eHk != null) {
            eHk.a(this.pYm.g(), 8);
        }
    }

    private void a(int i, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        boolean z2;
        int[] a2;
        int q = this.pYm.q();
        if (q != -3 || i != 4) {
            j();
            if (i != 4 && com.ss.android.socialbase.downloader.b.f.e(i)) {
                this.pYm.f(false);
                if (com.ss.android.socialbase.downloader.b.f.d(i)) {
                    this.pYm.aa();
                }
            }
            if (this.pYs != null && (this.pYs instanceof y) && (a2 = ((y) this.pYs).a()) != null && a2.length > 0) {
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
                    if (this.pYr != null) {
                        this.pYr.a(this.pYm, aVar, i);
                    }
                } catch (Throwable th) {
                }
                com.ss.android.socialbase.downloader.h.a.a(this.pYs, this.pYm, aVar, i);
            }
            if (i == 6) {
                this.pYm.c(2);
            } else if (i == -6) {
                this.pYm.c(-3);
            } else {
                this.pYm.c(i);
            }
            if (q == -3 || q == -1) {
                if (this.pYm.eIj() == com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADING) {
                    this.pYm.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADED);
                }
                if (this.pYm.eIk() == com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADING) {
                    this.pYm.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADED);
                }
                if (this.pYm.eHW() == com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                    this.pYm.a(com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
                }
            }
            com.ss.android.socialbase.downloader.m.c.a(i, this.h, true, this.pYm, aVar);
            if (i != -4) {
                if (z && (((this.g != null && this.g.size() > 0) || (this.pYp != null && this.pYp.size() > 0 && this.pYm.eHZ())) && this.e != null)) {
                    this.e.obtainMessage(i, this.pYm.g(), 0, aVar).sendToTarget();
                    return;
                }
                com.ss.android.socialbase.downloader.impls.a eHk = b.eHk();
                if (eHk != null) {
                    eHk.a(this.pYm.g(), i);
                }
            }
        }
    }
}
