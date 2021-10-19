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
    public static int f72048a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f72049b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static f f72050c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public InstallTipsViewHelper f72051d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Integer> f72052e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, Integer> f72053f;

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
        this.f72052e = new HashMap();
        this.f72053f = new HashMap();
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f72050c == null) {
                synchronized (f.class) {
                    if (f72050c == null) {
                        f72050c = new f();
                    }
                }
            }
            return f72050c;
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
                public final /* synthetic */ AdInfo f72060a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f72061b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f72062c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ f f72063d;

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
                    this.f72063d = this;
                    this.f72060a = adInfo;
                    this.f72061b = adTemplate;
                    this.f72062c = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f72063d.f72051d != null) {
                            ar.a(new Runnable(this) { // from class: com.kwad.sdk.core.download.f.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f72064a;

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
                                    this.f72064a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        if (this.f72064a.f72063d.f72051d != null) {
                                            this.f72064a.f72063d.f72051d.b();
                                            this.f72064a.f72063d.f72051d.c();
                                            this.f72064a.f72063d.f72051d = null;
                                        }
                                        AnonymousClass3 anonymousClass3 = this.f72064a;
                                        anonymousClass3.f72063d.b(anonymousClass3.f72060a, anonymousClass3.f72061b, anonymousClass3.f72062c);
                                    }
                                }
                            }, null, 500L);
                        } else {
                            this.f72063d.b(this.f72060a, this.f72061b, this.f72062c);
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
                        a(this.f72052e, valueOf);
                        com.kwad.sdk.core.report.a.c(adTemplate, 92, null);
                    } else {
                        com.kwad.sdk.core.report.a.d(adTemplate, 93, null);
                        a(this.f72053f, valueOf);
                    }
                    this.f72051d = installTipsViewHelper;
                }
            }
        }
    }

    public void a(InstallTipsViewHelper installTipsViewHelper) {
        InstallTipsViewHelper installTipsViewHelper2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, installTipsViewHelper) == null) || installTipsViewHelper == null || (installTipsViewHelper2 = this.f72051d) == null || !installTipsViewHelper.equals(installTipsViewHelper2)) {
            return;
        }
        this.f72051d = null;
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
            if (this.f72052e.containsKey(valueOf)) {
                i2 = this.f72052e.get(valueOf).intValue();
                this.f72052e.put(valueOf, Integer.valueOf(i2));
            }
            if (i2 >= f72048a) {
                return;
            }
            com.kwad.sdk.utils.g.a(new Runnable(this, adInfo, adTemplate) { // from class: com.kwad.sdk.core.download.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f72054a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f72055b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ f f72056c;

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
                    this.f72056c = this;
                    this.f72054a = adInfo;
                    this.f72055b = adTemplate;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.a.a("InstallTipsManager", "onDownloadFinished run() adInfo.status: " + this.f72054a.status);
                        AdInfo adInfo2 = this.f72054a;
                        int i3 = adInfo2.status;
                        if (i3 == 12 || i3 == 10) {
                            return;
                        }
                        this.f72056c.a(adInfo2, this.f72055b, true);
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
        if (this.f72053f.containsKey(valueOf)) {
            i2 = this.f72053f.get(valueOf).intValue();
            this.f72053f.put(valueOf, Integer.valueOf(i2));
        }
        if (i2 >= f72049b) {
            return;
        }
        com.kwad.sdk.utils.g.a(new Runnable(this, adInfo, adTemplate) { // from class: com.kwad.sdk.core.download.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdInfo f72057a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f72058b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ f f72059c;

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
                this.f72059c = this;
                this.f72057a = adInfo;
                this.f72058b = adTemplate;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (ac.b(KsAdSDK.getContext(), com.kwad.sdk.core.response.b.a.q(this.f72057a)) == 1) {
                        return;
                    }
                    this.f72059c.a(this.f72057a, this.f72058b, false);
                }
            }
        }, an, TimeUnit.SECONDS);
    }
}
