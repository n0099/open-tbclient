package com.kwad.components.ad.reward.presenter;

import android.annotation.SuppressLint;
import android.graphics.Rect;
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
import com.kwad.components.ad.reward.e;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.e;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class p extends a implements KsRefluxView.a, e.a, e.b, com.kwad.sdk.core.webview.a.kwai.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static long qY = 2000;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdWebView bF;
    public int bH;
    public x.b bM;
    public aa dP;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public List<com.kwad.components.core.c.a.c> me;
    public List<com.kwad.components.ad.reward.c.b> qW;
    public KsRefluxView qX;
    public Runnable qZ;
    public com.kwad.components.ad.reward.c.c ra;
    public KsAdWebView.d rb;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.me = new ArrayList();
        this.bH = -1;
        this.qZ = new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.p.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p rc;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.rc = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.rc.hn();
                    com.kwad.components.ad.reward.monitor.a.a(this.rc.nM.mz, "reflux", p.getUrl(), p.qY);
                }
            }
        };
        this.ra = new com.kwad.components.ad.reward.c.c(this, null) { // from class: com.kwad.components.ad.reward.presenter.p.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p rc;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(null);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.rc = this;
            }

            @Override // com.kwad.components.ad.reward.c.c
            public final void d(com.kwad.components.ad.reward.c.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    this.rc.nM.b(bVar);
                }
            }

            @Override // com.kwad.components.ad.reward.c.c
            public final void e(com.kwad.components.ad.reward.c.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    this.rc.nM.c(bVar);
                }
            }
        };
        this.bM = new x.b(this) { // from class: com.kwad.components.ad.reward.presenter.p.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p rc;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.rc = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar) {
                KsRefluxView ksRefluxView;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.rc.bH = aVar.status;
                    boolean z = true;
                    if (this.rc.bH == 1) {
                        ksRefluxView = this.rc.qX;
                    } else {
                        ksRefluxView = this.rc.qX;
                        z = false;
                    }
                    ksRefluxView.z(z);
                    bd.c(this.rc.qZ);
                }
            }
        };
        this.rb = new KsAdWebView.d(this) { // from class: com.kwad.components.ad.reward.presenter.p.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p rc;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.rc = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i3, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str, str2) == null) {
                    this.rc.hn();
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    com.kwad.components.ad.reward.monitor.a.b(this.rc.nM.mz, "reflux", p.getUrl(), System.currentTimeMillis() - this.rc.bF.getLoadTime());
                }
            }
        };
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            aa aaVar = new aa();
            this.dP = aaVar;
            aVar.a(aaVar);
            aVar.a(new com.kwad.components.core.webview.jshandler.f(this.mJsBridgeContext, this.me, this));
            aVar.a(new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext));
            aVar.a(new com.kwad.components.core.webview.jshandler.o(this.mJsBridgeContext));
            aVar.a(new com.kwad.components.core.webview.jshandler.k(this.mJsBridgeContext));
            aVar.a(new x(this.bM, getUrl()));
            List<AdTemplate> f = com.kwad.components.ad.reward.c.b.f(this.qW);
            aVar.a(new u(f, this.me));
            aVar.a(new com.kwad.components.core.webview.jshandler.q(null));
            aVar.a(new s(this.mJsBridgeContext));
            com.kwad.components.core.webview.jshandler.e eVar = new com.kwad.components.core.webview.jshandler.e(f);
            eVar.a(this);
            aVar.a(eVar);
            aVar.a(new w(new w.a(this) { // from class: com.kwad.components.ad.reward.presenter.p.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ p rc;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.rc = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.w.a
                public final void a(com.kwad.components.core.webview.a.b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) || bVar.pv() <= 0 || this.rc.qW == null) {
                        return;
                    }
                    AdTemplate adTemplate = null;
                    Iterator it = this.rc.qW.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        AdTemplate adTemplate2 = ((com.kwad.components.ad.reward.c.b) it.next()).getAdTemplate();
                        if (com.kwad.sdk.core.response.a.d.ca(adTemplate2) == bVar.pv()) {
                            adTemplate = adTemplate2;
                            break;
                        }
                    }
                    if (adTemplate != null) {
                        AdWebViewActivityProxy.launch(this.rc.getContext(), new AdWebViewActivityProxy.a.C0361a().ao(bVar.title).ap(bVar.url).N(adTemplate).nx());
                    }
                }
            }));
        }
    }

    private void aE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.bH = -1;
            aF();
            this.qX.z(false);
            String url = getUrl();
            com.kwad.components.ad.reward.monitor.a.a(this.nM.mz, "reflux", url);
            com.kwad.sdk.core.e.b.d("RewardRefluxPresenter", "startPreloadWebView url : " + url);
            if (ax.dT(url)) {
                hn();
                return;
            }
            this.bF.loadUrl(url);
            bd.runOnUiThreadDelay(this.qZ, qY);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            clearJsInterfaceRegister();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.bF);
            this.mJsInterface = aVar;
            a(aVar);
            this.bF.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        }
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (aVar = this.mJsInterface) == null) {
            return;
        }
        aVar.destroy();
        this.mJsInterface = null;
    }

    @Nullable
    public static String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            String str = com.kwad.components.ad.reward.kwai.b.fU() != null ? com.kwad.components.ad.reward.kwai.b.fU().h5Url : "";
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    private void hl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            SceneImpl sceneImpl = this.nM.mAdTemplate.mAdScene;
            SceneImpl m84clone = sceneImpl != null ? sceneImpl.m84clone() : null;
            if (m84clone != null) {
                com.kwad.components.ad.reward.e.a(m84clone, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.qX.getNativeView().c(com.kwad.components.ad.reflux.a.b(this.qW, this.me));
            this.qX.z(false);
        }
    }

    private void inflateJsBridgeContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.mJsBridgeContext = bVar;
            bVar.setAdTemplateList(com.kwad.components.ad.reward.c.b.f(this.qW));
            com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
            com.kwad.components.ad.reward.k kVar = this.nM;
            bVar2.mScreenOrientation = kVar.mScreenOrientation;
            AdBaseFrameLayout adBaseFrameLayout = kVar.mRootContainer;
            bVar2.agd = adBaseFrameLayout;
            bVar2.Gl = adBaseFrameLayout;
            bVar2.Fv = this.bF;
        }
    }

    @Override // com.kwad.components.ad.reward.e.a
    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.kwad.sdk.core.webview.a.kwai.a
    public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        com.kwad.components.ad.reward.c.b a = com.kwad.components.ad.reward.k.a(this.qW, aVar.creativeId);
        if (a != null) {
            this.nM.b(a);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.aq();
            KsAdWebView ksAdWebView = this.bF;
            if (ksAdWebView != null) {
                this.bF.setClientConfig(ksAdWebView.getClientConfig().R(this.nM.mAdTemplate).b(this.rb));
            }
            com.kwad.components.ad.reward.monitor.a.a(this.nM.mz, "reflux");
            hl();
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.e.b
    public final void b(AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, adTemplate, j) == null) {
            this.nM.c(com.kwad.components.ad.reward.k.a(this.qW, j));
        }
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxView.a
    public final void dh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            List<com.kwad.components.ad.reward.c.b> list = this.qW;
            if (list != null && list.size() > 0) {
                com.kwad.sdk.core.report.a.b(this.qW.get(0).getAdTemplate(), new com.kwad.sdk.core.report.f().aJ(1).aP(this.qX.eC() ? 8 : 9), (JSONObject) null);
            }
            this.nM.mAdOpenInteractionListener.j(false);
            gR();
        }
    }

    @Override // com.kwad.components.ad.reward.e.a
    public final void e(@Nullable List<com.kwad.components.ad.reward.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            com.kwad.sdk.core.e.b.d("RewardRefluxPresenter", "onRefluxAdLoad :" + list.size());
            this.qW = list;
            if (list.size() > 0) {
                this.me.clear();
                for (com.kwad.components.ad.reward.c.b bVar : this.qW) {
                    com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(bVar.getAdTemplate());
                    com.kwad.sdk.core.e.b.d("RewardRefluxPresenter", "onRefluxAdLoad helper: " + cVar.mJ());
                    this.me.add(cVar);
                }
                if (this.bF == null) {
                    hn();
                    return;
                }
                inflateJsBridgeContext();
                aE();
            }
        }
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxView.a
    public final void eI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.nM.eF.pause();
        }
    }

    public final BackPressHandleResult fS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !this.nM.fD() ? BackPressHandleResult.NOT_HANDLED : isRefluxVisible() ? BackPressHandleResult.HANDLED_CLOSE : hm() ? BackPressHandleResult.HANDLED : BackPressHandleResult.NOT_HANDLED : (BackPressHandleResult) invokeV.objValue;
    }

    public final boolean hm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<com.kwad.components.ad.reward.c.b> list = this.qW;
            if (list == null || list.size() <= 0) {
                return false;
            }
            aa aaVar = this.dP;
            if (aaVar != null) {
                aaVar.py();
            }
            this.qX.show();
            aa aaVar2 = this.dP;
            if (aaVar2 != null) {
                aaVar2.pz();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean isRefluxVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.qX == null) {
                return false;
            }
            return this.qX.getGlobalVisibleRect(new Rect());
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onCreate();
            KsRefluxView ksRefluxView = (KsRefluxView) findViewById(R.id.obfuscated_res_0x7f0911a0);
            this.qX = ksRefluxView;
            this.bF = ksRefluxView.getWebView();
            this.qX.setViewListener(this);
            this.qX.setInnerAdInteractionListener(this.ra);
        }
    }

    @Override // com.kwad.components.ad.reward.e.a
    public final void onRequestResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
        }
    }
}
