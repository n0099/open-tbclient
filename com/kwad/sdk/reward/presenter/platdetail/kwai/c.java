package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.k;
/* loaded from: classes5.dex */
public class c extends g implements View.OnClickListener {
    public ViewGroup b;
    public ImageView c;
    public TextView d;
    public AdTemplate e;
    public AdInfo f;
    public long g;
    public boolean h;
    public boolean i = false;
    public View j = null;
    public long k = -1;
    public final f l = new f() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (c.this.h) {
                k.a(((g) c.this).a);
            }
        }
    };
    public final com.kwad.sdk.contentalliance.detail.video.d m = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.c.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            c.this.g = j2;
            c.this.h = j - j2 < 800;
            if (c.this.k >= 0) {
                if (j2 > Math.min(Math.min(c.this.k, com.kwad.sdk.core.response.a.a.p(c.this.f)), j)) {
                    c.this.e();
                }
            }
        }
    };
    public final com.kwad.sdk.reward.a.e n = new com.kwad.sdk.reward.a.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.c.3
        @Override // com.kwad.sdk.reward.a.e
        public void a(long j, long j2, int i) {
            c.this.i = true;
            c.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.j.getVisibility() == 0) {
            return;
        }
        this.j.setAlpha(0.0f);
        this.j.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.c.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.j.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.j.setOnClickListener(this);
    }

    private void i() {
        com.kwad.sdk.core.report.a.a(this.e, 69, (int) (this.k / 1000), (int) (this.g / 1000));
        boolean z = !((g) this).a.v && com.kwad.sdk.core.config.b.R();
        if (f() || g() || this.g < com.kwad.sdk.core.response.a.a.p(this.f)) {
            if (z) {
                com.kwad.sdk.reward.widget.a.a(((g) this).a);
                return;
            }
            com.kwad.sdk.core.report.a.a(((g) this).a.g, (int) (this.k / 1000), (int) (this.g / 1000));
        } else if (!this.h && this.g < com.kwad.sdk.core.response.a.a.p(this.f)) {
            if (this.i) {
                h();
                return;
            }
            return;
        } else {
            com.kwad.sdk.core.report.a.a(((g) this).a.g, (int) (this.k / 1000), (int) (this.g / 1000));
            s();
        }
        r();
        k.a(((g) this).a);
    }

    private void r() {
        ((g) this).a.u = true;
        ((g) this).a.k.a(!com.kwad.sdk.core.response.a.a.aG(this.f));
    }

    private void s() {
        ((g) this).a.b.e();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.g;
        this.e = adTemplate;
        this.f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        ((g) this).a.k.a(this.m);
        ((g) this).a.q.add(this.n);
        ((g) this).a.a(this.l);
        this.k = com.kwad.sdk.core.response.a.a.o(this.f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.m);
        ((g) this).a.q.remove(this.n);
        ((g) this).a.b(this.l);
        this.j.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        ImageView imageView;
        int i;
        View view2;
        super.c_();
        this.b = (ViewGroup) a(R.id.obfuscated_res_0x7f0910a7);
        this.c = (ImageView) a(R.id.obfuscated_res_0x7f091020);
        this.d = (TextView) a(R.id.obfuscated_res_0x7f091112);
        if (TextUtils.isEmpty(com.kwad.sdk.core.config.b.V())) {
            if (com.kwad.sdk.core.config.b.S() == 0) {
                imageView = this.c;
                i = R.drawable.obfuscated_res_0x7f080bfa;
            } else {
                imageView = this.c;
                i = R.drawable.obfuscated_res_0x7f080ce6;
            }
            imageView.setImageResource(i);
            this.d.setVisibility(8);
            view2 = this.c;
        } else {
            this.d.setText(com.kwad.sdk.core.config.b.V());
            this.c.setVisibility(8);
            view2 = this.d;
        }
        this.j = view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.j) {
            i();
        }
    }
}
