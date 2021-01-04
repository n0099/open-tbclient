package com.kwad.sdk.reward.b.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.b.b.a.a;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.sdk.reward.widget.actionbar.ActionBarH5;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes5.dex */
public class b extends d {

    /* renamed from: b  reason: collision with root package name */
    private KsLogoView f10843b;
    private ActionBarAppLandscape c;
    private ActionBarAppPortrait d;
    private ActionBarH5 e;
    private AdTemplate f;
    private AdInfo g;
    private com.kwad.sdk.core.download.b.b h;
    private a i;
    private boolean k;
    @Nullable
    private ValueAnimator l;
    private boolean j = false;
    private a.InterfaceC1117a m = new a.InterfaceC1117a() { // from class: com.kwad.sdk.reward.b.b.a.b.1
        @Override // com.kwad.sdk.reward.b.b.a.a.InterfaceC1117a
        public void a(boolean z) {
            b.this.k = true;
            b.this.a(z);
        }
    };
    private e n = new f() { // from class: com.kwad.sdk.reward.b.b.a.b.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            b.this.i.a(b.this.f10949a.i.i(), b.this.f10949a.i.j());
        }
    };
    private com.kwad.sdk.reward.a.e o = new com.kwad.sdk.reward.a.e() { // from class: com.kwad.sdk.reward.b.b.a.b.3
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            b.this.k = false;
            b.this.b(false);
        }
    };
    private com.kwad.sdk.reward.a.d p = new com.kwad.sdk.reward.a.d() { // from class: com.kwad.sdk.reward.b.b.a.b.4
        @Override // com.kwad.sdk.reward.a.d
        public void a() {
            b.this.b(true);
        }

        @Override // com.kwad.sdk.reward.a.d
        public void b() {
            if (b.this.k) {
                b.this.a(true);
            }
        }
    };

    private void a(final View view, int i) {
        e();
        view.setVisibility(0);
        this.l = am.a(view, 0, i);
        this.l.setInterpolator(new DecelerateInterpolator(2.0f));
        this.l.setDuration(300L);
        this.l.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.a.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.l.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.f10843b.setVisibility(0);
        if (!com.kwad.sdk.core.response.b.a.y(this.g)) {
            e(z);
        } else if (this.f10949a.e == 1) {
            c(z);
        } else {
            d(z);
        }
    }

    private void b(final View view, int i) {
        e();
        view.setVisibility(0);
        this.l = am.a(view, i, 0);
        this.l.setInterpolator(new DecelerateInterpolator(2.0f));
        this.l.setDuration(300L);
        this.l.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.a.b.9
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
            this.j = false;
            this.f10843b.setVisibility(8);
            if (!com.kwad.sdk.core.response.b.a.y(this.g)) {
                if (z) {
                    b(this.e, ao.a(o(), 90.0f));
                } else {
                    this.e.setVisibility(8);
                }
            } else if (this.f10949a.e == 1) {
                if (z) {
                    b(this.c, ao.a(o(), 90.0f));
                } else {
                    this.c.setVisibility(8);
                }
            } else if (z) {
                b(this.d, ao.a(o(), 90.0f));
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    private void c(boolean z) {
        this.c.a(this.f, this.h, new ActionBarAppLandscape.a() { // from class: com.kwad.sdk.reward.b.b.a.b.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.a
            public void a() {
                b.this.f();
            }
        });
        if (z) {
            a(this.c, ao.a(o(), 90.0f));
        } else {
            this.c.setVisibility(0);
        }
    }

    private void d(boolean z) {
        this.d.a(this.f, this.h, new ActionBarAppPortrait.a() { // from class: com.kwad.sdk.reward.b.b.a.b.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.a
            public void a() {
                b.this.f();
            }
        });
        if (z) {
            a(this.d, ao.a(o(), 90.0f));
        } else {
            this.d.setVisibility(0);
        }
    }

    private void e() {
        if (this.l != null) {
            this.l.removeAllListeners();
            this.l.cancel();
        }
    }

    private void e(boolean z) {
        this.e.a(this.f, new ActionBarH5.a() { // from class: com.kwad.sdk.reward.b.b.a.b.7
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarH5.a
            public void a() {
                b.this.f();
            }
        });
        if (z) {
            a(this.e, ao.a(o(), 90.0f));
        } else {
            this.e.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.report.b.a(this.f, 1, this.f10949a.h.getTouchCoords(), this.f10949a.d);
        this.f10949a.f10824b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f = this.f10949a.f;
        this.g = com.kwad.sdk.core.response.b.c.j(this.f);
        this.f10843b.a(this.f);
        this.h = this.f10949a.j;
        this.i = this.f10949a.k;
        this.i.a(this.m);
        this.f10949a.i.a(this.n);
        this.f10949a.n.add(this.o);
        this.f10949a.o.add(this.p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.i.a((a.InterfaceC1117a) null);
        this.f10949a.i.b(this.n);
        this.f10949a.n.remove(this.o);
        this.f10949a.o.remove(this.p);
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f10843b = (KsLogoView) b(R.id.ksad_ad_label_play_bar);
        this.c = (ActionBarAppLandscape) b(R.id.ksad_video_play_bar_app_landscape);
        this.d = (ActionBarAppPortrait) b(R.id.ksad_video_play_bar_app_portrait);
        this.e = (ActionBarH5) b(R.id.ksad_video_play_bar_h5);
    }
}
