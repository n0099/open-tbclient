package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.v;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.d f74123a;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f74124b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f74125c;

    /* renamed from: d  reason: collision with root package name */
    public g f74126d;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f74125c, this.f74123a.f74188g, new a.b(this) { // from class: com.kwad.sdk.splashscreen.a.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f74128a;

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
                    this.f74128a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(a.C2004a c2004a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c2004a) == null) {
                        if (c2004a.f72798a || com.kwad.sdk.core.config.c.J()) {
                            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f74128a.f74123a.f74182a;
                            if (splashScreenAdInteractionListener != null) {
                                splashScreenAdInteractionListener.onAdClicked();
                            }
                            com.kwad.sdk.core.download.b.a.a(this.f74128a.f74123a.f74186e.getContext(), this.f74128a.f74123a.f74185d, new a.InterfaceC1990a(this) { // from class: com.kwad.sdk.splashscreen.a.e.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass2 f74129a;

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
                                    this.f74129a = this;
                                }

                                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1990a
                                public void a() {
                                    String d2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.i(this.f74129a.f74128a.f74123a.f74185d)) || (d2 = this.f74129a.f74128a.f74123a.d()) == null) {
                                        return;
                                    }
                                    com.kwad.sdk.splashscreen.d dVar = this.f74129a.f74128a.f74123a;
                                    dVar.f74183b = true;
                                    dVar.f74185d.mMiniWindowId = d2;
                                }
                            }, this.f74128a.f74123a.f74188g, c2004a.f72798a);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                if (this.f74128a.f74123a != null) {
                                    if (this.f74128a.f74123a.f74187f != null) {
                                        jSONObject.put("duration", this.f74128a.f74123a.f74187f.c());
                                    }
                                    com.kwad.sdk.core.report.a.a(this.f74128a.f74123a.f74185d, 132, (v.a) null, jSONObject);
                                }
                            } catch (JSONException e2) {
                                com.kwad.sdk.core.d.a.a(e2);
                            }
                        }
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f74125c));
            gVar.a(new com.kwad.sdk.core.webview.b.g());
            gVar.a(new m(new m.b(this) { // from class: com.kwad.sdk.splashscreen.a.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f74130a;

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
                    this.f74130a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.m.b
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) && i2 == 1) {
                        com.kwad.sdk.core.report.a.c(this.f74130a.f74123a.f74185d, 123, null);
                    }
                }
            }));
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f74125c = aVar;
            com.kwad.sdk.splashscreen.d dVar = this.f74123a;
            aVar.f72742b = dVar.f74185d;
            aVar.f72741a = 0;
            AdBaseFrameLayout adBaseFrameLayout = dVar.f74186e;
            aVar.f72743c = adBaseFrameLayout;
            aVar.f72745e = adBaseFrameLayout;
            aVar.f72746f = this.f74124b;
            aVar.f72744d = null;
            aVar.f72748h = false;
            aVar.f72749i = com.kwad.sdk.core.config.c.J();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            p();
            ay.a(this.f74124b).setAllowFileAccess(true);
            g gVar = new g(this.f74124b);
            this.f74126d = gVar;
            a(gVar);
            this.f74124b.addJavascriptInterface(this.f74126d, "KwaiAd");
        }
    }

    private void p() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (gVar = this.f74126d) == null) {
            return;
        }
        gVar.a();
        this.f74126d = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.splashscreen.d dVar = (com.kwad.sdk.splashscreen.d) l();
            this.f74123a = dVar;
            KsAdWebView ksAdWebView = (KsAdWebView) dVar.f74186e.findViewById(R.id.ksad_splash_web_card_webView);
            this.f74124b = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.f74124b.getBackground().setAlpha(0);
            this.f74124b.setVisibility(0);
            f();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            p();
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (m() != null) {
                File f2 = com.kwad.sdk.core.config.c.f(m());
                if (f2.exists()) {
                    return Uri.fromFile(f2).toString();
                }
                if (com.kwad.sdk.core.config.c.b() != null) {
                    return com.kwad.sdk.core.config.c.b().h5Url;
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String e2 = e();
            if (an.a(e2)) {
                this.f74124b.setVisibility(8);
                return;
            }
            this.f74124b.setVisibility(0);
            n();
            o();
            this.f74124b.loadUrl(e2);
            this.f74124b.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.splashscreen.a.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f74127a;

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
                    this.f74127a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
                        this.f74127a.f74124b.setVisibility(8);
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
