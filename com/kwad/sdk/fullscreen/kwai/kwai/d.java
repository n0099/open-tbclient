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
    public ImageView f56992b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56993c;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56995e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f56996f;

    /* renamed from: d  reason: collision with root package name */
    public View f56994d = null;

    /* renamed from: g  reason: collision with root package name */
    public e f56997g = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.1
        @Override // com.kwad.sdk.reward.a.e
        public void a(long j2, long j3, int i2) {
            d.this.e();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56998h = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (j3 >= com.kwad.sdk.core.config.b.Q()) {
                d.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f56994d.getVisibility() == 0) {
            return;
        }
        this.f56994d.setAlpha(0.0f);
        this.f56994d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.f56994d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.f56994d.setOnClickListener(this);
    }

    private void i() {
        com.kwad.sdk.core.report.a.i(this.f56996f, ((g) this).a.f57250e);
        ((g) this).a.f57247b.b();
        ((g) this).a.k.e();
        ((g) this).a.b();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f56996f = aVar.f57252g;
        aVar.k.a(this.f56998h);
        ((g) this).a.q.add(this.f56997g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.f56998h);
        ((g) this).a.q.remove(this.f56997g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        ImageView imageView;
        int i2;
        View view;
        super.c_();
        this.f56995e = (TextView) a(R.id.ksad_detail_call_btn);
        this.f56992b = (ImageView) a(R.id.ksad_skip_icon);
        this.f56993c = (TextView) a(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.sdk.core.config.b.T())) {
            if (com.kwad.sdk.core.config.b.P() == 0) {
                imageView = this.f56992b;
                i2 = R.drawable.ksad_page_close;
            } else {
                imageView = this.f56992b;
                i2 = R.drawable.ksad_video_skip_icon;
            }
            imageView.setImageResource(i2);
            this.f56993c.setVisibility(8);
            view = this.f56992b;
        } else {
            this.f56993c.setText(com.kwad.sdk.core.config.b.T());
            this.f56992b.setVisibility(8);
            view = this.f56993c;
        }
        this.f56994d = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f56994d) {
            i();
        }
    }
}
