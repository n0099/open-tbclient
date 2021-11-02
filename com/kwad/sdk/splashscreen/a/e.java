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
    public com.kwad.sdk.splashscreen.d f66547a;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f66548b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f66549c;

    /* renamed from: d  reason: collision with root package name */
    public g f66550d;

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
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f66549c, this.f66547a.f66609g, new a.b(this) { // from class: com.kwad.sdk.splashscreen.a.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f66552a;

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
                    this.f66552a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(a.C1916a c1916a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1916a) == null) {
                        if (c1916a.f65283a || com.kwad.sdk.core.config.c.J()) {
                            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f66552a.f66547a.f66603a;
                            if (splashScreenAdInteractionListener != null) {
                                splashScreenAdInteractionListener.onAdClicked();
                            }
                            com.kwad.sdk.core.download.b.a.a(this.f66552a.f66547a.f66607e.getContext(), this.f66552a.f66547a.f66606d, new a.InterfaceC1901a(this) { // from class: com.kwad.sdk.splashscreen.a.e.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass2 f66553a;

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
                                    this.f66553a = this;
                                }

                                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1901a
                                public void a() {
                                    String d2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.i(this.f66553a.f66552a.f66547a.f66606d)) || (d2 = this.f66553a.f66552a.f66547a.d()) == null) {
                                        return;
                                    }
                                    com.kwad.sdk.splashscreen.d dVar = this.f66553a.f66552a.f66547a;
                                    dVar.f66604b = true;
                                    dVar.f66606d.mMiniWindowId = d2;
                                }
                            }, this.f66552a.f66547a.f66609g, c1916a.f65283a);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                if (this.f66552a.f66547a != null) {
                                    if (this.f66552a.f66547a.f66608f != null) {
                                        jSONObject.put("duration", this.f66552a.f66547a.f66608f.c());
                                    }
                                    com.kwad.sdk.core.report.a.a(this.f66552a.f66547a.f66606d, 132, (v.a) null, jSONObject);
                                }
                            } catch (JSONException e2) {
                                com.kwad.sdk.core.d.a.a(e2);
                            }
                        }
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f66549c));
            gVar.a(new com.kwad.sdk.core.webview.b.g());
            gVar.a(new m(new m.b(this) { // from class: com.kwad.sdk.splashscreen.a.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f66554a;

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
                    this.f66554a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.m.b
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) && i2 == 1) {
                        com.kwad.sdk.core.report.a.c(this.f66554a.f66547a.f66606d, 123, null);
                    }
                }
            }));
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f66549c = aVar;
            com.kwad.sdk.splashscreen.d dVar = this.f66547a;
            aVar.f65227b = dVar.f66606d;
            aVar.f65226a = 0;
            AdBaseFrameLayout adBaseFrameLayout = dVar.f66607e;
            aVar.f65228c = adBaseFrameLayout;
            aVar.f65230e = adBaseFrameLayout;
            aVar.f65231f = this.f66548b;
            aVar.f65229d = null;
            aVar.f65233h = false;
            aVar.f65234i = com.kwad.sdk.core.config.c.J();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            p();
            ay.a(this.f66548b).setAllowFileAccess(true);
            g gVar = new g(this.f66548b);
            this.f66550d = gVar;
            a(gVar);
            this.f66548b.addJavascriptInterface(this.f66550d, "KwaiAd");
        }
    }

    private void p() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (gVar = this.f66550d) == null) {
            return;
        }
        gVar.a();
        this.f66550d = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.splashscreen.d dVar = (com.kwad.sdk.splashscreen.d) l();
            this.f66547a = dVar;
            KsAdWebView ksAdWebView = (KsAdWebView) dVar.f66607e.findViewById(R.id.ksad_splash_web_card_webView);
            this.f66548b = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.f66548b.getBackground().setAlpha(0);
            this.f66548b.setVisibility(0);
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
                this.f66548b.setVisibility(8);
                return;
            }
            this.f66548b.setVisibility(0);
            n();
            o();
            this.f66548b.loadUrl(e2);
            this.f66548b.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.splashscreen.a.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f66551a;

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
                    this.f66551a = this;
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
                        this.f66551a.f66548b.setVisibility(8);
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
