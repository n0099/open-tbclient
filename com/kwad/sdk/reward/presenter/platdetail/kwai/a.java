package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.h;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes7.dex */
public class a extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f41069b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f41070c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f41071d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f41072e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f41073f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f41074g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41075h = false;
    public final com.kwad.sdk.contentalliance.detail.video.d i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            long a = a.this.a(j);
            if (j2 < a - 800) {
                a.this.b((int) ((((float) (a - j2)) / 1000.0f) + 0.5f));
            } else if (!a.this.f() && !a.this.g()) {
                a.this.r();
                a.this.i();
            } else {
                a.this.e();
                a.this.s();
                bb.a(a.this.f41074g, 0, 0, 0, bb.a(a.this.q(), 1.0f));
            }
        }
    };
    public final h j = new h() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.2
        @Override // com.kwad.sdk.reward.a.h
        public void a() {
            a.this.i();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public long a(long j) {
        return Math.min(com.kwad.sdk.core.response.a.a.p(this.f41072e), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.f41069b.setText(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f41069b.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                a.this.f41069b.setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f41075h) {
            return;
        }
        this.f41075h = true;
        if (f() || g()) {
            bb.a(this.f41074g, bb.a(q(), 40.0f), 0, 0, bb.a(q(), 1.0f));
        }
        this.f41070c.setAlpha(0.0f);
        this.f41070c.setVisibility(0);
        this.f41070c.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f41069b.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.f41069b.setAlpha(1.0f - floatValue);
                a.this.f41070c.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ((g) this).a.f40742b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.reward.a.d dVar = ((g) this).a.f40743c;
        if (dVar != null) {
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        com.kwad.sdk.core.report.a.a(this.f41071d, 41, ((g) this).a.j.getTouchCoords(), ((g) this).a.f40745e);
        ((g) this).a.f40742b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f40747g;
        this.f41071d = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f41072e = j;
        this.f41073f = ((g) this).a.l;
        this.f41069b.setText(String.valueOf(a(com.kwad.sdk.core.response.a.a.b(j))));
        this.f41069b.setVisibility(0);
        this.f41069b.setAlpha(1.0f);
        com.kwad.sdk.reward.d.a().a(this.j);
        ((g) this).a.k.a(this.i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.reward.d.a().b(this.j);
        ((g) this).a.k.b(this.i);
        this.f41070c.setVisibility(8);
        this.f41075h = false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f41069b = (TextView) a(R.id.obfuscated_res_0x7f091167);
        this.f41070c = (ImageView) a(R.id.obfuscated_res_0x7f091066);
        this.f41074g = (ImageView) a(R.id.obfuscated_res_0x7f09117c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f41070c) {
            com.kwad.sdk.core.download.a.a.a(new a.C1956a(view.getContext()).a(this.f41071d).a(this.f41073f).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.a.7
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    a.this.t();
                }
            }));
        }
    }
}
