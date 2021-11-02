package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.ss.android.socialbase.downloader.constants.e;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.d;
import com.ss.android.socialbase.downloader.downloader.m;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.g;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DownloadNotificationService extends Service {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f69717a;

    /* renamed from: b  reason: collision with root package name */
    public static int f69718b;

    /* renamed from: c  reason: collision with root package name */
    public static int f69719c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f69720d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f69721e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile long f69722f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile long f69723g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f69724h;

    /* renamed from: i  reason: collision with root package name */
    public static long f69725i;
    public transient /* synthetic */ FieldHolder $fh;
    public g j;
    public final SparseArray<Notification> k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1721303359, "Lcom/ss/android/socialbase/downloader/notification/DownloadNotificationService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1721303359, "Lcom/ss/android/socialbase/downloader/notification/DownloadNotificationService;");
                return;
            }
        }
        f69717a = DownloadNotificationService.class.getSimpleName();
        f69718b = -1;
        f69719c = -1;
        f69720d = true;
        f69721e = false;
        f69725i = 900L;
    }

    public DownloadNotificationService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new SparseArray<>(2);
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65552, this) == null) && this.j == null) {
            g gVar = new g("DownloaderNotifyThread");
            this.j = gVar;
            gVar.a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            d();
            c.a(this);
            com.ss.android.socialbase.downloader.g.a c2 = com.ss.android.socialbase.downloader.g.a.c();
            int a2 = c2.a("download_service_foreground", 0);
            if ((a2 == 1 || a2 == 3) && f69718b == -1) {
                f69718b = 0;
            }
            if ((a2 == 2 || a2 == 3) && f69719c == -1) {
                f69719c = 0;
            }
            f69721e = c2.b("non_going_notification_foreground", false);
            f69724h = c2.b("notify_too_fast", false);
            long a3 = c2.a("notification_time_window", 900L);
            f69725i = a3;
            if (a3 < 0 || a3 > IMLikeRequest.TIME_INTERVAL) {
                f69725i = 900L;
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            g gVar = this.j;
            if (gVar != null) {
                try {
                    gVar.b();
                } catch (Throwable unused) {
                }
                this.j = null;
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i2, i3)) == null) {
            a(intent);
            return 2;
        }
        return invokeLII.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
        if (com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f69718b == 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(NotificationManager notificationManager, int i2, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65548, this, notificationManager, i2, notification) == null) {
            if (a(i2, notification)) {
                try {
                    boolean z = false;
                    boolean z2 = d.a().a(i2) == 1 && !f.c();
                    if (!z2) {
                    }
                    if (z2 && f69719c == 0) {
                        z = true;
                    }
                    if (z) {
                        m c2 = d.a().c(i2);
                        if (c2.g() && !c2.b()) {
                            String str = f69717a;
                            com.ss.android.socialbase.downloader.c.a.c(str, "doNotify, startForeground, ======== id = " + i2 + ", isIndependentProcess = " + z2);
                            if (z2) {
                                f69719c = i2;
                            } else {
                                f69718b = i2;
                            }
                            c2.a(i2, notification);
                        } else {
                            String str2 = f69717a;
                            com.ss.android.socialbase.downloader.c.a.c(str2, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = " + z2);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else if ((f69718b == i2 || f69719c == i2) && f69721e && (notification.flags & 2) == 0) {
                b(notificationManager, i2);
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (f69722f < currentTimeMillis) {
                    f69722f = currentTimeMillis;
                }
                notificationManager.notify(i2, notification);
            } catch (Throwable unused) {
            }
        }
    }

    private void a(Intent intent) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, intent) == null) || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (gVar = this.j) == null) {
            return;
        }
        gVar.a(new Runnable(this, intent, action) { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Intent f69726a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f69727b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ DownloadNotificationService f69728c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, intent, action};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f69728c = this;
                this.f69726a = intent;
                this.f69727b = action;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    NotificationManager notificationManager = (NotificationManager) this.f69728c.getSystemService(ActionJsonData.TAG_NOTIFICATION);
                    int intExtra = this.f69726a.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                    if (this.f69727b.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                        Notification notification = (Notification) this.f69726a.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                        int intExtra2 = this.f69726a.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                        if (intExtra == 0 || notification == null || notificationManager == null) {
                            return;
                        }
                        if (intExtra2 != 4) {
                            if (intExtra2 == -2 || intExtra2 == -3) {
                                if (!DownloadNotificationService.f69724h) {
                                    if (this.f69728c.j != null) {
                                        this.f69728c.j.a(new Runnable(this, notificationManager, intExtra, notification) { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;

                                            /* renamed from: a  reason: collision with root package name */
                                            public final /* synthetic */ NotificationManager f69729a;

                                            /* renamed from: b  reason: collision with root package name */
                                            public final /* synthetic */ int f69730b;

                                            /* renamed from: c  reason: collision with root package name */
                                            public final /* synthetic */ Notification f69731c;

                                            /* renamed from: d  reason: collision with root package name */
                                            public final /* synthetic */ AnonymousClass1 f69732d;

                                            {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, notificationManager, Integer.valueOf(intExtra), notification};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.f69732d = this;
                                                this.f69729a = notificationManager;
                                                this.f69730b = intExtra;
                                                this.f69731c = notification;
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                    this.f69732d.f69728c.b(this.f69729a, this.f69730b, this.f69731c);
                                                }
                                            }
                                        }, intExtra2 == -2 ? 50L : 200L);
                                        return;
                                    }
                                    return;
                                }
                                this.f69728c.a(notificationManager, intExtra, notification);
                            } else if (DownloadNotificationService.f69724h) {
                                this.f69728c.a(notificationManager, intExtra, notification);
                            } else {
                                this.f69728c.b(notificationManager, intExtra, notification);
                            }
                        } else if (Downloader.getInstance(c.N()).isDownloading(intExtra)) {
                            DownloadInfo downloadInfo = Downloader.getInstance(c.N()).getDownloadInfo(intExtra);
                            if (DownloadNotificationService.f69724h) {
                                if (downloadInfo == null || !downloadInfo.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.f69723g <= DownloadNotificationService.f69725i) {
                                    return;
                                }
                                this.f69728c.b(notificationManager, intExtra, notification);
                                downloadInfo.setLastNotifyProgressTime();
                            } else if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                            } else {
                                this.f69728c.b(notificationManager, intExtra, notification);
                                downloadInfo.setLastNotifyProgressTime();
                            }
                        }
                    } else if (this.f69727b.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                        if (intExtra != 0) {
                            this.f69728c.b(notificationManager, intExtra);
                        }
                    } else if (this.f69727b.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        try {
                            if (f.a((Context) this.f69728c, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) && (connectivityManager = (ConnectivityManager) this.f69728c.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                                ArrayList arrayList = new ArrayList();
                                if (!TextUtils.isEmpty(e.f69177a)) {
                                    arrayList.add(e.f69177a);
                                }
                                arrayList.add("mime_type_plg");
                                Context applicationContext = this.f69728c.getApplicationContext();
                                if (applicationContext != null) {
                                    Downloader.getInstance(applicationContext).restartAllFailedDownloadTasks(arrayList);
                                    Downloader.getInstance(applicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (this.f69727b.equals("android.intent.action.MEDIA_UNMOUNTED") || this.f69727b.equals("android.intent.action.MEDIA_REMOVED") || this.f69727b.equals("android.intent.action.MEDIA_BAD_REMOVAL") || this.f69727b.equals("android.intent.action.MEDIA_EJECT")) {
                        try {
                            Downloader.getInstance(this.f69728c).pauseAll();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NotificationManager notificationManager, int i2, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, this, notificationManager, i2, notification) == null) {
            synchronized (this.k) {
                int indexOfKey = this.k.indexOfKey(i2);
                if (indexOfKey >= 0 && indexOfKey < this.k.size()) {
                    this.k.setValueAt(indexOfKey, notification);
                    return;
                }
                long currentTimeMillis = f69725i - (System.currentTimeMillis() - f69722f);
                if (currentTimeMillis <= 0) {
                    currentTimeMillis = 0;
                }
                if (currentTimeMillis > 20000) {
                    currentTimeMillis = 20000;
                }
                long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
                f69723g = currentTimeMillis2;
                f69722f = currentTimeMillis2;
                if (currentTimeMillis <= 0) {
                    b(notificationManager, i2, notification);
                } else if (this.j != null) {
                    synchronized (this.k) {
                        this.k.put(i2, notification);
                    }
                    this.j.a(new Runnable(this, notificationManager, i2) { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ NotificationManager f69733a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ int f69734b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ DownloadNotificationService f69735c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, notificationManager, Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f69735c = this;
                            this.f69733a = notificationManager;
                            this.f69734b = i2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f69735c.a(this.f69733a, this.f69734b);
                            }
                        }
                    }, currentTimeMillis);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NotificationManager notificationManager, int i2) {
        Notification notification;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, notificationManager, i2) == null) {
            synchronized (this.k) {
                notification = this.k.get(i2);
                this.k.remove(i2);
            }
            if (notification != null) {
                b(notificationManager, i2, notification);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NotificationManager notificationManager, int i2) {
        boolean z;
        a aVar;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, this, notificationManager, i2) == null) {
            if (f69718b != i2 && f69719c != i2) {
                try {
                    notificationManager.cancel(i2);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            boolean z2 = true;
            if (f69718b == i2) {
                f69718b = 0;
                z = false;
            } else {
                f69719c = 0;
                z = true;
            }
            try {
                m c2 = d.a().c(i2);
                if (!c2.b()) {
                    f69720d = false;
                    com.ss.android.socialbase.downloader.c.a.d(f69717a, "try to stopForeground when is not Foreground, id = " + i2 + ", isIndependentProcess = " + z);
                }
                com.ss.android.socialbase.downloader.c.a.c(f69717a, "doCancel, ========== stopForeground id = " + i2 + ", isIndependentProcess = " + z);
                c2.a(false, true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                notificationManager.cancel(i2);
            } catch (Throwable unused2) {
            }
            if (f69720d) {
                try {
                    SparseArray<a> b2 = b.a().b();
                    if (b2 != null) {
                        for (int size = b2.size() - 1; size >= 0; size--) {
                            aVar = b2.valueAt(size);
                            if (aVar != null && (a2 = aVar.a()) != i2 && a2 != f69718b && a2 != f69719c && aVar.i()) {
                                if ((d.a().a(aVar.a()) == 1 && !f.c()) == z) {
                                    break;
                                }
                            }
                        }
                    }
                    aVar = null;
                    if (aVar != null) {
                        int a3 = aVar.a();
                        notificationManager.cancel(a3);
                        if (Downloader.getInstance(this).getStatus(a3) != 1) {
                            z2 = false;
                        }
                        com.ss.android.socialbase.downloader.c.a.c(f69717a, "doCancel, updateNotification id = " + a3);
                        aVar.a((BaseException) null, z2);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    private boolean a(int i2, Notification notification) {
        InterceptResult invokeIL;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65545, this, i2, notification)) == null) {
            if (!f69720d || (i3 = f69718b) == i2 || (i4 = f69719c) == i2) {
                return false;
            }
            if (i3 == 0 || i4 == 0) {
                if (f69721e && (notification.flags & 2) == 0) {
                    return false;
                }
                return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
            }
            return false;
        }
        return invokeIL.booleanValue;
    }
}
