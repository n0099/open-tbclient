package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
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
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bd;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class m extends e implements com.kwad.components.ad.splashscreen.f {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "SplashWebViewPresenter";
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdWebView bF;
    public AdInfo mAdInfo;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public com.kwad.components.ad.splashscreen.d.b zp;
    public ViewStub zq;
    public volatile boolean zr;
    public Runnable zs;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-78998466, "Lcom/kwad/components/ad/splashscreen/b/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-78998466, "Lcom/kwad/components/ad/splashscreen/b/m;");
        }
    }

    public m() {
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
        this.zs = new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.m.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m zt;

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
                this.zt = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.zt.kv();
                }
            }
        };
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            aVar.a(new ac(this.mJsBridgeContext, this.yF.mApkDownloadHelper));
            aVar.a(da());
            aVar.a(cZ());
            aVar.a(new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext));
            aVar.a(new com.kwad.components.core.webview.b.kwai.c());
            aVar.a(new x(new x.b(this) { // from class: com.kwad.components.ad.splashscreen.b.m.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m zt;

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
                    this.zt = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.x.b
                public final void a(x.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        String str = m.TAG;
                        com.kwad.sdk.core.e.b.d(str, "updatePageStatus: " + aVar2);
                        if (aVar2.status != 1) {
                            this.zt.kv();
                            return;
                        }
                        bd.c(this.zt.zs);
                        this.zt.ku();
                    }
                }
            }, getUrl()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i, @Nullable u.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), bVar}) == null) {
            this.yF.jD();
            int i2 = 0;
            boolean z2 = bVar != null;
            boolean z3 = i == 1;
            com.kwad.components.core.c.a.a.a(new a.C0577a(this.yF.mRootContainer.getContext()).L(this.yF.mAdTemplate).b(this.yF.mApkDownloadHelper).aj(z3).ae(i).a(bVar).al(z2).a(new a.b(this) { // from class: com.kwad.components.ad.splashscreen.b.m.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m zt;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.zt = this;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    String jC;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(this.zt.yF.mAdTemplate)) || (jC = this.zt.yF.jC()) == null) {
                        return;
                    }
                    com.kwad.components.ad.splashscreen.h hVar = this.zt.yF;
                    hVar.yb = true;
                    hVar.mAdTemplate.mMiniWindowId = jC;
                }
            }));
            if (z2) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.yF != null) {
                    if (this.yF.yc != null) {
                        jSONObject.put("duration", this.yF.yc.getCurrentPosition());
                    }
                    if (z) {
                        i2 = 153;
                    } else if (z3) {
                        i2 = 132;
                    }
                    com.kwad.sdk.core.report.a.a(this.yF.mAdTemplate, i2, (aa.a) null, jSONObject);
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
    }

    private void aE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            String url = getUrl();
            String str = TAG;
            com.kwad.sdk.core.e.b.d(str, "startPreloadWebView url: " + url);
            if (ax.dT(url)) {
                kv();
                return;
            }
            this.bF.setVisibility(0);
            inflateJsBridgeContext();
            aF();
            this.bF.setClientConfig(this.bF.getClientConfig().R(this.yF.mAdTemplate).b(getWebErrorListener()));
            this.bF.loadUrl(url);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            clearJsInterfaceRegister();
            this.bF.getSettings().setAllowFileAccess(true);
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.bF);
            this.mJsInterface = aVar;
            a(aVar);
            this.bF.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        }
    }

    private com.kwad.components.core.webview.jshandler.f cZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? new com.kwad.components.core.webview.jshandler.f(this.mJsBridgeContext, this.yF.mApkDownloadHelper, new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.splashscreen.b.m.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m zt;

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
                this.zt = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || com.kwad.sdk.b.kwai.a.ro()) {
                    return;
                }
                if (aVar.wj() || m.n(this.zt.mAdInfo)) {
                    u.b bVar = new u.b();
                    bVar.Mn = aVar.My.Mn;
                    this.zt.a(false, aVar.Mx, bVar);
                }
            }
        }) : (com.kwad.components.core.webview.jshandler.f) invokeV.objValue;
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (aVar = this.mJsInterface) == null) {
            return;
        }
        aVar.destroy();
        this.mJsInterface = null;
    }

    private com.kwad.components.core.webview.jshandler.i da() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? new com.kwad.components.core.webview.jshandler.i(this.mJsBridgeContext, this.yF.mApkDownloadHelper, new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.splashscreen.b.m.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m zt;

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
                this.zt = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    if (aVar.Mv || !m.n(this.zt.mAdInfo)) {
                        this.zt.a(false, aVar.Mv ? 1 : 3, null);
                    }
                }
            }
        }) : (com.kwad.components.core.webview.jshandler.i) invokeV.objValue;
    }

    public static String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            String str = com.kwad.components.ad.splashscreen.a.b.jJ() != null ? com.kwad.components.ad.splashscreen.a.b.jJ().h5Url : "";
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    private KsAdWebView.d getWebErrorListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.splashscreen.b.m.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m zt;

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
                this.zt = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, str2) == null) {
                    this.zt.kv();
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
                }
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    private void inflateJsBridgeContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.mJsBridgeContext = bVar;
            bVar.setAdTemplate(this.yF.mAdTemplate);
            com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
            bVar2.mScreenOrientation = 0;
            AdBaseFrameLayout adBaseFrameLayout = this.yF.mRootContainer;
            bVar2.agd = adBaseFrameLayout;
            bVar2.Gl = adBaseFrameLayout;
            bVar2.Fv = this.bF;
            bVar2.mReportExtData = null;
            bVar2.agf = false;
            bVar2.agg = n(this.mAdInfo);
        }
    }

    private int kw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            if (this.yF.fn instanceof SceneImpl) {
                return com.kwad.components.ad.splashscreen.local.d.a(getContext(), this.mAdInfo, (SceneImpl) this.yF.fn);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, adInfo)) == null) ? adInfo.adSplashInfo.fullScreenClickSwitch == 1 : invokeL.booleanValue;
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            this.bF = (KsAdWebView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091238);
            this.zq = (ViewStub) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091225);
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate);
            com.kwad.components.ad.splashscreen.d.b bVar = new com.kwad.components.ad.splashscreen.d.b((ViewGroup) getRootView(), this.zq, this.bF, com.kwad.sdk.core.response.a.c.bF(this.yF.mAdTemplate), this.yF.mApkDownloadHelper);
            this.zp = bVar;
            bVar.E(this.yF.mAdTemplate);
            this.zp.a(this);
            this.bF.setBackgroundColor(0);
            this.bF.getBackground().setAlpha(0);
            this.bF.setVisibility(0);
            this.zr = false;
            aE();
            bd.a(this.zs, null, 1000L);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.f
    public final void f(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            String str = TAG;
            com.kwad.sdk.core.e.b.d(str, "isClick: " + z + ", isActionBar: " + z2);
            a(!z, z2 ? 1 : 2, null);
        }
    }

    @SuppressLint({"WrongConstant"})
    public final void ku() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.zr) {
            return;
        }
        this.zr = true;
        u.b bVar = new u.b();
        u.a aVar = new u.a();
        aVar.aby = kw();
        bVar.abW = aVar;
        com.kwad.sdk.core.report.a.a(this.yF.mAdTemplate, 123, bVar, (JSONObject) null);
    }

    public final void kv() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.zp == null) {
            return;
        }
        ku();
        this.zp.kv();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onUnbind();
            clearJsInterfaceRegister();
            com.kwad.components.ad.splashscreen.d.b bVar = this.zp;
            if (bVar != null) {
                bVar.onUnbind();
            }
        }
    }
}
