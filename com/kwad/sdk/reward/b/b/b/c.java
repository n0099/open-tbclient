package com.kwad.sdk.reward.b.b.b;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.e;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f34435b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f34436c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f34437d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34438e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f34439f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f34440g;

    /* renamed from: h  reason: collision with root package name */
    public long f34441h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34442i;
    public Activity j;
    public boolean k = false;
    public View l = null;
    public com.kwad.sdk.contentalliance.detail.video.d m = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.b.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            c.this.f34441h = j2;
            long l = com.kwad.sdk.core.response.b.a.l(c.this.f34440g);
            if (com.kwad.sdk.core.response.b.a.k(c.this.f34440g)) {
                if (j2 < com.kwad.sdk.core.config.c.K()) {
                    return;
                }
            } else if (l <= 0 || j <= l || j2 <= l) {
                return;
            }
            c.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            c.this.f34442i = true;
        }
    };
    public com.kwad.sdk.reward.a.d n = new com.kwad.sdk.reward.a.d() { // from class: com.kwad.sdk.reward.b.b.b.c.2
        @Override // com.kwad.sdk.reward.a.d
        public void a(long j, long j2, int i2) {
            c.this.k = true;
            c.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.l.getVisibility() == 0) {
            return;
        }
        this.l.setAlpha(0.0f);
        this.l.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.b.b.b.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.l.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.l.setOnClickListener(this);
    }

    private void m() {
        boolean a2 = com.kwad.sdk.core.config.c.a(this.f34440g, l());
        if (com.kwad.sdk.core.response.b.a.k(this.f34440g)) {
            n();
            return;
        }
        if (!a2 || !((com.kwad.sdk.reward.d) this).f34594a.t) {
            if (this.f34442i || this.f34441h >= com.kwad.sdk.core.response.b.a.l(this.f34440g)) {
                com.kwad.sdk.core.report.b.a(this.f34439f, this.f34440g.adBaseInfo.skipSecond, (int) (this.f34441h / 1000));
                q();
                p();
                return;
            } else if (!this.k) {
                return;
            }
        }
        o();
    }

    private void n() {
        long b2 = com.kwad.sdk.core.response.b.a.b(this.f34440g) * 1000;
        AdInfo adInfo = this.f34440g;
        int i2 = adInfo.adBaseInfo.skipSecond;
        String str = "观看完整视频即可获取奖励";
        if (i2 > 0 && !com.kwad.sdk.core.response.b.a.k(adInfo) && b2 > i2) {
            str = "观看视频" + i2 + "s即可获取奖励";
        }
        com.kwad.sdk.reward.e.a(this.j, str, new e.a() { // from class: com.kwad.sdk.reward.b.b.b.c.4
            @Override // com.kwad.sdk.reward.e.a
            public void a() {
                ((com.kwad.sdk.reward.d) c.this).f34594a.f34324i.f();
                com.kwad.sdk.core.report.b.j(c.this.f34439f, ((com.kwad.sdk.reward.d) c.this).f34594a.f34319d);
            }

            @Override // com.kwad.sdk.reward.e.a
            public void b() {
                c.this.p();
                com.kwad.sdk.core.report.b.a(c.this.f34439f, (int) (com.kwad.sdk.core.config.c.K() / 1000), (int) (c.this.f34441h / 1000));
            }

            @Override // com.kwad.sdk.reward.e.a
            public void c() {
                ((com.kwad.sdk.reward.d) c.this).f34594a.f34324i.e();
                com.kwad.sdk.core.report.b.k(c.this.f34439f, ((com.kwad.sdk.reward.d) c.this).f34594a.f34319d);
            }
        });
    }

    private void o() {
        Activity activity = ((com.kwad.sdk.reward.d) this).f34594a.f34322g;
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.g();
    }

    private void q() {
        ((com.kwad.sdk.reward.d) this).f34594a.f34317b.e();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f34594a.f34321f;
        this.f34439f = adTemplate;
        this.f34440g = com.kwad.sdk.core.response.b.c.g(adTemplate);
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f34594a;
        this.j = aVar.f34322g;
        aVar.f34324i.a(this.m);
        ((com.kwad.sdk.reward.d) this).f34594a.p.add(this.n);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        ImageView imageView;
        int i2;
        View view;
        super.b();
        this.f34436c = (ViewGroup) a(R.id.ksad_reward_container_new);
        this.f34435b = (TextView) a(R.id.ksad_detail_call_btn);
        this.f34437d = (ImageView) a(R.id.ksad_detail_close_btn);
        this.f34438e = (TextView) a(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.sdk.core.config.c.N())) {
            if (com.kwad.sdk.core.config.c.L() == 0) {
                imageView = this.f34437d;
                i2 = R.drawable.ksad_page_close;
            } else {
                imageView = this.f34437d;
                i2 = R.drawable.ksad_video_skip_icon;
            }
            imageView.setImageResource(i2);
            this.f34438e.setVisibility(8);
            view = this.f34437d;
        } else {
            this.f34438e.setText(com.kwad.sdk.core.config.c.N());
            this.f34437d.setVisibility(8);
            view = this.f34438e;
        }
        this.l = view;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.b(this.m);
        ((com.kwad.sdk.reward.d) this).f34594a.p.remove(this.n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.l) {
            m();
        }
    }
}
