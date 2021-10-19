package com.kwad.sdk.core.download.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes10.dex */
public class f extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f71995b;

    /* renamed from: c  reason: collision with root package name */
    public i.a f71996c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo.DownloadSafeInfo f71997d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f71998e;

    /* renamed from: f  reason: collision with root package name */
    public g f71999f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f72000g;

    /* renamed from: h  reason: collision with root package name */
    public p f72001h;

    /* renamed from: i  reason: collision with root package name */
    public String f72002i;

    /* renamed from: j  reason: collision with root package name */
    public a.b f72003j;
    public i.b k;
    public h.a l;
    public m.b m;

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
        this.f72003j = new a.b(this) { // from class: com.kwad.sdk.core.download.a.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f72004a;

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
                this.f72004a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C2006a c2006a) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, c2006a) == null) {
                }
            }
        };
        this.k = new i.b(this) { // from class: com.kwad.sdk.core.download.a.f.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f72006a;

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
                this.f72006a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
                    this.f72006a.f71996c = aVar;
                    this.f72006a.f71995b.setTranslationY((float) (aVar.f72894a + aVar.f72897d));
                }
            }
        };
        this.l = new h.a(this) { // from class: com.kwad.sdk.core.download.a.f.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f72007a;

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
                this.f72007a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
                    this.f72007a.s();
                }
            }
        };
        this.m = new m.b(this) { // from class: com.kwad.sdk.core.download.a.f.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f72008a;

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
                this.f72008a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    com.kwad.sdk.core.d.a.c("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + i4);
                }
            }
        };
        this.f72002i = str;
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "registerWebCardHandler");
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f72000g, this.f71998e, this.f72003j));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f72000g));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f72000g));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f72000g));
            gVar.a(new i(this.f72000g, this.k));
            gVar.a(new m(this.m));
            p pVar = new p();
            this.f72001h = pVar;
            gVar.a(pVar);
            gVar.a(new q(this.f72000g, this.f71998e));
            gVar.a(new h(this.l));
            gVar.a(new j(this.f72000g));
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f71995b.setVisibility(8);
            this.f71995b.c();
            r();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f72000g = aVar;
            d dVar = ((c) this).f71989a;
            aVar.f72777b = dVar.f71993d;
            aVar.f72776a = dVar.f71990a;
            AdBaseFrameLayout adBaseFrameLayout = dVar.f71992c;
            aVar.f72778c = adBaseFrameLayout;
            aVar.f72780e = adBaseFrameLayout;
            aVar.f72781f = this.f71995b;
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            o();
            this.f71995b.setBackgroundColor(0);
            this.f71995b.getBackground().setAlpha(0);
            this.f71995b.setVisibility(0);
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "downloadPanelUrl=" + this.f71997d.windowPopUrl);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
            r();
            ay.b(this.f71995b);
            this.f71995b.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.core.download.a.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f72005a;

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
                    this.f72005a = this;
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
            g gVar = new g(this.f71995b);
            this.f71999f = gVar;
            a(gVar);
            this.f71995b.addJavascriptInterface(this.f71999f, "KwaiAd");
            String p = p();
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "getUrl: " + p);
            this.f71995b.loadUrl(p);
        }
    }

    private String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (TextUtils.isEmpty(this.f72002i)) {
                String q = q();
                return TextUtils.isEmpty(q) ? this.f71997d.windowPopUrl : q;
            }
            return this.f72002i;
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
        if (interceptable != null && (invokeV = interceptable.invokeV(65546, this)) != null) {
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
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (gVar = this.f71999f) == null) {
            return;
        }
        gVar.a();
        this.f71999f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation");
            if (this.f71995b.getVisibility() != 0) {
                return;
            }
            p pVar = this.f72001h;
            if (pVar != null) {
                pVar.e();
            }
            this.f71995b.setVisibility(4);
            p pVar2 = this.f72001h;
            if (pVar2 != null) {
                pVar2.f();
            }
            e eVar = ((c) this).f71989a.f71991b;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f71997d = com.kwad.sdk.core.response.b.a.V(com.kwad.sdk.core.response.b.c.i(((c) this).f71989a.f71993d));
            this.f71998e = ((c) this).f71989a.f71994e;
            f();
            n();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f71995b = (KsAdWebView) a(R.id.ksad_download_tips_web_card_webView);
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
