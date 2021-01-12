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
/* loaded from: classes4.dex */
public class c extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private TextView f10579b;
    private ViewGroup c;
    private ImageView d;
    private AdTemplate e;
    private AdInfo f;
    private long g;
    private boolean h;
    private Activity i;
    private com.kwad.sdk.contentalliance.detail.video.e j = new f() { // from class: com.kwad.sdk.reward.b.b.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            c.this.h = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            c.this.g = j2;
            long m = com.kwad.sdk.core.response.b.a.m(c.this.f);
            if (com.kwad.sdk.core.response.b.a.l(c.this.f)) {
                if (j2 >= 5000) {
                    c.this.e();
                }
            } else if (m <= 0 || j <= m || j2 <= m) {
            } else {
                c.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        if (this.f10579b.getVisibility() == 0) {
            int a2 = ao.a(o(), 40.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10579b.getLayoutParams();
            layoutParams.rightMargin = (int) (a2 * f);
            this.f10579b.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f) {
        if (this.c.getVisibility() == 0) {
            int a2 = ao.a(o(), 40.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.rightMargin = (int) (a2 * f);
            this.c.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.d.getVisibility() == 0) {
            return;
        }
        this.d.setAlpha(0.0f);
        this.d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.b.b.b.c.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c.this.d.setAlpha(floatValue);
                c.this.a(floatValue);
                c.this.b(floatValue);
            }
        });
        ofFloat.start();
        this.d.setOnClickListener(this);
    }

    private void f() {
        boolean a2 = com.kwad.sdk.core.config.c.a(this.f);
        if (com.kwad.sdk.core.response.b.a.l(this.f)) {
            g();
        } else if (a2) {
            h();
        } else if (this.h || this.g >= com.kwad.sdk.core.response.b.a.m(this.f)) {
            com.kwad.sdk.core.report.b.a(this.e, this.f.adBaseInfo.skipSecond, (int) (this.g / 1000));
            q();
            p();
        }
    }

    private void g() {
        String str = "观看完整视频即可获取奖励";
        long b2 = com.kwad.sdk.core.response.b.a.b(this.f) * 1000;
        int i = this.f.adBaseInfo.skipSecond;
        if (i > 0 && !com.kwad.sdk.core.response.b.a.l(this.f)) {
            str = b2 > ((long) i) ? "观看视频" + i + "s即可获取奖励" : "观看完整视频即可获取奖励";
        }
        com.kwad.sdk.reward.e.a(this.i, str, new e.a() { // from class: com.kwad.sdk.reward.b.b.b.c.3
            @Override // com.kwad.sdk.reward.e.a
            public void a() {
                c.this.f10650a.i.f();
                com.kwad.sdk.core.report.b.j(c.this.e, c.this.f10650a.d);
            }

            @Override // com.kwad.sdk.reward.e.a
            public void b() {
                c.this.p();
                com.kwad.sdk.core.report.b.a(c.this.e, 5, (int) (c.this.g / 1000));
            }

            @Override // com.kwad.sdk.reward.e.a
            public void c() {
                c.this.f10650a.i.e();
                com.kwad.sdk.core.report.b.k(c.this.e, c.this.f10650a.d);
            }
        });
    }

    private void h() {
        Activity activity = this.f10650a.g;
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.f10650a.i.g();
    }

    private void q() {
        this.f10650a.f10525b.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.e = this.f10650a.f;
        this.f = com.kwad.sdk.core.response.b.c.j(this.e);
        this.i = this.f10650a.g;
        this.f10650a.i.a(this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f10650a.i.b(this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c = (ViewGroup) b(R.id.ksad_reward_container_new);
        this.f10579b = (TextView) b(R.id.ksad_detail_call_btn);
        this.d = (ImageView) b(R.id.ksad_detail_close_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d) {
            f();
        }
    }
}
