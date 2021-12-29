package com.kwad.sdk.fullscreen.kwai.kwai;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.g;
/* loaded from: classes3.dex */
public class d extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f59175b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59176c;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59178e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f59179f;

    /* renamed from: d  reason: collision with root package name */
    public View f59177d = null;

    /* renamed from: g  reason: collision with root package name */
    public e f59180g = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.1
        @Override // com.kwad.sdk.reward.a.e
        public void a(long j2, long j3, int i2) {
            d.this.e();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59181h = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (j3 >= com.kwad.sdk.core.config.b.Q()) {
                d.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f59177d.getVisibility() == 0) {
            return;
        }
        this.f59177d.setAlpha(0.0f);
        this.f59177d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.f59177d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.f59177d.setOnClickListener(this);
    }

    private void i() {
        com.kwad.sdk.core.report.a.i(this.f59179f, ((g) this).a.f59453e);
        ((g) this).a.f59450b.b();
        ((g) this).a.f59459k.e();
        ((g) this).a.b();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f59179f = aVar.f59455g;
        aVar.f59459k.a(this.f59181h);
        ((g) this).a.q.add(this.f59180g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.f59459k.b(this.f59181h);
        ((g) this).a.q.remove(this.f59180g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        ImageView imageView;
        int i2;
        View view;
        super.c_();
        this.f59178e = (TextView) a(R.id.ksad_detail_call_btn);
        this.f59175b = (ImageView) a(R.id.ksad_skip_icon);
        this.f59176c = (TextView) a(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.sdk.core.config.b.T())) {
            if (com.kwad.sdk.core.config.b.P() == 0) {
                imageView = this.f59175b;
                i2 = R.drawable.ksad_page_close;
            } else {
                imageView = this.f59175b;
                i2 = R.drawable.ksad_video_skip_icon;
            }
            imageView.setImageResource(i2);
            this.f59176c.setVisibility(8);
            view = this.f59175b;
        } else {
            this.f59176c.setText(com.kwad.sdk.core.config.b.T());
            this.f59175b.setVisibility(8);
            view = this.f59176c;
        }
        this.f59177d = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f59177d) {
            i();
        }
    }
}
