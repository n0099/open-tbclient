package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class DownloadReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f68881a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f68882b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(97589039, "Lcom/ss/android/socialbase/appdownloader/DownloadReceiver;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(97589039, "Lcom/ss/android/socialbase/appdownloader/DownloadReceiver;");
                return;
            }
        }
        f68881a = DownloadReceiver.class.getSimpleName();
    }

    public DownloadReceiver() {
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
        this.f68882b = new Handler(Looper.getMainLooper());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        com.ss.android.socialbase.appdownloader.c.c a2 = d.j().a();
        if (action.equals("android.intent.action.BOOT_COMPLETED") && (a2 == null || a2.a())) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.a(f68881a, "Received broadcast intent for android.intent.action.BOOT_COMPLETED");
            }
            a(context, action);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.a(f68881a, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            a(context, action);
        } else if (action.equals(PackageChangedReceiver.ACTION_INSTALL) || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable(this, intent, context) { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Intent f68883a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f68884b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadReceiver f68885c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, intent, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68885c = this;
                    this.f68883a = intent;
                    this.f68884b = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Uri data;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (data = this.f68883a.getData()) == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    com.ss.android.socialbase.appdownloader.c.d b2 = d.j().b();
                    if (b2 != null) {
                        b2.a(this.f68884b, schemeSpecificPart);
                    }
                    List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(this.f68884b).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
                    if (successedDownloadInfosWithMimeType != null) {
                        for (DownloadInfo downloadInfo : successedDownloadInfosWithMimeType) {
                            if (downloadInfo != null && c.a(downloadInfo, schemeSpecificPart)) {
                                z downloadNotificationEventListener = Downloader.getInstance(this.f68884b).getDownloadNotificationEventListener(downloadInfo.getId());
                                if (downloadNotificationEventListener != null && com.ss.android.socialbase.downloader.i.f.f(downloadNotificationEventListener.a())) {
                                    downloadNotificationEventListener.a(9, downloadInfo, schemeSpecificPart, "");
                                }
                                com.ss.android.socialbase.downloader.notification.a e2 = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
                                if (e2 != null) {
                                    e2.a((BaseException) null, false);
                                }
                                if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_queue_enable", 0) == 1) {
                                    h.a().a(downloadInfo, schemeSpecificPart);
                                }
                                this.f68885c.f68882b.postDelayed(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ DownloadInfo f68886a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass1 f68887b;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, downloadInfo};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f68887b = this;
                                        this.f68886a = downloadInfo;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable(this) { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;

                                                /* renamed from: a  reason: collision with root package name */
                                                public final /* synthetic */ RunnableC19781 f68888a;

                                                {
                                                    Interceptable interceptable4 = $ic;
                                                    if (interceptable4 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this};
                                                        interceptable4.invokeUnInit(65536, newInitContext);
                                                        int i2 = newInitContext.flag;
                                                        if ((i2 & 1) != 0) {
                                                            int i3 = i2 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable4.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.f68888a = this;
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    Interceptable interceptable4 = $ic;
                                                    if (interceptable4 == null || interceptable4.invokeV(1048576, this) == null) {
                                                        try {
                                                            if (this.f68888a.f68886a.isSavePathRedirected()) {
                                                                com.ss.android.socialbase.downloader.i.f.b(this.f68888a.f68886a);
                                                            }
                                                        } catch (Throwable th) {
                                                            th.printStackTrace();
                                                        }
                                                    }
                                                }
                                            });
                                        }
                                    }
                                }, 1000L);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    private void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, this, context, str) == null) && com.ss.android.socialbase.downloader.downloader.c.G()) {
            this.f68882b.postDelayed(new Runnable(this, context, str) { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f68889a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f68890b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadReceiver f68891c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68891c = this;
                    this.f68889a = context;
                    this.f68890b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            Intent intent = new Intent(this.f68889a, DownloadHandlerService.class);
                            intent.setAction(this.f68890b);
                            this.f68889a.startService(intent);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }, 2000L);
        }
    }
}
