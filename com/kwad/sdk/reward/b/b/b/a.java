package com.kwad.sdk.reward.b.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f33591b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f33592c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f33593d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f33594e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33595f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f33596g = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            float f2;
            long l = com.kwad.sdk.core.response.b.a.l(a.this.f33594e);
            if (com.kwad.sdk.core.response.b.a.k(a.this.f33594e) || l <= 0 || j <= l) {
                f2 = (float) (j - j2);
            } else if (j2 >= l) {
                a.this.e();
                return;
            } else {
                f2 = (float) (l - j2);
            }
            a.this.b((int) ((f2 / 1000.0f) + 0.5f));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        this.f33591b.setText(String.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        m();
        this.f33592c.setAlpha(0.0f);
        this.f33592c.setVisibility(0);
        this.f33592c.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f33591b.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.b.b.b.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.f33591b.setAlpha(1.0f - floatValue);
                a.this.f33592c.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    private void m() {
        ((com.kwad.sdk.reward.d) this).f33768a.f33491b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.kwad.sdk.core.report.b.a(this.f33593d, 41, ((com.kwad.sdk.reward.d) this).f33768a.f33497h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f33768a.f33493d);
        ((com.kwad.sdk.reward.d) this).f33768a.f33491b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f33768a.f33495f;
        this.f33593d = adTemplate;
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33594e = g2;
        this.f33595f = ((com.kwad.sdk.reward.d) this).f33768a.j;
        this.f33591b.setText(String.valueOf(com.kwad.sdk.core.response.b.a.b(g2)));
        this.f33591b.setVisibility(0);
        ((com.kwad.sdk.reward.d) this).f33768a.f33498i.a(this.f33596g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33591b = (TextView) a(R.id.ksad_video_count_down);
        this.f33592c = (ImageView) a(R.id.ksad_detail_reward_icon);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f33768a.f33498i.b(this.f33596g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33592c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33593d, new a.InterfaceC0364a() { // from class: com.kwad.sdk.reward.b.b.b.a.4
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
                public void a() {
                    a.this.n();
                }
            }, this.f33595f, false);
        }
    }
}
