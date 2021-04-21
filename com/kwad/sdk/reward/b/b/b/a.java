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
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f36693b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f36694c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f36695d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f36696e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36697f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f36698g = new f() { // from class: com.kwad.sdk.reward.b.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            float f2;
            long m = com.kwad.sdk.core.response.b.a.m(a.this.f36696e);
            if (com.kwad.sdk.core.response.b.a.l(a.this.f36696e) || m <= 0 || j <= m) {
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
    public void a(int i) {
        this.f36693b.setText(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        f();
        this.f36694c.setAlpha(0.0f);
        this.f36694c.setVisibility(0);
        this.f36694c.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f36693b.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.b.b.b.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.f36693b.setAlpha(1.0f - floatValue);
                a.this.f36694c.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    private void f() {
        ((com.kwad.sdk.reward.d) this).f36842a.f36602b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f36695d, 41, ((com.kwad.sdk.reward.d) this).f36842a.f36608h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f36842a.f36604d);
        ((com.kwad.sdk.reward.d) this).f36842a.f36602b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f36842a.f36606f;
        this.f36695d = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f36696e = j;
        this.f36697f = ((com.kwad.sdk.reward.d) this).f36842a.j;
        this.f36693b.setText(String.valueOf(com.kwad.sdk.core.response.b.a.b(j)));
        this.f36693b.setVisibility(0);
        ((com.kwad.sdk.reward.d) this).f36842a.i.a(this.f36698g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f36842a.i.b(this.f36698g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36693b = (TextView) b(R.id.ksad_video_count_down);
        this.f36694c = (ImageView) b(R.id.ksad_detail_reward_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f36694c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36695d, new a.InterfaceC0396a() { // from class: com.kwad.sdk.reward.b.b.b.a.4
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
                public void a() {
                    a.this.g();
                }
            }, this.f36697f);
        }
    }
}
