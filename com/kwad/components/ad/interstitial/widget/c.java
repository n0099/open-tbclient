package com.kwad.components.ad.interstitial.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.interstitial.c;
import com.kwad.components.ad.interstitial.widget.ViewPagerIndicator;
import com.kwad.components.ad.interstitial.widget.a;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class c extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public AdTemplate b;
    public AdInfo c;
    public KsInterstitialAd.AdInteractionListener d;
    @NonNull
    public Context e;
    public final List<AdTemplate> f;
    public final View g;
    public TransViewPager h;
    public a i;
    public ViewPagerIndicator j;
    public SlideTipsView k;
    public SlideTipsView l;
    public boolean m;
    public boolean n;
    public ValueAnimator o;
    public boolean p;
    public boolean q;
    public final ViewPager.OnPageChangeListener r;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = new ArrayList();
        this.r = new ViewPager.SimpleOnPageChangeListener(this) { // from class: com.kwad.components.ad.interstitial.widget.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
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

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i3, float f, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), Float.valueOf(f), Integer.valueOf(i4)}) == null) || f == 0.0f) {
                    return;
                }
                if (this.a.k.getVisibility() == 0) {
                    this.a.k.clearAnimation();
                    this.a.k.setVisibility(8);
                }
                if (this.a.l.getVisibility() == 0) {
                    this.a.l.clearAnimation();
                    this.a.l.setVisibility(8);
                }
            }
        };
        this.g = FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d042e, this);
        this.e = context;
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.h = (TransViewPager) this.g.findViewById(R.id.obfuscated_res_0x7f091096);
            this.j = (ViewPagerIndicator) this.g.findViewById(R.id.obfuscated_res_0x7f091097);
            this.k = (SlideTipsView) this.g.findViewById(R.id.obfuscated_res_0x7f091080);
            this.l = (SlideTipsView) this.g.findViewById(R.id.obfuscated_res_0x7f091181);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = com.kwad.sdk.b.kwai.a.a(this.e, ae.e(this.e) ? 12.0f : 6.0f);
                this.j.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.b.mAdScene == null) {
            return;
        }
        com.kwad.components.ad.interstitial.c.a().a(16, com.kwad.components.ad.interstitial.kwai.b.f(), this.b.mAdScene, new c.b(this) { // from class: com.kwad.components.ad.interstitial.widget.c.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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

            @Override // com.kwad.components.ad.interstitial.c.b
            public final void a(@Nullable List<AdTemplate> list) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) || list == null || list.size() <= 0) {
                    return;
                }
                this.a.f.addAll(list);
                this.a.i.a(this.a.f);
                this.a.i.notifyDataSetChanged();
                this.a.h.setOffscreenPageLimit(this.a.f.size() - 1);
                this.a.h.addOnPageChangeListener(this.a.r);
                this.a.e();
                this.a.j.setViewPager(this.a.h);
                this.a.j.setVisibility(0);
                com.kwad.components.ad.interstitial.a.a.a(this.a.e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.j.setPlayProgressListener(new ViewPagerIndicator.a(this) { // from class: com.kwad.components.ad.interstitial.widget.c.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // com.kwad.components.ad.interstitial.widget.ViewPagerIndicator.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.q = true;
                        if (this.a.m) {
                            this.a.g();
                        } else {
                            this.a.f();
                        }
                        this.a.h.setScrollable(true);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 120, 0);
            this.o = ofInt;
            ofInt.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.interstitial.widget.c.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float f;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        this.a.h.scrollTo(com.kwad.sdk.b.kwai.a.a(this.a.e, ((Integer) valueAnimator.getAnimatedValue()).intValue()), 0);
                        this.a.h.onPageScrolled(0, com.kwad.sdk.b.kwai.a.a(this.a.e, f) / this.a.getWidth(), 0);
                    }
                }
            });
            this.o.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.interstitial.widget.c.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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
                        this.a.k.setVisibility(0);
                        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.5f, 1, 0.1f, 1, 0.0f, 1, 0.0f);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                        AnimationSet animationSet = new AnimationSet(true);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(alphaAnimation);
                        animationSet.setDuration(800L);
                        animationSet.setFillAfter(true);
                        this.a.k.startAnimation(animationSet);
                    }
                }
            });
            this.o.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, getWidth());
            this.o = ofInt;
            ofInt.setDuration(800L);
            this.o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.interstitial.widget.c.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        this.a.h.scrollTo(intValue, 0);
                        this.a.h.onPageScrolled(0, intValue / this.a.getWidth(), 0);
                    }
                }
            });
            this.o.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.interstitial.widget.c.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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
                        this.a.l.setVisibility(0);
                        TranslateAnimation translateAnimation = new TranslateAnimation(1, -0.5f, 1, -0.1f, 1, 0.0f, 1, 0.0f);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                        AnimationSet animationSet = new AnimationSet(true);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(alphaAnimation);
                        animationSet.setDuration(800L);
                        animationSet.setFillAfter(true);
                        this.a.l.startAnimation(animationSet);
                    }
                }
            });
            this.o.start();
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void a(@NonNull AdTemplate adTemplate, Dialog dialog, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, dialog, ksAdVideoPlayConfig, adInteractionListener) == null) {
            this.b = adTemplate;
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            this.c = i;
            this.m = com.kwad.sdk.core.response.a.a.aL(i) == 1;
            this.f.clear();
            this.f.add(this.b);
            this.d = adInteractionListener;
            this.n = ae.e(this.e);
            a aVar = new a(adTemplate, dialog, ksAdVideoPlayConfig, adInteractionListener);
            this.i = aVar;
            aVar.a(new a.b(this) { // from class: com.kwad.components.ad.interstitial.widget.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.ad.interstitial.widget.a.b
                public final void a(e eVar, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, eVar, i2) == null) {
                        this.a.h.a(i2, eVar);
                    }
                }
            });
            this.i.a(new a.InterfaceC0473a(this) { // from class: com.kwad.components.ad.interstitial.widget.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.ad.interstitial.widget.a.InterfaceC0473a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.q) {
                        return;
                    }
                    if (this.a.o != null) {
                        this.a.o.cancel();
                    }
                    this.a.j.setPlayProgressListener(null);
                    this.a.j.setVisibility(8);
                    this.a.h.setScrollable(false);
                }
            });
            this.h.setAdapter(this.i);
            this.i.a(this.f);
            this.i.notifyDataSetChanged();
            this.j.setFirstAdShowTime(com.kwad.sdk.core.response.a.a.aM(this.c));
            post(new Runnable(this) { // from class: com.kwad.components.ad.interstitial.widget.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.d();
                    }
                }
            });
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (!this.p || ae.e(this.e) == this.n || (gVar = this.a) == null) {
                return;
            }
            gVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            this.f.clear();
            com.kwad.components.ad.interstitial.c.a().b();
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            this.p = i == 0;
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adInteractionListener) == null) {
            this.d = adInteractionListener;
        }
    }
}
