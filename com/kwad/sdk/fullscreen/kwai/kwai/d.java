package com.kwad.sdk.fullscreen.kwai.kwai;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.g;
/* loaded from: classes8.dex */
public class d extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f55509b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55510c;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55512e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f55513f;

    /* renamed from: d  reason: collision with root package name */
    public View f55511d = null;

    /* renamed from: g  reason: collision with root package name */
    public e f55514g = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.1
        @Override // com.kwad.sdk.reward.a.e
        public void a(long j2, long j3, int i2) {
            d.this.e();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f55515h = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (j3 >= com.kwad.sdk.core.config.b.Q()) {
                d.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f55511d.getVisibility() == 0) {
            return;
        }
        this.f55511d.setAlpha(0.0f);
        this.f55511d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.f55511d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.f55511d.setOnClickListener(this);
    }

    private void i() {
        com.kwad.sdk.core.report.a.i(this.f55513f, ((g) this).a.f55767e);
        ((g) this).a.f55764b.b();
        ((g) this).a.k.e();
        ((g) this).a.b();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f55513f = aVar.f55769g;
        aVar.k.a(this.f55515h);
        ((g) this).a.q.add(this.f55514g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.f55515h);
        ((g) this).a.q.remove(this.f55514g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        ImageView imageView;
        int i2;
        View view;
        super.c_();
        this.f55512e = (TextView) a(R.id.ksad_detail_call_btn);
        this.f55509b = (ImageView) a(R.id.ksad_skip_icon);
        this.f55510c = (TextView) a(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.sdk.core.config.b.T())) {
            if (com.kwad.sdk.core.config.b.P() == 0) {
                imageView = this.f55509b;
                i2 = R.drawable.ksad_page_close;
            } else {
                imageView = this.f55509b;
                i2 = R.drawable.ksad_video_skip_icon;
            }
            imageView.setImageResource(i2);
            this.f55510c.setVisibility(8);
            view = this.f55509b;
        } else {
            this.f55510c.setText(com.kwad.sdk.core.config.b.T());
            this.f55509b.setVisibility(8);
            view = this.f55510c;
        }
        this.f55511d = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f55511d) {
            i();
        }
    }
}
