package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.k;
/* loaded from: classes4.dex */
public class c extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57795b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f57796c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57797d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f57798e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f57799f;

    /* renamed from: g  reason: collision with root package name */
    public long f57800g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57801h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57802i = false;

    /* renamed from: j  reason: collision with root package name */
    public View f57803j = null;
    public long k = -1;
    public final f l = new f() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (c.this.f57801h) {
                k.a(((g) c.this).a);
            }
        }
    };
    public final com.kwad.sdk.contentalliance.detail.video.d m = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.c.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            c.this.f57800g = j3;
            c.this.f57801h = j2 - j3 < 800;
            if (c.this.k >= 0) {
                if (j3 > Math.min(Math.min(c.this.k, com.kwad.sdk.core.response.a.a.p(c.this.f57799f)), j2)) {
                    c.this.e();
                }
            }
        }
    };
    public final com.kwad.sdk.reward.a.e n = new com.kwad.sdk.reward.a.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.c.3
        @Override // com.kwad.sdk.reward.a.e
        public void a(long j2, long j3, int i2) {
            c.this.f57802i = true;
            c.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f57803j.getVisibility() == 0) {
            return;
        }
        this.f57803j.setAlpha(0.0f);
        this.f57803j.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.c.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.f57803j.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.f57803j.setOnClickListener(this);
    }

    private void i() {
        com.kwad.sdk.core.report.a.a(this.f57798e, 69, (int) (this.k / 1000), (int) (this.f57800g / 1000));
        boolean z = !((g) this).a.v && com.kwad.sdk.core.config.b.R();
        if (f() || g() || this.f57800g < com.kwad.sdk.core.response.a.a.p(this.f57799f)) {
            if (z) {
                com.kwad.sdk.reward.widget.a.a(((g) this).a);
                return;
            }
            com.kwad.sdk.core.report.a.a(((g) this).a.f57419g, (int) (this.k / 1000), (int) (this.f57800g / 1000));
        } else if (!this.f57801h && this.f57800g < com.kwad.sdk.core.response.a.a.p(this.f57799f)) {
            if (this.f57802i) {
                h();
                return;
            }
            return;
        } else {
            com.kwad.sdk.core.report.a.a(((g) this).a.f57419g, (int) (this.k / 1000), (int) (this.f57800g / 1000));
            s();
        }
        r();
        k.a(((g) this).a);
    }

    private void r() {
        ((g) this).a.u = true;
        ((g) this).a.k.a(!com.kwad.sdk.core.response.a.a.aG(this.f57799f));
    }

    private void s() {
        ((g) this).a.f57414b.e();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f57419g;
        this.f57798e = adTemplate;
        this.f57799f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        ((g) this).a.k.a(this.m);
        ((g) this).a.q.add(this.n);
        ((g) this).a.a(this.l);
        this.k = com.kwad.sdk.core.response.a.a.o(this.f57799f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.m);
        ((g) this).a.q.remove(this.n);
        ((g) this).a.b(this.l);
        this.f57803j.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        ImageView imageView;
        int i2;
        View view;
        super.c_();
        this.f57795b = (ViewGroup) a(R.id.ksad_reward_container_new);
        this.f57796c = (ImageView) a(R.id.ksad_detail_close_btn);
        this.f57797d = (TextView) a(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.sdk.core.config.b.V())) {
            if (com.kwad.sdk.core.config.b.S() == 0) {
                imageView = this.f57796c;
                i2 = R.drawable.ksad_page_close;
            } else {
                imageView = this.f57796c;
                i2 = R.drawable.ksad_video_skip_icon;
            }
            imageView.setImageResource(i2);
            this.f57797d.setVisibility(8);
            view = this.f57796c;
        } else {
            this.f57797d.setText(com.kwad.sdk.core.config.b.V());
            this.f57796c.setVisibility(8);
            view = this.f57797d;
        }
        this.f57803j = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f57803j) {
            i();
        }
    }
}
