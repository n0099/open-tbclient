package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.sdk.reward.widget.actionbar.ActionBarH5;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes3.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f59794b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarAppLandscape f59795c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarAppPortrait f59796d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarH5 f59797e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f59798f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f59799g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59800h;

    /* renamed from: i  reason: collision with root package name */
    public RewardActionBarControl f59801i;

    /* renamed from: k  reason: collision with root package name */
    public boolean f59803k;
    @Nullable
    public ValueAnimator l;

    /* renamed from: j  reason: collision with root package name */
    public boolean f59802j = false;
    public RewardActionBarControl.b m = new RewardActionBarControl.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.1
        @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public void a(boolean z) {
            a.this.f59803k = true;
            a.this.b(z);
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d n = new e() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            a.this.f59801i.a(((g) a.this).a.f59459k.f(), ((g) a.this).a.f59459k.g());
        }
    };
    public f o = new f() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.3
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            a.this.f59803k = false;
            a.this.c(false);
        }
    };

    private void a(final View view, int i2) {
        e();
        view.setVisibility(0);
        ValueAnimator a = az.a(view, 0, i2);
        this.l = a;
        a.setInterpolator(new DecelerateInterpolator(2.0f));
        this.l.setDuration(300L);
        this.l.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.l.start();
    }

    private void b(final View view, int i2) {
        e();
        view.setVisibility(0);
        ValueAnimator a = az.a(view, i2, 0);
        this.l = a;
        a.setInterpolator(new DecelerateInterpolator(2.0f));
        this.l.setDuration(300L);
        this.l.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        this.l.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.f59802j) {
            return;
        }
        this.f59802j = true;
        this.f59794b.setVisibility(0);
        if (!com.kwad.sdk.core.response.a.a.B(this.f59799g)) {
            f(z);
        } else if (((g) this).a.f59454f == 1) {
            d(z);
        } else {
            e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        View view;
        LinearLayout linearLayout;
        if (this.f59802j) {
            this.f59802j = false;
            this.f59794b.setVisibility(8);
            if (com.kwad.sdk.core.response.a.a.B(this.f59799g)) {
                if (((g) this).a.f59454f == 1) {
                    if (!z) {
                        linearLayout = this.f59795c;
                        linearLayout.setVisibility(8);
                        return;
                    }
                    view = this.f59795c;
                } else if (!z) {
                    linearLayout = this.f59796d;
                    linearLayout.setVisibility(8);
                    return;
                } else {
                    view = this.f59796d;
                }
            } else if (!z) {
                this.f59797e.setVisibility(8);
                return;
            } else {
                view = this.f59797e;
            }
            b(view, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        }
    }

    private void d(boolean z) {
        this.f59795c.a(this.f59798f, this.f59800h, new ActionBarAppLandscape.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.4
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.a
            public void a(boolean z2) {
                a.this.a(z2);
            }
        });
        if (z) {
            a(this.f59795c, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        } else {
            this.f59795c.setVisibility(0);
        }
    }

    private void e() {
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.l.cancel();
        }
    }

    private void e(boolean z) {
        this.f59796d.a(this.f59798f, this.f59800h, new ActionBarAppPortrait.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.a
            public void a(boolean z2) {
                a.this.a(z2);
            }
        });
        if (z) {
            a(this.f59796d, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        } else {
            this.f59796d.setVisibility(0);
        }
    }

    private void f(boolean z) {
        this.f59797e.a(this.f59798f, new ActionBarH5.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarH5.a
            public void a(boolean z2) {
                a.this.a(z2);
            }
        });
        if (z) {
            a(this.f59797e, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        } else {
            this.f59797e.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f59455g;
        this.f59798f = adTemplate;
        this.f59799g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f59794b.a(this.f59798f);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f59800h = aVar.l;
        RewardActionBarControl rewardActionBarControl = aVar.n;
        this.f59801i = rewardActionBarControl;
        rewardActionBarControl.a(this.m);
        ((g) this).a.f59459k.a(this.n);
        ((g) this).a.a(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f59801i.a((RewardActionBarControl.b) null);
        ((g) this).a.f59459k.b(this.n);
        ((g) this).a.b(this.o);
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59794b = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
        this.f59795c = (ActionBarAppLandscape) a(R.id.ksad_video_play_bar_app_landscape);
        this.f59796d = (ActionBarAppPortrait) a(R.id.ksad_video_play_bar_app_portrait);
        this.f59797e = (ActionBarH5) a(R.id.ksad_video_play_bar_h5);
    }
}
