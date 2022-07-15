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
import com.kwad.components.ad.reward.i.r;
import com.kwad.components.ad.reward.i.w;
import com.kwad.components.ad.reward.l;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortraitForLive;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarH5;
import com.kwad.components.core.l.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
/* loaded from: classes5.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsLogoView b;
    public ActionBarAppLandscape c;
    public ActionBarAppPortrait d;
    @Nullable
    public ActionBarAppPortraitForLive e;
    public ActionBarH5 f;
    public AdTemplate g;
    public AdInfo h;
    public com.kwad.components.core.c.a.b i;
    public RewardActionBarControl j;
    public boolean k;
    public boolean l;
    @Nullable
    public ValueAnimator m;
    @Nullable
    public ViewGroup n;
    @Nullable
    public ViewGroup o;
    public r p;
    public RewardActionBarControl.c q;
    public com.kwad.components.ad.reward.c.f r;

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
        this.k = false;
        this.q = new RewardActionBarControl.c(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
            public final void a(boolean z, a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, aVar) == null) {
                    this.a.l = true;
                    this.a.a(z, aVar);
                }
            }
        };
        this.r = new com.kwad.components.ad.reward.c.f(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.c.f
            public final void d_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.l = false;
                    this.a.b(false);
                }
            }
        };
    }

    private void a(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, view2, i) == null) {
            h();
            view2.setVisibility(0);
            Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            ValueAnimator b = n.b(view2, i, 0);
            this.m = b;
            b.setInterpolator(create);
            this.m.setDuration(500L);
            this.m.addListener(new AnimatorListenerAdapter(this, view2) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View a;
                public final /* synthetic */ b b;

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
                    this.b = this;
                    this.a = view2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.a.setVisibility(0);
                    }
                }
            });
            this.m.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, a aVar) {
        ViewGroup viewGroup;
        RewardActionBarControl.ShowActionBarResult showActionBarResult;
        ViewGroup viewGroup2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TRACKBALL, this, z, aVar) == null) || this.k) {
            return;
        }
        this.k = true;
        this.b.setVisibility(a(this.h) ? 8 : 0);
        if (com.kwad.sdk.core.response.a.a.ar(this.h) && com.kwad.sdk.core.response.a.d.w(this.g) && ae.e(u())) {
            if (this.p == null) {
                r rVar = new r();
                this.p = rVar;
                rVar.a(new r.a(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b a;

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
                        this.a = this;
                    }

                    @Override // com.kwad.components.ad.reward.i.r.a
                    public final void b() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.components.ad.reward.b.a().a(PlayableSource.ACTIONBAR_CLICK, new com.kwad.components.ad.reward.d.a(this.a.u()));
                            com.kwad.sdk.core.report.a.k(((com.kwad.components.ad.reward.presenter.a) this.a).a.g, 67);
                        }
                    }

                    @Override // com.kwad.components.ad.reward.i.r.a
                    public final void c() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            ((com.kwad.components.ad.reward.presenter.a) this.a).a.a(this.a.u(), 1, 1);
                        }
                    }

                    @Override // com.kwad.components.ad.reward.i.r.a
                    public final void d() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            ((com.kwad.components.ad.reward.presenter.a) this.a).a.a(this.a.u(), 1, 2);
                        }
                    }

                    @Override // com.kwad.components.ad.reward.i.r.a
                    public final void l_() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        }
                    }
                });
                this.p.a((ViewGroup) q());
                this.p.b(w.a(this.g, this.i));
            }
            this.p.e();
            viewGroup = this.p.a();
            showActionBarResult = RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT;
        } else if (!com.kwad.sdk.core.response.a.a.aV(this.h) || (viewGroup2 = this.n) == null) {
            if (com.kwad.sdk.core.response.a.a.b(this.g)) {
                ViewGroup viewGroup3 = (ViewGroup) b(R.id.obfuscated_res_0x7f091145);
                this.o = viewGroup3;
                if (viewGroup3 != null) {
                    Resources resources = viewGroup3.getResources();
                    a(this.o, (int) (resources.getDimension(R.dimen.obfuscated_res_0x7f070380) + resources.getDimension(R.dimen.obfuscated_res_0x7f070383)));
                    viewGroup = this.o;
                    showActionBarResult = RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_LIVE_SUBSCRIBE;
                }
            }
            if (!com.kwad.sdk.core.response.a.a.I(this.h)) {
                e(z, aVar);
                return;
            } else if (((com.kwad.components.ad.reward.presenter.a) this).a.f == 1) {
                b(z, aVar);
                return;
            } else if (a(this.h)) {
                d(z, aVar);
                return;
            } else {
                c(z, aVar);
                return;
            }
        } else {
            viewGroup2.setVisibility(0);
            viewGroup = this.n;
            showActionBarResult = RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_JINNIU;
        }
        RewardActionBarControl.a(aVar, viewGroup, showActionBarResult);
    }

    private boolean a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, this, adInfo)) == null) ? com.kwad.sdk.core.response.a.a.bb(adInfo) && ((com.kwad.components.ad.reward.presenter.a) this).a.t : invokeL.booleanValue;
    }

    @Deprecated
    private void b(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, this, view2, i) == null) {
            h();
            view2.setVisibility(0);
            ValueAnimator a = n.a(view2, 0, i);
            this.m = a;
            a.setInterpolator(new DecelerateInterpolator(2.0f));
            this.m.setDuration(500L);
            this.m.addListener(new AnimatorListenerAdapter(this, view2) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View a;
                public final /* synthetic */ b b;

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
                    this.b = this;
                    this.a = view2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.a.setVisibility(0);
                    }
                }
            });
            this.m.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65546, this, z) == null) && this.k) {
            this.k = false;
            this.b.setVisibility(8);
            ViewGroup viewGroup = this.n;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            if (!com.kwad.sdk.core.response.a.a.I(this.h)) {
                if (z) {
                    c(this.f, com.kwad.sdk.b.kwai.a.a(u(), 90.0f));
                } else {
                    this.f.setVisibility(8);
                }
            } else if (((com.kwad.components.ad.reward.presenter.a) this).a.f == 1) {
                if (z) {
                    e();
                } else {
                    g();
                }
            } else if (z) {
                c(this.d, com.kwad.sdk.b.kwai.a.a(u(), 90.0f));
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    private void b(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65547, this, z, aVar) == null) {
            this.c.a(this.g, this.i, new ActionBarAppLandscape.a(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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
                    this.a = this;
                }

                @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
                public final void a(boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                        this.a.a(z2);
                    }
                }
            });
            if (z) {
                b(this.c, com.kwad.sdk.b.kwai.a.a(u(), 90.0f));
            } else {
                this.c.setVisibility(0);
            }
            RewardActionBarControl.a(aVar, this.c, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
        }
    }

    private void c(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, this, view2, i) == null) {
            h();
            view2.setVisibility(0);
            ValueAnimator a = n.a(view2, i, 0);
            this.m = a;
            a.setInterpolator(new DecelerateInterpolator(2.0f));
            this.m.setDuration(300L);
            this.m.addListener(new AnimatorListenerAdapter(this, view2) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View a;
                public final /* synthetic */ b b;

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
                    this.b = this;
                    this.a = view2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.a.setVisibility(8);
                    }
                }
            });
            this.m.start();
        }
    }

    private void c(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65551, this, z, aVar) == null) {
            this.d.a(this.g, this.i, new ActionBarAppPortrait.a(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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
                    this.a = this;
                }

                @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
                public final void a(boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                        this.a.a(z2);
                    }
                }
            });
            if (z) {
                b(this.d, com.kwad.sdk.b.kwai.a.a(u(), 90.0f));
            } else {
                this.d.setVisibility(0);
            }
            RewardActionBarControl.a(aVar, this.d, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            AdTemplate adTemplate = ((com.kwad.components.ad.reward.presenter.a) this).a.g;
            this.g = adTemplate;
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            this.h = i;
            if (com.kwad.sdk.core.response.a.a.aV(i)) {
                this.n = (ViewGroup) b(R.id.obfuscated_res_0x7f091131);
            }
            this.b.a(this.g);
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            this.i = lVar.k;
            RewardActionBarControl rewardActionBarControl = lVar.m;
            this.j = rewardActionBarControl;
            rewardActionBarControl.a(this.q);
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(this.r);
        }
    }

    private void d(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65555, this, z, aVar) == null) {
            this.e.a(((com.kwad.components.ad.reward.presenter.a) this).a, this.g, this.i, new ActionBarAppPortraitForLive.a(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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
                    this.a = this;
                }

                @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortraitForLive.a
                public final void a(boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                        this.a.a(z2);
                    }
                }
            });
            if (z) {
                b(this.e, com.kwad.sdk.b.kwai.a.a(u(), 68.0f));
            } else {
                this.e.setVisibility(0);
            }
            RewardActionBarControl.a(aVar, this.e, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
        }
    }

    private void e() {
        View view2;
        Context u;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            if (a(this.h)) {
                view2 = this.e;
                u = u();
                f = 68.0f;
            } else {
                view2 = this.d;
                u = u();
                f = 90.0f;
            }
            b(view2, com.kwad.sdk.b.kwai.a.a(u, f));
        }
    }

    private void e(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65559, this, z, aVar) == null) {
            this.f.a(this.g, new ActionBarH5.a(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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
                    this.a = this;
                }

                @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
                public final void a(boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                        this.a.a(z2);
                    }
                }
            });
            if (z) {
                b(this.f, com.kwad.sdk.b.kwai.a.a(u(), 90.0f));
            } else {
                this.f.setVisibility(0);
            }
            RewardActionBarControl.a(aVar, this.f, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            (a(this.h) ? this.e : this.d).setVisibility(8);
        }
    }

    private void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || (valueAnimator = this.m) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.m.cancel();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (l.c(((com.kwad.components.ad.reward.presenter.a) this).a)) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.a(this);
            } else {
                d();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.c.d
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && "ksad-video-bottom-card-v2".equals(str)) {
            d();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i_();
            this.b = (KsLogoView) b(R.id.obfuscated_res_0x7f090fe6);
            this.c = (ActionBarAppLandscape) b(R.id.obfuscated_res_0x7f0911d6);
            this.d = (ActionBarAppPortrait) b(R.id.obfuscated_res_0x7f0911d7);
            this.e = (ActionBarAppPortraitForLive) b(R.id.obfuscated_res_0x7f0911d8);
            this.f = (ActionBarH5) b(R.id.obfuscated_res_0x7f0911d9);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            RewardActionBarControl rewardActionBarControl = this.j;
            if (rewardActionBarControl != null) {
                rewardActionBarControl.a((RewardActionBarControl.c) null);
            }
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this.r);
            h();
        }
    }
}
