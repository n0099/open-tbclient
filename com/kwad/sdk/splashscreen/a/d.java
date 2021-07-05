package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ar;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f39235a;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f39236b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f39237c;

    /* renamed from: d  reason: collision with root package name */
    public g f39238d;

    public d() {
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
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f39237c, this.f39235a.f39279f, new a.b(this) { // from class: com.kwad.sdk.splashscreen.a.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f39240a;

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
                    this.f39240a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f39240a.f39235a.f39274a;
                        if (splashScreenAdInteractionListener != null) {
                            splashScreenAdInteractionListener.onAdClicked();
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (this.f39240a.f39235a != null && this.f39240a.f39235a.f39278e != null) {
                                jSONObject.put("duration", this.f39240a.f39235a.f39278e.c());
                            }
                        } catch (JSONException e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                        com.kwad.sdk.core.report.b.a(this.f39240a.f39235a.f39276c, jSONObject, (String) null);
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f39237c));
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f39237c = aVar;
            com.kwad.sdk.splashscreen.c cVar = this.f39235a;
            aVar.f36790b = cVar.f39276c;
            aVar.f36789a = 0;
            AdBaseFrameLayout adBaseFrameLayout = cVar.f39277d;
            aVar.f36791c = adBaseFrameLayout;
            aVar.f36793e = adBaseFrameLayout;
            aVar.f36794f = this.f39236b;
            aVar.f36792d = null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            p();
            ar.a(this.f39236b).setAllowFileAccess(true);
            g gVar = new g(this.f39236b);
            this.f39238d = gVar;
            a(gVar);
            this.f39236b.addJavascriptInterface(this.f39238d, "KwaiAd");
        }
    }

    private void p() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (gVar = this.f39238d) == null) {
            return;
        }
        gVar.a();
        this.f39238d = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
            this.f39235a = cVar;
            KsAdWebView ksAdWebView = (KsAdWebView) cVar.f39277d.findViewById(R.id.ksad_splash_web_card_webView);
            this.f39236b = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.f39236b.getBackground().setAlpha(0);
            this.f39236b.setVisibility(0);
            f();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            p();
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (o() != null) {
                File d2 = com.kwad.sdk.core.config.c.d(o());
                if (d2.exists()) {
                    return Uri.fromFile(d2).toString();
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
            if (TextUtils.isEmpty(e2)) {
                this.f39236b.setVisibility(8);
                return;
            }
            this.f39236b.setVisibility(0);
            g();
            h();
            this.f39236b.loadUrl(e2);
            this.f39236b.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.splashscreen.a.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f39239a;

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
                    this.f39239a = this;
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
                        this.f39239a.f39236b.setVisibility(8);
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
