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
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r implements Handler.Callback, a.InterfaceC2203a {
    public static volatile r a;

    /* renamed from: i  reason: collision with root package name */
    public static b f60226i;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f60230e;

    /* renamed from: f  reason: collision with root package name */
    public long f60231f;

    /* renamed from: h  reason: collision with root package name */
    public ConnectivityManager f60233h;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f60228c = new Handler(Looper.getMainLooper(), this);

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<a> f60229d = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public int f60232g = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Context f60227b = com.ss.android.socialbase.downloader.downloader.c.N();

    /* loaded from: classes4.dex */
    public static class a {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f60237b;

        /* renamed from: c  reason: collision with root package name */
        public final int f60238c;

        /* renamed from: d  reason: collision with root package name */
        public final int f60239d;

        /* renamed from: e  reason: collision with root package name */
        public final int f60240e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f60241f;

        /* renamed from: g  reason: collision with root package name */
        public final int[] f60242g;

        /* renamed from: h  reason: collision with root package name */
        public int f60243h;

        /* renamed from: i  reason: collision with root package name */
        public int f60244i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f60245j;
        public long k;
        public boolean l;

        public a(int i2, int i3, int i4, int i5, int i6, boolean z, int[] iArr) {
            i5 = i5 < 3000 ? 3000 : i5;
            i6 = i6 < 5000 ? 5000 : i6;
            this.a = i2;
            this.f60237b = i3;
            this.f60238c = i4;
            this.f60239d = i5;
            this.f60240e = i6;
            this.f60241f = z;
            this.f60242g = iArr;
            this.f60243h = i5;
        }

        public void c() {
            this.f60243h = this.f60239d;
        }

        public int d() {
            return this.f60243h;
        }

        public boolean a(long j2, int i2, int i3, boolean z) {
            if (!this.l) {
                com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            } else if (this.f60237b >= i2 && this.f60244i < this.f60238c) {
                if (!this.f60245j || i3 == 2) {
                    return z || j2 - this.k >= ((long) this.f60239d);
                }
                return false;
            } else {
                return false;
            }
        }

        public synchronized void b() {
            this.f60244i++;
        }

        public synchronized void a() {
            this.f60243h += this.f60240e;
        }

        public synchronized void a(long j2) {
            this.k = j2;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(DownloadInfo downloadInfo, long j2, boolean z, int i2);
    }

    public r() {
        f();
        this.f60230e = com.ss.android.socialbase.downloader.i.f.c();
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    private void f() {
        if (com.ss.android.socialbase.downloader.g.a.c().a("use_network_callback", 0) != 1) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.r.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (r.this.f60227b == null || Build.VERSION.SDK_INT < 21) {
                        return;
                    }
                    r.this.f60233h = (ConnectivityManager) r.this.f60227b.getApplicationContext().getSystemService("connectivity");
                    r.this.f60233h.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.r.1.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            com.ss.android.socialbase.downloader.c.a.b("RetryScheduler", "network onAvailable: ");
                            r.this.a(1, true);
                        }
                    });
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        try {
            if (this.f60233h == null) {
                this.f60233h = (ConnectivityManager) this.f60227b.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.f60233h.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            b(message.arg1, message.arg2 == 1);
        } else {
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            a(message.what);
        }
        return true;
    }

    private void b(final int i2, final boolean z) {
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.r.2
            @Override // java.lang.Runnable
            public void run() {
                int g2;
                try {
                    if (r.this.f60232g > 0 && (g2 = r.this.g()) != 0) {
                        com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + r.this.f60232g);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList<a> arrayList = new ArrayList();
                        synchronized (r.this.f60229d) {
                            for (int i3 = 0; i3 < r.this.f60229d.size(); i3++) {
                                a aVar = (a) r.this.f60229d.valueAt(i3);
                                if (aVar != null && aVar.a(currentTimeMillis, i2, g2, z)) {
                                    if (z) {
                                        aVar.c();
                                    }
                                    arrayList.add(aVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            for (a aVar2 : arrayList) {
                                r.this.a(aVar2.a, g2, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private void c(int i2) {
        synchronized (this.f60229d) {
            this.f60229d.remove(i2);
        }
    }

    private a d(int i2) {
        int[] iArr;
        int i3;
        int i4;
        boolean z;
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(i2);
        boolean z2 = false;
        int a3 = a2.a("retry_schedule", 0);
        JSONObject d2 = a2.d("retry_schedule_config");
        int i5 = 60;
        if (d2 != null) {
            int optInt = d2.optInt("max_count", 60);
            int optInt2 = d2.optInt("interval_sec", 60);
            int optInt3 = d2.optInt("interval_sec_acceleration", 60);
            if (Build.VERSION.SDK_INT >= 21 && f60226i != null && d2.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArr = a(d2.optString("allow_error_code"));
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
        return new a(i2, a3, i4, i5 * 1000, i3 * 1000, z, iArr);
    }

    public void e() {
        a(5, false);
    }

    private a b(int i2) {
        a aVar = this.f60229d.get(i2);
        if (aVar == null) {
            synchronized (this.f60229d) {
                aVar = this.f60229d.get(i2);
                if (aVar == null) {
                    aVar = d(i2);
                }
                this.f60229d.put(i2, aVar);
            }
        }
        return aVar;
    }

    public static r a() {
        if (a == null) {
            synchronized (r.class) {
                if (a == null) {
                    a = new r();
                }
            }
        }
        return a;
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2203a
    public void c() {
        a(3, false);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2203a
    public void b() {
        a(4, false);
    }

    public static void a(b bVar) {
        f60226i = bVar;
    }

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.e.a) || !com.ss.android.socialbase.downloader.constants.e.a.equals(downloadInfo.getMimeType())) {
            return;
        }
        a(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), g());
    }

    public void d() {
        a(2, true);
    }

    private void a(DownloadInfo downloadInfo, boolean z, int i2) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        a b2 = b(downloadInfo.getId());
        if (b2.f60244i > b2.f60238c) {
            com.ss.android.socialbase.downloader.c.a.d("RetryScheduler", "tryStartScheduleRetry, id = " + b2.a + ", mRetryCount = " + b2.f60244i + ", maxCount = " + b2.f60238c);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!com.ss.android.socialbase.downloader.i.f.h(failedException) && !com.ss.android.socialbase.downloader.i.f.i(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!a(b2, errorCode)) {
                return;
            }
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "allow error code, id = " + b2.a + ", error code = " + errorCode);
        }
        b2.f60245j = z;
        synchronized (this.f60229d) {
            if (!b2.l) {
                b2.l = true;
                this.f60232g++;
            }
        }
        int d2 = b2.d();
        com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "tryStartScheduleRetry: id = " + b2.a + ", delayTimeMills = " + d2 + ", mWaitingRetryTasks = " + this.f60232g);
        if (!b2.f60241f) {
            if (z) {
                return;
            }
            this.f60228c.removeMessages(downloadInfo.getId());
            this.f60228c.sendEmptyMessageDelayed(downloadInfo.getId(), d2);
            return;
        }
        if (i2 == 0) {
            b2.c();
        }
        b bVar = f60226i;
        if (bVar != null) {
            bVar.a(downloadInfo, d2, z, i2);
        }
        if (this.f60230e) {
            b2.a(System.currentTimeMillis());
            b2.b();
            b2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z) {
        if (this.f60232g <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (currentTimeMillis - this.f60231f < 10000) {
                    return;
                }
            }
            this.f60231f = currentTimeMillis;
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "scheduleAllTaskRetry, level = [" + i2 + "], force = [" + z + PreferencesUtil.RIGHT_MOUNT);
            if (z) {
                this.f60228c.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i2;
            obtain.arg2 = z ? 1 : 0;
            this.f60228c.sendMessageDelayed(obtain, 2000L);
        }
    }

    public void a(final int i2) {
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.r.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    r.this.a(i2, r.this.g(), true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, boolean z) {
        com.ss.android.socialbase.downloader.downloader.r reserveWifiStatusListener;
        boolean z2;
        Context context = this.f60227b;
        if (context == null) {
            return;
        }
        synchronized (this.f60229d) {
            a aVar = this.f60229d.get(i2);
            if (aVar == null) {
                return;
            }
            boolean z3 = true;
            if (aVar.l) {
                aVar.l = false;
                int i4 = this.f60232g - 1;
                this.f60232g = i4;
                if (i4 < 0) {
                    this.f60232g = 0;
                }
            }
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i2 + ", retryCount = " + aVar.f60244i + ", mWaitingRetryTasksCount = " + this.f60232g);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
            if (downloadInfo == null) {
                c(i2);
                return;
            }
            com.ss.android.socialbase.downloader.c.a.e("RetryScheduler", "doSchedulerRetryInSubThread，id:" + i2);
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus != -3 && realStatus != -4) {
                if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                    if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener()) != null) {
                        reserveWifiStatusListener.a(downloadInfo, 4, 3);
                    }
                    com.ss.android.socialbase.downloader.downloader.l w = com.ss.android.socialbase.downloader.downloader.c.w();
                    if (w != null) {
                        w.a(Collections.singletonList(downloadInfo), 3);
                    }
                    c(i2);
                    return;
                } else if (realStatus != -1) {
                    return;
                } else {
                    if (i3 != 0) {
                        z2 = true;
                    } else if (!aVar.f60241f) {
                        return;
                    } else {
                        z2 = false;
                    }
                    BaseException failedException = downloadInfo.getFailedException();
                    if (z2 && com.ss.android.socialbase.downloader.i.f.h(failedException)) {
                        z2 = a(downloadInfo, failedException);
                    }
                    aVar.b();
                    if (z2) {
                        com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + aVar.a);
                        aVar.a(System.currentTimeMillis());
                        if (z) {
                            aVar.a();
                        }
                        downloadInfo.setRetryScheduleCount(aVar.f60244i);
                        if (downloadInfo.getStatus() == -1) {
                            Downloader.getInstance(context).restart(downloadInfo.getId());
                            return;
                        }
                        return;
                    }
                    if (z) {
                        aVar.a();
                    }
                    if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                        z3 = false;
                    }
                    a(downloadInfo, z3, i3);
                    return;
                }
            }
            c(i2);
        }
    }

    private boolean a(a aVar, int i2) {
        int[] iArr = aVar.f60242g;
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] a(String str) {
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

    private boolean a(DownloadInfo downloadInfo, BaseException baseException) {
        long j2;
        long totalBytes;
        try {
            j2 = com.ss.android.socialbase.downloader.i.f.d(downloadInfo.getTempPath());
        } catch (BaseException e2) {
            e2.printStackTrace();
            j2 = 0;
        }
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
            totalBytes = ((com.ss.android.socialbase.downloader.exception.d) baseException).b();
        } else {
            totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (j2 < totalBytes) {
            com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            if (a2.a("space_fill_part_download", 0) == 1) {
                if (j2 > 0) {
                    int a3 = a2.a("space_fill_min_keep_mb", 100);
                    if (a3 > 0) {
                        long j3 = j2 - (a3 * 1048576);
                        com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "retry schedule: available = " + com.ss.android.socialbase.downloader.i.f.a(j2) + "MB, minKeep = " + a3 + "MB, canDownload = " + com.ss.android.socialbase.downloader.i.f.a(j3) + "MB");
                        if (j3 <= 0) {
                            com.ss.android.socialbase.downloader.c.a.d("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (a2.a("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }
}
