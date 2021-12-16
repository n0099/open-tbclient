package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.z;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends Presenter implements com.kwad.sdk.splashscreen.f {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "SplashWebViewPresenter";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.g f60076b;

    /* renamed from: c  reason: collision with root package name */
    public KsAdWebView f60077c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f60078d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f60079e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c.a f60080f;

    /* renamed from: g  reason: collision with root package name */
    public ViewStub f60081g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f60082h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f60083i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1381681439, "Lcom/kwad/sdk/splashscreen/a/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1381681439, "Lcom/kwad/sdk/splashscreen/a/i;");
        }
    }

    public i() {
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
        this.f60082h = new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.i.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.f60080f == null) {
                    return;
                }
                this.a.f60080f.a();
            }
        };
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new t(this.f60078d, this.f60076b.f60161g));
            gVar.a(t());
            gVar.a(s());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f60078d));
            gVar.a(new com.kwad.sdk.core.webview.a.g());
            gVar.a(new p(new p.b(this) { // from class: com.kwad.sdk.splashscreen.a.i.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ i a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.p.b
                public void a(p.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        String str = i.a;
                        com.kwad.sdk.core.d.a.a(str, "updatePageStatus: " + aVar);
                        if (aVar.a != 1) {
                            this.a.f60080f.a();
                            return;
                        }
                        ax.b(this.a.f60082h);
                        com.kwad.sdk.core.report.a.c(this.a.f60076b.f60158d, 123, null);
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i2, @Nullable p.a aVar) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), aVar}) == null) {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f60076b.a;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdClicked();
            }
            boolean z2 = aVar != null;
            boolean z3 = i2 == 1;
            com.kwad.sdk.core.download.a.a.a(new a.C2076a(this.f60076b.f60159e.getContext()).a(this.f60076b.f60158d).a(this.f60076b.f60161g).a(z3).a(i2).a(aVar).c(z2).a(new a.b(this) { // from class: com.kwad.sdk.splashscreen.a.i.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ i a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    String d2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(this.a.f60076b.f60158d)) || (d2 = this.a.f60076b.d()) == null) {
                        return;
                    }
                    this.a.f60076b.f60156b = true;
                    this.a.f60076b.f60158d.mMiniWindowId = d2;
                }
            }));
            if (z2) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f60076b != null) {
                    if (this.f60076b.f60160f != null) {
                        jSONObject.put("duration", this.f60076b.f60160f.c());
                    }
                    if (z) {
                        i3 = 153;
                    } else {
                        i3 = z3 ? 132 : 0;
                    }
                    com.kwad.sdk.core.report.a.a(this.f60076b.f60158d, i3, (z.a) null, jSONObject);
                }
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
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
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f60078d = aVar;
            aVar.a(this.f60076b.f60158d);
            com.kwad.sdk.core.webview.a aVar2 = this.f60078d;
            aVar2.a = 0;
            AdBaseFrameLayout adBaseFrameLayout = this.f60076b.f60159e;
            aVar2.f58536b = adBaseFrameLayout;
            aVar2.f58538d = adBaseFrameLayout;
            aVar2.f58539e = this.f60077c;
            aVar2.f58537c = null;
            aVar2.f58542h = false;
            aVar2.f58543i = a(this.f60083i);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            r();
            be.a(this.f60077c).setAllowFileAccess(true);
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f60077c);
            this.f60079e = gVar;
            a(gVar);
            this.f60077c.addJavascriptInterface(this.f60079e, "KwaiAd");
        }
    }

    private void r() {
        com.kwad.sdk.core.webview.kwai.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (gVar = this.f60079e) == null) {
            return;
        }
        gVar.a();
        this.f60079e = null;
    }

    private com.kwad.sdk.core.webview.jshandler.a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? new com.kwad.sdk.core.webview.jshandler.a(this.f60078d, this.f60076b.f60161g, new b.c(this) { // from class: com.kwad.sdk.splashscreen.a.i.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || bb.a()) {
                    return;
                }
                if (aVar.a() || i.a(this.a.f60083i)) {
                    p.a aVar2 = new p.a();
                    aVar2.f58268h = aVar.f58570d.a;
                    this.a.a(false, aVar.f58569c, aVar2);
                }
            }
        }) : (com.kwad.sdk.core.webview.jshandler.a) invokeV.objValue;
    }

    private com.kwad.sdk.core.webview.jshandler.b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? new com.kwad.sdk.core.webview.jshandler.b(this.f60078d, this.f60076b.f60161g, new b.c(this) { // from class: com.kwad.sdk.splashscreen.a.i.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    if (aVar.f58568b || !i.a(this.a.f60083i)) {
                        this.a.a(false, aVar.f58568b ? 1 : 3, null);
                    }
                }
            }
        }) : (com.kwad.sdk.core.webview.jshandler.b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
            this.f60076b = gVar;
            this.f60077c = (KsAdWebView) gVar.f60159e.findViewById(R.id.ksad_splash_web_card_webView);
            this.f60081g = (ViewStub) this.f60076b.f60159e.findViewById(R.id.ksad_splash_actionbar_native_stub);
            this.f60083i = com.kwad.sdk.core.response.a.d.j(this.f60076b.f60158d);
            com.kwad.sdk.splashscreen.c.a aVar = new com.kwad.sdk.splashscreen.c.a(this.f60081g, this.f60077c, com.kwad.sdk.core.response.a.c.g(this.f60076b.f60158d), this.f60076b.f60161g);
            this.f60080f = aVar;
            aVar.a(this.f60076b.f60158d);
            this.f60080f.a(this);
            this.f60077c.setBackgroundColor(0);
            this.f60077c.getBackground().setAlpha(0);
            this.f60077c.setVisibility(0);
            f();
            ax.a(this.f60082h, null, 1000L);
        }
    }

    @Override // com.kwad.sdk.splashscreen.f
    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            String str = a;
            com.kwad.sdk.core.d.a.a(str, "isClick: " + z + ", isActionBar: " + z2);
            a(!z, z2 ? 1 : 2, null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            r();
            com.kwad.sdk.splashscreen.c.a aVar = this.f60080f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (q() != null) {
                File e2 = com.kwad.sdk.core.config.b.e(q());
                if (e2.exists()) {
                    return Uri.fromFile(e2).toString();
                }
                if (com.kwad.sdk.core.config.b.a() != null) {
                    return com.kwad.sdk.core.config.b.a().h5Url;
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String e2 = e();
            String str = a;
            com.kwad.sdk.core.d.a.a(str, "startPreloadWebView url: " + e2);
            if (at.a(e2)) {
                this.f60080f.a();
                return;
            }
            this.f60077c.setVisibility(0);
            h();
            i();
            this.f60077c.loadUrl(e2);
            this.f60077c.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.splashscreen.a.i.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ i a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2, str3) == null) {
                        this.a.f60080f.a();
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }
            });
        }
    }
}
