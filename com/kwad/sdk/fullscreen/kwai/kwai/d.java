package com.kwad.sdk.fullscreen.kwai.kwai;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.g;
/* loaded from: classes7.dex */
public class d extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f40540b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f40541c;

    /* renamed from: e  reason: collision with root package name */
    public TextView f40543e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f40544f;

    /* renamed from: d  reason: collision with root package name */
    public View f40542d = null;

    /* renamed from: g  reason: collision with root package name */
    public e f40545g = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.1
        @Override // com.kwad.sdk.reward.a.e
        public void a(long j, long j2, int i) {
            d.this.e();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40546h = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= com.kwad.sdk.core.config.b.Q()) {
                d.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f40542d.getVisibility() == 0) {
            return;
        }
        this.f40542d.setAlpha(0.0f);
        this.f40542d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.f40542d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.f40542d.setOnClickListener(this);
    }

    private void i() {
        com.kwad.sdk.core.report.a.i(this.f40544f, ((g) this).a.f40745e);
        ((g) this).a.f40742b.b();
        ((g) this).a.k.e();
        ((g) this).a.b();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f40544f = aVar.f40747g;
        aVar.k.a(this.f40546h);
        ((g) this).a.q.add(this.f40545g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.f40546h);
        ((g) this).a.q.remove(this.f40545g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        ImageView imageView;
        int i;
        View view;
        super.c_();
        this.f40543e = (TextView) a(R.id.obfuscated_res_0x7f091064);
        this.f40540b = (ImageView) a(R.id.obfuscated_res_0x7f091138);
        this.f40541c = (TextView) a(R.id.obfuscated_res_0x7f091157);
        if (TextUtils.isEmpty(com.kwad.sdk.core.config.b.T())) {
            if (com.kwad.sdk.core.config.b.P() == 0) {
                imageView = this.f40540b;
                i = R.drawable.obfuscated_res_0x7f080bde;
            } else {
                imageView = this.f40540b;
                i = R.drawable.obfuscated_res_0x7f080cca;
            }
            imageView.setImageResource(i);
            this.f40541c.setVisibility(8);
            view = this.f40540b;
        } else {
            this.f40541c.setText(com.kwad.sdk.core.config.b.T());
            this.f40540b.setVisibility(8);
            view = this.f40541c;
        }
        this.f40542d = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f40542d) {
            i();
        }
    }
}
