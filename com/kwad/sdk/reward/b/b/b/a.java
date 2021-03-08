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
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.reward.d implements View.OnClickListener {
    private TextView b;
    private ImageView c;
    private AdTemplate d;
    private AdInfo e;
    private com.kwad.sdk.core.download.b.b f;
    private com.kwad.sdk.contentalliance.detail.video.e g = new f() { // from class: com.kwad.sdk.reward.b.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            long m = com.kwad.sdk.core.response.b.a.m(a.this.e);
            if (com.kwad.sdk.core.response.b.a.l(a.this.e)) {
                a.this.a((int) ((((float) (j - j2)) / 1000.0f) + 0.5f));
            } else if (m <= 0 || j <= m) {
                a.this.a((int) ((((float) (j - j2)) / 1000.0f) + 0.5f));
            } else if (j2 >= m) {
                a.this.e();
            } else {
                a.this.a((int) ((((float) (m - j2)) / 1000.0f) + 0.5f));
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.b.setText(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        f();
        this.c.setAlpha(0.0f);
        this.c.setVisibility(0);
        this.c.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.b.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.b.b.b.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.b.setAlpha(1.0f - floatValue);
                a.this.c.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    private void f() {
        this.f7028a.b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.d, 41, this.f7028a.h.getTouchCoords(), this.f7028a.d);
        this.f7028a.b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = this.f7028a.f;
        this.e = com.kwad.sdk.core.response.b.c.j(this.d);
        this.f = this.f7028a.j;
        this.b.setText(String.valueOf(com.kwad.sdk.core.response.b.a.b(this.e)));
        this.b.setVisibility(0);
        this.f7028a.i.a(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f7028a.i.b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (TextView) b(R.id.ksad_video_count_down);
        this.c = (ImageView) b(R.id.ksad_detail_reward_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.d, new a.InterfaceC1111a() { // from class: com.kwad.sdk.reward.b.b.b.a.4
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1111a
                public void a() {
                    a.this.g();
                }
            }, this.f);
        }
    }
}
