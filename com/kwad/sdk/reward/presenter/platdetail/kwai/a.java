package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.h;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes3.dex */
public class a extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f57569b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f57570c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f57571d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f57572e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57573f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57574g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57575h = false;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.video.d f57576i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            long a = a.this.a(j2);
            if (j3 < a - 800) {
                a.this.b((int) ((((float) (a - j3)) / 1000.0f) + 0.5f));
            } else if (!a.this.f() && !a.this.g()) {
                a.this.r();
                a.this.i();
            } else {
                a.this.e();
                a.this.s();
                bb.a(a.this.f57574g, 0, 0, 0, bb.a(a.this.q(), 1.0f));
            }
        }
    };

    /* renamed from: j  reason: collision with root package name */
    public final h f57577j = new h() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.2
        @Override // com.kwad.sdk.reward.a.h
        public void a() {
            a.this.i();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public long a(long j2) {
        return Math.min(com.kwad.sdk.core.response.a.a.p(this.f57572e), j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        this.f57569b.setText(String.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f57569b.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                a.this.f57569b.setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f57575h) {
            return;
        }
        this.f57575h = true;
        if (f() || g()) {
            bb.a(this.f57574g, bb.a(q(), 40.0f), 0, 0, bb.a(q(), 1.0f));
        }
        this.f57570c.setAlpha(0.0f);
        this.f57570c.setVisibility(0);
        this.f57570c.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f57569b.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.f57569b.setAlpha(1.0f - floatValue);
                a.this.f57570c.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ((g) this).a.f57202b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.reward.a.d dVar = ((g) this).a.f57203c;
        if (dVar != null) {
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        com.kwad.sdk.core.report.a.a(this.f57571d, 41, ((g) this).a.f57210j.getTouchCoords(), ((g) this).a.f57205e);
        ((g) this).a.f57202b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f57207g;
        this.f57571d = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f57572e = j2;
        this.f57573f = ((g) this).a.l;
        this.f57569b.setText(String.valueOf(a(com.kwad.sdk.core.response.a.a.b(j2))));
        this.f57569b.setVisibility(0);
        this.f57569b.setAlpha(1.0f);
        com.kwad.sdk.reward.d.a().a(this.f57577j);
        ((g) this).a.k.a(this.f57576i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.reward.d.a().b(this.f57577j);
        ((g) this).a.k.b(this.f57576i);
        this.f57570c.setVisibility(8);
        this.f57575h = false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57569b = (TextView) a(R.id.ksad_video_count_down);
        this.f57570c = (ImageView) a(R.id.ksad_detail_reward_icon);
        this.f57574g = (ImageView) a(R.id.ksad_video_sound_switch);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f57570c) {
            com.kwad.sdk.core.download.a.a.a(new a.C2100a(view.getContext()).a(this.f57571d).a(this.f57573f).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.7
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    a.this.t();
                }
            }));
        }
    }
}
