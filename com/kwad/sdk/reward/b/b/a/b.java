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
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.b.b.a.a;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.sdk.reward.widget.actionbar.ActionBarH5;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class b extends d {

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f33550b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarAppLandscape f33551c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarAppPortrait f33552d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarH5 f33553e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33554f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f33555g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33556h;

    /* renamed from: i  reason: collision with root package name */
    public a f33557i;
    public boolean k;
    @Nullable
    public ValueAnimator l;
    public boolean j = false;
    public a.InterfaceC0382a m = new a.InterfaceC0382a() { // from class: com.kwad.sdk.reward.b.b.a.b.1
        @Override // com.kwad.sdk.reward.b.b.a.a.InterfaceC0382a
        public void a(boolean z) {
            b.this.k = true;
            b.this.a(z);
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d n = new e() { // from class: com.kwad.sdk.reward.b.b.a.b.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            b.this.f33557i.a(((d) b.this).f33768a.f33498i.i(), ((d) b.this).f33768a.f33498i.j());
        }
    };
    public f o = new f() { // from class: com.kwad.sdk.reward.b.b.a.b.3
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            b.this.k = false;
            b.this.b(false);
        }
    };
    public com.kwad.sdk.reward.a.e p = new com.kwad.sdk.reward.a.e() { // from class: com.kwad.sdk.reward.b.b.a.b.4
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            b.this.b(true);
        }

        @Override // com.kwad.sdk.reward.a.e
        public void b() {
            if (b.this.k) {
                b.this.a(true);
            }
        }
    };

    private void a(final View view, int i2) {
        e();
        view.setVisibility(0);
        ValueAnimator a2 = am.a(view, 0, i2);
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
        this.f33550b.setVisibility(0);
        if (!com.kwad.sdk.core.response.b.a.v(this.f33555g)) {
            e(z);
        } else if (((d) this).f33768a.f33494e == 1) {
            c(z);
        } else {
            d(z);
        }
    }

    private void b(final View view, int i2) {
        e();
        view.setVisibility(0);
        ValueAnimator a2 = am.a(view, i2, 0);
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
            this.f33550b.setVisibility(8);
            if (com.kwad.sdk.core.response.b.a.v(this.f33555g)) {
                if (((d) this).f33768a.f33494e == 1) {
                    if (!z) {
                        linearLayout = this.f33551c;
                        linearLayout.setVisibility(8);
                        return;
                    }
                    view = this.f33551c;
                } else if (!z) {
                    linearLayout = this.f33552d;
                    linearLayout.setVisibility(8);
                    return;
                } else {
                    view = this.f33552d;
                }
            } else if (!z) {
                this.f33553e.setVisibility(8);
                return;
            } else {
                view = this.f33553e;
            }
            b(view, an.a(l(), 90.0f));
        }
    }

    private void c(boolean z) {
        this.f33551c.a(this.f33554f, this.f33556h, new ActionBarAppLandscape.a() { // from class: com.kwad.sdk.reward.b.b.a.b.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.a
            public void a() {
                b.this.m();
            }
        });
        if (z) {
            a(this.f33551c, an.a(l(), 90.0f));
        } else {
            this.f33551c.setVisibility(0);
        }
    }

    private void d(boolean z) {
        this.f33552d.a(this.f33554f, this.f33556h, new ActionBarAppPortrait.a() { // from class: com.kwad.sdk.reward.b.b.a.b.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.a
            public void a() {
                b.this.m();
            }
        });
        if (z) {
            a(this.f33552d, an.a(l(), 90.0f));
        } else {
            this.f33552d.setVisibility(0);
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
        this.f33553e.a(this.f33554f, new ActionBarH5.a() { // from class: com.kwad.sdk.reward.b.b.a.b.7
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarH5.a
            public void a() {
                b.this.m();
            }
        });
        if (z) {
            a(this.f33553e, an.a(l(), 90.0f));
        } else {
            this.f33553e.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.kwad.sdk.core.report.b.a(this.f33554f, 1, ((d) this).f33768a.f33497h.getTouchCoords(), ((d) this).f33768a.f33493d);
        ((d) this).f33768a.f33491b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f33768a.f33495f;
        this.f33554f = adTemplate;
        this.f33555g = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33550b.a(this.f33554f);
        com.kwad.sdk.reward.a aVar = ((d) this).f33768a;
        this.f33556h = aVar.j;
        a aVar2 = aVar.k;
        this.f33557i = aVar2;
        aVar2.a(this.m);
        ((d) this).f33768a.f33498i.a(this.n);
        ((d) this).f33768a.a(this.o);
        ((d) this).f33768a.o.add(this.p);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33550b = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
        this.f33551c = (ActionBarAppLandscape) a(R.id.ksad_video_play_bar_app_landscape);
        this.f33552d = (ActionBarAppPortrait) a(R.id.ksad_video_play_bar_app_portrait);
        this.f33553e = (ActionBarH5) a(R.id.ksad_video_play_bar_h5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33557i.a((a.InterfaceC0382a) null);
        ((d) this).f33768a.f33498i.b(this.n);
        ((d) this).f33768a.b(this.o);
        ((d) this).f33768a.o.remove(this.p);
        e();
    }
}
