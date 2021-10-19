package com.kwad.sdk.core.page.a;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
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
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ay;
/* loaded from: classes10.dex */
public class b extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f72393a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f72394b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f72395c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f72396d;

    /* renamed from: e  reason: collision with root package name */
    public m.b f72397e;

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
        this.f72397e = new m.b(this) { // from class: com.kwad.sdk.core.page.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f72398a;

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
                this.f72398a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
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
            gVar.a(new e(this.f72394b));
            gVar.a(new f(this.f72394b));
            gVar.a(new m(this.f72397e));
            gVar.a(new j(this.f72394b));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            f();
            ay.a(this.f72395c);
            g gVar = new g(this.f72395c);
            this.f72393a = gVar;
            a(gVar);
            this.f72395c.addJavascriptInterface(this.f72393a, "KwaiAd");
        }
    }

    private void f() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (gVar = this.f72393a) == null) {
            return;
        }
        gVar.a();
        this.f72393a = null;
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f72394b = aVar;
            aVar.f72777b = this.f72396d;
            aVar.f72776a = 0;
            aVar.f72781f = this.f72395c;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f72396d = ((com.kwad.sdk.core.page.recycle.e) l()).f72456c;
            NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) j().findViewById(R.id.ksad_video_webView);
            this.f72395c = nestedScrollWebView;
            nestedScrollWebView.setTemplateData(this.f72396d);
            this.f72395c.setNestedScrollingEnabled(true);
            n();
            e();
            this.f72395c.loadUrl(com.kwad.sdk.core.response.b.a.y(c.i(this.f72396d)));
            this.f72395c.a();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            f();
            this.f72395c.b();
        }
    }
}
