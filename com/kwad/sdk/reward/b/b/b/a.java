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
    public TextView f34417b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34418c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f34419d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f34420e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34421f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f34422g = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            float f2;
            long l = com.kwad.sdk.core.response.b.a.l(a.this.f34420e);
            if (com.kwad.sdk.core.response.b.a.k(a.this.f34420e) || l <= 0 || j <= l) {
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
        this.f34417b.setText(String.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        m();
        this.f34418c.setAlpha(0.0f);
        this.f34418c.setVisibility(0);
        this.f34418c.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f34417b.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.b.b.b.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.f34417b.setAlpha(1.0f - floatValue);
                a.this.f34418c.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    private void m() {
        ((com.kwad.sdk.reward.d) this).f34594a.f34317b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.kwad.sdk.core.report.b.a(this.f34419d, 41, ((com.kwad.sdk.reward.d) this).f34594a.f34323h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f34594a.f34319d);
        ((com.kwad.sdk.reward.d) this).f34594a.f34317b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f34594a.f34321f;
        this.f34419d = adTemplate;
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f34420e = g2;
        this.f34421f = ((com.kwad.sdk.reward.d) this).f34594a.j;
        this.f34417b.setText(String.valueOf(com.kwad.sdk.core.response.b.a.b(g2)));
        this.f34417b.setVisibility(0);
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.a(this.f34422g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34417b = (TextView) a(R.id.ksad_video_count_down);
        this.f34418c = (ImageView) a(R.id.ksad_detail_reward_icon);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.b(this.f34422g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f34418c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f34419d, new a.InterfaceC0376a() { // from class: com.kwad.sdk.reward.b.b.b.a.4
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                public void a() {
                    a.this.n();
                }
            }, this.f34421f, false);
        }
    }
}
