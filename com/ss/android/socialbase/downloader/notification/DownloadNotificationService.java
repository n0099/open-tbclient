package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.util.io.ActionJsonData;
import com.ss.android.socialbase.downloader.b.e;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.downloader.n;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.m.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class DownloadNotificationService extends Service {
    private static volatile long f;
    private static volatile long g;
    private static boolean h;
    private HandlerThread j;
    private Handler k;

    /* renamed from: a  reason: collision with root package name */
    private static final String f7894a = DownloadNotificationService.class.getSimpleName();
    private static int b = -1;
    private static int c = -1;
    private static boolean d = true;
    private static boolean e = false;
    private static long i = 900;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d();
        com.ss.android.socialbase.downloader.downloader.b.a(this);
        com.ss.android.socialbase.downloader.k.a eIH = com.ss.android.socialbase.downloader.k.a.eIH();
        int a2 = eIH.a("download_service_foreground", 0);
        if ((a2 == 1 || a2 == 3) && b == -1) {
            b = 0;
        }
        if ((a2 == 2 || a2 == 3) && c == -1) {
            c = 0;
        }
        e = eIH.b("non_going_notification_foreground", false);
        h = eIH.b("notify_too_fast", false);
        i = eIH.a("notification_time_window", 900L);
        if (i < 0 || i > 1200) {
            i = 900L;
        }
    }

    private void d() {
        if (this.j == null) {
            this.j = new HandlerThread("DownloaderNotifyThread");
            this.j.start();
            this.k = new Handler(this.j.getLooper());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.j != null) {
            try {
                this.j.quit();
            } catch (Throwable th) {
            }
            this.j = null;
            this.k = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        a(intent);
        return 2;
    }

    private void a(final Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && this.k != null) {
                this.k.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectivityManager connectivityManager;
                        NetworkInfo activeNetworkInfo;
                        final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService(ActionJsonData.TAG_NOTIFICATION);
                        final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                        if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                            final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                            int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                            if (intExtra != 0 && notification != null && notificationManager != null) {
                                if (intExtra2 == 4) {
                                    if (f.iC(com.ss.android.socialbase.downloader.downloader.b.eGG()).g(intExtra)) {
                                        c h2 = f.iC(com.ss.android.socialbase.downloader.downloader.b.eGG()).h(intExtra);
                                        if (DownloadNotificationService.h) {
                                            if (h2 != null && h2.a() && System.currentTimeMillis() - DownloadNotificationService.g > DownloadNotificationService.i) {
                                                DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                                                h2.b();
                                            }
                                        } else if (h2 != null && h2.a()) {
                                            DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                                            h2.b();
                                        }
                                    }
                                } else if (intExtra2 == -2 || intExtra2 == -3) {
                                    if (DownloadNotificationService.h) {
                                        DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                                    } else if (DownloadNotificationService.this.k != null) {
                                        DownloadNotificationService.this.k.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                                            }
                                        }, intExtra2 == -2 ? 50L : 200L);
                                    }
                                } else if (DownloadNotificationService.h) {
                                    DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                                } else {
                                    DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                                }
                            }
                        } else if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                            if (intExtra != 0) {
                                DownloadNotificationService.this.a(notificationManager, intExtra);
                            }
                        } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                            try {
                                if (d.a((Context) DownloadNotificationService.this, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                                    ArrayList arrayList = new ArrayList();
                                    if (!TextUtils.isEmpty(e.f7777a)) {
                                        arrayList.add(e.f7777a);
                                    }
                                    arrayList.add("mime_type_plugin");
                                    Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                                    if (applicationContext != null) {
                                        f.iC(applicationContext).a(arrayList);
                                        f.iC(applicationContext).b(arrayList);
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                            try {
                                f.iC(DownloadNotificationService.this).a();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final NotificationManager notificationManager, final int i2, final Notification notification) {
        long currentTimeMillis = i - (System.currentTimeMillis() - f);
        if (currentTimeMillis <= 0) {
            currentTimeMillis = 0;
        }
        long j = currentTimeMillis <= 20000 ? currentTimeMillis : 20000L;
        long currentTimeMillis2 = System.currentTimeMillis() + j;
        g = currentTimeMillis2;
        f = currentTimeMillis2;
        if (j <= 0) {
            b(notificationManager, i2, notification);
        } else if (this.k != null) {
            this.k.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                @Override // java.lang.Runnable
                public void run() {
                    DownloadNotificationService.this.b(notificationManager, i2, notification);
                }
            }, j);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private boolean a(int i2, Notification notification) {
        if (!d || b == i2 || c == i2) {
            return false;
        }
        if (b == 0 || c == 0) {
            if (e && (notification.flags & 2) == 0) {
                return false;
            }
            return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NotificationManager notificationManager, int i2, Notification notification) {
        boolean z = true;
        if (a(i2, notification)) {
            try {
                boolean z2 = com.ss.android.socialbase.downloader.downloader.c.eGK().a(i2) == 1 && !d.c();
                if ((z2 || b != 0) && (!z2 || c != 0)) {
                    z = false;
                }
                if (z) {
                    n Rs = com.ss.android.socialbase.downloader.downloader.c.eGK().Rs(i2);
                    if (Rs.g() && !Rs.b()) {
                        com.ss.android.socialbase.downloader.f.a.c(f7894a, "doNotify, startForeground, ======== id = " + i2 + ", isIndependentProcess = " + z2);
                        if (z2) {
                            c = i2;
                        } else {
                            b = i2;
                        }
                        Rs.a(i2, notification);
                    } else {
                        com.ss.android.socialbase.downloader.f.a.c(f7894a, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = " + z2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if ((b == i2 || c == i2) && e && (notification.flags & 2) == 0) {
            a(notificationManager, i2);
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (f < currentTimeMillis) {
                f = currentTimeMillis;
            }
            notificationManager.notify(i2, notification);
        } catch (Throwable th2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NotificationManager notificationManager, int i2) {
        boolean z;
        int a2;
        a aVar = null;
        if (b == i2 || c == i2) {
            if (b == i2) {
                b = 0;
                z = false;
            } else {
                c = 0;
                z = true;
            }
            try {
                n Rs = com.ss.android.socialbase.downloader.downloader.c.eGK().Rs(i2);
                if (!Rs.b()) {
                    d = false;
                    com.ss.android.socialbase.downloader.f.a.d(f7894a, "try to stopForeground when is not Foreground, id = " + i2 + ", isIndependentProcess = " + z);
                }
                com.ss.android.socialbase.downloader.f.a.c(f7894a, "doCancel, ========== stopForeground id = " + i2 + ", isIndependentProcess = " + z);
                Rs.a(false, true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                notificationManager.cancel(i2);
            } catch (Throwable th2) {
            }
            if (d) {
                try {
                    SparseArray<a> eIL = b.eIK().eIL();
                    if (eIL != null) {
                        int size = eIL.size() - 1;
                        while (true) {
                            if (size < 0) {
                                break;
                            }
                            a valueAt = eIL.valueAt(size);
                            if (valueAt != null && (a2 = valueAt.a()) != i2 && a2 != b && a2 != c && valueAt.i()) {
                                if ((com.ss.android.socialbase.downloader.downloader.c.eGK().a(valueAt.a()) == 1 && !d.c()) == z) {
                                    aVar = valueAt;
                                    break;
                                }
                            }
                            size--;
                        }
                    }
                    if (aVar != null) {
                        int a3 = aVar.a();
                        notificationManager.cancel(a3);
                        boolean z2 = f.iC(this).f(a3) == 1;
                        com.ss.android.socialbase.downloader.f.a.c(f7894a, "doCancel, updateNotification id = " + a3);
                        aVar.a((com.ss.android.socialbase.downloader.e.a) null, z2);
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            notificationManager.cancel(i2);
        } catch (Throwable th4) {
        }
    }
}
