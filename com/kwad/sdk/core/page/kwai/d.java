package com.kwad.sdk.core.page.kwai;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.kwai.i;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.be;
import java.io.File;
/* loaded from: classes2.dex */
public class d extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f57570b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f57571c;

    /* renamed from: d  reason: collision with root package name */
    public int f57572d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f57573e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f57574f;

    /* renamed from: g  reason: collision with root package name */
    public final a f57575g;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i2);
    }

    public d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57572d = -1;
        this.f57575g = aVar;
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            com.kwad.sdk.core.d.a.a("LandPageWebViewPresenter", "registerWebCardHandler");
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((g) this).a.f58874g);
            gVar.a(new f(this.f57570b));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f57570b));
            gVar.a(new t(this.f57570b, bVar));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f57570b));
            gVar.a(new s());
            gVar.a(new p(t()));
            gVar.a(new k(this.f57570b));
            gVar.a(new o(u()));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f57570b, bVar, null));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f57570b, bVar, (b.c) null));
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f57570b = aVar;
            aVar.a(((g) this).a.f58874g);
            com.kwad.sdk.core.webview.a aVar2 = this.f57570b;
            aVar2.a = ((g) this).a.f58873f;
            aVar2.f57957d = this.f57574f;
            aVar2.f57958e = this.f57571c;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String r() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65544, this)) != null) {
            return (String) invokeV.objValue;
        }
        if (q() != null) {
            File i2 = com.kwad.sdk.core.config.b.i(q());
            if (i2.exists()) {
                str = Uri.fromFile(i2).toString();
            } else if (com.kwad.sdk.core.config.b.e() != null) {
                str = com.kwad.sdk.core.config.b.e().h5Url;
            }
            return str != null ? "" : str;
        }
        str = null;
        if (str != null) {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            v();
            be.b(this.f57571c);
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f57571c);
            this.f57573e = gVar;
            a(gVar);
            this.f57571c.addJavascriptInterface(this.f57573e, "KwaiAd");
        }
    }

    private p.b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? new p.b(this) { // from class: com.kwad.sdk.core.page.kwai.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.a.f57572d = aVar.a;
                    if (this.a.f57575g != null) {
                        this.a.f57575g.a(aVar.a);
                    }
                    if (aVar.a == 1) {
                        this.a.f57574f.setVisibility(0);
                    } else {
                        this.a.f57571c.setVisibility(8);
                    }
                }
            }
        } : (p.b) invokeV.objValue;
    }

    private o.a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? new o.a(this) { // from class: com.kwad.sdk.core.page.kwai.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            @Override // com.kwad.sdk.core.webview.jshandler.o.a
            public void a(i iVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, iVar) == null) {
                    AdWebViewActivityProxy.launch(this.a.f57571c.getContext(), new AdWebViewActivityProxy.a.C2022a().a(iVar.f58113b).b(iVar.a).a(((g) this.a).a.f58874g).a());
                }
            }
        } : (o.a) invokeV.objValue;
    }

    private void v() {
        com.kwad.sdk.core.webview.kwai.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (gVar = this.f57573e) == null) {
            return;
        }
        gVar.a();
        this.f57573e = null;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            i();
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            v();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f57571c = (WebView) a(R.id.ksad_landing_page_webview);
            this.f57574f = (ViewGroup) a(R.id.ksad_web_card_container);
            this.f57571c.setBackgroundColor(0);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            s();
            if (!TextUtils.isEmpty(r())) {
                this.f57571c.loadUrl(r());
                return;
            }
            a aVar = this.f57575g;
            if (aVar != null) {
                aVar.a(this.f57572d);
            }
        }
    }
}
