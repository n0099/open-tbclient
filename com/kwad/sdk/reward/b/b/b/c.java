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
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f37162b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f37163c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f37164d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f37165e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f37166f;

    /* renamed from: g  reason: collision with root package name */
    public long f37167g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37168h;

    /* renamed from: i  reason: collision with root package name */
    public Activity f37169i;
    public com.kwad.sdk.contentalliance.detail.video.e j = new f() { // from class: com.kwad.sdk.reward.b.b.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            c.this.f37168h = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            c.this.f37167g = j2;
            long m = com.kwad.sdk.core.response.b.a.m(c.this.f37166f);
            if (com.kwad.sdk.core.response.b.a.l(c.this.f37166f)) {
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
        if (this.f37162b.getVisibility() == 0) {
            int a2 = ao.a(o(), 40.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37162b.getLayoutParams();
            layoutParams.rightMargin = (int) (a2 * f2);
            this.f37162b.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2) {
        if (this.f37163c.getVisibility() == 0) {
            int a2 = ao.a(o(), 40.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37163c.getLayoutParams();
            layoutParams.rightMargin = (int) (a2 * f2);
            this.f37163c.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f37164d.getVisibility() == 0) {
            return;
        }
        this.f37164d.setAlpha(0.0f);
        this.f37164d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.b.b.b.c.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c.this.f37164d.setAlpha(floatValue);
                c.this.a(floatValue);
                c.this.b(floatValue);
            }
        });
        ofFloat.start();
        this.f37164d.setOnClickListener(this);
    }

    private void f() {
        boolean a2 = com.kwad.sdk.core.config.c.a(this.f37166f);
        if (com.kwad.sdk.core.response.b.a.l(this.f37166f)) {
            g();
        } else if (a2) {
            h();
        } else if (this.f37168h || this.f37167g >= com.kwad.sdk.core.response.b.a.m(this.f37166f)) {
            com.kwad.sdk.core.report.b.a(this.f37165e, this.f37166f.adBaseInfo.skipSecond, (int) (this.f37167g / 1000));
            q();
            p();
        }
    }

    private void g() {
        long b2 = com.kwad.sdk.core.response.b.a.b(this.f37166f) * 1000;
        AdInfo adInfo = this.f37166f;
        int i2 = adInfo.adBaseInfo.skipSecond;
        String str = "观看完整视频即可获取奖励";
        if (i2 > 0 && !com.kwad.sdk.core.response.b.a.l(adInfo) && b2 > i2) {
            str = "观看视频" + i2 + "s即可获取奖励";
        }
        com.kwad.sdk.reward.e.a(this.f37169i, str, new e.a() { // from class: com.kwad.sdk.reward.b.b.b.c.3
            @Override // com.kwad.sdk.reward.e.a
            public void a() {
                ((com.kwad.sdk.reward.d) c.this).f37299a.f37056i.f();
                com.kwad.sdk.core.report.b.j(c.this.f37165e, ((com.kwad.sdk.reward.d) c.this).f37299a.f37051d);
            }

            @Override // com.kwad.sdk.reward.e.a
            public void b() {
                c.this.p();
                com.kwad.sdk.core.report.b.a(c.this.f37165e, 5, (int) (c.this.f37167g / 1000));
            }

            @Override // com.kwad.sdk.reward.e.a
            public void c() {
                ((com.kwad.sdk.reward.d) c.this).f37299a.f37056i.e();
                com.kwad.sdk.core.report.b.k(c.this.f37165e, ((com.kwad.sdk.reward.d) c.this).f37299a.f37051d);
            }
        });
    }

    private void h() {
        Activity activity = ((com.kwad.sdk.reward.d) this).f37299a.f37054g;
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        ((com.kwad.sdk.reward.d) this).f37299a.f37056i.g();
    }

    private void q() {
        ((com.kwad.sdk.reward.d) this).f37299a.f37049b.e();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f37299a.f37053f;
        this.f37165e = adTemplate;
        this.f37166f = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f37299a;
        this.f37169i = aVar.f37054g;
        aVar.f37056i.a(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f37299a.f37056i.b(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37163c = (ViewGroup) b(R.id.ksad_reward_container_new);
        this.f37162b = (TextView) b(R.id.ksad_detail_call_btn);
        this.f37164d = (ImageView) b(R.id.ksad_detail_close_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f37164d) {
            f();
        }
    }
}
