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
/* loaded from: classes2.dex */
public class e extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.d f67459a;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f67460b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f67461c;

    /* renamed from: d  reason: collision with root package name */
    public g f67462d;

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
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f67461c, this.f67459a.f67521g, new a.b(this) { // from class: com.kwad.sdk.splashscreen.a.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f67464a;

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
                    this.f67464a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(a.C1956a c1956a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1956a) == null) {
                        if (c1956a.f66195a || com.kwad.sdk.core.config.c.J()) {
                            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f67464a.f67459a.f67515a;
                            if (splashScreenAdInteractionListener != null) {
                                splashScreenAdInteractionListener.onAdClicked();
                            }
                            com.kwad.sdk.core.download.b.a.a(this.f67464a.f67459a.f67519e.getContext(), this.f67464a.f67459a.f67518d, new a.InterfaceC1941a(this) { // from class: com.kwad.sdk.splashscreen.a.e.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass2 f67465a;

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
                                    this.f67465a = this;
                                }

                                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1941a
                                public void a() {
                                    String d2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.i(this.f67465a.f67464a.f67459a.f67518d)) || (d2 = this.f67465a.f67464a.f67459a.d()) == null) {
                                        return;
                                    }
                                    com.kwad.sdk.splashscreen.d dVar = this.f67465a.f67464a.f67459a;
                                    dVar.f67516b = true;
                                    dVar.f67518d.mMiniWindowId = d2;
                                }
                            }, this.f67464a.f67459a.f67521g, c1956a.f66195a);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                if (this.f67464a.f67459a != null) {
                                    if (this.f67464a.f67459a.f67520f != null) {
                                        jSONObject.put("duration", this.f67464a.f67459a.f67520f.c());
                                    }
                                    com.kwad.sdk.core.report.a.a(this.f67464a.f67459a.f67518d, 132, (v.a) null, jSONObject);
                                }
                            } catch (JSONException e2) {
                                com.kwad.sdk.core.d.a.a(e2);
                            }
                        }
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f67461c));
            gVar.a(new com.kwad.sdk.core.webview.b.g());
            gVar.a(new m(new m.b(this) { // from class: com.kwad.sdk.splashscreen.a.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f67466a;

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
                    this.f67466a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.m.b
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) && i2 == 1) {
                        com.kwad.sdk.core.report.a.c(this.f67466a.f67459a.f67518d, 123, null);
                    }
                }
            }));
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f67461c = aVar;
            com.kwad.sdk.splashscreen.d dVar = this.f67459a;
            aVar.f66139b = dVar.f67518d;
            aVar.f66138a = 0;
            AdBaseFrameLayout adBaseFrameLayout = dVar.f67519e;
            aVar.f66140c = adBaseFrameLayout;
            aVar.f66142e = adBaseFrameLayout;
            aVar.f66143f = this.f67460b;
            aVar.f66141d = null;
            aVar.f66145h = false;
            aVar.f66146i = com.kwad.sdk.core.config.c.J();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            p();
            ay.a(this.f67460b).setAllowFileAccess(true);
            g gVar = new g(this.f67460b);
            this.f67462d = gVar;
            a(gVar);
            this.f67460b.addJavascriptInterface(this.f67462d, "KwaiAd");
        }
    }

    private void p() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (gVar = this.f67462d) == null) {
            return;
        }
        gVar.a();
        this.f67462d = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.splashscreen.d dVar = (com.kwad.sdk.splashscreen.d) l();
            this.f67459a = dVar;
            KsAdWebView ksAdWebView = (KsAdWebView) dVar.f67519e.findViewById(R.id.ksad_splash_web_card_webView);
            this.f67460b = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.f67460b.getBackground().setAlpha(0);
            this.f67460b.setVisibility(0);
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
                this.f67460b.setVisibility(8);
                return;
            }
            this.f67460b.setVisibility(0);
            n();
            o();
            this.f67460b.loadUrl(e2);
            this.f67460b.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.splashscreen.a.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f67463a;

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
                    this.f67463a = this;
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
                        this.f67463a.f67460b.setVisibility(8);
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
