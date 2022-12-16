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
import com.kwad.components.core.k.kwai.a;
import com.kwad.components.core.m.m;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final Handler mHandler;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean xr;

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
            this.xr = false;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0579b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean xs;

        public C0579b() {
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
            this.xs = false;
        }

        public /* synthetic */ C0579b(byte b) {
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
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static void a(KsScene ksScene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ksScene) == null) {
            com.kwad.components.core.j.a.og().oi();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.splash.monitor.a.qG();
            com.kwad.components.splash.monitor.a.qI();
            ksScene.setAdStyle(4);
            ksScene.setAdNum(5);
            com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.ab();
            KsAdLoadManager.a(new a.C0599a().c(new com.kwad.components.core.k.kwai.b(ksScene)).ax(false).a(new com.kwad.components.core.k.c(elapsedRealtime) { // from class: com.kwad.components.ad.splashscreen.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long xq;

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
                    this.xq = elapsedRealtime;
                }

                @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
                public final void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, adResultData) == null) || adResultData.getAdTemplateList().size() <= 0) {
                        return;
                    }
                    int b = SplashPreloadManager.qD().b(adResultData, false);
                    com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + b);
                    com.kwad.components.splash.monitor.a.qG().b(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - this.xq);
                    com.kwad.components.core.j.a.og().an(adResultData.getAdTemplateList().size());
                }

                @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
                public final void onError(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                        com.kwad.components.splash.monitor.a.qG();
                        com.kwad.components.splash.monitor.a.f(i, str);
                        com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                    }
                }
            }).oo());
        }
    }

    public static void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ksScene, splashScreenAdListener) == null) {
            boolean a2 = m.oF().a(ksScene, "loadSplashScreenAd");
            ksScene.setAdStyle(4);
            ksScene.setAdNum(1);
            com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
            a aVar = new a((byte) 0);
            aVar.xr = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.core.k.kwai.b bVar = new com.kwad.components.core.k.kwai.b(ksScene);
            C0579b c0579b = new C0579b((byte) 0);
            com.kwad.components.core.j.a.og().oh();
            mHandler.postDelayed(new Runnable(ksScene) { // from class: com.kwad.components.ad.splashscreen.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsScene cU;

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
                    this.cU = ksScene;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        b.a(this.cU);
                    }
                }
            }, 15000L);
            Runnable runnable = new Runnable(c0579b, splashScreenAdListener) { // from class: com.kwad.components.ad.splashscreen.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0579b xk;
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener xl;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0579b, splashScreenAdListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.xk = c0579b;
                    this.xl = splashScreenAdListener;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.xk.xs = true;
                        com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                        KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = this.xl;
                        com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.Yf;
                        splashScreenAdListener2.onError(fVar.errorCode, fVar.Qd);
                        com.kwad.components.splash.monitor.a.qG();
                        com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.Yf;
                        com.kwad.components.splash.monitor.a.a("", false, fVar2.errorCode, fVar2.Qd);
                        com.kwad.components.core.j.a.og().am(4);
                    }
                }
            };
            mHandler.postDelayed(runnable, com.kwad.components.ad.splashscreen.a.b.jK());
            com.kwad.components.splash.monitor.a.qG();
            com.kwad.components.splash.monitor.a.qH();
            KsAdLoadManager.ab();
            KsAdLoadManager.a(new a.C0599a().c(bVar).aw(true).ax(a2).a(new com.kwad.components.core.k.c(c0579b, runnable, aVar, splashScreenAdListener, elapsedRealtime, ksScene) { // from class: com.kwad.components.ad.splashscreen.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsScene cU;
                public final /* synthetic */ long ef;
                public final /* synthetic */ C0579b xk;
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener xl;
                public final /* synthetic */ Runnable xm;
                public final /* synthetic */ a xn;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0579b, runnable, aVar, splashScreenAdListener, Long.valueOf(elapsedRealtime), ksScene};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.xk = c0579b;
                    this.xm = runnable;
                    this.xn = aVar;
                    this.xl = splashScreenAdListener;
                    this.ef = elapsedRealtime;
                    this.cU = ksScene;
                }

                @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.b
                public final void a(int i, String str, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                        if (this.xk.xs) {
                            com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                            return;
                        }
                        b.mHandler.removeCallbacks(this.xm);
                        if (!this.xn.xr) {
                            com.kwad.components.splash.monitor.a.qG();
                            com.kwad.components.splash.monitor.a.a("", z, i, str);
                        }
                        bd.runOnUiThread(new Runnable(this, i, str) { // from class: com.kwad.components.ad.splashscreen.b.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int aW;
                            public final /* synthetic */ String aX;
                            public final /* synthetic */ AnonymousClass3 xo;

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
                                this.xo = this;
                                this.aW = i;
                                this.aX = str;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.aW), this.aX));
                                    this.xo.xl.onError(this.aW, this.aX);
                                    if (this.aW == com.kwad.sdk.core.network.f.Yg.errorCode) {
                                        com.kwad.components.core.j.a.og().am(0);
                                    } else {
                                        com.kwad.components.core.j.a.og().am(3);
                                    }
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.b
                public final void a(@NonNull AdResultData adResultData, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData, z) == null) {
                        bd.runOnUiThread(new Runnable(this, adResultData) { // from class: com.kwad.components.ad.splashscreen.b.3.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AdResultData fx;
                            public final /* synthetic */ AnonymousClass3 xo;

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
                                this.xo = this;
                                this.fx = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.xo.xl.onRequestResult(this.fx.getAdTemplateList().size());
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                                    }
                                }
                            }
                        });
                        if (adResultData.getAdTemplateList().size() <= 0) {
                            if (this.xk.xs) {
                                com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                                return;
                            }
                            b.mHandler.removeCallbacks(this.xm);
                            com.kwad.components.splash.monitor.a.qG();
                            com.kwad.components.splash.monitor.a.l("", 6);
                            com.kwad.components.splash.monitor.a.qG();
                            com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.Yd;
                            com.kwad.components.splash.monitor.a.a("", z, fVar.errorCode, fVar.Qd);
                            this.xn.xr = true;
                            com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.Yd;
                            a(fVar2.errorCode, fVar2.Qd, z);
                            com.kwad.components.core.j.a.og().am(3);
                            return;
                        }
                        AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                        adTemplate.loadDataTime = SystemClock.elapsedRealtime() - this.ef;
                        adTemplate.notNetworkRequest = z;
                        String az = com.kwad.sdk.core.response.a.a.az(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
                        com.kwad.components.splash.monitor.a.qG().U(adTemplate);
                        com.kwad.components.splash.monitor.a.qG();
                        com.kwad.components.splash.monitor.a.l(az, 1);
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        KsSplashScreenAdControl ksSplashScreenAdControl = new KsSplashScreenAdControl(this.cU, adResultData);
                        boolean f = SplashPreloadManager.qD().f(adResultData);
                        com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + f);
                        if (!f) {
                            SplashPreloadManager.qD();
                            if (!SplashPreloadManager.g(adResultData)) {
                                if (this.xk.xs) {
                                    com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                                    return;
                                }
                                b.mHandler.removeCallbacks(this.xm);
                                com.kwad.components.splash.monitor.a.qG();
                                com.kwad.components.splash.monitor.a.l(az, 5);
                                com.kwad.components.splash.monitor.a.qG();
                                com.kwad.sdk.core.network.f fVar3 = com.kwad.sdk.core.network.f.Ye;
                                com.kwad.components.splash.monitor.a.a(az, z, fVar3.errorCode, fVar3.Qd);
                                this.xn.xr = true;
                                a(com.kwad.sdk.core.network.f.Ye.errorCode, "请求成功，但缓存未命中", z);
                                com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                                com.kwad.components.core.j.a.og().am(3);
                                return;
                            }
                            com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                            int b = SplashPreloadManager.qD().b(adResultData, true);
                            if (!this.xk.xs) {
                                b.mHandler.removeCallbacks(this.xm);
                                if (b > 0) {
                                    bd.runOnUiThread(new Runnable(this, ksSplashScreenAdControl) { // from class: com.kwad.components.ad.splashscreen.b.3.4
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass3 xo;
                                        public final /* synthetic */ KsSplashScreenAd xp;

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
                                            this.xo = this;
                                            this.xp = ksSplashScreenAdControl;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                try {
                                                    KsAdLoadManager.ab().a((KsAdLoadManager) this.xp);
                                                    this.xo.xl.onSplashScreenAdLoad(this.xp);
                                                } catch (Throwable th) {
                                                    com.kwad.sdk.core.e.b.printStackTrace(th);
                                                }
                                            }
                                        }
                                    });
                                    adTemplate.checkDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                    com.kwad.components.splash.monitor.a.qG();
                                    com.kwad.components.splash.monitor.a.l(az, 3);
                                    com.kwad.components.splash.monitor.a.qG().V(adTemplate);
                                    com.kwad.components.core.j.a.og().am(2);
                                    return;
                                }
                                com.kwad.components.splash.monitor.a.qG();
                                com.kwad.sdk.core.network.f fVar4 = com.kwad.sdk.core.network.f.Yg;
                                com.kwad.components.splash.monitor.a.a(az, z, fVar4.errorCode, fVar4.Qd);
                                com.kwad.components.splash.monitor.a.qG();
                                com.kwad.components.splash.monitor.a.l(az, 4);
                                this.xn.xr = true;
                                com.kwad.sdk.core.network.f fVar5 = com.kwad.sdk.core.network.f.Yg;
                                a(fVar5.errorCode, fVar5.Qd, z);
                                return;
                            }
                        } else if (!this.xk.xs) {
                            b.mHandler.removeCallbacks(this.xm);
                            com.kwad.components.splash.monitor.a.qG();
                            com.kwad.components.splash.monitor.a.l(az, 2);
                            bd.runOnUiThread(new Runnable(this, ksSplashScreenAdControl) { // from class: com.kwad.components.ad.splashscreen.b.3.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass3 xo;
                                public final /* synthetic */ KsSplashScreenAd xp;

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
                                    this.xo = this;
                                    this.xp = ksSplashScreenAdControl;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            KsAdLoadManager.ab().a((KsAdLoadManager) this.xp);
                                            this.xo.xl.onSplashScreenAdLoad(this.xp);
                                        } catch (Throwable th) {
                                            com.kwad.sdk.core.e.b.printStackTrace(th);
                                        }
                                    }
                                }
                            });
                            adTemplate.checkDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                            com.kwad.components.splash.monitor.a.qG().V(adTemplate);
                            com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                            com.kwad.components.core.j.a.og().am(1);
                            return;
                        }
                        com.kwad.components.splash.monitor.a.qG();
                        com.kwad.components.splash.monitor.a.l(az, 7);
                        com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                    }
                }
            }).oo());
        }
    }
}
