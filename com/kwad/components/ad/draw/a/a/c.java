package com.kwad.components.ad.draw.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.ViewGroup;
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
import com.kwad.components.ad.draw.a.a.a;
import com.kwad.components.core.m.n;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes8.dex */
public final class c extends com.kwad.components.ad.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.b bA;
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
    public ViewGroup bh;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public g mVideoPlayStateListener;

    public c() {
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
        this.mVideoPlayStateListener = new h(this) { // from class: com.kwad.components.ad.draw.a.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c bP;

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
                this.bP = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.onVideoPlayCompleted();
                    this.bP.release();
                }
            }
        };
        this.bA = new a.b(this) { // from class: com.kwad.components.ad.draw.a.a.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c bP;

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
                this.bP = this;
            }

            @Override // com.kwad.components.ad.draw.a.a.a.b
            public final boolean ay() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.bP.aG() : invokeV.booleanValue;
            }
        };
        this.bJ = new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.draw.a.a.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c bP;

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
                this.bP = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || this.bP.aK.aJ == null) {
                    return;
                }
                this.bP.aK.aJ.onAdClicked();
            }
        };
        this.bK = new r.b(this) { // from class: com.kwad.components.ad.draw.a.a.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c bP;

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
                this.bP = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.r.b
            public final void a(r.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.bP.bG = aVar;
                    this.bP.bF.setTranslationY(aVar.height + aVar.bottomMargin);
                }
            }
        };
        this.bL = new q.b(this) { // from class: com.kwad.components.ad.draw.a.a.c.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c bP;

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
                this.bP = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.q.b
            public final void a(q.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.bP.aJ();
                }
            }
        };
        this.bM = new x.b(this) { // from class: com.kwad.components.ad.draw.a.a.c.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c bP;

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
                this.bP = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.bP.bH = aVar.status;
                    com.kwad.sdk.core.e.b.i("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
                }
            }
        };
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            aVar.a(new i(this.mJsBridgeContext, this.mApkDownloadHelper, this.bJ));
            aVar.a(new f(this.mJsBridgeContext, this.mApkDownloadHelper, this.bJ));
            aVar.a(new l(this.mJsBridgeContext));
            aVar.a(new o(this.mJsBridgeContext));
            aVar.a(new k(this.mJsBridgeContext));
            aVar.a(new r(this.mJsBridgeContext, this.bK));
            aVar.a(new x(this.bM, com.kwad.sdk.core.response.a.b.aN(this.mAdTemplate)));
            aa aaVar = new aa();
            this.bI = aaVar;
            aVar.a(aaVar);
            aVar.a(new ac(this.mJsBridgeContext, this.mApkDownloadHelper));
            aVar.a(new q(this.bL));
            aVar.a(new s(this.mJsBridgeContext));
        }
    }

    private void aE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.bH = -1;
            aF();
            this.bF.setBackgroundColor(0);
            this.bF.getBackground().setAlpha(0);
            this.bF.setVisibility(4);
            this.bF.loadUrl(com.kwad.sdk.core.response.a.b.aN(this.mAdTemplate));
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.bH == 1) {
                aH();
                return true;
            }
            aM();
            return false;
        }
        return invokeV.booleanValue;
    }

    private void aH() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (this.bG == null) {
                aI();
                return;
            }
            aL();
            this.bh.setVisibility(8);
            this.bF.setVisibility(0);
            KsAdWebView ksAdWebView = this.bF;
            r.a aVar = this.bG;
            ValueAnimator c = n.c(ksAdWebView, aVar.height + aVar.bottomMargin, 0);
            this.bN = c;
            c.setInterpolator(new DecelerateInterpolator(2.0f));
            this.bN.setDuration(300L);
            this.bN.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.draw.a.a.c.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c bP;

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
                    this.bP = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.bP.bI != null) {
                            this.bP.bI.pz();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.bP.bI != null) {
                            this.bP.bI.py();
                        }
                    }
                }
            });
            this.bN.start();
        }
    }

    private void aI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            aa aaVar = this.bI;
            if (aaVar != null) {
                aaVar.py();
            }
            this.bh.setVisibility(8);
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
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.bF.getVisibility() == 0) {
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
            this.bO.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.draw.a.a.c.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c bP;

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
                    this.bP = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.bP.bF.setVisibility(4);
                        this.bP.bh.setVisibility(0);
                        if (this.bP.bI != null) {
                            this.bP.bI.pB();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.bP.bI != null) {
                            this.bP.bI.pA();
                        }
                    }
                }
            });
            this.bO.start();
        }
    }

    private void aK() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && this.bF.getVisibility() == 0) {
            aa aaVar = this.bI;
            if (aaVar != null) {
                aaVar.pA();
            }
            this.bF.setVisibility(4);
            this.bh.setVisibility(0);
            aa aaVar2 = this.bI;
            if (aaVar2 != null) {
                aaVar2.pB();
            }
        }
    }

    private void aL() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            int i = this.bH;
            String str = i == -1 ? com.alipay.sdk.data.a.O : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
            com.kwad.sdk.core.e.b.w("DrawPlayWebCard", "show webCard fail, reason: " + str);
        }
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (aVar = this.mJsInterface) == null) {
            return;
        }
        aVar.destroy();
        this.mJsInterface = null;
    }

    private void inflateJsBridgeContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.mJsBridgeContext = bVar;
            bVar.setAdTemplate(this.aK.mAdTemplate);
            com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
            bVar2.mScreenOrientation = 0;
            AdBaseFrameLayout adBaseFrameLayout = this.aK.mRootContainer;
            bVar2.agd = adBaseFrameLayout;
            bVar2.Gl = adBaseFrameLayout;
            bVar2.Fv = this.bF;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.bH = -1;
            this.bF.setVisibility(8);
            clearJsInterfaceRegister();
        }
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            com.kwad.components.ad.draw.kwai.b bVar = this.aK;
            this.mAdTemplate = bVar.mAdTemplate;
            bVar.ba.a(this.bA);
            com.kwad.components.ad.draw.kwai.b bVar2 = this.aK;
            this.mApkDownloadHelper = bVar2.mApkDownloadHelper;
            bVar2.aL.a(this.mVideoPlayStateListener);
            inflateJsBridgeContext();
            aE();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.bh = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0910eb);
            this.bF = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0911b6);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onUnbind();
            this.aK.ba.a((a.b) null);
            this.aK.aL.b(this.mVideoPlayStateListener);
            aL();
            release();
        }
    }
}
