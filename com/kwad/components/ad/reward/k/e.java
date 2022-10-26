package com.kwad.components.ad.reward.k;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
/* loaded from: classes7.dex */
public class e extends com.kwad.sdk.core.download.kwai.a implements r.b, x.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdWebView bF;
    public com.kwad.sdk.core.webview.a.kwai.a bJ;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public final com.kwad.components.ad.reward.d.h mRewardVerifyListener;
    public View uE;
    public ae uF;
    public f uG;

    public e(KsAdWebView ksAdWebView, View view2, com.kwad.components.core.c.a.c cVar, com.kwad.sdk.core.webview.a.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksAdWebView, view2, cVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRewardVerifyListener = new com.kwad.components.ad.reward.d.h(this) { // from class: com.kwad.components.ad.reward.k.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e uH;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.uH = this;
            }

            @Override // com.kwad.components.ad.reward.d.h
            public final void onRewardVerify() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.uH.uF == null) {
                    return;
                }
                this.uH.uF.af(true);
            }
        };
        this.uE = view2;
        this.bF = ksAdWebView;
        this.mApkDownloadHelper = cVar;
        this.bJ = aVar;
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, aVar, str) == null) {
            aVar.a(new com.kwad.components.core.webview.jshandler.f(this.mJsBridgeContext, this.mApkDownloadHelper, this.bJ));
            aVar.a(new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext));
            aVar.a(new com.kwad.components.core.webview.jshandler.k(this.mJsBridgeContext));
            aVar.a(new x(this, str));
            ae aeVar = new ae();
            this.uF = aeVar;
            aVar.a(aeVar);
            aVar.a(new com.kwad.components.core.webview.jshandler.s(this.mJsBridgeContext));
            aVar.a(new com.kwad.components.core.webview.jshandler.o(this.mJsBridgeContext));
            aVar.a(new com.kwad.components.core.webview.b.kwai.c());
            aVar.a(new com.kwad.components.core.webview.jshandler.r(this.mJsBridgeContext, this));
            aVar.a(new ac(this.mJsBridgeContext, this.mApkDownloadHelper));
            aVar.a(new com.kwad.components.ad.reward.f.b(this.bF.getContext(), this.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
        }
    }

    private void ab(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            com.kwad.sdk.core.e.b.d("BottomCardWebViewHelper", "switchWebView: " + z);
            KsAdWebView ksAdWebView = this.bF;
            if (ksAdWebView == null) {
                return;
            }
            ksAdWebView.setVisibility(z ? 0 : 8);
        }
    }

    private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, adTemplate, viewGroup) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.mJsBridgeContext = bVar;
            bVar.setAdTemplate(adTemplate);
            com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
            bVar2.mScreenOrientation = 0;
            bVar2.agd = null;
            bVar2.Gl = viewGroup;
            bVar2.Fv = this.bF;
            bVar2.mReportExtData = null;
            bVar2.agf = true;
        }
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (aVar = this.mJsInterface) == null) {
            return;
        }
        aVar.destroy();
        this.mJsInterface = null;
    }

    private KsAdWebView.d getWebErrorListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.reward.k.e.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e uH;

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
                this.uH = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, str2) == null) {
                    com.kwad.sdk.core.e.b.d("BottomCardWebViewHelper", "onReceivedHttpError: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
                    this.uH.hn();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            View view2 = this.uE;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            ab(false);
        }
    }

    private void j(String str, int i) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65545, this, str, i) == null) || (fVar = this.uG) == null) {
            return;
        }
        fVar.h(str, i);
    }

    private void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            if (ax.dT(str)) {
                hn();
                return;
            }
            clearJsInterfaceRegister();
            this.bF.setClientConfig(this.bF.getClientConfig().R(this.mAdTemplate).b(getWebErrorListener()));
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.bF);
            this.mJsInterface = aVar;
            a(aVar, str);
            this.bF.addJavascriptInterface(this.mJsInterface, "KwaiAd");
            this.bF.loadUrl(str);
        }
    }

    public final void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.uG = fVar;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.r.b
    public final void a(r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            com.kwad.sdk.core.e.b.d("BottomCardWebViewHelper", "onAdFrameValid : " + aVar.toJson());
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.x.b
    public final void a(x.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            com.kwad.sdk.core.e.b.d("BottomCardWebViewHelper", getClass().getName() + " updatePageStatus: " + aVar);
            if (aVar.status == 1) {
                ab(true);
            } else {
                hn();
            }
        }
    }

    public final void a(AdTemplate adTemplate, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, adTemplate, viewGroup) == null) {
            KsAdWebView ksAdWebView = this.bF;
            if (ksAdWebView != null) {
                ksAdWebView.setBackgroundColor(0);
                if (this.bF.getBackground() != null) {
                    this.bF.getBackground().setAlpha(0);
                }
            }
            com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
            this.mAdTemplate = adTemplate;
            b(adTemplate, viewGroup);
            v(com.kwad.sdk.core.response.a.b.aN(this.mAdTemplate));
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this);
            }
        }
    }

    public final void iR() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.c(this);
            }
            com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            j(adTemplate != null ? com.kwad.sdk.core.response.a.a.al(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : "立即下载", 100);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            j(adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.aJ(adTemplate), 100);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            j(adTemplate != null ? com.kwad.sdk.core.response.a.a.al(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : "立即下载", 100);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            j(adTemplate != null ? com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : "立即打开", 100);
        }
    }

    @Override // com.kwad.sdk.core.download.kwai.a
    public final void onPaused(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            j(com.kwad.sdk.core.response.a.a.aX(i), i);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || i == 0) {
            return;
        }
        j(com.kwad.sdk.core.response.a.a.aW(i), i);
    }
}
