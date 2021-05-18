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
    public TextView f33680b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f33681c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f33682d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33683e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33684f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f33685g;

    /* renamed from: h  reason: collision with root package name */
    public long f33686h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33687i;
    public Activity j;
    public boolean k = false;
    public View l = null;
    public com.kwad.sdk.contentalliance.detail.video.d m = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.b.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            c.this.f33686h = j2;
            long l = com.kwad.sdk.core.response.b.a.l(c.this.f33685g);
            if (com.kwad.sdk.core.response.b.a.k(c.this.f33685g)) {
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
            c.this.f33687i = true;
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
        boolean a2 = com.kwad.sdk.core.config.c.a(this.f33685g, l());
        if (com.kwad.sdk.core.response.b.a.k(this.f33685g)) {
            n();
            return;
        }
        if (!a2 || !((com.kwad.sdk.reward.d) this).f33839a.t) {
            if (this.f33687i || this.f33686h >= com.kwad.sdk.core.response.b.a.l(this.f33685g)) {
                com.kwad.sdk.core.report.b.a(this.f33684f, this.f33685g.adBaseInfo.skipSecond, (int) (this.f33686h / 1000));
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
        long b2 = com.kwad.sdk.core.response.b.a.b(this.f33685g) * 1000;
        AdInfo adInfo = this.f33685g;
        int i2 = adInfo.adBaseInfo.skipSecond;
        String str = "观看完整视频即可获取奖励";
        if (i2 > 0 && !com.kwad.sdk.core.response.b.a.k(adInfo) && b2 > i2) {
            str = "观看视频" + i2 + "s即可获取奖励";
        }
        com.kwad.sdk.reward.e.a(this.j, str, new e.a() { // from class: com.kwad.sdk.reward.b.b.b.c.4
            @Override // com.kwad.sdk.reward.e.a
            public void a() {
                ((com.kwad.sdk.reward.d) c.this).f33839a.f33569i.f();
                com.kwad.sdk.core.report.b.j(c.this.f33684f, ((com.kwad.sdk.reward.d) c.this).f33839a.f33564d);
            }

            @Override // com.kwad.sdk.reward.e.a
            public void b() {
                c.this.p();
                com.kwad.sdk.core.report.b.a(c.this.f33684f, (int) (com.kwad.sdk.core.config.c.K() / 1000), (int) (c.this.f33686h / 1000));
            }

            @Override // com.kwad.sdk.reward.e.a
            public void c() {
                ((com.kwad.sdk.reward.d) c.this).f33839a.f33569i.e();
                com.kwad.sdk.core.report.b.k(c.this.f33684f, ((com.kwad.sdk.reward.d) c.this).f33839a.f33564d);
            }
        });
    }

    private void o() {
        Activity activity = ((com.kwad.sdk.reward.d) this).f33839a.f33567g;
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.g();
    }

    private void q() {
        ((com.kwad.sdk.reward.d) this).f33839a.f33562b.e();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f33839a.f33566f;
        this.f33684f = adTemplate;
        this.f33685g = com.kwad.sdk.core.response.b.c.g(adTemplate);
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33839a;
        this.j = aVar.f33567g;
        aVar.f33569i.a(this.m);
        ((com.kwad.sdk.reward.d) this).f33839a.p.add(this.n);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        ImageView imageView;
        int i2;
        View view;
        super.b();
        this.f33681c = (ViewGroup) a(R.id.ksad_reward_container_new);
        this.f33680b = (TextView) a(R.id.ksad_detail_call_btn);
        this.f33682d = (ImageView) a(R.id.ksad_detail_close_btn);
        this.f33683e = (TextView) a(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.sdk.core.config.c.N())) {
            if (com.kwad.sdk.core.config.c.L() == 0) {
                imageView = this.f33682d;
                i2 = R.drawable.ksad_page_close;
            } else {
                imageView = this.f33682d;
                i2 = R.drawable.ksad_video_skip_icon;
            }
            imageView.setImageResource(i2);
            this.f33683e.setVisibility(8);
            view = this.f33682d;
        } else {
            this.f33683e.setText(com.kwad.sdk.core.config.c.N());
            this.f33682d.setVisibility(8);
            view = this.f33683e;
        }
        this.l = view;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.b(this.m);
        ((com.kwad.sdk.reward.d) this).f33839a.p.remove(this.n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.l) {
            m();
        }
    }
}
