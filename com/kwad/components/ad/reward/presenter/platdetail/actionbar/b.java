package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.n.h;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarH5;
import com.kwad.components.core.s.n;
import com.kwad.components.core.video.l;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    @Nullable
    public ValueAnimator cV;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public RewardActionBarControl oL;
    public KsLogoView sq;
    @Nullable
    public ViewGroup uA;
    public h uB;
    public boolean uC;
    public ActionBarAppLandscape ut;
    public ActionBarAppPortrait uu;
    public ActionBarH5 uv;
    public boolean ux;
    @Nullable
    public ViewGroup uy;
    @Nullable
    public ViewGroup uz;
    public boolean uw = false;
    public final l su = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.uC = true;
            if (com.kwad.sdk.core.response.b.a.cJ(b.this.mAdInfo) && b.this.uA != null) {
                b.this.uA.setVisibility(8);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.uC = false;
            if (com.kwad.sdk.core.response.b.a.cJ(b.this.mAdInfo) && b.this.uA != null) {
                b.this.uA.setVisibility(0);
            }
        }
    };
    public RewardActionBarControl.b uD = new RewardActionBarControl.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.4
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public final void a(boolean z, a aVar) {
            b.this.ux = true;
            b.this.a(z, aVar);
        }
    };
    public g uE = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.5
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            b.this.ux = false;
            b.this.L(false);
        }
    };

    private void aG() {
        ValueAnimator valueAnimator = this.cV;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.cV.cancel();
        }
    }

    private void ca() {
        if (com.kwad.sdk.core.response.b.a.cD(this.mAdInfo)) {
            this.uy = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091442);
        }
        this.sq.aD(this.mAdTemplate);
        com.kwad.components.ad.reward.g gVar = this.qn;
        this.mApkDownloadHelper = gVar.mApkDownloadHelper;
        RewardActionBarControl rewardActionBarControl = gVar.oL;
        this.oL = rewardActionBarControl;
        rewardActionBarControl.a(this.uD);
        this.qn.b(this.uE);
    }

    private void hS() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f092a6b);
        if (viewStub != null) {
            this.ut = (ActionBarAppLandscape) viewStub.inflate();
        } else {
            this.ut = (ActionBarAppLandscape) findViewById(R.id.obfuscated_res_0x7f0914fd);
        }
    }

    private void hT() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f092a6a);
        if (viewStub != null) {
            this.uu = (ActionBarAppPortrait) viewStub.inflate();
        } else {
            this.uu = (ActionBarAppPortrait) findViewById(R.id.obfuscated_res_0x7f0914fe);
        }
    }

    private void hU() {
        hT();
        f(this.uu, com.kwad.sdk.d.a.a.a(getContext(), 90.0f));
    }

    private void hV() {
        ActionBarAppPortrait actionBarAppPortrait = this.uu;
        if (actionBarAppPortrait != null) {
            actionBarAppPortrait.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.qn.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        this.qn.oI.a(this.su);
        ca();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0912f6);
        this.uv = (ActionBarH5) findViewById(R.id.obfuscated_res_0x7f0914ff);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.oL;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.b) null);
        }
        this.qn.oI.b(this.su);
        this.qn.c(this.uE);
        aG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        if (!this.uw) {
            return;
        }
        this.uw = false;
        this.sq.setVisibility(8);
        ViewGroup viewGroup = this.uy;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        ViewGroup viewGroup2 = this.uA;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            if (this.qn.mScreenOrientation == 1) {
                if (z) {
                    hU();
                } else {
                    hV();
                }
            } else if (z) {
                ActionBarAppPortrait actionBarAppPortrait = this.uu;
                if (actionBarAppPortrait != null) {
                    g(actionBarAppPortrait, com.kwad.sdk.d.a.a.a(getContext(), 90.0f));
                }
            } else {
                ActionBarAppPortrait actionBarAppPortrait2 = this.uu;
                if (actionBarAppPortrait2 != null) {
                    actionBarAppPortrait2.setVisibility(8);
                }
            }
        } else if (z) {
            g(this.uv, com.kwad.sdk.d.a.a.a(getContext(), 90.0f));
        } else {
            this.uv.setVisibility(8);
        }
    }

    public final void M(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 153;
        }
        j cA = new j().d(this.qn.mRootContainer.getTouchCoords()).cA(i);
        com.kwad.components.ad.reward.g gVar = this.qn;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, "native_id", (String) null, cA, gVar.mReportExtData);
        this.qn.oH.bJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, a aVar) {
        int i;
        ViewGroup viewGroup;
        if (this.uw) {
            return;
        }
        this.uw = true;
        KsLogoView ksLogoView = this.sq;
        if (com.kwad.sdk.core.response.b.a.cJ(this.mAdInfo)) {
            i = 8;
        } else {
            i = 0;
        }
        ksLogoView.setVisibility(i);
        getContext();
        final boolean z2 = !ai.Kx();
        if (com.kwad.sdk.core.response.b.a.bd(this.mAdInfo)) {
            if (this.uB == null) {
                h hVar = new h() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.6
                    @Override // com.kwad.components.ad.reward.n.h
                    public final int hW() {
                        if (z2) {
                            return R.id.obfuscated_res_0x7f09132f;
                        }
                        return super.hW();
                    }
                };
                this.uB = hVar;
                hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.7
                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void hX() {
                        b.this.qn.a(1, b.this.getContext(), 29, 1);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void hY() {
                        b.this.qn.a(1, b.this.getContext(), 30, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void hZ() {
                        b.this.qn.a(1, b.this.getContext(), 31, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void ia() {
                        b.this.qn.a(1, b.this.getContext(), 32, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void ib() {
                        b.this.qn.a(1, b.this.getContext(), 84, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void ic() {
                        b.this.qn.a(1, b.this.getContext(), 53, 2);
                    }
                });
                this.uB.f((ViewGroup) getRootView());
                this.uB.b(r.a(this.mAdTemplate, this.mApkDownloadHelper));
            }
            this.uB.show();
            RewardActionBarControl.a(aVar, this.uB.gD(), RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        } else if (com.kwad.sdk.core.response.b.a.bZ(this.mAdInfo) == 1 && (viewGroup = this.uy) != null) {
            viewGroup.setVisibility(0);
            RewardActionBarControl.a(aVar, this.uy, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_JINNIU);
        } else {
            if (com.kwad.sdk.core.response.b.a.cJ(this.mAdInfo)) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091474);
                this.uA = viewGroup2;
                if (viewGroup2 != null) {
                    if (!this.uC) {
                        viewGroup2.setVisibility(0);
                    }
                    RewardActionBarControl.a(aVar, this.uA, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORIGIN_LIVE);
                    return;
                }
            }
            if (com.kwad.sdk.core.response.b.a.ca(this.mAdTemplate)) {
                ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091457);
                this.uz = viewGroup3;
                if (viewGroup3 != null) {
                    Resources resources = viewGroup3.getResources();
                    e(this.uz, (int) (resources.getDimension(R.dimen.obfuscated_res_0x7f0704e1) + resources.getDimension(R.dimen.obfuscated_res_0x7f0704e5)));
                    RewardActionBarControl.a(aVar, this.uz, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_LIVE_SUBSCRIBE);
                    return;
                }
            }
            if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
                if (this.qn.mScreenOrientation == 1) {
                    b(z, aVar);
                    return;
                } else {
                    c(z, aVar);
                    return;
                }
            }
            d(z, aVar);
        }
    }

    private void b(boolean z, a aVar) {
        hS();
        this.ut.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppLandscape.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.8
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
            public final void N(boolean z2) {
                b.this.M(z2);
            }
        });
        if (z) {
            f(this.ut, com.kwad.sdk.d.a.a.a(getContext(), 90.0f));
        } else {
            this.ut.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.ut, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void d(boolean z, a aVar) {
        this.uv.a(this.mAdTemplate, new ActionBarH5.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.10
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
            public final void N(boolean z2) {
                b.this.M(z2);
            }
        });
        if (z) {
            f(this.uv, com.kwad.sdk.d.a.a.a(getContext(), 90.0f));
        } else {
            this.uv.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.uv, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void e(final View view2, int i) {
        aG();
        view2.setVisibility(0);
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ValueAnimator c = n.c(view2, i, 0);
        this.cV = c;
        c.setInterpolator(create);
        this.cV.setDuration(500L);
        this.cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view2.setVisibility(0);
            }
        });
        this.cV.start();
    }

    @Deprecated
    private void f(final View view2, int i) {
        aG();
        view2.setVisibility(0);
        ValueAnimator b = n.b(view2, 0, i);
        this.cV = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cV.setDuration(500L);
        this.cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view2.setVisibility(0);
            }
        });
        this.cV.start();
    }

    private void g(final View view2, int i) {
        aG();
        view2.setVisibility(0);
        ValueAnimator b = n.b(view2, i, 0);
        this.cV = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cV.setDuration(300L);
        this.cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view2.setVisibility(8);
            }
        });
        this.cV.start();
    }

    private void c(boolean z, a aVar) {
        hT();
        this.uu.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortrait.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.9
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
            public final void N(boolean z2) {
                b.this.M(z2);
            }
        });
        if (z) {
            f(this.uu, com.kwad.sdk.d.a.a.a(getContext(), 90.0f));
        } else {
            this.uu.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.uu, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }
}
