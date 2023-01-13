package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.i.b;
import com.kwad.components.ad.reward.e;
import com.kwad.components.ad.reward.presenter.RewardPreEndCardPresenter;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.e;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class o extends a implements com.kwad.components.ad.reward.d.e, e.a, e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.core.webview.a.kwai.a bJ;
    public KsLogoView ln;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.video.g mVideoPlayStateListener;
    @Nullable
    public com.kwad.components.ad.reward.h mp;
    public ImageView px;
    public View qA;
    public DetailVideoView qB;
    public int qC;
    public View qD;
    public FrameLayout qE;
    public Animator qF;
    public Animator qG;
    public Animator qH;
    public AdTemplate qI;
    public List<com.kwad.components.ad.reward.c.b> qJ;
    public float qK;
    public float qL;
    public float qM;
    public long qN;
    public long qO;
    @RewardPreEndCardPresenter.PreEndPageStatus
    public int qz;

    public o() {
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
        this.qz = 1;
        this.qK = 1.2254902f;
        this.qL = 0.80472106f;
        this.qM = 0.0f;
        this.qN = 500L;
        this.qO = 50L;
        this.mVideoPlayStateListener = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.presenter.o.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean qP;
            public long qQ;
            public long qR;
            public boolean qS;
            public final /* synthetic */ o qT;

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
                this.qT = this;
                this.qP = false;
                this.qQ = -1L;
                this.qR = -1L;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || this.qT.qI == null || this.qS) {
                    return;
                }
                if (this.qQ <= 0) {
                    this.qQ = com.kwad.sdk.core.response.a.b.aT(this.qT.qI);
                    this.qR = com.kwad.sdk.core.response.a.b.aS(this.qT.qI) + this.qQ;
                }
                long j3 = this.qQ;
                if (j3 > 0 && !this.qP && j2 > j3) {
                    this.qS = !this.qT.N(true);
                    com.kwad.sdk.core.e.b.d("RewardPreEndCardPresenter", "showError: " + this.qS);
                    if (this.qS) {
                        return;
                    }
                    this.qP = true;
                }
                boolean z = this.qT.qz == 3;
                long j4 = this.qR;
                if (j4 <= 0 || z || j2 <= j4) {
                    return;
                }
                this.qT.O(true);
            }
        };
        this.bJ = new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.reward.presenter.o.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o qT;

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
                this.qT = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    if (aVar == null || com.kwad.sdk.core.response.a.d.b(this.qT.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                        this.qT.nM.mAdOpenInteractionListener.bB();
                        return;
                    }
                    com.kwad.components.ad.reward.c.b a = com.kwad.components.ad.reward.k.a(this.qT.qJ, aVar.creativeId);
                    if (a != null) {
                        this.qT.nM.b(a);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) {
            int b = b(hi());
            O(b);
            com.kwad.components.ad.reward.h hVar = this.mp;
            boolean ay = hVar != null ? hVar.ay() : false;
            com.kwad.sdk.core.e.b.d("RewardPreEndCardPresenter", "webLoadSuccess: " + ay);
            if (ay) {
                int a = a(hi());
                float f = -b;
                this.qM = f;
                Animator a2 = a(true, f, a, true, z);
                this.qF = a2;
                a2.start();
                Animator hh = hh();
                this.qH = hh;
                hh.start();
                this.qz = 2;
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    private void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            ViewGroup.LayoutParams layoutParams = this.qA.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.height = i;
                layoutParams2.bottomMargin = -i;
                return;
            }
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
            layoutParams3.height = i;
            layoutParams3.bottomMargin = -i;
            this.qA.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            Animator a = a(false, (hi() - hj()) + this.qM, a(hj()), false, z);
            this.qG = a;
            a.start();
            com.kwad.sdk.core.d.a.tr();
            com.kwad.sdk.core.d.a.an(this.qI);
            this.qz = 3;
            com.kwad.components.ad.reward.h hVar = this.mp;
            if (hVar != null) {
                hVar.fj();
            }
        }
    }

    private int a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, this, f)) == null) ? (int) (com.kwad.sdk.b.kwai.a.d(getActivity()) - f) : invokeF.intValue;
    }

    private Animator a(boolean z, float f, int i, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        ValueAnimator ofFloat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f), Integer.valueOf(i), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            com.kwad.sdk.core.e.b.d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f + ", videoTargetHeight: " + i);
            if (z) {
                ofFloat = ObjectAnimator.ofFloat(this.qA, Key.TRANSLATION_Y, f);
            } else {
                int height = this.qA.getHeight();
                ViewGroup.LayoutParams layoutParams = this.qA.getLayoutParams();
                ofFloat = ValueAnimator.ofFloat(height, Math.abs(f));
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, layoutParams) { // from class: com.kwad.components.ad.reward.presenter.o.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ o qT;
                    public final /* synthetic */ ViewGroup.LayoutParams qU;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, layoutParams};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.qT = this;
                        this.qU = layoutParams;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            this.qU.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            this.qT.qA.setLayoutParams(this.qU);
                        }
                    }
                });
            }
            ObjectAnimator ofFloat2 = z2 ? ObjectAnimator.ofFloat(this.ln, Key.ALPHA, 0.0f, 255.0f) : null;
            ValueAnimator a = this.qB.a(this.mAdTemplate, i, new ValueAnimator.AnimatorUpdateListener(this, this.px.getLayoutParams()) { // from class: com.kwad.components.ad.reward.presenter.o.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ o qT;
                public final /* synthetic */ ViewGroup.LayoutParams qV;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.qT = this;
                    this.qV = r7;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ViewGroup.LayoutParams layoutParams2 = this.qV;
                        if (layoutParams2 != null) {
                            layoutParams2.height = intValue;
                            this.qT.px.setLayoutParams(this.qV);
                        }
                    }
                }
            });
            long j = z3 ? this.qN : this.qO;
            Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(j);
            animatorSet.setInterpolator(create);
            if (ofFloat2 != null) {
                if (z3) {
                    animatorSet.playTogether(ofFloat, ofFloat2, a);
                } else {
                    animatorSet.playTogether(ofFloat, ofFloat2);
                }
            } else if (z3) {
                animatorSet.playTogether(ofFloat, a);
            } else {
                animatorSet.playTogether(ofFloat);
            }
            return animatorSet;
        }
        return (Animator) invokeCommon.objValue;
    }

    private int b(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65544, this, f)) == null) ? (int) (f + getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d0) + getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d1)) : invokeF.intValue;
    }

    private void g(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, list) == null) {
            com.kwad.components.ad.reward.h hVar = new com.kwad.components.ad.reward.h(list, this.nM.mReportExtData, this);
            this.mp = hVar;
            this.nM.mp = hVar;
            hVar.A(com.kwad.sdk.core.response.a.b.aW(this.mAdTemplate));
            this.mp.a(this.bJ);
            com.kwad.components.ad.reward.h hVar2 = this.mp;
            FrameLayout frameLayout = this.qE;
            com.kwad.components.ad.reward.k kVar = this.nM;
            hVar2.a(frameLayout, kVar.mRootContainer, this.mAdTemplate, kVar.mApkDownloadHelper, kVar.mScreenOrientation);
            com.kwad.sdk.core.e.b.d("RewardPreEndCardPresenter", "startPreloadWebView");
            this.mp.a(new b.InterfaceC0555b(this) { // from class: com.kwad.components.ad.reward.presenter.o.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ o qT;

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
                    this.qT = this;
                }

                @Override // com.kwad.components.ad.i.b.InterfaceC0555b
                public final void hk() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.e.b.d("RewardPreEndCardPresenter", "onPreloadSuccess");
                        this.qT.nM.mJ = true;
                    }
                }
            });
        }
    }

    public static boolean hg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            List<com.kwad.sdk.core.request.model.f> aA = com.kwad.sdk.core.d.a.aA(15);
            if (aA.size() == 0) {
                return true;
            }
            long j = -1;
            int i = 0;
            for (com.kwad.sdk.core.request.model.f fVar : aA) {
                i += fVar.count;
                long j2 = fVar.acW;
                if (j2 > j) {
                    j = j2;
                }
            }
            com.kwad.sdk.core.e.b.d("RewardPreEndCardPresenter", "onBind localCountCheck: allCount: " + i + ", lastShowTime: " + j);
            if (i > com.kwad.sdk.core.d.a.tt()) {
                return false;
            }
            return j + (com.kwad.sdk.core.d.a.tu() * 1000) <= System.currentTimeMillis();
        }
        return invokeV.booleanValue;
    }

    private Animator hh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.qD, Key.ALPHA, 255.0f, 0.0f);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
            ofFloat.setDuration(200L);
            return ofFloat;
        }
        return (Animator) invokeV.objValue;
    }

    private float hi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? com.kwad.sdk.b.kwai.a.c(getActivity()) / this.qK : invokeV.floatValue;
    }

    private float hj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? com.kwad.sdk.b.kwai.a.c(getActivity()) / this.qL : invokeV.floatValue;
    }

    @Override // com.kwad.components.ad.reward.e.a
    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            com.kwad.sdk.core.e.b.w("RewardPreEndCardPresenter", "onError : msg " + str);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            this.nM.eF.a(this.mVideoPlayStateListener);
            this.nM.a(this);
            this.mAdTemplate = this.nM.mAdTemplate;
            this.qC = com.kwad.sdk.b.kwai.a.A(this.qB);
            com.kwad.sdk.b.kwai.a.i(this.qB, 49);
            this.ln.T(this.mAdTemplate);
            boolean hg = hg();
            com.kwad.sdk.core.e.b.d("RewardPreEndCardPresenter", "onBind localCheckResult: " + hg);
            SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
            if (sceneImpl == null || !hg) {
                return;
            }
            com.kwad.components.ad.reward.e.b(sceneImpl, this);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.e.b
    public final void b(AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, adTemplate, j) == null) {
            com.kwad.components.ad.reward.c.b bVar = new com.kwad.components.ad.reward.c.b(adTemplate, com.kwad.components.ad.reward.c.d.AGGREGATION);
            com.kwad.components.ad.reward.k kVar = this.nM;
            if (kVar != null) {
                kVar.c(bVar);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.d.e
    public final void bA() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.qI == null || (i = this.qz) == 3) {
            return;
        }
        if (i == 1) {
            N(false);
            O(false);
        } else if (i == 2) {
            O(true);
        }
    }

    @Override // com.kwad.components.ad.reward.e.a
    public final void e(@Nullable List<com.kwad.components.ad.reward.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            com.kwad.sdk.core.e.b.d("RewardPreEndCardPresenter", "onInnerAdLoad: " + list);
            if (list == null || list.size() == 0) {
                return;
            }
            AdTemplate adTemplate = list.get(0).getAdTemplate();
            this.qI = adTemplate;
            if (com.kwad.sdk.core.response.a.b.aX(adTemplate)) {
                this.qJ = list;
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.mAdTemplate);
                arrayList.addAll(com.kwad.components.ad.reward.c.b.f(list));
                g(arrayList);
                com.kwad.sdk.core.d.a.a(com.kwad.sdk.core.response.a.b.aU(this.qI), com.kwad.sdk.core.response.a.b.aV(this.qI));
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onCreate();
            this.qA = findViewById(R.id.obfuscated_res_0x7f0911a1);
            this.qB = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f0912c9);
            this.ln = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091296);
            this.px = (ImageView) findViewById(R.id.obfuscated_res_0x7f091112);
            this.qD = findViewById(R.id.obfuscated_res_0x7f0911c1);
            this.qE = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0911a2);
        }
    }

    @Override // com.kwad.components.ad.reward.e.a
    public final void onRequestResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            com.kwad.sdk.core.e.b.w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onUnbind();
            com.kwad.components.ad.reward.k kVar = this.nM;
            kVar.mJ = false;
            kVar.eF.b(this.mVideoPlayStateListener);
            this.nM.b(this);
            com.kwad.components.ad.reward.h hVar = this.mp;
            if (hVar != null) {
                hVar.bt();
            }
            Animator animator = this.qH;
            if (animator != null) {
                animator.cancel();
            }
            DetailVideoView detailVideoView = this.qB;
            if (detailVideoView != null) {
                com.kwad.sdk.b.kwai.a.i(detailVideoView, this.qC);
            }
            Animator animator2 = this.qF;
            if (animator2 != null) {
                animator2.cancel();
            }
            this.qH = null;
            this.qF = null;
        }
    }
}
