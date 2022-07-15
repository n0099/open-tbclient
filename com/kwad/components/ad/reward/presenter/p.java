package com.kwad.components.ad.reward.presenter;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reflux.KsRefluxView;
import com.kwad.components.ad.reward.f;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.c;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.az;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class p extends a implements KsRefluxView.a, f.a, c.b, com.kwad.sdk.core.webview.a.kwai.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static long i = 2000;
    public transient /* synthetic */ FieldHolder $fh;
    public List<com.kwad.components.ad.reward.b.b> b;
    public List<com.kwad.components.core.c.a.b> c;
    public KsRefluxView d;
    public KsAdWebView e;
    public com.kwad.components.core.webview.a f;
    public com.kwad.sdk.core.webview.b g;
    public int h;
    public Runnable j;
    public x k;
    public com.kwad.components.ad.reward.b.c l;
    public u.b m;
    public KsAdWebView.d n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1298625209, "Lcom/kwad/components/ad/reward/presenter/p;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1298625209, "Lcom/kwad/components/ad/reward/presenter/p;");
        }
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.h = -1;
        this.j = new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.p.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p a;

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

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.k();
                }
            }
        };
        this.l = new com.kwad.components.ad.reward.b.c(this, null) { // from class: com.kwad.components.ad.reward.presenter.p.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(null);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.b.c
            public final void a(com.kwad.components.ad.reward.b.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    ((a) this.a).a.a(bVar);
                }
            }

            @Override // com.kwad.components.ad.reward.b.c
            public final void b(com.kwad.components.ad.reward.b.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    ((a) this.a).a.b(bVar);
                }
            }
        };
        this.m = new u.b(this) { // from class: com.kwad.components.ad.reward.presenter.p.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p a;

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

            @Override // com.kwad.components.core.webview.jshandler.u.b
            public final void a(u.a aVar) {
                KsRefluxView ksRefluxView;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.a.h = aVar.a;
                    boolean z = true;
                    if (this.a.h == 1) {
                        ksRefluxView = this.a.d;
                    } else {
                        ksRefluxView = this.a.d;
                        z = false;
                    }
                    ksRefluxView.a(z);
                    az.b(this.a.j);
                }
            }
        };
        this.n = new KsAdWebView.d(this) { // from class: com.kwad.components.ad.reward.presenter.p.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p a;

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

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str) == null) {
                    this.a.k();
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        };
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            x xVar = new x();
            this.k = xVar;
            aVar.a(xVar);
            aVar.a(new com.kwad.components.core.webview.jshandler.d(this.g, this.c, this));
            aVar.a(new com.kwad.components.core.webview.jshandler.i(this.g));
            aVar.a(new com.kwad.components.core.webview.jshandler.l(this.g));
            aVar.a(new com.kwad.components.core.webview.jshandler.h(this.g));
            aVar.a(new u(this.m, n()));
            List<AdTemplate> a = com.kwad.components.ad.reward.b.b.a(this.b);
            aVar.a(new com.kwad.components.core.webview.jshandler.r(a, this.c));
            aVar.a(new com.kwad.components.core.webview.jshandler.n(null));
            aVar.a(new com.kwad.components.core.webview.jshandler.p(this.g));
            com.kwad.components.core.webview.jshandler.c cVar = new com.kwad.components.core.webview.jshandler.c(a);
            cVar.a(this);
            aVar.a(cVar);
            aVar.a(new t(new t.a(this) { // from class: com.kwad.components.ad.reward.presenter.p.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ p a;

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

                @Override // com.kwad.components.core.webview.jshandler.t.a
                public final void a(com.kwad.components.core.webview.a.b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) || bVar.a() <= 0 || this.a.b == null) {
                        return;
                    }
                    AdTemplate adTemplate = null;
                    Iterator it = this.a.b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        AdTemplate b = ((com.kwad.components.ad.reward.b.b) it.next()).b();
                        if (com.kwad.sdk.core.response.a.d.t(b) == bVar.a()) {
                            adTemplate = b;
                            break;
                        }
                    }
                    if (adTemplate != null) {
                        AdWebViewActivityProxy.launch(this.a.u(), new AdWebViewActivityProxy.a.C0514a().a(bVar.b).b(bVar.a).a(adTemplate).a());
                    }
                }
            }));
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            SceneImpl sceneImpl = ((a) this).a.g.mAdScene;
            SceneImpl m1024clone = sceneImpl != null ? sceneImpl.m1024clone() : null;
            if (m1024clone != null) {
                com.kwad.components.ad.reward.f.a(m1024clone, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.d.getNativeView().a(com.kwad.components.ad.reflux.a.a(this.b, this.c));
            this.d.a(false);
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.g = bVar;
            bVar.a(com.kwad.components.ad.reward.b.b.a(this.b));
            com.kwad.sdk.core.webview.b bVar2 = this.g;
            com.kwad.components.ad.reward.l lVar = ((a) this).a;
            bVar2.a = lVar.f;
            AdBaseFrameLayout adBaseFrameLayout = lVar.h;
            bVar2.b = adBaseFrameLayout;
            bVar2.d = adBaseFrameLayout;
            bVar2.e = this.e;
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.h = -1;
            v();
            this.d.a(false);
            String n = n();
            com.kwad.sdk.core.d.b.a("RewardRefluxPresenter", "startPreloadWebView url : " + n);
            if (at.a(n)) {
                k();
                return;
            }
            this.e.loadUrl(n);
            az.a(this.j, i);
        }
    }

    @Nullable
    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            String str = com.kwad.components.ad.reward.kwai.b.a() != null ? com.kwad.components.ad.reward.kwai.b.a().h5Url : "";
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            w();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.e);
            this.f = aVar;
            a(aVar);
            this.e.addJavascriptInterface(this.f, "KwaiAd");
        }
    }

    private void w() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (aVar = this.f) == null) {
            return;
        }
        aVar.a();
        this.f = null;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            KsAdWebView ksAdWebView = this.e;
            if (ksAdWebView != null) {
                this.e.setClientConfig(ksAdWebView.getClientConfig().a(((a) this).a.g).a(this.n));
            }
            i();
        }
    }

    @Override // com.kwad.components.ad.reward.f.a
    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.c.b
    public final void a(AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, adTemplate, j) == null) {
            ((a) this).a.b(com.kwad.components.ad.reward.l.a(this.b, j));
        }
    }

    @Override // com.kwad.sdk.core.webview.a.kwai.a
    public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
            return;
        }
        com.kwad.components.ad.reward.b.b a = com.kwad.components.ad.reward.l.a(this.b, aVar.f);
        if (a != null) {
            ((a) this).a.a(a);
        }
    }

    @Override // com.kwad.components.ad.reward.f.a
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.f.a
    public final void a(@Nullable List<com.kwad.components.ad.reward.b.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            com.kwad.sdk.core.d.b.a("RewardRefluxPresenter", "onRefluxAdLoad :" + list.size());
            this.b = list;
            if (list.size() > 0) {
                this.c.clear();
                for (com.kwad.components.ad.reward.b.b bVar : this.b) {
                    com.kwad.components.core.c.a.b bVar2 = new com.kwad.components.core.c.a.b(bVar.b());
                    com.kwad.sdk.core.d.b.a("RewardRefluxPresenter", "onRefluxAdLoad helper: " + bVar2.b());
                    this.c.add(bVar2);
                }
                if (this.e == null) {
                    k();
                    return;
                }
                l();
                m();
            }
        }
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxView.a
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            List<com.kwad.components.ad.reward.b.b> list = this.b;
            if (list != null && list.size() > 0) {
                com.kwad.sdk.core.report.a.b(this.b.get(0).b(), new com.kwad.sdk.core.report.f().b(1).h(this.d.a() ? 8 : 9), (JSONObject) null);
            }
            ((a) this).a.b.a(false);
            j();
        }
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxView.a
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ((a) this).a.j.c();
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<com.kwad.components.ad.reward.b.b> list = this.b;
            if (list == null || list.size() <= 0) {
                return false;
            }
            x xVar = this.k;
            if (xVar != null) {
                xVar.c();
            }
            this.d.c();
            x xVar2 = this.k;
            if (xVar2 != null) {
                xVar2.d();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final BackPressHandleResult g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !((a) this).a.n() ? BackPressHandleResult.NOT_HANDLED : h() ? BackPressHandleResult.HANDLED_CLOSE : e() ? BackPressHandleResult.HANDLED : BackPressHandleResult.NOT_HANDLED : (BackPressHandleResult) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            KsRefluxView ksRefluxView = this.d;
            return ksRefluxView != null && ksRefluxView.isShown();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.i_();
            KsRefluxView ksRefluxView = (KsRefluxView) b(R.id.obfuscated_res_0x7f09116c);
            this.d = ksRefluxView;
            this.e = ksRefluxView.getWebView();
            this.d.setViewListener(this);
            this.d.setInnerAdInteractionListener(this.l);
        }
    }
}
