package com.kwad.sdk.reward.b.b.b;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.e;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f36326b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f36327c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f36328d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36329e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f36330f;

    /* renamed from: g  reason: collision with root package name */
    public long f36331g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36332h;
    public Activity i;
    public com.kwad.sdk.contentalliance.detail.video.e j = new f() { // from class: com.kwad.sdk.reward.b.b.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            c.this.f36332h = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            c.this.f36331g = j2;
            long m = com.kwad.sdk.core.response.b.a.m(c.this.f36330f);
            if (com.kwad.sdk.core.response.b.a.l(c.this.f36330f)) {
                if (j2 < 5000) {
                    return;
                }
            } else if (m <= 0 || j <= m || j2 <= m) {
                return;
            }
            c.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        if (this.f36326b.getVisibility() == 0) {
            int a2 = ao.a(o(), 40.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f36326b.getLayoutParams();
            layoutParams.rightMargin = (int) (a2 * f2);
            this.f36326b.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2) {
        if (this.f36327c.getVisibility() == 0) {
            int a2 = ao.a(o(), 40.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f36327c.getLayoutParams();
            layoutParams.rightMargin = (int) (a2 * f2);
            this.f36327c.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f36328d.getVisibility() == 0) {
            return;
        }
        this.f36328d.setAlpha(0.0f);
        this.f36328d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.b.b.b.c.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c.this.f36328d.setAlpha(floatValue);
                c.this.a(floatValue);
                c.this.b(floatValue);
            }
        });
        ofFloat.start();
        this.f36328d.setOnClickListener(this);
    }

    private void f() {
        boolean a2 = com.kwad.sdk.core.config.c.a(this.f36330f);
        if (com.kwad.sdk.core.response.b.a.l(this.f36330f)) {
            g();
        } else if (a2) {
            h();
        } else if (this.f36332h || this.f36331g >= com.kwad.sdk.core.response.b.a.m(this.f36330f)) {
            com.kwad.sdk.core.report.b.a(this.f36329e, this.f36330f.adBaseInfo.skipSecond, (int) (this.f36331g / 1000));
            q();
            p();
        }
    }

    private void g() {
        long b2 = com.kwad.sdk.core.response.b.a.b(this.f36330f) * 1000;
        AdInfo adInfo = this.f36330f;
        int i = adInfo.adBaseInfo.skipSecond;
        String str = "观看完整视频即可获取奖励";
        if (i > 0 && !com.kwad.sdk.core.response.b.a.l(adInfo) && b2 > i) {
            str = "观看视频" + i + "s即可获取奖励";
        }
        com.kwad.sdk.reward.e.a(this.i, str, new e.a() { // from class: com.kwad.sdk.reward.b.b.b.c.3
            @Override // com.kwad.sdk.reward.e.a
            public void a() {
                ((com.kwad.sdk.reward.d) c.this).f36457a.i.f();
                com.kwad.sdk.core.report.b.j(c.this.f36329e, ((com.kwad.sdk.reward.d) c.this).f36457a.f36219d);
            }

            @Override // com.kwad.sdk.reward.e.a
            public void b() {
                c.this.p();
                com.kwad.sdk.core.report.b.a(c.this.f36329e, 5, (int) (c.this.f36331g / 1000));
            }

            @Override // com.kwad.sdk.reward.e.a
            public void c() {
                ((com.kwad.sdk.reward.d) c.this).f36457a.i.e();
                com.kwad.sdk.core.report.b.k(c.this.f36329e, ((com.kwad.sdk.reward.d) c.this).f36457a.f36219d);
            }
        });
    }

    private void h() {
        Activity activity = ((com.kwad.sdk.reward.d) this).f36457a.f36222g;
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        ((com.kwad.sdk.reward.d) this).f36457a.i.g();
    }

    private void q() {
        ((com.kwad.sdk.reward.d) this).f36457a.f36217b.e();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f36457a.f36221f;
        this.f36329e = adTemplate;
        this.f36330f = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36457a;
        this.i = aVar.f36222g;
        aVar.i.a(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f36457a.i.b(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36327c = (ViewGroup) b(R.id.ksad_reward_container_new);
        this.f36326b = (TextView) b(R.id.ksad_detail_call_btn);
        this.f36328d = (ImageView) b(R.id.ksad_detail_close_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f36328d) {
            f();
        }
    }
}
