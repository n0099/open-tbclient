package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
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
/* loaded from: classes7.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f41037b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarAppLandscape f41038c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarAppPortrait f41039d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarH5 f41040e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f41041f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f41042g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f41043h;
    public RewardActionBarControl i;
    public boolean k;
    @Nullable
    public ValueAnimator l;
    public boolean j = false;
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
            a.this.i.a(((g) a.this).a.k.f(), ((g) a.this).a.k.g());
        }
    };
    public f o = new f() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.3
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            a.this.k = false;
            a.this.c(false);
        }
    };

    private void a(final View view, int i) {
        e();
        view.setVisibility(0);
        ValueAnimator a = az.a(view, 0, i);
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

    private void b(final View view, int i) {
        e();
        view.setVisibility(0);
        ValueAnimator a = az.a(view, i, 0);
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
        if (this.j) {
            return;
        }
        this.j = true;
        this.f41037b.setVisibility(0);
        if (!com.kwad.sdk.core.response.a.a.B(this.f41042g)) {
            f(z);
        } else if (((g) this).a.f40746f == 1) {
            d(z);
        } else {
            e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        View view;
        LinearLayout linearLayout;
        if (this.j) {
            this.j = false;
            this.f41037b.setVisibility(8);
            if (com.kwad.sdk.core.response.a.a.B(this.f41042g)) {
                if (((g) this).a.f40746f == 1) {
                    if (!z) {
                        linearLayout = this.f41038c;
                        linearLayout.setVisibility(8);
                        return;
                    }
                    view = this.f41038c;
                } else if (!z) {
                    linearLayout = this.f41039d;
                    linearLayout.setVisibility(8);
                    return;
                } else {
                    view = this.f41039d;
                }
            } else if (!z) {
                this.f41040e.setVisibility(8);
                return;
            } else {
                view = this.f41040e;
            }
            b(view, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        }
    }

    private void d(boolean z) {
        this.f41038c.a(this.f41041f, this.f41043h, new ActionBarAppLandscape.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.4
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.a
            public void a(boolean z2) {
                a.this.a(z2);
            }
        });
        if (z) {
            a(this.f41038c, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        } else {
            this.f41038c.setVisibility(0);
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
        this.f41039d.a(this.f41041f, this.f41043h, new ActionBarAppPortrait.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.a
            public void a(boolean z2) {
                a.this.a(z2);
            }
        });
        if (z) {
            a(this.f41039d, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        } else {
            this.f41039d.setVisibility(0);
        }
    }

    private void f(boolean z) {
        this.f41040e.a(this.f41041f, new ActionBarH5.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarH5.a
            public void a(boolean z2) {
                a.this.a(z2);
            }
        });
        if (z) {
            a(this.f41040e, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        } else {
            this.f41040e.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f40747g;
        this.f41041f = adTemplate;
        this.f41042g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f41037b.a(this.f41041f);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f41043h = aVar.l;
        RewardActionBarControl rewardActionBarControl = aVar.n;
        this.i = rewardActionBarControl;
        rewardActionBarControl.a(this.m);
        ((g) this).a.k.a(this.n);
        ((g) this).a.a(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.i.a((RewardActionBarControl.b) null);
        ((g) this).a.k.b(this.n);
        ((g) this).a.b(this.o);
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f41037b = (KsLogoView) a(R.id.obfuscated_res_0x7f091020);
        this.f41038c = (ActionBarAppLandscape) a(R.id.obfuscated_res_0x7f091174);
        this.f41039d = (ActionBarAppPortrait) a(R.id.obfuscated_res_0x7f091175);
        this.f41040e = (ActionBarH5) a(R.id.obfuscated_res_0x7f091176);
    }
}
