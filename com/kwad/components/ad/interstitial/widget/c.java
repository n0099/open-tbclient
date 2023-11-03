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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tieba.R;
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
/* loaded from: classes10.dex */
public final class c extends b {
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
    public boolean io;
    public final ViewPager.OnPageChangeListener iq;
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;
    public final List<AdTemplate> mAdTemplateList;
    public final View mRootView;

    public c(@NonNull Context context) {
        this(context, null);
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.mAdTemplateList = new ArrayList();
        this.bX = new com.kwad.sdk.core.h.c() { // from class: com.kwad.components.ad.interstitial.widget.c.2
            @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
            public final void aR() {
                super.aR();
                if (Build.VERSION.SDK_INT >= 19 && c.this.im) {
                    if (c.this.ih != null) {
                        c.this.ih.ek();
                    }
                    if (c.this.il != null) {
                        c.this.il.resume();
                    }
                    c.this.im = false;
                }
            }

            @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
            public final void aS() {
                super.aS();
                if (Build.VERSION.SDK_INT >= 19 && !c.this.im) {
                    if (c.this.ih != null) {
                        c.this.ih.ej();
                    }
                    if (c.this.il != null) {
                        c.this.il.pause();
                    }
                    c.this.im = true;
                }
            }
        };
        this.iq = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.widget.c.3
            public int is = 0;

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
                if (f != 0.0f) {
                    if (c.this.ij.getVisibility() == 0) {
                        c.this.ij.clearAnimation();
                        c.this.ij.setVisibility(8);
                    }
                    if (c.this.ik.getVisibility() == 0) {
                        c.this.ik.clearAnimation();
                        c.this.ik.setVisibility(8);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                e F;
                e F2 = c.this.f8if.F(i);
                if (F2 != null) {
                    F2.dW();
                }
                if (this.is != i && (F = c.this.f8if.F(this.is)) != null) {
                    F.dX();
                }
                this.is = i;
            }
        };
        this.mRootView = FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d04ca, this);
        this.mContext = context;
        initView();
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.io = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO() {
        if (this.mAdTemplate.mAdScene != null) {
            com.kwad.components.ad.interstitial.c.cd().a(16, com.kwad.components.ad.interstitial.kwai.b.cn(), this.mAdTemplate.mAdScene, new c.b() { // from class: com.kwad.components.ad.interstitial.widget.c.6
                @Override // com.kwad.components.ad.interstitial.c.b
                public final void onInterstitialAdLoad(@Nullable List<AdTemplate> list) {
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    c.this.mAdTemplateList.addAll(list);
                    c.this.ig.setAdTemplateList(c.this.mAdTemplateList);
                    c.this.ig.notifyDataSetChanged();
                    c.this.f8if.setOffscreenPageLimit(c.this.mAdTemplateList.size() - 1);
                    c.this.f8if.addOnPageChangeListener(c.this.iq);
                    c.this.dP();
                    c.this.ih.setViewPager(c.this.f8if);
                    c.this.ih.setVisibility(0);
                    c.this.aM.a(c.this.bX);
                    com.kwad.components.ad.interstitial.a.a.I(c.this.mContext);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dP() {
        this.ih.setPlayProgressListener(new ViewPagerIndicator.a() { // from class: com.kwad.components.ad.interstitial.widget.c.7
            @Override // com.kwad.components.ad.interstitial.widget.ViewPagerIndicator.a
            public final void dS() {
                c.a(c.this, true);
                if (c.this.ia) {
                    c.this.dR();
                } else {
                    c.this.dQ();
                }
                c.this.f8if.setScrollable(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 120, 0);
        this.il = ofInt;
        ofInt.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.il.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.widget.c.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f;
                c.this.f8if.scrollTo(com.kwad.sdk.b.kwai.a.a(c.this.mContext, ((Integer) valueAnimator.getAnimatedValue()).intValue()), 0);
                c.this.f8if.onPageScrolled(0, com.kwad.sdk.b.kwai.a.a(c.this.mContext, f) / c.this.getWidth(), 0);
            }
        });
        this.il.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.widget.c.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                c.this.ij.setVisibility(0);
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.5f, 1, 0.1f, 1, 0.0f, 1, 0.0f);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setDuration(800L);
                animationSet.setFillAfter(true);
                c.this.ij.startAnimation(animationSet);
            }
        });
        this.il.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dR() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, getWidth());
        this.il = ofInt;
        ofInt.setDuration(800L);
        this.il.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.widget.c.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                c.this.f8if.scrollTo(intValue, 0);
                c.this.f8if.onPageScrolled(0, intValue / c.this.getWidth(), 0);
            }
        });
        this.il.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.widget.c.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                c.this.f8if.setCurrentItem(1);
                c.this.ik.setVisibility(0);
                TranslateAnimation translateAnimation = new TranslateAnimation(1, -0.5f, 1, -0.1f, 1, 0.0f, 1, 0.0f);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setDuration(800L);
                animationSet.setFillAfter(true);
                c.this.ik.startAnimation(animationSet);
            }
        });
        this.il.start();
    }

    private void initView() {
        this.f8if = (TransViewPager) this.mRootView.findViewById(R.id.obfuscated_res_0x7f091371);
        this.ih = (ViewPagerIndicator) this.mRootView.findViewById(R.id.obfuscated_res_0x7f091372);
        this.ij = (SlideTipsView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f09135b);
        this.ik = (SlideTipsView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f091440);
        this.aM = new com.kwad.components.core.widget.kwai.b(this.mRootView, 100);
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void a(@NonNull AdTemplate adTemplate, Dialog dialog, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdTemplate = adTemplate;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.mAdInfo = bQ;
        this.ia = com.kwad.sdk.core.response.a.a.bu(bQ) == 1;
        this.mAdTemplateList.clear();
        this.mAdTemplateList.add(this.mAdTemplate);
        this.fo = adInteractionListener;
        a aVar = new a(adTemplate, dialog, ksAdVideoPlayConfig, adInteractionListener);
        this.ig = aVar;
        aVar.a(new a.b() { // from class: com.kwad.components.ad.interstitial.widget.c.1
            @Override // com.kwad.components.ad.interstitial.widget.a.b
            public final void a(e eVar, int i) {
                c.this.f8if.a(i, eVar);
            }
        });
        this.ig.a(new a.InterfaceC0593a() { // from class: com.kwad.components.ad.interstitial.widget.c.4
            @Override // com.kwad.components.ad.interstitial.widget.a.InterfaceC0593a
            public final void dL() {
                if (c.this.io) {
                    return;
                }
                if (c.this.il != null) {
                    c.this.il.cancel();
                }
                c.this.ih.setPlayProgressListener(null);
                c.this.ih.setVisibility(8);
                c.this.f8if.setScrollable(false);
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
        post(new Runnable() { // from class: com.kwad.components.ad.interstitial.widget.c.5
            @Override // java.lang.Runnable
            public final void run() {
                c.this.dO();
            }
        });
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void dM() {
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void dN() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aM.b(this.bX);
        this.aM.qj();
        this.mAdTemplateList.clear();
        com.kwad.components.ad.interstitial.c.cd().release();
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.fo = adInteractionListener;
    }
}
