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
    public ImageView f34123b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34124c;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34126e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f34127f;

    /* renamed from: d  reason: collision with root package name */
    public View f34125d = null;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.reward.a.d f34128g = new com.kwad.sdk.reward.a.d() { // from class: com.kwad.sdk.fullscreen.a.a.d.1
        @Override // com.kwad.sdk.reward.a.d
        public void a(long j, long j2, int i2) {
            d.this.e();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f34129h = new e() { // from class: com.kwad.sdk.fullscreen.a.a.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= com.kwad.sdk.core.config.c.J()) {
                d.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f34125d.getVisibility() == 0) {
            return;
        }
        this.f34125d.setAlpha(0.0f);
        this.f34125d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.fullscreen.a.a.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.f34125d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.f34125d.setOnClickListener(this);
    }

    private void m() {
        com.kwad.sdk.core.report.b.i(this.f34127f, ((com.kwad.sdk.reward.d) this).f34594a.f34319d);
        ((com.kwad.sdk.reward.d) this).f34594a.f34317b.b();
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.h();
        ((com.kwad.sdk.reward.d) this).f34594a.b();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f34594a;
        this.f34127f = aVar.f34321f;
        aVar.f34324i.a(this.f34129h);
        ((com.kwad.sdk.reward.d) this).f34594a.p.add(this.f34128g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        ImageView imageView;
        int i2;
        View view;
        super.b();
        this.f34126e = (TextView) a(R.id.ksad_detail_call_btn);
        this.f34123b = (ImageView) a(R.id.ksad_skip_icon);
        this.f34124c = (TextView) a(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.sdk.core.config.c.M())) {
            if (com.kwad.sdk.core.config.c.I() == 0) {
                imageView = this.f34123b;
                i2 = R.drawable.ksad_page_close;
            } else {
                imageView = this.f34123b;
                i2 = R.drawable.ksad_video_skip_icon;
            }
            imageView.setImageResource(i2);
            this.f34124c.setVisibility(8);
            view = this.f34123b;
        } else {
            this.f34124c.setText(com.kwad.sdk.core.config.c.M());
            this.f34123b.setVisibility(8);
            view = this.f34124c;
        }
        this.f34125d = view;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.b(this.f34129h);
        ((com.kwad.sdk.reward.d) this).f34594a.p.remove(this.f34128g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f34125d) {
            m();
        }
    }
}
