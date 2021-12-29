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
    public TextView f59832b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f59833c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f59834d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f59835e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59836f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59837g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59838h = false;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.video.d f59839i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.1
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
                bb.a(a.this.f59837g, 0, 0, 0, bb.a(a.this.q(), 1.0f));
            }
        }
    };

    /* renamed from: j  reason: collision with root package name */
    public final h f59840j = new h() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.2
        @Override // com.kwad.sdk.reward.a.h
        public void a() {
            a.this.i();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public long a(long j2) {
        return Math.min(com.kwad.sdk.core.response.a.a.p(this.f59835e), j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        this.f59832b.setText(String.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f59832b.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                a.this.f59832b.setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f59838h) {
            return;
        }
        this.f59838h = true;
        if (f() || g()) {
            bb.a(this.f59837g, bb.a(q(), 40.0f), 0, 0, bb.a(q(), 1.0f));
        }
        this.f59833c.setAlpha(0.0f);
        this.f59833c.setVisibility(0);
        this.f59833c.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f59832b.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.f59832b.setAlpha(1.0f - floatValue);
                a.this.f59833c.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ((g) this).a.f59450b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.reward.a.d dVar = ((g) this).a.f59451c;
        if (dVar != null) {
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        com.kwad.sdk.core.report.a.a(this.f59834d, 41, ((g) this).a.f59458j.getTouchCoords(), ((g) this).a.f59453e);
        ((g) this).a.f59450b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f59455g;
        this.f59834d = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f59835e = j2;
        this.f59836f = ((g) this).a.l;
        this.f59832b.setText(String.valueOf(a(com.kwad.sdk.core.response.a.a.b(j2))));
        this.f59832b.setVisibility(0);
        this.f59832b.setAlpha(1.0f);
        com.kwad.sdk.reward.d.a().a(this.f59840j);
        ((g) this).a.f59459k.a(this.f59839i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.reward.d.a().b(this.f59840j);
        ((g) this).a.f59459k.b(this.f59839i);
        this.f59833c.setVisibility(8);
        this.f59838h = false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59832b = (TextView) a(R.id.ksad_video_count_down);
        this.f59833c = (ImageView) a(R.id.ksad_detail_reward_icon);
        this.f59837g = (ImageView) a(R.id.ksad_video_sound_switch);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f59833c) {
            com.kwad.sdk.core.download.a.a.a(new a.C2083a(view.getContext()).a(this.f59834d).a(this.f59836f).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.7
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    a.this.t();
                }
            }));
        }
    }
}
