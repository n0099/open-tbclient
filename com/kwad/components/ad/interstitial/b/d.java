package com.kwad.components.ad.interstitial.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.f.kwai.kwai.b;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.b.kwai.j;
import com.kwad.components.core.webview.b.kwai.n;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.kwai.c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes7.dex */
public final class d extends b {
    public static /* synthetic */ Interceptable $ic = null;
    public static long gO = 400;
    public static float gP = 0.8f;
    public static float gQ = 1.0f;
    public static float gR = 0.749f;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.widget.kwai.b aM;
    public int bH;
    public x.b bM;
    public com.kwad.sdk.core.h.b bX;
    @NonNull
    public KsAdVideoPlayConfig cN;
    public KSFrameLayout dN;
    public aa dP;
    public boolean dR;

    /* renamed from: do  reason: not valid java name */
    public ImageView f6do;
    public com.kwad.sdk.core.video.videoview.a dp;
    public com.kwad.sdk.core.g.d eN;
    public Vibrator eO;
    public ab gN;
    public KSFrameLayout gS;
    public KsAdWebView gT;
    public ImageView gU;
    public a.b gV;
    public j gW;
    public c.a gX;
    @Nullable
    public com.kwad.components.ad.f.kwai.kwai.b gY;
    public boolean gZ;
    public c gh;
    public Dialog gi;
    public final Runnable ha;
    public s.a hb;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    @NonNull
    public Context mContext;
    public Handler mHandler;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(228459822, "Lcom/kwad/components/ad/interstitial/b/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(228459822, "Lcom/kwad/components/ad/interstitial/b/d;");
        }
    }

    public d() {
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
        this.mHandler = new Handler(Looper.getMainLooper());
        this.bH = -1;
        this.gZ = false;
        this.bX = new com.kwad.sdk.core.h.c(this) { // from class: com.kwad.components.ad.interstitial.b.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d hc;

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
                this.hc = this;
            }

            @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
            public final void aR() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "onPageVisible");
                    if (this.hc.dP != null) {
                        this.hc.dP.py();
                        this.hc.dP.pz();
                    }
                }
            }

            @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
            public final void aS() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "onPageInvisible");
                    if (this.hc.dP != null) {
                        this.hc.dP.pA();
                        this.hc.dP.pB();
                    }
                }
            }
        };
        this.ha = new Runnable(this) { // from class: com.kwad.components.ad.interstitial.b.d.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d hc;

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
                this.hc = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "rollBackRunnable run");
                    this.hc.t("4");
                }
            }
        };
        this.hb = new s.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.23
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d hc;

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
                this.hc = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.s.a
            public final void onAdShow() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.hc.mAdTemplate.mPvReported || this.hc.gh.gn || this.hc.gh.fo == null) {
                    return;
                }
                this.hc.gh.fo.onAdShow();
                com.kwad.components.ad.interstitial.monitor.b.cr().a(this.hc.mAdTemplate, 2);
            }
        };
        this.bM = new x.b(this) { // from class: com.kwad.components.ad.interstitial.b.d.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d hc;

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
                this.hc = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || this.hc.dR || this.hc.gZ) {
                    return;
                }
                this.hc.bH = aVar.status;
                if (this.hc.bH != 1) {
                    this.hc.t("3");
                    return;
                }
                this.hc.gT.setVisibility(0);
                com.kwad.components.core.j.a.og().O(this.hc.mAdTemplate);
                this.hc.mHandler.removeCallbacksAndMessages(null);
                bd.c(this.hc.ha);
                if (this.hc.gY != null) {
                    this.hc.gY.ez();
                }
            }
        };
    }

    public static ViewGroup.LayoutParams A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            int i2 = (int) (i * gR);
            return new ViewGroup.LayoutParams((int) (i2 / 0.749f), i2);
        }
        return (ViewGroup.LayoutParams) invokeI.objValue;
    }

    public static float a(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? (z && z2) ? 1.7777778f : 0.749f : invokeCommon.floatValue;
    }

    public static ViewGroup.LayoutParams a(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int i2 = (int) (i * (z ? gP : gQ));
            return new ViewGroup.LayoutParams(i2, (int) (i2 * (z ? 1.7777778f : 0.749f)));
        }
        return (ViewGroup.LayoutParams) invokeCommon.objValue;
    }

    public static ViewGroup.MarginLayoutParams a(WebCardVideoPositionHandler.VideoPosition videoPosition, ViewGroup.MarginLayoutParams marginLayoutParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, videoPosition, marginLayoutParams)) == null) {
            marginLayoutParams.topMargin = videoPosition.topMargin;
            marginLayoutParams.leftMargin = videoPosition.leftMargin;
            marginLayoutParams.width = videoPosition.width;
            marginLayoutParams.height = videoPosition.height;
            return marginLayoutParams;
        }
        return (ViewGroup.MarginLayoutParams) invokeLL.objValue;
    }

    public static void a(ViewGroup.MarginLayoutParams marginLayoutParams, ViewGroup.MarginLayoutParams marginLayoutParams2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, marginLayoutParams, marginLayoutParams2) == null) {
            marginLayoutParams2.leftMargin = marginLayoutParams.leftMargin;
            marginLayoutParams2.rightMargin = marginLayoutParams.rightMargin;
            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
            marginLayoutParams2.bottomMargin = marginLayoutParams.bottomMargin;
            marginLayoutParams2.width = marginLayoutParams.width;
            marginLayoutParams2.height = marginLayoutParams.height;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, aVar, str) == null) {
            aVar.a(da());
            aVar.a(cZ());
            aVar.a(new com.kwad.components.core.webview.b.kwai.c());
            aVar.a(cS());
            aVar.a(new l(this.mJsBridgeContext));
            aVar.a(cR());
            aVar.a(cQ());
            aVar.a(cW());
            aa aaVar = new aa();
            this.dP = aaVar;
            aVar.a(aaVar);
            this.gh.a(cT());
            aVar.a(cX());
            aVar.a(cU());
            aVar.a(new o(this.mJsBridgeContext));
            aVar.a(cN());
            aVar.a(new x(this.bM, str));
            aVar.a(cL());
            s sVar = new s(this.mJsBridgeContext);
            sVar.a(this.hb);
            aVar.a(sVar);
            aVar.a(cV());
            aVar.a(new w(getOpenNewPageListener()));
            if (com.kwad.sdk.core.response.a.b.bZ(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
                aVar.a(cK());
            }
            if (cO() != null) {
                aVar.a(this.gY);
            }
            aVar.a(cM());
            aVar.a(cP());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdInfo adInfo, WebCardVideoPositionHandler.VideoPosition videoPosition, KSFrameLayout kSFrameLayout, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{adInfo, videoPosition, kSFrameLayout, Boolean.valueOf(z)}) == null) {
            kSFrameLayout.setWidthBasedRatio(!z);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) kSFrameLayout.getLayoutParams();
            com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "updateVideoContainerSize before size: " + marginLayoutParams.width + StringUtil.ARRAY_ELEMENT_SEPARATOR + marginLayoutParams.height);
            a(videoPosition, marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams);
            float aw = com.kwad.sdk.core.response.a.a.aw(adInfo);
            com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "updateVideoContainerSize materialRatio: " + aw);
            if (!z || aw <= 0.0f) {
                kSFrameLayout.setRatio(0.0f);
            } else {
                int i = marginLayoutParams.width;
                int i2 = marginLayoutParams.height;
                int i3 = (int) (i2 / aw);
                marginLayoutParams.width = i3;
                marginLayoutParams.leftMargin += (i - i3) / 2;
                if (i3 != 0) {
                    float f = i2 / i3;
                    com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "cardParams ratio: " + f);
                    kSFrameLayout.setRatio(f);
                }
            }
            com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "cardParams width: " + marginLayoutParams.width + ", height: " + marginLayoutParams.height);
            kSFrameLayout.setLayoutParams(marginLayoutParams);
            float dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070372);
            WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel = videoPosition.cornerRadius;
            if (kSAdJSCornerModel != null) {
                kSFrameLayout.setRadius((float) kSAdJSCornerModel.topLeft, (float) kSAdJSCornerModel.topRight, (float) kSAdJSCornerModel.bottomRight, (float) kSAdJSCornerModel.bottomLeft);
            } else if (marginLayoutParams.width > marginLayoutParams.height) {
                kSFrameLayout.setRadius(dimension, dimension, 0.0f, 0.0f);
            } else {
                kSFrameLayout.setRadius(dimension, dimension, dimension, dimension);
            }
            if (z) {
                this.gU.setVisibility(0);
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.gU.getLayoutParams();
                a(marginLayoutParams2, marginLayoutParams3);
                this.gU.setLayoutParams(marginLayoutParams3);
                this.gh.a(this.mContext, adInfo, this.mAdTemplate, this.gU);
            } else {
                this.gU.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                kSFrameLayout.setOutlineProvider(new ViewOutlineProvider(this) { // from class: com.kwad.components.ad.interstitial.b.d.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d hc;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.hc = this;
                    }

                    @Override // android.view.ViewOutlineProvider
                    public final void getOutline(View view2, Outline outline) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view2, outline) == null) {
                            outline.setRect(0, 0, view2.getWidth(), view2.getHeight());
                        }
                    }
                });
                kSFrameLayout.setClipToOutline(true);
            }
        }
    }

    public static boolean a(Dialog dialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, dialog)) == null) {
            Activity ownerActivity = dialog.getOwnerActivity();
            return (ownerActivity == null || ownerActivity.isFinishing()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    private void aE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            String bo = com.kwad.sdk.core.response.a.b.bo(this.mAdTemplate);
            if (TextUtils.isEmpty(bo)) {
                t("1");
            } else {
                v(bo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, this, new Object[]{Double.valueOf(d)}) == null) {
            this.gh.a(new c.b(getContext()).m(true).b(d).y(2).a(this.gS.getTouchCoords()).z(Cea708Decoder.COMMAND_DF5));
            bd.a(getContext(), this.eO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            boolean av = com.kwad.sdk.core.response.a.a.av(this.mAdInfo);
            boolean cB = ag.cB(this.mContext);
            float a = a(cB, av);
            com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "replaceNativeView cardRatio: " + a);
            this.gh.gj.setRatio(a);
            ViewGroup viewGroup = (ViewGroup) this.gS.findViewById(R.id.obfuscated_res_0x7f091108);
            viewGroup.setVisibility(0);
            viewGroup.post(new Runnable(this, cB, av, viewGroup) { // from class: com.kwad.components.ad.interstitial.b.d.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d hc;
                public final /* synthetic */ boolean hj;
                public final /* synthetic */ boolean hk;
                public final /* synthetic */ ViewGroup hl;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(cB), Boolean.valueOf(av), viewGroup};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.hc = this;
                    this.hj = cB;
                    this.hk = av;
                    this.hl = viewGroup;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ViewGroup.LayoutParams a2 = this.hj ? d.a(this.hc.gS.getWidth(), this.hk) : d.A(this.hc.gS.getHeight());
                        this.hc.gT.setVisibility(8);
                        this.hc.dN.setVisibility(8);
                        ViewParent parent = this.hc.gh.gj.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(this.hc.gh.gj);
                        }
                        this.hl.addView(this.hc.gh.gj);
                        this.hc.gh.gj.f(a2.width, a2.height);
                        this.hc.dp.requestLayout();
                        this.hc.gZ = true;
                    }
                }
            });
        }
    }

    @NonNull
    private ab cK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            ab abVar = new ab(new ab.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.24
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d hc;

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
                    this.hc = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.ab.a
                public final void dd() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.hc.db();
                    }
                }
            });
            this.gN = abVar;
            return abVar;
        }
        return (ab) invokeV.objValue;
    }

    private ac cL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) ? new ac(this.mJsBridgeContext, this.mApkDownloadHelper) : (ac) invokeV.objValue;
    }

    private com.kwad.components.core.webview.b.kwai.d cM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            com.kwad.components.core.webview.b.a.h hVar = new com.kwad.components.core.webview.b.a.h();
            hVar.NQ = this.gh.gx;
            return new com.kwad.components.core.webview.b.kwai.d(hVar);
        }
        return (com.kwad.components.core.webview.b.kwai.d) invokeV.objValue;
    }

    private k cN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            k kVar = new k(this.mJsBridgeContext);
            kVar.a(new k.b(this) { // from class: com.kwad.components.ad.interstitial.b.d.25
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d hc;

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
                    this.hc = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.k.b
                public final void a(k.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        aVar.height = com.kwad.sdk.b.kwai.a.getScreenHeight(this.hc.mContext);
                        aVar.width = com.kwad.sdk.b.kwai.a.getScreenHeight(this.hc.mContext);
                    }
                }
            });
            return kVar;
        }
        return (k) invokeV.objValue;
    }

    private com.kwad.components.ad.f.kwai.kwai.b cO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            com.kwad.components.ad.f.kwai.kwai.b j = com.kwad.components.ad.f.kwai.kwai.b.j(this.mAdTemplate);
            this.gY = j;
            if (j != null) {
                j.a(new b.InterfaceC0532b(this) { // from class: com.kwad.components.ad.interstitial.b.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d hc;

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
                        this.hc = this;
                    }

                    @Override // com.kwad.components.ad.f.kwai.kwai.b.InterfaceC0532b
                    public final void C(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                            if (i == com.kwad.components.ad.f.kwai.kwai.b.kt) {
                                this.hc.gh.b(this.hc.getContext(), this.hc.mAdTemplate);
                                this.hc.gh.a(true, -1, this.hc.gh.dp);
                            }
                            this.hc.cY();
                        }
                    }
                });
            }
            return this.gY;
        }
        return (com.kwad.components.ad.f.kwai.kwai.b) invokeV.objValue;
    }

    private com.kwad.components.ad.f.kwai.kwai.a cP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            com.kwad.components.ad.f.kwai.kwai.a aVar = new com.kwad.components.ad.f.kwai.kwai.a();
            this.gh.gs.add(new c.InterfaceC0541c(this, aVar) { // from class: com.kwad.components.ad.interstitial.b.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d hc;
                public final /* synthetic */ com.kwad.components.ad.f.kwai.kwai.a hd;

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
                    this.hc = this;
                    this.hd = aVar;
                }

                @Override // com.kwad.components.ad.interstitial.b.c.InterfaceC0541c
                public final void cH() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.hd.ey();
                    }
                }
            });
            return aVar;
        }
        return (com.kwad.components.ad.f.kwai.kwai.a) invokeV.objValue;
    }

    private n cQ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) {
            n nVar = new n();
            nVar.a(new n.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d hc;

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
                    this.hc = this;
                }

                @Override // com.kwad.components.core.webview.b.kwai.n.a
                public final void a(com.kwad.components.core.webview.b.a.i iVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, iVar) == null) {
                        this.hc.dp.setVideoSoundEnable(!iVar.NR);
                    }
                }
            });
            return nVar;
        }
        return (n) invokeV.objValue;
    }

    @NonNull
    private com.kwad.components.core.webview.b.kwai.i cR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) ? new com.kwad.components.core.webview.b.kwai.i(this) { // from class: com.kwad.components.ad.interstitial.b.d.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d hc;

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
                this.hc = this;
            }

            @Override // com.kwad.components.core.webview.b.kwai.e, com.kwad.sdk.core.webview.kwai.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                    super.a(str, cVar);
                    com.kwad.components.core.webview.b.a.i iVar = new com.kwad.components.core.webview.b.a.i();
                    iVar.NR = !this.hc.cN.isVideoSoundEnable();
                    cVar.a(iVar);
                }
            }
        } : (com.kwad.components.core.webview.b.kwai.i) invokeV.objValue;
    }

    @NonNull
    private r cS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) ? new r(this.mJsBridgeContext, new r.b(this) { // from class: com.kwad.components.ad.interstitial.b.d.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d hc;

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
                this.hc = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.r.b
            public final void a(r.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                }
            }
        }) : (r) invokeV.objValue;
    }

    private a.b cT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            a.b bVar = new a.b(this, new com.kwad.components.core.webview.b.a.s()) { // from class: com.kwad.components.ad.interstitial.b.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d hc;
                public final /* synthetic */ com.kwad.components.core.webview.b.a.s he;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.hc = this;
                    this.he = r7;
                }

                @Override // com.kwad.components.core.video.a.b
                public final void bm() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.components.core.webview.b.a.s sVar = this.he;
                        sVar.NZ = false;
                        sVar.Oa = true;
                        this.he.kD = com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.bQ(this.hc.mJsBridgeContext.getAdTemplate()));
                        this.hc.gW.a(this.he);
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void d(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        com.kwad.components.core.webview.b.a.s sVar = this.he;
                        sVar.NZ = false;
                        sVar.Oa = false;
                        sVar.kD = (int) Math.ceil(((float) j) / 1000.0f);
                        this.hc.gW.a(this.he);
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void onVideoPlayStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        com.kwad.components.core.webview.b.a.s sVar = this.he;
                        sVar.NZ = false;
                        sVar.Oa = false;
                        sVar.kD = 0;
                        this.hc.gW.a(this.he);
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void onVideoPlaying() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        if (this.hc.f6do.getVisibility() == 0) {
                            this.hc.f6do.setVisibility(8);
                        }
                        com.kwad.components.core.webview.b.a.s sVar = this.he;
                        sVar.NZ = false;
                        sVar.Oa = false;
                        sVar.kD = (int) Math.ceil(((float) this.hc.dp.getCurrentPosition()) / 1000.0f);
                        this.hc.gW.a(this.he);
                    }
                }
            };
            this.gV = bVar;
            return bVar;
        }
        return (a.b) invokeV.objValue;
    }

    @NonNull
    private WebCardVideoPositionHandler cU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) ? new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d hc;

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
                this.hc = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
            public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                AdInfo adInfo;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, videoPosition) == null) {
                    com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "onVideoSetPosition hadRollBackToNative: " + this.hc.gZ);
                    if (this.hc.gZ || (adInfo = this.hc.mAdInfo) == null || !com.kwad.sdk.core.response.a.a.aB(adInfo)) {
                        return;
                    }
                    c unused = this.hc.gh;
                    d dVar = this.hc;
                    boolean a = c.a(dVar.mContext, dVar.mAdInfo);
                    d dVar2 = this.hc;
                    dVar2.a(dVar2.mAdInfo, videoPosition, dVar2.dN, a);
                    this.hc.dN.setVisibility(0);
                    this.hc.gT.setVisibility(0);
                }
            }
        }) : (WebCardVideoPositionHandler) invokeV.objValue;
    }

    private ah cV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, this)) == null) {
            ah ahVar = new ah(getContext(), this.mAdTemplate);
            ahVar.a(new ah.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d hc;

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
                    this.hc = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.ah.a
                public final boolean dc() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                        if (this.hc.gW != null) {
                            this.hc.gW.aD(false);
                        }
                        bd.runOnUiThread(new Runnable(this) { // from class: com.kwad.components.ad.interstitial.b.d.9.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass9 hf;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.hf = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && this.hf.hc.gi != null && d.a(this.hf.hc.gi)) {
                                    this.hf.hc.gi.dismiss();
                                    if (this.hf.hc.gh.gn || this.hf.hc.gh.fo == null) {
                                        return;
                                    }
                                    this.hf.hc.gh.fo.onAdClosed();
                                }
                            }
                        });
                        boolean z = !this.hc.gh.gv;
                        if (z) {
                            this.hc.gh.a(true, -1, this.hc.gh.dp);
                        }
                        return z;
                    }
                    return invokeV2.booleanValue;
                }
            });
            return ahVar;
        }
        return (ah) invokeV.objValue;
    }

    @NonNull
    private q cW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) ? new q(new q.b(this) { // from class: com.kwad.components.ad.interstitial.b.d.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d hc;

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
                this.hc = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.q.b
            public final void a(q.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || this.hc.gi == null) {
                    return;
                }
                this.hc.mHandler.post(new Runnable(this, aVar) { // from class: com.kwad.components.ad.interstitial.b.d.11.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ q.a hg;
                    public final /* synthetic */ AnonymousClass11 hh;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar};
                            interceptable3.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.hh = this;
                        this.hg = aVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                            if (!this.hh.hc.gh.gn && this.hg.type == 0 && !this.hh.hc.gh.gl && !this.hh.hc.gh.gm && com.kwad.components.ad.interstitial.c.a.c(this.hh.hc.gh)) {
                                this.hh.hc.gh.gm = true;
                                com.kwad.components.ad.interstitial.a.b.J(this.hh.hc.mContext);
                            } else if (d.a(this.hh.hc.gi)) {
                                this.hh.hc.gi.dismiss();
                                this.hh.hc.gh.a(this.hg.type == 3, -1, this.hh.hc.dp);
                                if (this.hh.hc.gh.gn || this.hh.hc.gh.fo == null) {
                                    return;
                                }
                                this.hh.hc.gh.fo.onAdClosed();
                            }
                        }
                    }
                });
            }
        }) : (q) invokeV.objValue;
    }

    private j cX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) {
            j jVar = new j(this) { // from class: com.kwad.components.ad.interstitial.b.d.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d hc;

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
                    this.hc = this;
                }

                @Override // com.kwad.components.core.webview.b.kwai.j, com.kwad.components.core.webview.b.kwai.e, com.kwad.sdk.core.webview.kwai.a
                public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                        super.a(str, cVar);
                        if (this.hc.dp.isIdle()) {
                            com.kwad.components.core.webview.b.a.s sVar = new com.kwad.components.core.webview.b.a.s();
                            sVar.NZ = false;
                            sVar.Oa = false;
                            sVar.kD = 0;
                            cVar.a(sVar);
                        }
                        if (this.hc.dp.isCompleted()) {
                            com.kwad.components.core.webview.b.a.s sVar2 = new com.kwad.components.core.webview.b.a.s();
                            sVar2.NZ = false;
                            sVar2.Oa = true;
                            sVar2.kD = com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.bQ(this.hc.mJsBridgeContext.getAdTemplate()));
                            cVar.a(sVar2);
                        }
                    }
                }
            };
            this.gW = jVar;
            return jVar;
        }
        return (j) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cY() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            com.kwad.sdk.core.video.videoview.a aVar = this.gh.dp;
            if (aVar != null) {
                aVar.release();
            }
            this.gh.gi.dismiss();
            c cVar = this.gh;
            if (cVar.gn || (adInteractionListener = cVar.fo) == null) {
                return;
            }
            adInteractionListener.onAdClosed();
        }
    }

    @NonNull
    private com.kwad.components.core.webview.jshandler.f cZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, this)) == null) ? new com.kwad.components.core.webview.jshandler.f(this.mJsBridgeContext, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d hc;

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
                this.hc = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                if (!this.hc.gh.gn && this.hc.gh.fo != null) {
                    this.hc.gh.fo.onAdClicked();
                }
                this.hc.gh.gl = true;
                if (!this.hc.gh.gn) {
                    this.hc.gh.cy();
                }
                if (this.hc.gh.gi == null || !com.kwad.components.ad.interstitial.kwai.b.co()) {
                    return;
                }
                this.hc.gh.gi.dismiss();
            }
        }) : (com.kwad.components.core.webview.jshandler.f) invokeV.objValue;
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65576, this) == null) || (aVar = this.mJsInterface) == null) {
            return;
        }
        aVar.destroy();
        this.mJsInterface = null;
    }

    @NonNull
    private com.kwad.components.core.webview.jshandler.i da() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, this)) == null) ? new com.kwad.components.core.webview.jshandler.i(this.mJsBridgeContext, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d hc;

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
                this.hc = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                if (!this.hc.gh.gn && this.hc.gh.fo != null) {
                    this.hc.gh.fo.onAdClicked();
                }
                this.hc.gh.gl = true;
                if (!this.hc.gh.gn) {
                    this.hc.gh.cy();
                }
                if (this.hc.gh.gi == null || !com.kwad.components.ad.interstitial.kwai.b.co()) {
                    return;
                }
                this.hc.gh.gi.dismiss();
            }
        }) : (com.kwad.components.core.webview.jshandler.i) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            float bm = com.kwad.sdk.core.response.a.b.bm(this.mAdTemplate);
            if (this.eN == null) {
                com.kwad.sdk.core.g.d dVar = new com.kwad.sdk.core.g.d(bm);
                this.eN = dVar;
                dVar.a(new com.kwad.sdk.core.g.b(this) { // from class: com.kwad.components.ad.interstitial.b.d.18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d hc;

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
                        this.hc = this;
                    }

                    @Override // com.kwad.sdk.core.g.b
                    public final void a(double d) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Double.valueOf(d)}) == null) {
                            if (com.kwad.sdk.b.kwai.a.g(this.hc.gS, 100)) {
                                this.hc.c(d);
                            }
                            bd.a(new Runnable(this) { // from class: com.kwad.components.ad.interstitial.b.d.18.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass18 hi;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.hi = this;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "onShakeEvent openGate2");
                                        this.hi.hc.eN.vb();
                                    }
                                }
                            }, null, 500L);
                        }
                    }

                    @Override // com.kwad.sdk.core.g.b
                    public final void bX() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        }
                    }
                });
            }
            this.eN.d(bm);
            this.eN.bz(getContext());
        }
    }

    private w.a getOpenNewPageListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, this)) == null) ? new w.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d hc;

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
                this.hc = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.w.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    AdWebViewActivityProxy.launch(this.hc.mContext, new AdWebViewActivityProxy.a.C0584a().ao(bVar.title).ap(bVar.url).N(this.hc.mAdTemplate).nx());
                }
            }
        } : (w.a) invokeV.objValue;
    }

    @NonNull
    private KsAdWebView.d getWebListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65584, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.interstitial.b.d.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d hc;

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
                this.hc = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, str2) == null) {
                    this.hc.t("1");
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
        if (interceptable == null || interceptable.invokeV(65587, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.mJsBridgeContext = bVar;
            bVar.setAdTemplate(this.gh.mAdTemplate);
            int i = !ag.cB(this.mContext) ? 1 : 0;
            com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
            bVar2.mScreenOrientation = i;
            KSFrameLayout kSFrameLayout = this.gS;
            bVar2.agd = kSFrameLayout;
            bVar2.Gl = kSFrameLayout;
            bVar2.Fv = this.gT;
            bVar2.mReportExtData = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65599, this, str) == null) {
            com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "handleWebViewError " + str);
            com.kwad.sdk.core.g.d dVar = this.eN;
            if (dVar != null) {
                dVar.bA(getContext());
            }
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.dR) {
                return;
            }
            this.dR = true;
            com.kwad.components.core.j.a og = com.kwad.components.core.j.a.og();
            AdTemplate adTemplate = this.mAdTemplate;
            og.c(adTemplate, com.kwad.sdk.core.response.a.b.bo(adTemplate), str);
            this.mHandler.post(new Runnable(this) { // from class: com.kwad.components.ad.interstitial.b.d.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d hc;

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
                    this.hc = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.hc.cJ();
                        this.hc.gh.cx();
                    }
                }
            });
            c.a aVar = this.gX;
            if (aVar != null) {
                aVar.b((KsAdWebView.d) null);
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65602, this, str) == null) {
            clearJsInterfaceRegister();
            c.a b = this.gT.getClientConfig().R(this.mAdTemplate).b(getWebListener());
            this.gX = b;
            this.gT.setClientConfig(b);
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.gT);
            this.mJsInterface = aVar;
            a(aVar, str);
            this.gT.addJavascriptInterface(this.mJsInterface, "KwaiAd");
            this.gT.loadUrl(str);
            bd.a(this.ha, null, 3000L);
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            c cVar = (c) xR();
            this.gh = cVar;
            this.gZ = false;
            this.gi = cVar.gi;
            this.cN = cVar.cN;
            this.mApkDownloadHelper = cVar.mApkDownloadHelper;
            AdTemplate adTemplate = cVar.mAdTemplate;
            this.mAdTemplate = adTemplate;
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            this.dp = this.gh.dp;
            this.aM.qi();
            this.aM.a(this.bX);
            if (com.kwad.sdk.core.response.a.b.bn(this.mAdTemplate)) {
                this.mHandler.post(new Runnable(this) { // from class: com.kwad.components.ad.interstitial.b.d.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d hc;

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
                        this.hc = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.hc.cJ();
                            this.hc.gh.cx();
                        }
                    }
                });
                return;
            }
            inflateJsBridgeContext();
            aE();
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void cv() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.cv();
            com.kwad.components.ad.f.kwai.kwai.b bVar = this.gY;
            if (bVar != null) {
                bVar.eB();
            }
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void cw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.cw();
            com.kwad.components.ad.f.kwai.kwai.b bVar = this.gY;
            if (bVar != null) {
                bVar.eA();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onCreate();
            KsAdWebView ksAdWebView = (KsAdWebView) getRootView().findViewById(R.id.obfuscated_res_0x7f09126c);
            this.gT = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.gT.setVisibility(4);
            this.aM = new com.kwad.components.core.widget.kwai.b(this.gT, 100);
            this.gS = (KSFrameLayout) getRootView().findViewById(R.id.obfuscated_res_0x7f0910b6);
            this.dN = (KSFrameLayout) getRootView().findViewById(R.id.obfuscated_res_0x7f091243);
            this.f6do = (ImageView) getRootView().findViewById(R.id.obfuscated_res_0x7f091253);
            this.gU = (ImageView) getRootView().findViewById(R.id.obfuscated_res_0x7f091110);
            Context context = getContext();
            this.mContext = context;
            if (context != null) {
                this.eO = (Vibrator) context.getSystemService("vibrator");
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onUnbind();
            this.mHandler.removeCallbacksAndMessages(null);
            this.aM.b(this.bX);
            this.aM.qj();
            com.kwad.sdk.core.g.d dVar = this.eN;
            if (dVar != null) {
                dVar.bA(getContext());
            }
            c.a aVar = this.gX;
            if (aVar != null) {
                aVar.b((KsAdWebView.d) null);
            }
        }
    }
}
