package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortraitForLive;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarH5;
import com.kwad.components.core.m.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.core.webview.b.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ValueAnimator bN;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public RewardActionBarControl ml;
    public KsLogoView pM;
    public ActionBarAppLandscape rn;
    public ActionBarAppPortrait ro;
    @Nullable
    public ActionBarAppPortraitForLive rp;
    public ActionBarH5 rq;
    public boolean rr;
    public boolean rs;
    @Nullable
    public ViewGroup rt;
    @Nullable
    public ViewGroup ru;
    public p rv;
    public RewardActionBarControl.b rw;

    /* renamed from: rx  reason: collision with root package name */
    public com.kwad.components.ad.reward.d.e f1086rx;

    public b() {
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
        this.rr = false;
        this.rw = new RewardActionBarControl.b(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b ry;

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
                this.ry = this;
            }

            @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
            public final void a(boolean z, a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, aVar) == null) {
                    this.ry.rs = true;
                    this.ry.a(z, aVar);
                }
            }
        };
        this.f1086rx = new com.kwad.components.ad.reward.d.e(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b ry;

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
                this.ry = this;
            }

            @Override // com.kwad.components.ad.reward.d.e
            public final void bA() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.ry.rs = false;
                    this.ry.Q(false);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65537, this, z) == null) && this.rr) {
            this.rr = false;
            this.pM.setVisibility(8);
            ViewGroup viewGroup = this.rt;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            if (!com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                if (z) {
                    d(this.rq, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
                } else {
                    this.rq.setVisibility(8);
                }
            } else if (this.nM.mScreenOrientation == 1) {
                if (z) {
                    hq();
                } else {
                    hr();
                }
            } else if (z) {
                d(this.ro, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
            } else {
                this.ro.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, a aVar) {
        ViewGroup viewGroup;
        RewardActionBarControl.ShowActionBarResult showActionBarResult;
        ViewGroup viewGroup2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TRACKBALL, this, z, aVar) == null) || this.rr) {
            return;
        }
        this.rr = true;
        this.pM.setVisibility(l(this.mAdInfo) ? 8 : 0);
        if (com.kwad.sdk.core.response.a.a.aY(this.mAdInfo) && com.kwad.sdk.core.response.a.d.cd(this.mAdTemplate) && ag.cB(getContext())) {
            if (this.rv == null) {
                p pVar = new p();
                this.rv = pVar;
                pVar.a(new p.a(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b ry;

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
                        this.ry = this;
                    }

                    @Override // com.kwad.components.ad.reward.k.p.a
                    public final void hs() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        }
                    }

                    @Override // com.kwad.components.ad.reward.k.p.a
                    public final void ht() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            com.kwad.components.ad.reward.b.eV().c(PlayableSource.ACTIONBAR_CLICK, new com.kwad.components.ad.reward.f.a(this.ry.getContext()));
                            com.kwad.sdk.core.report.a.r(this.ry.nM.mAdTemplate, 67);
                        }
                    }

                    @Override // com.kwad.components.ad.reward.k.p.a
                    public final void hu() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.ry.nM.a(this.ry.getContext(), 1, 1);
                        }
                    }

                    @Override // com.kwad.components.ad.reward.k.p.a
                    public final void hv() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.ry.nM.a(this.ry.getContext(), 1, 2);
                        }
                    }
                });
                this.rv.e((ViewGroup) getRootView());
                this.rv.b(u.a(this.mAdTemplate, this.mApkDownloadHelper));
            }
            this.rv.show();
            viewGroup = this.rv.fR();
            showActionBarResult = RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT;
        } else if (!com.kwad.sdk.core.response.a.a.bF(this.mAdInfo) || (viewGroup2 = this.rt) == null) {
            if (com.kwad.sdk.core.response.a.a.aK(this.mAdTemplate)) {
                ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0911c7);
                this.ru = viewGroup3;
                if (viewGroup3 != null) {
                    Resources resources = viewGroup3.getResources();
                    b(this.ru, (int) (resources.getDimension(R.dimen.obfuscated_res_0x7f07037e) + resources.getDimension(R.dimen.obfuscated_res_0x7f070381)));
                    viewGroup = this.ru;
                    showActionBarResult = RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_LIVE_SUBSCRIBE;
                }
            }
            if (!com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                e(z, aVar);
                return;
            } else if (this.nM.mScreenOrientation == 1) {
                b(z, aVar);
                return;
            } else if (l(this.mAdInfo)) {
                d(z, aVar);
                return;
            } else {
                c(z, aVar);
                return;
            }
        } else {
            viewGroup2.setVisibility(0);
            viewGroup = this.rt;
            showActionBarResult = RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_JINNIU;
        }
        RewardActionBarControl.a(aVar, viewGroup, showActionBarResult);
    }

    private void aL() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (valueAnimator = this.bN) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.bN.cancel();
    }

    private void b(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, this, view2, i) == null) {
            aL();
            view2.setVisibility(0);
            Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            ValueAnimator c = n.c(view2, i, 0);
            this.bN = c;
            c.setInterpolator(create);
            this.bN.setDuration(500L);
            this.bN.addListener(new AnimatorListenerAdapter(this, view2) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View jJ;
                public final /* synthetic */ b ry;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ry = this;
                    this.jJ = view2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.jJ.setVisibility(0);
                    }
                }
            });
            this.bN.start();
        }
    }

    private void b(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65546, this, z, aVar) == null) {
            this.rn.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppLandscape.a(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b ry;

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
                    this.ry = this;
                }

                @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
                public final void R(boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                        this.ry.L(z2);
                    }
                }
            });
            if (z) {
                c(this.rn, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
            } else {
                this.rn.setVisibility(0);
            }
            RewardActionBarControl.a(aVar, this.rn, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
        }
    }

    private void bQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            AdTemplate adTemplate = this.nM.mAdTemplate;
            this.mAdTemplate = adTemplate;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            this.mAdInfo = bQ;
            if (com.kwad.sdk.core.response.a.a.bF(bQ)) {
                this.rt = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0911b3);
            }
            this.pM.T(this.mAdTemplate);
            k kVar = this.nM;
            this.mApkDownloadHelper = kVar.mApkDownloadHelper;
            RewardActionBarControl rewardActionBarControl = kVar.ml;
            this.ml = rewardActionBarControl;
            rewardActionBarControl.a(this.rw);
            this.nM.a(this.f1086rx);
        }
    }

    @Deprecated
    private void c(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, this, view2, i) == null) {
            aL();
            view2.setVisibility(0);
            ValueAnimator b = n.b(view2, 0, i);
            this.bN = b;
            b.setInterpolator(new DecelerateInterpolator(2.0f));
            this.bN.setDuration(500L);
            this.bN.addListener(new AnimatorListenerAdapter(this, view2) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View jJ;
                public final /* synthetic */ b ry;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ry = this;
                    this.jJ = view2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.jJ.setVisibility(0);
                    }
                }
            });
            this.bN.start();
        }
    }

    private void c(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65551, this, z, aVar) == null) {
            this.ro.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortrait.a(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b ry;

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
                    this.ry = this;
                }

                @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
                public final void R(boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                        this.ry.L(z2);
                    }
                }
            });
            if (z) {
                c(this.ro, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
            } else {
                this.ro.setVisibility(0);
            }
            RewardActionBarControl.a(aVar, this.ro, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
        }
    }

    private void d(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65553, this, view2, i) == null) {
            aL();
            view2.setVisibility(0);
            ValueAnimator b = n.b(view2, i, 0);
            this.bN = b;
            b.setInterpolator(new DecelerateInterpolator(2.0f));
            this.bN.setDuration(300L);
            this.bN.addListener(new AnimatorListenerAdapter(this, view2) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View jJ;
                public final /* synthetic */ b ry;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ry = this;
                    this.jJ = view2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.jJ.setVisibility(8);
                    }
                }
            });
            this.bN.start();
        }
    }

    private void d(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65555, this, z, aVar) == null) {
            this.rp.a(this.nM, this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortraitForLive.a(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b ry;

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
                    this.ry = this;
                }

                @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortraitForLive.a
                public final void R(boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                        this.ry.L(z2);
                    }
                }
            });
            if (z) {
                c(this.rp, com.kwad.sdk.b.kwai.a.a(getContext(), 68.0f));
            } else {
                this.rp.setVisibility(0);
            }
            RewardActionBarControl.a(aVar, this.rp, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
        }
    }

    private void e(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65558, this, z, aVar) == null) {
            this.rq.a(this.mAdTemplate, new ActionBarH5.a(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b ry;

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
                    this.ry = this;
                }

                @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
                public final void R(boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                        this.ry.L(z2);
                    }
                }
            });
            if (z) {
                c(this.rq, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
            } else {
                this.rq.setVisibility(0);
            }
            RewardActionBarControl.a(aVar, this.rq, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
        }
    }

    private void hq() {
        View view2;
        Context context;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            if (l(this.mAdInfo)) {
                view2 = this.rp;
                context = getContext();
                f = 68.0f;
            } else {
                view2 = this.ro;
                context = getContext();
                f = 90.0f;
            }
            c(view2, com.kwad.sdk.b.kwai.a.a(context, f));
        }
    }

    private void hr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            (l(this.mAdInfo) ? this.rp : this.ro).setVisibility(8);
        }
    }

    private boolean l(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, this, adInfo)) == null) ? com.kwad.sdk.core.response.a.a.bK(adInfo) && this.nM.mz : invokeL.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            if (k.c(this.nM)) {
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
            this.pM = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091081);
            this.rn = (ActionBarAppLandscape) findViewById(R.id.obfuscated_res_0x7f091256);
            this.ro = (ActionBarAppPortrait) findViewById(R.id.obfuscated_res_0x7f091257);
            this.rp = (ActionBarAppPortraitForLive) findViewById(R.id.obfuscated_res_0x7f091258);
            this.rq = (ActionBarH5) findViewById(R.id.obfuscated_res_0x7f091259);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onUnbind();
            RewardActionBarControl rewardActionBarControl = this.ml;
            if (rewardActionBarControl != null) {
                rewardActionBarControl.a((RewardActionBarControl.b) null);
            }
            com.kwad.components.core.webview.b.c.a.pR().b(this);
            this.nM.b(this.f1086rx);
            aL();
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
