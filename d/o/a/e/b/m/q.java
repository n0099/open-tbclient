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
    public final boolean f67175h;
    public long i;
    public ConnectivityManager k;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f67173f = new Handler(Looper.getMainLooper(), this);

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<d> f67174g = new SparseArray<>();
    public int j = 0;

    /* renamed from: e  reason: collision with root package name */
    public final Context f67172e = d.o.a.e.b.g.d.l();

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: d.o.a.e.b.m.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1850a extends ConnectivityManager.NetworkCallback {
            public C1850a() {
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
                if (q.this.f67172e == null || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                q.this.k = (ConnectivityManager) q.this.f67172e.getApplicationContext().getSystemService("connectivity");
                q.this.k.registerNetworkCallback(new NetworkRequest.Builder().build(), new C1850a());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f67178e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f67179f;

        public b(int i, boolean z) {
            this.f67178e = i;
            this.f67179f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int A;
            try {
                if (q.this.j > 0 && (A = q.this.A()) != 0) {
                    d.o.a.e.b.c.a.h("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + q.this.j);
                    long currentTimeMillis = System.currentTimeMillis();
                    ArrayList<d> arrayList = new ArrayList();
                    synchronized (q.this.f67174g) {
                        for (int i = 0; i < q.this.f67174g.size(); i++) {
                            d dVar = (d) q.this.f67174g.valueAt(i);
                            if (dVar != null && dVar.d(currentTimeMillis, this.f67178e, A, this.f67179f)) {
                                if (this.f67179f) {
                                    dVar.i();
                                }
                                arrayList.add(dVar);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        for (d dVar2 : arrayList) {
                            q.this.f(dVar2.f67183a, A, false);
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
        public final /* synthetic */ int f67181e;

        public c(int i) {
            this.f67181e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                q.this.f(this.f67181e, q.this.A(), true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f67183a;

        /* renamed from: b  reason: collision with root package name */
        public final int f67184b;

        /* renamed from: c  reason: collision with root package name */
        public final int f67185c;

        /* renamed from: d  reason: collision with root package name */
        public final int f67186d;

        /* renamed from: e  reason: collision with root package name */
        public final int f67187e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f67188f;

        /* renamed from: g  reason: collision with root package name */
        public final int[] f67189g;

        /* renamed from: h  reason: collision with root package name */
        public int f67190h;
        public int i;
        public boolean j;
        public long k;
        public boolean l;

        public d(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 3000 ? 3000 : i4;
            i5 = i5 < 5000 ? 5000 : i5;
            this.f67183a = i;
            this.f67184b = i2;
            this.f67185c = i3;
            this.f67186d = i4;
            this.f67187e = i5;
            this.f67188f = z;
            this.f67189g = iArr;
            this.f67190h = i4;
        }

        public synchronized void b() {
            this.f67190h += this.f67187e;
        }

        public synchronized void c(long j) {
            this.k = j;
        }

        public boolean d(long j, int i, int i2, boolean z) {
            if (!this.l) {
                d.o.a.e.b.c.a.h("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            } else if (this.f67184b >= i && this.i < this.f67185c) {
                if (!this.j || i2 == 2) {
                    return z || j - this.k >= ((long) this.f67186d);
                }
                return false;
            } else {
                return false;
            }
        }

        public synchronized void f() {
            this.i++;
        }

        public void i() {
            this.f67190h = this.f67186d;
        }

        public int j() {
            return this.f67190h;
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(DownloadInfo downloadInfo, long j, boolean z, int i);
    }

    public q() {
        z();
        this.f67175h = d.o.a.e.b.l.e.n0();
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
                this.k = (ConnectivityManager) this.f67172e.getApplicationContext().getSystemService("connectivity");
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

    public void e(int i) {
        d.o.a.e.b.g.d.w0().execute(new c(i));
    }

    public final void f(int i, int i2, boolean z) {
        d.o.a.e.b.g.q m2;
        boolean z2;
        Context context = this.f67172e;
        if (context == null) {
            return;
        }
        synchronized (this.f67174g) {
            d dVar = this.f67174g.get(i);
            if (dVar == null) {
                return;
            }
            boolean z3 = true;
            if (dVar.l) {
                dVar.l = false;
                int i3 = this.j - 1;
                this.j = i3;
                if (i3 < 0) {
                    this.j = 0;
                }
            }
            d.o.a.e.b.c.a.h("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i + ", retryCount = " + dVar.i + ", mWaitingRetryTasksCount = " + this.j);
            DownloadInfo f2 = d.o.a.e.b.g.a.l(context).f(i);
            if (f2 == null) {
                t(i);
                return;
            }
            d.o.a.e.b.c.a.j("RetryScheduler", "doSchedulerRetryInSubThread，id:" + i);
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
                    t(i);
                    return;
                } else if (z0 != -1) {
                    return;
                } else {
                    if (i2 != 0) {
                        z2 = true;
                    } else if (!dVar.f67188f) {
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
                        d.o.a.e.b.c.a.h("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + dVar.f67183a);
                        dVar.c(System.currentTimeMillis());
                        if (z) {
                            dVar.b();
                        }
                        f2.W2(dVar.i);
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
                    l(f2, z3, i2);
                    return;
                }
            }
            t(i);
        }
    }

    public final void g(int i, boolean z) {
        if (this.j <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (currentTimeMillis - this.i < 10000) {
                    return;
                }
            }
            this.i = currentTimeMillis;
            d.o.a.e.b.c.a.h("RetryScheduler", "scheduleAllTaskRetry, level = [" + i + "], force = [" + z + "]");
            if (z) {
                this.f67173f.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i;
            obtain.arg2 = z ? 1 : 0;
            this.f67173f.sendMessageDelayed(obtain, 2000L);
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
        if (downloadInfo == null || TextUtils.isEmpty(d.o.a.e.b.d.c.f66953a) || !d.o.a.e.b.d.c.f66953a.equals(downloadInfo.m0())) {
            return;
        }
        l(downloadInfo, downloadInfo.K1() || downloadInfo.L1(), A());
    }

    public final void l(DownloadInfo downloadInfo, boolean z, int i) {
        BaseException U = downloadInfo.U();
        if (U == null) {
            return;
        }
        d q = q(downloadInfo.c0());
        if (q.i > q.f67185c) {
            d.o.a.e.b.c.a.i("RetryScheduler", "tryStartScheduleRetry, id = " + q.f67183a + ", mRetryCount = " + q.i + ", maxCount = " + q.f67185c);
            return;
        }
        int errorCode = U.getErrorCode();
        if (!d.o.a.e.b.l.e.M0(U) && !d.o.a.e.b.l.e.P0(U) && (!downloadInfo.k3() || !downloadInfo.L1())) {
            if (!m(q, errorCode)) {
                return;
            }
            d.o.a.e.b.c.a.h("RetryScheduler", "allow error code, id = " + q.f67183a + ", error code = " + errorCode);
        }
        q.j = z;
        synchronized (this.f67174g) {
            if (!q.l) {
                q.l = true;
                this.j++;
            }
        }
        int j = q.j();
        d.o.a.e.b.c.a.h("RetryScheduler", "tryStartScheduleRetry: id = " + q.f67183a + ", delayTimeMills = " + j + ", mWaitingRetryTasks = " + this.j);
        if (!q.f67188f) {
            if (z) {
                return;
            }
            this.f67173f.removeMessages(downloadInfo.c0());
            this.f67173f.sendEmptyMessageDelayed(downloadInfo.c0(), j);
            return;
        }
        if (i == 0) {
            q.i();
        }
        e eVar = m;
        if (eVar != null) {
            eVar.a(downloadInfo, j, z, i);
        }
        if (this.f67175h) {
            q.c(System.currentTimeMillis());
            q.f();
            q.b();
        }
    }

    public final boolean m(d dVar, int i) {
        int[] iArr = dVar.f67189g;
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 == i) {
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
            for (int i = 0; i < split.length; i++) {
                iArr[i] = Integer.parseInt(split[i]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final d q(int i) {
        d dVar = this.f67174g.get(i);
        if (dVar == null) {
            synchronized (this.f67174g) {
                dVar = this.f67174g.get(i);
                if (dVar == null) {
                    dVar = v(i);
                }
                this.f67174g.put(i, dVar);
            }
        }
        return dVar;
    }

    public final void r(int i, boolean z) {
        d.o.a.e.b.g.d.w0().execute(new b(i, z));
    }

    public final void t(int i) {
        synchronized (this.f67174g) {
            this.f67174g.remove(i);
        }
    }

    public final d v(int i) {
        int[] iArr;
        int i2;
        int i3;
        boolean z;
        d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(i);
        boolean z2 = false;
        int b2 = d2.b("retry_schedule", 0);
        JSONObject u = d2.u("retry_schedule_config");
        int i4 = 60;
        if (u != null) {
            int optInt = u.optInt("max_count", 60);
            int optInt2 = u.optInt("interval_sec", 60);
            int optInt3 = u.optInt("interval_sec_acceleration", 60);
            if (Build.VERSION.SDK_INT >= 21 && m != null && u.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArr = o(u.optString("allow_error_code"));
            i2 = optInt3;
            z = z2;
            i3 = optInt;
            i4 = optInt2;
        } else {
            iArr = null;
            i2 = 60;
            i3 = 60;
            z = false;
        }
        return new d(i, b2, i3, i4 * 1000, i2 * 1000, z, iArr);
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
