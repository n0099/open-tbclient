package com.kwad.components.ad.interstitial.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
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
import com.kwad.sdk.utils.ag;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class c extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.widget.kwai.b aM;
    public final com.kwad.sdk.core.h.b bX;
    public KsInterstitialAd.AdInteractionListener fo;
    public boolean ia;

    /* renamed from: if  reason: not valid java name */
    public TransViewPager f8if;
    public a ig;
    public ViewPagerIndicator ih;
    public SlideTipsView ij;
    public SlideTipsView ik;
    public ValueAnimator il;
    public boolean im;

    /* renamed from: io  reason: collision with root package name */
    public boolean f1080io;
    public final ViewPager.OnPageChangeListener iq;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public final List mAdTemplateList;
    public final View mRootView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
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
    public c(Context context, AttributeSet attributeSet) {
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
        this.mAdTemplateList = new ArrayList();
        this.bX = new com.kwad.sdk.core.h.c(this) { // from class: com.kwad.components.ad.interstitial.widget.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c ir;

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
                this.ir = this;
            }

            @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
            public final void aR() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.aR();
                    if (Build.VERSION.SDK_INT >= 19 && this.ir.im) {
                        if (this.ir.ih != null) {
                            this.ir.ih.ek();
                        }
                        if (this.ir.il != null) {
                            this.ir.il.resume();
                        }
                        this.ir.im = false;
                    }
                }
            }

            @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
            public final void aS() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.aS();
                    if (Build.VERSION.SDK_INT >= 19 && !this.ir.im) {
                        if (this.ir.ih != null) {
                            this.ir.ih.ej();
                        }
                        if (this.ir.il != null) {
                            this.ir.il.pause();
                        }
                        this.ir.im = true;
                    }
                }
            }
        };
        this.iq = new ViewPager.SimpleOnPageChangeListener(this) { // from class: com.kwad.components.ad.interstitial.widget.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c ir;
            public int is;

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
                this.ir = this;
                this.is = 0;
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i3, float f, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), Float.valueOf(f), Integer.valueOf(i4)}) == null) || f == 0.0f) {
                    return;
                }
                if (this.ir.ij.getVisibility() == 0) {
                    this.ir.ij.clearAnimation();
                    this.ir.ij.setVisibility(8);
                }
                if (this.ir.ik.getVisibility() == 0) {
                    this.ir.ik.clearAnimation();
                    this.ir.ik.setVisibility(8);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i3) {
                e F;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3) == null) {
                    e F2 = this.ir.f8if.F(i3);
                    if (F2 != null) {
                        F2.dW();
                    }
                    if (this.is != i3 && (F = this.ir.f8if.F(this.is)) != null) {
                        F.dX();
                    }
                    this.is = i3;
                }
            }
        };
        this.mRootView = FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0433, this);
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.mAdTemplate.mAdScene == null) {
            return;
        }
        com.kwad.components.ad.interstitial.c.cd().a(16, com.kwad.components.ad.interstitial.kwai.b.cn(), this.mAdTemplate.mAdScene, new c.b(this) { // from class: com.kwad.components.ad.interstitial.widget.c.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c ir;

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
                this.ir = this;
            }

            @Override // com.kwad.components.ad.interstitial.c.b
            public final void onInterstitialAdLoad(List list) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) || list == null || list.size() <= 0) {
                    return;
                }
                this.ir.mAdTemplateList.addAll(list);
                this.ir.ig.setAdTemplateList(this.ir.mAdTemplateList);
                this.ir.ig.notifyDataSetChanged();
                this.ir.f8if.setOffscreenPageLimit(this.ir.mAdTemplateList.size() - 1);
                this.ir.f8if.addOnPageChangeListener(this.ir.iq);
                this.ir.dP();
                this.ir.ih.setViewPager(this.ir.f8if);
                this.ir.ih.setVisibility(0);
                this.ir.aM.a(this.ir.bX);
                com.kwad.components.ad.interstitial.a.a.I(this.ir.mContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.ih.setPlayProgressListener(new ViewPagerIndicator.a(this) { // from class: com.kwad.components.ad.interstitial.widget.c.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c ir;

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
                    this.ir = this;
                }

                @Override // com.kwad.components.ad.interstitial.widget.ViewPagerIndicator.a
                public final void dS() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.ir.f1080io = true;
                        if (this.ir.ia) {
                            this.ir.dR();
                        } else {
                            this.ir.dQ();
                        }
                        this.ir.f8if.setScrollable(true);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 120, 0);
            this.il = ofInt;
            ofInt.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.il.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.interstitial.widget.c.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c ir;

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
                    this.ir = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float f;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        this.ir.f8if.scrollTo(com.kwad.sdk.b.kwai.a.a(this.ir.mContext, ((Integer) valueAnimator.getAnimatedValue()).intValue()), 0);
                        this.ir.f8if.onPageScrolled(0, com.kwad.sdk.b.kwai.a.a(this.ir.mContext, f) / this.ir.getWidth(), 0);
                    }
                }
            });
            this.il.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.interstitial.widget.c.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c ir;

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
                    this.ir = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.ir.ij.setVisibility(0);
                        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.5f, 1, 0.1f, 1, 0.0f, 1, 0.0f);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                        AnimationSet animationSet = new AnimationSet(true);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(alphaAnimation);
                        animationSet.setDuration(800L);
                        animationSet.setFillAfter(true);
                        this.ir.ij.startAnimation(animationSet);
                    }
                }
            });
            this.il.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dR() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, getWidth());
            this.il = ofInt;
            ofInt.setDuration(800L);
            this.il.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.interstitial.widget.c.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c ir;

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
                    this.ir = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        this.ir.f8if.scrollTo(intValue, 0);
                        this.ir.f8if.onPageScrolled(0, intValue / this.ir.getWidth(), 0);
                    }
                }
            });
            this.il.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.interstitial.widget.c.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c ir;

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
                    this.ir = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.ir.f8if.setCurrentItem(1);
                        this.ir.ik.setVisibility(0);
                        TranslateAnimation translateAnimation = new TranslateAnimation(1, -0.5f, 1, -0.1f, 1, 0.0f, 1, 0.0f);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                        AnimationSet animationSet = new AnimationSet(true);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(alphaAnimation);
                        animationSet.setDuration(800L);
                        animationSet.setFillAfter(true);
                        this.ir.ik.startAnimation(animationSet);
                    }
                }
            });
            this.il.start();
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.f8if = (TransViewPager) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0910fa);
            this.ih = (ViewPagerIndicator) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0910fb);
            this.ij = (SlideTipsView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0910e4);
            this.ik = (SlideTipsView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0911c9);
            this.aM = new com.kwad.components.core.widget.kwai.b(this.mRootView, 100);
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void a(AdTemplate adTemplate, Dialog dialog, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, adTemplate, dialog, ksAdVideoPlayConfig, adInteractionListener) == null) {
            this.mAdTemplate = adTemplate;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            this.mAdInfo = bQ;
            this.ia = com.kwad.sdk.core.response.a.a.bu(bQ) == 1;
            this.mAdTemplateList.clear();
            this.mAdTemplateList.add(this.mAdTemplate);
            this.fo = adInteractionListener;
            a aVar = new a(adTemplate, dialog, ksAdVideoPlayConfig, adInteractionListener);
            this.ig = aVar;
            aVar.a(new a.b(this) { // from class: com.kwad.components.ad.interstitial.widget.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c ir;

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
                    this.ir = this;
                }

                @Override // com.kwad.components.ad.interstitial.widget.a.b
                public final void a(e eVar, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, eVar, i) == null) {
                        this.ir.f8if.a(i, eVar);
                    }
                }
            });
            this.ig.a(new a.InterfaceC0534a(this) { // from class: com.kwad.components.ad.interstitial.widget.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c ir;

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
                    this.ir = this;
                }

                @Override // com.kwad.components.ad.interstitial.widget.a.InterfaceC0534a
                public final void dL() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.ir.f1080io) {
                        return;
                    }
                    if (this.ir.il != null) {
                        this.ir.il.cancel();
                    }
                    this.ir.ih.setPlayProgressListener(null);
                    this.ir.ih.setVisibility(8);
                    this.ir.f8if.setScrollable(false);
                }
            });
            this.f8if.setAdapter(this.ig);
            this.ig.setAdTemplateList(this.mAdTemplateList);
            this.ig.notifyDataSetChanged();
            this.aM.qi();
            ViewPagerIndicator viewPagerIndicator = this.ih;
            if (viewPagerIndicator == null) {
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewPagerIndicator.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = com.kwad.sdk.b.kwai.a.a(this.mContext, ag.cB(this.mContext) ? 12.0f : 6.0f);
                this.ih.setLayoutParams(marginLayoutParams);
            }
            this.ih.setFirstAdShowTime(com.kwad.sdk.core.response.a.a.bv(this.mAdInfo));
            post(new Runnable(this) { // from class: com.kwad.components.ad.interstitial.widget.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c ir;

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
                    this.ir = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.ir.dO();
                    }
                }
            });
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void dM() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void dN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            this.aM.b(this.bX);
            this.aM.qj();
            this.mAdTemplateList.clear();
            com.kwad.components.ad.interstitial.c.cd().release();
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adInteractionListener) == null) {
            this.fo = adInteractionListener;
        }
    }
}
