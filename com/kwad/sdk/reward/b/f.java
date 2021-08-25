package com.kwad.sdk.reward.b;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.utils.v;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class f extends com.kwad.sdk.reward.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WebView f73380b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f73381c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f73382d;

    /* renamed from: e  reason: collision with root package name */
    public p f73383e;

    /* renamed from: f  reason: collision with root package name */
    public b f73384f;

    /* renamed from: g  reason: collision with root package name */
    public a f73385g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f73386h;

    /* loaded from: classes10.dex */
    public static class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AdTemplate f73389a;

        public a(AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adTemplate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73389a = adTemplate;
        }

        @Override // com.kwad.sdk.core.webview.jshandler.t.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                com.kwad.sdk.core.report.a.a(this.f73389a, i2, (v.a) null);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f73390a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f73391b;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73390a = -1;
            this.f73391b = new WeakReference<>(fVar);
        }

        @Override // com.kwad.sdk.core.webview.jshandler.m.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f73390a = i2;
                com.kwad.sdk.core.d.a.c("RewardPlayablePresenter", "updatePageStatus mPageState: " + i2);
                WeakReference<f> weakReference = this.f73391b;
                if (weakReference != null) {
                    AdTemplate r = weakReference.get().r();
                    if (this.f73390a != 1 || r == null) {
                        return;
                    }
                    com.kwad.sdk.core.report.a.o(r);
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f73390a == 1 : invokeV.booleanValue;
        }
    }

    public f() {
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
        this.f73386h = new com.kwad.sdk.reward.a.f(this) { // from class: com.kwad.sdk.reward.b.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f73387a;

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
                this.f73387a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f73387a.f73384f != null && this.f73387a.f73384f.a()) {
                        this.f73387a.f();
                    } else {
                        this.f73387a.n();
                    }
                }
            }
        };
    }

    @MainThread
    public static WebSettings a(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, webView)) == null) {
            if (webView == null) {
                return null;
            }
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setSavePassword(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setAllowFileAccess(false);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            if (Build.VERSION.SDK_INT < 19) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.setSaveEnabled(false);
            return settings;
        }
        return (WebSettings) invokeL.objValue;
    }

    private void a(com.kwad.sdk.core.webview.a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f73410a;
            com.kwad.sdk.core.download.b.b bVar = aVar.f73077j;
            a aVar2 = new a(aVar.f73073f);
            this.f73385g = aVar2;
            gVar.a(new t(this.f73382d, bVar, aVar2));
            gVar.a(new m(this.f73384f));
            gVar.a(new j(this.f73382d));
            p pVar = new p();
            this.f73383e = pVar;
            gVar.a(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.f73380b == null) {
            return;
        }
        p pVar = this.f73383e;
        if (pVar != null) {
            pVar.c();
        }
        this.f73380b.setVisibility(0);
        p pVar2 = this.f73383e;
        if (pVar2 != null) {
            pVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            p pVar = this.f73383e;
            if (pVar != null) {
                pVar.e();
            }
            this.f73380b.setVisibility(8);
            p pVar2 = this.f73383e;
            if (pVar2 != null) {
                pVar2.f();
            }
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            q();
            this.f73381c = new com.kwad.sdk.core.webview.a.g(this.f73380b);
            com.kwad.sdk.core.d.a.a("RewardPlayablePresenter", "mJsInterface is : " + this.f73381c);
            a(this.f73381c);
            this.f73380b.addJavascriptInterface(this.f73381c, "KwaiAd");
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f73382d = aVar;
            com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f73410a;
            aVar.f72243b = aVar2.f73073f;
            aVar.f72242a = 0;
            AdBaseFrameLayout adBaseFrameLayout = aVar2.f73075h;
            aVar.f72244c = adBaseFrameLayout;
            aVar.f72246e = adBaseFrameLayout;
            aVar.f72247f = this.f73380b;
        }
    }

    private void q() {
        com.kwad.sdk.core.webview.a.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (gVar = this.f73381c) == null) {
            return;
        }
        gVar.a();
        this.f73381c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdTemplate r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f73410a;
            if (aVar != null) {
                return aVar.f73073f;
            }
            return null;
        }
        return (AdTemplate) invokeV.objValue;
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((com.kwad.sdk.reward.d) this).f73410a.a(this.f73386h);
            p();
            WebSettings a2 = a(this.f73380b);
            a2.setCacheMode(2);
            if (Build.VERSION.SDK_INT >= 17 && com.kwad.sdk.core.config.c.H()) {
                a2.setMediaPlaybackRequiresUserGesture(false);
            }
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            WebView webView = (WebView) a(R.id.ksad_playable_webview);
            this.f73380b = webView;
            webView.setVisibility(4);
            this.f73380b.setWebChromeClient(new WebChromeClient(this) { // from class: com.kwad.sdk.reward.b.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f73388a;

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
                    this.f73388a = this;
                }

                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView2, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, webView2, i2) == null) {
                        super.onProgressChanged(webView2, i2);
                        com.kwad.sdk.core.d.a.a("RewardPlayablePresenter", "newProgress: " + i2);
                    }
                }
            });
            this.f73384f = new b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            q();
            n();
            ((com.kwad.sdk.reward.d) this).f73410a.b(this.f73386h);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o();
            AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f73410a.f73073f;
            String ad = com.kwad.sdk.core.response.b.a.ad(com.kwad.sdk.core.response.b.c.i(adTemplate));
            if (!TextUtils.isEmpty(ad)) {
                this.f73380b.loadUrl(ad);
            }
            com.kwad.sdk.core.report.a.p(adTemplate);
        }
    }
}
