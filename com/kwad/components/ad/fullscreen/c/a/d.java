package com.kwad.components.ad.fullscreen.c.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.core.video.l;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    public ImageView ht;
    public TextView hu;
    public View hv = null;
    public com.kwad.components.ad.reward.e.e hw = new com.kwad.components.ad.reward.e.e() { // from class: com.kwad.components.ad.fullscreen.c.a.d.1
        @Override // com.kwad.components.ad.reward.e.e
        public final void ce() {
            d.this.cd();
        }
    };
    public l gO = new l() { // from class: com.kwad.components.ad.fullscreen.c.a.d.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            d.this.g(j2);
        }
    };

    private void ca() {
        this.qn.oI.a(this.gO);
        this.qn.oT.add(this.hw);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.oT.remove(this.hw);
        this.qn.oI.b(this.gO);
    }

    public final void g(long j) {
        if (j >= com.kwad.sdk.core.response.b.a.al(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate))) {
            cd();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.hv) {
            com.kwad.components.ad.reward.presenter.f.a(this.qn, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd() {
        if (this.hv.getVisibility() == 0) {
            return;
        }
        this.hv.setAlpha(0.0f);
        this.hv.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.hv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.hv.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ht = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914a8);
        this.hu = (TextView) findViewById(R.id.obfuscated_res_0x7f0914e1);
        if (!TextUtils.isEmpty(com.kwad.components.ad.fullscreen.a.b.bN())) {
            this.hu.setText(com.kwad.components.ad.fullscreen.a.b.bN());
            this.ht.setVisibility(8);
            this.hv = this.hu;
            return;
        }
        if (com.kwad.components.ad.fullscreen.a.b.bM() == 0) {
            this.ht.setImageResource(R.drawable.obfuscated_res_0x7f080eb7);
        } else {
            this.ht.setImageResource(R.drawable.obfuscated_res_0x7f080f20);
        }
        this.hu.setVisibility(8);
        this.hv = this.ht;
    }
}
