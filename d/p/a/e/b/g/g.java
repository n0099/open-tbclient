package d.p.a.e.b.g;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.e.b.f.y;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class g {
    public static final String p = "g";

    /* renamed from: a  reason: collision with root package name */
    public final boolean f68140a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadInfo f68141b;

    /* renamed from: c  reason: collision with root package name */
    public final j f68142c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f68143d;

    /* renamed from: e  reason: collision with root package name */
    public d.p.a.e.b.n.a f68144e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<d.p.a.e.b.f.b> f68145f;

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<d.p.a.e.b.f.b> f68146g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<d.p.a.e.b.f.b> f68147h;
    public boolean i = false;
    public volatile long j = 0;
    public final AtomicLong k = new AtomicLong();
    public boolean l = false;
    public int m;
    public long n;
    public y o;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f68142c.i(g.this.f68141b.c0());
            g.this.c(1, null);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements d.p.a.e.b.f.j {
        public b() {
        }

        @Override // d.p.a.e.b.f.j
        public void a() {
            g.this.C();
        }

        @Override // d.p.a.e.b.f.j
        public void a(BaseException baseException) {
            String str = g.p;
            StringBuilder sb = new StringBuilder();
            sb.append("saveFileAsTargetName onFailed : ");
            sb.append(baseException != null ? baseException.getErrorMessage() : "");
            d.p.a.e.b.c.a.g(str, sb.toString());
            g.this.g(baseException);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements d.p.a.e.b.f.j {
        public c() {
        }

        @Override // d.p.a.e.b.f.j
        public void a() {
            g.this.C();
        }

        @Override // d.p.a.e.b.f.j
        public void a(BaseException baseException) {
            String str = g.p;
            StringBuilder sb = new StringBuilder();
            sb.append("saveFileAsTargetName onFailed : ");
            sb.append(baseException != null ? baseException.getErrorMessage() : "");
            d.p.a.e.b.c.a.g(str, sb.toString());
            g.this.g(baseException);
        }
    }

    public g(d.p.a.e.b.n.a aVar, Handler handler) {
        this.f68144e = aVar;
        A();
        this.f68143d = handler;
        this.f68142c = d.I0();
        DownloadInfo H = aVar.H();
        if (H != null) {
            this.f68140a = d.p.a.e.b.j.a.d(H.c0()).l("fix_start_with_file_exist_update_error");
        } else {
            this.f68140a = false;
        }
    }

    public final void A() {
        d.p.a.e.b.n.a aVar = this.f68144e;
        if (aVar != null) {
            this.f68141b = aVar.H();
            this.f68145f = this.f68144e.K(com.ss.android.socialbase.downloader.constants.g.MAIN);
            this.f68147h = this.f68144e.K(com.ss.android.socialbase.downloader.constants.g.NOTIFICATION);
            this.f68146g = this.f68144e.K(com.ss.android.socialbase.downloader.constants.g.SUB);
            this.f68144e.C();
            this.o = this.f68144e.O();
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
            d.p.a.e.b.c.a.g(p, "saveFileAsTargetName onSuccess");
            try {
                D();
                this.f68141b.v2(false);
                this.f68141b.c3(false);
                c(-3, null);
                this.f68142c.c(this.f68141b.c0(), this.f68141b.Q0());
                this.f68142c.d(this.f68141b.c0());
                this.f68142c.m(this.f68141b.c0());
            } catch (BaseException e2) {
                g(e2);
            }
        } catch (Throwable th) {
            g(new BaseException(1008, d.p.a.e.b.l.e.Y(th, "onCompleted")));
        }
    }

    public final void D() throws BaseException {
        List<d.p.a.e.b.f.p> F = this.f68144e.F();
        if (F.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.f68141b;
        c(11, null);
        this.f68142c.a(downloadInfo);
        for (d.p.a.e.b.f.p pVar : F) {
            try {
                if (pVar.b(downloadInfo)) {
                    pVar.a(downloadInfo);
                    this.f68142c.a(downloadInfo);
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    public void b() {
        if (this.f68141b.f()) {
            return;
        }
        this.f68141b.a3(1);
        B();
    }

    public final void c(int i, BaseException baseException) {
        d(i, baseException, true);
    }

    public final void d(int i, BaseException baseException, boolean z) {
        SparseArray<d.p.a.e.b.f.b> sparseArray;
        SparseArray<d.p.a.e.b.f.b> sparseArray2;
        int H0 = this.f68141b.H0();
        if (H0 == -3 && i == 4) {
            return;
        }
        A();
        if (i != 4 && d.p.a.e.b.d.a.e(i)) {
            this.f68141b.q3(false);
            if (d.p.a.e.b.d.a.f(i)) {
                this.f68141b.p3();
            }
        }
        d.p.a.e.b.e.a.h(this.f68144e, baseException, i);
        if (i == 6) {
            this.f68141b.a3(2);
        } else if (i == -6) {
            this.f68141b.a3(-3);
        } else {
            this.f68141b.a3(i);
        }
        if (H0 == -3 || H0 == -1) {
            if (this.f68141b.C0() == com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_DOWNLOADING) {
                this.f68141b.V2(com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_DOWNLOADED);
            }
            if (this.f68141b.u() == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADING) {
                this.f68141b.f2(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.f68141b.z() == com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.f68141b.i2(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        d.p.a.e.b.l.c.a(i, this.f68146g, true, this.f68141b, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.f68143d != null && (((sparseArray = this.f68145f) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f68147h) != null && sparseArray2.size() > 0 && (this.f68141b.e() || this.f68141b.c1())))) {
            this.f68143d.obtainMessage(i, this.f68141b.c0(), 0, baseException).sendToTarget();
            return;
        }
        d.p.a.e.b.m.a c2 = d.c();
        if (c2 != null) {
            c2.c(this.f68141b.c0(), i);
        }
    }

    public void e(long j, String str, String str2) {
        this.f68141b.g3(j);
        this.f68141b.i3(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.f68141b.q0())) {
            this.f68141b.N2(str2);
        }
        try {
            this.f68142c.a(this.f68141b.c0(), j, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c(3, null);
        this.n = this.f68141b.n0(j);
        this.m = this.f68141b.o0();
        this.i = true;
        d.p.a.e.b.m.q.d().y();
    }

    public void g(BaseException baseException) {
        this.f68141b.t2(false);
        o(baseException);
    }

    public void h(BaseException baseException, boolean z) {
        this.f68141b.t2(false);
        this.k.set(0L);
        p(baseException, z);
    }

    public void i(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, boolean z) {
        this.f68141b.t2(false);
        this.k.set(0L);
        this.f68142c.h(this.f68141b.c0());
        d(z ? 10 : 9, baseException, true);
    }

    public void j(String str) throws BaseException {
        String str2 = p;
        d.p.a.e.b.c.a.g(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.f68141b.q0());
        if (this.f68140a) {
            d.p.a.e.b.l.e.x(this.f68141b, str);
            D();
            this.f68141b.c3(true);
            c(-3, null);
            this.f68142c.a(this.f68141b);
            return;
        }
        this.f68142c.a(this.f68141b);
        d.p.a.e.b.l.e.x(this.f68141b, str);
        this.f68141b.c3(true);
        D();
        c(-3, null);
    }

    public boolean k(long j) {
        this.k.addAndGet(j);
        this.f68141b.Z0(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return l(uptimeMillis, q(uptimeMillis));
    }

    public final boolean l(long j, boolean z) {
        boolean z2 = false;
        if (this.f68141b.E() == this.f68141b.Q0()) {
            try {
                this.f68142c.a(this.f68141b.c0(), this.f68141b.E());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        if (this.i) {
            this.i = false;
            this.f68141b.a3(4);
        }
        if (this.f68141b.D1() && z) {
            z2 = true;
        }
        d(4, null, z2);
        return z;
    }

    public void n() {
        if (this.f68141b.f()) {
            this.f68141b.h();
            return;
        }
        this.f68142c.g(this.f68141b.c0());
        if (this.f68141b.s1()) {
            c(6, null);
        }
        c(2, null);
    }

    public final void o(BaseException baseException) {
        String str = p;
        Log.d(str, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.f68142c.f(this.f68141b.c0());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                try {
                    this.f68142c.b(this.f68141b.c0(), this.f68141b.E());
                } catch (SQLiteException unused) {
                    this.f68142c.f(this.f68141b.c0());
                }
            } catch (SQLiteException e3) {
                e3.printStackTrace();
            }
        }
        BaseException r = r(baseException);
        this.f68141b.q2(r);
        c(r instanceof com.ss.android.socialbase.downloader.exception.e ? -2 : -1, r);
        if (d.p.a.e.b.j.a.d(this.f68141b.c0()).b("retry_schedule", 0) > 0) {
            d.p.a.e.b.m.q.d().k(this.f68141b);
        }
    }

    public final void p(BaseException baseException, boolean z) {
        this.f68142c.h(this.f68141b.c0());
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
        if (d.p.a.e.b.j.a.d(this.f68141b.c0()).b("download_failed_check_net", 1) != 1 || !d.p.a.e.b.l.e.P0(baseException) || (l = d.l()) == null || d.p.a.e.b.l.e.p0(l)) {
            return baseException;
        }
        return new BaseException(this.f68141b.K1() ? 1013 : SDKLogTypeConstants.TYPE_LP_LOAD_URL, baseException.getErrorMessage());
    }

    public void s() {
        c(-4, null);
    }

    public void u() {
        this.f68141b.a3(-2);
        try {
            this.f68142c.d(this.f68141b.c0(), this.f68141b.E());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        c(-2, null);
    }

    public void v() {
        this.f68141b.a3(-7);
        try {
            this.f68142c.j(this.f68141b.c0());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        c(-7, null);
    }

    public void w() {
        this.f68141b.t2(false);
        if (!this.f68141b.y1() && this.f68141b.E() != this.f68141b.Q0()) {
            d.p.a.e.b.c.a.g(p, this.f68141b.O());
            g(new com.ss.android.socialbase.downloader.exception.f(SDKLogTypeConstants.EXPTYPE_LITEINC_SHOW, "current bytes is not equals to total bytes, bytes changed with process : " + this.f68141b.z()));
        } else if (this.f68141b.E() <= 0) {
            d.p.a.e.b.c.a.g(p, this.f68141b.O());
            g(new com.ss.android.socialbase.downloader.exception.f(SDKLogTypeConstants.EXPTYPE_LITEINC_CP, "curBytes is 0, bytes changed with process : " + this.f68141b.z()));
        } else if (!this.f68141b.y1() && this.f68141b.Q0() <= 0) {
            d.p.a.e.b.c.a.g(p, this.f68141b.O());
            g(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes changed with process : " + this.f68141b.z()));
        } else {
            String str = p;
            d.p.a.e.b.c.a.g(str, "" + this.f68141b.q0() + " onCompleted start save file as target name");
            y yVar = this.o;
            d.p.a.e.b.n.a aVar = this.f68144e;
            if (aVar != null) {
                yVar = aVar.O();
            }
            if (this.f68141b.I1()) {
                d.p.a.e.b.l.e.w(this.f68141b, yVar, new b());
            } else {
                d.p.a.e.b.l.e.v(this.f68141b, new c());
            }
        }
    }

    public void x() throws BaseException {
        if (this.f68140a) {
            D();
            d.p.a.e.b.c.a.g(p, "onCompleteForFileExist");
            this.f68141b.c3(true);
            c(-3, null);
            this.f68142c.c(this.f68141b.c0(), this.f68141b.Q0());
            this.f68142c.d(this.f68141b.c0());
            this.f68142c.a(this.f68141b);
            this.f68142c.m(this.f68141b.c0());
            return;
        }
        D();
        d.p.a.e.b.c.a.g(p, "onCompleteForFileExist");
        this.f68141b.c3(true);
        c(-3, null);
        this.f68142c.c(this.f68141b.c0(), this.f68141b.Q0());
        this.f68142c.d(this.f68141b.c0());
        this.f68142c.m(this.f68141b.c0());
    }

    public void y() {
        this.f68141b.a3(8);
        this.f68141b.f2(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING);
        d.p.a.e.b.m.a c2 = d.c();
        if (c2 != null) {
            c2.c(this.f68141b.c0(), 8);
        }
    }
}
