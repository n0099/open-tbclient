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
/* loaded from: classes5.dex */
public class d extends g implements View.OnClickListener {
    public ImageView b;
    public TextView c;
    public TextView e;
    public AdTemplate f;
    public View d = null;
    public e g = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.1
        @Override // com.kwad.sdk.reward.a.e
        public void a(long j, long j2, int i) {
            d.this.e();
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d h = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= com.kwad.sdk.core.config.b.Q()) {
                d.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.d.getVisibility() == 0) {
            return;
        }
        this.d.setAlpha(0.0f);
        this.d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.d.setOnClickListener(this);
    }

    private void i() {
        com.kwad.sdk.core.report.a.i(this.f, ((g) this).a.e);
        ((g) this).a.b.b();
        ((g) this).a.k.e();
        ((g) this).a.b();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f = aVar.g;
        aVar.k.a(this.h);
        ((g) this).a.q.add(this.g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.h);
        ((g) this).a.q.remove(this.g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        ImageView imageView;
        int i;
        View view2;
        super.c_();
        this.e = (TextView) a(R.id.obfuscated_res_0x7f09105d);
        this.b = (ImageView) a(R.id.obfuscated_res_0x7f091131);
        this.c = (TextView) a(R.id.obfuscated_res_0x7f091150);
        if (TextUtils.isEmpty(com.kwad.sdk.core.config.b.T())) {
            if (com.kwad.sdk.core.config.b.P() == 0) {
                imageView = this.b;
                i = R.drawable.obfuscated_res_0x7f080bdf;
            } else {
                imageView = this.b;
                i = R.drawable.obfuscated_res_0x7f080ccb;
            }
            imageView.setImageResource(i);
            this.c.setVisibility(8);
            view2 = this.b;
        } else {
            this.c.setText(com.kwad.sdk.core.config.b.T());
            this.b.setVisibility(8);
            view2 = this.c;
        }
        this.d = view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.d) {
            i();
        }
    }
}
