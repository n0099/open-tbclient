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
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f64516a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f64517b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static f f64518c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public InstallTipsViewHelper f64519d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Integer> f64520e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, Integer> f64521f;

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
        this.f64520e = new HashMap();
        this.f64521f = new HashMap();
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f64518c == null) {
                synchronized (f.class) {
                    if (f64518c == null) {
                        f64518c = new f();
                    }
                }
            }
            return f64518c;
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
                public final /* synthetic */ AdInfo f64528a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f64529b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f64530c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ f f64531d;

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
                    this.f64531d = this;
                    this.f64528a = adInfo;
                    this.f64529b = adTemplate;
                    this.f64530c = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f64531d.f64519d != null) {
                            ar.a(new Runnable(this) { // from class: com.kwad.sdk.core.download.f.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f64532a;

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
                                    this.f64532a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        if (this.f64532a.f64531d.f64519d != null) {
                                            this.f64532a.f64531d.f64519d.b();
                                            this.f64532a.f64531d.f64519d.c();
                                            this.f64532a.f64531d.f64519d = null;
                                        }
                                        AnonymousClass3 anonymousClass3 = this.f64532a;
                                        anonymousClass3.f64531d.b(anonymousClass3.f64528a, anonymousClass3.f64529b, anonymousClass3.f64530c);
                                    }
                                }
                            }, null, 500L);
                        } else {
                            this.f64531d.b(this.f64528a, this.f64529b, this.f64530c);
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
                        a(this.f64520e, valueOf);
                        com.kwad.sdk.core.report.a.c(adTemplate, 92, null);
                    } else {
                        com.kwad.sdk.core.report.a.d(adTemplate, 93, null);
                        a(this.f64521f, valueOf);
                    }
                    this.f64519d = installTipsViewHelper;
                }
            }
        }
    }

    public void a(InstallTipsViewHelper installTipsViewHelper) {
        InstallTipsViewHelper installTipsViewHelper2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, installTipsViewHelper) == null) || installTipsViewHelper == null || (installTipsViewHelper2 = this.f64519d) == null || !installTipsViewHelper.equals(installTipsViewHelper2)) {
            return;
        }
        this.f64519d = null;
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
            if (this.f64520e.containsKey(valueOf)) {
                i2 = this.f64520e.get(valueOf).intValue();
                this.f64520e.put(valueOf, Integer.valueOf(i2));
            }
            if (i2 >= f64516a) {
                return;
            }
            com.kwad.sdk.utils.g.a(new Runnable(this, adInfo, adTemplate) { // from class: com.kwad.sdk.core.download.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f64522a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f64523b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ f f64524c;

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
                    this.f64524c = this;
                    this.f64522a = adInfo;
                    this.f64523b = adTemplate;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.a.a("InstallTipsManager", "onDownloadFinished run() adInfo.status: " + this.f64522a.status);
                        AdInfo adInfo2 = this.f64522a;
                        int i3 = adInfo2.status;
                        if (i3 == 12 || i3 == 10) {
                            return;
                        }
                        this.f64524c.a(adInfo2, this.f64523b, true);
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
        if (this.f64521f.containsKey(valueOf)) {
            i2 = this.f64521f.get(valueOf).intValue();
            this.f64521f.put(valueOf, Integer.valueOf(i2));
        }
        if (i2 >= f64517b) {
            return;
        }
        com.kwad.sdk.utils.g.a(new Runnable(this, adInfo, adTemplate) { // from class: com.kwad.sdk.core.download.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdInfo f64525a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f64526b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ f f64527c;

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
                this.f64527c = this;
                this.f64525a = adInfo;
                this.f64526b = adTemplate;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (ac.b(KsAdSDK.getContext(), com.kwad.sdk.core.response.b.a.q(this.f64525a)) == 1) {
                        return;
                    }
                    this.f64527c.a(this.f64525a, this.f64526b, false);
                }
            }
        }, an, TimeUnit.SECONDS);
    }
}
