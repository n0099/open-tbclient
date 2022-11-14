package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.h.l;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.m.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public final class f extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.core.webview.b.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdWebView bF;
    public r.a bG;
    public int bH;
    public aa bI;
    public com.kwad.sdk.core.webview.a.kwai.a bJ;
    public r.b bK;
    public q.b bL;
    public x.b bM;
    public ValueAnimator bN;
    public ValueAnimator bO;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public com.kwad.components.ad.reward.d.e mPlayEndPageListener;
    public String mUrl;
    public RewardActionBarControl ml;
    public KsLogoView pM;
    public boolean rS;
    public long rT;
    public RewardActionBarControl.f rz;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bH = -1;
        this.rz = new RewardActionBarControl.f(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f rU;

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
                this.rU = this;
            }

            @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.f
            public final boolean g(a aVar) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, aVar)) == null) {
                    f fVar = this.rU;
                    fVar.rS = fVar.g(aVar);
                    return this.rU.rS;
                }
                return invokeL.booleanValue;
            }
        };
        this.mPlayEndPageListener = new com.kwad.components.ad.reward.d.e(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f rU;

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
                this.rU = this;
            }

            @Override // com.kwad.components.ad.reward.d.e
            public final void bA() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.rU.release();
                }
            }
        };
        this.bJ = new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f rU;

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
                this.rU = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.rU.nM.mAdOpenInteractionListener.bB();
                }
            }
        };
        this.bK = new r.b(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f rU;

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
                this.rU = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.r.b
            public final void a(r.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.rU.bG = aVar;
                    this.rU.bF.setTranslationY(aVar.height + aVar.bottomMargin);
                }
            }
        };
        this.bL = new q.b(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f rU;

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
                this.rU = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.q.b
            public final void a(q.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.rU.rS = false;
                    this.rU.aJ();
                }
            }
        };
        this.bM = new x.b(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f rU;

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
                this.rU = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.rU.bH = aVar.status;
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.rU.rT;
                    com.kwad.sdk.core.e.b.i("RewardActionBarWeb", "load time:" + elapsedRealtime + ", pageStatus: " + this.rU.bH);
                    if (this.rU.bH == 1) {
                        com.kwad.components.core.j.a.og().d(this.rU.nM.mAdTemplate, elapsedRealtime);
                    }
                    if (this.rU.nM.fv()) {
                        return;
                    }
                    this.rU.ml.hw();
                }
            }
        };
    }

    private void A(AdTemplate adTemplate) {
        KsLogoView ksLogoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, adTemplate) == null) || !com.kwad.sdk.core.response.a.a.bF(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) || ag.zL() || (ksLogoView = this.pM) == null) {
            return;
        }
        ksLogoView.setVisibility(0);
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            aVar.a(new i(this.mJsBridgeContext, this.mApkDownloadHelper, this.bJ));
            aVar.a(new com.kwad.components.core.webview.b.kwai.c());
            aVar.a(new l(this.mJsBridgeContext, this.mApkDownloadHelper, this.nM, -1L, this.bJ));
            aVar.a(new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext));
            aVar.a(new o(this.mJsBridgeContext));
            aVar.a(new k(this.mJsBridgeContext));
            aVar.a(new r(this.mJsBridgeContext, this.bK));
            aVar.a(new x(this.bM, com.kwad.sdk.core.response.a.b.aN(this.nM.mAdTemplate)));
            aa aaVar = new aa();
            this.bI = aaVar;
            aVar.a(aaVar);
            aVar.a(new ac(this.mJsBridgeContext, this.mApkDownloadHelper));
            aVar.a(new q(this.bL));
            aVar.a(new s(this.mJsBridgeContext));
            aVar.a(new com.kwad.components.ad.reward.f.b(getContext(), this.nM.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
        }
    }

    private void aE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.bH = -1;
            aF();
            this.bF.setBackgroundColor(0);
            this.bF.getBackground().setAlpha(0);
            this.bF.setVisibility(4);
            this.bF.setClientConfig(this.bF.getClientConfig().R(this.nM.mAdTemplate).b(getWebListener()));
            this.rT = SystemClock.elapsedRealtime();
            this.mUrl = com.kwad.sdk.core.response.a.b.aN(this.nM.mAdTemplate);
            com.kwad.sdk.core.e.b.d("RewardActionBarWeb", "startPreloadWebView url: " + this.mUrl);
            com.kwad.components.ad.reward.monitor.a.a(this.nM.mz, "play_card", this.mUrl);
            this.bF.loadUrl(this.mUrl);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            clearJsInterfaceRegister();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.bF);
            this.mJsInterface = aVar;
            a(aVar);
            this.bF.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        }
    }

    private void aI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            A(this.nM.mAdTemplate);
            aa aaVar = this.bI;
            if (aaVar != null) {
                aaVar.py();
            }
            this.bF.setVisibility(0);
            aa aaVar2 = this.bI;
            if (aaVar2 != null) {
                aaVar2.pz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && this.bF.getVisibility() == 0) {
            if (this.bG == null) {
                aK();
                return;
            }
            aL();
            KsAdWebView ksAdWebView = this.bF;
            r.a aVar = this.bG;
            ValueAnimator c = n.c(ksAdWebView, 0, aVar.height + aVar.bottomMargin);
            this.bO = c;
            c.setInterpolator(new DecelerateInterpolator(2.0f));
            this.bO.setDuration(300L);
            this.bO.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f rU;

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
                    this.rU = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.rU.bF.setVisibility(4);
                        if (this.rU.bI != null) {
                            this.rU.bI.pB();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.rU.bI != null) {
                            this.rU.bI.pA();
                        }
                    }
                }
            });
            this.bO.start();
        }
    }

    private void aK() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && this.bF.getVisibility() == 0) {
            aa aaVar = this.bI;
            if (aaVar != null) {
                aaVar.pA();
            }
            this.bF.setVisibility(4);
            aa aaVar2 = this.bI;
            if (aaVar2 != null) {
                aaVar2.pB();
            }
        }
    }

    private void aL() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            ValueAnimator valueAnimator = this.bN;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.bN.cancel();
            }
            ValueAnimator valueAnimator2 = this.bO;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllListeners();
                this.bO.cancel();
            }
        }
    }

    private void aM() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            int i = this.bH;
            String str = i == -1 ? "timeout" : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
            com.kwad.sdk.core.e.b.w("RewardActionBarWeb", "show webCard fail, reason: " + str);
        }
    }

    private void bQ() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65552, this) == null) && com.kwad.sdk.core.response.a.b.aP(this.nM.mAdTemplate)) {
            com.kwad.components.ad.reward.k kVar = this.nM;
            this.mApkDownloadHelper = kVar.mApkDownloadHelper;
            RewardActionBarControl rewardActionBarControl = kVar.ml;
            this.ml = rewardActionBarControl;
            rewardActionBarControl.a(this.rz);
            inflateJsBridgeContext();
            aE();
            this.nM.a(this.mPlayEndPageListener);
        }
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (aVar = this.mJsInterface) == null) {
            return;
        }
        aVar.destroy();
        this.mJsInterface = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, this, aVar)) == null) {
            KsAdWebView ksAdWebView = this.bF;
            if (ksAdWebView == null) {
                return false;
            }
            if (ksAdWebView.getVisibility() == 0) {
                return true;
            }
            if (this.bH == 1) {
                h(aVar);
                return true;
            }
            aM();
            return false;
        }
        return invokeL.booleanValue;
    }

    private KsAdWebView.d getWebListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f rU;

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
                this.rU = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, str2) == null) {
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
                    com.kwad.components.ad.reward.monitor.a.b(this.rU.nM.mz, "play_card", this.rU.mUrl, System.currentTimeMillis() - this.rU.bF.getLoadTime());
                }
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    private void h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, aVar) == null) {
            if (this.bG == null) {
                aI();
                return;
            }
            A(this.nM.mAdTemplate);
            aL();
            this.bF.setVisibility(0);
            KsAdWebView ksAdWebView = this.bF;
            r.a aVar2 = this.bG;
            ValueAnimator c = n.c(ksAdWebView, aVar2.height + aVar2.bottomMargin, 0);
            this.bN = c;
            c.setInterpolator(new DecelerateInterpolator(2.0f));
            this.bN.setDuration(500L);
            this.bN.addListener(new AnimatorListenerAdapter(this, aVar) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a rH;
                public final /* synthetic */ f rU;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.rU = this;
                    this.rH = aVar;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.rU.bI != null) {
                            this.rU.bI.pz();
                        }
                        a aVar3 = this.rH;
                        if (aVar3 != null) {
                            aVar3.a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, this.rU.bF);
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.rU.bI != null) {
                            this.rU.bI.py();
                        }
                    }
                }
            });
            this.bN.start();
        }
    }

    private void inflateJsBridgeContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.mJsBridgeContext = bVar;
            bVar.setAdTemplate(this.nM.mAdTemplate);
            com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
            com.kwad.components.ad.reward.k kVar = this.nM;
            bVar2.mScreenOrientation = kVar.mScreenOrientation;
            AdBaseFrameLayout adBaseFrameLayout = kVar.mRootContainer;
            bVar2.agd = adBaseFrameLayout;
            bVar2.Gl = adBaseFrameLayout;
            bVar2.Fv = this.bF;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            this.bH = -1;
            this.bF.setVisibility(8);
            clearJsInterfaceRegister();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            com.kwad.components.ad.reward.monitor.a.a(this.nM.mz, "play_card");
            if (com.kwad.components.ad.reward.k.c(this.nM)) {
                com.kwad.components.core.webview.b.c.a.pR().a(this);
            } else {
                bQ();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.bF = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091157);
            this.pM = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091086);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onUnbind();
            RewardActionBarControl rewardActionBarControl = this.ml;
            if (rewardActionBarControl != null) {
                rewardActionBarControl.a((RewardActionBarControl.f) null);
            }
            com.kwad.components.core.webview.b.c.a.pR().b(this);
            this.nM.b(this.mPlayEndPageListener);
            aL();
            release();
        }
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && "ksad-video-bottom-card-v2".equals(str)) {
            bQ();
        }
    }
}
