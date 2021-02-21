package com.ss.android.socialbase.downloader.impls;

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
import com.ss.android.socialbase.downloader.a.a;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r implements Handler.Callback, a.InterfaceC1233a {
    private static volatile r qhA;
    private final boolean e;
    private long f;
    private ConnectivityManager qhB;
    private final Handler c = new Handler(Looper.getMainLooper(), this);
    private final SparseArray<a> d = new SparseArray<>();
    private int g = 0;

    /* renamed from: b  reason: collision with root package name */
    private final Context f13198b = com.ss.android.socialbase.downloader.downloader.b.eGC();

    private r() {
        f();
        this.e = com.ss.android.socialbase.downloader.m.d.c();
        com.ss.android.socialbase.downloader.a.a.eFY().a(this);
    }

    public static r eIB() {
        if (qhA == null) {
            synchronized (r.class) {
                if (qhA == null) {
                    qhA = new r();
                }
            }
        }
        return qhA;
    }

    private void f() {
        if (com.ss.android.socialbase.downloader.k.a.eIF().a("use_network_callback", 0) == 1) {
            com.ss.android.socialbase.downloader.downloader.b.eGk().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.r.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (r.this.f13198b != null && Build.VERSION.SDK_INT >= 21) {
                            r.this.qhB = (ConnectivityManager) r.this.f13198b.getApplicationContext().getSystemService("connectivity");
                            r.this.qhB.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.r.1.1
                                @Override // android.net.ConnectivityManager.NetworkCallback
                                public void onAvailable(Network network) {
                                    com.ss.android.socialbase.downloader.f.a.b("RetryScheduler", "network onAvailable: ");
                                    r.this.a(1, true);
                                }
                            });
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null && !TextUtils.isEmpty(com.ss.android.socialbase.downloader.b.e.f13074a) && com.ss.android.socialbase.downloader.b.e.f13074a.equals(cVar.eHn())) {
            b(cVar, cVar.x() || cVar.U(), g());
        }
    }

    private void b(com.ss.android.socialbase.downloader.g.c cVar, boolean z, int i) {
        com.ss.android.socialbase.downloader.e.a eHV = cVar.eHV();
        if (eHV != null) {
            a RU = RU(cVar.g());
            if (RU.i > RU.c) {
                com.ss.android.socialbase.downloader.f.a.d("RetryScheduler", "tryStartScheduleRetry, id = " + RU.f13202a + ", mRetryCount = " + RU.i + ", maxCount = " + RU.c);
                return;
            }
            int a2 = eHV.a();
            if (!com.ss.android.socialbase.downloader.m.d.I(eHV) && !com.ss.android.socialbase.downloader.m.d.J(eHV) && (!cVar.eHf() || !cVar.U())) {
                if (a(RU, a2)) {
                    com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", "white error code, id = " + RU.f13202a + ", error code = " + a2);
                } else {
                    return;
                }
            }
            RU.j = z;
            synchronized (this.d) {
                if (!RU.l) {
                    RU.l = true;
                    this.g++;
                }
            }
            int d = RU.d();
            com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", "tryStartScheduleRetry: id = " + RU.f13202a + ", delayTimeMills = " + d + ", mWaitingRetryTasks = " + this.g);
            if (RU.f) {
                if (i == 0) {
                    RU.c();
                }
                RetryJobSchedulerService.a(cVar, d, z, i);
                if (this.e) {
                    RU.a(System.currentTimeMillis());
                    RU.b();
                    RU.a();
                }
            } else if (!z) {
                this.c.removeMessages(cVar.g());
                this.c.sendEmptyMessageDelayed(cVar.g(), d);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            b(message.arg1, message.arg2 == 1);
        } else {
            com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            a(message.what);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z) {
        if (this.g > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                if (!z) {
                    if (currentTimeMillis - this.f < 20000) {
                    }
                }
                this.f = currentTimeMillis;
                com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", "scheduleAllTaskRetry, level = [" + i + "], force = [" + z + "]");
                if (z) {
                    this.c.removeMessages(0);
                }
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.arg1 = i;
                obtain.arg2 = z ? 1 : 0;
                this.c.sendMessageDelayed(obtain, 2000L);
            }
        }
    }

    private void b(final int i, final boolean z) {
        com.ss.android.socialbase.downloader.downloader.b.eGk().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.r.2
            @Override // java.lang.Runnable
            public void run() {
                int g;
                try {
                    if (r.this.g > 0 && (g = r.this.g()) != 0) {
                        com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + r.this.g);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList<a> arrayList = new ArrayList();
                        synchronized (r.this.d) {
                            for (int i2 = 0; i2 < r.this.d.size(); i2++) {
                                a aVar = (a) r.this.d.valueAt(i2);
                                if (aVar != null && aVar.a(currentTimeMillis, i, g, z)) {
                                    if (z) {
                                        aVar.c();
                                    }
                                    arrayList.add(aVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            for (a aVar2 : arrayList) {
                                r.this.a(aVar2.f13202a, g, false);
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i) {
        com.ss.android.socialbase.downloader.downloader.b.eGk().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.r.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    r.this.a(i, r.this.g(), true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, boolean z) {
        com.ss.android.socialbase.downloader.downloader.r eGH;
        boolean z2;
        boolean z3 = false;
        Context context = this.f13198b;
        if (context != null) {
            synchronized (this.d) {
                a aVar = this.d.get(i);
                if (aVar == null) {
                    return;
                }
                if (aVar.l) {
                    aVar.l = false;
                    this.g--;
                    if (this.g < 0) {
                        this.g = 0;
                    }
                }
                com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i + ", retryCount = " + aVar.i + ", mWaitingRetryTasksCount = " + this.g);
                com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.downloader.f.iB(context).h(i);
                if (h == null) {
                    c(i);
                    return;
                }
                com.ss.android.socialbase.downloader.f.a.e("RetryScheduler", "doSchedulerRetryInSubThread，id:" + i);
                int w = h.w();
                if (w == -3 || w == -4) {
                    c(i);
                } else if (w == -5 || (w == -2 && h.U())) {
                    if (w == -2 && (eGH = com.ss.android.socialbase.downloader.downloader.f.iB(com.ss.android.socialbase.downloader.downloader.b.eGC()).eGH()) != null) {
                        eGH.a(h, 4, 3);
                    }
                    com.ss.android.socialbase.downloader.downloader.m eGr = com.ss.android.socialbase.downloader.downloader.b.eGr();
                    if (eGr != null) {
                        eGr.a(Collections.singletonList(h), 3);
                    }
                    c(i);
                } else if (w == -1) {
                    if (i2 != 0) {
                        z2 = true;
                    } else if (!aVar.f) {
                        return;
                    } else {
                        z2 = false;
                    }
                    com.ss.android.socialbase.downloader.e.a eHV = h.eHV();
                    if (z2 && com.ss.android.socialbase.downloader.m.d.I(eHV)) {
                        z2 = d(h, eHV);
                    }
                    aVar.b();
                    if (z2) {
                        com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + aVar.f13202a);
                        aVar.a(System.currentTimeMillis());
                        if (z) {
                            aVar.a();
                        }
                        h.b(aVar.i);
                        if (h.q() == -1) {
                            com.ss.android.socialbase.downloader.downloader.f.iB(context).e(h.g());
                            return;
                        }
                        return;
                    }
                    if (z) {
                        aVar.a();
                    }
                    if (h.x() || h.U()) {
                        z3 = true;
                    }
                    b(h, z3, i2);
                }
            }
        }
    }

    private boolean a(a aVar, int i) {
        int[] iArr = aVar.g;
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private a RU(int i) {
        a aVar = this.d.get(i);
        if (aVar == null) {
            synchronized (this.d) {
                aVar = this.d.get(i);
                if (aVar == null) {
                    aVar = RV(i);
                }
                this.d.put(i, aVar);
            }
        }
        return aVar;
    }

    private void c(int i) {
        synchronized (this.d) {
            this.d.remove(i);
        }
    }

    private a RV(int i) {
        int[] iArr;
        boolean z;
        int i2;
        int i3;
        int i4;
        boolean z2 = true;
        com.ss.android.socialbase.downloader.k.a RW = com.ss.android.socialbase.downloader.k.a.RW(i);
        int a2 = RW.a("retry_schedule", 0);
        JSONObject abH = RW.abH("retry_schedule_config");
        if (abH != null) {
            i4 = abH.optInt("max_count", 60);
            i3 = abH.optInt("interval_sec", 60);
            int optInt = abH.optInt("interval_sec_acceleration", 60);
            if (Build.VERSION.SDK_INT < 21 || abH.optInt("use_job_scheduler", 0) != 1) {
                z2 = false;
            }
            iArr = abG(abH.optString("white_error_code"));
            z = z2;
            i2 = optInt;
        } else {
            iArr = null;
            z = false;
            i2 = 60;
            i3 = 60;
            i4 = 60;
        }
        return new a(i, a2, i4, i3 * 1000, i2 * 1000, z, iArr);
    }

    private int[] abG(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length > 0) {
                int[] iArr = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Integer.parseInt(split[i]);
                }
                return iArr;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1233a
    public void b() {
        a(4, false);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1233a
    public void c() {
        a(3, false);
    }

    public void d() {
        a(2, false);
    }

    public void e() {
        a(5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        try {
            if (this.qhB == null) {
                this.qhB = (ConnectivityManager) this.f13198b.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.qhB.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            return activeNetworkInfo.getType() == 1 ? 2 : 1;
        } catch (Exception e) {
            return 0;
        }
    }

    private boolean d(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar) {
        long j;
        long eir;
        try {
            j = com.ss.android.socialbase.downloader.m.d.c(cVar.l());
        } catch (com.ss.android.socialbase.downloader.e.a e) {
            e.printStackTrace();
            j = 0;
        }
        if (aVar instanceof com.ss.android.socialbase.downloader.e.e) {
            eir = ((com.ss.android.socialbase.downloader.e.e) aVar).d();
        } else {
            eir = cVar.eir() - cVar.eHi();
        }
        if (j < eir) {
            com.ss.android.socialbase.downloader.k.a RW = com.ss.android.socialbase.downloader.k.a.RW(cVar.g());
            if (RW.a("space_fill_part_download", 0) != 1) {
                return false;
            }
            if (j > 0) {
                int a2 = RW.a("space_fill_min_keep_mb", 100);
                if (a2 > 0) {
                    long j2 = j - (a2 * 1048576);
                    com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", "retry schedule: available = " + com.ss.android.socialbase.downloader.m.d.a(j) + "MB, minKeep = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.m.d.a(j2) + "MB");
                    if (j2 <= 0) {
                        com.ss.android.socialbase.downloader.f.a.d("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                        return false;
                    }
                }
            } else if (RW.a("download_when_space_negative", 0) != 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f13202a;

        /* renamed from: b  reason: collision with root package name */
        final int f13203b;
        final int c;
        final int d;
        final int e;
        final boolean f;
        final int[] g;
        private int h;
        private int i;
        private boolean j;
        private long k;
        private boolean l;

        a(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 20000 ? 20000 : i4;
            i5 = i5 < 20000 ? 20000 : i5;
            this.f13202a = i;
            this.f13203b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = z;
            this.g = iArr;
            this.h = i4;
        }

        boolean a(long j, int i, int i2, boolean z) {
            if (!this.l) {
                com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            } else if (this.f13203b < i || this.i >= this.c) {
                return false;
            } else {
                if (!this.j || i2 == 2) {
                    return z || j - this.k >= ((long) this.d);
                }
                return false;
            }
        }

        synchronized void a() {
            this.h += this.e;
        }

        synchronized void a(long j) {
            this.k = j;
        }

        synchronized void b() {
            this.i++;
        }

        void c() {
            this.h = this.d;
        }

        int d() {
            return this.h;
        }
    }
}
