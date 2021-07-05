package com.kwad.sdk.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
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
import com.kwad.sdk.core.webview.jshandler.e;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ar;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f34271a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f34272b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f34273c;

    /* renamed from: d  reason: collision with root package name */
    public WebView f34274d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f34275e;

    /* renamed from: f  reason: collision with root package name */
    public int f34276f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f34277g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34278h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public a.b f34279i;
    public g j;
    public com.kwad.sdk.core.webview.a k;
    public int l;
    public n m;
    public h.a n;
    public k.b o;

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
        this.l = -1;
        this.n = new h.a(this) { // from class: com.kwad.sdk.c.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f34280a;

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
                this.f34280a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34280a.h();
                }
            }
        };
        this.o = new k.b(this) { // from class: com.kwad.sdk.c.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f34281a;

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
                this.f34281a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f34281a.l = i4;
                    com.kwad.sdk.core.d.a.b("PlayEndWebCard", "updatePageStatus mPageState: " + i4);
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
        this.l = -1;
        this.n = new h.a(this) { // from class: com.kwad.sdk.c.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f34280a;

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
                this.f34280a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34280a.h();
                }
            }
        };
        this.o = new k.b(this) { // from class: com.kwad.sdk.c.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f34281a;

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
                this.f34281a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f34281a.l = i4;
                    com.kwad.sdk.core.d.a.b("PlayEndWebCard", "updatePageStatus mPageState: " + i4);
                }
            }
        };
        this.f34275e = jSONObject;
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.k, this.f34278h, this.f34279i));
            gVar.a(new e(this.k));
            gVar.a(new f(this.k));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.k));
            gVar.a(new k(this.o));
            n nVar = new n();
            this.m = nVar;
            gVar.a(nVar);
            gVar.a(new o(this.k, this.f34278h));
            gVar.a(new h(this.n));
            gVar.a(new j(this.k));
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.f34273c.removeAllViews();
            this.f34273c.setVisibility(4);
            this.f34271a = ao.a((ViewGroup) this.f34273c, a(), true);
            WebView webView = (WebView) this.f34273c.findViewById(R.id.ksad_web_card_webView);
            this.f34274d = webView;
            webView.setBackgroundColor(0);
            this.f34274d.getBackground().setAlpha(0);
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.k = aVar;
            aVar.f36790b = this.f34277g;
            aVar.f36789a = this.f34276f;
            aVar.f36791c = this.f34272b;
            aVar.f36793e = this.f34273c;
            aVar.f36794f = this.f34274d;
            aVar.f36792d = this.f34275e;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            m();
            WebSettings a2 = ar.a(this.f34274d);
            a2.setAllowContentAccess(false);
            a2.setAllowFileAccess(true);
            g gVar = new g(this.f34274d);
            this.j = gVar;
            a(gVar);
            this.f34274d.addJavascriptInterface(this.j, "KwaiAd");
        }
    }

    private void m() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (gVar = this.j) == null) {
            return;
        }
        gVar.a();
        this.j = null;
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            int i2 = this.l;
            String str = i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
            Log.w("PlayEndWebCard", "show webCard fail, reason: " + str);
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ksad_ad_web_card_layout : invokeV.intValue;
    }

    public String a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate)) == null) {
            String str = com.kwad.sdk.core.response.b.b.q(adTemplate).playEndInfo.adWebCardInfo.cardUrl;
            if (com.kwad.sdk.core.config.a.a(str)) {
                return str;
            }
            com.kwad.sdk.core.d.a.d("PlayEndWebCard", "url host is invalid: " + str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
        }
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, frameLayout, adBaseFrameLayout, adTemplate, bVar) == null) {
            a(frameLayout, adBaseFrameLayout, adTemplate, bVar, 0);
        }
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.b.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{frameLayout, adBaseFrameLayout, adTemplate, bVar, Integer.valueOf(i2)}) == null) {
            this.f34278h = bVar;
            this.f34272b = adBaseFrameLayout;
            this.f34273c = frameLayout;
            this.f34276f = i2;
            this.f34277g = adTemplate;
            j();
            k();
        }
    }

    public void a(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f34279i = bVar;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l == 1 : invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            m();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!b()) {
                n();
                return false;
            }
            n nVar = this.m;
            if (nVar != null) {
                nVar.c();
            }
            this.f34273c.setVisibility(0);
            n nVar2 = this.m;
            if (nVar2 != null) {
                nVar2.d();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public a.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f34279i : (a.b) invokeV.objValue;
    }

    public WebView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f34274d : (WebView) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f34273c.setVisibility(4);
            this.l = -1;
            String a2 = a(this.f34277g);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            l();
            this.f34274d.loadUrl(a2);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && ao.a((View) this.f34274d, 50, false)) {
            n nVar = this.m;
            if (nVar != null) {
                nVar.e();
            }
            this.f34273c.setVisibility(4);
            n nVar2 = this.m;
            if (nVar2 != null) {
                nVar2.f();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            m();
        }
    }
}
