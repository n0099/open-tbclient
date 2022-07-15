package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.y;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class m extends e implements com.kwad.components.ad.splashscreen.f {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "SplashWebViewPresenter";
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdWebView c;
    public com.kwad.sdk.core.webview.b d;
    public com.kwad.components.core.webview.a e;
    public com.kwad.components.ad.splashscreen.d.b f;
    public ViewStub g;
    public volatile boolean h;
    public Runnable i;
    public AdInfo j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-78998466, "Lcom/kwad/components/ad/splashscreen/b/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-78998466, "Lcom/kwad/components/ad/splashscreen/b/m;");
        }
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.m.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.e();
                }
            }
        };
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            aVar.a(new z(this.d, ((e) this).a.f));
            aVar.a(w());
            aVar.a(v());
            aVar.a(new com.kwad.components.core.webview.jshandler.i(this.d));
            aVar.a(new com.kwad.components.core.webview.b.j());
            aVar.a(new u(new u.b(this) { // from class: com.kwad.components.ad.splashscreen.b.m.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.u.b
                public final void a(u.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        String str = m.b;
                        com.kwad.sdk.core.d.b.a(str, "updatePageStatus: " + aVar2);
                        if (aVar2.a != 1) {
                            this.a.e();
                            return;
                        }
                        az.b(this.a.i);
                        this.a.d();
                    }
                }
            }, i()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i, @Nullable u.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), bVar}) == null) {
            ((e) this).a.e();
            int i2 = 0;
            boolean z2 = bVar != null;
            boolean z3 = i == 1;
            com.kwad.components.core.c.a.a.a(new a.C0507a(((e) this).a.d.getContext()).a(((e) this).a.c).a(((e) this).a.f).a(z3).a(i).a(bVar).c(z2).a(new a.b(this) { // from class: com.kwad.components.ad.splashscreen.b.m.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void a() {
                    String d;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || com.kwad.sdk.core.response.a.a.I(com.kwad.sdk.core.response.a.d.i(((e) this.a).a.c)) || (d = ((e) this.a).a.d()) == null) {
                        return;
                    }
                    com.kwad.components.ad.splashscreen.h hVar = ((e) this.a).a;
                    hVar.a = true;
                    hVar.c.mMiniWindowId = d;
                }
            }));
            if (z2) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (((e) this).a != null) {
                    if (((e) this).a.e != null) {
                        jSONObject.put("duration", ((e) this).a.e.e());
                    }
                    if (z) {
                        i2 = 153;
                    } else if (z3) {
                        i2 = 132;
                    }
                    com.kwad.sdk.core.report.a.a(((e) this).a.c, i2, (y.a) null, jSONObject);
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.a(e);
            }
        }
    }

    public static boolean a(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, adInfo)) == null) ? adInfo.adSplashInfo.fullScreenClickSwitch == 1 : invokeL.booleanValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.d = bVar;
            bVar.a(((e) this).a.c);
            com.kwad.sdk.core.webview.b bVar2 = this.d;
            bVar2.a = 0;
            AdBaseFrameLayout adBaseFrameLayout = ((e) this).a.d;
            bVar2.b = adBaseFrameLayout;
            bVar2.d = adBaseFrameLayout;
            bVar2.e = this.c;
            bVar2.c = null;
            bVar2.g = false;
            bVar2.h = a(this.j);
        }
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String str = com.kwad.components.ad.splashscreen.a.b.a() != null ? com.kwad.components.ad.splashscreen.a.b.a().h5Url : "";
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            String i = i();
            String str = b;
            com.kwad.sdk.core.d.b.a(str, "startPreloadWebView url: " + i);
            if (at.a(i)) {
                e();
                return;
            }
            this.c.setVisibility(0);
            h();
            l();
            this.c.setClientConfig(this.c.getClientConfig().a(((e) this).a.c).a(k()));
            this.c.loadUrl(i);
        }
    }

    @NonNull
    private KsAdWebView.d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.splashscreen.b.m.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                    this.a.e();
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            m();
            this.c.getSettings().setAllowFileAccess(true);
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.c);
            this.e = aVar;
            a(aVar);
            this.c.addJavascriptInterface(this.e, "KwaiAd");
        }
    }

    private void m() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (aVar = this.e) == null) {
            return;
        }
        aVar.a();
        this.e = null;
    }

    private int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            if (((e) this).a.g instanceof SceneImpl) {
                return com.kwad.components.ad.splashscreen.local.d.a(u(), this.j, (SceneImpl) ((e) this).a.g);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private com.kwad.components.core.webview.jshandler.d v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) ? new com.kwad.components.core.webview.jshandler.d(this.d, ((e) this).a.f, new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.splashscreen.b.m.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || com.kwad.sdk.b.kwai.a.a()) {
                    return;
                }
                if (aVar.a() || m.a(this.a.j)) {
                    u.b bVar = new u.b();
                    bVar.j = aVar.d.b;
                    this.a.a(false, aVar.c, bVar);
                }
            }
        }) : (com.kwad.components.core.webview.jshandler.d) invokeV.objValue;
    }

    private com.kwad.components.core.webview.jshandler.f w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? new com.kwad.components.core.webview.jshandler.f(this.d, ((e) this).a.f, new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.splashscreen.b.m.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    if (aVar.b || !m.a(this.a.j)) {
                        this.a.a(false, aVar.b ? 1 : 3, null);
                    }
                }
            }
        }) : (com.kwad.components.core.webview.jshandler.f) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.c = (KsAdWebView) ((e) this).a.d.findViewById(R.id.obfuscated_res_0x7f0911b4);
            this.g = (ViewStub) ((e) this).a.d.findViewById(R.id.obfuscated_res_0x7f0911a1);
            this.j = com.kwad.sdk.core.response.a.d.i(((e) this).a.c);
            com.kwad.components.ad.splashscreen.d.b bVar = new com.kwad.components.ad.splashscreen.d.b((ViewGroup) q(), this.g, this.c, com.kwad.sdk.core.response.a.c.d(((e) this).a.c), ((e) this).a.f);
            this.f = bVar;
            bVar.a(((e) this).a.c);
            this.f.a(this);
            this.c.setBackgroundColor(0);
            this.c.getBackground().setAlpha(0);
            this.c.setVisibility(0);
            this.h = false;
            j();
            az.a(this.i, null, 1000L);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.f
    public final void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            String str = b;
            com.kwad.sdk.core.d.b.a(str, "isClick: " + z + ", isActionBar: " + z2);
            a(!z, z2 ? 1 : 2, null);
        }
    }

    @SuppressLint({"WrongConstant"})
    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.h) {
            return;
        }
        this.h = true;
        u.b bVar = new u.b();
        u.a aVar = new u.a();
        aVar.b = n();
        bVar.B = aVar;
        com.kwad.sdk.core.report.a.a(((e) this).a.c, 123, bVar, (JSONObject) null);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f == null) {
            return;
        }
        d();
        this.f.a();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.k_();
            m();
            com.kwad.components.ad.splashscreen.d.b bVar = this.f;
            if (bVar != null) {
                bVar.b();
            }
        }
    }
}
