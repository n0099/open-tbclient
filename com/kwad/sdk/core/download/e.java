package com.kwad.sdk.core.download;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f57393b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static e f57394c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public InstallTipsViewHelper f57395d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Integer> f57396e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, Integer> f57397f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(303278536, "Lcom/kwad/sdk/core/download/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(303278536, "Lcom/kwad/sdk/core/download/e;");
        }
    }

    public e() {
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
        this.f57396e = new HashMap();
        this.f57397f = new HashMap();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f57394c == null) {
                synchronized (e.class) {
                    if (f57394c == null) {
                        f57394c = new e();
                    }
                }
            }
            return f57394c;
        }
        return (e) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdInfo adInfo, AdTemplate adTemplate, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, this, adInfo, adTemplate, z) == null) {
            ax.a(new Runnable(this, adInfo, adTemplate, z) { // from class: com.kwad.sdk.core.download.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdInfo a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f57402b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f57403c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ e f57404d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, adInfo, adTemplate, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57404d = this;
                    this.a = adInfo;
                    this.f57402b = adTemplate;
                    this.f57403c = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f57404d.f57395d != null) {
                            ax.a(new Runnable(this) { // from class: com.kwad.sdk.core.download.e.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass3 a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        if (this.a.f57404d.f57395d != null) {
                                            this.a.f57404d.f57395d.b();
                                            this.a.f57404d.f57395d.c();
                                            this.a.f57404d.f57395d = null;
                                        }
                                        AnonymousClass3 anonymousClass3 = this.a;
                                        anonymousClass3.f57404d.b(anonymousClass3.a, anonymousClass3.f57402b, anonymousClass3.f57403c);
                                    }
                                }
                            }, null, 500L);
                        } else {
                            this.f57404d.b(this.a, this.f57402b, this.f57403c);
                        }
                    }
                }
            });
        }
    }

    private void a(Map<String, Integer> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, map, str) == null) {
            map.put(str, map.containsKey(str) ? Integer.valueOf(map.get(str).intValue() + 1) : 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void b(AdInfo adInfo, AdTemplate adTemplate, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65545, this, adInfo, adTemplate, z) == null) {
            com.kwad.sdk.core.d.a.a("InstallTipsManager", "addToWindow");
            Activity c2 = x.a().c();
            if (c2 != null) {
                View findViewById = c2.getWindow().getDecorView().findViewById(16908290);
                if (findViewById instanceof FrameLayout) {
                    InstallTipsViewHelper installTipsViewHelper = new InstallTipsViewHelper(z, adInfo, adTemplate);
                    installTipsViewHelper.a((FrameLayout) findViewById);
                    String valueOf = String.valueOf(adInfo.adBaseInfo.creativeId);
                    if (z) {
                        a(this.f57396e, valueOf);
                        com.kwad.sdk.core.report.a.c(adTemplate, 92, null);
                    } else {
                        com.kwad.sdk.core.report.a.d(adTemplate, 93, null);
                        a(this.f57397f, valueOf);
                    }
                    this.f57395d = installTipsViewHelper;
                }
            }
        }
    }

    public void a(InstallTipsViewHelper installTipsViewHelper) {
        InstallTipsViewHelper installTipsViewHelper2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, installTipsViewHelper) == null) || installTipsViewHelper == null || (installTipsViewHelper2 = this.f57395d) == null || !installTipsViewHelper.equals(installTipsViewHelper2)) {
            return;
        }
        this.f57395d = null;
    }

    public void a(AdInfo adInfo, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adInfo, adTemplate) == null) {
            int L = com.kwad.sdk.core.config.b.L();
            com.kwad.sdk.core.d.a.a("InstallTipsManager", "onDownloadFinished installTipsTime: " + L);
            if (L <= 0 || adInfo == null || adTemplate == null || adTemplate.mAdScene.getAdStyle() == 0) {
                return;
            }
            String valueOf = String.valueOf(adInfo.adBaseInfo.creativeId);
            int i2 = 0;
            if (this.f57396e.containsKey(valueOf)) {
                i2 = this.f57396e.get(valueOf).intValue();
                this.f57396e.put(valueOf, Integer.valueOf(i2));
            }
            if (i2 >= a) {
                return;
            }
            i.a(new Runnable(this, adInfo, adTemplate) { // from class: com.kwad.sdk.core.download.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdInfo a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f57398b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ e f57399c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, adInfo, adTemplate};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57399c = this;
                    this.a = adInfo;
                    this.f57398b = adTemplate;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.a.a("InstallTipsManager", "onDownloadFinished run() adInfo.status: " + this.a.status);
                        AdInfo adInfo2 = this.a;
                        int i3 = adInfo2.status;
                        if (i3 == 12 || i3 == 10) {
                            return;
                        }
                        this.f57399c.a(adInfo2, this.f57398b, true);
                    }
                }
            }, L, TimeUnit.SECONDS);
        }
    }

    public void b(AdInfo adInfo, AdTemplate adTemplate) {
        int av;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adInfo, adTemplate) == null) || (av = com.kwad.sdk.core.config.b.av()) < 0) {
            return;
        }
        String valueOf = String.valueOf(adInfo.adBaseInfo.creativeId);
        int i2 = 0;
        if (this.f57397f.containsKey(valueOf)) {
            i2 = this.f57397f.get(valueOf).intValue();
            this.f57397f.put(valueOf, Integer.valueOf(i2));
        }
        if (i2 >= f57393b) {
            return;
        }
        i.a(new Runnable(this, adInfo, adTemplate) { // from class: com.kwad.sdk.core.download.e.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdInfo a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f57400b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ e f57401c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, adInfo, adTemplate};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57401c = this;
                this.a = adInfo;
                this.f57400b = adTemplate;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (ag.b(KsAdSDK.getContext(), com.kwad.sdk.core.response.a.a.v(this.a)) == 1) {
                        return;
                    }
                    this.f57401c.a(this.a, this.f57400b, false);
                }
            }
        }, av, TimeUnit.SECONDS);
    }
}
