package com.kwad.sdk.reward.presenter;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.reflux.KsRefluxView;
import com.kwad.sdk.reflux.a;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.be;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends com.kwad.sdk.reward.g implements KsRefluxView.a, a.InterfaceC2107a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f59753b;

    /* renamed from: c  reason: collision with root package name */
    public List<com.kwad.sdk.core.download.a.b> f59754c;

    /* renamed from: d  reason: collision with root package name */
    public KsRefluxView f59755d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdWebView f59756e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f59757f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f59758g;

    /* renamed from: h  reason: collision with root package name */
    public int f59759h;

    /* renamed from: i  reason: collision with root package name */
    public s f59760i;

    /* renamed from: j  reason: collision with root package name */
    public p.b f59761j;

    /* renamed from: k  reason: collision with root package name */
    public KsAdWebView.d f59762k;

    public j() {
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
        this.f59754c = new ArrayList();
        this.f59759h = -1;
        this.f59761j = new p.b(this) { // from class: com.kwad.sdk.reward.presenter.j.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

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
                    this.a.f59759h = aVar.a;
                    if (this.a.f59759h == 1) {
                        this.a.f59755d.a(true);
                    }
                }
            }
        };
        this.f59762k = new KsAdWebView.d(this) { // from class: com.kwad.sdk.reward.presenter.j.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

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

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i4, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str, str2) == null) {
                    this.a.t();
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        };
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            s sVar = new s();
            this.f59760i = sVar;
            gVar.a(sVar);
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f59758g, this.f59754c, (b.c) null));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f59758g));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f59758g));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f59758g));
            gVar.a(new p(this.f59761j));
            gVar.a(new m(this.f59753b, this.f59754c));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.i(null));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.f59758g));
            gVar.a(new o(new o.a(this) { // from class: com.kwad.sdk.reward.presenter.j.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ j a;

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
                public void a(com.kwad.sdk.core.webview.kwai.i iVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, iVar) == null) || iVar.a() <= 0 || this.a.f59753b == null) {
                        return;
                    }
                    AdTemplate adTemplate = null;
                    Iterator it = this.a.f59753b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        AdTemplate adTemplate2 = (AdTemplate) it.next();
                        if (com.kwad.sdk.core.response.a.d.y(adTemplate2) == iVar.a()) {
                            adTemplate = adTemplate2;
                            break;
                        }
                    }
                    if (adTemplate != null) {
                        AdWebViewActivityProxy.launch(this.a.q(), new AdWebViewActivityProxy.a.C2083a().a(iVar.f58694b).b(iVar.a).a(adTemplate).a());
                    }
                }
            }));
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            SceneImpl sceneImpl = ((com.kwad.sdk.reward.g) this).a.f59455g.mAdScene;
            SceneImpl m110clone = sceneImpl != null ? sceneImpl.m110clone() : null;
            if (m110clone != null) {
                com.kwad.sdk.reflux.a.a(m110clone, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f59755d.getNativeView().a(com.kwad.sdk.reflux.b.a(this.f59753b, this.f59754c));
            this.f59755d.a(false);
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f59758g = aVar;
            aVar.a(this.f59753b);
            com.kwad.sdk.core.webview.a aVar2 = this.f59758g;
            com.kwad.sdk.reward.a aVar3 = ((com.kwad.sdk.reward.g) this).a;
            aVar2.a = aVar3.f59454f;
            AdBaseFrameLayout adBaseFrameLayout = aVar3.f59458j;
            aVar2.f58536b = adBaseFrameLayout;
            aVar2.f58538d = adBaseFrameLayout;
            aVar2.f58539e = this.f59756e;
        }
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f59759h = -1;
            x();
            this.f59755d.a(false);
            String w = w();
            com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "startPreloadWebView url : " + w);
            if (at.a(w)) {
                t();
            } else {
                this.f59756e.loadUrl(w);
            }
        }
    }

    @Nullable
    private String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? com.kwad.sdk.core.config.b.a(q()) : (String) invokeV.objValue;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            y();
            be.a(this.f59756e);
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f59756e);
            this.f59757f = gVar;
            a(gVar);
            this.f59756e.addJavascriptInterface(this.f59757f, "KwaiAd");
        }
    }

    private void y() {
        com.kwad.sdk.core.webview.kwai.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (gVar = this.f59757f) == null) {
            return;
        }
        gVar.a();
        this.f59757f = null;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            KsAdWebView ksAdWebView = this.f59756e;
            if (ksAdWebView != null) {
                ksAdWebView.setHttpErrorListener(this.f59762k);
            }
            s();
        }
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2107a
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
        }
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2107a
    public void a(@Nullable List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "onRefluxAdLoad :" + list.size());
            this.f59753b = list;
            if (list.size() > 0) {
                this.f59754c.clear();
                for (AdTemplate adTemplate : this.f59753b) {
                    com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(adTemplate);
                    com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "onRefluxAdLoad helper: " + bVar.a());
                    this.f59754c.add(bVar);
                }
                if (this.f59756e == null) {
                    t();
                    return;
                }
                u();
                v();
            }
        }
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2107a
    public void a_(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.c();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.c_();
            KsRefluxView ksRefluxView = (KsRefluxView) a(R.id.ksad_reward_reflux);
            this.f59755d = ksRefluxView;
            this.f59756e = ksRefluxView.getWebView();
            this.f59755d.setViewListener(this);
        }
    }

    @Override // com.kwad.sdk.reflux.KsRefluxView.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ((com.kwad.sdk.reward.g) this).a.f59450b.a(false);
            h();
        }
    }

    @Override // com.kwad.sdk.reflux.KsRefluxView.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ((com.kwad.sdk.reward.g) this).a.f59459k.c();
        }
    }

    public int i() {
        InterceptResult invokeV;
        List<AdTemplate> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f59755d.isShown()) {
                return 3;
            }
            if (!((com.kwad.sdk.reward.g) this).a.v || (list = this.f59753b) == null || list.size() <= 0) {
                return 1;
            }
            s sVar = this.f59760i;
            if (sVar != null) {
                sVar.c();
            }
            this.f59755d.c();
            s sVar2 = this.f59760i;
            if (sVar2 != null) {
                sVar2.d();
                return 2;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            KsRefluxView ksRefluxView = this.f59755d;
            return ksRefluxView != null && ksRefluxView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }
}
