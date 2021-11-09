package com.kwad.sdk.core.download.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.utils.ay;
import java.io.File;
/* loaded from: classes2.dex */
public class f extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f64464b;

    /* renamed from: c  reason: collision with root package name */
    public i.a f64465c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo.DownloadSafeInfo f64466d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f64467e;

    /* renamed from: f  reason: collision with root package name */
    public g f64468f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f64469g;

    /* renamed from: h  reason: collision with root package name */
    public p f64470h;

    /* renamed from: i  reason: collision with root package name */
    public String f64471i;
    public boolean j;
    public a.b k;
    public i.b l;
    public h.a m;
    public m.b n;

    public f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = false;
        this.k = new a.b(this) { // from class: com.kwad.sdk.core.download.a.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f64472a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
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
                this.f64472a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C1916a c1916a) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1916a) == null) {
                    com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + this.f64472a.j);
                    this.f64472a.j = true;
                }
            }
        };
        this.l = new i.b(this) { // from class: com.kwad.sdk.core.download.a.f.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f64474a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
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
                this.f64474a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
                    this.f64474a.f64465c = aVar;
                    this.f64474a.f64464b.setTranslationY((float) (aVar.f65341a + aVar.f65344d));
                }
            }
        };
        this.m = new h.a(this) { // from class: com.kwad.sdk.core.download.a.f.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f64475a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
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
                this.f64475a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
                    this.f64475a.s();
                }
            }
        };
        this.n = new m.b(this) { // from class: com.kwad.sdk.core.download.a.f.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f64476a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
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
                this.f64476a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    com.kwad.sdk.core.d.a.c("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + i4);
                }
            }
        };
        this.f64471i = str;
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, gVar) == null) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "registerWebCardHandler");
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f64469g, this.f64467e, this.k));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f64469g));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f64469g));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f64469g));
            gVar.a(new i(this.f64469g, this.l));
            gVar.a(new m(this.n));
            p pVar = new p();
            this.f64470h = pVar;
            gVar.a(pVar);
            gVar.a(new q(this.f64469g, this.f64467e));
            gVar.a(new h(this.m));
            gVar.a(new j(this.f64469g));
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f64464b.setVisibility(8);
            this.f64464b.c();
            r();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f64469g = aVar;
            d dVar = ((c) this).f64458a;
            aVar.f65226b = dVar.f64462d;
            aVar.f65225a = dVar.f64459a;
            AdBaseFrameLayout adBaseFrameLayout = dVar.f64461c;
            aVar.f65227c = adBaseFrameLayout;
            aVar.f65229e = adBaseFrameLayout;
            aVar.f65230f = this.f64464b;
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            o();
            this.f64464b.setBackgroundColor(0);
            this.f64464b.getBackground().setAlpha(0);
            this.f64464b.setVisibility(0);
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "downloadPanelUrl=" + this.f64466d.windowPopUrl);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
            r();
            ay.b(this.f64464b);
            this.f64464b.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.core.download.a.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f64473a;

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
                    this.f64473a = this;
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
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }
            });
            g gVar = new g(this.f64464b);
            this.f64468f = gVar;
            a(gVar);
            this.f64464b.addJavascriptInterface(this.f64468f, "KwaiAd");
            String p = p();
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "getUrl: " + p);
            this.f64464b.loadUrl(p);
        }
    }

    private String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (TextUtils.isEmpty(this.f64471i)) {
                String q = q();
                return TextUtils.isEmpty(q) ? this.f64466d.windowPopUrl : q;
            }
            return this.f64471i;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String q() {
        InterceptResult invokeV;
        String str;
        StringBuilder sb;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65548, this)) != null) {
            return (String) invokeV.objValue;
        }
        if (m() != null) {
            File b2 = com.kwad.sdk.core.config.c.b(m());
            if (b2.exists()) {
                str = Uri.fromFile(b2).toString();
                sb = new StringBuilder();
                str2 = "getPreloadUrl preloadUrl ";
            } else if (com.kwad.sdk.core.config.c.d() != null) {
                str = com.kwad.sdk.core.config.c.d().h5Url;
                sb = new StringBuilder();
                str2 = "getPreloadUrl getDownloadPopWindowConfig ";
            }
            sb.append(str2);
            sb.append(str);
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", sb.toString());
            return str != null ? "" : str;
        }
        str = null;
        if (str != null) {
        }
    }

    private void r() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (gVar = this.f64468f) == null) {
            return;
        }
        gVar.a();
        this.f64468f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.j);
            if (this.f64464b.getVisibility() != 0) {
                return;
            }
            p pVar = this.f64470h;
            if (pVar != null) {
                pVar.e();
            }
            this.f64464b.setVisibility(4);
            p pVar2 = this.f64470h;
            if (pVar2 != null) {
                pVar2.f();
            }
            e eVar = ((c) this).f64458a.f64460b;
            if (eVar != null) {
                eVar.a(this.j);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f64466d = com.kwad.sdk.core.response.b.a.V(com.kwad.sdk.core.response.b.c.i(((c) this).f64458a.f64462d));
            this.f64467e = ((c) this).f64458a.f64463e;
            f();
            n();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f64464b = (KsAdWebView) a(R.id.ksad_download_tips_web_card_webView);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            e();
        }
    }
}
