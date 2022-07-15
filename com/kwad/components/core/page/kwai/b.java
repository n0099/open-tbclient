package com.kwad.components.core.page.kwai;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.page.recycle.NestedScrollWebView;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public final class b extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.webview.a a;
    public com.kwad.sdk.core.webview.b b;
    public NestedScrollWebView c;
    public AdTemplate d;
    public u.b e;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new u.b(this) { // from class: com.kwad.components.core.page.kwai.b.1
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

            @Override // com.kwad.components.core.webview.jshandler.u.b
            public final void a(u.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                }
            }
        };
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, aVar) == null) {
            aVar.a(new i(this.b));
            aVar.a(new l(this.b));
            aVar.a(new u(this.e, com.kwad.sdk.core.response.a.a.N(com.kwad.sdk.core.response.a.d.i(this.d))));
            aVar.a(new p(this.b));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            e();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.c);
            this.a = aVar;
            a(aVar);
            this.c.addJavascriptInterface(this.a, "KwaiAd");
        }
    }

    private void e() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.a();
        this.a = null;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.b = bVar;
            bVar.a(this.d);
            com.kwad.sdk.core.webview.b bVar2 = this.b;
            bVar2.a = 0;
            bVar2.e = this.c;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.d = ((com.kwad.components.core.page.recycle.e) t()).c;
            NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) q().findViewById(R.id.obfuscated_res_0x7f0911e8);
            this.c = nestedScrollWebView;
            this.c.setClientConfig(nestedScrollWebView.getClientConfig().a(this.d));
            this.c.setNestedScrollingEnabled(true);
            g();
            d();
            this.c.loadUrl(com.kwad.sdk.core.response.a.a.N(com.kwad.sdk.core.response.a.d.i(this.d)));
            this.c.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void e_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.e_();
            e();
            NestedScrollWebView nestedScrollWebView = this.c;
            if (nestedScrollWebView != null) {
                nestedScrollWebView.c();
                this.c = null;
            }
        }
    }
}
