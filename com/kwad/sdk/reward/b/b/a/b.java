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
    public KsLogoView f33621b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarAppLandscape f33622c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarAppPortrait f33623d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarH5 f33624e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33625f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f33626g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33627h;

    /* renamed from: i  reason: collision with root package name */
    public a f33628i;
    public boolean k;
    @Nullable
    public ValueAnimator l;
    public boolean j = false;
    public a.InterfaceC0381a m = new a.InterfaceC0381a() { // from class: com.kwad.sdk.reward.b.b.a.b.1
        @Override // com.kwad.sdk.reward.b.b.a.a.InterfaceC0381a
        public void a(boolean z) {
            b.this.k = true;
            b.this.a(z);
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d n = new e() { // from class: com.kwad.sdk.reward.b.b.a.b.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            b.this.f33628i.a(((d) b.this).f33839a.f33569i.i(), ((d) b.this).f33839a.f33569i.j());
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
        this.f33621b.setVisibility(0);
        if (!com.kwad.sdk.core.response.b.a.v(this.f33626g)) {
            e(z);
        } else if (((d) this).f33839a.f33565e == 1) {
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
            this.f33621b.setVisibility(8);
            if (com.kwad.sdk.core.response.b.a.v(this.f33626g)) {
                if (((d) this).f33839a.f33565e == 1) {
                    if (!z) {
                        linearLayout = this.f33622c;
                        linearLayout.setVisibility(8);
                        return;
                    }
                    view = this.f33622c;
                } else if (!z) {
                    linearLayout = this.f33623d;
                    linearLayout.setVisibility(8);
                    return;
                } else {
                    view = this.f33623d;
                }
            } else if (!z) {
                this.f33624e.setVisibility(8);
                return;
            } else {
                view = this.f33624e;
            }
            b(view, an.a(l(), 90.0f));
        }
    }

    private void c(boolean z) {
        this.f33622c.a(this.f33625f, this.f33627h, new ActionBarAppLandscape.a() { // from class: com.kwad.sdk.reward.b.b.a.b.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.a
            public void a() {
                b.this.m();
            }
        });
        if (z) {
            a(this.f33622c, an.a(l(), 90.0f));
        } else {
            this.f33622c.setVisibility(0);
        }
    }

    private void d(boolean z) {
        this.f33623d.a(this.f33625f, this.f33627h, new ActionBarAppPortrait.a() { // from class: com.kwad.sdk.reward.b.b.a.b.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.a
            public void a() {
                b.this.m();
            }
        });
        if (z) {
            a(this.f33623d, an.a(l(), 90.0f));
        } else {
            this.f33623d.setVisibility(0);
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
        this.f33624e.a(this.f33625f, new ActionBarH5.a() { // from class: com.kwad.sdk.reward.b.b.a.b.7
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarH5.a
            public void a() {
                b.this.m();
            }
        });
        if (z) {
            a(this.f33624e, an.a(l(), 90.0f));
        } else {
            this.f33624e.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.kwad.sdk.core.report.b.a(this.f33625f, 1, ((d) this).f33839a.f33568h.getTouchCoords(), ((d) this).f33839a.f33564d);
        ((d) this).f33839a.f33562b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f33839a.f33566f;
        this.f33625f = adTemplate;
        this.f33626g = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33621b.a(this.f33625f);
        com.kwad.sdk.reward.a aVar = ((d) this).f33839a;
        this.f33627h = aVar.j;
        a aVar2 = aVar.k;
        this.f33628i = aVar2;
        aVar2.a(this.m);
        ((d) this).f33839a.f33569i.a(this.n);
        ((d) this).f33839a.a(this.o);
        ((d) this).f33839a.o.add(this.p);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33621b = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
        this.f33622c = (ActionBarAppLandscape) a(R.id.ksad_video_play_bar_app_landscape);
        this.f33623d = (ActionBarAppPortrait) a(R.id.ksad_video_play_bar_app_portrait);
        this.f33624e = (ActionBarH5) a(R.id.ksad_video_play_bar_h5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33628i.a((a.InterfaceC0381a) null);
        ((d) this).f33839a.f33569i.b(this.n);
        ((d) this).f33839a.b(this.o);
        ((d) this).f33839a.o.remove(this.p);
        e();
    }
}
