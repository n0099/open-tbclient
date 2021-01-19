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
    private com.ss.android.socialbase.downloader.d.c pVA;
    private com.ss.android.socialbase.downloader.g.c pVu;
    private final k pVv;
    private com.ss.android.socialbase.downloader.g.d pVw;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> pVx;
    private ad pVz;
    private boolean j = false;
    private volatile long k = 0;
    private final AtomicLong pVy = new AtomicLong();
    private boolean m = false;

    public e(com.ss.android.socialbase.downloader.g.d dVar, Handler handler) {
        this.pVw = dVar;
        j();
        this.e = handler;
        this.pVv = b.eDT();
        com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
        if (a2 != null) {
            this.f13136b = com.ss.android.socialbase.downloader.k.a.RA(a2.g()).a("fix_start_with_file_exist_update_error");
        } else {
            this.f13136b = false;
        }
    }

    private void j() {
        if (this.pVw != null) {
            this.pVu = this.pVw.a();
            this.g = this.pVw.b(com.ss.android.socialbase.downloader.b.h.MAIN);
            this.pVx = this.pVw.b(com.ss.android.socialbase.downloader.b.h.NOTIFICATION);
            this.h = this.pVw.b(com.ss.android.socialbase.downloader.b.h.SUB);
            this.pVz = this.pVw.eFK();
            this.pVA = this.pVw.eFL();
        }
    }

    public void a() {
        if (!this.pVu.eEZ()) {
            this.pVu.c(1);
            k();
        }
    }

    private void k() {
        ExecutorService eDL = b.eDL();
        if (eDL != null) {
            eDL.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.pVv.i(e.this.pVu.g());
                    e.this.a(1, (com.ss.android.socialbase.downloader.e.a) null);
                }
            });
        }
    }

    public void b() {
        if (this.pVu.eEZ()) {
            this.pVu.aH();
            return;
        }
        this.pVv.g(this.pVu.g());
        if (this.pVu.eFs()) {
            a(6, (com.ss.android.socialbase.downloader.e.a) null);
        }
        a(2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(long j, String str, String str2) {
        this.pVu.f(j);
        this.pVu.c(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.pVu.h())) {
            this.pVu.d(str2);
        }
        try {
            this.pVv.a(this.pVu.g(), j, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(3, (com.ss.android.socialbase.downloader.e.a) null);
        this.o = this.pVu.jk(j);
        this.n = this.pVu.eFm();
        this.j = true;
        com.ss.android.socialbase.downloader.impls.r.eGc().e();
    }

    public boolean a(long j) {
        this.pVy.addAndGet(j);
        this.pVu.e(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    public void c() {
        a(-4, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void d() {
        this.pVu.c(-2);
        try {
            this.pVv.d(this.pVu.g(), this.pVu.eEJ());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void e() {
        this.pVu.c(-7);
        try {
            this.pVv.j(this.pVu.g());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-7, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.pVu.g(false);
        this.pVy.set(0L);
        c(aVar, z);
    }

    public void a(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.pVu.g(false);
        this.pVy.set(0L);
        this.pVv.h(this.pVu.g());
        a(z ? 10 : 9, aVar, true);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
        this.pVu.g(false);
        b(aVar);
    }

    private void b(com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar != null && aVar.getCause() != null && (aVar.getCause() instanceof SQLiteFullException)) {
            try {
                this.pVv.f(this.pVu.g());
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.pVv.b(this.pVu.g(), this.pVu.eEJ());
            } catch (SQLiteException e2) {
                try {
                    this.pVv.f(this.pVu.g());
                } catch (SQLiteException e3) {
                    e3.printStackTrace();
                }
            }
        }
        com.ss.android.socialbase.downloader.e.a c = c(aVar);
        this.pVu.a(c);
        a(c instanceof com.ss.android.socialbase.downloader.e.f ? -2 : -1, c);
        if (com.ss.android.socialbase.downloader.k.a.RA(this.pVu.g()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.eGc().a(this.pVu);
        }
    }

    private com.ss.android.socialbase.downloader.e.a c(com.ss.android.socialbase.downloader.e.a aVar) {
        Context eEd;
        if (com.ss.android.socialbase.downloader.k.a.RA(this.pVu.g()).a("download_failed_check_net", 0) == 1 && com.ss.android.socialbase.downloader.m.d.K(aVar) && (eEd = b.eEd()) != null && !com.ss.android.socialbase.downloader.m.d.b(eEd)) {
            return new com.ss.android.socialbase.downloader.e.a(this.pVu.x() ? 1013 : 1049, aVar.b());
        }
        return aVar;
    }

    public void f() {
        this.pVu.g(false);
        if (!this.pVu.ag() && this.pVu.eEJ() != this.pVu.efR()) {
            com.ss.android.socialbase.downloader.f.a.b(f13135a, this.pVu.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes changed with process : " + this.pVu.eEK()));
        } else if (this.pVu.eEJ() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f13135a, this.pVu.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, "curBytes is 0, bytes changed with process : " + this.pVu.eEK()));
        } else if (!this.pVu.ag() && this.pVu.efR() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f13135a, this.pVu.d());
            a(new com.ss.android.socialbase.downloader.e.g(1044, "TotalBytes is 0, bytes changed with process : " + this.pVu.eEK()));
        } else {
            com.ss.android.socialbase.downloader.f.a.b(f13135a, "" + this.pVu.h() + " onCompleted start save file as target name");
            com.ss.android.socialbase.downloader.d.c cVar = this.pVA;
            if (this.pVw != null) {
                cVar = this.pVw.eFL();
            }
            if (this.pVu.ah()) {
                com.ss.android.socialbase.downloader.m.d.a(this.pVu, cVar, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.2
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
                com.ss.android.socialbase.downloader.m.d.a(this.pVu, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.3
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
                this.pVu.h(false);
                a(-3, (com.ss.android.socialbase.downloader.e.a) null);
                this.pVv.c(this.pVu.g(), this.pVu.efR());
                this.pVv.d(this.pVu.g());
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
            this.pVv.c(this.pVu.g(), this.pVu.efR());
            this.pVv.d(this.pVu.g());
            this.pVv.a(this.pVu);
            return;
        }
        m();
        com.ss.android.socialbase.downloader.f.a.b(f13135a, "onCompleteForFileExist");
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
        this.pVv.c(this.pVu.g(), this.pVu.efR());
        this.pVv.d(this.pVu.g());
    }

    public void a(String str) throws com.ss.android.socialbase.downloader.e.a {
        com.ss.android.socialbase.downloader.f.a.b(f13135a, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.pVu.h());
        if (this.f13136b) {
            com.ss.android.socialbase.downloader.m.d.a(this.pVu, str);
            m();
            a(-3, (com.ss.android.socialbase.downloader.e.a) null);
            this.pVv.a(this.pVu);
            return;
        }
        this.pVv.a(this.pVu);
        com.ss.android.socialbase.downloader.m.d.a(this.pVu, str);
        m();
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
    }

    private void m() throws com.ss.android.socialbase.downloader.e.a {
        ab eFU = this.pVw.eFU();
        if (eFU != null) {
            try {
                com.ss.android.socialbase.downloader.g.c cVar = this.pVu;
                if (eFU.b(cVar)) {
                    a(11, (com.ss.android.socialbase.downloader.e.a) null);
                    this.pVv.a(cVar);
                    eFU.a(cVar);
                    this.pVv.a(cVar);
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
        if (this.pVu.eEJ() == this.pVu.efR()) {
            try {
                this.pVv.a(this.pVu.g(), this.pVu.eEJ());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (this.j) {
            this.j = false;
            this.pVu.c(4);
        }
        if (this.pVu.eFk() && z) {
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
            if (this.pVy.get() < this.o && j2 < this.n) {
                z = false;
            }
            if (z) {
                this.k = j;
                this.pVy.set(0L);
            }
        }
        return z;
    }

    private void c(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.pVv.h(this.pVu.g());
        a(z ? 7 : 5, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.ss.android.socialbase.downloader.e.a aVar) {
        a(i, aVar, true);
    }

    public void h() {
        this.pVu.c(8);
        this.pVu.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a eDY = b.eDY();
        if (eDY != null) {
            eDY.a(this.pVu.g(), 8);
        }
    }

    private void a(int i, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        boolean z2;
        int[] a2;
        int q = this.pVu.q();
        if (q != -3 || i != 4) {
            j();
            if (i != 4 && com.ss.android.socialbase.downloader.b.f.e(i)) {
                this.pVu.f(false);
                if (com.ss.android.socialbase.downloader.b.f.d(i)) {
                    this.pVu.aa();
                }
            }
            if (this.pVA != null && (this.pVA instanceof y) && (a2 = ((y) this.pVA).a()) != null && a2.length > 0) {
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
                    if (this.pVz != null) {
                        this.pVz.a(this.pVu, aVar, i);
                    }
                } catch (Throwable th) {
                }
                com.ss.android.socialbase.downloader.h.a.a(this.pVA, this.pVu, aVar, i);
            }
            if (i == 6) {
                this.pVu.c(2);
            } else if (i == -6) {
                this.pVu.c(-3);
            } else {
                this.pVu.c(i);
            }
            if (q == -3 || q == -1) {
                if (this.pVu.eEX() == com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADING) {
                    this.pVu.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADED);
                }
                if (this.pVu.eEY() == com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADING) {
                    this.pVu.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADED);
                }
                if (this.pVu.eEK() == com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                    this.pVu.a(com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
                }
            }
            com.ss.android.socialbase.downloader.m.c.a(i, this.h, true, this.pVu, aVar);
            if (i != -4) {
                if (z && (((this.g != null && this.g.size() > 0) || (this.pVx != null && this.pVx.size() > 0 && this.pVu.eEN())) && this.e != null)) {
                    this.e.obtainMessage(i, this.pVu.g(), 0, aVar).sendToTarget();
                    return;
                }
                com.ss.android.socialbase.downloader.impls.a eDY = b.eDY();
                if (eDY != null) {
                    eDY.a(this.pVu.g(), i);
                }
            }
        }
    }
}
