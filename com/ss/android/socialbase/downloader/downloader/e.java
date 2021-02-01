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
    private com.ss.android.socialbase.downloader.g.d qfA;
    private SparseArray<com.ss.android.socialbase.downloader.d.b> qfB;
    private ad qfD;
    private com.ss.android.socialbase.downloader.d.c qfE;
    private com.ss.android.socialbase.downloader.g.c qfy;
    private final k qfz;
    private boolean j = false;
    private volatile long k = 0;
    private final AtomicLong qfC = new AtomicLong();
    private boolean m = false;

    public e(com.ss.android.socialbase.downloader.g.d dVar, Handler handler) {
        this.qfA = dVar;
        j();
        this.e = handler;
        this.qfz = b.eGk();
        com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
        if (a2 != null) {
            this.f13138b = com.ss.android.socialbase.downloader.k.a.RV(a2.g()).a("fix_start_with_file_exist_update_error");
        } else {
            this.f13138b = false;
        }
    }

    private void j() {
        if (this.qfA != null) {
            this.qfy = this.qfA.a();
            this.g = this.qfA.b(com.ss.android.socialbase.downloader.b.h.MAIN);
            this.qfB = this.qfA.b(com.ss.android.socialbase.downloader.b.h.NOTIFICATION);
            this.h = this.qfA.b(com.ss.android.socialbase.downloader.b.h.SUB);
            this.qfD = this.qfA.eIb();
            this.qfE = this.qfA.eIc();
        }
    }

    public void a() {
        if (!this.qfy.eHq()) {
            this.qfy.c(1);
            k();
        }
    }

    private void k() {
        ExecutorService eGc = b.eGc();
        if (eGc != null) {
            eGc.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.qfz.i(e.this.qfy.g());
                    e.this.a(1, (com.ss.android.socialbase.downloader.e.a) null);
                }
            });
        }
    }

    public void b() {
        if (this.qfy.eHq()) {
            this.qfy.aH();
            return;
        }
        this.qfz.g(this.qfy.g());
        if (this.qfy.eHJ()) {
            a(6, (com.ss.android.socialbase.downloader.e.a) null);
        }
        a(2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(long j, String str, String str2) {
        this.qfy.f(j);
        this.qfy.c(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.qfy.h())) {
            this.qfy.d(str2);
        }
        try {
            this.qfz.a(this.qfy.g(), j, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(3, (com.ss.android.socialbase.downloader.e.a) null);
        this.o = this.qfy.jn(j);
        this.n = this.qfy.eHD();
        this.j = true;
        com.ss.android.socialbase.downloader.impls.r.eIt().e();
    }

    public boolean a(long j) {
        this.qfC.addAndGet(j);
        this.qfy.e(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    public void c() {
        a(-4, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void d() {
        this.qfy.c(-2);
        try {
            this.qfz.d(this.qfy.g(), this.qfy.eHa());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-2, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void e() {
        this.qfy.c(-7);
        try {
            this.qfz.j(this.qfy.g());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(-7, (com.ss.android.socialbase.downloader.e.a) null);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.qfy.g(false);
        this.qfC.set(0L);
        c(aVar, z);
    }

    public void a(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.qfy.g(false);
        this.qfC.set(0L);
        this.qfz.h(this.qfy.g());
        a(z ? 10 : 9, aVar, true);
    }

    public void a(com.ss.android.socialbase.downloader.e.a aVar) {
        this.qfy.g(false);
        b(aVar);
    }

    private void b(com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar != null && aVar.getCause() != null && (aVar.getCause() instanceof SQLiteFullException)) {
            try {
                this.qfz.f(this.qfy.g());
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.qfz.b(this.qfy.g(), this.qfy.eHa());
            } catch (SQLiteException e2) {
                try {
                    this.qfz.f(this.qfy.g());
                } catch (SQLiteException e3) {
                    e3.printStackTrace();
                }
            }
        }
        com.ss.android.socialbase.downloader.e.a c = c(aVar);
        this.qfy.a(c);
        a(c instanceof com.ss.android.socialbase.downloader.e.f ? -2 : -1, c);
        if (com.ss.android.socialbase.downloader.k.a.RV(this.qfy.g()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.eIt().a(this.qfy);
        }
    }

    private com.ss.android.socialbase.downloader.e.a c(com.ss.android.socialbase.downloader.e.a aVar) {
        Context eGu;
        if (com.ss.android.socialbase.downloader.k.a.RV(this.qfy.g()).a("download_failed_check_net", 0) == 1 && com.ss.android.socialbase.downloader.m.d.J(aVar) && (eGu = b.eGu()) != null && !com.ss.android.socialbase.downloader.m.d.b(eGu)) {
            return new com.ss.android.socialbase.downloader.e.a(this.qfy.x() ? 1013 : 1049, aVar.b());
        }
        return aVar;
    }

    public void f() {
        this.qfy.g(false);
        if (!this.qfy.ag() && this.qfy.eHa() != this.qfy.eij()) {
            com.ss.android.socialbase.downloader.f.a.b(f13137a, this.qfy.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_STOP, "current bytes is not equals to total bytes, bytes changed with process : " + this.qfy.eHb()));
        } else if (this.qfy.eHa() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f13137a, this.qfy.d());
            a(new com.ss.android.socialbase.downloader.e.g(ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, "curBytes is 0, bytes changed with process : " + this.qfy.eHb()));
        } else if (!this.qfy.ag() && this.qfy.eij() <= 0) {
            com.ss.android.socialbase.downloader.f.a.b(f13137a, this.qfy.d());
            a(new com.ss.android.socialbase.downloader.e.g(1044, "TotalBytes is 0, bytes changed with process : " + this.qfy.eHb()));
        } else {
            com.ss.android.socialbase.downloader.f.a.b(f13137a, "" + this.qfy.h() + " onCompleted start save file as target name");
            com.ss.android.socialbase.downloader.d.c cVar = this.qfE;
            if (this.qfA != null) {
                cVar = this.qfA.eIc();
            }
            if (this.qfy.ah()) {
                com.ss.android.socialbase.downloader.m.d.a(this.qfy, cVar, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.2
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
                com.ss.android.socialbase.downloader.m.d.a(this.qfy, new com.ss.android.socialbase.downloader.d.s() { // from class: com.ss.android.socialbase.downloader.downloader.e.3
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
                this.qfy.h(false);
                a(-3, (com.ss.android.socialbase.downloader.e.a) null);
                this.qfz.c(this.qfy.g(), this.qfy.eij());
                this.qfz.d(this.qfy.g());
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
            this.qfz.c(this.qfy.g(), this.qfy.eij());
            this.qfz.d(this.qfy.g());
            this.qfz.a(this.qfy);
            return;
        }
        m();
        com.ss.android.socialbase.downloader.f.a.b(f13137a, "onCompleteForFileExist");
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
        this.qfz.c(this.qfy.g(), this.qfy.eij());
        this.qfz.d(this.qfy.g());
    }

    public void a(String str) throws com.ss.android.socialbase.downloader.e.a {
        com.ss.android.socialbase.downloader.f.a.b(f13137a, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.qfy.h());
        if (this.f13138b) {
            com.ss.android.socialbase.downloader.m.d.a(this.qfy, str);
            m();
            a(-3, (com.ss.android.socialbase.downloader.e.a) null);
            this.qfz.a(this.qfy);
            return;
        }
        this.qfz.a(this.qfy);
        com.ss.android.socialbase.downloader.m.d.a(this.qfy, str);
        m();
        a(-3, (com.ss.android.socialbase.downloader.e.a) null);
    }

    private void m() throws com.ss.android.socialbase.downloader.e.a {
        ab eIl = this.qfA.eIl();
        if (eIl != null) {
            try {
                com.ss.android.socialbase.downloader.g.c cVar = this.qfy;
                if (eIl.b(cVar)) {
                    a(11, (com.ss.android.socialbase.downloader.e.a) null);
                    this.qfz.a(cVar);
                    eIl.a(cVar);
                    this.qfz.a(cVar);
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
        if (this.qfy.eHa() == this.qfy.eij()) {
            try {
                this.qfz.a(this.qfy.g(), this.qfy.eHa());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (this.j) {
            this.j = false;
            this.qfy.c(4);
        }
        if (this.qfy.eHB() && z) {
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
            if (this.qfC.get() < this.o && j2 < this.n) {
                z = false;
            }
            if (z) {
                this.k = j;
                this.qfC.set(0L);
            }
        }
        return z;
    }

    private void c(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        this.qfz.h(this.qfy.g());
        a(z ? 7 : 5, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.ss.android.socialbase.downloader.e.a aVar) {
        a(i, aVar, true);
    }

    public void h() {
        this.qfy.c(8);
        this.qfy.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a eGp = b.eGp();
        if (eGp != null) {
            eGp.a(this.qfy.g(), 8);
        }
    }

    private void a(int i, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        boolean z2;
        int[] a2;
        int q = this.qfy.q();
        if (q != -3 || i != 4) {
            j();
            if (i != 4 && com.ss.android.socialbase.downloader.b.f.e(i)) {
                this.qfy.f(false);
                if (com.ss.android.socialbase.downloader.b.f.d(i)) {
                    this.qfy.aa();
                }
            }
            if (this.qfE != null && (this.qfE instanceof y) && (a2 = ((y) this.qfE).a()) != null && a2.length > 0) {
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
                    if (this.qfD != null) {
                        this.qfD.a(this.qfy, aVar, i);
                    }
                } catch (Throwable th) {
                }
                com.ss.android.socialbase.downloader.h.a.a(this.qfE, this.qfy, aVar, i);
            }
            if (i == 6) {
                this.qfy.c(2);
            } else if (i == -6) {
                this.qfy.c(-3);
            } else {
                this.qfy.c(i);
            }
            if (q == -3 || q == -1) {
                if (this.qfy.eHo() == com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADING) {
                    this.qfy.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_DOWNLOADED);
                }
                if (this.qfy.eHp() == com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADING) {
                    this.qfy.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_DOWNLOADED);
                }
                if (this.qfy.eHb() == com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                    this.qfy.a(com.ss.android.socialbase.downloader.b.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
                }
            }
            com.ss.android.socialbase.downloader.m.c.a(i, this.h, true, this.qfy, aVar);
            if (i != -4) {
                if (z && (((this.g != null && this.g.size() > 0) || (this.qfB != null && this.qfB.size() > 0 && this.qfy.eHe())) && this.e != null)) {
                    this.e.obtainMessage(i, this.qfy.g(), 0, aVar).sendToTarget();
                    return;
                }
                com.ss.android.socialbase.downloader.impls.a eGp = b.eGp();
                if (eGp != null) {
                    eGp.a(this.qfy.g(), i);
                }
            }
        }
    }
}
