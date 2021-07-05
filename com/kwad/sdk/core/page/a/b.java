package com.kwad.sdk.core.page.a;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.recycle.NestedScrollWebView;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.e;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ar;
/* loaded from: classes7.dex */
public class b extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f36396a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f36397b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f36398c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f36399d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f36400e;

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
        this.f36400e = new k.b(this) { // from class: com.kwad.sdk.core.page.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36401a;

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
                this.f36401a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                }
            }
        };
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, gVar) == null) {
            gVar.a(new d());
            gVar.a(new e(this.f36397b));
            gVar.a(new f(this.f36397b));
            gVar.a(new k(this.f36400e));
            gVar.a(new j(this.f36397b));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            f();
            ar.a(this.f36398c);
            g gVar = new g(this.f36398c);
            this.f36396a = gVar;
            a(gVar);
            this.f36398c.addJavascriptInterface(this.f36396a, "KwaiAd");
        }
    }

    private void f() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (gVar = this.f36396a) == null) {
            return;
        }
        gVar.a();
        this.f36396a = null;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f36397b = aVar;
            aVar.f36790b = this.f36399d;
            aVar.f36789a = 0;
            aVar.f36794f = this.f36398c;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f36399d = ((com.kwad.sdk.core.page.recycle.e) n()).f36434c;
            NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) l().findViewById(R.id.ksad_video_webView);
            this.f36398c = nestedScrollWebView;
            nestedScrollWebView.setTemplateData(this.f36399d);
            this.f36398c.setNestedScrollingEnabled(true);
            g();
            e();
            this.f36398c.loadUrl(com.kwad.sdk.core.response.b.a.B(c.j(this.f36399d)));
            this.f36398c.d();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            f();
            this.f36398c.e();
        }
    }
}
