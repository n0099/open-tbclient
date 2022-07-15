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
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.f;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class o extends a implements f.a, c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View b;
    public KsLogoView c;
    public ImageView d;
    public DetailVideoView e;
    public int f;
    public View g;
    public FrameLayout h;
    @Nullable
    public com.kwad.components.ad.reward.i i;
    public Animator j;
    public Animator k;
    public Animator l;
    public AdTemplate m;
    public AdTemplate n;
    public List<com.kwad.components.ad.reward.b.b> o;
    public float p;
    public float q;
    public float r;
    public com.kwad.components.core.video.g s;
    public com.kwad.sdk.core.webview.a.kwai.a t;

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
        this.p = 1.2254902f;
        this.q = 0.80472106f;
        this.r = 0.0f;
        this.s = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.presenter.o.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;
            public boolean b;
            public long c;
            public long d;
            public boolean e;
            public boolean f;

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
                this.b = false;
                this.c = -1L;
                this.d = -1L;
                this.e = false;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || this.a.n == null || this.f) {
                    return;
                }
                if (this.c <= 0) {
                    this.c = com.kwad.sdk.core.response.a.b.f(this.a.n);
                    this.d = com.kwad.sdk.core.response.a.b.e(this.a.n) + this.c;
                }
                long j3 = this.c;
                if (j3 > 0 && !this.b && j2 > j3) {
                    o oVar = this.a;
                    this.a.c(oVar.b(oVar.i()));
                    this.f = !this.a.e();
                    com.kwad.sdk.core.d.b.a("RewardPreEndCardPresenter", "showError: " + this.f);
                    if (this.f) {
                        return;
                    }
                    this.b = true;
                }
                long j4 = this.d;
                if (j4 <= 0 || this.e || j2 <= j4) {
                    return;
                }
                this.a.g();
                this.e = true;
            }
        };
        this.t = new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.reward.presenter.o.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

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

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    if (aVar == null || com.kwad.sdk.core.response.a.d.a(this.a.m, aVar.f, aVar.g)) {
                        ((a) this.a).a.b.a();
                        return;
                    }
                    com.kwad.components.ad.reward.b.b a = com.kwad.components.ad.reward.l.a(this.a.o, aVar.f);
                    if (a != null) {
                        ((a) this.a).a.a(a);
                    }
                }
            }
        };
    }

    private int a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65537, this, f)) == null) ? (int) (com.kwad.sdk.b.kwai.a.c(s()) - f) : invokeF.intValue;
    }

    private Animator a(boolean z, float f, int i, boolean z2) {
        InterceptResult invokeCommon;
        ValueAnimator ofFloat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f), Integer.valueOf(i), Boolean.valueOf(z2)})) == null) {
            com.kwad.sdk.core.d.b.a("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f + ", videoTargetHeight: " + i);
            if (z) {
                ofFloat = ObjectAnimator.ofFloat(this.b, "translationY", f);
            } else {
                int height = this.b.getHeight();
                ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                float f2 = height;
                ofFloat = ValueAnimator.ofFloat(f2, f2 + Math.abs(f));
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, layoutParams) { // from class: com.kwad.components.ad.reward.presenter.o.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ViewGroup.LayoutParams a;
                    public final /* synthetic */ o b;

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
                        this.b = this;
                        this.a = layoutParams;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            this.a.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            this.b.b.setLayoutParams(this.a);
                        }
                    }
                });
            }
            ObjectAnimator ofFloat2 = z2 ? ObjectAnimator.ofFloat(this.c, "alpha", 0.0f, 255.0f) : null;
            ValueAnimator a = this.e.a(this.m, i, new ValueAnimator.AnimatorUpdateListener(this, this.d.getLayoutParams()) { // from class: com.kwad.components.ad.reward.presenter.o.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ViewGroup.LayoutParams a;
                public final /* synthetic */ o b;

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
                    this.b = this;
                    this.a = r7;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ViewGroup.LayoutParams layoutParams2 = this.a;
                        if (layoutParams2 != null) {
                            layoutParams2.height = intValue;
                            this.b.d.setLayoutParams(this.a);
                        }
                    }
                }
            });
            Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(500L);
            animatorSet.setInterpolator(create);
            if (ofFloat2 != null) {
                animatorSet.playTogether(ofFloat, ofFloat2, a);
            } else {
                animatorSet.playTogether(ofFloat, a);
            }
            return animatorSet;
        }
        return (Animator) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65543, this, f)) == null) ? (int) (f + u().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d2) + u().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d3)) : invokeF.intValue;
    }

    private void b(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, list) == null) {
            com.kwad.components.ad.reward.i iVar = new com.kwad.components.ad.reward.i(list, ((a) this).a.e, this);
            this.i = iVar;
            ((a) this).a.q = iVar;
            iVar.a(com.kwad.sdk.core.response.a.b.i(this.m));
            this.i.a(this.t);
            com.kwad.components.ad.reward.i iVar2 = this.i;
            FrameLayout frameLayout = this.h;
            com.kwad.components.ad.reward.l lVar = ((a) this).a;
            iVar2.a(frameLayout, lVar.h, this.m, lVar.k, lVar.f);
            this.i.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i) == null) {
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.height = i;
                layoutParams2.bottomMargin = -i;
                return;
            }
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
            layoutParams3.height = i;
            layoutParams3.bottomMargin = -i;
            this.b.setLayoutParams(layoutParams3);
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            List<com.kwad.sdk.core.request.model.f> a = com.kwad.sdk.core.c.a.a(15);
            if (a.size() == 0) {
                return true;
            }
            long j = -1;
            int i = 0;
            for (com.kwad.sdk.core.request.model.f fVar : a) {
                i += fVar.c;
                long j2 = fVar.d;
                if (j2 > j) {
                    j = j2;
                }
            }
            com.kwad.sdk.core.d.b.a("RewardPreEndCardPresenter", "onBind localCountCheck: allCount: " + i + ", lastShowTime: " + j);
            if (i > com.kwad.sdk.core.c.a.c()) {
                return false;
            }
            return j + (com.kwad.sdk.core.c.a.d() * 1000) <= System.currentTimeMillis();
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            com.kwad.components.ad.reward.i iVar = this.i;
            if (iVar != null ? iVar.e() : false) {
                float i = i();
                int a = a(i);
                float f = -b(i);
                this.r = f;
                Animator a2 = a(true, f, a, true);
                this.j = a2;
                a2.start();
                Animator h = h();
                this.l = h;
                h.start();
                ((a) this).a.A = true;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            Animator a = a(false, k() - i(), a(k()), false);
            this.k = a;
            a.start();
            com.kwad.sdk.core.c.a.a();
            com.kwad.sdk.core.c.a.a(this.n);
        }
    }

    private Animator h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.g, "alpha", 255.0f, 0.0f);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
            ofFloat.setDuration(200L);
            return ofFloat;
        }
        return (Animator) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) ? com.kwad.sdk.b.kwai.a.b(s()) / this.p : invokeV.floatValue;
    }

    private float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) ? com.kwad.sdk.b.kwai.a.b(s()) / this.q : invokeV.floatValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((a) this).a.j.a(this.s);
            this.m = ((a) this).a.g;
            this.f = com.kwad.sdk.b.kwai.a.c(this.e);
            com.kwad.sdk.b.kwai.a.c(this.e, 49);
            this.c.a(this.m);
            boolean d = d();
            com.kwad.sdk.core.d.b.a("RewardPreEndCardPresenter", "onBind localCheckResult: " + d);
            SceneImpl sceneImpl = this.m.mAdScene;
            if (sceneImpl == null || !d) {
                return;
            }
            com.kwad.components.ad.reward.f.b(sceneImpl, this);
        }
    }

    @Override // com.kwad.components.ad.reward.f.a
    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.c.b
    public final void a(AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, adTemplate, j) == null) {
            com.kwad.components.ad.reward.b.b bVar = new com.kwad.components.ad.reward.b.b(adTemplate, com.kwad.components.ad.reward.b.d.b);
            com.kwad.components.ad.reward.l lVar = ((a) this).a;
            if (lVar != null) {
                lVar.b(bVar);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.f.a
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "onError : msg " + str);
        }
    }

    @Override // com.kwad.components.ad.reward.f.a
    public final void a(@Nullable List<com.kwad.components.ad.reward.b.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            com.kwad.sdk.core.d.b.a("RewardPreEndCardPresenter", "onInnerAdLoad: " + list);
            if (list == null || list.size() == 0) {
                return;
            }
            AdTemplate b = list.get(0).b();
            this.n = b;
            if (com.kwad.sdk.core.response.a.b.j(b)) {
                this.o = list;
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.m);
                arrayList.addAll(com.kwad.components.ad.reward.b.b.a(list));
                b(arrayList);
                com.kwad.sdk.core.c.a.a(com.kwad.sdk.core.response.a.b.g(this.n), com.kwad.sdk.core.response.a.b.h(this.n));
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.i_();
            this.b = b(R.id.obfuscated_res_0x7f091094);
            this.e = (DetailVideoView) b(R.id.obfuscated_res_0x7f0911da);
            this.c = (KsLogoView) b(R.id.obfuscated_res_0x7f0911a8);
            this.d = (ImageView) b(R.id.obfuscated_res_0x7f091005);
            this.g = b(R.id.obfuscated_res_0x7f0910b4);
            this.h = (FrameLayout) b(R.id.obfuscated_res_0x7f091095);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.k_();
            com.kwad.components.ad.reward.l lVar = ((a) this).a;
            lVar.A = false;
            lVar.j.b(this.s);
            com.kwad.components.ad.reward.i iVar = this.i;
            if (iVar != null) {
                iVar.i();
            }
            Animator animator = this.l;
            if (animator != null) {
                animator.cancel();
            }
            DetailVideoView detailVideoView = this.e;
            if (detailVideoView != null) {
                com.kwad.sdk.b.kwai.a.c(detailVideoView, this.f);
            }
            Animator animator2 = this.j;
            if (animator2 != null) {
                animator2.cancel();
            }
            this.l = null;
            this.j = null;
        }
    }
}
