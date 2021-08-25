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
import c.p.a.e.b.d.c;
import c.p.a.e.b.g.e;
import c.p.a.e.b.g.n;
import c.p.a.e.b.k.g;
import c.p.a.e.b.l.f;
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
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class DownloadNotificationService extends Service {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f75834a;

    /* renamed from: b  reason: collision with root package name */
    public static int f75835b;

    /* renamed from: c  reason: collision with root package name */
    public static int f75836c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f75837d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f75838e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile long f75839f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile long f75840g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f75841h;

    /* renamed from: i  reason: collision with root package name */
    public static long f75842i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public g f75843j;
    public final SparseArray<Notification> k;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f75844e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f75845f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DownloadNotificationService f75846g;

        /* renamed from: com.ss.android.socialbase.downloader.notification.DownloadNotificationService$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class RunnableC2078a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ NotificationManager f75847e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f75848f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Notification f75849g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f75850h;

            public RunnableC2078a(a aVar, NotificationManager notificationManager, int i2, Notification notification) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, notificationManager, Integer.valueOf(i2), notification};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f75850h = aVar;
                this.f75847e = notificationManager;
                this.f75848f = i2;
                this.f75849g = notification;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f75850h.f75846g.b(this.f75847e, this.f75848f, this.f75849g);
                }
            }
        }

        public a(DownloadNotificationService downloadNotificationService, Intent intent, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadNotificationService, intent, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75846g = downloadNotificationService;
            this.f75844e = intent;
            this.f75845f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConnectivityManager connectivityManager;
            NetworkInfo activeNetworkInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NotificationManager notificationManager = (NotificationManager) this.f75846g.getSystemService(ActionJsonData.TAG_NOTIFICATION);
                int intExtra = this.f75844e.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                if (this.f75845f.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                    Notification notification = (Notification) this.f75844e.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                    int intExtra2 = this.f75844e.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                    if (intExtra == 0 || notification == null || notificationManager == null) {
                        return;
                    }
                    if (intExtra2 != 4) {
                        if (intExtra2 == -2 || intExtra2 == -3) {
                            if (!DownloadNotificationService.f75841h) {
                                if (this.f75846g.f75843j != null) {
                                    this.f75846g.f75843j.e(new RunnableC2078a(this, notificationManager, intExtra, notification), intExtra2 == -2 ? 50L : 200L);
                                    return;
                                }
                                return;
                            }
                            this.f75846g.a(notificationManager, intExtra, notification);
                        } else if (DownloadNotificationService.f75841h) {
                            this.f75846g.a(notificationManager, intExtra, notification);
                        } else {
                            this.f75846g.b(notificationManager, intExtra, notification);
                        }
                    } else if (c.p.a.e.b.g.a.H(e.n()).t(intExtra)) {
                        DownloadInfo f2 = c.p.a.e.b.g.a.H(e.n()).f(intExtra);
                        if (DownloadNotificationService.f75841h) {
                            if (f2 == null || !f2.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.f75840g <= DownloadNotificationService.f75842i) {
                                return;
                            }
                            this.f75846g.b(notificationManager, intExtra, notification);
                            f2.setLastNotifyProgressTime();
                        } else if (f2 == null || !f2.canNotifyProgress()) {
                        } else {
                            this.f75846g.b(notificationManager, intExtra, notification);
                            f2.setLastNotifyProgressTime();
                        }
                    }
                } else if (this.f75845f.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                    if (intExtra != 0) {
                        this.f75846g.b(notificationManager, intExtra);
                    }
                } else if (this.f75845f.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        if (f.J(this.f75846g, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) && (connectivityManager = (ConnectivityManager) this.f75846g.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(c.f34970a)) {
                                arrayList.add(c.f34970a);
                            }
                            arrayList.add("mime_type_plg");
                            Context applicationContext = this.f75846g.getApplicationContext();
                            if (applicationContext != null) {
                                c.p.a.e.b.g.a.H(applicationContext).z(arrayList);
                                c.p.a.e.b.g.a.H(applicationContext).A(arrayList);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (this.f75845f.equals("android.intent.action.MEDIA_UNMOUNTED") || this.f75845f.equals("android.intent.action.MEDIA_REMOVED") || this.f75845f.equals("android.intent.action.MEDIA_BAD_REMOVAL") || this.f75845f.equals("android.intent.action.MEDIA_EJECT")) {
                    try {
                        c.p.a.e.b.g.a.H(this.f75846g).v();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NotificationManager f75851e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f75852f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DownloadNotificationService f75853g;

        public b(DownloadNotificationService downloadNotificationService, NotificationManager notificationManager, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadNotificationService, notificationManager, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75853g = downloadNotificationService;
            this.f75851e = notificationManager;
            this.f75852f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f75853g.a(this.f75851e, this.f75852f);
            }
        }
    }

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
        f75834a = DownloadNotificationService.class.getSimpleName();
        f75835b = -1;
        f75836c = -1;
        f75837d = true;
        f75838e = false;
        f75842i = 900L;
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
        if ((interceptable == null || interceptable.invokeV(65552, this) == null) && this.f75843j == null) {
            g gVar = new g("DownloaderNotifyThread");
            this.f75843j = gVar;
            gVar.c();
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
            e.C(this);
            c.p.a.e.b.j.a r = c.p.a.e.b.j.a.r();
            int b2 = r.b("download_service_foreground", 0);
            if ((b2 == 1 || b2 == 3) && f75835b == -1) {
                f75835b = 0;
            }
            if ((b2 == 2 || b2 == 3) && f75836c == -1) {
                f75836c = 0;
            }
            f75838e = r.q("non_going_notification_foreground", false);
            f75841h = r.q("notify_too_fast", false);
            long c2 = r.c("notification_time_window", 900L);
            f75842i = c2;
            if (c2 < 0 || c2 > IMLikeRequest.TIME_INTERVAL) {
                f75842i = 900L;
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            g gVar = this.f75843j;
            if (gVar != null) {
                try {
                    gVar.g();
                } catch (Throwable unused) {
                }
                this.f75843j = null;
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
        if (com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f75835b == 0) goto L33;
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
                    boolean z2 = c.p.a.e.b.g.f.c().a(i2) == 1 && !f.p0();
                    if (!z2) {
                    }
                    if (z2 && f75836c == 0) {
                        z = true;
                    }
                    if (z) {
                        n t = c.p.a.e.b.g.f.c().t(i2);
                        if (t.h() && !t.b()) {
                            String str = f75834a;
                            c.p.a.e.b.c.a.i(str, "doNotify, startForeground, ======== id = " + i2 + ", isIndependentProcess = " + z2);
                            if (z2) {
                                f75836c = i2;
                            } else {
                                f75835b = i2;
                            }
                            t.a(i2, notification);
                        } else {
                            String str2 = f75834a;
                            c.p.a.e.b.c.a.i(str2, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = " + z2);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else if ((f75835b == i2 || f75836c == i2) && f75838e && (notification.flags & 2) == 0) {
                b(notificationManager, i2);
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (f75839f < currentTimeMillis) {
                    f75839f = currentTimeMillis;
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
        if (TextUtils.isEmpty(action) || (gVar = this.f75843j) == null) {
            return;
        }
        gVar.d(new a(this, intent, action));
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
                long currentTimeMillis = f75842i - (System.currentTimeMillis() - f75839f);
                if (currentTimeMillis <= 0) {
                    currentTimeMillis = 0;
                }
                if (currentTimeMillis > 20000) {
                    currentTimeMillis = 20000;
                }
                long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
                f75840g = currentTimeMillis2;
                f75839f = currentTimeMillis2;
                if (currentTimeMillis <= 0) {
                    b(notificationManager, i2, notification);
                } else if (this.f75843j != null) {
                    synchronized (this.k) {
                        this.k.put(i2, notification);
                    }
                    this.f75843j.e(new b(this, notificationManager, i2), currentTimeMillis);
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
        c.p.a.e.b.p.a aVar;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, this, notificationManager, i2) == null) {
            if (f75835b != i2 && f75836c != i2) {
                try {
                    notificationManager.cancel(i2);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            boolean z2 = true;
            if (f75835b == i2) {
                f75835b = 0;
                z = false;
            } else {
                f75836c = 0;
                z = true;
            }
            try {
                n t = c.p.a.e.b.g.f.c().t(i2);
                if (!t.b()) {
                    f75837d = false;
                    c.p.a.e.b.c.a.j(f75834a, "try to stopForeground when is not Foreground, id = " + i2 + ", isIndependentProcess = " + z);
                }
                c.p.a.e.b.c.a.i(f75834a, "doCancel, ========== stopForeground id = " + i2 + ", isIndependentProcess = " + z);
                t.c(false, true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                notificationManager.cancel(i2);
            } catch (Throwable unused2) {
            }
            if (f75837d) {
                try {
                    SparseArray<c.p.a.e.b.p.a> f2 = c.p.a.e.b.p.b.a().f();
                    if (f2 != null) {
                        for (int size = f2.size() - 1; size >= 0; size--) {
                            aVar = f2.valueAt(size);
                            if (aVar != null && (a2 = aVar.a()) != i2 && a2 != f75835b && a2 != f75836c && aVar.r()) {
                                if ((c.p.a.e.b.g.f.c().a(aVar.a()) == 1 && !f.p0()) == z) {
                                    break;
                                }
                            }
                        }
                    }
                    aVar = null;
                    if (aVar != null) {
                        int a3 = aVar.a();
                        notificationManager.cancel(a3);
                        if (c.p.a.e.b.g.a.H(this).o(a3) != 1) {
                            z2 = false;
                        }
                        c.p.a.e.b.c.a.i(f75834a, "doCancel, updateNotification id = " + a3);
                        aVar.g(null, z2);
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
            if (!f75837d || (i3 = f75835b) == i2 || (i4 = f75836c) == i2) {
                return false;
            }
            if (i3 == 0 || i4 == 0) {
                if (f75838e && (notification.flags & 2) == 0) {
                    return false;
                }
                return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
            }
            return false;
        }
        return invokeIL.booleanValue;
    }
}
