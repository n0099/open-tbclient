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
    private static final String f13135a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final boolean f13136b;
    private final Handler e;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> g;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> h;
    private int n;
    private long o;
    private com.ss.android.socialbase.downloader.g.c pVt;
    private final k pVu;
    private com.ss.android.socialbase.downloader.g.d pVv;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> pVw;
    private ad pVy;
    private com.ss.android.socialbase.downloader.d.c pVz;
    private boolean j = false;
    private volatile long k = 0;
    private final AtomicLong pVx = new AtomicLong();
    private boolean m = false;

    public e(com.ss.android.socialbase.downloader.g.d dVar, Handler handler) {
        this.pVv = dVar;
        j();
        this.e = handler;
        this.pVu = b.eDT();
        com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
        if (a2 != null) {
            this.f13136b = com.ss.android.socialbase.downloader.k.a.RA(a2.g()).a("fix_start_with_file_exist_update_error");
        } else {
            this.f13136b = false;
        }
    }

    private void j() {
        if (this.pVv != null) {
            this.pVt = this.pVv.a();
            this.g = this.pVv.b(com.ss.android.socialbase.downloader.b.h.MAIN);
            this.pVw = this.pVv.b(com.ss.android.socialbase.downloader.b.h.NOTIFICATION);
            this.h = this.pVv.b(com.ss.android.socialbase.downloader.b.h.SUB);
            this.pVy = this.pVv.eFK();
            this.pVz = this.pVv.eFL();
        }
    }

    public void a() {
        if (!this.pVt.eEZ()) {
            this.pVt.c(1);
            k();
        }
    }

    private void k() {
        ExecutorService eDL = b.eDL();
        if (eDL != null) {
            eDL.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.pVu.i(e.this.pVt.g());
                    e.this.a(1, (com.ss.android.socialbase.downloader.e.a) null);
                }
            });
        }
    }

    public void b() {
        if (this.pVt.eEZ()) {
            this.pVt.aH();
            return;
        }
        this.pVu.g(this.pVt.g());
        if (this.pVt.eFs()) {
            a(6, (com.ss.android.socialbase.downloader.e.a) null);
        }
        a(2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(long j, String str, String str2) {
        this.pVt.f(j);
        this.pVt.c(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.pVt.h())) {
            this.pVt.d(str2);
        }
        try {
            this.pVu.a(this.pVt.g(), j, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(3, (com.ss.android.socialbase.downloader.e.a) null);
        this.o = this.pVt.jk(j);
        this.n = this.pVt.eFm();
        this.j = true;
        com.ss.android.socialbase.downloader.impls.r.eGc().e();
    }

    public boolean a(long j) {
        this.pVx.addAndGet(j);
        this.pVt.e(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    public void c() {
        a(-4, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void d() {
        this.pVt.c(-2);
        try {
            this.pVu.d(this.pVt.g(), this.pVt.eEJ());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void e() {
        this.pVt.c(-7);
        try {
            this.pVu.j(this.pVt.g());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-7, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.pVt.g(false);
        this.pVx.set(0L);
        c(aVar, z);
    }

    public void a(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.pVt.g(false);
        this.pVx.set(0L);
        this.pVu.h(this.pVt.g());
        a(z ? 10 : 9, aVar, true);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
        this.pVt.g(false);
        b(aVar);
    }

    private void b(com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar != null && aVar.getCause() != null && (aVar.getCause() instanceof SQLiteFullException)) {
            try {
                this.pVu.f(this.pVt.g());
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.pVu.b(this.pVt.g(), this.pVt.eEJ());
            } catch (SQLiteException e2) {
                try {
                    this.pVu.f(this.pVt.g());
                } catch (SQLiteException e3) {
                    e3.printStackTrace();
                }
            }
        }
        com.ss.android.socialbase.downloader.e.a c = c(aVar);
        this.pVt.a(c);
        a(c instanceof com.ss.android.socialbase.downloader.e.f ? -2 : -1, c);
        if (com.ss.android.socialbase.downloader.k.a.RA(this.pVt.g()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.eGc().a(this.pVt);
        }
    }

    private com.ss.android.socialbase.downloader.e.a c(com.ss.android.socialbase.downloader.e.a aVar) {
        Context eEd;
        if (com.ss.android.socialbase.downloader.k.a.RA(this.pVt.g()).a("download_failed_check_net", 0) == 1 && com.ss.android.socialbase.downloader.m.d.K(aVar) && (eEd = b.eEd()) != null && !com.ss.android.socialbase.downloader.m.d.b(eEd)) {
            return new com.ss.android.socialbase.downloader.e.a(this.pVt.x() ? 1013 : 1049, aVar.b());
        }
        return aVar;
    }

    public void f() {
        this.pVt.g(false);
        if (!this.pVt.ag() && this.pVt.eEJ() != this.pVt.efR()) {
            com.ss.android.socialbase.downloader.f.a.b(f13135a, this.pVt.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes changed with process : " + this.pVt.eEK()));
        } else if (this.pVt.eEJ() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f13135a, this.pVt.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, "curBytes is 0, bytes changed with process : " + this.pVt.eEK()));
        } else if (!this.pVt.ag() && this.pVt.efR() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f13135a, this.pVt.d());
            a(new com.ss.android.socialbase.downloader.e.g(1044, "TotalBytes is 0, bytes changed with process : " + this.pVt.eEK()));
        } else {
            com.ss.android.socialbase.downloader.f.a.b(f13135a, "" + this.pVt.h() + " onCompleted start save file as target name");
            com.ss.android.socialbase.downloader.d.c cVar = this.pVz;
            if (this.pVv != null) {
                cVar = this.pVv.eFL();
            }
            if (this.pVt.ah()) {
                com.ss.android.socialbase.downloader.m.d.a(this.pVt, cVar, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.2
                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a() {
                        e.this.l();
                    }

                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
                        com.ss.android.socialbase.downloader.f.a.b(e.f13135a, "saveFileAsTargetName onFailed : " + (aVar != null ? aVar.b() : ""));
                        e.this.a(aVar);
                    }
                });
            } else {
                com.ss.android.socialbase.downloader.m.d.a(this.pVt, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.3
                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a() {
                        e.this.l();
                    }

                    @Override // com.ss.android.socialbase.downloader.d.s
                    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
                        com.ss.android.socialbase.downloader.f.a.b(e.f13135a, "saveFileAsTargetName onFailed : " + (aVar != null ? aVar.b() : ""));
                        e.this.a(aVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.ss.android.socialbase.downloader.f.a.b(f13135a, "saveFileAsTargetName onSuccess");
            try {
                m();
                this.pVt.h(false);
                a(-3, (com.ss.android.socialbase.downloader.e.a) null);
                this.pVu.c(this.pVt.g(), this.pVt.efR());
                this.pVu.d(this.pVt.g());
            } catch (com.ss.android.socialbase.downloader.e.a e) {
                a(e);
            }
        } catch (Throwable th) {
            a(new com.ss.android.socialbase.downloader.e.a(1008, com.ss.android.socialbase.downloader.m.d.c(th, "onCompleted")));
        }
    }

    public void g() throws com.ss.android.socialbase.downloader.e.a {
        if (this.f13136b) {
            m();
            com.ss.android.socialbase.downloader.f.a.b(f13135a, "onCompleteForFileExist");
            a(-3, (com.ss.android.socialbase.downloader.e.a) null);
            this.pVu.c(this.pVt.g(), this.pVt.efR());
            this.pVu.d(this.pVt.g());
            this.pVu.a(this.pVt);
            return;
        }
        m();
        com.ss.android.socialbase.downloader.f.a.b(f13135a, "onCompleteForFileExist");
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
        this.pVu.c(this.pVt.g(), this.pVt.efR());
        this.pVu.d(this.pVt.g());
    }

    public void a(String str) throws com.ss.android.socialbase.downloader.e.a {
        com.ss.android.socialbase.downloader.f.a.b(f13135a, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.pVt.h());
        if (this.f13136b) {
            com.ss.android.socialbase.downloader.m.d.a(this.pVt, str);
            m();
            a(-3, (com.ss.android.socialbase.downloader.e.a) null);
            this.pVu.a(this.pVt);
            return;
        }
        this.pVu.a(this.pVt);
        com.ss.android.socialbase.downloader.m.d.a(this.pVt, str);
        m();
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
    }

    private void m() throws com.ss.android.socialbase.downloader.e.a {
        ab eFU = this.pVv.eFU();
        if (eFU != null) {
            try {
                com.ss.android.socialbase.downloader.g.c cVar = this.pVt;
                if (eFU.b(cVar)) {
                    a(11, (com.ss.android.socialbase.downloader.e.a) null);
                    this.pVu.a(cVar);
                    eFU.a(cVar);
                    this.pVu.a(cVar);
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
        if (this.pVt.eEJ() == this.pVt.efR()) {
            try {
                this.pVu.a(this.pVt.g(), this.pVt.eEJ());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (this.j) {
            this.j = false;
            this.pVt.c(4);
        }
        if (this.pVt.eFk() && z) {
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
            if (this.pVx.get() < this.o && j2 < this.n) {
                z = false;
            }
            if (z) {
                this.k = j;
                this.pVx.set(0L);
            }
        }
        return z;
    }

    private void c(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.pVu.h(this.pVt.g());
        a(z ? 7 : 5, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.ss.android.socialbase.downloader.e.a aVar) {
        a(i, aVar, true);
    }

    public void h() {
        this.pVt.c(8);
        this.pVt.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a eDY = b.eDY();
        if (eDY != null) {
            eDY.a(this.pVt.g(), 8);
        }
    }

    private void a(int i, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        boolean z2;
        int[] a2;
        int q = this.pVt.q();
        if (q != -3 || i != 4) {
            j();
            if (i != 4 && com.ss.android.socialbase.downloader.b.f.e(i)) {
                this.pVt.f(false);
                if (com.ss.android.socialbase.downloader.b.f.d(i)) {
                    this.pVt.aa();
                }
            }
            if (this.pVz != null && (this.pVz instanceof y) && (a2 = ((y) this.pVz).a()) != null && a2.length > 0) {
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
                    if (this.pVy != null) {
                        this.pVy.a(this.pVt, aVar, i);
                    }
                } catch (Throwable th) {
                }
                com.ss.android.socialbase.downloader.h.a.a(this.pVz, this.pVt, aVar, i);
            }
            if (i == 6) {
                this.pVt.c(2);
            } else if (i == -6) {
                this.pVt.c(-3);
            } else {
                this.pVt.c(i);
            }
            if (q == -3 || q == -1) {
                if (this.pVt.eEX() == com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADING) {
                    this.pVt.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADED);
                }
                if (this.pVt.eEY() == com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADING) {
                    this.pVt.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADED);
                }
                if (this.pVt.eEK() == com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                    this.pVt.a(com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
                }
            }
            com.ss.android.socialbase.downloader.m.c.a(i, this.h, true, this.pVt, aVar);
            if (i != -4) {
                if (z && (((this.g != null && this.g.size() > 0) || (this.pVw != null && this.pVw.size() > 0 && this.pVt.eEN())) && this.e != null)) {
                    this.e.obtainMessage(i, this.pVt.g(), 0, aVar).sendToTarget();
                    return;
                }
                com.ss.android.socialbase.downloader.impls.a eDY = b.eDY();
                if (eDY != null) {
                    eDY.a(this.pVt.g(), i);
                }
            }
        }
    }
}
