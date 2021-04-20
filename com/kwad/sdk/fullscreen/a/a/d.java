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
    public ImageView f35298b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35299c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f35300d;

    /* renamed from: e  reason: collision with root package name */
    public e f35301e = new f() { // from class: com.kwad.sdk.fullscreen.a.a.d.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 > 5000) {
                d.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        if (this.f35299c.getVisibility() == 0) {
            int a2 = ao.a(o(), 40.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f35299c.getLayoutParams();
            layoutParams.rightMargin = (int) (a2 * f2);
            this.f35299c.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f35298b.getVisibility() == 0) {
            return;
        }
        this.f35298b.setAlpha(0.0f);
        this.f35298b.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.fullscreen.a.a.d.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                d.this.f35298b.setAlpha(floatValue);
                d.this.a(floatValue);
            }
        });
        ofFloat.start();
        this.f35298b.setOnClickListener(this);
    }

    private void f() {
        com.kwad.sdk.core.report.b.i(this.f35300d, ((com.kwad.sdk.reward.d) this).f36747a.f36509d);
        ((com.kwad.sdk.reward.d) this).f36747a.f36507b.b();
        ((com.kwad.sdk.reward.d) this).f36747a.i.h();
        ((com.kwad.sdk.reward.d) this).f36747a.b();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36747a;
        this.f35300d = aVar.f36511f;
        aVar.i.a(this.f35301e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f36747a.i.b(this.f35301e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35299c = (TextView) b(R.id.ksad_detail_call_btn);
        this.f35298b = (ImageView) b(R.id.ksad_skip_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f35298b) {
            f();
        }
    }
}
