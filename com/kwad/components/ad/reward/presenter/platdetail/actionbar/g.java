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
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.b.j;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ae;
/* loaded from: classes5.dex */
public final class g extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdWebView b;
    public KsLogoView c;
    public o.a d;
    public com.kwad.components.core.c.a.b e;
    public RewardActionBarControl f;
    public com.kwad.components.core.webview.a g;
    public com.kwad.sdk.core.webview.b h;
    public int i;
    public x j;
    public boolean k;
    public RewardActionBarControl.g l;
    public com.kwad.components.ad.reward.c.f m;
    public com.kwad.sdk.core.webview.a.kwai.a n;
    public long o;
    public o.b p;
    public n.b q;
    public u.b r;
    public ValueAnimator s;
    public ValueAnimator t;

    public g() {
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
        this.i = -1;
        this.l = new RewardActionBarControl.g(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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

            @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.g
            public final boolean a(a aVar) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, aVar)) == null) {
                    g gVar = this.a;
                    gVar.k = gVar.a(aVar);
                    return this.a.k;
                }
                return invokeL.booleanValue;
            }
        };
        this.m = new com.kwad.components.ad.reward.c.f(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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
                    this.a.e();
                }
            }
        };
        this.n = new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.g.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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
                    ((com.kwad.components.ad.reward.presenter.a) this.a).a.b.a();
                }
            }
        };
        this.p = new o.b(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.g.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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

            @Override // com.kwad.components.core.webview.jshandler.o.b
            public final void a(o.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.a.d = aVar;
                    this.a.b.setTranslationY(aVar.a + aVar.d);
                }
            }
        };
        this.q = new n.b(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.g.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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

            @Override // com.kwad.components.core.webview.jshandler.n.b
            public final void a(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    this.a.k = false;
                    this.a.m();
                }
            }
        };
        this.r = new u.b(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.g.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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

            @Override // com.kwad.components.core.webview.jshandler.u.b
            public final void a(u.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.a.i = aVar.a;
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.a.o;
                    com.kwad.sdk.core.d.b.c("RewardActionBarWeb", "load time:" + elapsedRealtime + ", pageStatus: " + this.a.i);
                    if (this.a.i == 1) {
                        com.kwad.components.core.i.a.a().b(((com.kwad.components.ad.reward.presenter.a) this.a).a.g, elapsedRealtime);
                    }
                    if (((com.kwad.components.ad.reward.presenter.a) this.a).a.f()) {
                        return;
                    }
                    this.a.f.a();
                }
            }
        };
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, aVar) == null) {
            aVar.a(new com.kwad.components.core.webview.jshandler.f(this.h, this.e, this.n));
            aVar.a(new j());
            aVar.a(new com.kwad.components.core.webview.jshandler.d(this.h, this.e, this.n));
            aVar.a(new i(this.h));
            aVar.a(new l(this.h));
            aVar.a(new h(this.h));
            aVar.a(new o(this.h, this.p));
            aVar.a(new u(this.r, com.kwad.sdk.core.response.a.b.a(((com.kwad.components.ad.reward.presenter.a) this).a.g)));
            x xVar = new x();
            this.j = xVar;
            aVar.a(xVar);
            aVar.a(new z(this.h, this.e));
            aVar.a(new n(this.q));
            aVar.a(new p(this.h));
            aVar.a(new com.kwad.components.ad.reward.d.b(u(), ((com.kwad.components.ad.reward.presenter.a) this).a.g, PlayableSource.ACTIONBAR_CLICK));
        }
    }

    private void a(AdTemplate adTemplate) {
        KsLogoView ksLogoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, adTemplate) == null) || !com.kwad.sdk.core.response.a.a.aV(com.kwad.sdk.core.response.a.d.i(adTemplate)) || ae.a() || (ksLogoView = this.c) == null) {
            return;
        }
        ksLogoView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, aVar)) == null) {
            KsAdWebView ksAdWebView = this.b;
            if (ksAdWebView == null) {
                return false;
            }
            if (ksAdWebView.getVisibility() == 0) {
                return true;
            }
            if (this.i == 1) {
                b(aVar);
                return true;
            }
            w();
            return false;
        }
        return invokeL.booleanValue;
    }

    private void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, aVar) == null) {
            if (this.d == null) {
                l();
                return;
            }
            a(((com.kwad.components.ad.reward.presenter.a) this).a.g);
            v();
            this.b.setVisibility(0);
            KsAdWebView ksAdWebView = this.b;
            o.a aVar2 = this.d;
            ValueAnimator b = com.kwad.components.core.l.n.b(ksAdWebView, aVar2.a + aVar2.d, 0);
            this.s = b;
            b.setInterpolator(new DecelerateInterpolator(2.0f));
            this.s.setDuration(500L);
            this.s.addListener(new AnimatorListenerAdapter(this, aVar) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.g.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;
                public final /* synthetic */ g b;

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
                    this.b = this;
                    this.a = aVar;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.b.j != null) {
                            this.b.j.d();
                        }
                        a aVar3 = this.a;
                        if (aVar3 != null) {
                            aVar3.a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, this.b.b);
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.b.j != null) {
                            this.b.j.c();
                        }
                    }
                }
            });
            this.s.start();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && com.kwad.sdk.core.response.a.b.c(((com.kwad.components.ad.reward.presenter.a) this).a.g)) {
            com.kwad.components.ad.reward.l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            this.e = lVar.k;
            RewardActionBarControl rewardActionBarControl = lVar.m;
            this.f = rewardActionBarControl;
            rewardActionBarControl.a(this.l);
            g();
            h();
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.i = -1;
            this.b.setVisibility(8);
            k();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.h = bVar;
            bVar.a(((com.kwad.components.ad.reward.presenter.a) this).a.g);
            com.kwad.sdk.core.webview.b bVar2 = this.h;
            com.kwad.components.ad.reward.l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            bVar2.a = lVar.f;
            AdBaseFrameLayout adBaseFrameLayout = lVar.h;
            bVar2.b = adBaseFrameLayout;
            bVar2.d = adBaseFrameLayout;
            bVar2.e = this.b;
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.i = -1;
            i();
            this.b.setBackgroundColor(0);
            this.b.getBackground().setAlpha(0);
            this.b.setVisibility(4);
            this.o = SystemClock.elapsedRealtime();
            String a = com.kwad.sdk.core.response.a.b.a(((com.kwad.components.ad.reward.presenter.a) this).a.g);
            com.kwad.sdk.core.d.b.a("RewardActionBarWeb", "startPreloadWebView url: " + a);
            this.b.loadUrl(a);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            k();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.b);
            this.g = aVar;
            a(aVar);
            this.b.addJavascriptInterface(this.g, "KwaiAd");
        }
    }

    private void k() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || (aVar = this.g) == null) {
            return;
        }
        aVar.a();
        this.g = null;
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            a(((com.kwad.components.ad.reward.presenter.a) this).a.g);
            x xVar = this.j;
            if (xVar != null) {
                xVar.c();
            }
            this.b.setVisibility(0);
            x xVar2 = this.j;
            if (xVar2 != null) {
                xVar2.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65563, this) == null) && this.b.getVisibility() == 0) {
            if (this.d == null) {
                n();
                return;
            }
            v();
            KsAdWebView ksAdWebView = this.b;
            o.a aVar = this.d;
            ValueAnimator b = com.kwad.components.core.l.n.b(ksAdWebView, 0, aVar.a + aVar.d);
            this.t = b;
            b.setInterpolator(new DecelerateInterpolator(2.0f));
            this.t.setDuration(300L);
            this.t.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.g.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g a;

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

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.a.b.setVisibility(4);
                        if (this.a.j != null) {
                            this.a.j.f();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.a.j != null) {
                            this.a.j.e();
                        }
                    }
                }
            });
            this.t.start();
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65564, this) == null) && this.b.getVisibility() == 0) {
            x xVar = this.j;
            if (xVar != null) {
                xVar.e();
            }
            this.b.setVisibility(4);
            x xVar2 = this.j;
            if (xVar2 != null) {
                xVar2.f();
            }
        }
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            ValueAnimator valueAnimator = this.s;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.s.cancel();
            }
            ValueAnimator valueAnimator2 = this.t;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllListeners();
                this.t.cancel();
            }
        }
    }

    private void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            int i = this.i;
            String str = i == -1 ? "timeout" : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
            com.kwad.sdk.core.d.b.d("RewardActionBarWeb", "show webCard fail, reason: " + str);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (com.kwad.components.ad.reward.l.c(((com.kwad.components.ad.reward.presenter.a) this).a)) {
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
            this.b = (KsAdWebView) b(R.id.obfuscated_res_0x7f0910b4);
            this.c = (KsLogoView) b(R.id.obfuscated_res_0x7f090fe6);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            RewardActionBarControl rewardActionBarControl = this.f;
            if (rewardActionBarControl != null) {
                rewardActionBarControl.a((RewardActionBarControl.g) null);
            }
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this.m);
            v();
            e();
        }
    }
}
