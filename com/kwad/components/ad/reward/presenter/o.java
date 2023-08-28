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
/* loaded from: classes10.dex */
public final class o extends a implements com.kwad.components.ad.reward.d.e, e.a, e.b {
    public KsLogoView ln;
    public AdTemplate mAdTemplate;
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
    @RewardPreEndCardPresenter.PreEndPageStatus
    public int qz = 1;
    public float qK = 1.2254902f;
    public float qL = 0.80472106f;
    public float qM = 0.0f;
    public long qN = 500;
    public long qO = 50;
    public com.kwad.components.core.video.g mVideoPlayStateListener = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.reward.presenter.o.1
        public boolean qP = false;
        public long qQ = -1;
        public long qR = -1;
        public boolean qS;

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            if (o.this.qI == null || this.qS) {
                return;
            }
            if (this.qQ <= 0) {
                this.qQ = com.kwad.sdk.core.response.a.b.aT(o.this.qI);
                this.qR = com.kwad.sdk.core.response.a.b.aS(o.this.qI) + this.qQ;
            }
            long j3 = this.qQ;
            if (j3 > 0 && !this.qP && j2 > j3) {
                this.qS = !o.this.N(true);
                com.kwad.sdk.core.e.b.d("RewardPreEndCardPresenter", "showError: " + this.qS);
                if (this.qS) {
                    return;
                }
                this.qP = true;
            }
            boolean z = o.this.qz == 3;
            long j4 = this.qR;
            if (j4 <= 0 || z || j2 <= j4) {
                return;
            }
            o.this.O(true);
        }
    };
    public com.kwad.sdk.core.webview.a.kwai.a bJ = new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.o.5
        @Override // com.kwad.sdk.core.webview.a.kwai.a
        public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
            if (aVar == null || com.kwad.sdk.core.response.a.d.b(o.this.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                o.this.nM.mAdOpenInteractionListener.bB();
                return;
            }
            com.kwad.components.ad.reward.c.b a = com.kwad.components.ad.reward.k.a(o.this.qJ, aVar.creativeId);
            if (a != null) {
                o.this.nM.b(a);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N(boolean z) {
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

    private void O(int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void O(boolean z) {
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

    private int a(float f) {
        return (int) (com.kwad.sdk.b.kwai.a.d(getActivity()) - f);
    }

    private Animator a(boolean z, float f, int i, boolean z2, boolean z3) {
        ValueAnimator ofFloat;
        com.kwad.sdk.core.e.b.d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f + ", videoTargetHeight: " + i);
        if (z) {
            ofFloat = ObjectAnimator.ofFloat(this.qA, Key.TRANSLATION_Y, f);
        } else {
            int height = this.qA.getHeight();
            final ViewGroup.LayoutParams layoutParams = this.qA.getLayoutParams();
            ofFloat = ValueAnimator.ofFloat(height, Math.abs(f));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.o.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    o.this.qA.setLayoutParams(layoutParams);
                }
            });
        }
        ObjectAnimator ofFloat2 = z2 ? ObjectAnimator.ofFloat(this.ln, Key.ALPHA, 0.0f, 255.0f) : null;
        final ViewGroup.LayoutParams layoutParams2 = this.px.getLayoutParams();
        ValueAnimator a = this.qB.a(this.mAdTemplate, i, new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.o.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                if (layoutParams3 != null) {
                    layoutParams3.height = intValue;
                    o.this.px.setLayoutParams(layoutParams2);
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

    private int b(float f) {
        return (int) (f + getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070528) + getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070529));
    }

    private void g(List<AdTemplate> list) {
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
        this.mp.a(new b.InterfaceC0610b() { // from class: com.kwad.components.ad.reward.presenter.o.2
            @Override // com.kwad.components.ad.i.b.InterfaceC0610b
            public final void hk() {
                com.kwad.sdk.core.e.b.d("RewardPreEndCardPresenter", "onPreloadSuccess");
                o.this.nM.mJ = true;
            }
        });
    }

    public static boolean hg() {
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

    private Animator hh() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.qD, Key.ALPHA, 255.0f, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    private float hi() {
        return com.kwad.sdk.b.kwai.a.c(getActivity()) / this.qK;
    }

    private float hj() {
        return com.kwad.sdk.b.kwai.a.c(getActivity()) / this.qL;
    }

    @Override // com.kwad.components.ad.reward.e.a
    public final void C(String str) {
        com.kwad.sdk.core.e.b.w("RewardPreEndCardPresenter", "onError : msg " + str);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
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

    @Override // com.kwad.components.core.webview.jshandler.e.b
    public final void b(AdTemplate adTemplate, long j) {
        com.kwad.components.ad.reward.c.b bVar = new com.kwad.components.ad.reward.c.b(adTemplate, com.kwad.components.ad.reward.c.d.AGGREGATION);
        com.kwad.components.ad.reward.k kVar = this.nM;
        if (kVar != null) {
            kVar.c(bVar);
        }
    }

    @Override // com.kwad.components.ad.reward.d.e
    public final void bA() {
        int i;
        if (this.qI == null || (i = this.qz) == 3) {
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

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.qA = findViewById(R.id.obfuscated_res_0x7f091322);
        this.qB = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f09144a);
        this.ln = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091417);
        this.px = (ImageView) findViewById(R.id.obfuscated_res_0x7f091293);
        this.qD = findViewById(R.id.obfuscated_res_0x7f091342);
        this.qE = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091323);
    }

    @Override // com.kwad.components.ad.reward.e.a
    public final void onRequestResult(int i) {
        com.kwad.sdk.core.e.b.w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
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
