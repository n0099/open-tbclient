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
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.e.b.d.c;
import d.p.a.e.b.g.d;
import d.p.a.e.b.g.m;
import d.p.a.e.b.l.e;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class DownloadNotificationService extends Service {

    /* renamed from: f  reason: collision with root package name */
    public static volatile long f39345f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile long f39346g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f39347h;
    public HandlerThread j;
    public Handler k;
    public final SparseArray<Notification> l = new SparseArray<>(2);

    /* renamed from: a  reason: collision with root package name */
    public static final String f39340a = DownloadNotificationService.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static int f39341b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static int f39342c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f39343d = true;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f39344e = false;
    public static long i = 900;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f39348e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f39349f;

        /* renamed from: com.ss.android.socialbase.downloader.notification.DownloadNotificationService$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0521a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ NotificationManager f39351e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f39352f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Notification f39353g;

            public RunnableC0521a(NotificationManager notificationManager, int i, Notification notification) {
                this.f39351e = notificationManager;
                this.f39352f = i;
                this.f39353g = notification;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadNotificationService.this.b(this.f39351e, this.f39352f, this.f39353g);
            }
        }

        public a(Intent intent, String str) {
            this.f39348e = intent;
            this.f39349f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConnectivityManager connectivityManager;
            NetworkInfo activeNetworkInfo;
            NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService(ActionJsonData.TAG_NOTIFICATION);
            int intExtra = this.f39348e.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
            if (this.f39349f.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                Notification notification = (Notification) this.f39348e.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                int intExtra2 = this.f39348e.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                if (intExtra == 0 || notification == null || notificationManager == null) {
                    return;
                }
                if (intExtra2 != 4) {
                    if (intExtra2 == -2 || intExtra2 == -3) {
                        if (!DownloadNotificationService.f39347h) {
                            if (DownloadNotificationService.this.k != null) {
                                DownloadNotificationService.this.k.postDelayed(new RunnableC0521a(notificationManager, intExtra, notification), intExtra2 == -2 ? 50L : 200L);
                                return;
                            }
                            return;
                        }
                        DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                    } else if (DownloadNotificationService.f39347h) {
                        DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                    } else {
                        DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                    }
                } else if (d.p.a.e.b.g.a.l(d.l()).u(intExtra)) {
                    DownloadInfo f2 = d.p.a.e.b.g.a.l(d.l()).f(intExtra);
                    if (DownloadNotificationService.f39347h) {
                        if (f2 == null || !f2.b() || System.currentTimeMillis() - DownloadNotificationService.f39346g <= DownloadNotificationService.i) {
                            return;
                        }
                        DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                        f2.I2();
                    } else if (f2 == null || !f2.b()) {
                    } else {
                        DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                        f2.I2();
                    }
                }
            } else if (this.f39349f.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                if (intExtra != 0) {
                    DownloadNotificationService.this.b(notificationManager, intExtra);
                }
            } else if (this.f39349f.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                try {
                    if (e.H(DownloadNotificationService.this, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                        ArrayList arrayList = new ArrayList();
                        if (!TextUtils.isEmpty(c.f68093a)) {
                            arrayList.add(c.f68093a);
                        }
                        arrayList.add("mime_type_plg");
                        Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                        if (applicationContext != null) {
                            d.p.a.e.b.g.a.l(applicationContext).A(arrayList);
                            d.p.a.e.b.g.a.l(applicationContext).B(arrayList);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (this.f39349f.equals("android.intent.action.MEDIA_UNMOUNTED") || this.f39349f.equals("android.intent.action.MEDIA_REMOVED") || this.f39349f.equals("android.intent.action.MEDIA_BAD_REMOVAL") || this.f39349f.equals("android.intent.action.MEDIA_EJECT")) {
                try {
                    d.p.a.e.b.g.a.l(DownloadNotificationService.this).w();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NotificationManager f39355e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f39356f;

        public b(NotificationManager notificationManager, int i) {
            this.f39355e = notificationManager;
            this.f39356f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadNotificationService.this.a(this.f39355e, this.f39356f);
        }
    }

    private void d() {
        if (this.j == null) {
            HandlerThread handlerThread = new HandlerThread("DownloaderNotifyThread");
            this.j = handlerThread;
            handlerThread.start();
            this.k = new Handler(this.j.getLooper());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d();
        d.y(this);
        d.p.a.e.b.j.a r = d.p.a.e.b.j.a.r();
        int b2 = r.b("download_service_foreground", 0);
        if ((b2 == 1 || b2 == 3) && f39341b == -1) {
            f39341b = 0;
        }
        if ((b2 == 2 || b2 == 3) && f39342c == -1) {
            f39342c = 0;
        }
        f39344e = r.q("non_going_notification_foreground", false);
        f39347h = r.q("notify_too_fast", false);
        long c2 = r.c("notification_time_window", 900L);
        i = c2;
        if (c2 < 0 || c2 > IMLikeRequest.TIME_INTERVAL) {
            i = 900L;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        HandlerThread handlerThread = this.j;
        if (handlerThread != null) {
            try {
                handlerThread.quit();
            } catch (Throwable unused) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f39341b == 0) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(NotificationManager notificationManager, int i2, Notification notification) {
        if (a(i2, notification)) {
            try {
                boolean z = false;
                boolean z2 = d.p.a.e.b.g.e.c().a(i2) == 1 && !e.n0();
                if (!z2) {
                }
                if (z2 && f39342c == 0) {
                    z = true;
                }
                if (z) {
                    m t = d.p.a.e.b.g.e.c().t(i2);
                    if (t.g() && !t.b()) {
                        String str = f39340a;
                        d.p.a.e.b.c.a.h(str, "doNotify, startForeground, ======== id = " + i2 + ", isIndependentProcess = " + z2);
                        if (z2) {
                            f39342c = i2;
                        } else {
                            f39341b = i2;
                        }
                        t.a(i2, notification);
                    } else {
                        String str2 = f39340a;
                        d.p.a.e.b.c.a.h(str2, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = " + z2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if ((f39341b == i2 || f39342c == i2) && f39344e && (notification.flags & 2) == 0) {
            b(notificationManager, i2);
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (f39345f < currentTimeMillis) {
                f39345f = currentTimeMillis;
            }
            notificationManager.notify(i2, notification);
        } catch (Throwable unused) {
        }
    }

    private void a(Intent intent) {
        Handler handler;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (handler = this.k) == null) {
            return;
        }
        handler.post(new a(intent, action));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NotificationManager notificationManager, int i2, Notification notification) {
        synchronized (this.l) {
            int indexOfKey = this.l.indexOfKey(i2);
            if (indexOfKey >= 0 && indexOfKey < this.l.size()) {
                this.l.setValueAt(indexOfKey, notification);
                return;
            }
            long currentTimeMillis = i - (System.currentTimeMillis() - f39345f);
            if (currentTimeMillis <= 0) {
                currentTimeMillis = 0;
            }
            if (currentTimeMillis > 20000) {
                currentTimeMillis = 20000;
            }
            long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
            f39346g = currentTimeMillis2;
            f39345f = currentTimeMillis2;
            if (currentTimeMillis <= 0) {
                b(notificationManager, i2, notification);
            } else if (this.k != null) {
                synchronized (this.l) {
                    this.l.put(i2, notification);
                }
                this.k.postDelayed(new b(notificationManager, i2), currentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NotificationManager notificationManager, int i2) {
        Notification notification;
        synchronized (this.l) {
            notification = this.l.get(i2);
            this.l.remove(i2);
        }
        if (notification != null) {
            b(notificationManager, i2, notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NotificationManager notificationManager, int i2) {
        boolean z;
        d.p.a.e.b.p.a aVar;
        int a2;
        if (f39341b != i2 && f39342c != i2) {
            try {
                notificationManager.cancel(i2);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean z2 = true;
        if (f39341b == i2) {
            f39341b = 0;
            z = false;
        } else {
            f39342c = 0;
            z = true;
        }
        try {
            m t = d.p.a.e.b.g.e.c().t(i2);
            if (!t.b()) {
                f39343d = false;
                d.p.a.e.b.c.a.i(f39340a, "try to stopForeground when is not Foreground, id = " + i2 + ", isIndependentProcess = " + z);
            }
            d.p.a.e.b.c.a.h(f39340a, "doCancel, ========== stopForeground id = " + i2 + ", isIndependentProcess = " + z);
            t.a(false, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            notificationManager.cancel(i2);
        } catch (Throwable unused2) {
        }
        if (f39343d) {
            try {
                SparseArray<d.p.a.e.b.p.a> f2 = d.p.a.e.b.p.b.a().f();
                if (f2 != null) {
                    for (int size = f2.size() - 1; size >= 0; size--) {
                        aVar = f2.valueAt(size);
                        if (aVar != null && (a2 = aVar.a()) != i2 && a2 != f39341b && a2 != f39342c && aVar.r()) {
                            if ((d.p.a.e.b.g.e.c().a(aVar.a()) == 1 && !e.n0()) == z) {
                                break;
                            }
                        }
                    }
                }
                aVar = null;
                if (aVar != null) {
                    int a3 = aVar.a();
                    notificationManager.cancel(a3);
                    if (d.p.a.e.b.g.a.l(this).n(a3) != 1) {
                        z2 = false;
                    }
                    d.p.a.e.b.c.a.h(f39340a, "doCancel, updateNotification id = " + a3);
                    aVar.g(null, z2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private boolean a(int i2, Notification notification) {
        int i3;
        int i4;
        if (!f39343d || (i3 = f39341b) == i2 || (i4 = f39342c) == i2) {
            return false;
        }
        if (i3 == 0 || i4 == 0) {
            if (f39344e && (notification.flags & 2) == 0) {
                return false;
            }
            return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
        }
        return false;
    }
}
