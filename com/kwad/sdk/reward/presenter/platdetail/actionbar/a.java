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
    public KsLogoView f57533b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarAppLandscape f57534c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarAppPortrait f57535d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarH5 f57536e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f57537f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f57538g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57539h;

    /* renamed from: i  reason: collision with root package name */
    public RewardActionBarControl f57540i;
    public boolean k;
    @Nullable
    public ValueAnimator l;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57541j = false;
    public RewardActionBarControl.b m = new RewardActionBarControl.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.1
        @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public void a(boolean z) {
            a.this.k = true;
            a.this.b(z);
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d n = new e() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            a.this.f57540i.a(((g) a.this).a.k.f(), ((g) a.this).a.k.g());
        }
    };
    public f o = new f() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.3
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            a.this.k = false;
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
        if (this.f57541j) {
            return;
        }
        this.f57541j = true;
        this.f57533b.setVisibility(0);
        if (!com.kwad.sdk.core.response.a.a.B(this.f57538g)) {
            f(z);
        } else if (((g) this).a.f57206f == 1) {
            d(z);
        } else {
            e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        View view;
        LinearLayout linearLayout;
        if (this.f57541j) {
            this.f57541j = false;
            this.f57533b.setVisibility(8);
            if (com.kwad.sdk.core.response.a.a.B(this.f57538g)) {
                if (((g) this).a.f57206f == 1) {
                    if (!z) {
                        linearLayout = this.f57534c;
                        linearLayout.setVisibility(8);
                        return;
                    }
                    view = this.f57534c;
                } else if (!z) {
                    linearLayout = this.f57535d;
                    linearLayout.setVisibility(8);
                    return;
                } else {
                    view = this.f57535d;
                }
            } else if (!z) {
                this.f57536e.setVisibility(8);
                return;
            } else {
                view = this.f57536e;
            }
            b(view, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        }
    }

    private void d(boolean z) {
        this.f57534c.a(this.f57537f, this.f57539h, new ActionBarAppLandscape.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.4
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.a
            public void a(boolean z2) {
                a.this.a(z2);
            }
        });
        if (z) {
            a(this.f57534c, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        } else {
            this.f57534c.setVisibility(0);
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
        this.f57535d.a(this.f57537f, this.f57539h, new ActionBarAppPortrait.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.a
            public void a(boolean z2) {
                a.this.a(z2);
            }
        });
        if (z) {
            a(this.f57535d, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        } else {
            this.f57535d.setVisibility(0);
        }
    }

    private void f(boolean z) {
        this.f57536e.a(this.f57537f, new ActionBarH5.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarH5.a
            public void a(boolean z2) {
                a.this.a(z2);
            }
        });
        if (z) {
            a(this.f57536e, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        } else {
            this.f57536e.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f57207g;
        this.f57537f = adTemplate;
        this.f57538g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f57533b.a(this.f57537f);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f57539h = aVar.l;
        RewardActionBarControl rewardActionBarControl = aVar.n;
        this.f57540i = rewardActionBarControl;
        rewardActionBarControl.a(this.m);
        ((g) this).a.k.a(this.n);
        ((g) this).a.a(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f57540i.a((RewardActionBarControl.b) null);
        ((g) this).a.k.b(this.n);
        ((g) this).a.b(this.o);
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57533b = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
        this.f57534c = (ActionBarAppLandscape) a(R.id.ksad_video_play_bar_app_landscape);
        this.f57535d = (ActionBarAppPortrait) a(R.id.ksad_video_play_bar_app_portrait);
        this.f57536e = (ActionBarH5) a(R.id.ksad_video_play_bar_h5);
    }
}
