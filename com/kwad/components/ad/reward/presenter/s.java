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
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.components.ad.k.b;
import com.kwad.components.ad.reward.presenter.RewardPreEndCardPresenter;
import com.kwad.components.core.i.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class s extends b implements com.kwad.components.ad.reward.e.g, a.InterfaceC0649a, w.b {
    @Nullable
    public com.kwad.components.ad.reward.d oO;
    public ImageView sb;
    public View tc;
    public KsLogoView td;
    public DetailVideoView te;
    public int tf;
    public View tg;
    public FrameLayout th;
    public Animator ti;
    public Animator tj;
    public Animator tk;
    public AdTemplate tl;
    public List<com.kwad.components.core.i.c> tm;
    public boolean tu;
    @RewardPreEndCardPresenter.PreEndPageStatus
    public int tb = 1;
    public long tn = 500;
    public long to = 50;
    public float tp = 1.2254902f;
    public float tq = 0.80472106f;
    public float tr = 0.0f;
    public boolean ts = false;
    public long showTime = -1;
    public long tt = -1;
    public com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.s.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            s.this.g(j2);
        }
    };
    public com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.s.5
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar != null && !com.kwad.sdk.core.response.b.e.c(s.this.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                com.kwad.components.core.i.c a = com.kwad.components.ad.reward.g.a(s.this.tm, aVar.creativeId);
                if (a != null) {
                    s.this.qn.a(a);
                    return;
                }
                return;
            }
            s.this.qn.oH.bJ();
        }
    };

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.tc = findViewById(R.id.obfuscated_res_0x7f0913d8);
        this.te = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f091500);
        this.td = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0914c5);
        this.sb = (ImageView) findViewById(R.id.obfuscated_res_0x7f091319);
        this.tg = findViewById(R.id.obfuscated_res_0x7f0913ec);
        this.th = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0913d9);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.g gVar = this.qn;
        gVar.po = false;
        gVar.oI.b(this.gO);
        this.qn.c(this);
        this.qn.b((a.InterfaceC0649a) this);
        com.kwad.components.ad.reward.d dVar = this.oO;
        if (dVar != null) {
            dVar.lP();
        }
        Animator animator = this.tk;
        if (animator != null) {
            animator.cancel();
        }
        DetailVideoView detailVideoView = this.te;
        if (detailVideoView != null) {
            com.kwad.sdk.d.a.a.n(detailVideoView, this.tf);
        }
        Animator animator2 = this.ti;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.tk = null;
        this.ti = null;
    }

    private boolean I(boolean z) {
        boolean z2;
        int b = b(hF());
        N(b);
        com.kwad.components.ad.reward.d dVar = this.oO;
        if (dVar != null) {
            z2 = dVar.ar();
        } else {
            z2 = false;
        }
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "webLoadSuccess: " + z2);
        if (!z2) {
            return false;
        }
        int a = a(hF());
        float f = -b;
        this.tr = f;
        Animator a2 = a(true, f, a, true, z);
        this.ti = a2;
        a2.start();
        Animator hE = hE();
        this.tk = hE;
        hE.start();
        this.tb = 2;
        return true;
    }

    private void J(boolean z) {
        Animator a = a(false, (hF() - hG()) + this.tr, a(hG()), false, z);
        this.tj = a;
        a.start();
        com.kwad.sdk.core.d.a.Cv();
        com.kwad.sdk.core.d.a.bF(this.tl);
        this.tb = 3;
        com.kwad.components.ad.reward.d dVar = this.oO;
        if (dVar != null) {
            dVar.fk();
        }
    }

    private void f(List<AdTemplate> list) {
        com.kwad.components.ad.reward.d dVar = new com.kwad.components.ad.reward.d(list, this.qn.mReportExtData, this);
        this.oO = dVar;
        this.qn.oO = dVar;
        dVar.setShowLandingPage(com.kwad.sdk.core.response.b.b.cs(this.mAdTemplate));
        this.oO.a(this.cR);
        com.kwad.components.ad.reward.d dVar2 = this.oO;
        FrameLayout frameLayout = this.th;
        com.kwad.components.ad.reward.g gVar = this.qn;
        dVar2.a(frameLayout, gVar.mRootContainer, this.mAdTemplate, gVar.mApkDownloadHelper, gVar.mScreenOrientation);
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "startPreloadWebView");
        this.oO.a(new b.InterfaceC0606b() { // from class: com.kwad.components.ad.reward.presenter.s.2
            @Override // com.kwad.components.ad.k.b.InterfaceC0606b
            public final void hH() {
                com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "onPreloadSuccess");
                s.this.qn.po = true;
            }
        });
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0649a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "onInnerAdLoad: " + list);
        if (list != null && list.size() != 0) {
            this.tl = list.get(0).getAdTemplate();
            this.tm = list;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mAdTemplate);
            arrayList.addAll(com.kwad.components.core.i.c.l(list));
            f(arrayList);
        }
    }

    private void N(int i) {
        ViewGroup.LayoutParams layoutParams = this.tc.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = -i;
            return;
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
        layoutParams3.height = i;
        layoutParams3.bottomMargin = -i;
        this.tc.setLayoutParams(layoutParams3);
    }

    private int a(float f) {
        return (int) (com.kwad.sdk.d.a.a.e(getActivity()) - f);
    }

    private int b(float f) {
        return (int) (f + getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070529) + getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07052a));
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0649a
    public final void onRequestResult(int i) {
        com.kwad.sdk.core.e.c.w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }

    @Override // com.kwad.components.core.webview.jshandler.w.b
    public final void N(AdTemplate adTemplate) {
        com.kwad.components.core.i.c cVar = new com.kwad.components.core.i.c(adTemplate, com.kwad.components.core.i.e.AGGREGATION);
        com.kwad.components.ad.reward.g gVar = this.qn;
        if (gVar != null) {
            gVar.b(cVar);
        }
    }

    private Animator a(boolean z, float f, int i, boolean z2, boolean z3) {
        ValueAnimator ofFloat;
        long j;
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f + ", videoTargetHeight: " + i);
        if (z) {
            ofFloat = ObjectAnimator.ofFloat(this.tc, Key.TRANSLATION_Y, f);
        } else {
            int height = this.tc.getHeight();
            final ViewGroup.LayoutParams layoutParams = this.tc.getLayoutParams();
            ofFloat = ValueAnimator.ofFloat(height, Math.abs(f));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    s.this.tc.setLayoutParams(layoutParams);
                }
            });
        }
        ObjectAnimator objectAnimator = null;
        if (z2) {
            objectAnimator = ObjectAnimator.ofFloat(this.td, Key.ALPHA, 0.0f, 255.0f);
        }
        final ViewGroup.LayoutParams layoutParams2 = this.sb.getLayoutParams();
        ValueAnimator a = this.te.a(this.mAdTemplate, i, new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                if (layoutParams3 != null) {
                    layoutParams3.height = intValue;
                    s.this.sb.setLayoutParams(layoutParams2);
                }
            }
        });
        if (z3) {
            j = this.tn;
        } else {
            j = this.to;
        }
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(create);
        if (objectAnimator != null) {
            if (z3) {
                animatorSet.playTogether(ofFloat, objectAnimator, a);
            } else {
                animatorSet.playTogether(ofFloat, objectAnimator);
            }
        } else if (z3) {
            animatorSet.playTogether(ofFloat, a);
        } else {
            animatorSet.playTogether(ofFloat);
        }
        return animatorSet;
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0649a
    public final void onError(int i, String str) {
        com.kwad.sdk.core.e.c.w("RewardPreEndCardPresenter", "onError : msg " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j) {
        boolean z;
        AdTemplate adTemplate = this.tl;
        if (adTemplate == null || this.tu) {
            return;
        }
        if (this.showTime <= 0) {
            this.showTime = com.kwad.sdk.core.response.b.b.cp(adTemplate);
            this.tt = com.kwad.sdk.core.response.b.b.co(this.tl) + this.showTime;
        }
        long j2 = this.showTime;
        if (j2 > 0 && !this.ts && j > j2) {
            this.tu = !I(true);
            com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "showError: " + this.tu);
            if (this.tu) {
                return;
            }
            this.ts = true;
        }
        if (this.tb == 3) {
            z = true;
        } else {
            z = false;
        }
        long j3 = this.tt;
        if (j3 > 0 && !z && j > j3) {
            J(true);
        }
    }

    private Animator hE() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.tg, Key.ALPHA, 255.0f, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    private float hF() {
        return com.kwad.sdk.d.a.a.d(getActivity()) / this.tp;
    }

    private float hG() {
        return com.kwad.sdk.d.a.a.d(getActivity()) / this.tq;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qn.oI.a(this.gO);
        this.qn.b((com.kwad.components.ad.reward.e.g) this);
        this.qn.a(this);
        this.tf = com.kwad.sdk.d.a.a.F(this.te);
        com.kwad.sdk.d.a.a.n(this.te, 49);
        this.td.aD(this.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void bL() {
        int i;
        if (this.tl != null && (i = this.tb) != 3) {
            if (i == 1) {
                I(false);
                J(false);
            } else if (i == 2) {
                J(true);
            }
        }
    }
}
