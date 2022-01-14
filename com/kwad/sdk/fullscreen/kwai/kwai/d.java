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
    public ImageView f56947b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56948c;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56950e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f56951f;

    /* renamed from: d  reason: collision with root package name */
    public View f56949d = null;

    /* renamed from: g  reason: collision with root package name */
    public e f56952g = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.1
        @Override // com.kwad.sdk.reward.a.e
        public void a(long j2, long j3, int i2) {
            d.this.e();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56953h = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (j3 >= com.kwad.sdk.core.config.b.Q()) {
                d.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f56949d.getVisibility() == 0) {
            return;
        }
        this.f56949d.setAlpha(0.0f);
        this.f56949d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.f56949d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.f56949d.setOnClickListener(this);
    }

    private void i() {
        com.kwad.sdk.core.report.a.i(this.f56951f, ((g) this).a.f57205e);
        ((g) this).a.f57202b.b();
        ((g) this).a.k.e();
        ((g) this).a.b();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f56951f = aVar.f57207g;
        aVar.k.a(this.f56953h);
        ((g) this).a.q.add(this.f56952g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.f56953h);
        ((g) this).a.q.remove(this.f56952g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        ImageView imageView;
        int i2;
        View view;
        super.c_();
        this.f56950e = (TextView) a(R.id.ksad_detail_call_btn);
        this.f56947b = (ImageView) a(R.id.ksad_skip_icon);
        this.f56948c = (TextView) a(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.sdk.core.config.b.T())) {
            if (com.kwad.sdk.core.config.b.P() == 0) {
                imageView = this.f56947b;
                i2 = R.drawable.ksad_page_close;
            } else {
                imageView = this.f56947b;
                i2 = R.drawable.ksad_video_skip_icon;
            }
            imageView.setImageResource(i2);
            this.f56948c.setVisibility(8);
            view = this.f56947b;
        } else {
            this.f56948c.setText(com.kwad.sdk.core.config.b.T());
            this.f56947b.setVisibility(8);
            view = this.f56948c;
        }
        this.f56949d = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f56949d) {
            i();
        }
    }
}
