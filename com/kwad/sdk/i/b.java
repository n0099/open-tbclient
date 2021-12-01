package com.kwad.sdk.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.kwai.g;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.be;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58633b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f58634c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f58635d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdWebView f58636e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f58637f;

    /* renamed from: g  reason: collision with root package name */
    public int f58638g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f58639h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58640i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public b.c f58641j;

    /* renamed from: k  reason: collision with root package name */
    public g f58642k;
    public com.kwad.sdk.core.webview.a l;
    public int m;
    public s n;
    public i.b o;
    public p.b p;

    public b() {
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
        this.f58633b = false;
        this.o = new i.b(this) { // from class: com.kwad.sdk.i.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.a.e();
                }
            }
        };
        this.p = new p.b(this) { // from class: com.kwad.sdk.i.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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

            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.a.m = aVar.a;
                    com.kwad.sdk.core.d.a.c("PlayEndWebCard", "updatePageStatus mPageState: " + aVar);
                }
            }
        };
    }

    public b(@Nullable JSONObject jSONObject) {
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
        this.f58633b = false;
        this.o = new i.b(this) { // from class: com.kwad.sdk.i.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.a.e();
                }
            }
        };
        this.p = new p.b(this) { // from class: com.kwad.sdk.i.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.a.m = aVar.a;
                    com.kwad.sdk.core.d.a.c("PlayEndWebCard", "updatePageStatus mPageState: " + aVar);
                }
            }
        };
        this.f58637f = jSONObject;
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.l, this.f58640i, this.f58641j));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.l, this.f58640i, this.f58641j));
            gVar.a(new f(this.l));
            gVar.a(new com.kwad.sdk.core.webview.a.g());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.l));
            gVar.a(new d(this.l));
            gVar.a(new p(this.p));
            s sVar = new s();
            this.n = sVar;
            gVar.a(sVar);
            gVar.a(new t(this.l, this.f58640i));
            gVar.a(new i(this.o));
            gVar.a(new k(this.l));
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f58635d.removeAllViews();
            this.f58635d.setVisibility(4);
            this.a = com.kwad.sdk.a.kwai.a.a((ViewGroup) this.f58635d, a(), true);
            KsAdWebView ksAdWebView = (KsAdWebView) this.f58635d.findViewById(R.id.ksad_web_card_webView);
            this.f58636e = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.f58636e.getBackground().setAlpha(0);
            this.f58636e.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.i.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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
                public void a(int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
                        this.a.f58633b = false;
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.a.f58633b = true;
                    }
                }
            });
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.l = aVar;
            aVar.a(this.f58639h);
            com.kwad.sdk.core.webview.a aVar2 = this.l;
            aVar2.a = this.f58638g;
            aVar2.f57955b = this.f58634c;
            aVar2.f57957d = this.f58635d;
            aVar2.f57958e = this.f58636e;
            aVar2.f57956c = this.f58637f;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            k();
            WebSettings a = be.a(this.f58636e);
            a.setAllowContentAccess(false);
            a.setAllowFileAccess(true);
            g gVar = new g(this.f58636e);
            this.f58642k = gVar;
            a(gVar);
            this.f58636e.addJavascriptInterface(this.f58642k, "KwaiAd");
        }
    }

    private void k() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (gVar = this.f58642k) == null) {
            return;
        }
        gVar.a();
        this.f58642k = null;
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            int i2 = this.m;
            String str = "show webCard fail, reason: " + (i2 == -1 ? com.alipay.sdk.data.a.O : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate)) == null) ? com.kwad.sdk.core.response.a.b.g(this.f58639h) : (String) invokeL.objValue;
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, frameLayout, adBaseFrameLayout, adTemplate, bVar) == null) {
            a(frameLayout, adBaseFrameLayout, adTemplate, bVar, 0);
        }
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{frameLayout, adBaseFrameLayout, adTemplate, bVar, Integer.valueOf(i2)}) == null) {
            this.f58640i = bVar;
            this.f58634c = adBaseFrameLayout;
            this.f58635d = frameLayout;
            this.f58638g = i2;
            this.f58639h = adTemplate;
            h();
            i();
        }
    }

    public void a(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f58641j = cVar;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f58635d.setVisibility(4);
            this.m = -1;
            String a = a(this.f58639h);
            if (TextUtils.isEmpty(a)) {
                return;
            }
            j();
            this.f58636e.loadUrl(a);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m == 1 : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!c()) {
                FrameLayout frameLayout = this.f58635d;
                if (frameLayout != null) {
                    frameLayout.setVisibility(4);
                }
                l();
                return false;
            }
            s sVar = this.n;
            if (sVar != null) {
                sVar.c();
            }
            FrameLayout frameLayout2 = this.f58635d;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            s sVar2 = this.n;
            if (sVar2 != null) {
                sVar2.d();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && bb.a(this.f58636e, 50, false)) {
            s sVar = this.n;
            if (sVar != null) {
                sVar.e();
            }
            this.f58635d.setVisibility(4);
            s sVar2 = this.n;
            if (sVar2 != null) {
                sVar2.f();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            k();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            k();
        }
    }
}
