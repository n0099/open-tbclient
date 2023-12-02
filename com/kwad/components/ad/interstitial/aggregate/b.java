package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tieba.R;
import com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator;
import com.kwad.components.ad.interstitial.aggregate.a;
import com.kwad.components.ad.interstitial.aggregate.c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.utils.ai;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.interstitial.g.a {
    public com.kwad.components.core.widget.a.b bQ;
    public final com.kwad.sdk.core.h.c df;
    public ValueAnimator iA;
    public boolean iB;
    public InterstitialAggregateManualTipsView iC;
    public boolean iD;
    public boolean iE;
    public final ViewPager.OnPageChangeListener iF;
    public KsInterstitialAd.AdInteractionListener ie;
    public final List<AdResultData> im;
    public boolean iq;
    public TransViewPager iv;
    public a iw;
    public ViewPagerIndicator ix;
    public SlideTipsView iy;
    public SlideTipsView iz;
    public AdInfo mAdInfo;
    @NonNull
    public AdResultData mAdResultData;
    @NonNull
    public AdTemplate mAdTemplate;
    public final View mRootView;

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void cr() {
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void cs() {
    }

    public b(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.ie = adInteractionListener;
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.im = new ArrayList();
        this.df = new com.kwad.sdk.core.h.d() { // from class: com.kwad.components.ad.interstitial.aggregate.b.2
            @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
            public final void aM() {
                super.aM();
                if (Build.VERSION.SDK_INT >= 19 && b.this.iB) {
                    if (b.this.ix != null) {
                        b.this.ix.cD();
                    }
                    if (b.this.iA != null) {
                        b.this.iA.resume();
                    }
                    b.this.iB = false;
                }
            }

            @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
            public final void aN() {
                super.aN();
                if (Build.VERSION.SDK_INT >= 19 && !b.this.iB) {
                    if (b.this.ix != null) {
                        b.this.ix.cC();
                    }
                    if (b.this.iA != null) {
                        b.this.iA.pause();
                    }
                    b.this.iB = true;
                }
            }
        };
        this.iF = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.3
            public int iH = 0;

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
                if (f != 0.0f) {
                    if (b.this.iy.getVisibility() == 0) {
                        b.this.iy.clearAnimation();
                        b.this.iy.setVisibility(8);
                    }
                    if (b.this.iz.getVisibility() == 0) {
                        b.this.iz.clearAnimation();
                        b.this.iz.setVisibility(8);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                com.kwad.components.ad.interstitial.g.c y = b.this.iv.y(i);
                if (y != null) {
                    y.dZ();
                }
                if (this.iH != i) {
                    com.kwad.sdk.core.report.a.a(com.kwad.sdk.core.response.b.c.m((AdResultData) b.this.im.get(this.iH)), -1L, (JSONObject) null);
                    com.kwad.components.ad.interstitial.g.c y2 = b.this.iv.y(this.iH);
                    if (y2 != null) {
                        y2.ea();
                    }
                }
                this.iH = i;
            }
        };
        this.mContext = context;
        this.mRootView = l.inflate(context, R.layout.obfuscated_res_0x7f0d04e2, this);
        initView();
    }

    public static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.iE = true;
        return true;
    }

    public static AnimationSet b(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, f, 1, f2, 1, 0.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(800L);
        animationSet.setFillAfter(true);
        return animationSet;
    }

    public static /* synthetic */ AnimationSet a(b bVar, float f, float f2) {
        return b(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq() {
        if (this.mAdTemplate.mAdScene != null) {
            c.cx().a(16, com.kwad.components.ad.interstitial.b.b.cJ(), this.mAdTemplate.mAdScene, new c.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.6
                @Override // com.kwad.components.ad.interstitial.aggregate.c.b
                public final void onInterstitialAdLoad(@Nullable List<AdResultData> list) {
                    if (list != null && list.size() > 0) {
                        b.this.im.addAll(list);
                        b.this.iw.d(b.this.im);
                        b.this.iw.notifyDataSetChanged();
                        b.this.iv.setOffscreenPageLimit(b.this.im.size() - 1);
                        b.this.iv.addOnPageChangeListener(b.this.iF);
                        b.this.ct();
                        b.this.ix.setViewPager(b.this.iv);
                        b.this.ix.setVisibility(0);
                        b.this.bQ.a(b.this.df);
                        com.kwad.components.ad.interstitial.c.a.H(b.this.mContext);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct() {
        this.ix.setPlayProgressListener(new ViewPagerIndicator.a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.7
            @Override // com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.a
            public final void cw() {
                b.a(b.this, true);
                if (b.this.iq) {
                    b.this.cv();
                } else {
                    b.this.cu();
                }
                b.this.iv.setScrollable(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, getWidth());
        this.iA = ofInt;
        ofInt.setDuration(800L);
        this.iA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.iv.scrollTo(intValue, 0);
                b.this.iv.onPageScrolled(0, intValue / b.this.getWidth(), 0);
            }
        });
        this.iA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                b.this.iv.setCurrentItem(1);
                b.this.iz.setVisibility(0);
                b.this.iz.startAnimation(b.a(b.this, -0.5f, -0.1f));
            }
        });
        this.iA.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bQ.b(this.df);
        this.bQ.tn();
        this.im.clear();
        this.iv.clearOnPageChangeListeners();
        c.cx().release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu() {
        if (this.iD) {
            this.iC.a(this.mAdTemplate, this.iv);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 120, 0);
        this.iA = ofInt;
        ofInt.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.iA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f;
                b.this.iv.scrollTo(com.kwad.sdk.d.a.a.a(b.this.mContext, ((Integer) valueAnimator.getAnimatedValue()).intValue()), 0);
                b.this.iv.onPageScrolled(0, com.kwad.sdk.d.a.a.a(b.this.mContext, f) / b.this.getWidth(), 0);
            }
        });
        this.iA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (b.this.iD) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(200L);
                    alphaAnimation.setFillAfter(true);
                    b.this.iC.startAnimation(alphaAnimation);
                    b.this.iC.setVisibility(0);
                }
                b.this.iy.setVisibility(0);
                b.this.iy.startAnimation(b.a(b.this, 0.5f, 0.1f));
            }
        });
        this.iA.start();
    }

    private void initView() {
        this.iv = (TransViewPager) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0913da);
        this.ix = (ViewPagerIndicator) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0913db);
        this.iy = (SlideTipsView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0913ae);
        this.iz = (SlideTipsView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f09148f);
        this.iC = (InterstitialAggregateManualTipsView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0913d6);
        this.bQ = new com.kwad.components.core.widget.a.b(this.mRootView, 100);
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void a(@NonNull AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        float f;
        int i;
        this.mAdResultData = adResultData;
        AdTemplate m = com.kwad.sdk.core.response.b.c.m(adResultData);
        this.mAdTemplate = m;
        AdInfo dP = e.dP(m);
        this.mAdInfo = dP;
        boolean z = true;
        if (com.kwad.sdk.core.response.b.a.cq(dP) != 1) {
            z = false;
        }
        this.iq = z;
        this.im.clear();
        this.im.add(this.mAdResultData);
        this.ie = adInteractionListener;
        a aVar = new a(this.mAdResultData, dVar, ksAdVideoPlayConfig, adInteractionListener);
        this.iw = aVar;
        aVar.a(new a.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.1
            @Override // com.kwad.components.ad.interstitial.aggregate.a.b
            public final void a(com.kwad.components.ad.interstitial.g.c cVar, int i2) {
                b.this.iv.a(i2, cVar);
            }
        });
        this.iw.a(new a.InterfaceC0595a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.4
            @Override // com.kwad.components.ad.interstitial.aggregate.a.InterfaceC0595a
            public final void cp() {
                if (!b.this.iE) {
                    if (b.this.iA != null) {
                        b.this.iA.cancel();
                    }
                    b.this.ix.setPlayProgressListener(null);
                    b.this.ix.setVisibility(8);
                    b.this.iv.setScrollable(false);
                }
            }
        });
        this.iv.setAdapter(this.iw);
        this.iw.d(this.im);
        this.iw.notifyDataSetChanged();
        this.bQ.tm();
        ViewPagerIndicator viewPagerIndicator = this.ix;
        if (viewPagerIndicator == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewPagerIndicator.getLayoutParams();
        if (marginLayoutParams != null) {
            boolean Kx = ai.Kx();
            this.iD = Kx;
            Context context = this.mContext;
            if (Kx) {
                if (this.iq) {
                    i = 12;
                } else {
                    i = 4;
                }
                f = i;
            } else {
                f = 6.0f;
            }
            marginLayoutParams.bottomMargin = com.kwad.sdk.d.a.a.a(context, f);
            this.ix.setLayoutParams(marginLayoutParams);
        }
        this.ix.setFirstAdShowTime(com.kwad.sdk.core.response.b.a.cr(this.mAdInfo));
        post(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.b.5
            @Override // java.lang.Runnable
            public final void run() {
                b.this.cq();
            }
        });
    }
}
