package com.kwad.sdk.core.download;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.t;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f71314a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f71315b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static f f71316c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public InstallTipsViewHelper f71317d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Integer> f71318e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, Integer> f71319f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(303278567, "Lcom/kwad/sdk/core/download/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(303278567, "Lcom/kwad/sdk/core/download/f;");
        }
    }

    public f() {
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
        this.f71318e = new HashMap();
        this.f71319f = new HashMap();
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f71316c == null) {
                synchronized (f.class) {
                    if (f71316c == null) {
                        f71316c = new f();
                    }
                }
            }
            return f71316c;
        }
        return (f) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdInfo adInfo, AdTemplate adTemplate, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(AdIconUtil.BAIDU_LOGO_ID, this, adInfo, adTemplate, z) == null) {
            ar.a(new Runnable(this, adInfo, adTemplate, z) { // from class: com.kwad.sdk.core.download.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f71326a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f71327b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f71328c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ f f71329d;

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
                    this.f71329d = this;
                    this.f71326a = adInfo;
                    this.f71327b = adTemplate;
                    this.f71328c = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f71329d.f71317d != null) {
                            ar.a(new Runnable(this) { // from class: com.kwad.sdk.core.download.f.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f71330a;

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
                                    this.f71330a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        if (this.f71330a.f71329d.f71317d != null) {
                                            this.f71330a.f71329d.f71317d.b();
                                            this.f71330a.f71329d.f71317d.c();
                                            this.f71330a.f71329d.f71317d = null;
                                        }
                                        AnonymousClass3 anonymousClass3 = this.f71330a;
                                        anonymousClass3.f71329d.b(anonymousClass3.f71326a, anonymousClass3.f71327b, anonymousClass3.f71328c);
                                    }
                                }
                            }, null, 500L);
                        } else {
                            this.f71329d.b(this.f71326a, this.f71327b, this.f71328c);
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
            Activity c2 = t.a().c();
            if (c2 != null) {
                View findViewById = c2.getWindow().getDecorView().findViewById(16908290);
                if (findViewById instanceof FrameLayout) {
                    InstallTipsViewHelper installTipsViewHelper = new InstallTipsViewHelper(z, adInfo, adTemplate);
                    installTipsViewHelper.a((FrameLayout) findViewById);
                    String valueOf = String.valueOf(adInfo.adBaseInfo.creativeId);
                    if (z) {
                        a(this.f71318e, valueOf);
                        com.kwad.sdk.core.report.a.c(adTemplate, 92, null);
                    } else {
                        com.kwad.sdk.core.report.a.d(adTemplate, 93, null);
                        a(this.f71319f, valueOf);
                    }
                    this.f71317d = installTipsViewHelper;
                }
            }
        }
    }

    public void a(InstallTipsViewHelper installTipsViewHelper) {
        InstallTipsViewHelper installTipsViewHelper2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, installTipsViewHelper) == null) || installTipsViewHelper == null || (installTipsViewHelper2 = this.f71317d) == null || !installTipsViewHelper.equals(installTipsViewHelper2)) {
            return;
        }
        this.f71317d = null;
    }

    public void a(AdInfo adInfo, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adInfo, adTemplate) == null) {
            int K = com.kwad.sdk.core.config.c.K();
            com.kwad.sdk.core.d.a.a("InstallTipsManager", "onDownloadFinished installTipsTime: " + K);
            if (K <= 0 || adInfo == null || adTemplate == null || adTemplate.mAdScene.getAdStyle() == 0) {
                return;
            }
            String valueOf = String.valueOf(adInfo.adBaseInfo.creativeId);
            int i2 = 0;
            if (this.f71318e.containsKey(valueOf)) {
                i2 = this.f71318e.get(valueOf).intValue();
                this.f71318e.put(valueOf, Integer.valueOf(i2));
            }
            if (i2 >= f71314a) {
                return;
            }
            com.kwad.sdk.utils.g.a(new Runnable(this, adInfo, adTemplate) { // from class: com.kwad.sdk.core.download.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f71320a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f71321b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ f f71322c;

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
                    this.f71322c = this;
                    this.f71320a = adInfo;
                    this.f71321b = adTemplate;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.a.a("InstallTipsManager", "onDownloadFinished run() adInfo.status: " + this.f71320a.status);
                        AdInfo adInfo2 = this.f71320a;
                        int i3 = adInfo2.status;
                        if (i3 == 12 || i3 == 10) {
                            return;
                        }
                        this.f71322c.a(adInfo2, this.f71321b, true);
                    }
                }
            }, K, TimeUnit.SECONDS);
        }
    }

    public void b(AdInfo adInfo, AdTemplate adTemplate) {
        int an;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adInfo, adTemplate) == null) || (an = com.kwad.sdk.core.config.c.an()) < 0) {
            return;
        }
        String valueOf = String.valueOf(adInfo.adBaseInfo.creativeId);
        int i2 = 0;
        if (this.f71319f.containsKey(valueOf)) {
            i2 = this.f71319f.get(valueOf).intValue();
            this.f71319f.put(valueOf, Integer.valueOf(i2));
        }
        if (i2 >= f71315b) {
            return;
        }
        com.kwad.sdk.utils.g.a(new Runnable(this, adInfo, adTemplate) { // from class: com.kwad.sdk.core.download.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdInfo f71323a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f71324b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ f f71325c;

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
                this.f71325c = this;
                this.f71323a = adInfo;
                this.f71324b = adTemplate;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (ac.b(KsAdSDK.getContext(), com.kwad.sdk.core.response.b.a.q(this.f71323a)) == 1) {
                        return;
                    }
                    this.f71325c.a(this.f71323a, this.f71324b, false);
                }
            }
        }, an, TimeUnit.SECONDS);
    }
}
