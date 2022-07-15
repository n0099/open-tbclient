package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.splashscreen.preload.SplashPreloadManager;
import com.kwad.components.core.j.kwai.a;
import com.kwad.components.core.l.m;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final Handler a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0492b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;

        public C0492b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
        }

        public /* synthetic */ C0492b(byte b) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(987626204, "Lcom/kwad/components/ad/splashscreen/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(987626204, "Lcom/kwad/components/ad/splashscreen/b;");
                return;
            }
        }
        a = new Handler(Looper.getMainLooper());
    }

    public static void a(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ksScene, splashScreenAdListener) == null) {
            boolean a2 = m.a().a(ksScene, "loadSplashScreenAd");
            ksScene.setAdStyle(4);
            ksScene.setAdNum(1);
            com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
            a aVar = new a((byte) 0);
            aVar.a = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.core.j.kwai.b bVar = new com.kwad.components.core.j.kwai.b(ksScene);
            C0492b c0492b = new C0492b((byte) 0);
            com.kwad.components.core.i.a.a().b();
            a.postDelayed(new Runnable(ksScene) { // from class: com.kwad.components.ad.splashscreen.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsScene a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ksScene};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = ksScene;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        b.b(this.a);
                    }
                }
            }, 15000L);
            Runnable runnable = new Runnable(c0492b, splashScreenAdListener) { // from class: com.kwad.components.ad.splashscreen.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0492b a;
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0492b, splashScreenAdListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0492b;
                    this.b = splashScreenAdListener;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a = true;
                        com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                        KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = this.b;
                        com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.h;
                        splashScreenAdListener2.onError(fVar.p, fVar.q);
                        com.kwad.components.ad.splashscreen.monitor.a.a();
                        com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.h;
                        com.kwad.components.ad.splashscreen.monitor.a.a("", false, fVar2.p, fVar2.q);
                        com.kwad.components.core.i.a.a().a(4);
                    }
                }
            };
            a.postDelayed(runnable, com.kwad.components.ad.splashscreen.a.b.b());
            com.kwad.components.ad.splashscreen.monitor.a.a();
            com.kwad.components.ad.splashscreen.monitor.a.b();
            KsAdLoadManager.a();
            KsAdLoadManager.a(new a.C0512a().a(bVar).a(SplashPreloadManager.a().b()).a(true).b(a2).a(new com.kwad.components.core.j.c(c0492b, runnable, aVar, splashScreenAdListener, elapsedRealtime, ksScene) { // from class: com.kwad.components.ad.splashscreen.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0492b a;
                public final /* synthetic */ Runnable b;
                public final /* synthetic */ a c;
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener d;
                public final /* synthetic */ long e;
                public final /* synthetic */ KsScene f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0492b, runnable, aVar, splashScreenAdListener, Long.valueOf(elapsedRealtime), ksScene};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0492b;
                    this.b = runnable;
                    this.c = aVar;
                    this.d = splashScreenAdListener;
                    this.e = elapsedRealtime;
                    this.f = ksScene;
                }

                @Override // com.kwad.components.core.j.c, com.kwad.components.core.j.b
                public final void a(int i, String str, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                        if (this.a.a) {
                            com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                            return;
                        }
                        b.a.removeCallbacks(this.b);
                        if (!this.c.a) {
                            com.kwad.components.ad.splashscreen.monitor.a.a();
                            com.kwad.components.ad.splashscreen.monitor.a.a("", z, i, str);
                        }
                        az.a(new Runnable(this, i, str) { // from class: com.kwad.components.ad.splashscreen.b.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int a;
                            public final /* synthetic */ String b;
                            public final /* synthetic */ AnonymousClass3 c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i), str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.c = this;
                                this.a = i;
                                this.b = str;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.b));
                                    this.c.d.onError(this.a, this.b);
                                    if (this.a == com.kwad.sdk.core.network.f.i.p) {
                                        com.kwad.components.core.i.a.a().a(0);
                                    } else {
                                        com.kwad.components.core.i.a.a().a(3);
                                    }
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.components.core.j.c, com.kwad.components.core.j.b
                public final void a(@NonNull AdResultData adResultData, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData, z) == null) {
                        az.a(new Runnable(this, adResultData) { // from class: com.kwad.components.ad.splashscreen.b.3.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AdResultData a;
                            public final /* synthetic */ AnonymousClass3 b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, adResultData};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.b = this;
                                this.a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.b.d.onRequestResult(this.a.getAdTemplateList().size());
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.b.b(th);
                                    }
                                }
                            }
                        });
                        if (adResultData.getAdTemplateList().size() <= 0) {
                            if (this.a.a) {
                                com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                                return;
                            }
                            b.a.removeCallbacks(this.b);
                            com.kwad.components.ad.splashscreen.monitor.a.a();
                            com.kwad.components.ad.splashscreen.monitor.a.a("", 6);
                            com.kwad.components.ad.splashscreen.monitor.a.a();
                            com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f;
                            com.kwad.components.ad.splashscreen.monitor.a.a("", z, fVar.p, fVar.q);
                            this.c.a = true;
                            com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f;
                            a(fVar2.p, fVar2.q, z);
                            com.kwad.components.core.i.a.a().a(3);
                            return;
                        }
                        AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                        adTemplate.loadDataTime = SystemClock.elapsedRealtime() - this.e;
                        adTemplate.notNetworkRequest = z;
                        String U = com.kwad.sdk.core.response.a.a.U(com.kwad.sdk.core.response.a.d.i(adTemplate));
                        com.kwad.components.ad.splashscreen.monitor.a.a().a(adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.a.a();
                        com.kwad.components.ad.splashscreen.monitor.a.a(U, 1);
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        KsSplashScreenAdControl ksSplashScreenAdControl = new KsSplashScreenAdControl(this.f, adResultData);
                        boolean a3 = SplashPreloadManager.a().a(adResultData);
                        com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + a3);
                        if (!a3) {
                            SplashPreloadManager.a();
                            if (!SplashPreloadManager.b(adResultData)) {
                                if (this.a.a) {
                                    com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                                    return;
                                }
                                b.a.removeCallbacks(this.b);
                                com.kwad.components.ad.splashscreen.monitor.a.a();
                                com.kwad.components.ad.splashscreen.monitor.a.a(U, 5);
                                com.kwad.components.ad.splashscreen.monitor.a.a();
                                com.kwad.sdk.core.network.f fVar3 = com.kwad.sdk.core.network.f.g;
                                com.kwad.components.ad.splashscreen.monitor.a.a(U, z, fVar3.p, fVar3.q);
                                this.c.a = true;
                                a(com.kwad.sdk.core.network.f.g.p, "请求成功，但缓存未命中", z);
                                com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                                com.kwad.components.core.i.a.a().a(3);
                                return;
                            }
                            com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                            int a4 = SplashPreloadManager.a().a(adResultData, true);
                            if (!this.a.a) {
                                b.a.removeCallbacks(this.b);
                                if (a4 > 0) {
                                    az.a(new Runnable(this, ksSplashScreenAdControl) { // from class: com.kwad.components.ad.splashscreen.b.3.4
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ KsSplashScreenAd a;
                                        public final /* synthetic */ AnonymousClass3 b;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, ksSplashScreenAdControl};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i = newInitContext.flag;
                                                if ((i & 1) != 0) {
                                                    int i2 = i & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.b = this;
                                            this.a = ksSplashScreenAdControl;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                try {
                                                    this.b.d.onSplashScreenAdLoad(this.a);
                                                } catch (Throwable th) {
                                                    com.kwad.sdk.core.d.b.a(th);
                                                }
                                            }
                                        }
                                    });
                                    adTemplate.checkDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                    com.kwad.components.ad.splashscreen.monitor.a.a();
                                    com.kwad.components.ad.splashscreen.monitor.a.a(U, 3);
                                    com.kwad.components.ad.splashscreen.monitor.a.a().b(adTemplate);
                                    com.kwad.components.core.i.a.a().a(2);
                                    return;
                                }
                                com.kwad.components.ad.splashscreen.monitor.a.a();
                                com.kwad.sdk.core.network.f fVar4 = com.kwad.sdk.core.network.f.i;
                                com.kwad.components.ad.splashscreen.monitor.a.a(U, z, fVar4.p, fVar4.q);
                                com.kwad.components.ad.splashscreen.monitor.a.a();
                                com.kwad.components.ad.splashscreen.monitor.a.a(U, 4);
                                this.c.a = true;
                                com.kwad.sdk.core.network.f fVar5 = com.kwad.sdk.core.network.f.i;
                                a(fVar5.p, fVar5.q, z);
                                return;
                            }
                        } else if (!this.a.a) {
                            b.a.removeCallbacks(this.b);
                            com.kwad.components.ad.splashscreen.monitor.a.a();
                            com.kwad.components.ad.splashscreen.monitor.a.a(U, 2);
                            az.a(new Runnable(this, ksSplashScreenAdControl) { // from class: com.kwad.components.ad.splashscreen.b.3.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ KsSplashScreenAd a;
                                public final /* synthetic */ AnonymousClass3 b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, ksSplashScreenAdControl};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.b = this;
                                    this.a = ksSplashScreenAdControl;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            this.b.d.onSplashScreenAdLoad(this.a);
                                        } catch (Throwable th) {
                                            com.kwad.sdk.core.d.b.a(th);
                                        }
                                    }
                                }
                            });
                            adTemplate.checkDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                            com.kwad.components.ad.splashscreen.monitor.a.a().b(adTemplate);
                            com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                            com.kwad.components.core.i.a.a().a(1);
                            return;
                        }
                        com.kwad.components.ad.splashscreen.monitor.a.a();
                        com.kwad.components.ad.splashscreen.monitor.a.a(U, 7);
                        com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                    }
                }
            }).a());
        }
    }

    public static void b(KsScene ksScene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ksScene) == null) {
            com.kwad.components.core.i.a.a().c();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.a.a();
            com.kwad.components.ad.splashscreen.monitor.a.c();
            ksScene.setAdStyle(4);
            ksScene.setAdNum(5);
            com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.a();
            KsAdLoadManager.a(new a.C0512a().a(new com.kwad.components.core.j.kwai.b(ksScene)).b(false).a(new com.kwad.components.core.j.c(elapsedRealtime) { // from class: com.kwad.components.ad.splashscreen.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Long.valueOf(elapsedRealtime)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = elapsedRealtime;
                }

                @Override // com.kwad.components.core.j.c, com.kwad.components.core.j.g
                public final void a(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                        com.kwad.components.ad.splashscreen.monitor.a.a();
                        com.kwad.components.ad.splashscreen.monitor.a.a(i, str);
                        com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                    }
                }

                @Override // com.kwad.components.core.j.c, com.kwad.components.core.j.g
                public final void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) || adResultData.getAdTemplateList().size() <= 0) {
                        return;
                    }
                    int a2 = SplashPreloadManager.a().a(adResultData, false);
                    com.kwad.sdk.core.d.b.a("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + a2);
                    com.kwad.components.ad.splashscreen.monitor.a.a().a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - this.a);
                    com.kwad.components.core.i.a.a().b(adResultData.getAdTemplateList().size());
                }
            }).a());
        }
    }
}
