package d.o.a.e.b.m;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.a.a;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q implements Handler.Callback, a.b {
    public static volatile q l;
    public static e m;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f71203h;

    /* renamed from: i  reason: collision with root package name */
    public long f71204i;
    public ConnectivityManager k;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f71201f = new Handler(Looper.getMainLooper(), this);

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<d> f71202g = new SparseArray<>();
    public int j = 0;

    /* renamed from: e  reason: collision with root package name */
    public final Context f71200e = d.o.a.e.b.g.d.l();

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: d.o.a.e.b.m.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1952a extends ConnectivityManager.NetworkCallback {
            public C1952a() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                d.o.a.e.b.c.a.g("RetryScheduler", "network onAvailable: ");
                q.this.g(1, true);
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (q.this.f71200e == null || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                q.this.k = (ConnectivityManager) q.this.f71200e.getApplicationContext().getSystemService("connectivity");
                q.this.k.registerNetworkCallback(new NetworkRequest.Builder().build(), new C1952a());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f71207e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f71208f;

        public b(int i2, boolean z) {
            this.f71207e = i2;
            this.f71208f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int A;
            try {
                if (q.this.j > 0 && (A = q.this.A()) != 0) {
                    d.o.a.e.b.c.a.h("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + q.this.j);
                    long currentTimeMillis = System.currentTimeMillis();
                    ArrayList<d> arrayList = new ArrayList();
                    synchronized (q.this.f71202g) {
                        for (int i2 = 0; i2 < q.this.f71202g.size(); i2++) {
                            d dVar = (d) q.this.f71202g.valueAt(i2);
                            if (dVar != null && dVar.d(currentTimeMillis, this.f71207e, A, this.f71208f)) {
                                if (this.f71208f) {
                                    dVar.i();
                                }
                                arrayList.add(dVar);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        for (d dVar2 : arrayList) {
                            q.this.f(dVar2.f71212a, A, false);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f71210e;

        public c(int i2) {
            this.f71210e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                q.this.f(this.f71210e, q.this.A(), true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f71212a;

        /* renamed from: b  reason: collision with root package name */
        public final int f71213b;

        /* renamed from: c  reason: collision with root package name */
        public final int f71214c;

        /* renamed from: d  reason: collision with root package name */
        public final int f71215d;

        /* renamed from: e  reason: collision with root package name */
        public final int f71216e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f71217f;

        /* renamed from: g  reason: collision with root package name */
        public final int[] f71218g;

        /* renamed from: h  reason: collision with root package name */
        public int f71219h;

        /* renamed from: i  reason: collision with root package name */
        public int f71220i;
        public boolean j;
        public long k;
        public boolean l;

        public d(int i2, int i3, int i4, int i5, int i6, boolean z, int[] iArr) {
            i5 = i5 < 3000 ? 3000 : i5;
            i6 = i6 < 5000 ? 5000 : i6;
            this.f71212a = i2;
            this.f71213b = i3;
            this.f71214c = i4;
            this.f71215d = i5;
            this.f71216e = i6;
            this.f71217f = z;
            this.f71218g = iArr;
            this.f71219h = i5;
        }

        public synchronized void b() {
            this.f71219h += this.f71216e;
        }

        public synchronized void c(long j) {
            this.k = j;
        }

        public boolean d(long j, int i2, int i3, boolean z) {
            if (!this.l) {
                d.o.a.e.b.c.a.h("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            } else if (this.f71213b >= i2 && this.f71220i < this.f71214c) {
                if (!this.j || i3 == 2) {
                    return z || j - this.k >= ((long) this.f71215d);
                }
                return false;
            } else {
                return false;
            }
        }

        public synchronized void f() {
            this.f71220i++;
        }

        public void i() {
            this.f71219h = this.f71215d;
        }

        public int j() {
            return this.f71219h;
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(DownloadInfo downloadInfo, long j, boolean z, int i2);
    }

    public q() {
        z();
        this.f71203h = d.o.a.e.b.l.e.n0();
        d.o.a.e.b.a.a.c().f(this);
    }

    public static q d() {
        if (l == null) {
            synchronized (q.class) {
                if (l == null) {
                    l = new q();
                }
            }
        }
        return l;
    }

    public static void h(e eVar) {
        m = eVar;
    }

    public final int A() {
        try {
            if (this.k == null) {
                this.k = (ConnectivityManager) this.f71200e.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.k.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    @Override // d.o.a.e.b.a.a.b
    public void c() {
        g(3, false);
    }

    public void e(int i2) {
        d.o.a.e.b.g.d.w0().execute(new c(i2));
    }

    public final void f(int i2, int i3, boolean z) {
        d.o.a.e.b.g.q m2;
        boolean z2;
        Context context = this.f71200e;
        if (context == null) {
            return;
        }
        synchronized (this.f71202g) {
            d dVar = this.f71202g.get(i2);
            if (dVar == null) {
                return;
            }
            boolean z3 = true;
            if (dVar.l) {
                dVar.l = false;
                int i4 = this.j - 1;
                this.j = i4;
                if (i4 < 0) {
                    this.j = 0;
                }
            }
            d.o.a.e.b.c.a.h("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i2 + ", retryCount = " + dVar.f71220i + ", mWaitingRetryTasksCount = " + this.j);
            DownloadInfo f2 = d.o.a.e.b.g.a.l(context).f(i2);
            if (f2 == null) {
                t(i2);
                return;
            }
            d.o.a.e.b.c.a.j("RetryScheduler", "doSchedulerRetryInSubThread，id:" + i2);
            int z0 = f2.z0();
            if (z0 != -3 && z0 != -4) {
                if (z0 == -5 || (z0 == -2 && f2.L1())) {
                    if (z0 == -2 && (m2 = d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).m()) != null) {
                        m2.a(f2, 4, 3);
                    }
                    d.o.a.e.b.g.l H0 = d.o.a.e.b.g.d.H0();
                    if (H0 != null) {
                        H0.a(Collections.singletonList(f2), 3);
                    }
                    t(i2);
                    return;
                } else if (z0 != -1) {
                    return;
                } else {
                    if (i3 != 0) {
                        z2 = true;
                    } else if (!dVar.f71217f) {
                        return;
                    } else {
                        z2 = false;
                    }
                    BaseException U = f2.U();
                    if (z2 && d.o.a.e.b.l.e.M0(U)) {
                        z2 = n(f2, U);
                    }
                    dVar.f();
                    if (z2) {
                        d.o.a.e.b.c.a.h("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + dVar.f71212a);
                        dVar.c(System.currentTimeMillis());
                        if (z) {
                            dVar.b();
                        }
                        f2.W2(dVar.f71220i);
                        if (f2.H0() == -1) {
                            d.o.a.e.b.g.a.l(context).z(f2.c0());
                            return;
                        }
                        return;
                    }
                    if (z) {
                        dVar.b();
                    }
                    if (!f2.K1() && !f2.L1()) {
                        z3 = false;
                    }
                    l(f2, z3, i3);
                    return;
                }
            }
            t(i2);
        }
    }

    public final void g(int i2, boolean z) {
        if (this.j <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (currentTimeMillis - this.f71204i < 10000) {
                    return;
                }
            }
            this.f71204i = currentTimeMillis;
            d.o.a.e.b.c.a.h("RetryScheduler", "scheduleAllTaskRetry, level = [" + i2 + "], force = [" + z + "]");
            if (z) {
                this.f71201f.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i2;
            obtain.arg2 = z ? 1 : 0;
            this.f71201f.sendMessageDelayed(obtain, 2000L);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            r(message.arg1, message.arg2 == 1);
        } else {
            d.o.a.e.b.c.a.h("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            e(message.what);
        }
        return true;
    }

    public void k(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(d.o.a.e.b.d.c.f70964a) || !d.o.a.e.b.d.c.f70964a.equals(downloadInfo.m0())) {
            return;
        }
        l(downloadInfo, downloadInfo.K1() || downloadInfo.L1(), A());
    }

    public final void l(DownloadInfo downloadInfo, boolean z, int i2) {
        BaseException U = downloadInfo.U();
        if (U == null) {
            return;
        }
        d q = q(downloadInfo.c0());
        if (q.f71220i > q.f71214c) {
            d.o.a.e.b.c.a.i("RetryScheduler", "tryStartScheduleRetry, id = " + q.f71212a + ", mRetryCount = " + q.f71220i + ", maxCount = " + q.f71214c);
            return;
        }
        int errorCode = U.getErrorCode();
        if (!d.o.a.e.b.l.e.M0(U) && !d.o.a.e.b.l.e.P0(U) && (!downloadInfo.k3() || !downloadInfo.L1())) {
            if (!m(q, errorCode)) {
                return;
            }
            d.o.a.e.b.c.a.h("RetryScheduler", "allow error code, id = " + q.f71212a + ", error code = " + errorCode);
        }
        q.j = z;
        synchronized (this.f71202g) {
            if (!q.l) {
                q.l = true;
                this.j++;
            }
        }
        int j = q.j();
        d.o.a.e.b.c.a.h("RetryScheduler", "tryStartScheduleRetry: id = " + q.f71212a + ", delayTimeMills = " + j + ", mWaitingRetryTasks = " + this.j);
        if (!q.f71217f) {
            if (z) {
                return;
            }
            this.f71201f.removeMessages(downloadInfo.c0());
            this.f71201f.sendEmptyMessageDelayed(downloadInfo.c0(), j);
            return;
        }
        if (i2 == 0) {
            q.i();
        }
        e eVar = m;
        if (eVar != null) {
            eVar.a(downloadInfo, j, z, i2);
        }
        if (this.f71203h) {
            q.c(System.currentTimeMillis());
            q.f();
            q.b();
        }
    }

    public final boolean m(d dVar, int i2) {
        int[] iArr = dVar.f71218g;
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean n(DownloadInfo downloadInfo, BaseException baseException) {
        long j;
        long Q0;
        try {
            j = d.o.a.e.b.l.e.w0(downloadInfo.N0());
        } catch (BaseException e2) {
            e2.printStackTrace();
            j = 0;
        }
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
            Q0 = ((com.ss.android.socialbase.downloader.exception.d) baseException).b();
        } else {
            Q0 = downloadInfo.Q0() - downloadInfo.E();
        }
        if (j < Q0) {
            d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(downloadInfo.c0());
            if (d2.b("space_fill_part_download", 0) == 1) {
                if (j > 0) {
                    int b2 = d2.b("space_fill_min_keep_mb", 100);
                    if (b2 > 0) {
                        long j2 = j - (b2 * 1048576);
                        d.o.a.e.b.c.a.h("RetryScheduler", "retry schedule: available = " + d.o.a.e.b.l.e.a(j) + "MB, minKeep = " + b2 + "MB, canDownload = " + d.o.a.e.b.l.e.a(j2) + "MB");
                        if (j2 <= 0) {
                            d.o.a.e.b.c.a.i("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (d2.b("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }

    public final int[] o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length <= 0) {
                return null;
            }
            int[] iArr = new int[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                iArr[i2] = Integer.parseInt(split[i2]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final d q(int i2) {
        d dVar = this.f71202g.get(i2);
        if (dVar == null) {
            synchronized (this.f71202g) {
                dVar = this.f71202g.get(i2);
                if (dVar == null) {
                    dVar = v(i2);
                }
                this.f71202g.put(i2, dVar);
            }
        }
        return dVar;
    }

    public final void r(int i2, boolean z) {
        d.o.a.e.b.g.d.w0().execute(new b(i2, z));
    }

    public final void t(int i2) {
        synchronized (this.f71202g) {
            this.f71202g.remove(i2);
        }
    }

    public final d v(int i2) {
        int[] iArr;
        int i3;
        int i4;
        boolean z;
        d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(i2);
        boolean z2 = false;
        int b2 = d2.b("retry_schedule", 0);
        JSONObject u = d2.u("retry_schedule_config");
        int i5 = 60;
        if (u != null) {
            int optInt = u.optInt("max_count", 60);
            int optInt2 = u.optInt("interval_sec", 60);
            int optInt3 = u.optInt("interval_sec_acceleration", 60);
            if (Build.VERSION.SDK_INT >= 21 && m != null && u.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArr = o(u.optString("allow_error_code"));
            i3 = optInt3;
            z = z2;
            i4 = optInt;
            i5 = optInt2;
        } else {
            iArr = null;
            i3 = 60;
            i4 = 60;
            z = false;
        }
        return new d(i2, b2, i4, i5 * 1000, i3 * 1000, z, iArr);
    }

    public void w() {
        g(2, true);
    }

    public void y() {
        g(5, false);
    }

    public final void z() {
        if (d.o.a.e.b.j.a.r().b("use_network_callback", 0) != 1) {
            return;
        }
        d.o.a.e.b.g.d.w0().execute(new a());
    }

    @Override // d.o.a.e.b.a.a.b
    public void b() {
        g(4, false);
    }
}
