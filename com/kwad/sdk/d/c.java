package com.kwad.sdk.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.e;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ay;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f66452a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66453b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f66454c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f66455d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f66456e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f66457f;

    /* renamed from: g  reason: collision with root package name */
    public int f66458g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f66459h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f66460i;
    @Nullable
    public a.b j;
    public g k;
    public com.kwad.sdk.core.webview.a l;
    public int m;
    public p n;
    public h.a o;
    public m.b p;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = -1;
        this.f66453b = false;
        this.o = new h.a(this) { // from class: com.kwad.sdk.d.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66462a;

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
                this.f66462a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f66462a.e();
                }
            }
        };
        this.p = new m.b(this) { // from class: com.kwad.sdk.d.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66463a;

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
                this.f66463a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f66463a.m = i4;
                    com.kwad.sdk.core.d.a.c("PlayEndWebCard", "updatePageStatus mPageState: " + i4);
                }
            }
        };
    }

    public c(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = -1;
        this.f66453b = false;
        this.o = new h.a(this) { // from class: com.kwad.sdk.d.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66462a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f66462a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f66462a.e();
                }
            }
        };
        this.p = new m.b(this) { // from class: com.kwad.sdk.d.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66463a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f66463a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f66463a.m = i4;
                    com.kwad.sdk.core.d.a.c("PlayEndWebCard", "updatePageStatus mPageState: " + i4);
                }
            }
        };
        this.f66457f = jSONObject;
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.l, this.f66460i, this.j));
            gVar.a(new e(this.l));
            gVar.a(new f(this.l));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.l));
            gVar.a(new m(this.p));
            p pVar = new p();
            this.n = pVar;
            gVar.a(pVar);
            gVar.a(new q(this.l, this.f66460i));
            gVar.a(new h(this.o));
            gVar.a(new j(this.l));
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f66455d.removeAllViews();
            this.f66455d.setVisibility(4);
            this.f66452a = av.a((ViewGroup) this.f66455d, b(), true);
            WebView webView = (WebView) this.f66455d.findViewById(R.id.ksad_web_card_webView);
            this.f66456e = webView;
            webView.setBackgroundColor(0);
            this.f66456e.getBackground().setAlpha(0);
            this.f66456e.setWebViewClient(new WebViewClient(this) { // from class: com.kwad.sdk.d.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f66461a;

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
                    this.f66461a = this;
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView2, str) == null) {
                        super.onPageFinished(webView2, str);
                        this.f66461a.f66453b = true;
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView2, webResourceRequest, webResourceError) == null) {
                        super.onReceivedError(webView2, webResourceRequest, webResourceError);
                        this.f66461a.f66453b = false;
                    }
                }
            });
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.l = aVar;
            aVar.f66139b = this.f66459h;
            aVar.f66138a = this.f66458g;
            aVar.f66140c = this.f66454c;
            aVar.f66142e = this.f66455d;
            aVar.f66143f = this.f66456e;
            aVar.f66141d = this.f66457f;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            k();
            WebSettings a2 = ay.a(this.f66456e);
            a2.setAllowContentAccess(false);
            a2.setAllowFileAccess(true);
            g gVar = new g(this.f66456e);
            this.k = gVar;
            a(gVar);
            this.f66456e.addJavascriptInterface(this.k, "KwaiAd");
        }
    }

    private void k() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (gVar = this.k) == null) {
            return;
        }
        gVar.a();
        this.k = null;
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            int i2 = this.m;
            String str = "show webCard fail, reason: " + (i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
        }
    }

    public String a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adTemplate)) == null) {
            String str = com.kwad.sdk.core.response.b.b.k(adTemplate).playEndInfo.adWebCardInfo.cardUrl;
            if (com.kwad.sdk.core.config.a.a(str)) {
                return str;
            }
            com.kwad.sdk.core.d.a.e("PlayEndWebCard", "url host is invalid: " + str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
        }
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, frameLayout, adBaseFrameLayout, adTemplate, bVar) == null) {
            a(frameLayout, adBaseFrameLayout, adTemplate, bVar, 0);
        }
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.b.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{frameLayout, adBaseFrameLayout, adTemplate, bVar, Integer.valueOf(i2)}) == null) {
            this.f66460i = bVar;
            this.f66454c = adBaseFrameLayout;
            this.f66455d = frameLayout;
            this.f66458g = i2;
            this.f66459h = adTemplate;
            h();
            i();
        }
    }

    public void a(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.j = bVar;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m == 1 : invokeV.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.layout.ksad_ad_web_card_layout : invokeV.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f66455d.setVisibility(4);
            this.m = -1;
            String a2 = a(this.f66459h);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            j();
            this.f66456e.loadUrl(a2);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!a()) {
                FrameLayout frameLayout = this.f66455d;
                if (frameLayout != null) {
                    frameLayout.setVisibility(4);
                }
                l();
                return false;
            }
            p pVar = this.n;
            if (pVar != null) {
                pVar.c();
            }
            FrameLayout frameLayout2 = this.f66455d;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            p pVar2 = this.n;
            if (pVar2 != null) {
                pVar2.d();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && av.a((View) this.f66456e, 50, false)) {
            p pVar = this.n;
            if (pVar != null) {
                pVar.e();
            }
            this.f66455d.setVisibility(4);
            p pVar2 = this.n;
            if (pVar2 != null) {
                pVar2.f();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            k();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            k();
        }
    }
}
