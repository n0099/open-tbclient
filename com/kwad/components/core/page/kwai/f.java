package com.kwad.components.core.page.kwai;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class f extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.core.webview.b b;
    public WebView c;
    public int d;
    public com.kwad.components.core.webview.a e;
    public ViewGroup f;
    public final a g;
    public AdTemplate h;
    public final boolean i;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i);
    }

    public f(a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = -1;
        this.g = aVar;
        this.i = z;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, aVar) == null) {
            com.kwad.sdk.core.d.b.a("LandPageWebViewPresenter", "registerWebCardHandler");
            com.kwad.components.core.c.a.b bVar = new com.kwad.components.core.c.a.b(((c) this).a.K);
            aVar.a(new i(this.b));
            aVar.a(new l(this.b));
            aVar.a(new z(this.b, bVar));
            aVar.a(new h(this.b));
            aVar.a(new x());
            aVar.a(new u(g(), com.kwad.sdk.core.response.a.b.k(this.h)));
            aVar.a(new p(this.b));
            aVar.a(new t(h()));
            aVar.a(new com.kwad.components.core.webview.jshandler.f(this.b, bVar, null));
            aVar.a(new com.kwad.components.core.webview.jshandler.d(this.b, bVar, null, 2, this.i));
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            e();
            this.c.loadUrl(str);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.b = bVar;
            bVar.a(this.h);
            com.kwad.sdk.core.webview.b bVar2 = this.b;
            bVar2.d = this.f;
            bVar2.e = this.c;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            i();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.c);
            this.e = aVar;
            a(aVar);
            this.c.addJavascriptInterface(this.e, "KwaiAd");
        }
    }

    private u.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? new u.b(this) { // from class: com.kwad.components.core.page.kwai.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

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
            public final void a(u.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.a.d = aVar.a;
                    if (this.a.g != null) {
                        this.a.g.a(aVar.a);
                    }
                    if (aVar.a == 1) {
                        this.a.f.setVisibility(0);
                    } else {
                        this.a.c.setVisibility(8);
                    }
                }
            }
        } : (u.b) invokeV.objValue;
    }

    private t.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? new t.a(this) { // from class: com.kwad.components.core.page.kwai.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

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

            @Override // com.kwad.components.core.webview.jshandler.t.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    AdWebViewActivityProxy.launch(this.a.c.getContext(), new AdWebViewActivityProxy.a.C0514a().a(bVar.b).b(bVar.a).a(this.a.h).a());
                }
            }
        } : (t.a) invokeV.objValue;
    }

    private void i() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (aVar = this.e) == null) {
            return;
        }
        aVar.a();
        this.e = null;
    }

    @Override // com.kwad.components.core.page.kwai.c, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((c) this).a.K;
            this.h = adTemplate;
            String k = com.kwad.sdk.core.response.a.b.k(adTemplate);
            if (!TextUtils.isEmpty(k)) {
                d();
                a(k);
                return;
            }
            a aVar = this.g;
            if (aVar != null) {
                aVar.a(this.d);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
            this.c = (WebView) b(R.id.obfuscated_res_0x7f09107f);
            this.f = (ViewGroup) b(R.id.obfuscated_res_0x7f0911ea);
            this.c.setBackgroundColor(0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.k_();
            i();
        }
    }
}
