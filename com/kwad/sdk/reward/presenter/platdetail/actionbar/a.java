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
/* loaded from: classes5.dex */
public class a extends g {
    public KsLogoView b;
    public ActionBarAppLandscape c;
    public ActionBarAppPortrait d;
    public ActionBarH5 e;
    public AdTemplate f;
    public AdInfo g;
    public com.kwad.sdk.core.download.a.b h;
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

    private void a(final View view2, int i) {
        e();
        view2.setVisibility(0);
        ValueAnimator a = az.a(view2, 0, i);
        this.l = a;
        a.setInterpolator(new DecelerateInterpolator(2.0f));
        this.l.setDuration(300L);
        this.l.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view2.setVisibility(0);
            }
        });
        this.l.start();
    }

    private void b(final View view2, int i) {
        e();
        view2.setVisibility(0);
        ValueAnimator a = az.a(view2, i, 0);
        this.l = a;
        a.setInterpolator(new DecelerateInterpolator(2.0f));
        this.l.setDuration(300L);
        this.l.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view2.setVisibility(8);
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
        this.b.setVisibility(0);
        if (!com.kwad.sdk.core.response.a.a.B(this.g)) {
            f(z);
        } else if (((g) this).a.f == 1) {
            d(z);
        } else {
            e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        View view2;
        LinearLayout linearLayout;
        if (this.j) {
            this.j = false;
            this.b.setVisibility(8);
            if (com.kwad.sdk.core.response.a.a.B(this.g)) {
                if (((g) this).a.f == 1) {
                    if (!z) {
                        linearLayout = this.c;
                        linearLayout.setVisibility(8);
                        return;
                    }
                    view2 = this.c;
                } else if (!z) {
                    linearLayout = this.d;
                    linearLayout.setVisibility(8);
                    return;
                } else {
                    view2 = this.d;
                }
            } else if (!z) {
                this.e.setVisibility(8);
                return;
            } else {
                view2 = this.e;
            }
            b(view2, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        }
    }

    private void d(boolean z) {
        this.c.a(this.f, this.h, new ActionBarAppLandscape.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.4
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.a
            public void a(boolean z2) {
                a.this.a(z2);
            }
        });
        if (z) {
            a(this.c, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        } else {
            this.c.setVisibility(0);
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
        this.d.a(this.f, this.h, new ActionBarAppPortrait.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.a
            public void a(boolean z2) {
                a.this.a(z2);
            }
        });
        if (z) {
            a(this.d, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        } else {
            this.d.setVisibility(0);
        }
    }

    private void f(boolean z) {
        this.e.a(this.f, new ActionBarH5.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarH5.a
            public void a(boolean z2) {
                a.this.a(z2);
            }
        });
        if (z) {
            a(this.e, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        } else {
            this.e.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.g;
        this.f = adTemplate;
        this.g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.b.a(this.f);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.h = aVar.l;
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
        this.b = (KsLogoView) a(R.id.obfuscated_res_0x7f091019);
        this.c = (ActionBarAppLandscape) a(R.id.obfuscated_res_0x7f09116d);
        this.d = (ActionBarAppPortrait) a(R.id.obfuscated_res_0x7f09116e);
        this.e = (ActionBarH5) a(R.id.obfuscated_res_0x7f09116f);
    }
}
