package d.o.a.e.b.k;

import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.b;
import com.vivo.push.PushInnerClientConstants;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import d.o.a.e.b.f.l;
import d.o.a.e.b.f.s;
import d.o.a.e.b.f.w;
import d.o.a.e.b.f.x;
import d.o.a.e.b.f.y;
import d.o.a.e.b.g.h;
import d.o.a.e.b.g.j;
import d.o.a.e.b.g.r;
import d.o.a.e.b.i.m;
import d.o.a.e.b.m.p;
import d.o.a.e.b.m.q;
import d.o.a.e.b.o.i;
import d.o.a.e.b.o.k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements f, Runnable {
    public static final String O = c.class.getSimpleName();
    public k A;
    public i B;
    public w C;
    public s D;
    public String H;
    public long J;
    public long K;
    public final d.o.a.e.b.j.a L;

    /* renamed from: e  reason: collision with root package name */
    public Future f71118e;

    /* renamed from: f  reason: collision with root package name */
    public final d.o.a.e.b.n.a f71119f;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f71121h;
    public volatile d.o.a.e.b.g.f j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final AtomicBoolean p;
    public final j r;
    public DownloadInfo s;
    public d.o.a.e.b.g.i t;
    public final d.o.a.e.b.g.i u;
    public h v;
    public final h w;
    public r x;
    public final d.o.a.e.b.g.g y;
    public volatile BaseException z;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f71120g = false;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<d.o.a.e.b.k.b> f71122i = new ArrayList<>();
    public volatile com.ss.android.socialbase.downloader.constants.i q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_NONE;
    public volatile int E = 5;
    public boolean F = false;
    public boolean G = false;
    public boolean I = false;
    public int M = 0;
    public volatile d.o.a.e.b.i.j N = null;

    /* loaded from: classes7.dex */
    public class a extends l {
        public a() {
        }

        @Override // d.o.a.e.b.f.l, d.o.a.e.b.f.v
        public void a(List<String> list) {
            super.a(list);
            c.this.I(list);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.o.a.e.b.f.r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f71124a;

        public b(AtomicBoolean atomicBoolean) {
            this.f71124a = atomicBoolean;
        }

        @Override // d.o.a.e.b.f.r
        public void a() {
            synchronized (c.this) {
                this.f71124a.set(true);
                c.this.s();
            }
        }
    }

    public c(d.o.a.e.b.n.a aVar, Handler handler) {
        this.f71119f = aVar;
        if (aVar != null) {
            this.s = aVar.H();
            this.t = aVar.B();
            this.v = aVar.A();
            this.C = aVar.M();
            this.D = aVar.D();
            this.x = v(aVar);
            this.L = d.o.a.e.b.j.a.d(this.s.c0());
        } else {
            this.L = d.o.a.e.b.j.a.r();
        }
        V();
        this.r = d.o.a.e.b.g.d.I0();
        this.u = d.o.a.e.b.g.d.h();
        this.w = d.o.a.e.b.g.d.j();
        this.y = new d.o.a.e.b.g.g(aVar, handler);
        this.p = new AtomicBoolean(true);
    }

    public static com.ss.android.socialbase.downloader.model.b w(DownloadInfo downloadInfo, long j) {
        b.C0503b c0503b = new b.C0503b(downloadInfo.c0());
        c0503b.b(-1);
        c0503b.c(0L);
        c0503b.m(j);
        c0503b.g(j);
        c0503b.i(0L);
        c0503b.k(downloadInfo.Q0() - j);
        return c0503b.e();
    }

    public final void A(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws BaseException {
        if (list.size() == i2) {
            J(list, this.s.Q0());
            return;
        }
        throw new BaseException(1033, new IllegalArgumentException());
    }

    public final void B(long j, int i2) throws BaseException {
        long j2 = j / i2;
        int c0 = this.s.c0();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        long j3 = 0;
        while (i3 < i2) {
            long j4 = i3 == i2 + (-1) ? 0L : (j3 + j2) - 1;
            b.C0503b c0503b = new b.C0503b(c0);
            c0503b.b(i3);
            c0503b.c(j3);
            c0503b.m(j3);
            c0503b.g(j3);
            c0503b.i(j4);
            com.ss.android.socialbase.downloader.model.b e2 = c0503b.e();
            arrayList.add(e2);
            this.r.a(e2);
            j3 += j2;
            i3++;
        }
        this.s.l2(i2);
        this.r.a(c0, i2);
        J(arrayList, j);
    }

    public final void E(com.ss.android.socialbase.downloader.model.b bVar, String str, k kVar) throws BaseException {
        bVar.d(this.s.Q0() - bVar.A());
        this.s.l2(1);
        this.r.a(this.s.c0(), 1);
        this.j = new d.o.a.e.b.g.f(this.s, str, kVar, bVar, this);
        h0();
    }

    public final void F(String str, String str2) throws com.ss.android.socialbase.downloader.exception.h {
        this.r.d(this.s.c0());
        this.r.m(this.s.c0());
        d.o.a.e.b.l.e.u(this.s);
        this.l = false;
        this.s.a2(str);
        this.r.a(this.s);
        throw new com.ss.android.socialbase.downloader.exception.h(str2);
    }

    public final void G(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws BaseException, com.ss.android.socialbase.downloader.exception.h {
        if (this.A != null) {
            return;
        }
        d.o.a.e.b.o.b.d f2 = this.s.B() == 1 ? d.o.a.e.b.o.b.a.a().f(str, list) : null;
        if (f2 != null) {
            e(this.A);
            this.s.U2(2);
            this.A = f2;
        } else {
            try {
                try {
                    k w = d.o.a.e.b.g.d.w(this.s.A1(), this.s.j0(), str, null, list, this.L.m("net_lib_strategy"), this.L.b("monitor_download_connect", 0) > 0, this.s);
                    this.A = w;
                    e(w);
                } catch (BaseException e2) {
                    throw e2;
                }
            }
        }
        if (this.A == null) {
            throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
        }
    }

    public final void H(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.h {
        N(str, list, j);
        i iVar = this.B;
        if (iVar != null) {
            try {
                d(str, iVar, j);
            } catch (Throwable unused) {
                this.G = true;
            }
        }
        if (this.B == null || this.G) {
            G(str, list);
            d(str, this.A, j);
        }
    }

    public final void I(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.s.w2(list, this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_WAITING_ASYNC_HANDLER);
        d.o.a.e.b.m.a c2 = d.o.a.e.b.g.d.c();
        if (c2 != null) {
            c2.N(this.s.c0());
        }
    }

    public final void J(List<com.ss.android.socialbase.downloader.model.b> list, long j) throws BaseException {
        long C;
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                if (bVar.C() == 0) {
                    C = j - bVar.A();
                } else {
                    C = (bVar.C() - bVar.A()) + 1;
                }
                if (C > 0) {
                    bVar.d(C);
                    if (this.s.G1() && this.A != null && (!this.s.w1() || this.G)) {
                        if (bVar.F() == 0) {
                            this.f71122i.add(new d.o.a.e.b.k.b(bVar, this.f71119f, this.A, this));
                        } else if (bVar.F() > 0) {
                            this.f71122i.add(new d.o.a.e.b.k.b(bVar, this.f71119f, this));
                        }
                    } else {
                        this.f71122i.add(new d.o.a.e.b.k.b(bVar, this.f71119f, this));
                    }
                }
            }
        }
        if (d.o.a.e.b.l.a.a(64)) {
            ArrayList arrayList = new ArrayList(this.f71122i.size());
            Iterator<d.o.a.e.b.k.b> it = this.f71122i.iterator();
            while (it.hasNext()) {
                d.o.a.e.b.k.b next = it.next();
                if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_CANCELED) {
                    next.e();
                } else if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_PAUSE) {
                    next.a();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> T = d.o.a.e.b.m.e.T(arrayList);
                for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = d.o.a.e.b.m.e.U(T)) {
                    if (j0()) {
                        return;
                    }
                    runnable.run();
                }
                if (T == null || T.isEmpty()) {
                    return;
                }
                for (Future future : T) {
                    if (future != null && !future.isDone()) {
                        try {
                            future.get();
                        } catch (Throwable unused) {
                        }
                    }
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.f71122i.size());
        Iterator<d.o.a.e.b.k.b> it2 = this.f71122i.iterator();
        while (it2.hasNext()) {
            d.o.a.e.b.k.b next2 = it2.next();
            if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_CANCELED) {
                next2.e();
            } else if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_PAUSE) {
                next2.a();
            } else {
                arrayList2.add(Executors.callable(next2));
            }
        }
        if (j0()) {
            return;
        }
        try {
            d.o.a.e.b.m.e.S(arrayList2);
        } catch (InterruptedException e2) {
            throw new BaseException(1020, e2);
        }
    }

    public void K(Future future) {
        this.f71118e = future;
    }

    public final boolean L(int i2, String str, String str2) {
        if (i2 == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.n || this.m)) {
            return (i2 == 201 || i2 == 416) && this.s.E() > 0;
        }
        return true;
    }

    public void M() {
        this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_CANCELED;
        if (this.N != null) {
            this.N.r();
        }
        if (this.j != null) {
            this.j.j();
        }
        if (this.N == null && this.j == null) {
            g0();
            this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_CANCELED;
            d0();
        }
        r();
    }

    public final void N(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.h {
        d.o.a.e.b.o.b.c b2;
        boolean z = true;
        if (this.s.B() == 1 && (b2 = d.o.a.e.b.o.b.a.a().b(str, list)) != null) {
            this.B = b2;
            this.s.U2(1);
        }
        if (this.B == null && !this.G && this.s.w1()) {
            try {
                int m = this.L.m("net_lib_strategy");
                if (this.L.b("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.B = d.o.a.e.b.g.d.u(str, list, m, z, this.s);
            } catch (Throwable th) {
                this.s.z2(d.o.a.e.b.l.e.R0(th));
            }
        }
    }

    public d.o.a.e.b.n.a O() {
        return this.f71119f;
    }

    public void P(long j) {
        k kVar = this.A;
        if (kVar != null && (kVar instanceof d.o.a.e.b.o.c)) {
            try {
                ((d.o.a.e.b.o.c) kVar).a(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean Q() {
        return this.p.get();
    }

    public final boolean R(BaseException baseException) {
        AtomicInteger atomicInteger = this.f71121h;
        boolean z = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                if (this.s.n3()) {
                    this.f71121h.set(this.s.v());
                    this.s.o3(this.f71121h.get());
                } else if (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.s.d())) {
                    this.f71121h.set(this.s.B0());
                    this.s.o3(this.f71121h.get());
                    this.s.C2(true);
                } else {
                    g(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.f71121h), String.valueOf(this.s.B0()), baseException.getErrorMessage())));
                    return true;
                }
                z = false;
            }
            if (this.q != com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_RETRY_DELAY && z) {
                this.s.o3(this.f71121h.decrementAndGet());
            }
            return false;
        }
        g(new BaseException((int) SDKLogTypeConstants.TYPE_NATIVE_CPU_CLICK, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
        return true;
    }

    public int S() {
        DownloadInfo downloadInfo = this.s;
        if (downloadInfo != null) {
            return downloadInfo.c0();
        }
        return 0;
    }

    public void T() {
        this.K = System.currentTimeMillis();
        this.y.b();
    }

    public Future U() {
        return this.f71118e;
    }

    public final void V() {
        DownloadInfo downloadInfo = this.s;
        if (downloadInfo == null) {
            return;
        }
        int B0 = downloadInfo.B0() - this.s.F();
        if (B0 < 0) {
            B0 = 0;
        }
        AtomicInteger atomicInteger = this.f71121h;
        if (atomicInteger == null) {
            this.f71121h = new AtomicInteger(B0);
        } else {
            atomicInteger.set(B0);
        }
    }

    public final boolean W() {
        int H0 = this.s.H0();
        if (H0 == 1 || this.s.f()) {
            return true;
        }
        if (H0 == -2 || H0 == -4) {
            return false;
        }
        g(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + H0));
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x00f5, code lost:
        if (r9.L.l("fix_file_exist_update_download_info") != false) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab A[Catch: all -> 0x00ea, TryCatch #7 {all -> 0x00ea, blocks: (B:56:0x00a7, B:58:0x00ab, B:60:0x00af, B:73:0x00e9), top: B:86:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X() throws com.ss.android.socialbase.downloader.exception.a {
        Throwable th;
        com.ss.android.socialbase.downloader.exception.a e2;
        boolean z = false;
        boolean z2 = true;
        try {
            try {
                try {
                    int c0 = this.s.c0();
                    if (this.r != null) {
                        if (d.o.a.e.b.l.a.a(2048)) {
                            this.r.d();
                        }
                        DownloadInfo b2 = this.r.b(c0);
                        if (b2 != null && !b2.J1()) {
                            String F0 = this.s.F0();
                            String l0 = this.s.l0();
                            this.s.l(b2, true);
                            boolean z3 = d.o.a.e.b.l.a.a(4096) && b2 != this.s;
                            try {
                                if (F0.equals(b2.F0()) && d.o.a.e.b.l.e.K(b2, false, l0)) {
                                    try {
                                        throw new com.ss.android.socialbase.downloader.exception.a(b2.q0());
                                    } catch (com.ss.android.socialbase.downloader.exception.a e3) {
                                        throw e3;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z = z3;
                                        if (this.f71119f != null) {
                                        }
                                        if (z) {
                                        }
                                    }
                                } else if (d.o.a.e.b.g.d.r(b2) != c0) {
                                    try {
                                        this.r.f(c0);
                                    } catch (SQLiteException e4) {
                                        e4.printStackTrace();
                                    }
                                } else {
                                    z2 = z3;
                                }
                            } catch (com.ss.android.socialbase.downloader.exception.a e5) {
                                e2 = e5;
                                throw e2;
                            } catch (Throwable th3) {
                                th = th3;
                                z = z3;
                                z2 = false;
                                if (this.f71119f != null) {
                                    d.o.a.e.b.e.a.e(this.f71119f.O(), this.s, new BaseException(1003, d.o.a.e.b.l.e.Y(th, "checkTaskCache")), this.s.H0());
                                }
                                if (z) {
                                }
                            }
                        }
                        this.s.Z1();
                    } else {
                        z2 = false;
                    }
                    try {
                        V();
                    } catch (com.ss.android.socialbase.downloader.exception.a e6) {
                        e2 = e6;
                        throw e2;
                    } catch (Throwable th4) {
                        th = th4;
                        z = z2;
                        z2 = false;
                        if (this.f71119f != null && this.s != null) {
                            d.o.a.e.b.e.a.e(this.f71119f.O(), this.s, new BaseException(1003, d.o.a.e.b.l.e.Y(th, "checkTaskCache")), this.s.H0());
                        }
                        if (z) {
                            if (!z2 || this.L.l("fix_file_exist_update_download_info")) {
                                this.r.a(this.s);
                            }
                        }
                        return;
                    }
                } catch (Throwable th5) {
                    if (0 != 0) {
                        if (1 != 0) {
                            try {
                            } catch (SQLiteException e7) {
                                e7.printStackTrace();
                            }
                        }
                        this.r.a(this.s);
                    }
                    throw th5;
                }
            } catch (com.ss.android.socialbase.downloader.exception.a e8) {
                e2 = e8;
            } catch (Throwable th6) {
                th = th6;
            }
            if (z2) {
                this.r.a(this.s);
            }
        } catch (SQLiteException e9) {
            e9.printStackTrace();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a A[LOOP:0: B:24:0x005a->B:55:0x005a, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Y() {
        Process.setThreadPriority(10);
        try {
            if (this.s != null && this.K > 0) {
                this.s.a1(System.currentTimeMillis() - this.K);
            }
        } catch (Throwable unused) {
        }
        try {
            x N = this.f71119f.N();
            if (N != null) {
                if (N.a()) {
                    this.y.v();
                    return;
                }
            }
        } finally {
            if (W()) {
            }
        }
        if (W()) {
            y O2 = this.f71119f.O();
            DownloadInfo downloadInfo = this.s;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo2 = this.s;
            d.o.a.e.b.e.a.e(O2, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.H0() : 0);
            return;
        }
        while (true) {
            Z();
            if (!this.F) {
                return;
            }
            if (this.E > 0) {
                this.E--;
            } else if (this.s.E() != this.s.Q0()) {
                d.o.a.e.b.c.a.g(O, this.s.O());
                this.y.g(new com.ss.android.socialbase.downloader.exception.f(SDKLogTypeConstants.EXPTYPE_LITEINC_SHOW, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.s.z()));
                return;
            } else if (this.s.E() <= 0) {
                d.o.a.e.b.c.a.g(O, this.s.O());
                this.y.g(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes invalid retry status is : " + this.s.z()));
                return;
            } else if (this.s.Q0() <= 0) {
                d.o.a.e.b.c.a.g(O, this.s.O());
                this.y.g(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.s.z()));
                return;
            }
        }
    }

    public final void Z() {
        boolean z;
        List<com.ss.android.socialbase.downloader.model.b> c2;
        try {
            this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_NONE;
            this.s.t3();
            this.s.b2();
            long currentTimeMillis = System.currentTimeMillis();
            this.s.u2(-1L);
            try {
                X();
                z = false;
            } catch (com.ss.android.socialbase.downloader.exception.a e2) {
                String str = O;
                d.o.a.e.b.c.a.g(str, "file exist " + e2.a());
                this.H = e2.a();
                z = true;
            }
            if (!this.F) {
                this.y.n();
            }
            this.F = false;
            if (j0()) {
                return;
            }
            if (!TextUtils.isEmpty(this.H) && z) {
                if (this.s.q1()) {
                    if (!this.s.k1() && TextUtils.isEmpty(this.s.g0())) {
                        this.I = false;
                        d.o.a.e.b.c.a.g(O, "dcache::last modify is emtpy, so just return cache");
                    } else {
                        String str2 = O;
                        d.o.a.e.b.c.a.g(str2, "dcache::curt=" + System.currentTimeMillis() + " expired=" + this.s.A());
                        if (System.currentTimeMillis() > this.s.A()) {
                            this.I = true;
                            d.o.a.e.b.c.a.g(O, "dcache::expired=true");
                        }
                    }
                }
                if (!this.I) {
                    a0();
                    return;
                }
            }
            while (!j0()) {
                try {
                    try {
                        try {
                            o();
                            k();
                            n();
                            c2 = this.r.c(this.s.c0());
                            p();
                        } catch (com.ss.android.socialbase.downloader.exception.a unused) {
                            a0();
                        }
                    } catch (BaseException e3) {
                        String str3 = O;
                        d.o.a.e.b.c.a.i(str3, "downloadInner: baseException = " + e3);
                        if (this.q != com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_PAUSE) {
                            if (e3.getErrorCode() != 1025 && e3.getErrorCode() != 1009) {
                                if (a(e3)) {
                                    if (d.o.a.e.b.l.e.I(e3)) {
                                        q();
                                    }
                                    if (h(e3, 0L) != com.ss.android.socialbase.downloader.exception.g.RETURN) {
                                        g0();
                                    } else {
                                        g0();
                                        return;
                                    }
                                } else {
                                    g(e3);
                                }
                            }
                            this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_END_RIGHT_NOW;
                            g0();
                            return;
                        }
                    }
                } catch (com.ss.android.socialbase.downloader.exception.h e4) {
                    String str4 = O;
                    d.o.a.e.b.c.a.i(str4, "downloadInner: retry throwable for " + e4.a());
                    if (this.q != com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_PAUSE) {
                        if (this.f71121h != null && this.f71121h.get() > 0) {
                            this.s.o3(this.f71121h.decrementAndGet());
                            this.s.a3(5);
                        } else if (this.f71121h != null) {
                            if (this.s.n3()) {
                                this.s.a3(5);
                                this.f71121h.set(this.s.B0());
                                this.s.o3(this.f71121h.get());
                            } else {
                                g(new BaseException(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.s.B0()), e4.a())));
                            }
                        } else {
                            g(new BaseException((int) SDKLogTypeConstants.TYPE_NATIVE_CPU_CLICK, "retry for Throwable, but retain retry time is NULL, last error is" + e4.a()));
                        }
                        g0();
                    }
                } catch (Throwable th) {
                    String str5 = O;
                    d.o.a.e.b.c.a.i(str5, "downloadInner: throwable =  " + th);
                    if (this.q != com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_PAUSE) {
                        g(new BaseException(1045, th));
                    }
                }
                if (b0()) {
                    d.o.a.e.b.c.a.h(O, "downloadSegments return");
                    g0();
                    return;
                }
                String C = this.s.C();
                if (j0()) {
                    g0();
                    return;
                }
                long v0 = this.l ? d.o.a.e.b.l.e.v0(this.s) : 0L;
                com.ss.android.socialbase.downloader.model.b w = w(this.s, v0);
                List<com.ss.android.socialbase.downloader.model.c> y = y(w);
                d.o.a.e.b.l.e.B(y, this.s);
                this.s.U2(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    H(C, y, v0);
                    this.s.Y0(System.currentTimeMillis() - currentTimeMillis2);
                    if (j0()) {
                        g0();
                        return;
                    }
                    long Q0 = this.s.Q0();
                    a(Q0);
                    int u = u(Q0, c2);
                    if (j0()) {
                        g0();
                        return;
                    } else if (u > 0) {
                        boolean z2 = u == 1;
                        this.k = z2;
                        if (z2) {
                            if (this.A == null) {
                                try {
                                    currentTimeMillis2 = System.currentTimeMillis();
                                    G(C, y);
                                    this.s.Y0(System.currentTimeMillis() - currentTimeMillis2);
                                } finally {
                                }
                            }
                            if (j0()) {
                                g0();
                                return;
                            }
                            this.s.u2(System.currentTimeMillis() - currentTimeMillis);
                            c0();
                            E(w, C, this.A);
                        } else {
                            if (!this.s.G1()) {
                                f0();
                            }
                            if (j0()) {
                                g0();
                                return;
                            }
                            c0();
                            this.s.u2(System.currentTimeMillis() - currentTimeMillis);
                            if (this.l) {
                                A(u, c2);
                            } else {
                                B(Q0, u);
                            }
                        }
                        g0();
                        return;
                    } else {
                        throw new BaseException((int) com.baidu.apollon.eventbus.f.f3721a, "chunkCount is 0");
                    }
                } finally {
                }
            }
        } finally {
            d0();
        }
    }

    @Override // d.o.a.e.b.k.f
    public void a(long j) throws BaseException {
        long j2;
        String N0 = this.s.N0();
        String M0 = this.s.M0();
        if (d.o.a.e.b.l.e.c0(j)) {
            return;
        }
        d.o.a.e.b.n.c f2 = d.o.a.e.b.l.e.f(N0, M0, -1);
        try {
            long length = new File(N0, M0).length();
            long j3 = j - length;
            long w0 = d.o.a.e.b.l.e.w0(N0);
            d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(this.s.c0());
            if (d2.b("space_fill_part_download", 0) == 1) {
                this.J = 0L;
                if (j3 <= 0) {
                    j3 = this.s.Q0() - this.s.E();
                }
                if (w0 < j3) {
                    String str = O;
                    d.o.a.e.b.c.a.i(str, "checkSpaceOverflow: contentLength = " + d.o.a.e.b.l.e.a(j) + "MB, downloaded = " + d.o.a.e.b.l.e.a(length) + "MB, required = " + d.o.a.e.b.l.e.a(j3) + "MB, available = " + d.o.a.e.b.l.e.a(w0) + "MB");
                    int i2 = (w0 > 0L ? 1 : (w0 == 0L ? 0 : -1));
                    if (i2 > 0) {
                        int b2 = d2.b("space_fill_min_keep_mb", 100);
                        if (b2 > 0) {
                            j2 = w0 - (b2 * 1048576);
                            String str2 = O;
                            d.o.a.e.b.c.a.i(str2, "checkSpaceOverflow: minKeep = " + b2 + "MB, canDownload = " + d.o.a.e.b.l.e.a(j2) + "MB");
                            if (j2 > 0) {
                                this.J = this.s.E() + j2;
                            } else {
                                throw new com.ss.android.socialbase.downloader.exception.d(w0, j3);
                            }
                        } else {
                            j2 = w0;
                        }
                        if (length < j) {
                            if (j2 + length > j) {
                            }
                            f2.p(j);
                            d.o.a.e.b.l.e.C(f2);
                        }
                    } else if (d2.b("download_when_space_negative", 0) != 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("availableSpace ");
                        sb.append(i2 == 0 ? "=" : "<");
                        sb.append(" 0");
                        throw new BaseException((int) RevenueServerConst.GetChargeCouponDiscountRequest, sb.toString());
                    } else {
                        f2.p(j);
                        d.o.a.e.b.l.e.C(f2);
                    }
                }
            } else {
                int i3 = (w0 > 0L ? 1 : (w0 == 0L ? 0 : -1));
                if (i3 <= 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("availableSpace ");
                    sb2.append(i3 == 0 ? "=" : "<");
                    sb2.append(" 0");
                    throw new BaseException((int) RevenueServerConst.GetChargeCouponDiscountRequest, sb2.toString());
                } else if (w0 < j3) {
                    throw new com.ss.android.socialbase.downloader.exception.d(w0, j3);
                }
            }
            f2.p(j);
            d.o.a.e.b.l.e.C(f2);
        } catch (Throwable th) {
            d.o.a.e.b.l.e.C(f2);
            throw th;
        }
    }

    public final void a0() {
        d.o.a.e.b.c.a.g(O, "finishWithFileExist");
        if (d.o.a.e.b.j.a.r().q("fix_end_for_file_exist_error", true)) {
            if (this.H.equals(this.s.q0())) {
                this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_END_RIGHT_NOW;
            } else {
                this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_END_FOR_FILE_EXIST;
            }
        } else if (this.H.equals(this.s.K0())) {
            this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    @Override // d.o.a.e.b.k.f
    public boolean b(long j) throws BaseException {
        if (this.J > 0 && this.s.E() > this.J) {
            m();
        }
        return this.y.k(j);
    }

    public final boolean b0() throws BaseException, InterruptedException {
        if (!this.s.q1() && this.s.B() == 1 && this.s.O0() <= 0) {
            JSONObject u = d.o.a.e.b.j.a.d(this.s.c0()).u("segment_config");
            List<d.o.a.e.b.i.i> n = this.r.n(this.s.c0());
            if (this.s.E() > 0) {
                if (n == null || n.isEmpty()) {
                    return false;
                }
                if (u == null) {
                    u = new JSONObject();
                }
            }
            if (u == null) {
                return false;
            }
            this.N = new d.o.a.e.b.i.j(this.s, m.b(u), this);
            if (j0()) {
                d.o.a.e.b.c.a.h(O, "downloadSegments: is stopped by user");
                if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_CANCELED) {
                    this.N.r();
                } else {
                    this.N.C();
                }
                return true;
            }
            this.N.v(n);
            return true;
        }
        return false;
    }

    @Override // d.o.a.e.b.k.f
    public void c(d.o.a.e.b.k.b bVar) {
        if (this.k) {
            return;
        }
        synchronized (this) {
            this.f71122i.remove(bVar);
        }
    }

    public final void c0() {
        if (d.o.a.e.b.j.a.d(this.s.c0()).b("reset_retain_retry_times", 0) != 1 || this.M >= 3) {
            return;
        }
        this.f71121h.set(this.s.e1() ? this.s.v() : this.s.B0());
        this.M++;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00cb A[Catch: all -> 0x0222, h -> 0x0229, BaseException -> 0x022b, TryCatch #2 {BaseException -> 0x022b, h -> 0x0229, all -> 0x0222, blocks: (B:6:0x0008, B:8:0x0021, B:10:0x0027, B:11:0x002c, B:13:0x0081, B:15:0x008e, B:16:0x00a0, B:18:0x00a9, B:20:0x00ad, B:24:0x00b9, B:30:0x00cb, B:31:0x00d1, B:32:0x00f6, B:33:0x00f7, B:35:0x00fd, B:36:0x0102, B:39:0x010a, B:41:0x010e, B:43:0x0114, B:46:0x011b, B:48:0x0121, B:49:0x0128, B:50:0x0129, B:52:0x012f, B:57:0x0138, B:58:0x0141, B:59:0x0142, B:60:0x0158, B:61:0x0159, B:65:0x0161, B:67:0x0165, B:69:0x016b, B:70:0x0172, B:71:0x0173, B:73:0x0183, B:75:0x018f, B:79:0x019b, B:82:0x01a0, B:83:0x01a5, B:84:0x01a6, B:86:0x01aa, B:88:0x01b6, B:90:0x01bd, B:93:0x01c7, B:96:0x01ce, B:98:0x01d8, B:100:0x01ea, B:103:0x01f5, B:104:0x021b, B:105:0x021c, B:91:0x01c2), top: B:114:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d1 A[Catch: all -> 0x0222, h -> 0x0229, BaseException -> 0x022b, TryCatch #2 {BaseException -> 0x022b, h -> 0x0229, all -> 0x0222, blocks: (B:6:0x0008, B:8:0x0021, B:10:0x0027, B:11:0x002c, B:13:0x0081, B:15:0x008e, B:16:0x00a0, B:18:0x00a9, B:20:0x00ad, B:24:0x00b9, B:30:0x00cb, B:31:0x00d1, B:32:0x00f6, B:33:0x00f7, B:35:0x00fd, B:36:0x0102, B:39:0x010a, B:41:0x010e, B:43:0x0114, B:46:0x011b, B:48:0x0121, B:49:0x0128, B:50:0x0129, B:52:0x012f, B:57:0x0138, B:58:0x0141, B:59:0x0142, B:60:0x0158, B:61:0x0159, B:65:0x0161, B:67:0x0165, B:69:0x016b, B:70:0x0172, B:71:0x0173, B:73:0x0183, B:75:0x018f, B:79:0x019b, B:82:0x01a0, B:83:0x01a5, B:84:0x01a6, B:86:0x01aa, B:88:0x01b6, B:90:0x01bd, B:93:0x01c7, B:96:0x01ce, B:98:0x01d8, B:100:0x01ea, B:103:0x01f5, B:104:0x021b, B:105:0x021c, B:91:0x01c2), top: B:114:0x0008 }] */
    @Override // d.o.a.e.b.k.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str, i iVar, long j) throws BaseException, com.ss.android.socialbase.downloader.exception.h {
        long j2;
        boolean z;
        if (iVar == null) {
            return;
        }
        try {
            d.o.a.e.b.n.b bVar = new d.o.a.e.b.n.b(str, iVar);
            int i2 = bVar.f71232c;
            String d2 = bVar.d();
            if (TextUtils.isEmpty(this.s.m0()) && !TextUtils.isEmpty(d2)) {
                this.s.M2(d2);
            }
            boolean b2 = bVar.b();
            this.m = b2;
            this.s.d3(b2);
            this.n = bVar.a();
            String U0 = this.s.U0();
            String c2 = bVar.c();
            String f2 = bVar.f();
            String g2 = bVar.g();
            String str2 = O;
            d.o.a.e.b.c.a.g(str2, "dcache=last_modified=" + f2 + " CACHE_CONTROL=" + g2 + " max-age=" + bVar.k());
            if (!TextUtils.isEmpty(g2)) {
                this.s.j2(g2);
                if (bVar.k() > 0) {
                    this.s.k2(System.currentTimeMillis() + (bVar.k() * 1000));
                }
            }
            if (this.s.q1() && this.I && !TextUtils.isEmpty(this.H)) {
                if (i2 != 304 && !TextUtils.equals(f2, this.s.g0())) {
                    z = false;
                    if (z) {
                        d.o.a.e.b.l.e.u(this.s);
                    } else {
                        String str3 = O;
                        d.o.a.e.b.c.a.g(str3, "dcache=responseCode=" + i2 + " lastModified not changed, use local file  " + f2);
                        throw new com.ss.android.socialbase.downloader.exception.a(this.H);
                    }
                }
                z = true;
                if (z) {
                }
            }
            if (!TextUtils.isEmpty(f2)) {
                this.s.H2(f2);
            }
            if (L(i2, U0, c2)) {
                if (iVar instanceof k) {
                    if (!TextUtils.isEmpty(U0) && U0.equals(c2)) {
                        c2 = "";
                    }
                    F(c2, "eTag of server file changed");
                    throw null;
                }
                throw new com.ss.android.socialbase.downloader.exception.b(1002, i2, "");
            }
            if (!this.m && !this.n) {
                if (i2 == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "response code error : " + i2);
            }
            if (this.n && j > 0) {
                if (iVar instanceof k) {
                    F("", "http head request not support");
                    throw null;
                }
                throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
            }
            long h2 = bVar.h();
            String g3 = TextUtils.isEmpty(this.s.q0()) ? d.o.a.e.b.l.e.g(iVar, this.s.T0()) : "";
            boolean i3 = bVar.i();
            this.o = i3;
            if (!i3 && h2 == 0 && !(iVar instanceof k)) {
                throw new BaseException(1004, "");
            }
            if (this.o) {
                j2 = -1;
            } else {
                String W = d.o.a.e.b.l.e.W(iVar, "Content-Range");
                j2 = (TextUtils.isEmpty(W) || !d.o.a.e.b.l.a.a(2)) ? j + h2 : d.o.a.e.b.l.e.T(W);
            }
            if (j0()) {
                return;
            }
            if (this.s.Q() > 0 && d.o.a.e.b.j.a.d(this.s.c0()).m("force_check_file_length") == 1 && this.s.Q() != j2) {
                throw new BaseException(1070, "expectFileLength = " + this.s.Q() + " , totalLength = " + j2);
            }
            this.y.e(j2, c2, g3);
        } catch (BaseException e2) {
            throw e2;
        } catch (com.ss.android.socialbase.downloader.exception.h e3) {
            throw e3;
        } catch (Throwable th) {
            d.o.a.e.b.l.e.A(th, "HandleFirstConnection");
            throw null;
        }
    }

    public final void d0() {
        boolean z;
        boolean z2;
        String str = O;
        d.o.a.e.b.c.a.g(str, "endDownloadRunnable::runStatus=" + this.q);
        boolean z3 = (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_PAUSE || this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_CANCELED) ? false : true;
        try {
            z = k0();
            z2 = false;
        } catch (Exception e2) {
            if (e2 instanceof BaseException) {
                this.y.g((BaseException) e2);
            } else {
                this.y.g(new BaseException(1046, e2));
            }
            z = true;
            z2 = true;
        }
        if (!z && !z2) {
            this.F = true;
            d.o.a.e.b.c.a.g(O, "jump to restart");
            return;
        }
        this.p.set(false);
        if (z3) {
            try {
                d.o.a.e.b.m.a c2 = d.o.a.e.b.g.d.c();
                if (c2 != null) {
                    c2.j(this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                y O2 = this.f71119f.O();
                DownloadInfo downloadInfo = this.s;
                BaseException baseException = new BaseException(1014, d.o.a.e.b.l.e.Y(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.s;
                d.o.a.e.b.e.a.e(O2, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.H0() : 0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    @Override // d.o.a.e.b.k.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(i iVar) {
        boolean z;
        if (iVar != null) {
            try {
                int b2 = iVar.b();
                this.s.A2(b2);
                this.s.B2(d.o.a.e.b.l.b.a(b2));
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z) {
                this.s.A2(-1);
                this.s.B2("");
                return;
            }
            return;
        }
        z = false;
        if (z) {
        }
    }

    public final void e0() {
        i iVar = this.B;
        if (iVar != null) {
            iVar.c();
            this.B = null;
        }
    }

    @Override // d.o.a.e.b.k.f
    public void f(BaseException baseException) {
        DownloadInfo downloadInfo = this.s;
        if (downloadInfo != null) {
            downloadInfo.m2(true);
        }
        i(baseException, false);
    }

    public final void f0() {
        k kVar = this.A;
        if (kVar != null) {
            kVar.d();
            this.A = null;
        }
    }

    @Override // d.o.a.e.b.k.f
    public void g(BaseException baseException) {
        String str = O;
        d.o.a.e.b.c.a.g(str, "onError:" + baseException.getMessage());
        this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_ERROR;
        this.z = baseException;
        r();
    }

    public final void g0() {
        e0();
        f0();
    }

    @Override // d.o.a.e.b.k.f
    public com.ss.android.socialbase.downloader.exception.g h(BaseException baseException, long j) {
        long Q0;
        long j2;
        boolean z;
        this.z = baseException;
        this.s.Z0(-j);
        this.r.a(this.s);
        if (i0()) {
            return com.ss.android.socialbase.downloader.exception.g.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.C != null && !this.s.u1()) {
                a aVar = new a();
                boolean a2 = this.C.a(aVar);
                this.s.x2();
                if (a2) {
                    if (!aVar.a()) {
                        r();
                        this.y.y();
                        this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.exception.g.RETURN;
                    }
                    z = true;
                }
            } else if (R(baseException)) {
                return com.ss.android.socialbase.downloader.exception.g.RETURN;
            }
            z = false;
        } else if (d.o.a.e.b.l.e.M0(baseException)) {
            if (this.D == null) {
                g(baseException);
                return com.ss.android.socialbase.downloader.exception.g.RETURN;
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            b bVar = new b(atomicBoolean);
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
                com.ss.android.socialbase.downloader.exception.d dVar = (com.ss.android.socialbase.downloader.exception.d) baseException;
                j2 = dVar.a();
                Q0 = dVar.b();
            } else {
                Q0 = this.s.Q0();
                j2 = -1;
            }
            synchronized (this) {
                if (this.D.a(j2, Q0, bVar)) {
                    if (!d.o.a.e.b.j.a.d(this.s.c0()).q("not_delete_when_clean_space", false)) {
                        m0();
                    }
                    if (!atomicBoolean.get()) {
                        if (this.q != com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                            this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_WAITING_ASYNC_HANDLER;
                            r();
                            this.y.y();
                        }
                        return com.ss.android.socialbase.downloader.exception.g.RETURN;
                    }
                    if (R(baseException)) {
                        return com.ss.android.socialbase.downloader.exception.g.RETURN;
                    }
                    z = true;
                } else if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                    return com.ss.android.socialbase.downloader.exception.g.RETURN;
                } else {
                    g(baseException);
                    return com.ss.android.socialbase.downloader.exception.g.RETURN;
                }
            }
        } else {
            if (R(baseException)) {
                return com.ss.android.socialbase.downloader.exception.g.RETURN;
            }
            z = false;
        }
        if (!z && t()) {
            r();
        }
        this.y.h(baseException, this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_RETRY_DELAY);
        return this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_RETRY_DELAY ? com.ss.android.socialbase.downloader.exception.g.RETURN : com.ss.android.socialbase.downloader.exception.g.CONTINUE;
    }

    public final void h0() throws BaseException {
        if (this.j != null) {
            if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_CANCELED) {
                this.s.a3(-4);
                this.j.j();
            } else if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_PAUSE) {
                this.s.a3(-2);
                this.j.h();
            } else {
                this.j.k();
            }
        }
    }

    @Override // d.o.a.e.b.k.f
    public void i(BaseException baseException, boolean z) {
        d.o.a.e.b.c.a.g(O, "onAllChunkRetryWithReset");
        this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.z = baseException;
        r();
        if (z ? R(baseException) : false) {
            return;
        }
        q();
    }

    public final boolean i0() {
        return this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_CANCELED || this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_PAUSE;
    }

    public final long j() {
        return this.x.a(this.s.G(), this.s.R0());
    }

    public final boolean j0() {
        if (i0() || this.s.H0() == -2) {
            if (i0()) {
                return true;
            }
            if (this.s.H0() == -2) {
                this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_PAUSE;
                return true;
            } else if (this.s.H0() == -4) {
                this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_CANCELED;
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public final void k() throws com.ss.android.socialbase.downloader.exception.h, BaseException {
        d.o.a.e.b.m.a c2;
        int c0 = this.s.c0();
        int r = d.o.a.e.b.g.d.r(this.s);
        if (this.s.o1() && !this.s.q1() && !this.I) {
            throw new BaseException(1009, "file has downloaded");
        }
        DownloadInfo b2 = this.r.b(r);
        if (b2 == null || (c2 = d.o.a.e.b.g.d.c()) == null || b2.c0() == c0 || !b2.p(this.s)) {
            return;
        }
        if (!c2.p(b2.c0())) {
            List<com.ss.android.socialbase.downloader.model.b> c3 = this.r.c(r);
            d.o.a.e.b.l.e.u(this.s);
            this.r.f(r);
            if (b2 == null || !b2.f1()) {
                return;
            }
            this.s.l(b2, false);
            this.r.a(this.s);
            if (c3 != null) {
                for (com.ss.android.socialbase.downloader.model.b bVar : c3) {
                    bVar.k(c0);
                    this.r.a(bVar);
                }
            }
            throw new com.ss.android.socialbase.downloader.exception.h("retry task because id generator changed");
        }
        this.r.f(c0);
        throw new BaseException(1025, "another same task is downloading");
    }

    public final boolean k0() {
        if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_ERROR) {
            this.y.g(this.z);
        } else if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_CANCELED) {
            this.y.s();
        } else if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_PAUSE) {
            this.y.u();
        } else if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.y.x();
            } catch (BaseException e2) {
                this.y.g(e2);
            }
        } else if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.y.j(this.H);
            } catch (BaseException e3) {
                this.y.g(e3);
            }
        } else if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.y.h(this.z, false);
            return false;
        } else if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            return true;
        } else {
            if (this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_RETRY_DELAY && !l0()) {
                d.o.a.e.b.c.a.g(O, "doTaskStatusHandle retryDelay");
                n0();
                return this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_RETRY_DELAY;
            }
            try {
                if (!m0()) {
                    return false;
                }
                this.y.w();
                q.d().w();
            } catch (Throwable th) {
                g(new BaseException(1008, d.o.a.e.b.l.e.Y(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    public final boolean l() {
        DownloadInfo downloadInfo = this.s;
        if (downloadInfo == null || downloadInfo.q1()) {
            return false;
        }
        return (!this.l || this.s.B() > 1) && !this.s.i1() && this.m && !this.o;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean l0() {
        if (this.s.B() <= 1) {
            return this.s.E() > 0 && this.s.E() == this.s.Q0();
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = this.r.c(this.s.c0());
        if (c2 == null || c2.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
            if (bVar == null || !bVar.v()) {
                return false;
            }
            while (r0.hasNext()) {
            }
        }
        return true;
    }

    public final void m() throws BaseException {
        long j;
        int b2;
        try {
            j = d.o.a.e.b.l.e.w0(this.s.N0());
        } catch (BaseException unused) {
            j = 0;
        }
        d.o.a.e.b.c.a.h(O, "checkSpaceOverflowInProgress: available = " + d.o.a.e.b.l.e.a(j) + "MB");
        if (j > 0) {
            long Q0 = this.s.Q0() - this.s.E();
            if (j < Q0 && (b2 = d.o.a.e.b.j.a.d(this.s.c0()).b("space_fill_min_keep_mb", 100)) > 0) {
                long j2 = j - (b2 * 1048576);
                d.o.a.e.b.c.a.h(O, "checkSpaceOverflowInProgress: minKeep  = " + b2 + "MB, canDownload = " + d.o.a.e.b.l.e.a(j2) + "MB");
                if (j2 > 0) {
                    this.J = this.s.E() + j2 + 1048576;
                    return;
                } else {
                    this.J = 0L;
                    throw new com.ss.android.socialbase.downloader.exception.d(j, Q0);
                }
            }
        }
        this.J = 0L;
    }

    public final boolean m0() {
        if (this.s.j1()) {
            DownloadInfo downloadInfo = this.s;
            downloadInfo.g3(downloadInfo.E());
        }
        String str = O;
        d.o.a.e.b.c.a.h(str, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.s.E() + ",  downloadInfo.getTotalBytes() = " + this.s.Q0());
        if (this.s.E() > 0) {
            if (this.s.y1()) {
                return true;
            }
            if (this.s.Q0() > 0 && this.s.E() == this.s.Q0()) {
                return true;
            }
        }
        this.s.i2(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.s.Z1();
        this.r.a(this.s);
        this.r.d(this.s.c0());
        this.r.m(this.s.c0());
        d.o.a.e.b.l.e.u(this.s);
        return false;
    }

    public final void n() throws com.ss.android.socialbase.downloader.exception.f {
        if (this.s.K1() && !d.o.a.e.b.l.e.H(d.o.a.e.b.g.d.l(), DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
            throw new com.ss.android.socialbase.downloader.exception.f(1019, String.format("download task need permission:%s", DefaultConnectivityMonitorFactory.NETWORK_PERMISSION));
        }
        if (this.s.n1()) {
            if (!this.s.M1()) {
                throw new com.ss.android.socialbase.downloader.exception.e();
            }
            return;
        }
        throw new com.ss.android.socialbase.downloader.exception.c();
    }

    public final void n0() {
        this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_NONE;
    }

    public final void o() throws BaseException {
        if (!TextUtils.isEmpty(this.s.F0())) {
            if (!TextUtils.isEmpty(this.s.q0())) {
                File file = new File(this.s.F0());
                if (!file.exists()) {
                    if (!file.mkdirs()) {
                        throw new BaseException((int) PushInnerClientConstants.ReportTypeConstant.TYPE_NOTICE_CLICK, "download savePath directory can not created");
                    }
                    return;
                } else if (!file.isDirectory()) {
                    throw new BaseException(1031, "download savePath is not a directory");
                } else {
                    return;
                }
            }
            throw new BaseException((int) SDKLogTypeConstants.EXPTYPE_LITEINC_LAUNCH, "download name can not be empty");
        }
        throw new BaseException((int) SDKLogTypeConstants.EXPTYPE_LITEINC_INSTALL, "download savePath can not be empty");
    }

    public final void p() {
        long C0 = d.o.a.e.b.l.e.C0(this.s);
        long E = this.s.E();
        if (C0 != E) {
            String str = O;
            d.o.a.e.b.c.a.i(str, "checkTaskCanResume: offset = " + C0 + ", curBytes = " + E);
        }
        this.s.n2(C0);
        boolean z = C0 > 0;
        this.l = z;
        if (z || this.I) {
            return;
        }
        d.o.a.e.b.c.a.h(O, "checkTaskCanResume: deleteAllDownloadFiles");
        this.r.d(this.s.c0());
        this.r.m(this.s.c0());
        d.o.a.e.b.l.e.u(this.s);
    }

    public final void q() {
        String str = O;
        d.o.a.e.b.c.a.i(str, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.r.d(this.s.c0());
            this.r.m(this.s.c0());
            d.o.a.e.b.l.e.u(this.s);
            this.l = false;
            this.s.a2("");
            this.r.a(this.s);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void r() {
        try {
            Iterator it = ((ArrayList) this.f71122i.clone()).iterator();
            while (it.hasNext()) {
                d.o.a.e.b.k.b bVar = (d.o.a.e.b.k.b) it.next();
                if (bVar != null) {
                    bVar.e();
                }
            }
        } catch (Throwable th) {
            String str = O;
            d.o.a.e.b.c.a.h(str, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        d.o.a.e.b.g.d.N(this.f71119f, 3);
        try {
            d.o.a.e.b.o.d.a().b();
            Y();
            d.o.a.e.b.o.d.a().c();
            d.o.a.e.b.g.d.b0(this.f71119f, 3);
        } catch (Throwable th) {
            d.o.a.e.b.o.d.a().c();
            throw th;
        }
    }

    public final void s() {
        d.o.a.e.b.m.a c2;
        if (j0() || (c2 = d.o.a.e.b.g.d.c()) == null) {
            return;
        }
        c2.N(this.s.c0());
    }

    public final boolean t() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (r9 <= 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int u(long j, List<com.ss.android.socialbase.downloader.model.b> list) {
        int i2;
        int a2;
        if (l()) {
            if (!this.l) {
                d.o.a.e.b.g.i iVar = this.t;
                if (iVar != null) {
                    a2 = iVar.a(j);
                } else {
                    a2 = this.u.a(j);
                }
                com.ss.android.socialbase.downloader.network.l d2 = d.o.a.e.b.o.m.a().d();
                d.o.a.e.b.c.a.g(O, String.format("NetworkQuality is : %s", d2.name()));
                this.s.O2(d2.name());
                h hVar = this.v;
                if (hVar != null) {
                    i2 = hVar.a(a2, d2);
                } else {
                    i2 = this.w.a(a2, d2);
                }
            } else if (list != null) {
                i2 = list.size();
            } else {
                i2 = this.s.B();
            }
        }
        i2 = 1;
        if (d.o.a.e.b.c.a.e()) {
            d.o.a.e.b.c.a.g(O, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(i2), this.s.q0(), String.valueOf(j)));
        }
        return i2;
    }

    public final r v(d.o.a.e.b.n.a aVar) {
        r R = aVar.R();
        if (R != null) {
            return R;
        }
        DownloadInfo H = aVar.H();
        if (H != null) {
            String D0 = H.D0();
            if (!TextUtils.isEmpty(D0)) {
                return new p(D0);
            }
        }
        return d.o.a.e.b.g.d.k();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r9.s() != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.ss.android.socialbase.downloader.model.b x(com.ss.android.socialbase.downloader.model.b bVar, int i2) {
        com.ss.android.socialbase.downloader.model.b bVar2 = null;
        if (bVar.q()) {
            long n = bVar.n(true);
            String str = O;
            d.o.a.e.b.c.a.g(str, "reuseChunk retainLen:" + n + " chunkIndex:" + i2);
            boolean z = false;
            if (!bVar.s() && n > d.o.a.e.b.d.c.f70969f && this.s.F1()) {
                List<com.ss.android.socialbase.downloader.model.b> b2 = bVar.b(this.s.B(), this.s.Q0());
                if (b2 != null) {
                    for (com.ss.android.socialbase.downloader.model.b bVar3 : b2) {
                        this.r.b(bVar3);
                    }
                }
            }
            z = true;
            if (z && bVar.s()) {
                for (int i3 = 1; i3 < bVar.t().size(); i3++) {
                    com.ss.android.socialbase.downloader.model.b bVar4 = bVar.t().get(i3);
                    if (bVar4 != null) {
                        String str2 = O;
                        d.o.a.e.b.c.a.g(str2, "check can checkUnCompletedChunk -- chunkIndex:" + bVar4.F() + " currentOffset:" + bVar4.A() + "  startOffset:" + bVar4.y() + " contentLen:" + bVar4.D());
                        if (bVar4.F() < 0 || (!bVar4.v() && !bVar4.p())) {
                            bVar2 = bVar4;
                            break;
                        }
                    }
                }
                if (bVar2 != null) {
                    long A = bVar.A();
                    String str3 = O;
                    d.o.a.e.b.c.a.g(str3, "unComplete chunk " + bVar.F() + " curOffset:" + A + " reuseChunk chunkIndex:" + i2 + " for subChunk:" + bVar2.F());
                    this.r.a(bVar2.x(), bVar2.F(), bVar2.j(), i2);
                    bVar2.o(i2);
                    bVar2.i(true);
                }
            }
            return bVar2;
        }
        return null;
    }

    public final List<com.ss.android.socialbase.downloader.model.c> y(com.ss.android.socialbase.downloader.model.b bVar) {
        List<com.ss.android.socialbase.downloader.model.c> r = d.o.a.e.b.l.e.r(this.s.S(), this.s.U0(), bVar);
        if (this.s.q1() && this.I && this.s.g0() != null) {
            r.add(new com.ss.android.socialbase.downloader.model.c("if-modified-since", this.s.g0()));
            String str = O;
            d.o.a.e.b.c.a.g(str, "dcache::add head IF_MODIFIED_SINCE=" + this.s.g0());
        }
        return r;
    }

    public void z() {
        this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_PAUSE;
        if (this.N != null) {
            this.N.C();
        }
        if (this.j != null) {
            this.j.h();
        }
        if (this.N == null && this.j == null) {
            g0();
            this.q = com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_PAUSE;
            d0();
        }
        try {
            Iterator it = ((ArrayList) this.f71122i.clone()).iterator();
            while (it.hasNext()) {
                d.o.a.e.b.k.b bVar = (d.o.a.e.b.k.b) it.next();
                if (bVar != null) {
                    bVar.a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.k.f
    public com.ss.android.socialbase.downloader.exception.g b(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, long j) {
        if (i0()) {
            return com.ss.android.socialbase.downloader.exception.g.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || d.o.a.e.b.l.e.M0(baseException))) {
            return h(baseException, j);
        }
        this.z = baseException;
        this.s.Z0(-j);
        this.r.a(this.s);
        if (R(baseException)) {
            return com.ss.android.socialbase.downloader.exception.g.RETURN;
        }
        this.y.i(bVar, baseException, this.q == com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_RETRY_DELAY);
        if (this.q != com.ss.android.socialbase.downloader.constants.i.RUN_STATUS_RETRY_DELAY && this.s.E1()) {
            long j2 = j();
            if (j2 > 0) {
                String str = O;
                d.o.a.e.b.c.a.h(str, "onSingleChunkRetry with delay time " + j2);
                try {
                    Thread.sleep(j2);
                } catch (Throwable th) {
                    String str2 = O;
                    d.o.a.e.b.c.a.i(str2, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.exception.g.CONTINUE;
    }

    @Override // d.o.a.e.b.k.f
    public boolean a(BaseException baseException) {
        if (this.N == null || !d.o.a.e.b.l.e.P0(baseException) || this.f71121h.get() >= this.s.B0()) {
            if (d.o.a.e.b.l.e.e0(baseException)) {
                if (this.k && !this.f71120g) {
                    d.o.a.e.b.l.e.u(this.s);
                    this.f71120g = true;
                }
                return true;
            }
            AtomicInteger atomicInteger = this.f71121h;
            if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.s.W0()) {
                if (baseException == null) {
                    return false;
                }
                if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.s.d()) {
                    return false;
                }
            }
            return !(baseException instanceof com.ss.android.socialbase.downloader.exception.f);
        }
        return false;
    }

    @Override // d.o.a.e.b.k.f
    public synchronized com.ss.android.socialbase.downloader.model.b a(int i2) {
        com.ss.android.socialbase.downloader.model.b x;
        if (this.s.B() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = this.r.c(this.s.c0());
        if (c2 != null && !c2.isEmpty()) {
            for (int i3 = 0; i3 < c2.size(); i3++) {
                com.ss.android.socialbase.downloader.model.b bVar = c2.get(i3);
                if (bVar != null && (x = x(bVar, i2)) != null) {
                    return x;
                }
            }
            return null;
        }
        return null;
    }
}
