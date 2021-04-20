package com.kwad.sdk.reward.b.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
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
/* loaded from: classes6.dex */
public class b extends d {

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f36559b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarAppLandscape f36560c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarAppPortrait f36561d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarH5 f36562e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f36563f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f36564g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36565h;
    public a i;
    public boolean k;
    @Nullable
    public ValueAnimator l;
    public boolean j = false;
    public a.InterfaceC0446a m = new a.InterfaceC0446a() { // from class: com.kwad.sdk.reward.b.b.a.b.1
        @Override // com.kwad.sdk.reward.b.b.a.a.InterfaceC0446a
        public void a(boolean z) {
            b.this.k = true;
            b.this.a(z);
        }
    };
    public e n = new f() { // from class: com.kwad.sdk.reward.b.b.a.b.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            b.this.i.a(((d) b.this).f36747a.i.i(), ((d) b.this).f36747a.i.j());
        }
    };
    public com.kwad.sdk.reward.a.e o = new com.kwad.sdk.reward.a.e() { // from class: com.kwad.sdk.reward.b.b.a.b.3
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            b.this.k = false;
            b.this.b(false);
        }
    };
    public com.kwad.sdk.reward.a.d p = new com.kwad.sdk.reward.a.d() { // from class: com.kwad.sdk.reward.b.b.a.b.4
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
        ValueAnimator a2 = am.a(view, 0, i);
        this.l = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
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
        this.f36559b.setVisibility(0);
        if (!com.kwad.sdk.core.response.b.a.y(this.f36564g)) {
            e(z);
        } else if (((d) this).f36747a.f36510e == 1) {
            c(z);
        } else {
            d(z);
        }
    }

    private void b(final View view, int i) {
        e();
        view.setVisibility(0);
        ValueAnimator a2 = am.a(view, i, 0);
        this.l = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
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
        View view;
        LinearLayout linearLayout;
        if (this.j) {
            this.j = false;
            this.f36559b.setVisibility(8);
            if (com.kwad.sdk.core.response.b.a.y(this.f36564g)) {
                if (((d) this).f36747a.f36510e == 1) {
                    if (!z) {
                        linearLayout = this.f36560c;
                        linearLayout.setVisibility(8);
                        return;
                    }
                    view = this.f36560c;
                } else if (!z) {
                    linearLayout = this.f36561d;
                    linearLayout.setVisibility(8);
                    return;
                } else {
                    view = this.f36561d;
                }
            } else if (!z) {
                this.f36562e.setVisibility(8);
                return;
            } else {
                view = this.f36562e;
            }
            b(view, ao.a(o(), 90.0f));
        }
    }

    private void c(boolean z) {
        this.f36560c.a(this.f36563f, this.f36565h, new ActionBarAppLandscape.a() { // from class: com.kwad.sdk.reward.b.b.a.b.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.a
            public void a() {
                b.this.f();
            }
        });
        if (z) {
            a(this.f36560c, ao.a(o(), 90.0f));
        } else {
            this.f36560c.setVisibility(0);
        }
    }

    private void d(boolean z) {
        this.f36561d.a(this.f36563f, this.f36565h, new ActionBarAppPortrait.a() { // from class: com.kwad.sdk.reward.b.b.a.b.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.a
            public void a() {
                b.this.f();
            }
        });
        if (z) {
            a(this.f36561d, ao.a(o(), 90.0f));
        } else {
            this.f36561d.setVisibility(0);
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
        this.f36562e.a(this.f36563f, new ActionBarH5.a() { // from class: com.kwad.sdk.reward.b.b.a.b.7
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarH5.a
            public void a() {
                b.this.f();
            }
        });
        if (z) {
            a(this.f36562e, ao.a(o(), 90.0f));
        } else {
            this.f36562e.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.report.b.a(this.f36563f, 1, ((d) this).f36747a.f36513h.getTouchCoords(), ((d) this).f36747a.f36509d);
        ((d) this).f36747a.f36507b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f36747a.f36511f;
        this.f36563f = adTemplate;
        this.f36564g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f36559b.a(this.f36563f);
        com.kwad.sdk.reward.a aVar = ((d) this).f36747a;
        this.f36565h = aVar.j;
        a aVar2 = aVar.k;
        this.i = aVar2;
        aVar2.a(this.m);
        ((d) this).f36747a.i.a(this.n);
        ((d) this).f36747a.n.add(this.o);
        ((d) this).f36747a.o.add(this.p);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.i.a((a.InterfaceC0446a) null);
        ((d) this).f36747a.i.b(this.n);
        ((d) this).f36747a.n.remove(this.o);
        ((d) this).f36747a.o.remove(this.p);
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36559b = (KsLogoView) b(R.id.ksad_ad_label_play_bar);
        this.f36560c = (ActionBarAppLandscape) b(R.id.ksad_video_play_bar_app_landscape);
        this.f36561d = (ActionBarAppPortrait) b(R.id.ksad_video_play_bar_app_portrait);
        this.f36562e = (ActionBarH5) b(R.id.ksad_video_play_bar_h5);
    }
}
