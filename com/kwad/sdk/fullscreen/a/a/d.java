package com.kwad.sdk.fullscreen.a.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33368b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33369c;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33371e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33372f;

    /* renamed from: d  reason: collision with root package name */
    public View f33370d = null;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.reward.a.d f33373g = new com.kwad.sdk.reward.a.d() { // from class: com.kwad.sdk.fullscreen.a.a.d.1
        @Override // com.kwad.sdk.reward.a.d
        public void a(long j, long j2, int i2) {
            d.this.e();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f33374h = new e() { // from class: com.kwad.sdk.fullscreen.a.a.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= com.kwad.sdk.core.config.c.J()) {
                d.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f33370d.getVisibility() == 0) {
            return;
        }
        this.f33370d.setAlpha(0.0f);
        this.f33370d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.fullscreen.a.a.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.f33370d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.f33370d.setOnClickListener(this);
    }

    private void m() {
        com.kwad.sdk.core.report.b.i(this.f33372f, ((com.kwad.sdk.reward.d) this).f33839a.f33564d);
        ((com.kwad.sdk.reward.d) this).f33839a.f33562b.b();
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.h();
        ((com.kwad.sdk.reward.d) this).f33839a.b();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33839a;
        this.f33372f = aVar.f33566f;
        aVar.f33569i.a(this.f33374h);
        ((com.kwad.sdk.reward.d) this).f33839a.p.add(this.f33373g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        ImageView imageView;
        int i2;
        View view;
        super.b();
        this.f33371e = (TextView) a(R.id.ksad_detail_call_btn);
        this.f33368b = (ImageView) a(R.id.ksad_skip_icon);
        this.f33369c = (TextView) a(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.sdk.core.config.c.M())) {
            if (com.kwad.sdk.core.config.c.I() == 0) {
                imageView = this.f33368b;
                i2 = R.drawable.ksad_page_close;
            } else {
                imageView = this.f33368b;
                i2 = R.drawable.ksad_video_skip_icon;
            }
            imageView.setImageResource(i2);
            this.f33369c.setVisibility(8);
            view = this.f33368b;
        } else {
            this.f33369c.setText(com.kwad.sdk.core.config.c.M());
            this.f33368b.setVisibility(8);
            view = this.f33369c;
        }
        this.f33370d = view;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.b(this.f33374h);
        ((com.kwad.sdk.reward.d) this).f33839a.p.remove(this.f33373g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33370d) {
            m();
        }
    }
}
