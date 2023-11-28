package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    public AdInfo mAdInfo;
    public ImageView vk;
    public TextView vl;
    public boolean vm = false;
    public View vn = null;
    public long vo = -1;
    public final l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            if (c.this.vo >= 0) {
                if (j2 > Math.min(Math.min(c.this.vo, com.kwad.sdk.core.response.b.a.ag(c.this.mAdInfo)), j)) {
                    c.this.il();
                }
            }
        }
    };
    public final com.kwad.components.ad.reward.e.e hw = new com.kwad.components.ad.reward.e.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.2
        @Override // com.kwad.components.ad.reward.e.e
        public final void ce() {
            c.a(c.this, true);
            c.this.il();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.oI.b(this.gO);
        this.qn.oT.remove(this.hw);
        this.vn.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.vn) {
            f.a(this.qn, this.vm);
        }
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.vm = true;
        return true;
    }

    private void ca() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        this.qn.oI.a(this.gO);
        this.qn.oT.add(this.hw);
        long af = com.kwad.sdk.core.response.b.a.af(this.mAdInfo);
        this.vo = af;
        if (af == 0) {
            this.vn.setVisibility(0);
        } else {
            this.vn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void il() {
        if (this.vn.getVisibility() == 0) {
            return;
        }
        this.vn.setAlpha(0.0f);
        this.vn.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.vn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vk = (ImageView) findViewById(R.id.obfuscated_res_0x7f091347);
        this.vl = (TextView) findViewById(R.id.obfuscated_res_0x7f0914e0);
        if (!TextUtils.isEmpty(com.kwad.components.ad.reward.a.b.go())) {
            this.vl.setText(com.kwad.components.ad.reward.a.b.go());
            this.vn = this.vl;
        } else {
            if (com.kwad.components.ad.reward.a.b.gn() == 0) {
                this.vk.setImageResource(R.drawable.obfuscated_res_0x7f080eb7);
            } else {
                this.vk.setImageResource(R.drawable.obfuscated_res_0x7f080f20);
            }
            this.vn = this.vk;
        }
        this.vn.setOnClickListener(this);
    }
}
