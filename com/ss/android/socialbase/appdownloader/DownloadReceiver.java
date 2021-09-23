package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import c.p.a.e.a.d;
import c.p.a.e.a.k;
import c.p.a.e.b.g.e;
import c.p.a.e.b.l.f;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
/* loaded from: classes10.dex */
public class DownloadReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f76046a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f76047b;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f76048e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f76049f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DownloadReceiver f76050g;

        /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class RunnableC2056a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f76051e;

            /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            public class RunnableC2057a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC2056a f76052e;

                public RunnableC2057a(RunnableC2056a runnableC2056a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC2056a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f76052e = runnableC2056a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        try {
                            if (this.f76052e.f76051e.isSavePathRedirected()) {
                                f.b0(this.f76052e.f76051e);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }

            public RunnableC2056a(a aVar, DownloadInfo downloadInfo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, downloadInfo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f76051e = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e.A0().execute(new RunnableC2057a(this));
                }
            }
        }

        public a(DownloadReceiver downloadReceiver, Intent intent, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadReceiver, intent, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76050g = downloadReceiver;
            this.f76048e = intent;
            this.f76049f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uri data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (data = this.f76048e.getData()) == null) {
                return;
            }
            String schemeSpecificPart = data.getSchemeSpecificPart();
            d.f u = c.p.a.e.a.e.G().u();
            if (u != null) {
                u.a(this.f76049f, schemeSpecificPart);
            }
            List<DownloadInfo> p = c.p.a.e.b.g.a.H(this.f76049f).p("application/vnd.android.package-archive");
            if (p != null) {
                for (DownloadInfo downloadInfo : p) {
                    if (downloadInfo != null && d.A(downloadInfo, schemeSpecificPart)) {
                        c.p.a.e.b.f.e i2 = c.p.a.e.b.g.a.H(this.f76049f).i(downloadInfo.getId());
                        if (i2 != null && f.O0(i2.a())) {
                            i2.a(9, downloadInfo, schemeSpecificPart, "");
                        }
                        c.p.a.e.b.p.a l = c.p.a.e.b.p.b.a().l(downloadInfo.getId());
                        if (l != null) {
                            l.g(null, false);
                        }
                        if (c.p.a.e.b.j.a.d(downloadInfo.getId()).b("install_queue_enable", 0) == 1) {
                            k.d().g(downloadInfo, schemeSpecificPart);
                        }
                        this.f76050g.f76047b.postDelayed(new RunnableC2056a(this, downloadInfo), 1000L);
                        return;
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
        public final /* synthetic */ Context f76053e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f76054f;

        public b(DownloadReceiver downloadReceiver, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadReceiver, context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76053e = context;
            this.f76054f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Intent intent = new Intent(this.f76053e, DownloadHandlerService.class);
                    intent.setAction(this.f76054f);
                    this.f76053e.startService(intent);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

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
        f76046a = DownloadReceiver.class.getSimpleName();
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
        this.f76047b = new Handler(Looper.getMainLooper());
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
        d.e b2 = c.p.a.e.a.e.G().b();
        if (action.equals("android.intent.action.BOOT_COMPLETED") && (b2 == null || b2.a())) {
            if (c.p.a.e.b.c.a.e()) {
                c.p.a.e.b.c.a.c(f76046a, "Received broadcast intent for android.intent.action.BOOT_COMPLETED");
            }
            a(context, action);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (c.p.a.e.b.c.a.e()) {
                c.p.a.e.b.c.a.c(f76046a, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            a(context, action);
        } else if (action.equals(PackageChangedReceiver.ACTION_INSTALL) || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            e.A0().execute(new a(this, intent, context));
        }
    }

    private void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, this, context, str) == null) && e.g()) {
            this.f76047b.postDelayed(new b(this, context, str), 2000L);
        }
    }
}
