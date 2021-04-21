package com.kwad.sdk.fullscreen.a.a;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35393b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35394c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f35395d;

    /* renamed from: e  reason: collision with root package name */
    public e f35396e = new f() { // from class: com.kwad.sdk.fullscreen.a.a.d.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 > 5000) {
                d.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        if (this.f35394c.getVisibility() == 0) {
            int a2 = ao.a(o(), 40.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f35394c.getLayoutParams();
            layoutParams.rightMargin = (int) (a2 * f2);
            this.f35394c.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f35393b.getVisibility() == 0) {
            return;
        }
        this.f35393b.setAlpha(0.0f);
        this.f35393b.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.fullscreen.a.a.d.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                d.this.f35393b.setAlpha(floatValue);
                d.this.a(floatValue);
            }
        });
        ofFloat.start();
        this.f35393b.setOnClickListener(this);
    }

    private void f() {
        com.kwad.sdk.core.report.b.i(this.f35395d, ((com.kwad.sdk.reward.d) this).f36842a.f36604d);
        ((com.kwad.sdk.reward.d) this).f36842a.f36602b.b();
        ((com.kwad.sdk.reward.d) this).f36842a.i.h();
        ((com.kwad.sdk.reward.d) this).f36842a.b();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36842a;
        this.f35395d = aVar.f36606f;
        aVar.i.a(this.f35396e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f36842a.i.b(this.f35396e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35394c = (TextView) b(R.id.ksad_detail_call_btn);
        this.f35393b = (ImageView) b(R.id.ksad_skip_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f35393b) {
            f();
        }
    }
}
