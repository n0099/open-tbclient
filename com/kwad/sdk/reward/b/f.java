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
/* loaded from: classes6.dex */
public class f extends com.kwad.sdk.reward.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WebView f36185b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f36186c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f36187d;

    /* renamed from: e  reason: collision with root package name */
    public p f36188e;

    /* renamed from: f  reason: collision with root package name */
    public b f36189f;

    /* renamed from: g  reason: collision with root package name */
    public a f36190g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f36191h;

    /* loaded from: classes6.dex */
    public static class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AdTemplate f36194a;

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
            this.f36194a = adTemplate;
        }

        @Override // com.kwad.sdk.core.webview.jshandler.t.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                com.kwad.sdk.core.report.a.a(this.f36194a, i2, (v.a) null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f36195a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f36196b;

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
            this.f36195a = -1;
            this.f36196b = new WeakReference<>(fVar);
        }

        @Override // com.kwad.sdk.core.webview.jshandler.m.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f36195a = i2;
                com.kwad.sdk.core.d.a.c("RewardPlayablePresenter", "updatePageStatus mPageState: " + i2);
                WeakReference<f> weakReference = this.f36196b;
                if (weakReference != null) {
                    AdTemplate r = weakReference.get().r();
                    if (this.f36195a != 1 || r == null) {
                        return;
                    }
                    com.kwad.sdk.core.report.a.o(r);
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f36195a == 1 : invokeV.booleanValue;
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
        this.f36191h = new com.kwad.sdk.reward.a.f(this) { // from class: com.kwad.sdk.reward.b.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f36192a;

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
                this.f36192a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f36192a.f36189f != null && this.f36192a.f36189f.a()) {
                        this.f36192a.f();
                    } else {
                        this.f36192a.n();
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
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36214a;
            com.kwad.sdk.core.download.b.b bVar = aVar.j;
            a aVar2 = new a(aVar.f35888f);
            this.f36190g = aVar2;
            gVar.a(new t(this.f36187d, bVar, aVar2));
            gVar.a(new m(this.f36189f));
            gVar.a(new j(this.f36187d));
            p pVar = new p();
            this.f36188e = pVar;
            gVar.a(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.f36185b == null) {
            return;
        }
        p pVar = this.f36188e;
        if (pVar != null) {
            pVar.c();
        }
        this.f36185b.setVisibility(0);
        p pVar2 = this.f36188e;
        if (pVar2 != null) {
            pVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            p pVar = this.f36188e;
            if (pVar != null) {
                pVar.e();
            }
            this.f36185b.setVisibility(8);
            p pVar2 = this.f36188e;
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
            this.f36186c = new com.kwad.sdk.core.webview.a.g(this.f36185b);
            com.kwad.sdk.core.d.a.a("RewardPlayablePresenter", "mJsInterface is : " + this.f36186c);
            a(this.f36186c);
            this.f36185b.addJavascriptInterface(this.f36186c, "KwaiAd");
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f36187d = aVar;
            com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f36214a;
            aVar.f35099b = aVar2.f35888f;
            aVar.f35098a = 0;
            AdBaseFrameLayout adBaseFrameLayout = aVar2.f35890h;
            aVar.f35100c = adBaseFrameLayout;
            aVar.f35102e = adBaseFrameLayout;
            aVar.f35103f = this.f36185b;
        }
    }

    private void q() {
        com.kwad.sdk.core.webview.a.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (gVar = this.f36186c) == null) {
            return;
        }
        gVar.a();
        this.f36186c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdTemplate r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36214a;
            if (aVar != null) {
                return aVar.f35888f;
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
            ((com.kwad.sdk.reward.d) this).f36214a.a(this.f36191h);
            p();
            WebSettings a2 = a(this.f36185b);
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
            this.f36185b = webView;
            webView.setVisibility(4);
            this.f36185b.setWebChromeClient(new WebChromeClient(this) { // from class: com.kwad.sdk.reward.b.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f36193a;

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
                    this.f36193a = this;
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
            this.f36189f = new b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            q();
            n();
            ((com.kwad.sdk.reward.d) this).f36214a.b(this.f36191h);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o();
            AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f36214a.f35888f;
            String ad = com.kwad.sdk.core.response.b.a.ad(com.kwad.sdk.core.response.b.c.i(adTemplate));
            if (!TextUtils.isEmpty(ad)) {
                this.f36185b.loadUrl(ad);
            }
            com.kwad.sdk.core.report.a.p(adTemplate);
        }
    }
}
