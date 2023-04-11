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
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortraitForLive;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarH5;
import com.kwad.components.core.m.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
/* loaded from: classes8.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.core.webview.b.d.b {
    @Nullable
    public ValueAnimator bN;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public RewardActionBarControl ml;
    public KsLogoView pM;
    public ActionBarAppLandscape rn;
    public ActionBarAppPortrait ro;
    @Nullable
    public ActionBarAppPortraitForLive rp;
    public ActionBarH5 rq;
    public boolean rs;
    @Nullable
    public ViewGroup rt;
    @Nullable
    public ViewGroup ru;
    public p rv;
    public boolean rr = false;
    public RewardActionBarControl.b rw = new RewardActionBarControl.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.1
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public final void a(boolean z, a aVar) {
            b.this.rs = true;
            b.this.a(z, aVar);
        }
    };

    /* renamed from: rx  reason: collision with root package name */
    public com.kwad.components.ad.reward.d.e f1084rx = new com.kwad.components.ad.reward.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.3
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            b.this.rs = false;
            b.this.Q(false);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z) {
        if (this.rr) {
            this.rr = false;
            this.pM.setVisibility(8);
            ViewGroup viewGroup = this.rt;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            if (!com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                if (z) {
                    d(this.rq, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
                } else {
                    this.rq.setVisibility(8);
                }
            } else if (this.nM.mScreenOrientation == 1) {
                if (z) {
                    hq();
                } else {
                    hr();
                }
            } else if (z) {
                d(this.ro, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
            } else {
                this.ro.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, a aVar) {
        ViewGroup viewGroup;
        RewardActionBarControl.ShowActionBarResult showActionBarResult;
        ViewGroup viewGroup2;
        if (this.rr) {
            return;
        }
        this.rr = true;
        this.pM.setVisibility(l(this.mAdInfo) ? 8 : 0);
        if (com.kwad.sdk.core.response.a.a.aY(this.mAdInfo) && com.kwad.sdk.core.response.a.d.cd(this.mAdTemplate) && ag.cB(getContext())) {
            if (this.rv == null) {
                p pVar = new p();
                this.rv = pVar;
                pVar.a(new p.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.4
                    @Override // com.kwad.components.ad.reward.k.p.a
                    public final void hs() {
                    }

                    @Override // com.kwad.components.ad.reward.k.p.a
                    public final void ht() {
                        com.kwad.components.ad.reward.b.eV().c(PlayableSource.ACTIONBAR_CLICK, new com.kwad.components.ad.reward.f.a(b.this.getContext()));
                        com.kwad.sdk.core.report.a.r(b.this.nM.mAdTemplate, 67);
                    }

                    @Override // com.kwad.components.ad.reward.k.p.a
                    public final void hu() {
                        b.this.nM.a(b.this.getContext(), 1, 1);
                    }

                    @Override // com.kwad.components.ad.reward.k.p.a
                    public final void hv() {
                        b.this.nM.a(b.this.getContext(), 1, 2);
                    }
                });
                this.rv.e((ViewGroup) getRootView());
                this.rv.b(u.a(this.mAdTemplate, this.mApkDownloadHelper));
            }
            this.rv.show();
            viewGroup = this.rv.fR();
            showActionBarResult = RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT;
        } else if (!com.kwad.sdk.core.response.a.a.bF(this.mAdInfo) || (viewGroup2 = this.rt) == null) {
            if (com.kwad.sdk.core.response.a.a.aK(this.mAdTemplate)) {
                ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091304);
                this.ru = viewGroup3;
                if (viewGroup3 != null) {
                    Resources resources = viewGroup3.getResources();
                    b(this.ru, (int) (resources.getDimension(R.dimen.obfuscated_res_0x7f070380) + resources.getDimension(R.dimen.obfuscated_res_0x7f070383)));
                    viewGroup = this.ru;
                    showActionBarResult = RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_LIVE_SUBSCRIBE;
                }
            }
            if (!com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                e(z, aVar);
                return;
            } else if (this.nM.mScreenOrientation == 1) {
                b(z, aVar);
                return;
            } else if (l(this.mAdInfo)) {
                d(z, aVar);
                return;
            } else {
                c(z, aVar);
                return;
            }
        } else {
            viewGroup2.setVisibility(0);
            viewGroup = this.rt;
            showActionBarResult = RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_JINNIU;
        }
        RewardActionBarControl.a(aVar, viewGroup, showActionBarResult);
    }

    private void aL() {
        ValueAnimator valueAnimator = this.bN;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.bN.cancel();
        }
    }

    private void b(final View view2, int i) {
        aL();
        view2.setVisibility(0);
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ValueAnimator c = n.c(view2, i, 0);
        this.bN = c;
        c.setInterpolator(create);
        this.bN.setDuration(500L);
        this.bN.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view2.setVisibility(0);
            }
        });
        this.bN.start();
    }

    private void b(boolean z, a aVar) {
        this.rn.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppLandscape.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.5
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
            public final void R(boolean z2) {
                b.this.L(z2);
            }
        });
        if (z) {
            c(this.rn, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
        } else {
            this.rn.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.rn, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void bQ() {
        AdTemplate adTemplate = this.nM.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.mAdInfo = bQ;
        if (com.kwad.sdk.core.response.a.a.bF(bQ)) {
            this.rt = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912f0);
        }
        this.pM.T(this.mAdTemplate);
        k kVar = this.nM;
        this.mApkDownloadHelper = kVar.mApkDownloadHelper;
        RewardActionBarControl rewardActionBarControl = kVar.ml;
        this.ml = rewardActionBarControl;
        rewardActionBarControl.a(this.rw);
        this.nM.a(this.f1084rx);
    }

    @Deprecated
    private void c(final View view2, int i) {
        aL();
        view2.setVisibility(0);
        ValueAnimator b = n.b(view2, 0, i);
        this.bN = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.bN.setDuration(500L);
        this.bN.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view2.setVisibility(0);
            }
        });
        this.bN.start();
    }

    private void c(boolean z, a aVar) {
        this.ro.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortrait.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.6
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
            public final void R(boolean z2) {
                b.this.L(z2);
            }
        });
        if (z) {
            c(this.ro, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
        } else {
            this.ro.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.ro, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void d(final View view2, int i) {
        aL();
        view2.setVisibility(0);
        ValueAnimator b = n.b(view2, i, 0);
        this.bN = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.bN.setDuration(300L);
        this.bN.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view2.setVisibility(8);
            }
        });
        this.bN.start();
    }

    private void d(boolean z, a aVar) {
        this.rp.a(this.nM, this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortraitForLive.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.7
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortraitForLive.a
            public final void R(boolean z2) {
                b.this.L(z2);
            }
        });
        if (z) {
            c(this.rp, com.kwad.sdk.b.kwai.a.a(getContext(), 68.0f));
        } else {
            this.rp.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.rp, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void e(boolean z, a aVar) {
        this.rq.a(this.mAdTemplate, new ActionBarH5.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.8
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
            public final void R(boolean z2) {
                b.this.L(z2);
            }
        });
        if (z) {
            c(this.rq, com.kwad.sdk.b.kwai.a.a(getContext(), 90.0f));
        } else {
            this.rq.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.rq, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void hq() {
        View view2;
        Context context;
        float f;
        if (l(this.mAdInfo)) {
            view2 = this.rp;
            context = getContext();
            f = 68.0f;
        } else {
            view2 = this.ro;
            context = getContext();
            f = 90.0f;
        }
        c(view2, com.kwad.sdk.b.kwai.a.a(context, f));
    }

    private void hr() {
        (l(this.mAdInfo) ? this.rp : this.ro).setVisibility(8);
    }

    private boolean l(AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.a.bK(adInfo) && this.nM.mz;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (k.c(this.nM)) {
            com.kwad.components.core.webview.b.c.a.pR().a(this);
        } else {
            bQ();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pM = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0911c1);
        this.rn = (ActionBarAppLandscape) findViewById(R.id.obfuscated_res_0x7f091393);
        this.ro = (ActionBarAppPortrait) findViewById(R.id.obfuscated_res_0x7f091394);
        this.rp = (ActionBarAppPortraitForLive) findViewById(R.id.obfuscated_res_0x7f091395);
        this.rq = (ActionBarH5) findViewById(R.id.obfuscated_res_0x7f091396);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.ml;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.b) null);
        }
        com.kwad.components.core.webview.b.c.a.pR().b(this);
        this.nM.b(this.f1084rx);
        aL();
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-bottom-card-v2".equals(str)) {
            bQ();
        }
    }
}
