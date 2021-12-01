package com.kwad.sdk.core.page.kwai;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.recycle.NestedScrollWebView;
import com.kwad.sdk.core.page.recycle.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.kwai.g;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.be;
/* loaded from: classes2.dex */
public class b extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f57563b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f57564c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f57565d;

    /* renamed from: e  reason: collision with root package name */
    public p.b f57566e;

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
        this.f57566e = new p.b(this) { // from class: com.kwad.sdk.core.page.kwai.b.1
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
                }
            }
        };
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, gVar) == null) {
            gVar.a(new f(this.f57563b));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f57563b));
            gVar.a(new p(this.f57566e));
            gVar.a(new k(this.f57563b));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            f();
            be.a(this.f57564c);
            g gVar = new g(this.f57564c);
            this.a = gVar;
            a(gVar);
            this.f57564c.addJavascriptInterface(this.a, "KwaiAd");
        }
    }

    private void f() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (gVar = this.a) == null) {
            return;
        }
        gVar.a();
        this.a = null;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f57563b = aVar;
            aVar.a(this.f57565d);
            com.kwad.sdk.core.webview.a aVar2 = this.f57563b;
            aVar2.a = 0;
            aVar2.f57958e = this.f57564c;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f57565d = ((e) p()).f57604c;
            NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) m().findViewById(R.id.ksad_video_webView);
            this.f57564c = nestedScrollWebView;
            nestedScrollWebView.setTemplateData(this.f57565d);
            this.f57564c.setNestedScrollingEnabled(true);
            g();
            e();
            this.f57564c.loadUrl(com.kwad.sdk.core.response.a.a.G(com.kwad.sdk.core.response.a.d.j(this.f57565d)));
            this.f57564c.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d_();
            f();
            NestedScrollWebView nestedScrollWebView = this.f57564c;
            if (nestedScrollWebView != null) {
                nestedScrollWebView.c();
                this.f57564c = null;
            }
        }
    }
}
