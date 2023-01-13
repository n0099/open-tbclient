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
/* loaded from: classes8.dex */
public class r implements Handler.Callback, a.InterfaceC0693a {
    public static volatile r a;
    public static b i;
    public final boolean e;
    public long f;
    public ConnectivityManager h;
    public final Handler c = new Handler(Looper.getMainLooper(), this);
    public final SparseArray<a> d = new SparseArray<>();
    public int g = 0;
    public final Context b = com.ss.android.socialbase.downloader.downloader.c.N();

    /* loaded from: classes8.dex */
    public interface b {
        void a(DownloadInfo downloadInfo, long j, boolean z, int i);
    }

    public r() {
        f();
        this.e = com.ss.android.socialbase.downloader.i.f.c();
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    public static r a() {
        if (a == null) {
            synchronized (r.class) {
                try {
                    if (a == null) {
                        a = new r();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, boolean z) {
        com.ss.android.socialbase.downloader.downloader.r reserveWifiStatusListener;
        boolean z2;
        Context context = this.b;
        if (context == null) {
            return;
        }
        synchronized (this.d) {
            a aVar = this.d.get(i2);
            if (aVar == null) {
                return;
            }
            boolean z3 = false;
            if (aVar.l) {
                aVar.l = false;
                int i4 = this.g - 1;
                this.g = i4;
                if (i4 < 0) {
                    this.g = 0;
                }
            }
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i2 + ", retryCount = " + aVar.i + ", mWaitingRetryTasksCount = " + this.g);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
            if (downloadInfo == null) {
                c(i2);
                return;
            }
            com.ss.android.socialbase.downloader.c.a.e("RetryScheduler", "doSchedulerRetryInSubThread，id:" + i2);
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus == -3 || realStatus == -4) {
                c(i2);
            } else if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener()) != null) {
                    reserveWifiStatusListener.a(downloadInfo, 4, 3);
                }
                com.ss.android.socialbase.downloader.downloader.l w = com.ss.android.socialbase.downloader.downloader.c.w();
                if (w != null) {
                    w.a(Collections.singletonList(downloadInfo), 3);
                }
                c(i2);
            } else if (realStatus != -1) {
            } else {
                if (i3 != 0) {
                    z2 = true;
                } else if (!aVar.f) {
                    return;
                } else {
                    z2 = false;
                }
                BaseException failedException = downloadInfo.getFailedException();
                if (z2 && com.ss.android.socialbase.downloader.i.f.h(failedException)) {
                    z2 = a(downloadInfo, failedException);
                }
                aVar.b();
                if (!z2) {
                    if (z) {
                        aVar.a();
                    }
                    a(downloadInfo, (downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi()) ? true : true, i3);
                    return;
                }
                com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + aVar.a);
                aVar.a(System.currentTimeMillis());
                if (z) {
                    aVar.a();
                }
                downloadInfo.setRetryScheduleCount(aVar.i);
                if (downloadInfo.getStatus() == -1) {
                    Downloader.getInstance(context).restart(downloadInfo.getId());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z) {
        if (this.g <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (currentTimeMillis - this.f < 10000) {
                    return;
                }
            }
            this.f = currentTimeMillis;
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "scheduleAllTaskRetry, level = [" + i2 + "], force = [" + z + PreferencesUtil.RIGHT_MOUNT);
            if (z) {
                this.c.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i2;
            obtain.arg2 = z ? 1 : 0;
            this.c.sendMessageDelayed(obtain, 2000L);
        }
    }

    public static void a(b bVar) {
        i = bVar;
    }

    private void a(DownloadInfo downloadInfo, boolean z, int i2) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        a b2 = b(downloadInfo.getId());
        if (b2.i > b2.c) {
            com.ss.android.socialbase.downloader.c.a.d("RetryScheduler", "tryStartScheduleRetry, id = " + b2.a + ", mRetryCount = " + b2.i + ", maxCount = " + b2.c);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!com.ss.android.socialbase.downloader.i.f.h(failedException) && !com.ss.android.socialbase.downloader.i.f.i(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!a(b2, errorCode)) {
                return;
            }
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "allow error code, id = " + b2.a + ", error code = " + errorCode);
        }
        b2.j = z;
        synchronized (this.d) {
            if (!b2.l) {
                b2.l = true;
                this.g++;
            }
        }
        int d = b2.d();
        com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "tryStartScheduleRetry: id = " + b2.a + ", delayTimeMills = " + d + ", mWaitingRetryTasks = " + this.g);
        if (!b2.f) {
            if (z) {
                return;
            }
            this.c.removeMessages(downloadInfo.getId());
            this.c.sendEmptyMessageDelayed(downloadInfo.getId(), d);
            return;
        }
        if (i2 == 0) {
            b2.c();
        }
        b bVar = i;
        if (bVar != null) {
            bVar.a(downloadInfo, d, z, i2);
        }
        if (this.e) {
            b2.a(System.currentTimeMillis());
            b2.b();
            b2.a();
        }
    }

    private boolean a(a aVar, int i2) {
        int[] iArr = aVar.g;
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(DownloadInfo downloadInfo, BaseException baseException) {
        long j;
        try {
            j = com.ss.android.socialbase.downloader.i.f.d(downloadInfo.getTempPath());
        } catch (BaseException e) {
            e.printStackTrace();
            j = 0;
        }
        if (j < (baseException instanceof com.ss.android.socialbase.downloader.exception.d ? ((com.ss.android.socialbase.downloader.exception.d) baseException).b() : downloadInfo.getTotalBytes() - downloadInfo.getCurBytes())) {
            com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            if (a2.a("space_fill_part_download", 0) == 1) {
                if (j > 0) {
                    int a3 = a2.a("space_fill_min_keep_mb", 100);
                    if (a3 > 0) {
                        long j2 = j - (a3 * 1048576);
                        com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "retry schedule: available = " + com.ss.android.socialbase.downloader.i.f.a(j) + "MB, minKeep = " + a3 + "MB, canDownload = " + com.ss.android.socialbase.downloader.i.f.a(j2) + "MB");
                        if (j2 <= 0) {
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

    private a b(int i2) {
        a aVar = this.d.get(i2);
        if (aVar == null) {
            synchronized (this.d) {
                aVar = this.d.get(i2);
                if (aVar == null) {
                    aVar = d(i2);
                }
                this.d.put(i2, aVar);
            }
        }
        return aVar;
    }

    private void b(final int i2, final boolean z) {
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.r.2
            @Override // java.lang.Runnable
            public void run() {
                int g;
                try {
                    if (r.this.g <= 0 || (g = r.this.g()) == 0) {
                        return;
                    }
                    com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + r.this.g);
                    long currentTimeMillis = System.currentTimeMillis();
                    ArrayList<a> arrayList = new ArrayList();
                    synchronized (r.this.d) {
                        for (int i3 = 0; i3 < r.this.d.size(); i3++) {
                            a aVar = (a) r.this.d.valueAt(i3);
                            if (aVar != null && aVar.a(currentTimeMillis, i2, g, z)) {
                                if (z) {
                                    aVar.c();
                                }
                                arrayList.add(aVar);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        for (a aVar2 : arrayList) {
                            r.this.a(aVar2.a, g, false);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private void c(int i2) {
        synchronized (this.d) {
            this.d.remove(i2);
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
        JSONObject d = a2.d("retry_schedule_config");
        int i5 = 60;
        if (d != null) {
            int optInt = d.optInt("max_count", 60);
            int optInt2 = d.optInt("interval_sec", 60);
            int optInt3 = d.optInt("interval_sec_acceleration", 60);
            if (Build.VERSION.SDK_INT >= 21 && i != null && d.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArr = a(d.optString("allow_error_code"));
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

    private void f() {
        if (com.ss.android.socialbase.downloader.g.a.c().a("use_network_callback", 0) != 1) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.r.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (r.this.b != null && Build.VERSION.SDK_INT >= 21) {
                        r.this.h = (ConnectivityManager) r.this.b.getApplicationContext().getSystemService("connectivity");
                        r.this.h.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.r.1.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public void onAvailable(Network network) {
                                com.ss.android.socialbase.downloader.c.a.b("RetryScheduler", "network onAvailable: ");
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

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        try {
            if (this.h == null) {
                this.h = (ConnectivityManager) this.b.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.h.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0000, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String r1654612903244dc(String str) {
        while (true) {
            char c = 'I';
            char c2 = '`';
            while (true) {
                switch (c) {
                    case 'H':
                        c = 'J';
                        c2 = '7';
                    case 'I':
                        switch (c2) {
                            case '_':
                            case '`':
                                c = 'J';
                                c2 = '7';
                        }
                        break;
                    case 'J':
                        break;
                    default:
                        c = 'H';
                }
                switch (c2) {
                    case '7':
                        char[] charArray = str.toCharArray();
                        for (int i2 = 0; i2 < charArray.length; i2++) {
                            charArray[i2] = (char) (charArray[i2] ^ i2);
                        }
                        return new String(charArray);
                }
            }
        }
    }

    public void a(final int i2) {
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.r.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    r.this.a(i2, r.this.g(), true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.e.a) || !com.ss.android.socialbase.downloader.constants.e.a.equals(downloadInfo.getMimeType())) {
            return;
        }
        a(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), g());
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0693a
    public void b() {
        a(4, false);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0693a
    public void c() {
        a(3, false);
    }

    public void d() {
        a(2, true);
    }

    public void e() {
        a(5, false);
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

    /* loaded from: classes8.dex */
    public static class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final boolean f;
        public final int[] g;
        public int h;
        public int i;
        public boolean j;
        public long k;
        public boolean l;

        public a(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 3000 ? 3000 : i4;
            i5 = i5 < 5000 ? 5000 : i5;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = z;
            this.g = iArr;
            this.h = i4;
        }

        public synchronized void a() {
            this.h += this.e;
        }

        public synchronized void b() {
            this.i++;
        }

        public void c() {
            this.h = this.d;
        }

        public int d() {
            return this.h;
        }

        public synchronized void a(long j) {
            this.k = j;
        }

        public boolean a(long j, int i, int i2, boolean z) {
            if (!this.l) {
                com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            } else if (this.b < i || this.i >= this.c) {
                return false;
            } else {
                if (this.j && i2 != 2) {
                    return false;
                }
                if (!z && j - this.k < this.d) {
                    return false;
                }
                return true;
            }
        }
    }
}
