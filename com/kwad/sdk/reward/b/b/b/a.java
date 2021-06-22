package com.kwad.sdk.reward.b.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f37144b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f37145c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f37146d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f37147e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37148f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f37149g = new f() { // from class: com.kwad.sdk.reward.b.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            float f2;
            long m = com.kwad.sdk.core.response.b.a.m(a.this.f37147e);
            if (com.kwad.sdk.core.response.b.a.l(a.this.f37147e) || m <= 0 || j <= m) {
                f2 = (float) (j - j2);
            } else if (j2 >= m) {
                a.this.e();
                return;
            } else {
                f2 = (float) (m - j2);
            }
            a.this.a((int) ((f2 / 1000.0f) + 0.5f));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        this.f37144b.setText(String.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        f();
        this.f37145c.setAlpha(0.0f);
        this.f37145c.setVisibility(0);
        this.f37145c.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f37144b.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.b.b.b.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.f37144b.setAlpha(1.0f - floatValue);
                a.this.f37145c.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    private void f() {
        ((com.kwad.sdk.reward.d) this).f37299a.f37049b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f37146d, 41, ((com.kwad.sdk.reward.d) this).f37299a.f37055h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f37299a.f37051d);
        ((com.kwad.sdk.reward.d) this).f37299a.f37049b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f37299a.f37053f;
        this.f37146d = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f37147e = j;
        this.f37148f = ((com.kwad.sdk.reward.d) this).f37299a.j;
        this.f37144b.setText(String.valueOf(com.kwad.sdk.core.response.b.a.b(j)));
        this.f37144b.setVisibility(0);
        ((com.kwad.sdk.reward.d) this).f37299a.f37056i.a(this.f37149g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f37299a.f37056i.b(this.f37149g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37144b = (TextView) b(R.id.ksad_video_count_down);
        this.f37145c = (ImageView) b(R.id.ksad_detail_reward_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f37145c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37146d, new a.InterfaceC0382a() { // from class: com.kwad.sdk.reward.b.b.b.a.4
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
                public void a() {
                    a.this.g();
                }
            }, this.f37148f);
        }
    }
}
