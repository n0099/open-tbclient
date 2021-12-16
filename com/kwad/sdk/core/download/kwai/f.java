package com.kwad.sdk.core.download.kwai;

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
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.v;
import java.io.File;
/* loaded from: classes3.dex */
public class f extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f58001b;

    /* renamed from: c  reason: collision with root package name */
    public j.a f58002c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo.DownloadSafeInfo f58003d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58004e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f58005f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f58006g;

    /* renamed from: h  reason: collision with root package name */
    public s f58007h;

    /* renamed from: i  reason: collision with root package name */
    public String f58008i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f58009j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f58010k;
    public b.c l;
    public j.b m;
    public i.b n;
    public p.b o;

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
        this.f58010k = false;
        this.l = new b.c(this) { // from class: com.kwad.sdk.core.download.kwai.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + this.a.f58010k);
                    this.a.f58010k = true;
                }
            }
        };
        this.m = new j.b(this) { // from class: com.kwad.sdk.core.download.kwai.f.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.j.b
            public void a(j.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
                    this.a.f58002c = aVar;
                    this.a.f58001b.setTranslationY((float) (aVar.a + aVar.f58614d));
                }
            }
        };
        this.n = new i.b(this) { // from class: com.kwad.sdk.core.download.kwai.f.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
                    this.a.v();
                }
            }
        };
        this.o = new p.b(this) { // from class: com.kwad.sdk.core.download.kwai.f.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.d.a.c("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
                    if (aVar.a == 1) {
                        this.a.u();
                        return;
                    }
                    this.a.v();
                    if (this.a.q() != null) {
                        u.a(this.a.q(), v.a(this.a.q()));
                    }
                }
            }
        };
        this.f58008i = str;
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, gVar) == null) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "registerWebCardHandler");
            gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f58006g, this.f58004e, this.l));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f58006g, this.f58004e, this.l));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f58006g));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f58006g));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f58006g));
            gVar.a(new j(this.f58006g, this.m));
            gVar.a(new p(this.o));
            s sVar = new s();
            this.f58007h = sVar;
            gVar.a(sVar);
            gVar.a(new t(this.f58006g, this.f58004e));
            gVar.a(new i(this.n));
            gVar.a(new k(this.f58006g));
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f58001b.setVisibility(8);
            this.f58001b.a();
            t();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f58006g = aVar;
            aVar.a(((c) this).a.f57999d);
            com.kwad.sdk.core.webview.a aVar2 = this.f58006g;
            d dVar = ((c) this).a;
            aVar2.a = dVar.a;
            AdBaseFrameLayout adBaseFrameLayout = dVar.f57998c;
            aVar2.f58536b = adBaseFrameLayout;
            aVar2.f58538d = adBaseFrameLayout;
            aVar2.f58539e = this.f58001b;
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            i();
            this.f58001b.postDelayed(h(), 1500L);
            this.f58001b.setBackgroundColor(0);
            this.f58001b.getBackground().setAlpha(0);
            this.f58001b.setVisibility(0);
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "downloadPanelUrl=" + this.f58003d.windowPopUrl);
        }
    }

    private Runnable h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            Runnable runnable = new Runnable(this) { // from class: com.kwad.sdk.core.download.kwai.f.2
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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.v();
                        if (this.a.q() != null) {
                            u.a(this.a.q(), v.a(this.a.q()));
                        }
                    }
                }
            };
            this.f58009j = runnable;
            return runnable;
        }
        return (Runnable) invokeV.objValue;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
            t();
            be.b(this.f58001b);
            this.f58001b.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.core.download.kwai.f.3
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
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }
            });
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f58001b);
            this.f58005f = gVar;
            a(gVar);
            this.f58001b.addJavascriptInterface(this.f58005f, "KwaiAd");
            String r = r();
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "getUrl: " + r);
            this.f58001b.loadUrl(r);
        }
    }

    private String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            if (TextUtils.isEmpty(this.f58008i)) {
                String s = s();
                return TextUtils.isEmpty(s) ? this.f58003d.windowPopUrl : s;
            }
            return this.f58008i;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String s() {
        InterceptResult invokeV;
        String str;
        StringBuilder sb;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65556, this)) != null) {
            return (String) invokeV.objValue;
        }
        if (q() != null) {
            File c2 = com.kwad.sdk.core.config.b.c(q());
            if (c2.exists()) {
                str = Uri.fromFile(c2).toString();
                sb = new StringBuilder();
                str2 = "getPreloadUrl preloadUrl ";
            } else if (com.kwad.sdk.core.config.b.c() != null) {
                str = com.kwad.sdk.core.config.b.c().h5Url;
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

    private void t() {
        com.kwad.sdk.core.webview.kwai.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || (gVar = this.f58005f) == null) {
            return;
        }
        gVar.a();
        this.f58005f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (runnable = this.f58009j) == null) {
            return;
        }
        this.f58001b.removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.f58010k);
            if (this.f58001b.getVisibility() != 0) {
                return;
            }
            s sVar = this.f58007h;
            if (sVar != null) {
                sVar.e();
            }
            this.f58001b.setVisibility(4);
            s sVar2 = this.f58007h;
            if (sVar2 != null) {
                sVar2.f();
            }
            e eVar = ((c) this).a.f57997b;
            if (eVar != null) {
                eVar.a(this.f58010k);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.kwai.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f58003d = com.kwad.sdk.core.response.a.a.ac(com.kwad.sdk.core.response.a.d.j(((c) this).a.f57999d));
            this.f58004e = ((c) this).a.f58000e;
            f();
            g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            e();
            u();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f58001b = (KsAdWebView) a(R.id.ksad_download_tips_web_card_webView);
        }
    }
}
