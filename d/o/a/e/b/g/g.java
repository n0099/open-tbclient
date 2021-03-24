package d.o.a.e.b.g;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.y;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class g {
    public static final String p = "g";

    /* renamed from: a  reason: collision with root package name */
    public final boolean f66995a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadInfo f66996b;

    /* renamed from: c  reason: collision with root package name */
    public final j f66997c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f66998d;

    /* renamed from: e  reason: collision with root package name */
    public d.o.a.e.b.n.a f66999e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<d.o.a.e.b.f.b> f67000f;

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<d.o.a.e.b.f.b> f67001g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<d.o.a.e.b.f.b> f67002h;
    public boolean i = false;
    public volatile long j = 0;
    public final AtomicLong k = new AtomicLong();
    public boolean l = false;
    public int m;
    public long n;
    public y o;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f66997c.i(g.this.f66996b.c0());
            g.this.c(1, null);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.o.a.e.b.f.j {
        public b() {
        }

        @Override // d.o.a.e.b.f.j
        public void a() {
            g.this.C();
        }

        @Override // d.o.a.e.b.f.j
        public void a(BaseException baseException) {
            String str = g.p;
            StringBuilder sb = new StringBuilder();
            sb.append("saveFileAsTargetName onFailed : ");
            sb.append(baseException != null ? baseException.getErrorMessage() : "");
            d.o.a.e.b.c.a.g(str, sb.toString());
            g.this.g(baseException);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.o.a.e.b.f.j {
        public c() {
        }

        @Override // d.o.a.e.b.f.j
        public void a() {
            g.this.C();
        }

        @Override // d.o.a.e.b.f.j
        public void a(BaseException baseException) {
            String str = g.p;
            StringBuilder sb = new StringBuilder();
            sb.append("saveFileAsTargetName onFailed : ");
            sb.append(baseException != null ? baseException.getErrorMessage() : "");
            d.o.a.e.b.c.a.g(str, sb.toString());
            g.this.g(baseException);
        }
    }

    public g(d.o.a.e.b.n.a aVar, Handler handler) {
        this.f66999e = aVar;
        A();
        this.f66998d = handler;
        this.f66997c = d.I0();
        DownloadInfo H = aVar.H();
        if (H != null) {
            this.f66995a = d.o.a.e.b.j.a.d(H.c0()).l("fix_start_with_file_exist_update_error");
        } else {
            this.f66995a = false;
        }
    }

    public final void A() {
        d.o.a.e.b.n.a aVar = this.f66999e;
        if (aVar != null) {
            this.f66996b = aVar.H();
            this.f67000f = this.f66999e.K(com.ss.android.socialbase.downloader.constants.g.MAIN);
            this.f67002h = this.f66999e.K(com.ss.android.socialbase.downloader.constants.g.NOTIFICATION);
            this.f67001g = this.f66999e.K(com.ss.android.socialbase.downloader.constants.g.SUB);
            this.f66999e.C();
            this.o = this.f66999e.O();
        }
    }

    public final void B() {
        ExecutorService w0 = d.w0();
        if (w0 != null) {
            w0.execute(new a());
        }
    }

    public final void C() {
        try {
            d.o.a.e.b.c.a.g(p, "saveFileAsTargetName onSuccess");
            try {
                D();
                this.f66996b.v2(false);
                this.f66996b.c3(false);
                c(-3, null);
                this.f66997c.c(this.f66996b.c0(), this.f66996b.Q0());
                this.f66997c.d(this.f66996b.c0());
                this.f66997c.m(this.f66996b.c0());
            } catch (BaseException e2) {
                g(e2);
            }
        } catch (Throwable th) {
            g(new BaseException(1008, d.o.a.e.b.l.e.Y(th, "onCompleted")));
        }
    }

    public final void D() throws BaseException {
        List<d.o.a.e.b.f.p> F = this.f66999e.F();
        if (F.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.f66996b;
        c(11, null);
        this.f66997c.a(downloadInfo);
        for (d.o.a.e.b.f.p pVar : F) {
            try {
                if (pVar.b(downloadInfo)) {
                    pVar.a(downloadInfo);
                    this.f66997c.a(downloadInfo);
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    public void b() {
        if (this.f66996b.f()) {
            return;
        }
        this.f66996b.a3(1);
        B();
    }

    public final void c(int i, BaseException baseException) {
        d(i, baseException, true);
    }

    public final void d(int i, BaseException baseException, boolean z) {
        SparseArray<d.o.a.e.b.f.b> sparseArray;
        SparseArray<d.o.a.e.b.f.b> sparseArray2;
        int H0 = this.f66996b.H0();
        if (H0 == -3 && i == 4) {
            return;
        }
        A();
        if (i != 4 && d.o.a.e.b.d.a.e(i)) {
            this.f66996b.q3(false);
            if (d.o.a.e.b.d.a.f(i)) {
                this.f66996b.p3();
            }
        }
        d.o.a.e.b.e.a.h(this.f66999e, baseException, i);
        if (i == 6) {
            this.f66996b.a3(2);
        } else if (i == -6) {
            this.f66996b.a3(-3);
        } else {
            this.f66996b.a3(i);
        }
        if (H0 == -3 || H0 == -1) {
            if (this.f66996b.C0() == com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_DOWNLOADING) {
                this.f66996b.V2(com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_DOWNLOADED);
            }
            if (this.f66996b.u() == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADING) {
                this.f66996b.f2(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.f66996b.z() == com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.f66996b.i2(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        d.o.a.e.b.l.c.a(i, this.f67001g, true, this.f66996b, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.f66998d != null && (((sparseArray = this.f67000f) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f67002h) != null && sparseArray2.size() > 0 && (this.f66996b.e() || this.f66996b.c1())))) {
            this.f66998d.obtainMessage(i, this.f66996b.c0(), 0, baseException).sendToTarget();
            return;
        }
        d.o.a.e.b.m.a c2 = d.c();
        if (c2 != null) {
            c2.c(this.f66996b.c0(), i);
        }
    }

    public void e(long j, String str, String str2) {
        this.f66996b.g3(j);
        this.f66996b.i3(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.f66996b.q0())) {
            this.f66996b.N2(str2);
        }
        try {
            this.f66997c.a(this.f66996b.c0(), j, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c(3, null);
        this.n = this.f66996b.n0(j);
        this.m = this.f66996b.o0();
        this.i = true;
        d.o.a.e.b.m.q.d().y();
    }

    public void g(BaseException baseException) {
        this.f66996b.t2(false);
        o(baseException);
    }

    public void h(BaseException baseException, boolean z) {
        this.f66996b.t2(false);
        this.k.set(0L);
        p(baseException, z);
    }

    public void i(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, boolean z) {
        this.f66996b.t2(false);
        this.k.set(0L);
        this.f66997c.h(this.f66996b.c0());
        d(z ? 10 : 9, baseException, true);
    }

    public void j(String str) throws BaseException {
        String str2 = p;
        d.o.a.e.b.c.a.g(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.f66996b.q0());
        if (this.f66995a) {
            d.o.a.e.b.l.e.x(this.f66996b, str);
            D();
            this.f66996b.c3(true);
            c(-3, null);
            this.f66997c.a(this.f66996b);
            return;
        }
        this.f66997c.a(this.f66996b);
        d.o.a.e.b.l.e.x(this.f66996b, str);
        this.f66996b.c3(true);
        D();
        c(-3, null);
    }

    public boolean k(long j) {
        this.k.addAndGet(j);
        this.f66996b.Z0(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return l(uptimeMillis, q(uptimeMillis));
    }

    public final boolean l(long j, boolean z) {
        boolean z2 = false;
        if (this.f66996b.E() == this.f66996b.Q0()) {
            try {
                this.f66997c.a(this.f66996b.c0(), this.f66996b.E());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        if (this.i) {
            this.i = false;
            this.f66996b.a3(4);
        }
        if (this.f66996b.D1() && z) {
            z2 = true;
        }
        d(4, null, z2);
        return z;
    }

    public void n() {
        if (this.f66996b.f()) {
            this.f66996b.h();
            return;
        }
        this.f66997c.g(this.f66996b.c0());
        if (this.f66996b.s1()) {
            c(6, null);
        }
        c(2, null);
    }

    public final void o(BaseException baseException) {
        String str = p;
        Log.d(str, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.f66997c.f(this.f66996b.c0());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                try {
                    this.f66997c.b(this.f66996b.c0(), this.f66996b.E());
                } catch (SQLiteException unused) {
                    this.f66997c.f(this.f66996b.c0());
                }
            } catch (SQLiteException e3) {
                e3.printStackTrace();
            }
        }
        BaseException r = r(baseException);
        this.f66996b.q2(r);
        c(r instanceof com.ss.android.socialbase.downloader.exception.e ? -2 : -1, r);
        if (d.o.a.e.b.j.a.d(this.f66996b.c0()).b("retry_schedule", 0) > 0) {
            d.o.a.e.b.m.q.d().k(this.f66996b);
        }
    }

    public final void p(BaseException baseException, boolean z) {
        this.f66997c.h(this.f66996b.c0());
        c(z ? 7 : 5, baseException);
    }

    public final boolean q(long j) {
        boolean z = true;
        if (!this.l) {
            this.l = true;
            return true;
        }
        long j2 = j - this.j;
        if (this.k.get() < this.n && j2 < this.m) {
            z = false;
        }
        if (z) {
            this.j = j;
            this.k.set(0L);
        }
        return z;
    }

    public final BaseException r(BaseException baseException) {
        Context l;
        if (d.o.a.e.b.j.a.d(this.f66996b.c0()).b("download_failed_check_net", 1) != 1 || !d.o.a.e.b.l.e.P0(baseException) || (l = d.l()) == null || d.o.a.e.b.l.e.p0(l)) {
            return baseException;
        }
        return new BaseException(this.f66996b.K1() ? 1013 : 1049, baseException.getErrorMessage());
    }

    public void s() {
        c(-4, null);
    }

    public void u() {
        this.f66996b.a3(-2);
        try {
            this.f66997c.d(this.f66996b.c0(), this.f66996b.E());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        c(-2, null);
    }

    public void v() {
        this.f66996b.a3(-7);
        try {
            this.f66997c.j(this.f66996b.c0());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        c(-7, null);
    }

    public void w() {
        this.f66996b.t2(false);
        if (!this.f66996b.y1() && this.f66996b.E() != this.f66996b.Q0()) {
            d.o.a.e.b.c.a.g(p, this.f66996b.O());
            g(new com.ss.android.socialbase.downloader.exception.f(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.f66996b.z()));
        } else if (this.f66996b.E() <= 0) {
            d.o.a.e.b.c.a.g(p, this.f66996b.O());
            g(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes changed with process : " + this.f66996b.z()));
        } else if (!this.f66996b.y1() && this.f66996b.Q0() <= 0) {
            d.o.a.e.b.c.a.g(p, this.f66996b.O());
            g(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes changed with process : " + this.f66996b.z()));
        } else {
            String str = p;
            d.o.a.e.b.c.a.g(str, "" + this.f66996b.q0() + " onCompleted start save file as target name");
            y yVar = this.o;
            d.o.a.e.b.n.a aVar = this.f66999e;
            if (aVar != null) {
                yVar = aVar.O();
            }
            if (this.f66996b.I1()) {
                d.o.a.e.b.l.e.w(this.f66996b, yVar, new b());
            } else {
                d.o.a.e.b.l.e.v(this.f66996b, new c());
            }
        }
    }

    public void x() throws BaseException {
        if (this.f66995a) {
            D();
            d.o.a.e.b.c.a.g(p, "onCompleteForFileExist");
            this.f66996b.c3(true);
            c(-3, null);
            this.f66997c.c(this.f66996b.c0(), this.f66996b.Q0());
            this.f66997c.d(this.f66996b.c0());
            this.f66997c.a(this.f66996b);
            this.f66997c.m(this.f66996b.c0());
            return;
        }
        D();
        d.o.a.e.b.c.a.g(p, "onCompleteForFileExist");
        this.f66996b.c3(true);
        c(-3, null);
        this.f66997c.c(this.f66996b.c0(), this.f66996b.Q0());
        this.f66997c.d(this.f66996b.c0());
        this.f66997c.m(this.f66996b.c0());
    }

    public void y() {
        this.f66996b.a3(8);
        this.f66996b.f2(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING);
        d.o.a.e.b.m.a c2 = d.c();
        if (c2 != null) {
            c2.c(this.f66996b.c0(), 8);
        }
    }
}
